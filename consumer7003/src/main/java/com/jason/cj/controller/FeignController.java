package com.jason.cj.controller;

import com.jason.cj.service.FeignService;
import com.json.cj.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiancheng
 * @date 2022/7/7 10:55 PM
 */
@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/consumer")
    public String hello(String content){
        User user = new User();
        user.setName("cheng");
        user.setAge(18);
        return feignService.hello(content) + feignService.helloJson(user);
    }
}
