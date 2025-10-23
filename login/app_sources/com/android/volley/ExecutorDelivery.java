package com.android.volley;

import android.os.Handler;
import com.liapp.y;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ExecutorDelivery implements ResponseDelivery {
    private final Executor mResponsePoster;

    private class ResponseDeliveryRunnable implements Runnable {
        private final Request mRequest;
        private final Response mResponse;
        private final Runnable mRunnable;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ResponseDeliveryRunnable(Request request, Response response, Runnable runnable) {
            this.mRequest = request;
            this.mResponse = response;
            this.mRunnable = runnable;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (this.mRequest.isCanceled()) {
                this.mRequest.finish(y.ݬֲ֮ܲت(1512846135));
                return;
            }
            if (this.mResponse.isSuccess()) {
                this.mRequest.deliverResponse(this.mResponse.result);
            } else {
                this.mRequest.deliverError(this.mResponse.error);
            }
            if (this.mResponse.intermediate) {
                this.mRequest.addMarker(y.٬ݯح׭٩(576118126));
            } else {
                this.mRequest.finish(y.ۮڭڭܬި(862024483));
            }
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExecutorDelivery(final Handler handler) {
        this.mResponsePoster = new Executor() { // from class: com.android.volley.ExecutorDelivery.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExecutorDelivery(Executor executor) {
        this.mResponsePoster = executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.ResponseDelivery
    public void postError(Request<?> request, VolleyError volleyError) {
        request.addMarker(y.ݬֲ֮ܲت(1512845791));
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(request, Response.error(volleyError), null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response) {
        postResponse(request, response, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.ResponseDelivery
    public void postResponse(Request<?> request, Response<?> response, Runnable runnable) {
        request.markDelivered();
        request.addMarker(y.دײܮڳܯ(2051807445));
        this.mResponsePoster.execute(new ResponseDeliveryRunnable(request, response, runnable));
    }
}
