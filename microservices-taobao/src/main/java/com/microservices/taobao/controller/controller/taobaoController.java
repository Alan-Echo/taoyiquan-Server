package com.microservices.taobao.controller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 说明
 * 
 * @date: 2020-11-28 17:29
 **/
@RestController
@RequestMapping("v1/info")
public class taobaoController {

    @GetMapping
    public String info(){
        return "taobao-info";
    }




}
