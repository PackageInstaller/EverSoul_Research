package com.google.firebase.messaging;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class SharedPreferencesQueue {
    private final String itemSeparator;
    private final String queueName;
    private final SharedPreferences sharedPreferences;
    private final Executor syncExecutor;
    final ArrayDeque<String> internalQueue = new ArrayDeque<>();
    private boolean bulkOperation = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SharedPreferencesQueue(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        this.sharedPreferences = sharedPreferences;
        this.queueName = str;
        this.itemSeparator = str2;
        this.syncExecutor = executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static SharedPreferencesQueue createInstance(SharedPreferences sharedPreferences, String str, String str2, Executor executor) {
        SharedPreferencesQueue sharedPreferencesQueue = new SharedPreferencesQueue(sharedPreferences, str, str2, executor);
        sharedPreferencesQueue.initQueue();
        return sharedPreferencesQueue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initQueue() {
        synchronized (this.internalQueue) {
            this.internalQueue.clear();
            String string = this.sharedPreferences.getString(this.queueName, "");
            if (!TextUtils.isEmpty(string) && string.contains(this.itemSeparator)) {
                String[] split = string.split(this.itemSeparator, -1);
                if (split.length == 0) {
                    Log.e(Constants.TAG, "Corrupted queue. Please check the queue contents and item separator provided");
                }
                for (String str : split) {
                    if (!TextUtils.isEmpty(str)) {
                        this.internalQueue.add(str);
                    }
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<String> toList() {
        ArrayList arrayList;
        synchronized (this.internalQueue) {
            arrayList = new ArrayList(this.internalQueue);
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean add(String str) {
        boolean checkAndSyncState;
        if (TextUtils.isEmpty(str) || str.contains(this.itemSeparator)) {
            return false;
        }
        synchronized (this.internalQueue) {
            checkAndSyncState = checkAndSyncState(this.internalQueue.add(str));
        }
        return checkAndSyncState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String checkAndSyncState(String str) {
        checkAndSyncState(str != null);
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean checkAndSyncState(boolean z) {
        if (z && !this.bulkOperation) {
            syncStateAsync();
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void syncStateAsync() {
        this.syncExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.SharedPreferencesQueue$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                SharedPreferencesQueue.this.syncState();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void syncState() {
        synchronized (this.internalQueue) {
            this.sharedPreferences.edit().putString(this.queueName, serialize()).commit();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.internalQueue.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(this.itemSeparator);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void beginTransaction() {
        this.bulkOperation = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void beginTransactionSync() {
        synchronized (this.internalQueue) {
            beginTransaction();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void commitTransaction() {
        this.bulkOperation = false;
        syncStateAsync();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void commitTransactionSync() {
        synchronized (this.internalQueue) {
            commitTransaction();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String serializeSync() {
        String serialize;
        synchronized (this.internalQueue) {
            serialize = serialize();
        }
        return serialize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean remove(Object obj) {
        boolean checkAndSyncState;
        synchronized (this.internalQueue) {
            checkAndSyncState = checkAndSyncState(this.internalQueue.remove(obj));
        }
        return checkAndSyncState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String remove() {
        String checkAndSyncState;
        synchronized (this.internalQueue) {
            checkAndSyncState = checkAndSyncState(this.internalQueue.remove());
        }
        return checkAndSyncState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        synchronized (this.internalQueue) {
            this.internalQueue.clear();
            checkAndSyncState(true);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String peek() {
        String peek;
        synchronized (this.internalQueue) {
            peek = this.internalQueue.peek();
        }
        return peek;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int size() {
        int size;
        synchronized (this.internalQueue) {
            size = this.internalQueue.size();
        }
        return size;
    }
}
