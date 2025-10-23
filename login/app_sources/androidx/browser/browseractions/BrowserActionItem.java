package androidx.browser.browseractions;

import android.app.PendingIntent;
import android.net.Uri;

@Deprecated
/* loaded from: classes.dex */
public class BrowserActionItem {
    private final PendingIntent mAction;
    private int mIconId;
    private Uri mIconUri;
    private Runnable mRunnableAction;
    private final String mTitle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BrowserActionItem(String str, PendingIntent pendingIntent, int i) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BrowserActionItem(String str, PendingIntent pendingIntent, Uri uri) {
        this.mTitle = str;
        this.mAction = pendingIntent;
        this.mIconUri = uri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BrowserActionItem(String str, Runnable runnable) {
        this.mTitle = str;
        this.mAction = null;
        this.mRunnableAction = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BrowserActionItem(String str, PendingIntent pendingIntent) {
        this(str, pendingIntent, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getIconId() {
        return this.mIconId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTitle() {
        return this.mTitle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PendingIntent getAction() {
        PendingIntent pendingIntent = this.mAction;
        if (pendingIntent != null) {
            return pendingIntent;
        }
        throw new IllegalStateException("Can't call getAction on BrowserActionItem with null action.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Uri getIconUri() {
        return this.mIconUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Runnable getRunnableAction() {
        return this.mRunnableAction;
    }
}
