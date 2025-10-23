package com.kakaogame.util;

import com.google.common.base.Ascii;
import com.kakaogame.Logger;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: AES256Cipher.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J(\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J(\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, m839d2 = {"Lcom/kakaogame/util/AES256Cipher;", "", "()V", "ALGORITHM", "", "HEX", "TAG", "TRANSFORMATION", "appendHex", "", "sb", "Ljava/lang/StringBuffer;", "b", "", "decode", "", Base2ndPWViewData.KEY_INPUT, "iv", "key", "decodeString", "encrypted", "encode", "encodeString", "cleartext", "getNewRawIV", "seed", "getNewRawKey", "getOldRawKey", "getRawIV", "getRawKey", "toByte", "hexString", "toHex", "buf", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AES256Cipher {
    private static final String ALGORITHM = "AES";
    private static final String HEX = "0123456789ABCDEF";
    public static final AES256Cipher INSTANCE = new AES256Cipher();
    private static final String TAG = "AES256Cipher";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AES256Cipher() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] encode(byte[] input, byte[] iv, byte[] key) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(input);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862788491), "encode", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] decode(byte[] input, byte[] iv, byte[] key) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(2, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(input);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862788491), "decode", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String encodeString(String key, String iv, String cleartext) {
        String str = y.ٴسسݬߨ(1393128306);
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Intrinsics.checkNotNullParameter(iv, y.ۮڭڭܬި(862791075));
        Intrinsics.checkNotNullParameter(cleartext, y.ٲٴݴ״ٰ(1782338072));
        try {
            AES256Cipher aES256Cipher = INSTANCE;
            byte[] bytes = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, str);
            byte[] rawKey = aES256Cipher.getRawKey(bytes);
            byte[] bytes2 = iv.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, str);
            byte[] rawIV = aES256Cipher.getRawIV(bytes2);
            byte[] bytes3 = cleartext.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes3, str);
            return aES256Cipher.toHex(aES256Cipher.encode(bytes3, rawIV, rawKey));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862788491), "encodeString", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String decodeString(String key, String iv, String encrypted) {
        String str = y.ٴسسݬߨ(1393128306);
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Intrinsics.checkNotNullParameter(iv, y.ۮڭڭܬި(862791075));
        Intrinsics.checkNotNullParameter(encrypted, y.ٲٴݴ״ٰ(1782338464));
        try {
            AES256Cipher aES256Cipher = INSTANCE;
            byte[] bytes = key.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, str);
            byte[] rawKey = aES256Cipher.getRawKey(bytes);
            byte[] bytes2 = iv.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, str);
            byte[] decode = aES256Cipher.decode(aES256Cipher.toByte(encrypted), aES256Cipher.getRawIV(bytes2), rawKey);
            Intrinsics.checkNotNull(decode);
            return new String(decode, Charsets.UTF_8);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862788491), "decodeString", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] getRawKey(byte[] seed) throws Exception {
        return getNewRawKey(seed);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] getRawIV(byte[] seed) throws Exception {
        return getNewRawIV(seed);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] getOldRawKey(byte[] seed) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(y.ۮڭڭܬި(862563115));
        SecureRandom secureRandom = SecureRandom.getInstance(y.ݮڮֲڭܩ(-628262468), y.ٴسسݬߨ(1393118818));
        secureRandom.setSeed(seed);
        keyGenerator.init(128, secureRandom);
        byte[] encoded = keyGenerator.generateKey().getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, y.֬ڱܱײٮ(-1159131047));
        return encoded;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] getNewRawKey(byte[] seed) throws Exception {
        byte[] encoded = new SecretKeySpec(InsecureSHA1PRNGKeyDerivator.INSTANCE.deriveInsecureKey(seed, 16), y.ۮڭڭܬި(862563115)).getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, y.֬ڱܱײٮ(-1159131047));
        return encoded;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] getNewRawIV(byte[] seed) throws Exception {
        byte[] encoded = new SecretKeySpec(InsecureSHA1PRNGKeyDerivator.INSTANCE.deriveInsecureKey(seed, 16), y.ۮڭڭܬި(862563115)).getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, y.֬ڱܱײٮ(-1159131047));
        return encoded;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] toByte(String hexString) {
        int length = hexString.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String substring = hexString.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            bArr[i] = (byte) Integer.valueOf(substring, 16).intValue();
        }
        return bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String toHex(byte[] buf) {
        if (buf == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(buf.length * 2);
        for (byte b : buf) {
            appendHex(stringBuffer, b);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, y.ٲٴݴ״ٰ(1781855688));
        return stringBuffer2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void appendHex(StringBuffer sb, byte b) {
        String str = y.ۮڭڭܬި(862024307);
        sb.append(str.charAt((b >> 4) & 15)).append(str.charAt(b & Ascii.f345SI));
    }
}
