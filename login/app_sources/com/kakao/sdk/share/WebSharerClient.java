package com.kakao.sdk.share;

import android.net.Uri;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.JsonObject;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.template.model.DefaultTemplate;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebSharerClient.kt */
@Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0002J@\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007J(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007JQ\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m839d2 = {"Lcom/kakao/sdk/share/WebSharerClient;", "", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "applicationInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "(Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApplicationInfo;)V", "baseUriBuilder", "Landroid/net/Uri$Builder;", "serverCallbackArgs", "", "", "makeCustomUrl", "Landroid/net/Uri;", "templateId", "", "templateArgs", "makeDefaultUrl", SDKConstants.PARAM_UPDATE_TEMPLATE, "Lcom/kakao/sdk/template/model/DefaultTemplate;", "makeScrapUrl", "requestUrl", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)Landroid/net/Uri;", "Companion", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class WebSharerClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<WebSharerClient> instance$delegate = LazyKt.lazy(new Function0<WebSharerClient>() { // from class: com.kakao.sdk.share.WebSharerClient$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final WebSharerClient invoke() {
            return new WebSharerClient(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    });
    private final ApplicationInfo applicationInfo;
    private final ContextInfo contextInfo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebSharerClient() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final WebSharerClient getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeCustomUrl(long j) {
        return makeCustomUrl$default(this, j, null, null, 6, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeCustomUrl(long j, Map<String, String> map) {
        return makeCustomUrl$default(this, j, map, null, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeDefaultUrl(DefaultTemplate template) {
        Intrinsics.checkNotNullParameter(template, "template");
        return makeDefaultUrl$default(this, template, null, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeScrapUrl(String requestUrl) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        return makeScrapUrl$default(this, requestUrl, null, null, null, 14, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeScrapUrl(String requestUrl, Long l) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        return makeScrapUrl$default(this, requestUrl, l, null, null, 12, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeScrapUrl(String requestUrl, Long l, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        return makeScrapUrl$default(this, requestUrl, l, map, null, 8, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebSharerClient(ContextInfo contextInfo, ApplicationInfo applicationInfo) {
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        this.contextInfo = contextInfo;
        this.applicationInfo = applicationInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ WebSharerClient(ApplicationContextInfo applicationContextInfo, ApplicationContextInfo applicationContextInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo, (i & 2) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Uri makeCustomUrl$default(WebSharerClient webSharerClient, long j, Map map, Map map2, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        if ((i & 4) != 0) {
            map2 = null;
        }
        return webSharerClient.makeCustomUrl(j, map, map2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeCustomUrl(long templateId, Map<String, String> templateArgs, Map<String, String> serverCallbackArgs) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("template_id", Long.valueOf(templateId));
        if (templateArgs != null) {
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry<String, String> entry : templateArgs.entrySet()) {
                jsonObject2.addProperty(entry.getKey(), entry.getValue());
            }
            Unit unit = Unit.INSTANCE;
            jsonObject.add("template_args", jsonObject2);
        }
        jsonObject.addProperty(Constants.LINK_VER, Constants.LINKVER_40);
        Uri build = baseUriBuilder(serverCallbackArgs).appendQueryParameter(Constants.VALIDATION_ACTION, Constants.VALIDATION_CUSTOM).appendQueryParameter(Constants.VALIDATION_PARAMS, jsonObject.toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Uri makeScrapUrl$default(WebSharerClient webSharerClient, String str, Long l, Map map, Map map2, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        if ((i & 8) != 0) {
            map2 = null;
        }
        return webSharerClient.makeScrapUrl(str, l, map, map2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeScrapUrl(String requestUrl, Long templateId, Map<String, String> templateArgs, Map<String, String> serverCallbackArgs) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("request_url", requestUrl);
        if (templateId != null) {
            jsonObject.addProperty("template_id", Long.valueOf(templateId.longValue()));
        }
        if (templateArgs != null) {
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry<String, String> entry : templateArgs.entrySet()) {
                jsonObject2.addProperty(entry.getKey(), entry.getValue());
            }
            Unit unit = Unit.INSTANCE;
            jsonObject.add("template_args", jsonObject2);
        }
        jsonObject.addProperty(Constants.LINK_VER, Constants.LINKVER_40);
        Uri build = baseUriBuilder(serverCallbackArgs).appendQueryParameter(Constants.VALIDATION_ACTION, Constants.VALIDATION_SCRAP).appendQueryParameter(Constants.VALIDATION_PARAMS, jsonObject.toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Uri makeDefaultUrl$default(WebSharerClient webSharerClient, DefaultTemplate defaultTemplate, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        return webSharerClient.makeDefaultUrl(defaultTemplate, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri makeDefaultUrl(DefaultTemplate template, Map<String, String> serverCallbackArgs) {
        Intrinsics.checkNotNullParameter(template, "template");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("template_object", KakaoJson.INSTANCE.getBase().toJsonTree(template));
        jsonObject.addProperty(Constants.LINK_VER, Constants.LINKVER_40);
        Uri build = baseUriBuilder(serverCallbackArgs).appendQueryParameter(Constants.VALIDATION_ACTION, Constants.VALIDATION_DEFAULT).appendQueryParameter(Constants.VALIDATION_PARAMS, jsonObject.toString()).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Uri.Builder baseUriBuilder(Map<String, String> serverCallbackArgs) {
        Uri.Builder builder = new Uri.Builder().scheme("https").authority(KakaoSdk.INSTANCE.getHosts().getSharer()).path(Constants.SHARER_PATH).appendQueryParameter("app_key", this.applicationInfo.getAppKey()).appendQueryParameter("ka", this.contextInfo.getKaHeader());
        if (serverCallbackArgs != null) {
            builder.appendQueryParameter(Constants.LCBA, KakaoJson.INSTANCE.toJson(serverCallbackArgs));
        }
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        return builder;
    }

    /* compiled from: WebSharerClient.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/share/WebSharerClient$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/share/WebSharerClient;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/share/WebSharerClient;", "instance$delegate", "Lkotlin/Lazy;", "share_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final WebSharerClient getInstance() {
            return (WebSharerClient) WebSharerClient.instance$delegate.getValue();
        }
    }
}
