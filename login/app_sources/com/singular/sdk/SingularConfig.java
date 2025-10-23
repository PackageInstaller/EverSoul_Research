package com.singular.sdk;

import android.content.Intent;
import android.net.Uri;
import com.singular.sdk.internal.SingularGlobalProperty;
import com.singular.sdk.internal.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class SingularConfig {
    public final String apiKey;
    public String customSdid;
    public String customUserId;
    public DDLHandler ddlHandler;
    public SingularDeviceAttributionHandler deviceAttributionHandler;
    public String facebookAppId;
    public String fcmDeviceToken;
    public String imei;
    public SingularLinkHandler linkCallback;
    public Uri openUri;
    public SDIDAccessorHandler sdidAccessorHandler;
    public final String secret;
    public long shortlinkTimeoutSec;
    public Uri singularLink;
    public boolean collectOAID = false;
    public Map<String, SingularGlobalProperty> globalProperties = new HashMap();
    public long sessionTimeoutSec = 60;
    public boolean enableLogging = false;
    public int logLevel = 6;
    public boolean isOpenedWithDeepLink = false;

    @Deprecated
    public List<String> approvedDomains = new ArrayList();
    public List<String> espDomains = new ArrayList();
    public Boolean limitDataSharing = null;
    public Boolean limitedIdentifiresEnabled = false;

    public static class DDLHandler {
        public DeferredDeepLinkHandler handler;
        public long timeoutInSec = 60;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig(String str, String str2) {
        if (Utils.isEmptyOrNull(str)) {
            throw new IllegalArgumentException("apiKey can not be null or empty");
        }
        if (Utils.isEmptyOrNull(str2)) {
            throw new IllegalArgumentException("secret can not be null or empty");
        }
        this.apiKey = str;
        this.secret = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withOpenURI(Uri uri) {
        this.openUri = uri;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withFacebookAppId(String str) {
        this.facebookAppId = str;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withDDLHandler(DeferredDeepLinkHandler deferredDeepLinkHandler) {
        if (this.ddlHandler == null) {
            this.ddlHandler = new DDLHandler();
        }
        this.ddlHandler.handler = deferredDeepLinkHandler;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withDDLTimeoutInSec(long j) {
        if (this.ddlHandler == null) {
            this.ddlHandler = new DDLHandler();
        }
        this.ddlHandler.timeoutInSec = j;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withSessionTimeoutInSec(long j) {
        this.sessionTimeoutSec = j;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withLoggingEnabled() {
        this.enableLogging = true;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withLogLevel(int i) {
        this.logLevel = i;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withSingularLink(Intent intent, SingularLinkHandler singularLinkHandler, long j) {
        return withSingularLink(intent, singularLinkHandler, j, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public SingularConfig withSingularLink(Intent intent, SingularLinkHandler singularLinkHandler, long j, List<String> list) {
        if (this.ddlHandler == null) {
            this.ddlHandler = new DDLHandler();
        }
        this.linkCallback = singularLinkHandler;
        this.shortlinkTimeoutSec = j;
        if (intent != null) {
            Uri data = intent.getData();
            this.singularLink = data;
            if (data != null && "android.intent.action.VIEW".equals(intent.getAction())) {
                this.isOpenedWithDeepLink = true;
            }
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withSingularLink(Intent intent, SingularLinkHandler singularLinkHandler) {
        return withSingularLink(intent, singularLinkHandler, 10L, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public SingularConfig withSingularLink(Intent intent, SingularLinkHandler singularLinkHandler, List<String> list) {
        return withSingularLink(intent, singularLinkHandler, 10L, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withSingularDeviceAttribution(SingularDeviceAttributionHandler singularDeviceAttributionHandler) {
        this.deviceAttributionHandler = singularDeviceAttributionHandler;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withCustomSdid(String str, SDIDAccessorHandler sDIDAccessorHandler) {
        this.customSdid = str;
        this.sdidAccessorHandler = sDIDAccessorHandler;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withCustomUserId(String str) {
        this.customUserId = str;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withIMEI(String str) {
        this.imei = str;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withGlobalProperty(String str, String str2, boolean z) {
        if (this.globalProperties.size() >= 5) {
            return this;
        }
        SingularGlobalProperty singularGlobalProperty = new SingularGlobalProperty(str, str2, z);
        this.globalProperties.put(singularGlobalProperty.getKey(), singularGlobalProperty);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withOAIDCollection() {
        this.collectOAID = true;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withFCMDeviceToken(String str) {
        if (Utils.isEmptyOrNull(str)) {
            return this;
        }
        this.fcmDeviceToken = str;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withLimitDataSharing(boolean z) {
        this.limitDataSharing = Boolean.valueOf(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withESPDomains(List<String> list) {
        this.espDomains = list;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularConfig withLimitedIdentifiersEnabled() {
        this.limitedIdentifiresEnabled = true;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("apiKey='");
        sb.append(this.apiKey).append("', secret='");
        sb.append(this.secret).append('\'');
        if (this.openUri != null) {
            sb.append(", openUri=").append(this.openUri);
        }
        if (this.ddlHandler != null) {
            sb.append(", ddlHandler=").append(this.ddlHandler.getClass().getName());
            sb.append(", timeoutInSec=").append(this.ddlHandler.timeoutInSec);
        }
        sb.append(", logging='").append(this.enableLogging).append("', logLevel='");
        sb.append(this.logLevel).append('\'');
        return sb.toString();
    }
}
