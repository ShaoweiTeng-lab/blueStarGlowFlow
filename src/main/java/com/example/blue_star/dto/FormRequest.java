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
    private String LangType;
    private Integer TradeLimit;//交易有效時間
    private String ExpireDate;//繳費期限
    private String ReturnUrl;//支付完成返回商店網址
    private String NotifyURL;//支付通知網址
    private String CustomerURL;//返回商店網址
    private String Email ; //付款人電子信箱
    private Integer EmailModify ; //1 = 可修改(預設) ,0 不可修改
    private Integer LoginType ; //0 = 不需登入藍星金流會員 1= 需登入
    private String OrderComment;//商店備註
    private Integer CREDIT; //信用卡一次付清 0 = 不啟用 1 = 啟用
    private Integer ANDROIDPAY; //Google Pay啟用 0 = 不啟用 1 = 啟用
    private Integer SAMSUNGPAY; //Samsung Pay啟用 0 = 不啟用 1 = 啟用
    private Integer LINEPAY; //Line Pay啟用 0 = 不啟用 1 = 啟用
    private Integer ImageUrl; //Line Pay圖檔位置
    private String InstFlag; //信用卡分期付款
    private Integer CreditRed; //是否信用卡紅利啟用 0 = 不啟用 1 = 啟用
    private Integer UNIONPAY; //信用卡銀聯卡啟用 0 = 不啟用 1 = 啟用
    private Integer CREDITAE; //信用卡美國通運卡啟用 0 = 不啟用 1 = 啟用
    private Integer WEBATM; //WEBATM啟用 0 = 不啟用 1 = 啟用
    private Integer VACC; //ATM轉帳啟用 0 = 不啟用 1 = 啟用
    private String BankType; //金融機構 ： BOT -台灣銀行 HNCB-華南銀行
    private Integer CVS; //超商代碼繳費啟用 ： 0 = 不啟用 1 = 啟用
    private Integer BARCODE; //超商代碼繳費啟用 ： 0 = 不啟用 1 = 啟用
    private Integer ESUNWALLET; //玉山WALLET ： 0 = 不啟用 1 = 啟用
    private Integer TAIWANPAY; //台灣PAY啟用 ： 0 = 不啟用 1 = 啟用
    private String FLUA; //Flua 付啦
    private Integer CVSCOM; //物流啟動 ： 0 = 不開啟 1 = 啟動超商取貨不付款 2 = 啟動超商取貨不付款 3 =啟動超商取貨付款及超商取貨不付款
    private Integer EZPAY;  //簡單付款電子錢包 0 = 不啟用 1 = 啟用
    private Integer EZPWECHAT;  //簡單為微信支付 0 = 不啟用 1 = 啟用
    private String LgsType;//物流型態 B2B = 大宗寄倉 C2C = 店到店

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
