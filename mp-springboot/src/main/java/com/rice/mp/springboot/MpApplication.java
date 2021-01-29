package com.rice.mp.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wgz
 * create date  2021/1/30 1:29
 */
@SpringBootApplication
@MapperScan("com.rice.mp.springboot.mapper")
public class MpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MpApplication.class, args);
    }
}
