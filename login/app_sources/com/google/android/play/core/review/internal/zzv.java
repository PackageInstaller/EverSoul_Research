package com.google.android.play.core.review.internal;

import android.util.Base64;
import com.kakao.sdk.auth.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
public final class zzv {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zza(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.CODE_CHALLENGE_ALGORITHM);
            messageDigest.update(bArr);
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
