package com.kakao.sdk.network;

import com.kakao.sdk.common.json.IntDate;
import com.kakao.sdk.common.json.MapToQuery;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.Utility;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* compiled from: KakaoRetrofitConverterFactory.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, m839d2 = {"Lcom/kakao/sdk/network/KakaoRetrofitConverterFactory;", "Lretrofit2/Converter$Factory;", "()V", "stringConverter", "Lretrofit2/Converter;", "", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "network_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoRetrofitConverterFactory extends Converter.Factory {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Converter.Factory
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        if (Intrinsics.areEqual(type, String.class)) {
            return null;
        }
        if ((type instanceof Class) && ((Class) type).isEnum()) {
            return new Converter() { // from class: com.kakao.sdk.network.KakaoRetrofitConverterFactory$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // retrofit2.Converter
                public final Object convert(Object obj) {
                    String m1215stringConverter$lambda0;
                    m1215stringConverter$lambda0 = KakaoRetrofitConverterFactory.m1215stringConverter$lambda0((Enum) obj);
                    return m1215stringConverter$lambda0;
                }
            };
        }
        int i = 0;
        if (Intrinsics.areEqual(type, Date.class)) {
            ArrayList arrayList = new ArrayList();
            int length = annotations.length;
            int i2 = 0;
            while (i2 < length) {
                Annotation annotation = annotations[i2];
                i2++;
                if (annotation instanceof IntDate) {
                    arrayList.add(annotation);
                }
            }
            if (((IntDate) CollectionsKt.firstOrNull((List) arrayList)) != null) {
                return new Converter() { // from class: com.kakao.sdk.network.KakaoRetrofitConverterFactory$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // retrofit2.Converter
                    public final Object convert(Object obj) {
                        String m1216stringConverter$lambda2$lambda1;
                        m1216stringConverter$lambda2$lambda1 = KakaoRetrofitConverterFactory.m1216stringConverter$lambda2$lambda1((Date) obj);
                        return m1216stringConverter$lambda2$lambda1;
                    }
                };
            }
        }
        if ((type instanceof ParameterizedType) && Intrinsics.areEqual(((ParameterizedType) type).getRawType(), Map.class)) {
            ArrayList arrayList2 = new ArrayList();
            int length2 = annotations.length;
            while (i < length2) {
                Annotation annotation2 = annotations[i];
                i++;
                if (annotation2 instanceof MapToQuery) {
                    arrayList2.add(annotation2);
                }
            }
            if (((MapToQuery) CollectionsKt.firstOrNull((List) arrayList2)) != null) {
                return new Converter() { // from class: com.kakao.sdk.network.KakaoRetrofitConverterFactory$$ExternalSyntheticLambda2
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // retrofit2.Converter
                    public final Object convert(Object obj) {
                        String m1217stringConverter$lambda4$lambda3;
                        m1217stringConverter$lambda4$lambda3 = KakaoRetrofitConverterFactory.m1217stringConverter$lambda4$lambda3((Map) obj);
                        return m1217stringConverter$lambda4$lambda3;
                    }
                };
            }
        }
        return new Converter() { // from class: com.kakao.sdk.network.KakaoRetrofitConverterFactory$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Converter
            public final Object convert(Object obj) {
                String m1218stringConverter$lambda5;
                m1218stringConverter$lambda5 = KakaoRetrofitConverterFactory.m1218stringConverter$lambda5(obj);
                return m1218stringConverter$lambda5;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: stringConverter$lambda-0, reason: not valid java name */
    public static final String m1215stringConverter$lambda0(Enum r2) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        String json = KakaoJson.INSTANCE.toJson(r2);
        String substring = json.substring(1, json.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: stringConverter$lambda-2$lambda-1, reason: not valid java name */
    public static final String m1216stringConverter$lambda2$lambda1(Date value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return String.valueOf(value.getTime() / 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: stringConverter$lambda-4$lambda-3, reason: not valid java name */
    public static final String m1217stringConverter$lambda4$lambda3(Map map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return Utility.INSTANCE.buildQuery(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: stringConverter$lambda-5, reason: not valid java name */
    public static final String m1218stringConverter$lambda5(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return KakaoJson.INSTANCE.toJson(value);
    }
}
