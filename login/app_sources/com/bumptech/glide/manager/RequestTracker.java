package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RequestTracker {
    private static final String TAG = "RequestTracker";
    private boolean isPaused;
    private final Set<Request> requests = Collections.newSetFromMap(new WeakHashMap());
    private final List<Request> pendingRequests = new ArrayList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void runRequest(Request request) {
        this.requests.add(request);
        if (!this.isPaused) {
            request.begin();
            return;
        }
        request.clear();
        String str = y.ٴسسݬߨ(1393030210);
        if (Log.isLoggable(str, 2)) {
            Log.v(str, y.ۮڭڭܬި(862166443));
        }
        this.pendingRequests.add(request);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void addRequest(Request request) {
        this.requests.add(request);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean clearAndRemove(Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.requests.remove(request);
        if (!this.pendingRequests.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isPaused() {
        return this.isPaused;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void pauseRequests() {
        this.isPaused = true;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (request.isRunning()) {
                request.pause();
                this.pendingRequests.add(request);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void pauseAllRequests() {
        this.isPaused = true;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (request.isRunning() || request.isComplete()) {
                request.clear();
                this.pendingRequests.add(request);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resumeRequests() {
        this.isPaused = false;
        for (Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isRunning()) {
                request.begin();
            }
        }
        this.pendingRequests.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearRequests() {
        Iterator it = Util.getSnapshot(this.requests).iterator();
        while (it.hasNext()) {
            clearAndRemove((Request) it.next());
        }
        this.pendingRequests.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void restartRequests() {
        for (Request request : Util.getSnapshot(this.requests)) {
            if (!request.isComplete() && !request.isCleared()) {
                request.clear();
                if (!this.isPaused) {
                    request.begin();
                } else {
                    this.pendingRequests.add(request);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return super.toString() + y.٬ݯح׭٩(575943006) + this.requests.size() + y.ٲٴݴ״ٰ(1781721840) + this.isPaused + y.ۮڭڭܬި(861939259);
    }
}
