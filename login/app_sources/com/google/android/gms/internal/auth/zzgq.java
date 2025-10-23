package com.google.android.gms.internal.auth;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzgq {
    private static final zzgq zza = new zzgq(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private boolean zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzgq() {
        this(0, new int[8], new Object[8], true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzgq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzgq zza() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzgq zzb(zzgq zzgqVar, zzgq zzgqVar2) {
        int i = zzgqVar.zzb + zzgqVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzgqVar.zzc, i);
        System.arraycopy(zzgqVar2.zzc, 0, copyOf, zzgqVar.zzb, zzgqVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzgqVar.zzd, i);
        System.arraycopy(zzgqVar2.zzd, 0, copyOf2, zzgqVar.zzb, zzgqVar2.zzb);
        return new zzgq(i, copyOf, copyOf2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzgq zzc() {
        return new zzgq(0, new int[8], new Object[8], true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzgq)) {
            return false;
        }
        zzgq zzgqVar = (zzgq) obj;
        int i = this.zzb;
        if (i == zzgqVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzgqVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzgqVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd() {
        this.zze = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zze(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzfs.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zzf(int i, Object obj) {
        if (!this.zze) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.zzb;
        int[] iArr = this.zzc;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.zzc = Arrays.copyOf(iArr, i3);
            this.zzd = Arrays.copyOf(this.zzd, i3);
        }
        int[] iArr2 = this.zzc;
        int i4 = this.zzb;
        iArr2[i4] = i;
        this.zzd[i4] = obj;
        this.zzb = i4 + 1;
    }
}
