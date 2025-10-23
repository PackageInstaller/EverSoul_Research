package com.kakao.sdk.friend.p023l;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.l.l */
/* loaded from: classes3.dex */
public final class C2196l<T> extends MutableLiveData<T> {

    /* renamed from: a */
    public final AtomicBoolean f858a = new AtomicBoolean(false);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m563a(C2196l this$0, Observer observer, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (this$0.f858a.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner owner, final Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        super.observe(owner, new Observer() { // from class: com.kakao.sdk.friend.l.l$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                C2196l.m563a(C2196l.this, observer, obj);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t) {
        this.f858a.set(true);
        super.setValue(t);
    }
}
