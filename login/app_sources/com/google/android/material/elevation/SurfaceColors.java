package com.google.android.material.elevation;

import android.content.Context;
import com.google.android.material.C0903R;
import com.google.android.material.color.MaterialColors;

/* loaded from: classes2.dex */
public enum SurfaceColors {
    SURFACE_0(C0903R.dimen.m3_sys_elevation_level0),
    SURFACE_1(C0903R.dimen.m3_sys_elevation_level1),
    SURFACE_2(C0903R.dimen.m3_sys_elevation_level2),
    SURFACE_3(C0903R.dimen.m3_sys_elevation_level3),
    SURFACE_4(C0903R.dimen.m3_sys_elevation_level4),
    SURFACE_5(C0903R.dimen.m3_sys_elevation_level5);

    private final int elevationResId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SurfaceColors(int i) {
        this.elevationResId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getColor(Context context) {
        return getColorForElevation(context, context.getResources().getDimension(this.elevationResId));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getColorForElevation(Context context, float f) {
        return new ElevationOverlayProvider(context).compositeOverlay(MaterialColors.getColor(context, C0903R.attr.colorSurface, 0), f);
    }
}
