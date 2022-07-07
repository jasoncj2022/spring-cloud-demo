package com.jason.cj.service;

import com.json.cj.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义远程调用的接口
 * @author jiancheng
 * @date 2022/7/7 10:56 PM
 */
@Component
@FeignClient(value = "provider7002")
public interface FeignService {
    //使用feign代理调用远程http接口
    @GetMapping("/provider")
    public String hello(@RequestParam("content") String content);  //需要带RequestParam指定参数，如果是对象就使用requestBody


    @PostMapping("/provider-json")
    String helloJson(@RequestBody User user);  //注意：requestbody要使用Post方法
}
