package com.kakao.sdk.friend.p024m;

import android.os.SystemClock;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.m.s */
/* loaded from: classes3.dex */
public final class ViewOnClickListenerC2216s implements View.OnClickListener {

    /* renamed from: a */
    public final View.OnClickListener f901a;

    /* renamed from: b */
    public long f902b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewOnClickListenerC2216s(View.OnClickListener onClickListener, long j) {
        this.f901a = onClickListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.f902b < 500) {
            return;
        }
        View.OnClickListener onClickListener = this.f901a;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this.f902b = uptimeMillis;
    }
}
