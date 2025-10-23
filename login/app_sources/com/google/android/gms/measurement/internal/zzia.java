package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zzia extends zzib {
    private boolean zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzia(zzhd zzhdVar) {
        super(zzhdVar);
        this.zzu.zzaa();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void zzaa() {
    }

    protected abstract boolean zzo();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzac() {
        if (!zzaf()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzad() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzo()) {
            return;
        }
        this.zzu.zzz();
        this.zza = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzae() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzaa();
        this.zzu.zzz();
        this.zza = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzaf() {
        return this.zza;
    }
}
