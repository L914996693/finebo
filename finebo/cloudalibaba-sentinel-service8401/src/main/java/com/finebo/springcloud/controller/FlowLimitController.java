package com.finebo.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping(value = "testA")
    public String testA(){
        log.info(Thread.currentThread().getName()+"\t"+"....testA");
        return "testA";
    }

    @GetMapping(value = "testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"\t"+"....testB");
        return "testB";
    }

    @GetMapping(value = "testD")
    public String testD(){
       /* try {降级RT
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        int age = 10/0;//异常比例
        log.info("testD测试RT");
        return "testD";
    }

    @GetMapping(value = "testE")
    public String testE(){
        int age = 10/0;
        log.info("testE测试异常数量");
        return "testD";
    }

    @GetMapping(value = "testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        log.info("testHotKey测试热点");
        return "testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey----";//sentinel系统默认提示:Blocked by Sentinel (flow limiting)
    }
}
