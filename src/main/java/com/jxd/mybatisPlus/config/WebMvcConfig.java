package com.jxd.mybatisPlus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ：zhaowentao
 * @date ：Created in 2020/11/3 16:12
 * @description：TODO
 * @modified By：
 * @version: 1.0
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:E:/Users/91245/IdeaProjects/GrowthTrace - 副本/src/main/webapp/upload/");
    }

}
