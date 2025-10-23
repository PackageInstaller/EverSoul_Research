package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjf;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public class zzis {
    static final zzis zza = new zzis(true);
    private static volatile boolean zzb = false;
    private static boolean zzc = true;
    private static volatile zzis zzd;
    private final Map<zza, zzjf.zzf<?, ?>> zze;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    private static final class zza {
        private final Object zza;
        private final int zzb;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(Object obj, int i) {
            this.zza = obj;
            this.zzb = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzis zza() {
        zzis zzisVar = zzd;
        if (zzisVar != null) {
            return zzisVar;
        }
        synchronized (zzis.class) {
            zzis zzisVar2 = zzd;
            if (zzisVar2 != null) {
                return zzisVar2;
            }
            zzis zza2 = zzjd.zza(zzis.class);
            zzd = zza2;
            return zza2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <ContainingType extends zzkr> zzjf.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzjf.zzf) this.zze.get(new zza(containingtype, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzis() {
        this.zze = new HashMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzis(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
