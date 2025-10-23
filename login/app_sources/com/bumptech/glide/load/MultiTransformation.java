package com.bumptech.glide.load;

import android.content.Context;
import com.bumptech.glide.load.engine.Resource;
import com.liapp.y;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MultiTransformation<T> implements Transformation<T> {
    private final Collection<? extends Transformation<T>> transformations;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public MultiTransformation(Transformation<T>... transformationArr) {
        if (transformationArr.length == 0) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2052036853));
        }
        this.transformations = Arrays.asList(transformationArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MultiTransformation(Collection<? extends Transformation<T>> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(y.دײܮڳܯ(2052036853));
        }
        this.transformations = collection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Transformation
    public Resource<T> transform(Context context, Resource<T> resource, int i, int i2) {
        Iterator<? extends Transformation<T>> it = this.transformations.iterator();
        Resource<T> resource2 = resource;
        while (it.hasNext()) {
            Resource<T> transform = it.next().transform(context, resource2, i, i2);
            if (resource2 != null && !resource2.equals(resource) && !resource2.equals(transform)) {
                resource2.recycle();
            }
            resource2 = transform;
        }
        return resource2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof MultiTransformation) {
            return this.transformations.equals(((MultiTransformation) obj).transformations);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.transformations.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Iterator<? extends Transformation<T>> it = this.transformations.iterator();
        while (it.hasNext()) {
            it.next().updateDiskCacheKey(messageDigest);
        }
    }
}
