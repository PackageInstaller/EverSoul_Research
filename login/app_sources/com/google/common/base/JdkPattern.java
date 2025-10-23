package com.google.common.base;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class JdkPattern extends CommonPattern implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern pattern;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JdkPattern(Pattern pattern) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.CommonPattern
    public CommonMatcher matcher(CharSequence charSequence) {
        return new JdkMatcher(this.pattern.matcher(charSequence));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.CommonPattern
    public String pattern() {
        return this.pattern.pattern();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.CommonPattern
    public int flags() {
        return this.pattern.flags();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.CommonPattern
    public String toString() {
        return this.pattern.toString();
    }

    private static final class JdkMatcher extends CommonMatcher {
        final Matcher matcher;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        JdkMatcher(Matcher matcher) {
            this.matcher = (Matcher) Preconditions.checkNotNull(matcher);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.CommonMatcher
        public boolean matches() {
            return this.matcher.matches();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.CommonMatcher
        public boolean find() {
            return this.matcher.find();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.CommonMatcher
        public boolean find(int i) {
            return this.matcher.find(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.CommonMatcher
        public String replaceAll(String str) {
            return this.matcher.replaceAll(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.CommonMatcher
        public int end() {
            return this.matcher.end();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.CommonMatcher
        public int start() {
            return this.matcher.start();
        }
    }
}
