package com.unity3d.player;

import android.view.SurfaceHolder;

/* renamed from: com.unity3d.player.h0 */
/* loaded from: classes3.dex */
final class SurfaceHolderCallbackC2731h0 implements SurfaceHolder.Callback {

    /* renamed from: a */
    final /* synthetic */ C2734i0 f1375a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SurfaceHolderCallbackC2731h0(C2734i0 c2734i0) {
        this.f1375a = c2734i0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        unityPlayer = this.f1375a.f1379b;
        unityPlayer.updateGLDisplay(0, surfaceHolder.getSurface());
        unityPlayer2 = this.f1375a.f1379b;
        unityPlayer2.sendSurfaceChangedEvent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        UnityPlayer unityPlayer;
        C2671K c2671k;
        UnityPlayer unityPlayer2;
        unityPlayer = this.f1375a.f1379b;
        unityPlayer.updateGLDisplay(0, surfaceHolder.getSurface());
        C2734i0 c2734i0 = this.f1375a;
        c2671k = c2734i0.f1380c;
        unityPlayer2 = c2734i0.f1379b;
        PixelCopyOnPixelCopyFinishedListenerC2669J pixelCopyOnPixelCopyFinishedListenerC2669J = c2671k.f1183b;
        if (pixelCopyOnPixelCopyFinishedListenerC2669J == null || pixelCopyOnPixelCopyFinishedListenerC2669J.getParent() != null) {
            return;
        }
        unityPlayer2.addView(c2671k.f1183b);
        unityPlayer2.bringChildToFront(c2671k.f1183b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C2671K c2671k;
        C2724f c2724f;
        UnityPlayer unityPlayer;
        C2734i0 c2734i0 = this.f1375a;
        c2671k = c2734i0.f1380c;
        c2724f = c2734i0.f1378a;
        c2671k.getClass();
        if (PlatformSupport.NOUGAT_SUPPORT && c2671k.f1182a != null) {
            if (c2671k.f1183b == null) {
                c2671k.f1183b = new PixelCopyOnPixelCopyFinishedListenerC2669J(c2671k.f1182a);
            }
            c2671k.f1183b.m734a(c2724f);
        }
        unityPlayer = this.f1375a.f1379b;
        unityPlayer.updateGLDisplay(0, null);
    }
}
