package com.jason.cj.controller;

import com.json.cj.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author jiancheng
 * @date 2022/7/7 5:45 PM
 */
@RestController
public class FeignController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/provider")
    public String hello(String content){
        return "call port2222" + port + ", content=" + content + ",";
    }

    @PostMapping("/provider-json")
    public String helloJson(@RequestBody User user){
        return user.toString();
    }
}
