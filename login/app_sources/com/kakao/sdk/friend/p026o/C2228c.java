package com.kakao.sdk.friend.p026o;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.kakao.sdk.friend.p015d.InterfaceC2137a;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.o.c */
/* loaded from: classes3.dex */
public final class C2228c implements ViewModelProvider.Factory {

    /* renamed from: a */
    public final InterfaceC2137a f954a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2228c(InterfaceC2137a dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.f954a = dataSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(C2227b.class)) {
            return new C2227b(this.f954a);
        }
        throw new IllegalArgumentException();
    }
}
