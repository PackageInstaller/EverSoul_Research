package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zzmq {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmq() {
    }

    abstract int zza(int i, byte[] bArr, int i2, int i3);

    abstract int zza(String str, byte[] bArr, int i, int i2);

    abstract String zza(byte[] bArr, int i, int i2) throws zzjq;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzb(byte[] bArr, int i, int i2) {
        return zza(0, bArr, i, i2) == 0;
    }
}
