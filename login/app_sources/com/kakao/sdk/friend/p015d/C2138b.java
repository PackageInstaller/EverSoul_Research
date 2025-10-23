package com.kakao.sdk.friend.p015d;

import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.friend.model.PickerChatFilter;
import com.kakao.sdk.friend.model.PickerFriendFilter;
import com.kakao.sdk.friend.model.PickerServiceTypeFilter;
import com.kakao.sdk.friend.network.model.C2225Me;
import com.kakao.sdk.friend.network.model.PickerChat;
import com.kakao.sdk.friend.network.model.PickerChatMembers;
import com.kakao.sdk.friend.network.model.PickerChats;
import com.kakao.sdk.friend.network.model.PickerFriend;
import com.kakao.sdk.friend.network.model.PickerScopeGroup;
import com.kakao.sdk.friend.network.model.PickerUserScope;
import com.kakao.sdk.friend.network.model.PickerUsers;
import com.kakao.sdk.friend.p021j.InterfaceC2179b;
import com.kakao.sdk.friend.p021j.InterfaceC2180c;
import com.kakao.sdk.network.ApiCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.d.b */
/* loaded from: classes3.dex */
public final class C2138b implements InterfaceC2137a {

    /* renamed from: a */
    public final InterfaceC2179b f668a;

    /* renamed from: b */
    public final InterfaceC2180c f669b;

    /* renamed from: c */
    public List<PickerFriend> f670c;

    /* renamed from: d */
    public C2225Me f671d;

    /* renamed from: e */
    public List<PickerChat> f672e;

    /* renamed from: f */
    public PickerChatMembers f673f;

    /* renamed from: g */
    public boolean f674g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2138b(InterfaceC2179b friendApi, InterfaceC2180c scopesApi) {
        Intrinsics.checkNotNullParameter(friendApi, "friendApi");
        Intrinsics.checkNotNullParameter(scopesApi, "scopesApi");
        this.f668a = friendApi;
        this.f669b = scopesApi;
        this.f670c = new ArrayList();
        this.f672e = new ArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: a */
    public C2225Me mo491a() {
        return this.f671d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: a */
    public void mo494a(PickerScopeGroup scopeGroup, List<Long> targetIds, Function2<? super List<PickerUserScope>, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(scopeGroup, "scopeGroup");
        Intrinsics.checkNotNullParameter(targetIds, "targetIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f669b.m535a(scopeGroup, KakaoJson.INSTANCE.toJson(targetIds)).enqueue(new a(callback));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: b */
    public boolean mo496b() {
        return this.f674g;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: c */
    public List<PickerChat> mo497c() {
        return this.f672e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: d */
    public PickerChatMembers mo498d() {
        return this.f673f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: e */
    public List<PickerFriend> mo499e() {
        return this.f670c;
    }

    /* renamed from: com.kakao.sdk.friend.d.b$a */
    public static final class a extends ApiCallback<List<? extends PickerUserScope>> {

        /* renamed from: a */
        public final /* synthetic */ Function2<List<PickerUserScope>, Throwable, Unit> f675a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public a(Function2<? super List<PickerUserScope>, ? super Throwable, Unit> function2) {
            super(false);
            this.f675a = function2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakao.sdk.network.ApiCallback
        public void onComplete(List<? extends PickerUserScope> list, Throwable th) {
            this.f675a.invoke(list, th);
        }
    }

    /* renamed from: com.kakao.sdk.friend.d.b$b */
    public static final class b extends Lambda implements Function2<PickerChatMembers, Throwable, Unit> {

        /* renamed from: a */
        public final /* synthetic */ Function1<Throwable, Unit> f676a;

        /* renamed from: b */
        public final /* synthetic */ C2138b f677b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public b(Function1<? super Throwable, Unit> function1, C2138b c2138b) {
            super(2);
            this.f676a = function1;
            this.f677b = c2138b;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(PickerChatMembers pickerChatMembers, Throwable th) {
            PickerChatMembers pickerChatMembers2 = pickerChatMembers;
            Throwable th2 = th;
            if (th2 != null) {
                this.f676a.invoke(th2);
            } else if (pickerChatMembers2 != null) {
                this.f677b.f673f = pickerChatMembers2;
                this.f676a.invoke(null);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.kakao.sdk.friend.d.b$c */
    public static final class c extends Lambda implements Function2<PickerChats, Throwable, Unit> {

        /* renamed from: a */
        public final /* synthetic */ Function1<Throwable, Unit> f678a;

        /* renamed from: b */
        public final /* synthetic */ C2138b f679b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public c(Function1<? super Throwable, Unit> function1, C2138b c2138b) {
            super(2);
            this.f678a = function1;
            this.f679b = c2138b;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(PickerChats pickerChats, Throwable th) {
            List<PickerChat> m643a;
            PickerChats pickerChats2 = pickerChats;
            Throwable th2 = th;
            if (th2 != null) {
                this.f678a.invoke(th2);
            } else if (pickerChats2 != null && (m643a = pickerChats2.m643a()) != null) {
                C2138b c2138b = this.f679b;
                Function1<Throwable, Unit> function1 = this.f678a;
                c2138b.f672e.addAll(m643a);
                function1.invoke(null);
            }
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.kakao.sdk.friend.d.b$d */
    public static final class d extends Lambda implements Function2<PickerUsers, Throwable, Unit> {

        /* renamed from: a */
        public final /* synthetic */ Function1<Throwable, Unit> f680a;

        /* renamed from: b */
        public final /* synthetic */ C2138b f681b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public d(Function1<? super Throwable, Unit> function1, C2138b c2138b) {
            super(2);
            this.f680a = function1;
            this.f681b = c2138b;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(PickerUsers pickerUsers, Throwable th) {
            PickerUsers pickerUsers2 = pickerUsers;
            Throwable th2 = th;
            if (th2 != null) {
                this.f680a.invoke(th2);
            } else if (pickerUsers2 != null) {
                this.f681b.f674g = pickerUsers2.m663a();
                List<PickerFriend> m658a = pickerUsers2.m664b().m658a();
                if (m658a != null) {
                    C2138b c2138b = this.f681b;
                    Function1<Throwable, Unit> function1 = this.f680a;
                    c2138b.f670c.addAll(m658a);
                    c2138b.f671d = pickerUsers2.m665c();
                    function1.invoke(null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: a */
    public void mo492a(long j, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f668a.m532a(j).enqueue(new C2139c(this, new b(callback, this)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: a */
    public void mo495a(List<? extends PickerChatFilter> list, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f668a.m534a(list == null ? null : CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null), 10000).enqueue(new C2140d(new c(callback, this)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakao.sdk.friend.p015d.InterfaceC2137a
    /* renamed from: a */
    public void mo493a(PickerServiceTypeFilter serviceTypeFilter, PickerFriendFilter friendFilter, List<String> list, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(serviceTypeFilter, "serviceTypeFilter");
        Intrinsics.checkNotNullParameter(friendFilter, "friendFilter");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f668a.m533a(serviceTypeFilter, friendFilter, 10000, list == null ? null : CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null)).enqueue(new C2141e(new d(callback, this)));
    }
}
