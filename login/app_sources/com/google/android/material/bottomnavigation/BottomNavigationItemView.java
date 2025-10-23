package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.C0903R;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: classes2.dex */
public class BottomNavigationItemView extends NavigationBarItemView {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BottomNavigationItemView(Context context) {
        super(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemLayoutResId() {
        return C0903R.layout.design_bottom_navigation_item;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemDefaultMarginResId() {
        return C0903R.dimen.design_bottom_navigation_margin;
    }
}
