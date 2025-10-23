package com.unity3d.player;

import android.view.KeyEvent;
import android.view.View;

/* renamed from: com.unity3d.player.b */
/* loaded from: classes3.dex */
final class ViewOnKeyListenerC2712b implements View.OnKeyListener {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewOnKeyListenerC2712b() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return i == 4 && keyEvent.getAction() == 1;
    }
}
