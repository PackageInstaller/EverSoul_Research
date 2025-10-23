package com.google.firebase.remoteconfig.internal;

import android.util.Log;
import androidx.privacysandbox.ads.adservices.adid.AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda0;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class ConfigCacheClient {
    static final long DISK_READ_TIMEOUT_IN_SECONDS = 5;
    private Task<ConfigContainer> cachedContainerTask = null;
    private final Executor executor;
    private final ConfigStorageClient storageClient;
    private static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    private static final Executor DIRECT_EXECUTOR = new AdIdManager$Api33Ext4Impl$$ExternalSyntheticLambda0();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConfigCacheClient(Executor executor, ConfigStorageClient configStorageClient) {
        this.executor = executor;
        this.storageClient = configStorageClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigContainer getBlocking() {
        return getBlocking(5L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ConfigContainer getBlocking(long j) {
        synchronized (this) {
            Task<ConfigContainer> task = this.cachedContainerTask;
            if (task != null && task.isSuccessful()) {
                return this.cachedContainerTask.getResult();
            }
            try {
                return (ConfigContainer) await(get(), j, TimeUnit.SECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                Log.d(FirebaseRemoteConfig.TAG, "Reading from storage file failed.", e);
                return null;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$put$0$com-google-firebase-remoteconfig-internal-ConfigCacheClient */
    /* synthetic */ Void m449xddaae01c(ConfigContainer configContainer) throws Exception {
        return this.storageClient.write(configContainer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<ConfigContainer> put(final ConfigContainer configContainer, final boolean z) {
        return Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ConfigCacheClient.this.m449xddaae01c(configContainer);
            }
        }).onSuccessTask(this.executor, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return ConfigCacheClient.this.m450x9820809d(z, configContainer, (Void) obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$put$1$com-google-firebase-remoteconfig-internal-ConfigCacheClient */
    /* synthetic */ Task m450x9820809d(boolean z, ConfigContainer configContainer, Void r3) throws Exception {
        if (z) {
            updateInMemoryConfigContainer(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Task<ConfigContainer> get() {
        Task<ConfigContainer> task = this.cachedContainerTask;
        if (task == null || (task.isComplete() && !this.cachedContainerTask.isSuccessful())) {
            Executor executor = this.executor;
            final ConfigStorageClient configStorageClient = this.storageClient;
            Objects.requireNonNull(configStorageClient);
            this.cachedContainerTask = Tasks.call(executor, new Callable() { // from class: com.google.firebase.remoteconfig.internal.ConfigCacheClient$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return ConfigStorageClient.this.read();
                }
            });
        }
        return this.cachedContainerTask;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        synchronized (this) {
            this.cachedContainerTask = Tasks.forResult(null);
        }
        this.storageClient.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void updateInMemoryConfigContainer(ConfigContainer configContainer) {
        this.cachedContainerTask = Tasks.forResult(configContainer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized Task<ConfigContainer> getCachedContainerTask() {
        return this.cachedContainerTask;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized ConfigCacheClient getInstance(Executor executor, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String fileName = configStorageClient.getFileName();
            Map<String, ConfigCacheClient> map = clientInstances;
            if (!map.containsKey(fileName)) {
                map.put(fileName, new ConfigCacheClient(executor, configStorageClient));
            }
            configCacheClient = map.get(fileName);
        }
        return configCacheClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigCacheClient.class) {
            clientInstances.clear();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        Executor executor = DIRECT_EXECUTOR;
        task.addOnSuccessListener(executor, awaitListener);
        task.addOnFailureListener(executor, awaitListener);
        task.addOnCanceledListener(executor, awaitListener);
        if (!awaitListener.await(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }

    private static class AwaitListener<TResult> implements OnSuccessListener<TResult>, OnFailureListener, OnCanceledListener {
        private final CountDownLatch latch;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AwaitListener() {
            this.latch = new CountDownLatch(1);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            this.latch.countDown();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.tasks.OnCanceledListener
        public void onCanceled() {
            this.latch.countDown();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void await() throws InterruptedException {
            this.latch.await();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.latch.await(j, timeUnit);
        }
    }
}
