package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzif {
    public static final zzif zza = new zzif(null, null, 100);
    private final EnumMap<zza, Boolean> zzb;
    private final int zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zza(int i) {
        return i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zza(boolean z) {
        return z ? "granted" : "denied";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zza(int i, int i2) {
        return i <= i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static char zza(Boolean bool) {
        if (bool == null) {
            return '-';
        }
        return bool.booleanValue() ? '1' : '0';
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");

        public final String zze;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        zza(String str) {
            this.zze = str;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzb(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int i = this.zzc * 17;
        Iterator<Boolean> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            i = (i * 31) + zzb(it.next());
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<zza, Boolean> entry : this.zzb.entrySet()) {
            Boolean value = entry.getValue();
            if (value != null) {
                bundle.putString(entry.getKey().zze, zza(value.booleanValue()));
            }
        }
        return bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzif zza(Bundle bundle, int i) {
        zza[] zzaVarArr;
        if (bundle == null) {
            return new zzif(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzie.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            enumMap.put((EnumMap) zzaVar, (zza) zzb(bundle.getString(zzaVar.zze)));
        }
        return new zzif(enumMap, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzif zza(String str) {
        return zza(str, 100);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzif zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str != null) {
            zza[] zza2 = zzie.STORAGE.zza();
            for (int i2 = 0; i2 < zza2.length; i2++) {
                zza zzaVar = zza2[i2];
                int i3 = i2 + 2;
                if (i3 < str.length()) {
                    enumMap.put((EnumMap) zzaVar, (zza) zza(str.charAt(i3)));
                }
            }
        }
        return new zzif(enumMap, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzif zza(zzif zzifVar) {
        zza[] zzaVarArr;
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzie.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            Boolean bool = this.zzb.get(zzaVar);
            Boolean bool2 = zzifVar.zzb.get(zzaVar);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                bool = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
            }
            enumMap.put((EnumMap) zzaVar, (zza) bool);
        }
        return new zzif(enumMap, 100);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzif zzb(zzif zzifVar) {
        zza[] zzaVarArr;
        EnumMap enumMap = new EnumMap(zza.class);
        zzaVarArr = zzie.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            Boolean bool = this.zzb.get(zzaVar);
            if (bool == null) {
                bool = zzifVar.zzb.get(zzaVar);
            }
            enumMap.put((EnumMap) zzaVar, (zza) bool);
        }
        return new zzif(enumMap, this.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Boolean zzb(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Boolean zza(char c) {
        if (c == '0') {
            return Boolean.FALSE;
        }
        if (c != '1') {
            return null;
        }
        return Boolean.TRUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean zzc() {
        return this.zzb.get(zza.AD_STORAGE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean zzd() {
        return this.zzb.get(zza.ANALYTICS_STORAGE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zza(Bundle bundle) {
        zza[] zzaVarArr;
        String string;
        zzaVarArr = zzie.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            if (bundle.containsKey(zzaVar.zze) && (string = bundle.getString(zzaVar.zze)) != null && zzb(string) == null) {
                return string;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zze() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zzaVar : zzie.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zzaVar)));
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzf() {
        char c;
        StringBuilder sb = new StringBuilder("G2");
        for (zza zzaVar : zzie.STORAGE.zza()) {
            Boolean bool = this.zzb.get(zzaVar);
            if (bool == null) {
                c = 'g';
            } else {
                c = bool.booleanValue() ? 'G' : 'D';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        zza[] zzaVarArr;
        StringBuilder append = new StringBuilder("source=").append(zza(this.zzc));
        zzaVarArr = zzie.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            append.append(",");
            append.append(zzaVar.zze);
            append.append("=");
            Boolean bool = this.zzb.get(zzaVar);
            if (bool == null) {
                append.append("uninitialized");
            } else {
                append.append(bool.booleanValue() ? "granted" : "denied");
            }
        }
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzif(EnumMap<zza, Boolean> enumMap, int i) {
        EnumMap<zza, Boolean> enumMap2 = new EnumMap<>((Class<zza>) zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzif(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, Boolean> enumMap = new EnumMap<>((Class<zza>) zza.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap<zza, Boolean>) zza.AD_STORAGE, (zza) bool);
        enumMap.put((EnumMap<zza, Boolean>) zza.ANALYTICS_STORAGE, (zza) bool2);
        this.zzc = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        zza[] zzaVarArr;
        if (!(obj instanceof zzif)) {
            return false;
        }
        zzif zzifVar = (zzif) obj;
        zzaVarArr = zzie.STORAGE.zzd;
        for (zza zzaVar : zzaVarArr) {
            if (zzb(this.zzb.get(zzaVar)) != zzb(zzifVar.zzb.get(zzaVar))) {
                return false;
            }
        }
        return this.zzc == zzifVar.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zzif zzifVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            if (!zzifVar.zza(zzaVar) && zza(zzaVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzg() {
        return zza(zza.AD_STORAGE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zza zzaVar) {
        Boolean bool = this.zzb.get(zzaVar);
        return bool == null || bool.booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzh() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzi() {
        Iterator<Boolean> it = this.zzb.values().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzc(zzif zzifVar) {
        return zzb(zzifVar, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzb(zzif zzifVar, zza... zzaVarArr) {
        for (zza zzaVar : zzaVarArr) {
            Boolean bool = this.zzb.get(zzaVar);
            Boolean bool2 = zzifVar.zzb.get(zzaVar);
            if (bool == Boolean.FALSE && bool2 != Boolean.FALSE) {
                return true;
            }
        }
        return false;
    }
}
