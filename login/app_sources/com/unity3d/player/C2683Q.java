package com.unity3d.player;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.unity3d.player.Q */
/* loaded from: classes3.dex */
final class C2683Q implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC2687S f1220a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2683Q(AbstractC2687S abstractC2687S) {
        this.f1220a = abstractC2687S;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            AbstractC2687S abstractC2687S = this.f1220a;
            abstractC2687S.m748a(abstractC2687S.m750b(), false);
        }
        return false;
    }
}
