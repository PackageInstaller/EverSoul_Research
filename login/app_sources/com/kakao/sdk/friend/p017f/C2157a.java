package com.kakao.sdk.friend.p017f;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.StatFs;
import com.kakao.sdk.friend.p017f.C2159c;
import com.kakao.sdk.friend.p018g.InterfaceC2163c;
import com.kakao.sdk.friend.p019h.C2167c;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* renamed from: com.kakao.sdk.friend.f.a */
/* loaded from: classes3.dex */
public final class C2157a {

    /* renamed from: a */
    public final Handler f735a;

    /* renamed from: b */
    public final Lazy f736b;

    /* renamed from: c */
    public final InterfaceC2163c f737c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2157a(Handler mainThreadHandler) {
        Intrinsics.checkNotNullParameter(mainThreadHandler, "mainThreadHandler");
        this.f735a = mainThreadHandler;
        this.f736b = LazyKt.lazy(a.f738a);
        this.f737c = (InterfaceC2163c) new Retrofit.Builder().client(m512a()).baseUrl("https://developers.kakao.com/").build().create(InterfaceC2163c.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final OkHttpClient m512a() {
        return (OkHttpClient) this.f736b.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m513a(List<Bitmap> list, Function1<? super List<Bitmap>, Unit> function1) {
        C2167c c2167c = new C2167c(list, null, function1);
        Handler handler = this.f735a;
        handler.sendMessage(handler.obtainMessage(1, c2167c));
    }

    /* renamed from: com.kakao.sdk.friend.f.a$a */
    public static final class a extends Lambda implements Function0<OkHttpClient> {

        /* renamed from: a */
        public static final a f738a = new a();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a() {
            super(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public OkHttpClient invoke() {
            long j;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            C2159c.c cVar = C2159c.f746c;
            File m517a = cVar.m517a();
            File dir = cVar.m517a();
            Intrinsics.checkNotNullParameter(dir, "dir");
            try {
                StatFs statFs = new StatFs(dir.getAbsolutePath());
                j = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
            } catch (IllegalArgumentException unused) {
                j = 5242880;
            }
            builder.cache(new Cache(m517a, Math.max(Math.min(j, 52428800L), 5242880L)));
            return builder.build();
        }
    }
}
