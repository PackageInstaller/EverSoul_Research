package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.kakao.sdk.common.util.Utility;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: KakaoTypeAdapterFactory.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J(\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\r"}, m839d2 = {"Lcom/kakao/sdk/common/json/MapToQueryAdapter;", "Lcom/google/gson/TypeAdapter;", "", "", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class MapToQueryAdapter extends TypeAdapter<Map<String, ? extends String>> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Map<String, ? extends String> map) {
        write2(jsonWriter, (Map<String, String>) map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter out, Map<String, String> value) {
        if (value == null) {
            if (out == null) {
                return;
            }
            out.nullValue();
        } else {
            String buildQuery = Utility.INSTANCE.buildQuery(value);
            if (out == null) {
                return;
            }
            out.value(buildQuery);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Map<String, ? extends String> read2(JsonReader in) {
        if ((in == null ? null : in.peek()) == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        return Utility.INSTANCE.parseQuery(in != null ? in.nextString() : null);
    }
}
