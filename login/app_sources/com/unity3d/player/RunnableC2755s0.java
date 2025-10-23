package com.unity3d.player;

import android.text.InputFilter;
import android.widget.EditText;

/* renamed from: com.unity3d.player.s0 */
/* loaded from: classes3.dex */
final class RunnableC2755s0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1442a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1443b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2755s0(UnityPlayer unityPlayer, int i) {
        this.f1443b = unityPlayer;
        this.f1442a = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        AbstractC2687S abstractC2687S = this.f1443b.mSoftInput;
        if (abstractC2687S != null) {
            int i = this.f1442a;
            EditText editText = abstractC2687S.f1256c;
            if (editText != null) {
                if (i > 0) {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
                } else {
                    editText.setFilters(new InputFilter[0]);
                }
            }
        }
    }
}
