package androidx.core.os;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
final class LocaleListPlatformWrapper implements LocaleListInterface {
    private final LocaleList mLocaleList;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LocaleListPlatformWrapper(Object obj) {
        this.mLocaleList = (LocaleList) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.os.LocaleListInterface
    public Object getLocaleList() {
        return this.mLocaleList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.os.LocaleListInterface
    public Locale get(int i) {
        return this.mLocaleList.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.os.LocaleListInterface
    public boolean isEmpty() {
        return this.mLocaleList.isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.os.LocaleListInterface
    public int size() {
        return this.mLocaleList.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.os.LocaleListInterface
    public int indexOf(Locale locale) {
        return this.mLocaleList.indexOf(locale);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return this.mLocaleList.equals(((LocaleListInterface) obj).getLocaleList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.mLocaleList.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.mLocaleList.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.os.LocaleListInterface
    public String toLanguageTags() {
        return this.mLocaleList.toLanguageTags();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.core.os.LocaleListInterface
    public Locale getFirstMatch(String[] strArr) {
        return this.mLocaleList.getFirstMatch(strArr);
    }
}
