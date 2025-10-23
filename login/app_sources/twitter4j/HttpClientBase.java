package twitter4j;

import com.google.common.net.HttpHeaders;
import com.liapp.y;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import twitter4j.auth.Authorization;

/* loaded from: classes4.dex */
public abstract class HttpClientBase implements HttpClient, Serializable {
    private static final Logger logger = Logger.getLogger(HttpClientBase.class);
    private static final long serialVersionUID = -8016974810651763053L;
    protected final HttpClientConfiguration CONF;
    private final Map<String, String> requestHeaders;

    abstract HttpResponse handleRequest(HttpRequest httpRequest) throws TwitterException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpClientBase(HttpClientConfiguration httpClientConfiguration) {
        this.CONF = httpClientConfiguration;
        HashMap hashMap = new HashMap();
        this.requestHeaders = hashMap;
        hashMap.put(y.ٴسسݬߨ(1393287762), Version.getVersion());
        hashMap.put(y.ݮڮֲڭܩ(-628111236), y.ٴسسݬߨ(1393287810) + Version.getVersion() + y.ٴسسݬߨ(1393288098));
        hashMap.put(y.ݬֲ֮ܲت(1512232775), y.ٲٴݴ״ٰ(1782506104));
        hashMap.put(y.ݮڮֲڭܩ(-629002692), y.٬ݯح׭٩(576207350) + Version.getVersion());
        if (httpClientConfiguration.isGZIPEnabled()) {
            hashMap.put(HttpHeaders.ACCEPT_ENCODING, y.دײܮڳܯ(2051210413));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean isProxyConfigured() {
        return (this.CONF.getHttpProxyHost() == null || this.CONF.getHttpProxyHost().equals("")) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void write(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        logger.debug(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public void addDefaultRequestHeader(String str, String str2) {
        this.requestHeaders.put(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public final HttpResponse request(HttpRequest httpRequest) throws TwitterException {
        return handleRequest(httpRequest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public final HttpResponse request(HttpRequest httpRequest, HttpResponseListener httpResponseListener) throws TwitterException {
        try {
            HttpResponse handleRequest = handleRequest(httpRequest);
            if (httpResponseListener != null) {
                httpResponseListener.httpResponseReceived(new HttpResponseEvent(httpRequest, handleRequest, null));
            }
            return handleRequest;
        } catch (TwitterException e) {
            if (httpResponseListener != null) {
                httpResponseListener.httpResponseReceived(new HttpResponseEvent(httpRequest, null, e));
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse get(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        return request(new HttpRequest(RequestMethod.GET, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse get(String str) throws TwitterException {
        return request(new HttpRequest(RequestMethod.GET, str, null, null, this.requestHeaders));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse post(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        return request(new HttpRequest(RequestMethod.POST, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse post(String str) throws TwitterException {
        return request(new HttpRequest(RequestMethod.POST, str, null, null, this.requestHeaders));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse delete(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        return request(new HttpRequest(RequestMethod.DELETE, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse delete(String str) throws TwitterException {
        return request(new HttpRequest(RequestMethod.DELETE, str, null, null, this.requestHeaders));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse head(String str) throws TwitterException {
        return request(new HttpRequest(RequestMethod.HEAD, str, null, null, this.requestHeaders));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse put(String str, HttpParameter[] httpParameterArr, Authorization authorization, HttpResponseListener httpResponseListener) throws TwitterException {
        return request(new HttpRequest(RequestMethod.PUT, str, httpParameterArr, authorization, this.requestHeaders), httpResponseListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClient
    public HttpResponse put(String str) throws TwitterException {
        return request(new HttpRequest(RequestMethod.PUT, str, null, null, this.requestHeaders));
    }
}
