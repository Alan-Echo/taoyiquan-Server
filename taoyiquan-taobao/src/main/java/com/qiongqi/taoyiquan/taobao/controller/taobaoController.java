package com.qiongqi.taoyiquan.taobao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 说明
 * @author: ※狗尾巴草
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
