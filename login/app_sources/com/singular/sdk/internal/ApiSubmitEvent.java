package com.singular.sdk.internal;

import com.kakaogame.auth.agreement.AgreementService;
import com.kakaogame.server.ServerConstants;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import com.singular.sdk.internal.Constants;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApiSubmitEvent extends BaseApi {
    private static final SingularLog logger = SingularLog.getLogger("ApiSubmitEvent");
    static final String path = "/event";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Api
    public String getPath() {
        return path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ long getTimestamp() {
        return super.getTimestamp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ String getType() {
        return super.getType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BaseApi
    public /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BaseApi
    public /* bridge */ /* synthetic */ boolean isAdmonEvent() {
        return super.isAdmonEvent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ boolean makeRequest(SingularInstance singularInstance) throws IOException {
        return super.makeRequest(singularInstance);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.BaseApi, com.singular.sdk.internal.Api
    public /* bridge */ /* synthetic */ String toJsonAsString() {
        return super.toJsonAsString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ApiSubmitEvent(long j) {
        super(Constants.API_TYPE_EVENT, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback getOnApiCallback() {
        return new OnEventSubmitCallback();
    }

    public class OnEventSubmitCallback implements Api.OnApiCallback {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OnEventSubmitCallback() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean handle(SingularInstance singularInstance, int i, String str) {
            if (i == 413) {
                return true;
            }
            if (i != 200) {
                return false;
            }
            try {
            } catch (JSONException e) {
                ApiSubmitEvent.logger.error("error in handle()", e);
            }
            return new JSONObject(str).optString("status", "").equalsIgnoreCase("ok");
        }
    }

    public static class RawEvent {
        final String extra;
        final String name;
        final long timestamp;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RawEvent(String str, String str2) {
            this.name = str.replace("\\n", "");
            this.extra = !Utils.isEmptyOrNull(str2) ? str2.replace("\\n", "") : null;
            this.timestamp = Utils.getCurrentTimeMillis();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            StringBuilder sb = new StringBuilder("RawEvent{name='");
            sb.append(this.name).append("', extra='");
            sb.append(this.extra).append("', timestamp=");
            sb.append(this.timestamp);
            sb.append('}');
            return sb.toString();
        }
    }

    static class Params extends SingularParamsBase {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Params build(RawEvent rawEvent, SingularInstance singularInstance) {
            return new Params().withName(rawEvent.name).withExtra(rawEvent.extra).withSecondsIntoSession((rawEvent.timestamp - r0) * 0.001d).withSession(singularInstance.getSessionManager().getSessionId()).withSequence(singularInstance.getSessionManager().getNextSequenceNumber()).withSingularConfig(singularInstance.getSingularConfig()).withDeviceInfo(singularInstance.getDeviceInfo());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withName(String str) {
            put(AgreementService.VALUE_NO, str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withSession(long j) {
            put("s", String.valueOf(j));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withSecondsIntoSession(double d) {
            put("t", String.valueOf(d));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withExtra(String str) {
            try {
                if (Utils.isEmptyOrNull(str)) {
                    str = new JSONObject().put(Constants.IS_REVENUE_EVENT_KEY, false).toString();
                } else {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!jSONObject.optBoolean(Constants.IS_REVENUE_EVENT_KEY, false)) {
                        str = jSONObject.put(Constants.IS_REVENUE_EVENT_KEY, false).toString();
                    }
                }
                put(Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, str);
            } catch (JSONException e) {
                ApiSubmitEvent.logger.error("Error in JSON serialization", e);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withSequence(long j) {
            put(ServerConstants.SEQ, String.valueOf(j));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withSingularConfig(SingularConfig singularConfig) {
            put("a", singularConfig.apiKey);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.singular.sdk.internal.SingularParamsBase
        public Params withDeviceInfo(DeviceInfo deviceInfo) {
            super.withDeviceInfo(deviceInfo);
            put("av", deviceInfo.appVersion);
            put("sdk", Utils.getSdkVersion());
            put(Constants.CUSTOM_USER_ID_KEY, deviceInfo.customUserId);
            return this;
        }
    }
}
