package com.google.android.material.resources;

import android.graphics.Typeface;

/* loaded from: classes2.dex */
public final class CancelableFontCallback extends TextAppearanceFontCallback {
    private final ApplyFont applyFont;
    private boolean cancelled;
    private final Typeface fallbackFont;

    public interface ApplyFont {
        void apply(Typeface typeface);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = applyFont;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface typeface, boolean z) {
        updateIfNotCancelled(typeface);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
        updateIfNotCancelled(this.fallbackFont);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cancel() {
        this.cancelled = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateIfNotCancelled(Typeface typeface) {
        if (this.cancelled) {
            return;
        }
        this.applyFont.apply(typeface);
    }
}
