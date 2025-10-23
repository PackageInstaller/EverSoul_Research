package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzij {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzin zzc;
    private int zze;
    private boolean zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract int zza(int i) throws zzjq;

    public abstract float zzb() throws IOException;

    public abstract void zzb(int i) throws zzjq;

    public abstract int zzc();

    public abstract void zzc(int i);

    public abstract int zzd() throws IOException;

    public abstract boolean zzd(int i) throws IOException;

    public abstract int zze() throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzhu zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzt() throws IOException;

    public abstract boolean zzu() throws IOException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzij zza(byte[] bArr, int i, int i2, boolean z) {
        zzii zziiVar = new zzii(bArr, i2);
        try {
            zziiVar.zza(i2);
            return zziiVar;
        } catch (zzjq e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzij() {
        this.zzb = zzd;
        this.zze = Integer.MAX_VALUE;
        this.zzf = false;
    }
}
