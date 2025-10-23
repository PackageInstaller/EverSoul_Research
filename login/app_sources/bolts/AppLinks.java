package bolts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.liapp.y;

/* loaded from: classes.dex */
public final class AppLinks {
    static final String KEY_NAME_APPLINK_DATA = "al_applink_data";
    static final String KEY_NAME_EXTRAS = "extras";
    static final String KEY_NAME_TARGET = "target_url";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bundle getAppLinkData(Intent intent) {
        return intent.getBundleExtra(y.ٲٴݴ״ٰ(1781642984));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Bundle getAppLinkExtras(Intent intent) {
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null) {
            return null;
        }
        return appLinkData.getBundle(y.٬ݯح׭٩(576155478));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri getTargetUrl(Intent intent) {
        String string;
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData != null && (string = appLinkData.getString(y.ۮڭڭܬި(861979003))) != null) {
            return Uri.parse(string);
        }
        return intent.getData();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uri getTargetUrlFromInboundIntent(Context context, Intent intent) {
        String string;
        Bundle appLinkData = getAppLinkData(intent);
        if (appLinkData == null || (string = appLinkData.getString(y.ۮڭڭܬި(861979003))) == null) {
            return null;
        }
        MeasurementEvent.sendBroadcastEvent(context, y.ݬֲ֮ܲت(1512931391), intent, null);
        return Uri.parse(string);
    }
}
