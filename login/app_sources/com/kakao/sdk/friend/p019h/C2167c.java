package com.kakao.sdk.friend.p019h;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.h.c */
/* loaded from: classes3.dex */
public final class C2167c {

    /* renamed from: a */
    public final List<Bitmap> f769a;

    /* renamed from: b */
    public final String f770b;

    /* renamed from: c */
    public final Function1<List<Bitmap>, Unit> f771c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2167c(List<Bitmap> list, String str, Function1<? super List<Bitmap>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f769a = list;
        this.f770b = str;
        this.f771c = callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2167c)) {
            return false;
        }
        C2167c c2167c = (C2167c) obj;
        return Intrinsics.areEqual(this.f769a, c2167c.f769a) && Intrinsics.areEqual(this.f770b, c2167c.f770b) && Intrinsics.areEqual(this.f771c, c2167c.f771c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        List<Bitmap> list = this.f769a;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.f770b;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f771c.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "MultiDecodingResult(bitmaps=" + this.f769a + ", error=" + ((Object) this.f770b) + ", callback=" + this.f771c + ')';
    }
}
