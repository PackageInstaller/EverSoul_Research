package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzio extends zzhv {
    private static final Logger zzb = Logger.getLogger(zzio.class.getName());
    private static final boolean zzc = zzmo.zzc();
    zzir zza;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    private static class zza extends zzio {
        private final byte[] zzb;
        private final int zzc;
        private final int zzd;
        private int zze;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final int zza() {
            return this.zzd - this.zze;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            if ((i2 | 0 | (bArr.length - i2)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.zzb = bArr;
            this.zzc = 0;
            this.zze = 0;
            this.zzd = i2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(byte b) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                this.zze = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void zzc(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.zzb, this.zze, i2);
                this.zze += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(int i, boolean z) throws IOException {
            zzc(i, 0);
            zza(z ? (byte) 1 : (byte) 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzb(byte[] bArr, int i, int i2) throws IOException {
            zzc(i2);
            zzc(bArr, 0, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(int i, zzhu zzhuVar) throws IOException {
            zzc(i, 2);
            zza(zzhuVar);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(zzhu zzhuVar) throws IOException {
            zzc(zzhuVar.zzb());
            zzhuVar.zza(this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(int i, int i2) throws IOException {
            zzc(i, 5);
            zza(i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(int i) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i2 = this.zze;
                int i3 = i2 + 1;
                bArr[i2] = (byte) i;
                int i4 = i3 + 1;
                bArr[i3] = (byte) (i >> 8);
                int i5 = i4 + 1;
                bArr[i4] = (byte) (i >> 16);
                this.zze = i5 + 1;
                bArr[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(int i, long j) throws IOException {
            zzc(i, 1);
            zza(j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(long j) throws IOException {
            try {
                byte[] bArr = this.zzb;
                int i = this.zze;
                int i2 = i + 1;
                bArr[i] = (byte) j;
                int i3 = i2 + 1;
                bArr[i2] = (byte) (j >> 8);
                int i4 = i3 + 1;
                bArr[i3] = (byte) (j >> 16);
                int i5 = i4 + 1;
                bArr[i4] = (byte) (j >> 24);
                int i6 = i5 + 1;
                bArr[i5] = (byte) (j >> 32);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (j >> 40);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (j >> 48);
                this.zze = i8 + 1;
                bArr[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzb(int i, int i2) throws IOException {
            zzc(i, 0);
            zzb(i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzb(int i) throws IOException {
            if (i >= 0) {
                zzc(i);
            } else {
                zzb(i);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzhv
        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            zzc(bArr, i, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        final void zza(int i, zzkr zzkrVar, zzlj zzljVar) throws IOException {
            zzc(i, 2);
            zzc(((zzhl) zzkrVar).zza(zzljVar));
            zzljVar.zza((zzlj) zzkrVar, (zzne) this.zza);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(zzkr zzkrVar) throws IOException {
            zzc(zzkrVar.zzbw());
            zzkrVar.zza(this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(int i, zzkr zzkrVar) throws IOException {
            zzc(1, 3);
            zzd(2, i);
            zzc(3, 2);
            zza(zzkrVar);
            zzc(1, 4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzb(int i, zzhu zzhuVar) throws IOException {
            zzc(1, 3);
            zzd(2, i);
            zza(3, zzhuVar);
            zzc(1, 4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(int i, String str) throws IOException {
            zzc(i, 2);
            zza(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zza(String str) throws IOException {
            int i = this.zze;
            try {
                int zzj = zzj(str.length() * 3);
                int zzj2 = zzj(str.length());
                if (zzj2 == zzj) {
                    int i2 = i + zzj2;
                    this.zze = i2;
                    int zza = zzmp.zza(str, this.zzb, i2, zza());
                    this.zze = i;
                    zzc((zza - i) - zzj2);
                    this.zze = zza;
                    return;
                }
                zzc(zzmp.zza(str));
                this.zze = zzmp.zza(str, this.zzb, this.zze, zza());
            } catch (zzms e) {
                this.zze = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzb(e2);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzc(int i, int i2) throws IOException {
            zzc((i << 3) | i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzd(int i, int i2) throws IOException {
            zzc(i, 0);
            zzc(i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzc(int i) throws IOException {
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i2 = this.zze;
                    this.zze = i2 + 1;
                    bArr[i2] = (byte) (i | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            byte[] bArr2 = this.zzb;
            int i3 = this.zze;
            this.zze = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzb(int i, long j) throws IOException {
            zzc(i, 0);
            zzb(j);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.measurement.zzio
        public final void zzb(long j) throws IOException {
            if (zzio.zzc && zza() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.zzb;
                    int i = this.zze;
                    this.zze = i + 1;
                    zzmo.zza(bArr, i, (byte) (((int) j) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.zzb;
                int i2 = this.zze;
                this.zze = i2 + 1;
                zzmo.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.zzb;
                    int i3 = this.zze;
                    this.zze = i3 + 1;
                    bArr3[i3] = (byte) (((int) j) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzb(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            byte[] bArr4 = this.zzb;
            int i4 = this.zze;
            this.zze = i4 + 1;
            bArr4[i4] = (byte) j;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(double d) {
        return 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(float f) {
        return 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(boolean z) {
        return 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzc(long j) {
        return 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zze(int i) {
        return 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zze(long j) {
        return 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzg(int i) {
        return 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static long zzi(long j) {
        return (j >> 63) ^ (j << 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzl(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public abstract int zza();

    public abstract void zza(byte b) throws IOException;

    public abstract void zza(int i) throws IOException;

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzhu zzhuVar) throws IOException;

    public abstract void zza(int i, zzkr zzkrVar) throws IOException;

    abstract void zza(int i, zzkr zzkrVar, zzlj zzljVar) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(zzhu zzhuVar) throws IOException;

    public abstract void zza(zzkr zzkrVar) throws IOException;

    public abstract void zza(String str) throws IOException;

    public abstract void zzb(int i) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzb(int i, long j) throws IOException;

    public abstract void zzb(int i, zzhu zzhuVar) throws IOException;

    public abstract void zzb(long j) throws IOException;

    abstract void zzb(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzc(int i) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
    public static class zzb extends IOException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzb(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zzb(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(int i, boolean z) {
        return zzj(i << 3) + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(byte[] bArr) {
        int length = bArr.length;
        return zzj(length) + length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzc(int i, zzhu zzhuVar) {
        int zzj = zzj(i << 3);
        int zzb2 = zzhuVar.zzb();
        return zzj + zzj(zzb2) + zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(zzhu zzhuVar) {
        int zzb2 = zzhuVar.zzb();
        return zzj(zzb2) + zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(int i, double d) {
        return zzj(i << 3) + 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zze(int i, int i2) {
        return zzj(i << 3) + zzg(i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzd(int i) {
        return zzg(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzf(int i, int i2) {
        return zzj(i << 3) + 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzc(int i, long j) {
        return zzj(i << 3) + 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(int i, float f) {
        return zzj(i << 3) + 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    static int zzb(int i, zzkr zzkrVar, zzlj zzljVar) {
        return (zzj(i << 3) << 1) + ((zzhl) zzkrVar).zza(zzljVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static int zzb(zzkr zzkrVar) {
        return zzkrVar.zzbw();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzg(int i, int i2) {
        return zzj(i << 3) + zzg(i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzf(int i) {
        return zzg(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzd(int i, long j) {
        return zzj(i << 3) + zzg(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzd(long j) {
        return zzg(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(int i, zzjv zzjvVar) {
        return (zzj(8) << 1) + zzj(2, i) + zzb(3, zzjvVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(int i, zzjv zzjvVar) {
        int zzj = zzj(i << 3);
        int zzb2 = zzjvVar.zzb();
        return zzj + zzj(zzb2) + zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(zzjv zzjvVar) {
        int zzb2 = zzjvVar.zzb();
        return zzj(zzb2) + zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(int i, zzkr zzkrVar) {
        return (zzj(8) << 1) + zzj(2, i) + zzj(24) + zzc(zzkrVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzc(int i, zzkr zzkrVar, zzlj zzljVar) {
        return zzj(i << 3) + zza(zzkrVar, zzljVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzc(zzkr zzkrVar) {
        int zzbw = zzkrVar.zzbw();
        return zzj(zzbw) + zzbw;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(zzkr zzkrVar, zzlj zzljVar) {
        int zza2 = ((zzhl) zzkrVar).zza(zzljVar);
        return zzj(zza2) + zza2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzd(int i, zzhu zzhuVar) {
        return (zzj(8) << 1) + zzj(2, i) + zzc(3, zzhuVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzh(int i, int i2) {
        return zzj(i << 3) + 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zze(int i, long j) {
        return zzj(i << 3) + 8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzi(int i, int i2) {
        return zzj(i << 3) + zzj(zzl(i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzh(int i) {
        return zzj(zzl(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzf(int i, long j) {
        return zzj(i << 3) + zzg(zzi(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzf(long j) {
        return zzg(zzi(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(int i, String str) {
        return zzj(i << 3) + zzb(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzb(String str) {
        int length;
        try {
            length = zzmp.zza(str);
        } catch (zzms unused) {
            length = str.getBytes(zzjh.zza).length;
        }
        return zzj(length) + length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzi(int i) {
        return zzj(i << 3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzj(int i, int i2) {
        return zzj(i << 3) + zzj(i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzj(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzg(int i, long j) {
        return zzj(i << 3) + zzg(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zzg(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzio zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzio() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(String str, zzms zzmsVar) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzmsVar);
        byte[] bytes = str.getBytes(zzjh.zza);
        try {
            zzc(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzb(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(boolean z) throws IOException {
        zza(z ? (byte) 1 : (byte) 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(int i, double d) throws IOException {
        zza(i, Double.doubleToRawLongBits(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(double d) throws IOException {
        zza(Double.doubleToRawLongBits(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(int i, float f) throws IOException {
        zza(i, Float.floatToRawIntBits(f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(float f) throws IOException {
        zza(Float.floatToRawIntBits(f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzk(int i, int i2) throws IOException {
        zzd(i, zzl(i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzk(int i) throws IOException {
        zzc(zzl(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzh(int i, long j) throws IOException {
        zzb(i, zzi(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzh(long j) throws IOException {
        zzb(zzi(j));
    }
}
