package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {
    private Spannable mDelegate;
    private boolean mSafeToWrite = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.mDelegate = spannable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UnprecomputeTextOnModificationSpannable(Spanned spanned) {
        this.mDelegate = new SpannableString(spanned);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    UnprecomputeTextOnModificationSpannable(CharSequence charSequence) {
        this.mDelegate = new SpannableString(charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureSafeWrites() {
        Spannable spannable = this.mDelegate;
        if (!this.mSafeToWrite && precomputedTextDetector().isPrecomputedText(spannable)) {
            this.mDelegate = new SpannableString(spannable);
        }
        this.mSafeToWrite = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        ensureSafeWrites();
        this.mDelegate.setSpan(obj, i, i2, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return (T[]) this.mDelegate.getSpans(i, i2, cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.mDelegate.getSpanStart(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.mDelegate.getSpanEnd(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.mDelegate.getSpanFlags(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.mDelegate.nextSpanTransition(i, i2, cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.CharSequence
    public int length() {
        return this.mDelegate.length();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.mDelegate.charAt(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.mDelegate.subSequence(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.CharSequence
    public String toString() {
        return this.mDelegate.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.CharSequence
    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    private static class CharSequenceHelper_API24 {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CharSequenceHelper_API24() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static IntStream codePoints(CharSequence charSequence) {
            return charSequence.codePoints();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static IntStream chars(CharSequence charSequence) {
            return charSequence.chars();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static PrecomputedTextDetector precomputedTextDetector() {
        return Build.VERSION.SDK_INT < 28 ? new PrecomputedTextDetector() : new PrecomputedTextDetector_28();
    }

    static class PrecomputedTextDetector {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PrecomputedTextDetector() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isPrecomputedText(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PrecomputedTextDetector_28() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        boolean isPrecomputedText(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof PrecomputedTextCompat);
        }
    }
}
