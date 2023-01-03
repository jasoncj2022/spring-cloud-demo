package com.jason.cj.wrapper;

import com.jason.cj.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiancheng
 * @date 2022/9/3 8:44 PM
 */
@Component
public class HelloWrapper {
    @Autowired
    private FeignService feignService;

    public String sayHello(String content){
        return feignService.hello(content)  + "-wrapper";
    }
}
