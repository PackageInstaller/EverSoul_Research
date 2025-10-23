package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
final class zzix {
    private static final Class<?> zzni = zzj("libcore.io.Memory");
    private static final boolean zznj;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzbr() {
        return (zzni == null || zznj) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Class<?> zzbs() {
        return zzni;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> Class<T> zzj(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zznj = zzj("org.robolectric.Robolectric") != null;
    }
}
