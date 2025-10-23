package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes2.dex */
final class zzl extends zzk {
    private final char zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzl(char c) {
        this.zza = c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        int i = this.zza;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        return "CharMatcher.is('" + String.copyValueOf(cArr) + "')";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.common.zzo
    public final boolean zza(char c) {
        return c == this.zza;
    }
}
