package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.C0047R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.C0903R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;

/* loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private boolean bottomInsetScrimEnabled;
    private int drawerLayoutCornerSize;
    private int layoutGravity;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final RectF shapeClipBounds;
    private Path shapeClipPath;
    private final int[] tmpLocation;
    private boolean topInsetScrimEnabled;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int DEF_STYLE_RES = C0903R.style.Widget_Design_NavigationView;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NavigationView(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0903R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NavigationView(android.content.Context r12, android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void maybeUpdateCornerSizeForDrawerLayout(int i, int i2) {
        if ((getParent() instanceof DrawerLayout) && this.drawerLayoutCornerSize > 0 && (getBackground() instanceof MaterialShapeDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
            ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
            if (GravityCompat.getAbsoluteGravity(this.layoutGravity, ViewCompat.getLayoutDirection(this)) == 3) {
                builder.setTopRightCornerSize(this.drawerLayoutCornerSize);
                builder.setBottomRightCornerSize(this.drawerLayoutCornerSize);
            } else {
                builder.setTopLeftCornerSize(this.drawerLayoutCornerSize);
                builder.setBottomLeftCornerSize(this.drawerLayoutCornerSize);
            }
            materialShapeDrawable.setShapeAppearanceModel(builder.build());
            if (this.shapeClipPath == null) {
                this.shapeClipPath = new Path();
            }
            this.shapeClipPath.reset();
            this.shapeClipBounds.set(0.0f, 0.0f, i, i2);
            ShapeAppearancePathProvider.getInstance().calculatePath(materialShapeDrawable.getShapeAppearanceModel(), materialShapeDrawable.getInterpolation(), this.shapeClipBounds, this.shapeClipPath);
            invalidate();
            return;
        }
        this.shapeClipPath = null;
        this.shapeClipBounds.setEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean hasShapeAppearance(TintTypedArray tintTypedArray) {
        return tintTypedArray.hasValue(C0903R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(C0903R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        maybeUpdateCornerSizeForDrawerLayout(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        MaterialShapeUtils.setElevation(this, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Drawable createDefaultItemBackground(TintTypedArray tintTypedArray) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), tintTypedArray.getResourceId(C0903R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(C0903R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), tintTypedArray, C0903R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) materialShapeDrawable, tintTypedArray.getDimensionPixelSize(C0903R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(C0903R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(C0903R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(C0903R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuState = new Bundle();
        this.menu.savePresenterStates(savedState.menuState);
        return savedState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), this.maxWidth), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.shapeClipPath == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int save = canvas.save();
        canvas.clipPath(this.shapeClipPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    protected void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void inflateMenu(int i) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Menu getMenu() {
        return this.menu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View inflateHeaderView(int i) {
        return this.presenter.inflateHeaderView(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public View getHeaderView(int i) {
        return this.presenter.getHeaderView(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemBackgroundResource(int i) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemBackground(Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemHorizontalPadding(int i) {
        this.presenter.setItemHorizontalPadding(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemHorizontalPaddingResource(int i) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemVerticalPadding(int i) {
        this.presenter.setItemVerticalPadding(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemVerticalPaddingResource(int i) {
        this.presenter.setItemVerticalPadding(getResources().getDimensionPixelSize(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemIconPadding(int i) {
        this.presenter.setItemIconPadding(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemIconPaddingResource(int i) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedItem(int i) {
        MenuItem findItem = this.menu.findItem(i);
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.setCheckedItem((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemTextAppearance(int i) {
        this.presenter.setItemTextAppearance(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemIconSize(int i) {
        this.presenter.setItemIconSize(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setItemMaxLines(int i) {
        this.presenter.setItemMaxLines(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTopInsetScrimEnabled(boolean z) {
        this.topInsetScrimEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBottomInsetScrimEnabled(boolean z) {
        this.bottomInsetScrimEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetStart(int i) {
        this.presenter.setDividerInsetStart(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetEnd(int i) {
        this.presenter.setDividerInsetEnd(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSubheaderInsetStart(int i) {
        this.presenter.setSubheaderInsetStart(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSubheaderInsetEnd(int i) {
        this.presenter.setSubheaderInsetStart(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0047R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z = NavigationView.this.tmpLocation[1] == 0;
                NavigationView.this.presenter.setBehindStatusBar(z);
                NavigationView navigationView2 = NavigationView.this;
                navigationView2.setDrawTopInsetForeground(z && navigationView2.isTopInsetScrimEnabled());
                Activity activity = ContextUtils.getActivity(NavigationView.this.getContext());
                if (activity != null) {
                    boolean z2 = activity.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight();
                    boolean z3 = Color.alpha(activity.getWindow().getNavigationBarColor()) != 0;
                    NavigationView navigationView3 = NavigationView.this;
                    navigationView3.setDrawBottomInsetForeground(z2 && z3 && navigationView3.isBottomInsetScrimEnabled());
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public Bundle menuState;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeBundle(this.menuState);
        }
    }
}
