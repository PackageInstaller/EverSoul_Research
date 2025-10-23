package com.unity3d.player;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/* renamed from: com.unity3d.player.c */
/* loaded from: classes3.dex */
abstract class AbstractC2715c {

    /* renamed from: a */
    private static final int[] f1340a = {android.R.attr.progressBarStyleLarge, android.R.attr.progressBarStyleLargeInverse, android.R.attr.progressBarStyleSmall, android.R.attr.progressBarStyleSmallInverse};

    /* renamed from: b */
    private static ProgressBar f1341b = null;

    /* renamed from: c */
    private static View f1342c = null;

    /* renamed from: d */
    private static int f1343d = -1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static void m779a() {
        ProgressBar progressBar = f1341b;
        if (progressBar != null) {
            if (progressBar != null && f1342c != null) {
                ViewGroup viewGroup = (ViewGroup) progressBar.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(f1341b);
                    viewGroup.removeView(f1342c);
                }
                f1341b = null;
                f1342c = null;
            }
            f1343d = -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static void m780a(Activity activity, UnityPlayer unityPlayer, int i) {
        if (i >= 0) {
            int[] iArr = f1340a;
            if (i >= 4) {
                return;
            }
            if (unityPlayer == null) {
                throw new IllegalArgumentException("ViewGroup cannot be null.");
            }
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            if (f1341b != null) {
                if (f1343d == i) {
                    return;
                } else {
                    m779a();
                }
            }
            f1343d = i;
            ProgressBar progressBar = new ProgressBar(activity, null, iArr[i]);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            progressBar.setLayoutParams(layoutParams);
            progressBar.setBackground(new ColorDrawable(0));
            progressBar.setIndeterminate(true);
            f1341b = progressBar;
            View view = new View(activity);
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            view.setBackgroundColor(0);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            view.setOnTouchListener(new ViewOnTouchListenerC2703a());
            view.setOnKeyListener(new ViewOnKeyListenerC2712b());
            f1342c = view;
            unityPlayer.addView(view);
            unityPlayer.addView(f1341b);
        }
    }
}
