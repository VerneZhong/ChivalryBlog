package com.chivalry.sql.engine.presto.function;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:21:31
 */
public class Function {
    private ParameterFrom parameterFrom;
    private Method method;

    private Function(ParameterFrom parameterFrom, Method method) {
        this.parameterFrom = parameterFrom;
        this.method = method;
    }

    public static Function of(ParameterFrom parameterFrom, Method method) {
        return new Function(parameterFrom, method);
    }

    public boolean isProcessAll() {
        switch (parameterFrom) {
            case RAWJSON:
                return true;
            default:
                return false;
        }
    }

    public Object invoke(JSONContext context, Object... args) {
        try {
            switch (parameterFrom) {
                case NONE:
                    return method.invoke(null, null);
                case RAWJSON:
                    return method.invoke(null, context.getRawJSON());
                default:
                    return null;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object[] arrayAppend(Object[] original, Object object) {
        original = Arrays.copyOf(original, original.length + 1);
        original[original.length - 1] = object;
        return original;
    }

}
