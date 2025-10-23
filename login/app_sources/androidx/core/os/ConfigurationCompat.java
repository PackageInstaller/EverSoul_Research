package androidx.core.os;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: classes.dex */
public final class ConfigurationCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConfigurationCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat getLocales(Configuration configuration) {
        return LocaleListCompat.wrap(Api24Impl.getLocales(configuration));
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static LocaleList getLocales(Configuration configuration) {
            return configuration.getLocales();
        }
    }
}
