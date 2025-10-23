package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class zzja extends zziw<Boolean> implements zzkp<Boolean>, zzmc, RandomAccess {
    private static final zzja zzno;
    private int size;
    private boolean[] zznp;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzja() {
        this(new boolean[10], 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzja(boolean[] zArr, int i) {
        this.zznp = zArr;
        this.size = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzbq();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.zznp;
        System.arraycopy(zArr, i2, zArr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzja)) {
            return super.equals(obj);
        }
        zzja zzjaVar = (zzja) obj;
        if (this.size != zzjaVar.size) {
            return false;
        }
        boolean[] zArr = zzjaVar.zznp;
        for (int i = 0; i < this.size; i++) {
            if (this.zznp[i] != zArr[i]) {
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
            i = (i * 31) + zzkm.zze(this.zznp[i2]);
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zza(int i, boolean z) {
        int i2;
        zzbq();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzq(i));
        }
        boolean[] zArr = this.zznp;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zznp, i, zArr2, i + 1, this.size - i);
            this.zznp = zArr2;
        }
        this.zznp[i] = z;
        this.size++;
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbq();
        zzkm.checkNotNull(collection);
        if (!(collection instanceof zzja)) {
            return super.addAll(collection);
        }
        zzja zzjaVar = (zzja) collection;
        int i = zzjaVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.zznp;
        if (i3 > zArr.length) {
            this.zznp = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(zzjaVar.zznp, 0, this.zznp, this.size, zzjaVar.size);
        this.size = i3;
        this.modCount++;
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zznp[i]))) {
                boolean[] zArr = this.zznp;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbq();
        zzp(i);
        boolean[] zArr = this.zznp;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzp(i);
        boolean[] zArr = this.zznp;
        boolean z = zArr[i];
        if (i < this.size - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zziw, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zza(i, ((Boolean) obj).booleanValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzkp
    public final /* synthetic */ zzkp<Boolean> zzr(int i) {
        if (i < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzja(Arrays.copyOf(this.zznp, i), this.size);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzp(i);
        return Boolean.valueOf(this.zznp[i]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzja zzjaVar = new zzja(new boolean[0], 0);
        zzno = zzjaVar;
        zzjaVar.zzbp();
    }
}
