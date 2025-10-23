package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    private final GeneratedAdapter[] mGeneratedAdapters;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CompositeGeneratedAdaptersObserver(GeneratedAdapter[] generatedAdapterArr) {
        this.mGeneratedAdapters = generatedAdapterArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter generatedAdapter : this.mGeneratedAdapters) {
            generatedAdapter.callMethods(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter generatedAdapter2 : this.mGeneratedAdapters) {
            generatedAdapter2.callMethods(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
