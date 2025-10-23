package com.kakaogame.util.json;

import com.liapp.y;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* compiled from: JSONObject.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\b\u0016\u0018\u0000 \r2\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u00020\u00042\u00020\u0005:\u0001\rB\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/util/json/JSONObject;", "Ljava/util/LinkedHashMap;", "", "", "Lcom/kakaogame/util/json/JSONAware;", "Lcom/kakaogame/util/json/JSONStreamAware;", "()V", "map", "", "(Ljava/util/Map;)V", "toJSONString", "toString", "writeJSONString", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class JSONObject extends LinkedHashMap<String, Object> implements JSONAware, JSONStreamAware {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -503443796854799292L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String toJSONString(Map<String, ? extends Object> map) {
        return INSTANCE.toJSONString(map);
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
    public JSONObject() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject(Map<String, ? extends Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.util.json.JSONStreamAware
    public String writeJSONString() throws IOException {
        return INSTANCE.writeJSONString(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.util.json.JSONAware
    public String toJSONString() {
        return INSTANCE.toJSONString(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap
    public String toString() {
        return toJSONString();
    }

    /* compiled from: JSONObject.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\b\u001a\u00020\u00062\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nH\u0007J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0001J\u001e\u0010\u000e\u001a\u00020\u00062\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/util/json/JSONObject$Companion;", "", "()V", "serialVersionUID", "", "escape", "", "s", "toJSONString", "map", "", "toString", "key", "value", "writeJSONString", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String writeJSONString(Map<String, ? extends Object> map) throws IOException {
            StringWriter stringWriter = new StringWriter();
            String str = y.ٲٴݴ״ٰ(1781855688);
            if (map == null) {
                stringWriter.write("null");
                String stringWriter2 = stringWriter.toString();
                Intrinsics.checkNotNullExpressionValue(stringWriter2, str);
                return stringWriter2;
            }
            stringWriter.write(123);
            boolean z = true;
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (z) {
                    z = false;
                } else {
                    stringWriter.write(44);
                }
                stringWriter.write(34);
                stringWriter.write(escape(key));
                stringWriter.write(34);
                stringWriter.write(58);
                stringWriter.write(JSONValue.writeJSONString(value));
            }
            stringWriter.write(125);
            String stringWriter3 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter3, str);
            return stringWriter3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final String toJSONString(Map<String, ? extends Object> map) {
            try {
                return writeJSONString(map);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toString(String key, Object value) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Typography.quote);
            if (key == null) {
                stringBuffer.append("null");
            } else {
                JSONValue.escape(key, stringBuffer);
            }
            stringBuffer.append(Typography.quote).append(':');
            stringBuffer.append(JSONValue.toJSONString(value));
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
            return stringBuffer2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final String escape(String s) {
            return JSONValue.escape(s);
        }
    }
}
