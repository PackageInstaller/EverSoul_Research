package com.bumptech.glide.load;

import com.bumptech.glide.util.Preconditions;
import com.liapp.y;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class Option<T> {
    private static final CacheKeyUpdater<Object> EMPTY_UPDATER = new CacheKeyUpdater<Object>() { // from class: com.bumptech.glide.load.Option.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.bumptech.glide.load.Option.CacheKeyUpdater
        public void update(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    };
    private final CacheKeyUpdater<T> cacheKeyUpdater;
    private final T defaultValue;
    private final String key;
    private volatile byte[] keyBytes;

    public interface CacheKeyUpdater<T> {
        void update(byte[] bArr, T t, MessageDigest messageDigest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Option<T> memory(String str) {
        return new Option<>(str, null, emptyUpdater());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Option<T> memory(String str, T t) {
        return new Option<>(str, t, emptyUpdater());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Option<T> disk(String str, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, null, cacheKeyUpdater);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Option<T> disk(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        return new Option<>(str, t, cacheKeyUpdater);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Option(String str, T t, CacheKeyUpdater<T> cacheKeyUpdater) {
        this.key = Preconditions.checkNotEmpty(str);
        this.defaultValue = t;
        this.cacheKeyUpdater = (CacheKeyUpdater) Preconditions.checkNotNull(cacheKeyUpdater);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T getDefaultValue() {
        return this.defaultValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void update(T t, MessageDigest messageDigest) {
        this.cacheKeyUpdater.update(getKeyBytes(), t, messageDigest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] getKeyBytes() {
        if (this.keyBytes == null) {
            this.keyBytes = this.key.getBytes(Key.CHARSET);
        }
        return this.keyBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.key.equals(((Option) obj).key);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.key.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> CacheKeyUpdater<T> emptyUpdater() {
        return (CacheKeyUpdater<T>) EMPTY_UPDATER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628973532) + this.key + y.ݮڮֲڭܩ(-628973388);
    }
}
