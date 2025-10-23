package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.security.ProtectionManager;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: KGProtection.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0007J$\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000fH\u0007J$\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u000fH\u0007J$\u0010\u0017\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000fH\u0007J\u001a\u0010\u0018\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000fH\u0007J\u001a\u0010\u0019\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u000fH\u0007J$\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000fH\u0007J$\u0010\u001d\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000fH\u0007J$\u0010\u001e\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\u0006\u0010\tR\u001a\u0010\n\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\n\u0010\t¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/KGProtection;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "isEnable2ndPassword", "", "isEnable2ndPassword$annotations", "()Z", "isEnableDeviceSecurity", "isEnableDeviceSecurity$annotations", "check2StepVerificationEmail", "", "callback", "Lcom/kakaogame/KGResultCallback;", "initInterfaceBroker", "initialize", "isAllowedAccess", "activity", "Landroid/app/Activity;", "isAllowedAccessOnEngine", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "isCertificatedDevice", "isRegistered2ndPassword", "isRegisteredDeviceSecurity", "register2StepVerificationEmail", "email", "Ljava/lang/Void;", "register2ndPassword", "showDeviceRegistrationView", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGProtection {
    private static final String CLASS_NAME_KEY = "KGProtection";
    public static final KGProtection INSTANCE = new KGProtection();
    private static final String TAG = "KGProtection";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isEnable2ndPassword$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isEnableDeviceSecurity$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGProtection() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void isAllowedAccess(Activity activity, KGResultCallback<String> callback) {
        Job launch$default;
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.֬ڱܱײٮ(-1159491127));
        if (activity != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$isAllowedAccess$1$1(activity, callback, null), 3, null);
            if (launch$default != null) {
                return;
            }
        }
        if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106)));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void isAllowedAccessOnEngine(Activity activity, KGResultCallback<Base2ndPWViewData> callback) {
        Job launch$default;
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.֬ڱܱײٮ(-1159491127));
        if (activity != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$isAllowedAccessOnEngine$1$1(activity, callback, null), 3, null);
            if (launch$default != null) {
                return;
            }
        }
        if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106)));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isEnableDeviceSecurity() {
        KGIdpProfile idpProfile;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return false;
        }
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        KGIdpProfile.KGIdpCode idpCode = (currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode();
        if (idpCode == null || KGIdpProfile.KGIdpCode.Guest == idpCode || !InfodeskHelper.INSTANCE.isEnableDeviceSecurity()) {
            return false;
        }
        String registerDeviceUrl = InfodeskHelper.INSTANCE.getRegisterDeviceUrl();
        if (registerDeviceUrl == null || registerDeviceUrl.length() == 0) {
            return false;
        }
        String deviceVerifyEncryptKey = InfodeskHelper.INSTANCE.getDeviceVerifyEncryptKey();
        return !(deviceVerifyEncryptKey == null || deviceVerifyEncryptKey.length() == 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void isCertificatedDevice(Activity activity, KGResultCallback<Boolean> callback) {
        Job launch$default;
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.ٴسسݬߨ(1392758226));
        if (activity != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$isCertificatedDevice$1$1(activity, callback, null), 3, null);
            if (launch$default != null) {
                return;
            }
        }
        if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106)));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void isRegisteredDeviceSecurity(KGResultCallback<Boolean> callback) {
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.ٴسسݬߨ(1392758650));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$isRegisteredDeviceSecurity$1(callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showDeviceRegistrationView(Activity activity, KGResultCallback<Void> callback) {
        Job launch$default;
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.ٲٴݴ״ٰ(1781978856));
        if (activity != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$showDeviceRegistrationView$1$1(activity, callback, null), 3, null);
            if (launch$default != null) {
                return;
            }
        }
        if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106)));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isEnable2ndPassword() {
        KGIdpProfile idpProfile;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return false;
        }
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        KGIdpProfile.KGIdpCode idpCode = (currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode();
        if (idpCode == null || KGIdpProfile.KGIdpCode.Guest == idpCode) {
            return false;
        }
        return InfodeskHelper.INSTANCE.isEnable2ndPWSecurity();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void isRegistered2ndPassword(KGResultCallback<Boolean> callback) {
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.ۮڭڭܬި(862431099));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$isRegistered2ndPassword$1(callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void register2ndPassword(Activity activity, KGResultCallback<Void> callback) {
        Job launch$default;
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.ݬֲ֮ܲت(1512759999));
        if (activity != null) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$register2ndPassword$1$1(activity, callback, null), 3, null);
            if (launch$default != null) {
                return;
            }
        }
        if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106)));
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void check2StepVerificationEmail(KGResultCallback<String> callback) {
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.دײܮڳܯ(2051727365));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$check2StepVerificationEmail$1(callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void register2StepVerificationEmail(String email, KGResultCallback<Void> callback) {
        Logger.INSTANCE.m704i(y.֬ڱܱײٮ(-1159479959), y.ݮڮֲڭܩ(-628622268));
        String str = email;
        if (!(str == null || str.length() == 0)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGProtection$register2StepVerificationEmail$1(email, callback, null), 3, null);
        } else if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getResult(4000, y.٬ݯح׭٩(575677438)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051727645), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGResult isAllowedAccess$default = ProtectionManager.isAllowedAccess$default(ProtectionManager.INSTANCE, activity, false, 2, null);
                if (isAllowedAccess$default.isSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.֬ڱܱײٮ(-1159480759), isAllowedAccess$default.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(isAllowedAccess$default);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512757015), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(y.ٲٴݴ״ٰ(1781966448), Boolean.valueOf(KGProtection.isEnableDeviceSecurity()));
                return KGResult.INSTANCE.getSuccessResult(jSONObject);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781981936), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                KGResult<Boolean> isRegisteredDeviceSecurity = ProtectionManager.INSTANCE.isRegisteredDeviceSecurity();
                if (isRegisteredDeviceSecurity.isSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ۮڭڭܬި(862423163), isRegisteredDeviceSecurity.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(isRegisteredDeviceSecurity);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781981256), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGResult<Boolean> isCertificatedDevice = ProtectionManager.INSTANCE.isCertificatedDevice(activity);
                JSONObject jSONObject = new JSONObject();
                if (isCertificatedDevice.isSuccess()) {
                    jSONObject.put(y.ٲٴݴ״ٰ(1781989032), isCertificatedDevice.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(isCertificatedDevice);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512756031), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                return ProtectionManager.INSTANCE.showDeviceRegistrationView(activity);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512755591), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(y.ٲٴݴ״ٰ(1781966448), Boolean.valueOf(KGProtection.isEnable2ndPassword()));
                return KGResult.INSTANCE.getSuccessResult(jSONObject);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392769794), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                KGResult<Boolean> isRegistered2ndPassword = ProtectionManager.INSTANCE.isRegistered2ndPassword();
                if (isRegistered2ndPassword.isSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.ۮڭڭܬި(862423163), isRegistered2ndPassword.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(isRegistered2ndPassword);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781984168), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                return ProtectionManager.INSTANCE.register2ndPassword(activity);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628637268), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                KGResult<String> check2StepVerificationEmail = ProtectionManager.INSTANCE.check2StepVerificationEmail();
                if (check2StepVerificationEmail.isSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.֬ڱܱײٮ(-1159479551), check2StepVerificationEmail.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(check2StepVerificationEmail);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628636884), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$10
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("email");
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return KGResult.INSTANCE.getResult(4000, y.٬ݯح׭٩(575677438));
                }
                return ProtectionManager.INSTANCE.register2StepVerificationEmail(str);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862427171), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$11
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Object runBlocking$default;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGProtection$initInterfaceBroker$11$request$result$1(activity, null), 1, null);
                KGResult<?> kGResult = (KGResult) runBlocking$default;
                FirebaseEvent.INSTANCE.getFirebaseEvent(y.֬ڱܱײٮ(-1159479959), y.٬ݯح׭٩(575677686)).setResult(kGResult);
                if (kGResult.isSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.دײܮڳܯ(2051550101), kGResult.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(kGResult);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051731477), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$12
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Object runBlocking$default;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGProtection$initInterfaceBroker$12$request$result$1(activity, null), 1, null);
                KGResult kGResult = (KGResult) runBlocking$default;
                if (kGResult.isSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.دײܮڳܯ(2051550101), kGResult.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(kGResult);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051731877), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGProtection$initInterfaceBroker$13
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Object runBlocking$default;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.֬ڱܱײٮ(-1159583711));
                if (str == null) {
                    str = "";
                }
                String str2 = (String) request.getParameter(y.֬ڱܱײٮ(-1159406207));
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGProtection$initInterfaceBroker$13$request$result$1(activity, str, str2 != null ? str2 : "", null), 1, null);
                KGResult kGResult = (KGResult) runBlocking$default;
                if (kGResult.isSuccess()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(y.دײܮڳܯ(2051550101), kGResult.getContent());
                    return KGResult.INSTANCE.getSuccessResult(jSONObject);
                }
                return KGResult.INSTANCE.getResult(kGResult);
            }
        });
    }
}
