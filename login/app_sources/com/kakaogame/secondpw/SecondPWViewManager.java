package com.kakaogame.secondpw;

import android.app.Activity;
import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.addon.KGService;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.secondpw.viewdata.PopupType;
import com.kakaogame.secondpw.viewdata.PopupViewData;
import com.kakaogame.secondpw.viewdata.RemoveGuideViewData;
import com.kakaogame.secondpw.viewdata.RemoveWarningViewData;
import com.kakaogame.secondpw.viewdata.ResetInputSMSCodeViewData;
import com.kakaogame.secondpw.viewdata.ResetInputTalkCodeViewData;
import com.kakaogame.secondpw.viewdata.RestrictPopupViewData;
import com.kakaogame.secondpw.viewdata.ResultData;
import com.kakaogame.secondpw.viewdata.SetInputEmailCodeViewData;
import com.kakaogame.secondpw.viewdata.SetInputEmailViewData;
import com.kakaogame.secondpw.viewdata.SetInputPhoneNumberViewData;
import com.kakaogame.secondpw.viewdata.SetInputSMSCodeViewData;
import com.kakaogame.secondpw.viewdata.SetInputTalkCodeViewData;
import com.kakaogame.security.ProtectionManager;
import com.kakaogame.security.SecondaryPWService;
import com.kakaogame.security.SendAuthCodeResult;
import com.kakaogame.security.SendAuthType;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.DeviceUtil;
import com.liapp.y;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: SecondPWViewManager.kt */
@Metadata(m838d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ4\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001c0\u001fJ\u0018\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010&\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0004H\u0002J\u0018\u0010(\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J(\u0010+\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u0004H\u0002J&\u0010-\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0011H\u0082@¢\u0006\u0002\u0010/J\u0018\u00100\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001e\u00101\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u00102R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, m839d2 = {"Lcom/kakaogame/secondpw/SecondPWViewManager;", "", "()V", "TAG", "", "keypads", "", "Lcom/kakaogame/secondpw/Keypad;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "publicKey", "check2ndPWOptionType", "Lcom/kakaogame/secondpw/viewdata/Base2ndPWViewData;", "activity", "Landroid/app/Activity;", "checkSettingPassword", SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, "Lcom/kakaogame/secondpw/ActionType;", "content", "getKeypadData", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "context", "Landroid/content/Context;", KGService.COUNT, "", "(Landroid/content/Context;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUIData", "", "action", "callback", "Lkotlin/Function1;", "matchPassword", "password", "removeFile", "requestRemove", "requestReset", "sendAuthCode", "sendAuthCodeEmail", "email", "sendAuthCodeSMS", ServerConstants.PHONE_NUMBER, "sendAuthCodeTalk", "setPassword", Base2ndPWViewData.KEY_CONFIRM, "verifyAuthCode", "code", "(Landroid/app/Activity;Ljava/lang/String;Lcom/kakaogame/secondpw/ActionType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyExistAuthCodeForRemove", "verifyExistAuthCodeForReset", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SecondPWViewManager {
    private static final String TAG = "SecondPWViewManager";
    public static final SecondPWViewManager INSTANCE = new SecondPWViewManager();
    private static String publicKey = "";
    private static List<Keypad> keypads = new ArrayList();
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    /* compiled from: SecondPWViewManager.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[SendAuthType.values().length];
            try {
                iArr[SendAuthType.TALK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ActionType.values().length];
            try {
                iArr2[ActionType.SET_CODE_TALK.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[ActionType.SET_CODE_SMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ActionType.SET_PASSWORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SecondPWViewManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void removeFile() {
        Iterator<T> it = keypads.iterator();
        while (it.hasNext()) {
            new File(((Keypad) it.next()).getPath()).delete();
        }
        keypads.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void getUIData$default(SecondPWViewManager secondPWViewManager, Activity activity, ActionType actionType, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "";
        }
        secondPWViewManager.getUIData(activity, actionType, str, function1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void getUIData(Activity activity, ActionType action, String content, Function1<? super Base2ndPWViewData, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(action, y.֬ڱܱײٮ(-1159583711));
        Intrinsics.checkNotNullParameter(content, y.֬ڱܱײٮ(-1159406207));
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SecondPWViewManager$getUIData$1(action, activity, content, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData sendAuthCode(Activity activity) {
        KGIdpProfile idpProfile;
        if (InfodeskHelper.INSTANCE.getSecondaryPasswordAuthType() == InfodeskHelper.SecondaryPWAuthType.EMAIL) {
            return new SetInputEmailViewData(activity);
        }
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        return ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode()) == KGIdpProfile.KGIdpCode.Kakao ? sendAuthCodeTalk(activity) : new SetInputPhoneNumberViewData(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Base2ndPWViewData sendAuthCodeTalk(Activity activity) {
        PopupViewData popupViewData;
        KGResult<SendAuthCodeResult> sendCodeWithKakaoTalk = SecondaryPWService.INSTANCE.sendCodeWithKakaoTalk();
        if (sendCodeWithKakaoTalk.isSuccess()) {
            SendAuthCodeResult content = sendCodeWithKakaoTalk.getContent();
            Intrinsics.checkNotNull(content);
            SendAuthCodeResult sendAuthCodeResult = content;
            if (sendAuthCodeResult.isSend()) {
                if (WhenMappings.$EnumSwitchMapping$0[sendAuthCodeResult.getAuthType().ordinal()] == 1) {
                    return new SetInputTalkCodeViewData(activity, InfodeskHelper.INSTANCE.getAuthCodeValidTime());
                }
                return new SetInputSMSCodeViewData(activity, sendAuthCodeResult.getAuthKey(), sendAuthCodeResult.getAuthKey(), InfodeskHelper.INSTANCE.getAuthCodeValidTime(), ActionType.SET_CODE_TALK);
            }
            return new SetInputPhoneNumberViewData(activity);
        }
        int code = sendCodeWithKakaoTalk.getCode();
        if (code == 462) {
            popupViewData = new PopupViewData(activity, PopupType.EXIT_PROCESS_ERROR, 0, 0, 0, 28, null);
        } else if (code == 467) {
            popupViewData = new PopupViewData(activity, PopupType.AUTH_CODE_TIME_ERROR, 0, 0, 0, 28, null);
        } else {
            popupViewData = new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
        }
        return popupViewData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData sendAuthCodeSMS(Activity activity, String phoneNumber) {
        if (phoneNumber.length() == 0) {
            return new PopupViewData(activity, PopupType.INVALID_PHONE_NUMBER_ERROR, 0, 0, 0, 28, null);
        }
        KGResult<SendAuthCodeResult> sendCodeWithSMS = SecondaryPWService.INSTANCE.sendCodeWithSMS(phoneNumber);
        int code = sendCodeWithSMS.getCode();
        if (code == 200) {
            SendAuthCodeResult content = sendCodeWithSMS.getContent();
            Intrinsics.checkNotNull(content);
            return new SetInputSMSCodeViewData(activity, phoneNumber, content.getAuthKey(), InfodeskHelper.INSTANCE.getAuthCodeValidTime(), null, 16, null);
        }
        if (code == 462) {
            return new PopupViewData(activity, PopupType.EXIT_PROCESS_ERROR, 0, 0, 0, 28, null);
        }
        if (code == 467) {
            return new PopupViewData(activity, PopupType.AUTH_CODE_TIME_ERROR, 0, 0, 0, 28, null);
        }
        if (code == 478) {
            return new PopupViewData(activity, PopupType.INVALID_PHONE_NUMBER_ERROR, 0, 0, 0, 28, null);
        }
        return new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData sendAuthCodeEmail(Activity activity, String email) {
        if (!Pattern.compile(y.ݮڮֲڭܩ(-628345284)).matcher(email).matches()) {
            return new PopupViewData(activity, PopupType.INVALID_EMAIL_ERROR, 0, 0, 0, 28, null);
        }
        KGResult<SendAuthCodeResult> sendCodeWithEmail = SecondaryPWService.INSTANCE.sendCodeWithEmail(email);
        int code = sendCodeWithEmail.getCode();
        if (code == 200) {
            SendAuthCodeResult content = sendCodeWithEmail.getContent();
            Intrinsics.checkNotNull(content);
            return new SetInputEmailCodeViewData(activity, email, content.getAuthKey(), InfodeskHelper.INSTANCE.getAuthCodeValidTime());
        }
        if (code == 462) {
            return new PopupViewData(activity, PopupType.EXIT_PROCESS_ERROR, 0, 0, 0, 28, null);
        }
        if (code == 467) {
            return new PopupViewData(activity, PopupType.AUTH_CODE_TIME_ERROR, 0, 0, 0, 28, null);
        }
        if (code == 472) {
            return new PopupViewData(activity, PopupType.INVALID_EMAIL_ERROR, 0, 0, 0, 28, null);
        }
        return new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object verifyAuthCode(android.app.Activity r18, java.lang.String r19, com.kakaogame.secondpw.ActionType r20, kotlin.coroutines.Continuation<? super com.kakaogame.secondpw.viewdata.Base2ndPWViewData> r21) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.secondpw.SecondPWViewManager.verifyAuthCode(android.app.Activity, java.lang.String, com.kakaogame.secondpw.ActionType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object verifyExistAuthCodeForReset(android.app.Activity r17, java.lang.String r18, kotlin.coroutines.Continuation<? super com.kakaogame.secondpw.viewdata.Base2ndPWViewData> r19) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.secondpw.SecondPWViewManager.verifyExistAuthCodeForReset(android.app.Activity, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData verifyExistAuthCodeForRemove(Activity activity, String code) {
        PopupViewData popupViewData;
        if (code.length() < 6) {
            return new PopupViewData(activity, PopupType.INVALID_AUTH_CODE_ERROR, 0, 0, 0, 28, null);
        }
        KGResult<Void> verifyExistAuthCode = SecondaryPWService.INSTANCE.verifyExistAuthCode(code);
        if (verifyExistAuthCode.getCode() == 462) {
            popupViewData = new PopupViewData(activity, PopupType.AUTH_CODE_LIMIT_ERROR, 0, 0, 0, 28, null);
        } else if (verifyExistAuthCode.getCode() == 461) {
            popupViewData = new PopupViewData(activity, PopupType.INVALID_AUTH_CODE_ERROR, 0, 0, 0, 28, null);
        } else if (verifyExistAuthCode.getCode() == 9999) {
            popupViewData = new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
        } else {
            popupViewData = SecondaryPWService.INSTANCE.deletePassword().isNotSuccess() ? new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null) : new PopupViewData(activity, PopupType.REMOVE_PASSWORD_COMPLETE, 0, 0, 0, 28, null);
        }
        return popupViewData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData requestReset(Activity activity) {
        KGResult<SendAuthCodeResult> sendCodeWithExistType = SecondaryPWService.INSTANCE.sendCodeWithExistType();
        if (sendCodeWithExistType.getCode() == 467) {
            return new PopupViewData(activity, PopupType.AUTH_CODE_TIME_ERROR, 0, 0, 0, 28, null);
        }
        if (sendCodeWithExistType.getCode() == 462) {
            return new PopupViewData(activity, PopupType.EXIT_PROCESS_ERROR, 0, 0, 0, 28, null);
        }
        if (!sendCodeWithExistType.isNotSuccess() && sendCodeWithExistType.getContent() != null) {
            SendAuthCodeResult content = sendCodeWithExistType.getContent();
            Intrinsics.checkNotNull(content);
            if (content.getAuthType() == SendAuthType.TALK) {
                return new ResetInputTalkCodeViewData(activity, InfodeskHelper.INSTANCE.getAuthCodeValidTime(), false, 4, null);
            }
            SendAuthCodeResult content2 = sendCodeWithExistType.getContent();
            Intrinsics.checkNotNull(content2);
            return new ResetInputSMSCodeViewData(activity, content2.getAuthKey(), InfodeskHelper.INSTANCE.getAuthCodeValidTime(), false, InfodeskHelper.INSTANCE.getSecondaryPasswordAuthType(), 8, null);
        }
        return new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData requestRemove(Activity activity) {
        KGResult<SendAuthCodeResult> sendCodeWithExistType = SecondaryPWService.INSTANCE.sendCodeWithExistType();
        if (sendCodeWithExistType.getCode() == 467) {
            return new PopupViewData(activity, PopupType.AUTH_CODE_TIME_ERROR, 0, 0, 0, 28, null);
        }
        if (sendCodeWithExistType.getCode() == 462) {
            return new PopupViewData(activity, PopupType.EXIT_PROCESS_ERROR, 0, 0, 0, 28, null);
        }
        if (!sendCodeWithExistType.isNotSuccess() && sendCodeWithExistType.getContent() != null) {
            SendAuthCodeResult content = sendCodeWithExistType.getContent();
            Intrinsics.checkNotNull(content);
            if (content.getAuthType() == SendAuthType.TALK) {
                return new ResetInputTalkCodeViewData(activity, InfodeskHelper.INSTANCE.getAuthCodeValidTime(), true);
            }
            SendAuthCodeResult content2 = sendCodeWithExistType.getContent();
            Intrinsics.checkNotNull(content2);
            return new ResetInputSMSCodeViewData(activity, content2.getAuthKey(), InfodeskHelper.INSTANCE.getAuthCodeValidTime(), true, InfodeskHelper.INSTANCE.getSecondaryPasswordAuthType());
        }
        return new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Object getKeypadData$default(SecondPWViewManager secondPWViewManager, Context context, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return secondPWViewManager.getKeypadData(context, i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005f A[Catch: all -> 0x0124, TryCatch #0 {all -> 0x0124, blocks: (B:11:0x0053, B:13:0x005f, B:14:0x007d, B:16:0x0083, B:18:0x0090, B:19:0x00a5, B:22:0x00de, B:30:0x00fc, B:31:0x00ff, B:32:0x009d, B:34:0x0100, B:36:0x0108, B:39:0x010f, B:40:0x0118, B:21:0x00d2, B:26:0x00fa), top: B:10:0x0053, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0118 A[Catch: all -> 0x0124, TRY_LEAVE, TryCatch #0 {all -> 0x0124, blocks: (B:11:0x0053, B:13:0x005f, B:14:0x007d, B:16:0x0083, B:18:0x0090, B:19:0x00a5, B:22:0x00de, B:30:0x00fc, B:31:0x00ff, B:32:0x009d, B:34:0x0100, B:36:0x0108, B:39:0x010f, B:40:0x0118, B:21:0x00d2, B:26:0x00fa), top: B:10:0x0053, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getKeypadData(android.content.Context r10, int r11, kotlin.coroutines.Continuation<? super com.kakaogame.KGResult<java.lang.Void>> r12) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.secondpw.SecondPWViewManager.getKeypadData(android.content.Context, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData matchPassword(Activity activity, String password) {
        ResultData resultData;
        if (password.length() != 6) {
            return new PopupViewData(activity, PopupType.INPUT_PASSWORD_PLEASE, 0, 0, 0, 28, null);
        }
        KGResult<Integer> matchPassword = SecondaryPWService.INSTANCE.matchPassword(password, publicKey);
        int code = matchPassword.getCode();
        if (code == 200) {
            if (ProtectionManager.INSTANCE.checkDeviceSecurityCompleted()) {
                resultData = new ResultData(200, DeviceUtil.getDeviceId(activity));
            } else {
                resultData = new ResultData(200, "");
            }
            return resultData;
        }
        if (code == 469) {
            return new PopupViewData(activity, PopupType.KEYPAD_TIME_LIMIT, 1, 0, 0, 24, null);
        }
        if (code != 563) {
            if (code == 565) {
                return new RestrictPopupViewData(activity, InfodeskHelper.INSTANCE.getPinFailLimitCount(), InfodeskHelper.INSTANCE.getPinFailBlockTime(), InfodeskHelper.INSTANCE.getPinFailBlockTime() * 60);
            }
            return new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
        }
        Integer content = matchPassword.getContent();
        if ((content != null ? content.intValue() : 1) == InfodeskHelper.INSTANCE.getPinFailLimitCount()) {
            return new RestrictPopupViewData(activity, InfodeskHelper.INSTANCE.getPinFailLimitCount(), InfodeskHelper.INSTANCE.getPinFailBlockTime(), InfodeskHelper.INSTANCE.getPinFailBlockTime() * 60);
        }
        Integer content2 = matchPassword.getContent();
        Intrinsics.checkNotNull(content2);
        return new PopupViewData(activity, PopupType.INPUT_PASSWORD_NOT_MATCHED, 0, content2.intValue(), InfodeskHelper.INSTANCE.getPinFailLimitCount(), 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Base2ndPWViewData setPassword(Activity activity, ActionType actionType, String password, String confirm) {
        PopupViewData popupViewData;
        int code = SecondaryPWService.INSTANCE.setPassword(password, confirm, publicKey).getCode();
        if (code == 200) {
            if (WhenMappings.$EnumSwitchMapping$1[actionType.ordinal()] == 3) {
                popupViewData = new PopupViewData(activity, PopupType.SET_PASSWORD_COMPLETE, 0, 0, 0, 28, null);
            } else {
                popupViewData = new PopupViewData(activity, PopupType.RESET_PASSWORD_COMPLETE, 0, 0, 0, 28, null);
            }
            return popupViewData;
        }
        if (code == 461) {
            return new PopupViewData(activity, PopupType.PASSWORD_NOT_MACHED, 0, 0, 0, 28, null);
        }
        if (code == 469) {
            return new PopupViewData(activity, PopupType.KEYPAD_TIME_LIMIT, 2, 0, 0, 24, null);
        }
        if (code == 568) {
            return new PopupViewData(activity, PopupType.SAME_PASSWORD_USED, 0, 0, 0, 28, null);
        }
        return new PopupViewData(activity, PopupType.DEFAULT_ERROR, 0, 0, 0, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData checkSettingPassword(Activity activity, ActionType actionType, String content) {
        List<String> split = new Regex(y.ݮڮֲڭܩ(-628345228)).split(content, 0);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = split.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((String) next).length() > 0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty() && ((String) arrayList2.get(0)).length() == 6) {
            if (arrayList2.size() != 1 && ((String) arrayList2.get(1)).length() == 6) {
                return setPassword(activity, actionType, (String) arrayList2.get(0), (String) arrayList2.get(1));
            }
            return new PopupViewData(activity, PopupType.CONFIRM_PASSWORD_INVALID, 0, 0, 0, 28, null);
        }
        return new PopupViewData(activity, PopupType.SET_PASSWORD_INVALID, 0, 0, 0, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Base2ndPWViewData check2ndPWOptionType(Activity activity) {
        return InfodeskHelper.INSTANCE.getSecondaryPasswordOptionType() == InfodeskHelper.SecondaryPWSettingType.MANDATORY ? new RemoveWarningViewData(activity) : new RemoveGuideViewData(activity, InfodeskHelper.INSTANCE.getSecondaryPasswordAuthType());
    }
}
