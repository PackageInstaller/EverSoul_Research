package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
public class UnusedAppRestrictionsBackportCallback {
    private IUnusedAppRestrictionsBackportCallback mCallback;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
        this.mCallback = iUnusedAppRestrictionsBackportCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onResult(boolean z, boolean z2) throws RemoteException {
        this.mCallback.onIsPermissionRevocationEnabledForAppResult(z, z2);
    }
}
