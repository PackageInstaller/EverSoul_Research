package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
class LifecycleDispatcher {
    private static AtomicBoolean sInitialized = new AtomicBoolean(false);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void init(Context context) {
        if (sInitialized.getAndSet(true)) {
            return;
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new DispatcherActivityCallback());
    }

    static class DispatcherActivityCallback extends EmptyActivityLifecycleCallbacks {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DispatcherActivityCallback() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ReportFragment.injectIfNeededIn(activity);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LifecycleDispatcher() {
    }
}
