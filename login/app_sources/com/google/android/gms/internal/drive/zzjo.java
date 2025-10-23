package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
public abstract class zzjo {
    private int zznz;
    private int zzoa;
    private boolean zzob;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjo zza(byte[] bArr, int i, int i2, boolean z) {
        zzjq zzjqVar = new zzjq(bArr, 0, i2, false);
        try {
            zzjqVar.zzv(i2);
            return zzjqVar;
        } catch (zzkq e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long zzk(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzw(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zzbz();

    public abstract int zzv(int i) throws zzkq;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzjo() {
        this.zznz = 100;
        this.zzoa = Integer.MAX_VALUE;
        this.zzob = false;
    }
}
