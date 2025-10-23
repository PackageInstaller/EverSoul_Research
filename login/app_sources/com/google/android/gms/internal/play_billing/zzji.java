package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzji extends RuntimeException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzji(zzim zzimVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzhr zza() {
        return new zzhr(getMessage());
    }
}
