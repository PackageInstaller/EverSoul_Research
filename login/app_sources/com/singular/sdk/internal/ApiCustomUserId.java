package com.singular.sdk.internal;

import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApiCustomUserId extends BaseApi {
    private static final SingularLog logger = SingularLog.getLogger("ApiCustomUserId");
    static final String path = "/set_device_for_custom_id";

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
    public ApiCustomUserId(long j) {
        super(Constants.API_TYPE_CUSTOM_USER_ID, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback getOnApiCallback() {
        return new OnSetCustomUserIdCallback();
    }

    public class OnSetCustomUserIdCallback implements Api.OnApiCallback {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OnSetCustomUserIdCallback() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean handle(SingularInstance singularInstance, int i, String str) {
            if (i != 200) {
                return false;
            }
            try {
                return new JSONObject(str).optString("status", "").equalsIgnoreCase("ok");
            } catch (JSONException e) {
                ApiCustomUserId.logger.error("error in handle()", e);
                return false;
            }
        }
    }

    static class Params extends SingularParamsBase {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Params build(SingularInstance singularInstance) {
            return new Params().withSingularConfig(singularInstance.getSingularConfig()).withDeviceInfo(singularInstance.getDeviceInfo());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withSingularConfig(SingularConfig singularConfig) {
            put("a", singularConfig.apiKey);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        
            if (r4.isLimitedTrackingEnabled != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0022, code lost:
        
            if (r4.isLimitedTrackingEnabled != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0025, code lost:
        
            r1 = com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_NO;
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.singular.sdk.internal.SingularParamsBase
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.singular.sdk.internal.ApiCustomUserId.Params withDeviceInfo(com.singular.sdk.internal.DeviceInfo r4) {
            /*
                r3 = this;
                super.withDeviceInfo(r4)
                java.lang.String r0 = "sdk"
                java.lang.String r1 = r4.sdkVersion
                r3.put(r0, r1)
                java.lang.String r0 = "av"
                java.lang.String r1 = r4.appVersion
                r3.put(r0, r1)
                java.lang.String r0 = "n"
                java.lang.String r1 = r4.appName
                r3.put(r0, r1)
                boolean r0 = r4.isGooglePlayServicesAvailable
                java.lang.String r1 = "1"
                java.lang.String r2 = "0"
                if (r0 == 0) goto L27
                boolean r0 = r4.isLimitedTrackingEnabled
                if (r0 == 0) goto L25
                goto L32
            L25:
                r1 = r2
                goto L32
            L27:
                boolean r0 = r4.isAmazonAvailable
                if (r0 == 0) goto L30
                boolean r0 = r4.isLimitedTrackingEnabled
                if (r0 == 0) goto L25
                goto L32
            L30:
                java.lang.String r1 = "-1"
            L32:
                java.lang.String r0 = "dnt"
                r3.put(r0, r1)
                java.lang.String r0 = "custom_user_id"
                java.lang.String r4 = r4.customUserId
                r3.put(r0, r4)
                return r3
                fill-array 0x0040: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.ApiCustomUserId.Params.withDeviceInfo(com.singular.sdk.internal.DeviceInfo):com.singular.sdk.internal.ApiCustomUserId$Params");
        }
    }
}
