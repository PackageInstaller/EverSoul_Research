package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.C0903R;
import com.google.android.material.internal.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int DEF_STYLE_RES = C0903R.style.Widget_MaterialComponents_ChipGroup;
    private int checkedId;
    private final CheckedStateTracker checkedStateTracker;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private OnCheckedChangeListener onCheckedChangeListener;
    private PassThroughHierarchyChangeListener passThroughListener;
    private boolean protectFromCheckedChange;
    private boolean selectionRequired;
    private boolean singleSelection;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup chipGroup, int i);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ChipGroup(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0903R.attr.chipGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ChipGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.ChipGroup.DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            com.google.android.material.chip.ChipGroup$CheckedStateTracker r8 = new com.google.android.material.chip.ChipGroup$CheckedStateTracker
            r0 = 0
            r8.<init>()
            r7.checkedStateTracker = r8
            com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener r8 = new com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener
            r8.<init>()
            r7.passThroughListener = r8
            r8 = -1
            r7.checkedId = r8
            r6 = 0
            r7.protectFromCheckedChange = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.C0903R.styleable.ChipGroup
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.C0903R.styleable.ChipGroup_chipSpacing
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            int r0 = com.google.android.material.C0903R.styleable.ChipGroup_chipSpacingHorizontal
            int r0 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.C0903R.styleable.ChipGroup_chipSpacingVertical
            int r10 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingVertical(r10)
            int r10 = com.google.android.material.C0903R.styleable.ChipGroup_singleLine
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleLine(r10)
            int r10 = com.google.android.material.C0903R.styleable.ChipGroup_singleSelection
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleSelection(r10)
            int r10 = com.google.android.material.C0903R.styleable.ChipGroup_selectionRequired
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSelectionRequired(r10)
            int r10 = com.google.android.material.C0903R.styleable.ChipGroup_checkedChip
            int r10 = r9.getResourceId(r10, r8)
            if (r10 == r8) goto L69
            r7.checkedId = r10
        L69:
            r9.recycle()
            com.google.android.material.chip.ChipGroup$PassThroughHierarchyChangeListener r8 = r7.passThroughListener
            super.setOnHierarchyChangeListener(r8)
            r8 = 1
            androidx.core.view.ViewCompat.setImportantForAccessibility(r7, r8)
            return
            fill-array 0x0076: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), isSingleLine() ? getChipCount() : -1, false, isSingleSelection() ? 1 : 2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.passThroughListener.onHierarchyChangeListener = onHierarchyChangeListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i = this.checkedId;
        if (i != -1) {
            setCheckedStateForView(i, true);
            setCheckedId(this.checkedId);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i2 = this.checkedId;
                if (i2 != -1 && this.singleSelection) {
                    setCheckedStateForView(i2, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void check(int i) {
        int i2 = this.checkedId;
        if (i == i2) {
            return;
        }
        if (i2 != -1 && this.singleSelection) {
            setCheckedStateForView(i2, false);
        }
        if (i != -1) {
            setCheckedStateForView(i, true);
        }
        setCheckedId(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCheckedChipId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.singleSelection) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearCheck() {
        this.protectFromCheckedChange = true;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.protectFromCheckedChange = false;
        setCheckedId(-1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedId(int i) {
        setCheckedId(i, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedId(int i, boolean z) {
        this.checkedId = i;
        OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
        if (onCheckedChangeListener != null && this.singleSelection && z) {
            onCheckedChangeListener.onCheckedChanged(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedStateForView(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof Chip) {
            this.protectFromCheckedChange = true;
            ((Chip) findViewById).setChecked(z);
            this.protectFromCheckedChange = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getIndexOfChip(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                if (((Chip) getChildAt(i2)) == view) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipSpacingHorizontal(int i) {
        if (this.chipSpacingHorizontal != i) {
            this.chipSpacingHorizontal = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipSpacingVertical(int i) {
        if (this.chipSpacingVertical != i) {
            this.chipSpacingVertical = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.FlowLayout
    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            clearCheck();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSelectionRequired(boolean z) {
        this.selectionRequired = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CheckedStateTracker() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.protectFromCheckedChange) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.selectionRequired) {
                ChipGroup.this.setCheckedStateForView(compoundButton.getId(), true);
                ChipGroup.this.setCheckedId(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (z) {
                if (ChipGroup.this.checkedId != -1 && ChipGroup.this.checkedId != id && ChipGroup.this.singleSelection) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.setCheckedStateForView(chipGroup.checkedId, false);
                }
                ChipGroup.this.setCheckedId(id);
                return;
            }
            if (ChipGroup.this.checkedId == id) {
                ChipGroup.this.setCheckedId(-1);
            }
        }
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PassThroughHierarchyChangeListener() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).check(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.checkedStateTracker);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.onHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }
}
