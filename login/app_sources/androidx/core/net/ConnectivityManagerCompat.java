package androidx.core.net;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class ConnectivityManagerCompat {
    public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
    public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
    public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RestrictBackgroundStatus {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
        return Api16Impl.isActiveNetworkMetered(connectivityManager);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NetworkInfo getNetworkInfoFromBroadcast(ConnectivityManager connectivityManager, Intent intent) {
        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
        if (networkInfo != null) {
            return connectivityManager.getNetworkInfo(networkInfo.getType());
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
        return Api24Impl.getRestrictBackgroundStatus(connectivityManager);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConnectivityManagerCompat() {
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager) {
            return connectivityManager.isActiveNetworkMetered();
        }
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getRestrictBackgroundStatus(ConnectivityManager connectivityManager) {
            return connectivityManager.getRestrictBackgroundStatus();
        }
    }
}
