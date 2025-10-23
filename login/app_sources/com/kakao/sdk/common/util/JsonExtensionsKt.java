package com.kakao.sdk.common.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;

/* compiled from: JsonExtensions.kt */
@Metadata(m838d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u0002\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f*\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\r\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u0004\u0018\u00010\u0002¨\u0006\u0010"}, m839d2 = {"asBooleanOrNull", "", "Lcom/google/gson/JsonElement;", "(Lcom/google/gson/JsonElement;)Ljava/lang/Boolean;", "asIntOrNull", "", "(Lcom/google/gson/JsonElement;)Ljava/lang/Integer;", "asJsonArrayOrNull", "Lcom/google/gson/JsonArray;", "asJsonObjectOrNull", "Lcom/google/gson/JsonObject;", "asLongOrNull", "", "(Lcom/google/gson/JsonElement;)Ljava/lang/Long;", "asStringOrNull", "", "common_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class JsonExtensionsKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String asStringOrNull(JsonElement jsonElement) {
        boolean z = false;
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            z = true;
        }
        if (z) {
            return jsonElement.getAsString();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Integer asIntOrNull(JsonElement jsonElement) {
        boolean z = false;
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            z = true;
        }
        if (z) {
            return Integer.valueOf(jsonElement.getAsInt());
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Long asLongOrNull(JsonElement jsonElement) {
        boolean z = false;
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            z = true;
        }
        if (z) {
            return Long.valueOf(jsonElement.getAsLong());
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Boolean asBooleanOrNull(JsonElement jsonElement) {
        boolean z = false;
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            z = true;
        }
        if (z) {
            return Boolean.valueOf(jsonElement.getAsBoolean());
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final JsonArray asJsonArrayOrNull(JsonElement jsonElement) {
        boolean z = false;
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            z = true;
        }
        if (z) {
            return jsonElement.getAsJsonArray();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final JsonObject asJsonObjectOrNull(JsonElement jsonElement) {
        boolean z = false;
        if (jsonElement != null && !jsonElement.isJsonNull()) {
            z = true;
        }
        if (z) {
            return jsonElement.getAsJsonObject();
        }
        return null;
    }
}
