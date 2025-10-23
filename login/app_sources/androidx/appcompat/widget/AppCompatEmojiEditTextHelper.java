package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.C0047R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* loaded from: classes.dex */
class AppCompatEmojiEditTextHelper {
    private final EmojiEditTextHelper mEmojiEditTextHelper;
    private final EditText mView;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AppCompatEmojiEditTextHelper(EditText editText) {
        this.mView = editText;
        this.mEmojiEditTextHelper = new EmojiEditTextHelper(editText, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, C0047R.styleable.AppCompatTextView, i, 0);
        try {
            boolean z = obtainStyledAttributes.hasValue(C0047R.styleable.AppCompatTextView_emojiCompatEnabled) ? obtainStyledAttributes.getBoolean(C0047R.styleable.AppCompatTextView_emojiCompatEnabled, true) : true;
            obtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isEmojiCapableKeyListener(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setEnabled(boolean z) {
        this.mEmojiEditTextHelper.setEnabled(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isEnabled() {
        return this.mEmojiEditTextHelper.isEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KeyListener getKeyListener(KeyListener keyListener) {
        return isEmojiCapableKeyListener(keyListener) ? this.mEmojiEditTextHelper.getKeyListener(keyListener) : keyListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.mEmojiEditTextHelper.onCreateInputConnection(inputConnection, editorInfo);
    }
}
