package com.google.android.gms.common.providers;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@Deprecated
/* loaded from: classes.dex */
public class PooledExecutorsProvider {
    private static PooledExecutorFactory zza;

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface PooledExecutorFactory {
        @Deprecated
        ScheduledExecutorService newSingleThreadScheduledExecutor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PooledExecutorsProvider() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static synchronized PooledExecutorFactory getInstance() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (zza == null) {
                zza = new zza();
            }
            pooledExecutorFactory = zza;
        }
        return pooledExecutorFactory;
    }
}
