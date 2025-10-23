package com.google.android.gms.games;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class PageDirection {
    public static final int NEXT = 0;
    public static final int NONE = -1;
    public static final int PREV = 1;

    /* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PageDirection() {
        throw new AssertionError("Uninstantiable");
    }
}
