package com.jufeng.springboot.environment;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/10/29
 * \* Time: 9:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoProperties {
    private String host;

    private int port ;

    private String uri = "mongodb://localhost/test";

    private String database;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}