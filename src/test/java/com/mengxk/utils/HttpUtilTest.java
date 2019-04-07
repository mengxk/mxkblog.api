package com.mengxk.utils;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.junit.Assert.*;

public class HttpUtilTest {

    @Test
    public void send() {
        System.out.println("11111111");
        //String result = HttpUtil.send("https://stock.xueqiu.com/v5/stock/batch/quote.json?symbol=SZ300259,SH600159&extend=detail",
        //RequestMethod.GET, "", MediaType.APPLICATION_JSON);
        String result = HttpUtil.doGet("https://stock.xueqiu.com/v5/stock/batch/quote.json?symbol=SZ300259,SH600159&extend=detail");
        System.out.println(result);

        //String template = URLEncoder.encode("oF_AT5kZARvTPpiKs8zWDMYoOs8c" + "wealth", "utf-8");
        for (int i = 0; i < 1000; i++) {
            String wealthToken2 = MD5Util.getMD5String("oF_AT5kZARvTPpiKs8zWDMYoOs8c" + "wealth");
            System.out.println(wealthToken2);
            if (!wealthToken2.equals("ca86bfb51078df04b546a5f2b2efd53a")){
                System.out.println("1111111111111111111111111111111111111111111111111111111111111111");
            }
        }
    }
}