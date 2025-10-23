package twitter4j;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.liapp.y;
import java.io.IOException;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes4.dex */
class HttpClientImpl extends HttpClientBase implements HttpResponseCode, Serializable {
    private static final Map<HttpClientConfiguration, HttpClient> instanceMap;
    private static final Logger logger = Logger.getLogger(HttpClientImpl.class);
    private static final long serialVersionUID = -403500272719330534L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        try {
            if (Integer.parseInt((String) Class.forName("android.os.Build$VERSION").getField("SDK").get(null)) < 8) {
                System.setProperty("http.keepAlive", "false");
            }
        } catch (Exception unused) {
        }
        instanceMap = new HashMap(1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpClientImpl() {
        super(ConfigurationContext.getInstance().getHttpClientConfiguration());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpClientImpl(HttpClientConfiguration httpClientConfiguration) {
        super(httpClientConfiguration);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        Map<HttpClientConfiguration, HttpClient> map = instanceMap;
        HttpClient httpClient = map.get(httpClientConfiguration);
        if (httpClient != null) {
            return httpClient;
        }
        HttpClientImpl httpClientImpl = new HttpClientImpl(httpClientConfiguration);
        map.put(httpClientConfiguration, httpClientImpl);
        return httpClientImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClientBase, twitter4j.HttpClient
    public HttpResponse get(String str) throws TwitterException {
        return request(new HttpRequest(RequestMethod.GET, str, null, null, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpResponse post(String str, HttpParameter[] httpParameterArr) throws TwitterException {
        return request(new HttpRequest(RequestMethod.POST, str, httpParameterArr, null, null));
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:29|30|(3:32|(4:35|(4:38|(3:44|45|46)(3:40|41|42)|43|36)|47|33)|48)|49|(2:80|(3:92|93|95)(9:88|89|61|62|63|(1:66)|67|68|69))(5:55|56|76|77|78)|58|61|62|63|(1:66)|67|68|69) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpClientBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public twitter4j.HttpResponse handleRequest(twitter4j.HttpRequest r20) throws twitter4j.TwitterException {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpClientImpl.handleRequest(twitter4j.HttpRequest):twitter4j.HttpResponse");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setHeaders(HttpRequest httpRequest, HttpURLConnection httpURLConnection) {
        String authorizationHeader;
        Logger logger2 = logger;
        if (logger2.isDebugEnabled()) {
            logger2.debug(y.٬ݯح׭٩(576207830));
            logger2.debug(httpRequest.getMethod().name() + y.دײܮڳܯ(2051829469), httpRequest.getURL());
        }
        if (httpRequest.getAuthorization() != null && (authorizationHeader = httpRequest.getAuthorization().getAuthorizationHeader(httpRequest)) != null) {
            if (logger2.isDebugEnabled()) {
                logger2.debug(y.ݮڮֲڭܩ(-628110332), authorizationHeader.replaceAll(y.ݮڮֲڭܩ(-629059348), y.ٲٴݴ״ٰ(1782507304)));
            }
            httpURLConnection.addRequestProperty(y.ٲٴݴ״ٰ(1782078608), authorizationHeader);
        }
        if (httpRequest.getRequestHeaders() != null) {
            for (String str : httpRequest.getRequestHeaders().keySet()) {
                httpURLConnection.addRequestProperty(str, httpRequest.getRequestHeaders().get(str));
                logger.debug(str + y.ݬֲ֮ܲت(1512932847) + httpRequest.getRequestHeaders().get(str));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpURLConnection getConnection(String str) throws IOException {
        HttpURLConnection httpURLConnection;
        if (isProxyConfigured()) {
            if (this.CONF.getHttpProxyUser() != null && !this.CONF.getHttpProxyUser().equals("")) {
                Logger logger2 = logger;
                if (logger2.isDebugEnabled()) {
                    logger2.debug(y.دײܮڳܯ(2051209901) + this.CONF.getHttpProxyUser());
                    logger2.debug(y.ݮڮֲڭܩ(-628110020) + this.CONF.getHttpProxyPassword().replaceAll(y.ݮڮֲڭܩ(-629059348), y.ٲٴݴ״ٰ(1782507304)));
                }
                Authenticator.setDefault(new Authenticator() { // from class: twitter4j.HttpClientImpl.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.net.Authenticator
                    protected PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType().equals(Authenticator.RequestorType.PROXY)) {
                            return new PasswordAuthentication(HttpClientImpl.this.CONF.getHttpProxyUser(), HttpClientImpl.this.CONF.getHttpProxyPassword().toCharArray());
                        }
                        return null;
                    }
                });
            }
            Proxy proxy = new Proxy(this.CONF.isHttpProxySocks() ? Proxy.Type.SOCKS : Proxy.Type.HTTP, InetSocketAddress.createUnresolved(this.CONF.getHttpProxyHost(), this.CONF.getHttpProxyPort()));
            Logger logger3 = logger;
            if (logger3.isDebugEnabled()) {
                logger3.debug(y.ݬֲ֮ܲت(1512231303) + this.CONF.getHttpProxyHost() + y.ݬֲ֮ܲت(1512942399) + this.CONF.getHttpProxyPort() + y.ٴسسݬߨ(1392959042));
            }
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection(proxy)));
        } else {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        }
        if (this.CONF.getHttpConnectionTimeout() > 0) {
            httpURLConnection.setConnectTimeout(this.CONF.getHttpConnectionTimeout());
        }
        if (this.CONF.getHttpReadTimeout() > 0) {
            httpURLConnection.setReadTimeout(this.CONF.getHttpReadTimeout());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }
}
