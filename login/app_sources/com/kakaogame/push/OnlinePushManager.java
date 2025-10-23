package com.kakaogame.push;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.kakaogame.C2382R;
import com.kakaogame.KGCustomUI;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.server.session.SessionService;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.StringUtil;
import com.liapp.y;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: OnlinePushManager.kt */
@Metadata(m838d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0003J,\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/push/OnlinePushManager;", "", "()V", "Notice_RemainTimeHourKey", "", "Notice_RemainTimeKey", "TAG", "onlinePushListener", "Lcom/kakaogame/server/session/SessionService$OnlinePushListener;", "getLargeIcon", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "getLargeIconId", "", "getMessage", "messageData", "", "initialize", "", "refreshLocalPlayer", "showNotification", "activity", "Landroid/app/Activity;", "message", "showPopup", "linkUrl", "terminate", "", "showToast", "OnlinePushListenerImpl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class OnlinePushManager {
    private static final String Notice_RemainTimeHourKey = "${remain_total_hour}";
    private static final String Notice_RemainTimeKey = "${remain_total_minute}";
    private static final String TAG = "OnlinePushManager";
    public static final OnlinePushManager INSTANCE = new OnlinePushManager();
    private static final SessionService.OnlinePushListener onlinePushListener = new OnlinePushListenerImpl();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private OnlinePushManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Context context) {
        SessionService.addOnlinePushListener(onlinePushListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getMessage(Map<String, ? extends Object> messageData) {
        Intrinsics.checkNotNull(messageData);
        Map map = (Map) messageData.get(y.ٴسسݬߨ(1393096506));
        String str = y.دײܮڳܯ(2051551053);
        if (map == null) {
            return (String) messageData.get(str);
        }
        String str2 = (String) map.get(KGSystem.getLanguageCode());
        String str3 = str2;
        return str3 == null || str3.length() == 0 ? (String) messageData.get(str) : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void refreshLocalPlayer() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new OnlinePushManager$refreshLocalPlayer$1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showNotification(final Activity activity, final String message) {
        Logger.INSTANCE.m699d(y.٬ݯح׭٩(576405214), y.ٲٴݴ״ٰ(1782442192) + activity + y.ݮڮֲڭܩ(-628756788) + message);
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.push.OnlinePushManager$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                OnlinePushManager.showNotification$lambda$1(activity, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotification$lambda$1(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        try {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(activity);
            builder.setContentTitle(AndroidManifestUtil.getAppName(activity));
            builder.setContentText(str);
            builder.setTicker(str);
            builder.setPriority(2);
            builder.setDefaults(2);
            ApplicationInfo applicationInfo = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            builder.setSmallIcon(applicationInfo.icon);
            Bitmap largeIcon = INSTANCE.getLargeIcon(activity);
            if (largeIcon != null) {
                builder.setLargeIcon(largeIcon);
            }
            Notification build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            build.flags |= 17;
            Object systemService = activity.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            final NotificationManager notificationManager = (NotificationManager) systemService;
            final int i = 2844;
            notificationManager.notify(2844, build);
            new Handler().postDelayed(new Runnable() { // from class: com.kakaogame.push.OnlinePushManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    OnlinePushManager.showNotification$lambda$1$lambda$0(notificationManager, i);
                }
            }, 3000L);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576405214), e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showNotification$lambda$1$lambda$0(NotificationManager notificationManager, int i) {
        Intrinsics.checkNotNullParameter(notificationManager, y.֬ڱܱײٮ(-1159156391));
        notificationManager.cancel(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showToast(final Activity activity, final String message) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger.INSTANCE.m699d(y.٬ݯح׭٩(576405214), y.ۮڭڭܬި(862755267) + activity + y.ݮڮֲڭܩ(-628756788) + message);
        activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.push.OnlinePushManager$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                OnlinePushManager.showToast$lambda$2(activity, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showToast$lambda$2(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        try {
            Toast makeText = Toast.makeText(activity, str, 1);
            makeText.setGravity(49, 0, 0);
            y.٬خݮ۳ݯ();
            makeText.show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576405214), e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showPopup(final Activity activity, String message, final String linkUrl, final boolean terminate) {
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ٲٴݴ״ٰ(1782443928)).append(activity);
        String str = y.ݮڮֲڭܩ(-628756788);
        logger.m699d(y.٬ݯح׭٩(576405214), append.append(str).append(message).append(str).append(linkUrl).append(str).append(terminate).toString());
        if (terminate) {
            AppUtil.terminateAppReservation(activity, 10L);
        }
        Activity activity2 = activity;
        String string = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_common_button_ok);
        String string2 = ResourceUtil.getString(activity2, C2382R.string.zinny_sdk_common_button_detail);
        if (CoreManager.INSTANCE.getInstance().hasCustomAlertHandler(KGCustomUI.KGCustomAlertType.MAINTENANCE)) {
            String str2 = y.٬ݯح׭٩(576553654);
            String str3 = y.֬ڱܱײٮ(-1159545887);
            String str4 = linkUrl;
            String showCustomUI = CoreManager.INSTANCE.getInstance().showCustomUI(activity, KGCustomUI.KGCustomAlert.INSTANCE.makeAlert(KGCustomUI.KGCustomAlertType.MAINTENANCE, "", message, TextUtils.isEmpty(str4) ? "" : string2, TextUtils.isEmpty(str4) ? "" : linkUrl, string, terminate ? str2 : str3));
            if (StringsKt.equals(showCustomUI, str2, true)) {
                AppUtil.terminateApp(activity);
                return;
            }
            if (StringsKt.equals(showCustomUI, str3, true)) {
                return;
            }
            if (terminate) {
                AppUtil.launchViewer(activity2, linkUrl);
                AppUtil.terminateApp(activity);
                return;
            } else {
                if (str4 == null || str4.length() == 0) {
                    return;
                }
                BuildersKt__BuildersKt.runBlocking$default(null, new OnlinePushManager$showPopup$1(activity, linkUrl, null), 1, null);
                return;
            }
        }
        DialogManager.Settings settings = new DialogManager.Settings(null, null, message, null, null, null, null, null, false, null, null, null, null, 8187, null);
        settings.setPositiveButton(string, new DialogInterface.OnClickListener() { // from class: com.kakaogame.push.OnlinePushManager$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                OnlinePushManager.showPopup$lambda$3(terminate, activity, dialogInterface, i);
            }
        });
        String str5 = linkUrl;
        if (!(str5 == null || str5.length() == 0)) {
            settings.setNegativeButton(string2, new DialogInterface.OnClickListener() { // from class: com.kakaogame.push.OnlinePushManager$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    OnlinePushManager.showPopup$lambda$4(terminate, activity, linkUrl, dialogInterface, i);
                }
            });
        }
        DialogManager.INSTANCE.showAlertDialog(activity, settings);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPopup$lambda$3(boolean z, Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (z) {
            AppUtil.terminateApp(activity);
        } else {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPopup$lambda$4(boolean z, Activity activity, String str, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (z) {
            AppUtil.launchViewer(activity, str);
            AppUtil.terminateApp(activity);
        } else {
            dialogInterface.dismiss();
            BuildersKt__BuildersKt.runBlocking$default(null, new OnlinePushManager$showPopup$3$1(activity, str, null), 1, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int getLargeIconId(Context context) {
        String str = y.٬ݯح׭٩(576405214);
        try {
            int identifier = context.getResources().getIdentifier("ic_noti_large", "drawable", context.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Log.e(str, "Notification large icon file: ic_noti_large is not exist.");
            return identifier;
        } catch (Throwable th) {
            Log.e(str, y.٬ݯح׭٩(576402006) + th, th);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Bitmap getLargeIcon(Context context) {
        try {
            int largeIconId = getLargeIconId(context);
            if (largeIconId == 0) {
                return null;
            }
            return BitmapFactory.decodeResource(context.getResources(), largeIconId);
        } catch (Throwable th) {
            Log.e(y.٬ݯح׭٩(576405214), y.٬ݯح׭٩(576402006) + th, th);
            return null;
        }
    }

    /* compiled from: OnlinePushManager.kt */
    @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bH\u0016¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/push/OnlinePushManager$OnlinePushListenerImpl;", "Lcom/kakaogame/server/session/SessionService$OnlinePushListener;", "()V", "onMessage", "", "uri", "", "messageData", "", "", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class OnlinePushListenerImpl implements SessionService.OnlinePushListener {
        private static final String onlinePushUri = "push://v2/online/onMessageForPlatform";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.server.session.SessionService.OnlinePushListener
        public void onMessage(String uri, Map<String, ? extends Object> messageData) {
            String replaceString;
            Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
            if (StringsKt.equals(y.ۮڭڭܬި(862752779), uri, true)) {
                Logger logger = Logger.INSTANCE;
                String str = y.٬ݯح׭٩(576405062) + messageData;
                String str2 = y.٬ݯح׭٩(576405214);
                logger.m699d(str2, str);
                Intrinsics.checkNotNull(messageData);
                String str3 = (String) messageData.get(y.ٲٴݴ״ٰ(1781623144));
                Logger.INSTANCE.m699d(str2, y.֬ڱܱײٮ(-1159158087) + str3);
                if (StringsKt.equals(y.ݬֲ֮ܲت(1512165471), str3, true)) {
                    String message = OnlinePushManager.getMessage(messageData);
                    if (message == null) {
                        message = "";
                    }
                    String str4 = (String) messageData.get(y.ݮڮֲڭܩ(-628442580));
                    boolean z = false;
                    if (StringsKt.equals(y.ٲٴݴ״ٰ(1782149840), (String) messageData.get(y.ۮڭڭܬި(862606107)), true)) {
                        String lowerCase = message.toLowerCase(Locale.ROOT);
                        String str5 = y.ݮڮֲڭܩ(-628797244);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, str5);
                        String str6 = y.ݬֲ֮ܲت(1512530983);
                        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) str6, false, 2, (Object) null)) {
                            Number number = (Number) messageData.get(y.٬ݯح׭٩(576553334));
                            long j = 60;
                            long longValue = ((((number != null ? number.longValue() : 0L) - CoreManager.INSTANCE.getInstance().currentTimeMillis()) / 1000) / j) + 1;
                            String lowerCase2 = message.toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, str5);
                            String str7 = y.دײܮڳܯ(2051492365);
                            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) str7, false, 2, (Object) null)) {
                                long j2 = longValue % j;
                                String str8 = y.ݮڮֲڭܩ(-628458116);
                                String format = String.format(Locale.US, StringUtil.replaceString(message, str7, str8), Long.valueOf((longValue - j2) / j));
                                String str9 = y.ٲٴݴ״ٰ(1782078816);
                                Intrinsics.checkNotNullExpressionValue(format, str9);
                                replaceString = String.format(Locale.US, StringUtil.replaceString(format, str6, str8), Long.valueOf(j2));
                                Intrinsics.checkNotNullExpressionValue(replaceString, str9);
                            } else {
                                replaceString = StringUtil.replaceString(message, str6, String.valueOf(longValue));
                            }
                            message = replaceString;
                        }
                        z = !InfodeskHelper.INSTANCE.isWhitelist();
                    }
                    OnlinePushManager.INSTANCE.showPopup(activity, message, str4, z);
                    return;
                }
                if (StringsKt.equals(y.ݮڮֲڭܩ(-628306004), str3, true)) {
                    String message2 = OnlinePushManager.getMessage(messageData);
                    String str10 = (String) messageData.get(y.ݮڮֲڭܩ(-628487100));
                    if (str10 != null) {
                        boolean equals = StringsKt.equals(str10, y.ٴسسݬߨ(1393095786), true);
                        String str11 = y.ݬֲ֮ܲت(1512814407);
                        String str12 = y.دײܮڳܯ(2051283261);
                        if (equals) {
                            Object obj = messageData.get(str12);
                            Intrinsics.checkNotNull(obj, str11);
                            String str13 = (String) obj;
                            Object obj2 = messageData.get(y.ݬֲ֮ܲت(1512510487));
                            String str14 = y.دײܮڳܯ(2051781685);
                            Intrinsics.checkNotNull(obj2, str14);
                            long longValue2 = ((Long) obj2).longValue();
                            Object obj3 = messageData.get(y.ٴسسݬߨ(1393442554));
                            Intrinsics.checkNotNull(obj3, str14);
                            long longValue3 = ((Long) obj3).longValue();
                            long currentTimeMillis = longValue3 - CoreManager.INSTANCE.getInstance().currentTimeMillis();
                            Object obj4 = messageData.get(y.ݬֲ֮ܲت(1512510599));
                            Intrinsics.checkNotNull(obj4, str14);
                            long longValue4 = ((Long) obj4).longValue();
                            Logger.INSTANCE.m699d(str2, y.ݮڮֲڭܩ(-628309980) + longValue3 + y.ٴسسݬߨ(1393439418) + longValue4 + y.֬ڱܱײٮ(-1159157263) + currentTimeMillis);
                            if (currentTimeMillis > longValue4) {
                                CoreManager.INSTANCE.getInstance().startOnlineAlarmTimer(activity, str13, message2, longValue4, longValue2, longValue3);
                                return;
                            }
                            return;
                        }
                        if (StringsKt.equals(str10, y.֬ڱܱײٮ(-1158781631), true)) {
                            Object obj5 = messageData.get(str12);
                            Intrinsics.checkNotNull(obj5, str11);
                            CoreManager.INSTANCE.getInstance().stopOnlineAlarmTimer((String) obj5);
                            return;
                        }
                        OnlinePushManager.showToast(activity, message2);
                        return;
                    }
                    OnlinePushManager.showToast(activity, message2);
                    return;
                }
                if (StringsKt.equals(y.ݮڮֲڭܩ(-628941404), str3, true)) {
                    OnlinePushManager.INSTANCE.showNotification(activity, OnlinePushManager.getMessage(messageData));
                    return;
                }
                if (StringsKt.equals(y.ݮڮֲڭܩ(-628309652), str3, true)) {
                    OnlinePushManager.INSTANCE.refreshLocalPlayer();
                } else if (StringsKt.equals(y.ݬֲ֮ܲت(1512502807), str3, true)) {
                    Logger.INSTANCE.m699d(str2, y.٬ݯح׭٩(576401822));
                    CoreManager.INSTANCE.getInstance().sendLogFilesImmediately();
                }
            }
        }
    }
}
