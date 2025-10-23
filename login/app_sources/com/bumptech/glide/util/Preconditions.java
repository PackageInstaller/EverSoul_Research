package com.bumptech.glide.util;

import android.text.TextUtils;
import com.liapp.y;
import java.util.Collection;

/* loaded from: classes.dex */
public final class Preconditions {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Preconditions() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(T t) {
        return (T) checkNotNull(t, y.ۮڭڭܬި(862147475));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(y.٬ݯح׭٩(575995166));
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Collection<Y>, Y> T checkNotEmpty(T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException(y.ٲٴݴ״ٰ(1781671184));
        }
        return t;
    }
}
