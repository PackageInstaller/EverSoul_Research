package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.OkHttpCall;

/* loaded from: classes4.dex */
public final class Response<T> {

    @Nullable
    private final T body;

    @Nullable
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> success(@Nullable T t) {
        return success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> success(int i, @Nullable T t) {
        if (i < 200 || i >= 300) {
            throw new IllegalArgumentException("code < 200 or >= 300: " + i);
        }
        return success(t, new Response.Builder().code(i).message("Response.success()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> success(@Nullable T t, Headers headers) {
        Objects.requireNonNull(headers, "headers == null");
        return success(t, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> success(@Nullable T t, okhttp3.Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse must be successful response");
        }
        return new Response<>(response, t, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> error(int i, ResponseBody responseBody) {
        Objects.requireNonNull(responseBody, "body == null");
        if (i < 400) {
            throw new IllegalArgumentException("code < 400: " + i);
        }
        return error(responseBody, new Response.Builder().body(new OkHttpCall.NoContentResponseBody(responseBody.contentType(), responseBody.contentLength())).code(i).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Response<T> error(ResponseBody responseBody, okhttp3.Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new Response<>(response, null, responseBody);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Response(okhttp3.Response response, @Nullable T t, @Nullable ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t;
        this.errorBody = responseBody;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public okhttp3.Response raw() {
        return this.rawResponse;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int code() {
        return this.rawResponse.code();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String message() {
        return this.rawResponse.message();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Headers headers() {
        return this.rawResponse.headers();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    public T body() {
        return this.body;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    public ResponseBody errorBody() {
        return this.errorBody;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.rawResponse.toString();
    }
}
