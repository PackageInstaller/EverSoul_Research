package com.google.android.material.color;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.C0903R;
import com.google.android.material.resources.MaterialAttributes;

/* loaded from: classes2.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int TONE_ACCENT_CONTAINER_DARK = 20;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 70;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 80;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 10;
    private static final int TONE_ON_ACCENT_LIGHT = 100;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MaterialColors() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getColor(View view, int i) {
        return MaterialAttributes.resolveOrThrow(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getColor(Context context, int i, String str) {
        return MaterialAttributes.resolveOrThrow(context, i, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getColor(View view, int i, int i2) {
        return getColor(view.getContext(), i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getColor(Context context, int i, int i2) {
        TypedValue resolve = MaterialAttributes.resolve(context, i);
        return resolve != null ? resolve.data : i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int layer(View view, int i, int i2) {
        return layer(view, i, i2, 1.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int layer(View view, int i, int i2, float f) {
        return layer(getColor(view, i), getColor(view, i2), f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int layer(int i, int i2, float f) {
        return layer(i, androidx.core.graphics.ColorUtils.setAlphaComponent(i2, Math.round(Color.alpha(i2) * f)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int layer(int i, int i2) {
        return androidx.core.graphics.ColorUtils.compositeColors(i2, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int compositeARGBWithAlpha(int i, int i2) {
        return androidx.core.graphics.ColorUtils.setAlphaComponent(i, (Color.alpha(i) * i2) / 255);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isColorLight(int i) {
        return i != 0 && androidx.core.graphics.ColorUtils.calculateLuminance(i) > 0.5d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int harmonizeWithPrimary(Context context, int i) {
        return harmonize(i, getColor(context, C0903R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int harmonize(int i, int i2) {
        return Blend.harmonize(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorRoles getColorRoles(Context context, int i) {
        return getColorRoles(i, MaterialAttributes.resolveBoolean(context, C0903R.attr.isLightTheme, true));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorRoles getColorRoles(int i, boolean z) {
        if (z) {
            return new ColorRoles(getColorRole(i, 40), getColorRole(i, 100), getColorRole(i, 90), getColorRole(i, 10));
        }
        return new ColorRoles(getColorRole(i, 70), getColorRole(i, 10), getColorRole(i, 20), getColorRole(i, 80));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getColorRole(int i, int i2) {
        Hct fromInt = Hct.fromInt(i);
        fromInt.setTone(i2);
        return fromInt.toInt();
    }
}
