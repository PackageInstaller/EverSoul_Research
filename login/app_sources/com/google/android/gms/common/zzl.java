package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
abstract class zzl extends zzj {
    private static final WeakReference zza = new WeakReference(null);
    private WeakReference zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzl(byte[] bArr) {
        super(bArr);
        this.zzb = zza;
    }

    protected abstract byte[] zzb();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.zzj
    final byte[] zzf() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.zzb.get();
            if (bArr == null) {
                bArr = zzb();
                this.zzb = new WeakReference(bArr);
            }
        }
        return bArr;
    }
}
