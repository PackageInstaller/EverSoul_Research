package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.C0903R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes2.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayAccentColor;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ElevationOverlayProvider(Context context) {
        this(MaterialAttributes.resolveBoolean(context, C0903R.attr.elevationOverlayEnabled, false), MaterialColors.getColor(context, C0903R.attr.elevationOverlayColor, 0), MaterialColors.getColor(context, C0903R.attr.elevationOverlayAccentColor, 0), MaterialColors.getColor(context, C0903R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ElevationOverlayProvider(boolean z, int i, int i2, int i3, float f) {
        this.elevationOverlayEnabled = z;
        this.elevationOverlayColor = i;
        this.elevationOverlayAccentColor = i2;
        this.colorSurface = i3;
        this.displayDensity = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f, View view) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(f + getParentAbsoluteElevation(view));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f) {
        return compositeOverlayIfNeeded(this.colorSurface, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int compositeOverlayIfNeeded(int i, float f, View view) {
        return compositeOverlayIfNeeded(i, f + getParentAbsoluteElevation(view));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int compositeOverlayIfNeeded(int i, float f) {
        return (this.elevationOverlayEnabled && isThemeSurfaceColor(i)) ? compositeOverlay(i, f) : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int compositeOverlay(int i, float f, View view) {
        return compositeOverlay(i, f + getParentAbsoluteElevation(view));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int compositeOverlay(int i, float f) {
        int i2;
        float calculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f);
        int alpha = Color.alpha(i);
        int layer = MaterialColors.layer(ColorUtils.setAlphaComponent(i, 255), this.elevationOverlayColor, calculateOverlayAlphaFraction);
        if (calculateOverlayAlphaFraction > 0.0f && (i2 = this.elevationOverlayAccentColor) != 0) {
            layer = MaterialColors.layer(layer, ColorUtils.setAlphaComponent(i2, OVERLAY_ACCENT_COLOR_ALPHA));
        }
        return ColorUtils.setAlphaComponent(layer, alpha);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int calculateOverlayAlpha(float f) {
        return Math.round(calculateOverlayAlphaFraction(f) * 255.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float calculateOverlayAlphaFraction(float f) {
        if (this.displayDensity <= 0.0f || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f / r0)) * FORMULA_MULTIPLIER) + 2.0f) / 100.0f, 1.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getParentAbsoluteElevation(View view) {
        return ViewUtils.getParentAbsoluteElevation(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isThemeSurfaceColor(int i) {
        return ColorUtils.setAlphaComponent(i, 255) == this.colorSurface;
    }
}
