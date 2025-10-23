package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzmf extends RuntimeException {
    private final List<String> zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzmf(zzkr zzkrVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zza = null;
    }
}
