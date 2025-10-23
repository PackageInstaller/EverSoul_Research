package androidx.core.content;

import android.content.SharedPreferences;

@Deprecated
/* loaded from: classes.dex */
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper = new Helper();

        private static class Helper {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            Helper() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public void apply(SharedPreferences.Editor editor) {
                try {
                    editor.apply();
                } catch (AbstractMethodError unused) {
                    editor.commit();
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EditorCompat() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public static EditorCompat getInstance() {
            if (sInstance == null) {
                sInstance = new EditorCompat();
            }
            return sInstance;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated
        public void apply(SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SharedPreferencesCompat() {
    }
}
