package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzv extends zzx {
    private final Callable zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzv(Callable callable, zzu zzuVar) {
        super();
        this.zze = callable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.zzx
    final String zza() {
        try {
            return (String) this.zze.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
