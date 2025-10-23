package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzr {
    Object zza;
    zzu zzb;
    private zzw zzc = zzw.zze();
    private boolean zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzr() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void finalize() {
        zzw zzwVar;
        zzu zzuVar = this.zzb;
        if (zzuVar != null && !zzuVar.isDone()) {
            zzuVar.zzc(new zzs("The completer object was garbage collected - this future would otherwise never complete. The tag was: ".concat(String.valueOf(String.valueOf(this.zza)))));
        }
        if (this.zzd || (zzwVar = this.zzc) == null) {
            return;
        }
        zzwVar.zzd(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza() {
        this.zza = null;
        this.zzb = null;
        this.zzc.zzd(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzb(Object obj) {
        this.zzd = true;
        zzu zzuVar = this.zzb;
        boolean z = zzuVar != null && zzuVar.zza(obj);
        if (z) {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }
        return z;
    }
}
