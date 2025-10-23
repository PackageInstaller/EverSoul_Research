package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import kotlin.time.DurationKt;

/* loaded from: classes.dex */
public class BuildCompat {
    public static final int AD_SERVICES_EXTENSION_INT;
    public static final int R_EXTENSION_INT;
    public static final int S_EXTENSION_INT;
    public static final int T_EXTENSION_INT;

    public @interface PrereleaseSdkCheck {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastN() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BuildCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static boolean isAtLeastPreReleaseCodename(String str, String str2) {
        return !"REL".equals(str2) && str2.toUpperCase(Locale.ROOT).compareTo(str.toUpperCase(Locale.ROOT)) >= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastNMR1() {
        return Build.VERSION.SDK_INT >= 25;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastOMR1() {
        return Build.VERSION.SDK_INT >= 27;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31 || (Build.VERSION.SDK_INT >= 30 && isAtLeastPreReleaseCodename("S", Build.VERSION.CODENAME));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isAtLeastSv2() {
        return Build.VERSION.SDK_INT >= 32 || (Build.VERSION.SDK_INT >= 31 && isAtLeastPreReleaseCodename("Sv2", Build.VERSION.CODENAME));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAtLeastT() {
        return Build.VERSION.SDK_INT >= 33 || (Build.VERSION.SDK_INT >= 32 && isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAtLeastU() {
        return Build.VERSION.SDK_INT >= 33 && isAtLeastPreReleaseCodename("UpsideDownCake", Build.VERSION.CODENAME);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        R_EXTENSION_INT = Build.VERSION.SDK_INT >= 30 ? Extensions30Impl.f80R : 0;
        S_EXTENSION_INT = Build.VERSION.SDK_INT >= 30 ? Extensions30Impl.f81S : 0;
        T_EXTENSION_INT = Build.VERSION.SDK_INT >= 30 ? Extensions30Impl.TIRAMISU : 0;
        AD_SERVICES_EXTENSION_INT = Build.VERSION.SDK_INT >= 30 ? Extensions30Impl.AD_SERVICES : 0;
    }

    private static final class Extensions30Impl {

        /* renamed from: R */
        static final int f80R = SdkExtensions.getExtensionVersion(30);

        /* renamed from: S */
        static final int f81S = SdkExtensions.getExtensionVersion(31);
        static final int TIRAMISU = SdkExtensions.getExtensionVersion(33);
        static final int AD_SERVICES = SdkExtensions.getExtensionVersion(DurationKt.NANOS_IN_MILLIS);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Extensions30Impl() {
        }
    }
}
