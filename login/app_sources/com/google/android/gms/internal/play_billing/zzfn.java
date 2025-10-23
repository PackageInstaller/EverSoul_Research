package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzfn extends zzhk implements zzin {
    private static final zzfn zzb;
    private zzho zzd = zzs();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzfn zzfnVar = new zzfn();
        zzb = zzfnVar;
        zzhk.zzx(zzfn.class, zzfnVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfn() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzfm zza() {
        return (zzfm) zzb.zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzc(zzfn zzfnVar, Iterable iterable) {
        zzho zzhoVar = zzfnVar.zzd;
        if (!zzhoVar.zzc()) {
            int size = zzhoVar.size();
            zzfnVar.zzd = zzhoVar.zzd(size + size);
        }
        zzfv.zzg(iterable, zzfnVar.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzhk
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzfl.class});
        }
        if (i2 == 3) {
            return new zzfn();
        }
        zzfo zzfoVar = null;
        if (i2 == 4) {
            return new zzfm(zzfoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
