package com.microservices.elasticsearch.controller;

import com.microservices.elasticsearch.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * elasticsearch控制器
 */
@Slf4j
@RestController
@RequestMapping("/admin/elasticsearch")
public class ElasticsearchController extends BaseController {

    @Autowired
    private LogRepository logRepository;

    /**
     * 查询日志message内容
     *
     * @param message 内容
     * @return
     */
    @GetMapping("search-message")
    public Map<String, Object> findByMessage(String message) {
        log.info("日志搜索:findByMessage[{}]", message);
        return success(logRepository.findByMessage(message));
    }

    /**
     * 根据message和级别查询日志
     *
     * @param message 日志message
     * @param level   级别
     * @return
     */
    @GetMapping("search-message-level")
    public Map<String, Object> findByMessageAndLevel(String message, String level) {
        log.info("日志搜索:findByMessageAndLevel[{}]", message);
        return success(logRepository.findByMessageAndLevel(message, level));
    }

    /**
     * 根据日志级别查询
     *
     * @param level 级别
     * @return
     */
    @GetMapping("search-level")
    public Map<String, Object> findByLevel(String level) {
        log.info("日志搜索:findByLevel[{}]", level);
        return success(logRepository.findByLevel(level));
    }


}
