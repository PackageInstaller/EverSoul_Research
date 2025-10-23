package com.unity3d.player;

import android.widget.EditText;

/* renamed from: com.unity3d.player.u0 */
/* loaded from: classes3.dex */
final class RunnableC2759u0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1448a;

    /* renamed from: b */
    final /* synthetic */ int f1449b;

    /* renamed from: c */
    final /* synthetic */ UnityPlayer f1450c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2759u0(UnityPlayer unityPlayer, int i, int i2) {
        this.f1450c = unityPlayer;
        this.f1448a = i;
        this.f1449b = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        int i;
        AbstractC2687S abstractC2687S = this.f1450c.mSoftInput;
        if (abstractC2687S != null) {
            int i2 = this.f1448a;
            int i3 = this.f1449b;
            EditText editText = abstractC2687S.f1256c;
            if (editText == null || editText.getText().length() < (i = i3 + i2)) {
                return;
            }
            abstractC2687S.f1256c.setSelection(i2, i);
        }
    }
}
