package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;

/* loaded from: classes.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.type = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.type = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public void resolve(int i) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = i;
        for (Dependency dependency : this.dependencies) {
            dependency.update(dependency);
        }
    }
}
