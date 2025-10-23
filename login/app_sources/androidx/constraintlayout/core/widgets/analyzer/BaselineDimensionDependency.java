package androidx.constraintlayout.core.widgets.analyzer;

/* loaded from: classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void update(DependencyNode dependencyNode) {
        ((VerticalWidgetRun) this.run).baseline.margin = this.run.widget.getBaselineDistance();
        this.resolved = true;
    }
}
