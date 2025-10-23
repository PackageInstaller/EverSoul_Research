package com.kakaogame.server;

import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResult.kt */
@Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u000f2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000fB'\b\u0002\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/server/ServerResult;", "Lcom/kakaogame/server/KeyBaseResult;", "Lcom/kakaogame/util/json/JSONObject;", "result", "request", "Lcom/kakaogame/server/ServerRequest;", "response", "Lcom/kakaogame/server/ServerResponse;", "(Lcom/kakaogame/server/KeyBaseResult;Lcom/kakaogame/server/ServerRequest;Lcom/kakaogame/server/ServerResponse;)V", "getRequest", "()Lcom/kakaogame/server/ServerRequest;", "getResponse", "()Lcom/kakaogame/server/ServerResponse;", "toString", "", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ServerResult extends KeyBaseResult<JSONObject> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -5054750715583937284L;
    private final ServerRequest request;
    private final ServerResponse response;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ServerResult(KeyBaseResult keyBaseResult, ServerRequest serverRequest, ServerResponse serverResponse, DefaultConstructorMarker defaultConstructorMarker) {
        this(keyBaseResult, serverRequest, serverResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerResult getServerErrorResult(KeyBaseResult<?> keyBaseResult) {
        return INSTANCE.getServerErrorResult(keyBaseResult);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerResult getServerErrorResult(KeyBaseResult<?> keyBaseResult, ServerRequest serverRequest) {
        return INSTANCE.getServerErrorResult(keyBaseResult, serverRequest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerResult getServerResult(ServerRequest serverRequest, ServerResponse serverResponse) {
        return INSTANCE.getServerResult(serverRequest, serverResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerRequest getRequest() {
        return this.request;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ServerResult(KeyBaseResult<?> keyBaseResult, ServerRequest serverRequest, ServerResponse serverResponse) {
        super(keyBaseResult);
        this.request = serverRequest;
        this.response = serverResponse;
        if (keyBaseResult.isSuccess()) {
            return;
        }
        put("desc", serverRequest + " : " + serverResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.server.KeyBaseResult, java.util.AbstractMap
    public String toString() {
        if (isSuccess()) {
            StringBuilder sb = new StringBuilder(y.ۮڭڭܬި(862814835));
            ServerRequest serverRequest = this.request;
            Intrinsics.checkNotNull(serverRequest);
            return sb.append(serverRequest.getRequestUri()).append(']').toString();
        }
        return y.ٲٴݴ״ٰ(1782381376) + this.request + y.٬ݯح׭٩(576332070) + super.toString() + ']';
    }

    /* compiled from: ServerResult.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007J\u001e\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/server/ServerResult$Companion;", "", "()V", "serialVersionUID", "", "getServerErrorResult", "Lcom/kakaogame/server/ServerResult;", "result", "Lcom/kakaogame/server/KeyBaseResult;", "request", "Lcom/kakaogame/server/ServerRequest;", "getServerResult", "response", "Lcom/kakaogame/server/ServerResponse;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final ServerResult getServerResult(ServerRequest request, ServerResponse response) {
            Intrinsics.checkNotNullParameter(response, y.٬ݯح׭٩(575793966));
            return new ServerResult(response.getResult(), request, response, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final ServerResult getServerErrorResult(KeyBaseResult<?> result) {
            Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
            return new ServerResult(result, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final ServerResult getServerErrorResult(KeyBaseResult<?> result, ServerRequest request) {
            Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
            return new ServerResult(result, request, null, 0 == true ? 1 : 0);
        }
    }
}
