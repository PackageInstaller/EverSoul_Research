package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import android.widget.RemoteViews;
import androidx.browser.customtabs.CustomTabsSessionToken;
import java.util.List;

/* loaded from: classes.dex */
public final class CustomTabsSession {
    private static final String TAG = "CustomTabsSession";
    private final ICustomTabsCallback mCallback;
    private final ComponentName mComponentName;
    private final PendingIntent mId;
    private final Object mLock = new Object();
    private final ICustomTabsService mService;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomTabsSession createMockSessionForTesting(ComponentName componentName) {
        return new CustomTabsSession(new MockSession(), new CustomTabsSessionToken.MockCallback(), componentName, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CustomTabsSession(ICustomTabsService iCustomTabsService, ICustomTabsCallback iCustomTabsCallback, ComponentName componentName, PendingIntent pendingIntent) {
        this.mService = iCustomTabsService;
        this.mCallback = iCustomTabsCallback;
        this.mComponentName = componentName;
        this.mId = pendingIntent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean mayLaunchUrl(Uri uri, Bundle bundle, List<Bundle> list) {
        try {
            return this.mService.mayLaunchUrl(this.mCallback, uri, createBundleWithId(bundle), list);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setActionButton(Bitmap bitmap, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
        addIdToBundle(bundle);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setSecondaryToolbarViews(RemoteViews remoteViews, int[] iArr, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(CustomTabsIntent.EXTRA_REMOTEVIEWS, remoteViews);
        bundle.putIntArray(CustomTabsIntent.EXTRA_REMOTEVIEWS_VIEW_IDS, iArr);
        bundle.putParcelable(CustomTabsIntent.EXTRA_REMOTEVIEWS_PENDINGINTENT, pendingIntent);
        addIdToBundle(bundle);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public boolean setToolbarItem(int i, Bitmap bitmap, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt(CustomTabsIntent.KEY_ID, i);
        bundle.putParcelable(CustomTabsIntent.KEY_ICON, bitmap);
        bundle.putString(CustomTabsIntent.KEY_DESCRIPTION, str);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(CustomTabsIntent.EXTRA_ACTION_BUTTON_BUNDLE, bundle);
        addIdToBundle(bundle2);
        try {
            return this.mService.updateVisuals(this.mCallback, bundle2);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean requestPostMessageChannel(Uri uri) {
        try {
            if (this.mId != null) {
                return this.mService.requestPostMessageChannelWithExtras(this.mCallback, uri, createBundleWithId(null));
            }
            return this.mService.requestPostMessageChannel(this.mCallback, uri);
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int postMessage(String str, Bundle bundle) {
        int postMessage;
        Bundle createBundleWithId = createBundleWithId(bundle);
        synchronized (this.mLock) {
            try {
                try {
                    postMessage = this.mService.postMessage(this.mCallback, str, createBundleWithId);
                } catch (RemoteException unused) {
                    return -2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return postMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean validateRelationship(int i, Uri uri, Bundle bundle) {
        if (i >= 1 && i <= 2) {
            try {
                return this.mService.validateRelationship(this.mCallback, i, uri, createBundleWithId(bundle));
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean receiveFile(Uri uri, int i, Bundle bundle) {
        try {
            return this.mService.receiveFile(this.mCallback, uri, i, createBundleWithId(bundle));
        } catch (RemoteException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Bundle createBundleWithId(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        addIdToBundle(bundle2);
        return bundle2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addIdToBundle(Bundle bundle) {
        PendingIntent pendingIntent = this.mId;
        if (pendingIntent != null) {
            bundle.putParcelable(CustomTabsIntent.EXTRA_SESSION_ID, pendingIntent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IBinder getBinder() {
        return this.mCallback.asBinder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ComponentName getComponentName() {
        return this.mComponentName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PendingIntent getId() {
        return this.mId;
    }

    public static class PendingSession {
        private final CustomTabsCallback mCallback;
        private final PendingIntent mId;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PendingSession(CustomTabsCallback customTabsCallback, PendingIntent pendingIntent) {
            this.mCallback = customTabsCallback;
            this.mId = pendingIntent;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PendingIntent getId() {
            return this.mId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CustomTabsCallback getCallback() {
            return this.mCallback;
        }
    }

    static class MockSession extends ICustomTabsService.Stub {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String str, Bundle bundle) throws RemoteException {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback iCustomTabsCallback) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) throws RemoteException {
            return 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback iCustomTabsCallback, Uri uri, int i, Bundle bundle) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i, Uri uri, Bundle bundle) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsService
        public boolean warmup(long j) throws RemoteException {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MockSession() {
        }
    }
}
