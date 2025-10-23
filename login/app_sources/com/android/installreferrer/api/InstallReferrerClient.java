package com.android.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;
import com.liapp.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class InstallReferrerClient {

    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallReferrerResponse {
        public static final int DEVELOPER_ERROR = 3;
        public static final int FEATURE_NOT_SUPPORTED = 2;

        /* renamed from: OK */
        public static final int f146OK = 0;
        public static final int PERMISSION_ERROR = 4;
        public static final int SERVICE_DISCONNECTED = -1;
        public static final int SERVICE_UNAVAILABLE = 1;
    }

    public abstract void endConnection();

    public abstract ReferrerDetails getInstallReferrer() throws RemoteException;

    public abstract boolean isReady();

    public abstract void startConnection(InstallReferrerStateListener installReferrerStateListener);

    public static final class Builder {
        private final Context mContext;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder(Context context) {
            this.mContext = context;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InstallReferrerClient build() {
            Context context = this.mContext;
            if (context != null) {
                return new InstallReferrerClientImpl(context);
            }
            throw new IllegalArgumentException(y.ݬֲ֮ܲت(1512943623));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }
}
