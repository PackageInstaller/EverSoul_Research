package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.LocaleList;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LocaleManagerCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LocaleManagerCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat getSystemLocales(Context context) {
        LocaleListCompat emptyLocaleList = LocaleListCompat.getEmptyLocaleList();
        if (BuildCompat.isAtLeastT()) {
            Object localeManagerForApplication = getLocaleManagerForApplication(context);
            return localeManagerForApplication != null ? LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(localeManagerForApplication)) : emptyLocaleList;
        }
        return getConfigurationLocales(context.getApplicationContext().getResources().getConfiguration());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Object getLocaleManagerForApplication(Context context) {
        return context.getSystemService("locale");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static LocaleListCompat getConfigurationLocales(Configuration configuration) {
        return Api24Impl.getLocales(configuration);
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }
    }

    static class Api33Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api33Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static LocaleList localeManagerGetSystemLocales(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }
}
