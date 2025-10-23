package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzhf implements zzik {
    private static final zzhf zza = new zzhf();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzhf() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzhf zza() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzik
    public final zzij zzb(Class cls) {
        if (!zzhk.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
        try {
            return (zzij) zzhk.zzo(cls.asSubclass(zzhk.class)).zzd(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzik
    public final boolean zzc(Class cls) {
        return zzhk.class.isAssignableFrom(cls);
    }
}
