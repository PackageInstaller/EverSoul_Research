package com.singular.sdk.internal;

import android.content.Context;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApiManager {
    private static final SingularLog logger = SingularLog.getLogger("ApiManager");
    final Context context;
    private Queue queue;
    final Runnable runnable = new Runnable() { // from class: com.singular.sdk.internal.ApiManager.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            if (!SingularInstance.getInstance().isInitialized()) {
                ApiManager.logger.debug("Singular is not initialized!");
                return;
            }
            if (!Utils.isConnected(ApiManager.this.context)) {
                ApiManager.logger.debug("Oops, not connected to internet!");
                return;
            }
            try {
                String peek = ApiManager.this.queue.peek();
                if (peek == null) {
                    ApiManager.logger.debug("Queue is empty");
                    return;
                }
                BaseApi from = BaseApi.from(peek);
                ApiManager.logger.debug("api = %s", from.getClass().getName());
                if (from.makeRequest(SingularInstance.getInstance())) {
                    Utils.resetRetryCountForKey(ApiManager.this.context, Long.toString(from.getTimestamp()));
                    ApiManager.this.queue.remove();
                    ApiManager.this.wakeUp();
                }
            } catch (Throwable th) {
                ApiManager.logger.error("IOException in processing an event: %s", th.getMessage());
            }
        }
    };
    private SingularWorkerThread worker;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApiManager(SingularWorkerThread singularWorkerThread, Context context, Queue queue) {
        this.context = context;
        this.queue = queue;
        if (queue == null) {
            return;
        }
        logger.debug("Queue: %s", queue.getClass().getSimpleName());
        if (singularWorkerThread == null) {
            return;
        }
        this.worker = singularWorkerThread;
        singularWorkerThread.start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void wakeUp() {
        SingularWorkerThread singularWorkerThread = this.worker;
        if (singularWorkerThread == null) {
            return;
        }
        singularWorkerThread.getHandler().removeCallbacksAndMessages(null);
        this.worker.post(this.runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void enqueue(BaseApi baseApi) {
        if (baseApi != null) {
            try {
                if (this.queue == null) {
                    return;
                }
                if (!(baseApi instanceof ApiGDPRConsent) && !(baseApi instanceof ApiGDPRUnder13)) {
                    baseApi.put(Constants.EVENT_INDEX, String.valueOf(Utils.getEventIndex(this.context)));
                }
                baseApi.put(Constants.SINGULAR_INSTALL_ID, Utils.getSingularId(this.context).toString());
                enrichRequestFromSingularInstance(baseApi);
                this.queue.add(baseApi.toJsonAsString());
                wakeUp();
            } catch (IndexOutOfBoundsException unused) {
            } catch (Throwable th) {
                logger.error("error in enqueue()", th);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void enrichRequestFromSingularInstance(BaseApi baseApi) {
        SingularInstance singularInstance = SingularInstance.getInstance();
        JSONObject globalPropertiesJSON = singularInstance.getGlobalPropertiesJSON();
        if (globalPropertiesJSON.length() != 0) {
            baseApi.put(Constants.GLOBAL_PROPERTIES_KEY, globalPropertiesJSON.toString());
        }
        Boolean limitDataSharing = singularInstance.getLimitDataSharing();
        if (limitDataSharing != null) {
            baseApi.put(Constants.DATA_SHARING_OPTIONS, new JSONObject(new HashMap(limitDataSharing) { // from class: com.singular.sdk.internal.ApiManager.1
                final /* synthetic */ Boolean val$limitDataSharing;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    this.val$limitDataSharing = limitDataSharing;
                    put("limit_data_sharing", Boolean.valueOf(limitDataSharing.booleanValue()));
                }
            }).toString());
        }
    }
}
