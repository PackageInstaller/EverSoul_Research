package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public abstract class ActivityLifecycleObserver {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static final ActivityLifecycleObserver m142of(Activity activity) {
        return new zab(zaa.zaa(activity));
    }

    public abstract ActivityLifecycleObserver onStopCallOnce(Runnable runnable);
}
