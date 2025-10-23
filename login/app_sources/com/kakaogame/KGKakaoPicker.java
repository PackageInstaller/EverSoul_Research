package com.kakaogame;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Pair;
import com.kakao.sdk.friend.client.PickerClient;
import com.kakao.sdk.friend.model.DisableSelectOption;
import com.kakao.sdk.friend.model.DisableSelectReason;
import com.kakao.sdk.friend.model.PickerFriendFilter;
import com.kakao.sdk.friend.model.PickerOrientation;
import com.kakao.sdk.friend.model.PickerServiceTypeFilter;
import com.kakao.sdk.friend.model.PickerUsingOsFilter;
import com.kakao.sdk.friend.model.SelectedUser;
import com.kakao.sdk.friend.model.SelectedUsers;
import com.kakao.sdk.friend.model.ViewAppearance;
import com.kakao.sdk.partner.friend.client.PickerClientKt;
import com.kakao.sdk.partner.friend.model.PickerFriendRequestParams;
import com.kakaogame.KGCustomUI;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoPicker;
import com.kakaogame.KGResult;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.kakao.KakaoManager;
import com.kakaogame.kakao.KakaoUtil;
import com.kakaogame.kakao.UserProfile;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.server.InhouseGWService;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoPicker.kt */
@Metadata(m838d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001*B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ8\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0002JD\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00160\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0002JF\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00160\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0002JR\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\u0016\u0010\u001c\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016\u0018\u00010\u001dH\u0007J\u0018\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000f2\u0006\u0010 \u001a\u00020!H\u0002J@\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0002JL\u0010\"\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u001dH\u0007J \u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J,\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016H\u0082@¢\u0006\u0002\u0010$J,\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00160\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010&J&\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010&J\u001e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006+"}, m839d2 = {"Lcom/kakaogame/KGKakaoPicker;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "createPickerParams", "Lcom/kakao/sdk/partner/friend/model/PickerFriendRequestParams;", "isSingle", "", "isPortrait", "initInterfaceBroker", "", "initialize", "sendInvitationMessage", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/KGKakaoPicker$KGKakaoUser;", "kakaoUser", "templateId", "args", "", "sendInvitationMessages", "", "kakaoUsers", "sendMultiInviteMessage", "activity", "Landroid/app/Activity;", "isPopup", "callback", "Lcom/kakaogame/KGResultCallback;", "sendRequestWithScope", "Ljava/lang/Void;", "requestData", "Lcom/kakaogame/server/ServerRequest;", "sendSingleInviteMessage", "showInvitationDialog", "(Landroid/app/Activity;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showMultiFriendPicker", "(Landroid/app/Activity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSingleFriendPicker", "showUnavailableDialog", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "KGKakaoUser", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoPicker {
    private static final String CLASS_NAME_KEY;
    public static final KGKakaoPicker INSTANCE = new KGKakaoPicker();
    private static final String TAG;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoPicker() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        String str = y.֬ڱܱײٮ(-1159542919);
        TAG = str;
        CLASS_NAME_KEY = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendSingleInviteMessage(Activity activity, boolean isPopup, String templateId, Map<String, String> args, KGResultCallback<KGKakaoUser> callback) {
        Intrinsics.checkNotNullParameter(templateId, y.ۮڭڭܬި(862266835));
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.m706v(str, y.֬ڱܱײٮ(-1159548447) + activity + y.ۮڭڭܬި(862386995) + isPopup + y.ݮڮֲڭܩ(-628709828) + templateId);
        if (callback == null) {
            Logger.INSTANCE.m708w(str, y.دײܮڳܯ(2051796069));
        }
        if (activity != null && !activity.isFinishing()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoPicker$sendSingleInviteMessage$1(activity, isPopup, templateId, args, callback, null), 3, null);
            return;
        }
        KGResult<KGKakaoUser> result = KGResult.INSTANCE.getResult(4000, "'activity' is null or not running.");
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendMultiInviteMessage(Activity activity, boolean isPopup, String templateId, Map<String, String> args, KGResultCallback<List<KGKakaoUser>> callback) {
        Intrinsics.checkNotNullParameter(templateId, y.ۮڭڭܬި(862266835));
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.m706v(str, y.֬ڱܱײٮ(-1159541271) + activity + y.ۮڭڭܬި(862386995) + isPopup + y.ݮڮֲڭܩ(-628709828) + templateId);
        if (callback == null) {
            Logger.INSTANCE.m708w(str, y.ݮڮֲڭܩ(-628709748));
        }
        if (activity != null && !activity.isFinishing()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoPicker$sendMultiInviteMessage$1(activity, isPopup, templateId, args, callback, null), 3, null);
            return;
        }
        KGResult<List<KGKakaoUser>> result = KGResult.INSTANCE.getResult(4000, "'activity' is null or not running.");
        if (callback != null) {
            callback.onResult(result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGKakaoUser> sendSingleInviteMessage(Activity activity, boolean isPopup, String templateId, Map<String, String> args) {
        Object runBlocking$default;
        Object runBlocking$default2;
        KGIdpProfile idpProfile;
        KGIdpProfile idpProfile2;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Kakao;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        KGIdpProfile.KGIdpCode kGIdpCode2 = null;
        if (kGIdpCode != ((currentPlayer == null || (idpProfile2 = currentPlayer.getIdpProfile()) == null) ? null : idpProfile2.getIdpCode())) {
            KGResult.Companion companion = KGResult.INSTANCE;
            StringBuilder sb = new StringBuilder("IDP is not Kakao: ");
            KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            if (currentPlayer2 != null && (idpProfile = currentPlayer2.getIdpProfile()) != null) {
                kGIdpCode2 = idpProfile.getIdpCode();
            }
            return companion.getResult(5001, sb.append(kGIdpCode2).toString());
        }
        if (!KakaoManager.isTalkUser()) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, "onNotKakaoTalkUser");
        }
        UserProfile content = KakaoManager.loadProfile().getContent();
        boolean z = false;
        if (content != null && content.getRemainingInviteCount() == 0) {
            z = true;
        }
        if (!z) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakaoPicker$sendSingleInviteMessage$friendPickerResult$1(activity, isPopup, null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default;
            Logger.INSTANCE.m699d(TAG, y.ݬֲ֮ܲت(1512815551) + kGResult);
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Object content2 = kGResult.getContent();
            Intrinsics.checkNotNull(content2);
            KGKakaoUser kGKakaoUser = (KGKakaoUser) content2;
            KGResult<Void> showInvitationDialog = showInvitationDialog(activity, kGKakaoUser);
            if (showInvitationDialog.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(showInvitationDialog);
            }
            return sendInvitationMessage(kGKakaoUser, templateId, args);
        }
        KGResult.Companion companion2 = KGResult.INSTANCE;
        runBlocking$default2 = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakaoPicker$sendSingleInviteMessage$2(activity, null), 1, null);
        return companion2.getResult((Map<String, ? extends Object>) runBlocking$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<List<KGKakaoUser>> sendMultiInviteMessage(Activity activity, boolean isPopup, String templateId, Map<String, String> args) {
        Object runBlocking$default;
        Object runBlocking$default2;
        Object runBlocking$default3;
        KGIdpProfile idpProfile;
        KGIdpProfile idpProfile2;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Kakao;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        KGIdpProfile.KGIdpCode kGIdpCode2 = null;
        if (kGIdpCode != ((currentPlayer == null || (idpProfile2 = currentPlayer.getIdpProfile()) == null) ? null : idpProfile2.getIdpCode())) {
            KGResult.Companion companion = KGResult.INSTANCE;
            StringBuilder sb = new StringBuilder("IDP is not Kakao: ");
            KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            if (currentPlayer2 != null && (idpProfile = currentPlayer2.getIdpProfile()) != null) {
                kGIdpCode2 = idpProfile.getIdpCode();
            }
            return companion.getResult(5001, sb.append(kGIdpCode2).toString());
        }
        if (!KakaoManager.isTalkUser()) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, "onNotKakaoTalkUser");
        }
        UserProfile content = KakaoManager.loadProfile().getContent();
        boolean z = false;
        if (content != null && content.getRemainingInviteCount() == 0) {
            z = true;
        }
        if (!z) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakaoPicker$sendMultiInviteMessage$friendPickerResult$1(activity, isPopup, null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default;
            Logger.INSTANCE.m699d(TAG, y.ݬֲ֮ܲت(1512815551) + kGResult);
            if (kGResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            Object content2 = kGResult.getContent();
            Intrinsics.checkNotNull(content2);
            List<KGKakaoUser> list = (List) content2;
            runBlocking$default2 = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakaoPicker$sendMultiInviteMessage$dialogResult$1(activity, list, null), 1, null);
            KGResult kGResult2 = (KGResult) runBlocking$default2;
            if (kGResult2.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kGResult2);
            }
            return sendInvitationMessages(list, templateId, args);
        }
        KGResult.Companion companion2 = KGResult.INSTANCE;
        runBlocking$default3 = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakaoPicker$sendMultiInviteMessage$2(activity, null), 1, null);
        return companion2.getResult((Map<String, ? extends Object>) runBlocking$default3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showSingleFriendPicker(final Activity activity, final boolean z, Continuation<? super KGResult<KGKakaoUser>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m706v(TAG, y.دײܮڳܯ(2051793509));
        try {
            final PickerFriendRequestParams createPickerParams = INSTANCE.createPickerParams(true, DisplayUtil.isScreenPortrait(activity));
            final Function2<SelectedUsers, Throwable, Unit> function2 = new Function2<SelectedUsers, Throwable, Unit>() { // from class: com.kakaogame.KGKakaoPicker$showSingleFriendPicker$2$callback$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SelectedUsers selectedUsers, Throwable th) {
                    invoke2(selectedUsers, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SelectedUsers selectedUsers, Throwable th) {
                    String str;
                    String str2;
                    Unit unit;
                    List<SelectedUser> users;
                    if (th == null) {
                        Logger logger = Logger.INSTANCE;
                        str2 = KGKakaoPicker.TAG;
                        logger.m699d(str2, "성공");
                        if (selectedUsers == null || (users = selectedUsers.getUsers()) == null) {
                            unit = null;
                        } else {
                            Continuation<KGResult<KGKakaoPicker.KGKakaoUser>> continuation2 = safeContinuation2;
                            Result.Companion companion = Result.INSTANCE;
                            continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(new KGKakaoPicker.KGKakaoUser(users.get(0)))));
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            KGKakaoPicker kGKakaoPicker = KGKakaoPicker.INSTANCE;
                            Continuation<KGResult<KGKakaoPicker.KGKakaoUser>> continuation3 = safeContinuation2;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(2003)));
                            return;
                        }
                        return;
                    }
                    Logger logger2 = Logger.INSTANCE;
                    str = KGKakaoPicker.TAG;
                    logger2.m701e(str, "실패");
                    Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                    Continuation<KGResult<KGKakaoPicker.KGKakaoUser>> continuation4 = safeContinuation2;
                    KGResult.Companion companion3 = KGResult.INSTANCE;
                    Object obj = classifyKakaoError.first;
                    Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                    KGResult result = companion3.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second);
                    Result.Companion companion4 = Result.INSTANCE;
                    continuation4.resumeWith(Result.m1440constructorimpl(result));
                }
            };
            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.KGKakaoPicker$showSingleFriendPicker$2$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    if (z) {
                        PickerClientKt.selectFriendPopup(PickerClient.INSTANCE.getInstance(), activity, createPickerParams, function2);
                    } else {
                        PickerClientKt.selectFriend(PickerClient.INSTANCE.getInstance(), activity, createPickerParams, function2);
                    }
                }
            });
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showMultiFriendPicker(final Activity activity, final boolean z, Continuation<? super KGResult<List<KGKakaoUser>>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m706v(TAG, y.ۮڭڭܬި(862359147));
        try {
            final PickerFriendRequestParams createPickerParams = INSTANCE.createPickerParams(false, DisplayUtil.isScreenPortrait(activity));
            final Function2<SelectedUsers, Throwable, Unit> function2 = new Function2<SelectedUsers, Throwable, Unit>() { // from class: com.kakaogame.KGKakaoPicker$showMultiFriendPicker$2$callback$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SelectedUsers selectedUsers, Throwable th) {
                    invoke2(selectedUsers, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SelectedUsers selectedUsers, Throwable th) {
                    String str;
                    String str2;
                    Unit unit;
                    List<SelectedUser> users;
                    if (th == null) {
                        Logger logger = Logger.INSTANCE;
                        str2 = KGKakaoPicker.TAG;
                        logger.m699d(str2, "성공");
                        if (selectedUsers == null || (users = selectedUsers.getUsers()) == null) {
                            unit = null;
                        } else {
                            Continuation<KGResult<List<KGKakaoPicker.KGKakaoUser>>> continuation2 = safeContinuation2;
                            List<SelectedUser> list = users;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new KGKakaoPicker.KGKakaoUser((SelectedUser) it.next()));
                            }
                            Result.Companion companion = Result.INSTANCE;
                            continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(arrayList)));
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            KGKakaoPicker kGKakaoPicker = KGKakaoPicker.INSTANCE;
                            Continuation<KGResult<List<KGKakaoPicker.KGKakaoUser>>> continuation3 = safeContinuation2;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(2003)));
                            return;
                        }
                        return;
                    }
                    Logger logger2 = Logger.INSTANCE;
                    str = KGKakaoPicker.TAG;
                    logger2.m701e(str, "실패");
                    Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                    Continuation<KGResult<List<KGKakaoPicker.KGKakaoUser>>> continuation4 = safeContinuation2;
                    KGResult.Companion companion3 = KGResult.INSTANCE;
                    Object obj = classifyKakaoError.first;
                    Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                    KGResult result = companion3.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second);
                    Result.Companion companion4 = Result.INSTANCE;
                    continuation4.resumeWith(Result.m1440constructorimpl(result));
                }
            };
            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.KGKakaoPicker$showMultiFriendPicker$2$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    if (z) {
                        PickerClientKt.selectFriendsPopup(PickerClient.INSTANCE.getInstance(), activity, createPickerParams, function2);
                    } else {
                        PickerClientKt.selectFriends(PickerClient.INSTANCE.getInstance(), activity, createPickerParams, function2);
                    }
                }
            });
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
    private final PickerFriendRequestParams createPickerParams(boolean isSingle, boolean isPortrait) {
        ArrayList arrayList;
        PickerOrientation pickerOrientation;
        UserProfile userProfile;
        KGResult<List<String>> invitationHistory = InhouseGWService.getInvitationHistory();
        if (invitationHistory.isNotSuccess()) {
            arrayList = new ArrayList();
        } else {
            List<String> content = invitationHistory.getContent();
            arrayList = content == null || content.isEmpty() ? new ArrayList() : CollectionsKt.mutableListOf(new DisableSelectOption(DisableSelectReason.CUSTOM, "초대완료", invitationHistory.getContent()));
        }
        arrayList.add(new DisableSelectOption(DisableSelectReason.REGISTERED, null, null, 6, null));
        arrayList.add(new DisableSelectOption(DisableSelectReason.MSG_BLOCKED, null, null, 6, null));
        arrayList.add(new DisableSelectOption(DisableSelectReason.NOT_FRIEND, null, null, 6, null));
        if (Build.VERSION.SDK_INT == 26) {
            pickerOrientation = PickerOrientation.AUTO;
        } else if (isPortrait) {
            pickerOrientation = PickerOrientation.PORTRAIT;
        } else {
            pickerOrientation = PickerOrientation.LANDSCAPE;
        }
        return new PickerFriendRequestParams(null, PickerServiceTypeFilter.TALK, PickerFriendFilter.INVITABLE, null, PickerUsingOsFilter.ALL, ViewAppearance.AUTO, pickerOrientation, true, true, false, true, arrayList, true, isSingle ? null : true, (isSingle || (userProfile = KakaoManager.getUserProfile()) == null) ? null : Integer.valueOf(userProfile.getRemainingInviteCount()), isSingle ? null : 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> sendRequestWithScope(ServerRequest requestData) {
        ServerResult requestServer$default = ServerService.requestServer$default(requestData, 0, 2, null);
        if (requestServer$default.isNotSuccess()) {
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            String str = y.دײܮڳܯ(2051777077);
            if (content.containsKey((Object) str)) {
                List<String> list = (List) content.get((Object) str);
                Logger logger = Logger.INSTANCE;
                String str2 = TAG;
                logger.m699d(str2, y.٬ݯح׭٩(575760134) + list);
                KGKakao2Auth.Companion companion = KGKakao2Auth.INSTANCE;
                Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
                Intrinsics.checkNotNull(list);
                KGResult<String> updateScope = companion.updateScope(activity, list);
                if (updateScope.isSuccess()) {
                    ServerResult requestServer$default2 = ServerService.requestServer$default(requestData, 0, 2, null);
                    if (requestServer$default2.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(requestServer$default2);
                    }
                } else {
                    Logger.INSTANCE.m699d(str2, y.ݮڮֲڭܩ(-628713572) + updateScope);
                    return KGResult.INSTANCE.getResult(9001, y.ٲٴݴ״ٰ(1782031224));
                }
            } else {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<KGKakaoUser> sendInvitationMessage(KGKakaoUser kakaoUser, String templateId, Map<String, String> args) {
        KGResult<KGKakaoUser> result;
        String str = y.ۮڭڭܬި(862387379);
        Logger logger = Logger.INSTANCE;
        String str2 = TAG;
        logger.m706v(str2, y.ٴسسݬߨ(1392678642));
        try {
            KGResult<Void> sendRequestWithScope = sendRequestWithScope(InhouseGWService.getSendInvitationMessageRequest(kakaoUser.getUuid(), templateId, args));
            KakaoUtil.convertResultCode(sendRequestWithScope);
            Logger.INSTANCE.m699d(str2, str + sendRequestWithScope);
            if (sendRequestWithScope.isSuccess()) {
                result = KGResult.INSTANCE.getSuccessResult(kakaoUser);
            } else {
                result = KGResult.INSTANCE.getResult(sendRequestWithScope);
            }
            return result;
        } catch (Exception e) {
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<List<KGKakaoUser>> sendInvitationMessages(List<KGKakaoUser> kakaoUsers, String templateId, Map<String, String> args) {
        Logger.INSTANCE.m706v(TAG, y.ۮڭڭܬި(862387795));
        ArrayList arrayList = new ArrayList();
        try {
            for (KGKakaoUser kGKakaoUser : kakaoUsers) {
                KGResult<Void> sendRequestWithScope = sendRequestWithScope(InhouseGWService.getSendInvitationMessageRequest(kGKakaoUser.getUuid(), templateId, args));
                KakaoUtil.convertResultCode(sendRequestWithScope);
                Logger.INSTANCE.m699d(TAG, "response about invitation message: " + sendRequestWithScope);
                if (sendRequestWithScope.isSuccess()) {
                    arrayList.add(kGKakaoUser);
                }
            }
            if (arrayList.size() == 0) {
                return KGResult.INSTANCE.getResult(KGResult.KGResultCode.FAIL_SEND_MESSAGE_IN_MULTI_PICKER);
            }
            return KGResult.INSTANCE.getSuccessResult(arrayList);
        } catch (Exception e) {
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showInvitationDialog(Activity activity, KGKakaoUser kakaoUser) {
        Object runBlocking$default;
        ArrayList arrayList = new ArrayList();
        arrayList.add(kakaoUser);
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakaoPicker$showInvitationDialog$1(activity, arrayList, null), 1, null);
        return (KGResult) runBlocking$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showInvitationDialog(Activity activity, List<KGKakaoUser> list, Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m699d(TAG, y.دײܮڳܯ(2051795565) + list);
        Activity activity2 = activity;
        String string = ResourceUtil.getString(activity2, y.ۮڭڭܬި(862355483));
        String string2 = list.size() > 1 ? ResourceUtil.getString(activity2, y.٬ݯح׭٩(575745598), list.get(0).getNickname(), Boxing.boxInt(list.size() - 1)) : ResourceUtil.getString(activity2, y.٬ݯح׭٩(575745822), list.get(0).getNickname());
        String string3 = ResourceUtil.getString(activity2, y.ݮڮֲڭܩ(-628699132));
        String string4 = ResourceUtil.getString(activity2, y.ٲٴݴ״ٰ(1782053472));
        if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE)) {
            if (Intrinsics.areEqual(CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, string, string2, string4, y.ٴسسݬߨ(1392698922), string3, y.֬ڱܱײٮ(-1159545887))), y.ٴسسݬߨ(1392698922))) {
                Result.Companion companion = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult()));
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(9001)));
            }
        } else {
            DialogManager.Settings settings = new DialogManager.Settings(string, null, string2, null, null, null, null, null, false, null, null, null, null, 8186, null);
            settings.setNegativeButton(string3, new DialogInterface.OnClickListener() { // from class: com.kakaogame.KGKakaoPicker$showInvitationDialog$3$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(9001)));
                }
            });
            settings.setPositiveButton(string4, new DialogInterface.OnClickListener() { // from class: com.kakaogame.KGKakaoPicker$showInvitationDialog$3$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult()));
                }
            });
            settings.setCancelable(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.KGKakaoPicker$showInvitationDialog$3$3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(9001)));
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
    public final Object showUnavailableDialog(Activity activity, Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m706v(TAG, y.ٴسسݬߨ(1392697482));
        Activity activity2 = activity;
        String string = ResourceUtil.getString(activity2, y.ٴسسݬߨ(1392697810));
        String string2 = ResourceUtil.getString(activity2, y.ۮڭڭܬި(862358339));
        String string3 = ResourceUtil.getString(activity2, y.ٲٴݴ״ٰ(1782054008));
        if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE)) {
            CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, string, string2, null, null, string3, y.֬ڱܱײٮ(-1159545887)));
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(KGResult.KGResultCode.EXCEED_DAILY_USAGE)));
        } else {
            DialogManager.Settings settings = new DialogManager.Settings(string, null, string2, null, null, null, null, null, false, null, null, null, null, 8186, null);
            settings.setNegativeButton(string3, new DialogInterface.OnClickListener() { // from class: com.kakaogame.KGKakaoPicker$showUnavailableDialog$2$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(KGResult.KGResultCode.EXCEED_DAILY_USAGE)));
                }
            });
            settings.setCancelable(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.KGKakaoPicker$showUnavailableDialog$2$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(KGResult.KGResultCode.EXCEED_DAILY_USAGE)));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392679650), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoPicker$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult sendSingleInviteMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                Object parameter = request.getParameter(y.֬ڱܱײٮ(-1159544407));
                Intrinsics.checkNotNull(parameter, y.ٲٴݴ״ٰ(1782032576));
                boolean booleanValue = ((Boolean) parameter).booleanValue();
                Object parameter2 = request.getParameter(y.ۮڭڭܬި(862266835));
                Intrinsics.checkNotNull(parameter2, y.ݬֲ֮ܲت(1512814407));
                Map map = (Map) request.getParameter(y.ۮڭڭܬި(862266483));
                sendSingleInviteMessage = KGKakaoPicker.INSTANCE.sendSingleInviteMessage(activity, booleanValue, (String) parameter2, map);
                if (sendSingleInviteMessage.isSuccess()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.٬ݯح׭٩(575756878), sendSingleInviteMessage.getContent());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
                return KGResult.INSTANCE.getResult(sendSingleInviteMessage.getCode(), sendSingleInviteMessage.getDescription(), sendSingleInviteMessage.getContent());
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051774037), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoPicker$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult sendMultiInviteMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                new ArrayList();
                Object parameter = request.getParameter(y.֬ڱܱײٮ(-1159544407));
                Intrinsics.checkNotNull(parameter, y.ٲٴݴ״ٰ(1782032576));
                boolean booleanValue = ((Boolean) parameter).booleanValue();
                Object parameter2 = request.getParameter(y.ۮڭڭܬި(862266835));
                Intrinsics.checkNotNull(parameter2, y.ݬֲ֮ܲت(1512814407));
                Map map = (Map) request.getParameter(y.ۮڭڭܬި(862266483));
                sendMultiInviteMessage = KGKakaoPicker.INSTANCE.sendMultiInviteMessage(activity, booleanValue, (String) parameter2, map);
                if (sendMultiInviteMessage.isSuccess()) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Object content = sendMultiInviteMessage.getContent();
                    Intrinsics.checkNotNull(content);
                    linkedHashMap.put(y.٬ݯح׭٩(575756958), content);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
                return KGResult.INSTANCE.getResult(sendMultiInviteMessage.getCode(), sendMultiInviteMessage.getDescription(), sendMultiInviteMessage.getContent());
            }
        });
    }

    /* compiled from: KGKakaoPicker.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\b\u0016\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/KGKakaoPicker$KGKakaoUser;", "Lcom/kakaogame/KGObject;", "m", "", "", "", "(Ljava/util/Map;)V", "nickname", "uuid", "(Ljava/lang/String;Ljava/lang/String;)V", "selectedUser", "Lcom/kakao/sdk/friend/model/SelectedUser;", "(Lcom/kakao/sdk/friend/model/SelectedUser;)V", "KEY_NICKNAME", "getKEY_NICKNAME", "()Ljava/lang/String;", "KEY_UUID", "getKEY_UUID", "TAG", "getNickname", "getUuid", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGKakaoUser extends KGObject {
        private final String KEY_NICKNAME;
        private final String KEY_UUID;
        private final String TAG;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getKEY_NICKNAME() {
            return this.KEY_NICKNAME;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getKEY_UUID() {
            return this.KEY_UUID;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGKakaoUser(Map<String, Object> map) {
            super(map);
            this.TAG = "KGKakaoUser";
            this.KEY_NICKNAME = "nickname";
            this.KEY_UUID = "uuid";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGKakaoUser(String str, String str2) {
            super(null, 1, null);
            this.TAG = y.ۮڭڭܬި(862382795);
            String str3 = y.دײܮڳܯ(2051779213);
            this.KEY_NICKNAME = str3;
            String str4 = y.ٴسسݬߨ(1392679994);
            this.KEY_UUID = str4;
            put(str3, str);
            put(str4, str2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGKakaoUser(SelectedUser selectedUser) {
            super(null, 1, null);
            Intrinsics.checkNotNullParameter(selectedUser, y.ݮڮֲڭܩ(-628705316));
            this.TAG = y.ۮڭڭܬި(862382795);
            String str = y.دײܮڳܯ(2051779213);
            this.KEY_NICKNAME = str;
            String str2 = y.ٴسسݬߨ(1392679994);
            this.KEY_UUID = str2;
            put(str, selectedUser.getProfileNickname());
            put(str2, selectedUser.getUuid());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getNickname() {
            try {
                return (String) get(this.KEY_NICKNAME);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(this.TAG, e.toString(), e);
                return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getUuid() {
            try {
                return (String) get(this.KEY_UUID);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(this.TAG, e.toString(), e);
                return null;
            }
        }
    }
}
