package com.kakaogame.web.protocol;

import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.Logger;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.util.json.parser.ParseException;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestUriHandler.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/web/protocol/RequestUriHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "()V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "makeResponseString", "status", "", "desc", "content", "Lcom/kakaogame/util/json/JSONObject;", "request", "uri", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class RequestUriHandler extends WebAppProtocolHandler {
    private static final String TAG = "RequestUriHandler";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestUriHandler() {
        super(y.دײܮڳܯ(2051368157));
        setWebAppProtocolHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
    protected String handleInternal(WebView webView, Uri webUri) {
        String queryParameter = webUri != null ? webUri.getQueryParameter("uri") : null;
        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782529736), y.ٴسسݬߨ(1393173034) + queryParameter);
        String str = y.٬ݯح׭٩(576411270);
        if (webUri == null) {
            return makeResponseString(4001, str, new JSONObject());
        }
        if (queryParameter == null) {
            return makeResponseString(4001, str, new JSONObject());
        }
        return request(webUri, queryParameter);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String request(Uri webUri, String uri) {
        String str = y.ٲٴݴ״ٰ(1782529736);
        try {
            ServerRequest serverRequest = new ServerRequest(uri);
            String queryParameter = webUri.getQueryParameter("parameters");
            if (queryParameter != null) {
                if (queryParameter.length() > 0) {
                    Object parse = JSONValue.parse(queryParameter);
                    Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                    JSONObject jSONObject = (JSONObject) parse;
                    for (String str2 : jSONObject.keySet()) {
                        Intrinsics.checkNotNull(str2);
                        serverRequest.putBody(str2, jSONObject.get((Object) str2));
                    }
                }
            }
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            ServerResponse response = requestServer$default.getResponse();
            if ((response != null ? response.getResult() : null) != null) {
                ServerResponse response2 = requestServer$default.getResponse();
                if ((response2 != null ? response2.getBody() : null) != null) {
                    ServerResponse response3 = requestServer$default.getResponse();
                    Intrinsics.checkNotNull(response3);
                    String valueOf = String.valueOf(response3.getBody());
                    if (!ServerService.isUseSession()) {
                        ServerResponse response4 = requestServer$default.getResponse();
                        Intrinsics.checkNotNull(response4);
                        int code = response4.getResult().getCode();
                        ServerResponse response5 = requestServer$default.getResponse();
                        Intrinsics.checkNotNull(response5);
                        String description = response5.getResult().getDescription();
                        ServerResponse response6 = requestServer$default.getResponse();
                        Intrinsics.checkNotNull(response6);
                        valueOf = makeResponseString(code, description, response6.getBody());
                    }
                    Logger.INSTANCE.m699d(str, "ResponseUri: " + valueOf);
                    return valueOf;
                }
            }
            return makeResponseString(2003, "Invalid Response", new JSONObject());
        } catch (ParseException e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return makeResponseString(4001, y.ݮڮֲڭܩ(-628220116), new JSONObject());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String makeResponseString(int status, String desc, JSONObject content) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put(y.ݮڮֲڭܩ(-628237012), Integer.valueOf(status));
        jSONObject2.put("desc", desc);
        jSONObject2.put("content", content);
        return jSONObject.toJSONString();
    }
}
