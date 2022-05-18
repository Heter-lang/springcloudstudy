package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result= paymentService.create(payment);
        if (result>0){
            return new CommonResult(200,"插入成功",result);
        }else
            return new CommonResult(444,"插入失败",null);
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult slect(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById!=null){
            return new CommonResult(200,"成功",paymentById);
        }else
            return new CommonResult(444,"失败",null);
    }
}
