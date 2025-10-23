package com.google.android.gms.measurement.internal;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.internal.zzif;
import java.util.EnumMap;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzah {
    private final EnumMap<zzif.zza, zzak> zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzak zza(zzif.zza zzaVar) {
        zzak zzakVar = this.zza.get(zzaVar);
        return zzakVar == null ? zzak.UNSET : zzakVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzah zza(String str) {
        EnumMap enumMap = new EnumMap(zzif.zza.class);
        if (str.length() >= zzif.zza.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzif.zza[] values = zzif.zza.values();
                int length = values.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put((EnumMap) values[i], (zzif.zza) zzak.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzah(enumMap);
            }
        }
        return new zzah();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        char c;
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (zzif.zza zzaVar : zzif.zza.values()) {
            zzak zzakVar = this.zza.get(zzaVar);
            if (zzakVar == null) {
                zzakVar = zzak.UNSET;
            }
            c = zzakVar.zzk;
            sb.append(c);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzah() {
        this.zza = new EnumMap<>(zzif.zza.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzah(EnumMap<zzif.zza, zzak> enumMap) {
        EnumMap<zzif.zza, zzak> enumMap2 = new EnumMap<>((Class<zzif.zza>) zzif.zza.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzif.zza zzaVar, int i) {
        zzak zzakVar = zzak.UNSET;
        if (i == -30) {
            zzakVar = zzak.TCF;
        } else {
            if (i != -20) {
                if (i == -10) {
                    zzakVar = zzak.MANIFEST;
                } else if (i != 0) {
                    if (i == 30) {
                        zzakVar = zzak.INITIALIZATION;
                    }
                }
            }
            zzakVar = zzak.API;
        }
        this.zza.put((EnumMap<zzif.zza, zzak>) zzaVar, (zzif.zza) zzakVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzif.zza zzaVar, zzak zzakVar) {
        this.zza.put((EnumMap<zzif.zza, zzak>) zzaVar, (zzif.zza) zzakVar);
    }
}
