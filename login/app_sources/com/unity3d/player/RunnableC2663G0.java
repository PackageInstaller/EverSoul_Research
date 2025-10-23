package com.unity3d.player;

import android.app.Activity;

/* renamed from: com.unity3d.player.G0 */
/* loaded from: classes3.dex */
final class RunnableC2663G0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1164a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1165b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2663G0(UnityPlayer unityPlayer, int i) {
        this.f1165b = unityPlayer;
        this.f1164a = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        try {
            UnityPlayer unityPlayer = this.f1165b;
            activity = unityPlayer.mActivity;
            AbstractC2715c.m780a(activity, unityPlayer, this.f1164a);
        } catch (Exception e) {
            AbstractC2768z.Log(6, "Exception when opening Activity Indicator " + e);
        }
    }
}
