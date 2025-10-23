package com.kakao.sdk.friend.p024m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.m.v */
/* loaded from: classes3.dex */
public abstract class AbstractRunnableC2219v implements Runnable {

    /* renamed from: a */
    public Context f907a;

    /* renamed from: b */
    public WindowManager f908b;

    /* renamed from: c */
    public View f909c;

    /* renamed from: d */
    public final Handler f910d = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    public int f911e;

    /* renamed from: f */
    public int f912f;

    /* renamed from: g */
    public WindowManager.LayoutParams f913g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final View m595a(int i) {
        View view = this.f909c;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogPosition");
            view = null;
        }
        View findViewById = view.findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "dialogPosition.findViewById(id)");
        return findViewById;
    }

    /* renamed from: a */
    public abstract void mo596a();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m597b(int i) {
        View view = this.f909c;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogPosition");
            view = null;
        }
        view.setVisibility(i);
        if (i != 0) {
            if (i == 4 || i == 8) {
                try {
                    WindowManager windowManager = this.f908b;
                    Intrinsics.checkNotNull(windowManager);
                    View view3 = this.f909c;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("dialogPosition");
                    } else {
                        view2 = view3;
                    }
                    windowManager.removeView(view2);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            return;
        }
        try {
            WindowManager windowManager2 = this.f908b;
            Intrinsics.checkNotNull(windowManager2);
            View view4 = this.f909c;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogPosition");
                view4 = null;
            }
            windowManager2.addView(view4, this.f913g);
        } catch (WindowManager.BadTokenException e) {
            SdkLog.INSTANCE.m470e(e);
        } catch (IllegalStateException unused2) {
            WindowManager windowManager3 = this.f908b;
            Intrinsics.checkNotNull(windowManager3);
            View view5 = this.f909c;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogPosition");
            } else {
                view2 = view5;
            }
            windowManager3.updateViewLayout(view2, this.f913g);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        mo596a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static void m594a(AbstractRunnableC2219v abstractRunnableC2219v, Context context, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        abstractRunnableC2219v.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        abstractRunnableC2219v.f907a = context;
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            View view = null;
            View inflate = ((LayoutInflater) systemService).inflate(i, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(resId, null)");
            abstractRunnableC2219v.f909c = inflate;
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogPosition");
            } else {
                view = inflate;
            }
            view.setVisibility(4);
            abstractRunnableC2219v.f911e = i2;
            abstractRunnableC2219v.f912f = i3;
            Context context2 = abstractRunnableC2219v.f907a;
            Intrinsics.checkNotNull(context2);
            Object systemService2 = context2.getSystemService("window");
            if (systemService2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
            abstractRunnableC2219v.f908b = (WindowManager) systemService2;
            abstractRunnableC2219v.f913g = new WindowManager.LayoutParams(-2, -2, abstractRunnableC2219v.f911e, abstractRunnableC2219v.f912f, 2, 24, -3);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }
}
