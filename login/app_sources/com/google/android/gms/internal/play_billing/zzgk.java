package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public abstract class zzgk implements Iterable, Serializable {
    public static final zzgk zzb = new zzgi(zzhp.zzb);
    private int zza = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        int i = zzfy.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgk() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzgk zzj(byte[] bArr, int i, int i2) {
        zzh(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzgi(bArr2);
    }

    public abstract boolean equals(Object obj);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int i = this.zza;
        if (i == 0) {
            int zzd = zzd();
            i = zze(zzd, 0, zzd);
            if (i == 0) {
                i = 1;
            }
            this.zza = i;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgd(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzjh.zza(this) : zzjh.zza(zzf(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    abstract byte zzb(int i);

    public abstract int zzd();

    protected abstract int zze(int i, int i2, int i3);

    public abstract zzgk zzf(int i, int i2);

    abstract void zzg(zzgc zzgcVar) throws IOException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int zzi() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzh(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
