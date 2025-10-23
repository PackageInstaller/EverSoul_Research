package com.kakaogame.auth;

import android.app.Activity;
import android.content.Intent;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakao.sdk.common.Constants;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.Logger;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthActivityManager.kt */
@Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 )2\u00020\u0001:\u0002()B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J3\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010\"\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tJ\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\t2\b\u0010&\u001a\u0004\u0018\u00010'R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, m839d2 = {"Lcom/kakaogame/auth/AuthActivityManager;", "", "()V", "activityParametersMap", "", "", "Lcom/kakaogame/auth/AuthActivityManager$ActivityParameters;", "eventListeners", "", "Lcom/kakaogame/KGAuthActivity$KGActivityEventListener;", "parameterLock", "addResultListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "finishActivity", "txId", "onActivityResult", "requestCode", "", ServerConstants.TRACE_RESULT_CODE, "data", "Landroid/content/Intent;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(JI[Ljava/lang/String;[I)V", "processActivityAction", "", "curActivity", "Landroid/app/Activity;", "removeActivityParameters", "removeResultListener", "setActivity", "setActivityParameters", "eventListener", "permissionResultCallback", "Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;", "ActivityParameters", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthActivityManager {
    private static final String TAG = "AuthActivityManager";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AuthActivityManager instance = new AuthActivityManager();
    private final Set<KGAuthActivity.KGActivityEventListener> eventListeners = new LinkedHashSet();
    private final Map<Long, ActivityParameters> activityParametersMap = new LinkedHashMap();
    private final Object parameterLock = new Object();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthActivityManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addResultListener(KGAuthActivity.KGActivityEventListener listener) {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393344346), y.٬ݯح׭٩(576682910) + listener);
        if (listener == null) {
            return;
        }
        try {
            synchronized (this.eventListeners) {
                this.eventListeners.add(listener);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393344346), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeResultListener(KGAuthActivity.KGActivityEventListener listener) {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393344346), y.֬ڱܱײٮ(-1158879871) + listener);
        if (listener == null) {
            return;
        }
        try {
            synchronized (this.eventListeners) {
                this.eventListeners.remove(listener);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393344346), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long setActivityParameters(KGAuthActivity.KGActivityEventListener eventListener, ActivityCompat.OnRequestPermissionsResultCallback permissionResultCallback) {
        long currentTimeMillis = System.currentTimeMillis();
        ActivityParameters activityParameters = new ActivityParameters();
        activityParameters.setTxId(currentTimeMillis);
        activityParameters.setEventListener(eventListener);
        activityParameters.setPermissionResultCallback(permissionResultCallback);
        synchronized (this.parameterLock) {
            this.activityParametersMap.put(Long.valueOf(currentTimeMillis), activityParameters);
        }
        return currentTimeMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean setActivity(long txId, Activity curActivity) {
        ActivityParameters activityParameters;
        Intrinsics.checkNotNullParameter(curActivity, y.֬ڱܱײٮ(-1158879895));
        if (txId < 0) {
            return false;
        }
        synchronized (this.parameterLock) {
            activityParameters = this.activityParametersMap.get(Long.valueOf(txId));
            Unit unit = Unit.INSTANCE;
        }
        ActivityParameters activityParameters2 = activityParameters;
        if (activityParameters2 == null) {
            return false;
        }
        activityParameters2.setActivity(curActivity);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean processActivityAction(long txId, Activity curActivity) {
        ActivityParameters activityParameters;
        Intrinsics.checkNotNullParameter(curActivity, y.֬ڱܱײٮ(-1158879895));
        if (txId < 0) {
            return false;
        }
        synchronized (this.parameterLock) {
            activityParameters = this.activityParametersMap.get(Long.valueOf(txId));
            Unit unit = Unit.INSTANCE;
        }
        if (activityParameters == null) {
            return false;
        }
        KGAuthActivity.KGActivityEventListener eventListener = activityParameters.getEventListener();
        if (eventListener == null) {
            return true;
        }
        eventListener.onActivityStart(curActivity);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeActivityParameters(long txId, Activity curActivity) {
        ActivityParameters activityParameters;
        KGAuthActivity.KGActivityEventListener eventListener;
        Intrinsics.checkNotNullParameter(curActivity, y.֬ڱܱײٮ(-1158879895));
        if (txId < 0) {
            return;
        }
        synchronized (this.parameterLock) {
            activityParameters = this.activityParametersMap.get(Long.valueOf(txId));
            Unit unit = Unit.INSTANCE;
        }
        ActivityParameters activityParameters2 = activityParameters;
        if (activityParameters2 != null && Intrinsics.areEqual(activityParameters2.getActivity(), curActivity) && (eventListener = activityParameters2.getEventListener()) != null) {
            eventListener.onDestroy();
        }
        synchronized (this.parameterLock) {
            this.activityParametersMap.remove(Long.valueOf(txId));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void finishActivity(long txId) {
        ActivityParameters activityParameters;
        Activity activity;
        synchronized (this.parameterLock) {
            activityParameters = this.activityParametersMap.get(Long.valueOf(txId));
            Unit unit = Unit.INSTANCE;
        }
        ActivityParameters activityParameters2 = activityParameters;
        if (activityParameters2 == null || (activity = activityParameters2.getActivity()) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        synchronized (this.eventListeners) {
            Iterator<KGAuthActivity.KGActivityEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityResult(requestCode, resultCode, data);
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(TAG, e.toString(), e);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onRequestPermissionsResult(long txId, int requestCode, String[] permissions, int[] grantResults) {
        ActivityParameters activityParameters;
        Intrinsics.checkNotNullParameter(permissions, y.دײܮڳܯ(2051593325));
        if (txId < 0) {
            return;
        }
        synchronized (this.parameterLock) {
            activityParameters = this.activityParametersMap.get(Long.valueOf(txId));
            Unit unit = Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(activityParameters);
        ActivityParameters activityParameters2 = activityParameters;
        if (activityParameters2.getPermissionResultCallback() != null) {
            ActivityCompat.OnRequestPermissionsResultCallback permissionResultCallback = activityParameters2.getPermissionResultCallback();
            Intrinsics.checkNotNull(permissionResultCallback);
            Intrinsics.checkNotNull(grantResults);
            permissionResultCallback.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    /* compiled from: AuthActivityManager.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/auth/AuthActivityManager$ActivityParameters;", "", "()V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "eventListener", "Lcom/kakaogame/KGAuthActivity$KGActivityEventListener;", "getEventListener", "()Lcom/kakaogame/KGAuthActivity$KGActivityEventListener;", "setEventListener", "(Lcom/kakaogame/KGAuthActivity$KGActivityEventListener;)V", "permissionResultCallback", "Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;", "getPermissionResultCallback", "()Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;", "setPermissionResultCallback", "(Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;)V", "txId", "", "getTxId", "()J", "setTxId", "(J)V", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class ActivityParameters {
        private Activity activity;
        private KGAuthActivity.KGActivityEventListener eventListener;
        private ActivityCompat.OnRequestPermissionsResultCallback permissionResultCallback;
        private long txId;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long getTxId() {
            return this.txId;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setTxId(long j) {
            this.txId = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGAuthActivity.KGActivityEventListener getEventListener() {
            return this.eventListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setEventListener(KGAuthActivity.KGActivityEventListener kGActivityEventListener) {
            this.eventListener = kGActivityEventListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final ActivityCompat.OnRequestPermissionsResultCallback getPermissionResultCallback() {
            return this.permissionResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPermissionResultCallback(ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback) {
            this.permissionResultCallback = onRequestPermissionsResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Activity getActivity() {
            return this.activity;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setActivity(Activity activity) {
            this.activity = activity;
        }
    }

    /* compiled from: AuthActivityManager.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/auth/AuthActivityManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/kakaogame/auth/AuthActivityManager;", Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakaogame/auth/AuthActivityManager;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final AuthActivityManager getInstance() {
            return AuthActivityManager.instance;
        }
    }
}
