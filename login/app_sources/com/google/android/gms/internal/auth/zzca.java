package com.google.android.gms.internal.auth;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzca extends ContentObserver {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzca(Handler handler) {
        super(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        AtomicBoolean atomicBoolean;
        atomicBoolean = zzcb.zzk;
        atomicBoolean.set(true);
    }
}
