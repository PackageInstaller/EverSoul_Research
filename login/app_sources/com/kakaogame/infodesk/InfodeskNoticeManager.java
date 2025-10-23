package com.kakaogame.infodesk;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.kakaogame.C2382R;
import com.kakaogame.KGApplication;
import com.kakaogame.KGCustomUI;
import com.kakaogame.KGGameNoticeInfo;
import com.kakaogame.KGMessage;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.infodesk.InfodeskData;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.push.OnlinePushManager;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.StringUtil;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.web.WebDialogManager;
import com.liapp.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: InfodeskNoticeManager.kt */
@Metadata(m838d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ(\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J \u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\u0002J \u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001e\u0010\"\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J \u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, m839d2 = {"Lcom/kakaogame/infodesk/InfodeskNoticeManager;", "", "()V", "Notice_RemainTimeHourKey", "", "Notice_RemainTimeKey", "PREF_NAME", "TAG", "appId", "clearPreference", "", "context", "Landroid/content/Context;", "getGameServerMaintenance", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/KGApplication$KGGameServerMaintenanceResponse;", "activity", "Landroid/app/Activity;", "showUI", "", "gameServerId", "getNoticeDisplayMessage", "message", "periodEndTime", "", "initialize", "applicationId", "showAlarms", "infodesk", "Lcom/kakaogame/infodesk/InfodeskData;", "showNotice", "Ljava/lang/Void;", KGMessage.SENDER_ID_NOTICE, "Lcom/kakaogame/infodesk/InfodeskData$KGInfodeskNotice;", "showNotices", "noticeList", "", "Lcom/kakaogame/KGGameNoticeInfo;", "showTerminateNoticeOnRefreshInfodesk", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class InfodeskNoticeManager {
    public static final InfodeskNoticeManager INSTANCE = new InfodeskNoticeManager();
    public static final String Notice_RemainTimeHourKey = "${remain_total_hour}";
    public static final String Notice_RemainTimeKey = "${remain_total_minute}";
    private static final String PREF_NAME = "KakaoGameSDK_InfodeskNoticeDate";
    private static final String TAG = "InfodeskNoticeManager";
    private static String appId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InfodeskNoticeManager() {
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
            Logger.INSTANCE.m702e(y.ۮڭڭܬި(862594611), e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showAlarms(Activity activity, InfodeskData infodesk) {
        String str = y.ۮڭڭܬި(862594611);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(infodesk, y.ۮڭڭܬި(862593131));
        try {
            Logger.INSTANCE.m699d(str, "showAlarms");
            List<InfodeskData.KGInfodeskAlarm> alarms = infodesk.getAlarms();
            if (alarms == null) {
                return;
            }
            for (InfodeskData.KGInfodeskAlarm kGInfodeskAlarm : alarms) {
                String notificationId = kGInfodeskAlarm.getNotificationId();
                Intrinsics.checkNotNull(notificationId);
                if (kGInfodeskAlarm.isCancel()) {
                    CoreManager.INSTANCE.getInstance().stopOnlineAlarmTimer(notificationId);
                    return;
                }
                long startTime = kGInfodeskAlarm.getStartTime();
                long endTime = kGInfodeskAlarm.getEndTime();
                long currentTimeMillis = endTime - CoreManager.INSTANCE.getInstance().currentTimeMillis();
                long interval = kGInfodeskAlarm.getInterval();
                String message = OnlinePushManager.getMessage(kGInfodeskAlarm.getObject());
                Intrinsics.checkNotNull(message);
                if (currentTimeMillis > interval) {
                    CoreManager.INSTANCE.getInstance().startOnlineAlarmTimer(activity, notificationId, message, interval, startTime, endTime);
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> showNotices(Activity activity, InfodeskData infodesk) {
        String str = y.ۮڭڭܬި(862594611);
        String str2 = y.ٴسسݬߨ(1393444730);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(infodesk, y.ۮڭڭܬި(862593131));
        try {
            Logger.INSTANCE.m699d(str, "showNotices");
            List<InfodeskData.KGInfodeskNotice> notices = infodesk.getNotices();
            if (notices == null) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            Logger.INSTANCE.m699d(str, str2 + notices.size());
            for (InfodeskData.KGInfodeskNotice kGInfodeskNotice : notices) {
                if (kGInfodeskNotice.getActionOnClose() == InfodeskData.KGInfodeskNotice.InfodeskNoticeActionOnClose.TERMINATE) {
                    if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.maintenance)) {
                        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.SERVICE_UNAVAILABLE);
                    }
                } else if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.urgentNotice)) {
                }
                KGResult<Void> showNotice = INSTANCE.showNotice(activity, kGInfodeskNotice);
                if (!showNotice.isSuccess()) {
                    return KGResult.INSTANCE.getResult(showNotice);
                }
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> showTerminateNoticeOnRefreshInfodesk(Activity activity, InfodeskData infodesk) {
        String str = y.ۮڭڭܬި(862594611);
        String str2 = y.ݬֲ֮ܲت(1512532999);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(infodesk, y.ۮڭڭܬި(862593131));
        try {
            Logger.INSTANCE.m699d(str, "showTerminateNoticeOnRefreshInfodesk");
            List<InfodeskData.KGInfodeskNotice> notices = infodesk.getNotices();
            if (notices == null) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            Logger.INSTANCE.m699d(str, str2 + notices.size());
            for (InfodeskData.KGInfodeskNotice kGInfodeskNotice : notices) {
                if (kGInfodeskNotice.getActionOnClose() == InfodeskData.KGInfodeskNotice.InfodeskNoticeActionOnClose.TERMINATE) {
                    if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.maintenance)) {
                        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.SERVICE_UNAVAILABLE);
                    }
                    if (CoreManager.INSTANCE.getInstance().currentTimeMillis() - kGInfodeskNotice.getStartTime() < 300000) {
                        Logger.INSTANCE.m699d(str, "Pass the terminate notice, before 5min.");
                        return KGResult.INSTANCE.getSuccessResult();
                    }
                    if (!InfodeskHelper.INSTANCE.isWhitelist()) {
                        AppUtil.terminateAppReservation(activity, 10L);
                    }
                    KGResult<Void> showNotice = INSTANCE.showNotice(activity, kGInfodeskNotice);
                    if (!showNotice.isSuccess()) {
                        return KGResult.INSTANCE.getResult(showNotice);
                    }
                }
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showNotice(Activity activity, final InfodeskData.KGInfodeskNotice notice) {
        String message;
        String str;
        Logger logger = Logger.INSTANCE;
        String str2 = y.֬ڱܱײٮ(-1158802287) + notice;
        String str3 = y.ۮڭڭܬި(862594611);
        logger.m699d(str3, str2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(y.٬ݯح׭٩(576556590), Locale.getDefault());
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        String format = simpleDateFormat.format(new Date());
        String str4 = appId + '_' + notice.getNoticeId();
        Activity activity2 = activity;
        String str5 = y.دײܮڳܯ(2051491869);
        String string = PreferenceUtil.getString(activity2, str5, str4, null);
        boolean z = true;
        if (string != null) {
            InfodeskData.KGInfodeskNotice.InfodeskNoticeDisplayRule displayRule = notice.getDisplayRule();
            if (displayRule == InfodeskData.KGInfodeskNotice.InfodeskNoticeDisplayRule.ONCE) {
                Logger.INSTANCE.m699d(str3, y.٬ݯح׭٩(576556870));
                return KGResult.INSTANCE.getSuccessResult();
            }
            if (displayRule == InfodeskData.KGInfodeskNotice.InfodeskNoticeDisplayRule.DAILY && StringsKt.equals(string, format, true)) {
                Logger.INSTANCE.m699d(str3, y.ݬֲ֮ܲت(1512533983));
                return KGResult.INSTANCE.getSuccessResult();
            }
        }
        String str6 = y.ٴسسݬߨ(1392719098);
        Object obj = notice.get(str6);
        String str7 = y.ݮڮֲڭܩ(-628686508);
        if (Intrinsics.areEqual(obj, str7)) {
            Number number = (Number) notice.get(y.٬ݯح׭٩(576553334));
            message = getNoticeDisplayMessage(notice.getMessage(), number != null ? number.longValue() : 0L);
        } else {
            message = notice.getMessage();
        }
        String str8 = message;
        Intrinsics.checkNotNull(format);
        PreferenceUtil.setString(activity2, str5, str4, format);
        final String link = notice.getLink();
        String string2 = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_common_button_ok);
        String string3 = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_common_button_detail);
        KGCustomUI.KGCustomAlertType kGCustomAlertType = Intrinsics.areEqual(notice.get(str6), str7) ? KGCustomUI.KGCustomAlertType.MAINTENANCE : KGCustomUI.KGCustomAlertType.NOTICE;
        Logger.INSTANCE.m699d(str3, y.٬ݯح׭٩(576553358).concat(CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(kGCustomAlertType) ? y.دײܮڳܯ(2051939573) : y.ٲٴݴ״ٰ(1781635312)));
        boolean hasCustomAlertHandler = CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(kGCustomAlertType);
        String str9 = y.٬ݯح׭٩(576553654);
        String str10 = y.֬ڱܱײٮ(-1159545887);
        if (hasCustomAlertHandler) {
            String str11 = link;
            str = CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(kGCustomAlertType, "", str8, str11 == null || str11.length() == 0 ? "" : string3, str11 == null || str11.length() == 0 ? "" : link, string2, notice.getActionOnClose() == InfodeskData.KGInfodeskNotice.InfodeskNoticeActionOnClose.TERMINATE ? str9 : str10));
        } else {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            DialogManager.Settings settings = new DialogManager.Settings(null, null, str8, null, null, null, null, null, false, null, null, null, null, 8187, null);
            settings.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    InfodeskNoticeManager.showNotice$lambda$0(InfodeskData.KGInfodeskNotice.this, createLock, dialogInterface, i);
                }
            });
            String str12 = link;
            if (!(str12 == null || str12.length() == 0)) {
                settings.setNegativeButton(string3, new DialogInterface.OnClickListener() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$$ExternalSyntheticLambda4
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        InfodeskNoticeManager.showNotice$lambda$1(MutexLock.this, link, dialogInterface, i);
                    }
                });
            }
            if (notice.getActionOnClose() != InfodeskData.KGInfodeskNotice.InfodeskNoticeActionOnClose.TERMINATE) {
                settings.setCancelable(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$$ExternalSyntheticLambda5
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        InfodeskNoticeManager.showNotice$lambda$2(MutexLock.this, dialogInterface);
                    }
                });
            }
            DialogManager.INSTANCE.showAlertDialog(activity, settings);
            MutexLock.lock$default(createLock, 0L, 1, null);
            str = (String) createLock.getContent();
        }
        if (StringsKt.equals(str, str10, true)) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (StringsKt.equals(str, str9, true)) {
            return KGResult.INSTANCE.getResult(9900);
        }
        String str13 = str;
        if (str13 != null && str13.length() != 0) {
            z = false;
        }
        if (!z) {
            if (notice.getActionOnClose() == InfodeskData.KGInfodeskNotice.InfodeskNoticeActionOnClose.TERMINATE) {
                AppUtil.launchViewer(activity2, str);
                return KGResult.INSTANCE.getResult(9900);
            }
            WebDialogManager.show$default(activity, str, null, false, new KGResultCallback<String>() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$showNotice$4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    Logger.INSTANCE.m699d(y.ۮڭڭܬި(862594611), y.ݮڮֲڭܩ(-628458788) + link + y.ٴسسݬߨ(1393446642));
                }
            }, 12, null);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotice$lambda$0(InfodeskData.KGInfodeskNotice notice, MutexLock dialogLock, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(notice, "$notice");
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent(notice.getActionOnClose() == InfodeskData.KGInfodeskNotice.InfodeskNoticeActionOnClose.TERMINATE ? DialogManager.ACTION_TERMINATE : "customUI_close");
        dialogLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotice$lambda$1(MutexLock dialogLock, String str, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent(str);
        dialogLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotice$lambda$2(MutexLock dialogLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent("customUI_close");
        dialogLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getNoticeDisplayMessage(String message, long periodEndTime) {
        String replaceString;
        String str = message;
        if (str == null || str.length() == 0) {
            return "";
        }
        Locale locale = Locale.getDefault();
        String str2 = y.֬ڱܱײٮ(-1158775023);
        Intrinsics.checkNotNullExpressionValue(locale, str2);
        String lowerCase = message.toLowerCase(locale);
        String str3 = y.ݮڮֲڭܩ(-628797244);
        Intrinsics.checkNotNullExpressionValue(lowerCase, str3);
        String str4 = y.ݬֲ֮ܲت(1512530983);
        if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str4, false, 2, (Object) null)) {
            return message;
        }
        long j = 60;
        long currentTimeMillis = (((periodEndTime - CoreManager.INSTANCE.getInstance().currentTimeMillis()) / 1000) / j) + 1;
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, str2);
        String lowerCase2 = message.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, str3);
        String str5 = y.دײܮڳܯ(2051492365);
        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str5, false, 2, (Object) null)) {
            long j2 = currentTimeMillis % j;
            String str6 = y.ݮڮֲڭܩ(-628458116);
            String format = String.format(Locale.US, StringUtil.replaceString(message, str5, str6), Long.valueOf((currentTimeMillis - j2) / j));
            Intrinsics.checkNotNullExpressionValue(format, y.ٲٴݴ״ٰ(1782078816));
            replaceString = String.format(Locale.US, StringUtil.replaceString(format, str4, str6), Long.valueOf(j2));
        } else {
            replaceString = StringUtil.replaceString(message, str4, String.valueOf(currentTimeMillis));
        }
        Intrinsics.checkNotNull(replaceString);
        return replaceString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KGApplication.KGGameServerMaintenanceResponse> getGameServerMaintenance(Activity activity, boolean showUI, String gameServerId) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        KGResult<JSONObject> loadGameServerMaintenance = InfodeskService.INSTANCE.loadGameServerMaintenance(activity, gameServerId);
        if (loadGameServerMaintenance.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(loadGameServerMaintenance);
        }
        JSONObject content = loadGameServerMaintenance.getContent();
        Intrinsics.checkNotNull(content);
        JSONObject jSONObject = content;
        Boolean bool = (Boolean) jSONObject.get((Object) y.֬ڱܱײٮ(-1158929071));
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = (JSONArray) jSONObject.get((Object) y.֬ڱܱײٮ(-1159613431));
        JSONArray jSONArray2 = jSONArray;
        if (jSONArray2 == null || jSONArray2.isEmpty()) {
            return KGResult.INSTANCE.getSuccessResult(new KGApplication.KGGameServerMaintenanceResponse(CollectionsKt.emptyList(), booleanValue));
        }
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
            Object obj = null;
            String str = (String) (jSONObject2 != null ? jSONObject2.get((Object) y.ݬֲ֮ܲت(1512734375)) : null);
            String str2 = y.٬ݯح׭٩(576553334);
            Number number = (Number) (jSONObject2 != null ? jSONObject2.get((Object) str2) : null);
            long longValue = number != null ? number.longValue() : 0L;
            String str3 = y.ٴسسݬߨ(1393441538);
            Number number2 = (Number) (jSONObject2 != null ? jSONObject2.get((Object) str3) : null);
            long longValue2 = number2 != null ? number2.longValue() : 0L;
            if (jSONObject2 != null) {
                obj = jSONObject2.get((Object) y.ݮڮֲڭܩ(-628442580));
            }
            arrayList.add(new KGGameNoticeInfo(MapsKt.mutableMapOf(TuplesKt.m846to(y.دײܮڳܯ(2051551053), getNoticeDisplayMessage(str, longValue)), TuplesKt.m846to(y.٬ݯح׭٩(575849926), (String) obj), TuplesKt.m846to(str2, Long.valueOf(longValue)), TuplesKt.m846to(str3, Long.valueOf(longValue2)))));
        }
        if (showUI) {
            showNotices(activity, arrayList);
        }
        return KGResult.INSTANCE.getSuccessResult(new KGApplication.KGGameServerMaintenanceResponse(arrayList, booleanValue));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showNotices(Activity activity, List<KGGameNoticeInfo> noticeList) {
        Activity activity2 = activity;
        String string = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_common_button_ok);
        String string2 = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_common_button_detail);
        for (final KGGameNoticeInfo kGGameNoticeInfo : noticeList) {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            DialogManager.Settings settings = new DialogManager.Settings(null, null, kGGameNoticeInfo.getMessage(), null, null, null, null, null, false, null, null, null, null, 8187, null);
            settings.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    InfodeskNoticeManager.showNotices$lambda$3(MutexLock.this, dialogInterface, i);
                }
            });
            String detailLink = kGGameNoticeInfo.getDetailLink();
            if (!(detailLink == null || detailLink.length() == 0)) {
                settings.setNegativeButton(string2, new DialogInterface.OnClickListener() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$$ExternalSyntheticLambda1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        InfodeskNoticeManager.showNotices$lambda$4(MutexLock.this, kGGameNoticeInfo, dialogInterface, i);
                    }
                });
            }
            settings.setCancelable(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    InfodeskNoticeManager.showNotices$lambda$5(MutexLock.this, dialogInterface);
                }
            });
            DialogManager.INSTANCE.showAlertDialog(activity, settings);
            MutexLock.lock$default(createLock, 0L, 1, null);
            final String str = (String) createLock.getContent();
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                WebDialogManager.show$default(activity, str, null, false, new KGResultCallback<String>() { // from class: com.kakaogame.infodesk.InfodeskNoticeManager$showNotices$4
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862594611), y.ݮڮֲڭܩ(-628458788) + str + y.ٴسسݬߨ(1393446642));
                    }
                }, 12, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotices$lambda$3(MutexLock dialogLock, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent("");
        dialogLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotices$lambda$4(MutexLock dialogLock, KGGameNoticeInfo notice, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        Intrinsics.checkNotNullParameter(notice, "$notice");
        dialogLock.setContent(notice.getDetailLink());
        dialogLock.unlock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotices$lambda$5(MutexLock dialogLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogLock, "$dialogLock");
        dialogLock.setContent("");
        dialogLock.unlock();
    }
}
