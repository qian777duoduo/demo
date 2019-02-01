package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianduoduo
 * @date 2019/2/1  11:08
 */
@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String test(){
        return "ok";
    }
}
