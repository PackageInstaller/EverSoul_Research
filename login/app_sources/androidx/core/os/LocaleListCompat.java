package androidx.core.os;

import android.os.LocaleList;
import androidx.core.text.ICUCompat;
import java.util.Locale;

/* loaded from: classes.dex */
public final class LocaleListCompat {
    private static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
    private final LocaleListInterface mImpl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LocaleListCompat(LocaleListInterface localeListInterface) {
        this.mImpl = localeListInterface;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static LocaleListCompat wrap(Object obj) {
        return wrap((LocaleList) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat wrap(LocaleList localeList) {
        return new LocaleListCompat(new LocaleListPlatformWrapper(localeList));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object unwrap() {
        return this.mImpl.getLocaleList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat create(Locale... localeArr) {
        return wrap(Api24Impl.createLocaleList(localeArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Locale get(int i) {
        return this.mImpl.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEmpty() {
        return this.mImpl.isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int size() {
        return this.mImpl.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int indexOf(Locale locale) {
        return this.mImpl.indexOf(locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toLanguageTags() {
        return this.mImpl.toLanguageTags();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Locale getFirstMatch(String[] strArr) {
        return this.mImpl.getFirstMatch(strArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat getEmptyLocaleList() {
        return sEmptyLocaleList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat forLanguageTags(String str) {
        if (str == null || str.isEmpty()) {
            return getEmptyLocaleList();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = Api21Impl.forLanguageTag(split[i]);
        }
        return create(localeArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Locale forLanguageTagCompat(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (str.contains("_")) {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        } else {
            return new Locale(str);
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat getAdjustedDefault() {
        return wrap(Api24Impl.getAdjustedDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocaleListCompat getDefault() {
        return wrap(Api24Impl.getDefault());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean matchesLanguageAndScript(Locale locale, Locale locale2) {
        if (BuildCompat.isAtLeastT()) {
            return LocaleList.matchesLanguageAndScript(locale, locale2);
        }
        return Api21Impl.matchesLanguageAndScript(locale, locale2);
    }

    static class Api21Impl {
        private static final Locale[] PSEUDO_LOCALE = {new Locale("en", "XA"), new Locale("ar", "XB")};

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean matchesLanguageAndScript(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || isPseudoLocale(locale) || isPseudoLocale(locale2)) {
                return false;
            }
            String maximizeAndGetScript = ICUCompat.maximizeAndGetScript(locale);
            if (maximizeAndGetScript.isEmpty()) {
                String country = locale.getCountry();
                return country.isEmpty() || country.equals(locale2.getCountry());
            }
            return maximizeAndGetScript.equals(ICUCompat.maximizeAndGetScript(locale2));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static boolean isPseudoLocale(Locale locale) {
            for (Locale locale2 : PSEUDO_LOCALE) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return (obj instanceof LocaleListCompat) && this.mImpl.equals(((LocaleListCompat) obj).mImpl);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.mImpl.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.mImpl.toString();
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static LocaleList createLocaleList(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static LocaleList getAdjustedDefault() {
            return LocaleList.getAdjustedDefault();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static LocaleList getDefault() {
            return LocaleList.getDefault();
        }
    }
}
