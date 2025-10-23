package com.google.android.gms.internal.auth;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
class zzgl<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private boolean zzd;
    private volatile zzgk zze;
    private List<zzgi> zzb = Collections.emptyList();
    private Map<K, V> zzc = Collections.emptyMap();
    private Map<K, V> zzf = Collections.emptyMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zzk(K k) {
        int size = this.zzb.size() - 1;
        int i = 0;
        if (size >= 0) {
            int compareTo = k.compareTo(this.zzb.get(size).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.zzb.get(i2).zza());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final V zzl(int i) {
        zzn();
        V v = (V) this.zzb.remove(i).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzm().entrySet().iterator();
            List<zzgi> list = this.zzb;
            Map.Entry<K, V> next = it.next();
            list.add(new zzgi(this, next.getKey(), next.getValue()));
            it.remove();
        }
        return v;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final SortedMap<K, V> zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzgk(this, null);
        }
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgl)) {
            return super.equals(obj);
        }
        zzgl zzglVar = (zzgl) obj;
        int size = size();
        if (size != zzglVar.size()) {
            return false;
        }
        int zzb = zzb();
        if (zzb != zzglVar.zzb()) {
            return entrySet().equals(zzglVar.entrySet());
        }
        for (int i = 0; i < zzb; i++) {
            if (!zzg(i).equals(zzglVar.zzg(i))) {
                return false;
            }
        }
        if (zzb != size) {
            return this.zzc.equals(zzglVar.zzc);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        return zzk >= 0 ? (V) this.zzb.get(zzk).getValue() : this.zzc.get(comparable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int zzb = zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb; i2++) {
            i += this.zzb.get(i2).hashCode();
        }
        return this.zzc.size() > 0 ? i + this.zzc.hashCode() : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return (V) zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void zza() {
        if (this.zzd) {
            return;
        }
        this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
        this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
        this.zzd = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzb() {
        return this.zzb.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Iterable<Map.Entry<K, V>> zzc() {
        return this.zzc.isEmpty() ? zzgh.zza() : this.zzc.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final V put(K k, V v) {
        zzn();
        int zzk = zzk(k);
        if (zzk >= 0) {
            return (V) this.zzb.get(zzk).setValue(v);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(zzk + 1);
        if (i >= this.zza) {
            return zzm().put(k, v);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzgi remove = this.zzb.remove(i2 - 1);
            zzm().put(remove.zza(), remove.getValue());
        }
        this.zzb.add(i, new zzgi(this, k, v));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map.Entry<K, V> zzg(int i) {
        return this.zzb.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzj() {
        return this.zzd;
    }
}
