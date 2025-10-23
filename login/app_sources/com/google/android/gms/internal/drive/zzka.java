package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
final class zzka {
    private static final zzjy<?> zzoq = new zzjz();
    private static final zzjy<?> zzor = zzck();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static zzjy<?> zzck() {
        try {
            return (zzjy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjy<?> zzcl() {
        return zzoq;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzjy<?> zzcm() {
        zzjy<?> zzjyVar = zzor;
        if (zzjyVar != null) {
            return zzjyVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
