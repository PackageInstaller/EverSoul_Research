package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class ConfigRealtimeHandler {
    private final ConfigCacheClient activatedCacheClient;
    private final ConfigFetchHandler configFetchHandler;
    private final ConfigRealtimeHttpClient configRealtimeHttpClient;
    private final Context context;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Set<ConfigUpdateListener> listeners;
    private final ConfigMetadataClient metadataClient;
    private final String namespace;
    private final ScheduledExecutorService scheduledExecutorService;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigRealtimeHandler(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, ConfigMetadataClient configMetadataClient, ScheduledExecutorService scheduledExecutorService) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.listeners = linkedHashSet;
        this.configRealtimeHttpClient = new ConfigRealtimeHttpClient(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient, context, str, linkedHashSet, configMetadataClient, scheduledExecutorService);
        this.firebaseApp = firebaseApp;
        this.configFetchHandler = configFetchHandler;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.activatedCacheClient = configCacheClient;
        this.context = context;
        this.namespace = str;
        this.metadataClient = configMetadataClient;
        this.scheduledExecutorService = scheduledExecutorService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void beginRealtime() {
        if (!this.listeners.isEmpty()) {
            this.configRealtimeHttpClient.startHttpConnection();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized ConfigUpdateListenerRegistration addRealtimeConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        this.listeners.add(configUpdateListener);
        beginRealtime();
        return new ConfigUpdateListenerRegistrationInternal(configUpdateListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setBackgroundState(boolean z) {
        this.configRealtimeHttpClient.setRealtimeBackgroundState(z);
        if (!z) {
            beginRealtime();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void removeRealtimeConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        this.listeners.remove(configUpdateListener);
    }

    public class ConfigUpdateListenerRegistrationInternal implements ConfigUpdateListenerRegistration {
        private final ConfigUpdateListener listener;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ConfigUpdateListenerRegistrationInternal(ConfigUpdateListener configUpdateListener) {
            this.listener = configUpdateListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration
        public void remove() {
            ConfigRealtimeHandler.this.removeRealtimeConfigUpdateListener(this.listener);
        }
    }
}
