package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class Jobs {
    private final Map<Key, EngineJob<?>> jobs = new HashMap();
    private final Map<Key, EngineJob<?>> onlyCacheJobs = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Jobs() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Map<Key, EngineJob<?>> getAll() {
        return Collections.unmodifiableMap(this.jobs);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EngineJob<?> get(Key key, boolean z) {
        return getJobMap(z).get(key);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void put(Key key, EngineJob<?> engineJob) {
        getJobMap(engineJob.onlyRetrieveFromCache()).put(key, engineJob);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void removeIfCurrent(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> jobMap = getJobMap(engineJob.onlyRetrieveFromCache());
        if (engineJob.equals(jobMap.get(key))) {
            jobMap.remove(key);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Map<Key, EngineJob<?>> getJobMap(boolean z) {
        return z ? this.onlyCacheJobs : this.jobs;
    }
}
