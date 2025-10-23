package com.singular.sdk.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.internal.ServerProtocol;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularLinkParams;
import com.singular.sdk.internal.Api;
import com.singular.sdk.internal.ApiSubmitEvent;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.LicenseApiHelper;
import com.singular.sdk.internal.SingularParamsBase;
import com.singular.sdk.internal.utils.UriUtils;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ApiStartSession extends BaseApi {
    private static final int LICENSE_RETRY_INTERVAL_MS = 3000;
    private static final SingularLog logger = SingularLog.getLogger("ApiStartSession");
    static final String path = "/start";
    private int licenseAttemptsCounter;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Api
    public String getPath() {
        return path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ int access$108(ApiStartSession apiStartSession) {
        int i = apiStartSession.licenseAttemptsCounter;
        apiStartSession.licenseAttemptsCounter = i + 1;
        return i;
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
    ApiStartSession(long j) {
        super(Constants.API_TYPE_SESSION_START, j);
        this.licenseAttemptsCounter = 0;
    }

    private class ApiStartSessionConstants {
        static final String STRING_REFERRER = "referrer";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ApiStartSessionConstants() {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.singular.sdk.internal.Api
    public Api.OnApiCallback getOnApiCallback() {
        return new OnSessionStartCallback();
    }

    public class OnSessionStartCallback implements Api.OnApiCallback {
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isLicenseResponseValid(int i) {
            return (i == -1 || i == 257 || i == 4) ? false : true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public OnSessionStartCallback() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.singular.sdk.internal.Api.OnApiCallback
        public boolean handle(SingularInstance singularInstance, int i, String str) {
            String str2;
            if (i != 200) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.optString("status", "").equalsIgnoreCase("ok")) {
                    return false;
                }
                String optString = jSONObject.optString("ddl", null);
                String optString2 = jSONObject.optString("deferred_passthrough", null);
                if (!Utils.isOpenedWithDeeplink() && (!Utils.isEmptyOrNull(optString) || !Utils.isEmptyOrNull(optString2))) {
                    handleDDL(singularInstance, optString, optString2);
                }
                String optString3 = jSONObject.optString(Constants.RESOLVED_SINGULAR_LINK, null);
                if (!Utils.isEmptyOrNull(optString3) && (str2 = (String) ApiStartSession.this.get(Constants.SINGULAR_LINK_RESOLVE_REQUIRED)) != null && Boolean.parseBoolean(str2) && Utils.lagSince(ApiStartSession.this.getTimestamp()) < SingularInstance.getInstance().getSingularConfig().shortlinkTimeoutSec) {
                    Utils.handleSingularLink(Uri.parse(optString3));
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(Constants.DEVICE_ATTRIBUTION_INFO_KEY);
                if (optJSONObject != null) {
                    singularInstance.handleDeviceAttributionData(optJSONObject);
                }
                String str3 = (String) ApiStartSession.this.get(SingularParamsBase.Constants.IDENTIFIER_UNIQUE_ID_KEY);
                if (Utils.isEmptyOrNull(str3) || Utils.isLicenseRetrieved(singularInstance.getContext(), str3)) {
                    return true;
                }
                Utils.saveLicenseInfo(singularInstance.getContext(), str3);
                performLicenseCheck(singularInstance, str3);
                return true;
            } catch (JSONException e) {
                ApiStartSession.logger.error("error in handle()", e);
                return false;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void performLicenseCheck(SingularInstance singularInstance, String str) {
            ApiStartSession.logger.debug("Trying to fetch license key from the Licensing Service");
            new Thread(new RunnableC25961(singularInstance, str)).start();
        }

        /* renamed from: com.singular.sdk.internal.ApiStartSession$OnSessionStartCallback$1 */
        class RunnableC25961 implements Runnable {
            final /* synthetic */ String val$identifier;
            final /* synthetic */ SingularInstance val$singular;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            RunnableC25961(SingularInstance singularInstance, String str) {
                this.val$singular = singularInstance;
                this.val$identifier = str;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                ApiStartSession.access$108(ApiStartSession.this);
                LicenseApiHelper.checkLicense(this.val$singular.getContext(), new LicenseApiHelper.LicenseResultHandler() { // from class: com.singular.sdk.internal.ApiStartSession.OnSessionStartCallback.1.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.singular.sdk.internal.LicenseApiHelper.LicenseResultHandler
                    public void handle(final int i, final String str, final String str2) {
                        new Thread(new Runnable() { // from class: com.singular.sdk.internal.ApiStartSession.OnSessionStartCallback.1.1.1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (!OnSessionStartCallback.this.isLicenseResponseValid(i) && ApiStartSession.this.licenseAttemptsCounter < 3) {
                                        Thread.sleep(ApiStartSession.this.licenseAttemptsCounter * 3000);
                                        OnSessionStartCallback.this.performLicenseCheck(RunnableC25961.this.val$singular, RunnableC25961.this.val$identifier);
                                        return;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("responseCode", String.valueOf(i));
                                    jSONObject.put("signedData", str);
                                    jSONObject.put("signature", str2);
                                    RunnableC25961.this.val$singular.logEvent(new ApiSubmitEvent.RawEvent(LicenseApiHelper.LICENSING_EVENT_NAME, jSONObject.toString()));
                                } catch (Throwable th) {
                                    ApiStartSession.logger.error("Error occurred while trying to send licensing status event", th);
                                }
                            }
                        }).start();
                    }
                });
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void handleDDL(SingularInstance singularInstance, final String str, String str2) {
            final SingularConfig.DDLHandler dDLHandler = singularInstance.getSingularConfig().ddlHandler;
            if (dDLHandler == null) {
                ApiStartSession.logger.error("DDLHandler is not configured, ignoring callback for url = %s", str);
                return;
            }
            if (Utils.lagSince(ApiStartSession.this.getTimestamp()) > dDLHandler.timeoutInSec) {
                ApiStartSession.logger.error("DDLHandler timedout. timeout = %dms", Long.valueOf(dDLHandler.timeoutInSec));
            } else {
                if (Utils.handleDeepLink(new SingularLinkParams(str, str2, true, Uri.parse(str))) || dDLHandler.handler == null) {
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.singular.sdk.internal.ApiStartSession.OnSessionStartCallback.2
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public void run() {
                        dDLHandler.handler.handleLink(str);
                    }
                });
            }
        }
    }

    static class Params extends SingularParamsBase {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Params build(long j, SingularInstance singularInstance) {
            return new Params().withId(j).withSingularConfig(singularInstance.getSingularConfig()).withDeviceInfo(singularInstance.getDeviceInfo()).withConnectionType(Utils.getConnectionType(singularInstance.getContext())).withAppInstallInfo(singularInstance).withInstallReferrer(singularInstance).withDTInstallReferrer(singularInstance).withUtils();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withInstallReferrer(SingularInstance singularInstance) {
            if (singularInstance.getIsFirstInstall()) {
                if (singularInstance.getGoogleInstallReferrer() != null) {
                    put("install_ref", new JSONObject(singularInstance.getGoogleInstallReferrer()).toString());
                }
                put("install_ref_timeinterval", String.valueOf(singularInstance.getInstallReferrerTimeInterval()));
                HashMap hashMap = new HashMap();
                if (singularInstance.getSamsungInstallReferrer() != null) {
                    hashMap.putAll(singularInstance.getSamsungInstallReferrer());
                }
                if (singularInstance.getMetaInstallReferrer() != null) {
                    hashMap.putAll(singularInstance.getMetaInstallReferrer());
                }
                put(Constants.RequestBody.INSTALL_REFERRER_KEY, new JSONObject(hashMap).toString());
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withDTInstallReferrer(SingularInstance singularInstance) {
            if (singularInstance.getIsFirstInstall() & (singularInstance.getDTInstallReferrer() != null)) {
                put(Constants.DT_INSTALL_REFERRER_KEY, singularInstance.getDTInstallReferrer());
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withUtils() {
            put("asid_timeinterval", String.valueOf(Utils.getASIDTimeInterval()));
            put("asid_scope", String.valueOf(Utils.getASIDScope()));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withId(long j) {
            put("s", String.valueOf(j));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withConnectionType(String str) {
            put("c", str);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withSingularConfig(SingularConfig singularConfig) {
            put("a", singularConfig.apiKey);
            Uri uri = singularConfig.openUri;
            if (UriUtils.isValid(uri)) {
                put("ref", uri.getQueryParameter("referrer"));
                put(com.kakao.sdk.user.Constants.EXTRA, uri.getQuery());
            }
            if (singularConfig.ddlHandler != null || singularConfig.linkCallback != null) {
                put("ddl_enabled", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                put("ddl_to", String.valueOf(singularConfig.ddlHandler.timeoutInSec));
            } else {
                put("ddl_enabled", "false");
            }
            Uri uri2 = singularConfig.singularLink;
            if (UriUtils.isValid(uri2)) {
                String queryParameter = uri2.getQueryParameter("referrer");
                String query = uri2.getQuery();
                if (!Utils.isEmptyOrNull(queryParameter)) {
                    put("ref", queryParameter);
                }
                if (!Utils.isEmptyOrNull(query)) {
                    put(com.kakao.sdk.user.Constants.EXTRA, query);
                }
                if (Utils.isESPLink(uri2)) {
                    put("esp_link", uri2.toString());
                    uri2 = Utils.resolveESPLink(uri2);
                }
                if (Utils.validateSingularLink(uri2)) {
                    boolean isShortLink = Utils.isShortLink(uri2);
                    if (!isShortLink) {
                        Utils.handleSingularLink(uri2);
                    }
                    put(Constants.SINGULAR_LINK, uri2.toString());
                    put(Constants.SINGULAR_LINK_RESOLVE_TIMEOUT, String.valueOf(singularConfig.shortlinkTimeoutSec));
                    put(Constants.SINGULAR_LINK_RESOLVE_REQUIRED, String.valueOf(isShortLink));
                }
                singularConfig.singularLink = null;
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        
            if (r4.isLimitedTrackingEnabled != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x004e, code lost:
        
            if (r4.isLimitedTrackingEnabled != false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0051, code lost:
        
            r1 = com.facebook.appevents.AppEventsConstants.EVENT_PARAM_VALUE_NO;
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.singular.sdk.internal.SingularParamsBase
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.singular.sdk.internal.ApiStartSession.Params withDeviceInfo(com.singular.sdk.internal.DeviceInfo r4) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.singular.sdk.internal.ApiStartSession.Params.withDeviceInfo(com.singular.sdk.internal.DeviceInfo):com.singular.sdk.internal.ApiStartSession$Params");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Params withAppInstallInfo(SingularInstance singularInstance) {
            if (singularInstance.getIsFirstInstall()) {
                put("is", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            } else {
                put("is", "false");
            }
            return this;
        }
    }
}
