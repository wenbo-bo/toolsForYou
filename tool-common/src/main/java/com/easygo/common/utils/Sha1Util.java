package com.easygo.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * sha1加解密
 *
 * @author:
 * @version: 2019年05月08日 16:17
 */
public class Sha1Util {
    private static final String ZERO = "0";
    private static final String ALGORITHM = "SHA1";

    /**
     * sha1加密
     *
     * @param str
     * @return 返回十六进制的字符串形式，全部小写
     */
    public static String encrypt(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(str.getBytes());
            return byte2hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 二进制转十六进制字符串
     *
     * @param bytes
     * @return
     */
    public static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append(ZERO);
            }
            sign.append(hex);
        }
        return sign.toString();
    }


}
