package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzhg {
    private final boolean zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhg(zzhj zzhjVar) {
        Preconditions.checkNotNull(zzhjVar, "BuildInfo must be non-null");
        this.zza = !zzhjVar.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(String str) {
        Preconditions.checkNotNull(str, "flagName must not be null");
        if (this.zza) {
            return zzhi.zza.get().containsValue(str);
        }
        return true;
    }
}
