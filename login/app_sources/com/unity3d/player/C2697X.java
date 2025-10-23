package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;

/* renamed from: com.unity3d.player.X */
/* loaded from: classes3.dex */
final class C2697X extends AbstractC2687S {

    /* renamed from: h */
    private boolean f1295h;

    /* renamed from: i */
    private Handler f1296i;

    /* renamed from: j */
    private Runnable f1297j;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2697X(Context context, UnityPlayer unityPlayer) {
        super(context, unityPlayer);
        this.f1295h = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: a */
    public final void mo749a(boolean z) {
        EditText editText;
        int i;
        this.f1257d = z;
        if (z) {
            editText = this.f1256c;
            i = 4;
        } else {
            editText = this.f1256c;
            i = 0;
        }
        editText.setVisibility(i);
        this.f1256c.invalidate();
        this.f1256c.requestLayout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: c */
    public final void mo751c() {
        Runnable runnable;
        Handler handler = this.f1296i;
        if (handler != null && (runnable = this.f1297j) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f1255b.removeView(this.f1256c);
        this.f1295h = false;
        invokeOnClose();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    protected EditText createEditText(AbstractC2687S abstractC2687S) {
        return new C2695W(this.f1254a, abstractC2687S);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: d */
    public final boolean mo752d() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.AbstractC2687S
    /* renamed from: e */
    public final void mo753e() {
        if (this.f1295h) {
            return;
        }
        this.f1255b.addView(this.f1256c);
        this.f1255b.bringChildToFront(this.f1256c);
        this.f1256c.setVisibility(0);
        this.f1256c.requestFocus();
        this.f1297j = new RunnableC2693V(this);
        Handler handler = new Handler(Looper.getMainLooper());
        this.f1296i = handler;
        handler.postDelayed(this.f1297j, 400L);
        this.f1295h = true;
    }
}
