package com.kakaogame.p029ui;

import android.app.Activity;
import com.kakaogame.KGCustomUI;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.util.MutexLock;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CustomUIManager.kt */
@Metadata(m838d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bJ\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m839d2 = {"Lcom/kakaogame/ui/CustomUIManager;", "", "()V", "uiAlertLock", "Lcom/kakaogame/util/MutexLock;", "", "uiHandlers", "", "Lcom/kakaogame/KGCustomUI$KGCustomAlertType;", "Lcom/kakaogame/KGCustomUI$KGShowCustomAlertHandler;", "hasCustomAlertHandler", "", "type", "onCustomUICallbackOnUnity", "", "action", "registerShowCustomAlertHandler", "handler", "showCustomUI", "activity", "Landroid/app/Activity;", "alert", "Lcom/kakaogame/KGCustomUI$KGCustomAlert;", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CustomUIManager {
    private static final String TAG = "CustomUIManager";
    private MutexLock<String> uiAlertLock;
    private final Map<KGCustomUI.KGCustomAlertType, KGCustomUI.KGShowCustomAlertHandler> uiHandlers = new LinkedHashMap();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void registerShowCustomAlertHandler(KGCustomUI.KGCustomAlertType type, KGCustomUI.KGShowCustomAlertHandler handler) {
        Intrinsics.checkNotNullParameter(type, y.ٲٴݴ״ٰ(1781623144));
        Intrinsics.checkNotNullParameter(handler, y.ٴسسݬߨ(1393099658));
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628283628), y.ٴسسݬߨ(1393103466) + type.name());
        this.uiHandlers.put(type, handler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasCustomAlertHandler(KGCustomUI.KGCustomAlertType type) {
        Intrinsics.checkNotNullParameter(type, y.ٲٴݴ״ٰ(1781623144));
        return this.uiHandlers.containsKey(type);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String showCustomUI(Activity activity, KGCustomUI.KGCustomAlert alert) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(alert, y.٬ݯح׭٩(576642510));
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628283628), y.ݬֲ֮ܲت(1512061015) + alert.toJSONString());
        this.uiAlertLock = null;
        this.uiAlertLock = MutexLock.INSTANCE.createLock();
        if (CoreManager.INSTANCE.getInstance().isUnity()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CustomUIManager$showCustomUI$1(alert, null), 3, null);
            MutexLock<String> mutexLock = this.uiAlertLock;
            Intrinsics.checkNotNull(mutexLock);
            MutexLock.lock$default(mutexLock, 0L, 1, null);
            MutexLock<String> mutexLock2 = this.uiAlertLock;
            Intrinsics.checkNotNull(mutexLock2);
            return mutexLock2.getContent();
        }
        if (CoreManager.INSTANCE.getInstance().isUnreal()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new CustomUIManager$showCustomUI$2(alert, null), 3, null);
            MutexLock<String> mutexLock3 = this.uiAlertLock;
            Intrinsics.checkNotNull(mutexLock3);
            MutexLock.lock$default(mutexLock3, 0L, 1, null);
            MutexLock<String> mutexLock4 = this.uiAlertLock;
            Intrinsics.checkNotNull(mutexLock4);
            return mutexLock4.getContent();
        }
        KGCustomUI.KGShowCustomAlertHandler kGShowCustomAlertHandler = this.uiHandlers.get(alert.getType());
        Intrinsics.checkNotNull(kGShowCustomAlertHandler);
        kGShowCustomAlertHandler.onShow(activity, alert, new KGCustomUI.KGCustomAlertCallback() { // from class: com.kakaogame.ui.CustomUIManager$showCustomUI$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGCustomUI.KGCustomAlertCallback
            public void onClick(String action) {
                MutexLock mutexLock5;
                MutexLock mutexLock6;
                mutexLock5 = CustomUIManager.this.uiAlertLock;
                Intrinsics.checkNotNull(mutexLock5);
                mutexLock5.setContent(action);
                mutexLock6 = CustomUIManager.this.uiAlertLock;
                Intrinsics.checkNotNull(mutexLock6);
                mutexLock6.unlock();
            }
        });
        MutexLock<String> mutexLock5 = this.uiAlertLock;
        Intrinsics.checkNotNull(mutexLock5);
        MutexLock.lock$default(mutexLock5, 0L, 1, null);
        MutexLock<String> mutexLock6 = this.uiAlertLock;
        Intrinsics.checkNotNull(mutexLock6);
        return mutexLock6.getContent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onCustomUICallbackOnUnity(String action) {
        MutexLock<String> mutexLock = this.uiAlertLock;
        Intrinsics.checkNotNull(mutexLock);
        mutexLock.setContent(action);
        MutexLock<String> mutexLock2 = this.uiAlertLock;
        Intrinsics.checkNotNull(mutexLock2);
        mutexLock2.unlock();
    }
}
