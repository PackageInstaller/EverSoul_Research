package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import org.apache.commons.lang3.time.TimeZones;

/* compiled from: KakaoTypeAdapterFactory.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m839d2 = {"Lcom/kakao/sdk/common/json/KakaoDateTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Ljava/util/Date;", "()V", "format", "Ljava/text/SimpleDateFormat;", "getFormat", "()Ljava/text/SimpleDateFormat;", "read", "in", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoDateTypeAdapter extends TypeAdapter<Date> {
    private final SimpleDateFormat format;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoDateTypeAdapter() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(TimeZones.GMT_ID));
        this.format = simpleDateFormat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SimpleDateFormat getFormat() {
        return this.format;
    }

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
            out.value(this.format.format(value));
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
        if ((in == null ? null : in.peek()) == JsonToken.STRING) {
            return this.format.parse(in.nextString());
        }
        return null;
    }
}
