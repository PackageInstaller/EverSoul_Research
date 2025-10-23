package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzjy extends zzho<String> implements zzjx, RandomAccess {
    private static final zzjy zza;

    @Deprecated
    private static final zzjx zzb;
    private final List<Object> zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzjn
    public final /* synthetic */ zzjn zza(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzjy((ArrayList<Object>) arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzjx
    /* renamed from: h_ */
    public final zzjx mo172h_() {
        return zzc() ? new zzmj(this) : this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzhu) {
            zzhu zzhuVar = (zzhu) obj;
            String zzc = zzhuVar.zzc();
            if (zzhuVar.zzd()) {
                this.zzc.set(i, zzc);
            }
            return zzc;
        }
        byte[] bArr = (byte[]) obj;
        String zzb2 = zzjh.zzb(bArr);
        if (zzjh.zzc(bArr)) {
            this.zzc.set(i, zzb2);
        }
        return zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzjx
    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zza(remove);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zza(this.zzc.set(i, (String) obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzhu) {
            return ((zzhu) obj).zzc();
        }
        return zzjh.zzb((byte[]) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzjx
    public final List<?> zzb() {
        return Collections.unmodifiableList(this.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzjy zzjyVar = new zzjy(false);
        zza = zzjyVar;
        zzb = zzjyVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzjy() {
        this(10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzjy(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzjy(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzjy(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzjx
    public final void zza(zzhu zzhuVar) {
        zza();
        this.zzc.add(zzhuVar);
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzjx) {
            collection = ((zzjx) collection).zzb();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, com.google.android.gms.internal.measurement.zzjn
    public final /* bridge */ /* synthetic */ boolean zzc() {
        return super.zzc();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzho, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }
}
