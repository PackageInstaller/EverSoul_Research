package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {
    private final ListenerHolder zaa;
    private final Feature[] zab;
    private final boolean zac;
    private final int zad;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder) {
        this(listenerHolder, null, false, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z, int i) {
        this.zaa = listenerHolder;
        this.zab = featureArr;
        this.zac = z;
        this.zad = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearListener() {
        this.zaa.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ListenerHolder.ListenerKey<L> getListenerKey() {
        return this.zaa.getListenerKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Feature[] getRequiredFeatures() {
        return this.zab;
    }

    protected abstract void registerListener(A a2, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zaa() {
        return this.zad;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zab() {
        return this.zac;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected RegisterListenerMethod(ListenerHolder<L> listenerHolder, Feature[] featureArr, boolean z) {
        this(listenerHolder, featureArr, z, 0);
    }
}
