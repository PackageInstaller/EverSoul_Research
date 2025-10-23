package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzmr implements zzfv {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzmp zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmr(zzmp zzmpVar, String str) {
        this.zza = str;
        this.zzb = zzmpVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfv
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(true, i, th, bArr, this.zza);
    }
}
