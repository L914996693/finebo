package com.fineboali.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/order")
@PropertySource(value = "classpath:address.properties")
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url-nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "ordernacos")
    public String paymentInfo(){//@RequestParam("id") Integer id
        System.out.println(serverURL+"/payment/nacos");
        return restTemplate.getForObject(serverURL+"/payment/nacos",String.class);//?id="+id
    }

}
