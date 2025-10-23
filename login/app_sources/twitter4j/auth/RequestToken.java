package twitter4j.auth;

import com.liapp.y;
import java.io.Serializable;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes4.dex */
public final class RequestToken extends OAuthToken implements Serializable {
    private static final long serialVersionUID = -8806439091674811734L;
    private final Configuration conf;
    private OAuthSupport oauth;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getParameter(String str) {
        return super.getParameter(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getToken() {
        return super.getToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String getTokenSecret() {
        return super.getTokenSecret();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RequestToken(HttpResponse httpResponse, OAuthSupport oAuthSupport) throws TwitterException {
        super(httpResponse);
        this.conf = ConfigurationContext.getInstance();
        this.oauth = oAuthSupport;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestToken(String str, String str2) {
        super(str, str2);
        this.conf = ConfigurationContext.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RequestToken(String str, String str2, OAuthSupport oAuthSupport) {
        super(str, str2);
        this.conf = ConfigurationContext.getInstance();
        this.oauth = oAuthSupport;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAuthorizationURL() {
        return this.conf.getOAuthAuthorizationURL() + y.ݮڮֲڭܩ(-627975300) + getToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAuthenticationURL() {
        return this.conf.getOAuthAuthenticationURL() + y.ݮڮֲڭܩ(-627975300) + getToken();
    }
}
