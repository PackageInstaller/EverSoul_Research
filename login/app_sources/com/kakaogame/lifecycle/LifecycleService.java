package com.kakaogame.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.kakaogame.KGActivityManager;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifecycleService.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/lifecycle/LifecycleService;", "", "()V", "TAG", "", "initialize", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LifecycleService {
    public static final LifecycleService INSTANCE = new LifecycleService();
    private static final String TAG = "LifecycleService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LifecycleService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393553162), y.ٲٴݴ״ٰ(1781793120));
        CoreManager.INSTANCE.getInstance().getActivity().getApplication().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.kakaogame.lifecycle.LifecycleService$initialize$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity arg0, Bundle arg1) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity arg0) {
                Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity arg0, Bundle arg1) {
                Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
                Intrinsics.checkNotNullParameter(arg1, "arg1");
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity arg0) {
                Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity arg0) {
                Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity arg0) {
                Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
                if (Intrinsics.areEqual(arg0, CoreManager.INSTANCE.getInstance().getActivity())) {
                    KGActivityManager.INSTANCE.dispatchResume();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity arg0) {
                Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
                if (Intrinsics.areEqual(arg0, CoreManager.INSTANCE.getInstance().getActivity())) {
                    KGActivityManager.INSTANCE.dispatchPause();
                }
            }
        });
    }
}
