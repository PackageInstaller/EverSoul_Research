package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;
import com.liapp.y;

@Deprecated
/* loaded from: classes.dex */
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SimpleTarget(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        if (!Util.isValidDimensions(this.width, this.height)) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159230047) + this.width + y.֬ڱܱײٮ(-1159229903) + this.height + y.دײܮڳܯ(2051942421));
        }
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }
}
