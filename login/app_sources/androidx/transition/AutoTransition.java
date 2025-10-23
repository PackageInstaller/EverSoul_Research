package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* loaded from: classes5.dex */
public class AutoTransition extends TransitionSet {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AutoTransition() {
        init();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init() {
        setOrdering(1);
        addTransition(new Fade(2)).addTransition(new ChangeBounds()).addTransition(new Fade(1));
    }
}
