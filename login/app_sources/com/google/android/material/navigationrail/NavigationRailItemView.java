package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import com.google.android.material.C0903R;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes2.dex */
final class NavigationRailItemView extends NavigationBarItemView {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NavigationRailItemView(Context context) {
        super(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i2)), i2, 0));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemLayoutResId() {
        return C0903R.layout.mtrl_navigation_rail_item;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemDefaultMarginResId() {
        return C0903R.dimen.mtrl_navigation_rail_icon_margin;
    }
}
