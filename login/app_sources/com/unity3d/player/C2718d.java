package com.unity3d.player;

import android.window.OnBackInvokedCallback;
import com.unity3d.player.p030a.InterfaceC2706c;

/* renamed from: com.unity3d.player.d */
/* loaded from: classes3.dex */
final class C2718d implements OnBackInvokedCallback {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2706c f1346a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2718d(InterfaceC2706c interfaceC2706c) {
        this.f1346a = interfaceC2706c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        Runnable runnable = ((C2652B) this.f1346a).f1148a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
