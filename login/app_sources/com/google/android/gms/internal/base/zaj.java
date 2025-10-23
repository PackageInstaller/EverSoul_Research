package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes2.dex */
final class zaj extends Drawable.ConstantState {
    int zaa;
    int zab;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zaj(zaj zajVar) {
        if (zajVar != null) {
            this.zaa = zajVar.zaa;
            this.zab = zajVar.zab;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.zaa;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new zak(this);
    }
}
