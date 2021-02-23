package com.liuyk.asimple.config;

import com.liuyk.asimple.web.inteceptor.AccessInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liuyk
 */
@Component
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AccessInterceptor accessInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessInterceptor).addPathPatterns("/**").excludePathPatterns("/");
    }
}
