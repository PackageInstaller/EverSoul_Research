package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;

/* renamed from: com.unity3d.player.i0 */
/* loaded from: classes3.dex */
final class C2734i0 extends FrameLayout {

    /* renamed from: a */
    private C2724f f1378a;

    /* renamed from: b */
    private UnityPlayer f1379b;

    /* renamed from: c */
    private C2671K f1380c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2734i0(Context context, UnityPlayer unityPlayer) {
        super(context);
        int i;
        this.f1380c = new C2671K(context);
        this.f1379b = unityPlayer;
        C2724f c2724f = new C2724f(context, unityPlayer);
        this.f1378a = c2724f;
        c2724f.setId(context.getResources().getIdentifier("unitySurfaceView", "id", context.getPackageName()));
        if (m793a()) {
            this.f1378a.getHolder().setFormat(-3);
            this.f1378a.setZOrderOnTop(true);
            i = 0;
        } else {
            this.f1378a.getHolder().setFormat(-1);
            i = ViewCompat.MEASURED_STATE_MASK;
        }
        setBackgroundColor(i);
        this.f1378a.getHolder().addCallback(new SurfaceHolderCallbackC2731h0(this));
        this.f1378a.setFocusable(true);
        this.f1378a.setFocusableInTouchMode(true);
        this.f1378a.setContentDescription(m792a(context));
        addView(this.f1378a, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static String m792a(Context context) {
        return context.getResources().getString(context.getResources().getIdentifier("game_view_content_description", TypedValues.Custom.S_STRING, context.getPackageName()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static boolean m793a() {
        Activity activity = UnityPlayer.currentActivity;
        if (activity == null) {
            return false;
        }
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    final void m794a(float f) {
        this.f1378a.m785a(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m795b() {
        C2671K c2671k = this.f1380c;
        UnityPlayer unityPlayer = this.f1379b;
        PixelCopyOnPixelCopyFinishedListenerC2669J pixelCopyOnPixelCopyFinishedListenerC2669J = c2671k.f1183b;
        if (pixelCopyOnPixelCopyFinishedListenerC2669J != null && pixelCopyOnPixelCopyFinishedListenerC2669J.getParent() != null) {
            unityPlayer.removeView(c2671k.f1183b);
        }
        this.f1380c.f1183b = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final boolean m796c() {
        C2724f c2724f = this.f1378a;
        return c2724f != null && c2724f.m786a();
    }
}
