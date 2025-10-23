package com.kakaogame.idp;

import android.app.Activity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthService;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ChannelConnectHelper.kt */
@Metadata(m838d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J,\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J,\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/idp/ChannelConnectHelper;", "", "()V", "FACEBOOK_AUTH_CLASS_NAME", "", "FACEBOOK_SHARE_IMAGE_MEMTHOD_NAME", "FACEBOOK_SHARE_MEMTHOD_NAME", "GOOGLE_GAME_AUTH2_MEMTHOD_NAME", "GOOGLE_GAME_AUTH_CLASS_NAME", "GOOGLE_GAME_AUTH_MEMTHOD_NAME", "GOOGLE_GAME_VERSION", "TAG", "checkGoogleGame", "", "activity", "Landroid/app/Activity;", "account", "Lcom/kakaogame/idp/IdpAccount;", "checkGoogleGameVersion", "", "facebookShareImage", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", Base2ndPWViewData.KEY_PATH, "hashTag", "facebookShareLink", "link", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ChannelConnectHelper {
    private static final String FACEBOOK_AUTH_CLASS_NAME = "com.kakaogame.idp.FacebookShare";
    private static final String FACEBOOK_SHARE_IMAGE_MEMTHOD_NAME = "shareImage";
    private static final String FACEBOOK_SHARE_MEMTHOD_NAME = "shareLink";
    private static final String GOOGLE_GAME_AUTH2_MEMTHOD_NAME = "manualLogin";
    private static final String GOOGLE_GAME_AUTH_CLASS_NAME = "com.kakaogame.idp.GoogleGameAuth";
    private static final String GOOGLE_GAME_AUTH_MEMTHOD_NAME = "login";
    private static final String GOOGLE_GAME_VERSION = "getVersion";
    public static final ChannelConnectHelper INSTANCE = new ChannelConnectHelper();
    private static final String TAG = "ChannelConnectHelper";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ChannelConnectHelper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void checkGoogleGame(Activity activity, IdpAccount account) {
        String str = y.٬ݯح׭٩(576549966);
        String str2 = y.دײܮڳܯ(2051519125);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(account, y.ۮڭڭܬި(862470355));
        Logger logger = Logger.INSTANCE;
        String str3 = y.ݮڮֲڭܩ(-628456148) + account;
        String str4 = y.٬ݯح׭٩(576550438);
        logger.m704i(str4, str3);
        try {
            int googleGameVersion = CoreManager.INSTANCE.getInstance().getGoogleGameVersion();
            String str5 = y.ٲٴݴ״ٰ(1782296016);
            String str6 = y.دײܮڳܯ(2051316573);
            if (googleGameVersion == 1) {
                if (!InfodeskHelper.INSTANCE.useGoogleGame()) {
                    Logger.INSTANCE.m704i(str4, "InfodeskUtil.useGoogleGame returns false");
                    return;
                }
                if (!StringsKt.equals(KGIdpProfile.KGIdpCode.Kakao.getCode(), account.getIdpCode(), true)) {
                    Logger.INSTANCE.m704i(str4, str2 + account.getIdpCode());
                    return;
                } else if (!StringsKt.equals(Locale.KOREA.getCountry(), LocaleManager.INSTANCE.getCountryCode(), true)) {
                    Logger.INSTANCE.m704i(str4, str + LocaleManager.INSTANCE.getCountryCode());
                    return;
                } else {
                    Logger.INSTANCE.m704i(str4, str6 + Class.forName(str5).getMethod("login", Activity.class, Boolean.TYPE).invoke(null, activity, true));
                    return;
                }
            }
            Object invoke = Class.forName(str5).getMethod(GOOGLE_GAME_AUTH2_MEMTHOD_NAME, Activity.class, Boolean.TYPE).invoke(null, activity, true);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.kakaogame.KGResult<kotlin.String>");
            KGResult kGResult = (KGResult) invoke;
            Logger.INSTANCE.m704i(str4, str6 + invoke);
            if (kGResult.isSuccess()) {
                String str7 = (String) kGResult.getContent();
                String str8 = str7;
                if (str8 == null || str8.length() == 0) {
                    return;
                }
                AuthService.INSTANCE.syncGooglePlayerId(str7);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m699d(str4, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int checkGoogleGameVersion() {
        String str = y.ٲٴݴ״ٰ(1782288448);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݮڮֲڭܩ(-628442100);
        String str3 = y.٬ݯح׭٩(576550438);
        logger.m704i(str3, str2);
        try {
            Object invoke = Class.forName(GOOGLE_GAME_AUTH_CLASS_NAME).getMethod(GOOGLE_GAME_VERSION, new Class[0]).invoke(null, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) invoke).intValue();
            Logger.INSTANCE.m701e(str3, str + intValue);
            return intValue;
        } catch (Exception e) {
            Logger.INSTANCE.m701e(str3, e.toString());
            return 1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> facebookShareLink(Activity activity, String link, String hashTag) {
        String str = y.ݬֲ֮ܲت(1512547847);
        Intrinsics.checkNotNullParameter(link, y.ݮڮֲڭܩ(-628442580));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٴسسݬߨ(1393463026) + link;
        String str3 = y.٬ݯح׭٩(576550438);
        logger.m704i(str3, str2);
        try {
            Object invoke = Class.forName(FACEBOOK_AUTH_CLASS_NAME).getMethod(FACEBOOK_SHARE_MEMTHOD_NAME, Activity.class, String.class, String.class).invoke(null, activity, link, hashTag);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.kakaogame.KGResult<java.lang.Void?>");
            KGResult<Void> kGResult = (KGResult) invoke;
            Logger.INSTANCE.m704i(str3, str + kGResult);
            return kGResult;
        } catch (Exception e) {
            Logger.INSTANCE.m699d(str3, e.toString());
            return KGResult.INSTANCE.getResult(4001);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> facebookShareImage(Activity activity, String path, String hashTag) {
        String str = y.٬ݯح׭٩(576550886);
        Intrinsics.checkNotNullParameter(path, y.دײܮڳܯ(2051509965));
        Logger logger = Logger.INSTANCE;
        String str2 = y.֬ڱܱײٮ(-1158753839) + path;
        String str3 = y.٬ݯح׭٩(576550438);
        logger.m704i(str3, str2);
        try {
            Object invoke = Class.forName(FACEBOOK_AUTH_CLASS_NAME).getMethod(FACEBOOK_SHARE_IMAGE_MEMTHOD_NAME, Activity.class, String.class, String.class).invoke(null, activity, path, hashTag);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type com.kakaogame.KGResult<java.lang.Void?>");
            KGResult<Void> kGResult = (KGResult) invoke;
            Logger.INSTANCE.m704i(str3, str + kGResult);
            return kGResult;
        } catch (Exception e) {
            Logger.INSTANCE.m699d(str3, e.toString());
            return KGResult.INSTANCE.getResult(4001);
        }
    }
}
