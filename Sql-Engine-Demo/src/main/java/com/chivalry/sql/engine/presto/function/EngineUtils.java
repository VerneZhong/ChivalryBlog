package com.chivalry.sql.engine.presto.function;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:53:39
 */
public class EngineUtils {

    private static LoadingCache<String, SelectEngine> enginePools;

    static {
        enginePools = CacheBuilder.newBuilder().maximumSize(10000)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, SelectEngine>() {
                    @Override
                    public SelectEngine load(String sql) throws Exception {
                        return new SelectEngine(sql);
                    }
                });
    }

    private static List<SelectEngine> getEngineList(String topic) {
        List<SelectEngine> matchList = null;
        try {
            // Redis 根据topic加载sql列表
            String logSql = SqlConstants.printAll;
            matchList = Lists.newArrayList(enginePools.get(logSql));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matchList;
    }

    public static void process(String topic, String payload) {
        List<SelectEngine> engineList = getEngineList(topic);
        for (SelectEngine engine : engineList) {
            engine.select(topic, payload);
        }
    }
}
