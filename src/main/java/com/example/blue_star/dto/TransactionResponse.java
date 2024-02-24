package com.example.blue_star.dto;

import lombok.Data;

@Data
public class TransactionResponse {
    private String status;
    private String merchantID;
    private String version;
    private String tradeInfo;
    private String tradeSha;
}
