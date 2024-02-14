package com.example.blue_star.controller;

import com.example.blue_star.dto.FormRequest;
import com.example.blue_star.dto.FormResponse;
import com.example.blue_star.service.GoldFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/createOrder")
    public FormResponse createOrder(@ModelAttribute FormRequest formRequest){
        return goldFlowService.createOrderInfo(formRequest);
    }

    @PostMapping("/completePay")
    public  String completePay(){
        System.out.println("完成付款");
        return ("完成付款");
    }
}
