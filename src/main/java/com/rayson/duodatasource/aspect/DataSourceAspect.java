package com.rayson.duodatasource.aspect;

import com.rayson.duodatasource.annotation.DataSource;
import com.rayson.duodatasource.holder.DataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * Author: rayson
 * Description: 动态数据源切面类
 * Date: 2022/1/1 19:55
 */
@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(com.rayson.duodatasource.annotation.DataSource)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        DataSource dataSource = getDataSource(joinPoint);
        if (dataSource != null) {
            // 设置数据源
            DataSourceHolder.setDataSource(dataSource.value());
        }

        try {
            return joinPoint.proceed();
        } finally {
            // 移除数据源
            DataSourceHolder.remove();
        }
    }

    /**
     * 获取数据源
     */
    private DataSource getDataSource(ProceedingJoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 优先获取方法上的注解
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (dataSource != null) {
            return dataSource;
        }

        // 获取类上面的注解
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }
}
