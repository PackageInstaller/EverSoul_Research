package twitter4j.auth;

import com.liapp.y;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import twitter4j.HttpResponse;
import twitter4j.JSONException;
import twitter4j.JSONObject;
import twitter4j.TwitterException;

/* loaded from: classes4.dex */
public class OAuth2Token implements Serializable {
    private static final long serialVersionUID = -8985359441959903216L;
    private String accessToken;
    private String tokenType;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OAuth2Token(HttpResponse httpResponse) throws TwitterException {
        JSONObject asJSONObject = httpResponse.asJSONObject();
        this.tokenType = getRawString(y.ݮڮֲڭܩ(-627984436), asJSONObject);
        try {
            this.accessToken = URLDecoder.decode(getRawString("access_token", asJSONObject), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OAuth2Token(String str, String str2) {
        this.tokenType = str;
        this.accessToken = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getTokenType() {
        return this.tokenType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAccessToken() {
        return this.accessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String generateAuthorizationHeader() {
        String str;
        try {
            str = URLEncoder.encode(this.accessToken, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        return y.دײܮڳܯ(2051293517) + str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OAuth2Token)) {
            return false;
        }
        OAuth2Token oAuth2Token = (OAuth2Token) obj;
        String str = this.tokenType;
        if (str == null ? oAuth2Token.tokenType != null : !str.equals(oAuth2Token.tokenType)) {
            return false;
        }
        String str2 = this.accessToken;
        String str3 = oAuth2Token.accessToken;
        if (str2 != null) {
            if (str2.equals(str3)) {
                return true;
            }
        } else if (str3 == null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        String str = this.tokenType;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.accessToken;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(575031246) + this.tokenType + y.٬ݯح׭٩(575035638) + this.accessToken + y.ݮڮֲڭܩ(-628973388);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getRawString(String str, JSONObject jSONObject) {
        try {
            if (jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }
}
