package com.singular.sdk.internal;

import com.android.volley.http.HttpEntity;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.singular.sdk.ShortLinkHandler;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ReferrerLinkService {
    private static final SingularLog logger = SingularLog.getLogger("ReferrerLinkService");
    private static String REFERRER_BASE_URL = "https://sdk-api-v1.singular.net/api/v1/shorten_link";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean validateRequest(String str, String str2, String str3, JSONObject jSONObject) {
        try {
            URL url = new URL(str);
            if (url.getProtocol() == null || url.getProtocol().trim().equals("") || url.getHost() == null || url.getHost().trim().equals("")) {
                logger.debug("ReferrerLinksService - Invalid url foramt: " + str);
                return false;
            }
            if (str2 != null && str2.length() > 256) {
                logger.debug("ReferrerLinksService - refName exceeds size");
                return false;
            }
            if (str3 == null || str3.length() <= 256) {
                return true;
            }
            logger.debug("ReferrerLinksService - refId exceeds size");
            return false;
        } catch (MalformedURLException e) {
            logger.error("Error in forming URL ", e);
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String unifyParamsToUrl(String str, String str2, String str3, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject(jSONObject != null ? jSONObject.toString() : "{}");
        if (str2 != null) {
            jSONObject2.put(Constants.REFERRER_LINK_REQ_BODY_URL_QUERY_PARAM_KEY_REF_NAME, str2);
            str = appendParamToUrl(str, Constants.REFERRER_LINK_REQ_BODY_URL_QUERY_PARAM_KEY_REF_NAME, str2);
        }
        if (str3 != null) {
            jSONObject2.put(Constants.REFERRER_LINK_REQ_BODY_URL_QUERY_PARAM_KEY_REF_ID, str3);
            str = appendParamToUrl(str, Constants.REFERRER_LINK_REQ_BODY_URL_QUERY_PARAM_KEY_REF_ID, str3);
        }
        String jSONObject3 = jSONObject2.toString();
        return jSONObject3.length() > 0 ? appendParamToUrl(str, Constants.QUERY_DEEPLINK_PASSTHROUGH, jSONObject3) : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String appendParamToUrl(String str, String str2, String str3) {
        try {
            if (str.contains("?")) {
                str = str + "&" + str2 + "=" + URLEncoder.encode(str3, "UTF-8");
            } else {
                str = str + "?" + str2 + "=" + URLEncoder.encode(str3, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            logger.debug("Error in encoding ", e);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpURLConnection buildRequest(String str, Map<String, String> map) throws Exception {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, Constants.HTTP_USER_AGENT);
        httpsURLConnection.setRequestProperty("Content-Type", HttpEntity.APPLICATION_JSON);
        httpsURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, "gzip");
        JSONObject jSONObject = new JSONObject(map);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream(), "UTF-8");
        outputStreamWriter.write(jSONObject.toString());
        outputStreamWriter.close();
        return httpsURLConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void sendReferrerRequest(String str, final ShortLinkHandler shortLinkHandler) {
        try {
            String str2 = "?a=" + SingularInstance.getInstance().getSingularConfig().apiKey;
            final String str3 = REFERRER_BASE_URL + (str2 + "&h=" + Utils.sha1Hash(str2, SingularInstance.getInstance().getSingularConfig().secret));
            final HashMap hashMap = new HashMap();
            hashMap.put(Constants.REFERRER_LINK_REQ_BODY_KEY, str);
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.ReferrerLinkService.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    InputStreamReader inputStreamReader;
                    HttpURLConnection httpURLConnection = null;
                    try {
                        httpURLConnection = ReferrerLinkService.buildRequest(str3, hashMap);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
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
                                if (readLine == null) {
                                    break;
                                } else {
                                    stringBuffer.append(readLine);
                                }
                            }
                            shortLinkHandler.onSuccess(new JSONObject(stringBuffer.toString()).getString(Constants.REFERRER_LINK_RES_BODY_KEY));
                        } else {
                            shortLinkHandler.onError("Error sending request: error code - " + responseCode);
                        }
                    } catch (Throwable th) {
                        shortLinkHandler.onError("Error sending request");
                        ReferrerLinkService.logger.debug("Error in I/O ", th);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            });
        } catch (Throwable th) {
            logger.debug("Error: ", th.getMessage());
            shortLinkHandler.onError("Error sending request");
        }
    }
}
