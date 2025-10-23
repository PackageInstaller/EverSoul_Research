package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
public abstract class zze extends zzb implements zzf {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.inappreview.protocol.IInAppReviewService");
        return queryLocalInterface instanceof zzf ? (zzf) queryLocalInterface : new zzd(iBinder);
    }
}
