package com.api.tiktokapi.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<LoginFilter> filterRegistrationBean() {
        FilterRegistrationBean<LoginFilter> filterRegistrationBean = new FilterRegistrationBean<>(new LoginFilter());
//        filterRegistrationBean.addUrlPatterns("/api/*");

        return filterRegistrationBean;
    }
}
