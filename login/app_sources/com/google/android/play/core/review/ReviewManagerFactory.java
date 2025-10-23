package com.google.android.play.core.review;

import android.content.Context;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
public class ReviewManagerFactory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ReviewManagerFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ReviewManager create(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return new zzd(new zzi(context));
    }
}
