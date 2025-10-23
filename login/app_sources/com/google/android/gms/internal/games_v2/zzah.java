package com.google.android.gms.internal.games_v2;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzah {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zza(int i) {
        if (i == 0) {
            return "DAILY";
        }
        if (i == 1) {
            return "WEEKLY";
        }
        if (i == 2) {
            return "ALL_TIME";
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Unknown time span ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
