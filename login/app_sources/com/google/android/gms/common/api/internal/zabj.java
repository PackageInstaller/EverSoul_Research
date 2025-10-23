package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.util.concurrent.NumberedThreadFactory;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class zabj {
    private static final ExecutorService zaa = com.google.android.gms.internal.base.zat.zaa().zac(2, new NumberedThreadFactory("GAC_Executor"), 2);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExecutorService zaa() {
        return zaa;
    }
}
