package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes.dex */
class EngineKey implements Key {
    private int hashCode;
    private final int height;
    private final Object model;
    private final Options options;
    private final Class<?> resourceClass;
    private final Key signature;
    private final Class<?> transcodeClass;
    private final Map<Class<?>, Transformation<?>> transformations;
    private final int width;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EngineKey(Object obj, Key key, int i, int i2, Map<Class<?>, Transformation<?>> map, Class<?> cls, Class<?> cls2, Options options) {
        this.model = Preconditions.checkNotNull(obj);
        this.signature = (Key) Preconditions.checkNotNull(key, "Signature must not be null");
        this.width = i;
        this.height = i2;
        this.transformations = (Map) Preconditions.checkNotNull(map);
        this.resourceClass = (Class) Preconditions.checkNotNull(cls, "Resource class must not be null");
        this.transcodeClass = (Class) Preconditions.checkNotNull(cls2, "Transcode class must not be null");
        this.options = (Options) Preconditions.checkNotNull(options);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (!(obj instanceof EngineKey)) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        return this.model.equals(engineKey.model) && this.signature.equals(engineKey.signature) && this.height == engineKey.height && this.width == engineKey.width && this.transformations.equals(engineKey.transformations) && this.resourceClass.equals(engineKey.resourceClass) && this.transcodeClass.equals(engineKey.transcodeClass) && this.options.equals(engineKey.options);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = this.model.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = (((((hashCode * 31) + this.signature.hashCode()) * 31) + this.width) * 31) + this.height;
            this.hashCode = hashCode2;
            int hashCode3 = (hashCode2 * 31) + this.transformations.hashCode();
            this.hashCode = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.resourceClass.hashCode();
            this.hashCode = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.transcodeClass.hashCode();
            this.hashCode = hashCode5;
            this.hashCode = (hashCode5 * 31) + this.options.hashCode();
        }
        return this.hashCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.دײܮڳܯ(2052048589) + this.model + y.ݬֲ֮ܲت(1513090775) + this.width + y.ۮڭڭܬި(862104747) + this.height + y.ۮڭڭܬި(862104771) + this.resourceClass + y.֬ڱܱײٮ(-1159291975) + this.transcodeClass + y.٬ݯح׭٩(576006110) + this.signature + y.دײܮڳܯ(2052048237) + this.hashCode + y.دײܮڳܯ(2052048373) + this.transformations + y.ݬֲ֮ܲت(1513089983) + this.options + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
