package com.kakaogame.security;

import android.app.Activity;
import android.content.Context;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.KGSession;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.secondpw.ActionType;
import com.kakaogame.secondpw.ActionTypeKt;
import com.kakaogame.secondpw.SecondPWRestrictViewDialog;
import com.kakaogame.secondpw.SecondPWViewDialog;
import com.kakaogame.secondpw.SecondPWViewManager;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.secondpw.viewdata.RestrictPopupViewData;
import com.kakaogame.secondpw.viewdata.ResultData;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.AES256Cipher;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.web.DeviceRegistrationDialog;
import com.kakaogame.web.WebDialog;
import com.liapp.y;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ProtectionManager.kt */
@Metadata(m838d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u00017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\rJ\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\tH\u0002J\"\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0002J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u001f\u001a\u00020\tJ \u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\tJ\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\r2\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\"J.\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0082@¢\u0006\u0002\u0010-J \u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0016\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\r2\u0006\u0010\u0013\u001a\u00020\u0014J.\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\u00042\u0006\u00102\u001a\u000203H\u0082@¢\u0006\u0002\u00104J\u001e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\"J\u0018\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u00068"}, m839d2 = {"Lcom/kakaogame/security/ProtectionManager;", "", "()V", "CHECK_ONLY", "", "CLASS_NAME_KEY", "PROCESS_IS_ALLOWED_ACESS", "TAG", "isCompletedDeviceSecurity", "", "isNewUser", "()Z", "isRegistered2ndPassword", "Lcom/kakaogame/KGResult;", "()Lcom/kakaogame/KGResult;", "isRegisteredDeviceSecurity", "regex", "actionForEngineUI", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "activity", "Landroid/app/Activity;", "action", "content", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "check2StepVerificationEmail", "check2ndPW", "Lcom/kakaogame/security/UserState;", "isEngineUI", "checkDeviceCertification", "process", "checkDeviceSecurity", "checkDeviceSecurityCompleted", "isAllowedAccess", "isAllowedAccessOnEngine", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCertificatedDevice", "register2StepVerificationEmail", "Ljava/lang/Void;", "email", "register2ndPassword", "register2ndPasswordOnEngine", "showAccessRestrictViewDialog", Base2ndPWViewData.KEY_MIN, "", "second", "(Landroid/app/Activity;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showDeviceRegistrationDialog", "url", "showDeviceRegistrationView", "showInAppWebView", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/kakaogame/web/WebDialog$Settings;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showPasswordInputDialog", "showPasswordSettingDialog", "CertificationPrefManager", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ProtectionManager {
    private static final String CHECK_ONLY = "check_only";
    private static final String CLASS_NAME_KEY = "KGProtection";
    public static final ProtectionManager INSTANCE = new ProtectionManager();
    private static final String PROCESS_IS_ALLOWED_ACESS = "is_allowed_access";
    private static final String TAG = "ProtectionManager";
    private static boolean isCompletedDeviceSecurity = false;
    public static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ProtectionManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean checkDeviceSecurityCompleted() {
        return isCompletedDeviceSecurity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Boolean> isRegisteredDeviceSecurity() {
        KGResult<Boolean> result;
        KGIdpProfile idpProfile;
        if (!InfodeskHelper.INSTANCE.isEnableDeviceSecurity()) {
            return KGResult.INSTANCE.getResult(5001, y.٬ݯح׭٩(576435214));
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode()) == KGIdpProfile.KGIdpCode.Guest) {
            return KGResult.INSTANCE.getSuccessResult(false);
        }
        FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.֬ڱܱײٮ(-1159479959), y.دײܮڳܯ(2051109765));
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٲٴݴ״ٰ(1782410688));
        try {
            result = DeviceProtectionService.INSTANCE.isRegisteredUser();
            if (result.isSuccess()) {
                result = KGResult.INSTANCE.getSuccessResult(result.getContent());
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
            result = KGResult.INSTANCE.getResult(4001, e.toString());
        }
        start.stop();
        KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
        firebaseEvent.setResult(result);
        return result;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Boolean> isCertificatedDevice(Activity activity) {
        KGIdpProfile idpProfile;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (!InfodeskHelper.INSTANCE.isEnableDeviceSecurity()) {
            return KGResult.INSTANCE.getResult(5001);
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Guest;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (kGIdpCode == ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
            return KGResult.INSTANCE.getSuccessResult(false);
        }
        KGResult checkDeviceCertification$default = checkDeviceCertification$default(this, activity, null, 2, null);
        return checkDeviceCertification$default.isSuccess() ? KGResult.INSTANCE.getSuccessResult(true) : checkDeviceCertification$default.getCode() == 4011 ? KGResult.INSTANCE.getSuccessResult(false) : KGResult.INSTANCE.getResult(checkDeviceCertification$default);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Boolean> isRegistered2ndPassword() {
        KGResult<Boolean> result;
        KGIdpProfile idpProfile;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode()) == KGIdpProfile.KGIdpCode.Guest) {
            return KGResult.INSTANCE.getSuccessResult(false);
        }
        FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.֬ڱܱײٮ(-1159479959), y.دײܮڳܯ(2051109941));
        Stopwatch start = Stopwatch.INSTANCE.start(y.ۮڭڭܬި(862723643));
        try {
            KGResult<UserState> userState = SecondaryPWService.INSTANCE.getUserState();
            if (userState.isSuccess()) {
                UserState content = userState.getContent();
                Intrinsics.checkNotNull(content);
                result = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(content.isRegistered()));
            } else {
                result = KGResult.INSTANCE.getResult(userState);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
            result = KGResult.INSTANCE.getResult(4001, e.toString());
        }
        start.stop();
        KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
        firebaseEvent.setResult(result);
        return result;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult isAllowedAccess$default(ProtectionManager protectionManager, Activity activity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return protectionManager.isAllowedAccess(activity, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> isAllowedAccess(Activity activity, boolean isEngineUI) {
        KGResult<String> successResult;
        KGIdpProfile idpProfile;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.֬ڱܱײٮ(-1159479959), y.٬ݯح׭٩(575677686));
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            successResult = KGResult.INSTANCE.getResult(3002);
        } else {
            KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Guest;
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            if (kGIdpCode == ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
                successResult = KGResult.INSTANCE.getSuccessResult("");
            } else {
                if (InfodeskHelper.INSTANCE.isEnableDeviceSecurity()) {
                    isCompletedDeviceSecurity = false;
                    KGResult<String> checkDeviceSecurity = checkDeviceSecurity(activity);
                    if (checkDeviceSecurity.isNotSuccess()) {
                        return checkDeviceSecurity;
                    }
                }
                if (isEngineUI) {
                    return KGResult.INSTANCE.getResult(10001);
                }
                KGResult check2ndPW$default = check2ndPW$default(this, activity, false, 2, null);
                if (check2ndPW$default.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(check2ndPW$default);
                }
                if (checkDeviceSecurityCompleted()) {
                    successResult = KGResult.INSTANCE.getSuccessResult(KGSystem.getDeviceId());
                } else {
                    successResult = KGResult.INSTANCE.getSuccessResult("");
                }
            }
        }
        if (!isEngineUI) {
            firebaseEvent.setResult(successResult);
        }
        return successResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ KGResult check2ndPW$default(ProtectionManager protectionManager, Activity activity, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return protectionManager.check2ndPW(activity, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<UserState> check2ndPW(Activity activity, boolean isEngineUI) {
        Object runBlocking$default;
        Object runBlocking$default2;
        if (!InfodeskHelper.INSTANCE.isEnable2ndPWSecurity()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        KGResult<UserState> userState = SecondaryPWService.INSTANCE.getUserState();
        if (userState.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(userState);
        }
        UserState content = userState.getContent();
        Intrinsics.checkNotNull(content);
        if (!content.isRegistered()) {
            if (InfodeskHelper.INSTANCE.getSecondaryPasswordOptionType() == InfodeskHelper.SecondaryPWSettingType.MANDATORY) {
                return KGResult.INSTANCE.getResult(KGResult.KGResultCode.PASSWORD_REGISTRATION_REQUIRED);
            }
            return KGResult.INSTANCE.getSuccessResult();
        }
        UserState content2 = userState.getContent();
        Intrinsics.checkNotNull(content2);
        if (content2.isBlocked()) {
            UserState content3 = userState.getContent();
            Intrinsics.checkNotNull(content3);
            UserState userState2 = content3;
            if (!isEngineUI) {
                runBlocking$default2 = BuildersKt__BuildersKt.runBlocking$default(null, new ProtectionManager$check2ndPW$1(activity, userState2, null), 1, null);
                return (KGResult) runBlocking$default2;
            }
            return KGResult.INSTANCE.getResult(10001, "", userState2);
        }
        if (isCompletedDeviceSecurity && InfodeskHelper.INSTANCE.getSkip2ndPassword()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (!isEngineUI) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ProtectionManager$check2ndPW$2(activity, null), 1, null);
            return (KGResult) runBlocking$default;
        }
        return KGResult.INSTANCE.getResult(10001);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object isAllowedAccessOnEngine(Activity activity, Continuation<? super KGResult<Base2ndPWViewData>> continuation) {
        ResultData resultData;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        ProtectionManager protectionManager = INSTANCE;
        KGResult<String> isAllowedAccess = protectionManager.isAllowedAccess(activity, true);
        if (isAllowedAccess.isSuccess()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(new ResultData(200, isAllowedAccess.getContent()))));
        } else if (isAllowedAccess.getCode() != 10001) {
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(isAllowedAccess)));
        } else {
            KGResult<UserState> check2ndPW = protectionManager.check2ndPW(activity, true);
            if (check2ndPW.isSuccess()) {
                if (protectionManager.checkDeviceSecurityCompleted()) {
                    resultData = new ResultData(200, KGSystem.getDeviceId());
                } else {
                    resultData = new ResultData(200, "");
                }
                Result.Companion companion3 = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(resultData)));
            } else if (check2ndPW.getCode() == 4012) {
                Result.Companion companion4 = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(KGResult.KGResultCode.PASSWORD_REGISTRATION_REQUIRED)));
            } else if (check2ndPW.getContent() == null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ProtectionManager$isAllowedAccessOnEngine$2$1(activity, safeContinuation2, null), 3, null);
            } else {
                UserState content = check2ndPW.getContent();
                Intrinsics.checkNotNull(content);
                UserState userState = content;
                int pinFailLimitCount = InfodeskHelper.INSTANCE.getPinFailLimitCount();
                int pinFailBlockTime = InfodeskHelper.INSTANCE.getPinFailBlockTime();
                int blockMin = (userState.getBlockMin() * 60) + userState.getBlockSec();
                Result.Companion companion5 = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(new RestrictPopupViewData(activity, pinFailLimitCount, pinFailBlockTime, blockMin))));
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object actionForEngineUI(Activity activity, String str, String str2, Continuation<? super KGResult<Base2ndPWViewData>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        SecondPWViewManager.INSTANCE.getUIData(activity, ActionTypeKt.getActionType(str), str2, new Function1<Base2ndPWViewData, Unit>() { // from class: com.kakaogame.security.ProtectionManager$actionForEngineUI$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Base2ndPWViewData base2ndPWViewData) {
                invoke2(base2ndPWViewData);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Base2ndPWViewData base2ndPWViewData) {
                Intrinsics.checkNotNullParameter(base2ndPWViewData, y.٬ݯح׭٩(576439206));
                if (base2ndPWViewData.isResult() && base2ndPWViewData.getResultCode() != 200) {
                    Continuation<KGResult<Base2ndPWViewData>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(base2ndPWViewData.getResultCode())));
                } else {
                    Continuation<KGResult<Base2ndPWViewData>> continuation3 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(base2ndPWViewData)));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> checkDeviceSecurity(Activity activity) {
        try {
            if (InfodeskHelper.INSTANCE.getDeviceSecurityOptionType() == InfodeskHelper.DeviceSecuritySettingType.OPTIONAL) {
                KGResult<Boolean> isRegisteredUser = DeviceProtectionService.INSTANCE.isRegisteredUser();
                if (isRegisteredUser.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(isRegisteredUser);
                }
                Boolean content = isRegisteredUser.getContent();
                Intrinsics.checkNotNull(content);
                if (!content.booleanValue()) {
                    if (InfodeskHelper.INSTANCE.isCheckNewUser()) {
                        if (!isNewUser()) {
                            return KGResult.INSTANCE.getSuccessResult("");
                        }
                    } else {
                        return KGResult.INSTANCE.getSuccessResult("");
                    }
                }
            }
            return checkDeviceCertification(activity, PROCESS_IS_ALLOWED_ACESS);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isNewUser() {
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        long registTime = currentPlayer != null ? currentPlayer.getRegistTime() : 0L;
        long firstLoginBaseTime = InfodeskHelper.INSTANCE.getFirstLoginBaseTime();
        if (registTime == 0) {
            return true;
        }
        return firstLoginBaseTime >= 0 && registTime > firstLoginBaseTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ KGResult checkDeviceCertification$default(ProtectionManager protectionManager, Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = CHECK_ONLY;
        }
        return protectionManager.checkDeviceCertification(activity, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> checkDeviceCertification(Activity activity, String process) {
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        Intrinsics.checkNotNull(currentPlayer);
        String playerId = currentPlayer.getPlayerId();
        String appId = CoreManager.INSTANCE.getInstance().getConfiguration().getAppId();
        String certification = CertificationPrefManager.INSTANCE.getCertification(activity, appId, playerId);
        String str = certification;
        boolean z = str == null || str.length() == 0;
        String str2 = y.ݬֲ֮ܲت(1512133391);
        if (z) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.DEVICE_REGISTRATION_REQUIRED, str2);
        }
        try {
            String deviceId = KGSystem.getDeviceId();
            KGResult<Boolean> checkRegisteredDevice = DeviceProtectionService.INSTANCE.checkRegisteredDevice(deviceId, certification);
            if (checkRegisteredDevice.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(checkRegisteredDevice);
            }
            Boolean content = checkRegisteredDevice.getContent();
            Intrinsics.checkNotNull(content);
            if (content.booleanValue()) {
                if (Intrinsics.areEqual(process, PROCESS_IS_ALLOWED_ACESS)) {
                    isCompletedDeviceSecurity = true;
                }
                return KGResult.INSTANCE.getSuccessResult(deviceId);
            }
            CertificationPrefManager.removeCertification(activity, appId, playerId);
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.DEVICE_REGISTRATION_REQUIRED, str2);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> showDeviceRegistrationView(Activity activity) {
        KGIdpProfile idpProfile;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (!InfodeskHelper.INSTANCE.isEnableDeviceSecurity()) {
            return KGResult.INSTANCE.getResult(5001, y.٬ݯح׭٩(576435214));
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Guest;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (kGIdpCode == ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
            return KGResult.INSTANCE.getResult(5001, y.٬ݯح׭٩(576425102));
        }
        String registerDeviceUrl = InfodeskHelper.INSTANCE.getRegisterDeviceUrl();
        if (registerDeviceUrl == null || registerDeviceUrl.length() == 0) {
            return KGResult.INSTANCE.getResult(5001, y.֬ڱܱײٮ(-1159195543));
        }
        String registerDeviceUrl2 = InfodeskHelper.INSTANCE.getRegisterDeviceUrl();
        Intrinsics.checkNotNull(registerDeviceUrl2);
        return showDeviceRegistrationDialog(activity, registerDeviceUrl2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showDeviceRegistrationDialog(Activity activity, String url) {
        FirebaseEvent firebaseEvent;
        KGResult<Void> result;
        Object runBlocking$default;
        String str = y.ٴسسݬߨ(1393064434);
        String str2 = y.ݮڮֲڭܩ(-628583628);
        String str3 = y.ۮڭڭܬި(862262355);
        String appId = CoreManager.INSTANCE.getInstance().getConfiguration().getAppId();
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        Intrinsics.checkNotNull(currentPlayer);
        String playerId = currentPlayer.getPlayerId();
        FirebaseEvent firebaseEvent2 = FirebaseEvent.INSTANCE.getFirebaseEvent(y.֬ڱܱײٮ(-1159479959), y.ٴسسݬߨ(1393064322));
        KGResult checkDeviceCertification$default = checkDeviceCertification$default(this, activity, null, 2, null);
        if (!checkDeviceCertification$default.isSuccess() && checkDeviceCertification$default.getCode() != 4011) {
            return KGResult.INSTANCE.getResult(checkDeviceCertification$default);
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.ٴسسݬߨ(1393064674));
        int requestedOrientation = activity.getRequestedOrientation();
        Logger logger = Logger.INSTANCE;
        String str4 = y.ٲٴݴ״ٰ(1782416888) + requestedOrientation;
        String str5 = y.ۮڭڭܬި(862721739);
        logger.m699d(str5, str4);
        if (DisplayUtil.isScreenPortrait(activity)) {
            activity.setRequestedOrientation(7);
        } else {
            activity.setRequestedOrientation(6);
        }
        try {
            int resourceId = ResourceUtil.getResourceId(activity, "sdk_device_registration_portrait_width", str3);
            int resourceId2 = ResourceUtil.getResourceId(activity, "sdk_device_registration_portrait_height", str3);
            int resourceId3 = ResourceUtil.getResourceId(activity, "sdk_device_registration_landscape_width", str3);
            int resourceId4 = ResourceUtil.getResourceId(activity, "sdk_device_registration_landscape_height", str3);
            HashMap hashMap = new HashMap();
            hashMap.put(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            hashMap.put(ServerConstants.GUID, KGSystem.getDeviceId());
            hashMap.put("deviceNickname", KGSystem.getDeviceModel());
            firebaseEvent = firebaseEvent2;
            try {
                hashMap.put("isRegistered", CertificationPrefManager.INSTANCE.checkCertification(activity, appId, playerId));
                hashMap.put(str2, KGSession.getAccessToken());
                HashMap hashMap2 = new HashMap();
                hashMap2.put(str2, KGSession.getAccessToken());
                WebDialog.Settings.Builder fixedFontSize = new WebDialog.Settings.Builder().setPortSize(resourceId, resourceId2).setLandSize(resourceId3, resourceId4).setPulltoRefresh(false).setRequestHeaders(hashMap2).setCustomCookie(hashMap).setCookieExcludeOption(17).setFixedFontSize(true);
                if (InfodeskHelper.INSTANCE.offWebviewTopBarYellow()) {
                    fixedFontSize.setTitleBackgroundColor(InfodeskHelper.INSTANCE.webviewTitleBgColor()).setTitleTextColor(InfodeskHelper.INSTANCE.webviewTitleTextColor()).setCloseButtonColor(str).setPreviousButtonColor(str);
                }
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new ProtectionManager$showDeviceRegistrationDialog$result$result$1(activity, url, fixedFontSize, null), 1, null);
                activity.setRequestedOrientation(requestedOrientation);
                result = KGResult.INSTANCE.getResult((KGResult) runBlocking$default);
            } catch (Exception e) {
                e = e;
                Logger.INSTANCE.m702e(str5, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
                firebaseEvent.setResult(result);
                return result;
            }
        } catch (Exception e2) {
            e = e2;
            firebaseEvent = firebaseEvent2;
        }
        start.stop();
        KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
        firebaseEvent.setResult(result);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showInAppWebView(final Activity activity, final String str, final WebDialog.Settings settings, Continuation<? super KGResult<String>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862721739), y.ٴسسݬߨ(1392723938) + str);
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.security.ProtectionManager$showInAppWebView$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Activity activity2 = activity;
                    String str2 = str;
                    WebDialog.Settings settings2 = settings;
                    final Continuation<KGResult<String>> continuation2 = safeContinuation2;
                    new DeviceRegistrationDialog(activity2, str2, settings2, new Function1<KGResult<String>, Unit>() { // from class: com.kakaogame.security.ProtectionManager$showInAppWebView$2$1$webDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        {
                            super(1);
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KGResult<String> kGResult) {
                            invoke2(kGResult);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KGResult<String> kGResult) {
                            Intrinsics.checkNotNullParameter(kGResult, y.ٲٴݴ״ٰ(1782134480));
                            Continuation<KGResult<String>> continuation3 = continuation2;
                            Result.Companion companion = Result.INSTANCE;
                            continuation3.resumeWith(Result.m1440constructorimpl(kGResult));
                        }
                    }).show();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
                    KGResult result = KGResult.INSTANCE.getResult(4001, e.toString());
                    Continuation<KGResult<String>> continuation3 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1440constructorimpl(result));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showPasswordInputDialog(Activity activity, Continuation<? super KGResult<String>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ProtectionManager$showPasswordInputDialog$2$1(activity, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showAccessRestrictViewDialog(final Activity activity, final int i, final int i2, Continuation<? super KGResult<String>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.security.ProtectionManager$showAccessRestrictViewDialog$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    final int requestedOrientation = activity.getRequestedOrientation();
                    activity.setRequestedOrientation(6);
                    int pinFailLimitCount = InfodeskHelper.INSTANCE.getPinFailLimitCount();
                    int pinFailBlockTime = InfodeskHelper.INSTANCE.getPinFailBlockTime();
                    int i3 = (i * 60) + i2;
                    Activity activity2 = activity;
                    RestrictPopupViewData restrictPopupViewData = new RestrictPopupViewData(activity, pinFailLimitCount, pinFailBlockTime, i3);
                    final Activity activity3 = activity;
                    final Continuation<KGResult<String>> continuation2 = safeContinuation2;
                    new SecondPWRestrictViewDialog(activity2, restrictPopupViewData, new Function0<Unit>() { // from class: com.kakaogame.security.ProtectionManager$showAccessRestrictViewDialog$2$1$dialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        {
                            super(0);
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            activity3.setRequestedOrientation(requestedOrientation);
                            Continuation<KGResult<String>> continuation3 = continuation2;
                            Result.Companion companion = Result.INSTANCE;
                            continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_ALLOWED_ACCESS)));
                        }
                    }).show();
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
                    Continuation<KGResult<String>> continuation3 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object register2ndPasswordOnEngine(Activity activity, Continuation<? super KGResult<Base2ndPWViewData>> continuation) {
        KGIdpProfile idpProfile;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        if (!InfodeskHelper.INSTANCE.isEnable2ndPWSecurity()) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(5001, y.٬ݯح׭٩(576435214))));
        } else if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(3002)));
        } else {
            KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Guest;
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            if (kGIdpCode == ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
                Result.Companion companion3 = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(5001, y.٬ݯح׭٩(576425102))));
            } else {
                KGResult<Boolean> isRegistered2ndPassword = INSTANCE.isRegistered2ndPassword();
                if (isRegistered2ndPassword.isNotSuccess()) {
                    Result.Companion companion4 = Result.INSTANCE;
                    safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(isRegistered2ndPassword)));
                } else {
                    Boolean content = isRegistered2ndPassword.getContent();
                    Intrinsics.checkNotNull(content);
                    if (content.booleanValue()) {
                        Result.Companion companion5 = Result.INSTANCE;
                        safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(new ResultData(200, null, 2, null))));
                    } else {
                        SecondPWViewManager.getUIData$default(SecondPWViewManager.INSTANCE, activity, ActionType.ENTER_SHOW_PASSWORD_SETTING_VIEW, null, new Function1<Base2ndPWViewData, Unit>() { // from class: com.kakaogame.security.ProtectionManager$register2ndPasswordOnEngine$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(1);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Base2ndPWViewData base2ndPWViewData) {
                                invoke2(base2ndPWViewData);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Base2ndPWViewData base2ndPWViewData) {
                                Intrinsics.checkNotNullParameter(base2ndPWViewData, y.٬ݯح׭٩(576439206));
                                if (base2ndPWViewData.isResult() && base2ndPWViewData.getResultCode() != 200) {
                                    Continuation<KGResult<Base2ndPWViewData>> continuation2 = safeContinuation2;
                                    Result.Companion companion6 = Result.INSTANCE;
                                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(base2ndPWViewData.getResultCode())));
                                } else {
                                    Continuation<KGResult<Base2ndPWViewData>> continuation3 = safeContinuation2;
                                    Result.Companion companion7 = Result.INSTANCE;
                                    continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(base2ndPWViewData)));
                                }
                            }
                        }, 4, null);
                    }
                }
            }
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> register2ndPassword(Activity activity) {
        KGIdpProfile idpProfile;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (!InfodeskHelper.INSTANCE.isEnable2ndPWSecurity()) {
            return KGResult.INSTANCE.getResult(5001, y.٬ݯح׭٩(576435214));
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Guest;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (kGIdpCode == ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
            return KGResult.INSTANCE.getResult(5001, y.٬ݯح׭٩(576425102));
        }
        KGResult<Boolean> isRegistered2ndPassword = isRegistered2ndPassword();
        if (isRegistered2ndPassword.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(isRegistered2ndPassword);
        }
        Boolean content = isRegistered2ndPassword.getContent();
        Intrinsics.checkNotNull(content);
        return content.booleanValue() ? KGResult.INSTANCE.getSuccessResult() : showPasswordSettingDialog(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showPasswordSettingDialog(final Activity activity) {
        final MutexLock createLock = MutexLock.INSTANCE.createLock();
        int requestedOrientation = activity.getRequestedOrientation();
        activity.setRequestedOrientation(6);
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.security.ProtectionManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                ProtectionManager.showPasswordSettingDialog$lambda$6(activity, createLock);
            }
        });
        MutexLock.lock$default(createLock, 0L, 1, null);
        activity.setRequestedOrientation(requestedOrientation);
        Object content = createLock.getContent();
        Intrinsics.checkNotNull(content);
        return (KGResult) content;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPasswordSettingDialog$lambda$6(Activity activity, final MutexLock mutexLock) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Intrinsics.checkNotNullParameter(mutexLock, y.ݬֲ֮ܲت(1512132671));
        try {
            new SecondPWViewDialog(activity, ActionType.ENTER_SHOW_PASSWORD_SETTING_VIEW, new KGResultCallback<String>() { // from class: com.kakaogame.security.ProtectionManager$showPasswordSettingDialog$1$dialog$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    MutexLock<KGResult<Void>> mutexLock2 = mutexLock;
                    KGResult.Companion companion = KGResult.INSTANCE;
                    Intrinsics.checkNotNull(result);
                    mutexLock2.setContent(companion.getResult(result));
                    mutexLock.unlock();
                }
            }).show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
            mutexLock.setContent(KGResult.INSTANCE.getResult(KGResult.INSTANCE.getResult(4001, e.toString())));
            mutexLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> check2StepVerificationEmail() {
        KGResult<String> result;
        String name;
        FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.֬ڱܱײٮ(-1159479959), y.ٲٴݴ״ٰ(1782410008));
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159190071));
        try {
            try {
                result = DeviceProtectionService.INSTANCE.check2StepVerificationEmail();
                if (result.isNotSuccess()) {
                    result = KGResult.INSTANCE.getResult(result);
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            firebaseEvent.setResult(result);
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            firebaseEvent.setResult(null);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> register2StepVerificationEmail(String email) {
        KGResult<Void> result;
        String name;
        Intrinsics.checkNotNullParameter(email, y.֬ڱܱײٮ(-1159479551));
        FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.֬ڱܱײٮ(-1159479959), y.֬ڱܱײٮ(-1159196383));
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        String emailPublicKey = InfodeskHelper.INSTANCE.getEmailPublicKey();
        if (emailPublicKey == null || emailPublicKey.length() == 0) {
            return KGResult.INSTANCE.getResult(5001, y.ݬֲ֮ܲت(1512138375));
        }
        if (!Pattern.compile(y.ݮڮֲڭܩ(-628345284)).matcher(email).matches()) {
            return KGResult.INSTANCE.getResult(4000, y.٬ݯح׭٩(576424590));
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(576424806));
        try {
            try {
                KGResult<Void> register2StepVerificationEmail = DeviceProtectionService.INSTANCE.register2StepVerificationEmail(email);
                if (register2StepVerificationEmail.isNotSuccess()) {
                    result = KGResult.INSTANCE.getResult(register2StepVerificationEmail);
                } else {
                    result = KGResult.INSTANCE.getSuccessResult();
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            firebaseEvent.setResult(result);
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            firebaseEvent.setResult(null);
            throw th;
        }
    }

    /* compiled from: ProtectionManager.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\"\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004J\"\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007J(\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/security/ProtectionManager$CertificationPrefManager;", "", "()V", "PREFERENCE_NAME", "", "checkCertification", "context", "Landroid/content/Context;", "appId", "playerId", "getCertification", "removeCertification", "", "saveCertification", ServerConstants.CERTIFICATION, "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class CertificationPrefManager {
        public static final CertificationPrefManager INSTANCE = new CertificationPrefManager();
        private static final String PREFERENCE_NAME = "DeviceCertification";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CertificationPrefManager() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void saveCertification(Context context, String appId, String playerId, String certification) {
            String encryptIV;
            String encodeString;
            Intrinsics.checkNotNullParameter(appId, y.ۮڭڭܬި(862411867));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            Intrinsics.checkNotNullParameter(certification, y.ٴسسݬߨ(1393058762));
            String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
            if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null || (encodeString = AES256Cipher.encodeString(encryptKey, encryptIV, certification)) == null) {
                return;
            }
            PreferenceUtil.setString(context, PREFERENCE_NAME, appId + '_' + playerId, encodeString);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String checkCertification(Context context, String appId, String playerId) {
            Intrinsics.checkNotNullParameter(appId, y.ۮڭڭܬި(862411867));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            String certification = getCertification(context, appId, playerId);
            return certification == null || certification.length() == 0 ? "N" : "Y";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCertification(Context context, String appId, String playerId) {
            String encryptIV;
            Intrinsics.checkNotNullParameter(appId, y.ۮڭڭܬި(862411867));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            String string = PreferenceUtil.getString(context, PREFERENCE_NAME, appId + '_' + playerId, "");
            String str = string;
            if (str == null || str.length() == 0) {
                return string;
            }
            String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
            if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
                return null;
            }
            return AES256Cipher.decodeString(encryptKey, encryptIV, string);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static final void removeCertification(Context context, String appId, String playerId) {
            Intrinsics.checkNotNullParameter(appId, y.ۮڭڭܬި(862411867));
            Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            PreferenceUtil.removeKey(context, PREFERENCE_NAME, appId + '_' + playerId);
        }
    }
}
