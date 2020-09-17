package com.chivalry.sql.engine.presto.function;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:05:14
 */
public class JSONContext {
    private JSONObject rowData;
    private JSONArray jsondb;
    private String    jsonData;
    private String    topic;
    private boolean isDone;

    public String getTopic(){
        return topic;
    }

    public JSONContext(String topic, String data){
        this.topic = topic;
        jsonData = data;
        //jsondb = JSON.parseArray(data);
    }
    public JSONContext setRowJSON(JSONObject row) {
        rowData = row;
        return this;
    }
    public String getRawJSON(){
        return jsonData;
    }
    public JSONObject getRowJSON(){
        return rowData;
    }
    public JSONArray getJSONArray(){
        if(jsondb == null){
            if(jsonData.startsWith("{")) {
                jsondb = JSON.parseArray('['+jsonData+']');
            }else {
                jsondb = JSON.parseArray(jsonData);
            }
        }
        return jsondb;
    }

    public void done(){
        isDone = true;
    }

    public boolean isDone(){
        return isDone;
    }
}
