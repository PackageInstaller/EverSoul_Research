package com.google.android.gms.internal.games_v2;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public abstract class zzaj {
    private final Handler zza;
    private boolean zzc;
    final Object zzb = new Object();
    private final HashMap zzd = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzaj(Looper looper, int i) {
        this.zza = new zzfa(looper);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* bridge */ /* synthetic */ void zzb(zzaj zzajVar) {
        synchronized (zzajVar.zzb) {
            zzajVar.zzc = false;
            zzajVar.zzd();
        }
    }

    protected abstract void zza(String str, int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(String str, int i) {
        synchronized (this.zzb) {
            if (!this.zzc) {
                this.zzc = true;
                this.zza.postDelayed(new zzai(this), 1000L);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzd.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzd.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd() {
        synchronized (this.zzb) {
            for (Map.Entry entry : this.zzd.entrySet()) {
                zza((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzd.clear();
        }
    }
}
