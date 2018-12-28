package com.jufeng.springboot.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/24
 * \* Time: 10:59
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSource.class);
    protected Object determineCurrentLookupKey() {
        logger.info("DataSourceHolder.getDataSource()=>" + DataSourceHolder.getDataSource());
        return DataSourceHolder.getDataSource();
    }
}