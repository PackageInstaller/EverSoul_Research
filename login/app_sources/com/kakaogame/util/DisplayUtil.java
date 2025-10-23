package com.kakaogame.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.liapp.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayUtil.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f¨\u0006 "}, m839d2 = {"Lcom/kakaogame/util/DisplayUtil;", "", "()V", "checkCutout", "", "activity", "Landroid/app/Activity;", "checkSystemFontSize", "", "convertDpToPixel", "", "dp", "context", "Landroid/content/Context;", "convertPixelsToDp", "px", "getCurrentWindowMetricsPointCompat", "Landroid/graphics/Point;", "getDisplayHeight", "getDisplayWidth", "getLandscapeDirection", "getNavigationBarHeight", "getRatioWidthPerHeight", "getStatusBarHeight", "getStatusBarHeight2", "isScreenPortrait", "", "isTablet", "isZFlipSubScreenPortrait", "setFullScreenView", "window", "Landroid/view/Window;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DisplayUtil {
    public static final DisplayUtil INSTANCE = new DisplayUtil();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DisplayUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Point getCurrentWindowMetricsPointCompat(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, y.دײܮڳܯ(2051256301));
            WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsets, y.ۮڭڭܬި(862898107));
            Insets insets = windowInsets.getInsets(WindowInsets.Type.navigationBars());
            Intrinsics.checkNotNullExpressionValue(insets, y.٬ݯح׭٩(576285454));
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                insets = Insets.max(insets, Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()));
                Intrinsics.checkNotNullExpressionValue(insets, y.٬ݯح׭٩(576285582));
            }
            return new Point(currentWindowMetrics.getBounds().width() - (insets.right + insets.left), currentWindowMetrics.getBounds().height() - (insets.top + insets.bottom));
        }
        Point point = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(point);
        return point;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int getDisplayWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (Build.VERSION.SDK_INT >= 30) {
            return Resources.getSystem().getDisplayMetrics().widthPixels;
        }
        int i = Build.VERSION.SDK_INT;
        String str = y.ݮڮֲڭܩ(-628267068);
        String str2 = y.ݮڮֲڭܩ(-628942364);
        if (i >= 28) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = context.getSystemService(str2);
            Intrinsics.checkNotNull(systemService, str);
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        }
        Point point = new Point();
        Object systemService2 = context.getSystemService(str2);
        Intrinsics.checkNotNull(systemService2, str);
        ((WindowManager) systemService2).getDefaultDisplay().getSize(point);
        return point.x;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int getDisplayHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (Build.VERSION.SDK_INT >= 30) {
            return Resources.getSystem().getDisplayMetrics().heightPixels;
        }
        int i = Build.VERSION.SDK_INT;
        String str = y.ݮڮֲڭܩ(-628267068);
        String str2 = y.ݮڮֲڭܩ(-628942364);
        if (i >= 28) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = context.getSystemService(str2);
            Intrinsics.checkNotNull(systemService, str);
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }
        Point point = new Point();
        Object systemService2 = context.getSystemService(str2);
        Intrinsics.checkNotNull(systemService2, str);
        ((WindowManager) systemService2).getDefaultDisplay().getSize(point);
        return point.y;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setFullScreenView(Activity activity, Window window) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(window, y.ݮڮֲڭܩ(-628942364));
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            window.getDecorView().setSystemUiVisibility(5894);
        }
        window.addFlags(activity.getWindow().getAttributes().flags);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float convertDpToPixel(float dp, Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        return dp * (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float convertPixelsToDp(float px, Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        return px / (context.getResources().getDisplayMetrics().densityDpi / 160.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getStatusBarHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Rect rect = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rect);
        return window.findViewById(R.id.content).getTop() - rect.top;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getStatusBarHeight2(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        int identifier = activity.getResources().getIdentifier(y.ٲٴݴ״ٰ(1782560536), y.ۮڭڭܬި(862262355), y.ٴسسݬߨ(1392813258));
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getNavigationBarHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        int identifier = activity.getResources().getIdentifier(y.ٲٴݴ״ٰ(1782560536), y.ۮڭڭܬި(862262355), y.ٴسسݬߨ(1392813258));
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void checkSystemFontSize(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Configuration configuration = activity.getResources().getConfiguration();
        if (configuration.fontScale > 1.0d) {
            configuration.fontScale = 1.0f;
            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            Object systemService = activity.getSystemService(y.ݮڮֲڭܩ(-628942364));
            Intrinsics.checkNotNull(systemService, y.ݮڮֲڭܩ(-628267068));
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            displayMetrics.scaledDensity = configuration.fontScale * displayMetrics.density;
            activity.getResources().getDisplayMetrics().setTo(displayMetrics);
            activity.getApplicationContext().createConfigurationContext(configuration);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isScreenPortrait(Activity activity) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (Build.VERSION.SDK_INT >= 30) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display display = activity.getDisplay();
            if (display != null) {
                display.getRealMetrics(displayMetrics);
            }
            i = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        } else {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            i = point.y;
            i2 = point.x;
        }
        return i > i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isZFlipSubScreenPortrait(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        return getDisplayHeight(context) == 748 && getDisplayWidth(context) == 654;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int getLandscapeDirection(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Object systemService = activity.getSystemService(y.ݮڮֲڭܩ(-628942364));
        Intrinsics.checkNotNull(systemService, y.ݮڮֲڭܩ(-628267068));
        int rotation = ((WindowManager) systemService).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            System.out.println((Object) "SCREEN_ORIENTATION_PORTRAIT");
            return -1;
        }
        if (rotation == 1) {
            System.out.println((Object) "SCREEN_ORIENTATION_LANDSCAPE LEFT");
            return 0;
        }
        if (rotation == 2) {
            System.out.println((Object) "SCREEN_ORIENTATION_REVERSE_PORTRAIT");
            return -1;
        }
        if (rotation != 3) {
            return -1;
        }
        System.out.println((Object) "SCREEN_ORIENTATION_REVERSE_LANDSCAPE RIGHT");
        return 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final int checkCutout(Activity activity) {
        int width;
        int i = 0;
        if (activity != null && Build.VERSION.SDK_INT >= 28 && activity.getWindow() != null) {
            DisplayCutout displayCutout = activity.getWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
            if (displayCutout == null) {
                return 0;
            }
            List<Rect> boundingRects = displayCutout.getBoundingRects();
            Intrinsics.checkNotNullExpressionValue(boundingRects, y.٬ݯح׭٩(576362222));
            if (boundingRects.size() == 0) {
                return 0;
            }
            for (Rect rect : boundingRects) {
                if (isScreenPortrait(activity)) {
                    width = rect.height();
                } else {
                    width = rect.width();
                }
                if (width > i) {
                    i = width;
                }
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isTablet(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        float f2 = i;
        float f3 = i2;
        if (Math.min(f2 / f, f3 / f) >= 600.0f) {
            return true;
        }
        float f4 = f2 / displayMetrics.xdpi;
        float f5 = f3 / displayMetrics.ydpi;
        return Math.sqrt((double) ((f4 * f4) + (f5 * f5))) >= 7.0d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float getRatioWidthPerHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Activity activity2 = activity;
        return getDisplayHeight(activity2) / getDisplayWidth(activity2);
    }
}
