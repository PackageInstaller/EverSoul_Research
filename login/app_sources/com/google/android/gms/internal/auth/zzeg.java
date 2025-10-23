package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzeg {
    static final zzeg zza = new zzeg(true);
    private static volatile boolean zzb;
    private static volatile zzeg zzc;
    private final Map zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzeg() {
        this.zzd = new HashMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzeg zza() {
        zzeg zzegVar = zzc;
        if (zzegVar == null) {
            synchronized (zzeg.class) {
                zzegVar = zzc;
                if (zzegVar == null) {
                    zzegVar = zza;
                    zzc = zzegVar;
                }
            }
        }
        return zzegVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzeg(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
