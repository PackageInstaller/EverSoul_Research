package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.unity3d.player.p030a.InterfaceC2706c;
import kotlin.time.DurationKt;

/* renamed from: com.unity3d.player.U */
/* loaded from: classes3.dex */
final class DialogC2691U extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    protected Context f1273a;

    /* renamed from: b */
    protected UnityPlayer f1274b;

    /* renamed from: c */
    protected C2681P f1275c;

    /* renamed from: d */
    protected AbstractC2687S f1276d;

    /* renamed from: e */
    private C2654C f1277e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DialogC2691U(Context context, UnityPlayer unityPlayer) {
        super(context);
        this.f1275c = null;
        this.f1276d = null;
        this.f1277e = null;
        this.f1273a = context;
        this.f1274b = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Rect m756a() {
        Rect rect = new Rect();
        this.f1274b.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        this.f1274b.getLocationOnScreen(iArr);
        Point point = new Point(rect.left - iArr[0], rect.height() - this.f1275c.getHeight());
        Point point2 = new Point();
        getWindow().getWindowManager().getDefaultDisplay().getSize(point2);
        int height = this.f1274b.getHeight();
        int i = height - point2.y;
        int i2 = height - point.y;
        int height2 = this.f1275c.getHeight() + i;
        UnityPlayer unityPlayer = this.f1274b;
        if (i2 != height2) {
            unityPlayer.reportSoftInputIsVisible(true);
        } else {
            unityPlayer.reportSoftInputIsVisible(false);
        }
        return new Rect(point.x, point.y, this.f1275c.getWidth(), i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m757a(AbstractC2687S abstractC2687S, boolean z, boolean z2) {
        this.f1276d = abstractC2687S;
        Window window = getWindow();
        window.requestFeature(1);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        m759b();
        this.f1275c = createSoftInputView(this.f1276d.f1256c);
        window.setLayout(-1, -2);
        window.clearFlags(2);
        window.clearFlags(134217728);
        window.clearFlags(67108864);
        if (!z2) {
            window.addFlags(32);
            window.addFlags(262144);
        }
        m758a(z);
        getWindow().setSoftInputMode(5);
        this.f1277e = C2656D.m731a(this, DurationKt.NANOS_IN_MILLIS, new RunnableC2689T(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m758a(boolean z) {
        C2681P c2681p = this.f1275c;
        if (z) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c2681p.f1212b.getLayoutParams();
            layoutParams.height = 1;
            c2681p.f1212b.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) c2681p.f1211a.getLayoutParams();
            layoutParams2.height = 1;
            c2681p.f1211a.setLayoutParams(layoutParams2);
            Rect rect = c2681p.f1215e;
            c2681p.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            c2681p.setVisibility(4);
        } else {
            c2681p.setVisibility(0);
            Rect rect2 = c2681p.f1214d;
            c2681p.setPadding(rect2.left, rect2.top, rect2.right, rect2.bottom);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) c2681p.f1212b.getLayoutParams();
            layoutParams3.height = -2;
            c2681p.f1212b.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) c2681p.f1211a.getLayoutParams();
            layoutParams4.height = -2;
            c2681p.f1211a.setLayoutParams(layoutParams4);
        }
        c2681p.invalidate();
        c2681p.requestLayout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m759b() {
        ColorDrawable colorDrawable = new ColorDrawable(0);
        if (!PlatformSupport.VANILLA_ICE_CREAM_SUPPORT) {
            getWindow().setBackgroundDrawable(colorDrawable);
            return;
        }
        Insets insets = this.f1274b.getActivity().getWindow().getDecorView().getRootWindowInsets().getInsets(WindowInsets.Type.displayCutout());
        getWindow().setBackgroundDrawable(new InsetDrawable((Drawable) colorDrawable, insets.left, insets.top, insets.right, 0));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected C2681P createSoftInputView(EditText editText) {
        C2681P c2681p = new C2681P(this.f1273a, editText);
        c2681p.f1211a.setOnClickListener(this);
        setContentView(c2681p);
        return c2681p;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f1276d.mo752d() || !(motionEvent.getAction() == 4 || this.f1276d.f1257d)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public final void onBackPressed() {
        Runnable runnable;
        C2654C c2654c = this.f1277e;
        if (c2654c != null) {
            InterfaceC2706c interfaceC2706c = c2654c.f1150a;
            if (!(interfaceC2706c != null) || (runnable = ((C2652B) interfaceC2706c).f1148a) == null) {
                return;
            }
            runnable.run();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AbstractC2687S abstractC2687S = this.f1276d;
        abstractC2687S.m748a(abstractC2687S.m750b(), false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public final void onStop() {
        C2654C c2654c = this.f1277e;
        if (c2654c != null) {
            c2654c.unregisterOnBackPressedCallback();
            this.f1277e = null;
        }
        super.onStop();
    }
}
