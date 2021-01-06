package com.finebo.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String handleException1(BlockException exception){
        return "444--1";
    }
    public static String handleException2(BlockException exception){
        return "444--2";
    }
}
