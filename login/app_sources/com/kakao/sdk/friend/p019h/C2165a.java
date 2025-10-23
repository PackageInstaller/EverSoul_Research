package com.kakao.sdk.friend.p019h;

import android.graphics.Bitmap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.h.a */
/* loaded from: classes3.dex */
public final class C2165a {

    /* renamed from: a */
    public final Bitmap f763a;

    /* renamed from: b */
    public final String f764b;

    /* renamed from: c */
    public final Function1<Bitmap, Unit> f765c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2165a(Bitmap bitmap, String str, Function1<? super Bitmap, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f763a = bitmap;
        this.f764b = str;
        this.f765c = callback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2165a)) {
            return false;
        }
        C2165a c2165a = (C2165a) obj;
        return Intrinsics.areEqual(this.f763a, c2165a.f763a) && Intrinsics.areEqual(this.f764b, c2165a.f764b) && Intrinsics.areEqual(this.f765c, c2165a.f765c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Bitmap bitmap = this.f763a;
        int hashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        String str = this.f764b;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f765c.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "DecodingResult(bitmap=" + this.f763a + ", error=" + ((Object) this.f764b) + ", callback=" + this.f765c + ')';
    }
}
