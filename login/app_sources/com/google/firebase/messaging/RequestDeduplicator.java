package com.google.firebase.messaging;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new ArrayMap();

    interface GetTokenRequest {
        Task<String> start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized Task<String> getOrStartGetTokenRequest(final String str, GetTokenRequest getTokenRequest) {
        Task<String> task = this.getTokenRequests.get(str);
        if (task != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "Joining ongoing request for: " + str);
            }
            return task;
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Making new request for: " + str);
        }
        Task continueWithTask = getTokenRequest.start().continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.messaging.RequestDeduplicator$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return RequestDeduplicator.this.m422x7161fc54(str, task2);
            }
        });
        this.getTokenRequests.put(str, continueWithTask);
        return continueWithTask;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$getOrStartGetTokenRequest$0$com-google-firebase-messaging-RequestDeduplicator */
    /* synthetic */ Task m422x7161fc54(String str, Task task) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }
}
