package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzlq extends zzhk implements zzin {
    private static final zzlq zzb;
    private int zzd;
    private zzki zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzlq zzlqVar = new zzlq();
        zzb = zzlqVar;
        zzhk.zzx(zzlq.class, zzlqVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzlq() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzC(zzlq zzlqVar, zzki zzkiVar) {
        zzkiVar.getClass();
        zzlqVar.zze = zzkiVar;
        zzlqVar.zzd |= 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzlo zzc() {
        return (zzlo) zzb.zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzhk
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzlq();
        }
        zzlp zzlpVar = null;
        if (i2 == 4) {
            return new zzlo(zzlpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
