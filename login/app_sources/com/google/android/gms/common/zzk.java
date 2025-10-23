package com.google.android.gms.common;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
final class zzk extends zzj {
    private final byte[] zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzk(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.zza = bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.zzj
    final byte[] zzf() {
        return this.zza;
    }
}
