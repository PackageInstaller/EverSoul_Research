package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* renamed from: com.unity3d.player.W */
/* loaded from: classes3.dex */
final class C2695W extends EditText {

    /* renamed from: a */
    final /* synthetic */ AbstractC2687S f1289a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2695W(Context context, AbstractC2687S abstractC2687S) {
        super(context);
        this.f1289a = abstractC2687S;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public final void onEditorAction(int i) {
        if (i == 6) {
            AbstractC2687S abstractC2687S = this.f1289a;
            abstractC2687S.m748a(abstractC2687S.m750b(), false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (keyEvent.getAction() == 1) {
                AbstractC2687S abstractC2687S = this.f1289a;
                abstractC2687S.m748a(abstractC2687S.m750b(), false);
            }
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i != 66 || keyEvent.getAction() != 0 || (getInputType() & 131072) != 0) {
            return super.onKeyPreIme(i, keyEvent);
        }
        AbstractC2687S abstractC2687S2 = this.f1289a;
        abstractC2687S2.m748a(abstractC2687S2.m750b(), false);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        this.f1289a.f1255b.reportSoftInputSelection(i, i2 - i);
    }
}
