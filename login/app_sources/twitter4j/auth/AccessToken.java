package twitter4j.auth;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.liapp.y;
import java.io.Serializable;
import twitter4j.HttpResponse;
import twitter4j.TwitterException;

/* loaded from: classes4.dex */
public class AccessToken extends OAuthToken implements Serializable {
    private static final long serialVersionUID = 2470022129505774772L;
    private String screenName;
    private long userId;

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
    AccessToken(HttpResponse httpResponse) throws TwitterException {
        this(httpResponse.asString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AccessToken(String str) {
        super(str);
        this.userId = -1L;
        this.screenName = getParameter(FirebaseAnalytics.Param.SCREEN_NAME);
        String parameter = getParameter("user_id");
        if (parameter != null) {
            this.userId = Long.parseLong(parameter);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessToken(String str, String str2) {
        super(str, str2);
        this.userId = -1L;
        int indexOf = str.indexOf("-");
        if (indexOf != -1) {
            try {
                this.userId = Long.parseLong(str.substring(0, indexOf));
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessToken(String str, String str2, long j) {
        super(str, str2);
        this.userId = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getScreenName() {
        return this.screenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        if (this.userId != accessToken.userId) {
            return false;
        }
        String str = this.screenName;
        String str2 = accessToken.screenName;
        return str == null ? str2 == null : str.equals(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.screenName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.userId;
        return hashCode2 + ((int) (j ^ (j >>> 32)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthToken
    public String toString() {
        return y.ݬֲ֮ܲت(1513923863) + this.screenName + y.ٲٴݴ״ٰ(1780518984) + this.userId + '}';
    }
}
