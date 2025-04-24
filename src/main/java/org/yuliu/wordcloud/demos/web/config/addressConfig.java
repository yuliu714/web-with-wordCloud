package org.yuliu.wordcloud.demos.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class addressConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 浏览器访问路径前缀（与实际图片路径对应）
        registry.addResourceHandler("/python/wordCloud/Images/**")
                // 本地文件实际路径（精确到图片所在文件夹）
                .addResourceLocations("file:./python/wordCloud/Images/");
    }
}