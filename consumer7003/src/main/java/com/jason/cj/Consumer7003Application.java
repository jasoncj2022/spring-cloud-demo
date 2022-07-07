package com.jason.cj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jiancheng
 * @date 2022/7/7 10:43 PM
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Consumer7003Application {
    public static void main(String args[]){
        SpringApplication.run(Consumer7003Application.class,args);
    }

}
