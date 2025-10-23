package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class LifecycleActivity {
    private final Object zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LifecycleActivity(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        this.zza = activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Activity zza() {
        return (Activity) this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final FragmentActivity zzb() {
        return (FragmentActivity) this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzc() {
        return this.zza instanceof Activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzd() {
        return this.zza instanceof FragmentActivity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }
}
