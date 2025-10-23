package com.kakao.sdk.friend.p026o;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.PickerChatSelectionType;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p022k.EnumC2184d;

/* renamed from: com.kakao.sdk.friend.o.i */
/* loaded from: classes3.dex */
public final class C2234i extends ViewModel {

    /* renamed from: a */
    public int f983a;

    /* renamed from: b */
    public final String f984b;

    /* renamed from: c */
    public final boolean f985c;

    /* renamed from: d */
    public final boolean f986d;

    /* renamed from: e */
    public final MutableLiveData<Integer> f987e;

    /* renamed from: f */
    public final MutableLiveData<Boolean> f988f;

    /* renamed from: g */
    public final MutableLiveData<EnumC2184d> f989g;

    /* renamed from: h */
    public final MutableLiveData<EnumC2184d> f990h;

    /* renamed from: i */
    public final MutableLiveData<AbstractC2181a.d> f991i;

    /* renamed from: j */
    public final MutableLiveData<AbstractC2181a.d> f992j;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2234i() {
        InternalTabParams.InternalChatParams chatParams;
        C2171d m529a = C2171d.f793i.m529a();
        InternalTabParams m526e = m529a.m526e();
        this.f984b = m526e == null ? null : m526e.getTitle();
        this.f985c = m529a.m527f();
        InternalTabParams m526e2 = m529a.m526e();
        this.f986d = ((m526e2 != null && (chatParams = m526e2.getChatParams()) != null) ? chatParams.getSelectionType() : null) == PickerChatSelectionType.CHAT_MEMBER;
        this.f987e = new MutableLiveData<>();
        this.f988f = new MutableLiveData<>();
        this.f989g = new MutableLiveData<>();
        this.f990h = new MutableLiveData<>();
        this.f991i = new MutableLiveData<>(null);
        this.f992j = new MutableLiveData<>(null);
    }
}
