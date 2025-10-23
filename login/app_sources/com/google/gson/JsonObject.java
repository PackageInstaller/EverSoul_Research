package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class JsonObject extends JsonElement {
    private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.JsonElement
    public JsonObject deepCopy() {
        JsonObject jsonObject = new JsonObject();
        for (Map.Entry<String, JsonElement> entry : this.members.entrySet()) {
            jsonObject.add(entry.getKey(), entry.getValue().deepCopy());
        }
        return jsonObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(String str, JsonElement jsonElement) {
        LinkedTreeMap<String, JsonElement> linkedTreeMap = this.members;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(str, jsonElement);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonElement remove(String str) {
        return this.members.remove(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProperty(String str, String str2) {
        add(str, str2 == null ? JsonNull.INSTANCE : new JsonPrimitive(str2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProperty(String str, Number number) {
        add(str, number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProperty(String str, Boolean bool) {
        add(str, bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addProperty(String str, Character ch) {
        add(str, ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.members.entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<String> keySet() {
        return this.members.keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int size() {
        return this.members.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean has(String str) {
        return this.members.containsKey(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonElement get(String str) {
        return this.members.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonPrimitive getAsJsonPrimitive(String str) {
        return (JsonPrimitive) this.members.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonArray getAsJsonArray(String str) {
        return (JsonArray) this.members.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JsonObject getAsJsonObject(String str) {
        return (JsonObject) this.members.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof JsonObject) && ((JsonObject) obj).members.equals(this.members));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.members.hashCode();
    }
}
