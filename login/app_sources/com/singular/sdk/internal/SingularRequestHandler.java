package com.singular.sdk.internal;

import com.android.volley.http.HttpEntity;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.singular.sdk.internal.Api;
import com.singular.sdk.internal.Constants;
import com.singular.sdk.internal.SingularParamsBase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class SingularRequestHandler {
    private static final SingularLog logger = SingularLog.getLogger("SingularRequestHandler");
    static int counter = 0;
    private static final String[] POST_PAYLOAD_PARAMS_KEYS = {Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, Constants.GLOBAL_PROPERTIES_KEY, Constants.RequestBody.INSTALL_REFERRER_KEY};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingularRequestHandler() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean makeRequest(SingularInstance singularInstance, String str, Map<String, String> map, long j, Api.OnApiCallback onApiCallback) throws IOException {
        long currentTimeMillis = Utils.getCurrentTimeMillis();
        int i = counter + 1;
        counter = i;
        SingularLog singularLog = logger;
        singularLog.debug("---------------------------> /%d", Integer.valueOf(i));
        singularLog.debug("url = %s", str);
        singularLog.debug("params = %s", map);
        HttpURLConnection buildRequest = buildRequest(singularInstance, str, map, j);
        try {
            try {
                return sendRequest(singularInstance, onApiCallback, currentTimeMillis, i, buildRequest);
            } catch (IOException e) {
                throw e;
            }
        } finally {
            if (buildRequest != null) {
                buildRequest.disconnect();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static HttpURLConnection buildRequest(SingularInstance singularInstance, String str, Map<String, String> map, long j) throws IOException {
        HttpURLConnection httpConnection;
        Map<String, String> postPayloadParams = getPostPayloadParams(map);
        String str2 = str + "?" + appendHash(getQueryString(singularInstance, map, j), singularInstance.getSingularConfig().secret);
        URL url = new URL(str2);
        if (url.getProtocol().equalsIgnoreCase("https")) {
            httpConnection = getHttpsConnection(url);
        } else {
            httpConnection = getHttpConnection(url);
        }
        setDefaultConnectionProperties(httpConnection);
        setPayloadForRequest(httpConnection, postPayloadParams, singularInstance.getSingularConfig().secret);
        logger.debug("__API__ %s %s", httpConnection.getRequestMethod(), str2);
        return httpConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean sendRequest(SingularInstance singularInstance, Api.OnApiCallback onApiCallback, long j, int i, HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        String readResponse = readResponse(httpURLConnection);
        httpURLConnection.disconnect();
        long currentTimeMillis = Utils.getCurrentTimeMillis() - j;
        SingularLog singularLog = logger;
        singularLog.debug("%d %s", Integer.valueOf(responseCode), readResponse);
        singularLog.debug("<--------------------------- /%d - took %dms", Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        return onApiCallback.handle(singularInstance, responseCode, readResponse);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String readResponse(HttpURLConnection httpURLConnection) throws IOException {
        InputStreamReader inputStreamReader;
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = httpURLConnection.getInputStream();
        if (httpURLConnection.getContentEncoding() != null && httpURLConnection.getContentEncoding().equals("gzip")) {
            inputStreamReader = new InputStreamReader(new GZIPInputStream(inputStream));
        } else {
            inputStreamReader = new InputStreamReader(inputStream);
        }
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                stringBuffer.append(readLine);
            } else {
                return stringBuffer.toString();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Map<String, String> getPostPayloadParams(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (String str : POST_PAYLOAD_PARAMS_KEYS) {
            if (map.containsKey(str)) {
                hashMap.put(str, map.get(str));
                map.remove(str);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void setPayloadForRequest(HttpURLConnection httpURLConnection, Map<String, String> map, String str) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null && map.size() > 0) {
                String jSONObject2 = new JSONObject(map).toString();
                String sha1Hash = Utils.sha1Hash(jSONObject2, str);
                jSONObject.put("payload", jSONObject2);
                jSONObject.put("signature", sha1Hash);
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(jSONObject.toString());
            outputStreamWriter.close();
        } catch (IOException | JSONException e) {
            logger.error("Error in JSON parsing or I/O ", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void setDefaultConnectionProperties(HttpURLConnection httpURLConnection) throws ProtocolException {
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoInput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, Constants.HTTP_USER_AGENT);
        httpURLConnection.setRequestProperty("Content-Type", HttpEntity.APPLICATION_JSON);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getQueryString(SingularInstance singularInstance, Map<String, String> map, long j) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            map = new HashMap<>();
        }
        TreeMap treeMap = new TreeMap(map);
        treeMap.put("rt", "json");
        treeMap.put("lag", String.valueOf(Utils.lagSince(j)));
        treeMap.put("c", Utils.getConnectionType(singularInstance.getContext()));
        if ((!treeMap.containsKey(SingularParamsBase.Constants.IDENTIFIER_UNIQUE_ID_KEY) || Utils.isEmptyOrNull((String) treeMap.get(SingularParamsBase.Constants.IDENTIFIER_UNIQUE_ID_KEY))) && !Utils.isEmptyOrNull(singularInstance.getDeviceInfo().oaid)) {
            treeMap.put(SingularParamsBase.Constants.IDENTIFIER_UNIQUE_ID_KEY, singularInstance.getDeviceInfo().oaid);
            treeMap.put(SingularParamsBase.Constants.IDENTIFIER_KEYSPACE_KEY, SingularParamsBase.Constants.OAID_KEYSPACE_VALUE);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String encode = URLEncoder.encode((String) entry.getKey(), "UTF-8");
            String str = (String) entry.getValue();
            String encode2 = str != null ? URLEncoder.encode(str, "UTF-8") : "";
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String appendHash(String str, String str2) {
        if (str == null) {
            return "";
        }
        String sha1Hash = Utils.sha1Hash(String.format("?%s", str), str2);
        logger.debug("hash = %s", sha1Hash);
        return Utils.isEmptyOrNull(sha1Hash) ? str : str + "&h=" + sha1Hash;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpURLConnection getHttpConnection(URL url) throws IOException {
        if (url != null) {
            return (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpURLConnection getHttpsConnection(URL url) throws IOException {
        if (url == null) {
            return null;
        }
        return (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
    }
}
