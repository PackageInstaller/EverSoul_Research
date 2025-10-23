package com.kakao.sdk.friend.p026o;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.kakao.sdk.friend.p015d.InterfaceC2137a;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.o.h */
/* loaded from: classes3.dex */
public final class C2233h implements ViewModelProvider.Factory {

    /* renamed from: a */
    public final InterfaceC2137a f981a;

    /* renamed from: b */
    public final boolean f982b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2233h(InterfaceC2137a dataSource, boolean z) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.f981a = dataSource;
        this.f982b = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(C2232g.class)) {
            return new C2232g(this.f981a, this.f982b);
        }
        throw new IllegalArgumentException();
    }
}
