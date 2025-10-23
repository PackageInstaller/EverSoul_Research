package com.unity3d.player;

import android.view.WindowManager;

/* renamed from: com.unity3d.player.F0 */
/* loaded from: classes3.dex */
final class RunnableC2661F0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f1162a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1163b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2661F0(UnityPlayer unityPlayer, float f) {
        this.f1163b = unityPlayer;
        this.f1162a = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        WindowManager.LayoutParams attributes = this.f1163b.m_Window.getAttributes();
        attributes.screenBrightness = this.f1162a;
        this.f1163b.m_Window.setAttributes(attributes);
    }
}
