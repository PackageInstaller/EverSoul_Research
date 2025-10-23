package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzx extends zzal {
    private final Callable<Object> zzk;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzaq zza(zzh zzhVar, List<zzaq> list) {
        try {
            return zzj.zza(this.zzk.call());
        } catch (Exception unused) {
            return zzaq.zzc;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzx(String str, Callable<Object> callable) {
        super(str);
        this.zzk = callable;
    }
}
