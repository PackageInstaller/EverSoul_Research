package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.Date;
import kotlin.Metadata;

/* compiled from: KakaoTypeAdapterFactory.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, m839d2 = {"Lcom/kakao/sdk/common/json/KakaoIntDateTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Ljava/util/Date;", "()V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoIntDateTypeAdapter extends TypeAdapter<Date> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, Date value) {
        if (value == null) {
            if (out == null) {
                return;
            }
            out.nullValue();
        } else {
            if (out == null) {
                return;
            }
            out.value(value.getTime() / 1000);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read, reason: avoid collision after fix types in other method */
    public Date read2(JsonReader in) {
        if ((in == null ? null : in.peek()) == JsonToken.NULL) {
            in.nextNull();
            return null;
        }
        if ((in == null ? null : in.peek()) == JsonToken.NUMBER) {
            return new Date(in.nextLong() * 1000);
        }
        return null;
    }
}
