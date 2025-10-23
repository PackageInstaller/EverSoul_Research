package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzl {
    private Map<String, Callable<? extends zzal>> zza = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzaq zza(String str) {
        if (!this.zza.containsKey(str)) {
            return zzaq.zzc;
        }
        try {
            return this.zza.get(str).call();
        } catch (Exception unused) {
            throw new IllegalStateException("Failed to create API implementation: " + str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, Callable<? extends zzal> callable) {
        this.zza.put(str, callable);
    }
}
