package com.kakao.sdk.friend.p019h;

import android.graphics.Bitmap;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.h.b */
/* loaded from: classes3.dex */
public final class C2166b {

    /* renamed from: a */
    public final Bitmap f766a;

    /* renamed from: b */
    public final String f767b;

    /* renamed from: c */
    public final ImageView f768c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2166b(Bitmap bitmap, String str, ImageView target) {
        Intrinsics.checkNotNullParameter(target, "target");
        this.f766a = bitmap;
        this.f767b = str;
        this.f768c = target;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2166b)) {
            return false;
        }
        C2166b c2166b = (C2166b) obj;
        return Intrinsics.areEqual(this.f766a, c2166b.f766a) && Intrinsics.areEqual(this.f767b, c2166b.f767b) && Intrinsics.areEqual(this.f768c, c2166b.f768c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        Bitmap bitmap = this.f766a;
        int hashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        String str = this.f767b;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f768c.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "DownloadResult(bitmap=" + this.f766a + ", error=" + ((Object) this.f767b) + ", target=" + this.f768c + ')';
    }
}
