package com.kakaogame.promotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.kakaogame.C2382R;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UrlPromotionManager.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u001a\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/promotion/UrlPromotionManager;", "", "()V", "TAG", "", "URL_SCHEME", "prevReferrer", "checkUrlPromotion", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "getClickReferrer", "initialize", "", "context", "Landroid/content/Context;", "appId", "showResultUi", "resultStr", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UrlPromotionManager {
    private static final String TAG = "UrlPromotionManager";
    private static String prevReferrer;
    public static final UrlPromotionManager INSTANCE = new UrlPromotionManager();
    private static String URL_SCHEME = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UrlPromotionManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Context context, String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        URL_SCHEME = y.٬ݯح׭٩(576399862) + appId;
        Logger.INSTANCE.m706v(y.دײܮڳܯ(2051117861), y.֬ڱܱײٮ(-1159154911) + URL_SCHEME);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> checkUrlPromotion(Activity activity) {
        String str = y.ݬֲ֮ܲت(1512160887);
        String str2 = y.֬ڱܱײٮ(-1159148951);
        String str3 = y.٬ݯح׭٩(575847686);
        String str4 = y.٬ݯح׭٩(576410670);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.promotion)) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        Logger logger = Logger.INSTANCE;
        String str5 = y.֬ڱܱײٮ(-1159148143) + activity;
        String str6 = y.دײܮڳܯ(2051117861);
        logger.m699d(str6, str5);
        try {
            UrlPromotionManager urlPromotionManager = INSTANCE;
            String clickReferrer = urlPromotionManager.getClickReferrer(activity);
            Logger.INSTANCE.m706v(str6, str4 + clickReferrer);
            if (TextUtils.isEmpty(clickReferrer)) {
                clickReferrer = InviteDataManager.loadReferrer(activity);
                Logger.INSTANCE.m706v(str6, str3 + clickReferrer);
                if (TextUtils.isEmpty(clickReferrer)) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
                Intrinsics.checkNotNull(clickReferrer);
                if (StringsKt.contains$default((CharSequence) clickReferrer, (CharSequence) "kgi", false, 2, (Object) null)) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
            }
            if (StringsKt.equals(clickReferrer, prevReferrer, true)) {
                Logger.INSTANCE.m706v(str6, str2 + clickReferrer);
                return KGResult.INSTANCE.getSuccessResult();
            }
            KGResult<String> checkUrlPromotion = PromotionService.checkUrlPromotion(clickReferrer);
            Logger.INSTANCE.m706v(str6, str + checkUrlPromotion + " : " + checkUrlPromotion.getContent());
            if (checkUrlPromotion.isSuccess()) {
                prevReferrer = clickReferrer;
                InviteDataManager.removeReferrer(activity);
                urlPromotionManager.showResultUi(activity, checkUrlPromotion.getContent());
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str6, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getClickReferrer(Activity activity) {
        String str = y.دײܮڳܯ(2051117861);
        if (activity == null) {
            Logger.INSTANCE.m701e(str, y.ٴسسݬߨ(1392634106));
            return null;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            Logger.INSTANCE.m706v(str, y.دײܮڳܯ(2051117965));
            return null;
        }
        Uri data = intent.getData();
        Logger.INSTANCE.m706v(str, y.ٲٴݴ״ٰ(1782418792) + data);
        if (data == null) {
            Logger.INSTANCE.m706v(str, y.٬ݯح׭٩(576411270));
            return null;
        }
        String scheme = data.getScheme();
        if (!StringsKt.equals(URL_SCHEME, scheme, true)) {
            Logger.INSTANCE.m706v(str, y.ٲٴݴ״ٰ(1782418440) + scheme);
            return null;
        }
        String authority = data.getAuthority();
        if (!StringsKt.equals(y.ۮڭڭܬި(862780139), authority, true)) {
            Logger.INSTANCE.m706v(str, y.ݮڮֲڭܩ(-628303844) + authority);
            return null;
        }
        String queryParameter = data.getQueryParameter(y.ۮڭڭܬި(862461307));
        Logger.INSTANCE.m706v(str, y.ݬֲ֮ܲت(1512432967) + queryParameter);
        if (!TextUtils.isEmpty(queryParameter)) {
            return queryParameter;
        }
        Logger.INSTANCE.m706v(str, y.٬ݯح׭٩(576399638) + queryParameter);
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showResultUi(Activity activity, String resultStr) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862750651) + resultStr;
        String str2 = y.دײܮڳܯ(2051117861);
        logger.m699d(str2, str);
        if (StringsKt.equals(y.دײܮڳܯ(2051140989), resultStr, true)) {
            DialogManager.INSTANCE.showDialog(activity, ResourceUtil.getString(activity, C2382R.string.zinny_sdk_promotion_url_achieved), new Function1<Boolean, Unit>() { // from class: com.kakaogame.promotion.UrlPromotionManager$showResultUi$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public final void invoke(boolean z) {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (StringsKt.equals(y.ݬֲ֮ܲت(1512162503), resultStr, true)) {
            DialogManager.INSTANCE.showDialog(activity, ResourceUtil.getString(activity, C2382R.string.zinny_sdk_promotion_url_already_achieved), new Function1<Boolean, Unit>() { // from class: com.kakaogame.promotion.UrlPromotionManager$showResultUi$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public final void invoke(boolean z) {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            });
        } else if (StringsKt.equals(y.٬ݯح׭٩(576400350), resultStr, true)) {
            DialogManager.INSTANCE.showDialog(activity, ResourceUtil.getString(activity, C2382R.string.zinny_sdk_promotion_url_ended), new Function1<Boolean, Unit>() { // from class: com.kakaogame.promotion.UrlPromotionManager$showResultUi$3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public final void invoke(boolean z) {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            });
        } else {
            if (StringsKt.equals("NO_PROMOTION", resultStr, true)) {
                return;
            }
            Logger.INSTANCE.m708w(str2, y.ݬֲ֮ܲت(1512162239) + resultStr);
        }
    }
}
