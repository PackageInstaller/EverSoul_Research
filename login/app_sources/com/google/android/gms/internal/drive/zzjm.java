package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
class zzjm extends zzjl {
    protected final byte[] zzny;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjm(byte[] bArr) {
        bArr.getClass();
        this.zzny = bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int zzbw() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    public byte zzs(int i) {
        return this.zzny[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    byte zzt(int i) {
        return this.zzny[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    public int size() {
        return this.zzny.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    public final zzjc zza(int i, int i2) {
        int zzb = zzb(0, i2, size());
        if (zzb == 0) {
            return zzjc.zznq;
        }
        return new zzjh(this.zzny, zzbw(), zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    final void zza(zzjb zzjbVar) throws IOException {
        zzjbVar.zza(this.zzny, zzbw(), size());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    protected final String zza(Charset charset) {
        return new String(this.zzny, zzbw(), size(), charset);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    public final boolean zzbu() {
        int zzbw = zzbw();
        return zznf.zze(this.zzny, zzbw, size() + zzbw);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjc) || size() != ((zzjc) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof zzjm) {
            zzjm zzjmVar = (zzjm) obj;
            int zzbv = zzbv();
            int zzbv2 = zzjmVar.zzbv();
            if (zzbv == 0 || zzbv2 == 0 || zzbv == zzbv2) {
                return zza(zzjmVar, 0, size());
            }
            return false;
        }
        return obj.equals(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjl
    final boolean zza(zzjc zzjcVar, int i, int i2) {
        if (i2 > zzjcVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        }
        if (i2 > zzjcVar.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i2).append(", ").append(zzjcVar.size()).toString());
        }
        if (zzjcVar instanceof zzjm) {
            zzjm zzjmVar = (zzjm) zzjcVar;
            byte[] bArr = this.zzny;
            byte[] bArr2 = zzjmVar.zzny;
            int zzbw = zzbw() + i2;
            int zzbw2 = zzbw();
            int zzbw3 = zzjmVar.zzbw();
            while (zzbw2 < zzbw) {
                if (bArr[zzbw2] != bArr2[zzbw3]) {
                    return false;
                }
                zzbw2++;
                zzbw3++;
            }
            return true;
        }
        return zzjcVar.zza(0, i2).equals(zza(0, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzjc
    protected final int zza(int i, int i2, int i3) {
        return zzkm.zza(i, this.zzny, zzbw(), i3);
    }
}
