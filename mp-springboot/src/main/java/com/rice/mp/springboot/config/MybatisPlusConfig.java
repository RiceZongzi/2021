package com.rice.mp.springboot.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wgz
 * create date  2021/2/1 15:27
 */
@Configuration
@MapperScan("com.rice.mp.springboot.mapper")
public class MybatisPlusConfig {

    @Bean
    // 配置分页
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
