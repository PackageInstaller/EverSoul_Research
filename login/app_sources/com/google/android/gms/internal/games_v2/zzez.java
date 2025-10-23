package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.internal.GmsLogger;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzez {
    private static final GmsLogger zza = new GmsLogger("Games");

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(String str, String str2) {
        zza.m143d(zzi(str), str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzb(String str, String str2, Throwable th) {
        zza.m144d(zzi("GamesApiManager"), "Authentication task failed", th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzc(String str, String str2) {
        zza.m145e(zzi(str), str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzd(String str, String str2, Throwable th) {
        zza.m146e(zzi(str), str2, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zze(String str, String str2, Throwable th) {
        zza.m148i(zzi("SnapshotContentsEntity"), "Failed to write snapshot data", th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzf(String str, String str2) {
        zza.m149v(zzi(str), str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzg(String str, String str2) {
        zza.m151w(zzi(str), str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzh(String str, String str2, Throwable th) {
        zza.m152w(zzi(str), str2, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String zzi(String str) {
        return String.format("%s[%s]", "PlayGamesServices", str);
    }
}
