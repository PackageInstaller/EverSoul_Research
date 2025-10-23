package com.singular.sdk.internal;

import com.singular.sdk.SingularConfig;
import com.singular.sdk.internal.Api;
import java.io.IOException;

/* loaded from: classes3.dex */
public class ApiGDPRConsent extends BaseApi {
    private static final SingularLog logger = SingularLog.getLogger("ApiGDPRConsent");
    static final String path = "/opengdpr";

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
    ApiGDPRConsent(long j) {
        super(Constants.API_TYPE_GDPR_CONSENT, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback getOnApiCallback() {
        return new OnResolveCallback();
    }

    public class OnResolveCallback implements Api.OnApiCallback {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean handle(SingularInstance singularInstance, int i, String str) {
            return i == 200;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OnResolveCallback() {
        }
    }

    static class Params extends SingularParamsBase {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Params build(SingularInstance singularInstance) {
            return new Params().withBaseParams().withSingularConfig(singularInstance.getSingularConfig()).withDeviceInfo(singularInstance.getDeviceInfo());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withBaseParams() {
            put("op", "consent");
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
            put("sdk", Utils.getSdkVersion());
            return this;
        }
    }
}
