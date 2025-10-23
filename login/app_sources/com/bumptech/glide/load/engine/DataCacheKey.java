package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.liapp.y;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class DataCacheKey implements Key {
    private final Key signature;
    private final Key sourceKey;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DataCacheKey(Key key, Key key2) {
        this.sourceKey = key;
        this.signature = key2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Key getSourceKey() {
        return this.sourceKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof DataCacheKey)) {
            return false;
        }
        DataCacheKey dataCacheKey = (DataCacheKey) obj;
        return this.sourceKey.equals(dataCacheKey.sourceKey) && this.signature.equals(dataCacheKey.signature);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return (this.sourceKey.hashCode() * 31) + this.signature.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٲٴݴ״ٰ(1781791792) + this.sourceKey + y.٬ݯح׭٩(576006110) + this.signature + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.sourceKey.updateDiskCacheKey(messageDigest);
        this.signature.updateDiskCacheKey(messageDigest);
    }
}
