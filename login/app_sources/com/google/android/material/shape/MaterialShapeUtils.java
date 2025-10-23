package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes2.dex */
public class MaterialShapeUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MaterialShapeUtils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static CornerTreatment createCornerTreatment(int i) {
        if (i == 0) {
            return new RoundedCornerTreatment();
        }
        if (i == 1) {
            return new CutCornerTreatment();
        }
        return createDefaultCornerTreatment();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static CornerTreatment createDefaultCornerTreatment() {
        return new RoundedCornerTreatment();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static EdgeTreatment createDefaultEdgeTreatment() {
        return new EdgeTreatment();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setElevation(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setParentAbsoluteElevation(View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            setParentAbsoluteElevation(view, (MaterialShapeDrawable) background);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setParentAbsoluteElevation(View view, MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.isElevationOverlayEnabled()) {
            materialShapeDrawable.setParentAbsoluteElevation(ViewUtils.getParentAbsoluteElevation(view));
        }
    }
}
