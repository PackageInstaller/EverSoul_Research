package com.kakaogame.util;

import com.google.common.base.Ascii;
import com.liapp.y;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: ChaCha20Cipher.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018J(\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, m839d2 = {"Lcom/kakaogame/util/ChaCha20Cipher;", "", "()V", "ALGORITHM", "", "HEX", "K_ALGORITHM", "NONCE_LEN", "", "nonce", "", "getNonce", "()[B", "appendHex", "", "sb", "Ljava/lang/StringBuffer;", "b", "", "convertBytesToHex", "buf", "convertHexToBytes", "hex", "createKey", "Ljavax/crypto/SecretKey;", "decrypt", "cText", "key", "encrypt", "pText", "encryptString", "getByteKey", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ChaCha20Cipher {
    private static final String ALGORITHM = "ChaCha20/Poly1305/NoPadding";
    private static final String HEX = "0123456789abcdef";
    public static final ChaCha20Cipher INSTANCE = new ChaCha20Cipher();
    private static final String K_ALGORITHM = "ChaCha20";
    private static final int NONCE_LEN = 12;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] encrypt(byte[] bArr, SecretKey secretKey) throws Exception {
        return encrypt$default(this, bArr, secretKey, null, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ChaCha20Cipher() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String encryptString(byte[] pText, SecretKey key) throws Exception {
        return convertBytesToHex(encrypt$default(this, pText, key, null, 4, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ byte[] encrypt$default(ChaCha20Cipher chaCha20Cipher, byte[] bArr, SecretKey secretKey, byte[] bArr2, int i, Object obj) throws Exception {
        if ((i & 4) != 0) {
            bArr2 = chaCha20Cipher.getNonce();
        }
        return chaCha20Cipher.encrypt(bArr, secretKey, bArr2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] encrypt(byte[] pText, SecretKey key, byte[] nonce) throws Exception {
        Cipher cipher = Cipher.getInstance(y.ݬֲ֮ܲت(1512077039));
        cipher.init(1, key, new IvParameterSpec(nonce));
        byte[] doFinal = cipher.doFinal(pText);
        byte[] array = ByteBuffer.allocate(doFinal.length + 12).put(doFinal).put(nonce).array();
        Intrinsics.checkNotNullExpressionValue(array, "array(...)");
        return array;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] decrypt(byte[] cText, SecretKey key) throws Exception {
        Intrinsics.checkNotNullParameter(cText, y.دײܮڳܯ(2051039053));
        ByteBuffer wrap = ByteBuffer.wrap(cText);
        byte[] bArr = new byte[cText.length - 12];
        byte[] bArr2 = new byte[12];
        wrap.get(bArr);
        wrap.get(bArr2);
        Cipher cipher = Cipher.getInstance(y.ݬֲ֮ܲت(1512077039));
        cipher.init(2, key, new IvParameterSpec(bArr2));
        byte[] doFinal = cipher.doFinal(bArr);
        Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
        return doFinal;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] getNonce() {
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String convertBytesToHex(byte[] buf) {
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
        String str = y.ݬֲ֮ܲت(1512968423);
        sb.append(str.charAt((b >> 4) & 15)).append(str.charAt(b & Ascii.f345SI));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] convertHexToBytes(String hex) {
        Intrinsics.checkNotNullParameter(hex, y.֬ڱܱײٮ(-1159134967));
        if (hex.length() % 2 != 0) {
            hex = y.دײܮڳܯ(2051900013) + hex;
        }
        int length = hex.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String substring = hex.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            bArr[i] = (byte) Integer.parseInt(substring, CharsKt.checkRadix(16));
        }
        return bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SecretKey createKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(y.دײܮڳܯ(2051038765));
        keyGenerator.init(256, SecureRandom.getInstanceStrong());
        SecretKey generateKey = keyGenerator.generateKey();
        Intrinsics.checkNotNullExpressionValue(generateKey, y.ۮڭڭܬި(862795163));
        return generateKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SecretKey getByteKey(String key) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        byte[] convertHexToBytes = convertHexToBytes(key);
        return new SecretKeySpec(convertHexToBytes, 0, convertHexToBytes.length, y.دײܮڳܯ(2051038765));
    }
}
