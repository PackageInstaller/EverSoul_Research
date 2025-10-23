package bolts;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.kakao.sdk.common.Constants;
import com.liapp.y;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MeasurementEvent {
    public static final String APP_LINK_NAVIGATE_IN_EVENT_NAME = "al_nav_in";
    public static final String APP_LINK_NAVIGATE_OUT_EVENT_NAME = "al_nav_out";
    public static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    public static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    public static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
    private Context appContext;
    private Bundle args;
    private String name;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void sendBroadcastEvent(Context context, String str, Intent intent, Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (intent != null) {
            Bundle appLinkData = AppLinks.getAppLinkData(intent);
            if (appLinkData != null) {
                bundle = getApplinkLogData(context, str, appLinkData, intent);
            } else {
                Uri data = intent.getData();
                if (data != null) {
                    bundle.putString(y.֬ڱܱײٮ(-1159404767), data.toString());
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str2 : extras.keySet()) {
                        bundle.putString(str2, objectToJSONString(extras.get(str2)));
                    }
                }
            }
        }
        if (map != null) {
            for (String str3 : map.keySet()) {
                bundle.putString(str3, map.get(str3));
            }
        }
        new MeasurementEvent(context, str, bundle).sendBroadcast();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MeasurementEvent(Context context, String str, Bundle bundle) {
        this.appContext = context.getApplicationContext();
        this.name = str;
        this.args = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void sendBroadcast() {
        if (this.name == null) {
            Log.d(getClass().getName(), y.دײܮڳܯ(2051907789));
        }
        try {
            Class<?> cls = Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            Method method = cls.getMethod(Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, Context.class);
            Method method2 = cls.getMethod("sendBroadcast", Intent.class);
            Object invoke = method.invoke(null, this.appContext);
            Intent intent = new Intent(MEASUREMENT_EVENT_NOTIFICATION_NAME);
            intent.putExtra(MEASUREMENT_EVENT_NAME_KEY, this.name);
            intent.putExtra(MEASUREMENT_EVENT_ARGS_KEY, this.args);
            method2.invoke(invoke, intent);
        } catch (Exception unused) {
            Log.d(getClass().getName(), y.ۮڭڭܬި(861981259));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Bundle getApplinkLogData(Context context, String str, Bundle bundle, Intent intent) {
        Bundle bundle2 = new Bundle();
        ComponentName resolveActivity = intent.resolveActivity(context.getPackageManager());
        if (resolveActivity != null) {
            bundle2.putString(y.ݬֲ֮ܲت(1512934471), resolveActivity.getShortClassName());
        }
        boolean equals = y.٬ݯح׭٩(576152614).equals(str);
        String str2 = y.ݬֲ֮ܲت(1512932399);
        if (equals) {
            if (resolveActivity != null) {
                bundle2.putString(str2, resolveActivity.getPackageName());
            }
            if (intent.getData() != null) {
                bundle2.putString("outputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("outputURLScheme", intent.getScheme());
            }
        } else if (APP_LINK_NAVIGATE_IN_EVENT_NAME.equals(str)) {
            if (intent.getData() != null) {
                bundle2.putString("inputURL", intent.getData().toString());
            }
            if (intent.getScheme() != null) {
                bundle2.putString("inputURLScheme", intent.getScheme());
            }
        }
        for (String str3 : bundle.keySet()) {
            Object obj = bundle.get(str3);
            if (obj instanceof Bundle) {
                Bundle bundle3 = (Bundle) obj;
                for (String str4 : bundle3.keySet()) {
                    String objectToJSONString = objectToJSONString(bundle3.get(str4));
                    if (str3.equals(y.٬ݯح׭٩(576152646))) {
                        if (str4.equalsIgnoreCase(y.ݬֲ֮ܲت(1512934047))) {
                            bundle2.putString(y.٬ݯح׭٩(576152862), objectToJSONString);
                        } else if (str4.equalsIgnoreCase(y.دײܮڳܯ(2051911053))) {
                            bundle2.putString(y.دײܮڳܯ(2051908605), objectToJSONString);
                        } else if (str4.equalsIgnoreCase(str2)) {
                            bundle2.putString(y.ݬֲ֮ܲت(1512933783), objectToJSONString);
                        }
                    }
                    bundle2.putString(str3 + y.ۮڭڭܬި(861981587) + str4, objectToJSONString);
                }
            } else {
                String objectToJSONString2 = objectToJSONString(obj);
                if (str3.equals(y.ۮڭڭܬި(861979003))) {
                    Uri parse = Uri.parse(objectToJSONString2);
                    bundle2.putString("targetURL", parse.toString());
                    bundle2.putString("targetURLHost", parse.getHost());
                } else {
                    bundle2.putString(str3, objectToJSONString2);
                }
            }
        }
        return bundle2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String objectToJSONString(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj.toString();
        }
        try {
            if (obj instanceof Collection) {
                return new JSONArray((Collection) obj).toString();
            }
            if (obj instanceof Map) {
                return new JSONObject((Map) obj).toString();
            }
            return obj.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
