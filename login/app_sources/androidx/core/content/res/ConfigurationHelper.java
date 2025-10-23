package androidx.core.content.res;

import android.content.res.Resources;

/* loaded from: classes.dex */
public final class ConfigurationHelper {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConfigurationHelper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getDensityDpi(Resources resources) {
        return resources.getConfiguration().densityDpi;
    }
}
