package com.fineboali.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/payment")
public class Paycontroller {

    @Value("${server.port}")
    private String serverport;

    @GetMapping(value = "nacos")
    public String getPayment(){//@RequestParam("id") Integer id +id
        return "nacos registry,serverPort: "+serverport+"\t id:9001";
    }

    @GetMapping(value = "paycount")
    public String paycount(){
        return "1";
    }
}
