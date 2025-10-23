package com.unity3d.player;

import android.graphics.Rect;

/* renamed from: com.unity3d.player.y0 */
/* loaded from: classes3.dex */
final class C2767y0 extends AbstractRunnableC2694V0 {

    /* renamed from: b */
    final /* synthetic */ Rect f1490b;

    /* renamed from: c */
    final /* synthetic */ UnityPlayer f1491c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2767y0(UnityPlayer unityPlayer, Rect rect) {
        super(unityPlayer);
        this.f1491c = unityPlayer;
        this.f1490b = rect;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractRunnableC2694V0
    /* renamed from: a */
    public final void mo761a() {
        UnityPlayer unityPlayer = this.f1491c;
        Rect rect = this.f1490b;
        unityPlayer.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
    }
}
