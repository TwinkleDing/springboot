package com.example.spring.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author TwinkleDing
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwInterceptor()).addPathPatterns("/api/**");
    }

    @Bean
    public JwInterceptor jwInterceptor() {
        return new JwInterceptor();
    }
}
