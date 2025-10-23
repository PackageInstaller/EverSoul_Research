package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.http.HttpEntity;
import com.android.volley.http.HttpResponse;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.liapp.y;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class HurlStack implements HttpStack {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlRewriter mUrlRewriter;

    public interface UrlRewriter {
        String rewriteUrl(String str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HurlStack() {
        this(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HurlStack(UrlRewriter urlRewriter) {
        this(urlRewriter, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HurlStack(UrlRewriter urlRewriter, SSLSocketFactory sSLSocketFactory) {
        this.mUrlRewriter = urlRewriter;
        this.mSslSocketFactory = sSLSocketFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void addBodyIfExists(HttpURLConnection httpURLConnection, Request<?> request) {
        byte[] body = request.getBody();
        if (body != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty(y.ٲٴݴ״ٰ(1781552064), request.getBodyContentType());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(body);
            dataOutputStream.close();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static HttpEntity entityFromConnection(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        HttpEntity httpEntity = new HttpEntity();
        try {
            errorStream = httpURLConnection.getInputStream();
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        httpEntity.setContent(errorStream);
        httpEntity.setContentLength(httpURLConnection.getContentLength());
        httpEntity.setContentEncoding(httpURLConnection.getContentEncoding());
        httpEntity.setContentType(httpURLConnection.getContentType());
        return httpEntity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private HttpURLConnection openConnection(URL url, Request<?> request) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection createConnection = createConnection(url);
        int timeoutMs = request.getTimeoutMs();
        createConnection.setConnectTimeout(timeoutMs);
        createConnection.setReadTimeout(timeoutMs);
        createConnection.setUseCaches(false);
        createConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.mSslSocketFactory) != null) {
            ((HttpsURLConnection) createConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        return createConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setConnectionParametersForRequest(HttpURLConnection httpURLConnection, Request<?> request) {
        String str;
        String str2;
        int method = request.getMethod();
        String str3 = y.ٴسسݬߨ(1392856570);
        switch (method) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod(str3);
                    httpURLConnection.addRequestProperty(y.ٲٴݴ״ٰ(1781552064), request.getPostBodyContentType());
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(postBody);
                    dataOutputStream.close();
                    return;
                }
                return;
            case 0:
                str = "GET";
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                httpURLConnection.setRequestMethod(str3);
                addBodyIfExists(httpURLConnection, request);
                return;
            case 2:
                str2 = y.ۮڭڭܬި(862005051);
                httpURLConnection.setRequestMethod(str2);
                addBodyIfExists(httpURLConnection, request);
                return;
            case 3:
                str = FirebasePerformance.HttpMethod.DELETE;
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = FirebasePerformance.HttpMethod.HEAD;
                httpURLConnection.setRequestMethod(str);
                return;
            case 5:
                str = FirebasePerformance.HttpMethod.OPTIONS;
                httpURLConnection.setRequestMethod(str);
                return;
            case 6:
                str = FirebasePerformance.HttpMethod.TRACE;
                httpURLConnection.setRequestMethod(str);
                return;
            case 7:
                str2 = y.دײܮڳܯ(2051821477);
                httpURLConnection.setRequestMethod(str2);
                addBodyIfExists(httpURLConnection, request);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected HttpURLConnection createConnection(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) {
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.getHeaders());
        hashMap.putAll(map);
        UrlRewriter urlRewriter = this.mUrlRewriter;
        if (urlRewriter != null) {
            String rewriteUrl = urlRewriter.rewriteUrl(url);
            if (rewriteUrl == null) {
                throw new IOException(y.ݬֲ֮ܲت(1512859055) + url);
            }
            url = rewriteUrl;
        }
        HttpURLConnection openConnection = openConnection(new URL(url), request);
        for (String str : hashMap.keySet()) {
            openConnection.addRequestProperty(str, (String) hashMap.get(str));
        }
        setConnectionParametersForRequest(openConnection, request);
        if (openConnection.getResponseCode() == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        HttpResponse httpResponse = new HttpResponse(openConnection.getResponseCode(), openConnection.getResponseMessage());
        httpResponse.setEntity(entityFromConnection(openConnection));
        for (Map.Entry<String, List<String>> entry : openConnection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                httpResponse.addHeader(entry.getKey(), entry.getValue().get(0));
            }
        }
        return httpResponse;
    }
}
