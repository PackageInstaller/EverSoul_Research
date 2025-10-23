package com.unity3d.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.unity3d.player.f */
/* loaded from: classes3.dex */
final class C2724f extends SurfaceView {

    /* renamed from: a */
    private float f1357a;

    /* renamed from: b */
    private UnityPlayer f1358b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2724f(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.f1358b = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m785a(float f) {
        this.f1357a = f;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int i = f <= 0.0f ? -1 : -2;
        layoutParams.width = i;
        layoutParams.height = i;
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m786a() {
        return this.f1357a > 0.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (m786a()) {
            return this.f1358b.injectEvent(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f1357a <= 0.0f) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size <= 0 || size2 <= 0 || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE || View.MeasureSpec.getMode(i2) != Integer.MIN_VALUE) {
            super.onMeasure(i, i2);
            return;
        }
        float f = size;
        float f2 = size2;
        float f3 = f / f2;
        float f4 = this.f1357a;
        if (f3 < f4) {
            size2 = (int) (f / f4);
        } else {
            size = (int) (f2 * f4);
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (m786a()) {
            return this.f1358b.injectEvent(motionEvent);
        }
        return false;
    }
}
