package com.kakaogame.web.protocol;

import android.net.Uri;
import com.kakaogame.Logger;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CachedRequestUriHandler.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.web.protocol.CachedRequestUriHandler$reqeustServer$2$1", m855f = "CachedRequestUriHandler.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class CachedRequestUriHandler$reqeustServer$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Continuation<String> $cont;
    final /* synthetic */ String $uri;
    final /* synthetic */ Uri $webUri;
    int label;
    final /* synthetic */ CachedRequestUriHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CachedRequestUriHandler$reqeustServer$2$1(String str, Uri uri, CachedRequestUriHandler cachedRequestUriHandler, Continuation<? super String> continuation, Continuation<? super CachedRequestUriHandler$reqeustServer$2$1> continuation2) {
        super(2, continuation2);
        this.$uri = str;
        this.$webUri = uri;
        this.this$0 = cachedRequestUriHandler;
        this.$cont = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CachedRequestUriHandler$reqeustServer$2$1(this.$uri, this.$webUri, this.this$0, this.$cont, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CachedRequestUriHandler$reqeustServer$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String makeResponseString;
        Map map;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        ServerRequest serverRequest = new ServerRequest(this.$uri);
        String queryParameter = this.$webUri.getQueryParameter(y.ٴسسݬߨ(1392586602));
        if (queryParameter != null) {
            if (queryParameter.length() > 0) {
                Object parse = JSONValue.parse(queryParameter);
                Intrinsics.checkNotNull(parse, y.ݮڮֲڭܩ(-628332684));
                JSONObject jSONObject = (JSONObject) parse;
                for (String str : jSONObject.keySet()) {
                    Intrinsics.checkNotNull(str);
                    serverRequest.putBody(str, jSONObject.get((Object) str));
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
                makeResponseString = String.valueOf(response3.getBody());
                if (!ServerService.isUseSession()) {
                    CachedRequestUriHandler cachedRequestUriHandler = this.this$0;
                    ServerResponse response4 = requestServer$default.getResponse();
                    Intrinsics.checkNotNull(response4);
                    int code = response4.getResult().getCode();
                    ServerResponse response5 = requestServer$default.getResponse();
                    Intrinsics.checkNotNull(response5);
                    String description = response5.getResult().getDescription();
                    ServerResponse response6 = requestServer$default.getResponse();
                    Intrinsics.checkNotNull(response6);
                    makeResponseString = cachedRequestUriHandler.makeResponseString(code, description, response6.getBody());
                }
                Logger logger = Logger.INSTANCE;
                String str2 = y.ٲٴݴ״ٰ(1782527912) + makeResponseString;
                String str3 = y.دײܮڳܯ(2051222341);
                logger.m699d(str3, str2);
                JSONArray jSONArray = new JSONArray();
                jSONArray.add(Boxing.boxLong(System.currentTimeMillis()));
                jSONArray.add(makeResponseString);
                Logger.INSTANCE.m699d(str3, y.ݬֲ֮ܲت(1512243815) + jSONArray.toJSONString());
                map = CachedRequestUriHandler.requestedUriCache;
                map.put(this.$webUri, jSONArray.toJSONString());
                Continuation<String> continuation = this.$cont;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m1440constructorimpl(makeResponseString));
                return Unit.INSTANCE;
            }
        }
        makeResponseString = this.this$0.makeResponseString(2003, y.ٲٴݴ״ٰ(1782527304), new JSONObject());
        Continuation<String> continuation2 = this.$cont;
        Result.Companion companion2 = Result.INSTANCE;
        continuation2.resumeWith(Result.m1440constructorimpl(makeResponseString));
        return Unit.INSTANCE;
    }
}
