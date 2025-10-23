package com.kakao.sdk.friend.p018g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import com.kakao.sdk.friend.p017f.C2157a;
import com.kakao.sdk.friend.p017f.C2159c;
import com.kakao.sdk.friend.p019h.C2165a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* renamed from: com.kakao.sdk.friend.g.a */
/* loaded from: classes3.dex */
public final class RunnableC2161a implements Runnable {

    /* renamed from: a */
    public final String f754a;

    /* renamed from: b */
    public final C2157a f755b;

    /* renamed from: c */
    public final Function1<Bitmap, Unit> f756c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC2161a(String imageUrl, C2157a downloader, Function1<? super Bitmap, Unit> callback) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f754a = imageUrl;
        this.f755b = downloader;
        this.f756c = callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Message obtainMessage;
        C2157a c2157a = this.f755b;
        String imageUrl = this.f754a;
        Function1<Bitmap, Unit> callback = this.f756c;
        c2157a.getClass();
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Response<ResponseBody> execute = c2157a.f737c.m520a(imageUrl).execute();
        if (execute.isSuccessful()) {
            ResponseBody body = execute.body();
            if (body == null) {
                return;
            }
            Bitmap bitmap = BitmapFactory.decodeStream(body.byteStream());
            C2165a c2165a = new C2165a(bitmap, null, callback);
            C2159c.c cVar = C2159c.f746c;
            if (!Intrinsics.areEqual(cVar.m514a(imageUrl), bitmap)) {
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                cVar.m515a(imageUrl, bitmap);
            }
            handler = c2157a.f735a;
            obtainMessage = handler.obtainMessage(1, c2165a);
        } else {
            C2165a c2165a2 = new C2165a(null, execute.message(), callback);
            handler = c2157a.f735a;
            obtainMessage = handler.obtainMessage(2, c2165a2);
        }
        handler.sendMessage(obtainMessage);
    }
}
