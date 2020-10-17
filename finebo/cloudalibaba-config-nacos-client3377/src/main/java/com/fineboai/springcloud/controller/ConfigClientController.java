package com.fineboai.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope//支持Nacos的动态刷新功能
@RequestMapping("/config")
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("info")
    public String getConfigInfo(){
        return configInfo;
    }
}
