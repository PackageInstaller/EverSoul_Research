package androidx.constraintlayout.core;

/* loaded from: classes.dex */
public class GoalRow extends ArrayRow {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GoalRow(Cache cache) {
        super(cache);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        super.addError(solverVariable);
        solverVariable.usageInRowCount--;
    }
}
