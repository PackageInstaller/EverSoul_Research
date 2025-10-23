package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public class ListenerHolders {
    private final Set zaa = Collections.newSetFromMap(new WeakHashMap());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <L> ListenerHolder<L> createListenerHolder(L l, Looper looper, String str) {
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l, String str) {
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ListenerHolder zaa(Object obj, Looper looper, String str) {
        Set set = this.zaa;
        ListenerHolder createListenerHolder = createListenerHolder(obj, looper, "NO_TYPE");
        set.add(createListenerHolder);
        return createListenerHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zab() {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).clear();
        }
        this.zaa.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <L> ListenerHolder<L> createListenerHolder(L l, Executor executor, String str) {
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(executor, l, str);
    }
}
