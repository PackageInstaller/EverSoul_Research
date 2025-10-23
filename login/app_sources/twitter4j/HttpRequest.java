package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import twitter4j.auth.Authorization;

/* loaded from: classes4.dex */
public final class HttpRequest implements Serializable {
    private static final HttpParameter[] NULL_PARAMETERS = new HttpParameter[0];
    private static final long serialVersionUID = 3365496352032493020L;
    private final Authorization authorization;
    private final RequestMethod method;
    private final HttpParameter[] parameters;
    private final Map<String, String> requestHeaders;
    private final String url;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpRequest(RequestMethod requestMethod, String str, HttpParameter[] httpParameterArr, Authorization authorization, Map<String, String> map) {
        this.method = requestMethod;
        if (requestMethod != RequestMethod.POST && httpParameterArr != null && httpParameterArr.length != 0) {
            this.url = str + "?" + HttpParameter.encodeParameters(httpParameterArr);
            this.parameters = NULL_PARAMETERS;
        } else {
            this.url = str;
            this.parameters = httpParameterArr;
        }
        this.authorization = authorization;
        this.requestHeaders = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequestMethod getMethod() {
        return this.method;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpParameter[] getParameters() {
        return this.parameters;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getURL() {
        return this.url;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Authorization getAuthorization() {
        return this.authorization;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getRequestHeaders() {
        return this.requestHeaders;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        Authorization authorization = this.authorization;
        if (authorization == null ? httpRequest.authorization != null : !authorization.equals(httpRequest.authorization)) {
            return false;
        }
        if (!Arrays.equals(this.parameters, httpRequest.parameters)) {
            return false;
        }
        Map<String, String> map = this.requestHeaders;
        if (map == null ? httpRequest.requestHeaders != null : !map.equals(httpRequest.requestHeaders)) {
            return false;
        }
        RequestMethod requestMethod = this.method;
        if (requestMethod == null ? httpRequest.method != null : !requestMethod.equals(httpRequest.method)) {
            return false;
        }
        String str = this.url;
        String str2 = httpRequest.url;
        return str == null ? str2 == null : str.equals(str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        RequestMethod requestMethod = this.method;
        int hashCode = (requestMethod != null ? requestMethod.hashCode() : 0) * 31;
        String str = this.url;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        HttpParameter[] httpParameterArr = this.parameters;
        int hashCode3 = (hashCode2 + (httpParameterArr != null ? Arrays.hashCode(httpParameterArr) : 0)) * 31;
        Authorization authorization = this.authorization;
        int hashCode4 = (hashCode3 + (authorization != null ? authorization.hashCode() : 0)) * 31;
        Map<String, String> map = this.requestHeaders;
        return hashCode4 + (map != null ? map.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(576206510)).append(this.method).append(y.ٲٴݴ״ٰ(1782508648)).append(this.url).append(y.دײܮڳܯ(2051207605));
        HttpParameter[] httpParameterArr = this.parameters;
        return append.append(httpParameterArr == null ? null : Arrays.asList(httpParameterArr)).append(y.ۮڭڭܬި(862954867)).append(this.authorization).append(y.ٲٴݴ״ٰ(1782502344)).append(this.requestHeaders).append('}').toString();
    }
}
