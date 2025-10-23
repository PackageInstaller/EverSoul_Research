package com.gamania.beanfunsdk.util;

import java.security.MessageDigest;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class EncodeUtil {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String decodeData(String str, String str2, String str3) {
        try {
            byte[] bytes = getMD5(str).getBytes("UTF-8");
            byte[] bytes2 = str2.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(Base64.decode(str3));
            if (doFinal != null) {
                return new String(doFinal, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeData(String str, String str2, String str3) {
        try {
            byte[] bytes = getMD5(str).getBytes("UTF-8");
            byte[] bytes2 = str2.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bytes2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, ivParameterSpec);
            byte[] doFinal = cipher.doFinal(str3.getBytes("UTF-8"));
            if (doFinal != null) {
                return Base64.encodeBytes(doFinal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String genProductKey(String str) {
        String encodeString = Base64.encodeString(new StringBuilder(str).reverse().toString());
        int length = str.length();
        String substring = encodeString.substring(0, length);
        return String.format(Locale.getDefault(), "%s%s", new StringBuilder(substring).reverse().toString(), encodeString.substring(length));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getMD5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append('0');
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
