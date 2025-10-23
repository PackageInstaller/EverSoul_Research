package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class TextDrawableHelper {
    private TextAppearance textAppearance;
    private float textWidth;
    private final TextPaint textPaint = new TextPaint(1);
    private final TextAppearanceFontCallback fontCallback = new TextAppearanceFontCallback() { // from class: com.google.android.material.internal.TextDrawableHelper.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrieved(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            TextDrawableHelper.this.textWidthDirty = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void onFontRetrievalFailed(int i) {
            TextDrawableHelper.this.textWidthDirty = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.delegate.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.onTextSizeChange();
            }
        }
    };
    private boolean textWidthDirty = true;
    private WeakReference<TextDrawableDelegate> delegate = new WeakReference<>(null);

    public interface TextDrawableDelegate {
        int[] getState();

        boolean onStateChange(int[] iArr);

        void onTextSizeChange();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextDrawableHelper(TextDrawableDelegate textDrawableDelegate) {
        setDelegate(textDrawableDelegate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDelegate(TextDrawableDelegate textDrawableDelegate) {
        this.delegate = new WeakReference<>(textDrawableDelegate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextPaint getTextPaint() {
        return this.textPaint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextWidthDirty(boolean z) {
        this.textWidthDirty = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTextWidthDirty() {
        return this.textWidthDirty;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getTextWidth(String str) {
        if (!this.textWidthDirty) {
            return this.textWidth;
        }
        float calculateTextWidth = calculateTextWidth(str);
        this.textWidth = calculateTextWidth;
        this.textWidthDirty = false;
        return calculateTextWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float calculateTextWidth(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.textPaint.measureText(charSequence, 0, charSequence.length());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextAppearance getTextAppearance() {
        return this.textAppearance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextAppearance(TextAppearance textAppearance, Context context) {
        if (this.textAppearance != textAppearance) {
            this.textAppearance = textAppearance;
            if (textAppearance != null) {
                textAppearance.updateMeasureState(context, this.textPaint, this.fontCallback);
                TextDrawableDelegate textDrawableDelegate = this.delegate.get();
                if (textDrawableDelegate != null) {
                    this.textPaint.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
                this.textWidthDirty = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = this.delegate.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.onTextSizeChange();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void updateTextPaintDrawState(Context context) {
        this.textAppearance.updateDrawState(context, this.textPaint, this.fontCallback);
    }
}
