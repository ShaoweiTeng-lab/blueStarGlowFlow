package com.example.blue_star.dto;

import lombok.Data;

/**
 *獲得訂單Response
 * */
@Data
public class GetOrderResponse {
    private String merchantId;
    private String version;
    private String respondType;
    private String checkValue;
    private String timeStamp;
    private String merchantOrderNo;
    private String amt;
    private String gateWay ;//預設為空值可不帶 (用於查詢複合式商店)


}
