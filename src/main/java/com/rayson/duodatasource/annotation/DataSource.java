package com.rayson.duodatasource.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
// 用在类或者方法上,方法优先级大于类
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface DataSource {
    // 数据源的名称
    String value() default "master";
}
