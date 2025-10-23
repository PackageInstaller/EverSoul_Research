package com.kakaogame.server;

import com.kakaogame.util.json.JSONAware;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyBaseResult.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u00020\u0005:\u0002\"#B\u0007\b\u0012¢\u0006\u0002\u0010\u0006B\u001f\b\u0014\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJK\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\n\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R%\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001c¨\u0006$"}, m839d2 = {"Lcom/kakaogame/server/KeyBaseResult;", "T", "Ljava/util/LinkedHashMap;", "", "", "Lcom/kakaogame/util/json/JSONAware;", "()V", "m", "", "(Ljava/util/Map;)V", "code", "", "getCode", "()I", "content", "getContent", "()Ljava/lang/Object;", "defaultDecription", "getDefaultDecription", "()Ljava/lang/String;", "description", "getDescription", "headers", "", "getHeaders", "()Ljava/util/Map;", "isNotSuccess", "", "()Z", "isSuccess", "setResult", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/Object;)Lcom/kakaogame/server/KeyBaseResult;", "toJSONString", "toString", "Companion", "ResultCode", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class KeyBaseResult<T> extends LinkedHashMap<String, Object> implements JSONAware {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_CODE = "code";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DESC = "desc";
    public static final String KEY_HEADER = "header";
    public static final String KEY_SERVER_ERROR_CODE = "serverErrorCode";
    private static final long serialVersionUID = -8349956291777706222L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KeyBaseResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getResult(int i) {
        return INSTANCE.getResult(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getResult(int i, String str) {
        return INSTANCE.getResult(i, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getResult(int i, String str, Map<String, ? extends List<String>> map) {
        return INSTANCE.getResult(i, str, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getResult(int i, String str, Map<String, ? extends List<String>> map, T t) {
        return INSTANCE.getResult(i, str, map, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getResult(Map<String, ? extends Object> map) {
        return INSTANCE.getResult(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getSuccessResult() {
        return INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getSuccessResult(Map<String, ? extends List<String>> map) {
        return INSTANCE.getSuccessResult(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KeyBaseResult<T> getSuccessResult(Map<String, ? extends List<String>> map, T t) {
        return INSTANCE.getSuccessResult(map, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Object get(String str) {
        return super.get((Object) str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Object getOrDefault(String str, Object obj) {
        return super.getOrDefault((Object) str, (String) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ int getSize() {
        return super.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ Object remove(String str) {
        return super.remove((Object) str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (obj instanceof String) {
            return remove((String) obj, obj2);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* bridge */ boolean remove(String str, Object obj) {
        return super.remove((Object) str, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KeyBaseResult() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KeyBaseResult<T> setResult(int code, String description, Map<String, ? extends List<String>> headers, T content) {
        KeyBaseResult<T> keyBaseResult = this;
        keyBaseResult.put(y.دײܮڳܯ(2051571757), Integer.valueOf(code));
        if (code < 1000) {
            keyBaseResult.put(y.ۮڭڭܬި(862433435), Integer.valueOf(code));
        }
        keyBaseResult.put("desc", description);
        keyBaseResult.put(KEY_HEADER, headers);
        keyBaseResult.put("content", content);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected KeyBaseResult(Map<String, ? extends Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isSuccess() {
        return getCode() == 200;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNotSuccess() {
        return getCode() != 200;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getCode() {
        Object obj = get((Object) y.دײܮڳܯ(2051571757));
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDescription() {
        String str = (String) get((Object) y.ݬֲ֮ܲت(1512761407));
        String str2 = str;
        return str2 == null || str2.length() == 0 ? getDefaultDecription() : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getDefaultDecription() {
        try {
            Field[] declaredFields = ResultCode.class.getDeclaredFields();
            Intrinsics.checkNotNull(declaredFields);
            for (Field field : declaredFields) {
                Object obj = field.get(null);
                if (obj instanceof Integer) {
                    int code = getCode();
                    if ((obj instanceof Integer) && code == ((Number) obj).intValue()) {
                        String name = field.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        return name;
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final T getContent() {
        return (T) get((Object) y.֬ڱܱײٮ(-1159406207));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, List<String>> getHeaders() {
        Object obj = get((Object) y.ۮڭڭܬި(862842747));
        if (obj == null) {
            return null;
        }
        try {
            return (Map) obj;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap
    public String toString() {
        return isSuccess() ? y.ݮڮֲڭܩ(-628247844) : y.֬ڱܱײٮ(-1159079319) + getCode() + y.ݮڮֲڭܩ(-628625604) + getDescription() + ']';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.util.json.JSONAware
    public String toJSONString() {
        return JSONValue.toJSONString(this);
    }

    /* compiled from: KeyBaseResult.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m839d2 = {"Lcom/kakaogame/server/KeyBaseResult$ResultCode;", "", "()V", "ALREADY_USED_IDP_ACCOUNT", "", "APP_TERMINATE", "AUTH_FAILURE", "BAD_REQUEST", "CLIENT_EXCEPTION", "CONFLICT_DATA", "FAILURE", "FORBIDDEN", "IDP_AUTH_FAILURE", "INITIALIZATION_FAILED", "INTERNAL_ERROR", "INVALID_PARAMETER", "INVALID_STATE", "NETWORK_FAILURE", "NOT_AUTHORIZED", "NOT_EXIST_DATA", "NOT_FOUND", "NOT_INITIALIZED", "NOT_SUPPORTED", "SERVER_CONNECTION_FAILED", "SERVER_EXCEPTION", "SERVER_INVALID_RESPONSE", "SERVER_TIMEOUT", "SERVICE_UNAVAILABLE", "SUCCESS", "USER_CANCELED", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class ResultCode {
        public static final int ALREADY_USED_IDP_ACCOUNT = 406;
        public static final int APP_TERMINATE = 9900;
        public static final int AUTH_FAILURE = 401;
        public static final int BAD_REQUEST = 400;
        public static final int CLIENT_EXCEPTION = 4001;
        public static final int CONFLICT_DATA = 409;
        public static final int FAILURE = 9999;
        public static final int FORBIDDEN = 403;
        public static final int IDP_AUTH_FAILURE = 4010;
        public static final int INITIALIZATION_FAILED = 3000;
        public static final ResultCode INSTANCE = new ResultCode();
        public static final int INTERNAL_ERROR = 500;
        public static final int INVALID_PARAMETER = 4000;
        public static final int INVALID_STATE = 4002;
        public static final int NETWORK_FAILURE = 1001;
        public static final int NOT_AUTHORIZED = 3002;
        public static final int NOT_EXIST_DATA = 406;
        public static final int NOT_FOUND = 404;
        public static final int NOT_INITIALIZED = 3001;
        public static final int NOT_SUPPORTED = 5001;
        public static final int SERVER_CONNECTION_FAILED = 2004;
        public static final int SERVER_EXCEPTION = 2002;
        public static final int SERVER_INVALID_RESPONSE = 2003;
        public static final int SERVER_TIMEOUT = 2001;
        public static final int SERVICE_UNAVAILABLE = 503;
        public static final int SUCCESS = 200;
        public static final int USER_CANCELED = 9001;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ResultCode() {
        }
    }

    /* compiled from: KeyBaseResult.kt */
    @Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J@\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0013\u0018\u00010\u0012H\u0007JQ\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0013\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u0001H\rH\u0007¢\u0006\u0002\u0010\u0015J6\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0013\u0018\u00010\u0012J,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H\u0007J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\rH\u0007J0\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0013\u0018\u00010\u0012H\u0007J=\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u0002H\rH\u0007¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/server/KeyBaseResult$Companion;", "", "()V", "KEY_CODE", "", "KEY_CONTENT", "KEY_DESC", "KEY_HEADER", "KEY_SERVER_ERROR_CODE", "serialVersionUID", "", "getResult", "Lcom/kakaogame/server/KeyBaseResult;", "T", "code", "", "description", "headers", "", "", "content", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/Object;)Lcom/kakaogame/server/KeyBaseResult;", "result", "getSuccessResult", "(Ljava/util/Map;Ljava/lang/Object;)Lcom/kakaogame/server/KeyBaseResult;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
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
        public final <T> KeyBaseResult<T> getSuccessResult() {
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(200, y.ٴسسݬߨ(1392755458), null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KeyBaseResult<T> getSuccessResult(Map<String, ? extends List<String>> headers) {
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(200, y.ٴسسݬߨ(1392755458), headers, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KeyBaseResult<T> getSuccessResult(Map<String, ? extends List<String>> headers, T content) {
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(200, y.ٴسسݬߨ(1392755458), headers, content);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KeyBaseResult<T> getResult(int code) {
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(code, "", null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final <T> KeyBaseResult<T> getResult(int code, Map<String, ? extends List<String>> headers) {
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(code, "", headers, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KeyBaseResult<T> getResult(int code, String description) {
            Intrinsics.checkNotNullParameter(description, y.ٴسسݬߨ(1392801274));
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(code, description, null, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KeyBaseResult<T> getResult(int code, String description, Map<String, ? extends List<String>> headers) {
            Intrinsics.checkNotNullParameter(description, y.ٴسسݬߨ(1392801274));
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(code, description, headers, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KeyBaseResult<T> getResult(int code, String description, Map<String, ? extends List<String>> headers, T content) {
            return new KeyBaseResult((DefaultConstructorMarker) null).setResult(code, description, headers, content);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KeyBaseResult<T> getResult(Map<String, ? extends Object> result) {
            return new KeyBaseResult<>(result);
        }
    }
}
