package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Platform {
    private static final Logger logger = Logger.getLogger(Platform.class.getName());
    private static final PatternCompiler patternCompiler = loadPatternCompiler();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void checkGwtRpcEnabled() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String nullToEmpty(@CheckForNull String str) {
        return str == null ? "" : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Platform() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long systemNanoTime() {
        return System.nanoTime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static CharMatcher precomputeCharMatcher(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = Enums.getEnumConstants(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.m188of(cls.cast(weakReference.get()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String formatCompact4Digits(double d) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean stringIsNullOrEmpty(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    static String emptyToNull(@CheckForNull String str) {
        if (stringIsNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static CommonPattern compilePattern(String str) {
        Preconditions.checkNotNull(str);
        return patternCompiler.compile(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void logPatternCompilerError(ServiceConfigurationError serviceConfigurationError) {
        logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) serviceConfigurationError);
    }

    private static final class JdkPatternCompiler implements PatternCompiler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.PatternCompiler
        public boolean isPcreLike() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private JdkPatternCompiler() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.PatternCompiler
        public CommonPattern compile(String str) {
            return new JdkPattern(Pattern.compile(str));
        }
    }
}
