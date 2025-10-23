package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class HelperReference extends ConstraintReference implements Facade {
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences;
    protected final State mState;
    final State.Helper mType;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.mReferences = new ArrayList<>();
        this.mState = state;
        this.mType = helper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public State.Helper getType() {
        return this.mType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HelperReference add(Object... objArr) {
        Collections.addAll(this.mReferences, objArr);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHelperWidget(HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }
}
