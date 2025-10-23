package com.kakaogame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGKakaoInvitation;
import com.kakaogame.KGSNSShare;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.promotion.PromotionService;
import com.kakaogame.promotion.SNSShareData;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.web.WebDialog;
import com.kakaogame.web.WebDialogManager;
import com.liapp.y;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGSNSShare.kt */
@Metadata(m838d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u000234B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u001a\u0010\u0018\u001a\u00020\u00142\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001aH\u0007J\u001a\u0010\u001b\u001a\u00020\u00142\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001aH\u0007J$\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001aH\u0007J\u0012\u0010\u001f\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J.\u0010\"\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001aH\u0007J\"\u0010#\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001aH\u0007J*\u0010#\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010$\u001a\u00020\u000b2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001aH\u0002J\u001a\u0010%\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J$\u0010(\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001aH\u0007J$\u0010)\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001aH\u0007J$\u0010*\u001a\u00020\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001aH\u0007J*\u0010+\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001aH\u0002J*\u0010-\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u001aH\u0002J4\u0010.\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010/\u001a\u0002002\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u001aH\u0002J*\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u0002022\u0006\u0010,\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u00065"}, m839d2 = {"Lcom/kakaogame/KGSNSShare;", "", "()V", "CLASS_NAME_KEY", "", "EVENT_SCREEN_SHOT", "", "NEW_REWARD_SHOW_KEY", "REWARD_SHOW_KEY", "TAG", "isAlreadyPlayerShowUI", "", "()Z", "dataCheck", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "getInvitationLinkReferrer", "initInterfaceBroker", "", "initialize", "isAlreadyPlayerReward", ServerConstants.SEQ, "loadBadgeInfo", "callback", "Lcom/kakaogame/KGResultCallback;", "loadJoinerCount", "Lcom/kakaogame/KGSNSShare$KGJoinerCount;", "loadShareRewardInfo", "code", "registerEventListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakaogame/KGSNSShare$KGEventListener;", "shareContentsLink", "shareScreenShot", "isNative", "showAlertDialog", "parentDialog", "Lcom/kakaogame/web/WebDialog;", "showInvitationRewardView", "showInvitationView", "showNewInvitationRewardView", "showNewRewardView", "baseUrl", "showRewardView", "showShareDialog", "data", "Lcom/kakaogame/promotion/SNSShareData;", "showShareViewOnActivity", "", "KGEventListener", "KGJoinerCount", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSNSShare {
    private static final String CLASS_NAME_KEY = "KGSNSShare";
    public static final int EVENT_SCREEN_SHOT = 1001;
    public static final KGSNSShare INSTANCE = new KGSNSShare();
    private static final String NEW_REWARD_SHOW_KEY = "Zinny://SNSShare.showNewInvitationRewardView";
    private static final String REWARD_SHOW_KEY = "Zinny://SNSShare.showInvitationRewardView";
    private static final String TAG = "KGSNSShare";

    /* compiled from: KGSNSShare.kt */
    @Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/KGSNSShare$KGEventListener;", "", "onEvent", "", KGKakaoInvitation.KGKakaoEvent.UNUTY_EVENT_ID, "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface KGEventListener {
        void onEvent(int eventId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGSNSShare() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void shareScreenShot(Activity activity, KGResultCallback<Void> callback) {
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        INSTANCE.shareScreenShot(activity, true, callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void registerEventListener(KGEventListener listener) {
        CoreManager.INSTANCE.getInstance().putEventListener(listener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void shareContentsLink(Activity activity, String code, final KGResultCallback<Void> callback) {
        String str = y.֬ڱܱײٮ(-1159497279);
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str2 = y.ٲٴݴ״ٰ(1781938864);
        String str3 = y.ݬֲ֮ܲت(1512767087);
        final FirebaseEvent firebaseEvent = companion.getFirebaseEvent(str3, str2);
        try {
            Logger.INSTANCE.m704i(str3, str + code);
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.snsShare)) {
                Logger.INSTANCE.m701e(str3, "SNS Share Feature is not enabled. Check your game settings on the admin page.");
                KGResult<Void> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                }
                firebaseEvent.setResult(result);
                return;
            }
            if (activity != null && !activity.isFinishing()) {
                SNSShareData snsShareData = CoreManager.INSTANCE.getInstance().getSnsShareData();
                if (snsShareData == null) {
                    KGResult<Void> result2 = KGResult.INSTANCE.getResult(1001);
                    if (callback != null) {
                        callback.onResult(result2);
                    }
                    firebaseEvent.setResult(result2);
                    return;
                }
                INSTANCE.showShareDialog(activity, snsShareData, code, new KGResultCallback<Void>() { // from class: com.kakaogame.KGSNSShare$shareContentsLink$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result3) {
                        KGResultCallback<Void> kGResultCallback = callback;
                        if (kGResultCallback != null) {
                            kGResultCallback.onResult(result3);
                        }
                        firebaseEvent.setResult(result3);
                    }
                });
                return;
            }
            Logger.INSTANCE.m701e(str3, "shareContentsLink: activity is null or finishing.");
            KGResult<Void> result3 = KGResult.INSTANCE.getResult(4000, "activity is null or finishing.");
            if (callback != null) {
                callback.onResult(result3);
            }
            firebaseEvent.setResult(result3);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            KGResult<Void> result4 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result4);
            }
            firebaseEvent.setResult(result4);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadShareRewardInfo(String code, KGResultCallback<Boolean> callback) {
        String str = y.دײܮڳܯ(2051680749);
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str2 = y.ۮڭڭܬި(862408035);
        String str3 = y.ݬֲ֮ܲت(1512767087);
        FirebaseEvent firebaseEvent = companion.getFirebaseEvent(str3, str2);
        try {
            Logger.INSTANCE.m704i(str3, str + code);
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.snsShare)) {
                Logger.INSTANCE.m701e(str3, "SNS Share Feature is not enabled. Check your game settings on the admin page.");
                KGResult<Boolean> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                }
                firebaseEvent.setResult(result);
                return;
            }
            SNSShareData snsShareData = CoreManager.INSTANCE.getInstance().getSnsShareData();
            if (snsShareData == null) {
                KGResult<Boolean> result2 = KGResult.INSTANCE.getResult(1001);
                if (callback != null) {
                    callback.onResult(result2);
                }
                firebaseEvent.setResult(result2);
                return;
            }
            KGResult<Void> sendSavedRequestSNSShareReward = PromotionService.sendSavedRequestSNSShareReward();
            if (!sendSavedRequestSNSShareReward.isSuccess()) {
                KGResult<Boolean> result3 = KGResult.INSTANCE.getResult(sendSavedRequestSNSShareReward);
                if (callback != null) {
                    callback.onResult(result3);
                }
                firebaseEvent.setResult(result3);
                return;
            }
            KGResult<Boolean> checkSNSShareRewarded = PromotionService.checkSNSShareRewarded(snsShareData.getSeq(), SNSShareData.SNSShareType.linkShare, code);
            if (callback != null) {
                callback.onResult(checkSNSShareRewarded);
            }
            firebaseEvent.setResult(checkSNSShareRewarded);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            KGResult<Boolean> result4 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result4);
            }
            firebaseEvent.setResult(result4);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showInvitationView(Activity activity, KGResultCallback<Void> callback) {
        String str = y.ݬֲ֮ܲت(1512706959);
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str2 = y.دײܮڳܯ(2051685229);
        String str3 = y.ݬֲ֮ܲت(1512767087);
        FirebaseEvent firebaseEvent = companion.getFirebaseEvent(str3, str2);
        try {
            Logger logger = Logger.INSTANCE;
            StringBuilder sb = new StringBuilder(str);
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            logger.m704i(str3, sb.append(currentPlayer != null ? Long.valueOf(currentPlayer.getRegistTime()) : null).toString());
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.snsShare)) {
                Logger.INSTANCE.m701e(str3, "SNS Share Feature is not enabled. Check your game settings on the admin page.");
                KGResult<Void> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                }
                firebaseEvent.setResult(result);
                return;
            }
            if (activity != null && !activity.isFinishing()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSNSShare$showInvitationView$1(activity, callback, firebaseEvent, null), 3, null);
                return;
            }
            Logger.INSTANCE.m701e(str3, "showInvitationView: activity is null or finishing.");
            KGResult<Void> result2 = KGResult.INSTANCE.getResult(4000, "activity is null or finishing.");
            if (callback != null) {
                callback.onResult(result2);
            }
            firebaseEvent.setResult(result2);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            KGResult<Void> result3 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result3);
            }
            firebaseEvent.setResult(result3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> dataCheck(Activity activity) {
        SNSShareData snsShareData = CoreManager.INSTANCE.getInstance().getSnsShareData();
        if (snsShareData == null) {
            return KGResult.INSTANCE.getResult(1001);
        }
        if (TextUtils.isEmpty(snsShareData.getInvitationHostUrl())) {
            return KGResult.INSTANCE.getResult(200);
        }
        String invitationLinkReferrer = getInvitationLinkReferrer(activity);
        return showShareViewOnActivity(activity, snsShareData.getSeq(), snsShareData.getInvitationHostUrl() + (invitationLinkReferrer.length() == 0 ? "" : y.ۮڭڭܬި(861981587) + invitationLinkReferrer));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0075 A[Catch: Exception -> 0x00b1, TryCatch #0 {Exception -> 0x00b1, blocks: (B:3:0x0014, B:5:0x0023, B:7:0x0034, B:8:0x0037, B:12:0x003d, B:15:0x0044, B:17:0x0050, B:19:0x005a, B:20:0x005d, B:22:0x0061, B:24:0x0069, B:29:0x0075, B:31:0x007f, B:32:0x0082, B:34:0x0086, B:37:0x0097, B:39:0x00aa, B:40:0x00ad), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[Catch: Exception -> 0x00b1, TryCatch #0 {Exception -> 0x00b1, blocks: (B:3:0x0014, B:5:0x0023, B:7:0x0034, B:8:0x0037, B:12:0x003d, B:15:0x0044, B:17:0x0050, B:19:0x005a, B:20:0x005d, B:22:0x0061, B:24:0x0069, B:29:0x0075, B:31:0x007f, B:32:0x0082, B:34:0x0086, B:37:0x0097, B:39:0x00aa, B:40:0x00ad), top: B:2:0x0014 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showInvitationRewardView(android.app.Activity r5, final com.kakaogame.KGResultCallback<java.lang.Void> r6) {
        /*
            com.kakaogame.log.FirebaseEvent$Companion r0 = com.kakaogame.log.FirebaseEvent.INSTANCE
            r1 = 1512767087(0x5a2afe6f, float:1.2032625E16)
            java.lang.String r1 = com.liapp.y.ݬֲ֮ܲت(r1)
            r2 = 2051685685(0x7a4a3d35, float:2.6252135E35)
            java.lang.String r2 = com.liapp.y.دײܮڳܯ(r2)
            com.kakaogame.log.FirebaseEvent r0 = r0.getFirebaseEvent(r1, r2)
            com.kakaogame.Logger r3 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> Lb1
            r3.m704i(r1, r2)     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.core.FeatureManager r2 = com.kakaogame.core.FeatureManager.INSTANCE     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.core.FeatureManager$Feature r3 = com.kakaogame.core.FeatureManager.Feature.snsShare     // Catch: java.lang.Exception -> Lb1
            boolean r2 = r2.isNotSupportedFeature(r3)     // Catch: java.lang.Exception -> Lb1
            if (r2 == 0) goto L3b
            com.kakaogame.Logger r5 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> Lb1
            java.lang.String r2 = "SNS Share Feature is not enabled. Check your game settings on the admin page."
            r5.m701e(r1, r2)     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lb1
            r2 = 5001(0x1389, float:7.008E-42)
            com.kakaogame.KGResult r5 = r5.getResult(r2)     // Catch: java.lang.Exception -> Lb1
            if (r6 == 0) goto L37
            r6.onResult(r5)     // Catch: java.lang.Exception -> Lb1
        L37:
            r0.setResult(r5)     // Catch: java.lang.Exception -> Lb1
            return
        L3b:
            if (r5 == 0) goto L97
            boolean r2 = r5.isFinishing()     // Catch: java.lang.Exception -> Lb1
            if (r2 == 0) goto L44
            goto L97
        L44:
            com.kakaogame.core.CoreManager$Companion r2 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.core.CoreManager r2 = r2.getInstance()     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.promotion.SNSShareData r2 = r2.getSnsShareData()     // Catch: java.lang.Exception -> Lb1
            if (r2 != 0) goto L61
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lb1
            r2 = 1001(0x3e9, float:1.403E-42)
            com.kakaogame.KGResult r5 = r5.getResult(r2)     // Catch: java.lang.Exception -> Lb1
            if (r6 == 0) goto L5d
            r6.onResult(r5)     // Catch: java.lang.Exception -> Lb1
        L5d:
            r0.setResult(r5)     // Catch: java.lang.Exception -> Lb1
            return
        L61:
            java.lang.String r3 = r2.getInvitationGuestUrl()     // Catch: java.lang.Exception -> Lb1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: java.lang.Exception -> Lb1
            if (r3 == 0) goto L72
            int r3 = r3.length()     // Catch: java.lang.Exception -> Lb1
            if (r3 != 0) goto L70
            goto L72
        L70:
            r3 = 0
            goto L73
        L72:
            r3 = 1
        L73:
            if (r3 == 0) goto L86
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lb1
            r2 = 200(0xc8, float:2.8E-43)
            com.kakaogame.KGResult r5 = r5.getResult(r2)     // Catch: java.lang.Exception -> Lb1
            if (r6 == 0) goto L82
            r6.onResult(r5)     // Catch: java.lang.Exception -> Lb1
        L82:
            r0.setResult(r5)     // Catch: java.lang.Exception -> Lb1
            return
        L86:
            java.lang.String r2 = r2.getInvitationGuestUrl()     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.KGSNSShare r3 = com.kakaogame.KGSNSShare.INSTANCE     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.KGSNSShare$showInvitationRewardView$1 r4 = new com.kakaogame.KGSNSShare$showInvitationRewardView$1     // Catch: java.lang.Exception -> Lb1
            r4.<init>()     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.KGResultCallback r4 = (com.kakaogame.KGResultCallback) r4     // Catch: java.lang.Exception -> Lb1
            r3.showRewardView(r5, r2, r4)     // Catch: java.lang.Exception -> Lb1
            goto Ld2
        L97:
            com.kakaogame.Logger r5 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> Lb1
            java.lang.String r2 = "showInvitationRewardView: activity is null or finishing."
            r5.m701e(r1, r2)     // Catch: java.lang.Exception -> Lb1
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> Lb1
            java.lang.String r2 = "activity is null or finishing."
            r3 = 4000(0xfa0, float:5.605E-42)
            com.kakaogame.KGResult r5 = r5.getResult(r3, r2)     // Catch: java.lang.Exception -> Lb1
            if (r6 == 0) goto Lad
            r6.onResult(r5)     // Catch: java.lang.Exception -> Lb1
        Lad:
            r0.setResult(r5)     // Catch: java.lang.Exception -> Lb1
            return
        Lb1:
            r5 = move-exception
            com.kakaogame.Logger r2 = com.kakaogame.Logger.INSTANCE
            java.lang.String r3 = r5.toString()
            r4 = r5
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r2.m702e(r1, r3, r4)
            com.kakaogame.KGResult$Companion r1 = com.kakaogame.KGResult.INSTANCE
            r2 = 4001(0xfa1, float:5.607E-42)
            java.lang.String r5 = r5.toString()
            com.kakaogame.KGResult r5 = r1.getResult(r2, r5)
            if (r6 == 0) goto Lcf
            r6.onResult(r5)
        Lcf:
            r0.setResult(r5)
        Ld2:
            return
            fill-array 0x00d4: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGSNSShare.showInvitationRewardView(android.app.Activity, com.kakaogame.KGResultCallback):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f A[Catch: Exception -> 0x0141, TryCatch #0 {Exception -> 0x0141, blocks: (B:3:0x001b, B:5:0x002a, B:7:0x003b, B:8:0x003e, B:12:0x0044, B:15:0x004c, B:17:0x0058, B:19:0x0062, B:20:0x0065, B:22:0x0069, B:24:0x0071, B:30:0x007f, B:32:0x0087, B:33:0x008a, B:35:0x008e, B:37:0x009e, B:39:0x00a6, B:40:0x00a9, B:42:0x00ad, B:44:0x00b7, B:46:0x00bd, B:48:0x00c3, B:50:0x00d9, B:51:0x00e6, B:52:0x0109, B:54:0x0111, B:55:0x0114, B:57:0x0118, B:60:0x0127, B:62:0x013a, B:63:0x013d), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e A[Catch: Exception -> 0x0141, TryCatch #0 {Exception -> 0x0141, blocks: (B:3:0x001b, B:5:0x002a, B:7:0x003b, B:8:0x003e, B:12:0x0044, B:15:0x004c, B:17:0x0058, B:19:0x0062, B:20:0x0065, B:22:0x0069, B:24:0x0071, B:30:0x007f, B:32:0x0087, B:33:0x008a, B:35:0x008e, B:37:0x009e, B:39:0x00a6, B:40:0x00a9, B:42:0x00ad, B:44:0x00b7, B:46:0x00bd, B:48:0x00c3, B:50:0x00d9, B:51:0x00e6, B:52:0x0109, B:54:0x0111, B:55:0x0114, B:57:0x0118, B:60:0x0127, B:62:0x013a, B:63:0x013d), top: B:2:0x001b }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showNewInvitationRewardView(android.app.Activity r9, final com.kakaogame.KGResultCallback<java.lang.Void> r10) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGSNSShare.showNewInvitationRewardView(android.app.Activity, com.kakaogame.KGResultCallback):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadBadgeInfo(KGResultCallback<Boolean> callback) {
        Unit unit;
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str = y.دײܮڳܯ(2051569477);
        String str2 = y.ݬֲ֮ܲت(1512767087);
        FirebaseEvent firebaseEvent = companion.getFirebaseEvent(str2, str);
        KGResult<Long> sNSShareJoinerCount = PromotionService.getSNSShareJoinerCount();
        if (sNSShareJoinerCount.isNotSuccess()) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(sNSShareJoinerCount.getCode(), sNSShareJoinerCount.getDescription(), false);
            if (callback != null) {
                callback.onResult(result);
            }
            firebaseEvent.setResult(result);
            return;
        }
        Long content = sNSShareJoinerCount.getContent();
        Intrinsics.checkNotNull(content);
        boolean hasNewJoiner = new KGJoinerCount(content.longValue()).hasNewJoiner();
        SNSShareData snsShareData = CoreManager.INSTANCE.getInstance().getSnsShareData();
        if (snsShareData != null) {
            long seq = snsShareData.getSeq();
            long loadInvitationSeq = InviteDataManager.loadInvitationSeq(CoreManager.INSTANCE.getInstance().getContext(), CoreManager.INSTANCE.getInstance().getPlayerId());
            Logger.INSTANCE.m699d(str2, y.ݬֲ֮ܲت(1512702439) + loadInvitationSeq + y.ٲٴݴ״ٰ(1781937624) + seq);
            KGResult<Boolean> successResult = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(loadInvitationSeq != seq || hasNewJoiner));
            if (callback != null) {
                callback.onResult(successResult);
            }
            firebaseEvent.setResult(successResult);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            KGResult<Boolean> successResult2 = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(hasNewJoiner));
            if (callback != null) {
                callback.onResult(successResult2);
            }
            firebaseEvent.setResult(successResult2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadJoinerCount(KGResultCallback<KGJoinerCount> callback) {
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512767087);
        String str2 = y.٬ݯح׭٩(575729446);
        FirebaseEvent firebaseEvent = companion.getFirebaseEvent(str, str2);
        try {
            Logger.INSTANCE.m704i(str, str2);
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.snsShare)) {
                Logger.INSTANCE.m701e(str, "SNS Share Feature is not enabled. Check your game settings on the admin page.");
                KGResult<KGJoinerCount> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                }
                firebaseEvent.setResult(result);
                return;
            }
            KGResult<Long> sNSShareJoinerCount = PromotionService.getSNSShareJoinerCount();
            if (sNSShareJoinerCount.isNotSuccess()) {
                KGResult<KGJoinerCount> result2 = KGResult.INSTANCE.getResult(sNSShareJoinerCount);
                if (callback != null) {
                    callback.onResult(result2);
                }
                firebaseEvent.setResult(result2);
                return;
            }
            Long content = sNSShareJoinerCount.getContent();
            Intrinsics.checkNotNull(content);
            KGResult<KGJoinerCount> successResult = KGResult.INSTANCE.getSuccessResult(new KGJoinerCount(content.longValue()));
            if (callback != null) {
                callback.onResult(successResult);
            }
            firebaseEvent.setResult(successResult);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            KGResult<KGJoinerCount> result3 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result3);
            }
            firebaseEvent.setResult(result3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showShareViewOnActivity(Activity activity, final long seq, final String baseUrl) {
        try {
            KGResult<Long> sNSShareJoinerCount = PromotionService.getSNSShareJoinerCount();
            if (sNSShareJoinerCount.isSuccess()) {
                Long content = sNSShareJoinerCount.getContent();
                Intrinsics.checkNotNull(content);
                long longValue = content.longValue();
                String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
                InviteDataManager.savePlayerInvitationCount(activity, playerId, longValue);
                InviteDataManager.saveInvitationSeq(activity, playerId, seq);
            }
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            KGAuthActivity.KGActivityEventListener kGActivityEventListener = new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.KGSNSShare$showShareViewOnActivity$listener$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityResult(int requestCode, int resultCode, Intent data) {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityStart(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                    if (TextUtils.isEmpty(baseUrl)) {
                        createLock.setContent(KGResult.INSTANCE.getResult(4002));
                        createLock.unlock();
                        return;
                    }
                    Activity activity3 = activity2;
                    String str = y.ٴسسݬߨ(1392606306);
                    String str2 = y.ۮڭڭܬި(862262355);
                    int resourceId = ResourceUtil.getResourceId(activity3, str, str2);
                    int resourceId2 = ResourceUtil.getResourceId(activity3, y.ٴسسݬߨ(1392606658), str2);
                    int resourceId3 = ResourceUtil.getResourceId(activity3, y.دײܮڳܯ(2051570877), str2);
                    int resourceId4 = ResourceUtil.getResourceId(activity3, y.֬ڱܱײٮ(-1159650623), str2);
                    HashMap hashMap = new HashMap();
                    hashMap.put(y.֬ڱܱײٮ(-1159491663), Long.valueOf(seq));
                    WebDialog.Settings.Builder fixedFontSize = new WebDialog.Settings.Builder().setFixedTitle().setPortSize(resourceId, resourceId2).setLandSize(resourceId3, resourceId4).setPulltoRefresh(false).setCustomCookie(hashMap).setBackgroundColor(-553648128).setFixedFontSize(true);
                    String str3 = baseUrl;
                    WebDialog.Settings build = fixedFontSize.build();
                    final MutexLock<KGResult<String>> mutexLock = createLock;
                    WebDialogManager.show(activity2, str3, build, false, new KGResultCallback<String>() { // from class: com.kakaogame.KGSNSShare$showShareViewOnActivity$listener$1$onActivityStart$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            mutexLock.setContent(result);
                            mutexLock.unlock();
                        }
                    });
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onDestroy() {
                    if (createLock.isLock()) {
                        createLock.setContent(KGResult.INSTANCE.getSuccessResult());
                        createLock.unlock();
                    }
                }
            };
            long start$default = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, kGActivityEventListener, null, 4, null);
            MutexLock.lock$default(createLock, 0L, 1, null);
            AuthActivityManager.INSTANCE.getInstance().finishActivity(start$default);
            AuthActivityManager.INSTANCE.getInstance().removeResultListener(kGActivityEventListener);
            KGResult kGResult = (KGResult) createLock.getContent();
            if (kGResult != null) {
                return KGResult.INSTANCE.getResult(kGResult);
            }
            return null;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512767087), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isAlreadyPlayerShowUI() {
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        Intrinsics.checkNotNull(currentPlayer);
        String customProperty = currentPlayer.getCustomProperty(y.֬ڱܱײٮ(-1159492871));
        if (TextUtils.isEmpty(customProperty)) {
            return false;
        }
        return StringsKt.equals(y.دײܮڳܯ(2051939573), customProperty, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isAlreadyPlayerShowUI(String seq) {
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        Intrinsics.checkNotNull(currentPlayer);
        String customProperty = currentPlayer.getCustomProperty(y.ٲٴݴ״ٰ(1781975360));
        String str = customProperty;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Intrinsics.checkNotNull(customProperty);
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) str, new String[]{y.ٲٴݴ״ٰ(1781559176)}, false, 0, 6, (Object) null).toArray(new String[0]);
        Logger logger = Logger.INSTANCE;
        String str2 = y.٬ݯح׭٩(575729030) + customProperty + y.ٲٴݴ״ٰ(1781937896) + seq;
        String str3 = y.ݬֲ֮ܲت(1512767087);
        logger.m699d(str3, str2);
        for (String str4 : strArr) {
            if (Intrinsics.areEqual(str4, seq)) {
                Logger.INSTANCE.m699d(str3, y.ٲٴݴ״ٰ(1781937448));
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isAlreadyPlayerReward(Activity activity) {
        String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
        Activity activity2 = activity;
        if (InviteDataManager.isPlayerReward(activity2, playerId)) {
            return true;
        }
        KGResult<Boolean> playerReward = PromotionService.getPlayerReward();
        if (!playerReward.isSuccess()) {
            return false;
        }
        Boolean content = playerReward.getContent();
        Intrinsics.checkNotNull(content);
        if (!content.booleanValue()) {
            return false;
        }
        InviteDataManager.savePlayerRewardData(activity2, playerId);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getInvitationLinkReferrer(Activity activity) {
        String loadReferrer = InviteDataManager.loadReferrer(activity);
        Logger.INSTANCE.m706v(y.ݬֲ֮ܲت(1512767087), y.٬ݯح׭٩(575847686) + loadReferrer);
        String str = loadReferrer;
        return (!(str == null || str.length() == 0) && StringsKt.contains$default((CharSequence) str, (CharSequence) y.֬ڱܱײٮ(-1159650071), false, 2, (Object) null)) ? StringsKt.replace$default(loadReferrer, y.֬ڱܱײٮ(-1159650071), "", false, 4, (Object) null) : "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showRewardView(final Activity activity, String baseUrl, final KGResultCallback<String> callback) {
        String str = y.ۮڭڭܬި(862262355);
        try {
            if (isAlreadyPlayerShowUI()) {
                if (callback != null) {
                    callback.onResult(KGResult.INSTANCE.getResult(200, "Already showInvitationRewardView. No need to show invitation reward view", ""));
                    return;
                }
                return;
            }
            if (isAlreadyPlayerReward(activity)) {
                if (callback != null) {
                    callback.onResult(KGResult.INSTANCE.getResult(200, "Already get reward from referrer code. No need to show invitation reward view.", ""));
                    return;
                }
                return;
            }
            String invitationLinkReferrer = getInvitationLinkReferrer(activity);
            String str2 = baseUrl + '/' + invitationLinkReferrer;
            if (!TextUtils.isEmpty(invitationLinkReferrer)) {
                baseUrl = str2;
            } else if (!InfodeskHelper.INSTANCE.isShowInvitationRewardNoReferrer()) {
                if (callback != null) {
                    callback.onResult(KGResult.INSTANCE.getResult(200, "No referrer found. No need to show invitation reward view.", ""));
                    return;
                }
                return;
            }
            int resourceId = ResourceUtil.getResourceId(activity, "sdk_invitation_portrait_reward_width", str);
            int resourceId2 = ResourceUtil.getResourceId(activity, "sdk_invitation_portrait_reward_height", str);
            WebDialogManager.show(activity, baseUrl, new WebDialog.Settings.Builder().setFixedTitle().setPortSize(resourceId, resourceId2).setLandSize(ResourceUtil.getResourceId(activity, "sdk_invitation_landscape_reward_width", str), ResourceUtil.getResourceId(activity, "sdk_invitation_landscape_reward_height", str)).setViewCloseListener(new WebDialog.OnCloseListener() { // from class: com.kakaogame.KGSNSShare$showRewardView$listener$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.web.WebDialog.OnCloseListener
                public void onClose(WebDialog dialog) {
                    KGSNSShare.INSTANCE.showAlertDialog(activity, dialog);
                }
            }).setFixedFontSize(true).build(), false, new KGResultCallback<String>() { // from class: com.kakaogame.KGSNSShare$showRewardView$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    if (result != null && result.isSuccess()) {
                        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                        Intrinsics.checkNotNull(currentPlayer);
                        currentPlayer.saveCustomProperty(y.֬ڱܱײٮ(-1159492871), y.دײܮڳܯ(2051939573));
                    }
                    KGResultCallback<String> kGResultCallback = callback;
                    if (kGResultCallback != null) {
                        kGResultCallback.onResult(result);
                    }
                }
            });
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512767087), e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showAlertDialog(Activity activity, final WebDialog parentDialog) {
        String string;
        String string2;
        AlertDialog.Builder createAlertDialogBuilder = DialogManager.createAlertDialogBuilder(activity);
        String invitationLinkReferrer = getInvitationLinkReferrer(activity);
        if (TextUtils.isEmpty(invitationLinkReferrer)) {
            string = ResourceUtil.getString(activity, y.٬ݯح׭٩(575726326));
        } else {
            string = ResourceUtil.getString(activity, y.٬ݯح׭٩(575726662));
        }
        Activity activity2 = activity;
        String string3 = ResourceUtil.getString(activity2, y.٬ݯح׭٩(575727118));
        if (TextUtils.isEmpty(invitationLinkReferrer)) {
            string2 = ResourceUtil.getString(activity2, y.ݬֲ֮ܲت(1512704127));
        } else {
            string2 = ResourceUtil.getString(activity2, y.ۮڭڭܬި(862409971));
        }
        createAlertDialogBuilder.setMessage(string);
        createAlertDialogBuilder.setPositiveButton(string3, new DialogInterface.OnClickListener() { // from class: com.kakaogame.KGSNSShare$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        createAlertDialogBuilder.setNegativeButton(string2, new DialogInterface.OnClickListener() { // from class: com.kakaogame.KGSNSShare$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                KGSNSShare.showAlertDialog$lambda$4(WebDialog.this, dialogInterface, i);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGSNSShare$showAlertDialog$3(createAlertDialogBuilder, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showAlertDialog$lambda$4(WebDialog webDialog, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intrinsics.checkNotNull(webDialog);
        webDialog.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showNewRewardView(Activity activity, String baseUrl, final KGResultCallback<String> callback) {
        String str = y.ۮڭڭܬި(862262355);
        try {
            int resourceId = ResourceUtil.getResourceId(activity, "sdk_invitation_portrait_reward_width", str);
            int resourceId2 = ResourceUtil.getResourceId(activity, "sdk_invitation_portrait_reward_height", str);
            WebDialogManager.show(activity, baseUrl, new WebDialog.Settings.Builder().setFixedTitle().setPortSize(resourceId, resourceId2).setLandSize(ResourceUtil.getResourceId(activity, "sdk_invitation_landscape_reward_width", str), ResourceUtil.getResourceId(activity, "sdk_invitation_landscape_reward_height", str)).setFixedFontSize(true).build(), false, new KGResultCallback<String>() { // from class: com.kakaogame.KGSNSShare$showNewRewardView$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    KGResultCallback<String> kGResultCallback = callback;
                    if (kGResultCallback != null) {
                        kGResultCallback.onResult(result);
                    }
                }
            });
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512767087), e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shareScreenShot(Activity activity, boolean isNative, KGResultCallback<Void> callback) {
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512767087);
        String str2 = y.ݬֲ֮ܲت(1512705447);
        FirebaseEvent firebaseEvent = companion.getFirebaseEvent(str, str2);
        try {
            Logger.INSTANCE.m704i(str, str2);
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.snsShare)) {
                Logger.INSTANCE.m701e(str, "SNS Share Feature is not enabled. Check your game settings on the admin page.");
                KGResult<Void> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                }
                firebaseEvent.setResult(result);
                return;
            }
            if (activity != null && !activity.isFinishing()) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGSNSShare$shareScreenShot$1(activity, isNative, callback, firebaseEvent, null), 3, null);
                return;
            }
            Logger.INSTANCE.m701e(str, "shareScreenShot: activity is null or finishing");
            KGResult<Void> result2 = KGResult.INSTANCE.getResult(4000, "activity is null or finishing.");
            if (callback != null) {
                callback.onResult(result2);
            }
            firebaseEvent.setResult(result2);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            KGResult<Void> result3 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result3);
            }
            firebaseEvent.setResult(result3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showShareDialog(Activity activity, SNSShareData data, String code, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSNSShare$showShareDialog$1(activity, data, code, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159492063), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.INSTANCE.shareScreenShot(activity, false, new KGResultCallback<Void>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$1$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                return (KGResult) createLock.getContent();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159499503), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.دײܮڳܯ(2051571757));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.shareContentsLink(activity, str, new KGResultCallback<Void>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$2$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                return (KGResult) createLock.getContent();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628680420), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("code");
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.loadShareRewardInfo(str, new KGResultCallback<Boolean>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$3$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Boolean> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.֬ڱܱײٮ(-1159493631), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512703463), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.showInvitationView(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$4$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                return (KGResult) createLock.getContent();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159492871), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.showInvitationRewardView(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$5$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                return (KGResult) createLock.getContent();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781975360), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.showNewInvitationRewardView(activity, new KGResultCallback<Void>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$6$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Void> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                return (KGResult) createLock.getContent();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159499111), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.loadBadgeInfo(new KGResultCallback<Boolean>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$7$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Boolean> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (!kGResult.isSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.ݬֲ֮ܲت(1512589687), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575728790), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSNSShare.loadJoinerCount(new KGResultCallback<KGSNSShare.KGJoinerCount>() { // from class: com.kakaogame.KGSNSShare$initInterfaceBroker$8$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<KGSNSShare.KGJoinerCount> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (!kGResult.isSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                KGSNSShare.KGJoinerCount kGJoinerCount = (KGSNSShare.KGJoinerCount) kGResult.getContent();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(kGJoinerCount);
                linkedHashMap.put(y.دײܮڳܯ(2051725309), kGJoinerCount.getObject());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* compiled from: KGSNSShare.kt */
    @Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/KGSNSShare$KGJoinerCount;", "Lcom/kakaogame/KGObject;", "joinerCount", "", "(J)V", KGJoinerCount.KEY_NEW_JOINER_COUNT, "", "getNewJoinerCount", "()I", KGJoinerCount.KEY_TOTAL_JOINER_COUNT, "getTotalJoinerCount", KGJoinerCount.KEY_HAS_NEW_JOINER, "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGJoinerCount extends KGObject {
        private static final String KEY_HAS_NEW_JOINER = "hasNewJoiner";
        private static final String KEY_NEW_JOINER_COUNT = "newJoinerCount";
        private static final String KEY_TOTAL_JOINER_COUNT = "totalJoinerCount";
        private static final String TAG = "KGJoinerCount";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGJoinerCount(long j) {
            super(null, 1, null);
            long loadPlayerInvitationCount = j - InviteDataManager.loadPlayerInvitationCount(CoreManager.INSTANCE.getInstance().getContext(), CoreManager.INSTANCE.getInstance().getPlayerId());
            put(y.٬ݯح׭٩(575672446), Boolean.valueOf(loadPlayerInvitationCount > 0));
            put(y.٬ݯح׭٩(575672462), Long.valueOf(loadPlayerInvitationCount));
            put(y.ۮڭڭܬި(862379291), Long.valueOf(j));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean hasNewJoiner() {
            Object obj = get(y.٬ݯح׭٩(575672446));
            Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782032576));
            return ((Boolean) obj).booleanValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getNewJoinerCount() {
            Number number = (Number) get(y.٬ݯح׭٩(575672462));
            Intrinsics.checkNotNull(number);
            return number.intValue();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalJoinerCount() {
            Number number = (Number) get(y.ۮڭڭܬި(862379291));
            Intrinsics.checkNotNull(number);
            return number.intValue();
        }
    }
}
