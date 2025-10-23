package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* loaded from: classes4.dex */
class Platform {
    private static final Platform PLATFORM = findPlatform();
    private final boolean hasJava8Types;

    @Nullable
    private final Constructor<MethodHandles.Lookup> lookupConstructor;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    Executor defaultCallbackExecutor() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Platform get() {
        return PLATFORM;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Platform findPlatform() {
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            return new Android();
        }
        return new Platform(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Platform(boolean z) {
        this.hasJava8Types = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.lookupConstructor = constructor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        return this.hasJava8Types ? Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int defaultCallAdapterFactoriesSize() {
        return this.hasJava8Types ? 2 : 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    List<? extends Converter.Factory> defaultConverterFactories() {
        return this.hasJava8Types ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isDefaultMethod(Method method) {
        return this.hasJava8Types && method.isDefault();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.lookupConstructor;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    static final class Android extends Platform {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Android() {
            super(true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // retrofit2.Platform
        @Nullable
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT < 26) {
                throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
            }
            return super.invokeDefaultMethod(method, cls, obj, objArr);
        }

        static final class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            MainThreadExecutor() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }
    }
}
