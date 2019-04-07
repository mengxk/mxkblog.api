package com.mengxk.util;

import com.mengxk.utils.DESUtil;
import org.junit.Test;

import javax.crypto.SecretKey;

/**
 * Created by mengxk on 2018/7/24.
 */
public class DESUtilTest {
    @Test
    public void getKeyDES() throws Exception {
        String base64Str = DESUtil.getKeyDES();
        System.out.print(base64Str);
    }

    @Test
    public void loadKeyDES() throws Exception {
        //rhrEf5FiE3o=
    }

    @Test
    public void encryptDES() throws Exception {
        SecretKey secretKey = DESUtil.loadKeyDES("rhrEf5FiE3o=");
        byte[] bytes = DESUtil.encryptDES("123".getBytes("utf-8"), secretKey);
        System.out.println(new String (bytes, "utf-8"));
    }

    @Test
    public void decryptDES() throws Exception {
        SecretKey secretKey = DESUtil.loadKeyDES("rhrEf5FiE3o=");
        byte[] bytes = DESUtil.encryptDES("mxkBlog".getBytes(), secretKey);
        byte[] bytes1 = DESUtil.decryptDES(bytes, secretKey);
        String string = new String(bytes1);
        System.out.println(string);
    }

}