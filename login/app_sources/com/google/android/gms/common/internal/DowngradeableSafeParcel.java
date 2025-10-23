package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zza = new Object();
    private boolean zzb = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static boolean canUnparcelSafely(String str) {
        synchronized (zza) {
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Integer getUnparcelClientVersion() {
        synchronized (zza) {
        }
        return null;
    }

    protected abstract boolean prepareForClientVersion(int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShouldDowngrade(boolean z) {
        this.zzb = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean shouldDowngrade() {
        return this.zzb;
    }
}
