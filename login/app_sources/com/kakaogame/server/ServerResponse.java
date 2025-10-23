package com.kakaogame.server;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.Logger;
import com.kakaogame.session.SessionUtil;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerResponse.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B;\b\u0002\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, m839d2 = {"Lcom/kakaogame/server/ServerResponse;", "", "result", "Lcom/kakaogame/server/KeyBaseResult;", "Lcom/kakaogame/util/json/JSONObject;", "requestUri", "", KeyBaseResult.KEY_HEADER, SDKConstants.PARAM_A2U_BODY, "(Lcom/kakaogame/server/KeyBaseResult;Ljava/lang/String;Lcom/kakaogame/util/json/JSONObject;Lcom/kakaogame/util/json/JSONObject;)V", "getBody", "()Lcom/kakaogame/util/json/JSONObject;", "getHeader", "getRequestUri", "()Ljava/lang/String;", "getResult", "()Lcom/kakaogame/server/KeyBaseResult;", "transactionNo", "", "getTransactionNo", "()I", "toString", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ServerResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ServerResponse";
    private final JSONObject body;
    private final JSONObject header;
    private final String requestUri;
    private final KeyBaseResult<JSONObject> result;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ServerResponse(KeyBaseResult keyBaseResult, String str, JSONObject jSONObject, JSONObject jSONObject2, DefaultConstructorMarker defaultConstructorMarker) {
        this(keyBaseResult, str, jSONObject, jSONObject2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerResponse getResponse(String str) {
        return INSTANCE.getResponse(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerResponse getResponse(String str, String str2) {
        return INSTANCE.getResponse(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KeyBaseResult<JSONObject> getResult(JSONObject jSONObject) {
        return INSTANCE.getResult(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ServerResponse(KeyBaseResult<JSONObject> keyBaseResult, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        this.result = keyBaseResult;
        this.requestUri = str;
        this.header = jSONObject;
        this.body = jSONObject2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ ServerResponse(KeyBaseResult keyBaseResult, String str, JSONObject jSONObject, JSONObject jSONObject2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(keyBaseResult, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : jSONObject, (i & 8) != 0 ? null : jSONObject2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KeyBaseResult<JSONObject> getResult() {
        return this.result;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRequestUri() {
        return this.requestUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject getHeader() {
        return this.header;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject getBody() {
        return this.body;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTransactionNo() {
        try {
            JSONObject jSONObject = this.header;
            if (jSONObject == null) {
                return -1;
            }
            Number number = (Number) jSONObject.get((Object) SessionUtil.TRANSACTION_NO);
            Intrinsics.checkNotNull(number);
            return number.intValue();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576335054), e.toString(), e);
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576335246) + this.requestUri + y.ۮڭڭܬި(862815123) + this.header + y.٬ݯح׭٩(576335566) + this.body + ']';
    }

    /* compiled from: ServerResponse.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/server/ServerResponse$Companion;", "", "()V", "TAG", "", "getResponse", "Lcom/kakaogame/server/ServerResponse;", "responseMessage", "requestUri", "responseBody", "getResult", "Lcom/kakaogame/server/KeyBaseResult;", "Lcom/kakaogame/util/json/JSONObject;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
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
        public final ServerResponse getResponse(String requestUri, String responseBody) {
            try {
                Object parse = JSONValue.parse(responseBody);
                Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                JSONObject jSONObject = (JSONObject) parse;
                return new ServerResponse(getResult(jSONObject), requestUri, null, jSONObject, null);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.٬ݯح׭٩(576335054), e.toString(), e);
                if (responseBody == null) {
                    responseBody = "";
                }
                return new ServerResponse(KeyBaseResult.INSTANCE.getResult(2003, responseBody, null, null), null, null, null, 14, null);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final ServerResponse getResponse(String responseMessage) {
            try {
                Object parse = JSONValue.parse(responseMessage);
                Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONArray");
                JSONArray jSONArray = (JSONArray) parse;
                String str = (String) jSONArray.get(0);
                JSONObject jSONObject = (JSONObject) jSONArray.get(1);
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(2);
                return new ServerResponse(getResult(jSONObject2), str, jSONObject, jSONObject2, null);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.٬ݯح׭٩(576335054), e.toString(), e);
                if (responseMessage == null) {
                    responseMessage = "";
                }
                return new ServerResponse(KeyBaseResult.INSTANCE.getResult(2003, responseMessage, null, null), null, null, null, 14, null);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final KeyBaseResult<JSONObject> getResult(JSONObject responseBody) {
            Intrinsics.checkNotNull(responseBody);
            String str = y.ݮڮֲڭܩ(-628237012);
            if (responseBody.containsKey((Object) str)) {
                Number number = (Number) responseBody.get((Object) str);
                Intrinsics.checkNotNull(number);
                int intValue = number.intValue();
                String str2 = (String) responseBody.get((Object) y.ݬֲ֮ܲت(1512761407));
                if (str2 == null) {
                    str2 = "";
                }
                return KeyBaseResult.INSTANCE.getResult(intValue, str2, null, (JSONObject) responseBody.get((Object) y.֬ڱܱײٮ(-1159406207)));
            }
            return KeyBaseResult.INSTANCE.getSuccessResult(null, responseBody);
        }
    }
}
