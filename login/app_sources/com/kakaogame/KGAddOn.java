package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.addon.AddOnManager;
import com.kakaogame.addon.KGService;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGAddOn.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH\u0007J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0007J \u0010\u000e\u001a\u00020\u00062\u0016\u0010\t\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/KGAddOn;", "", "()V", "CLASS_NAME_KEY", "", "finishService", "", KGService.KEY_ID, "code", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "initInterfaceBroker", "initialize", "loadIncompleteServices", "", "Lcom/kakaogame/addon/KGService;", "kakaogame_addon_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGAddOn {
    private static final String CLASS_NAME_KEY = "KGAddOn";
    public static final KGAddOn INSTANCE = new KGAddOn();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGAddOn() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadIncompleteServices(KGResultCallback<List<KGService>> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGAddOn$loadIncompleteServices$1(callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void finishService(String keyId, String code, KGResultCallback<Void> callback) {
        Intrinsics.checkNotNullParameter(keyId, y.دײܮڳܯ(2051572045));
        Intrinsics.checkNotNullParameter(code, y.دײܮڳܯ(2051571757));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGAddOn$finishService$1(keyId, code, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862317123), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGAddOn$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                KGResult<List<KGService>> loadIncompleteOrders = AddOnManager.loadIncompleteOrders();
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159603143), y.٬ݯح׭٩(575817086), loadIncompleteOrders);
                if (loadIncompleteOrders.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loadIncompleteOrders);
                }
                JSONObject jSONObject = new JSONObject();
                List<KGService> content = loadIncompleteOrders.getContent();
                Intrinsics.checkNotNull(content);
                jSONObject.put(y.٬ݯح׭٩(575817278), content);
                return KGResult.INSTANCE.getSuccessResult(jSONObject);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862320019), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGAddOn$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter(KGService.KEY_ID);
                String str2 = (String) request.getParameter(y.دײܮڳܯ(2051571757));
                String str3 = str;
                if (str3 == null || str3.length() == 0) {
                    return KGResult.INSTANCE.getResult(KGResult.KGResultCode.INVALID_KEY_ID);
                }
                String str4 = str2;
                if (str4 == null || str4.length() == 0) {
                    return KGResult.INSTANCE.getResult(KGResult.KGResultCode.INVALID_CODE);
                }
                KGResult<Void> completeOrder = AddOnManager.completeOrder(str, str2);
                FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159603143), y.ٲٴݴ״ٰ(1781833624), completeOrder);
                if (completeOrder.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(completeOrder);
                }
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
    }
}
