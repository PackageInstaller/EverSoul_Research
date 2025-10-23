package com.google.common.p009io;

import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class PatternFilenameFilter implements FilenameFilter {
    private final Pattern pattern;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PatternFilenameFilter(String str) {
        this(Pattern.compile(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PatternFilenameFilter(Pattern pattern) {
        this.pattern = (Pattern) Preconditions.checkNotNull(pattern);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return this.pattern.matcher(str).matches();
    }
}
