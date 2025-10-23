package com.google.common.base;

import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Objects extends ExtraObjectsMethodsForWeb {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Objects() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean equal(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int hashCode(@CheckForNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
