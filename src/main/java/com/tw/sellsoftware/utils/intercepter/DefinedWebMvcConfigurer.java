package com.tw.sellsoftware.utils.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefinedWebMvcConfigurer implements WebMvcConfigurer {

    private final LoginInterceptor loginInterceptor;

    public DefinedWebMvcConfigurer(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/*/*/**").excludePathPatterns("/login/userLogin", "/register/userRegister");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
