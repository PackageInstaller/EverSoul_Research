package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzkl extends zzhk implements zzin {
    private static final zzkl zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzkl zzklVar = new zzkl();
        zzb = zzklVar;
        zzhk.zzx(zzkl.class, zzklVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzkl zzB() {
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzhk
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        zzkk zzkkVar = null;
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0000", null);
        }
        if (i2 == 3) {
            return new zzkl();
        }
        if (i2 == 4) {
            return new zzkj(zzkkVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
