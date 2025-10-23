package bolts;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import bolts.AppLink;
import com.facebook.appevents.AppEventsConstants;
import com.liapp.y;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppLinkNavigation {
    private static final String KEY_NAME_REFERER_APP_LINK = "referer_app_link";
    private static final String KEY_NAME_REFERER_APP_LINK_APP_NAME = "app_name";
    private static final String KEY_NAME_REFERER_APP_LINK_PACKAGE = "package";
    private static final String KEY_NAME_USER_AGENT = "user_agent";
    private static final String KEY_NAME_VERSION = "version";
    private static final String VERSION = "1.0";
    private static AppLinkResolver defaultResolver;
    private final AppLink appLink;
    private final Bundle appLinkData;
    private final Bundle extras;

    public enum NavigationResult {
        FAILED(y.ݮڮֲڭܩ(-629105980), false),
        WEB(y.ٲٴݴ״ٰ(1781641216), true),
        APP(y.ݬֲ֮ܲت(1512932607), true);

        private String code;
        private boolean succeeded;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getCode() {
            return this.code;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isSucceeded() {
            return this.succeeded;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NavigationResult(String str, boolean z) {
            this.code = str;
            this.succeeded = z;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppLinkNavigation(AppLink appLink, Bundle bundle, Bundle bundle2) {
        if (appLink == null) {
            throw new IllegalArgumentException("appLink must not be null.");
        }
        bundle = bundle == null ? new Bundle() : bundle;
        bundle2 = bundle2 == null ? new Bundle() : bundle2;
        this.appLink = appLink;
        this.extras = bundle;
        this.appLinkData = bundle2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppLink getAppLink() {
        return this.appLink;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle getAppLinkData() {
        return this.appLinkData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle getExtras() {
        return this.extras;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Bundle buildAppLinkDataForNavigation(Context context) {
        String string;
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        if (context != null) {
            String packageName = context.getPackageName();
            if (packageName != null) {
                bundle2.putString(y.ݬֲ֮ܲت(1512932399), packageName);
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null && (string = context.getString(applicationInfo.labelRes)) != null) {
                bundle2.putString(y.دײܮڳܯ(2051911053), string);
            }
        }
        bundle.putAll(getAppLinkData());
        bundle.putString(y.ۮڭڭܬި(861979003), getAppLink().getSourceUrl().toString());
        bundle.putString("version", y.ٲٴݴ״ٰ(1781643192));
        bundle.putString(KEY_NAME_USER_AGENT, y.ۮڭڭܬި(861979107));
        bundle.putBundle(KEY_NAME_REFERER_APP_LINK, bundle2);
        bundle.putBundle("extras", getExtras());
        return bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object getJSONValue(Object obj) throws JSONException {
        if (obj instanceof Bundle) {
            return getJSONForBundle((Bundle) obj);
        }
        if (obj instanceof CharSequence) {
            return obj.toString();
        }
        if (obj instanceof List) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(getJSONValue(it.next()));
            }
            return jSONArray;
        }
        int i = 0;
        if (obj instanceof SparseArray) {
            JSONArray jSONArray2 = new JSONArray();
            SparseArray sparseArray = (SparseArray) obj;
            while (i < sparseArray.size()) {
                jSONArray2.put(sparseArray.keyAt(i), getJSONValue(sparseArray.valueAt(i)));
                i++;
            }
            return jSONArray2;
        }
        if (obj instanceof Character) {
            return obj.toString();
        }
        if (obj instanceof Boolean) {
            return obj;
        }
        if (obj instanceof Number) {
            if ((obj instanceof Double) || (obj instanceof Float)) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof boolean[]) {
            JSONArray jSONArray3 = new JSONArray();
            boolean[] zArr = (boolean[]) obj;
            int length = zArr.length;
            while (i < length) {
                jSONArray3.put(getJSONValue(Boolean.valueOf(zArr[i])));
                i++;
            }
            return jSONArray3;
        }
        if (obj instanceof char[]) {
            JSONArray jSONArray4 = new JSONArray();
            char[] cArr = (char[]) obj;
            int length2 = cArr.length;
            while (i < length2) {
                jSONArray4.put(getJSONValue(Character.valueOf(cArr[i])));
                i++;
            }
            return jSONArray4;
        }
        if (obj instanceof CharSequence[]) {
            JSONArray jSONArray5 = new JSONArray();
            CharSequence[] charSequenceArr = (CharSequence[]) obj;
            int length3 = charSequenceArr.length;
            while (i < length3) {
                jSONArray5.put(getJSONValue(charSequenceArr[i]));
                i++;
            }
            return jSONArray5;
        }
        if (obj instanceof double[]) {
            JSONArray jSONArray6 = new JSONArray();
            double[] dArr = (double[]) obj;
            int length4 = dArr.length;
            while (i < length4) {
                jSONArray6.put(getJSONValue(Double.valueOf(dArr[i])));
                i++;
            }
            return jSONArray6;
        }
        if (obj instanceof float[]) {
            JSONArray jSONArray7 = new JSONArray();
            float[] fArr = (float[]) obj;
            int length5 = fArr.length;
            while (i < length5) {
                jSONArray7.put(getJSONValue(Float.valueOf(fArr[i])));
                i++;
            }
            return jSONArray7;
        }
        if (obj instanceof int[]) {
            JSONArray jSONArray8 = new JSONArray();
            int[] iArr = (int[]) obj;
            int length6 = iArr.length;
            while (i < length6) {
                jSONArray8.put(getJSONValue(Integer.valueOf(iArr[i])));
                i++;
            }
            return jSONArray8;
        }
        if (obj instanceof long[]) {
            JSONArray jSONArray9 = new JSONArray();
            long[] jArr = (long[]) obj;
            int length7 = jArr.length;
            while (i < length7) {
                jSONArray9.put(getJSONValue(Long.valueOf(jArr[i])));
                i++;
            }
            return jSONArray9;
        }
        if (obj instanceof short[]) {
            JSONArray jSONArray10 = new JSONArray();
            short[] sArr = (short[]) obj;
            int length8 = sArr.length;
            while (i < length8) {
                jSONArray10.put(getJSONValue(Short.valueOf(sArr[i])));
                i++;
            }
            return jSONArray10;
        }
        if (!(obj instanceof String[])) {
            return null;
        }
        JSONArray jSONArray11 = new JSONArray();
        String[] strArr = (String[]) obj;
        int length9 = strArr.length;
        while (i < length9) {
            jSONArray11.put(getJSONValue(strArr[i]));
            i++;
        }
        return jSONArray11;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private JSONObject getJSONForBundle(Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            jSONObject.put(str, getJSONValue(bundle.get(str)));
        }
        return jSONObject;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NavigationResult navigate(Context context) {
        String str;
        String str2;
        Intent intent;
        PackageManager packageManager = context.getPackageManager();
        Bundle buildAppLinkDataForNavigation = buildAppLinkDataForNavigation(context);
        Iterator<AppLink.Target> it = getAppLink().getTargets().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str = y.ٲٴݴ״ٰ(1781642984);
            str2 = y.ٲٴݴ״ٰ(1781642640);
            if (!hasNext) {
                intent = null;
                break;
            }
            AppLink.Target next = it.next();
            intent = new Intent(str2);
            if (next.getUrl() != null) {
                intent.setData(next.getUrl());
            } else {
                intent.setData(this.appLink.getSourceUrl());
            }
            intent.setPackage(next.getPackageName());
            if (next.getClassName() != null) {
                intent.setClassName(next.getPackageName(), next.getClassName());
            }
            intent.putExtra(str, buildAppLinkDataForNavigation);
            if (packageManager.resolveActivity(intent, 65536) != null) {
                break;
            }
        }
        NavigationResult navigationResult = NavigationResult.FAILED;
        if (intent != null) {
            navigationResult = NavigationResult.APP;
        } else {
            Uri webUrl = getAppLink().getWebUrl();
            if (webUrl != null) {
                try {
                    intent = new Intent(str2, webUrl.buildUpon().appendQueryParameter(str, getJSONForBundle(buildAppLinkDataForNavigation).toString()).build());
                    navigationResult = NavigationResult.WEB;
                } catch (JSONException e) {
                    sendAppLinkNavigateEventBroadcast(context, intent, NavigationResult.FAILED, e);
                    throw new RuntimeException(e);
                }
            } else {
                intent = null;
            }
        }
        sendAppLinkNavigateEventBroadcast(context, intent, navigationResult, null);
        if (intent != null) {
            context.startActivity(intent);
        }
        return navigationResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void sendAppLinkNavigateEventBroadcast(Context context, Intent intent, NavigationResult navigationResult, JSONException jSONException) {
        HashMap hashMap = new HashMap();
        if (jSONException != null) {
            hashMap.put(y.٬ݯح׭٩(576154958), jSONException.getLocalizedMessage());
        }
        hashMap.put(y.دײܮڳܯ(2051910597), navigationResult.isSucceeded() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("type", navigationResult.getCode());
        MeasurementEvent.sendBroadcastEvent(context, MeasurementEvent.APP_LINK_NAVIGATE_OUT_EVENT_NAME, intent, hashMap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setDefaultResolver(AppLinkResolver appLinkResolver) {
        defaultResolver = appLinkResolver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AppLinkResolver getDefaultResolver() {
        return defaultResolver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static AppLinkResolver getResolver(Context context) {
        if (getDefaultResolver() != null) {
            return getDefaultResolver();
        }
        return new WebViewAppLinkResolver(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NavigationResult navigate(Context context, AppLink appLink) {
        return new AppLinkNavigation(appLink, null, null).navigate(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Task<NavigationResult> navigateInBackground(final Context context, Uri uri, AppLinkResolver appLinkResolver) {
        return appLinkResolver.getAppLinkFromUrlInBackground(uri).onSuccess((Continuation<AppLink, TContinuationResult>) new Continuation<AppLink, NavigationResult>() { // from class: bolts.AppLinkNavigation.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // bolts.Continuation
            public NavigationResult then(Task<AppLink> task) throws Exception {
                return AppLinkNavigation.navigate(context, task.getResult());
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Task<NavigationResult> navigateInBackground(Context context, URL url, AppLinkResolver appLinkResolver) {
        return navigateInBackground(context, Uri.parse(url.toString()), appLinkResolver);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Task<NavigationResult> navigateInBackground(Context context, String str, AppLinkResolver appLinkResolver) {
        return navigateInBackground(context, Uri.parse(str), appLinkResolver);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Task<NavigationResult> navigateInBackground(Context context, Uri uri) {
        return navigateInBackground(context, uri, getResolver(context));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Task<NavigationResult> navigateInBackground(Context context, URL url) {
        return navigateInBackground(context, url, getResolver(context));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Task<NavigationResult> navigateInBackground(Context context, String str) {
        return navigateInBackground(context, str, getResolver(context));
    }
}
