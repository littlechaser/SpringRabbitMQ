package com.learn.rabbitmq.core;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by PC on 2017/6/9.
 */
public class StartJetty {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext wac = new WebAppContext();
        wac.setContextPath("/SpringRabbitMQ");
        wac.setWar("D:\\Develop\\workspace_sts\\SpringRabbitMQ\\target\\SpringRabbitMQ.war");
        server.setHandler(wac);
        server.start();
        server.join();
    }
}
