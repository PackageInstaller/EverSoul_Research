package com.unity3d.player;

import android.content.DialogInterface;

/* renamed from: com.unity3d.player.w0 */
/* loaded from: classes3.dex */
final class DialogInterfaceOnClickListenerC2763w0 implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1486a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DialogInterfaceOnClickListenerC2763w0(UnityPlayer unityPlayer) {
        this.f1486a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1486a.finish();
    }
}
