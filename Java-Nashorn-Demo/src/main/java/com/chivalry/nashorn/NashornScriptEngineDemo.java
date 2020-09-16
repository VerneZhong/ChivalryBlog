package com.chivalry.nashorn;

import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 模拟Full GC 场景
 * metaspace 达到阈值时，会触发Full GC
 * VM args:
 *          -Xmx128m -Xmn64m -XX:MetaspaceSize=64m
 *          -XX:MaxMetaspaceSize=128m -XX:+PrintGCDetails
 * 监控CG：jstat -gcutil pid 250 20
 * @author Mr.zxb
 * @date 2020-08-17 14:07
 */
public class NashornScriptEngineDemo {

    @Deprecated
    public static Object execute(Reader script, String payload) throws Exception{
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine= engineManager.getEngineByName("nashorn");
        engine.eval(script);
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction("execute", payload);
    }

    private final static Map<String, NashornScriptEngine> cache = new ConcurrentHashMap<>();

    public static final String PATH = "/Users/zhongxuebin/IdeaProjects/ChivalryBlog/Java-Nashorn-Demo/src/main/resources/hello.js";

    public final static AtomicLong monitor = new AtomicLong(0);

    public static Object execute(String nashorn) throws ScriptException, NoSuchMethodException {
        return cache.computeIfAbsent(nashorn, key -> {
            NashornScriptEngine scriptEngine = null;
            try {
                ScriptEngineManager engineManager = new ScriptEngineManager();
                scriptEngine = (NashornScriptEngine) engineManager.getEngineByName("nashorn");
                FileReader fileReader = new FileReader(PATH);
                scriptEngine.eval(fileReader);
            } catch (ScriptException | FileNotFoundException e) {
                e.printStackTrace();
            }
            return scriptEngine;
        }).invokeFunction("execute", "Hello Nashorn.");
    }

    public static void main(String[] args) throws Exception {
        int count = 10_000_000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            monitor.incrementAndGet();
            NashornScriptEngineDemo.execute("nashorn");
//            FileReader fileReader = new FileReader(PATH);
//            NashornScriptEngineDemo.execute(fileReader, "Hello Nashorn.");
        }
        System.out.println(monitor.get() + "次，共 cost: " + (System.currentTimeMillis() - start) + " ms");
        System.in.read();
    }
}
