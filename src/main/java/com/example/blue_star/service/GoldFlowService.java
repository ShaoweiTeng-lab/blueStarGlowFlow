package com.example.blue_star.service;

import com.example.blue_star.dto.*;
import com.example.blue_star.utils.AES256CBCUtils;
import com.example.blue_star.utils.BlueStarUtils;
import com.example.blue_star.utils.SHA256Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;


@Service
public class GoldFlowService {
    @Value(value = "${key}")
    private String key;
    @Value(value = "${iv}")
    private String iv;
    @Value(value = "${mid}")
    private String mid;
    @Value(value = "${notifyURL}")
    private String notifyURL;
    private RestTemplate restTemplate = new RestTemplate();

    public String getSHAEncrypt() {
        try {
            return AES256CBCUtils.encrypt(mid, key, iv);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 生成訂單
     */
    public FormResponse createOrderInfo(FormRequest formRequest) {
        long t = System.currentTimeMillis();
        formRequest.setMerchantID(mid);
        formRequest.setRespondType("String");
        formRequest.setNotifyURL(notifyURL);
        formRequest.setVersion("2.0");
        formRequest.setTimeStamp(t);
        formRequest.setMerchantOrderNo("test_store_Mpg_" + t);
        String tradeInfo = null;
        try {
            //將formData 進行 AES256CBC 加密

            tradeInfo = AES256CBCUtils.encrypt(formRequest.toFormDataString(), key, iv);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //依照藍星金流格式串接  StringUpper(sha256(HashKey=key&tradeInfo&HashIV))
        String tradeSha = SHA256Utils.sha256("HashKey=" + key + "&" + tradeInfo + "&" + "HashIV=" + iv).toUpperCase();
        FormResponse formResponse = new FormResponse();
        formResponse.setMerchantID(mid);
        formResponse.setTradeInfo(tradeInfo);
        formResponse.setTradeSha(tradeSha);
        formResponse.setVersion(2.0);
        //將加密資料返回前端後 由前端對藍星發請求,之後倒轉轉頁到藍星付款頁
        return formResponse;
    }

    /**
     * 處理藍星付款後返回參數
     */
    public String processResponse(TransactionResponse data) {
        String newData = null;
        try {
            newData = AES256CBCUtils.decrypt(data.getTradeInfo(), key, iv);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // Utils.removePadding(data.getTradeInfo());
        System.out.println(newData);
        return newData;
    }

    public GetOrderResponse getOrder(GetOrderRequest getOrderRequest) {
        String checkValue = BlueStarUtils.generateCheckValue(mid, getOrderRequest.getAmt(), getOrderRequest.getMerchantOrderNo(), iv, key);
        GetOrderResponse rs = new GetOrderResponse();
        rs.setMerchantId(mid);
        rs.setVersion("2.0");
        rs.setRespondType("String");
        rs.setCheckValue(checkValue);
        System.out.println(checkValue);
        rs.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        rs.setMerchantOrderNo(getOrderRequest.getMerchantOrderNo());
        rs.setAmt(getOrderRequest.getAmt());
        return rs;
    }


}
