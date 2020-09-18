package com.chivalry.sql.engine.presto.function;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.facebook.presto.sql.parser.SqlParser;
import com.facebook.presto.sql.tree.*;

import java.util.Iterator;
import java.util.List;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:04:36
 */
public class SelectEngine extends AstVisitor<String, JSONContext> {
    private static SqlParser parser = new SqlParser();

    private Statement statement;
    private String sql;

    public SelectEngine(String sql) {
        this.sql = sql;
        statement = parser.createStatement(sql);
    }

    public String sql(){
        return sql;
    }

    public String select(String topic, String jsonarr) {
        return this.process(statement, new JSONContext(topic, jsonarr));
    }

    public static String select(String sql, String topic, String jsonarr) {
        SelectEngine engine = new SelectEngine(sql);
        return engine.process(engine.statement, new JSONContext(topic, jsonarr));
    }

    @Override
    protected String visitQuerySpecification(QuerySpecification node, JSONContext context) {
        List<Object> result = context.getJSONArray();// = new ArrayList<JSONObject>();
        if( node.getWhere().isPresent() ){
            // where
            Iterator<Object> index = result.iterator();
            for( ; index.hasNext(); ){
                Object row = index.next();
                if( !SelectVisitor.where(node.getWhere().get(), context.setRowJSON((JSONObject)row)) ){
                    index.remove();
                }
            }
        }

        if( node.getOrderBy().isPresent() ){
            result.sort((left, right) -> {
                int compareRet = 0;
                for (SortItem sort : node.getOrderBy().get().getSortItems()) {
                    Object lvalue = SelectVisitor.valueOf(sort.getSortKey(), context.setRowJSON((JSONObject) left));
                    Object rvalue = SelectVisitor.valueOf(sort.getSortKey(), context.setRowJSON((JSONObject) right));
                    if (lvalue instanceof Number) {
                        Double l = ((Number) lvalue).doubleValue();
                        Double r = ((Number) rvalue).doubleValue();
                        switch (sort.getOrdering()) {
                            case DESCENDING:
                                compareRet = r.compareTo(l);
                                break;
                            case ASCENDING:
                            default:
                                compareRet = l.compareTo(r);
                        }
                    } else if (lvalue instanceof String) {
                        String l = (String) lvalue;
                        String r = (String) rvalue;
                        switch (sort.getOrdering()) {
                            case DESCENDING:
                                compareRet = r.compareTo(l);
                                break;
                            case ASCENDING:
                            default:
                                compareRet = l.compareTo(r);
                        }
                    }
                }
                return compareRet;
            });
        }

        if ( !(node.getSelect().getSelectItems().size() == 1
                && node.getSelect().getSelectItems().get(0) instanceof AllColumns) ){
            result = new JSONArray();
            for (Object obj : context.getJSONArray()) {
                JSONObject selRet = new JSONObject();
                JSONObject row = (JSONObject) obj;
                for (SelectItem item : node.getSelect().getSelectItems()) {
                    if (item instanceof AllColumns) {
                        selRet.putAll(row);
                    } else {
                        SingleColumn scolumn = (SingleColumn) item;
                        selRet.put(
                                scolumn.getAlias().isPresent() ? scolumn.getAlias().get().getValue()
                                        : scolumn.getExpression().toString(),
                                SelectVisitor.valueOf(scolumn.getExpression(), context.setRowJSON(row)) );
                    }
                }
                result.add(selRet);
                // 已经有Function处理了所有JSONArray数据。不再继续执行
                if (context.isDone())
                    break;
            }
        }

        if(node.getLimit().isPresent()){
            String limit = node.getLimit().get();
            int offset = 0;
            int rows   = 1;
            if(limit.contains(",")){
                String[] limits = limit.split(",");
                offset = Integer.valueOf(limits[0]);
                rows = Integer.valueOf(limits[1]);
            }else{
                rows = Integer.valueOf(limit);
            }
            result = result.subList(offset, rows);
        }

        return JSON.toJSONString(result, SerializerFeature.WriteMapNullValue);
    }

    @Override
    protected String visitQuery(Query node, JSONContext context) {
        return this.process(node.getQueryBody(), context);
    }
}
