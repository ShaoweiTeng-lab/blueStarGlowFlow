package com.example.blue_star.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 負責properties 設定檔讀取
 * */

@Component
public class CommonProperties {
    @Value(value = "${notifyURL}")
    public  static String notifyURl;
    @Value(value = "${queryTradeInfoURL}")
    public  static String queryTradeInfoURL;
}
