package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap<>();
    private final Context mContext;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DisplayManagerCompat(Context context) {
        this.mContext = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        WeakHashMap<Context, DisplayManagerCompat> weakHashMap = sInstances;
        synchronized (weakHashMap) {
            displayManagerCompat = weakHashMap.get(context);
            if (displayManagerCompat == null) {
                displayManagerCompat = new DisplayManagerCompat(context);
                weakHashMap.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Display getDisplay(int i) {
        return Api17Impl.getDisplay((DisplayManager) this.mContext.getSystemService("display"), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Display[] getDisplays() {
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Display[] getDisplays(String str) {
        return Api17Impl.getDisplays((DisplayManager) this.mContext.getSystemService("display"));
    }

    static class Api17Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api17Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Display getDisplay(DisplayManager displayManager, int i) {
            return displayManager.getDisplay(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Display[] getDisplays(DisplayManager displayManager) {
            return displayManager.getDisplays();
        }
    }
}
