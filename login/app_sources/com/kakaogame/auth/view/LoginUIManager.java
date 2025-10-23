package com.kakaogame.auth.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.firebase.perf.FirebasePerformance;
import com.kakaogame.C2382R;
import com.kakaogame.KGCustomUI;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthService;
import com.kakaogame.auth.LoginData;
import com.kakaogame.auth.view.DatePickerDialog;
import com.kakaogame.auth.view.LoginUIManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.infodesk.InfodeskData;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: LoginUIManager.kt */
@Metadata(m838d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001FB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002J8\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002J8\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0002J\"\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0003J&\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010!J&\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010!J4\u0010#\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\t2\u001a\u0010\u0018\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0 \u0012\u0004\u0012\u00020\u00110$H\u0002J&\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020&H\u0087@¢\u0006\u0002\u0010'JJ\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000bH\u0002JY\u00100\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0004022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2)\u0010\u0018\u001a%\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 ¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u00110$H\u0002J<\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u0004022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\tH\u0087@¢\u0006\u0002\u00107J\"\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\b\u00109\u001a\u0004\u0018\u00010:H\u0007J6\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010=2\b\u00109\u001a\u0004\u0018\u00010:2\b\b\u0002\u0010>\u001a\u00020\u000bH\u0007J\u0018\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J&\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00109\u001a\u00020:H\u0087@¢\u0006\u0002\u0010AJR\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\u0006\u0010C\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0002J\u001a\u0010E\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010=H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006G"}, m839d2 = {"Lcom/kakaogame/auth/view/LoginUIManager;", "", "()V", "TAG", "", "getErrorMessage", "context", "Landroid/content/Context;", "code", "", "isUpAge", "", "year", "month", "day", "limitAge", "loginImpl", "", "activity", "Landroid/app/Activity;", "idpCode", "requestType", "Lcom/kakaogame/auth/view/LoginUIManager$RequestType;", "traceJobId", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "onSelectIdpCode", "sendToMail", "playerId", "sendEmailAddress", "showAgeLimitErrorPopup", "Lcom/kakaogame/KGResult;", "(Landroid/app/Activity;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCOPPA", "showCOPPADialog", "Lkotlin/Function1;", "showConnectCheckPopup", "Lcom/kakaogame/KGIdpProfile$KGIdpCode;", "(Landroid/app/Activity;Lcom/kakaogame/KGIdpProfile$KGIdpCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showDefaultView", "restrDay", "restrEndTime", "", "restrReason", "userId", ServerConstants.EMAIL_ADDRESS, "isRejoin", "showLoginDialog", "idpCodes", "", "Lkotlin/ParameterName;", "name", "result", "showLoginPopup", "(Landroid/app/Activity;Ljava/util/List;Lcom/kakaogame/auth/view/LoginUIManager$RequestType;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showProtection", "loginData", "Lcom/kakaogame/auth/LoginData;", "showPunishment", "idpAccount", "Lcom/kakaogame/idp/IdpAccount;", "saveAccount", "showRestrictAdolescent", "showUnregister", "(Landroid/app/Activity;Lcom/kakaogame/auth/LoginData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showUnregisterView", "restrMessage", "onetimeToken", "terminateAppAfterLogout", "RequestType", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class LoginUIManager {
    public static final LoginUIManager INSTANCE = new LoginUIManager();
    private static final String TAG = "LoginUIManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LoginUIManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isUpAge(int year, int month, int day, int limitAge) {
        String str = y.ݬֲ֮ܲت(1512382239);
        StringBuilder append = new StringBuilder(str).append(year);
        String str2 = y.ٴسسݬߨ(1393308826);
        StringBuilder append2 = append.append(str2).append(month);
        String str3 = y.دײܮڳܯ(2051356517);
        String sb = append2.append(str3).append(day).toString();
        String str4 = y.ٴسسݬߨ(1393296946);
        Log.d(str4, sb);
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        Intrinsics.checkNotNull(infodesk);
        Calendar serverCalendarOnPST = infodesk.getServerCalendarOnPST();
        int i = serverCalendarOnPST.get(1);
        int i2 = serverCalendarOnPST.get(2);
        int i3 = serverCalendarOnPST.get(5);
        Log.d(str4, str + i + str2 + i2 + str3 + i3);
        int i4 = i - year;
        if (i4 > limitAge) {
            return true;
        }
        if (i4 != limitAge) {
            return false;
        }
        if (i2 > month) {
            return true;
        }
        return i2 == month && i3 >= day;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showCOPPADialog(Activity activity, final int limitAge, final Function1<? super KGResult<Boolean>, Unit> callback) {
        try {
            new DatePickerDialog(activity, new DatePickerDialog.DatePickerListener() { // from class: com.kakaogame.auth.view.LoginUIManager$showCOPPADialog$listener$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.auth.view.DatePickerDialog.DatePickerListener
                public void onDatePick(int year, int month, int day) {
                    boolean isUpAge;
                    isUpAge = LoginUIManager.INSTANCE.isUpAge(year, month, day, limitAge);
                    callback.invoke(KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(isUpAge)));
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.auth.view.DatePickerDialog.DatePickerListener
                public void onUserCanceled() {
                    callback.invoke(KGResult.INSTANCE.getResult(9001, y.ݮڮֲڭܩ(-628653948), false));
                }
            }, limitAge).show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), y.֬ڱܱײٮ(-1159473103) + e, e);
            callback.invoke(KGResult.INSTANCE.getResult(4001, e.toString()));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object showCOPPA(Activity activity, int i, Continuation<? super KGResult<Boolean>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LoginUIManager$showCOPPA$2$1(activity, i, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object showAgeLimitErrorPopup(final Activity activity, int i, Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393296946), y.֬ڱܱײٮ(-1158914847));
        DialogManager.Settings settings = new DialogManager.Settings(null, null, ResourceUtil.getString(activity, y.٬ݯح׭٩(576702022), Boxing.boxInt(i)), null, null, null, null, null, false, null, null, null, null, 8187, null);
        settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$showAgeLimitErrorPopup$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                KGResult successResult = KGResult.INSTANCE.getSuccessResult();
                Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(successResult));
                dialogInterface.dismiss();
                AppUtil.terminateApp(activity);
            }
        });
        DialogManager.INSTANCE.showAlertDialog(activity, settings);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object showConnectCheckPopup(Activity activity, KGIdpProfile.KGIdpCode kGIdpCode, Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393296946), y.٬ݯح׭٩(576702398) + kGIdpCode);
        if (kGIdpCode != KGIdpProfile.KGIdpCode.Google) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult()));
        } else {
            DialogManager.Settings settings = new DialogManager.Settings(null, Boxing.boxInt(C2382R.string.kakao_game_sdk_connect_popup_title), null, Boxing.boxInt(C2382R.string.kakao_game_sdk_connect_popup_from_google), null, null, null, null, true, null, null, new DialogInterface.OnCancelListener() { // from class: com.kakaogame.auth.view.LoginUIManager$showConnectCheckPopup$2$settings$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    KGResult result = KGResult.INSTANCE.getResult(9001);
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(result));
                }
            }, null, 5877, null);
            settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$showConnectCheckPopup$2$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    KGResult successResult = KGResult.INSTANCE.getSuccessResult();
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(successResult));
                    dialogInterface.dismiss();
                }
            });
            settings.setNegativeButton(C2382R.string.zinny_sdk_common_button_cancel, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$showConnectCheckPopup$2$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    KGResult result = KGResult.INSTANCE.getResult(9001);
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(result));
                    dialogInterface.dismiss();
                }
            });
            DialogManager.INSTANCE.showAlertDialog(activity, settings);
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onSelectIdpCode(final Activity activity, final String idpCode, final RequestType requestType, final int traceJobId, final KGResultCallback<Void> callback) {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393296946), y.ݬֲ֮ܲت(1512385743) + idpCode);
        if (StringsKt.equals(KGIdpProfile.KGIdpCode.Guest.getCode(), idpCode, true)) {
            Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_GUEST_POPUP);
            DialogManager.Settings settings = new DialogManager.Settings(null, Integer.valueOf(C2382R.string.kakao_game_sdk_login_idp_guest_check_title), null, Integer.valueOf(C2382R.string.kakao_game_sdk_login_idp_guest_check_desc), null, null, null, null, true, null, null, new DialogInterface.OnCancelListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda20
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    LoginUIManager.onSelectIdpCode$lambda$3(KGResultCallback.this, dialogInterface);
                }
            }, null, 5877, null);
            settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda21
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LoginUIManager.onSelectIdpCode$lambda$4(traceJobId, activity, idpCode, requestType, callback, dialogInterface, i);
                }
            });
            settings.setNegativeButton(C2382R.string.zinny_sdk_common_button_cancel, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    LoginUIManager.onSelectIdpCode$lambda$5(traceJobId, callback, dialogInterface, i);
                }
            });
            DialogManager.INSTANCE.showAlertDialog(activity, settings);
            return;
        }
        loginImpl(activity, idpCode, requestType, traceJobId, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onSelectIdpCode$lambda$3(KGResultCallback callback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.onResult(KGResult.INSTANCE.getResult(9001));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onSelectIdpCode$lambda$4(int i, Activity activity, String idpCode, RequestType requestType, KGResultCallback callback, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(idpCode, "$idpCode");
        Intrinsics.checkNotNullParameter(requestType, "$requestType");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Tracer.INSTANCE.finishAction(i, TraceLoginActionCode.SDK_GUEST_POPUP, 200, y.ٴسسݬߨ(1392755458));
        INSTANCE.loginImpl(activity, idpCode, requestType, i, callback);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onSelectIdpCode$lambda$5(int i, KGResultCallback callback, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        KGResult result = KGResult.INSTANCE.getResult(9001);
        Tracer tracer = Tracer.INSTANCE;
        TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_GUEST_POPUP;
        int code = result.getCode();
        String description = result.getDescription();
        if (description == null) {
            description = result.toString();
        }
        tracer.finishAction(i, traceLoginActionCode, code, description);
        callback.onResult(result);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showLoginDialog(final Activity activity, final List<String> idpCodes, final RequestType requestType, final int traceJobId, final Function1<? super KGResult<Void>, Unit> callback) {
        try {
            final int requestedOrientation = activity.getRequestedOrientation();
            if (DisplayUtil.isScreenPortrait(activity)) {
                if (!DisplayUtil.INSTANCE.isZFlipSubScreenPortrait(activity)) {
                    activity.setRequestedOrientation(7);
                }
            } else {
                activity.setRequestedOrientation(6);
            }
            Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_LIST_POPUP);
            new LoginIDPListDialog(activity, idpCodes, requestType, new Function1<String, Unit>() { // from class: com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(1);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    activity.setRequestedOrientation(requestedOrientation);
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        KGResult<Void> result = KGResult.INSTANCE.getResult(9001);
                        Tracer tracer = Tracer.INSTANCE;
                        int i = traceJobId;
                        TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_LIST_POPUP;
                        int code = result.getCode();
                        String description = result.getDescription();
                        if (description == null) {
                            description = result.toString();
                        }
                        tracer.finishAction(i, traceLoginActionCode, code, description);
                        callback.invoke(result);
                        return;
                    }
                    Tracer.INSTANCE.finishAction(traceJobId, TraceLoginActionCode.SDK_IDP_LIST_POPUP, 200, y.ٴسسݬߨ(1392755458));
                    LoginUIManager.INSTANCE.onSelectIdpCode(activity, str, requestType, traceJobId, new C23891(callback, activity, idpCodes, requestType, traceJobId));
                }

                /* compiled from: LoginUIManager.kt */
                @Metadata(m838d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, m839d2 = {"com/kakaogame/auth/view/LoginUIManager$showLoginDialog$loginIDPListDialog$1$1", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "onResult", "", "result", "Lcom/kakaogame/KGResult;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
                /* renamed from: com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1$1 */
                public static final class C23891 implements KGResultCallback<Void> {
                    final /* synthetic */ Activity $activity;
                    final /* synthetic */ Function1<KGResult<Void>, Unit> $callback;
                    final /* synthetic */ List<String> $idpCodes;
                    final /* synthetic */ LoginUIManager.RequestType $requestType;
                    final /* synthetic */ int $traceJobId;

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    C23891(Function1<? super KGResult<Void>, Unit> function1, Activity activity, List<String> list, LoginUIManager.RequestType requestType, int i) {
                        this.$callback = function1;
                        this.$activity = activity;
                        this.$idpCodes = list;
                        this.$requestType = requestType;
                        this.$traceJobId = i;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(final KGResult<Void> result) {
                        if (result != null) {
                            int code = result.getCode();
                            if (code != 200) {
                                boolean z = true;
                                if (code == 403) {
                                    DialogManager dialogManager = DialogManager.INSTANCE;
                                    Activity activity = this.$activity;
                                    String errorMessage = LoginUIManager.INSTANCE.getErrorMessage(this.$activity, result.getCode());
                                    final Function1<KGResult<Void>, Unit> function1 = this.$callback;
                                    dialogManager.showErrorDialog(activity, errorMessage, true, 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006f: INVOKE 
                                          (r0v2 'dialogManager' com.kakaogame.ui.DialogManager)
                                          (r1v2 'activity' android.app.Activity)
                                          (r3v1 'errorMessage' java.lang.String)
                                          true
                                          (wrap:android.content.DialogInterface$OnDismissListener:0x006c: CONSTRUCTOR 
                                          (r4v2 'function1' kotlin.jvm.functions.Function1<com.kakaogame.KGResult<java.lang.Void>, kotlin.Unit> A[DONT_INLINE])
                                          (r11v0 'result' com.kakaogame.KGResult<java.lang.Void> A[DONT_INLINE])
                                         A[MD:(kotlin.jvm.functions.Function1, com.kakaogame.KGResult):void (m), WRAPPED] call: com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1$1$$ExternalSyntheticLambda0.<init>(kotlin.jvm.functions.Function1, com.kakaogame.KGResult):void type: CONSTRUCTOR)
                                         VIRTUAL call: com.kakaogame.ui.DialogManager.showErrorDialog(android.app.Activity, java.lang.String, boolean, android.content.DialogInterface$OnDismissListener):void A[MD:(android.app.Activity, java.lang.String, boolean, android.content.DialogInterface$OnDismissListener):void (m)] in method: com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1.1.onResult(com.kakaogame.KGResult<java.lang.Void>):void, file: classes3.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                                        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:310)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:782)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:97)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:878)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:317)
                                        	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
                                        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:402)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:390)
                                        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:340)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:305)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                        	... 120 more
                                        */
                                    /*
                                        this = this;
                                        if (r11 == 0) goto L78
                                        int r0 = r11.getCode()
                                        r1 = 200(0xc8, float:2.8E-43)
                                        if (r0 == r1) goto L73
                                        r1 = 403(0x193, float:5.65E-43)
                                        r2 = 1
                                        if (r0 == r1) goto L56
                                        r1 = 463(0x1cf, float:6.49E-43)
                                        if (r0 == r1) goto L73
                                        r1 = 4060(0xfdc, float:5.689E-42)
                                        if (r0 == r1) goto L73
                                        java.lang.String r0 = r11.getMessage()
                                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                                        r1 = 0
                                        if (r0 == 0) goto L28
                                        int r0 = r0.length()
                                        if (r0 != 0) goto L27
                                        goto L28
                                    L27:
                                        r2 = r1
                                    L28:
                                        if (r2 == 0) goto L3a
                                        com.kakaogame.auth.view.LoginUIManager r3 = com.kakaogame.auth.view.LoginUIManager.INSTANCE
                                        android.app.Activity r4 = r10.$activity
                                        java.util.List<java.lang.String> r5 = r10.$idpCodes
                                        com.kakaogame.auth.view.LoginUIManager$RequestType r6 = r10.$requestType
                                        int r7 = r10.$traceJobId
                                        kotlin.jvm.functions.Function1<com.kakaogame.KGResult<java.lang.Void>, kotlin.Unit> r8 = r10.$callback
                                        com.kakaogame.auth.view.LoginUIManager.access$showLoginDialog(r3, r4, r5, r6, r7, r8)
                                        goto L78
                                    L3a:
                                        com.kakaogame.ui.DialogManager r0 = com.kakaogame.p029ui.DialogManager.INSTANCE
                                        android.app.Activity r2 = r10.$activity
                                        java.lang.String r11 = r11.getMessage()
                                        android.app.Activity r4 = r10.$activity
                                        java.util.List<java.lang.String> r5 = r10.$idpCodes
                                        com.kakaogame.auth.view.LoginUIManager$RequestType r6 = r10.$requestType
                                        int r7 = r10.$traceJobId
                                        kotlin.jvm.functions.Function1<com.kakaogame.KGResult<java.lang.Void>, kotlin.Unit> r8 = r10.$callback
                                        com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1$1$$ExternalSyntheticLambda1 r9 = new com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1$1$$ExternalSyntheticLambda1
                                        r3 = r9
                                        r3.<init>(r4, r5, r6, r7, r8)
                                        r0.showErrorDialog(r2, r11, r1, r9)
                                        goto L78
                                    L56:
                                        com.kakaogame.ui.DialogManager r0 = com.kakaogame.p029ui.DialogManager.INSTANCE
                                        android.app.Activity r1 = r10.$activity
                                        com.kakaogame.auth.view.LoginUIManager r3 = com.kakaogame.auth.view.LoginUIManager.INSTANCE
                                        android.app.Activity r4 = r10.$activity
                                        android.content.Context r4 = (android.content.Context) r4
                                        int r5 = r11.getCode()
                                        java.lang.String r3 = r3.getErrorMessage(r4, r5)
                                        kotlin.jvm.functions.Function1<com.kakaogame.KGResult<java.lang.Void>, kotlin.Unit> r4 = r10.$callback
                                        com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1$1$$ExternalSyntheticLambda0 r5 = new com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1$1$$ExternalSyntheticLambda0
                                        r5.<init>(r4, r11)
                                        r0.showErrorDialog(r1, r3, r2, r5)
                                        goto L78
                                    L73:
                                        kotlin.jvm.functions.Function1<com.kakaogame.KGResult<java.lang.Void>, kotlin.Unit> r0 = r10.$callback
                                        r0.invoke(r11)
                                    L78:
                                        return
                                        fill-array 0x007a: FILL_ARRAY_DATA , data: ?
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.auth.view.LoginUIManager$showLoginDialog$loginIDPListDialog$1.C23891.onResult(com.kakaogame.KGResult):void");
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                public static final void onResult$lambda$0(Function1 callback, KGResult kGResult, DialogInterface dialogInterface) {
                                    Intrinsics.checkNotNullParameter(callback, "$callback");
                                    callback.invoke(kGResult);
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                public static final void onResult$lambda$1(Activity activity, List idpCodes, LoginUIManager.RequestType requestType, int i, Function1 callback, DialogInterface dialogInterface) {
                                    Intrinsics.checkNotNullParameter(activity, "$activity");
                                    Intrinsics.checkNotNullParameter(idpCodes, "$idpCodes");
                                    Intrinsics.checkNotNullParameter(requestType, "$requestType");
                                    Intrinsics.checkNotNullParameter(callback, "$callback");
                                    LoginUIManager.INSTANCE.showLoginDialog(activity, idpCodes, requestType, i, callback);
                                }
                            }
                        }).show();
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), y.دײܮڳܯ(2051350221) + e, e);
                        KGResult result = KGResult.INSTANCE.getResult(9001, e.toString());
                        Tracer.INSTANCE.finishAction(traceJobId, TraceLoginActionCode.SDK_IDP_LIST_POPUP, Tracer.INSTANCE.makeCustomErrorCode(traceJobId, 809), y.٬ݯح׭٩(576706958));
                        callback.invoke(result);
                    }
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @JvmStatic
                public static final Object showLoginPopup(Activity activity, List<String> list, RequestType requestType, int i, Continuation<? super KGResult<Void>> continuation) {
                    SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
                    SafeContinuation safeContinuation2 = safeContinuation;
                    Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393296946), y.֬ڱܱײٮ(-1158921343) + list);
                    try {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new LoginUIManager$showLoginPopup$2$1(activity, list, requestType, i, safeContinuation2, null), 3, null);
                    } catch (Exception e) {
                        Result.Companion companion = Result.INSTANCE;
                        safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
                    }
                    Object orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return orThrow;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private final void loginImpl(Activity activity, String idpCode, RequestType requestType, int traceJobId, KGResultCallback<Void> callback) {
                    Logger.INSTANCE.m704i(y.ٴسسݬߨ(1393296946), y.֬ڱܱײٮ(-1158915119) + idpCode);
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new LoginUIManager$loginImpl$1(requestType, activity, idpCode, traceJobId, callback, null), 3, null);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public final String getErrorMessage(Context context, int code) {
                    return code == 403 ? ResourceUtil.getString(context, C2382R.string.zinny_sdk_error_msg_login_forbidden) : ResourceUtil.getString(context, C2382R.string.zinny_sdk_error_msg_common, Integer.valueOf(code));
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private final void terminateAppAfterLogout(Activity activity, IdpAccount idpAccount) {
                    CoreManager.INSTANCE.getInstance().idpLogout(idpAccount);
                    AppUtil.terminateApp(activity);
                    AppUtil.killAppProcess();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static /* synthetic */ KGResult showPunishment$default(Activity activity, IdpAccount idpAccount, LoginData loginData, boolean z, int i, Object obj) {
                    if ((i & 8) != 0) {
                        z = true;
                    }
                    return showPunishment(activity, idpAccount, loginData, z);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @JvmStatic
                public static final KGResult<Void> showPunishment(Activity activity, IdpAccount idpAccount, LoginData loginData, boolean saveAccount) {
                    KGResult<Void> showDefaultView;
                    String str = y.ٲٴݴ״ٰ(1782161344);
                    String str2 = y.ݬֲ֮ܲت(1512387655);
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Logger logger = Logger.INSTANCE;
                    String str3 = y.دײܮڳܯ(2051349005) + loginData;
                    String str4 = y.ٴسسݬߨ(1393296946);
                    logger.m699d(str4, str3);
                    try {
                        if (loginData == null) {
                            return KGResult.INSTANCE.getResult(4000, "login data is null");
                        }
                        String playerId = loginData.getPlayerId();
                        String onetimeToken = loginData.getOnetimeToken();
                        String str5 = (String) loginData.get("restrReason");
                        String str6 = (String) loginData.get("restrMessage");
                        String str7 = str6 == null ? "" : str6;
                        String str8 = (String) loginData.get("csEmail");
                        String str9 = str8 == null ? "" : str8;
                        Number number = (Number) loginData.get("restrEndTime");
                        long longValue = number != null ? number.longValue() : 0L;
                        Number number2 = (Number) loginData.get("restrDay");
                        int intValue = number2 != null ? number2.intValue() : -2;
                        String str10 = (String) loginData.get("restrTag");
                        if (Intrinsics.areEqual(idpAccount != null ? idpAccount.getIdpCode() : null, KGIdpProfile.KGIdpCode.SigninWithApple.getCode()) && idpAccount.getIdpRefreshToken() == null) {
                            idpAccount.put("refreshToken", loginData.getSiwaRefreshToken());
                        }
                        if (Intrinsics.areEqual(str10, "normalBlock")) {
                            showDefaultView = INSTANCE.showUnregisterView(activity, intValue, longValue, str7, str5, onetimeToken, playerId, str9);
                        } else if (Intrinsics.areEqual(str10, "blockPlayerRejoin")) {
                            showDefaultView = INSTANCE.showDefaultView(activity, intValue, longValue, str5, loginData.getIdpId(), str9, true);
                        } else {
                            showDefaultView = INSTANCE.showDefaultView(activity, intValue, longValue, str5, playerId, str9, false);
                        }
                        if (showDefaultView.getCode() != 463) {
                            if (showDefaultView.getCode() != 9900) {
                                return showDefaultView;
                            }
                            INSTANCE.terminateAppAfterLogout(activity, idpAccount);
                            return showDefaultView;
                        }
                        if (Intrinsics.areEqual(idpAccount != null ? idpAccount.getIdpCode() : null, KGIdpProfile.KGIdpCode.SigninWithApple.getCode())) {
                            String idpRefreshToken = idpAccount.getIdpRefreshToken();
                            if (idpRefreshToken != null) {
                                AuthService.INSTANCE.revokeSIWA(playerId, idpRefreshToken);
                            }
                            Logger.INSTANCE.m699d(str4, str + CoreManager.INSTANCE.getInstance().idpLogout(idpAccount));
                        } else {
                            Logger.INSTANCE.m699d(str4, str2 + CoreManager.INSTANCE.getInstance().unregister(idpAccount));
                        }
                        if (saveAccount) {
                            return showDefaultView;
                        }
                        INSTANCE.terminateAppAfterLogout(activity, idpAccount);
                        return showDefaultView;
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(str4, e.toString(), e);
                        return KGResult.INSTANCE.getResult(4001, e.toString());
                    }
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private final KGResult<Void> showUnregisterView(final Activity activity, int restrDay, long restrEndTime, final String restrMessage, final String restrReason, final String onetimeToken, final String playerId, String emailAddress) {
                    String string;
                    if (restrDay >= 0) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ResourceUtil.getString(activity, C2382R.string.zinny_sdk_player_punishment_date_format), Locale.getDefault());
                        simpleDateFormat.setTimeZone(TimeZone.getDefault());
                        string = simpleDateFormat.format(new Date(restrEndTime));
                        Intrinsics.checkNotNull(string);
                    } else if (restrDay == -2) {
                        string = ResourceUtil.getString(activity, C2382R.string.zinny_sdk_player_punishment_term_temporary, playerId, restrReason);
                    } else {
                        string = ResourceUtil.getString(activity, C2382R.string.zinny_sdk_player_punishment_term_forever, playerId, restrReason);
                    }
                    final String str = string;
                    final MutexLock createLock = MutexLock.INSTANCE.createLock();
                    activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda0
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            LoginUIManager.showUnregisterView$lambda$8(activity, onetimeToken, playerId, restrReason, restrMessage, str, createLock);
                        }
                    });
                    MutexLock.lock$default(createLock, 0L, 1, null);
                    String str2 = (String) createLock.getContent();
                    if (!Intrinsics.areEqual(str2, PunishedUserDialog.INSTANCE.getRESULT_EMAIL())) {
                        return Intrinsics.areEqual(str2, PunishedUserDialog.INSTANCE.getRESULT_UNREGISTERED()) ? KGResult.INSTANCE.getResult(463) : KGResult.INSTANCE.getResult(9900);
                    }
                    sendToMail(activity, playerId, emailAddress);
                    return KGResult.INSTANCE.getResult(9900);
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showUnregisterView$lambda$8(Activity activity, String str, String str2, String str3, String str4, String str5, final MutexLock mutexLock) {
                    Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
                    Intrinsics.checkNotNullParameter(str, y.ٲٴݴ״ٰ(1782121800));
                    Intrinsics.checkNotNullParameter(str2, y.٬ݯح׭٩(576708326));
                    Intrinsics.checkNotNullParameter(str4, y.ٴسسݬߨ(1393302386));
                    Intrinsics.checkNotNullParameter(str5, y.ٴسسݬߨ(1393302522));
                    Intrinsics.checkNotNullParameter(mutexLock, y.֬ڱܱײٮ(-1158921879));
                    new PunishedUserDialog(activity, str, str2, str3 == null ? str4 : str3, str5, new Function1<String, Unit>() { // from class: com.kakaogame.auth.view.LoginUIManager$showUnregisterView$1$dialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        {
                            super(1);
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(String str6) {
                            invoke2(str6);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(String str6) {
                            mutexLock.setContent(str6);
                            mutexLock.unlock();
                        }
                    }).show();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private final KGResult<Void> showDefaultView(Activity activity, int restrDay, long restrEndTime, String restrReason, String userId, final String emailAddress, boolean isRejoin) {
                    String string;
                    final MutexLock mutexLock;
                    Activity activity2 = activity;
                    String string2 = ResourceUtil.getString(activity2, isRejoin ? C2382R.string.zinny_sdk_player_rejoin_punishment_title : C2382R.string.zinny_sdk_player_punishment_title);
                    if (restrDay >= 0) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_player_punishment_date_format), Locale.getDefault());
                        simpleDateFormat.setTimeZone(TimeZone.getDefault());
                        String format = simpleDateFormat.format(new Date(restrEndTime));
                        if (isRejoin) {
                            string = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_player_rejoin_punishment, userId, format);
                        } else {
                            string = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_player_punishment, userId, restrReason, format);
                        }
                    } else if (restrDay == -2) {
                        string = ResourceUtil.getString(activity2, isRejoin ? C2382R.string.zinny_sdk_player_rejoin_punishment_temporary : C2382R.string.zinny_sdk_player_punishment_temporary, userId, restrReason);
                    } else {
                        string = ResourceUtil.getString(activity2, isRejoin ? C2382R.string.zinny_sdk_player_rejoin_punishment_forever : C2382R.string.zinny_sdk_player_punishment_forever, userId, restrReason);
                    }
                    String str = string;
                    String string3 = ResourceUtil.getString(activity2, isRejoin ? C2382R.string.zinny_sdk_rejoin_punishment_ok_button : C2382R.string.zinny_sdk_common_button_close);
                    String string4 = ResourceUtil.getString(activity2, isRejoin ? C2382R.string.zinny_sdk_rejoin_punishment_inquire_button : C2382R.string.zinny_sdk_email_inquire_button);
                    if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE)) {
                        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda5
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showDefaultView$lambda$10();
                            }
                        });
                        if (CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, string2, str, string4, y.ݮڮֲڭܩ(-628607908), string3, y.֬ڱܱײٮ(-1159545887))) == y.ݮڮֲڭܩ(-628607908)) {
                            sendToMail(activity, userId, emailAddress);
                        }
                    } else {
                        MutexLock createLock = MutexLock.INSTANCE.createLock();
                        DialogManager.Settings settings = new DialogManager.Settings(string2, null, str, null, null, null, null, null, false, null, null, null, null, 8186, null);
                        if (isRejoin) {
                            mutexLock = createLock;
                            settings.setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda6
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LoginUIManager.showDefaultView$lambda$11(MutexLock.this, dialogInterface, i);
                                }
                            });
                            settings.setNegativeButton(string4, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda7
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LoginUIManager.showDefaultView$lambda$12(MutexLock.this, emailAddress, dialogInterface, i);
                                }
                            });
                        } else {
                            mutexLock = createLock;
                            settings.setPositiveButton(string4, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda8
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LoginUIManager.showDefaultView$lambda$13(MutexLock.this, emailAddress, dialogInterface, i);
                                }
                            });
                            settings.setNegativeButton(string3, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda9
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LoginUIManager.showDefaultView$lambda$14(MutexLock.this, dialogInterface, i);
                                }
                            });
                        }
                        DialogManager.INSTANCE.showAlertDialog(activity, settings);
                        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda10
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showDefaultView$lambda$16(MutexLock.this);
                            }
                        });
                        MutexLock.lock$default(mutexLock, 0L, 1, null);
                        sendToMail(activity, userId, (String) mutexLock.getContent());
                    }
                    return KGResult.INSTANCE.getResult(9900);
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$10() {
                    try {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda13
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showDefaultView$lambda$10$lambda$9();
                            }
                        }, 10000L);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), e.toString(), e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$10$lambda$9() {
                    CoreManager.INSTANCE.getInstance().onCustomUICallback(y.֬ڱܱײٮ(-1159545887));
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$11(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
                    Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
                    dialogLock.unlock();
                    dialogInterface.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$12(MutexLock dialogLock, String emailAddress, DialogInterface dialogInterface, int i) {
                    Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
                    Intrinsics.checkNotNullParameter(emailAddress, "$emailAddress");
                    dialogLock.setContent(emailAddress);
                    dialogLock.unlock();
                    dialogInterface.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$13(MutexLock dialogLock, String emailAddress, DialogInterface dialogInterface, int i) {
                    Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
                    Intrinsics.checkNotNullParameter(emailAddress, "$emailAddress");
                    dialogLock.setContent(emailAddress);
                    dialogLock.unlock();
                    dialogInterface.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$14(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
                    Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
                    dialogLock.unlock();
                    dialogInterface.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$16(final MutexLock mutexLock) {
                    Intrinsics.checkNotNullParameter(mutexLock, y.֬ڱܱײٮ(-1158921879));
                    try {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda16
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showDefaultView$lambda$16$lambda$15(MutexLock.this);
                            }
                        }, 10000L);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), e.toString(), e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showDefaultView$lambda$16$lambda$15(MutexLock mutexLock) {
                    Intrinsics.checkNotNullParameter(mutexLock, y.֬ڱܱײٮ(-1158921879));
                    mutexLock.unlock();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private final void sendToMail(Activity activity, String playerId, String sendEmailAddress) {
                    if (sendEmailAddress != null) {
                        Intent intent = new Intent(y.ݮڮֲڭܩ(-628607908));
                        Activity activity2 = activity;
                        intent.setData(Uri.parse(y.֬ڱܱײٮ(-1158914623) + sendEmailAddress + y.ٴسسݬߨ(1393295642) + Uri.encode(ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_email_title)) + y.֬ڱܱײٮ(-1158914911) + Uri.encode(ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_email_content_format, playerId))));
                        if (intent.resolveActivity(activity.getPackageManager()) != null) {
                            activity.startActivity(intent);
                        }
                    }
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @JvmStatic
                public static final KGResult<Void> showRestrictAdolescent(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Logger logger = Logger.INSTANCE;
                    String str = y.ۮڭڭܬި(862482491);
                    String str2 = y.ٴسسݬߨ(1393296946);
                    logger.m699d(str2, str);
                    try {
                        String string = ResourceUtil.getString(activity, C2382R.string.kakao_game_sdk_restrict_adolescent);
                        String string2 = ResourceUtil.getString(activity, C2382R.string.zinny_sdk_common_button_ok);
                        if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE)) {
                            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda2
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LoginUIManager.showRestrictAdolescent$lambda$18();
                                }
                            });
                            CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, "", string, "", "", string2, "customUI_close"));
                        } else {
                            final MutexLock createLock = MutexLock.INSTANCE.createLock();
                            DialogManager.Settings settings = new DialogManager.Settings(null, null, string, null, null, null, null, null, false, null, null, null, null, 8187, null);
                            settings.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda3
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LoginUIManager.showRestrictAdolescent$lambda$19(MutexLock.this, dialogInterface, i);
                                }
                            });
                            DialogManager.INSTANCE.showAlertDialog(activity, settings);
                            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda4
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LoginUIManager.showRestrictAdolescent$lambda$21(MutexLock.this);
                                }
                            });
                            MutexLock.lock$default(createLock, 0L, 1, null);
                        }
                        AppUtil.terminateApp(activity);
                        AppUtil.killAppProcess();
                        return KGResult.INSTANCE.getSuccessResult();
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(str2, e.toString(), e);
                        return KGResult.INSTANCE.getResult(4001, e.toString());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showRestrictAdolescent$lambda$18() {
                    try {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda11
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showRestrictAdolescent$lambda$18$lambda$17();
                            }
                        }, 10000L);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), e.toString(), e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showRestrictAdolescent$lambda$18$lambda$17() {
                    CoreManager.INSTANCE.getInstance().onCustomUICallback(y.֬ڱܱײٮ(-1159545887));
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showRestrictAdolescent$lambda$19(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
                    Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
                    dialogLock.unlock();
                    dialogInterface.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showRestrictAdolescent$lambda$21(final MutexLock mutexLock) {
                    Intrinsics.checkNotNullParameter(mutexLock, y.֬ڱܱײٮ(-1158921879));
                    try {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda14
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showRestrictAdolescent$lambda$21$lambda$20(MutexLock.this);
                            }
                        }, 10000L);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), e.toString(), e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showRestrictAdolescent$lambda$21$lambda$20(MutexLock mutexLock) {
                    Intrinsics.checkNotNullParameter(mutexLock, y.֬ڱܱײٮ(-1158921879));
                    mutexLock.unlock();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @JvmStatic
                public static final Object showUnregister(Activity activity, LoginData loginData, Continuation<? super KGResult<Void>> continuation) {
                    SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
                    final SafeContinuation safeContinuation2 = safeContinuation;
                    Logger logger = Logger.INSTANCE;
                    String str = y.٬ݯح׭٩(576708094) + loginData;
                    String str2 = y.ٴسسݬߨ(1393296946);
                    logger.m699d(str2, str);
                    try {
                        DialogManager.Settings settings = new DialogManager.Settings(null, null, null, Boxing.boxInt(C2382R.string.zinny_sdk_player_unregister), null, null, null, null, false, null, null, null, null, 8183, null);
                        settings.setPositiveButton(C2382R.string.zinny_sdk_player_unregister_restore, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$showUnregister$2$1
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                KGResult successResult = KGResult.INSTANCE.getSuccessResult();
                                Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                                Result.Companion companion = Result.INSTANCE;
                                continuation2.resumeWith(Result.m1440constructorimpl(successResult));
                                dialogInterface.dismiss();
                            }
                        });
                        settings.setNegativeButton(C2382R.string.zinny_sdk_player_unregister_no, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$showUnregister$2$2
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                KGResult result = KGResult.INSTANCE.getResult(463);
                                Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                                Result.Companion companion = Result.INSTANCE;
                                continuation2.resumeWith(Result.m1440constructorimpl(result));
                                dialogInterface.dismiss();
                            }
                        });
                        DialogManager.INSTANCE.showAlertDialog(activity, settings);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(str2, e.toString(), e);
                        Result.Companion companion = Result.INSTANCE;
                        safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
                    }
                    Object orThrow = safeContinuation.getOrThrow();
                    if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return orThrow;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @JvmStatic
                public static final KGResult<Void> showProtection(Activity activity, LoginData loginData) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Logger logger = Logger.INSTANCE;
                    String str = y.ݮڮֲڭܩ(-628610276) + loginData;
                    String str2 = y.ٴسسݬߨ(1393296946);
                    logger.m699d(str2, str);
                    try {
                        if (loginData == null) {
                            return KGResult.INSTANCE.getResult(4000, "login data is null");
                        }
                        String str3 = (String) loginData.get("message");
                        String str4 = (String) loginData.get("buttonName");
                        String str5 = (String) loginData.get("certificationUrl");
                        if (str5 == null) {
                            str5 = "";
                        }
                        boolean hasCustomAlertHandler = CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE);
                        String str6 = y.ٲٴݴ״ٰ(1781642640);
                        if (hasCustomAlertHandler) {
                            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda17
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LoginUIManager.showProtection$lambda$24();
                                }
                            });
                            if (CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, null, str3, str4, "android.intent.action.VIEW", null, null)) == str6) {
                                Intent intent = new Intent(str6);
                                intent.setData(Uri.parse(str5));
                                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                                    activity.startActivity(intent);
                                }
                            }
                        } else {
                            final MutexLock createLock = MutexLock.INSTANCE.createLock();
                            DialogManager.Settings settings = new DialogManager.Settings(null, null, str3, null, null, null, null, null, false, null, null, null, null, 8187, null);
                            if (str4 == null) {
                                str4 = "";
                            }
                            settings.setPositiveButton(str4, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda18
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    LoginUIManager.showProtection$lambda$25(MutexLock.this, dialogInterface, i);
                                }
                            });
                            DialogManager.INSTANCE.showAlertDialog(activity, settings);
                            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda19
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    LoginUIManager.showProtection$lambda$27(MutexLock.this);
                                }
                            });
                            MutexLock.lock$default(createLock, 0L, 1, null);
                            Object content = createLock.getContent();
                            Intrinsics.checkNotNull(content);
                            if (((KGResult) content).isSuccess()) {
                                Intent intent2 = new Intent(str6);
                                intent2.setData(Uri.parse(str5));
                                if (intent2.resolveActivity(activity.getPackageManager()) != null) {
                                    activity.startActivity(intent2);
                                }
                            }
                        }
                        AppUtil.terminateApp(activity);
                        AppUtil.killAppProcess();
                        return KGResult.INSTANCE.getSuccessResult();
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(str2, e.toString(), e);
                        return KGResult.INSTANCE.getResult(4001, e.toString());
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showProtection$lambda$24() {
                    try {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda12
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showProtection$lambda$24$lambda$23();
                            }
                        }, 10000L);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), e.toString(), e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showProtection$lambda$24$lambda$23() {
                    CoreManager.INSTANCE.getInstance().onCustomUICallback(y.֬ڱܱײٮ(-1159545887));
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showProtection$lambda$25(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
                    Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
                    dialogLock.setContent(KGResult.INSTANCE.getSuccessResult());
                    dialogLock.unlock();
                    dialogInterface.dismiss();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showProtection$lambda$27(final MutexLock mutexLock) {
                    Intrinsics.checkNotNullParameter(mutexLock, y.֬ڱܱײٮ(-1158921879));
                    try {
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.kakaogame.auth.view.LoginUIManager$$ExternalSyntheticLambda15
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                LoginUIManager.showProtection$lambda$27$lambda$26(MutexLock.this);
                            }
                        }, 10000L);
                    } catch (Exception e) {
                        Logger.INSTANCE.m702e(y.ٴسسݬߨ(1393296946), e.toString(), e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public static final void showProtection$lambda$27$lambda$26(MutexLock mutexLock) {
                    Intrinsics.checkNotNullParameter(mutexLock, y.֬ڱܱײٮ(-1158921879));
                    mutexLock.setContent(KGResult.INSTANCE.getResult(9001));
                    mutexLock.unlock();
                }

                /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
                /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
                /* compiled from: LoginUIManager.kt */
                @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/auth/view/LoginUIManager$RequestType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "LOGIN", FirebasePerformance.HttpMethod.CONNECT, "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
                public static final class RequestType {
                    private static final /* synthetic */ EnumEntries $ENTRIES;
                    private static final /* synthetic */ RequestType[] $VALUES;

                    /* renamed from: Companion, reason: from kotlin metadata */
                    public static final Companion INSTANCE;
                    private int value;
                    public static final RequestType LOGIN = new RequestType(y.ۮڭڭܬި(862499747), 0, 0);
                    public static final RequestType CONNECT = new RequestType(y.ݬֲ֮ܲت(1512436055), 1, 1);

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    private static final /* synthetic */ RequestType[] $values() {
                        return new RequestType[]{LOGIN, CONNECT};
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    public static EnumEntries<RequestType> getEntries() {
                        return $ENTRIES;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    public static RequestType valueOf(String str) {
                        return (RequestType) Enum.valueOf(RequestType.class, str);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    public static RequestType[] values() {
                        return (RequestType[]) $VALUES.clone();
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    private RequestType(String str, int i, int i2) {
                        this.value = i2;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    public final int getValue() {
                        return this.value;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    public final void setValue(int i) {
                        this.value = i;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    static {
                        RequestType[] $values = $values();
                        $VALUES = $values;
                        $ENTRIES = EnumEntriesKt.enumEntries($values);
                        INSTANCE = new Companion(null);
                    }

                    /* compiled from: LoginUIManager.kt */
                    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/auth/view/LoginUIManager$RequestType$Companion;", "", "()V", "getCode", "Lcom/kakaogame/auth/view/LoginUIManager$RequestType;", "value", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
                    public static final class Companion {
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                            this();
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        private Companion() {
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        public final RequestType getCode(int value) {
                            if (value == 0) {
                                return RequestType.LOGIN;
                            }
                            return RequestType.CONNECT;
                        }
                    }
                }
            }
