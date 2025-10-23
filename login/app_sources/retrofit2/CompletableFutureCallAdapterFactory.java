package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;

/* loaded from: classes4.dex */
final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CompletableFutureCallAdapterFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
        if (getRawType(parameterUpperBound) != Response.class) {
            return new BodyCallAdapter(parameterUpperBound);
        }
        if (!(parameterUpperBound instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
    }

    private static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type responseType;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.CallAdapter
        public CompletableFuture<R> adapt(Call<R> call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new BodyCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        private class BodyCallback implements Callback<R> {
            private final CompletableFuture<R> future;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public BodyCallback(CompletableFuture<R> completableFuture) {
                this.future = completableFuture;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onResponse(Call<R> call, Response<R> response) {
                if (response.isSuccessful()) {
                    this.future.complete(response.body());
                } else {
                    this.future.completeExceptionally(new HttpException(response));
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }
        }
    }

    private static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type responseType;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.CallAdapter
        public CompletableFuture<Response<R>> adapt(Call<R> call) {
            CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new ResponseCallback(callCancelCompletableFuture));
            return callCancelCompletableFuture;
        }

        private class ResponseCallback implements Callback<R> {
            private final CompletableFuture<Response<R>> future;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public ResponseCallback(CompletableFuture<Response<R>> completableFuture) {
                this.future = completableFuture;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onResponse(Call<R> call, Response<R> response) {
                this.future.complete(response);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onFailure(Call<R> call, Throwable th) {
                this.future.completeExceptionally(th);
            }
        }
    }

    private static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        private final Call<?> call;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        CallCancelCompletableFuture(Call<?> call) {
            this.call = call;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (z) {
                this.call.cancel();
            }
            return super.cancel(z);
        }
    }
}
