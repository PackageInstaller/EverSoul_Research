package com.kakao.sdk.friend.p017f;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.f.d */
/* loaded from: classes3.dex */
public final class C2160d {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final int m519a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ActivityManager activityManager = (ActivityManager) ContextCompat.getSystemService(context, ActivityManager.class);
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        Intrinsics.checkNotNull(activityManager);
        return (int) (((z ? activityManager.getLargeMemoryClass() : activityManager.getMemoryClass()) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) / 7);
    }
}
