package com.fineboali.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "nacos-provider/cloudalibaba-payment-service/payment")
public interface PaymentFeignService {

    @GetMapping(value = "paycount")
    public String paycount();

}
