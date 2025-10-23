package com.kakaogame.p029ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.kakaogame.C2382R;
import com.kakaogame.KGAppOption;
import com.kakaogame.KGCustomUI;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.game.StringSet;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AppUpdateManager.kt */
@Metadata(m838d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J*\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\rH\u0002J$\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m839d2 = {"Lcom/kakaogame/ui/AppUpdateManager;", "", "()V", "PREF_NAME", "", "TAG", "appId", "checkUpdate", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "checkUpdateInGame", "", StringSet.info, "Lcom/kakaogame/KGAppOption$UpdatePopupParamBuilder;", "clearPreference", "", "context", "Landroid/content/Context;", "initialize", "applicationId", "showServiceClose", "showUpdateRecommend", "popupInfo", "Lcom/kakaogame/KGAppOption$UpdatePopupParamBuilder$UpdatePopupParam;", "isReadPref", "showUpdateRequired", "marketUrl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AppUpdateManager {
    public static final AppUpdateManager INSTANCE = new AppUpdateManager();
    private static final String PREF_NAME = "KakaoSDK_AppUpdateRecommDate";
    private static final String TAG = "AppUpdateManager";
    private static String appId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AppUpdateManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(String applicationId) {
        appId = applicationId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void clearPreference(Context context) {
        try {
            PreferenceUtil.remove(context, PREF_NAME);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576379542), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> checkUpdate(Activity activity) {
        String str = y.ٴسسݬߨ(1393106114);
        String str2 = y.ݬֲ֮ܲت(1512060575);
        String str3 = y.٬ݯح׭٩(576379310);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str4 = y.٬ݯح׭٩(576379406);
        String str5 = y.٬ݯح׭٩(576379542);
        logger.m699d(str5, str4);
        try {
            InfodeskHelper.InfodeskAppServiceStatus appServiceStatus = InfodeskHelper.INSTANCE.getAppServiceStatus();
            Logger.INSTANCE.m699d(str5, str3 + appServiceStatus);
            if (appServiceStatus == InfodeskHelper.InfodeskAppServiceStatus.CLOSE) {
                return INSTANCE.showServiceClose(activity);
            }
            InfodeskHelper.InfodeskAppUpdateStatus appUpdateStatus = InfodeskHelper.INSTANCE.getAppUpdateStatus();
            Logger.INSTANCE.m699d(str5, str2 + appUpdateStatus);
            String marketUrl = InfodeskHelper.INSTANCE.getMarketUrl();
            Logger.INSTANCE.m699d(str5, str + marketUrl);
            if (appUpdateStatus == InfodeskHelper.InfodeskAppUpdateStatus.UPDATE_RECOMMEND) {
                return INSTANCE.showUpdateRecommend(activity, KGAppOption.getUpdateParam().setMarketUrl(marketUrl).build(), true);
            }
            if (appUpdateStatus == InfodeskHelper.InfodeskAppUpdateStatus.UPDATE_REQUIRED) {
                return INSTANCE.showUpdateRequired(activity, marketUrl);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Boolean> checkUpdateInGame(Activity activity, KGAppOption.UpdatePopupParamBuilder info) {
        KGResult<Boolean> successResult;
        String str = y.ٴسسݬߨ(1393106114);
        String str2 = y.ݬֲ֮ܲت(1512060575);
        if (info == null) {
            info = KGAppOption.getUpdateParam();
        }
        Logger logger = Logger.INSTANCE;
        String str3 = y.٬ݯح׭٩(576379654);
        String str4 = y.٬ݯح׭٩(576379542);
        logger.m699d(str4, str3);
        try {
            InfodeskHelper.InfodeskAppUpdateStatus appUpdateStatus = InfodeskHelper.INSTANCE.getAppUpdateStatus();
            Logger.INSTANCE.m699d(str4, str2 + appUpdateStatus);
            String marketUrl = InfodeskHelper.INSTANCE.getMarketUrl();
            Logger.INSTANCE.m699d(str4, str + marketUrl);
            if (appUpdateStatus == InfodeskHelper.InfodeskAppUpdateStatus.UPDATE_RECOMMEND) {
                info.setMarketUrl(marketUrl);
                INSTANCE.showUpdateRecommend(activity, info.build(), false);
                successResult = KGResult.INSTANCE.getSuccessResult(true);
            } else if (appUpdateStatus == InfodeskHelper.InfodeskAppUpdateStatus.UPDATE_REQUIRED) {
                INSTANCE.showUpdateRequired(activity, marketUrl);
                successResult = KGResult.INSTANCE.getSuccessResult(true);
            } else {
                successResult = KGResult.INSTANCE.getSuccessResult(false);
            }
            return successResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showServiceClose(Activity activity) {
        Logger.INSTANCE.m699d(y.٬ݯح׭٩(576379542), y.֬ڱܱײٮ(-1159118095));
        Activity activity2 = activity;
        String string = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_app_service_status_close);
        String string2 = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_common_button_ok);
        if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE)) {
            CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, "", string, "", "", string2, y.٬ݯح׭٩(576553654)));
        } else {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            DialogManager.Settings settings = new DialogManager.Settings(null, null, string, null, null, null, null, null, false, null, null, null, null, 8187, null);
            settings.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.AppUpdateManager$$ExternalSyntheticLambda4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppUpdateManager.showServiceClose$lambda$0(MutexLock.this, dialogInterface, i);
                }
            });
            DialogManager.INSTANCE.showAlertDialog(activity, settings);
            MutexLock.lock$default(createLock, 0L, 1, null);
        }
        return KGResult.INSTANCE.getResult(9900);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showServiceClose$lambda$0(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showUpdateRequired(Activity activity, String marketUrl) {
        Activity activity2;
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159115791) + marketUrl;
        String str2 = y.٬ݯح׭٩(576379542);
        logger.m699d(str2, str);
        if (activity == null) {
            return KGResult.INSTANCE.getResult(4002);
        }
        if (activity.isFinishing()) {
            Logger.INSTANCE.m701e(str2, y.ݬֲ֮ܲت(1512062183));
            Activity activity3 = CoreManager.INSTANCE.getInstance().getActivity();
            if (!Intrinsics.areEqual(activity, activity3)) {
                if (activity3.isFinishing()) {
                    Intrinsics.checkNotNull(marketUrl);
                    AppUtil.launchApp(activity, marketUrl);
                    return KGResult.INSTANCE.getResult(9900);
                }
                activity2 = activity3;
            } else {
                Intrinsics.checkNotNull(marketUrl);
                AppUtil.launchApp(activity, marketUrl);
                return KGResult.INSTANCE.getResult(9900);
            }
        } else {
            activity2 = activity;
        }
        String resourceString = CoreManager.INSTANCE.getResourceString(y.ۮڭڭܬި(862812171));
        String string = ResourceUtil.getString(activity, C2382R.string.zinny_sdk_app_update_button_now);
        if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE)) {
            CoreManager.INSTANCE.getInstance().showCustomUI(activity2, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, "", resourceString, "", "", string, marketUrl));
        } else {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            DialogManager.Settings settings = new DialogManager.Settings(null, null, resourceString, null, null, null, null, null, false, null, null, null, null, 8187, null);
            settings.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.AppUpdateManager$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppUpdateManager.showUpdateRequired$lambda$1(MutexLock.this, dialogInterface, i);
                }
            });
            DialogManager.INSTANCE.showAlertDialog(activity, settings);
            MutexLock.lock$default(createLock, 0L, 1, null);
        }
        Intrinsics.checkNotNull(marketUrl);
        AppUtil.launchApp(activity2, marketUrl);
        return KGResult.INSTANCE.getResult(9900);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showUpdateRequired$lambda$1(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showUpdateRecommend(Activity activity, KGAppOption.UpdatePopupParamBuilder.UpdatePopupParam popupInfo, boolean isReadPref) {
        Activity activity2;
        String str;
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݬֲ֮ܲت(1512059847) + popupInfo.getMarketUrl();
        String str3 = y.٬ݯح׭٩(576379542);
        logger.m699d(str3, str2);
        if (activity == null) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(y.٬ݯح׭٩(576556590), Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(new Date());
        Activity activity3 = activity;
        String str4 = appId;
        Intrinsics.checkNotNull(str4);
        String str5 = y.ݮڮֲڭܩ(-628282060);
        String string = PreferenceUtil.getString(activity3, str5, str4, null);
        if (string != null && isReadPref && StringsKt.equals(string, format, true)) {
            Logger.INSTANCE.m699d(str3, y.ݮڮֲڭܩ(-628281852));
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (activity.isFinishing()) {
            Logger.INSTANCE.m701e(str3, y.ٴسسݬߨ(1393105858));
            activity2 = CoreManager.INSTANCE.getInstance().getActivity();
            if (!Intrinsics.areEqual(activity, activity2)) {
                if (activity2.isFinishing()) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
            } else {
                return KGResult.INSTANCE.getSuccessResult();
            }
        } else {
            activity2 = activity;
        }
        String str6 = appId;
        Intrinsics.checkNotNull(str6);
        Intrinsics.checkNotNull(format);
        PreferenceUtil.setString(activity3, str5, str6, format);
        String titleMessage = popupInfo.getTitleMessage();
        String updateButton = popupInfo.getUpdateButton();
        Intrinsics.checkNotNull(updateButton);
        final String marketUrl = popupInfo.getMarketUrl();
        String laterButton = popupInfo.getLaterButton();
        Intrinsics.checkNotNull(laterButton);
        if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.NOTICE)) {
            str = CoreManager.INSTANCE.getInstance().showCustomUI(activity2, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.NOTICE, "", titleMessage, laterButton, y.֬ڱܱײٮ(-1159545887), updateButton, marketUrl));
        } else {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            DialogManager.Settings settings = new DialogManager.Settings(null, null, titleMessage, null, null, null, null, null, true, null, null, null, null, 7931, null);
            settings.setPositiveButton(updateButton, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.AppUpdateManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppUpdateManager.showUpdateRecommend$lambda$2(MutexLock.this, marketUrl, dialogInterface, i);
                }
            });
            settings.setNegativeButton(laterButton, new DialogInterface.OnClickListener() { // from class: com.kakaogame.ui.AppUpdateManager$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppUpdateManager.showUpdateRecommend$lambda$3(MutexLock.this, dialogInterface, i);
                }
            });
            settings.setCancelable(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.ui.AppUpdateManager$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    AppUpdateManager.showUpdateRecommend$lambda$4(MutexLock.this, dialogInterface);
                }
            });
            Logger.INSTANCE.m699d(str3, y.٬ݯح׭٩(576377174));
            DialogManager.INSTANCE.showAlertDialog(activity, settings);
            MutexLock.lock$default(createLock, 0L, 1, null);
            str = (String) createLock.getContent();
        }
        if (StringsKt.equals(str, y.֬ڱܱײٮ(-1159545887), true)) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        AppUtil.launchViewer(activity2, str);
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showUpdateRecommend$lambda$2(MutexLock dialogLock, String str, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent(str);
        dialogLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showUpdateRecommend$lambda$3(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent("customUI_close");
        dialogLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showUpdateRecommend$lambda$4(MutexLock dialogLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent("customUI_close");
        dialogLock.unlock();
    }
}
