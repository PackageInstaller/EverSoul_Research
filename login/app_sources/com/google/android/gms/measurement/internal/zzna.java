package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzna {
    final Context zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzna(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
    }
}
