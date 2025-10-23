package twitter4j;

import java.io.Serializable;
import twitter4j.auth.Authorization;
import twitter4j.auth.BasicAuthorization;

/* loaded from: classes4.dex */
public class XAuthAuthorization implements Authorization, Serializable {
    private static final long serialVersionUID = -7260372598870697494L;
    private final BasicAuthorization basic;
    private String consumerKey;
    private String consumerSecret;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public XAuthAuthorization(BasicAuthorization basicAuthorization) {
        this.basic = basicAuthorization;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return this.basic.getAuthorizationHeader(httpRequest);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getUserId() {
        return this.basic.getUserId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPassword() {
        return this.basic.getPassword();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getConsumerKey() {
        return this.consumerKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getConsumerSecret() {
        return this.consumerSecret;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setOAuthConsumer(String str, String str2) {
        this.consumerKey = str;
        this.consumerSecret = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        return this.basic.isEnabled();
    }
}
