package com.rayson.duodatasource.model;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Author: rayson
 * Description:
 * Date: 2022/1/1 20:30
 */
@Configuration
public class DruidProperty {
    @Value("${spring.datasource.druid.initial-size}")
    private int initialSize;

    @Value("${spring.datasource.druid.max-active}")
    private int maxActive;

    @Value("${spring.datasource.druid.min-idle}")
    private int minIdle;

    @Value("${spring.datasource.druid.max-wait}")
    private int maxWait;

    @Value("${spring.datasource.druid.validation-query}")
    private String validationQuery;

    @Value("${spring.datasource.druid.test-while-idle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.druid.test-on-borrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.druid.test-on-return}")
    private boolean testOnReturn;

    @Value("${spring.datasource.druid.retryAttemps}")
    private int retryAttemps;

    @Value("${spring.datasource.druid.timeBetweenEviction}")
    private int timeBetweenEviction;

    @Value("${spring.datasource.druid.minEvictionTime}")
    private int minEvictionTime;

    @Value("${spring.datasource.druid.maxEvictableIdleTime}")
    private int maxEvictableIdleTime;


    /**
     * 设置druid连接池的相关参数
     */
    public DruidDataSource setDataSource(DruidDataSource dataSource) {
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxWait(maxWait);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setConnectionErrorRetryAttempts(retryAttemps);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEviction);
        dataSource.setMinEvictableIdleTimeMillis(minEvictionTime);
        dataSource.setMaxEvictableIdleTimeMillis(maxEvictableIdleTime);
        return dataSource;
    }

}
