package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized List<ImageHeaderParser> getParsers() {
        return this.parsers;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void add(ImageHeaderParser imageHeaderParser) {
        this.parsers.add(imageHeaderParser);
    }
}
