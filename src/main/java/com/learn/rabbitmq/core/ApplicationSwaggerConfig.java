package com.learn.rabbitmq.core;

import org.springframework.context.annotation.Bean;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by PC on 2017/6/8.
 */
@EnableSwagger2
public class ApplicationSwaggerConfig {

    @Bean
    public Docket createDocket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfo apiInfo = new ApiInfo(
                "rabbitmq接口文档",
                "rabbitmq项目相关的接口文档",
                "1.0",
                "http://www.cnblogs.com/xiao-tao/",
                new Contact(
                        "allen",
                        "http://www.cnblogs.com/xiao-tao/",
                        "2393602894@qq.com"),
                "allen",
                "http://www.cnblogs.com/xiao-tao/");
        System.err.println("create docket success");
        return docket.apiInfo(apiInfo);
    }
}
