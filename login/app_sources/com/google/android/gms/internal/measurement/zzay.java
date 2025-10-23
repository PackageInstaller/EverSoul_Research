package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzay {
    final List<zzbv> zza = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final zzaq zza(String str) {
        if (this.zza.contains(zzg.zza(str))) {
            throw new UnsupportedOperationException("Command not implemented: " + str);
        }
        throw new IllegalArgumentException("Command not supported");
    }

    public abstract zzaq zza(String str, zzh zzhVar, List<zzaq> list);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzay() {
    }
}
