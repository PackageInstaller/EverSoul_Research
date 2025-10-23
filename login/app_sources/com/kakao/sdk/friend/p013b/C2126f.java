package com.kakao.sdk.friend.p013b;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.kakao.sdk.friend.p024m.C2199b;
import com.kakao.sdk.friend.p024m.C2206i;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.b.f */
/* loaded from: classes3.dex */
public final class C2126f extends FragmentStateAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2126f(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int i) {
        if (i == 0) {
            return new C2206i();
        }
        if (i == 1) {
            return new C2199b();
        }
        throw new IllegalStateException("Tab Picker can only have two tabs. (FriendPicker, ChatPicker)");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 2;
    }
}
