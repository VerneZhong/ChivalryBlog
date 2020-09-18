package com.chivalry.sql.engine.presto.function;

import com.google.common.reflect.ClassPath;
import com.google.common.reflect.ClassPath.ClassInfo;

import java.lang.reflect.Method;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:20:35
 */
public class SqlFunctionProxy {
    private static Map<String, Function> sqlFunctionMap = new ConcurrentHashMap<>(64);

    static {
        try {
            Set<ClassInfo> classes = ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClassesRecursive("com.chivalry.sql.engine");
            classes.forEach(classInfo -> {
                Method[] methods = classInfo.load().getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(SqlFunction.class)) {
                        if (Modifier.isStatic(method.getModifiers())) {
                            SqlFunction sqlMeta = method.getAnnotation(SqlFunction.class);
                            sqlFunctionMap.put(sqlMeta.name(), Function.of(sqlMeta.param(), method));
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Function getFunction(String name) {
        return sqlFunctionMap.get(name);
    }
}
