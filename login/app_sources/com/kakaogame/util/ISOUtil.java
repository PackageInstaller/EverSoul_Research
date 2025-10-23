package com.kakaogame.util;

import com.liapp.y;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ISOUtil.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/util/ISOUtil;", "", "()V", "ISO_COUNTRIES", "", "", "ISO_LANGUAGES", "", "isValidISOCountry", "", "s", "isValidISOLanguage", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ISOUtil {
    public static final ISOUtil INSTANCE = new ISOUtil();
    private static final Set<String> ISO_COUNTRIES;
    private static final Set<String> ISO_LANGUAGES;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ISOUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String[] iSOLanguages = Locale.getISOLanguages();
        ISO_LANGUAGES = new HashSet(Arrays.asList(Arrays.copyOf(iSOLanguages, iSOLanguages.length)));
        String[] iSOCountries = Locale.getISOCountries();
        ISO_COUNTRIES = new HashSet(Arrays.asList(Arrays.copyOf(iSOCountries, iSOCountries.length)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isValidISOLanguage(String s) {
        Intrinsics.checkNotNullParameter(s, y.ٲٴݴ״ٰ(1781877368));
        Set<String> set = ISO_LANGUAGES;
        String upperCase = s.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, y.ٲٴݴ״ٰ(1782555280));
        if (!set.contains(upperCase)) {
            String lowerCase = s.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, y.֬ڱܱײٮ(-1159086455));
            if (!set.contains(lowerCase)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isValidISOCountry(String s) {
        Intrinsics.checkNotNullParameter(s, y.ٲٴݴ״ٰ(1781877368));
        Set<String> set = ISO_COUNTRIES;
        set.add(y.֬ڱܱײٮ(-1159012263));
        String upperCase = s.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, y.ٲٴݴ״ٰ(1782555280));
        if (!set.contains(upperCase)) {
            String lowerCase = s.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, y.֬ڱܱײٮ(-1159086455));
            if (!set.contains(lowerCase)) {
                return false;
            }
        }
        return true;
    }
}
