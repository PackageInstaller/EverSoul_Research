package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CustomTabsClient {
    private static final String TAG = "CustomTabsClient";
    private final Context mApplicationContext;
    private final ICustomTabsService mService;
    private final ComponentName mServiceComponentName;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.mService = iCustomTabsService;
        this.mServiceComponentName = componentName;
        this.mApplicationContext = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean bindCustomTabsService(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 33);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean bindCustomTabsServicePreservePriority(Context context, String str, CustomTabsServiceConnection customTabsServiceConnection) {
        customTabsServiceConnection.setApplicationContext(context.getApplicationContext());
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.bindService(intent, customTabsServiceConnection, 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(Context context, List<String> list) {
        return getPackageName(context, list, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(Context context, List<String> list, boolean z) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        List<String> arrayList = list == null ? new ArrayList<>() : list;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if (!z && (resolveActivity = packageManager.resolveActivity(intent, 0)) != null) {
            String str = resolveActivity.activityInfo.packageName;
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 1);
            arrayList2.add(str);
            if (list != null) {
                arrayList2.addAll(list);
            }
            arrayList = arrayList2;
        }
        Intent intent2 = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
        for (String str2 : arrayList) {
            intent2.setPackage(str2);
            if (packageManager.resolveService(intent2, 0) != null) {
                return str2;
            }
        }
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        Log.w(TAG, "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean connectAndInitialize(Context context, String str) {
        if (str == null) {
            return false;
        }
        final Context applicationContext = context.getApplicationContext();
        try {
            return bindCustomTabsService(applicationContext, str, new CustomTabsServiceConnection() { // from class: androidx.browser.customtabs.CustomTabsClient.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // androidx.browser.customtabs.CustomTabsServiceConnection
                public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                    customTabsClient.warmup(0L);
                    applicationContext.unbindService(this);
                }
            });
        } catch (SecurityException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean warmup(long j) {
        try {
            return this.mService.warmup(j);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static PendingIntent createSessionId(Context context, int i) {
        return PendingIntent.getActivity(context, i, new Intent(), 67108864);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback) {
        return newSessionInternal(customTabsCallback, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomTabsSession newSession(CustomTabsCallback customTabsCallback, int i) {
        return newSessionInternal(customTabsCallback, createSessionId(this.mApplicationContext, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomTabsSession.PendingSession newPendingSession(Context context, CustomTabsCallback customTabsCallback, int i) {
        return new CustomTabsSession.PendingSession(customTabsCallback, createSessionId(context, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CustomTabsSession newSessionInternal(CustomTabsCallback customTabsCallback, PendingIntent pendingIntent) {
        boolean newSession;
        ICustomTabsCallback.Stub createCallbackWrapper = createCallbackWrapper(customTabsCallback);
        try {
            if (pendingIntent != null) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
                newSession = this.mService.newSessionWithExtras(createCallbackWrapper, bundle);
            } else {
                newSession = this.mService.newSession(createCallbackWrapper);
            }
            if (newSession) {
                return new CustomTabsSession(this.mService, createCallbackWrapper, this.mServiceComponentName, pendingIntent);
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle extraCommand(String str, Bundle bundle) {
        try {
            return this.mService.extraCommand(str, bundle);
        } catch (RemoteException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ICustomTabsCallback.Stub createCallbackWrapper(final CustomTabsCallback customTabsCallback) {
        return new ICustomTabsCallback.Stub() { // from class: androidx.browser.customtabs.CustomTabsClient.2
            private Handler mHandler = new Handler(Looper.getMainLooper());

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(final int i, final Bundle bundle) {
                if (customTabsCallback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onNavigationEvent(i, bundle);
                    }
                });
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.support.customtabs.ICustomTabsCallback
            public void extraCallback(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.2
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.extraCallback(str, bundle);
                    }
                });
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.support.customtabs.ICustomTabsCallback
            public Bundle extraCallbackWithResult(String str, Bundle bundle) throws RemoteException {
                CustomTabsCallback customTabsCallback2 = customTabsCallback;
                if (customTabsCallback2 == null) {
                    return null;
                }
                return customTabsCallback2.extraCallbackWithResult(str, bundle);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.3
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onMessageChannelReady(bundle);
                    }
                });
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.support.customtabs.ICustomTabsCallback
            public void onPostMessage(final String str, final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.4
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onPostMessage(str, bundle);
                    }
                });
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.support.customtabs.ICustomTabsCallback
            public void onRelationshipValidationResult(final int i, final Uri uri, final boolean z, final Bundle bundle) throws RemoteException {
                if (customTabsCallback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() { // from class: androidx.browser.customtabs.CustomTabsClient.2.5
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        customTabsCallback.onRelationshipValidationResult(i, uri, z, bundle);
                    }
                });
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomTabsSession attachSession(CustomTabsSession.PendingSession pendingSession) {
        return newSessionInternal(pendingSession.getCallback(), pendingSession.getId());
    }
}
