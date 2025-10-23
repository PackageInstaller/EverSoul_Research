package com.kakaogame;

import android.app.Activity;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.p029ui.AppUpdateManager;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: KGAppOption.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J.\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\b¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/KGAppOption;", "", "()V", "CLASS_NAME_KEY", "", "cDNAddress", "getCDNAddress$annotations", "getCDNAddress", "()Ljava/lang/String;", "gameServerAddress", "getGameServerAddress$annotations", "getGameServerAddress", "getUpdateParam", "Lcom/kakaogame/KGAppOption$UpdatePopupParamBuilder;", "getValue", "key", "initInterfaceBroker", "", "initialize", "showUpdateRecommendedPopup", "activity", "Landroid/app/Activity;", "popupInfo", "callback", "Lcom/kakaogame/KGResultCallback;", "", "UpdatePopupParamBuilder", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGAppOption {
    private static final String CLASS_NAME_KEY = "KGAppOption";
    public static final KGAppOption INSTANCE = new KGAppOption();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getCDNAddress$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getGameServerAddress$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGAppOption() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getGameServerAddress() {
        return getValue(y.ٴسسݬߨ(1392612938));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getCDNAddress() {
        return getValue(y.ݮڮֲڭܩ(-628776548));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getValue(String key) {
        InfodeskHelper infodeskHelper = InfodeskHelper.INSTANCE;
        Intrinsics.checkNotNull(key);
        return infodeskHelper.getValue(key, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final UpdatePopupParamBuilder getUpdateParam() {
        return new UpdatePopupParamBuilder(MapsKt.mapOf(TuplesKt.m846to(y.ٴسسݬߨ(1392612602), CoreManager.INSTANCE.getResourceString(y.دײܮڳܯ(2051577061))), TuplesKt.m846to(y.ݮڮֲڭܩ(-628776636), CoreManager.INSTANCE.getResourceString(y.دײܮڳܯ(2051577301))), TuplesKt.m846to(y.ٲٴݴ״ٰ(1781826800), CoreManager.INSTANCE.getResourceString(y.ݮڮֲڭܩ(-628775684)))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showUpdateRecommendedPopup(Activity activity, UpdatePopupParamBuilder popupInfo, KGResultCallback<Boolean> callback) {
        Job launch$default;
        FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.ݮڮֲڭܩ(-628761844), y.ٴسسݬߨ(1392635802));
        if (activity != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGAppOption$showUpdateRecommendedPopup$1$1(activity, popupInfo, callback, firebaseEvent, null), 3, null);
            if (launch$default != null) {
                return;
            }
        }
        KGResult<Boolean> result = KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106));
        if (callback != null) {
            callback.onResult(result);
        }
        firebaseEvent.setResult(result);
        Unit unit = Unit.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628775532), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGAppOption$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to("result", KGAppOption.getGameServerAddress())));
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862321203), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGAppOption$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to("result", KGAppOption.getCDNAddress())));
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159614159), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGAppOption$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to("result", KGAppOption.getValue((String) request.getParameter("key")))));
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512621943), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGAppOption$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to("result", InfodeskHelper.INSTANCE.getAppOption())));
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781854968), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGAppOption$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.ٴسسݬߨ(1392612602));
                String str2 = (String) request.getParameter(y.ݮڮֲڭܩ(-628776636));
                KGResult<Boolean> checkUpdateInGame = AppUpdateManager.checkUpdateInGame(activity, KGAppOption.getUpdateParam().setTitleMessage(str).setUpdateButton(str2).setLaterButton((String) request.getParameter(y.ٲٴݴ״ٰ(1781826800))));
                if (checkUpdateInGame.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(checkUpdateInGame);
                }
                return KGResult.INSTANCE.getSuccessResult(MapsKt.mapOf(TuplesKt.m846to("isUpdateRequired", checkUpdateInGame.getContent())));
            }
        });
    }

    /* compiled from: KGAppOption.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u001f\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000f\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/KGAppOption$UpdatePopupParamBuilder;", "", "obj", "", "", "(Ljava/util/Map;)V", "updateParam", "Lcom/kakaogame/KGAppOption$UpdatePopupParamBuilder$UpdatePopupParam;", "build", "setLaterButton", UpdatePopupParamBuilder.KEY_LATER_BUTTON, "setMarketUrl", UpdatePopupParamBuilder.KEY_MARKET_URL, "setTitleMessage", UpdatePopupParamBuilder.KEY_MESSAGE, "setUpdateButton", UpdatePopupParamBuilder.KEY_UPDATE_BUTTON, "Companion", "UpdatePopupParam", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class UpdatePopupParamBuilder {
        public static final String KEY_LATER_BUTTON = "laterButton";
        private static final String KEY_MARKET_URL = "marketUrl";
        public static final String KEY_MESSAGE = "titleMessage";
        public static final String KEY_UPDATE_BUTTON = "updateButton";
        private final UpdatePopupParam updateParam;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public UpdatePopupParamBuilder(Map<String, ? extends Object> map) {
            this.updateParam = new UpdatePopupParam(map);
        }

        /* compiled from: KGAppOption.kt */
        @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/KGAppOption$UpdatePopupParamBuilder$UpdatePopupParam;", "Lcom/kakaogame/KGObject;", "paramObj", "", "", "", "(Ljava/util/Map;)V", UpdatePopupParamBuilder.KEY_LATER_BUTTON, "getLaterButton", "()Ljava/lang/String;", UpdatePopupParamBuilder.KEY_MARKET_URL, "getMarketUrl", UpdatePopupParamBuilder.KEY_MESSAGE, "getTitleMessage", UpdatePopupParamBuilder.KEY_UPDATE_BUTTON, "getUpdateButton", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class UpdatePopupParam extends KGObject {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public UpdatePopupParam(Map<String, ? extends Object> map) {
                super(TypeIntrinsics.asMutableMap(map));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String getTitleMessage() {
                return (String) get(y.ٴسسݬߨ(1392612602));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String getUpdateButton() {
                return (String) get(y.ݮڮֲڭܩ(-628776636));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String getLaterButton() {
                return (String) get(y.ٲٴݴ״ٰ(1781826800));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final String getMarketUrl() {
                return (String) get(y.٬ݯح׭٩(575819902));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final UpdatePopupParamBuilder setTitleMessage(String titleMessage) {
            if (titleMessage != null) {
                this.updateParam.put(y.ٴسسݬߨ(1392612602), titleMessage);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final UpdatePopupParamBuilder setUpdateButton(String updateButton) {
            if (updateButton != null) {
                this.updateParam.put(y.ݮڮֲڭܩ(-628776636), updateButton);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final UpdatePopupParamBuilder setLaterButton(String laterButton) {
            this.updateParam.put(y.ٲٴݴ״ٰ(1781826800), laterButton);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final UpdatePopupParamBuilder setMarketUrl(String marketUrl) {
            this.updateParam.put(y.٬ݯح׭٩(575819902), marketUrl);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final UpdatePopupParam build() {
            return this.updateParam;
        }
    }
}
