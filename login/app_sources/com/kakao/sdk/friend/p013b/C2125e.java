package com.kakao.sdk.friend.p013b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.kakao.sdk.friend.C2110R;
import com.kakao.sdk.friend.p014c.C2133g;
import com.kakao.sdk.friend.p016e.C2153l;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.view.SquircleImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.kakao.sdk.friend.b.e */
/* loaded from: classes3.dex */
public final class C2125e extends RecyclerView.Adapter<C2133g> {

    /* renamed from: a */
    public final List<AbstractC2169b.a> f643a;

    /* renamed from: b */
    public final Function1<AbstractC2169b.a, Unit> f644b;

    /* renamed from: c */
    public RecyclerView f645c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2125e(List<AbstractC2169b.a> pickedFriends, Function1<? super AbstractC2169b.a, Unit> removeFriendCallback) {
        Intrinsics.checkNotNullParameter(pickedFriends, "pickedFriends");
        Intrinsics.checkNotNullParameter(removeFriendCallback, "removeFriendCallback");
        this.f643a = pickedFriends;
        this.f644b = removeFriendCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f643a.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.f645c = recyclerView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(C2133g c2133g, int i) {
        C2133g holder = c2133g;
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.m486a(this.f643a.get(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public C2133g onCreateViewHolder(ViewGroup parent, int i) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(C2110R.layout.kakao_sdk_item_picked_friend, parent, false);
        int i2 = C2110R.id.delete_button_iv;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, i2);
        if (imageView != null) {
            i2 = C2110R.id.picked_nickname_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, i2);
            if (textView != null) {
                i2 = C2110R.id.profile_iv;
                SquircleImageView squircleImageView = (SquircleImageView) ViewBindings.findChildViewById(inflate, i2);
                if (squircleImageView != null) {
                    C2153l c2153l = new C2153l((ConstraintLayout) inflate, imageView, textView, squircleImageView);
                    Intrinsics.checkNotNullExpressionValue(c2153l, "inflate(inflater, parent, false)");
                    return new C2133g(c2153l, new C2124d(this));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }
}
