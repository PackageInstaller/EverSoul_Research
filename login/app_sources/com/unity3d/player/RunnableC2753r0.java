package com.unity3d.player;

import android.widget.EditText;

/* renamed from: com.unity3d.player.r0 */
/* loaded from: classes3.dex */
final class RunnableC2753r0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f1439a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1440b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2753r0(UnityPlayer unityPlayer, String str) {
        this.f1440b = unityPlayer;
        this.f1439a = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        EditText editText;
        AbstractC2687S abstractC2687S = this.f1440b.mSoftInput;
        if (abstractC2687S == null || (str = this.f1439a) == null || (editText = abstractC2687S.f1256c) == null) {
            return;
        }
        editText.setText(str);
        abstractC2687S.f1256c.setSelection(str.length());
    }
}
