package com.kakao.sdk.friend.p017f;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import com.kakao.sdk.friend.p017f.C2159c;
import com.kakao.sdk.friend.p019h.C2167c;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* renamed from: com.kakao.sdk.friend.f.b */
/* loaded from: classes3.dex */
public final class C2158b implements Callback<ResponseBody> {

    /* renamed from: a */
    public final /* synthetic */ AtomicInteger f739a;

    /* renamed from: b */
    public final /* synthetic */ List<Bitmap> f740b;

    /* renamed from: c */
    public final /* synthetic */ String f741c;

    /* renamed from: d */
    public final /* synthetic */ List<String> f742d;

    /* renamed from: e */
    public final /* synthetic */ C2157a f743e;

    /* renamed from: f */
    public final /* synthetic */ Function1<List<Bitmap>, Unit> f744f;

    /* renamed from: g */
    public final /* synthetic */ Ref.ObjectRef<C2167c> f745g;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2158b(AtomicInteger atomicInteger, List<Bitmap> list, String str, List<String> list2, C2157a c2157a, Function1<? super List<Bitmap>, Unit> function1, Ref.ObjectRef<C2167c> objectRef) {
        this.f739a = atomicInteger;
        this.f740b = list;
        this.f741c = str;
        this.f742d = list2;
        this.f743e = c2157a;
        this.f744f = function1;
        this.f745g = objectRef;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.kakao.sdk.friend.h.c] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Callback
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(t, "t");
        this.f739a.incrementAndGet();
        if (this.f739a.get() == this.f742d.size()) {
            this.f745g.element = new C2167c(null, t.getMessage(), this.f744f);
            Handler handler = this.f743e.f735a;
            handler.sendMessage(handler.obtainMessage(2, this.f745g.element));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // retrofit2.Callback
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        ResponseBody body;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        this.f739a.incrementAndGet();
        if (!response.isSuccessful() || (body = response.body()) == null) {
            return;
        }
        List<Bitmap> apiResult = this.f740b;
        String str = this.f741c;
        AtomicInteger atomicInteger = this.f739a;
        List<String> list = this.f742d;
        C2157a c2157a = this.f743e;
        Function1<List<Bitmap>, Unit> function1 = this.f744f;
        Bitmap bitmap = BitmapFactory.decodeStream(body.byteStream());
        apiResult.add(bitmap);
        C2159c.c cVar = C2159c.f746c;
        if (!Intrinsics.areEqual(cVar.m514a(str), bitmap)) {
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            cVar.m515a(str, bitmap);
        }
        if (atomicInteger.get() == list.size()) {
            Intrinsics.checkNotNullExpressionValue(apiResult, "apiResult");
            c2157a.m513a(apiResult, function1);
        }
    }
}
