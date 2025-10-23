package com.kakao.sdk.friend.p014c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kakao.sdk.friend.p016e.C2151j;
import com.kakao.sdk.friend.p020i.AbstractC2168a;
import com.kakao.sdk.friend.p023l.C2185a;
import com.kakao.sdk.friend.p023l.C2195k;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* renamed from: com.kakao.sdk.friend.c.c */
/* loaded from: classes3.dex */
public final class C2129c extends RecyclerView.ViewHolder {

    /* renamed from: a */
    public final boolean f651a;

    /* renamed from: b */
    public final C2151j f652b;

    /* renamed from: c */
    public final Function1<AbstractC2168a.a, Unit> f653c;

    /* renamed from: d */
    public final Function1<AbstractC2168a.a, Unit> f654d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2129c(boolean z, C2151j binding, Function1<? super AbstractC2168a.a, Unit> checkCallback, Function1<? super AbstractC2168a.a, Unit> uncheckCallback) {
        super(binding.m507a());
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(checkCallback, "checkCallback");
        Intrinsics.checkNotNullParameter(uncheckCallback, "uncheckCallback");
        this.f651a = z;
        this.f652b = binding;
        this.f653c = checkCallback;
        this.f654d = uncheckCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final void m479a(C2151j this_bindRootView, C2129c this$0, AbstractC2168a.a chat, View view) {
        Intrinsics.checkNotNullParameter(this_bindRootView, "$this_bindRootView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chat, "$chat");
        (!this_bindRootView.f711b.isChecked() ? this$0.f653c : this$0.f654d).invoke(chat);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m483a(final C2151j c2151j, final AbstractC2168a.a aVar) {
        c2151j.f710a.setOnClickListener(new View.OnClickListener() { // from class: com.kakao.sdk.friend.c.c$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C2129c.m479a(C2151j.this, this, aVar, view);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final int m480a(AbstractC2168a.a aVar, int i) {
        int min;
        Integer num = aVar.f776e;
        if (num != null && num.intValue() == 1) {
            return 1;
        }
        Integer num2 = aVar.f776e;
        if (num2 != null && (min = Math.min(num2.intValue() - 1, 4)) > i) {
            return min - i;
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Bitmap m481a(Context context) {
        Integer valueOf = Integer.valueOf(Random.INSTANCE.nextInt());
        C2185a c2185a = C2185a.f829a;
        Intrinsics.checkNotNullParameter(context, "context");
        Integer valueOf2 = Integer.valueOf(valueOf == null ? 0 : valueOf.hashCode());
        Intrinsics.checkNotNullParameter(context, "context");
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), C2195k.m562a(Integer.valueOf(valueOf2 != null ? valueOf2.hashCode() : 0), context).resourceId);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(\n        …context).resourceId\n    )");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, 110, 110, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(\n    …eight,\n        true\n    )");
        return createScaledBitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final Bitmap m482a(Context context, AbstractC2168a.a aVar) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int m480a = m480a(aVar, 0);
        while (i < m480a) {
            i++;
            arrayList.add(m481a(context));
        }
        return C2185a.f829a.m537a(context, aVar.f772a, arrayList);
    }
}
