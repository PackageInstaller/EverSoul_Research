package com.facebook.gamingservices.cloudgaming.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookRequestError;
import com.facebook.appevents.InternalAppEventsLogger;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKLogger {
    private static SDKLogger instance;
    private final InternalAppEventsLogger logger;
    private String appID = null;
    private String userID = null;
    private String sessionID = null;
    private ConcurrentHashMap<String, String> requestIDToFunctionTypeMap = new ConcurrentHashMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SDKLogger(Context context) {
        this.logger = new InternalAppEventsLogger(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized SDKLogger getInstance(Context context) {
        SDKLogger sDKLogger;
        synchronized (SDKLogger.class) {
            if (instance == null) {
                instance = new SDKLogger(context);
            }
            sDKLogger = instance;
        }
        return sDKLogger;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void logInternalError(Context context, SDKMessageEnum functionType, Exception e) {
        getInstance(context).logInternalError(functionType, e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logPreparingRequest(String functionType, String requestID, JSONObject payloads) {
        Bundle parametersWithRequestIDAndFunctionType = getParametersWithRequestIDAndFunctionType(requestID, functionType);
        parametersWithRequestIDAndFunctionType.putString("payload", payloads.toString());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_PREPARING_REQUEST, parametersWithRequestIDAndFunctionType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logSentRequest(String functionType, String requestID, JSONObject payloads) {
        Bundle parametersWithRequestIDAndFunctionType = getParametersWithRequestIDAndFunctionType(requestID, functionType);
        this.requestIDToFunctionTypeMap.put(requestID, functionType);
        parametersWithRequestIDAndFunctionType.putString("payload", payloads.toString());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENT_REQUEST, parametersWithRequestIDAndFunctionType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logSendingSuccessResponse(String requestID) {
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENDING_SUCCESS_RESPONSE, getParametersWithRequestIDAndFunctionType(requestID));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logSendingErrorResponse(FacebookRequestError error, String requestID) {
        Bundle parametersWithRequestIDAndFunctionType = getParametersWithRequestIDAndFunctionType(requestID);
        parametersWithRequestIDAndFunctionType.putString("error_code", Integer.toString(error.getErrorCode()));
        parametersWithRequestIDAndFunctionType.putString("error_type", error.getErrorType());
        parametersWithRequestIDAndFunctionType.putString("error_message", error.getErrorMessage());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_SENDING_ERROR_RESPONSE, parametersWithRequestIDAndFunctionType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logLoginSuccess() {
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_LOGIN_SUCCESS, getInitParameters());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logGameLoadComplete() {
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_GAME_LOAD_COMPLETE, getInitParameters());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logInternalError(SDKMessageEnum functionType, Exception e) {
        Bundle initParameters = getInitParameters();
        initParameters.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, functionType.toString());
        initParameters.putString("error_type", e.getClass().getName());
        initParameters.putString("error_message", e.getMessage());
        this.logger.logEventImplicitly(SDKAnalyticsEvents.EVENT_INTERNAL_ERROR, initParameters);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAppID(String appID) {
        this.appID = appID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Bundle getParametersWithRequestIDAndFunctionType(String requestID) {
        Bundle initParameters = getInitParameters();
        if (requestID != null) {
            String orDefault = this.requestIDToFunctionTypeMap.getOrDefault(requestID, null);
            initParameters.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, requestID);
            if (orDefault != null) {
                initParameters.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, orDefault);
                this.requestIDToFunctionTypeMap.remove(requestID);
            }
        }
        return initParameters;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Bundle getParametersWithRequestIDAndFunctionType(String requestID, String functionType) {
        Bundle initParameters = getInitParameters();
        initParameters.putString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID, requestID);
        initParameters.putString(SDKAnalyticsEvents.PARAMETER_FUNCTION_TYPE, functionType);
        return initParameters;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Bundle getInitParameters() {
        Bundle bundle = new Bundle();
        String str = this.appID;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = this.sessionID;
        if (str2 != null) {
            bundle.putString(SDKAnalyticsEvents.PARAMETER_SESSION_ID, str2);
        }
        return bundle;
    }
}
