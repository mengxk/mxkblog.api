package com.mengxk.controller;

import com.mengxk.utils.HttpUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mengxk on 2018/7/18.
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        String result = HttpUtil.send("https://stock.xueqiu.com/v5/stock/batch/quote.json?symbol=SZ300259,SH600159&extend=detail",
                RequestMethod.GET, "", MediaType.APPLICATION_JSON);
        System.out.println(result);
        return "Hello world";
    }
}
