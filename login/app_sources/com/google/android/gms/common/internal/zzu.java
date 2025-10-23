package com.google.android.gms.common.internal;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzu {
    private static final Uri zza;
    private static final Uri zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        zza = parse;
        zzb = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
