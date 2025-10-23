package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzli<E> extends zzho<E> implements RandomAccess {
    private static final zzli<Object> zza = new zzli<>(new Object[0], 0, false);
    private E[] zzb;
    private int zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzjn
    public final /* synthetic */ zzjn zza(int i) {
        if (i < this.zzc) {
            throw new IllegalArgumentException();
        }
        return new zzli(Arrays.copyOf(this.zzb, i), this.zzc, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> zzli<E> zzd() {
        return (zzli<E>) zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzc(i);
        return this.zzb[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zza();
        zzc(i);
        E[] eArr = this.zzb;
        E e = eArr[i];
        if (i < this.zzc - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        zza();
        zzc(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zzb(int i) {
        return "Index:" + i + ", Size:" + this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzli() {
        this(new Object[10], 0, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzli(E[] eArr, int i, boolean z) {
        super(z);
        this.zzb = eArr;
        this.zzc = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzb(i));
        }
        E[] eArr = this.zzb;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
            this.zzb = eArr2;
        }
        this.zzb[i] = e;
        this.zzc++;
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzc(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzb(i));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        zza();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }
}
