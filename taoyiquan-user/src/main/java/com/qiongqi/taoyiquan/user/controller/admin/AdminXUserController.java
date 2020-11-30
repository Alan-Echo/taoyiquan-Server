package com.qiongqi.taoyiquan.user.controller.admin;


import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.user.model.dto.XUserDTO;
import com.qiongqi.taoyiquan.user.service.XUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * Description: 【  后台Controller控制器 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
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
