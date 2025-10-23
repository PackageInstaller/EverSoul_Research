package com.bumptech.glide;

/* loaded from: classes.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);

    private final float multiplier;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MemoryCategory(float f) {
        this.multiplier = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getMultiplier() {
        return this.multiplier;
    }
}
