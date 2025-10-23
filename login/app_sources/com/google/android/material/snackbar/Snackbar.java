package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.C0903R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = {C0903R.attr.snackbarButtonStyle};
    private static final int[] SNACKBAR_CONTENT_STYLE_ATTRS = {C0903R.attr.snackbarButtonStyle, C0903R.attr.snackbarTextViewStyle};
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onDismissed(Snackbar snackbar, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
        public void onShown(Snackbar snackbar) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Snackbar(Context context, ViewGroup viewGroup, View view, ContentViewCallback contentViewCallback) {
        super(context, viewGroup, view, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void show() {
        super.show();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void dismiss() {
        super.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public boolean isShown() {
        return super.isShown();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Snackbar make(View view, CharSequence charSequence, int i) {
        return makeInternal(null, view, charSequence, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Snackbar make(Context context, View view, CharSequence charSequence, int i) {
        return makeInternal(context, view, charSequence, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Snackbar makeInternal(Context context, View view, CharSequence charSequence, int i) {
        ViewGroup findSuitableParent = findSuitableParent(view);
        if (findSuitableParent == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = findSuitableParent.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(hasSnackbarContentStyleAttrs(context) ? C0903R.layout.mtrl_layout_snackbar_include : C0903R.layout.design_layout_snackbar_include, findSuitableParent, false);
        Snackbar snackbar = new Snackbar(context, findSuitableParent, snackbarContentLayout, snackbarContentLayout);
        snackbar.setText(charSequence);
        snackbar.setDuration(i);
        return snackbar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    protected static boolean hasSnackbarButtonStyleAttr(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean hasSnackbarContentStyleAttrs(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(SNACKBAR_CONTENT_STYLE_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Snackbar make(View view, int i, int i2) {
        return make(view, view.getResources().getText(i), i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ViewGroup findSuitableParent(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setText(CharSequence charSequence) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setText(int i) {
        return setText(getContext().getText(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setAction(int i, View.OnClickListener onClickListener) {
        return setAction(getContext().getText(i), onClickListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setAction(CharSequence charSequence, final View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.hasAction = false;
        } else {
            this.hasAction = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.snackbar.Snackbar.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onClickListener.onClick(view);
                    Snackbar.this.dispatchDismiss(1);
                }
            });
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int getDuration() {
        int duration = super.getDuration();
        if (duration == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.accessibilityManager.getRecommendedTimeoutMillis(duration, (this.hasAction ? 4 : 0) | 1 | 2);
        }
        if (this.hasAction && this.accessibilityManager.isTouchExplorationEnabled()) {
            return -2;
        }
        return duration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setTextColor(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(colorStateList);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setTextColor(int i) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setActionTextColor(ColorStateList colorStateList) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(colorStateList);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setMaxInlineActionWidth(int i) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).setMaxInlineActionWidth(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setActionTextColor(int i) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setBackgroundTint(int i) {
        return setBackgroundTintList(ColorStateList.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setBackgroundTintList(ColorStateList colorStateList) {
        this.view.setBackgroundTintList(colorStateList);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Snackbar setBackgroundTintMode(PorterDuff.Mode mode) {
        this.view.setBackgroundTintMode(mode);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public Snackbar setCallback(Callback callback) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback != null) {
            addCallback(callback);
        }
        this.callback = callback;
        return this;
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SnackbarLayout(Context context) {
            super(context);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }
}
