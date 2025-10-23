package com.kakao.sdk.friend.p018g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.kakao.sdk.friend.p017f.C2157a;
import com.kakao.sdk.friend.p017f.C2159c;
import com.kakao.sdk.friend.p019h.C2166b;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* renamed from: com.kakao.sdk.friend.g.d */
/* loaded from: classes3.dex */
public final class RunnableC2164d implements Runnable {

    /* renamed from: a */
    public final ImageView f760a;

    /* renamed from: b */
    public final String f761b;

    /* renamed from: c */
    public final C2157a f762c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC2164d(ImageView target, String imageUrl, C2157a downloader) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        this.f760a = target;
        this.f761b = imageUrl;
        this.f762c = downloader;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        Handler handler;
        Message obtainMessage;
        C2157a c2157a = this.f762c;
        ImageView target = this.f760a;
        String imageUrl = this.f761b;
        c2157a.getClass();
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Response<ResponseBody> execute = c2157a.f737c.m520a(imageUrl).execute();
        if (execute.isSuccessful()) {
            ResponseBody body = execute.body();
            if (body == null) {
                return;
            }
            Bitmap bitmap = BitmapFactory.decodeStream(body.byteStream());
            C2166b c2166b = new C2166b(bitmap, null, target);
            C2159c.c cVar = C2159c.f746c;
            if (!Intrinsics.areEqual(cVar.m514a(imageUrl), bitmap)) {
                Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                cVar.m515a(imageUrl, bitmap);
            }
            handler = c2157a.f735a;
            obtainMessage = handler.obtainMessage(1, c2166b);
        } else {
            C2166b c2166b2 = new C2166b(null, execute.message(), target);
            handler = c2157a.f735a;
            obtainMessage = handler.obtainMessage(2, c2166b2);
        }
        handler.sendMessage(obtainMessage);
    }
}
