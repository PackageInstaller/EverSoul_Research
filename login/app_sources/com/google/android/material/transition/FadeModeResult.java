package com.google.android.material.transition;

/* loaded from: classes2.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static FadeModeResult startOnTop(int i, int i2) {
        return new FadeModeResult(i, i2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static FadeModeResult endOnTop(int i, int i2) {
        return new FadeModeResult(i, i2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FadeModeResult(int i, int i2, boolean z) {
        this.startAlpha = i;
        this.endAlpha = i2;
        this.endOnTop = z;
    }
}
