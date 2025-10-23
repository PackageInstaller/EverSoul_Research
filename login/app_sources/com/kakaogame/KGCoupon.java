package com.kakaogame;

import android.app.Activity;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGCoupon.kt */
@Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J$\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/KGCoupon;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "initInterfaceBroker", "", "initialize", "showCouponPopup", "activity", "Landroid/app/Activity;", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGCoupon {
    public static final String CLASS_NAME_KEY = "KGCoupon";
    public static final KGCoupon INSTANCE = new KGCoupon();
    private static final String TAG = "KGCoupon";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGCoupon() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCouponPopup(Activity activity, KGResultCallback<Void> callback) {
        Logger.INSTANCE.m704i(y.ݮڮֲڭܩ(-628759164), y.ٲٴݴ״ٰ(1781845040));
        if (activity != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGCoupon$showCouponPopup$1(activity, callback, null), 3, null);
        } else if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159622887), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGCoupon$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Object runBlocking$default;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGCoupon$initInterfaceBroker$1$request$1(activity, null), 1, null);
                return (KGResult) runBlocking$default;
            }
        });
    }
}
