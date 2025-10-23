package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class zzjc implements Serializable, Iterable<Byte> {
    public static final zzjc zznq = new zzjm(zzkm.zzsn);
    private static final zzji zznr;
    private static final Comparator<zzjc> zznt;
    private int zzns = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int zza(byte b) {
        return b & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    protected abstract int zza(int i, int i2, int i3);

    public abstract zzjc zza(int i, int i2);

    protected abstract String zza(Charset charset);

    abstract void zza(zzjb zzjbVar) throws IOException;

    public abstract boolean zzbu();

    public abstract byte zzs(int i);

    abstract byte zzt(int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzjc zzb(byte[] bArr, int i, int i2) {
        zzb(i, i + i2, bArr.length);
        return new zzjm(zznr.zzc(bArr, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzjc zzk(String str) {
        return new zzjm(str.getBytes(zzkm.UTF_8));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzbt() {
        return size() == 0 ? "" : zza(zzkm.UTF_8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int i = this.zzns;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzns = i;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjk zzu(int i) {
        return new zzjk(i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int zzbv() {
        return this.zzns;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
        }
        throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i2).append(" >= ").append(i3).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zzjd(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzjd zzjdVar = null;
        zznr = zzix.zzbr() ? new zzjn(zzjdVar) : new zzjg(zzjdVar);
        zznt = new zzje();
    }
}
