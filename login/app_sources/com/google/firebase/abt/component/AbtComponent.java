package com.google.firebase.abt.component;

import android.content.Context;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AbtComponent {
    private final Map<String, FirebaseABTesting> abtOriginInstances = new HashMap();
    private final Provider<AnalyticsConnector> analyticsConnector;
    private final Context appContext;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AbtComponent(Context context, Provider<AnalyticsConnector> provider) {
        this.appContext = context;
        this.analyticsConnector = provider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized FirebaseABTesting get(String str) {
        if (!this.abtOriginInstances.containsKey(str)) {
            this.abtOriginInstances.put(str, createAbtInstance(str));
        }
        return this.abtOriginInstances.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected FirebaseABTesting createAbtInstance(String str) {
        return new FirebaseABTesting(this.appContext, this.analyticsConnector, str);
    }
}
