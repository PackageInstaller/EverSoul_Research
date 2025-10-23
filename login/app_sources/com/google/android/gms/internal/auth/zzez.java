package com.google.android.gms.internal.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzez extends zzdn<String> implements RandomAccess, zzfa {
    public static final zzfa zza;
    private static final zzez zzb;
    private final List<Object> zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzez zzezVar = new zzez(10);
        zzb = zzezVar;
        zzezVar.zzb();
        zza = zzezVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzez() {
        this(10);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String zzh(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzeb ? ((zzeb) obj).zzm(zzev.zza) : zzev.zzh((byte[]) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzfa) {
            collection = ((zzfa) collection).zzg();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zzh(remove);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzh(this.zzc.set(i, (String) obj));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzeu
    public final /* bridge */ /* synthetic */ zzeu zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzez((ArrayList<Object>) arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfa
    public final zzfa zze() {
        return zzc() ? new zzgu(this) : this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeb) {
            zzeb zzebVar = (zzeb) obj;
            String zzm = zzebVar.zzm(zzev.zza);
            if (zzebVar.zzh()) {
                this.zzc.set(i, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzev.zzh(bArr);
        if (zzev.zzi(bArr)) {
            this.zzc.set(i, zzh);
        }
        return zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfa
    public final List<?> zzg() {
        return Collections.unmodifiableList(this.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzez(int i) {
        this.zzc = new ArrayList(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzez(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzdn, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
