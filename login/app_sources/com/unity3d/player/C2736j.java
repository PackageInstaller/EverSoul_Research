package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnSuccessListener;

/* renamed from: com.unity3d.player.j */
/* loaded from: classes3.dex */
final class C2736j implements OnSuccessListener {

    /* renamed from: a */
    private IAssetPackManagerMobileDataConfirmationCallback f1390a;

    /* renamed from: b */
    private Looper f1391b = Looper.myLooper();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2736j(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f1390a = iAssetPackManagerMobileDataConfirmationCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        Integer num = (Integer) obj;
        if (this.f1390a != null) {
            new Handler(this.f1391b).post(new RunnableC2733i(this.f1390a, num.intValue() == -1));
        }
    }
}
