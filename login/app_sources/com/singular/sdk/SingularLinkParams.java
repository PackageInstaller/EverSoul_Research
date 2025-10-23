package com.singular.sdk;

import android.net.Uri;
import com.singular.sdk.internal.utils.UriUtils;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public class SingularLinkParams {
    private String deeplink;
    private boolean isDeferred;
    private String passthrough;
    private Uri url;
    private HashMap<String, String> urlParameters;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularLinkParams(String str, String str2, boolean z, Uri uri) {
        this.deeplink = str;
        this.passthrough = str2;
        this.isDeferred = z;
        this.url = uri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDeeplink() {
        return this.deeplink;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPassthrough() {
        return this.passthrough;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isDeferred() {
        return this.isDeferred;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashMap<String, String> getUrlParameters() {
        if (this.urlParameters == null && UriUtils.isValid(this.url)) {
            Set<String> queryParameterNames = this.url.getQueryParameterNames();
            this.urlParameters = new HashMap<>(queryParameterNames.size());
            for (String str : queryParameterNames) {
                this.urlParameters.put(str, this.url.getQueryParameter(str));
            }
        }
        HashMap<String, String> hashMap = this.urlParameters;
        return hashMap != null ? hashMap : new HashMap<>();
    }
}
