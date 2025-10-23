package twitter4j.auth;

import com.liapp.y;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import twitter4j.BASE64Encoder;
import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpRequest;
import twitter4j.Logger;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
public class OAuthAuthorization implements Authorization, Serializable, OAuthSupport {
    private static final String HMAC_SHA1 = "HmacSHA1";
    private static transient HttpClient http = null;
    private static final long serialVersionUID = -886869424811858868L;
    private final Configuration conf;
    private String consumerSecret;
    private static final HttpParameter OAUTH_SIGNATURE_METHOD = new HttpParameter(y.دײܮڳܯ(2052890405), y.ٴسسݬߨ(1393925706));
    private static final Logger logger = Logger.getLogger(OAuthAuthorization.class);
    private static final Random RAND = new Random();
    private String consumerKey = "";
    private String realm = null;
    private OAuthToken oauthToken = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OAuthAuthorization(Configuration configuration) {
        this.conf = configuration;
        http = HttpClientFactory.getInstance(configuration.getHttpClientConfiguration());
        setOAuthConsumer(configuration.getOAuthConsumerKey(), configuration.getOAuthConsumerSecret());
        if (configuration.getOAuthAccessToken() == null || configuration.getOAuthAccessTokenSecret() == null) {
            return;
        }
        setOAuthAccessToken(new AccessToken(configuration.getOAuthAccessToken(), configuration.getOAuthAccessTokenSecret()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return generateAuthorizationHeader(httpRequest.getMethod().name(), httpRequest.getURL(), httpRequest.getParameters(), this.oauthToken);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureTokenIsAvailable() {
        if (this.oauthToken == null) {
            throw new IllegalStateException(y.ۮڭڭܬި(863106667));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        OAuthToken oAuthToken = this.oauthToken;
        return oAuthToken != null && (oAuthToken instanceof AccessToken);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken() throws TwitterException {
        return getOAuthRequestToken(null, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str) throws TwitterException {
        return getOAuthRequestToken(str, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2) throws TwitterException {
        return getOAuthRequestToken(str, str2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2, String str3) throws TwitterException {
        if (this.oauthToken instanceof AccessToken) {
            throw new IllegalStateException("Access token already available.");
        }
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(new HttpParameter(y.ۮڭڭܬި(863107579), str));
        }
        if (str2 != null) {
            arrayList.add(new HttpParameter(y.٬ݯح׭٩(575034750), str2));
        }
        if (str3 != null) {
            arrayList.add(new HttpParameter("x_auth_mode", str3));
        }
        RequestToken requestToken = new RequestToken(http.post(this.conf.getOAuthRequestTokenURL(), (HttpParameter[]) arrayList.toArray(new HttpParameter[arrayList.size()]), this, null), this);
        this.oauthToken = requestToken;
        return requestToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken() throws TwitterException {
        ensureTokenIsAvailable();
        OAuthToken oAuthToken = this.oauthToken;
        if (oAuthToken instanceof AccessToken) {
            return (AccessToken) oAuthToken;
        }
        AccessToken accessToken = new AccessToken(http.post(this.conf.getOAuthAccessTokenURL(), null, this, null));
        this.oauthToken = accessToken;
        return accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(String str) throws TwitterException {
        ensureTokenIsAvailable();
        AccessToken accessToken = new AccessToken(http.post(this.conf.getOAuthAccessTokenURL(), new HttpParameter[]{new HttpParameter(y.֬ڱܱײٮ(-1159112711), str)}, this, null));
        this.oauthToken = accessToken;
        return accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(RequestToken requestToken) throws TwitterException {
        this.oauthToken = requestToken;
        return getOAuthAccessToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(RequestToken requestToken, String str) throws TwitterException {
        this.oauthToken = requestToken;
        return getOAuthAccessToken(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public AccessToken getOAuthAccessToken(String str, String str2) throws TwitterException {
        String str3 = y.٬ݯح׭٩(575036142);
        try {
            String oAuthAccessTokenURL = this.conf.getOAuthAccessTokenURL();
            if (oAuthAccessTokenURL.indexOf("http://") == 0) {
                oAuthAccessTokenURL = str3 + oAuthAccessTokenURL.substring(7);
            }
            AccessToken accessToken = new AccessToken(http.post(oAuthAccessTokenURL, new HttpParameter[]{new HttpParameter("x_auth_username", str), new HttpParameter("x_auth_password", str2), new HttpParameter("x_auth_mode", "client_auth")}, this, null));
            this.oauthToken = accessToken;
            AccessToken accessToken2 = accessToken;
            return accessToken;
        } catch (TwitterException e) {
            throw new TwitterException(y.ۮڭڭܬި(863109075), e, e.getStatusCode());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public void setOAuthAccessToken(AccessToken accessToken) {
        this.oauthToken = accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOAuthRealm(String str) {
        this.realm = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String generateAuthorizationHeader(String str, String str2, HttpParameter[] httpParameterArr, String str3, String str4, OAuthToken oAuthToken) {
        if (httpParameterArr == null) {
            httpParameterArr = new HttpParameter[0];
        }
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new HttpParameter(y.٬ݯح׭٩(575036470), this.consumerKey));
        arrayList.add(OAUTH_SIGNATURE_METHOD);
        arrayList.add(new HttpParameter(y.֬ڱܱײٮ(-1158298215), str4));
        arrayList.add(new HttpParameter(y.ۮڭڭܬި(863105051), str3));
        arrayList.add(new HttpParameter("oauth_version", y.ٲٴݴ״ٰ(1781643192)));
        if (oAuthToken != null) {
            arrayList.add(new HttpParameter("oauth_token", oAuthToken.getToken()));
        }
        List<HttpParameter> arrayList2 = new ArrayList<>(arrayList.size() + httpParameterArr.length);
        arrayList2.addAll(arrayList);
        if (!HttpParameter.containsFile(httpParameterArr)) {
            arrayList2.addAll(toParamList(httpParameterArr));
        }
        parseGetParameters(str2, arrayList2);
        StringBuilder append = new StringBuilder(str).append("&").append(HttpParameter.encode(constructRequestURL(str2))).append("&");
        append.append(HttpParameter.encode(normalizeRequestParameters(arrayList2)));
        String sb = append.toString();
        Logger logger2 = logger;
        logger2.debug("OAuth base string: ", sb);
        String generateSignature = generateSignature(sb, oAuthToken);
        logger2.debug("OAuth signature: ", generateSignature);
        arrayList.add(new HttpParameter("oauth_signature", generateSignature));
        if (this.realm != null) {
            arrayList.add(new HttpParameter("realm", this.realm));
        }
        return "OAuth " + encodeParameters(arrayList, ",", true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void parseGetParameters(String str, List<HttpParameter> list) {
        int indexOf = str.indexOf(y.ٴسسݬߨ(1393197818));
        if (-1 != indexOf) {
            try {
                for (String str2 : str.substring(indexOf + 1).split(y.֬ڱܱײٮ(-1159719487))) {
                    String[] split = str2.split("=");
                    int length = split.length;
                    String str3 = y.٬ݯح׭٩(576116366);
                    if (length == 2) {
                        list.add(new HttpParameter(URLDecoder.decode(split[0], str3), URLDecoder.decode(split[1], str3)));
                    } else {
                        list.add(new HttpParameter(URLDecoder.decode(split[0], str3), ""));
                    }
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String generateAuthorizationHeader(String str, String str2, HttpParameter[] httpParameterArr, OAuthToken oAuthToken) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return generateAuthorizationHeader(str, str2, httpParameterArr, String.valueOf(RAND.nextInt() + currentTimeMillis), String.valueOf(currentTimeMillis), oAuthToken);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<HttpParameter> generateOAuthSignatureHttpParams(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new HttpParameter(y.٬ݯح׭٩(575036470), this.consumerKey));
        arrayList.add(OAUTH_SIGNATURE_METHOD);
        arrayList.add(new HttpParameter(y.֬ڱܱײٮ(-1158298215), currentTimeMillis));
        arrayList.add(new HttpParameter(y.ۮڭڭܬި(863105051), RAND.nextInt() + currentTimeMillis));
        arrayList.add(new HttpParameter(y.ݬֲ֮ܲت(1513927183), y.ٲٴݴ״ٰ(1781643192)));
        if (this.oauthToken != null) {
            arrayList.add(new HttpParameter(y.ٴسسݬߨ(1393924690), this.oauthToken.getToken()));
        }
        List<HttpParameter> arrayList2 = new ArrayList<>(arrayList.size());
        arrayList2.addAll(arrayList);
        parseGetParameters(str2, arrayList2);
        StringBuilder append = new StringBuilder(str).append("&").append(HttpParameter.encode(constructRequestURL(str2))).append("&");
        append.append(HttpParameter.encode(normalizeRequestParameters(arrayList2)));
        arrayList.add(new HttpParameter(y.ٲٴݴ״ٰ(1780516192), generateSignature(append.toString(), this.oauthToken)));
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String generateSignature(String str, OAuthToken oAuthToken) {
        SecretKeySpec secretKeySpec;
        String str2 = y.ݬֲ֮ܲت(1513927015);
        try {
            Mac mac = Mac.getInstance(str2);
            String str3 = y.֬ڱܱײٮ(-1159719487);
            if (oAuthToken == null) {
                secretKeySpec = new SecretKeySpec((HttpParameter.encode(this.consumerSecret) + str3).getBytes(), str2);
            } else {
                SecretKeySpec secretKeySpec2 = oAuthToken.getSecretKeySpec();
                if (secretKeySpec2 == null) {
                    secretKeySpec2 = new SecretKeySpec((HttpParameter.encode(this.consumerSecret) + str3 + HttpParameter.encode(oAuthToken.getTokenSecret())).getBytes(), str2);
                    oAuthToken.setSecretKeySpec(secretKeySpec2);
                }
                secretKeySpec = secretKeySpec2;
            }
            mac.init(secretKeySpec);
            return BASE64Encoder.encode(mac.doFinal(str.getBytes()));
        } catch (InvalidKeyException e) {
            logger.error(y.ݬֲ֮ܲت(1513930423), e);
            throw new AssertionError(e);
        } catch (NoSuchAlgorithmException e2) {
            logger.error(y.ٴسسݬߨ(1393924882), e2);
            throw new AssertionError(e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String generateSignature(String str) {
        return generateSignature(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String normalizeRequestParameters(HttpParameter[] httpParameterArr) {
        return normalizeRequestParameters(toParamList(httpParameterArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String normalizeRequestParameters(List<HttpParameter> list) {
        Collections.sort(list);
        return encodeParameters(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static List<HttpParameter> toParamList(HttpParameter[] httpParameterArr) {
        ArrayList arrayList = new ArrayList(httpParameterArr.length);
        arrayList.addAll(Arrays.asList(httpParameterArr));
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeParameters(List<HttpParameter> list) {
        return encodeParameters(list, y.֬ڱܱײٮ(-1159719487), false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String encodeParameters(List<HttpParameter> list, String str, boolean z) {
        String str2;
        StringBuilder sb = new StringBuilder();
        Iterator<HttpParameter> it = list.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str2 = y.دײܮڳܯ(2051949821);
            if (!hasNext) {
                break;
            }
            HttpParameter next = it.next();
            if (!next.isFile() && !next.isJson()) {
                if (sb.length() != 0) {
                    if (z) {
                        sb.append(str2);
                    }
                    sb.append(str);
                }
                sb.append(HttpParameter.encode(next.getName())).append(y.ۮڭڭܬި(862004339));
                if (z) {
                    sb.append(str2);
                }
                sb.append(HttpParameter.encode(next.getValue()));
            }
        }
        if (sb.length() != 0 && z) {
            sb.append(str2);
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String constructRequestURL(String str) {
        int indexOf = str.indexOf(y.ٴسسݬߨ(1393197818));
        if (-1 != indexOf) {
            str = str.substring(0, indexOf);
        }
        int indexOf2 = str.indexOf(y.ۮڭڭܬި(861981587), 8);
        String lowerCase = str.substring(0, indexOf2).toLowerCase();
        int indexOf3 = lowerCase.indexOf(y.ݬֲ֮ܲت(1512942399), 8);
        if (-1 != indexOf3) {
            if (lowerCase.startsWith(y.دײܮڳܯ(2052889629)) && lowerCase.endsWith(y.دײܮڳܯ(2052889797))) {
                lowerCase = lowerCase.substring(0, indexOf3);
            } else if (lowerCase.startsWith(y.٬ݯح׭٩(575036142)) && lowerCase.endsWith(y.ݬֲ֮ܲت(1513927863))) {
                lowerCase = lowerCase.substring(0, indexOf3);
            }
        }
        return lowerCase + str.substring(indexOf2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport, twitter4j.auth.OAuth2Support
    public void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            str = "";
        }
        this.consumerKey = str;
        if (str2 == null) {
            str2 = "";
        }
        this.consumerSecret = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuthSupport)) {
            return false;
        }
        OAuthAuthorization oAuthAuthorization = (OAuthAuthorization) obj;
        String str = this.consumerKey;
        if (str == null ? oAuthAuthorization.consumerKey != null : !str.equals(oAuthAuthorization.consumerKey)) {
            return false;
        }
        String str2 = this.consumerSecret;
        if (str2 == null ? oAuthAuthorization.consumerSecret != null : !str2.equals(oAuthAuthorization.consumerSecret)) {
            return false;
        }
        OAuthToken oAuthToken = this.oauthToken;
        OAuthToken oAuthToken2 = oAuthAuthorization.oauthToken;
        return oAuthToken == null ? oAuthToken2 == null : oAuthToken.equals(oAuthToken2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.consumerKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.consumerSecret;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OAuthToken oAuthToken = this.oauthToken;
        return hashCode2 + (oAuthToken != null ? oAuthToken.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݬֲ֮ܲت(1513929335) + this.consumerKey + y.֬ڱܱײٮ(-1158295615) + this.oauthToken + '}';
    }
}
