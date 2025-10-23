package com.kakaogame.web.protocol;

import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.Logger;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.util.json.parser.ParseException;
import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CachedRequestUriHandler.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\n\u0010\u0013\u001a\u00020\u0014*\u00020\b¨\u0006\u0016"}, m839d2 = {"Lcom/kakaogame/web/protocol/CachedRequestUriHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "()V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "makeResponseString", "status", "", "desc", "content", "Lcom/kakaogame/util/json/JSONObject;", "reqeustServer", "uri", "(Landroid/net/Uri;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "returnCachedResult", "isCached", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CachedRequestUriHandler extends WebAppProtocolHandler {
    private static final String TAG = "CachedRequestUriHandler";
    private static final Map<Uri, String> requestedUriCache = new HashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CachedRequestUriHandler() {
        super(y.ݮڮֲڭܩ(-628220228));
        setWebAppProtocolHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
    protected String handleInternal(WebView webView, Uri webUri) {
        Object runBlocking$default;
        String queryParameter = webUri != null ? webUri.getQueryParameter(y.ۮڭڭܬި(862392755)) : null;
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051222341), y.ݬֲ֮ܲت(1512247167) + queryParameter);
        String str = y.٬ݯح׭٩(576411270);
        if (webUri == null) {
            return makeResponseString(4001, str, new JSONObject());
        }
        if (queryParameter == null) {
            return makeResponseString(4001, str, new JSONObject());
        }
        if (!isCached(webUri)) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new CachedRequestUriHandler$handleInternal$1(this, webUri, queryParameter, null), 1, null);
            return (String) runBlocking$default;
        }
        String returnCachedResult = returnCachedResult(webUri);
        return returnCachedResult == null ? handleInternal(webView, webUri) : returnCachedResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String returnCachedResult(Uri webUri) {
        String str = y.دײܮڳܯ(2051221117);
        Map<Uri, String> map = requestedUriCache;
        String str2 = null;
        try {
            Object parse = JSONValue.parse(map.get(webUri));
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONArray");
            JSONArray jSONArray = (JSONArray) parse;
            Number number = (Number) jSONArray.get(0);
            Intrinsics.checkNotNull(number);
            if (System.currentTimeMillis() - number.longValue() < InfodeskHelper.INSTANCE.getCachedRequestTerm()) {
                String str3 = (String) jSONArray.get(1);
                Logger.INSTANCE.m699d(TAG, str + str3);
                str2 = str3;
            } else {
                map.remove(webUri);
            }
        } catch (ParseException unused) {
            requestedUriCache.remove(webUri);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object reqeustServer(Uri uri, String str, Continuation<? super String> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CachedRequestUriHandler$reqeustServer$2$1(str, uri, this, safeContinuation, null), 3, null);
        } catch (ParseException e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051222341), e.toString(), e);
            makeResponseString(4001, y.ݮڮֲڭܩ(-628220116), new JSONObject());
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String makeResponseString(int status, String desc, JSONObject content) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put(y.ݮڮֲڭܩ(-628237012), Integer.valueOf(status));
        jSONObject2.put("desc", desc);
        jSONObject2.put("content", content);
        return jSONObject.toJSONString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isCached(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, y.٬ݯح׭٩(575694806));
        return requestedUriCache.containsKey(uri);
    }
}
