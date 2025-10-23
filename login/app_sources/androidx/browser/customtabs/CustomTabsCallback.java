package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes.dex */
public class CustomTabsCallback {
    public static final int NAVIGATION_ABORTED = 4;
    public static final int NAVIGATION_FAILED = 3;
    public static final int NAVIGATION_FINISHED = 2;
    public static final int NAVIGATION_STARTED = 1;
    public static final String ONLINE_EXTRAS_KEY = "online";
    public static final int TAB_HIDDEN = 6;
    public static final int TAB_SHOWN = 5;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void extraCallback(String str, Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle extraCallbackWithResult(String str, Bundle bundle) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onMessageChannelReady(Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onNavigationEvent(int i, Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onPostMessage(String str, Bundle bundle) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
    }
}
