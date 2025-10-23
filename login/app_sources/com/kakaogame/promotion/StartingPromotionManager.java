package com.kakaogame.promotion;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.bumptech.glide.Glide;
import com.facebook.internal.ServerProtocol;
import com.kakaogame.C2382R;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.p029ui.DeepLinkManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: StartingPromotionManager.kt */
@Metadata(m838d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013J\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013J.\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0013H\u0003J.\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m839d2 = {"Lcom/kakaogame/promotion/StartingPromotionManager;", "", "()V", "TAG", "", "bgDialog", "Landroid/app/Dialog;", "clearPreference", "", "context", "Landroid/content/Context;", "getErrorMessage", "code", "", "showStartPromotion", "activity", "Landroid/app/Activity;", ServerConstants.SEQ, "callback", "Lcom/kakaogame/KGResultCallback;", "showStartPromotions", "showStartingPromotionPopups", "promotionList", "", "Lcom/kakaogame/promotion/KGPromotionData;", "showStartingPromotionPopupsInternal", "Lcom/kakaogame/KGResult;", "screenPortrait", "", "HidePrefManager", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class StartingPromotionManager {
    public static final StartingPromotionManager INSTANCE = new StartingPromotionManager();
    private static final String TAG = "StartingPromotionManager";
    private static Dialog bgDialog;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private StartingPromotionManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void clearPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        HidePrefManager.INSTANCE.clearDate(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getErrorMessage(Context context, int code) {
        return code == 406 ? ResourceUtil.getString(context, C2382R.string.zinny_sdk_promotion_error_not_exist) : ResourceUtil.getString(context, C2382R.string.zinny_sdk_error_msg_common, Integer.valueOf(code));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showStartPromotions(Activity activity, KGResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new StartingPromotionManager$showStartPromotions$1(callback, activity, new Ref.ObjectRef(), null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showStartPromotion(Activity activity, int seq, KGResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new StartingPromotionManager$showStartPromotion$1(callback, activity, new Ref.ObjectRef(), seq, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showStartingPromotionPopups(Activity activity, List<KGPromotionData> promotionList, KGResultCallback<String> callback) {
        String str = y.ݮڮֲڭܩ(-628314612);
        String str2 = y.ۮڭڭܬި(862486483);
        String str3 = y.ٲٴݴ״ٰ(1782416888);
        Logger logger = Logger.INSTANCE;
        String str4 = y.ۮڭڭܬި(862778011) + promotionList;
        String str5 = y.ݬֲ֮ܲت(1512157999);
        logger.m699d(str5, str4);
        int requestedOrientation = activity.getRequestedOrientation();
        try {
            try {
                Logger.INSTANCE.m699d(str5, str3 + requestedOrientation);
                boolean isScreenPortrait = DisplayUtil.isScreenPortrait(activity);
                if (isScreenPortrait) {
                    activity.setRequestedOrientation(7);
                } else {
                    activity.setRequestedOrientation(6);
                }
                Logger.INSTANCE.m699d(str5, str.concat(isScreenPortrait ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false"));
                callback.onResult(showStartingPromotionPopupsInternal(activity, promotionList, isScreenPortrait));
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str5, str2 + e, e);
                callback.onResult(KGResult.INSTANCE.getResult(4001, e.toString()));
            }
        } finally {
            activity.setRequestedOrientation(requestedOrientation);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> showStartingPromotionPopupsInternal(final Activity activity, List<KGPromotionData> promotionList, boolean screenPortrait) {
        String str;
        Object runBlocking$default;
        KGResult<String> kGResult;
        final String landscapeImageUrl;
        ArrayList arrayList = new ArrayList();
        Iterator<KGPromotionData> it = promotionList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str = y.ݬֲ֮ܲت(1512157999);
            if (!hasNext) {
                break;
            }
            KGPromotionData next = it.next();
            if (!HidePrefManager.INSTANCE.isHideDate(activity, next.getSequence())) {
                if (screenPortrait) {
                    landscapeImageUrl = next.getPortraitImageUrl();
                } else {
                    landscapeImageUrl = next.getLandscapeImageUrl();
                }
                Logger.INSTANCE.m699d(str, y.ٲٴݴ״ٰ(1782418352) + landscapeImageUrl);
                String str2 = landscapeImageUrl;
                if (!(str2 == null || str2.length() == 0)) {
                    arrayList.add(next);
                    activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.promotion.StartingPromotionManager$$ExternalSyntheticLambda0
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            StartingPromotionManager.showStartingPromotionPopupsInternal$lambda$0(activity, landscapeImageUrl);
                        }
                    });
                }
            }
        }
        if (arrayList.isEmpty()) {
            Logger.INSTANCE.m699d(str, y.دײܮڳܯ(2051118965));
            return KGResult.INSTANCE.getSuccessResult("");
        }
        MutexLock createLock = MutexLock.INSTANCE.createLock();
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            KGPromotionData kGPromotionData = (KGPromotionData) it2.next();
            MutexLock createLock2 = MutexLock.INSTANCE.createLock();
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new StartingPromotionManager$showStartingPromotionPopupsInternal$2(kGPromotionData, activity, createLock2, null), 3, null);
            MutexLock.lock$default(createLock2, 0L, 1, null);
            String str3 = (String) createLock2.getContent();
            String str4 = str3;
            if (!(str4 == null || str4.length() == 0)) {
                if (DeepLinkManager.INSTANCE.isPlatformDeepLink(str3)) {
                    kGResult = DeepLinkManager.INSTANCE.handlePlatformDeepLink(activity, str3);
                } else if (DeepLinkManager.INSTANCE.isDeepLink(str3)) {
                    kGResult = KGResult.INSTANCE.getSuccessResult(str3);
                } else {
                    runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new C2440x2fc3d79e(activity, str3, null), 1, null);
                    kGResult = (KGResult) runBlocking$default;
                }
                createLock.setContent(kGResult);
                createLock.unlock();
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new StartingPromotionManager$showStartingPromotionPopupsInternal$3(null), 3, null);
        KGResult<String> kGResult2 = (KGResult) createLock.getContent();
        return kGResult2 == null ? KGResult.INSTANCE.getSuccessResult("") : kGResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showStartingPromotionPopupsInternal$lambda$0(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        Glide.with(activity).load(str).preload();
    }

    /* compiled from: StartingPromotionManager.kt */
    @Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/promotion/StartingPromotionManager$HidePrefManager;", "", "()V", "PREFERENCE_NAME", "", "currentDate", "getCurrentDate", "()Ljava/lang/String;", "clearDate", "", "context", "Landroid/content/Context;", "isHideDate", "", "sequence", "", "saveHideDate", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class HidePrefManager {
        public static final HidePrefManager INSTANCE = new HidePrefManager();
        private static final String PREFERENCE_NAME = "StartingPromotionHide";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private HidePrefManager() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void saveHideDate(Context context, int sequence) {
            Logger.INSTANCE.m699d(y.ݬֲ֮ܲت(1512157999), y.ۮڭڭܬި(862777603) + sequence);
            PreferenceUtil.setString(context, y.ۮڭڭܬި(862778955), String.valueOf(sequence), getCurrentDate());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isHideDate(Context context, int sequence) {
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            return StringsKt.equals(PreferenceUtil.getString(context, y.ۮڭڭܬި(862778955), String.valueOf(sequence), ""), getCurrentDate(), true);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final String getCurrentDate() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(y.٬ݯح׭٩(576556590));
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            String format = simpleDateFormat.format(new Date());
            Intrinsics.checkNotNullExpressionValue(format, y.ٲٴݴ״ٰ(1782078816));
            return format;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void clearDate(Context context) {
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            PreferenceUtil.remove(context, y.ۮڭڭܬި(862778955));
        }
    }
}
