package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;
import androidx.core.app.BundleCompat;

/* loaded from: classes.dex */
public class CustomTabsSessionToken {
    private static final String TAG = "CustomTabsSessionToken";
    private final CustomTabsCallback mCallback;
    final ICustomTabsCallback mCallbackBinder;
    private final PendingIntent mSessionId;

    static class MockCallback extends ICustomTabsCallback.Stub {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsCallback.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String str, Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String str, Bundle bundle) {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String str, Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MockCallback() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomTabsSessionToken getSessionTokenFromIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return null;
        }
        IBinder binder = BundleCompat.getBinder(extras, CustomTabsIntent.EXTRA_SESSION);
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra(CustomTabsIntent.EXTRA_SESSION_ID);
        if (binder == null && pendingIntent == null) {
            return null;
        }
        return new CustomTabsSessionToken(binder != null ? ICustomTabsCallback.Stub.asInterface(binder) : null, pendingIntent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CustomTabsSessionToken createMockSessionTokenForTesting() {
        return new CustomTabsSessionToken(new MockCallback(), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback, PendingIntent pendingIntent) {
        if (iCustomTabsCallback == null && pendingIntent == null) {
            throw new IllegalStateException("CustomTabsSessionToken must have either a session id or a callback (or both).");
        }
        this.mCallbackBinder = iCustomTabsCallback;
        this.mSessionId = pendingIntent;
        this.mCallback = iCustomTabsCallback == null ? null : new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onNavigationEvent(int i, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onNavigationEvent(i, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void extraCallback(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.extraCallback(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public Bundle extraCallbackWithResult(String str, Bundle bundle) {
                try {
                    return CustomTabsSessionToken.this.mCallbackBinder.extraCallbackWithResult(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                    return null;
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onMessageChannelReady(Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onMessageChannelReady(bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onPostMessage(String str, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onPostMessage(str, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.browser.customtabs.CustomTabsCallback
            public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
                try {
                    CustomTabsSessionToken.this.mCallbackBinder.onRelationshipValidationResult(i, uri, z, bundle);
                } catch (RemoteException unused) {
                    Log.e(CustomTabsSessionToken.TAG, "RemoteException during ICustomTabsCallback transaction");
                }
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IBinder getCallbackBinder() {
        ICustomTabsCallback iCustomTabsCallback = this.mCallbackBinder;
        if (iCustomTabsCallback == null) {
            return null;
        }
        return iCustomTabsCallback.asBinder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private IBinder getCallbackBinderAssertNotNull() {
        ICustomTabsCallback iCustomTabsCallback = this.mCallbackBinder;
        if (iCustomTabsCallback == null) {
            throw new IllegalStateException("CustomTabSessionToken must have valid binder or pending session");
        }
        return iCustomTabsCallback.asBinder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PendingIntent getId() {
        return this.mSessionId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasCallback() {
        return this.mCallbackBinder != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasId() {
        return this.mSessionId != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        PendingIntent pendingIntent = this.mSessionId;
        return pendingIntent != null ? pendingIntent.hashCode() : getCallbackBinderAssertNotNull().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof CustomTabsSessionToken)) {
            return false;
        }
        CustomTabsSessionToken customTabsSessionToken = (CustomTabsSessionToken) obj;
        PendingIntent id = customTabsSessionToken.getId();
        PendingIntent pendingIntent = this.mSessionId;
        if ((pendingIntent == null) != (id == null)) {
            return false;
        }
        if (pendingIntent != null) {
            return pendingIntent.equals(id);
        }
        return getCallbackBinderAssertNotNull().equals(customTabsSessionToken.getCallbackBinderAssertNotNull());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CustomTabsCallback getCallback() {
        return this.mCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAssociatedWith(CustomTabsSession customTabsSession) {
        return customTabsSession.getBinder().equals(this.mCallbackBinder);
    }
}
