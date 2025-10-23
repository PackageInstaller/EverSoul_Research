package com.kakao.sdk.friend.p018g;

import android.graphics.Bitmap;
import com.kakao.sdk.friend.p017f.C2157a;
import com.kakao.sdk.friend.p017f.C2158b;
import com.kakao.sdk.friend.p017f.C2159c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* renamed from: com.kakao.sdk.friend.g.b */
/* loaded from: classes3.dex */
public final class RunnableC2162b implements Runnable {

    /* renamed from: a */
    public final List<String> f757a;

    /* renamed from: b */
    public final C2157a f758b;

    /* renamed from: c */
    public final Function1<List<Bitmap>, Unit> f759c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC2162b(List<String> imageUrls, C2157a downloader, Function1<? super List<Bitmap>, Unit> callback) {
        Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
        Intrinsics.checkNotNullParameter(downloader, "downloader");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f757a = imageUrls;
        this.f758b = downloader;
        this.f759c = callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        C2157a c2157a = this.f758b;
        List<String> imageUrls = this.f757a;
        Function1<List<Bitmap>, Unit> callback = this.f759c;
        c2157a.getClass();
        Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        List<Bitmap> apiResult = Collections.synchronizedList(new ArrayList());
        for (String str : imageUrls) {
            if (str == null) {
                atomicInteger.incrementAndGet();
                if (atomicInteger.get() == imageUrls.size()) {
                    Intrinsics.checkNotNullExpressionValue(apiResult, "apiResult");
                    c2157a.m513a(apiResult, callback);
                }
            } else {
                C2159c.c cVar = C2159c.f746c;
                if (cVar.m514a(str) != null) {
                    atomicInteger.incrementAndGet();
                    apiResult.add(cVar.m514a(str));
                    if (atomicInteger.get() == imageUrls.size()) {
                        Intrinsics.checkNotNullExpressionValue(apiResult, "apiResult");
                        c2157a.m513a(apiResult, callback);
                    }
                } else {
                    c2157a.f737c.m520a(str).enqueue(new C2158b(atomicInteger, apiResult, str, imageUrls, c2157a, callback, objectRef));
                    c2157a = c2157a;
                }
            }
        }
    }
}
