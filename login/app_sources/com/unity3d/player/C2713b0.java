package com.unity3d.player;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.EditText;

/* renamed from: com.unity3d.player.b0 */
/* loaded from: classes3.dex */
final class C2713b0 extends EditText {

    /* renamed from: a */
    final /* synthetic */ AbstractC2687S f1337a;

    /* renamed from: b */
    final /* synthetic */ C2716c0 f1338b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2713b0(C2716c0 c2716c0, Context context, AbstractC2687S abstractC2687S) {
        super(context);
        this.f1338b = c2716c0;
        this.f1337a = abstractC2687S;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (keyEvent.getAction() == 1) {
                this.f1338b.f1344h.onBackPressed();
            }
            return true;
        }
        if (i == 84) {
            return true;
        }
        if (i == 66 && keyEvent.getAction() == 0 && (getInputType() & 131072) == 0) {
            AbstractC2687S abstractC2687S = this.f1337a;
            abstractC2687S.m748a(abstractC2687S.m750b(), false);
            return true;
        }
        if (i != 111 || keyEvent.getAction() != 0) {
            return super.onKeyPreIme(i, keyEvent);
        }
        AbstractC2687S abstractC2687S2 = this.f1337a;
        abstractC2687S2.m748a(abstractC2687S2.m750b(), true);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            requestFocus();
            this.f1337a.m754f();
        }
    }
}
