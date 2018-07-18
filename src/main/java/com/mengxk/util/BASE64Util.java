package com.mengxk.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by mengxk on 2018/6/16.
 */
public class BASE64Util {

    public static String byte2base64(byte[] bytes) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(bytes);
    }

    public static byte[] base642byte(String base64) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        return base64Decoder.decodeBuffer(base64);
    }

}
