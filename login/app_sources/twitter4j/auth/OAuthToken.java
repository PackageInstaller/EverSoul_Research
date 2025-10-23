package twitter4j.auth;

import com.liapp.y;
import java.io.Serializable;
import javax.crypto.spec.SecretKeySpec;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;

/* loaded from: classes4.dex */
abstract class OAuthToken implements Serializable {
    private static final long serialVersionUID = -7841506492508140600L;
    private String[] responseStr;
    private transient SecretKeySpec secretKeySpec;
    private final String token;
    private final String tokenSecret;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OAuthToken(String str, String str2) {
        this.responseStr = null;
        if (str == null) {
            throw new IllegalArgumentException("Token can't be null");
        }
        if (str2 == null) {
            throw new IllegalArgumentException("TokenSecret can't be null");
        }
        this.token = str;
        this.tokenSecret = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OAuthToken(HttpResponse httpResponse) throws TwitterException {
        this(httpResponse.asString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OAuthToken(String str) {
        this.responseStr = null;
        this.responseStr = str.split(y.֬ڱܱײٮ(-1159719487));
        this.tokenSecret = getParameter("oauth_token_secret");
        this.token = getParameter("oauth_token");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getToken() {
        return this.token;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTokenSecret() {
        return this.tokenSecret;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setSecretKeySpec(SecretKeySpec secretKeySpec) {
        this.secretKeySpec = secretKeySpec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SecretKeySpec getSecretKeySpec() {
        return this.secretKeySpec;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getParameter(String str) {
        for (String str2 : this.responseStr) {
            if (str2.startsWith(str + '=')) {
                return str2.split("=")[1].trim();
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OAuthToken)) {
            return false;
        }
        OAuthToken oAuthToken = (OAuthToken) obj;
        return this.token.equals(oAuthToken.token) && this.tokenSecret.equals(oAuthToken.tokenSecret);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.token.hashCode() * 31) + this.tokenSecret.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-627975884) + this.token + y.دײܮڳܯ(2052910197) + this.tokenSecret + y.ٲٴݴ״ٰ(1780543872) + this.secretKeySpec + '}';
    }
}
