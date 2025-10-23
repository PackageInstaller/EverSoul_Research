package com.bumptech.glide.signature;

import com.bumptech.glide.load.Key;
import com.liapp.y;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class EmptySignature implements Key {
    private static final EmptySignature EMPTY_KEY = new EmptySignature();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1781677096);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static EmptySignature obtain() {
        return EMPTY_KEY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EmptySignature() {
    }
}
