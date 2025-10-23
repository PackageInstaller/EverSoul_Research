package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;

/* loaded from: classes.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {
    private Context mApplicationContext;

    public abstract void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Context getApplicationContext() {
        return this.mApplicationContext;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (this.mApplicationContext == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        onCustomTabsServiceConnected(componentName, new CustomTabsClient(ICustomTabsService.Stub.asInterface(iBinder), componentName, this.mApplicationContext) { // from class: androidx.browser.customtabs.CustomTabsServiceConnection.1
        });
    }
}
