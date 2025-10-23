package com.kakaogame;

import android.text.TextUtils;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.json.JSONAware;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGResult.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u00052\u00020\u0006:\u0002+,B#\b\u0012\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u000bB\u001f\b\u0014\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001c\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010)\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R(\u0010\u001d\u001a\u0004\u0018\u00010\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010$¨\u0006-"}, m839d2 = {"Lcom/kakaogame/KGResult;", "T", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "Lcom/kakaogame/util/json/JSONAware;", "code", "", "description", "content", "(ILjava/lang/String;Ljava/lang/Object;)V", "m", "", "(Ljava/util/Map;)V", "getCode", "()I", "getContent", "()Ljava/lang/Object;", "defaultDescription", "getDefaultDescription", "()Ljava/lang/String;", "getDescription", "isNeedToWaitError", "", "()Z", "isNetworkError", "isNotSuccess", "isSuccess", "message", "getMessage", "setMessage", "(Ljava/lang/String;)V", "serverErrorCode", "getServerErrorCode", "setServerErrorCode", "(I)V", "convertErrorCode", "put", "key", "value", "toJSONString", "toString", "Companion", "KGResultCode", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGResult<T> extends LinkedHashMap<String, Object> implements JSONAware {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_CODE = "code";
    public static final String KEY_CONTENT = "content";
    public static final String KEY_DESC = "desc";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_SERVER_ERROR_CODE = "serverErrorCode";
    private static final long serialVersionUID = -8349956291777706222L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KGResult(int i, String str, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KGResult<T> getResult(int i) {
        return INSTANCE.getResult(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KGResult<T> getResult(int i, String str) {
        return INSTANCE.getResult(i, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KGResult<T> getResult(int i, String str, T t) {
        return INSTANCE.getResult(i, str, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KGResult<T> getResult(Map<String, ? extends Object> map) {
        return INSTANCE.getResult(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KGResult<T> getSuccessResult() {
        return INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final <T> KGResult<T> getSuccessResult(T t) {
        return INSTANCE.getSuccessResult(t);
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
    private KGResult(int i, String str, T t) {
        put(y.دײܮڳܯ(2051571757), (Object) Integer.valueOf(i));
        put(y.ݬֲ֮ܲت(1512761407), (Object) str);
        put("content", (Object) t);
        put("message", (Object) getMessage(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected KGResult(Map<String, ? extends Object> map) {
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
    public final KGResult<T> convertErrorCode(int code) {
        put(y.دײܮڳܯ(2051571757), (Object) Integer.valueOf(code));
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDescription() {
        String str = (String) get((Object) y.ݬֲ֮ܲت(1512761407));
        return TextUtils.isEmpty(str) ? getDefaultDescription() : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getDefaultDescription() {
        try {
            Field[] declaredFields = KGResultCode.class.getDeclaredFields();
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
    public final String getMessage() {
        return (String) get((Object) y.دײܮڳܯ(2051551053));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setMessage(String str) {
        if (str != null) {
            put(y.دײܮڳܯ(2051551053), (Object) str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getServerErrorCode() {
        Number number;
        String str = y.ۮڭڭܬި(862433435);
        if (!containsKey((Object) str) || (number = (Number) get((Object) str)) == null) {
            return 0;
        }
        return number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setServerErrorCode(int i) {
        put(y.ۮڭڭܬި(862433435), (Object) Integer.valueOf(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Object put = super.put((KGResult<T>) key, (String) value);
        if (Intrinsics.areEqual(y.دײܮڳܯ(2051571757), key)) {
            put(y.دײܮڳܯ(2051551053), (Object) getMessage(getCode()));
        }
        return put;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getMessage(int code) {
        String description;
        if (code == 200 || code == 4000 || code == 4003 || code == 9001 || code == 7204) {
            return "";
        }
        if (code == 1001 || code == 2001 || code == 2004) {
            return ResourceUtil.getString(CoreManager.INSTANCE.getInstance().getContext(), "zinny_sdk_error_msg_network", Integer.valueOf(code));
        }
        if (code == 401 || code == 4010) {
            return ResourceUtil.getString(CoreManager.INSTANCE.getInstance().getContext(), y.ݬֲ֮ܲت(1512761423));
        }
        if (code == 406) {
            return ResourceUtil.getString(CoreManager.INSTANCE.getInstance().getContext(), y.֬ڱܱײٮ(-1159495271));
        }
        if (code == 8001) {
            return ResourceUtil.getString(CoreManager.INSTANCE.getInstance().getContext(), y.֬ڱܱײٮ(-1159495503));
        }
        if (code == 7202) {
            return y.ݬֲ֮ܲت(1512764711);
        }
        if (code == -405) {
            return ResourceUtil.getString(CoreManager.INSTANCE.getInstance().getContext(), y.٬ݯح׭٩(575675222));
        }
        if (code == -406) {
            return ResourceUtil.getString(CoreManager.INSTANCE.getInstance().getContext(), y.دײܮڳܯ(2051726037), Integer.valueOf(InfodeskHelper.INSTANCE.getAgeAuthLimit() - 1));
        }
        if (!(code == 4070 || code == 4080)) {
            return (!(-1000 <= code && code < 0) || (description = getDescription()) == null) ? ResourceUtil.getString(CoreManager.INSTANCE.getInstance().getContext(), C2382R.string.zinny_sdk_error_msg_common, Integer.valueOf(code)) : description;
        }
        String description2 = getDescription();
        return description2 == null ? "" : description2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNetworkError() {
        int code = getCode();
        return code == 1001 || code == 2001 || code == 2004;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNeedToWaitError() {
        int code = getCode();
        return (500 <= code && code < 600) || code == 473 || code == 2001 || code == 2002;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap
    public String toString() {
        if (isSuccess()) {
            return y.ۮڭڭܬި(862434051) + (getContent() == null ? y.ݮڮֲڭܩ(-628841308) : String.valueOf(getContent()));
        }
        return y.ۮڭڭܬި(862434259) + getCode() + y.ݮڮֲڭܩ(-628625604) + getDescription() + y.دײܮڳܯ(2051725725) + getMessage() + ']';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.util.json.JSONAware
    public String toJSONString() {
        return JSONValue.toJSONString(this);
    }

    /* compiled from: KGResult.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bM\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006Q"}, m839d2 = {"Lcom/kakaogame/KGResult$KGResultCode;", "", "()V", "ACCOUNT_CREATION_LIMIT", "", "ADDON_SERVICE_FAILED", "AGREEMENT_REQUIRED", "ALREADY_COMPLETE_SERVICE", "ALREADY_USED_IDP_ACCOUNT", "ALREADY_USER_GOT_REWARD", "API_NOT_EXISTS", "APP_TERMINATE", "AUTH_CODE_TIME_ERROR", "AUTH_FAILURE", "BAD_REQUEST", "BLOCKED_COUNTRY_CODE", "BLOCKED_IP_ADDRESS", "BLOCKED_USER_ACCESS", "CLIENT_EXCEPTION", "CODE_NOT_MATCHED", "CONFLICT_DATA", "DEVICE_NOTIFICATION_SETTING_OFF", "DEVICE_REGISTRATION_REQUIRED", "EXCEED_DAILY_USAGE", "EXCEED_MAX_UPLOAD_NUMBER", "EXCEED_MAX_UPLOAD_SIZE", "EXCEED_MONTHLY_USAGE", "EXIT_PROCESS_ERROR", "FACEBOOK_NOT_INSTALLED", "FAILURE", "FAIL_SEND_MESSAGE_IN_MULTI_PICKER", "FORBIDDEN", "GOOGLE_PLAY_SERVICE_NOT_AVAILABLE", "IDP_AUTH_FAILURE", "INCOMPLETE_ADDON_SERVICE", "INITIALIZATION_FAILED", "INTERNAL_ERROR", "INVALID_AUTHORIZED", "INVALID_CODE", "INVALID_EMAIL_ADDRESS", "INVALID_KEY_ID", "INVALID_PARAMETER", "INVALID_PHONE_NUMBER", "INVALID_STATE", "INVALID_SUB_ID", "INVALID_TIME_ERROR", "IN_PROGRESS", "KAKAOTALK_NOT_AUTHENTICATION", "KAKAOTALK_NOT_INSTALLED", "MESSAGE_FROM_DESCRIPTION", "MESSAGE_SETTING_DISABLE", "NETWORK_FAILURE", "NOT_ALLOWED", "NOT_ALLOWED_ACCESS", "NOT_AUTHORIZED", "NOT_EXIST_DATA", "NOT_FOUND", "NOT_INITIALIZED", "NOT_KAKAOTALK_USER", "NOT_MATCHED_PASSWORD", "NOT_SUPPORTED", "NO_DATA", "PASSWORD_REGISTRATION_REQUIRED", "PLAYER_MARKET_REFUND_PUNISHMENT", "PLAYER_PROTECTED", "PLAYER_PUNISHMENT", "PLAYER_UNREGISTERED", "PRECONDITION_FAILED", "REQUEST_REOPEN", "RESTRICT_ADOLESCENT", "SAME_PASSWORD_USED", "SERVER_CONNECTION_FAILED", "SERVER_EXCEPTION", "SERVER_INVALID_RESPONSE", "SERVER_TIMEOUT", "SERVICE_UNAVAILABLE", "SHOW_ENGINE_UI", "SUCCESS", "UNDER_AGE_PLAYER", "USER_CANCELED", "ZAT_REFRESH_ONLY", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGResultCode {
        public static final int ACCOUNT_CREATION_LIMIT = 493;
        public static final int ADDON_SERVICE_FAILED = 6106;
        public static final int AGREEMENT_REQUIRED = 7204;
        public static final int ALREADY_COMPLETE_SERVICE = 6105;
        public static final int ALREADY_USED_IDP_ACCOUNT = 406;
        public static final int ALREADY_USER_GOT_REWARD = 406;
        public static final int API_NOT_EXISTS = 6001;
        public static final int APP_TERMINATE = 9900;
        public static final int AUTH_CODE_TIME_ERROR = 467;
        public static final int AUTH_FAILURE = 401;
        public static final int BAD_REQUEST = 400;
        public static final int BLOCKED_COUNTRY_CODE = 4070;
        public static final int BLOCKED_IP_ADDRESS = 4080;
        public static final int BLOCKED_USER_ACCESS = 565;
        public static final int CLIENT_EXCEPTION = 4001;
        public static final int CODE_NOT_MATCHED = 461;
        public static final int CONFLICT_DATA = 409;
        public static final int DEVICE_NOTIFICATION_SETTING_OFF = 5002;
        public static final int DEVICE_REGISTRATION_REQUIRED = 4011;
        public static final int EXCEED_DAILY_USAGE = 7002;
        public static final int EXCEED_MAX_UPLOAD_NUMBER = 7004;
        public static final int EXCEED_MAX_UPLOAD_SIZE = 7003;
        public static final int EXCEED_MONTHLY_USAGE = 7001;
        public static final int EXIT_PROCESS_ERROR = 462;
        public static final int FACEBOOK_NOT_INSTALLED = 8001;
        public static final int FAILURE = 9999;
        public static final int FAIL_SEND_MESSAGE_IN_MULTI_PICKER = 7301;
        public static final int FORBIDDEN = 403;
        public static final int GOOGLE_PLAY_SERVICE_NOT_AVAILABLE = 8002;
        public static final int IDP_AUTH_FAILURE = 4010;
        public static final int INCOMPLETE_ADDON_SERVICE = 6104;
        public static final int INITIALIZATION_FAILED = 3000;
        public static final KGResultCode INSTANCE = new KGResultCode();
        public static final int INTERNAL_ERROR = 500;
        public static final int INVALID_AUTHORIZED = 6100;
        public static final int INVALID_CODE = 6103;
        public static final int INVALID_EMAIL_ADDRESS = 472;
        public static final int INVALID_KEY_ID = 6102;
        public static final int INVALID_PARAMETER = 4000;
        public static final int INVALID_PHONE_NUMBER = 478;
        public static final int INVALID_STATE = 4002;
        public static final int INVALID_SUB_ID = 6101;
        public static final int INVALID_TIME_ERROR = 469;
        public static final int IN_PROGRESS = 4003;
        public static final int KAKAOTALK_NOT_AUTHENTICATION = 300000;
        public static final int KAKAOTALK_NOT_INSTALLED = 7201;
        public static final int MESSAGE_FROM_DESCRIPTION = 400000;
        public static final int MESSAGE_SETTING_DISABLE = 7101;
        public static final int NETWORK_FAILURE = 1001;
        public static final int NOT_ALLOWED = 483;
        public static final int NOT_ALLOWED_ACCESS = 4013;
        public static final int NOT_AUTHORIZED = 3002;
        public static final int NOT_EXIST_DATA = 406;
        public static final int NOT_FOUND = 404;
        public static final int NOT_INITIALIZED = 3001;
        public static final int NOT_KAKAOTALK_USER = 7202;
        public static final int NOT_MATCHED_PASSWORD = 563;
        public static final int NOT_SUPPORTED = 5001;
        public static final int NO_DATA = 410;
        public static final int PASSWORD_REGISTRATION_REQUIRED = 4012;
        public static final int PLAYER_MARKET_REFUND_PUNISHMENT = 4060;
        public static final int PLAYER_PROTECTED = 462;
        public static final int PLAYER_PUNISHMENT = 461;
        public static final int PLAYER_UNREGISTERED = 463;
        public static final int PRECONDITION_FAILED = 412;
        public static final int REQUEST_REOPEN = 100000;
        public static final int RESTRICT_ADOLESCENT = 494;
        public static final int SAME_PASSWORD_USED = 568;
        public static final int SERVER_CONNECTION_FAILED = 2004;
        public static final int SERVER_EXCEPTION = 2002;
        public static final int SERVER_INVALID_RESPONSE = 2003;
        public static final int SERVER_TIMEOUT = 2001;
        public static final int SERVICE_UNAVAILABLE = 473;
        public static final int SHOW_ENGINE_UI = 10001;
        public static final int SUCCESS = 200;
        public static final int UNDER_AGE_PLAYER = 7203;
        public static final int USER_CANCELED = 9001;
        public static final int ZAT_REFRESH_ONLY = 200000;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGResultCode() {
        }
    }

    /* compiled from: KGResult.kt */
    @Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J(\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J5\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u0002H\rH\u0007¢\u0006\u0002\u0010\u0012J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\u0007J\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\f\"\u0004\b\u0001\u0010\rH\u0007J#\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u0011\u001a\u0002H\rH\u0007¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/KGResult$Companion;", "", "()V", "KEY_CODE", "", "KEY_CONTENT", "KEY_DESC", "KEY_MESSAGE", "KEY_SERVER_ERROR_CODE", "serialVersionUID", "", "getResult", "Lcom/kakaogame/KGResult;", "T", "code", "", "description", "content", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/kakaogame/KGResult;", "result", "", "getSuccessResult", "(Ljava/lang/Object;)Lcom/kakaogame/KGResult;", "isNetworkError", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isNetworkError(int code) {
            if (code == 1001 || code == 2001 || code == 2004) {
                return true;
            }
            return (500 <= code && code < 600) || code == 2002;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KGResult<T> getSuccessResult() {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new KGResult<>(200, y.ٴسسݬߨ(1392755458), defaultConstructorMarker, defaultConstructorMarker);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KGResult<T> getSuccessResult(T content) {
            return new KGResult<>(200, y.ٴسسݬߨ(1392755458), content, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KGResult<T> getResult(int code) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new KGResult<>(code, "", defaultConstructorMarker, defaultConstructorMarker);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KGResult<T> getResult(int code, String description) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new KGResult<>(code, description, defaultConstructorMarker, defaultConstructorMarker);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KGResult<T> getResult(int code, String description, T content) {
            return new KGResult<>(code, description, content, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final <T> KGResult<T> getResult(Map<String, ? extends Object> result) {
            Intrinsics.checkNotNullParameter(result, y.ٴسسݬߨ(1392585418));
            return new KGResult<>(result);
        }
    }
}
