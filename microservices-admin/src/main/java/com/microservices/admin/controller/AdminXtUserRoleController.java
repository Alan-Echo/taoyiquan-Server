package com.microservices.admin.controller;

import com.microservices.common.response.ResponseData;
import com.microservices.admin.model.dto.XtRoleDTO;
import com.microservices.admin.service.XtUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Description: 【  后台Controller控制器 】
 *
 * 
 * 
 * @date : 2020-11-27 12:05:27
 * @version : 1.0.0
 */
@RestController
@RequestMapping("v1/admin/user_role")
public class AdminXtUserRoleController {

    @Autowired
    private XtUserRoleService xtUserRoleService;

    // ==================== 查询 ====================

    /**
     * Description: 【 通过userId查询数据 】
     *
     * 
     * 
     * @date : 2020-11-27 12:05:27
     *
     * @param userId
     */
    @GetMapping("getByUserId")
    public ResponseData<List<XtRoleDTO>> getByUserId(@RequestParam("userId") Long userId){
        List<XtRoleDTO> data = xtUserRoleService.getByUserId(userId);
        return new ResponseData<List<XtRoleDTO>>().success(data);
    }


    // ==================== 其他 ====================



}
