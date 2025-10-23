package com.unity3d.player;

import android.content.DialogInterface;

/* renamed from: com.unity3d.player.a0 */
/* loaded from: classes3.dex */
final class DialogInterfaceOnCancelListenerC2710a0 implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ C2716c0 f1309a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DialogInterfaceOnCancelListenerC2710a0(C2716c0 c2716c0) {
        this.f1309a = c2716c0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        InterfaceC2660F interfaceC2660F = this.f1309a.f1259f;
        if (interfaceC2660F != null) {
            ((C2741l0) interfaceC2660F).m801a();
        }
    }
}
