package com.google.androidgamesdk;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

/* renamed from: com.google.androidgamesdk.c */
/* loaded from: classes2.dex */
final class RunnableC1188c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f279a;

    /* renamed from: b */
    final /* synthetic */ SwappyDisplayManager f280b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC1188c(SwappyDisplayManager swappyDisplayManager, int i) {
        this.f280b = swappyDisplayManager;
        this.f279a = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        activity = this.f280b.mActivity;
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.preferredDisplayModeId = this.f279a;
        window.setAttributes(attributes);
    }
}
