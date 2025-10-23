package twitter4j.auth;

import com.liapp.y;
import java.io.Serializable;
import twitter4j.BASE64Encoder;
import twitter4j.HttpRequest;

/* loaded from: classes4.dex */
public class BasicAuthorization implements Authorization, Serializable {
    private static final long serialVersionUID = 7420629998989177351L;
    private final String basic = encodeBasicAuthenticationString();
    private final String password;
    private final String userId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BasicAuthorization(String str, String str2) {
        this.userId = str;
        this.password = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPassword() {
        return this.password;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String encodeBasicAuthenticationString() {
        if (this.userId == null || this.password == null) {
            return null;
        }
        return y.ݬֲ֮ܲت(1513923623) + BASE64Encoder.encode((this.userId + y.ݬֲ֮ܲت(1512942399) + this.password).getBytes());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return this.basic;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BasicAuthorization) {
            return this.basic.equals(((BasicAuthorization) obj).basic);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.basic.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-627983444) + this.userId + y.֬ڱܱײٮ(-1158294055);
    }
}
