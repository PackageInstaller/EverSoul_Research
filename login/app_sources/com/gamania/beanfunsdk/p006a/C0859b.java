package com.gamania.beanfunsdk.p006a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.gamania.beanfunsdk.activity.WebViewActivity;
import com.gamania.beanfunsdk.api.AccessCallback;
import com.gamania.beanfunsdk.api.AppDefine;
import com.gamania.beanfunsdk.api.CheckTokenCallback;
import com.gamania.beanfunsdk.api.LogoutCallback;
import com.gamania.beanfunsdk.model.Result;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.gamania.beanfunsdk.a.b */
/* loaded from: classes.dex */
public class C0859b {

    /* renamed from: a */
    private static C0859b f192a;

    /* renamed from: b */
    private static volatile RequestQueue f193b;

    /* renamed from: c */
    private static Context f194c;

    /* renamed from: d */
    private static boolean f195d;

    /* renamed from: com.gamania.beanfunsdk.a.b$a */
    class a implements Response.Listener<JSONObject> {

        /* renamed from: a */
        final /* synthetic */ CheckTokenCallback f196a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        a(C0859b c0859b, CheckTokenCallback checkTokenCallback) {
            this.f196a = checkTokenCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.android.volley.Response.Listener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null) {
                this.f196a.onError(AppDefine.STR_OPENID_RESULT_SERVER_ERROR);
            } else {
                this.f196a.onSuccess(jSONObject.optBoolean("is_valid", false));
            }
        }
    }

    /* renamed from: com.gamania.beanfunsdk.a.b$b */
    class b implements Response.ErrorListener {

        /* renamed from: a */
        final /* synthetic */ CheckTokenCallback f197a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        b(C0859b c0859b, CheckTokenCallback checkTokenCallback) {
            this.f197a = checkTokenCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f197a.onError(AppDefine.STR_OPENID_RESULT_SERVER_ERROR);
        }
    }

    /* renamed from: com.gamania.beanfunsdk.a.b$c */
    class c implements Response.Listener<JSONObject> {

        /* renamed from: a */
        final /* synthetic */ LogoutCallback f198a;

        /* renamed from: b */
        final /* synthetic */ Context f199b;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        c(C0859b c0859b, LogoutCallback logoutCallback, Context context) {
            this.f198a = logoutCallback;
            this.f199b = context;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.android.volley.Response.Listener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            if (jSONObject == null) {
                this.f198a.onError(AppDefine.STR_OPENID_RESULT_SERVER_ERROR);
                return;
            }
            if (jSONObject.optBoolean("is_valid", false)) {
                this.f198a.onSuccess();
            } else {
                this.f198a.onError(AppDefine.STR_RESULT_TOKEN_REVOKED);
            }
            C0858a.m72a(this.f199b);
        }
    }

    /* renamed from: com.gamania.beanfunsdk.a.b$d */
    class d implements Response.ErrorListener {

        /* renamed from: a */
        final /* synthetic */ LogoutCallback f200a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        d(C0859b c0859b, LogoutCallback logoutCallback) {
            this.f200a = logoutCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            this.f200a.onError(AppDefine.STR_OPENID_RESULT_SERVER_ERROR);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static C0859b m75a() {
        if (f192a == null) {
            f192a = new C0859b();
        }
        return f192a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private String m76a(Activity activity) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = activity.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(activity.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static synchronized String m77a(Context context) {
        String m84b;
        synchronized (C0859b.class) {
            m84b = m75a().m84b(context);
        }
        return m84b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static void m78a(int i, int i2, Intent intent, AccessCallback accessCallback) {
        String str;
        if (i2 != -1) {
            if (i == 11 || i == 22) {
                accessCallback.onCancel();
                return;
            }
            return;
        }
        if (i == 11 || i == 22) {
            String stringExtra = intent.getStringExtra(AppDefine.BUNDLE_KEY_OPNEID_RESULT_DATA);
            try {
                Result newInstance = Result.newInstance(new JSONObject(stringExtra));
                String accessToken = newInstance.getAccessToken();
                if (TextUtils.isEmpty(newInstance.getAccessToken())) {
                    int resultCode = newInstance.getResultCode();
                    if (resultCode == -2) {
                        str = AppDefine.STR_OPENID_RESULT_TIMEOUT;
                    } else if (resultCode == -1) {
                        str = AppDefine.STR_OPENID_RESULT_SERVER_ERROR;
                    } else if (resultCode == 0) {
                        accessCallback.onError(AppDefine.STR_OPENID_RESULT_REQUEST_DATA_ERROR);
                    }
                    accessCallback.onError(str);
                } else {
                    C0858a.m73a(f194c, accessToken);
                    accessCallback.onSuccess(newInstance);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                if (TextUtils.isEmpty(stringExtra)) {
                    accessCallback.onError(AppDefine.STR_OPENID_RESULT_REQUEST_DATA_ERROR);
                } else {
                    accessCallback.onSuccess(new Result(1, stringExtra));
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private void m79a(Activity activity, String str) {
        int i;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AppDefine.SCHEME_URL));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            JSONObject jSONObject = new JSONObject();
            String packageName = activity.getPackageName();
            String m76a = m76a(activity);
            try {
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, packageName);
                jSONObject.put("gamaId", str);
                jSONObject.put("gameName", m76a);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            intent.putExtra(AppDefine.BUNDLE_KEY_OPNEID_REQUEST_DATA, jSONObject.toString());
            i = 22;
        } else {
            intent = new Intent(activity, (Class<?>) WebViewActivity.class);
            intent.putExtra("gameId", str);
            i = 11;
        }
        activity.startActivityForResult(intent, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private void m80a(Context context, LogoutCallback logoutCallback) {
        String m74b = C0858a.m74b(context);
        if (TextUtils.isEmpty(m74b)) {
            logoutCallback.onError(AppDefine.STR_RESULT_TOKEN_REVOKED);
        } else {
            m83b().add(new JsonObjectRequest(0, AppDefine.LOGOUT_ACCESS_TOKEN + m74b, new c(this, logoutCallback, context), new d(this, logoutCallback)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static synchronized void m81a(Context context, boolean z) {
        synchronized (C0859b.class) {
            f194c = context;
            if (f193b == null) {
                synchronized (RequestQueue.class) {
                    if (f193b == null) {
                        f193b = Volley.newRequestQueue(context);
                    }
                }
            }
            f195d = z;
            AppDefine.setDomainUrl(z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private void m82a(String str, CheckTokenCallback checkTokenCallback) {
        if (TextUtils.isEmpty(str)) {
            checkTokenCallback.onError(AppDefine.STR_RESULT_TOKEN_ERROR);
        } else {
            m83b().add(new JsonObjectRequest(0, AppDefine.CHECK_ACCESS_TOKEN + str, new a(this, checkTokenCallback), new b(this, checkTokenCallback)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static final RequestQueue m83b() {
        return f193b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    private String m84b(Context context) {
        return C0858a.m74b(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static synchronized void m85b(Activity activity, String str) {
        synchronized (C0859b.class) {
            m75a().m79a(activity, str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static synchronized void m86b(Context context, LogoutCallback logoutCallback) {
        synchronized (C0859b.class) {
            m75a().m80a(context, logoutCallback);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static synchronized void m87b(String str, CheckTokenCallback checkTokenCallback) {
        synchronized (C0859b.class) {
            m75a().m82a(str, checkTokenCallback);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public static String m88c() {
        return "0.0.3".concat(f195d ? "_test" : "_live");
    }
}
