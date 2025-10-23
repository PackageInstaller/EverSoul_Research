package androidx.lifecycle;

import android.content.Context;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.startup.Initializer
    public LifecycleOwner create(Context context) {
        if (!AppInitializer.getInstance(context).isEagerlyInitialized(getClass())) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        LifecycleDispatcher.init(context);
        ProcessLifecycleOwner.init(context);
        return ProcessLifecycleOwner.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
