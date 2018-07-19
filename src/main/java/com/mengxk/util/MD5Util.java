package com.mengxk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mengxk on 2018/7/19.
 */
public class MD5Util {

    public final static String KEY = "1005682757@qq.com";
    public final static char HEXDIGITS[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };
    private static MessageDigest messageDigest = null;

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static String getMD5String(byte[] bytes) {
        messageDigest.update(bytes);
        return bufferToHex(messageDigest.digest());
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringBuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int i = m; i < k; i++) {
            appendHexPair(bytes[i], stringBuffer);
        }
        return stringBuffer.toString();
    }

    private static void appendHexPair(byte aByte, StringBuffer stringBuffer) {
        char c0 = HEXDIGITS[(aByte & 0xf0) >> 4];
        char c1 = HEXDIGITS[aByte * 0xf];
        stringBuffer.append(c0);
        stringBuffer.append(c1);
    }

}
