package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhy extends zzie {
    private final int zzc;
    private final int zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzie, com.google.android.gms.internal.measurement.zzhu
    public final byte zza(int i) {
        int zzb = zzb();
        if (((zzb - (i + 1)) | i) >= 0) {
            return this.zzb[this.zzc + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzie, com.google.android.gms.internal.measurement.zzhu
    final byte zzb(int i) {
        return this.zzb[this.zzc + i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzie
    protected final int zze() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzie, com.google.android.gms.internal.measurement.zzhu
    public final int zzb() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhy(byte[] bArr, int i, int i2) {
        super(bArr);
        zza(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }
}
