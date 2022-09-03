package com.example.tsinghuareggie.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * 设置资源映射
     * @param registry
     * 前面表示的是浏览器访问的请求
     * 后面表示的是要把请求映射到哪里去
    */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("O.o Start static resource mapping! o.O");
        registry.addResourceHandler("/backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }

}
