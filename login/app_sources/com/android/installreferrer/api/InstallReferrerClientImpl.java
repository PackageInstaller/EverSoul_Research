package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.installreferrer.commons.InstallReferrerCommons;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import com.liapp.y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes.dex */
class InstallReferrerClientImpl extends InstallReferrerClient {
    private static final int PLAY_STORE_MIN_APP_VER = 80837300;
    private static final String SERVICE_ACTION_NAME = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE";
    private static final String SERVICE_NAME = "com.google.android.finsky.externalreferrer.GetInstallReferrerService";
    private static final String SERVICE_PACKAGE_NAME = "com.android.vending";
    private static final String TAG = "InstallReferrerClient";
    private int clientState = 0;
    private final Context mApplicationContext;
    private IGetInstallReferrerService service;
    private ServiceConnection serviceConnection;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        return (this.clientState != 2 || this.service == null || this.serviceConnection == null) ? false : true;
    }

    private final class InstallReferrerServiceConnection implements ServiceConnection {
        private final InstallReferrerStateListener mListener;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InstallReferrerServiceConnection(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.mListener = installReferrerStateListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose(InstallReferrerClientImpl.TAG, y.ݬֲ֮ܲت(1512839047));
            InstallReferrerClientImpl.this.service = IGetInstallReferrerService.Stub.m141b(iBinder);
            InstallReferrerClientImpl.this.clientState = 2;
            this.mListener.onInstallReferrerSetupFinished(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn(InstallReferrerClientImpl.TAG, y.ݬֲ֮ܲت(1512838879));
            InstallReferrerClientImpl.this.service = null;
            InstallReferrerClientImpl.this.clientState = 0;
            this.mListener.onInstallReferrerServiceDisconnected();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InstallReferrerClientImpl(Context context) {
        this.mApplicationContext = context.getApplicationContext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isPlayStoreCompatible() {
        return this.mApplicationContext.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= PLAY_STORE_MIN_APP_VER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        this.clientState = 3;
        if (this.serviceConnection != null) {
            InstallReferrerCommons.logVerbose(y.٬ݯح׭٩(576125622), y.ݮڮֲڭܩ(-629077140));
            this.mApplicationContext.unbindService(this.serviceConnection);
            this.serviceConnection = null;
        }
        this.service = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails getInstallReferrer() throws RemoteException {
        if (!isReady()) {
            throw new IllegalStateException(y.֬ڱܱײٮ(-1159370983));
        }
        Bundle bundle = new Bundle();
        bundle.putString(y.ݮڮֲڭܩ(-629076908), this.mApplicationContext.getPackageName());
        try {
            return new ReferrerDetails(this.service.mo140c(bundle));
        } catch (RemoteException e) {
            InstallReferrerCommons.logWarn(y.٬ݯح׭٩(576125622), y.֬ڱܱײٮ(-1159371447));
            this.clientState = 0;
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        boolean isReady = isReady();
        String str = y.٬ݯح׭٩(576125622);
        if (isReady) {
            InstallReferrerCommons.logVerbose(str, y.֬ڱܱײٮ(-1159421119));
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.clientState;
        if (i == 1) {
            InstallReferrerCommons.logWarn(str, y.ۮڭڭܬި(862018995));
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i == 3) {
            InstallReferrerCommons.logWarn(str, y.ٴسسݬߨ(1392850650));
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        InstallReferrerCommons.logVerbose(str, y.ٲٴݴ״ٰ(1781542416));
        Intent intent = new Intent(y.٬ݯح׭٩(576124518));
        String str2 = y.دײܮڳܯ(2051804749);
        String str3 = y.ݮڮֲڭܩ(-629138092);
        intent.setComponent(new ComponentName(str3, str2));
        List<ResolveInfo> queryIntentServices = this.mApplicationContext.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            if (resolveInfo.serviceInfo != null) {
                String str4 = resolveInfo.serviceInfo.packageName;
                String str5 = resolveInfo.serviceInfo.name;
                if (!str3.equals(str4) || str5 == null || !isPlayStoreCompatible()) {
                    InstallReferrerCommons.logWarn(str, y.ݬֲ֮ܲت(1512842031));
                    this.clientState = 0;
                    installReferrerStateListener.onInstallReferrerSetupFinished(2);
                    return;
                }
                Intent intent2 = new Intent(intent);
                InstallReferrerServiceConnection installReferrerServiceConnection = new InstallReferrerServiceConnection(installReferrerStateListener);
                this.serviceConnection = installReferrerServiceConnection;
                try {
                    if (this.mApplicationContext.bindService(intent2, installReferrerServiceConnection, 1)) {
                        InstallReferrerCommons.logVerbose(str, "Service was bonded successfully.");
                        return;
                    }
                    InstallReferrerCommons.logWarn(str, y.ٲٴݴ״ٰ(1781535096));
                    this.clientState = 0;
                    installReferrerStateListener.onInstallReferrerSetupFinished(1);
                    return;
                } catch (SecurityException unused) {
                    InstallReferrerCommons.logWarn(str, y.ٲٴݴ״ٰ(1781534864));
                    this.clientState = 0;
                    installReferrerStateListener.onInstallReferrerSetupFinished(4);
                    return;
                }
            }
        }
        this.clientState = 0;
        InstallReferrerCommons.logVerbose(str, y.֬ڱܱײٮ(-1159374895));
        installReferrerStateListener.onInstallReferrerSetupFinished(2);
    }
}
