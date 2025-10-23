package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.CallAdapter;
import retrofit2.DefaultCallAdapterFactory;

/* loaded from: classes4.dex */
final class DefaultCallAdapterFactory extends CallAdapter.Factory {

    @Nullable
    private final Executor callbackExecutor;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DefaultCallAdapterFactory(@Nullable Executor executor) {
        this.callbackExecutor = executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (getRawType(type) != Call.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        }
        final Type parameterUpperBound = Utils.getParameterUpperBound(0, (ParameterizedType) type);
        final Executor executor = Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class) ? null : this.callbackExecutor;
        return new CallAdapter<Object, Call<?>>() { // from class: retrofit2.DefaultCallAdapterFactory.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.CallAdapter
            public Type responseType() {
                return parameterUpperBound;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.CallAdapter
            public Call<?> adapt(Call<Object> call) {
                return executor == null ? call : new ExecutorCallbackCall(executor, call);
            }
        };
    }

    static final class ExecutorCallbackCall<T> implements Call<T> {
        final Executor callbackExecutor;
        final Call<T> delegate;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ExecutorCallbackCall(Executor executor, Call<T> call) {
            this.callbackExecutor = executor;
            this.delegate = call;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public void enqueue(Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            this.delegate.enqueue(new C29291(callback));
        }

        /* renamed from: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1 */
        class C29291 implements Callback<T> {
            final /* synthetic */ Callback val$callback;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            C29291(Callback callback) {
                this.val$callback = callback;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onResponse(Call<T> call, final Response<T> response) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.C29291.this.m903xddacc936(callback, response);
                    }
                });
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: lambda$onResponse$0$retrofit2-DefaultCallAdapterFactory$ExecutorCallbackCall$1 */
            /* synthetic */ void m903xddacc936(Callback callback, Response response) {
                if (ExecutorCallbackCall.this.delegate.isCanceled()) {
                    callback.onFailure(ExecutorCallbackCall.this, new IOException("Canceled"));
                } else {
                    callback.onResponse(ExecutorCallbackCall.this, response);
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: lambda$onFailure$1$retrofit2-DefaultCallAdapterFactory$ExecutorCallbackCall$1 */
            /* synthetic */ void m902x714e864(Callback callback, Throwable th) {
                callback.onFailure(ExecutorCallbackCall.this, th);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call, final Throwable th) {
                Executor executor = ExecutorCallbackCall.this.callbackExecutor;
                final Callback callback = this.val$callback;
                executor.execute(new Runnable() { // from class: retrofit2.DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultCallAdapterFactory.ExecutorCallbackCall.C29291.this.m902x714e864(callback, th);
                    }
                });
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public Response<T> execute() throws IOException {
            return this.delegate.execute();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public Call<T> clone() {
            return new ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Call
        public Timeout timeout() {
            return this.delegate.timeout();
        }
    }
}
