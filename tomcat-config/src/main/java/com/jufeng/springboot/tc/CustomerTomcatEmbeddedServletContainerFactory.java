package com.jufeng.springboot.tc;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.AbstractProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: zhaojun(JUENG)
 * \* Date: 2018/12/28
 * \* Time: 10:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 修改内嵌tomcat 一些server 的配置参数，因为application.properties 内不能配置
 * \
 */
@Component()
public class CustomerTomcatEmbeddedServletContainerFactory extends
        TomcatEmbeddedServletContainerFactory {

    @Value("${tomcat.max-connections}")
    private int maxConnections;

    @Value("${tomcat.accept-count}")
    private int acceptCount;

    public CustomerTomcatEmbeddedServletContainerFactory() {
        super();
    }
    public CustomerTomcatEmbeddedServletContainerFactory(int port) {
        super(port);
    }
    public CustomerTomcatEmbeddedServletContainerFactory(String contextPath, int port) {
        super(contextPath, port);
    }
    @Override
    public EmbeddedServletContainer getEmbeddedServletContainer(
            ServletContextInitializer... initializers) {
        Tomcat tomcat = new Tomcat();
        File baseDir = createTempDir("tomcat");
        tomcat.setBaseDir(baseDir.getAbsolutePath());
        Connector connector = new Connector("org.apache.coyote.http11.Http11Nio2Protocol");//把之前的nio改成了nio2
        tomcat.getService().addConnector(connector);
        customizeConnector(connector);
        customizePrivateConnector(connector);
        tomcat.setConnector(connector);
        tomcat.getHost().setAutoDeploy(false);
        tomcat.getEngine().setBackgroundProcessorDelay(-1);
        prepareContext(tomcat.getHost(), initializers);
        return getTomcatEmbeddedServletContainer(tomcat);
    }
    protected void customizePrivateConnector(Connector connector) {
        if (connector.getProtocolHandler() instanceof AbstractProtocol) {
            customizePrivateProtocol((AbstractProtocol<?>) connector.getProtocolHandler());
        }
    }
    private void customizePrivateProtocol(AbstractProtocol<?> protocol) {
        protocol.setMaxConnections(maxConnections);
        //在这里随便写自定义的配置
        protocol.setAcceptCount(acceptCount);
    }
}