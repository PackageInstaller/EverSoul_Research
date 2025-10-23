package androidx.core.content.p002pm;

import android.content.pm.PermissionInfo;
import android.os.Build;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class PermissionInfoCompat {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PermissionInfoCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getProtection(PermissionInfo permissionInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getProtection(permissionInfo);
        }
        return permissionInfo.protectionLevel & 15;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getProtectionFlags(permissionInfo);
        }
        return permissionInfo.protectionLevel & (-16);
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getProtection(PermissionInfo permissionInfo) {
            return permissionInfo.getProtection();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getProtectionFlags(PermissionInfo permissionInfo) {
            return permissionInfo.getProtectionFlags();
        }
    }
}
