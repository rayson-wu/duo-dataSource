package com.rayson.duodatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.rayson.duodatasource.holder.DataSourceType;
import com.rayson.duodatasource.holder.DynamicDataSource;
import com.rayson.duodatasource.model.DruidProperty;
import com.rayson.duodatasource.util.SpringUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: rayson
 * Description:
 * Date: 2022/1/1 20:52
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    public DataSource masterDataSource(DruidProperty druidProperty) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperty.setDataSource(dataSource);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    // 当enabled=true时
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slave",name = "enabled",havingValue = "true")
    public DataSource slaveDataSource(DruidProperty druidProperty) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperty.setDataSource(dataSource);
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceType.MASTER.name(), masterDataSource);
        setDataSource(targetDataSources,DataSourceType.SLAVE.name(),"slaveDataSource");
        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

    public void setDataSource(Map<Object, Object> targetDataSources,String dbName, String beanName) {
        try {
            DataSource dataSource = SpringUtil.getBean(beanName);
            targetDataSources.put(dbName, dataSource);
        } catch (Exception e) {

        }
    }

}
