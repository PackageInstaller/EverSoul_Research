package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import com.google.android.material.C0903R;
import com.kakaogame.idp.IdpAccount;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DynamicColors {
    private static final Precondition ALWAYS_ALLOW;
    private static final DeviceSupportCondition DEFAULT_DEVICE_SUPPORT_CONDITION;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_BRANDS;
    private static final Map<String, DeviceSupportCondition> DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS;
    private static final int[] DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE = {C0903R.attr.dynamicColorThemeOverlay};
    private static final DeviceSupportCondition SAMSUNG_DEVICE_SUPPORT_CONDITION;
    private static final int USE_DEFAULT_THEME_OVERLAY = 0;

    private interface DeviceSupportCondition {
        boolean isSupported();
    }

    public interface Precondition {
        boolean shouldApplyDynamicColors(Activity activity, int i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        DeviceSupportCondition deviceSupportCondition = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean isSupported() {
                return true;
            }
        };
        DEFAULT_DEVICE_SUPPORT_CONDITION = deviceSupportCondition;
        DeviceSupportCondition deviceSupportCondition2 = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.2
            private Long version;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean isSupported() {
                if (this.version == null) {
                    try {
                        Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                        declaredMethod.setAccessible(true);
                        this.version = Long.valueOf(((Long) declaredMethod.invoke(null, "ro.build.version.oneui")).longValue());
                    } catch (Exception unused) {
                        this.version = -1L;
                    }
                }
                return this.version.longValue() >= 40100;
            }
        };
        SAMSUNG_DEVICE_SUPPORT_CONDITION = deviceSupportCondition2;
        HashMap hashMap = new HashMap();
        hashMap.put("oppo", deviceSupportCondition);
        hashMap.put("realme", deviceSupportCondition);
        hashMap.put("oneplus", deviceSupportCondition);
        hashMap.put("vivo", deviceSupportCondition);
        hashMap.put("xiaomi", deviceSupportCondition);
        hashMap.put("motorola", deviceSupportCondition);
        hashMap.put("itel", deviceSupportCondition);
        hashMap.put("tecno mobile limited", deviceSupportCondition);
        hashMap.put("infinix mobility limited", deviceSupportCondition);
        hashMap.put("hmd global", deviceSupportCondition);
        hashMap.put("sharp", deviceSupportCondition);
        hashMap.put("sony", deviceSupportCondition);
        hashMap.put("tcl", deviceSupportCondition);
        hashMap.put("lenovo", deviceSupportCondition);
        hashMap.put("lge", deviceSupportCondition);
        hashMap.put(IdpAccount.IdpCode.GOOGLE, deviceSupportCondition);
        hashMap.put("robolectric", deviceSupportCondition);
        hashMap.put("samsung", deviceSupportCondition2);
        DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("asus", deviceSupportCondition);
        hashMap2.put("jio", deviceSupportCondition);
        DYNAMIC_COLOR_SUPPORTED_BRANDS = Collections.unmodifiableMap(hashMap2);
        ALWAYS_ALLOW = new Precondition() { // from class: com.google.android.material.color.DynamicColors.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.material.color.DynamicColors.Precondition
            public boolean shouldApplyDynamicColors(Activity activity, int i) {
                return true;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DynamicColors() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyToActivitiesIfAvailable(Application application) {
        applyToActivitiesIfAvailable(application, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyToActivitiesIfAvailable(Application application, int i) {
        applyToActivitiesIfAvailable(application, i, ALWAYS_ALLOW);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyToActivitiesIfAvailable(Application application, Precondition precondition) {
        applyToActivitiesIfAvailable(application, 0, precondition);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyToActivitiesIfAvailable(Application application, int i, Precondition precondition) {
        application.registerActivityLifecycleCallbacks(new DynamicColorsActivityLifecycleCallbacks(i, precondition));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyIfAvailable(Activity activity) {
        applyIfAvailable(activity, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyIfAvailable(Activity activity, int i) {
        applyIfAvailable(activity, i, ALWAYS_ALLOW);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyIfAvailable(Activity activity, Precondition precondition) {
        applyIfAvailable(activity, 0, precondition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyIfAvailable(Activity activity, int i, Precondition precondition) {
        if (isDynamicColorAvailable()) {
            if (i == 0) {
                i = getDefaultThemeOverlay(activity);
            }
            if (i == 0 || !precondition.shouldApplyDynamicColors(activity, i)) {
                return;
            }
            activity.setTheme(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Context wrapContextIfAvailable(Context context) {
        return wrapContextIfAvailable(context, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Context wrapContextIfAvailable(Context context, int i) {
        if (!isDynamicColorAvailable()) {
            return context;
        }
        if (i == 0) {
            i = getDefaultThemeOverlay(context);
        }
        return i == 0 ? context : new ContextThemeWrapper(context, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isDynamicColorAvailable() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        DeviceSupportCondition deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_MANUFACTURERS.get(Build.MANUFACTURER.toLowerCase());
        if (deviceSupportCondition == null) {
            deviceSupportCondition = DYNAMIC_COLOR_SUPPORTED_BRANDS.get(Build.BRAND.toLowerCase());
        }
        return deviceSupportCondition != null && deviceSupportCondition.isSupported();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int getDefaultThemeOverlay(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(DYNAMIC_COLOR_THEME_OVERLAY_ATTRIBUTE);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        private final int dynamicColorThemeOverlay;
        private final Precondition precondition;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DynamicColorsActivityLifecycleCallbacks(int i, Precondition precondition) {
            this.dynamicColorThemeOverlay = i;
            this.precondition = precondition;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            DynamicColors.applyIfAvailable(activity, this.dynamicColorThemeOverlay, this.precondition);
        }
    }
}
