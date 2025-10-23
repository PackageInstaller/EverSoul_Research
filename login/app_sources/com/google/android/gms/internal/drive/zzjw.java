package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
final class zzjw {
    private static final Class<?> zzok = zzce();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Class<?> zzce() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzjx zzcf() {
        if (zzok != null) {
            try {
                return zzn("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzjx.zzoo;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.drive.zzjx zzcg() {
        /*
            java.lang.Class<?> r0 = com.google.android.gms.internal.drive.zzjw.zzok
            if (r0 == 0) goto Lb
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.drive.zzjx r0 = zzn(r0)     // Catch: java.lang.Exception -> Lb
            goto Lc
        Lb:
            r0 = 0
        Lc:
            if (r0 != 0) goto L12
            com.google.android.gms.internal.drive.zzjx r0 = com.google.android.gms.internal.drive.zzjx.zzcg()
        L12:
            if (r0 != 0) goto L18
            com.google.android.gms.internal.drive.zzjx r0 = zzcf()
        L18:
            return r0
            fill-array 0x001a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzjw.zzcg():com.google.android.gms.internal.drive.zzjx");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final zzjx zzn(String str) throws Exception {
        return (zzjx) zzok.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
