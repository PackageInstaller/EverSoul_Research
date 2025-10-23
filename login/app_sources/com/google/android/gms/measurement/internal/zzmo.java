package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zzmo extends zzml {
    private boolean zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmo(zzmp zzmpVar) {
        super(zzmpVar);
        this.zzf.zzu();
    }

    protected abstract boolean zzc();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzak() {
        if (!zzam()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzal() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzc();
        this.zzf.zzt();
        this.zza = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzam() {
        return this.zza;
    }
}
