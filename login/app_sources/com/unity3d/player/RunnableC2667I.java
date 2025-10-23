package com.unity3d.player;

import android.os.Build;

/* renamed from: com.unity3d.player.I */
/* loaded from: classes3.dex */
final class RunnableC2667I implements Runnable {

    /* renamed from: a */
    private IPermissionRequestCallbacks f1176a;

    /* renamed from: b */
    private String f1177b;

    /* renamed from: c */
    private int f1178c;

    /* renamed from: d */
    private boolean f1179d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2667I(IPermissionRequestCallbacks iPermissionRequestCallbacks, String str, int i, boolean z) {
        this.f1176a = iPermissionRequestCallbacks;
        this.f1177b = str;
        this.f1178c = i;
        this.f1179d = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1178c;
        if (i != -1) {
            if (i == 0) {
                this.f1176a.onPermissionGranted(this.f1177b);
            }
        } else if (Build.VERSION.SDK_INT >= 30 || this.f1179d) {
            this.f1176a.onPermissionDenied(this.f1177b);
        } else {
            this.f1176a.onPermissionDeniedAndDontAskAgain(this.f1177b);
        }
    }
}
