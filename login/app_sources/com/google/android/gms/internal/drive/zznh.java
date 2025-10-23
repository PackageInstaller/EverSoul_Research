package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
abstract class zznh {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zznh() {
    }

    abstract int zzb(int i, byte[] bArr, int i2, int i3);

    abstract int zzb(CharSequence charSequence, byte[] bArr, int i, int i2);

    abstract String zzg(byte[] bArr, int i, int i2) throws zzkq;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zze(byte[] bArr, int i, int i2) {
        return zzb(0, bArr, i, i2) == 0;
    }
}
