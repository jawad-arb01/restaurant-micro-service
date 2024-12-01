package com.arbahi.repasservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RepasServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepasServiceApplication.class, args);
    }

}
