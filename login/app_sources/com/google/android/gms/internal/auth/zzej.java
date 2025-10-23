package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzej {
    private static final zzeh<?> zza = new zzei();
    private static final zzeh<?> zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzeh<?> zzehVar;
        try {
            zzehVar = (zzeh) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzehVar = null;
        }
        zzb = zzehVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzeh<?> zza() {
        zzeh<?> zzehVar = zzb;
        if (zzehVar != null) {
            return zzehVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzeh<?> zzb() {
        return zza;
    }
}
