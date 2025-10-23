package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class LifecycleCallback {
    protected final LifecycleFragment mLifecycleFragment;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LifecycleFragment getFragment(Activity activity) {
        return getFragment(new LifecycleActivity(activity));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Activity getActivity() {
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        Preconditions.checkNotNull(lifecycleActivity);
        return lifecycleActivity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onCreate(Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDestroy() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onResume() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onSaveInstanceState(Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStart() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onStop() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LifecycleFragment getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static LifecycleFragment getFragment(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.zzd()) {
            return zzd.zzc(lifecycleActivity.zzb());
        }
        if (lifecycleActivity.zzc()) {
            return zzb.zzc(lifecycleActivity.zza());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
