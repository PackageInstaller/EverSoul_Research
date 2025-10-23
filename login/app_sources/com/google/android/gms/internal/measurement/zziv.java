package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zziv {
    private static final zziu<?> zza = new zziw();
    private static final zziu<?> zzb = zzc();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zziu<?> zza() {
        zziu<?> zziuVar = zzb;
        if (zziuVar != null) {
            return zziuVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zziu<?> zzb() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zziu<?> zzc() {
        try {
            return (zziu) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
