package retrofit2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* loaded from: classes4.dex */
abstract class ParameterHandler<T> {
    abstract void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ParameterHandler() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() { // from class: retrofit2.ParameterHandler.1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, @Nullable Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    ParameterHandler.this.apply(requestBuilder, it.next());
                }
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() { // from class: retrofit2.ParameterHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.ParameterHandler
            void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
                }
            }
        };
    }

    static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;

        /* renamed from: p */
        private final int f1559p;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RelativeUrl(Method method, int i) {
            this.method = method;
            this.f1559p = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable Object obj) {
            if (obj == null) {
                throw Utils.parameterError(this.method, this.f1559p, "@Url parameter is null.", new Object[0]);
            }
            requestBuilder.setRelativeUrl(obj);
        }
    }

    static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Header(String str, Converter<T, String> converter) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addHeader(this.name, convert);
        }
    }

    static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;

        /* renamed from: p */
        private final int f1557p;
        private final Converter<T, String> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Path(Method method, int i, String str, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f1557p = i;
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t == null) {
                throw Utils.parameterError(this.method, this.f1557p, "Path parameter \"" + this.name + "\" value must not be null.", new Object[0]);
            }
            requestBuilder.addPathParam(this.name, this.valueConverter.convert(t), this.encoded);
        }
    }

    static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Query(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addQueryParam(this.name, convert, this.encoded);
        }
    }

    static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        QueryName(Converter<T, String> converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.addQueryParam(this.nameConverter.convert(t), null, this.encoded);
        }
    }

    static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p */
        private final int f1558p;
        private final Converter<T, String> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        QueryMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f1558p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f1558p, "Query map was null", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f1558p, "Query map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f1558p, "Query map contained null value for key '" + key + "'.", new Object[0]);
                }
                String convert = this.valueConverter.convert(value);
                if (convert == null) {
                    throw Utils.parameterError(this.method, this.f1558p, "Query map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addQueryParam(key, convert, this.encoded);
            }
        }
    }

    static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p */
        private final int f1553p;
        private final Converter<T, String> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        HeaderMap(Method method, int i, Converter<T, String> converter) {
            this.method = method;
            this.f1553p = i;
            this.valueConverter = converter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f1553p, "Header map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f1553p, "Header map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f1553p, "Header map contained null value for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addHeader(key, this.valueConverter.convert(value));
            }
        }
    }

    static final class Headers extends ParameterHandler<okhttp3.Headers> {
        private final Method method;

        /* renamed from: p */
        private final int f1554p;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Headers(Method method, int i) {
            this.method = method;
            this.f1554p = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable okhttp3.Headers headers) {
            if (headers == null) {
                throw Utils.parameterError(this.method, this.f1554p, "Headers parameter must not be null.", new Object[0]);
            }
            requestBuilder.addHeaders(headers);
        }
    }

    static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Field(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Objects.requireNonNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t == null || (convert = this.valueConverter.convert(t)) == null) {
                return;
            }
            requestBuilder.addFormField(this.name, convert, this.encoded);
        }
    }

    static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;

        /* renamed from: p */
        private final int f1552p;
        private final Converter<T, String> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FieldMap(Method method, int i, Converter<T, String> converter, boolean z) {
            this.method = method;
            this.f1552p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f1552p, "Field map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f1552p, "Field map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f1552p, "Field map contained null value for key '" + key + "'.", new Object[0]);
                }
                String convert = this.valueConverter.convert(value);
                if (convert == null) {
                    throw Utils.parameterError(this.method, this.f1552p, "Field map value '" + value + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addFormField(key, convert, this.encoded);
            }
        }
    }

    static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final okhttp3.Headers headers;
        private final Method method;

        /* renamed from: p */
        private final int f1555p;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Part(Method method, int i, okhttp3.Headers headers, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f1555p = i;
            this.headers = headers;
            this.converter = converter;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.addPart(this.headers, this.converter.convert(t));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, this.f1555p, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    static final class RawPart extends ParameterHandler<MultipartBody.Part> {
        static final RawPart INSTANCE = new RawPart();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private RawPart() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable MultipartBody.Part part) {
            if (part != null) {
                requestBuilder.addPart(part);
            }
        }
    }

    static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;

        /* renamed from: p */
        private final int f1556p;
        private final String transferEncoding;
        private final Converter<T, RequestBody> valueConverter;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        PartMap(Method method, int i, Converter<T, RequestBody> converter, String str) {
            this.method = method;
            this.f1556p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map == null) {
                throw Utils.parameterError(this.method, this.f1556p, "Part map was null.", new Object[0]);
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw Utils.parameterError(this.method, this.f1556p, "Part map contained null key.", new Object[0]);
                }
                T value = entry.getValue();
                if (value == null) {
                    throw Utils.parameterError(this.method, this.f1556p, "Part map contained null value for key '" + key + "'.", new Object[0]);
                }
                requestBuilder.addPart(okhttp3.Headers.m870of(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
            }
        }
    }

    static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, RequestBody> converter;
        private final Method method;

        /* renamed from: p */
        private final int f1551p;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Body(Method method, int i, Converter<T, RequestBody> converter) {
            this.method = method;
            this.f1551p = i;
            this.converter = converter;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) {
            if (t == null) {
                throw Utils.parameterError(this.method, this.f1551p, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.setBody(this.converter.convert(t));
            } catch (IOException e) {
                throw Utils.parameterError(this.method, e, this.f1551p, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    static final class Tag<T> extends ParameterHandler<T> {
        final Class<T> cls;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Tag(Class<T> cls) {
            this.cls = cls;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.ParameterHandler
        void apply(RequestBuilder requestBuilder, @Nullable T t) {
            requestBuilder.addTag(this.cls, t);
        }
    }
}
