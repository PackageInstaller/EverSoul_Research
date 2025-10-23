package twitter4j.auth;

import com.liapp.y;
import java.io.ObjectStreamException;
import java.io.Serializable;
import twitter4j.HttpRequest;

/* loaded from: classes4.dex */
public class NullAuthorization implements Authorization, Serializable {
    private static final NullAuthorization SINGLETON = new NullAuthorization();
    private static final long serialVersionUID = -7704668493278727510L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public String getAuthorizationHeader(HttpRequest httpRequest) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.Authorization
    public boolean isEnabled() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(575032822);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NullAuthorization() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NullAuthorization getInstance() {
        return SINGLETON;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return SINGLETON == obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }
}
