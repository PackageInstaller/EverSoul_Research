package com.unity3d.player;

import android.graphics.SurfaceTexture;
import com.unity3d.player.p030a.InterfaceC2705b;

/* renamed from: com.unity3d.player.v */
/* loaded from: classes3.dex */
final class C2760v implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a */
    final /* synthetic */ C2762w f1451a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2760v(C2762w c2762w) {
        this.f1451a = c2762w;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        InterfaceC2705b interfaceC2705b;
        interfaceC2705b = this.f1451a.f1460a;
        ((Camera2Wrapper) interfaceC2705b).m729a(surfaceTexture);
    }
}
