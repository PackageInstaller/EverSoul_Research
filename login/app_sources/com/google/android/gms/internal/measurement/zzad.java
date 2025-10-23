package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzad {
    private static final ImmutableSet<String> zza = ImmutableSet.m265of("_syn", "_err", "_el");
    private String zzb;
    private long zzc;
    private Map<String, Object> zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int hashCode = this.zzb.hashCode() * 31;
        long j = this.zzc;
        return ((hashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.zzd.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long zza() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new zzad(this.zzb, this.zzc, new HashMap(this.zzd));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object zza(String str) {
        if (this.zzd.containsKey(str)) {
            return this.zzd.get(str);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object zza(String str, Object obj, Object obj2) {
        if (zza.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            return ((obj instanceof String) || obj == null) ? obj2 : obj;
        }
        if (obj instanceof Double) {
            return obj2;
        }
        if (obj instanceof Long) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        return obj instanceof String ? obj2.toString() : obj2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzb() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "Event{name='" + this.zzb + "', timestamp=" + this.zzc + ", params=" + String.valueOf(this.zzd) + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> zzc() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzad(String str, long j, Map<String, Object> map) {
        this.zzb = str;
        this.zzc = j;
        HashMap hashMap = new HashMap();
        this.zzd = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzb(String str) {
        this.zzb = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str, Object obj) {
        if (obj == null) {
            this.zzd.remove(str);
        } else {
            this.zzd.put(str, zza(str, this.zzd.get(str), obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzad)) {
            return false;
        }
        zzad zzadVar = (zzad) obj;
        if (this.zzc == zzadVar.zzc && this.zzb.equals(zzadVar.zzb)) {
            return this.zzd.equals(zzadVar.zzd);
        }
        return false;
    }
}
