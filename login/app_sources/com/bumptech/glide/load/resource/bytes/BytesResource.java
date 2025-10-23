package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes.dex */
public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BytesResource(byte[] bArr) {
        this.bytes = (byte[]) Preconditions.checkNotNull(bArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public byte[] get() {
        return this.bytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }
}
