package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zze extends zzf {
    private boolean zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zze(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzu.zzaa();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void zzx() {
    }

    protected abstract boolean zzz();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzu() {
        if (!zzy()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzz()) {
            return;
        }
        this.zzu.zzz();
        this.zza = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzw() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzx();
        this.zzu.zzz();
        this.zza = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzy() {
        return this.zza;
    }
}
