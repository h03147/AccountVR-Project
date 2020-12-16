package com.example.jsondowntest2.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.http.HttpStatus;

//@CrossOrigin(
//        origins = {"http://localhost"}, // 允许哪些域名来跨域来请求当前资源,可以使用通配符 *
//        allowedHeaders = {"foo"},		// 允许客户端请求携带的请求头
//        exposedHeaders = {"foo"},		// 允许客户端访问的响应头
//        methods = {RequestMethod.GET},	// 允许客户端跨域请求的请求方式
//        allowCredentials = "true",		// 允许客户端请求提交cookie
//        maxAge = 1600					// 预检测缓存时间
//)


// 无拦截器用带有继承的类名
//@Configuration
//public class CrosConfig implements WebMvcConfigurer {

// 有拦截器 请删除掉继承与实现类
@Configuration
public class CrosConfig {
    // 无拦截器时可以用addCorsMappings，有拦截器时会失效，因为调用优先级时拦截器。
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")    // 需要跨域的uri
//                .allowedOrigins("*")
//                .allowedHeaders("*")
////                .allowedMethods("GET", "PUT", "POST", "DELETE", "HEAD", "OPTIONS")
//                .allowedMethods("GET", "PUT", "POST", "DELETE")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }

    // 有拦截器时使用此方法 这样在拦截器前就会优先调用跨域方法
    private CorsConfiguration corsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setMaxAge(3600L);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig());
        return new CorsFilter(source);
    }

    // 无拦截器时使用 有拦截器删掉Override
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }



}
