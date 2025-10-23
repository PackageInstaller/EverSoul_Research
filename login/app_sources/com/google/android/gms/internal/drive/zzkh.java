package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class zzkh extends zziw<Float> implements zzkp<Float>, zzmc, RandomAccess {
    private static final zzkh zzrm;
    private int size;
    private float[] zzrn;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkh() {
        this(new float[10], 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkh(float[] fArr, int i) {
        this.zzrn = fArr;
        this.size = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzbq();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.zzrn;
        System.arraycopy(fArr, i2, fArr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkh)) {
            return super.equals(obj);
        }
        zzkh zzkhVar = (zzkh) obj;
        if (this.size != zzkhVar.size) {
            return false;
        }
        float[] fArr = zzkhVar.zzrn;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzrn[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzrn[i2]);
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc(float f) {
        zzc(this.size, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzc(int i, float f) {
        int i2;
        zzbq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
        float[] fArr = this.zzrn;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzrn, i, fArr2, i + 1, this.size - i);
            this.zzrn = fArr2;
        }
        this.zzrn[i] = f;
        this.size++;
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzkh)) {
            return super.addAll(collection);
        }
        zzkh zzkhVar = (zzkh) collection;
        int i = zzkhVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.zzrn;
        if (i3 > fArr.length) {
            this.zzrn = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(zzkhVar.zzrn, 0, this.zzrn, this.size, zzkhVar.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzrn[i]))) {
                float[] fArr = this.zzrn;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzp(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zzq(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbq();
        zzp(i);
        float[] fArr = this.zzrn;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzp(i);
        float[] fArr = this.zzrn;
        float f = fArr[i];
        if (i < this.size - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp<Float> zzr(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzkh(Arrays.copyOf(this.zzrn, i), this.size);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzp(i);
        return Float.valueOf(this.zzrn[i]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzkh zzkhVar = new zzkh(new float[0], 0);
        zzrm = zzkhVar;
        zzkhVar.zzbp();
    }
}
