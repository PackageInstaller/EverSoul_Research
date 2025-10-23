package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.C0903R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes2.dex */
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final int DEFAULT_STROKE_VALUE = -1;
    private final MaterialShapeDrawable bgDrawable;
    private boolean checkable;
    private Drawable checkedIcon;
    private int checkedIconMargin;
    private int checkedIconSize;
    private ColorStateList checkedIconTint;
    private LayerDrawable clickableForegroundDrawable;
    private MaterialShapeDrawable compatRippleDrawable;
    private Drawable fgDrawable;
    private final MaterialShapeDrawable foregroundContentDrawable;
    private MaterialShapeDrawable foregroundShapeDrawable;
    private final MaterialCardView materialCardView;
    private ColorStateList rippleColor;
    private Drawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;
    private int strokeWidth;
    private final Rect userContentPadding = new Rect();
    private boolean isBackgroundOverwritten = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialCardViewHelper(MaterialCardView materialCardView, AttributeSet attributeSet, int i, int i2) {
        this.materialCardView = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i, i2);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.getShapeAppearanceModel().toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, C0903R.styleable.CardView, i, C0903R.style.CardView);
        if (obtainStyledAttributes.hasValue(C0903R.styleable.CardView_cardCornerRadius)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(C0903R.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void loadFromAttributes(TypedArray typedArray) {
        ColorStateList colorStateList = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, C0903R.styleable.MaterialCardView_strokeColor);
        this.strokeColor = colorStateList;
        if (colorStateList == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(C0903R.styleable.MaterialCardView_strokeWidth, 0);
        boolean z = typedArray.getBoolean(C0903R.styleable.MaterialCardView_android_checkable, false);
        this.checkable = z;
        this.materialCardView.setLongClickable(z);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, C0903R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, C0903R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(typedArray.getDimensionPixelSize(C0903R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(typedArray.getDimensionPixelSize(C0903R.styleable.MaterialCardView_checkedIconMargin, 0));
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, C0903R.styleable.MaterialCardView_rippleColor);
        this.rippleColor = colorStateList2;
        if (colorStateList2 == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, C0903R.attr.colorControlHighlight));
        }
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, C0903R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        this.materialCardView.setForeground(insetDrawable(clickableForeground));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setBackgroundOverwritten(boolean z) {
        this.isBackgroundOverwritten = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getStrokeColor() {
        ColorStateList colorStateList = this.strokeColor;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setStrokeWidth(int i) {
        if (i == this.strokeWidth) {
            return;
        }
        this.strokeWidth = i;
        updateStroke();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCardForegroundColor(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        materialShapeDrawable.setFillColor(colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setUserContentPadding(int i, int i2, int i3, int i4) {
        this.userContentPadding.set(i, i2, i3, i4);
        updateContentPadding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateClickable() {
        Drawable drawable = this.fgDrawable;
        Drawable clickableForeground = this.materialCardView.isClickable() ? getClickableForeground() : this.foregroundContentDrawable;
        this.fgDrawable = clickableForeground;
        if (drawable != clickableForeground) {
            updateInsetForeground(clickableForeground);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCornerRadius(float f) {
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(f));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setProgress(float f) {
        this.bgDrawable.setInterpolation(f);
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setInterpolation(f);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setInterpolation(f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateContentPadding() {
        int calculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f) - getParentCardViewCalculatedCornerPadding());
        this.materialCardView.setAncestorContentPadding(this.userContentPadding.left + calculateActualCornerPadding, this.userContentPadding.top + calculateActualCornerPadding, this.userContentPadding.right + calculateActualCornerPadding, this.userContentPadding.bottom + calculateActualCornerPadding);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCheckable(boolean z) {
        this.checkable = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isCheckable() {
        return this.checkable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setRippleColor(ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCheckedIconTint(ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCheckedIcon(Drawable drawable) {
        this.checkedIcon = drawable;
        if (drawable != null) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.checkedIcon = mutate;
            DrawableCompat.setTintList(mutate, this.checkedIconTint);
            setChecked(this.materialCardView.isChecked());
        }
        LayerDrawable layerDrawable = this.clickableForegroundDrawable;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(C0903R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCheckedIconSize(int i) {
        this.checkedIconSize = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCheckedIconMargin(int i) {
        this.checkedIconMargin = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.clickableForegroundDrawable != null) {
            int i5 = this.checkedIconMargin;
            int i6 = this.checkedIconSize;
            int i7 = (i - i5) - i6;
            int i8 = (i2 - i5) - i6;
            if (this.materialCardView.getUseCompatPadding()) {
                i8 -= (int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
                i7 -= (int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
            }
            int i9 = i8;
            int i10 = this.checkedIconMargin;
            if (ViewCompat.getLayoutDirection(this.materialCardView) == 1) {
                i4 = i7;
                i3 = i10;
            } else {
                i3 = i7;
                i4 = i10;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i3, this.checkedIconMargin, i4, i9);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void forceRippleRedraw() {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        this.bgDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        this.bgDrawable.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        MaterialShapeDrawable materialShapeDrawable = this.foregroundContentDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundShapeDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.compatRippleDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateInsetForeground(Drawable drawable) {
        if (this.materialCardView.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        } else {
            this.materialCardView.setForeground(insetDrawable(drawable));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable insetDrawable(Drawable drawable) {
        int i;
        int i2;
        if (this.materialCardView.getUseCompatPadding()) {
            i2 = (int) Math.ceil(calculateVerticalBackgroundPadding());
            i = (int) Math.ceil(calculateHorizontalBackgroundPadding());
        } else {
            i = 0;
            i2 = 0;
        }
        return new InsetDrawable(drawable, i, i2, i, i2) { // from class: com.google.android.material.card.MaterialCardViewHelper.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.graphics.drawable.Drawable
            public int getMinimumHeight() {
                return -1;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.graphics.drawable.Drawable
            public int getMinimumWidth() {
                return -1;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
            public boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() && this.materialCardView.getUseCompatPadding()) {
            return (float) ((1.0d - COS_45) * this.materialCardView.getCardViewRadius());
        }
        return 0.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float calculateActualCornerPadding() {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(this.shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * f);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, C0903R.id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable createForegroundRippleDrawable() {
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            this.foregroundShapeDrawable = createForegroundShapeDrawable();
            return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
        }
        return createCompatRippleDrawable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable createCompatRippleDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        MaterialShapeDrawable createForegroundShapeDrawable = createForegroundShapeDrawable();
        this.compatRippleDrawable = createForegroundShapeDrawable;
        createForegroundShapeDrawable.setFillColor(this.rippleColor);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.compatRippleDrawable);
        return stateListDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateRippleColor() {
        Drawable drawable;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && (drawable = this.rippleDrawable) != null) {
            ((RippleDrawable) drawable).setColor(this.rippleColor);
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = this.compatRippleDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setFillColor(this.rippleColor);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MaterialShapeDrawable createForegroundShapeDrawable() {
        return new MaterialShapeDrawable(this.shapeAppearanceModel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChecked(boolean z) {
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            drawable.setAlpha(z ? 255 : 0);
        }
    }
}
