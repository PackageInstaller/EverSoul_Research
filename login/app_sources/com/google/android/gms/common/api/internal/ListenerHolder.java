package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.HandlerExecutor;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class ListenerHolder<L> {
    private final Executor zaa;
    private volatile Object zab;
    private volatile ListenerKey zac;

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    public static final class ListenerKey<L> {
        private final Object zaa;
        private final String zab;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ListenerKey(L l, String str) {
            this.zaa = l;
            this.zab = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            return this.zaa == listenerKey.zaa && this.zab.equals(listenerKey.zab);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return (System.identityHashCode(this.zaa) * 31) + this.zab.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toIdString() {
            return this.zab + "@" + System.identityHashCode(this.zaa);
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    public interface Notifier<L> {
        void notifyListener(L l);

        void onNotifyListenerFailed();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ListenerHolder(Looper looper, L l, String str) {
        this.zaa = new HandlerExecutor(looper);
        this.zab = Preconditions.checkNotNull(l, "Listener must not be null");
        this.zac = new ListenerKey(l, Preconditions.checkNotEmpty(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        this.zab = null;
        this.zac = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ListenerKey<L> getListenerKey() {
        return this.zac;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasListener() {
        return this.zab != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void notifyListener(final Notifier<? super L> notifier) {
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zaa.execute(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacb
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                ListenerHolder.this.zaa(notifier);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zaa(Notifier notifier) {
        Object obj = this.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e) {
            notifier.onNotifyListenerFailed();
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ListenerHolder(Executor executor, L l, String str) {
        this.zaa = (Executor) Preconditions.checkNotNull(executor, "Executor must not be null");
        this.zab = Preconditions.checkNotNull(l, "Listener must not be null");
        this.zac = new ListenerKey(l, Preconditions.checkNotEmpty(str));
    }
}
