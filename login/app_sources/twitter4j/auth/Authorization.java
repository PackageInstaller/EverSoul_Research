package twitter4j.auth;

import java.io.Serializable;
import twitter4j.HttpRequest;

/* loaded from: classes4.dex */
public interface Authorization extends Serializable {
    String getAuthorizationHeader(HttpRequest httpRequest);

    boolean isEnabled();
}
