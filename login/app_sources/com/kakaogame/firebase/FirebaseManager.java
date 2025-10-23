package com.kakaogame.firebase;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.IFirebase;
import com.kakaogame.push.PushService;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FirebaseManager.kt */
@Metadata(m838d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J$\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aH\u0016J$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m839d2 = {"Lcom/kakaogame/firebase/FirebaseManager;", "Lcom/kakaogame/log/IFirebase;", "()V", "fcmToken", "", "mFirebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "traceList", "", "", "Lcom/google/firebase/perf/metrics/Trace;", "useAnalytics", "", "useCrashlytics", "usePerformance", "addTraceMetric", "", ServerConstants.HEADER_TRACE_ID, NotificationCompat.CATEGORY_EVENT, "getFCMToken", "initialize", "context", "Landroid/content/Context;", "logEvent", "name", "attr", "", "setCrashUserIdentifier", "playerId", "traceStart", "traceStop", "Companion", "firebase_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class FirebaseManager implements IFirebase {
    private static final String TAG = "FirebaseManager";
    private String fcmToken;
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final Random requestIdGenerator = new Random(System.currentTimeMillis());
    private final Map<Integer, Trace> traceList = new HashMap();
    private boolean useCrashlytics = true;
    private boolean usePerformance = true;
    private boolean useAnalytics = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.log.IFirebase
    public void initialize(final Context context) {
        String str = y.ݬֲ֮ܲت(1512333463);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            if (CoreManager.INSTANCE.getInstance().getUseFirebase()) {
                if (!CoreManager.INSTANCE.getInstance().isUnity() && !CoreManager.INSTANCE.getInstance().isUnreal()) {
                    try {
                        Class.forName("com.google.firebase.crashlytics.FirebaseCrashlytics");
                    } catch (ClassNotFoundException unused) {
                        Logger.INSTANCE.m699d(str, "This game doesn't use Crashlytics.");
                        this.useCrashlytics = false;
                    }
                }
                try {
                    Class.forName("com.google.firebase.perf.FirebasePerformance");
                    Logger.INSTANCE.m699d(str, "Use FirebasePerformance...");
                } catch (ClassNotFoundException unused2) {
                    Logger.INSTANCE.m699d(str, "This game doesn't use FirebasePerformance");
                    this.usePerformance = false;
                }
                try {
                    Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                    Logger.INSTANCE.m699d(str, "Use FirebaseAnalytics...");
                    this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
                } catch (ClassNotFoundException unused3) {
                    Logger.INSTANCE.m699d(str, "This game doesn't use FirebaseAnalytics");
                    this.useAnalytics = false;
                }
                FirebaseApp.initializeApp(context);
            }
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.kakaogame.firebase.FirebaseManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FirebaseManager.initialize$lambda$0(context, this, task);
                }
            });
        } catch (Exception e) {
            Logger.INSTANCE.m701e(str, y.ٴسسݬߨ(1393380298));
            Logger.INSTANCE.m701e(str, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initialize$lambda$0(Context context, FirebaseManager firebaseManager, Task task) {
        Intrinsics.checkNotNullParameter(context, y.٬ݯح׭٩(576622142));
        Intrinsics.checkNotNullParameter(firebaseManager, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(task, y.دײܮڳܯ(2051295277));
        if (!task.isSuccessful()) {
            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
            return;
        }
        String str = (String) task.getResult();
        PushService.saveFCMIID(context, str);
        firebaseManager.fcmToken = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.log.IFirebase
    public void setCrashUserIdentifier(String playerId) {
        Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
        if (CoreManager.INSTANCE.getInstance().isUnity() || CoreManager.INSTANCE.getInstance().isUnreal() || !this.useCrashlytics) {
            return;
        }
        try {
            FirebaseCrashlytics.getInstance().setUserId(playerId);
        } catch (Exception unused) {
            Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512333463), y.ٴسسݬߨ(1393378762));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.log.IFirebase
    public String getFCMToken() {
        return this.fcmToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.log.IFirebase
    public int traceStart(String name, Map<String, String> attr) {
        String str = y.ݬֲ֮ܲت(1512333463);
        String str2 = y.֬ڱܱײٮ(-1158866039);
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(attr, y.ٲٴݴ״ٰ(1782055944));
        if (!this.usePerformance) {
            return 0;
        }
        try {
            Logger.INSTANCE.m706v(str, str2 + name);
            int nextInt = requestIdGenerator.nextInt();
            Trace newTrace = FirebasePerformance.getInstance().newTrace(name);
            Intrinsics.checkNotNullExpressionValue(newTrace, "newTrace(...)");
            for (Map.Entry<String, String> entry : attr.entrySet()) {
                newTrace.putAttribute(entry.getKey(), entry.getValue());
            }
            newTrace.start();
            this.traceList.put(Integer.valueOf(nextInt), newTrace);
            Logger.INSTANCE.m706v(str, "Firebase Trace ID: " + nextInt);
            return nextInt;
        } catch (Exception e) {
            Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512336631) + e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.log.IFirebase
    public void addTraceMetric(int traceId, String event) {
        Intrinsics.checkNotNullParameter(event, y.ٲٴݴ״ٰ(1782060104));
        if (this.usePerformance) {
            try {
                Trace trace = this.traceList.get(Integer.valueOf(traceId));
                if (trace != null) {
                    trace.incrementMetric(event, 1L);
                }
            } catch (Exception e) {
                Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512333463), y.ٴسسݬߨ(1393380050) + e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.log.IFirebase
    public void traceStop(int traceId, Map<String, String> attr) {
        String str = y.ݬֲ֮ܲت(1512333463);
        String str2 = y.٬ݯح׭٩(576619518);
        Intrinsics.checkNotNullParameter(attr, y.ٲٴݴ״ٰ(1782055944));
        if (this.usePerformance) {
            try {
                Logger.INSTANCE.m706v(str, str2 + traceId);
                Trace trace = this.traceList.get(Integer.valueOf(traceId));
                if (trace != null) {
                    for (Map.Entry<String, String> entry : attr.entrySet()) {
                        trace.putAttribute(entry.getKey(), entry.getValue());
                    }
                    trace.stop();
                    this.traceList.remove(Integer.valueOf(traceId));
                }
            } catch (Exception e) {
                Logger.INSTANCE.m699d(str, y.ݮڮֲڭܩ(-628526036) + e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.log.IFirebase
    public void logEvent(String name, Map<String, String> attr) {
        Intrinsics.checkNotNullParameter(name, y.ٲٴݴ״ٰ(1781623392));
        Intrinsics.checkNotNullParameter(attr, y.ٲٴݴ״ٰ(1782055944));
        if (this.useAnalytics) {
            try {
                Bundle bundle = new Bundle();
                for (Map.Entry<String, String> entry : attr.entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
                FirebaseAnalytics firebaseAnalytics = this.mFirebaseAnalytics;
                if (firebaseAnalytics != null) {
                    firebaseAnalytics.logEvent(name, bundle);
                }
            } catch (Exception e) {
                Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512333463), y.ۮڭڭܬި(862530675) + e);
            }
        }
    }
}
