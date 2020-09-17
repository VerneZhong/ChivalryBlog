package com.chivalry.sql.engine.presto.function;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:53:39
 */
public class EngineUtils {

    private static LoadingCache<String, SelectEngine> enginePools;

    static {
        enginePools = CacheBuilder.newBuilder().maximumSize(10000).expireAfterAccess(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, SelectEngine>() {
                    @Override
                    public SelectEngine load(String sql) throws Exception {
                        return new SelectEngine(sql);
                    }
                });
    }

    private static List<SelectEngine> getEigineList(String topic) {
        List<SelectEngine> matchList = null;
        return matchList;
    }

    public static void process(String topic, String payload) {
        List<SelectEngine> eigineList = getEigineList(topic);
        for (SelectEngine engine : eigineList) {
            engine.select(topic, payload);
        }
    }
}
