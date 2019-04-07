package com.mengxk.util;

import com.mengxk.utils.MD5Util;
import org.junit.Test;

/**
 * Created by mengxk on 2018/7/19.
 */
public class MD5UtilTest {
    @Test
    public void getMD5String() throws Exception {
        String md5Str = MD5Util.getMD5String("1005682757@qq.com" + MD5Util.KEY);
        System.out.println(md5Str);
        //af7541158ec1cc5426dc18a24047b101
    }

}