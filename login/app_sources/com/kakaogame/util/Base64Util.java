package com.kakaogame.util;

import android.util.Base64;
import com.liapp.y;
import java.io.UnsupportedEncodingException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: Base64Util.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/util/Base64Util;", "", "()V", "getBase64decode", "", "content", "getBase64decodeByteString", "", "getBase64encode", "getBase64encodeFromData", "source", "flag", "", "getUrlSafeBase64", "getUrlSafeBase64decode", "getUrlSafeBase64encode", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Base64Util {
    public static final Base64Util INSTANCE = new Base64Util();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Base64Util() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getBase64encodeFromData(byte[] source, int flag) {
        return Base64.encodeToString(source, flag);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getUrlSafeBase64(byte[] source) {
        String encodeToString = Base64.encodeToString(source, 10);
        Intrinsics.checkNotNullExpressionValue(encodeToString, y.دײܮڳܯ(2051018429));
        return encodeToString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getBase64encode(String content) {
        String str = y.ٴسسݬߨ(1393128306);
        Intrinsics.checkNotNullParameter(content, y.֬ڱܱײٮ(-1159406207));
        try {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, str);
            String encodeToString = Base64.encodeToString(bytes, 0);
            Intrinsics.checkNotNull(encodeToString);
            return encodeToString;
        } catch (UnsupportedEncodingException unused) {
            byte[] bytes2 = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, str);
            String encodeToString2 = Base64.encodeToString(bytes2, 0);
            Intrinsics.checkNotNull(encodeToString2);
            return encodeToString2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getBase64decode(String content) {
        String str = y.٬ݯح׭٩(576358142);
        try {
            byte[] decode = Base64.decode(content, 0);
            Intrinsics.checkNotNullExpressionValue(decode, str);
            return new String(decode, Charsets.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            byte[] decode2 = Base64.decode(content, 0);
            Intrinsics.checkNotNullExpressionValue(decode2, str);
            return new String(decode2, Charsets.UTF_8);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] getBase64decodeByteString(String content) {
        try {
            byte[] decode = Base64.decode(content, 0);
            Intrinsics.checkNotNull(decode);
            return decode;
        } catch (IllegalArgumentException unused) {
            byte[] decode2 = Base64.decode(content, 0);
            Intrinsics.checkNotNull(decode2);
            return decode2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getUrlSafeBase64encode(String content) {
        String str = y.ٴسسݬߨ(1393128306);
        Intrinsics.checkNotNullParameter(content, y.֬ڱܱײٮ(-1159406207));
        try {
            byte[] bytes = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, str);
            String encodeToString = Base64.encodeToString(bytes, 11);
            Intrinsics.checkNotNull(encodeToString);
            return encodeToString;
        } catch (UnsupportedEncodingException unused) {
            byte[] bytes2 = content.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, str);
            String encodeToString2 = Base64.encodeToString(bytes2, 11);
            Intrinsics.checkNotNull(encodeToString2);
            return encodeToString2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUrlSafeBase64decode(String content) {
        String str = y.٬ݯح׭٩(576358142);
        try {
            byte[] decode = Base64.decode(content, 11);
            Intrinsics.checkNotNullExpressionValue(decode, str);
            return new String(decode, Charsets.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            byte[] decode2 = Base64.decode(content, 11);
            Intrinsics.checkNotNullExpressionValue(decode2, str);
            return new String(decode2, Charsets.UTF_8);
        }
    }
}
