package com.microservices.user.controller.admin;


import org.springframework.web.bind.annotation.*;

/**
 * Description: 【  后台Controller控制器 】
 *
 * 
 * @version : 1.0.0
 * 
 * @date : 2020-11-28 19:36:52
 */
@RestController
@RequestMapping("v1/admin/entity")
public class AdminXUserController {


    // ==================== 查询 ====================

    @GetMapping("info")
    public String info(){

        return "user-info";
    }



}
