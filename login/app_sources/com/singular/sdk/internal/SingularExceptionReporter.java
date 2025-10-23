package com.singular.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.android.volley.http.HttpEntity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.kakaogame.server.ServerConstants;
import com.singular.sdk.internal.SingularParamsBase;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SingularExceptionReporter extends HandlerThread {
    private static SingularExceptionReporter instance;
    private Context context;
    private DeviceInfo device_info;
    private Handler handler;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SingularExceptionReporter getReporter(Context context, Boolean bool) {
        if (instance == null) {
            synchronized (SingularExceptionReporter.class) {
                SingularExceptionReporter singularExceptionReporter = new SingularExceptionReporter("singular_exception_reporter", context);
                instance = singularExceptionReporter;
                singularExceptionReporter.initDeviceInfo(bool);
            }
        }
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SingularExceptionReporter(String str, Context context) {
        super(str);
        this.handler = null;
        this.context = null;
        this.device_info = null;
        start();
        this.handler = new Handler(getLooper());
        this.context = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initDeviceInfo(final Boolean bool) {
        if (this.device_info != null || this.handler == null || this.context == null) {
            return;
        }
        this.handler.post(new Runnable() { // from class: com.singular.sdk.internal.SingularExceptionReporter.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SingularExceptionReporter.this.device_info = new DeviceInfo(SingularExceptionReporter.this.context, false, bool);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reportException(final Throwable th) {
        if (this.handler != null) {
            Runnable runnable = new Runnable() { // from class: com.singular.sdk.internal.SingularExceptionReporter.2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        Throwable th2 = th;
                        if (th2 != null) {
                            jSONObject.put("name", th2.getClass().getSimpleName());
                            jSONObject.put("message", th.getMessage());
                            jSONObject.put("stack_trace", Log.getStackTraceString(th));
                            if (SingularExceptionReporter.this.device_info != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(SingularParamsBase.Constants.AIFA_KEYSPACE_KEY, SingularExceptionReporter.this.device_info.aifa);
                                jSONObject2.put("appName", SingularExceptionReporter.this.device_info.appName);
                                jSONObject2.put("appVersion", SingularExceptionReporter.this.device_info.appVersion);
                                jSONObject2.put(ServerConstants.DEVICE_MODEL, SingularExceptionReporter.this.device_info.deviceModel);
                                jSONObject2.put("deviceBrand", SingularExceptionReporter.this.device_info.deviceBrand);
                                jSONObject2.put("deviceManufacturer", SingularExceptionReporter.this.device_info.deviceManufacturer);
                                jSONObject2.put("osVersion", SingularExceptionReporter.this.device_info.osVersion);
                                jSONObject2.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, SingularExceptionReporter.this.device_info.sdkVersion);
                                jSONObject2.put("isGooglePlayServicesAvailable", SingularExceptionReporter.this.device_info.isGooglePlayServicesAvailable);
                                jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, jSONObject2);
                            }
                        } else {
                            jSONObject.put("error", "Throwable is null!");
                        }
                        SingularExceptionReporter.this.postExceptionDataToServer(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
            };
            this.handler.removeCallbacksAndMessages(null);
            this.handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int postExceptionDataToServer(JSONObject jSONObject) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(Constants.TRACKER_EXCEPTION_ENDPOINT).openConnection()));
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", HttpEntity.APPLICATION_JSON);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            byte[] bytes = jSONObject.toString().getBytes();
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, Integer.toString(bytes.length));
            httpURLConnection.getOutputStream().write(bytes);
            httpURLConnection.connect();
            return httpURLConnection.getResponseCode();
        } catch (Throwable unused) {
            return -1;
        }
    }
}
