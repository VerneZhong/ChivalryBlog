package com.chivalry.sql.engine.presto.function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author Mr.zxb
 * @date 2020-09-17 22:21:31
 */
public class Function {
    private static Logger LOG = LoggerFactory.getLogger(Function.class);
    private ParameterFrom paramFrom;
    private Method method;

    public static Function of(ParameterFrom paramFrom, Method method) {
        return new Function(paramFrom, method);
    }

    private Function(ParameterFrom paramFrom, Method method) {
        this.paramFrom = paramFrom;
        this.method = method;
    }

    public ParameterFrom getParamFrom() {
        return paramFrom;
    }

    // 判断本Function是否处理了所有JSONArray数据
    public boolean isProcessAll() {
        switch (paramFrom) {
            case RAWJSON:
                return true;
            default:
                return false;
        }
    }

    public Object invoke(Object[] args) {
        try {
            return method.invoke(null, args);
        } catch (Throwable thx) {
            thx.printStackTrace();
        }
        return null;
    }

}
