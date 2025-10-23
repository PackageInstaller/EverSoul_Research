package com.google.android.gms.measurement.internal;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzfg<V> {
    private static final Object zza = new Object();
    private final String zzb;
    private final zzfe<V> zzc;
    private final V zzd;
    private final V zze;
    private final Object zzf;
    private volatile V zzg;
    private volatile V zzh;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final V zza(V v) {
        List<zzfg> list;
        synchronized (this.zzf) {
        }
        if (v != null) {
            return v;
        }
        if (zzfd.zza == null) {
            return this.zzd;
        }
        synchronized (zza) {
            if (zzab.zza()) {
                return this.zzh == null ? this.zzd : this.zzh;
            }
            try {
                list = zzbg.zzcy;
                for (zzfg zzfgVar : list) {
                    if (zzab.zza()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v2 = null;
                    try {
                        zzfe<V> zzfeVar = zzfgVar.zzc;
                        if (zzfeVar != null) {
                            v2 = zzfeVar.zza();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (zza) {
                        zzfgVar.zzh = v2;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzfe<V> zzfeVar2 = this.zzc;
            if (zzfeVar2 == null) {
                return this.zzd;
            }
            try {
                return zzfeVar2.zza();
            } catch (IllegalStateException unused3) {
                return this.zzd;
            } catch (SecurityException unused4) {
                return this.zzd;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zza() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfg(String str, V v, V v2, zzfe<V> zzfeVar) {
        this.zzf = new Object();
        this.zzg = null;
        this.zzh = null;
        this.zzb = str;
        this.zzd = v;
        this.zze = v2;
        this.zzc = zzfeVar;
    }
}
