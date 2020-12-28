package com.jxfh.auciton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(basePackages = {"com.jxfh.auciton.dao"})
@EnableTransactionManagement
@SpringBootApplication
public class AucitonApplication {

    public static void main(String[] args) {
        SpringApplication.run(AucitonApplication.class, args);
    }

}
