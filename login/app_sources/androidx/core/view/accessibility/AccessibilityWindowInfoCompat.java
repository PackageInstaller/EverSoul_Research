package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;

/* loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;
    private final Object mInfo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String typeToString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void recycle() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AccessibilityWindowInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getType() {
        return Api21Impl.getType((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getLayer() {
        return Api21Impl.getLayer((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getRoot() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api21Impl.getRoot((AccessibilityWindowInfo) this.mInfo));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isInPictureInPictureMode() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.isInPictureInPictureMode((AccessibilityWindowInfo) this.mInfo);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityWindowInfoCompat getParent() {
        return wrapNonNullInstance(Api21Impl.getParent((AccessibilityWindowInfo) this.mInfo));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getId() {
        return Api21Impl.getId((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getRegionInScreen(Region region) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.getRegionInScreen((AccessibilityWindowInfo) this.mInfo, region);
            return;
        }
        Rect rect = new Rect();
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, rect);
        region.set(rect);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getBoundsInScreen(Rect rect) {
        Api21Impl.getBoundsInScreen((AccessibilityWindowInfo) this.mInfo, rect);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isActive() {
        return Api21Impl.isActive((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFocused() {
        return Api21Impl.isFocused((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAccessibilityFocused() {
        return Api21Impl.isAccessibilityFocused((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getChildCount() {
        return Api21Impl.getChildCount((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityWindowInfoCompat getChild(int i) {
        return wrapNonNullInstance(Api21Impl.getChild((AccessibilityWindowInfo) this.mInfo, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDisplayId() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getDisplayId((AccessibilityWindowInfo) this.mInfo);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getTitle() {
        return Api24Impl.getTitle((AccessibilityWindowInfo) this.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityNodeInfoCompat getAnchor() {
        return AccessibilityNodeInfoCompat.wrapNonNullInstance(Api24Impl.getAnchor((AccessibilityWindowInfo) this.mInfo));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccessibilityWindowInfoCompat obtain() {
        return wrapNonNullInstance(Api21Impl.obtain());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (accessibilityWindowInfoCompat == null) {
            return null;
        }
        return wrapNonNullInstance(Api21Impl.obtain((AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessibilityWindowInfo unwrap() {
        return (AccessibilityWindowInfo) this.mInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        Object obj2 = this.mInfo;
        if (obj2 == null) {
            return accessibilityWindowInfoCompat.mInfo == null;
        }
        return obj2.equals(accessibilityWindowInfoCompat.mInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("AccessibilityWindowInfo[id=");
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb.append(getId());
        sb.append(", type=").append(typeToString(getType()));
        sb.append(", layer=").append(getLayer());
        sb.append(", bounds=").append(rect);
        sb.append(", focused=").append(isFocused());
        sb.append(", active=").append(isActive());
        sb.append(", hasParent=").append(getParent() != null);
        sb.append(", hasChildren=").append(getChildCount() > 0);
        sb.append(']');
        return sb.toString();
    }

    private static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void getBoundsInScreen(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AccessibilityWindowInfo getChild(AccessibilityWindowInfo accessibilityWindowInfo, int i) {
            return accessibilityWindowInfo.getChild(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getChildCount(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getId(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLayer(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AccessibilityWindowInfo getParent(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AccessibilityNodeInfo getRoot(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getType(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isAccessibilityFocused(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isActive(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isFocused(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AccessibilityWindowInfo obtain() {
            return AccessibilityWindowInfo.obtain();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AccessibilityWindowInfo obtain(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }
    }

    private static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static AccessibilityNodeInfo getAnchor(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getAnchor();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static CharSequence getTitle(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTitle();
        }
    }

    private static class Api33Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api33Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getDisplayId(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getDisplayId();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void getRegionInScreen(AccessibilityWindowInfo accessibilityWindowInfo, Region region) {
            accessibilityWindowInfo.getRegionInScreen(region);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isInPictureInPictureMode(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isInPictureInPictureMode();
        }
    }
}
