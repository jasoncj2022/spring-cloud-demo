package com.jason.cj.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jiancheng
 * @date 2022/7/8 11:00 AM
 */
@RestControllerAdvice
public class GlobalControllerException {
    @ExceptionHandler(Exception.class)
    public String handle(Exception e, HttpServletRequest httpServletRequest){
        return "catch global controller exception" + e.getMessage();
    }
}
