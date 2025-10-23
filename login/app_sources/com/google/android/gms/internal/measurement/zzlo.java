package com.google.android.gms.internal.measurement;

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

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
class zzlo<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    private List<zzlv> zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzma zze;
    private Map<K, V> zzf;
    private volatile zzls zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int zza(K k) {
        int size = this.zzb.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzb.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzb.get(i2).getKey());
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzb() {
        return this.zzb.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int zzb = zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb; i2++) {
            i += this.zzb.get(i2).hashCode();
        }
        return this.zzc.size() > 0 ? i + this.zzc.hashCode() : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzb.size() + this.zzc.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <FieldDescriptorType extends zzja<FieldDescriptorType>> zzlo<FieldDescriptorType, Object> zza(int i) {
        return new zzln(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Iterable<Map.Entry<K, V>> zzc() {
        if (this.zzc.isEmpty()) {
            return zzlu.zza();
        }
        return this.zzc.entrySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzlo<K, V>) comparable);
        if (zza >= 0) {
            return (V) this.zzb.get(zza).getValue();
        }
        return this.zzc.get(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final V zza(K k, V v) {
        zzg();
        int zza = zza((zzlo<K, V>) k);
        if (zza >= 0) {
            return (V) this.zzb.get(zza).setValue(v);
        }
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(zza + 1);
        if (i >= this.zza) {
            return zzf().put(k, v);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzlv remove = this.zzb.remove(i2 - 1);
            zzf().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzb.add(i, new zzlv(this, k, v));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzlo<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzlo<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzc(zza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final V zzc(int i) {
        zzg();
        V v = (V) this.zzb.remove(i).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzf().entrySet().iterator();
            this.zzb.add(new zzlv(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map.Entry<K, V> zzb(int i) {
        return this.zzb.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Set<Map.Entry<K, V>> zzd() {
        if (this.zzg == null) {
            this.zzg = new zzls(this);
        }
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzma(this);
        }
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzlo(int i) {
        this.zza = i;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void zza() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.zzd) {
            return;
        }
        if (this.zzc.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.zzc);
        }
        this.zzc = unmodifiableMap;
        if (this.zzf.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
        }
        this.zzf = unmodifiableMap2;
        this.zzd = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzlo<K, V>) comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlo)) {
            return super.equals(obj);
        }
        zzlo zzloVar = (zzlo) obj;
        int size = size();
        if (size != zzloVar.size()) {
            return false;
        }
        int zzb = zzb();
        if (zzb != zzloVar.zzb()) {
            return entrySet().equals(zzloVar.entrySet());
        }
        for (int i = 0; i < zzb; i++) {
            if (!zzb(i).equals(zzloVar.zzb(i))) {
                return false;
            }
        }
        if (zzb != size) {
            return this.zzc.equals(zzloVar.zzc);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zze() {
        return this.zzd;
    }
}
