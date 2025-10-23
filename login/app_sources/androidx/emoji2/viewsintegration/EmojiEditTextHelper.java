package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class EmojiEditTextHelper {
    private int mEmojiReplaceStrategy;
    private final HelperInternal mHelper;
    private int mMaxEmojiCount;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EmojiEditTextHelper(EditText editText) {
        this(editText, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EmojiEditTextHelper(EditText editText, boolean z) {
        this.mMaxEmojiCount = Integer.MAX_VALUE;
        this.mEmojiReplaceStrategy = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.mHelper = new HelperInternal19(editText, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxEmojiCount(int i) {
        Preconditions.checkArgumentNonnegative(i, "maxEmojiCount should be greater than 0");
        this.mMaxEmojiCount = i;
        this.mHelper.setMaxEmojiCount(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxEmojiCount() {
        return this.mMaxEmojiCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KeyListener getKeyListener(KeyListener keyListener) {
        return this.mHelper.getKeyListener(keyListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.mHelper.onCreateInputConnection(inputConnection, editorInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEmojiReplaceStrategy(int i) {
        this.mEmojiReplaceStrategy = i;
        this.mHelper.setEmojiReplaceStrategy(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getEmojiReplaceStrategy() {
        return this.mEmojiReplaceStrategy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEnabled() {
        return this.mHelper.isEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEnabled(boolean z) {
        this.mHelper.setEnabled(z);
    }

    static class HelperInternal {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        KeyListener getKeyListener(KeyListener keyListener) {
            return keyListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean isEnabled() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setEmojiReplaceStrategy(int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setEnabled(boolean z) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setMaxEmojiCount(int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        HelperInternal() {
        }
    }

    private static class HelperInternal19 extends HelperInternal {
        private final EditText mEditText;
        private final EmojiTextWatcher mTextWatcher;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        HelperInternal19(EditText editText, boolean z) {
            this.mEditText = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z);
            this.mTextWatcher = emojiTextWatcher;
            editText.addTextChangedListener(emojiTextWatcher);
            editText.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setMaxEmojiCount(int i) {
            this.mTextWatcher.setMaxEmojiCount(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEmojiReplaceStrategy(int i) {
            this.mTextWatcher.setEmojiReplaceStrategy(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener getKeyListener(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new EmojiKeyListener(keyListener);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.mEditText, inputConnection, editorInfo);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void setEnabled(boolean z) {
            this.mTextWatcher.setEnabled(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        boolean isEnabled() {
            return this.mTextWatcher.isEnabled();
        }
    }
}
