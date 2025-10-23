package com.google.android.gms.internal.p035authapi;

import android.util.Base64;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
public final class zbbb {
    private static final Random zba = new Random();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zba() {
        byte[] bArr = new byte[16];
        zba.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
