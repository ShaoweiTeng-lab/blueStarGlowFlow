package com.example.blue_star.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class FormRequest {

    private String MerchantID;
    private String RespondType;
    private Long TimeStamp;
    private String Version;
    private String MerchantOrderNo;
    private String Amt;
    private String ItemDesc;
    private String NotifyURL;
    public String toFormDataString() {
        return "MerchantID=" + MerchantID +
                "&RespondType=" + RespondType +
                "&TimeStamp=" + TimeStamp +
                "&Version=" + Version +
                "&MerchantOrderNo=" + MerchantOrderNo +
                "&Amt=" + Amt +
                "&ItemDesc=" + ItemDesc +
                "&NotifyURL=" + NotifyURL;
    }

}
