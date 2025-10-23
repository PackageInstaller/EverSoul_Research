package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.C0903R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;

/* loaded from: classes2.dex */
class MaterialButtonHelper {
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private boolean checkable;
    private int cornerRadius;
    private int elevation;
    private int insetBottom;
    private int insetLeft;
    private int insetRight;
    private int insetTop;
    private Drawable maskDrawable;
    private final MaterialButton materialButton;
    private ColorStateList rippleColor;
    private LayerDrawable rippleDrawable;
    private ShapeAppearanceModel shapeAppearanceModel;
    private ColorStateList strokeColor;
    private int strokeWidth;
    private static final boolean IS_MIN_LOLLIPOP = true;
    private static final boolean IS_LOLLIPOP = false;
    private boolean shouldDrawSurfaceColorStroke = false;
    private boolean backgroundOverwritten = false;
    private boolean cornerRadiusSet = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MaterialButtonHelper(MaterialButton materialButton, ShapeAppearanceModel shapeAppearanceModel) {
        this.materialButton = materialButton;
        this.shapeAppearanceModel = shapeAppearanceModel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void loadFromAttributes(TypedArray typedArray) {
        this.insetLeft = typedArray.getDimensionPixelOffset(C0903R.styleable.MaterialButton_android_insetLeft, 0);
        this.insetRight = typedArray.getDimensionPixelOffset(C0903R.styleable.MaterialButton_android_insetRight, 0);
        this.insetTop = typedArray.getDimensionPixelOffset(C0903R.styleable.MaterialButton_android_insetTop, 0);
        this.insetBottom = typedArray.getDimensionPixelOffset(C0903R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(C0903R.styleable.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(C0903R.styleable.MaterialButton_cornerRadius, -1);
            this.cornerRadius = dimensionPixelSize;
            setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(dimensionPixelSize));
            this.cornerRadiusSet = true;
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(C0903R.styleable.MaterialButton_strokeWidth, 0);
        this.backgroundTintMode = ViewUtils.parseTintMode(typedArray.getInt(C0903R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.backgroundTint = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, C0903R.styleable.MaterialButton_backgroundTint);
        this.strokeColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, C0903R.styleable.MaterialButton_strokeColor);
        this.rippleColor = MaterialResources.getColorStateList(this.materialButton.getContext(), typedArray, C0903R.styleable.MaterialButton_rippleColor);
        this.checkable = typedArray.getBoolean(C0903R.styleable.MaterialButton_android_checkable, false);
        this.elevation = typedArray.getDimensionPixelSize(C0903R.styleable.MaterialButton_elevation, 0);
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        if (typedArray.hasValue(C0903R.styleable.MaterialButton_android_background)) {
            setBackgroundOverwritten();
        } else {
            updateBackground();
        }
        ViewCompat.setPaddingRelative(this.materialButton, paddingStart + this.insetLeft, paddingTop + this.insetTop, paddingEnd + this.insetRight, paddingBottom + this.insetBottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateBackground() {
        this.materialButton.setInternalBackground(createBackground());
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(this.elevation);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setBackgroundOverwritten() {
        this.backgroundOverwritten = true;
        this.materialButton.setSupportBackgroundTintList(this.backgroundTint);
        this.materialButton.setSupportBackgroundTintMode(this.backgroundTintMode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isBackgroundOverwritten() {
        return this.backgroundOverwritten;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InsetDrawable wrapDrawableWithInset(Drawable drawable) {
        return new InsetDrawable(drawable, this.insetLeft, this.insetTop, this.insetRight, this.insetBottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.backgroundTint != colorStateList) {
            this.backgroundTint = colorStateList;
            if (getMaterialShapeDrawable() != null) {
                DrawableCompat.setTintList(getMaterialShapeDrawable(), this.backgroundTint);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getSupportBackgroundTintList() {
        return this.backgroundTint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.backgroundTintMode != mode) {
            this.backgroundTintMode = mode;
            if (getMaterialShapeDrawable() == null || this.backgroundTintMode == null) {
                return;
            }
            DrawableCompat.setTintMode(getMaterialShapeDrawable(), this.backgroundTintMode);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setShouldDrawSurfaceColorStroke(boolean z) {
        this.shouldDrawSurfaceColorStroke = z;
        updateStroke();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Drawable createBackground() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable.initializeElevationOverlay(this.materialButton.getContext());
        DrawableCompat.setTintList(materialShapeDrawable, this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            DrawableCompat.setTintMode(materialShapeDrawable, mode);
        }
        materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        materialShapeDrawable2.setTint(0);
        materialShapeDrawable2.setStroke(this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, C0903R.attr.colorSurface) : 0);
        if (IS_MIN_LOLLIPOP) {
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.maskDrawable = materialShapeDrawable3;
            DrawableCompat.setTint(materialShapeDrawable3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), wrapDrawableWithInset(new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable})), this.maskDrawable);
            this.rippleDrawable = rippleDrawable;
            return rippleDrawable;
        }
        RippleDrawableCompat rippleDrawableCompat = new RippleDrawableCompat(this.shapeAppearanceModel);
        this.maskDrawable = rippleDrawableCompat;
        DrawableCompat.setTintList(rippleDrawableCompat, RippleUtils.sanitizeRippleDrawableColor(this.rippleColor));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable, this.maskDrawable});
        this.rippleDrawable = layerDrawable;
        return wrapDrawableWithInset(layerDrawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateMaskBounds(int i, int i2) {
        Drawable drawable = this.maskDrawable;
        if (drawable != null) {
            drawable.setBounds(this.insetLeft, this.insetTop, i2 - this.insetRight, i - this.insetBottom);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setBackgroundColor(int i) {
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setTint(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            boolean z = IS_MIN_LOLLIPOP;
            if (z && (this.materialButton.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.materialButton.getBackground()).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            } else {
                if (z || !(this.materialButton.getBackground() instanceof RippleDrawableCompat)) {
                    return;
                }
                ((RippleDrawableCompat) this.materialButton.getBackground()).setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor != colorStateList) {
            this.strokeColor = colorStateList;
            updateStroke();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ColorStateList getStrokeColor() {
        return this.strokeColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setStrokeWidth(int i) {
        if (this.strokeWidth != i) {
            this.strokeWidth = i;
            updateStroke();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateStroke() {
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable();
        MaterialShapeDrawable surfaceColorStrokeDrawable = getSurfaceColorStrokeDrawable();
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setStroke(this.strokeWidth, this.strokeColor);
            if (surfaceColorStrokeDrawable != null) {
                surfaceColorStrokeDrawable.setStroke(this.strokeWidth, this.shouldDrawSurfaceColorStroke ? MaterialColors.getColor(this.materialButton, C0903R.attr.colorSurface) : 0);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setCornerRadius(int i) {
        if (this.cornerRadiusSet && this.cornerRadius == i) {
            return;
        }
        this.cornerRadius = i;
        this.cornerRadiusSet = true;
        setShapeAppearanceModel(this.shapeAppearanceModel.withCornerSize(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCornerRadius() {
        return this.cornerRadius;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (IS_MIN_LOLLIPOP) {
            return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
        }
        return (MaterialShapeDrawable) this.rippleDrawable.getDrawable(!z ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MaterialShapeDrawable getMaterialShapeDrawable() {
        return getMaterialShapeDrawable(false);
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
    private MaterialShapeDrawable getSurfaceColorStrokeDrawable() {
        return getMaterialShapeDrawable(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateButtonShape(ShapeAppearanceModel shapeAppearanceModel) {
        if (IS_LOLLIPOP && !this.backgroundOverwritten) {
            int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
            int paddingTop = this.materialButton.getPaddingTop();
            int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
            int paddingBottom = this.materialButton.getPaddingBottom();
            updateBackground();
            ViewCompat.setPaddingRelative(this.materialButton, paddingStart, paddingTop, paddingEnd, paddingBottom);
            return;
        }
        if (getMaterialShapeDrawable() != null) {
            getMaterialShapeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getSurfaceColorStrokeDrawable() != null) {
            getSurfaceColorStrokeDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (getMaskDrawable() != null) {
            getMaskDrawable().setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Shapeable getMaskDrawable() {
        LayerDrawable layerDrawable = this.rippleDrawable;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.rippleDrawable.getNumberOfLayers() > 2) {
            return (Shapeable) this.rippleDrawable.getDrawable(2);
        }
        return (Shapeable) this.rippleDrawable.getDrawable(1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        updateButtonShape(shapeAppearanceModel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInsetBottom(int i) {
        setVerticalInsets(this.insetTop, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getInsetBottom() {
        return this.insetBottom;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInsetTop(int i) {
        setVerticalInsets(i, this.insetBottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setVerticalInsets(int i, int i2) {
        int paddingStart = ViewCompat.getPaddingStart(this.materialButton);
        int paddingTop = this.materialButton.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.materialButton);
        int paddingBottom = this.materialButton.getPaddingBottom();
        int i3 = this.insetTop;
        int i4 = this.insetBottom;
        this.insetBottom = i2;
        this.insetTop = i;
        if (!this.backgroundOverwritten) {
            updateBackground();
        }
        ViewCompat.setPaddingRelative(this.materialButton, paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getInsetTop() {
        return this.insetTop;
    }
}
