package com.rayson.duodatasource.holder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: rayson
 * Description:
 * Date: 2022/1/1 20:14
 */
public class DataSourceHolder {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceHolder.class);
    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源的变量
     * @param dsName 数据源名称
     */
    public static void setDataSource(String dsName) {
        logger.info("切换数据源: {}", dsName);
        HOLDER.set(dsName);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSource() {
        return HOLDER.get();
    }

    /**
     * 移除当前线程的数据源变量
     */
    public static void remove() {
        logger.info("移除数据源: {}",getDataSource());
        HOLDER.remove();
    }

}
