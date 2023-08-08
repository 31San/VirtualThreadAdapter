package org.eu.miraikan.configuration;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Configuration;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


@Configuration
public class ServletContainerConfiguration implements TomcatConnectorCustomizer {

    //only work for default embedded Tomcat
    @Override
    public void customize(Connector connector) {
        Executor executor = Executors.newVirtualThreadPerTaskExecutor();
        connector.getProtocolHandler().setExecutor(executor);
    }
}
