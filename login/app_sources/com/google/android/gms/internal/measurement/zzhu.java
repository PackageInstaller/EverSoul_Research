package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzhu implements Serializable, Iterable<Byte> {
    public static final zzhu zza = new zzie(zzjh.zzb);
    private static final zzib zzb = new zzih();
    private static final Comparator<zzhu> zzc = new zzhw();
    private int zzd = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i);

    public abstract zzhu zza(int i, int i2);

    protected abstract String zza(Charset charset);

    abstract void zza(zzhv zzhvVar) throws IOException;

    abstract byte zzb(int i);

    public abstract int zzb();

    protected abstract int zzb(int i, int i2, int i3);

    public abstract boolean zzd();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(int i, int i2, int i3) {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int i = this.zzd;
        if (i == 0) {
            int zzb2 = zzb();
            i = zzb(zzb2, 0, zzb2);
            if (i == 0) {
                i = 1;
            }
            this.zzd = i;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int zza() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzid zzc(int i) {
        return new zzid(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzhu zza(byte[] bArr, int i, int i2) {
        zza(i, i + i2, bArr.length);
        return new zzie(zzb.zza(bArr, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzhu zza(String str) {
        return new zzie(str.getBytes(zzjh.zza));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzhu zza(byte[] bArr) {
        return new zzie(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzb());
        if (zzb() <= 50) {
            str = zzme.zza(this);
        } else {
            str = zzme.zza(zza(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzc() {
        return zzb() == 0 ? "" : zza(zzjh.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzhx(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhu() {
    }
}
