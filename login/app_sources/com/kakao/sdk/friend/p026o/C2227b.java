package com.kakao.sdk.friend.p026o;

import android.os.ResultReceiver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.kakao.sdk.friend.internal.InternalChatParams;
import com.kakao.sdk.friend.model.PickerChatSelectionType;
import com.kakao.sdk.friend.p015d.InterfaceC2137a;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p020i.C2171d;
import com.kakao.sdk.friend.p022k.AbstractC2181a;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import com.kakao.sdk.friend.p023l.C2196l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.o.b */
/* loaded from: classes3.dex */
public final class C2227b extends ViewModel {

    /* renamed from: a */
    public final InterfaceC2137a f938a;

    /* renamed from: b */
    public final ResultReceiver f939b;

    /* renamed from: c */
    public final InternalChatParams f940c;

    /* renamed from: d */
    public final List<AbstractC2170c> f941d;

    /* renamed from: e */
    public final List<AbstractC2168a.a> f942e;

    /* renamed from: f */
    public AbstractC2168a.a f943f;

    /* renamed from: g */
    public final MutableLiveData<List<AbstractC2170c>> f944g;

    /* renamed from: h */
    public final boolean f945h;

    /* renamed from: i */
    public final boolean f946i;

    /* renamed from: j */
    public final boolean f947j;

    /* renamed from: k */
    public final String f948k;

    /* renamed from: l */
    public final boolean f949l;

    /* renamed from: m */
    public final MutableLiveData<AbstractC2182b> f950m;

    /* renamed from: n */
    public final C2196l<AbstractC2182b> f951n;

    /* renamed from: o */
    public final MutableLiveData<AbstractC2181a> f952o;

    /* renamed from: p */
    public String f953p;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2227b(InterfaceC2137a dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.f938a = dataSource;
        C2171d m529a = C2171d.f793i.m529a();
        this.f939b = m529a.m525d();
        InternalChatParams m523b = m529a.m523b();
        Intrinsics.checkNotNull(m523b);
        this.f940c = m523b;
        this.f941d = new ArrayList();
        this.f942e = new ArrayList();
        this.f944g = new MutableLiveData<>();
        this.f945h = m529a.m527f();
        this.f946i = m523b.getSelectionType() == PickerChatSelectionType.CHAT_MEMBER;
        this.f947j = m529a.m526e() != null;
        this.f948k = m523b.getTitle();
        this.f949l = m523b.getEnableSearch();
        this.f950m = new MutableLiveData<>();
        this.f951n = new C2196l<>();
        this.f952o = new MutableLiveData<>();
        this.f953p = "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m666a() {
        Object obj;
        AbstractC2168a.a aVar = this.f943f;
        if (aVar != null) {
            Iterator<T> it = this.f941d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual((AbstractC2170c) obj, aVar)) {
                        break;
                    }
                }
            }
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.kakao.sdk.friend.internal.ChatItem.Chat");
            }
            ((AbstractC2168a.a) obj).f779h = false;
            this.f950m.setValue(new AbstractC2182b.g(aVar));
        }
        this.f943f = null;
    }
}
