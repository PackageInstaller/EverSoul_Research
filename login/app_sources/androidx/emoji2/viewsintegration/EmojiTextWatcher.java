package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class EmojiTextWatcher implements TextWatcher {
    private final EditText mEditText;
    private final boolean mExpectInitializedEmojiCompat;
    private EmojiCompat.InitCallback mInitCallback;
    private int mMaxEmojiCount = Integer.MAX_VALUE;
    private int mEmojiReplaceStrategy = 0;
    private boolean mEnabled = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EmojiTextWatcher(EditText editText, boolean z) {
        this.mEditText = editText;
        this.mExpectInitializedEmojiCompat = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setMaxEmojiCount(int i) {
        this.mMaxEmojiCount = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setEmojiReplaceStrategy(int i) {
        this.mEmojiReplaceStrategy = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.mEditText.isInEditMode() || shouldSkipForDisabledOrNotConfigured() || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState == 1) {
                EmojiCompat.get().process((Spannable) charSequence, i, i + i3, this.mMaxEmojiCount, this.mEmojiReplaceStrategy);
                return;
            } else if (loadState != 3) {
                return;
            }
        }
        EmojiCompat.get().registerInitCallback(getInitCallback());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean shouldSkipForDisabledOrNotConfigured() {
        return (this.mEnabled && (this.mExpectInitializedEmojiCompat || EmojiCompat.isConfigured())) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EmojiCompat.InitCallback getInitCallback() {
        if (this.mInitCallback == null) {
            this.mInitCallback = new InitCallbackImpl(this.mEditText);
        }
        return this.mInitCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEnabled() {
        return this.mEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnabled(boolean z) {
        if (this.mEnabled != z) {
            if (this.mInitCallback != null) {
                EmojiCompat.get().unregisterInitCallback(this.mInitCallback);
            }
            this.mEnabled = z;
            if (z) {
                processTextOnEnablingEvent(this.mEditText, EmojiCompat.get().getLoadState());
            }
        }
    }

    private static class InitCallbackImpl extends EmojiCompat.InitCallback {
        private final Reference<EditText> mViewRef;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InitCallbackImpl(EditText editText) {
            this.mViewRef = new WeakReference(editText);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.processTextOnEnablingEvent(this.mViewRef.get(), 1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void processTextOnEnablingEvent(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            EmojiInputFilter.updateSelection(editableText, selectionStart, selectionEnd);
        }
    }
}
