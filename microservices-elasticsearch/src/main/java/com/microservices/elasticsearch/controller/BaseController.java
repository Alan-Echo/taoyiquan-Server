package com.microservices.elasticsearch.controller;

import com.microservices.elasticsearch.entity.LogEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    protected Map<String, Object> success(List<LogEntity> list){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("message", "success");
        map.put("data", list);
        return map;
    }

}
