package com.microservices.user.controller.app;

import com.microservices.common.response.ResponseData;
import com.microservices.user.model.dto.XUserDTO;
import com.microservices.user.service.XUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Description: 【  ApiController控制器 】
 *
 * 
 * @version : 1.0.0
 * 
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
     * 
     * 
     * @date : 2020-11-27 12:05:28
     * @param account
     */
    @GetMapping("getByAccount")
    public ResponseData<XUserDTO> getbyAccount(@RequestParam("account") String account){
        XUserDTO data = xUserService.getbyAccount(account);
        return new ResponseData<XUserDTO>().success(data);
    }




}

