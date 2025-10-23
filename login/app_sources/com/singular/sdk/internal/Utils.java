package com.singular.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Looper;
import android.provider.Settings;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.net.HttpHeaders;
import com.singular.sdk.SingularLinkHandler;
import com.singular.sdk.SingularLinkParams;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Utils {
    private static int asidScope;
    private static double asidTimeinterval;
    private static final SingularLog logger = SingularLog.getLogger("Utils");
    private static String wrapperName = null;
    private static String wrapperVersion = null;
    private static String imei = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Utils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isEmptyOrNull(String str) {
        return str == null || str.trim().length() == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static double lagSince(long j) {
        return (getCurrentTimeMillis() - j) * 0.001d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String sha1Hash(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str2.getBytes("UTF-8"));
            messageDigest.update(str.getBytes("UTF-8"));
            return bytesToHexString(messageDigest.digest());
        } catch (Throwable th) {
            logger.error("error in sha1Hash()", th);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String bytesToHexString(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            cArr2[i3] = cArr[i2 >>> 4];
            cArr2[i3 + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String formatTimestamp(long j) {
        return new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isGooglePlayServicesAvailable() {
        return SLReflectionUtils.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient") != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Object getAdvertisingInfoObject(Context context) throws Exception {
        return SLReflectionUtils.invokeStaticMethod("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class}, context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPlayStoreAdId(Context context) {
        try {
            String str = (String) SLReflectionUtils.invokeInstanceMethod(getAdvertisingInfoObject(context), "getId", null, new Object[0]);
            if (isInvalidDeviceId(str)) {
                return null;
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isLimitedTrackingEnabled(Context context) {
        try {
            return ((Boolean) SLReflectionUtils.invokeInstanceMethod(getAdvertisingInfoObject(context), "isLimitAdTrackingEnabled", null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return !getInvalidDeviceIds().contains(string) ? string : "None";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isAmazonAvailable(Context context) {
        try {
            Settings.Secure.getInt(context.getContentResolver(), Constants.AMAZON_LIMIT_AD_TRACKING);
            return true;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getAmazonId(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), Constants.AMAZON_ADVERTISING_ID);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isAmazonLimitAdTracking(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), Constants.AMAZON_LIMIT_AD_TRACKING) != 0;
        } catch (Settings.SettingNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getAppSetId(Context context) {
        try {
            Task appSetIdInfo = AppSet.getClient(context).getAppSetIdInfo();
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            final long currentTimeMillis = getCurrentTimeMillis();
            appSetIdInfo.addOnSuccessListener(new OnSuccessListener<AppSetIdInfo>() { // from class: com.singular.sdk.internal.Utils.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(AppSetIdInfo appSetIdInfo2) {
                    int unused = Utils.asidScope = appSetIdInfo2.getScope();
                    linkedBlockingQueue.offer(appSetIdInfo2.getId());
                    double unused2 = Utils.asidTimeinterval = Utils.lagSince(currentTimeMillis);
                }
            });
            String str = (String) linkedBlockingQueue.poll(1L, TimeUnit.SECONDS);
            if (isEmptyOrNull(str)) {
                return null;
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double getASIDTimeInterval() {
        return asidTimeinterval;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getASIDScope() {
        return asidScope;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Set<String> getInvalidDeviceIds() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add(Constants.PLATFORM);
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        hashSet.add("0000-0000");
        return hashSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isInvalidDeviceId(String str) {
        if (isEmptyOrNull(str)) {
            return false;
        }
        return getInvalidDeviceIds().contains(str) || Pattern.compile("^[0-]+$").matcher(str).matches();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static NetworkInfo getNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isConnectedWifi(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isConnectedMobile(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getConnectionType(Context context) {
        if (isConnectedMobile(context)) {
            return Constants.WWAN;
        }
        isConnectedWifi(context);
        return "wifi";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Locale getLocale(Configuration configuration) {
        Locale localeFromLocaleList = SLReflectionUtils.getLocaleFromLocaleList(configuration);
        return localeFromLocaleList != null ? localeFromLocaleList : SLReflectionUtils.getLocaleFromField(configuration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String[] getSupportedAbis() {
        return SLReflectionUtils.getSupportedAbis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getCpuAbi() {
        return SLReflectionUtils.getCpuAbi();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void saveCSIReferrer(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_INSTALL_REFERRER, 0).edit();
        edit.putString(Constants.PREF_CSI_REFERRER_KEY, str);
        edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getCSIReferrer(Context context) {
        return context.getSharedPreferences(Constants.PREF_INSTALL_REFERRER, 0).getString(Constants.PREF_CSI_REFERRER_KEY, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isFirstInstall(Context context) {
        if (context.getSharedPreferences(Constants.PREF_FIRST_INSTALL, 0).getBoolean(Constants.WAS_OPENED_AFTER_INSTALL, false)) {
            return false;
        }
        saveFirstInstallInfo(context);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void saveFirstInstallInfo(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_FIRST_INSTALL, 0).edit();
        edit.putBoolean(Constants.WAS_OPENED_AFTER_INSTALL, true);
        edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static UUID getSingularId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_SINGULAR_ID, 0);
        String string = sharedPreferences.getString(Constants.PREF_SINGULAR_ID_KEY, null);
        if (string != null) {
            return UUID.fromString(string);
        }
        return createSingularId(sharedPreferences);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static UUID createSingularId(SharedPreferences sharedPreferences) {
        UUID randomUUID = UUID.randomUUID();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(Constants.PREF_SINGULAR_ID_KEY, randomUUID.toString());
        edit.commit();
        return randomUUID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long getEventIndex(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_EVENT_INDEX, 0);
        return increaseEventIndex(sharedPreferences, sharedPreferences.getLong(Constants.PREF_EVENT_INDEX_KEY, -1L));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long getAdmonEventIndex(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_ADMON_EVENT_INDEX, 0);
        return increaseAdmonEventIndex(sharedPreferences, sharedPreferences.getLong(Constants.PREF_ADMON_EVENT_INDEX_KEY, -1L));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static long increaseEventIndex(SharedPreferences sharedPreferences, long j) {
        long j2 = j + 1;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(Constants.PREF_EVENT_INDEX_KEY, j2);
        edit.commit();
        return j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static long increaseAdmonEventIndex(SharedPreferences sharedPreferences, long j) {
        long j2 = j + 1;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(Constants.PREF_ADMON_EVENT_INDEX_KEY, j2);
        edit.commit();
        return j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isLicenseRetrieved(Context context, String str) {
        return context.getSharedPreferences(Constants.LICENSING_API_KEY, 0).getBoolean(str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void saveLicenseInfo(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.LICENSING_API_KEY, 0).edit();
        edit.putBoolean(str, true);
        edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPlayStoreAdIdByBackupMethod(Context context) {
        try {
            String aifa = ExternalAIFAHelper.getAIFA(context);
            if (isInvalidDeviceId(aifa)) {
                return null;
            }
            return aifa;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isShortLink(Uri uri) {
        return (isESPLink(uri) || uri.getHost() == null || uri.getHost().endsWith(Constants.DEFAULT_SINGULAR_LINK_DOMAIN)) && extractDeepLink(uri) == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String extractDeepLink(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (!isESPLink(uri) && uri.getHost() != null && !uri.getHost().endsWith(Constants.DEFAULT_SINGULAR_LINK_DOMAIN)) {
            return null;
        }
        String queryParameter = uri.getQueryParameter(Constants.QUERY_ANDROID_DEEPLINK);
        return queryParameter != null ? queryParameter : uri.getQueryParameter(Constants.QUERY_DEEPLINK);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String extractPassthroughFromSingularLink(Uri uri) {
        return uri.getQueryParameter(Constants.QUERY_DEEPLINK_PASSTHROUGH);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void handleSingularLink(Uri uri) {
        String extractDeepLink = extractDeepLink(uri);
        if (extractDeepLink != null) {
            handleDeepLink(new SingularLinkParams(extractDeepLink, extractPassthroughFromSingularLink(uri), false, uri));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean handleDeepLink(final SingularLinkParams singularLinkParams) {
        final SingularLinkHandler singularLinkHandler = SingularInstance.getInstance().getSingularConfig().linkCallback;
        if (singularLinkParams.getDeeplink() == null || singularLinkHandler == null) {
            return false;
        }
        new Runnable() { // from class: com.singular.sdk.internal.Utils.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                SingularLinkHandler.this.onResolved(singularLinkParams);
            }
        }.run();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean validateSingularLink(Uri uri) {
        if (uri == null) {
            return false;
        }
        if (uri.getScheme() == null) {
            uri = Uri.parse("https://" + uri.toString());
        }
        return uri.getHost() != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isOpenedWithDeeplink() {
        return SingularInstance.getInstance().getSingularConfig().isOpenedWithDeepLink;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean appMovedToBackground() {
        SingularInstance.getInstance().getSingularConfig().isOpenedWithDeepLink = false;
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setWrapperNameAndVersion(String str, String str2) {
        wrapperName = str;
        wrapperVersion = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getWrapperName() {
        return wrapperName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setImei(String str) {
        imei = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getImei() {
        return imei;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getSdkVersion() {
        String str;
        String str2 = SingularInstance.getInstance().getDeviceInfo().sdkVersion;
        String str3 = wrapperName;
        return (str3 == null || (str = wrapperVersion) == null) ? str2 : String.format("%s-%s/%s", str2, str3, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isESPLink(Uri uri) {
        if (uri == null || SingularInstance.getInstance() == null || SingularInstance.getInstance().getSingularConfig() == null || SingularInstance.getInstance().getSingularConfig().espDomains == null || SingularInstance.getInstance().getSingularConfig().espDomains.size() == 0) {
            return false;
        }
        if (uri.getScheme() == null) {
            uri = Uri.parse("https://" + uri.toString());
        }
        return isUrlInDomains(uri, SingularInstance.getInstance().getSingularConfig().espDomains);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Uri resolveESPLink(Uri uri) {
        HttpURLConnection httpConnection;
        try {
            URL url = new URL(uri.toString());
            if (url.getProtocol().equalsIgnoreCase("https")) {
                httpConnection = SingularRequestHandler.getHttpsConnection(url);
            } else {
                httpConnection = SingularRequestHandler.getHttpConnection(url);
            }
            httpConnection.setInstanceFollowRedirects(false);
            httpConnection.connect();
            String headerField = httpConnection.getHeaderField(HttpHeaders.LOCATION);
            if (headerField == null) {
                return null;
            }
            return Uri.parse(headerField);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isUrlInDomains(Uri uri, List<String> list) {
        for (String str : list) {
            if (uri.getHost() != null && uri.getHost().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Method getDeclaredMethod(Object obj, String str, Class<?>... clsArr) {
        try {
            return obj.getClass().getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            logger.debug("Method " + str + " was not found in " + (obj != null ? obj.getClass().getName() : null));
            return null;
        } catch (SecurityException e) {
            logger.debug("Security violation occured ", e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String formatException(Throwable th) {
        return "Exception: \n" + th.getMessage() + "\nStack trace: \n" + getStackTrace(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long incBatchSendId(Context context) {
        long batchSendId = getBatchSendId(context) + 1;
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_BATCH_SEND_ID, 0).edit();
            edit.putLong("sendId", batchSendId);
            edit.commit();
        } catch (Throwable th) {
            logger.error(formatException(th));
        }
        return batchSendId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long getBatchSendId(Context context) {
        return context.getSharedPreferences(Constants.PREF_BATCH_SEND_ID, 0).getLong("sendId", 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void saveRetryCountForKey(String str, Context context, int i) {
        try {
            String generateKeyForRetryCountWithKey = generateKeyForRetryCountWithKey(str);
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.PREF_REQUEST_RETRY_COUNT, 0).edit();
            edit.putInt(generateKeyForRetryCountWithKey, i);
            edit.commit();
        } catch (Throwable th) {
            logger.error(formatException(th));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getAndIncrementRetryCountForKey(Context context, String str) {
        int i = context.getSharedPreferences(Constants.PREF_REQUEST_RETRY_COUNT, 0).getInt(generateKeyForRetryCountWithKey(str), 0);
        saveRetryCountForKey(str, context, i + 1);
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String generateKeyForRetryCountWithKey(String str) {
        return "rc-" + str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void resetRetryCountForKey(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.PREF_REQUEST_RETRY_COUNT, 0);
        sharedPreferences.edit().remove(generateKeyForRetryCountWithKey(str)).commit();
    }
}
