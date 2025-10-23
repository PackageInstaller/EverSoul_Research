package com.kakaogame.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.kakaogame.Logger;
import com.liapp.y;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkUtil.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/util/NetworkUtil;", "", "()V", "NETWORK_TYPE_CELLULAR", "", "NETWORK_TYPE_NETWORK", "NETWORK_TYPE_UNKNOWN", "TAG", "getMacAddress", "context", "Landroid/content/Context;", "getNetworkType", "getNetworkTypeName", "isNetworkConnected", "", "isNotNetworkConnected", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class NetworkUtil {
    public static final NetworkUtil INSTANCE = new NetworkUtil();
    private static final String NETWORK_TYPE_CELLULAR = "cellular";
    private static final String NETWORK_TYPE_NETWORK = "wifi";
    private static final String NETWORK_TYPE_UNKNOWN = "unknown";
    private static final String TAG = "NetworkUtil";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NetworkUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNotNetworkConnected(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        return !isNetworkConnected(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNetworkConnected(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger.INSTANCE.m706v(y.ٴسسݬߨ(1393210002), y.٬ݯح׭٩(576277590));
        Object systemService = context.getSystemService(y.دײܮڳܯ(2051993141));
        Intrinsics.checkNotNull(systemService, y.ٴسسݬߨ(1393211274));
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getNetworkType(Context context) {
        NetworkCapabilities networkCapabilities;
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Object systemService = context.getSystemService(y.دײܮڳܯ(2051993141));
        Intrinsics.checkNotNull(systemService, y.ٴسسݬߨ(1393211274));
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        String str = y.٬ݯح׭٩(576288310);
        return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) ? str : networkCapabilities.hasTransport(1) ? y.ٲٴݴ״ٰ(1782558040) : networkCapabilities.hasTransport(0) ? y.֬ڱܱײٮ(-1159008447) : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getNetworkTypeName(Context context) {
        Object systemService = context.getSystemService(y.دײܮڳܯ(2051993141));
        Intrinsics.checkNotNull(systemService, y.ٴسسݬߨ(1393211274));
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        String str = y.٬ݯح׭٩(576288310);
        String str2 = y.ٴسسݬߨ(1393210002);
        if (activeNetworkInfo == null) {
            Logger.INSTANCE.m701e(str2, y.ٴسسݬߨ(1393210218));
            return str;
        }
        String typeName = activeNetworkInfo.getTypeName();
        Logger.INSTANCE.m706v(str2, y.٬ݯح׭٩(576276662) + typeName);
        if (TextUtils.isEmpty(typeName)) {
            return str;
        }
        Intrinsics.checkNotNull(typeName);
        String lowerCase = typeName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        Intrinsics.checkNotNull(lowerCase);
        return lowerCase;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMacAddress(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Object systemService = context.getSystemService(y.ٲٴݴ״ٰ(1782558040));
        Intrinsics.checkNotNull(systemService, y.ۮڭڭܬި(862905587));
        WifiInfo connectionInfo = ((WifiManager) systemService).getConnectionInfo();
        if (connectionInfo == null || connectionInfo.getMacAddress() == null) {
            str = "";
        } else {
            str = connectionInfo.getMacAddress();
            Intrinsics.checkNotNull(str);
        }
        Logger.INSTANCE.m706v(y.ٴسسݬߨ(1393210002), y.ٴسسݬߨ(1393201026) + str);
        return str;
    }
}
