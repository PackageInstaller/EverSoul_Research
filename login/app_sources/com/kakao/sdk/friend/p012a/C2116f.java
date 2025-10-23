package com.kakao.sdk.friend.p012a;

import android.content.Context;
import com.kakao.sdk.friend.internal.InternalTabParams;
import com.kakao.sdk.friend.model.SelectedChat;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Scope;
import com.kakao.sdk.user.model.ScopeInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.a.f */
/* loaded from: classes3.dex */
public final class C2116f extends Lambda implements Function2<ScopeInfo, Throwable, Unit> {

    /* renamed from: a */
    public final /* synthetic */ Function3<SelectedUsers, SelectedChat, Throwable, Unit> f614a;

    /* renamed from: b */
    public final /* synthetic */ Context f615b;

    /* renamed from: c */
    public final /* synthetic */ boolean f616c;

    /* renamed from: d */
    public final /* synthetic */ boolean f617d;

    /* renamed from: e */
    public final /* synthetic */ InternalTabParams f618e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2116f(Function3<? super SelectedUsers, ? super SelectedChat, ? super Throwable, Unit> function3, Context context, boolean z, boolean z2, InternalTabParams internalTabParams) {
        super(2);
        this.f614a = function3;
        this.f615b = context;
        this.f616c = z;
        this.f617d = z2;
        this.f618e = internalTabParams;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(ScopeInfo scopeInfo, Throwable th) {
        List<Scope> scopes;
        ScopeInfo scopeInfo2 = scopeInfo;
        Throwable th2 = th;
        List list = 0;
        list = 0;
        if (th2 != null) {
            this.f614a.invoke(null, null, th2);
        } else {
            Function3<SelectedUsers, SelectedChat, Throwable, Unit> callback = this.f614a;
            Intrinsics.checkNotNullParameter("Tab Picker", "message");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ResultReceiverC2117g resultReceiverC2117g = new ResultReceiverC2117g("Tab Picker");
            resultReceiverC2117g.setEmitter(callback);
            if (scopeInfo2 != null && (scopes = scopeInfo2.getScopes()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : scopes) {
                    Scope scope = (Scope) obj;
                    if (scope.getUsing() && !scope.getAgreed()) {
                        arrayList.add(obj);
                    }
                }
                list = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    list.add(((Scope) it.next()).getId());
                }
            }
            if (list == 0) {
                list = CollectionsKt.emptyList();
            }
            if (list.isEmpty()) {
                C2119i.m474a(C2119i.f619a, this.f615b, this.f616c, this.f617d, this.f618e, resultReceiverC2117g, this.f614a);
            } else {
                UserApiClient companion = UserApiClient.INSTANCE.getInstance();
                Context context = this.f615b;
                UserApiClient.loginWithNewScopes$default(companion, context, list, null, new C2115e(this.f614a, context, this.f616c, this.f617d, this.f618e, resultReceiverC2117g), 4, null);
            }
        }
        return Unit.INSTANCE;
    }
}
