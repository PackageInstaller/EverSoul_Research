package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zabd extends zabw {
    private final WeakReference zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zabd(zabe zabeVar) {
        this.zaa = new WeakReference(zabeVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.zabw
    public final void zaa() {
        zabe zabeVar = (zabe) this.zaa.get();
        if (zabeVar == null) {
            return;
        }
        zabe.zai(zabeVar);
    }
}
