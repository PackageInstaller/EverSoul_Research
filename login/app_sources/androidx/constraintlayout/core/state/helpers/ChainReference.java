package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;

/* loaded from: classes.dex */
public class ChainReference extends HelperReference {
    protected float mBias;
    protected State.Chain mStyle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ChainReference(State state, State.Helper helper) {
        super(state, helper);
        this.mBias = 0.5f;
        this.mStyle = State.Chain.SPREAD;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public State.Chain getStyle() {
        return State.Chain.SPREAD;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ChainReference style(State.Chain chain) {
        this.mStyle = chain;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getBias() {
        return this.mBias;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.ConstraintReference
    public ChainReference bias(float f) {
        this.mBias = f;
        return this;
    }
}
