package com.kakao.sdk.friend.p014c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.sdk.friend.p016e.C2153l;
import com.kakao.sdk.friend.p017f.C2157a;
import com.kakao.sdk.friend.p017f.C2159c;
import com.kakao.sdk.friend.p018g.RunnableC2164d;
import com.kakao.sdk.friend.p020i.AbstractC2169b;
import com.kakao.sdk.friend.p023l.C2195k;
import com.kakao.sdk.friend.view.SquircleImageView;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.kakao.sdk.friend.c.g */
/* loaded from: classes3.dex */
public final class C2133g extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public final C2153l f658a;

    /* renamed from: b */
    public final Function1<AbstractC2169b.a, Unit> f659b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2133g(C2153l binding, Function1<? super AbstractC2169b.a, Unit> removeFriendCallback) {
        super(binding.m509a());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(removeFriendCallback, "removeFriendCallback");
        this.f658a = binding;
        this.f659b = removeFriendCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m485a(C2133g this$0, AbstractC2169b.a user, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(user, "$user");
        this$0.f659b.invoke(user);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m486a(final AbstractC2169b.a user) {
        Intrinsics.checkNotNullParameter(user, "user");
        Integer valueOf = Integer.valueOf(user.f782b.hashCode());
        Context context = this.f658a.f721a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        int i = C2195k.m562a(valueOf, context).resourceId;
        String str = user.f784d;
        if (str == null || StringsKt.isBlank(str)) {
            this.f658a.f723c.setImageResource(i);
        } else {
            C2159c.c cVar = C2159c.f746c;
            Context context2 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            C2159c loader = cVar.m516a(context2);
            String str2 = user.f784d;
            loader.getClass();
            List imageUrls = CollectionsKt.listOf(str2);
            C2157a downloader = loader.f752b;
            Intrinsics.checkNotNullParameter(loader, "loader");
            Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
            Intrinsics.checkNotNullParameter(downloader, "downloader");
            SquircleImageView target = this.f658a.f723c;
            Intrinsics.checkNotNullExpressionValue(target, "binding.profileIv");
            Intrinsics.checkNotNullParameter(target, "target");
            if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                throw new IllegalStateException("Method call should happen from the main thread.");
            }
            if (i != 0) {
                target.setImageDrawable(ContextCompat.getDrawable(target.getContext(), i));
            }
            String str3 = (String) imageUrls.get(0);
            if (str3 != null) {
                Bitmap m514a = cVar.m514a(str3);
                if (m514a == null) {
                    RunnableC2164d action = new RunnableC2164d(target, str3, downloader);
                    Intrinsics.checkNotNullParameter(action, "action");
                    loader.f751a.submit(action);
                } else if (target != null) {
                    target.setImageBitmap(m514a);
                } else {
                    throw new NullPointerException("target view is null");
                }
            }
        }
        this.f658a.f722b.setText(user.f783c);
        this.f658a.f721a.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.sdk.friend.c.g$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2133g.m485a(C2133g.this, user, view);
            }
        });
    }
}
