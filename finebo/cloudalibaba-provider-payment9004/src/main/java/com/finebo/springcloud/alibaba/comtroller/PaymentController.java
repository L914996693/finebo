package com.finebo.springcloud.alibaba.comtroller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/paymentSQL/{id}")
    public String pay(@PathVariable("id") Long id){
        System.out.println("id--->"+id);
        return "pay----------"+serverPort;
    }
}
