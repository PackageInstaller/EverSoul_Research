package com.kakaogame;

import com.kakaogame.util.json.JSONAware;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapObject.kt */
@Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0018B!\b\u0004\u0012\u0018\b\u0002\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0086\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0014J\u001e\u0010\u0014\u001a\u00020\u00122\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000bH\u0004J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R$\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/MapObject;", "Ljava/io/Serializable;", "Lcom/kakaogame/util/json/JSONAware;", "content", "", "", "", "(Ljava/util/Map;)V", "getContent", "()Ljava/util/Map;", "object", "", "getObject", "containsKey", "", "key", "get", "put", "", "value", "putAll", "m", "toJSONString", "toString", "Companion", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public abstract class MapObject implements Serializable, JSONAware {
    private static final long serialVersionUID = 4099866129531658860L;
    private final Map<String, Object> content;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected MapObject() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected MapObject(Map<String, Object> map) {
        this.content = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ MapObject(LinkedHashMap linkedHashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LinkedHashMap() : linkedHashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Map<String, Object> getContent() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object get(String key) {
        Map<String, Object> map = this.content;
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getObject() {
        return this.content;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void put(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, y.٬ݯح׭٩(575939726));
        Map<String, Object> map = this.content;
        if (map != null) {
            map.put(key, value);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void putAll(Map<String, ? extends Object> m) {
        Intrinsics.checkNotNullParameter(m, y.ٴسسݬߨ(1392530698));
        Map<String, Object> map = this.content;
        if (map != null) {
            map.putAll(m);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean containsKey(String key) {
        Map<String, Object> map = this.content;
        if (map != null) {
            return map.containsKey(key);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return JSONValue.toJSONString(this.content);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.util.json.JSONAware
    public String toJSONString() {
        return JSONValue.toJSONString(this.content);
    }
}
