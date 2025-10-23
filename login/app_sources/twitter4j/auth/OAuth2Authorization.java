package twitter4j.auth;

import com.facebook.internal.security.CertificateUtil;
import com.liapp.y;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import twitter4j.BASE64Encoder;
import twitter4j.HttpClient;
import twitter4j.HttpClientFactory;
import twitter4j.HttpParameter;
import twitter4j.HttpRequest;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;

/* loaded from: classes4.dex */
public class OAuth2Authorization implements Authorization, Serializable, OAuth2Support {
    private static final long serialVersionUID = -2895232598422218647L;
    private final Configuration conf;
    private String consumerKey;
    private String consumerSecret;
    private final HttpClient http;
    private OAuth2Token token;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OAuth2Authorization(Configuration configuration) {
        this.conf = configuration;
        setOAuthConsumer(configuration.getOAuthConsumerKey(), configuration.getOAuthConsumerSecret());
        this.http = HttpClientFactory.getInstance(configuration.getHttpClientConfiguration());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuth2Support
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
    @Override // twitter4j.auth.OAuth2Support
    public OAuth2Token getOAuth2Token() throws TwitterException {
        if (this.token != null) {
            throw new IllegalStateException(y.ݬֲ֮ܲت(1513926319));
        }
        HttpParameter[] httpParameterArr = new HttpParameter[this.conf.getOAuth2Scope() == null ? 1 : 2];
        httpParameterArr[0] = new HttpParameter(y.ݮڮֲڭܩ(-627982612), y.دײܮڳܯ(2052884845));
        if (this.conf.getOAuth2Scope() != null) {
            httpParameterArr[1] = new HttpParameter(y.٬ݯح׭٩(575033230), this.conf.getOAuth2Scope());
        }
        HttpResponse post = this.http.post(this.conf.getOAuth2TokenURL(), httpParameterArr, this, null);
        if (post.getStatusCode() != 200) {
            throw new TwitterException(y.٬ݯح׭٩(575033286), post);
        }
        OAuth2Token oAuth2Token = new OAuth2Token(post);
        this.token = oAuth2Token;
        return oAuth2Token;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuth2Support
    public void setOAuth2Token(OAuth2Token oAuth2Token) {
        this.token = oAuth2Token;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuth2Support
    public void invalidateOAuth2Token() throws TwitterException {
        if (this.token == null) {
            throw new IllegalStateException(y.ݬֲ֮ܲت(1513925791));
        }
        HttpParameter[] httpParameterArr = {new HttpParameter(y.ٲٴݴ״ٰ(1780521344), this.token.getAccessToken())};
        OAuth2Token oAuth2Token = this.token;
        try {
            this.token = null;
            HttpResponse post = this.http.post(this.conf.getOAuth2InvalidateTokenURL(), httpParameterArr, this, null);
            if (post.getStatusCode() == 200) {
            } else {
                throw new TwitterException("Invalidating OAuth 2 Bearer Token failed.", post);
            }
        } catch (Throwable th) {
            this.token = oAuth2Token;
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        String str;
        OAuth2Token oAuth2Token = this.token;
        if (oAuth2Token == null) {
            try {
                str = URLEncoder.encode(this.consumerKey, "UTF-8") + CertificateUtil.DELIMITER + URLEncoder.encode(this.consumerSecret, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                str = "";
            }
            return y.ݬֲ֮ܲت(1513923623) + BASE64Encoder.encode(str.getBytes());
        }
        return oAuth2Token.generateAuthorizationHeader();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        return this.token != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OAuth2Authorization)) {
            return false;
        }
        OAuth2Authorization oAuth2Authorization = (OAuth2Authorization) obj;
        String str = this.consumerKey;
        if (str == null ? oAuth2Authorization.consumerKey != null : !str.equals(oAuth2Authorization.consumerKey)) {
            return false;
        }
        String str2 = this.consumerSecret;
        if (str2 == null ? oAuth2Authorization.consumerSecret != null : !str2.equals(oAuth2Authorization.consumerSecret)) {
            return false;
        }
        OAuth2Token oAuth2Token = this.token;
        OAuth2Token oAuth2Token2 = oAuth2Authorization.token;
        if (oAuth2Token != null) {
            if (oAuth2Token.equals(oAuth2Token2)) {
                return true;
            }
        } else if (oAuth2Token2 == null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.consumerKey;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.consumerSecret;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        OAuth2Token oAuth2Token = this.token;
        return hashCode2 + (oAuth2Token != null ? oAuth2Token.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.دײܮڳܯ(2052882997)).append(this.consumerKey).append(y.دײܮڳܯ(2052883245));
        OAuth2Token oAuth2Token = this.token;
        return append.append(oAuth2Token == null ? y.ݮڮֲڭܩ(-628841308) : oAuth2Token.toString()).append('}').toString();
    }
}
