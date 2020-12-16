package com.example.jsondowntest2.demo.config;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


// 配置过滤类（拦截器）拦截不允许的请求方法
@Configuration
public class TomcatConfig {

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.addContextCustomizers(new TomcatContextCustomizer() {
            @Override
            public void customize(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                SecurityCollection collection = new SecurityCollection();
                // 要拦截的http请求方法
//                collection.addMethod("GET");
//                collection.addMethod("POST");
//                collection.addMethod("PUT");
//                collection.addMethod("DELETE");
                collection.addMethod("HEAD");
//                collection.addMethod("OPTIONS");
                collection.addMethod("TRACE");
                //url匹配表达式
                collection.addPattern("/*");
                constraint.addCollection(collection);
                constraint.setAuthConstraint(true);
                context.addConstraint(constraint);

                //设置使用httpOnly
                context.setUseHttpOnly(true);
            }
        });

        return tomcatServletWebServerFactory;
    }

}
