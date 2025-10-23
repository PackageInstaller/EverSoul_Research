package com.kakao.sdk.friend.p017f;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.LruCache;
import android.widget.ImageView;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.friend.p019h.C2165a;
import com.kakao.sdk.friend.p019h.C2166b;
import com.kakao.sdk.friend.p019h.C2167c;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.f.c */
/* loaded from: classes3.dex */
public final class C2159c {

    /* renamed from: d */
    public static File f747d;

    /* renamed from: e */
    public static LruCache<String, Bitmap> f748e;

    /* renamed from: a */
    public final ExecutorService f751a;

    /* renamed from: b */
    public C2157a f752b;

    /* renamed from: c */
    public static final c f746c = new c();

    /* renamed from: f */
    public static final Lazy<C2159c> f749f = LazyKt.lazy(a.f753a);

    /* renamed from: g */
    public static final Handler f750g = new b(Looper.getMainLooper());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2159c() {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Intrinsics.checkNotNullExpressionValue(newCachedThreadPool, "newCachedThreadPool()");
        this.f751a = newCachedThreadPool;
        this.f752b = new C2157a(f750g);
    }

    /* renamed from: com.kakao.sdk.friend.f.c$a */
    public static final class a extends Lambda implements Function0<C2159c> {

        /* renamed from: a */
        public static final a f753a = new a();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public C2159c invoke() {
            return new C2159c();
        }
    }

    /* renamed from: com.kakao.sdk.friend.f.c$b */
    public static final class b extends Handler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            C2167c c2167c;
            List<Bitmap> list;
            c cVar;
            C2165a c2165a;
            Bitmap bitmap;
            Intrinsics.checkNotNullParameter(msg, "msg");
            int i = msg.what;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                Object obj = msg.obj;
                if (obj instanceof C2166b) {
                    SdkLog.INSTANCE.m470e(Intrinsics.stringPlus("Image Loading failed: ", ((C2166b) obj).f767b));
                    return;
                }
                list = null;
                bitmap = null;
                if (obj instanceof C2165a) {
                    c2165a = (C2165a) obj;
                    SdkLog.INSTANCE.m470e(Intrinsics.stringPlus("Image Loading failed: ", c2165a.f764b));
                    cVar = C2159c.f746c;
                    cVar.m518a(bitmap, c2165a.f765c);
                    return;
                }
                if (obj instanceof C2167c) {
                    c2167c = (C2167c) obj;
                    SdkLog.INSTANCE.m470e(Intrinsics.stringPlus("Image Loading failed: ", c2167c.f770b));
                    c cVar2 = C2159c.f746c;
                    Function1<List<Bitmap>, Unit> callback = c2167c.f771c;
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    callback.invoke(list);
                }
                return;
            }
            Object obj2 = msg.obj;
            if (obj2 instanceof C2166b) {
                c cVar3 = C2159c.f746c;
                C2166b c2166b = (C2166b) obj2;
                ImageView imageView = c2166b.f768c;
                Bitmap bitmap2 = c2166b.f766a;
                if (imageView == null) {
                    throw new NullPointerException("target view is null");
                }
                if (bitmap2 == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap2);
                return;
            }
            if (obj2 instanceof C2165a) {
                cVar = C2159c.f746c;
                c2165a = (C2165a) obj2;
                bitmap = c2165a.f763a;
                cVar.m518a(bitmap, c2165a.f765c);
                return;
            }
            if (obj2 instanceof C2167c) {
                c cVar4 = C2159c.f746c;
                c2167c = (C2167c) obj2;
                list = c2167c.f769a;
                Function1<List<Bitmap>, Unit> callback2 = c2167c.f771c;
                Intrinsics.checkNotNullParameter(callback2, "callback");
                callback2.invoke(list);
            }
        }
    }

    /* renamed from: com.kakao.sdk.friend.f.c$c */
    public static final class c {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: a */
        public final File m517a() {
            File file = C2159c.f747d;
            if (file != null) {
                return file;
            }
            Intrinsics.throwUninitializedPropertyAccessException("diskCache");
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        /* renamed from: a */
        public final void m518a(Bitmap bitmap, Function1<? super Bitmap, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            callback.invoke(bitmap);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        /* renamed from: a */
        public final C2159c m516a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (C2159c.f748e == null) {
                C2159c.f748e = new LruCache<>(C2160d.m519a(context));
            }
            if (C2159c.f747d == null) {
                File file = new File(context.getApplicationContext().getCacheDir(), "image-loader-cache");
                Intrinsics.checkNotNullParameter(file, "<set-?>");
                C2159c.f747d = file;
                if (!m517a().exists()) {
                    m517a().mkdirs();
                }
            }
            return C2159c.f749f.getValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        /* renamed from: a */
        public final Bitmap m514a(String imageUrl) {
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            LruCache<String, Bitmap> lruCache = C2159c.f748e;
            if (lruCache == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoryCache");
                lruCache = null;
            }
            return lruCache.get(imageUrl);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        /* renamed from: a */
        public final Bitmap m515a(String imageUrl, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            LruCache<String, Bitmap> lruCache = C2159c.f748e;
            if (lruCache == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoryCache");
                lruCache = null;
            }
            return lruCache.put(imageUrl, bitmap);
        }
    }
}
