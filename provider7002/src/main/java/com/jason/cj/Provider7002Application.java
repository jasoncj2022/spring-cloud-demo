package com.jason.cj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jiancheng
 * @date 2022/7/7 5:38 PM
 */
@SpringBootApplication
@EnableEurekaClient
public class Provider7002Application {
    public static void main(String args[]){
        SpringApplication.run(Provider7002Application.class,args);
    }

}
