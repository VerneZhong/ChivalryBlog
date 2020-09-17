package com.chivalry.sql.engine.presto.function;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SqlFunction 注解
 * @author Mr.zxb
 * @date 2020-09-17 21:58:02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlFunction {
    String name();

    ParameterFrom param();
}
