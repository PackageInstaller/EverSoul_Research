package com.kakaogame;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.promotion.PromotionService;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.web.WebDialog;
import com.kakaogame.web.WebDialogManager;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGInvitation.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\n2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u0010H\u0007J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0010H\u0007J\u001a\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/KGInvitation;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "getInvitationLinkReferrer", "activity", "Landroid/app/Activity;", "initInterfaceBroker", "", "initialize", "isAlreadyPlayerReward", "", "loadBadgeInfo", "callback", "Lcom/kakaogame/KGResultCallback;", "showRewardView", "showShareView", "showShareViewOnActivity", "Lcom/kakaogame/KGResult;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGInvitation {
    private static final String CLASS_NAME_KEY = "KGInvitation";
    public static final KGInvitation INSTANCE = new KGInvitation();
    private static final String TAG = "KGInvitation";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGInvitation() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showShareView(Activity activity, KGResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGInvitation$showShareView$1(activity, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> showShareViewOnActivity(Activity activity) {
        String str = y.ۮڭڭܬި(861981587);
        try {
            String str2 = "";
            String invitationLinkReferrer = !isAlreadyPlayerReward(activity) ? getInvitationLinkReferrer(activity) : "";
            StringBuilder append = new StringBuilder().append(InfodeskHelper.INSTANCE.getSnsInvitationShareHostUrl());
            if (!(invitationLinkReferrer.length() == 0)) {
                str2 = str + invitationLinkReferrer;
            }
            final String sb = append.append(str2).toString();
            KGResult<Long> invitationCount = PromotionService.getInvitationCount();
            if (invitationCount.isSuccess()) {
                Long content = invitationCount.getContent();
                Intrinsics.checkNotNull(content);
                InviteDataManager.savePlayerInvitationCount(activity, CoreManager.INSTANCE.getInstance().getPlayerId(), content.longValue());
            }
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            KGAuthActivity.KGActivityEventListener kGActivityEventListener = new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.KGInvitation$showShareViewOnActivity$listener$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityResult(int requestCode, int resultCode, Intent data) {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityStart(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                    Activity activity3 = activity2;
                    String str3 = y.ٴسسݬߨ(1392606306);
                    String str4 = y.ۮڭڭܬި(862262355);
                    int resourceId = ResourceUtil.getResourceId(activity3, str3, str4);
                    int resourceId2 = ResourceUtil.getResourceId(activity3, y.ٴسسݬߨ(1392606658), str4);
                    WebDialog.Settings.Builder fixedFontSize = new WebDialog.Settings.Builder().setFixedTitle().setPortSize(resourceId, resourceId2).setLandSize(ResourceUtil.getResourceId(activity3, y.دײܮڳܯ(2051570877), str4), ResourceUtil.getResourceId(activity3, y.֬ڱܱײٮ(-1159650623), str4)).setPulltoRefresh(false).setBackgroundColor(-553648128).setFixedFontSize(true);
                    String str5 = sb;
                    WebDialog.Settings build = fixedFontSize.build();
                    final MutexLock<KGResult<String>> mutexLock = createLock;
                    WebDialogManager.show(activity2, str5, build, false, new KGResultCallback<String>() { // from class: com.kakaogame.KGInvitation$showShareViewOnActivity$listener$1$onActivityStart$1
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
            return (KGResult) createLock.getContent();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.دײܮڳܯ(2051563965), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showRewardView(Activity activity, final KGResultCallback<String> callback) {
        String str = y.ۮڭڭܬި(862262355);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        FirebaseEvent.Companion companion = FirebaseEvent.INSTANCE;
        String str2 = y.ٴسسݬߨ(1392604658);
        String str3 = y.دײܮڳܯ(2051563965);
        final FirebaseEvent firebaseEvent = companion.getFirebaseEvent(str3, str2);
        try {
            KGInvitation kGInvitation = INSTANCE;
            boolean isAlreadyPlayerReward = kGInvitation.isAlreadyPlayerReward(activity);
            String str4 = y.ݮڮֲڭܩ(-628800900);
            if (isAlreadyPlayerReward) {
                KGResult<String> successResult = KGResult.INSTANCE.getSuccessResult(str4);
                if (callback != null) {
                    callback.onResult(successResult);
                }
                firebaseEvent.setResult(successResult);
                return;
            }
            String invitationLinkReferrer = kGInvitation.getInvitationLinkReferrer(activity);
            if (invitationLinkReferrer.length() == 0) {
                KGResult<String> successResult2 = KGResult.INSTANCE.getSuccessResult(str4);
                if (callback != null) {
                    callback.onResult(successResult2);
                }
                firebaseEvent.setResult(successResult2);
                return;
            }
            WebDialogManager.show(activity, InfodeskHelper.INSTANCE.getSnsInvitationShareGuestUrl() + '/' + invitationLinkReferrer, new WebDialog.Settings.Builder().setFixedTitle().setPortSize(ResourceUtil.getResourceId(activity, "sdk_invitation_portrait_reward_width", str), ResourceUtil.getResourceId(activity, "sdk_invitation_portrait_reward_height", str)).setLandSize(ResourceUtil.getResourceId(activity, "sdk_invitation_landscape_reward_width", str), ResourceUtil.getResourceId(activity, "sdk_invitation_landscape_reward_height", str)).setFixedFontSize(true).build(), false, new KGResultCallback<String>() { // from class: com.kakaogame.KGInvitation$showRewardView$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    KGResultCallback<String> kGResultCallback = callback;
                    if (kGResultCallback != null) {
                        kGResultCallback.onResult(result);
                    }
                    firebaseEvent.setResult(result);
                }
            });
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
            firebaseEvent.setResult(result);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadBadgeInfo(KGResultCallback<Boolean> callback) {
        FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(y.دײܮڳܯ(2051563965), y.دײܮڳܯ(2051569477));
        KGResult<Long> invitationCount = PromotionService.getInvitationCount();
        if (!invitationCount.isSuccess()) {
            KGResult<Boolean> result = KGResult.INSTANCE.getResult(invitationCount.getCode(), invitationCount.getDescription(), false);
            if (callback != null) {
                callback.onResult(result);
            }
            firebaseEvent.setResult(result);
            return;
        }
        Long content = invitationCount.getContent();
        Intrinsics.checkNotNull(content);
        KGResult<Boolean> successResult = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(InviteDataManager.loadPlayerInvitationCount(CoreManager.INSTANCE.getInstance().getContext(), CoreManager.INSTANCE.getInstance().getPlayerId()) < content.longValue()));
        if (callback != null) {
            callback.onResult(successResult);
        }
        firebaseEvent.setResult(successResult);
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
        Logger.INSTANCE.m706v(y.دײܮڳܯ(2051563965), y.٬ݯح׭٩(575847686) + loadReferrer);
        String str = loadReferrer;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Intrinsics.checkNotNull(loadReferrer);
        return StringsKt.contains$default((CharSequence) str, (CharSequence) y.֬ڱܱײٮ(-1159650071), false, 2, (Object) null) ? StringsKt.replace$default(loadReferrer, y.֬ڱܱײٮ(-1159650071), "", false, 4, (Object) null) : "";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628798036), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGInvitation$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGInvitation.showShareView(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGInvitation$initInterfaceBroker$1$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
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
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392606034), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGInvitation$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGInvitation.showRewardView(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGInvitation$initInterfaceBroker$2$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
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
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051569237), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGInvitation$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGInvitation.loadBadgeInfo(new KGResultCallback<Boolean>() { // from class: com.kakaogame.KGInvitation$initInterfaceBroker$3$request$1
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
                linkedHashMap.put(y.ݬֲ֮ܲت(1512589687), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }
}
