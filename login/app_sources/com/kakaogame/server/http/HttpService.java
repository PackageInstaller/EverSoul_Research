package com.kakaogame.server.http;

import android.content.Context;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.kakaogame.Logger;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerSecurityManager;
import com.kakaogame.util.NetworkUtil;
import com.liapp.y;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpService.kt */
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007JP\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004JL\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0007JB\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0018\b\u0002\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ>\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J*\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\u0006\u0010\u001f\u001a\u00020 2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u0006JD\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006$"}, m839d2 = {"Lcom/kakaogame/server/http/HttpService;", "", "()V", "DEFAULT_HTTP_CONNECTION_TIMEOUT", "", "SCHEME_HTTPS", "", "TAG", "timeoutMillis", "getTimeoutMillis", "()I", "setTimeoutMillis", "(I)V", "getHttpsUrlConnection", "Ljava/net/HttpURLConnection;", "url", "Ljava/net/URL;", "initialize", "", "httpTimeoutStr", "request", "Lcom/kakaogame/server/KeyBaseResult;", "urlString", FirebaseAnalytics.Param.METHOD, KeyBaseResult.KEY_HEADER, "", SDKConstants.PARAM_A2U_BODY, "contentType", "Lcom/kakaogame/server/http/HttpService$HttpContentType;", "timeout", "requestGET", "context", "Landroid/content/Context;", "requestGETRttCheck", "requestPOST", "HttpContentType", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class HttpService {
    private static final int DEFAULT_HTTP_CONNECTION_TIMEOUT = 20000;
    private static final String SCHEME_HTTPS = "https";
    private static final String TAG = "HttpService";
    public static final HttpService INSTANCE = new HttpService();
    private static int timeoutMillis = 20000;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getTimeoutMillis() {
        return timeoutMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTimeoutMillis(int i) {
        timeoutMillis = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f A[Catch: Exception -> 0x0042, TryCatch #0 {Exception -> 0x0042, blocks: (B:3:0x000e, B:5:0x0013, B:10:0x001f, B:12:0x0025, B:13:0x002b), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void initialize(java.lang.String r3) {
        /*
            r0 = 2051076301(0x7a40f0cd, float:2.5045125E35)
            java.lang.String r0 = com.liapp.y.دײܮڳܯ(r0)
            r1 = 576337686(0x225a3716, float:2.9573671E-18)
            java.lang.String r1 = com.liapp.y.٬ݯح׭٩(r1)
            r2 = r3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> L42
            if (r2 == 0) goto L1c
            int r2 = r2.length()     // Catch: java.lang.Exception -> L42
            if (r2 != 0) goto L1a
            goto L1c
        L1a:
            r2 = 0
            goto L1d
        L1c:
            r2 = 1
        L1d:
            if (r2 != 0) goto L4e
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Exception -> L42
            if (r3 <= 0) goto L28
            int r3 = r3 * 1000
            goto L2b
        L28:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L2b:
            com.kakaogame.server.http.HttpService.timeoutMillis = r3     // Catch: java.lang.Exception -> L42
            com.kakaogame.Logger r3 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> L42
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L42
            r2.<init>(r1)     // Catch: java.lang.Exception -> L42
            int r1 = com.kakaogame.server.http.HttpService.timeoutMillis     // Catch: java.lang.Exception -> L42
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Exception -> L42
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L42
            r3.m699d(r0, r1)     // Catch: java.lang.Exception -> L42
            goto L4e
        L42:
            r3 = move-exception
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE
            java.lang.String r2 = r3.toString()
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r1.m702e(r0, r2, r3)
        L4e:
            return
            fill-array 0x0050: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.http.HttpService.initialize(java.lang.String):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KeyBaseResult requestGET$default(HttpService httpService, Context context, String str, Map map, HttpContentType httpContentType, int i, Object obj) {
        if ((i & 4) != 0) {
            map = null;
        }
        return httpService.requestGET(context, str, (Map<String, String>) map, httpContentType);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KeyBaseResult<Object> requestGET(Context context, String urlString, Map<String, String> header, HttpContentType contentType) {
        KeyBaseResult<Object> requestGET;
        String str = y.دײܮڳܯ(2051076301);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(contentType, y.ݮڮֲڭܩ(-628242540));
        try {
            if (NetworkUtil.INSTANCE.isNetworkConnected(context)) {
                return (urlString == null || (requestGET = INSTANCE.requestGET(urlString, header, contentType, timeoutMillis)) == null) ? KeyBaseResult.INSTANCE.getResult(4000, "url is null") : requestGET;
            }
            Logger.INSTANCE.m701e(str, "Network is not connected in HttpService.requestGET");
            return KeyBaseResult.INSTANCE.getResult(1001);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KeyBaseResult.INSTANCE.getResult(2002, e.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x016b, code lost:
    
        if (r0 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x016d, code lost:
    
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x018f, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x018c, code lost:
    
        if (0 == 0) goto L40;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.server.KeyBaseResult<java.lang.Object> requestGET(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, com.kakaogame.server.http.HttpService.HttpContentType r9, int r10) {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.http.HttpService.requestGET(java.lang.String, java.util.Map, com.kakaogame.server.http.HttpService$HttpContentType, int):com.kakaogame.server.KeyBaseResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KeyBaseResult requestGETRttCheck$default(HttpService httpService, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "GET";
        }
        return httpService.requestGETRttCheck(context, str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0128, code lost:
    
        if (r10 == null) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012f A[Catch: Exception -> 0x0133, TRY_ENTER, TryCatch #4 {Exception -> 0x0133, blocks: (B:3:0x0032, B:5:0x003a, B:8:0x004a, B:18:0x0103, B:27:0x012f, B:28:0x0132), top: B:2:0x0032 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.server.KeyBaseResult<java.lang.Object> requestGETRttCheck(android.content.Context r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.http.HttpService.requestGETRttCheck(android.content.Context, java.lang.String, java.lang.String):com.kakaogame.server.KeyBaseResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KeyBaseResult<Object> requestPOST(String urlString, Map<String, String> header, String body, HttpContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, y.ݮڮֲڭܩ(-628242540));
        return request(urlString, y.ٴسسݬߨ(1392856570), header, body, contentType);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025 A[Catch: Exception -> 0x003e, TryCatch #0 {Exception -> 0x003e, blocks: (B:3:0x0014, B:5:0x0019, B:10:0x0025, B:13:0x0030), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[Catch: Exception -> 0x003e, TRY_LEAVE, TryCatch #0 {Exception -> 0x003e, blocks: (B:3:0x0014, B:5:0x0019, B:10:0x0025, B:13:0x0030), top: B:2:0x0014 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.server.KeyBaseResult<java.lang.Object> request(java.lang.String r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10, com.kakaogame.server.http.HttpService.HttpContentType r11) {
        /*
            r0 = 1781805184(0x6a343080, float:5.445892E25)
            java.lang.String r0 = com.liapp.y.ٲٴݴ״ٰ(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = -628242540(0xffffffffda8dc794, float:-1.9953705E16)
            java.lang.String r0 = com.liapp.y.ݮڮֲڭܩ(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L3e
            if (r0 == 0) goto L22
            int r0 = r0.length()     // Catch: java.lang.Exception -> L3e
            if (r0 != 0) goto L20
            goto L22
        L20:
            r0 = 0
            goto L23
        L22:
            r0 = 1
        L23:
            if (r0 == 0) goto L30
            com.kakaogame.server.KeyBaseResult$Companion r7 = com.kakaogame.server.KeyBaseResult.INSTANCE     // Catch: java.lang.Exception -> L3e
            java.lang.String r8 = "url is null"
            r9 = 4000(0xfa0, float:5.605E-42)
            com.kakaogame.server.KeyBaseResult r7 = r7.getResult(r9, r8)     // Catch: java.lang.Exception -> L3e
            return r7
        L30:
            com.kakaogame.server.http.HttpService r0 = com.kakaogame.server.http.HttpService.INSTANCE     // Catch: java.lang.Exception -> L3e
            int r6 = com.kakaogame.server.http.HttpService.timeoutMillis     // Catch: java.lang.Exception -> L3e
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r11
            com.kakaogame.server.KeyBaseResult r7 = r0.request(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L3e
            goto L59
        L3e:
            r7 = move-exception
            com.kakaogame.Logger r8 = com.kakaogame.Logger.INSTANCE
            java.lang.String r9 = r7.toString()
            r10 = r7
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.String r11 = "HttpService"
            r8.m702e(r11, r9, r10)
            com.kakaogame.server.KeyBaseResult$Companion r8 = com.kakaogame.server.KeyBaseResult.INSTANCE
            r9 = 2002(0x7d2, float:2.805E-42)
            java.lang.String r7 = r7.toString()
            com.kakaogame.server.KeyBaseResult r7 = r8.getResult(r9, r7)
        L59:
            return r7
            fill-array 0x005a: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.http.HttpService.request(java.lang.String, java.lang.String, java.util.Map, java.lang.String, com.kakaogame.server.http.HttpService$HttpContentType):com.kakaogame.server.KeyBaseResult");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x01a6, code lost:
    
        if (r0 != null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x01a8, code lost:
    
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x01ca, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01c7, code lost:
    
        if (0 == 0) goto L42;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.server.KeyBaseResult<java.lang.Object> request(java.lang.String r7, java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.lang.String r10, com.kakaogame.server.http.HttpService.HttpContentType r11, int r12) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.server.http.HttpService.request(java.lang.String, java.lang.String, java.util.Map, java.lang.String, com.kakaogame.server.http.HttpService$HttpContentType, int):com.kakaogame.server.KeyBaseResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final HttpURLConnection getHttpsUrlConnection(URL url) throws Exception {
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
        Intrinsics.checkNotNull(uRLConnection, y.֬ڱܱײٮ(-1159090759));
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
        httpsURLConnection.setHostnameVerifier(ServerSecurityManager.getHostnameVerifier(url));
        httpsURLConnection.setSSLSocketFactory(ServerSecurityManager.getSSLSocketFactory());
        return httpsURLConnection;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: HttpService.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m839d2 = {"Lcom/kakaogame/server/http/HttpService$HttpContentType;", "", "(Ljava/lang/String;I)V", "NONE", "STRING", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class HttpContentType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HttpContentType[] $VALUES;
        public static final HttpContentType NONE = new HttpContentType(y.ۮڭڭܬި(862123667), 0);
        public static final HttpContentType STRING = new HttpContentType(y.ݬֲ֮ܲت(1512102879), 1);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ HttpContentType[] $values() {
            return new HttpContentType[]{NONE, STRING};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<HttpContentType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static HttpContentType valueOf(String str) {
            return (HttpContentType) Enum.valueOf(HttpContentType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static HttpContentType[] values() {
            return (HttpContentType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private HttpContentType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            HttpContentType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
