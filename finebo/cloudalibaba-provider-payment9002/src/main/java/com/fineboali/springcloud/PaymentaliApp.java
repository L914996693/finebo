package com.fineboali.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * liuwei
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.fineboali.springcloud.mapper")
public class PaymentaliApp {
    public static void main(String[] args) {
        SpringApplication.run(PaymentaliApp.class,args);
    }
}
