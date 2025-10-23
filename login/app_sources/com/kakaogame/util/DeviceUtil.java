package com.kakaogame.util;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.kakaogame.Logger;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceUtil.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\nR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m839d2 = {"Lcom/kakaogame/util/DeviceUtil;", "", "()V", "PREF_NAME", "", "TAG", "advertisingId", "deviceBrand", "getDeviceBrand$annotations", "getDeviceBrand", "()Ljava/lang/String;", ServerConstants.DEVICE_MODEL, "getDeviceModel$annotations", "getDeviceModel", "serial", "getSerial$annotations", "getSerial", ServerConstants.WHITEKEY, "getAdvertisingId", "context", "Landroid/content/Context;", "getAdvertisingIdFromClient", "", "getAndroidId", "getDeviceId", "getKeyHash", "getSSAID", "activity", "Landroid/app/Activity;", "getWhiteKey", "isGooglePlayServicesAvailable", "", "isNotificationEnable", "channelId", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DeviceUtil {
    private static final String PREF_NAME = "KGGUID";
    private static final String TAG = "DeviceUtil";
    public static final DeviceUtil INSTANCE = new DeviceUtil();
    private static String advertisingId = "";
    private static String whiteKey = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getDeviceBrand$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getDeviceModel$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getSerial$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DeviceUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getDeviceModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, y.ݮڮֲڭܩ(-628267276));
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getDeviceBrand() {
        String str = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str, y.٬ݯح׭٩(576361982));
        return str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getSSAID(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        String string = Settings.Secure.getString(activity.getApplicationContext().getContentResolver(), y.ݮڮֲڭܩ(-629050348));
        Intrinsics.checkNotNullExpressionValue(string, y.دײܮڳܯ(2051035965));
        return string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String getSerial() {
        String str;
        String str2 = y.ٴسسݬߨ(1392813258);
        try {
            if (Build.VERSION.SDK_INT > 26) {
                str = Build.getSerial();
            } else {
                str = Build.SERIAL;
            }
            return str == null ? str2 : str;
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getDeviceId(Context context) {
        String str = y.ۮڭڭܬި(862796595);
        String str2 = y.٬ݯح׭٩(576362102);
        String string = PreferenceUtil.getString(context, str, str2);
        String str3 = string;
        if (!(str3 == null || str3.length() == 0)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        PreferenceUtil.setString(context, str, str2, uuid);
        return uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getAndroidId(Context context) {
        if (context == null) {
            return "";
        }
        String string = Settings.Secure.getString(context.getContentResolver(), y.ݮڮֲڭܩ(-629050348));
        Intrinsics.checkNotNullExpressionValue(string, y.دײܮڳܯ(2051035965));
        return string;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isNotificationEnable(Context context, String channelId) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                if (!NotificationManagerCompat.from(context).areNotificationsEnabled() || TextUtils.isEmpty(channelId)) {
                    return false;
                }
                Object systemService = context.getSystemService("notification");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationChannel notificationChannel = ((NotificationManager) systemService).getNotificationChannel(channelId);
                return notificationChannel == null || notificationChannel.getImportance() != 0;
            }
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKeyHash(Context context) {
        PackageInfo packageInfo;
        String str = y.ݮڮֲڭܩ(-628267844);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
        if (packageInfo == null) {
            return null;
        }
        Signature[] signatures = packageInfo.signatures;
        Intrinsics.checkNotNullExpressionValue(signatures, "signatures");
        int length = signatures.length;
        for (int i = 0; i < length; i++) {
            Signature signature = signatures[i];
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                messageDigest.update(signature.toByteArray());
                return Base64.encodeToString(messageDigest.digest(), 2);
            } catch (NoSuchAlgorithmException e2) {
                Logger.INSTANCE.m709w(str, "Unable to get MessageDigest. signature=" + signature, e2);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getAdvertisingId(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (!TextUtils.isEmpty(whiteKey)) {
            return advertisingId;
        }
        INSTANCE.getAdvertisingIdFromClient(context);
        return advertisingId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final String getWhiteKey(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        if (!TextUtils.isEmpty(whiteKey)) {
            return whiteKey;
        }
        INSTANCE.getAdvertisingIdFromClient(context);
        return whiteKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isGooglePlayServicesAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
            Intrinsics.checkNotNullExpressionValue(googleApiAvailabilityLight, "getInstance(...)");
            return googleApiAvailabilityLight.isGooglePlayServicesAvailable(context) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void getAdvertisingIdFromClient(Context context) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782337304);
        String str2 = y.ݮڮֲڭܩ(-628267844);
        logger.m706v(str2, str);
        try {
            if (isGooglePlayServicesAvailable(context)) {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                Intrinsics.checkNotNullExpressionValue(advertisingIdInfo, "getAdvertisingIdInfo(...)");
                String id = advertisingIdInfo.getId();
                if (id != null) {
                    whiteKey = id;
                    if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                        return;
                    }
                    advertisingId = whiteKey;
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }
}
