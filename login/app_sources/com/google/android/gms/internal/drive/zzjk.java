package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
final class zzjk {
    private final byte[] buffer;
    private final zzjr zznx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzjk(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zznx = zzjr.zzb(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzjc zzbx() {
        this.zznx.zzcb();
        return new zzjm(this.buffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzjr zzby() {
        return this.zznx;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzjk(int i, zzjd zzjdVar) {
        this(i);
    }
}
