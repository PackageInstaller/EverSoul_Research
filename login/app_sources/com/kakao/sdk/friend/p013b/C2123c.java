package com.kakao.sdk.friend.p013b;

import androidx.recyclerview.widget.DiffUtil;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p020i.AbstractC2170c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.b.c */
/* loaded from: classes3.dex */
public final class C2123c extends DiffUtil.Callback {

    /* renamed from: a */
    public List<? extends AbstractC2170c> f640a;

    /* renamed from: b */
    public List<? extends AbstractC2170c> f641b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        List<? extends AbstractC2170c> list = this.f640a;
        List<? extends AbstractC2170c> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldList");
            list = null;
        }
        int hashCode = list.get(i).hashCode();
        List<? extends AbstractC2170c> list3 = this.f641b;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newList");
        } else {
            list2 = list3;
        }
        return hashCode == list2.get(i2).hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        List<? extends AbstractC2170c> list = this.f641b;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newList");
            list = null;
        }
        return list.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        List<? extends AbstractC2170c> list = this.f640a;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldList");
            list = null;
        }
        return list.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        List<? extends AbstractC2170c> list = this.f640a;
        List<? extends AbstractC2170c> list2 = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("oldList");
            list = null;
        }
        AbstractC2170c abstractC2170c = list.get(i);
        List<? extends AbstractC2170c> list3 = this.f641b;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newList");
        } else {
            list2 = list3;
        }
        AbstractC2170c abstractC2170c2 = list2.get(i2);
        if (abstractC2170c instanceof AbstractC2170c.c) {
            if (abstractC2170c2 instanceof AbstractC2170c.c) {
                return Intrinsics.areEqual(((AbstractC2170c.c) abstractC2170c).f792a, ((AbstractC2170c.c) abstractC2170c2).f792a);
            }
            return false;
        }
        if (abstractC2170c instanceof AbstractC2170c.a) {
            return abstractC2170c2 instanceof AbstractC2170c.a;
        }
        if (abstractC2170c instanceof AbstractC2170c.b) {
            return abstractC2170c2 instanceof AbstractC2170c.b;
        }
        if (!(abstractC2170c instanceof AbstractC2169b.a)) {
            return (abstractC2170c instanceof AbstractC2168a.a) && (abstractC2170c2 instanceof AbstractC2168a.a) && ((AbstractC2168a.a) abstractC2170c).f772a == ((AbstractC2168a.a) abstractC2170c2).f772a;
        }
        if (abstractC2170c2 instanceof AbstractC2169b.a) {
            return Intrinsics.areEqual(((AbstractC2169b.a) abstractC2170c).f782b, ((AbstractC2169b.a) abstractC2170c2).f782b);
        }
        return false;
    }
}
