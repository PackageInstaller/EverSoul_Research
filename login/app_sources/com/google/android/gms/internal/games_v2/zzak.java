package com.google.android.gms.internal.games_v2;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public abstract class zzak {
    private final AtomicReference zza = new AtomicReference();

    protected abstract zzaj zza();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb() {
        zzaj zzajVar = (zzaj) this.zza.get();
        if (zzajVar != null) {
            zzajVar.zzd();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(String str, int i) {
        zzaj zzajVar = (zzaj) this.zza.get();
        if (zzajVar == null) {
            zzaj zza = zza();
            AtomicReference atomicReference = this.zza;
            while (true) {
                if (UByte$$ExternalSyntheticBackport0.m850m(atomicReference, null, zza)) {
                    zzajVar = zza;
                    break;
                } else if (atomicReference.get() != null) {
                    zzajVar = (zzaj) this.zza.get();
                    break;
                }
            }
        }
        zzajVar.zzc(str, i);
    }
}
