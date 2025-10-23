package com.google.android.gms.common.util;

import android.util.Base64;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class Base64Utils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] decode(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] decodeUrlSafe(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ResultIgnorabilityUnspecified
    public static byte[] decodeUrlSafeNoPadding(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 11);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encode(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeUrlSafe(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeUrlSafeNoPadding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
