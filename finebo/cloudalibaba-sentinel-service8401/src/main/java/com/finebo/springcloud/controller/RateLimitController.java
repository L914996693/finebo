package com.finebo.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.finebo.springcloud.myhandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RateLimitController {

    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public String byResource(){
        return "ok";
    }

    public String handleException(BlockException exception){
        return ""+exception+"noOk";
    }

    @GetMapping(value = "/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public String byurl(){
        return "urlok";
    }

    @GetMapping(value = "/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException1")
    public String CustomerBlockHandler(){
        return "urlok";
    }
}
