package com.qiongqi.taoyiquan.user.controller.app;

import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.response.ResponseData;
import com.qiongqi.taoyiquan.user.model.dto.XUserDTO;
import com.qiongqi.taoyiquan.user.service.XUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Description: 【  ApiController控制器 】
 *
 * @author : ※狗尾巴草
 * @version : 1.0.0
 * @email : "m962464oo@gmail.com"
 * @date : 2020-11-28 19:36:52
 */
@RestController
@RequestMapping("v1/api/entity")
public class ApiXUserController {

    @Autowired
    private XUserService xUserService;

    @GetMapping
    public String info(){
        return "user-info";
    }


    /**
     * Description: 【 通过登录账户查询单一数据 】
     *
     * @author : ※狗尾巴草
     * @email : "m962464oo@gmail.com"
     * @date : 2020-11-27 12:05:28
     * @param account
     */
    @GetMapping("getByAccount")
    public ResponseData<XUserDTO> getbyAccount(@RequestParam("account") String account){
        XUserDTO data = xUserService.getbyAccount(account);
        return new ResponseData<XUserDTO>().success(data);
    }




}

