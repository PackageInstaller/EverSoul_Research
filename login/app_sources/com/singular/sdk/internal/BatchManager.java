package com.singular.sdk.internal;

import android.content.Context;
import com.facebook.internal.ServerProtocol;
import com.singular.sdk.internal.ConfigManager;
import com.singular.sdk.internal.Constants;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BatchManager {
    private static final String SEND_ID = "send_id";
    private static BatchManager instance;
    private static final SingularLog logger = SingularLog.getLogger("BatchManager");
    private BatchManagerPersistence batchManagerPersistence;
    private Context context;
    private boolean debug;
    private NetworkSender networkSender;
    private RegularFlowSender regularFlowSender;
    private long sendId;
    private boolean shouldBatchEvents;
    private Semaphore sendIdMutex = new Semaphore(1, true);
    private Semaphore sendMutex = new Semaphore(1, true);
    private String configUpdateId = null;
    private String[] batchFields = {"ad_platform", Constants.ADMON_CURRENCY, Constants.REVENUE_CURRENCY_KEY};
    private Map<String, BaseApi> eventsDataStructure = new ConcurrentHashMap();

    public interface NetworkSender {
        boolean sendApi(BaseApi baseApi);
    }

    public interface RegularFlowSender {
        void sendApi(BaseApi baseApi);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String prepareKey(BaseApi baseApi) throws JSONException {
        logger.debug("prepareKey for API: " + baseApi.toJsonAsString());
        JSONObject jSONObject = new JSONObject((String) baseApi.get(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(SEND_ID, this.sendId);
        for (String str : this.batchFields) {
            try {
                jSONObject2.put(str, jSONObject.getString(str));
            } catch (JSONException e) {
                logger.error(Utils.formatException(e));
            }
        }
        logger.debug("prepareKey result: " + jSONObject2.toString());
        return jSONObject2.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BatchManager getInstance() {
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BatchManager(Context context, BatchManagerPersistence batchManagerPersistence, NetworkSender networkSender, RegularFlowSender regularFlowSender) {
        this.shouldBatchEvents = false;
        this.debug = false;
        this.batchManagerPersistence = batchManagerPersistence;
        this.networkSender = networkSender;
        this.regularFlowSender = regularFlowSender;
        this.sendId = batchManagerPersistence.getSendId();
        this.shouldBatchEvents = ConfigManager.getInstance().getConfig().isAggregateAdmonEvents();
        this.debug = ConfigManager.getInstance().getConfig().isAdmonEventsDebug();
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void init(Context context, BatchManagerPersistence batchManagerPersistence, NetworkSender networkSender, RegularFlowSender regularFlowSender) {
        logger.debug("init with persistence: " + batchManagerPersistence.getClass().getName());
        BatchManager batchManager = new BatchManager(context, batchManagerPersistence, networkSender, regularFlowSender);
        batchManager.loadFromPersistence();
        batchManager.configUpdateId = ConfigManager.getInstance().registerForConfigUpdates(new ConfigManager.ConfigUpdateHandler() { // from class: com.singular.sdk.internal.BatchManager.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.ConfigManager.ConfigUpdateHandler
            public void onSync(boolean z) {
                ConfigManager.getInstance().unregisterConfigUpdates(BatchManager.this.configUpdateId);
                BatchManager.this.shouldBatchEvents = ConfigManager.getInstance().getConfig().isAggregateAdmonEvents();
                BatchManager.this.debug = ConfigManager.getInstance().getConfig().isAdmonEventsDebug();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.ConfigManager.ConfigUpdateHandler
            public void onSyncError() {
                ConfigManager.getInstance().unregisterConfigUpdates(BatchManager.instance.configUpdateId);
            }
        });
        instance = batchManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void batchEvent(BaseApi baseApi) throws JSONException, IOException {
        try {
            this.sendIdMutex.acquire();
        } catch (InterruptedException e) {
            logger.error(Utils.formatException(e));
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String prepareKey = prepareKey(baseApi);
            SingularLog singularLog = logger;
            singularLog.debug("batchEvent: " + baseApi.toJsonAsString());
            singularLog.debug("batchEvent: key: " + prepareKey);
            JSONObject jSONObject = new JSONObject((String) baseApi.get(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY));
            if (this.eventsDataStructure.containsKey(prepareKey)) {
                BaseApi baseApi2 = this.eventsDataStructure.get(prepareKey);
                JSONObject jSONObject2 = new JSONObject((String) baseApi2.get(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY));
                double d = jSONObject2.getDouble(Constants.REVENUE_AMOUNT_KEY) + jSONObject.getDouble(Constants.REVENUE_AMOUNT_KEY);
                double d2 = jSONObject2.getDouble(Constants.ADMON_REVENUE) + jSONObject.getDouble(Constants.ADMON_REVENUE);
                int i = jSONObject2.getInt(Constants.ADMON_COUNT) + 1;
                jSONObject2.put(Constants.REVENUE_AMOUNT_KEY, d);
                jSONObject2.put(Constants.ADMON_REVENUE, d2);
                jSONObject2.put(Constants.ADMON_COUNT, i);
                jSONObject2.put(Constants.ADMON_LAST_UPDATE_TIMESTAMP, currentTimeMillis);
                baseApi2.put(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, jSONObject2.toString());
                singularLog.debug("batchEvent: added to existing event: " + baseApi2.toJsonAsString());
                this.sendIdMutex.release();
                this.batchManagerPersistence.updateEvent(prepareKey, baseApi2.toJsonAsString());
            } else {
                JSONObject jSONObject3 = new JSONObject(prepareKey);
                jSONObject3.remove(SEND_ID);
                double d3 = jSONObject.getDouble(Constants.REVENUE_AMOUNT_KEY);
                double d4 = jSONObject.getDouble(Constants.ADMON_REVENUE);
                jSONObject3.put(Constants.REVENUE_AMOUNT_KEY, d3);
                jSONObject3.put(Constants.ADMON_REVENUE, d4);
                jSONObject3.put(Constants.ADMON_COUNT, 1);
                jSONObject3.put(Constants.ADMON_IS_ADMON_REVENUE, jSONObject.getBoolean(Constants.ADMON_IS_ADMON_REVENUE));
                jSONObject3.put(Constants.IS_REVENUE_EVENT_KEY, jSONObject.getBoolean(Constants.IS_REVENUE_EVENT_KEY));
                jSONObject3.put(Constants.ADMON_FIRST_UPDATE_TIMESTAMP, currentTimeMillis);
                jSONObject3.put(Constants.ADMON_LAST_UPDATE_TIMESTAMP, currentTimeMillis);
                baseApi.put(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, jSONObject3.toString());
                baseApi.put(Constants.EVENT_INDEX, "a" + String.valueOf(Utils.getAdmonEventIndex(this.context)));
                if (this.debug) {
                    baseApi.put(Constants.ADMON_EVENT_DEBUG_PARAM, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                this.eventsDataStructure.put(prepareKey, baseApi);
                this.sendIdMutex.release();
                this.batchManagerPersistence.addEvent(prepareKey, baseApi.toJsonAsString());
                singularLog.debug("batchEvent: created 1st event: " + baseApi.toJsonAsString());
            }
        } catch (Throwable th) {
            this.sendIdMutex.release();
            logger.error(Utils.formatException(th));
            reportException(th);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void loadFromPersistence() {
        logger.debug("loadFromPersistence");
        for (Map.Entry<String, String> entry : this.batchManagerPersistence.getAllEvents()) {
            try {
                this.eventsDataStructure.put(entry.getKey(), BaseApi.from(entry.getValue()));
            } catch (Throwable th) {
                logger.error(Utils.formatException(th));
            }
        }
        logger.debug("loadFromPersistence: loaded " + this.eventsDataStructure.size() + " entries");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addToBatch(final BaseApi baseApi) {
        if (this.shouldBatchEvents && this.debug && baseApi.isAdmonEvent()) {
            try {
                this.regularFlowSender.sendApi(BaseApi.from(baseApi.toJsonAsString()));
            } catch (IOException e) {
                logger.error("IOExceptionException", e);
            } catch (Throwable th) {
                logger.error("Throwable", th);
            }
        }
        try {
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.BatchManager.2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    BatchManager.logger.debug("addToBatch api: " + baseApi.toJsonAsString());
                    if (!BatchManager.this.shouldBatchEvents || !baseApi.isAdmonEvent()) {
                        BatchManager.logger.debug("addToBatch: no need to batch: batching enabled: " + BatchManager.this.shouldBatchEvents + " is Admon event: " + baseApi.isAdmonEvent());
                        BatchManager.this.regularFlowSender.sendApi(baseApi);
                        return;
                    }
                    BatchManager.logger.debug("addToBatch: event needs to be batched");
                    try {
                        BatchManager.this.batchEvent(baseApi);
                    } catch (Throwable th2) {
                        BatchManager.logger.debug("addToBatch: exception: " + th2.getMessage());
                        if (BatchManager.this.debug) {
                            return;
                        }
                        BatchManager.this.regularFlowSender.sendApi(baseApi);
                    }
                }
            });
        } catch (Throwable th2) {
            logger.error(Utils.formatException(th2));
            reportException(th2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void sendEvents() {
        if (this.shouldBatchEvents) {
            try {
                Executors.newSingleThreadExecutor().execute(new RunnableC26003());
            } catch (Throwable th) {
                logger.error(Utils.formatException(th));
                reportException(th);
            }
        }
    }

    /* renamed from: com.singular.sdk.internal.BatchManager$3 */
    class RunnableC26003 implements Runnable {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RunnableC26003() {
        }

        /* JADX WARN: Finally extract failed */
        /* JADX WARN: Removed duplicated region for block: B:16:0x00a6 A[Catch: all -> 0x0132, TRY_LEAVE, TryCatch #0 {all -> 0x0132, blocks: (B:4:0x0021, B:5:0x0072, B:7:0x0075, B:9:0x008c, B:11:0x0091, B:14:0x0094, B:16:0x00a6, B:23:0x00ef, B:27:0x010a, B:28:0x0110, B:36:0x0120, B:39:0x0128, B:40:0x0131, B:50:0x0016, B:26:0x0102, B:3:0x0002, B:35:0x0115, B:18:0x00dd), top: B:2:0x0002, inners: #1, #2, #3, #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0075 A[Catch: all -> 0x0132, TryCatch #0 {all -> 0x0132, blocks: (B:4:0x0021, B:5:0x0072, B:7:0x0075, B:9:0x008c, B:11:0x0091, B:14:0x0094, B:16:0x00a6, B:23:0x00ef, B:27:0x010a, B:28:0x0110, B:36:0x0120, B:39:0x0128, B:40:0x0131, B:50:0x0016, B:26:0x0102, B:3:0x0002, B:35:0x0115, B:18:0x00dd), top: B:2:0x0002, inners: #1, #2, #3, #5 }] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 348
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.BatchManager.RunnableC26003.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reportException(Throwable th) {
        try {
            SingularExceptionReporter.getReporter(this.context, false).reportException(th);
        } catch (RuntimeException unused) {
        }
    }
}
