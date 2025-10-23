package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;
import com.liapp.y;

/* loaded from: classes.dex */
final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    private static final String TAG = "ConnectivityMonitor";
    private final BroadcastReceiver connectivityReceiver = new BroadcastReceiver() { // from class: com.bumptech.glide.manager.DefaultConnectivityMonitor.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = DefaultConnectivityMonitor.this.isConnected;
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            defaultConnectivityMonitor.isConnected = defaultConnectivityMonitor.isConnected(context);
            if (z != DefaultConnectivityMonitor.this.isConnected) {
                if (Log.isLoggable(DefaultConnectivityMonitor.TAG, 3)) {
                    Log.d(DefaultConnectivityMonitor.TAG, y.ۮڭڭܬި(862189795) + DefaultConnectivityMonitor.this.isConnected);
                }
                DefaultConnectivityMonitor.this.listener.onConnectivityChanged(DefaultConnectivityMonitor.this.isConnected);
            }
        }
    };
    private final Context context;
    boolean isConnected;
    private boolean isRegistered;
    final ConnectivityMonitor.ConnectivityListener listener;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.context = context.getApplicationContext();
        this.listener = connectivityListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void register() {
        if (this.isRegistered) {
            return;
        }
        this.isConnected = isConnected(this.context);
        try {
            this.context.registerReceiver(this.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.isRegistered = true;
        } catch (SecurityException e) {
            String str = y.ۮڭڭܬި(862190539);
            if (Log.isLoggable(str, 5)) {
                Log.w(str, y.ۮڭڭܬި(862190227), e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void unregister() {
        if (this.isRegistered) {
            this.context.unregisterReceiver(this.connectivityReceiver);
            this.isRegistered = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isConnected(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.checkNotNull((ConnectivityManager) context.getSystemService(y.دײܮڳܯ(2051993141)))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e) {
            String str = y.ۮڭڭܬި(862190539);
            if (Log.isLoggable(str, 5)) {
                Log.w(str, y.دײܮڳܯ(2051993285), e);
            }
            return true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        register();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        unregister();
    }
}
