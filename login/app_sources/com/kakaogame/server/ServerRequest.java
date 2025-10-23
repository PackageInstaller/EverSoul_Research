package com.kakaogame.server;

import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.Logger;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.util.json.parser.ParseException;
import com.liapp.y;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServerRequest.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010&J\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010&J\u001e\u0010(\u001a\u00020)2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&J\u001e\u0010+\u001a\u00020)2\u0016\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010&J\u0018\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001J\u0018\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001J\b\u0010/\u001a\u00020\u0003H\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR$\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004R(\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u000e\u0010\u0004R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00061"}, m839d2 = {"Lcom/kakaogame/server/ServerRequest;", "", "uri", "", "(Ljava/lang/String;)V", SDKConstants.PARAM_A2U_BODY, "", KeyBaseResult.KEY_HEADER, "isIgnoreTimeout", "", "()Z", "setIgnoreTimeout", "(Z)V", "isPlainTextBody", "setPlainTextBody", "requestMethod", FirebaseAnalytics.Param.METHOD, "getMethod", "()Ljava/lang/String;", "setMethod", "value", "plainTextBody", "getPlainTextBody", "requestMessage", "getRequestMessage", "requestUri", "getRequestUri", "timeout", "", "getTimeout", "()J", "setTimeout", "(J)V", "transactionNo", "", "getTransactionNo", "()I", "getBody", "", "getHeader", "putAllBody", "", "map", "putAllHeader", "putBody", "key", "putHeader", "toString", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ServerRequest {
    private static final String TAG = "ServerRequest";
    private final Map<String, Object> body;
    private final Map<String, Object> header;
    private boolean isIgnoreTimeout;
    private boolean isPlainTextBody;
    private String method;
    private String plainTextBody;
    private final String requestUri;
    private long timeout;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Random requestIdGenerator = new Random(System.currentTimeMillis());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final ServerRequest parse(String str) {
        return INSTANCE.parse(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ServerRequest(String str) {
        Intrinsics.checkNotNull(str);
        this.requestUri = str;
        this.method = "POST";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.header = linkedHashMap;
        this.body = new LinkedHashMap();
        this.timeout = -1L;
        linkedHashMap.put(y.ٴسسݬߨ(1393160066), Integer.valueOf(requestIdGenerator.nextInt()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRequestUri() {
        return this.requestUri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMethod() {
        return this.method;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setMethod(String str) {
        Intrinsics.checkNotNullParameter(str, y.ݬֲ֮ܲت(1512096543));
        if (str.length() > 0) {
            this.method = str;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPlainTextBody() {
        return this.isPlainTextBody;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setPlainTextBody(boolean z) {
        this.isPlainTextBody = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlainTextBody() {
        return this.plainTextBody;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setPlainTextBody(String str) {
        this.isPlainTextBody = true;
        this.plainTextBody = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getTimeout() {
        return this.timeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTimeout(long j) {
        this.timeout = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isIgnoreTimeout() {
        return this.isIgnoreTimeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setIgnoreTimeout(boolean z) {
        this.isIgnoreTimeout = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTransactionNo() {
        Object obj = this.header.get(y.ٴسسݬߨ(1393160066));
        if (obj instanceof Long) {
            return (int) ((Number) obj).longValue();
        }
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getHeader() {
        return this.header;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getBody() {
        return this.body;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void putHeader(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        if (TextUtils.isEmpty(key)) {
            return;
        }
        if (value == null) {
            value = "";
        }
        this.header.put(key, value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void putAllHeader(Map<String, ? extends Object> map) {
        if (map == null) {
            return;
        }
        this.header.putAll(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void putBody(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        this.isPlainTextBody = false;
        if (TextUtils.isEmpty(key)) {
            return;
        }
        if (value == null) {
            value = "";
        }
        this.body.put(key, value);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void putAllBody(Map<String, ? extends Object> map) {
        this.isPlainTextBody = false;
        if (map == null) {
            return;
        }
        this.body.putAll(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getRequestMessage() {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.add(this.requestUri);
            jSONArray.add(this.header);
            if (this.isPlainTextBody) {
                jSONArray.add(this.plainTextBody);
            } else {
                jSONArray.add(this.body);
            }
            return jSONArray.toJSONString();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159088847), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(y.ۮڭڭܬި(862392755), this.requestUri);
        hashMap.put(y.ٲٴݴ״ٰ(1781805184), this.method);
        hashMap.put(y.ۮڭڭܬި(862842747), getHeader());
        boolean z = this.isPlainTextBody;
        String str = y.ۮڭڭܬި(862442651);
        if (z) {
            hashMap.put(str, this.plainTextBody);
        } else {
            hashMap.put(str, getBody());
        }
        return new JSONObject(hashMap).toJSONString();
    }

    /* compiled from: ServerRequest.kt */
    @Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/server/ServerRequest$Companion;", "", "()V", "TAG", "", "requestIdGenerator", "Ljava/util/Random;", "parse", "Lcom/kakaogame/server/ServerRequest;", "request", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
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
        public final ServerRequest parse(String request) {
            try {
                Object parse = JSONValue.parse(request);
                Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                JSONObject jSONObject = (JSONObject) parse;
                String str = (String) jSONObject.get((Object) "uri");
                String str2 = (String) jSONObject.get((Object) FirebaseAnalytics.Param.METHOD);
                Map<String, ? extends Object> map = (Map) jSONObject.get((Object) KeyBaseResult.KEY_HEADER);
                Map<String, ? extends Object> map2 = (Map) jSONObject.get((Object) SDKConstants.PARAM_A2U_BODY);
                ServerRequest serverRequest = new ServerRequest(str);
                Intrinsics.checkNotNull(str2);
                serverRequest.setMethod(str2);
                serverRequest.putAllHeader(map);
                serverRequest.putAllBody(map2);
                return serverRequest;
            } catch (ParseException unused) {
                return null;
            }
        }
    }
}
