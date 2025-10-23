package com.facebook.gamingservices.cloudgaming;

import android.content.Context;
import android.content.Intent;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DaemonRequest {
    private Callback mCallback;
    private Context mContext;
    private SDKLogger mLogger;
    private JSONObject mParameters;
    private ConcurrentHashMap<String, CompletableFuture<GraphResponse>> mRequestStore;

    public interface Callback {
        void onCompleted(GraphResponse response);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DaemonRequest(Context context, JSONObject parameters, Callback callback) {
        this.mContext = context;
        this.mParameters = parameters;
        this.mCallback = callback;
        this.mRequestStore = DaemonReceiver.getInstance(context).getRequestStore();
        this.mLogger = SDKLogger.getInstance(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void executeAsync() throws ExecutionException, InterruptedException {
        createRequest().thenAccept((Consumer<? super GraphResponse>) new Consumer<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.Consumer
            public void accept(GraphResponse response) {
                if (DaemonRequest.this.mCallback != null) {
                    DaemonRequest.this.mCallback.onCompleted(response);
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GraphResponse executeAndWait() throws ExecutionException, InterruptedException {
        return createRequest().get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GraphResponse executeAndWait(int timeout) throws ExecutionException, InterruptedException, TimeoutException {
        return createRequest().get(timeout, TimeUnit.SECONDS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CompletableFuture<GraphResponse> createRequest() {
        return CompletableFuture.supplyAsync(new Supplier<GraphResponse>() { // from class: com.facebook.gamingservices.cloudgaming.DaemonRequest.2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.function.Supplier
            public GraphResponse get() {
                String uuid = UUID.randomUUID().toString();
                try {
                    DaemonRequest.this.mParameters.put(SDKConstants.REQUEST_ID, uuid);
                    Intent intent = new Intent();
                    String string = DaemonRequest.this.mParameters.getString("type");
                    DaemonRequest.this.mLogger.logPreparingRequest(string, uuid, DaemonRequest.this.mParameters);
                    if (!string.equals(SDKMessageEnum.GET_ACCESS_TOKEN.toString()) && !string.equals(SDKMessageEnum.IS_ENV_READY.toString())) {
                        String string2 = DaemonRequest.this.mContext.getSharedPreferences(SDKConstants.PREF_DAEMON_PACKAGE_NAME, 0).getString(SDKConstants.PARAM_DAEMON_PACKAGE_NAME, null);
                        if (string2 == null) {
                            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request with a secure connection"), uuid);
                        }
                        intent.setPackage(string2);
                    }
                    intent.setAction(SDKConstants.REQUEST_ACTION);
                    Iterator<String> keys = DaemonRequest.this.mParameters.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        intent.putExtra(next, DaemonRequest.this.mParameters.getString(next));
                    }
                    CompletableFuture completableFuture = new CompletableFuture();
                    DaemonRequest.this.mRequestStore.put(uuid, completableFuture);
                    DaemonRequest.this.mContext.sendBroadcast(intent);
                    DaemonRequest.this.mLogger.logSentRequest(string, uuid, DaemonRequest.this.mParameters);
                    return (GraphResponse) completableFuture.get();
                } catch (InterruptedException | ExecutionException | JSONException unused) {
                    return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), uuid);
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void executeAsync(Context context, JSONObject parameters, Callback callback, SDKMessageEnum type) {
        JSONObject put;
        try {
            if (parameters == null) {
                put = new JSONObject().put("type", type.toString());
            } else {
                put = parameters.put("type", type.toString());
            }
            new DaemonRequest(context, put, callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GraphResponse executeAndWait(Context context, JSONObject parameters, SDKMessageEnum type) {
        JSONObject put;
        try {
            if (parameters == null) {
                put = new JSONObject().put("type", type.toString());
            } else {
                put = parameters.put("type", type.toString());
            }
            return new DaemonRequest(context, put, null).executeAndWait();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GraphResponse executeAndWait(Context context, JSONObject parameters, SDKMessageEnum type, int timeout) {
        JSONObject put;
        try {
            if (parameters == null) {
                put = new JSONObject().put("type", type.toString());
            } else {
                put = parameters.put("type", type.toString());
            }
            return new DaemonRequest(context, put, null).executeAndWait(timeout);
        } catch (InterruptedException | ExecutionException | TimeoutException | JSONException unused) {
            return DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void executeAsync(Context context, JSONObject parameters, Callback callback, String type) {
        JSONObject put;
        try {
            if (parameters == null) {
                put = new JSONObject().put("type", type);
            } else {
                put = parameters.put("type", type);
            }
            new DaemonRequest(context, put, callback).executeAsync();
        } catch (InterruptedException | ExecutionException | JSONException unused) {
            if (callback != null) {
                callback.onCompleted(DaemonReceiver.createErrorResponse(new FacebookRequestError(-1, "DAEMON_REQUEST_EXECUTE_ASYNC_FAILED", "Unable to correctly create the request or obtain response"), (String) null));
            }
        }
    }
}
