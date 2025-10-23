package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzki extends zzhk implements zzin {
    private static final zzki zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzki zzkiVar = new zzki();
        zzb = zzkiVar;
        zzhk.zzx(zzki.class, zzkiVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzki() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzC(zzki zzkiVar, String str) {
        zzkiVar.zzd |= 8;
        zzkiVar.zzh = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzD(zzki zzkiVar, String str) {
        str.getClass();
        zzkiVar.zzd |= 2;
        zzkiVar.zzf = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzE(zzki zzkiVar, int i) {
        zzkiVar.zzd |= 1;
        zzkiVar.zze = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void zzF(zzki zzkiVar, int i) {
        zzkiVar.zzg = i - 1;
        zzkiVar.zzd |= 4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzke zzc() {
        return (zzke) zzb.zzm();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzhk
    protected final Object zzd(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzu(zzb, "\u0004\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", zzkf.zza, "zzh"});
        }
        if (i2 == 3) {
            return new zzki();
        }
        zzkh zzkhVar = null;
        if (i2 == 4) {
            return new zzke(zzkhVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
