package com.jufeng.springboot.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/29
 * \* Time: 9:54
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \application.properties 绑定对象属性
 *  @ConditionOnClass表明该@Configuration仅仅在一定条件下才会被加载，这里的条件是Mongo.class位于类路径上
 *
 *  @EnableConfigurationProperties将Spring Boot的配置文件（application.properties）中的spring.data.mongodb.*属性映射为MongoProperties并注入到MongoAutoConfiguration中。
 *
 *  @ConditionalOnMissingBean说明Spring Boot仅仅在当前上下文中不存在Mongo对象时，才会实例化一个Bean。这个逻辑也体现了Spring Boot的另外一个特性——自定义的Bean优先于框架的默认配置，我们如果显式的在业务代码中定义了一个Mongo对象，那么Spring Boot就不再创建。
 */

@Configuration
@ConditionalOnClass(Mongo.class)
@EnableConfigurationProperties(MongoProperties.class)
public class MongoAutoConfiguration {
    @Autowired
    private MongoProperties properties;
}