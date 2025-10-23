package com.kakaogame.push;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.kakaogame.C2382R;
import com.kakaogame.push.PushMessage;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.ResourceUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushNotificationHandler.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0003J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/push/PushNotificationHandler;", "", "()V", "PUSH_TYPE_APP_BADGE", "", "TAG", "handlePushMessage", "", "context", "Landroid/content/Context;", "pushMessage", "Lcom/kakaogame/push/PushMessage;", "imageBitmap", "Landroid/graphics/Bitmap;", "onReceive", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PushNotificationHandler {
    public static final PushNotificationHandler INSTANCE = new PushNotificationHandler();
    private static final String PUSH_TYPE_APP_BADGE = "badge";
    private static final String TAG = "PushNotificationHandler";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PushNotificationHandler() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        com.kakaogame.p029ui.ImageDownloader.initialize(r4);
        r0 = r5.getBigPictureUrl();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        com.kakaogame.p029ui.ImageDownloader.downloadImage(r0, new com.kakaogame.push.PushNotificationHandler$onReceive$1(r4, r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void onReceive(final android.content.Context r4, final com.kakaogame.push.PushMessage r5) {
        /*
            r0 = -628296596(0xffffffffda8cf46c, float:-1.983762E16)
            java.lang.String r0 = com.liapp.y.ݮڮֲڭܩ(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 1782439816(0x6a3ddf88, float:5.7385644E25)
            java.lang.String r2 = com.liapp.y.ٲٴݴ״ٰ(r2)
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2 = 2051130533(0x7a41c4a5, float:2.5152543E35)
            java.lang.String r2 = com.liapp.y.دײܮڳܯ(r2)
            android.util.Log.i(r2, r1)
            if (r4 != 0) goto L28
            return
        L28:
            if (r5 != 0) goto L2b
            return
        L2b:
            java.lang.String r1 = r5.getPushType()     // Catch: java.lang.Exception -> L77
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L77
            r3.<init>(r0)     // Catch: java.lang.Exception -> L77
            java.lang.StringBuilder r0 = r3.append(r1)     // Catch: java.lang.Exception -> L77
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L77
            android.util.Log.d(r2, r0)     // Catch: java.lang.Exception -> L77
            java.lang.String r0 = "badge"
            r3 = 1
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r3)     // Catch: java.lang.Exception -> L77
            if (r0 == 0) goto L49
            return
        L49:
            java.lang.String r0 = r5.getBigPictureUrl()     // Catch: java.lang.Exception -> L77
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L77
            if (r0 == 0) goto L59
            int r0 = r0.length()     // Catch: java.lang.Exception -> L77
            if (r0 != 0) goto L58
            goto L59
        L58:
            r3 = 0
        L59:
            if (r3 != 0) goto L70
            com.kakaogame.p029ui.ImageDownloader.initialize(r4)     // Catch: java.lang.Exception -> L77
            java.lang.String r0 = r5.getBigPictureUrl()     // Catch: java.lang.Exception -> L77
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.lang.Exception -> L77
            com.kakaogame.push.PushNotificationHandler$onReceive$1 r1 = new com.kakaogame.push.PushNotificationHandler$onReceive$1     // Catch: java.lang.Exception -> L77
            r1.<init>()     // Catch: java.lang.Exception -> L77
            com.nostra13.universalimageloader.core.listener.ImageLoadingListener r1 = (com.nostra13.universalimageloader.core.listener.ImageLoadingListener) r1     // Catch: java.lang.Exception -> L77
            com.kakaogame.p029ui.ImageDownloader.downloadImage(r0, r1)     // Catch: java.lang.Exception -> L77
            goto L81
        L70:
            com.kakaogame.push.PushNotificationHandler r0 = com.kakaogame.push.PushNotificationHandler.INSTANCE     // Catch: java.lang.Exception -> L77
            r1 = 0
            r0.handlePushMessage(r4, r5, r1)     // Catch: java.lang.Exception -> L77
            goto L81
        L77:
            r4 = move-exception
            java.lang.String r5 = r4.toString()
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            android.util.Log.e(r2, r5, r4)
        L81:
            return
            fill-array 0x0082: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.push.PushNotificationHandler.onReceive(android.content.Context, com.kakaogame.push.PushMessage):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void handlePushMessage(Context context, PushMessage pushMessage, Bitmap imageBitmap) {
        String str;
        String str2 = y.ݮڮֲڭܩ(-628621444);
        String str3 = y.ٴسسݬߨ(1393083802);
        String str4 = y.٬ݯح׭٩(576389662) + pushMessage;
        String str5 = y.دײܮڳܯ(2051130533);
        Log.i(str5, str4);
        try {
            int notificationId = pushMessage.getNotificationId();
            PendingIntent appPendingIntent = pushMessage.getAppPendingIntent();
            CharSequence ticker = pushMessage.getTicker();
            CharSequence contentTitle = pushMessage.getContentTitle();
            CharSequence contentText = pushMessage.getContentText();
            int iconId = pushMessage.getIconId();
            Bitmap largeIcon = pushMessage.getLargeIcon();
            Log.d(str5, str3 + largeIcon);
            Uri soundUri = pushMessage.getSoundUri();
            long[] vibratePattern = pushMessage.getVibratePattern();
            long currentTimeMillis = System.currentTimeMillis();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContentIntent(appPendingIntent);
            builder.setTicker(ticker);
            builder.setSmallIcon(iconId);
            builder.setContentTitle(contentTitle);
            builder.setContentText(contentText);
            builder.setWhen(currentTimeMillis);
            if (!pushMessage.isMuteMode()) {
                builder.setDefaults(3);
            }
            if (imageBitmap != null) {
                NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
                bigPictureStyle.bigPicture(imageBitmap);
                builder.setStyle(bigPictureStyle);
                Log.i(str5, "Set BigPictureStyle");
            }
            PushMessage.PushTheme theme = pushMessage.getTheme();
            str = str5;
            try {
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C2382R.layout.zinny_sdk_notification);
                if (largeIcon != null) {
                    if (theme == PushMessage.PushTheme.DEFAULT) {
                        builder.setLargeIcon(largeIcon);
                    }
                    remoteViews.setImageViewBitmap(C2382R.id.zinny_sdk_notification_icon, largeIcon);
                } else {
                    remoteViews.setImageViewResource(C2382R.id.zinny_sdk_notification_icon, iconId);
                }
                remoteViews.setTextViewText(C2382R.id.zinny_sdk_notification_title, contentTitle);
                remoteViews.setTextViewText(C2382R.id.zinny_sdk_notification_content, contentText);
                remoteViews.setTextViewText(C2382R.id.zinny_sdk_notification_time, DateFormat.format(ResourceUtil.getString(context, C2382R.string.zinny_sdk_notification_time_format), currentTimeMillis).toString());
                PushMessage.PushTheme pushTheme = PushMessage.PushTheme.GRAY;
                String str6 = y.ۮڭڭܬި(862760619);
                if (theme == pushTheme) {
                    remoteViews.setInt(C2382R.id.zinny_sdk_notification, str6, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_gray_bg));
                    remoteViews.setTextColor(C2382R.id.zinny_sdk_notification_title, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_gray_title_text));
                    remoteViews.setTextColor(C2382R.id.zinny_sdk_notification_content, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_gray_content_text));
                    remoteViews.setTextColor(C2382R.id.zinny_sdk_notification_time, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_gray_time_text));
                } else if (theme == PushMessage.PushTheme.WHITE) {
                    remoteViews.setInt(C2382R.id.zinny_sdk_notification, str6, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_white_bg));
                    remoteViews.setTextColor(C2382R.id.zinny_sdk_notification_title, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_white_title_text));
                    remoteViews.setTextColor(C2382R.id.zinny_sdk_notification_content, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_white_content_text));
                    remoteViews.setTextColor(C2382R.id.zinny_sdk_notification_time, ResourceUtil.getColor(context, C2382R.color.zinny_sdk_notification_white_time_text));
                }
                if (theme != PushMessage.PushTheme.DEFAULT) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
                        builder.setCustomContentView(remoteViews);
                        builder.setCustomBigContentView(remoteViews);
                    } else {
                        builder.setCustomContentView(remoteViews);
                    }
                } else if (imageBitmap == null) {
                    NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle().setBigContentTitle(contentTitle).bigText(contentText);
                    Intrinsics.checkNotNullExpressionValue(bigText, "bigText(...)");
                    builder.setStyle(bigText);
                }
                String str7 = str2;
                if (Build.VERSION.SDK_INT >= 26) {
                    builder.setChannelId(str2);
                }
                if (!AppUtil.isAppForeground(context)) {
                    builder.setPriority(2);
                }
                Notification build = builder.build();
                Intrinsics.checkNotNull(build);
                PushMessage.PushTheme pushTheme2 = PushMessage.PushTheme.DEFAULT;
                if (!pushMessage.isMuteMode()) {
                    if (soundUri != null) {
                        build.sound = soundUri;
                    }
                    if (!(vibratePattern.length == 0)) {
                        build.vibrate = vibratePattern;
                    }
                }
                build.flags |= 17;
                Object systemService = context.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService;
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationChannel notificationChannel = new NotificationChannel(str2, str7, 3);
                    notificationChannel.enableVibration(true);
                    notificationChannel.setVibrationPattern(new long[]{100, 200, 100, 200});
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                notificationManager.notify(notificationId, build);
            } catch (Exception e) {
                e = e;
                Log.e(str, e.toString(), e);
            }
        } catch (Exception e2) {
            e = e2;
            str = str5;
        }
    }
}
