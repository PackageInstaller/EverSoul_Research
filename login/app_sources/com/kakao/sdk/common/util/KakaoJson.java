package com.kakao.sdk.common.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kakao.sdk.common.json.Exclude;
import com.kakao.sdk.common.json.KakaoTypeAdapterFactory;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoJson.kt */
@Metadata(m838d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0017\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0019J)\u0010\u001a\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u001e\u001a\u0002H\u0010¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006 "}, m839d2 = {"Lcom/kakao/sdk/common/util/KakaoJson;", "", "()V", "base", "Lcom/google/gson/Gson;", "getBase", "()Lcom/google/gson/Gson;", "internalBuilder", "Lcom/google/gson/GsonBuilder;", "kotlin.jvm.PlatformType", "kakaoExclusionStrategy", "com/kakao/sdk/common/util/KakaoJson$kakaoExclusionStrategy$1", "Lcom/kakao/sdk/common/util/KakaoJson$kakaoExclusionStrategy$1;", "pretty", "getPretty", "fromJson", "T", TypedValues.Custom.S_STRING, "", "type1", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "listFromJson", "", "type", "Ljava/lang/Class;", "parameterizedFromJson", "type2", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJson", DeviceRequestsHelper.DEVICE_INFO_MODEL, "(Ljava/lang/Object;)Ljava/lang/String;", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoJson {
    public static final KakaoJson INSTANCE = new KakaoJson();
    private static final Gson base;
    private static final GsonBuilder internalBuilder;
    private static final KakaoJson$kakaoExclusionStrategy$1 kakaoExclusionStrategy;
    private static final Gson pretty;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoJson() {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.kakao.sdk.common.util.KakaoJson$kakaoExclusionStrategy$1] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        ?? r0 = new ExclusionStrategy() { // from class: com.kakao.sdk.common.util.KakaoJson$kakaoExclusionStrategy$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.gson.ExclusionStrategy
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.gson.ExclusionStrategy
            public boolean shouldSkipField(FieldAttributes f) {
                Intrinsics.checkNotNull(f);
                return ((Exclude) f.getAnnotation(Exclude.class)) != null;
            }
        };
        kakaoExclusionStrategy = r0;
        GsonBuilder addDeserializationExclusionStrategy = new GsonBuilder().registerTypeAdapterFactory(new KakaoTypeAdapterFactory()).setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).addSerializationExclusionStrategy((ExclusionStrategy) r0).addDeserializationExclusionStrategy((ExclusionStrategy) r0);
        internalBuilder = addDeserializationExclusionStrategy;
        Gson create = addDeserializationExclusionStrategy.create();
        Intrinsics.checkNotNullExpressionValue(create, "internalBuilder.create()");
        base = create;
        Gson create2 = addDeserializationExclusionStrategy.setPrettyPrinting().create();
        Intrinsics.checkNotNullExpressionValue(create2, "internalBuilder.setPrettyPrinting().create()");
        pretty = create2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Gson getBase() {
        return base;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Gson getPretty() {
        return pretty;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> List<T> listFromJson(String string, Class<T> type) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(type, "type");
        Object fromJson = base.fromJson(string, TypeToken.getParameterized(List.class, type).getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "base.fromJson(string, Ty…::class.java, type).type)");
        return (List) fromJson;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> T parameterizedFromJson(String string, Type type1, Type type2) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(type1, "type1");
        Intrinsics.checkNotNullParameter(type2, "type2");
        return (T) base.fromJson(string, TypeToken.getParameterized(type1, type2).getType());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> String toJson(T model) {
        String json = base.toJson(model);
        Intrinsics.checkNotNullExpressionValue(json, "base.toJson(model)");
        return json;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> T fromJson(String string, Type type1) {
        Intrinsics.checkNotNullParameter(string, "string");
        Intrinsics.checkNotNullParameter(type1, "type1");
        return (T) base.fromJson(string, type1);
    }
}
