package com.kakaogame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.provider.FontsContractCompat;
import com.kakao.sdk.share.ShareClient;
import com.kakao.sdk.share.model.SharingResult;
import com.kakao.sdk.template.model.Link;
import com.kakao.sdk.template.model.TextTemplate;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoTalkMessage.kt */
@Metadata(m838d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007JF\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0012H\u0002JP\u0010\t\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00122\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007J<\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0002JF\u0010\t\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00152\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007J:\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0002JD\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007J:\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0002JD\u0010\u0019\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007J:\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0002JD\u0010\u001a\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007J:\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0002JD\u0010\u001b\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007J:\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0002JD\u0010\u001c\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007J\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J(\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\n2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0002\u0010%J*\u0010&\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010\u0014J\u001a\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J$\u0010'\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010#2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006)"}, m839d2 = {"Lcom/kakaogame/KGKakaoTalkMessage;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "initInterfaceBroker", "", "initialize", "sendGameMessage", "Lcom/kakaogame/KGResult;", "", "kakaoProfile", "Lcom/kakaogame/KGKakaoProfile;", "templateId", "image", "Landroid/graphics/Bitmap;", "args", "", "callback", "Lcom/kakaogame/KGResultCallback;", "", "sendGroupChatMessage", "groupChat", "Lcom/kakaogame/KGKakaoTalkGroupChat;", "sendInviteMessage", "sendNewGameMessage", "sendNewGroupChatMessage", "sendNewInviteMessage", "sendRequestWithScope", "requestData", "Lcom/kakaogame/server/ServerRequest;", "sendText", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "text", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendTextTemplateMessage", "showAllowMessageSettingView", "MessageReceiverIdType", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoTalkMessage {
    private static final String CLASS_NAME_KEY = "KGKakaoTalkMessage";
    public static final KGKakaoTalkMessage INSTANCE = new KGKakaoTalkMessage();
    private static final String TAG = "KGKakaoTalkMessage";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGKakaoTalkMessage() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showAllowMessageSettingView(Activity activity, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$showAllowMessageSettingView$1(activity, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "카카오톡 초대 메시지를 전송한다.")
    @JvmStatic
    public static final void sendInviteMessage(KGKakaoProfile kakaoProfile, String templateId, Map<String, String> args, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendInviteMessage$1(kakaoProfile, templateId, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "카카오톡 게임 메시지(이미지 포함)를 전송한다.")
    @JvmStatic
    public static final void sendGameMessage(KGKakaoProfile kakaoProfile, String templateId, Bitmap image, Map<String, String> args, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendGameMessage$1(kakaoProfile, templateId, image, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "카카오톡 게임 메시지를 전송한다.")
    @JvmStatic
    public static final void sendGameMessage(KGKakaoProfile kakaoProfile, String templateId, Map<String, String> args, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendGameMessage$2(kakaoProfile, templateId, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "그룹 채팅으로 카카오 메시지를 전송한다.")
    @JvmStatic
    public static final void sendGroupChatMessage(KGKakaoTalkGroupChat groupChat, String templateId, Map<String, String> args, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendGroupChatMessage$1(groupChat, templateId, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendNewInviteMessage(KGKakaoProfile kakaoProfile, String templateId, Map<String, String> args, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendNewInviteMessage$1(kakaoProfile, templateId, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendNewGameMessage(KGKakaoProfile kakaoProfile, String templateId, Map<String, String> args, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendNewGameMessage$1(kakaoProfile, templateId, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendNewGroupChatMessage(KGKakaoTalkGroupChat groupChat, String templateId, Map<String, String> args, KGResultCallback<Boolean> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendNewGroupChatMessage$1(groupChat, templateId, args, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendTextTemplateMessage(Activity activity, String text, final KGResultCallback<Void> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNull(text);
        TextTemplate textTemplate = new TextTemplate(text, new Link(text, null, null, null, 14, null), null, null, 12, null);
        HashMap hashMap = new HashMap();
        hashMap.put(y.ݬֲ֮ܲت(1512773759), y.ݮڮֲڭܩ(-628737924));
        hashMap.put(y.ۮڭڭܬި(862348795), y.֬ڱܱײٮ(-1159573487));
        ShareClient.INSTANCE.getInstance().shareDefault(activity, textTemplate, hashMap, new Function2<SharingResult, Throwable, Unit>() { // from class: com.kakaogame.KGKakaoTalkMessage$sendTextTemplateMessage$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(SharingResult sharingResult, Throwable th) {
                invoke2(sharingResult, th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SharingResult sharingResult, Throwable th) {
                String str = y.֬ڱܱײٮ(-1159562615);
                if (th != null) {
                    Logger.INSTANCE.m701e(str, th.toString());
                    KGResult<Void> result = KGResult.INSTANCE.getResult(9999);
                    KGResultCallback<Void> kGResultCallback = callback;
                    Intrinsics.checkNotNull(kGResultCallback);
                    kGResultCallback.onResult(result);
                    return;
                }
                if (sharingResult != null) {
                    Logger.INSTANCE.m699d(str, "Send Success");
                    Logger logger = Logger.INSTANCE;
                    String str2 = y.دײܮڳܯ(2051745965);
                    logger.m708w(str2, "Warning Msg: ${shareResult.warningMsg}");
                    Logger.INSTANCE.m708w(str2, "Argument Msg: ${shareResult.argumentMsg}");
                    KGResult<Void> result2 = KGResult.INSTANCE.getResult(200);
                    KGResultCallback<Void> kGResultCallback2 = callback;
                    Intrinsics.checkNotNull(kGResultCallback2);
                    kGResultCallback2.onResult(result2);
                }
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoTalkMessage$sendTextTemplateMessage$2(activity, text, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object sendText(Activity activity, final String str, Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.KGKakaoTalkMessage$sendText$2$eventListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onDestroy() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityStart(Activity activity2) {
                Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                try {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", str);
                    intent.setPackage("com.kakao.talk");
                    activity2.startActivityForResult(intent, 1234);
                } catch (Exception e) {
                    Logger.INSTANCE.m701e(y.دײܮڳܯ(2051745965), y.ۮڭڭܬި(862342763) + e);
                    KGResult result = KGResult.INSTANCE.getResult(4010, e.toString());
                    Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(result));
                    AuthActivityManager.INSTANCE.getInstance().finishActivity(longRef.element);
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                Logger logger = Logger.INSTANCE;
                StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575803430)).append(requestCode);
                String str2 = y.ݮڮֲڭܩ(-628756788);
                logger.m699d("KGKakaoTalkMessage", append.append(str2).append(resultCode).append(str2).append(data).toString());
                KGResult result = KGResult.INSTANCE.getResult(200);
                Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(result));
                AuthActivityManager.INSTANCE.getInstance().finishActivity(longRef.element);
            }
        }, null, 4, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0160  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> showAllowMessageSettingView(android.app.Activity r7) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.showAllowMessageSettingView(android.app.Activity):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[Catch: all -> 0x0148, Exception -> 0x014a, TryCatch #0 {Exception -> 0x014a, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0029, B:12:0x0033, B:14:0x003a, B:19:0x0046, B:20:0x0050, B:22:0x005c, B:23:0x0066, B:25:0x0070, B:27:0x0076, B:29:0x007e, B:31:0x008d, B:33:0x0093, B:34:0x0099, B:36:0x00a9, B:38:0x00af, B:39:0x00bb, B:41:0x00c7, B:42:0x00d0, B:44:0x00e0, B:47:0x00e9, B:49:0x011a, B:51:0x012e, B:52:0x00fb, B:54:0x0108), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050 A[Catch: all -> 0x0148, Exception -> 0x014a, TryCatch #0 {Exception -> 0x014a, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0029, B:12:0x0033, B:14:0x003a, B:19:0x0046, B:20:0x0050, B:22:0x005c, B:23:0x0066, B:25:0x0070, B:27:0x0076, B:29:0x007e, B:31:0x008d, B:33:0x0093, B:34:0x0099, B:36:0x00a9, B:38:0x00af, B:39:0x00bb, B:41:0x00c7, B:42:0x00d0, B:44:0x00e0, B:47:0x00e9, B:49:0x011a, B:51:0x012e, B:52:0x00fb, B:54:0x0108), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> sendInviteMessage(com.kakaogame.KGKakaoProfile r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.sendInviteMessage(com.kakaogame.KGKakaoProfile, java.lang.String, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[Catch: all -> 0x011f, Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x002d, B:16:0x0039, B:17:0x0043, B:19:0x0048, B:22:0x0051, B:23:0x005b, B:25:0x0067, B:26:0x0071, B:28:0x007b, B:30:0x0081, B:32:0x0089, B:34:0x0098, B:36:0x009e, B:37:0x00a4, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00d1, B:45:0x00da, B:47:0x00e6, B:48:0x00ef), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[Catch: all -> 0x011f, Exception -> 0x0121, TryCatch #0 {Exception -> 0x0121, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x002d, B:16:0x0039, B:17:0x0043, B:19:0x0048, B:22:0x0051, B:23:0x005b, B:25:0x0067, B:26:0x0071, B:28:0x007b, B:30:0x0081, B:32:0x0089, B:34:0x0098, B:36:0x009e, B:37:0x00a4, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00d1, B:45:0x00da, B:47:0x00e6, B:48:0x00ef), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> sendGameMessage(com.kakaogame.KGKakaoProfile r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.sendGameMessage(com.kakaogame.KGKakaoProfile, java.lang.String, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003b A[Catch: all -> 0x01fe, Exception -> 0x0200, TryCatch #0 {Exception -> 0x0200, blocks: (B:4:0x001b, B:9:0x0025, B:11:0x002f, B:16:0x003b, B:17:0x0045, B:19:0x004a, B:22:0x0053, B:24:0x005f, B:25:0x0069, B:27:0x0075, B:28:0x007f, B:30:0x0089, B:32:0x008f, B:34:0x0097, B:36:0x00a6, B:38:0x00ac, B:39:0x00b2, B:41:0x00c2, B:43:0x00c8, B:44:0x00d4, B:46:0x00e1, B:47:0x00eb, B:49:0x00f7, B:50:0x0100, B:53:0x0117, B:55:0x011d, B:56:0x012b, B:63:0x0159, B:64:0x015c, B:66:0x0166, B:70:0x017d, B:78:0x01e8, B:86:0x01fa, B:84:0x01fd), top: B:2:0x0019, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045 A[Catch: all -> 0x01fe, Exception -> 0x0200, TryCatch #0 {Exception -> 0x0200, blocks: (B:4:0x001b, B:9:0x0025, B:11:0x002f, B:16:0x003b, B:17:0x0045, B:19:0x004a, B:22:0x0053, B:24:0x005f, B:25:0x0069, B:27:0x0075, B:28:0x007f, B:30:0x0089, B:32:0x008f, B:34:0x0097, B:36:0x00a6, B:38:0x00ac, B:39:0x00b2, B:41:0x00c2, B:43:0x00c8, B:44:0x00d4, B:46:0x00e1, B:47:0x00eb, B:49:0x00f7, B:50:0x0100, B:53:0x0117, B:55:0x011d, B:56:0x012b, B:63:0x0159, B:64:0x015c, B:66:0x0166, B:70:0x017d, B:78:0x01e8, B:86:0x01fa, B:84:0x01fd), top: B:2:0x0019, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> sendGameMessage(com.kakaogame.KGKakaoProfile r10, java.lang.String r11, android.graphics.Bitmap r12, java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.sendGameMessage(com.kakaogame.KGKakaoProfile, java.lang.String, android.graphics.Bitmap, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034 A[Catch: all -> 0x010b, Exception -> 0x010d, TryCatch #0 {Exception -> 0x010d, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0028, B:16:0x0034, B:17:0x003e, B:19:0x004a, B:20:0x0054, B:22:0x005e, B:24:0x0064, B:26:0x006c, B:28:0x007b, B:30:0x0081, B:31:0x0087, B:33:0x0096, B:35:0x009c, B:36:0x00a7, B:38:0x00b1, B:39:0x00ba, B:41:0x00c6, B:42:0x00cf), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[Catch: all -> 0x010b, Exception -> 0x010d, TryCatch #0 {Exception -> 0x010d, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0028, B:16:0x0034, B:17:0x003e, B:19:0x004a, B:20:0x0054, B:22:0x005e, B:24:0x0064, B:26:0x006c, B:28:0x007b, B:30:0x0081, B:31:0x0087, B:33:0x0096, B:35:0x009c, B:36:0x00a7, B:38:0x00b1, B:39:0x00ba, B:41:0x00c6, B:42:0x00cf), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> sendGroupChatMessage(com.kakaogame.KGKakaoTalkGroupChat r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.sendGroupChatMessage(com.kakaogame.KGKakaoTalkGroupChat, java.lang.String, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046 A[Catch: all -> 0x0145, Exception -> 0x0147, TryCatch #1 {Exception -> 0x0147, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0029, B:12:0x0033, B:14:0x003a, B:19:0x0046, B:20:0x0050, B:22:0x005c, B:23:0x0066, B:25:0x0070, B:27:0x0076, B:29:0x007e, B:31:0x008d, B:33:0x0093, B:34:0x0099, B:36:0x00a9, B:38:0x00af, B:39:0x00bb, B:41:0x00c7, B:42:0x00d0, B:44:0x00e0, B:47:0x00e9, B:49:0x011a, B:51:0x012e, B:52:0x00fb, B:54:0x0108), top: B:2:0x0017, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050 A[Catch: all -> 0x0145, Exception -> 0x0147, TryCatch #1 {Exception -> 0x0147, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0029, B:12:0x0033, B:14:0x003a, B:19:0x0046, B:20:0x0050, B:22:0x005c, B:23:0x0066, B:25:0x0070, B:27:0x0076, B:29:0x007e, B:31:0x008d, B:33:0x0093, B:34:0x0099, B:36:0x00a9, B:38:0x00af, B:39:0x00bb, B:41:0x00c7, B:42:0x00d0, B:44:0x00e0, B:47:0x00e9, B:49:0x011a, B:51:0x012e, B:52:0x00fb, B:54:0x0108), top: B:2:0x0017, outer: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> sendNewInviteMessage(com.kakaogame.KGKakaoProfile r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.sendNewInviteMessage(com.kakaogame.KGKakaoProfile, java.lang.String, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039 A[Catch: all -> 0x0109, Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x002d, B:16:0x0039, B:17:0x0043, B:19:0x0048, B:22:0x0051, B:23:0x005b, B:25:0x0067, B:26:0x0071, B:28:0x007b, B:30:0x0081, B:32:0x0089, B:34:0x0098, B:36:0x009e, B:37:0x00a4, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00d0, B:45:0x00d9), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[Catch: all -> 0x0109, Exception -> 0x010b, TryCatch #0 {Exception -> 0x010b, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x002d, B:16:0x0039, B:17:0x0043, B:19:0x0048, B:22:0x0051, B:23:0x005b, B:25:0x0067, B:26:0x0071, B:28:0x007b, B:30:0x0081, B:32:0x0089, B:34:0x0098, B:36:0x009e, B:37:0x00a4, B:39:0x00b3, B:41:0x00b9, B:42:0x00c4, B:44:0x00d0, B:45:0x00d9), top: B:2:0x0017, outer: #1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> sendNewGameMessage(com.kakaogame.KGKakaoProfile r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.sendNewGameMessage(com.kakaogame.KGKakaoProfile, java.lang.String, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034 A[Catch: all -> 0x0100, Exception -> 0x0102, TryCatch #1 {Exception -> 0x0102, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0028, B:16:0x0034, B:17:0x003e, B:19:0x004a, B:20:0x0054, B:22:0x005e, B:24:0x0064, B:26:0x006c, B:28:0x007b, B:30:0x0081, B:31:0x0087, B:33:0x0096, B:35:0x009c, B:36:0x00a7, B:38:0x00b1, B:39:0x00ba, B:41:0x00c6, B:42:0x00cf), top: B:2:0x0017, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[Catch: all -> 0x0100, Exception -> 0x0102, TryCatch #1 {Exception -> 0x0102, blocks: (B:4:0x0019, B:9:0x0023, B:11:0x0028, B:16:0x0034, B:17:0x003e, B:19:0x004a, B:20:0x0054, B:22:0x005e, B:24:0x0064, B:26:0x006c, B:28:0x007b, B:30:0x0081, B:31:0x0087, B:33:0x0096, B:35:0x009c, B:36:0x00a7, B:38:0x00b1, B:39:0x00ba, B:41:0x00c6, B:42:0x00cf), top: B:2:0x0017, outer: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> sendNewGroupChatMessage(com.kakaogame.KGKakaoTalkGroupChat r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGKakaoTalkMessage.sendNewGroupChatMessage(com.kakaogame.KGKakaoTalkGroupChat, java.lang.String, java.util.Map):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Boolean> sendRequestWithScope(ServerRequest requestData) {
        boolean z = false;
        ServerResult requestServer$default = ServerService.requestServer$default(requestData, 0, 2, null);
        JSONObject content = requestServer$default.getContent();
        if (content == null) {
            return KGResult.INSTANCE.getResult(2003, y.ٲٴݴ״ٰ(1782001200));
        }
        if (requestServer$default.isSuccess()) {
            Long l = (Long) content.get((Object) FontsContractCompat.Columns.RESULT_CODE);
            if (l != null && l.longValue() == 0) {
                z = true;
            }
            return KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(z));
        }
        String str = y.دײܮڳܯ(2051777077);
        if (content.containsKey((Object) str) && content.get((Object) str) != null) {
            KGKakao2Auth.Companion companion = KGKakao2Auth.INSTANCE;
            Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
            Object obj = content.get((Object) str);
            Intrinsics.checkNotNull(obj, y.ݮڮֲڭܩ(-628714340));
            if (companion.updateScope(activity, (List) obj).isSuccess()) {
                return sendRequestWithScope(requestData);
            }
            return KGResult.INSTANCE.getResult(9001, y.ٲٴݴ״ٰ(1782031224), false);
        }
        return KGResult.INSTANCE.getResult(requestServer$default);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051744269), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkMessage$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> showAllowMessageSettingView;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                showAllowMessageSettingView = KGKakaoTalkMessage.INSTANCE.showAllowMessageSettingView(activity);
                FirebaseEvent.INSTANCE.sendEvent(y.دײܮڳܯ(2051745965), y.ݮڮֲڭܩ(-628744404), showAllowMessageSettingView);
                if (showAllowMessageSettingView.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(showAllowMessageSettingView);
                }
                Object content = showAllowMessageSettingView.getContent();
                Intrinsics.checkNotNull(content);
                boolean booleanValue = ((Boolean) content).booleanValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392692882), Boolean.valueOf(booleanValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628746628), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkMessage$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult sendInviteMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                sendInviteMessage = KGKakaoTalkMessage.INSTANCE.sendInviteMessage(new KGKakaoProfile((Map<String, Object>) TypeIntrinsics.asMutableMap(request.getParameter(y.ۮڭڭܬި(862270259)))), (String) request.getParameter(y.ۮڭڭܬި(862266835)), (Map) request.getParameter(y.ۮڭڭܬި(862266483)));
                if (sendInviteMessage.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(sendInviteMessage);
                }
                Object content = sendInviteMessage.getContent();
                Intrinsics.checkNotNull(content);
                boolean booleanValue = ((Boolean) content).booleanValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(booleanValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575793086), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkMessage$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult sendGameMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                KGKakaoProfile kGKakaoProfile = new KGKakaoProfile((Map<String, Object>) TypeIntrinsics.asMutableMap(request.getParameter(y.ۮڭڭܬި(862270259))));
                String str = (String) request.getParameter(y.ۮڭڭܬި(862266835));
                Map asMutableMap = TypeIntrinsics.asMutableMap(request.getParameter(y.ۮڭڭܬި(862266483)));
                String str2 = (String) request.getParameter(y.֬ڱܱײٮ(-1159562919));
                Logger logger = Logger.INSTANCE;
                String str3 = y.ݮڮֲڭܩ(-628692924) + str2;
                String str4 = y.دײܮڳܯ(2051745965);
                logger.m704i(str4, str3);
                String str5 = str2;
                if (str5 == null || str5.length() == 0) {
                    sendGameMessage = KGKakaoTalkMessage.INSTANCE.sendGameMessage(kGKakaoProfile, str, asMutableMap);
                } else {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str2, options);
                    Logger.INSTANCE.m704i(str4, y.ۮڭڭܬި(862342571) + decodeFile);
                    sendGameMessage = KGKakaoTalkMessage.INSTANCE.sendGameMessage(kGKakaoProfile, str, decodeFile, (Map<String, String>) asMutableMap);
                }
                if (sendGameMessage.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(sendGameMessage);
                }
                Object content = sendGameMessage.getContent();
                Intrinsics.checkNotNull(content);
                boolean booleanValue = ((Boolean) content).booleanValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(booleanValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575797486), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkMessage$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult sendGroupChatMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                sendGroupChatMessage = KGKakaoTalkMessage.INSTANCE.sendGroupChatMessage(new KGKakaoTalkGroupChat((Map<String, Object>) TypeIntrinsics.asMutableMap(request.getParameter(y.دײܮڳܯ(2051745437)))), (String) request.getParameter(y.ۮڭڭܬި(862266835)), (Map) request.getParameter(y.ۮڭڭܬި(862266483)));
                if (sendGroupChatMessage.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(sendGroupChatMessage);
                }
                Object content = sendGroupChatMessage.getContent();
                Intrinsics.checkNotNull(content);
                boolean booleanValue = ((Boolean) content).booleanValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(booleanValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051750949), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkMessage$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> sendNewInviteMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                sendNewInviteMessage = KGKakaoTalkMessage.INSTANCE.sendNewInviteMessage(new KGKakaoProfile((Map<String, Object>) TypeIntrinsics.asMutableMap(request.getParameter(y.ۮڭڭܬި(862270259)))), (String) request.getParameter(y.ۮڭڭܬި(862266835)), (Map) request.getParameter(y.ۮڭڭܬި(862266483)));
                FirebaseEvent.INSTANCE.sendEvent(y.دײܮڳܯ(2051745965), y.ݬֲ֮ܲت(1512771295), sendNewInviteMessage);
                if (sendNewInviteMessage.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(sendNewInviteMessage);
                }
                Object content = sendNewInviteMessage.getContent();
                Intrinsics.checkNotNull(content);
                boolean booleanValue = ((Boolean) content).booleanValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(booleanValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392656274), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkMessage$initInterfaceBroker$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> sendNewGameMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                sendNewGameMessage = KGKakaoTalkMessage.INSTANCE.sendNewGameMessage(new KGKakaoProfile((Map<String, Object>) TypeIntrinsics.asMutableMap(request.getParameter(y.ۮڭڭܬި(862270259)))), (String) request.getParameter(y.ۮڭڭܬި(862266835)), (Map) request.getParameter(y.ۮڭڭܬި(862266483)));
                FirebaseEvent.INSTANCE.sendEvent(y.دײܮڳܯ(2051745965), y.٬ݯح׭٩(575791558), sendNewGameMessage);
                if (sendNewGameMessage.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(sendNewGameMessage);
                }
                Object content = sendNewGameMessage.getContent();
                Intrinsics.checkNotNull(content);
                boolean booleanValue = ((Boolean) content).booleanValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(booleanValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512772271), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoTalkMessage$initInterfaceBroker$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> sendNewGroupChatMessage;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                sendNewGroupChatMessage = KGKakaoTalkMessage.INSTANCE.sendNewGroupChatMessage(new KGKakaoTalkGroupChat((Map<String, Object>) TypeIntrinsics.asMutableMap(request.getParameter(y.دײܮڳܯ(2051745437)))), (String) request.getParameter(y.ۮڭڭܬި(862266835)), (Map) request.getParameter(y.ۮڭڭܬި(862266483)));
                FirebaseEvent.INSTANCE.sendEvent(y.دײܮڳܯ(2051745965), y.ݮڮֲڭܩ(-628747580), sendNewGroupChatMessage);
                if (sendNewGroupChatMessage.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(sendNewGroupChatMessage);
                }
                Object content = sendNewGroupChatMessage.getContent();
                Intrinsics.checkNotNull(content);
                boolean booleanValue = ((Boolean) content).booleanValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ٴسسݬߨ(1392585418), Boolean.valueOf(booleanValue));
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGKakaoTalkMessage.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/KGKakaoTalkMessage$MessageReceiverIdType;", "", TypedValues.Custom.S_STRING, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "PLAYER_ID", "UUID", "CHAT_ID", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class MessageReceiverIdType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MessageReceiverIdType[] $VALUES;
        private final String string;
        public static final MessageReceiverIdType PLAYER_ID = new MessageReceiverIdType(y.ٴسسݬߨ(1392650834), 0, y.ݬֲ֮ܲت(1512589743));
        public static final MessageReceiverIdType UUID = new MessageReceiverIdType(y.ݮڮֲڭܩ(-628744652), 1, y.ٴسسݬߨ(1392679994));
        public static final MessageReceiverIdType CHAT_ID = new MessageReceiverIdType(y.دײܮڳܯ(2051746021), 2, y.ٲٴݴ״ٰ(1782003536));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ MessageReceiverIdType[] $values() {
            return new MessageReceiverIdType[]{PLAYER_ID, UUID, CHAT_ID};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<MessageReceiverIdType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageReceiverIdType valueOf(String str) {
            return (MessageReceiverIdType) Enum.valueOf(MessageReceiverIdType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static MessageReceiverIdType[] values() {
            return (MessageReceiverIdType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MessageReceiverIdType(String str, int i, String str2) {
            this.string = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getString() {
            return this.string;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            MessageReceiverIdType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
