package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.text.BidiFormatter;
import androidx.core.view.ViewCompat;
import com.google.android.material.C0903R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class ChipDrawable extends MaterialShapeDrawable implements TintAwareDrawable, Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final int MAX_CHIP_ICON_HEIGHT = 24;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private int alpha;
    private boolean checkable;
    private Drawable checkedIcon;
    private ColorStateList checkedIconTint;
    private boolean checkedIconVisible;
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private Drawable chipIcon;
    private float chipIconSize;
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint;
    private float chipStartPadding;
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private ColorStateList chipSurfaceColor;
    private Drawable closeIcon;
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private ColorFilter colorFilter;
    private ColorStateList compatRippleColor;
    private final Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentChipSurfaceColor;
    private int currentCompatRippleColor;
    private int currentCompositeSurfaceBackgroundColor;
    private int currentTextColor;
    private int currentTint;
    private final Paint debugPaint;
    private WeakReference<Delegate> delegate;
    private final Paint.FontMetrics fontMetrics;
    private boolean hasChipIconTint;
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF;
    private final RectF rectF;
    private ColorStateList rippleColor;
    private final Path shapePath;
    private boolean shouldDrawText;
    private MotionSpec showMotionSpec;
    private CharSequence text;
    private final TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;
    private ColorStateList tint;
    private PorterDuffColorFilter tintFilter;
    private PorterDuff.Mode tintMode;
    private TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;
    private static final int[] DEFAULT_STATE = {R.attr.state_enabled};
    private static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ChipDrawable createFromAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        ChipDrawable chipDrawable = new ChipDrawable(context, attributeSet, i, i2);
        chipDrawable.loadFromAttributes(attributeSet, i, i2);
        return chipDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ChipDrawable createFromResource(Context context, int i) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context, i, "chip");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = C0903R.style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context, parseDrawableXml, C0903R.attr.chipStandaloneStyle, styleAttribute);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ChipDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.chipCornerRadius = -1.0f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint.FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 255;
        this.tintMode = PorterDuff.Mode.SRC_IN;
        this.delegate = new WeakReference<>(null);
        initializeElevationOverlay(context);
        this.context = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        this.text = "";
        textDrawableHelper.getTextPaint().density = context.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] iArr = DEFAULT_STATE;
        setState(iArr);
        setCloseIconState(iArr);
        this.shouldDrawText = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            closeIconRippleMask.setTint(-1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void loadFromAttributes(AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(this.context, attributeSet, C0903R.styleable.Chip, i, i2, new int[0]);
        this.isShapeThemingEnabled = obtainStyledAttributes.hasValue(C0903R.styleable.Chip_shapeAppearance);
        setChipSurfaceColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C0903R.styleable.Chip_chipSurfaceColor));
        setChipBackgroundColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C0903R.styleable.Chip_chipBackgroundColor));
        setChipMinHeight(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_chipMinHeight, 0.0f));
        if (obtainStyledAttributes.hasValue(C0903R.styleable.Chip_chipCornerRadius)) {
            setChipCornerRadius(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_chipCornerRadius, 0.0f));
        }
        setChipStrokeColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C0903R.styleable.Chip_chipStrokeColor));
        setChipStrokeWidth(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_chipStrokeWidth, 0.0f));
        setRippleColor(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C0903R.styleable.Chip_rippleColor));
        setText(obtainStyledAttributes.getText(C0903R.styleable.Chip_android_text));
        TextAppearance textAppearance = MaterialResources.getTextAppearance(this.context, obtainStyledAttributes, C0903R.styleable.Chip_android_textAppearance);
        textAppearance.setTextSize(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_android_textSize, textAppearance.getTextSize()));
        setTextAppearance(textAppearance);
        int i3 = obtainStyledAttributes.getInt(C0903R.styleable.Chip_android_ellipsize, 0);
        if (i3 == 1) {
            setEllipsize(TextUtils.TruncateAt.START);
        } else if (i3 == 2) {
            setEllipsize(TextUtils.TruncateAt.MIDDLE);
        } else if (i3 == 3) {
            setEllipsize(TextUtils.TruncateAt.END);
        }
        setChipIconVisible(obtainStyledAttributes.getBoolean(C0903R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "chipIconVisible") == null) {
            setChipIconVisible(obtainStyledAttributes.getBoolean(C0903R.styleable.Chip_chipIconEnabled, false));
        }
        setChipIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, C0903R.styleable.Chip_chipIcon));
        if (obtainStyledAttributes.hasValue(C0903R.styleable.Chip_chipIconTint)) {
            setChipIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C0903R.styleable.Chip_chipIconTint));
        }
        setChipIconSize(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_chipIconSize, -1.0f));
        setCloseIconVisible(obtainStyledAttributes.getBoolean(C0903R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "closeIconVisible") == null) {
            setCloseIconVisible(obtainStyledAttributes.getBoolean(C0903R.styleable.Chip_closeIconEnabled, false));
        }
        setCloseIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, C0903R.styleable.Chip_closeIcon));
        setCloseIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C0903R.styleable.Chip_closeIconTint));
        setCloseIconSize(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_closeIconSize, 0.0f));
        setCheckable(obtainStyledAttributes.getBoolean(C0903R.styleable.Chip_android_checkable, false));
        setCheckedIconVisible(obtainStyledAttributes.getBoolean(C0903R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconEnabled") != null && attributeSet.getAttributeValue(NAMESPACE_APP, "checkedIconVisible") == null) {
            setCheckedIconVisible(obtainStyledAttributes.getBoolean(C0903R.styleable.Chip_checkedIconEnabled, false));
        }
        setCheckedIcon(MaterialResources.getDrawable(this.context, obtainStyledAttributes, C0903R.styleable.Chip_checkedIcon));
        if (obtainStyledAttributes.hasValue(C0903R.styleable.Chip_checkedIconTint)) {
            setCheckedIconTint(MaterialResources.getColorStateList(this.context, obtainStyledAttributes, C0903R.styleable.Chip_checkedIconTint));
        }
        setShowMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, C0903R.styleable.Chip_showMotionSpec));
        setHideMotionSpec(MotionSpec.createFromAttribute(this.context, obtainStyledAttributes, C0903R.styleable.Chip_hideMotionSpec));
        setChipStartPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_chipStartPadding, 0.0f));
        setIconStartPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_iconStartPadding, 0.0f));
        setIconEndPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_iconEndPadding, 0.0f));
        setTextStartPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_textStartPadding, 0.0f));
        setTextEndPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_textEndPadding, 0.0f));
        setCloseIconStartPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_closeIconStartPadding, 0.0f));
        setCloseIconEndPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_closeIconEndPadding, 0.0f));
        setChipEndPadding(obtainStyledAttributes.getDimension(C0903R.styleable.Chip_chipEndPadding, 0.0f));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(C0903R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUseCompatRipple(boolean z) {
        if (this.useCompatRipple != z) {
            this.useCompatRipple = z;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDelegate(Delegate delegate) {
        this.delegate = new WeakReference<>(delegate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onSizeChange() {
        Delegate delegate = this.delegate.get();
        if (delegate != null) {
            delegate.onChipDrawableSizeChange();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getChipTouchBounds(RectF rectF) {
        calculateChipTouchBounds(getBounds(), rectF);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getCloseIconTouchBounds(RectF rectF) {
        calculateCloseIconTouchBounds(getBounds(), rectF);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean canShowCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.checkable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + getCurrentChipIconWidth() + this.iconEndPadding;
        }
        return 0.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float getCurrentChipIconWidth() {
        Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
        float f = this.chipIconSize;
        return (f > 0.0f || drawable == null) ? f : drawable.getIntrinsicWidth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float getCurrentChipIconHeight() {
        Drawable drawable = this.currentChecked ? this.checkedIcon : this.chipIcon;
        float f = this.chipIconSize;
        if (f <= 0.0f && drawable != null) {
            f = (float) Math.ceil(ViewUtils.dpToPx(this.context, 24));
            if (drawable.getIntrinsicHeight() <= f) {
                return drawable.getIntrinsicHeight();
            }
        }
        return f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int saveLayerAlpha = this.alpha < 255 ? CanvasCompat.saveLayerAlpha(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, this.alpha) : 0;
        drawChipSurface(canvas, bounds);
        drawChipBackground(canvas, bounds);
        if (this.isShapeThemingEnabled) {
            super.draw(canvas);
        }
        drawChipStroke(canvas, bounds);
        drawCompatRipple(canvas, bounds);
        drawChipIcon(canvas, bounds);
        drawCheckedIcon(canvas, bounds);
        if (this.shouldDrawText) {
            drawText(canvas, bounds);
        }
        drawCloseIcon(canvas, bounds);
        drawDebug(canvas, bounds);
        if (this.alpha < 255) {
            canvas.restoreToCount(saveLayerAlpha);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawChipSurface(Canvas canvas, Rect rect) {
        if (this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipSurfaceColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawChipBackground(Canvas canvas, Rect rect) {
        if (this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipBackgroundColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.chipPaint.setColorFilter(getTintColorFilter());
        this.rectF.set(rect);
        canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawChipStroke(Canvas canvas, Rect rect) {
        if (this.chipStrokeWidth <= 0.0f || this.isShapeThemingEnabled) {
            return;
        }
        this.chipPaint.setColor(this.currentChipStrokeColor);
        this.chipPaint.setStyle(Paint.Style.STROKE);
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColorFilter(getTintColorFilter());
        }
        this.rectF.set(rect.left + (this.chipStrokeWidth / 2.0f), rect.top + (this.chipStrokeWidth / 2.0f), rect.right - (this.chipStrokeWidth / 2.0f), rect.bottom - (this.chipStrokeWidth / 2.0f));
        float f = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
        canvas.drawRoundRect(this.rectF, f, f, this.chipPaint);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawCompatRipple(Canvas canvas, Rect rect) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(rect);
        if (!this.isShapeThemingEnabled) {
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        } else {
            calculatePathForSize(new RectF(rect), this.shapePath);
            super.drawShape(canvas, this.chipPaint, this.shapePath, getBoundsAsRectF());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawChipIcon(Canvas canvas, Rect rect) {
        if (showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawCheckedIcon(Canvas canvas, Rect rect) {
        if (showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawText(Canvas canvas, Rect rect) {
        if (this.text != null) {
            Paint.Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }
            this.textDrawableHelper.getTextPaint().setTextAlign(calculateTextOriginAndAlignment);
            int i = 0;
            boolean z = Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > Math.round(this.rectF.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.rectF);
            }
            CharSequence charSequence = this.text;
            if (z && this.truncateAt != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }
            CharSequence charSequence2 = charSequence;
            canvas.drawText(charSequence2, 0, charSequence2.length(), this.pointF.x, this.pointF.y, this.textDrawableHelper.getTextPaint());
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawCloseIcon(Canvas canvas, Rect rect) {
        if (showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas);
            } else {
                this.closeIcon.draw(canvas);
            }
            canvas.translate(-f, -f2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void drawDebug(Canvas canvas, Rect rect) {
        Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setColor(ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, 127));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.text != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.debugPaint);
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            calculateChipTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void calculateChipIconBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            float currentChipIconWidth = getCurrentChipIconWidth();
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + currentChipIconWidth;
            } else {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - currentChipIconWidth;
            }
            float currentChipIconHeight = getCurrentChipIconHeight();
            rectF.top = rect.exactCenterY() - (currentChipIconHeight / 2.0f);
            rectF.bottom = rectF.top + currentChipIconHeight;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Paint.Align calculateTextOriginAndAlignment(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + calculateChipIconWidth;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - calculateChipIconWidth;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - calculateTextCenterFromBaseline();
        }
        return align;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void calculateTextBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            float calculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + calculateChipIconWidth;
                rectF.right = rect.right - calculateCloseIconWidth;
            } else {
                rectF.left = rect.left + calculateCloseIconWidth;
                rectF.right = rect.right - calculateChipIconWidth;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void calculateCloseIconBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.closeIconSize;
            } else {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.closeIconSize;
            }
            rectF.top = rect.exactCenterY() - (this.closeIconSize / 2.0f);
            rectF.bottom = rectF.top + this.closeIconSize;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void calculateChipTouchBounds(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void calculateCloseIconTouchBounds(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f;
            } else {
                rectF.left = rect.left;
                rectF.right = rect.left + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor) || (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textDrawableHelper.getTextAppearance()) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setCloseIconState(int[] iArr) {
        if (Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, getCloseIconState());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean onStateChange(int[] iArr, int[] iArr2) {
        boolean z;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.chipSurfaceColor;
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(colorStateList != null ? colorStateList.getColorForState(iArr, this.currentChipSurfaceColor) : 0);
        boolean z2 = true;
        if (this.currentChipSurfaceColor != compositeElevationOverlayIfNeeded) {
            this.currentChipSurfaceColor = compositeElevationOverlayIfNeeded;
            onStateChange = true;
        }
        ColorStateList colorStateList2 = this.chipBackgroundColor;
        int compositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipBackgroundColor) : 0);
        if (this.currentChipBackgroundColor != compositeElevationOverlayIfNeeded2) {
            this.currentChipBackgroundColor = compositeElevationOverlayIfNeeded2;
            onStateChange = true;
        }
        int layer = MaterialColors.layer(compositeElevationOverlayIfNeeded, compositeElevationOverlayIfNeeded2);
        if ((this.currentCompositeSurfaceBackgroundColor != layer) | (getFillColor() == null)) {
            this.currentCompositeSurfaceBackgroundColor = layer;
            setFillColor(ColorStateList.valueOf(layer));
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.chipStrokeColor;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState) {
            this.currentChipStrokeColor = colorForState;
            onStateChange = true;
        }
        int colorForState2 = (this.compatRippleColor == null || !RippleUtils.shouldDrawRippleCompat(iArr)) ? 0 : this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
        if (this.currentCompatRippleColor != colorForState2) {
            this.currentCompatRippleColor = colorForState2;
            if (this.useCompatRipple) {
                onStateChange = true;
            }
        }
        int colorForState3 = (this.textDrawableHelper.getTextAppearance() == null || this.textDrawableHelper.getTextAppearance().getTextColor() == null) ? 0 : this.textDrawableHelper.getTextAppearance().getTextColor().getColorForState(iArr, this.currentTextColor);
        if (this.currentTextColor != colorForState3) {
            this.currentTextColor = colorForState3;
            onStateChange = true;
        }
        boolean z3 = hasState(getState(), R.attr.state_checked) && this.checkable;
        if (this.currentChecked == z3 || this.checkedIcon == null) {
            z = false;
        } else {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.currentChecked = z3;
            if (calculateChipIconWidth != calculateChipIconWidth()) {
                onStateChange = true;
                z = true;
            } else {
                z = false;
                onStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.tint;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.currentTint) : 0;
        if (this.currentTint != colorForState4) {
            this.currentTint = colorForState4;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, this.tintMode);
        } else {
            z2 = onStateChange;
        }
        if (isStateful(this.chipIcon)) {
            z2 |= this.chipIcon.setState(iArr);
        }
        if (isStateful(this.checkedIcon)) {
            z2 |= this.checkedIcon.setState(iArr);
        }
        if (isStateful(this.closeIcon)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            z2 |= this.closeIcon.setState(iArr3);
        }
        if (RippleUtils.USE_FRAMEWORK_RIPPLE && isStateful(this.closeIconRipple)) {
            z2 |= this.closeIconRipple.setState(iArr2);
        }
        if (z2) {
            invalidateSelf();
        }
        if (z) {
            onSizeChange();
        }
        return z2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isStateful(TextAppearance textAppearance) {
        return (textAppearance == null || textAppearance.getTextColor() == null || !textAppearance.getTextColor().isStateful()) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.chipIcon, i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.checkedIcon, i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.closeIcon, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.alpha;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void applyChildDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.closeIcon) {
            if (drawable.isStateful()) {
                drawable.setState(getCloseIconState());
            }
            DrawableCompat.setTintList(drawable, this.closeIconTint);
            return;
        }
        Drawable drawable2 = this.chipIcon;
        if (drawable == drawable2 && this.hasChipIconTint) {
            DrawableCompat.setTintList(drawable2, this.chipIconTint);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ColorFilter getTintColorFilter() {
        ColorFilter colorFilter = this.colorFilter;
        return colorFilter != null ? colorFilter : this.tintFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateCompatRippleColor() {
        this.compatRippleColor = this.useCompatRipple ? RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setChipSurfaceColor(ColorStateList colorStateList) {
        if (this.chipSurfaceColor != colorStateList) {
            this.chipSurfaceColor = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean hasState(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextSize(float f) {
        TextAppearance textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.setTextSize(f);
            this.textDrawableHelper.getTextPaint().setTextSize(f);
            onTextSizeChange();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipBackgroundColorResource(int i) {
        setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipMinHeightResource(int i) {
        setChipMinHeight(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipMinHeight(float f) {
        if (this.chipMinHeight != f) {
            this.chipMinHeight = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        setChipCornerRadius(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipStrokeColorResource(int i) {
        setChipStrokeColor(AppCompatResources.getColorStateList(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipStrokeWidthResource(int i) {
        setChipStrokeWidth(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            if (this.isShapeThemingEnabled) {
                super.setStrokeWidth(f);
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRippleColorResource(int i) {
        setRippleColor(AppCompatResources.getColorStateList(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getText() {
        return this.text;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextResource(int i) {
        setText(this.context.getResources().getString(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.text, charSequence)) {
            return;
        }
        this.text = charSequence;
        this.textDrawableHelper.setTextWidthDirty(true);
        invalidateSelf();
        onSizeChange();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextAppearanceResource(int i) {
        setTextAppearance(new TextAppearance(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextAppearance(TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.truncateAt = truncateAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIconVisible(int i) {
        setChipIconVisible(this.context.getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getChipIcon() {
        Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIconResource(int i) {
        setChipIcon(AppCompatResources.getDrawable(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIcon(Drawable drawable) {
        Drawable chipIcon = getChipIcon();
        if (chipIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIconTintResource(int i) {
        setChipIconTint(AppCompatResources.getColorStateList(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIconTint(ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                DrawableCompat.setTintList(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getChipIconSize() {
        return this.chipIconSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIconSizeResource(int i) {
        setChipIconSize(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconVisible(int i) {
        setCloseIconVisible(this.context.getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return DrawableCompat.unwrap(drawable);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconResource(int i) {
        setCloseIcon(AppCompatResources.getDrawable(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIcon(Drawable drawable) {
        Drawable closeIcon = getCloseIcon();
        if (closeIcon != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkCloseIconRipple();
            }
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconTintResource(int i) {
        setCloseIconTint(AppCompatResources.getColorStateList(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                DrawableCompat.setTintList(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconSizeResource(int i) {
        setCloseIconSize(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconContentDescription(CharSequence charSequence) {
        if (this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCheckable() {
        return this.checkable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckableResource(int i) {
        setCheckable(this.context.getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedIconVisible(int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedIconResource(int i) {
        setCheckedIcon(AppCompatResources.getDrawable(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedIcon(Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedIconTintResource(int i) {
        setCheckedIconTint(AppCompatResources.getColorStateList(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckedIconTint(ColorStateList colorStateList) {
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (canShowCheckedIcon()) {
                DrawableCompat.setTintList(this.checkedIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipStartPaddingResource(int i) {
        setChipStartPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipStartPadding(float f) {
        if (this.chipStartPadding != f) {
            this.chipStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIconStartPaddingResource(int i) {
        setIconStartPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIconEndPaddingResource(int i) {
        setIconEndPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextStartPaddingResource(int i) {
        setTextStartPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextStartPadding(float f) {
        if (this.textStartPadding != f) {
            this.textStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextEndPaddingResource(int i) {
        setTextEndPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTextEndPadding(float f) {
        if (this.textEndPadding != f) {
            this.textEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconStartPaddingResource(int i) {
        setCloseIconStartPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconEndPaddingResource(int i) {
        setCloseIconEndPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipEndPaddingResource(int i) {
        setChipEndPadding(this.context.getResources().getDimension(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setChipEndPadding(float f) {
        if (this.chipEndPadding != f) {
            this.chipEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setShouldDrawText(boolean z) {
        this.shouldDrawText = z;
    }
}
