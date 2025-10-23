package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.liapp.y;

/* loaded from: classes.dex */
public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.ConnectivityMonitorFactory
    public ConnectivityMonitor build(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z = ContextCompat.checkSelfPermission(context, y.ݬֲ֮ܲت(1513014615)) == 0;
        String str = y.ۮڭڭܬި(862190539);
        if (Log.isLoggable(str, 3)) {
            Log.d(str, z ? y.ݮڮֲڭܩ(-628892604) : y.ۮڭڭܬި(862159707));
        }
        if (z) {
            return new DefaultConnectivityMonitor(context, connectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
