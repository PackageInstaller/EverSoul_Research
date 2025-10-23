package com.kakao.sdk.common.util;

import android.util.Base64;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ContextInfo;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: AESCipher.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u001e\u0010\u0017\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m839d2 = {"Lcom/kakao/sdk/common/util/AESCipher;", "Lcom/kakao/sdk/common/util/Cipher;", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "(Lcom/kakao/sdk/common/model/ContextInfo;)V", "charSet", "Ljava/nio/charset/Charset;", "cipherAlgorithm", "", "decryptor", "Ljavax/crypto/Cipher;", "encryptor", "initVector", "", "ivParameterSpec", "Ljavax/crypto/spec/IvParameterSpec;", "keyGenAlgorithm", "base64DecodeAndXor", "source", "decrypt", "encrypted", "encrypt", "value", "xorMessage", "message", "key", "Companion", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AESCipher implements Cipher {
    private static final String ALGORITHM = "AES";
    private static final int ITEM_COUNT = 2;
    private static final int KEY_LENGTH = 256;
    private final Charset charSet;
    private final String cipherAlgorithm;
    private final javax.crypto.Cipher decryptor;
    private final javax.crypto.Cipher encryptor;
    private final byte[] initVector;
    private final IvParameterSpec ivParameterSpec;
    private final String keyGenAlgorithm;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AESCipher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AESCipher(ContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        String base64DecodeAndXor = base64DecodeAndXor("My0oeSI1IzInbyA+LVFaW2wiNSokPAMiMipOLS4=");
        this.keyGenAlgorithm = base64DecodeAndXor;
        String base64DecodeAndXor2 = base64DecodeAndXor("Iio+ASgjKE4/ZSIjXDMOCUoCDww=");
        this.cipherAlgorithm = base64DecodeAndXor2;
        this.charSet = Charsets.UTF_8;
        byte[] bArr = {112, 78, 75, 55, -54, -30, -10, 44, 102, -126, -126, 92, -116, -48, -123, -55};
        this.initVector = bArr;
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        this.ivParameterSpec = ivParameterSpec;
        String signingKeyHash = contextInfo.getSigningKeyHash();
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(base64DecodeAndXor);
        String substring = signingKeyHash.substring(0, Math.min(signingKeyHash.length(), 16));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        char[] charArray = substring.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        SecretKey generateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(charArray, contextInfo.getSalt(), 2, 256));
        SecretKeySpec secretKeySpec = new SecretKeySpec(generateSecret.getEncoded(), ALGORITHM);
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(base64DecodeAndXor2);
        Intrinsics.checkNotNullExpressionValue(cipher, "getInstance(cipherAlgorithm)");
        this.encryptor = cipher;
        javax.crypto.Cipher cipher2 = javax.crypto.Cipher.getInstance(base64DecodeAndXor2);
        Intrinsics.checkNotNullExpressionValue(cipher2, "getInstance(cipherAlgorithm)");
        this.decryptor = cipher2;
        try {
            cipher.init(1, secretKeySpec, ivParameterSpec);
            cipher2.init(2, secretKeySpec, ivParameterSpec);
        } catch (InvalidKeyException unused) {
            SecretKeySpec secretKeySpec2 = new SecretKeySpec(Arrays.copyOfRange(generateSecret.getEncoded(), 0, generateSecret.getEncoded().length / 2), ALGORITHM);
            this.encryptor.init(1, secretKeySpec2, this.ivParameterSpec);
            this.decryptor.init(2, secretKeySpec2, this.ivParameterSpec);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AESCipher(ApplicationContextInfo applicationContextInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.Cipher
    public String encrypt(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        javax.crypto.Cipher cipher = this.encryptor;
        byte[] bytes = value.getBytes(this.charSet);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(cipher.doFinal(bytes), 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(encryptor…harSet)), Base64.NO_WRAP)");
        return encodeToString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.common.util.Cipher
    public String decrypt(String encrypted) {
        Intrinsics.checkNotNullParameter(encrypted, "encrypted");
        byte[] doFinal = this.decryptor.doFinal(Base64.decode(encrypted, 2));
        Intrinsics.checkNotNullExpressionValue(doFinal, "decryptor.doFinal(Base64…crypted, Base64.NO_WRAP))");
        return new String(doFinal, this.charSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String xorMessage(String message) {
        return xorMessage(message, "com.kakao.api");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String xorMessage(String message, String key) {
        if (message != null && key != null) {
            try {
                char[] charArray = key.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
                char[] charArray2 = message.toCharArray();
                Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
                int length = charArray2.length;
                int length2 = charArray.length;
                char[] cArr = new char[length];
                for (int i = 0; i < length; i++) {
                    cArr[i] = (char) (charArray2[i] ^ charArray[i % length2]);
                }
                return new String(cArr);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String base64DecodeAndXor(String source) {
        byte[] decode = Base64.decode(source, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(source, Base64.DEFAULT)");
        return xorMessage(new String(decode, Charsets.UTF_8));
    }
}
