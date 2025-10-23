package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzgl extends zzgn {
    private int zzb;
    private int zzc;
    private int zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzgl(byte[] bArr, int i, int i2, boolean z, zzgm zzgmVar) {
        super(null);
        this.zzd = Integer.MAX_VALUE;
        this.zzb = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza(int i) throws zzhr {
        int i2 = this.zzd;
        this.zzd = 0;
        int i3 = this.zzb + this.zzc;
        this.zzb = i3;
        if (i3 > 0) {
            this.zzc = i3;
            this.zzb = i3 - i3;
        } else {
            this.zzc = 0;
        }
        return i2;
    }
}
