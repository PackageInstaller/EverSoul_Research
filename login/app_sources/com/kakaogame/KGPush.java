package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import com.kakaogame.KGResult;
import com.kakaogame.auth.agreement.AgreementManager;
import com.kakaogame.auth.agreement.AgreementService;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.player.LocalPlayer;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.push.PushPermissionManager;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGPush.kt */
@Metadata(m838d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\fH\u0002J,\u0010\u000f\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\f2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0006\u0010\u0018\u001a\u00020\u0014J\u0012\u0010\u0019\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\f0\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, m839d2 = {"Lcom/kakaogame/KGPush;", "", "()V", "PUSH_CHANNEL", "", "PUSH_OPTION_NIGHT", "PUSH_OPTION_PLAYER", "TAG", "VALUE_FALSE", "VALUE_TRUE", "pushOptions", "Ljava/util/LinkedHashMap;", "", "getPushOptions", "()Ljava/util/LinkedHashMap;", "enablePush", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", LocalPlayerService.FIELD_KEY_PUSH_OPTION, "enable", "", "callback", "Lcom/kakaogame/KGResultCallback;", "initInterfaceBroker", "initialize", "isEnablePush", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGPush {
    public static final KGPush INSTANCE = new KGPush();
    public static final String PUSH_CHANNEL = "kakaoGameChannel";
    public static final String PUSH_OPTION_NIGHT = "night";
    public static final String PUSH_OPTION_PLAYER = "player";
    private static final String TAG = "KGPush";
    private static final String VALUE_FALSE = "n";
    private static final String VALUE_TRUE = "y";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGPush() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isEnablePush(String pushOption) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575669542) + pushOption;
        String str2 = y.ݬֲ֮ܲت(1512759671);
        logger.m704i(str2, str);
        if (TextUtils.isEmpty(pushOption)) {
            Logger.INSTANCE.m701e(str2, y.ٲٴݴ״ٰ(1781980848));
            return false;
        }
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.push) || CoreManager.INSTANCE.getInstance().getPlayer() == null || !DeviceUtil.isNotificationEnable(CoreManager.INSTANCE.getInstance().getContext(), y.ݮڮֲڭܩ(-628621444))) {
            return false;
        }
        boolean z = true;
        try {
            LinkedHashMap<String, Boolean> pushOptions = INSTANCE.getPushOptions();
            if (pushOptions.containsKey(pushOption)) {
                Boolean bool = pushOptions.get(pushOption);
                Intrinsics.checkNotNull(bool);
                z = bool.booleanValue();
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void enablePush(String pushOption, boolean enable, KGResultCallback<Void> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159489423) + pushOption + y.ݬֲ֮ܲت(1512762967) + (enable ? y.دײܮڳܯ(2051939573) : y.ٲٴݴ״ٰ(1781635312));
        String str2 = y.ݬֲ֮ܲت(1512759671);
        logger.m704i(str2, str);
        if (callback == null) {
            Logger.INSTANCE.m701e(str2, "enablePush: Invalid Parameter! 'callback' is null.");
        } else if (!TextUtils.isEmpty(pushOption)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGPush$enablePush$1(pushOption, enable, callback, null), 3, null);
        } else {
            Logger.INSTANCE.m701e(str2, "enablePush: Invalid Parameter! 'pushOption' is empty.");
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.دײܮڳܯ(2051720261)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final LinkedHashMap<String, Boolean> getPushOptions() {
        String str = y.ݬֲ֮ܲت(1512759671);
        String str2 = y.֬ڱܱײٮ(-1159488551);
        LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
        try {
            LocalPlayer player = CoreManager.INSTANCE.getInstance().getPlayer();
            Intrinsics.checkNotNull(player);
            Map map = (Map) player.get(LocalPlayerService.FIELD_KEY_PUSH_OPTION);
            Logger.INSTANCE.m699d(str, str2 + map);
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str3 = (String) entry.getKey();
                    boolean z = true;
                    if (StringsKt.equals("n", (String) entry.getValue(), true)) {
                        z = false;
                    }
                    linkedHashMap.put(str3, Boolean.valueOf(z));
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> enablePush(String pushOption, boolean enable) {
        KGResult<Void> result;
        String name;
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.push)) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String str = y.ݬֲ֮ܲت(1512759671);
        if (enable) {
            boolean isNotificationEnable = DeviceUtil.isNotificationEnable(CoreManager.INSTANCE.getInstance().getActivity(), y.ݮڮֲڭܩ(-628621444));
            if (!isNotificationEnable && !PushPermissionManager.INSTANCE.enablePush(CoreManager.INSTANCE.getInstance().getActivity()).isSuccess()) {
                return KGResult.INSTANCE.getResult(KGResult.KGResultCode.DEVICE_NOTIFICATION_SETTING_OFF);
            }
            Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512759335) + enable + y.֬ڱܱײٮ(-1159489231) + isNotificationEnable);
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1392755946));
        try {
            try {
                if (StringsKt.equals("player", pushOption, true)) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(AgreementManager.TERMS_CODE_PUSH_PLAYER, AgreementService.getValueString(enable));
                    KGResult<Void> saveAgreement = AgreementManager.saveAgreement(linkedHashMap);
                    if (saveAgreement.isNotSuccess()) {
                        KGResult<Void> result2 = KGResult.INSTANCE.getResult(saveAgreement);
                        start.stop();
                        KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                        return result2;
                    }
                    result = KGResult.INSTANCE.getSuccessResult();
                } else if (StringsKt.equals(PUSH_OPTION_NIGHT, pushOption, true)) {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put(AgreementManager.TERMS_CODE_PUSH_NIGHT, AgreementService.getValueString(enable));
                    KGResult<Void> saveAgreement2 = AgreementManager.saveAgreement(linkedHashMap2);
                    if (saveAgreement2.isNotSuccess()) {
                        KGResult<Void> result3 = KGResult.INSTANCE.getResult(saveAgreement2);
                        start.stop();
                        KGResultUtil.writeClientApiCall(start.getName(), result3, start.getDurationMs());
                        return result3;
                    }
                    result = KGResult.INSTANCE.getSuccessResult();
                } else {
                    result = KGResult.INSTANCE.getResult(4000, "not supported your pushOption string.");
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781979232), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPush$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter(LocalPlayerService.FIELD_KEY_PUSH_OPTION);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(y.ٲٴݴ״ٰ(1781966448), Boolean.valueOf(KGPush.isEnablePush(str)));
                return KGResult.INSTANCE.getSuccessResult(jSONObject);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392754706), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGPush$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> enablePush;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter(LocalPlayerService.FIELD_KEY_PUSH_OPTION);
                Object parameter = request.getParameter(y.ٲٴݴ״ٰ(1781966448));
                Intrinsics.checkNotNull(parameter, y.ٲٴݴ״ٰ(1782032576));
                enablePush = KGPush.INSTANCE.enablePush(str, ((Boolean) parameter).booleanValue());
                return enablePush;
            }
        });
    }
}
