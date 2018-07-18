package com.mengxk.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import static com.mengxk.util.BASE64Util.base642byte;


/**
 * Created by mengxk on 2018/6/14.
 */
public class DESUtil {

    /**
     * 生成DES密钥
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getKeyDES() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        String base64Str = BASE64Util.byte2base64(secretKey.getEncoded());
        return base64Str;
    }

    public static SecretKey loadKeyDES(String base64Key) throws IOException {
        byte[] bytes = base642byte(base64Key);
        SecretKey secretKey = new SecretKeySpec(bytes, "DES");
        return secretKey;
    }

    /**
     * 加密
     * @param source
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptDES(byte[] source, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

    public static byte[] decryptDES(byte[] source, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(source);
        return bytes;
    }

}
