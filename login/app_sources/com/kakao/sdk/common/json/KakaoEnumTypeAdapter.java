package com.kakao.sdk.common.json;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoTypeAdapterFactory.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lcom/kakao/sdk/common/json/KakaoEnumTypeAdapter;", "T", "Lcom/google/gson/TypeAdapter;", "enumClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "read", "in", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoEnumTypeAdapter<T> extends TypeAdapter<T> {
    private final Class<T> enumClass;

    /* compiled from: KakaoTypeAdapterFactory.kt */
    @Metadata(m840k = 3, m841mv = {1, 6, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[JsonToken.values().length];
            iArr[JsonToken.NUMBER.ordinal()] = 1;
            iArr[JsonToken.STRING.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoEnumTypeAdapter(Class<T> enumClass) {
        Intrinsics.checkNotNullParameter(enumClass, "enumClass");
        this.enumClass = enumClass;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, T value) {
        if (value == null) {
            if (out == null) {
                return;
            }
            out.nullValue();
            return;
        }
        boolean isAnnotationPresent = this.enumClass.isAnnotationPresent(IntEnum.class);
        Object[] enumConstants = this.enumClass.getEnumConstants();
        if (enumConstants != null) {
            int length = enumConstants.length;
            int i = 0;
            while (i < length) {
                Object obj = enumConstants[i];
                i++;
                if (obj != null) {
                    try {
                        SerializedName serializedName = (SerializedName) this.enumClass.getField(((Enum) obj).name()).getAnnotation(SerializedName.class);
                        if (serializedName != null && Intrinsics.areEqual(obj, value)) {
                            if (isAnnotationPresent) {
                                if (out == null) {
                                    return;
                                }
                                out.value(Integer.valueOf(Integer.parseInt(serializedName.value())));
                                return;
                            } else {
                                if (out == null) {
                                    return;
                                }
                                out.value(serializedName.value());
                                return;
                            }
                        }
                    } catch (NoSuchFieldException e) {
                        throw new IOException(e);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                }
            }
        }
        if (out == null) {
            return;
        }
        out.value(value.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00dc  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T read2(com.google.gson.stream.JsonReader r12) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.common.json.KakaoEnumTypeAdapter.read2(com.google.gson.stream.JsonReader):java.lang.Object");
    }
}
