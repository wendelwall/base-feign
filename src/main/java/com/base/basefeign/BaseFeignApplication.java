package com.base.basefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BaseFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseFeignApplication.class, args);
    }

}
