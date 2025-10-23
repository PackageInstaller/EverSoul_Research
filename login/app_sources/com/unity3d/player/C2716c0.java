package com.unity3d.player;

import android.content.Context;
import android.widget.EditText;

/* renamed from: com.unity3d.player.c0 */
/* loaded from: classes3.dex */
final class C2716c0 extends AbstractC2687S {

    /* renamed from: h */
    DialogC2691U f1344h;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2716c0(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: a */
    public final void mo747a(String str, int i, boolean z, boolean z2, boolean z3, boolean z4, String str2, int i2, boolean z5, boolean z6) {
        DialogC2691U dialogC2691U = new DialogC2691U(this.f1254a, this.f1255b);
        this.f1344h = dialogC2691U;
        dialogC2691U.m757a(this, z5, z6);
        this.f1344h.setOnDismissListener(new DialogInterfaceOnDismissListenerC2699Y(this));
        super.mo747a(str, i, z, z2, z3, z4, str2, i2, z5, z6);
        this.f1255b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC2701Z(this));
        this.f1256c.requestFocus();
        this.f1344h.setOnCancelListener(new DialogInterfaceOnCancelListenerC2710a0(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: a */
    public final void mo749a(boolean z) {
        this.f1257d = z;
        this.f1344h.m758a(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: c */
    public final void mo751c() {
        this.f1344h.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    protected EditText createEditText(AbstractC2687S abstractC2687S) {
        return new C2713b0(this, this.f1254a, abstractC2687S);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: e */
    public final void mo753e() {
        this.f1344h.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void reportSoftInputArea() {
        if (this.f1344h.isShowing()) {
            this.f1255b.reportSoftInputArea(this.f1344h.m756a());
        }
    }
}
