package com.jufeng.springboot.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/24
 * \* Time: 10:57
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 可以传入db数据库名称参数，进行saas化的切库
 * \
 */
@Configuration
public class DynamicDataSourceConfig implements EnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfig.class);

    @Autowired
    private ApplicationContext ctx;

    // 默认数据源
    private DataSource defaultDataSource;

    // 属性值
    private PropertyValues dataSourcePropertyValues;

    // 如配置文件中未指定数据源类型，使用该默认值
    private static final Object DATASOURCE_TYPE_DEFAULT = "org.apache.tomcat.jdbc.pool.DataSource";

    private ConversionService conversionService = new DefaultConversionService();

    //公共的properties
    private Map<String, Object> commonConfigs = new HashMap<>();

    //租户id
    private Map<Object, Object> customDataSources = new HashMap<>();

    @Value("${default.db}")
    private String defaultDb;

    @Override
    public void setEnvironment(Environment environment) {
        initCommonConfig(environment);//初始化公共配置
        addDefaultDataSource();
    }

    private void initCommonConfig(Environment environment){
        commonConfigs = new RelaxedPropertyResolver(environment, "dync.datasource").getSubProperties(".");
    }


    /**
     * 动态添加数据源
     * @param db
     */
    //添加数据源，解析不通的配置，然后按照initDataSource 步骤添加其他数据源
    public void addDataSource(String db){
        // 读取主数据源
        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("type", commonConfigs.get("type"));
        dsMap.put("driver-class-name", commonConfigs.get("driver-class-name"));
        dsMap.put("url",commonConfigs.get("url").toString().replace("xxx_","xxx_"+db));
        dsMap.put("username", commonConfigs.get("username"));
        dsMap.put("password", commonConfigs.get("password"));
        DataSource dataSource = buildDataSource(dsMap);
        DataSourceHolder.dataSourceIds.add(db);
        dataBinder(dataSource);
        customDataSources.put(db,dataSource);
        DynamicDataSource dynamicDataSource =ctx.getBean("dataSource", DynamicDataSource.class);
        dynamicDataSource.setTargetDataSources(customDataSources);
        dynamicDataSource.afterPropertiesSet();

    }

    /**
     * 第一次初始化要有一个默认的数据源
     */
    public void addDefaultDataSource(){
        // 读取主数据源
        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("type", commonConfigs.get("type"));
        dsMap.put("driver-class-name", commonConfigs.get("driver-class-name"));
        dsMap.put("url",commonConfigs.get("url").toString().replace("xxx_",defaultDb));
        dsMap.put("username", commonConfigs.get("username"));
        dsMap.put("password", commonConfigs.get("password"));
        defaultDataSource = buildDataSource(dsMap);
        DataSourceHolder.dataSourceIds.add("dataSource");
        dataBinder(defaultDataSource);
    }


    private void dataBinder(DataSource dataSource){
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreNestedProperties(false);//false
        dataBinder.setIgnoreInvalidFields(false);//false
        dataBinder.setIgnoreUnknownFields(true);//true
        if(dataSourcePropertyValues == null){
            Map<String, Object> values = new HashMap<>(commonConfigs);
            // 排除已经设置的属性
            values.remove("type");
            values.remove("driver-class-name");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            dataSourcePropertyValues = new MutablePropertyValues(values);
        }
        dataBinder.bind(dataSourcePropertyValues);
    }




    public DataSource buildDataSource(Map<String, Object> dsMap) {
        try {
            Object type = dsMap.get("type");
            if (type == null)
                type = DATASOURCE_TYPE_DEFAULT;// 默认DataSource

            Class<? extends DataSource> dataSourceType;
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);

            String driverClassName = dsMap.get("driver-class-name").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();

            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url)
                    .username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean(name = "dataSource")
    public DynamicDataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);
        dynamicDataSource.setTargetDataSources(customDataSources);
        return dynamicDataSource;
    }

}