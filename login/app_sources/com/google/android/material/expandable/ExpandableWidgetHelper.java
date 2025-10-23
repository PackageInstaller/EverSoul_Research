package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes2.dex */
public final class ExpandableWidgetHelper {
    private boolean expanded = false;
    private int expandedComponentIdHint = 0;
    private final View widget;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.widget = (View) expandableWidget;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setExpanded(boolean z) {
        if (this.expanded == z) {
            return false;
        }
        this.expanded = z;
        dispatchExpandedStateChanged();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isExpanded() {
        return this.expanded;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.expanded);
        bundle.putInt("expandedComponentIdHint", this.expandedComponentIdHint);
        return bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onRestoreInstanceState(Bundle bundle) {
        this.expanded = bundle.getBoolean("expanded", false);
        this.expandedComponentIdHint = bundle.getInt("expandedComponentIdHint", 0);
        if (this.expanded) {
            dispatchExpandedStateChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setExpandedComponentIdHint(int i) {
        this.expandedComponentIdHint = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getExpandedComponentIdHint() {
        return this.expandedComponentIdHint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void dispatchExpandedStateChanged() {
        ViewParent parent = this.widget.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).dispatchDependentViewsChanged(this.widget);
        }
    }
}
