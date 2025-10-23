package androidx.browser.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityCallback;

/* loaded from: classes.dex */
public class TrustedWebActivityCallbackRemote {
    private final ITrustedWebActivityCallback mCallbackBinder;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TrustedWebActivityCallbackRemote(ITrustedWebActivityCallback iTrustedWebActivityCallback) {
        this.mCallbackBinder = iTrustedWebActivityCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static TrustedWebActivityCallbackRemote fromBinder(IBinder iBinder) {
        ITrustedWebActivityCallback asInterface = iBinder == null ? null : ITrustedWebActivityCallback.Stub.asInterface(iBinder);
        if (asInterface == null) {
            return null;
        }
        return new TrustedWebActivityCallbackRemote(asInterface);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void runExtraCallback(String str, Bundle bundle) throws RemoteException {
        this.mCallbackBinder.onExtraCallback(str, bundle);
    }
}
