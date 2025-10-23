package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* loaded from: classes4.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BuiltInConverters() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == ResponseBody.class) {
            if (Utils.isAnnotationPresent(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.INSTANCE;
            }
            return BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit || type != Unit.class) {
            return null;
        }
        try {
            return UnitResponseBodyConverter.INSTANCE;
        } catch (NoClassDefFoundError unused) {
            this.checkForKotlinUnit = false;
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (RequestBody.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    static final class VoidResponseBodyConverter implements Converter<ResponseBody, Void> {
        static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        VoidResponseBodyConverter() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Converter
        public Void convert(ResponseBody responseBody) {
            responseBody.close();
            return null;
        }
    }

    static final class UnitResponseBodyConverter implements Converter<ResponseBody, Unit> {
        static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        UnitResponseBodyConverter() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Converter
        public Unit convert(ResponseBody responseBody) {
            responseBody.close();
            return Unit.INSTANCE;
        }
    }

    static final class RequestBodyConverter implements Converter<RequestBody, RequestBody> {
        static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Converter
        public RequestBody convert(RequestBody requestBody) {
            return requestBody;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RequestBodyConverter() {
        }
    }

    static final class StreamingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Converter
        public ResponseBody convert(ResponseBody responseBody) {
            return responseBody;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        StreamingResponseBodyConverter() {
        }
    }

    static final class BufferingResponseBodyConverter implements Converter<ResponseBody, ResponseBody> {
        static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        BufferingResponseBodyConverter() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Converter
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            try {
                return Utils.buffer(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = new ToStringConverter();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ToStringConverter() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }
}
