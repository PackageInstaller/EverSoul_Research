package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.measurement.internal.zzif;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzav {
    public static final zzav zza = new zzav((Boolean) null, 100);
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap<zzif.zza, Boolean> zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        Boolean bool = this.zzd;
        int i = bool == null ? 3 : bool == Boolean.TRUE ? 7 : 13;
        String str = this.zze;
        return this.zzc.hashCode() + (i * 29) + ((str == null ? 17 : str.hashCode()) * 137);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry<zzif.zza, Boolean> entry : this.zzf.entrySet()) {
            Boolean value = entry.getValue();
            if (value != null) {
                bundle.putString(entry.getKey().zze, zzif.zza(value.booleanValue()));
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzav zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzav((Boolean) null, i);
        }
        EnumMap enumMap = new EnumMap(zzif.zza.class);
        for (zzif.zza zzaVar : zzie.DMA.zza()) {
            enumMap.put((EnumMap) zzaVar, (zzif.zza) zzif.zzb(bundle.getString(zzaVar.zze)));
        }
        return new zzav((EnumMap<zzif.zza, Boolean>) enumMap, i, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzav zza(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] split = str.split(CertificateUtil.DELIMITER);
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(zzif.zza.class);
        zzif.zza[] zza2 = zzie.DMA.zza();
        int length = zza2.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            enumMap.put((EnumMap) zza2[i2], (zzif.zza) zzif.zza(split[i].charAt(0)));
            i2++;
            i++;
        }
        return new zzav((EnumMap<zzif.zza, Boolean>) enumMap, parseInt);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Boolean zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return zzif.zzb(bundle.getString("ad_personalization"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean zzc() {
        return this.zzf.get(zzif.zza.AD_USER_DATA);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean zzd() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zzh() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzif.zza zzaVar : zzie.DMA.zza()) {
            sb.append(CertificateUtil.DELIMITER);
            sb.append(zzif.zza(this.zzf.get(zzaVar)));
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zze() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzf() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        StringBuilder append = new StringBuilder("source=").append(zzif.zza(this.zzb));
        for (zzif.zza zzaVar : zzie.DMA.zza()) {
            append.append(",");
            append.append(zzaVar.zze);
            append.append("=");
            Boolean bool = this.zzf.get(zzaVar);
            if (bool == null) {
                append.append("uninitialized");
            } else {
                append.append(bool.booleanValue() ? "granted" : "denied");
            }
        }
        if (this.zzd != null) {
            append.append(",isDmaRegion=").append(this.zzd);
        }
        if (this.zze != null) {
            append.append(",cpsDisplayStr=").append(this.zze);
        }
        return append.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzav(Boolean bool, int i) {
        this(bool, i, (Boolean) null, (String) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzav(EnumMap<zzif.zza, Boolean> enumMap, int i) {
        this(enumMap, i, (Boolean) null, (String) null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzav(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap<zzif.zza, Boolean> enumMap = new EnumMap<>((Class<zzif.zza>) zzif.zza.class);
        this.zzf = enumMap;
        enumMap.put((EnumMap<zzif.zza, Boolean>) zzif.zza.AD_USER_DATA, (zzif.zza) bool);
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool2;
        this.zze = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzav(EnumMap<zzif.zza, Boolean> enumMap, int i, Boolean bool, String str) {
        EnumMap<zzif.zza, Boolean> enumMap2 = new EnumMap<>((Class<zzif.zza>) zzif.zza.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzc = zzh();
        this.zzd = bool;
        this.zze = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzavVar = (zzav) obj;
        if (this.zzc.equalsIgnoreCase(zzavVar.zzc) && Objects.equals(this.zzd, zzavVar.zzd)) {
            return Objects.equals(this.zze, zzavVar.zze);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzg() {
        Iterator<Boolean> it = this.zzf.values().iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                return true;
            }
        }
        return false;
    }
}
