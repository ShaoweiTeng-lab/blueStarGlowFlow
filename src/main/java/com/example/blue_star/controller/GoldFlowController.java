package com.example.blue_star.controller;

import com.example.blue_star.dto.*;
import com.example.blue_star.service.GoldFlowService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@RestController
public class GoldFlowController {
    private  final GoldFlowService goldFlowService;
    @Autowired
    public GoldFlowController(GoldFlowService goldFlowService){
        this.goldFlowService = goldFlowService;
    }
    @GetMapping("getSHAEncrypt")
    public  String getSHAEncrypt(){
        return goldFlowService.getSHAEncrypt();
    }

    /**
     * 創立金流
     * */
    @PostMapping("/createOrder")
    public FormResponse createOrder(@ModelAttribute FormRequest formRequest){
        return goldFlowService.createOrderInfo(formRequest);
    }

    /**
     * 創立金流+物流
     * */
    @PostMapping("/createLogistic")
    public FormResponse createLogistic(@ModelAttribute FormRequest formRequest){
        return goldFlowService.createOrderLogisticInfo(formRequest);
    }

    @PostMapping("/completePay")
    public  String completePay(){
        //前端倒轉用
        System.out.println("完成付款");
        return ("完成付款");
    }

    @PostMapping("/notifyPay")
    public  String notifyPayPay(@ModelAttribute TransactionResponse data){
        //背景接收付款資訊

        System.out.println(data);
        goldFlowService.processResponse(data);
        return ("完成付款");
    }
    @PostMapping("/getOrder")
    public GetOrderResponse getOrder(@ModelAttribute GetOrderRequest getOrderRequest){
        // return goldFlowService.getOrder(getOrderRequest);
        return goldFlowService.queryOrder(getOrderRequest);

    }
}
