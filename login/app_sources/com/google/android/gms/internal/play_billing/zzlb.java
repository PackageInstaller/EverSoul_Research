package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzlb extends zzhk implements zzin {
    private static final zzlb zzb;
    private int zzd;
    private int zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzlb zzlbVar = new zzlb();
        zzb = zzlbVar;
        zzhk.zzx(zzlb.class, zzlbVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzlb() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzC(zzlb zzlbVar, int i) {
        zzlbVar.zze = i - 1;
        zzlbVar.zzd |= 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzky zzc() {
        return (zzky) zzb.zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzhk
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzkz.zza});
        }
        if (i2 == 3) {
            return new zzlb();
        }
        zzla zzlaVar = null;
        if (i2 == 4) {
            return new zzky(zzlaVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
