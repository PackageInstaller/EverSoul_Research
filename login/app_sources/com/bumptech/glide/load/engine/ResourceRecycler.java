package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean isRecycling;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ResourceRecycler() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void recycle(Resource<?> resource) {
        if (this.isRecycling) {
            this.handler.obtainMessage(1, resource).sendToTarget();
        } else {
            this.isRecycling = true;
            resource.recycle();
            this.isRecycling = false;
        }
    }

    private static final class ResourceRecyclerCallback implements Handler.Callback {
        static final int RECYCLE_RESOURCE = 1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResourceRecyclerCallback() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((Resource) message.obj).recycle();
            return true;
        }
    }
}
