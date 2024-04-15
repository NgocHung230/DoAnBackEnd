package com.finalproject.dm.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
    @Bean(name = "emailTaskExecutor")
    public ThreadPoolTaskExecutor emailTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Số lượng luồng cố định trong pool
        executor.setMaxPoolSize(10); // Số lượng tối đa của luồng trong pool
        executor.setQueueCapacity(25); // Số lượng nhiệm vụ chờ trong hàng đợi
        executor.setThreadNamePrefix("EmailTask-");
        executor.initialize();
        return executor;
    }
}
