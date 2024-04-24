package com.finalproject.dm.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);
        registry.addMapping("/payment-callback")
        .allowedOrigins("172.21.2.109:3000") // Thay đổi thành địa chỉ IP hoặc tên miền của frontend
        .allowedMethods("GET") // Hoặc có thể thay đổi để cho phép các phương thức khác
        .allowedHeaders("*");
    }


}
