package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes4.dex */
final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OptionalConverterFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }

    static final class OptionalConverter<T> implements Converter<ResponseBody, Optional<T>> {
        final Converter<ResponseBody, T> delegate;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        OptionalConverter(Converter<ResponseBody, T> converter) {
            this.delegate = converter;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Converter
        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.delegate.convert(responseBody));
        }
    }
}
