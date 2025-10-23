package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzfl extends zzhk implements zzin {
    private static final zzfl zzb;
    private int zzd;
    private zzfq zze;
    private zzfq zzf;
    private int zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzfl zzflVar = new zzfl();
        zzb = zzflVar;
        zzhk.zzx(zzfl.class, zzflVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzfk zza() {
        return (zzfk) zzb.zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzc(zzfl zzflVar, zzfq zzfqVar) {
        zzfqVar.getClass();
        zzflVar.zze = zzfqVar;
        zzflVar.zzd |= 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzhk
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzft.zza()});
        }
        if (i2 == 3) {
            return new zzfl();
        }
        zzfo zzfoVar = null;
        if (i2 == 4) {
            return new zzfk(zzfoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
