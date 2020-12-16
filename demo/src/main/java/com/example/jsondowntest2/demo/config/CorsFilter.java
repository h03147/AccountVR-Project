//package com.example.jsondowntest2.demo.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class CorsFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) {
//        // TODO Auto-generated method stub
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//                         FilterChain chain) throws IOException, ServletException {
//        if (request instanceof HttpServletRequest) {
//            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//            httpServletResponse.setHeader("Access-Control-Allow-Methods",
//                    "POST, GET, PUT, DELETE");
//            httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
//            httpServletResponse.setHeader("Access-Control-Allow-Headers",
//                    "Content-Type, x-requested-with, X-Custom-Header, Authorization");
//        }
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void destroy() {
//        // TODO Auto-generated method stub
//    }
//
//    @Bean
//    public FilterRegistrationBean corsFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new CorsFilter());
//        registration.addUrlPatterns("/*");
//        registration.setName("corsFilter");
//        //将其注册在其他过滤器的前面
//        registration.setOrder(0);
//        return registration;
//    }
//}
