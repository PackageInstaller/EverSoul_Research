package com.unity3d.player;

import android.content.DialogInterface;

/* renamed from: com.unity3d.player.Y */
/* loaded from: classes3.dex */
final class DialogInterfaceOnDismissListenerC2699Y implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C2716c0 f1299a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DialogInterfaceOnDismissListenerC2699Y(C2716c0 c2716c0) {
        this.f1299a = c2716c0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f1299a.invokeOnClose();
    }
}
