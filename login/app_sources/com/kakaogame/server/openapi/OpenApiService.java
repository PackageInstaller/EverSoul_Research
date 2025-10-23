package com.kakaogame.server.openapi;

import android.content.Context;
import android.util.Log;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.auth.LoginData;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.APILatencyLogManager;
import com.kakaogame.log.APILogManager;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.util.HmacSHA256Util;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.StringUtil;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OpenApiService.kt */
@Metadata(m838d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015JT\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 JP\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001f\u001a\u00020 Jh\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 JJ\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001bH\u0007JR\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00072\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001b2\b\b\u0002\u0010\u001f\u001a\u00020 J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0007J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0007J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0002J\f\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\u0004J\u0012\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010(\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, m839d2 = {"Lcom/kakaogame/server/openapi/OpenApiService;", "", "()V", "NOT_USED", "", "TAG", "defaultHeader", "", "openApiUri", "getOpenApiUri", "()Ljava/lang/String;", "setOpenApiUri", "(Ljava/lang/String;)V", "uriMap", "checkZat", "context", "Landroid/content/Context;", ServerConstants.ZAT, "initialize", "", "config", "Lcom/kakaogame/config/Configuration;", "requestOpenApi", "Lcom/kakaogame/KGResult;", "url", FirebaseAnalytics.Param.METHOD, KeyBaseResult.KEY_HEADER, "", "stringBody", "contentType", "Lcom/kakaogame/server/http/HttpService$HttpContentType;", "traceJobId", "", SDKConstants.PARAM_A2U_BODY, "requestServerApi", "Lcom/kakaogame/server/ServerResult;", "request", "Lcom/kakaogame/server/ServerRequest;", "requestServerApiWithoutResponse", "requestServerApiWithoutResponseInternal", "uri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class OpenApiService {
    public static final String NOT_USED = "NOTUSED";
    private static final String TAG = "OpenApiService";
    public static String openApiUri;
    public static final OpenApiService INSTANCE = new OpenApiService();
    private static final Map<String, String> defaultHeader = new LinkedHashMap();
    private static final Map<String, String> uriMap = new LinkedHashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private OpenApiService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getOpenApiUri() {
        String str = openApiUri;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException(y.ۮڭڭܬި(862825619));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setOpenApiUri(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        openApiUri = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize(Configuration config) {
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        String openApiUrl = config.getServerInfo().getOpenApiUrl();
        Intrinsics.checkNotNull(openApiUrl);
        setOpenApiUri(openApiUrl);
        Map<String, String> map = defaultHeader;
        map.put(y.ۮڭڭܬި(862411867), config.getAppId());
        map.put(y.ۮڭڭܬި(862506555), config.getAppSecret());
        map.put("Content-Type", y.ٲٴݴ״ٰ(1782372624));
        map.put(ServerConstants.REQUESTED_BY, y.ٴسسݬߨ(1392813258));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String setOpenApiUri(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(575694806));
        Intrinsics.checkNotNullParameter(str2, y.ۮڭڭܬި(862392755));
        uriMap.put(str, str2);
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getOpenApiUri(String str) {
        Intrinsics.checkNotNullParameter(str, y.٬ݯح׭٩(575694806));
        return uriMap.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestServerApiWithoutResponse(ServerRequest request) {
        Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
        INSTANCE.requestServerApiWithoutResponseInternal(request);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:3:0x0027, B:5:0x0036, B:10:0x0042, B:13:0x0055, B:15:0x005d, B:17:0x0065, B:18:0x0080, B:20:0x0086, B:23:0x0098, B:28:0x00a0, B:32:0x00b8, B:33:0x00bd, B:37:0x00d3, B:38:0x00d8), top: B:2:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[Catch: Exception -> 0x0109, TryCatch #0 {Exception -> 0x0109, blocks: (B:3:0x0027, B:5:0x0036, B:10:0x0042, B:13:0x0055, B:15:0x005d, B:17:0x0065, B:18:0x0080, B:20:0x0086, B:23:0x0098, B:28:0x00a0, B:32:0x00b8, B:33:0x00bd, B:37:0x00d3, B:38:0x00d8), top: B:2:0x0027 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void requestServerApiWithoutResponseInternal(com.kakaogame.server.ServerRequest r13) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.openapi.OpenApiService.requestServerApiWithoutResponseInternal(com.kakaogame.server.ServerRequest):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String checkZat(Context context, String zat) {
        LoginData loginData = AuthDataManager.getLoginData();
        Intrinsics.checkNotNull(loginData);
        LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
        String str = y.ۮڭڭܬި(862822683);
        if (accessToken == null) {
            Logger.INSTANCE.m701e(str, "Zat is null!!!");
            return "";
        }
        if (!accessToken.isExpired()) {
            return zat;
        }
        Logger.INSTANCE.m699d(str, y.ݮڮֲڭܩ(-628228868));
        if (accessToken.isZrtExpired()) {
            Logger.INSTANCE.m701e(str, "Zrt is Expired!!!");
            return "";
        }
        KGResult<Void> requestIssueZAT = AuthDataManager.requestIssueZAT(context, y.دײܮڳܯ(2051066805) + SDKVersion.isPublishing);
        Logger.INSTANCE.m699d(str, y.ݮڮֲڭܩ(-628587364) + requestIssueZAT);
        return !requestIssueZAT.isSuccess() ? "" : CoreManager.INSTANCE.getInstance().getAccessToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ ServerResult requestServerApi$default(ServerRequest serverRequest, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        return requestServerApi(serverRequest, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0059 A[Catch: Exception -> 0x0214, TryCatch #1 {Exception -> 0x0214, blocks: (B:3:0x0032, B:5:0x004d, B:10:0x0059, B:13:0x0087, B:17:0x00a7, B:18:0x00ac, B:23:0x00c5, B:25:0x00d3, B:27:0x00e0, B:29:0x00ed, B:31:0x00fa, B:35:0x010c, B:38:0x011d, B:41:0x012b, B:42:0x0151, B:44:0x0159, B:45:0x0167, B:46:0x0173, B:48:0x0179, B:51:0x018b, B:56:0x0193, B:58:0x01a2, B:59:0x01c4, B:61:0x01ca, B:63:0x01d5, B:68:0x01ec, B:74:0x0201, B:76:0x01b2), top: B:2:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0087 A[Catch: Exception -> 0x0214, TryCatch #1 {Exception -> 0x0214, blocks: (B:3:0x0032, B:5:0x004d, B:10:0x0059, B:13:0x0087, B:17:0x00a7, B:18:0x00ac, B:23:0x00c5, B:25:0x00d3, B:27:0x00e0, B:29:0x00ed, B:31:0x00fa, B:35:0x010c, B:38:0x011d, B:41:0x012b, B:42:0x0151, B:44:0x0159, B:45:0x0167, B:46:0x0173, B:48:0x0179, B:51:0x018b, B:56:0x0193, B:58:0x01a2, B:59:0x01c4, B:61:0x01ca, B:63:0x01d5, B:68:0x01ec, B:74:0x0201, B:76:0x01b2), top: B:2:0x0032 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.server.ServerResult requestServerApi(com.kakaogame.server.ServerRequest r15, int r16) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.openapi.OpenApiService.requestServerApi(com.kakaogame.server.ServerRequest, int):com.kakaogame.server.ServerResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> requestOpenApi(String url, Map<String, String> header, Map<String, ? extends Object> body) {
        return INSTANCE.requestOpenApi(url, y.ٴسسݬߨ(1392856570), header, body, HttpService.HttpContentType.STRING, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult requestOpenApi$default(OpenApiService openApiService, String str, Map map, Map map2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = -1;
        }
        return openApiService.requestOpenApi(str, map, map2, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> requestOpenApi(String url, Map<String, String> header, Map<String, ? extends Object> body, int traceJobId) {
        return requestOpenApi(url, y.ٴسسݬߨ(1392856570), header, body, HttpService.HttpContentType.STRING, traceJobId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult requestOpenApi$default(OpenApiService openApiService, String str, String str2, Map map, String str3, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "POST";
        }
        String str4 = str2;
        Map map2 = (i2 & 4) != 0 ? null : map;
        String str5 = (i2 & 8) != 0 ? null : str3;
        if ((i2 & 16) != 0) {
            i = -1;
        }
        return openApiService.requestOpenApi(str, str4, map2, str5, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> requestOpenApi(String url, String method, Map<String, String> header, String stringBody, int traceJobId) {
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        Intrinsics.checkNotNullParameter(method, y.ٲٴݴ״ٰ(1781805184));
        String str = url;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) y.٬ݯح׭٩(576050958), false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) y.٬ݯح׭٩(576051006), false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(url, y.֬ڱܱײٮ(-1159095751), false, 2, (Object) null)) {
                url = getOpenApiUri() + url;
            } else {
                url = getOpenApiUri() + y.֬ڱܱײٮ(-1159095623) + url;
            }
        }
        return requestOpenApi(url, method, header, stringBody, HttpService.HttpContentType.STRING, traceJobId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult requestOpenApi$default(OpenApiService openApiService, String str, String str2, Map map, String str3, HttpService.HttpContentType httpContentType, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "POST";
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            map = null;
        }
        return openApiService.requestOpenApi(str, str4, (Map<String, String>) map, str3, httpContentType, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> requestOpenApi(String url, String method, Map<String, String> header, String stringBody, HttpService.HttpContentType contentType, int traceJobId) {
        KeyBaseResult<Object> request;
        List<String> list;
        String str = y.ٴسسݬߨ(1393492338);
        String str2 = y.ۮڭڭܬި(862822683);
        String str3 = y.دײܮڳܯ(2051065261);
        String str4 = y.ٲٴݴ״ٰ(1782374240);
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        Intrinsics.checkNotNullParameter(method, y.ٲٴݴ״ٰ(1781805184));
        Intrinsics.checkNotNullParameter(contentType, y.ݮڮֲڭܩ(-628242540));
        try {
            int startFirebaseTrace = CoreManager.INSTANCE.getInstance().startFirebaseTrace(url);
            long requestUri = Tracer.INSTANCE.requestUri(traceJobId, url);
            Stopwatch start = Stopwatch.INSTANCE.start(url);
            if (StringsKt.equals(method, "GET", true)) {
                request = HttpService.INSTANCE.requestGET(CoreManager.INSTANCE.getInstance().getContext(), url, header, contentType);
            } else {
                request = HttpService.request(url, method, header, stringBody, contentType);
            }
            start.stop();
            APILatencyLogManager.INSTANCE.writeApiCall(start.getName(), request, start.getDurationMs());
            APILogManager.INSTANCE.writeServerApiCall(start.getName(), request, start.getDurationMs());
            Logger.INSTANCE.m699d(str2, str4 + request);
            if (startFirebaseTrace > 0) {
                CoreManager.INSTANCE.getInstance().stopFirebaseTrace(startFirebaseTrace, request);
            }
            Map<String, List<String>> headers = request.getHeaders();
            Tracer.INSTANCE.response(requestUri, headers);
            if (headers != null && headers.containsKey(str) && (list = headers.get(str)) != null && (!list.isEmpty())) {
                long parseLong = Long.parseLong(list.get(0));
                if (parseLong > 0) {
                    CoreManager.INSTANCE.getInstance().setServerTimeStamp(parseLong);
                }
            }
            if (request.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(request);
            }
            String str5 = (String) request.getContent();
            Logger.INSTANCE.m706v(str2, str3 + str5);
            return KGResult.INSTANCE.getSuccessResult(str5);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult requestOpenApi$default(OpenApiService openApiService, String str, String str2, Map map, Map map2, HttpService.HttpContentType httpContentType, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "POST";
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            map = null;
        }
        Map map3 = map;
        if ((i2 & 16) != 0) {
            httpContentType = HttpService.HttpContentType.STRING;
        }
        HttpService.HttpContentType httpContentType2 = httpContentType;
        if ((i2 & 32) != 0) {
            i = -1;
        }
        return openApiService.requestOpenApi(str, str3, (Map<String, String>) map3, (Map<String, ? extends Object>) map2, httpContentType2, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> requestOpenApi(String url, String method, Map<String, String> header, Map<String, ? extends Object> body, HttpService.HttpContentType contentType, int traceJobId) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(method, y.ٲٴݴ״ٰ(1781805184));
        Intrinsics.checkNotNullParameter(contentType, y.ݮڮֲڭܩ(-628242540));
        StringBuilder append = new StringBuilder(y.دײܮڳܯ(2051064469)).append(url);
        String str3 = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str3).append(header).append(str3).append(body).toString();
        String str4 = y.ۮڭڭܬި(862822683);
        Log.v(str4, sb);
        try {
            if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
                Intrinsics.checkNotNull(url);
                if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "/auth/", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) url, (CharSequence) "\\/auth\\/", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) url, (CharSequence) "/zat/", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) url, (CharSequence) "\\/zat\\/", false, 2, (Object) null)) {
                    if (checkZat(CoreManager.INSTANCE.getInstance().getContext(), CoreManager.INSTANCE.getInstance().getAccessToken()) == null) {
                        return KGResult.INSTANCE.getResult(401, "Zat is Expired, and Failed to Issue Token.");
                    }
                }
            }
            if (header == null) {
                header = new LinkedHashMap();
            }
            Map<String, String> map = header;
            map.putAll(defaultHeader);
            if (body != null) {
                String jSONString = JSONValue.toJSONString(body);
                Intrinsics.checkNotNull(url);
                if (StringsKt.contains$default((CharSequence) url, (CharSequence) "v4/auth/loginDevice", false, 2, (Object) null)) {
                    map.put(ServerConstants.DLS, HmacSHA256Util.getDLS(jSONString));
                }
                str = jSONString;
            } else {
                str = null;
            }
            Intrinsics.checkNotNull(url);
            if (StringsKt.startsWith$default(url, ":10443/service", false, 2, (Object) null)) {
                str2 = getOpenApiUri() + url;
            } else {
                str2 = getOpenApiUri() + "/service/" + url;
            }
            if (StringsKt.equals(method, "GET", true)) {
                str2 = StringUtil.makeRequestUrl(str2, body);
            }
            return requestOpenApi(str2, method, map, str, contentType, traceJobId);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }
}
