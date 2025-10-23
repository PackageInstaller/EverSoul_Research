package com.kakaogame.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.kakaogame.Logger;
import com.kakaogame.util.AndroidManifestUtil;
import com.liapp.y;
import com.unity.androidnotifications.UnityNotificationManager;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: PushMessage.kt */
@Metadata(m838d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0016\n\u0002\b\u0006\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0017\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010B\u001a\u00020\u0015H\u0016R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b \u0010\"R\u0013\u0010#\u001a\u0004\u0018\u00010$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\rR\u0011\u0010)\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b*\u0010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b-\u0010\u0017R\u0011\u0010.\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b/\u0010\rR\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b5\u0010\u0017R\u0011\u00106\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b8\u00109R\u0011\u0010:\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b;\u0010\u001bR\u0013\u0010<\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b=\u0010\u0017R\u0011\u0010>\u001a\u00020?8F¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006E"}, m839d2 = {"Lcom/kakaogame/push/PushMessage;", "", "context", "Landroid/content/Context;", "budle", "Landroid/os/Bundle;", "(Landroid/content/Context;Landroid/os/Bundle;)V", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/content/Intent;", "(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/Intent;)V", "appIconId", "", "getAppIconId", "()I", "appPendingIntent", "Landroid/app/PendingIntent;", "getAppPendingIntent", "()Landroid/app/PendingIntent;", "badge", "getBadge", "bigPictureUrl", "", "getBigPictureUrl", "()Ljava/lang/String;", "contentText", "", "getContentText", "()Ljava/lang/CharSequence;", "contentTitle", "getContentTitle", "iconId", "getIconId", "isMuteMode", "", "()Z", UnityNotificationManager.KEY_LARGE_ICON, "Landroid/graphics/Bitmap;", "getLargeIcon", "()Landroid/graphics/Bitmap;", "largeIconId", "getLargeIconId", "notificationId", "getNotificationId", "pushBundle", "pushType", "getPushType", "requestCode", "getRequestCode", "soundUri", "Landroid/net/Uri;", "getSoundUri", "()Landroid/net/Uri;", "targetType", "getTargetType", "theme", "Lcom/kakaogame/push/PushMessage$PushTheme;", "getTheme", "()Lcom/kakaogame/push/PushMessage$PushTheme;", "ticker", "getTicker", "urlScheme", "getUrlScheme", "vibratePattern", "", "getVibratePattern", "()[J", "toString", "Companion", "PushTheme", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class PushMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String KEY_PUSH_ID = "pushId";
    private static final String TAG = "PushMessage";
    private final Context context;
    private final Intent pendingIntent;
    private final Bundle pushBundle;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PushMessage(Context context, Bundle bundle, Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bundle, intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ PushMessage(Context context, Bundle bundle, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final PushMessage getPushMessage(Context context, Bundle bundle) {
        return INSTANCE.getPushMessage(context, bundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final PushMessage getPushMessage(Context context, Bundle bundle, Intent intent) {
        return INSTANCE.getPushMessage(context, bundle, intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PushMessage(Context context, Bundle bundle) {
        this.context = context;
        this.pushBundle = bundle;
        this.pendingIntent = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PushMessage(Context context, Bundle bundle, Intent intent) {
        this.context = context;
        this.pushBundle = bundle;
        this.pendingIntent = intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PendingIntent getAppPendingIntent() {
        Intent launchIntentForPackage;
        PackageManager packageManager = this.context.getPackageManager();
        String urlScheme = getUrlScheme();
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051141821) + urlScheme;
        String str2 = y.ݬֲ֮ܲت(1512167935);
        logger.m704i(str2, str);
        if (urlScheme != null) {
            launchIntentForPackage = new Intent();
            launchIntentForPackage.setAction(y.ٲٴݴ״ٰ(1781642640));
            launchIntentForPackage.setData(Uri.parse(urlScheme));
        } else {
            Intent intent = this.pendingIntent;
            launchIntentForPackage = intent == null ? packageManager.getLaunchIntentForPackage(this.context.getPackageName()) : intent;
        }
        boolean z = this.pushBundle.getBoolean(y.֬ڱܱײٮ(-1159156215), false);
        Logger.INSTANCE.m704i(str2, y.٬ݯح׭٩(576403278) + urlScheme);
        if (z) {
            Intrinsics.checkNotNull(launchIntentForPackage);
            launchIntentForPackage.setFlags(603979776);
            launchIntentForPackage.addFlags(32768);
        }
        Intrinsics.checkNotNull(launchIntentForPackage);
        launchIntentForPackage.putExtras(this.pushBundle);
        Logger.INSTANCE.m704i(str2, y.ٲٴݴ״ٰ(1782443200) + launchIntentForPackage);
        PendingIntent activity = PendingIntent.getActivity(this.context, getRequestCode(), launchIntentForPackage, 201326592);
        Logger.INSTANCE.m704i(str2, y.ݮڮֲڭܩ(-628295572) + activity);
        Intrinsics.checkNotNull(activity);
        return activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUrlScheme() {
        return this.pushBundle.getString(y.ݮڮֲڭܩ(-628442580));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPushType() {
        String string = this.pushBundle.getString(y.دײܮڳܯ(2051132157));
        return string == null ? "" : string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CharSequence getContentTitle() {
        String string = this.pushBundle.getString(y.ݮڮֲڭܩ(-628294836));
        if (TextUtils.isEmpty(string)) {
            string = AndroidManifestUtil.getAppName(this.context);
        }
        Spanned fromHtml = Html.fromHtml(string);
        Intrinsics.checkNotNullExpressionValue(fromHtml, y.ݬֲ֮ܲت(1512170815));
        return fromHtml;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CharSequence getContentText() {
        String string = this.pushBundle.getString(y.ٴسسݬߨ(1393086050));
        if (string == null) {
            string = "";
        }
        Spanned fromHtml = Html.fromHtml(string);
        Intrinsics.checkNotNullExpressionValue(fromHtml, y.ݬֲ֮ܲت(1512170815));
        return fromHtml;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final CharSequence getTicker() {
        String string = this.pushBundle.getString(y.ۮڭڭܬި(862757531));
        if (string == null) {
            string = "";
        }
        Spanned fromHtml = Html.fromHtml(string);
        Intrinsics.checkNotNullExpressionValue(fromHtml, y.ݬֲ֮ܲت(1512170815));
        return fromHtml;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getBadge() {
        Bundle bundle = this.pushBundle;
        String str = y.ٴسسݬߨ(1393085594);
        if (!bundle.containsKey(str)) {
            return 0;
        }
        String string = this.pushBundle.getString(str);
        try {
            Intrinsics.checkNotNull(string);
            return Integer.parseInt(string);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512167935), y.֬ڱܱײٮ(-1159163455) + string, e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri getSoundUri() {
        String str = y.ٴسسݬߨ(1392906250);
        String string = this.pushBundle.getString(y.ݬֲ֮ܲت(1512170087));
        if (string == null) {
            string = y.٬ݯح׭٩(576629638);
        }
        try {
            return Uri.parse(str + this.context.getPackageName() + '/' + this.context.getResources().getIdentifier(string, "raw", this.context.getPackageName()));
        } catch (Exception unused) {
            Log.e(y.ݬֲ֮ܲت(1512167935), y.ݮڮֲڭܩ(-628294044) + string);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long[] getVibratePattern() {
        String string = this.pushBundle.getString(y.ٴسسݬߨ(1393085362));
        if (string == null) {
            string = "";
        }
        String[] strArr = (String[]) new Regex(y.ٲٴݴ״ٰ(1781559176)).split(string, 0).toArray(new String[0]);
        if (strArr.length <= 1) {
            return new long[0];
        }
        long[] jArr = new long[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            jArr[i] = Long.parseLong(strArr[i]);
        }
        return jArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getIconId() {
        String str = y.ݬֲ֮ܲت(1512167935);
        String str2 = y.ٲٴݴ״ٰ(1782435992);
        try {
            String string = this.pushBundle.getString(UnityNotificationManager.KEY_SMALL_ICON);
            if (string == null) {
                string = "ic_noti";
            }
            int identifier = this.context.getResources().getIdentifier(string, "drawable", this.context.getPackageName());
            if (identifier != 0) {
                return identifier;
            }
            Log.e(str, str2 + string + " is not exist.");
            return getAppIconId();
        } catch (Throwable th) {
            Log.e(str, str2 + th, th);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int getLargeIconId() {
        String str = y.ݬֲ֮ܲت(1512167935);
        try {
            int identifier = this.context.getResources().getIdentifier("ic_noti_large", "drawable", this.context.getPackageName());
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
    public final Bitmap getLargeIcon() {
        try {
            int largeIconId = getLargeIconId();
            if (largeIconId == 0) {
                return null;
            }
            return BitmapFactory.decodeResource(this.context.getResources(), largeIconId);
        } catch (Throwable th) {
            Log.e(y.ݬֲ֮ܲت(1512167935), y.٬ݯح׭٩(576402006) + th, th);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRequestCode() {
        String string = this.pushBundle.getString(y.ݬֲ֮ܲت(1512170311));
        try {
            Intrinsics.checkNotNull(string);
            return Integer.parseInt(string);
        } catch (Exception e) {
            Log.e(y.ݬֲ֮ܲت(1512167935), y.֬ڱܱײٮ(-1159162759) + string, e);
            return 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTargetType() {
        return this.pushBundle.getString(y.ٴسسݬߨ(1393085202));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getNotificationId() {
        if (StringsKt.equals(y.دײܮڳܯ(2051131949), getTargetType(), true)) {
            return (int) System.currentTimeMillis();
        }
        return 12523215;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getBigPictureUrl() {
        return this.pushBundle.getString(y.ٲٴݴ״ٰ(1782436544));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PushTheme getTheme() {
        String string = this.pushBundle.getString(y.ݬֲ֮ܲت(1512396567));
        for (PushTheme pushTheme : PushTheme.values()) {
            if (StringsKt.equals(pushTheme.getValue(), string, true)) {
                return pushTheme;
            }
        }
        return PushTheme.DEFAULT;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isMuteMode() {
        Bundle bundle = this.pushBundle;
        String str = y.֬ڱܱײٮ(-1159161591);
        if (bundle.containsKey(str)) {
            return this.pushBundle.getBoolean(str);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576389206) + this.pushBundle + ']';
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PushMessage.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/push/PushMessage$PushTheme;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "WHITE", "GRAY", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class PushTheme {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PushTheme[] $VALUES;
        private final String value;
        public static final PushTheme DEFAULT = new PushTheme(y.ۮڭڭܬި(862755627), 0, y.٬ݯح׭٩(576402918));
        public static final PushTheme WHITE = new PushTheme(y.دײܮڳܯ(2051597149), 1, y.ݬֲ֮ܲت(1512622959));
        public static final PushTheme GRAY = new PushTheme(y.֬ڱܱײٮ(-1159610567), 2, y.ٴسسݬߨ(1392632202));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ PushTheme[] $values() {
            return new PushTheme[]{DEFAULT, WHITE, GRAY};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<PushTheme> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PushTheme valueOf(String str) {
            return (PushTheme) Enum.valueOf(PushTheme.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static PushTheme[] values() {
            return (PushTheme[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PushTheme(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            PushTheme[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int getAppIconId() {
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            return applicationInfo.icon;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* compiled from: PushMessage.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/push/PushMessage$Companion;", "", "()V", "KEY_PUSH_ID", "", "TAG", "getPushMessage", "Lcom/kakaogame/push/PushMessage;", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/content/Intent;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final PushMessage getPushMessage(Context context, Bundle bundle) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (context == null || bundle == null) {
                return null;
            }
            return new PushMessage(context, bundle, defaultConstructorMarker);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final PushMessage getPushMessage(Context context, Bundle bundle, Intent pendingIntent) {
            Intrinsics.checkNotNullParameter(pendingIntent, y.֬ڱܱײٮ(-1159156639));
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (context == null || bundle == null) {
                return null;
            }
            return new PushMessage(context, bundle, pendingIntent, defaultConstructorMarker);
        }
    }
}
