package com.kakao.sdk.friend.p024m;

import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import com.kakao.sdk.friend.p022k.AbstractC2182b;
import com.kakao.sdk.friend.p026o.C2227b;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.kakao.sdk.friend.m.c */
/* loaded from: classes3.dex */
public final class C2200c extends Lambda implements Function1<AbstractC2168a.a, Unit> {

    /* renamed from: a */
    public final /* synthetic */ C2199b f873a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2200c(C2199b c2199b) {
        super(1);
        this.f873a = c2199b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(AbstractC2168a.a aVar) {
        Object obj;
        AbstractC2168a.a chat = aVar;
        Intrinsics.checkNotNullParameter(chat, "it");
        C2199b c2199b = this.f873a;
        int i = C2199b.f862h;
        C2227b m574d = c2199b.m574d();
        m574d.getClass();
        Intrinsics.checkNotNullParameter(chat, "chat");
        if (m574d.f943f != null) {
            m574d.m666a();
        }
        m574d.f943f = chat;
        Iterator<T> it = m574d.f941d.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((AbstractC2170c) obj, chat)) {
                break;
            }
        }
        if (obj != null) {
            ((AbstractC2168a.a) obj).f779h = true;
            m574d.f950m.setValue(new AbstractC2182b.a(chat));
            return Unit.INSTANCE;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.kakao.sdk.friend.internal.ChatItem.Chat");
    }
}
