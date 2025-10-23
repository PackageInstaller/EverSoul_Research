package com.kakaogame;

import android.app.Activity;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.promotion.EndingPromotionManager;
import com.kakaogame.promotion.StartingPromotionManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.MutexLock;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGPromotion.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J$\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rH\u0007J*\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rJ$\u0010\u0011\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m839d2 = {"Lcom/kakaogame/KGPromotion;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "initInterfaceBroker", "", "initialize", "showEndingPromotionPopups", "activity", "Landroid/app/Activity;", "callback", "Lcom/kakaogame/KGResultCallback;", "showPromotionPopup", ServerConstants.SEQ, "", "showStartingPromotionPopups", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGPromotion {
    private static final String CLASS_NAME_KEY = "KGPromotion";
    public static final KGPromotion INSTANCE = new KGPromotion();
    private static final String TAG = "KGPromotionUI";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGPromotion() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showStartingPromotionPopups(Activity activity, final KGResultCallback<String> callback) {
        KGResult<String> successResult;
        Logger.INSTANCE.m704i(y.ۮڭڭܬި(862452227), y.٬ݯح׭٩(575676534));
        final FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.ٴسسݬߨ(1392765786), y.ۮڭڭܬި(862424075));
        if (activity == null) {
            successResult = KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106));
        } else if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.promotion)) {
            successResult = KGResult.INSTANCE.getResult(5001);
        } else {
            StartingPromotionManager.INSTANCE.showStartPromotions(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGPromotion$showStartingPromotionPopups$result$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    Logger.INSTANCE.m704i(y.ۮڭڭܬި(862452227), y.֬ڱܱײٮ(-1159483007) + result);
                    KGResultCallback<String> kGResultCallback = callback;
                    if (kGResultCallback != null) {
                        kGResultCallback.onResult(result);
                    }
                    firebaseEvent.setResult(result);
                }
            });
            successResult = KGResult.INSTANCE.getSuccessResult();
        }
        if (successResult.isNotSuccess()) {
            if (callback != null) {
                callback.onResult(successResult);
            }
            firebaseEvent.setResult(successResult);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showPromotionPopup(Activity activity, int seq, final KGResultCallback<String> callback) {
        KGResult<String> successResult;
        Logger.INSTANCE.m704i(y.ۮڭڭܬި(862452227), y.ݮڮֲڭܩ(-628632972));
        final FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.ٴسسݬߨ(1392765786), y.ݬֲ֮ܲت(1512754511));
        if (activity == null) {
            successResult = KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106));
        } else if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.promotion)) {
            successResult = KGResult.INSTANCE.getResult(5001);
        } else {
            StartingPromotionManager.INSTANCE.showStartPromotion(activity, seq, new KGResultCallback<String>() { // from class: com.kakaogame.KGPromotion$showPromotionPopup$result$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    Logger.INSTANCE.m704i(y.ۮڭڭܬި(862452227), y.ٲٴݴ״ٰ(1781959864) + result);
                    KGResultCallback<String> kGResultCallback = callback;
                    if (kGResultCallback != null) {
                        kGResultCallback.onResult(result);
                    }
                    firebaseEvent.setResult(result);
                }
            });
            successResult = KGResult.INSTANCE.getSuccessResult();
        }
        if (successResult.isNotSuccess()) {
            if (callback != null) {
                callback.onResult(successResult);
            }
            firebaseEvent.setResult(successResult);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showEndingPromotionPopups(Activity activity, final KGResultCallback<String> callback) {
        KGResult<String> successResult;
        Logger.INSTANCE.m704i(y.ۮڭڭܬި(862452227), y.ٲٴݴ״ٰ(1781986568));
        final FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.ٴسسݬߨ(1392765786), y.ݮڮֲڭܩ(-628629700));
        if (activity == null) {
            successResult = KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106));
        } else if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.promotion)) {
            successResult = KGResult.INSTANCE.getResult(5001);
        } else {
            EndingPromotionManager.INSTANCE.showEndingPromotions(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGPromotion$showEndingPromotionPopups$result$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    Logger.INSTANCE.m704i(y.ۮڭڭܬި(862452227), y.ٴسسݬߨ(1392742826) + result);
                    KGResultCallback<String> kGResultCallback = callback;
                    if (kGResultCallback != null) {
                        kGResultCallback.onResult(result);
                    }
                    firebaseEvent.setResult(result);
                }
            });
            successResult = KGResult.INSTANCE.getSuccessResult();
        }
        if (successResult.isNotSuccess()) {
            if (callback != null) {
                callback.onResult(successResult);
            }
            firebaseEvent.setResult(successResult);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575679014), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPromotion$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGPromotion.showStartingPromotionPopups(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGPromotion$initInterfaceBroker$1$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                KGResult kGResult = (KGResult) content;
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051730941), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPromotion$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                int parseInt;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                Object parameter = request.getParameter(y.دײܮڳܯ(2051707837));
                if (parameter instanceof Number) {
                    parseInt = ((Number) parameter).intValue();
                } else if (parameter instanceof String) {
                    parseInt = Integer.parseInt((String) parameter);
                } else {
                    return KGResult.INSTANCE.getResult(KGResult.INSTANCE.getResult(4000));
                }
                KGPromotion.INSTANCE.showPromotionPopup(activity, parseInt, new KGResultCallback<String>() { // from class: com.kakaogame.KGPromotion$initInterfaceBroker$2$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                KGResult kGResult = (KGResult) content;
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051730125), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPromotion$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGPromotion.showEndingPromotionPopups(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGPromotion$initInterfaceBroker$3$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                Object content = createLock.getContent();
                Intrinsics.checkNotNull(content);
                KGResult kGResult = (KGResult) content;
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }
}
