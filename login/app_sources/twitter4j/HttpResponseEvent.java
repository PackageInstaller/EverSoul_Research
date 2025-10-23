package twitter4j;

import com.liapp.y;

/* loaded from: classes4.dex */
public final class HttpResponseEvent {
    private final HttpRequest request;
    private final HttpResponse response;
    private final TwitterException twitterException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    HttpResponseEvent(HttpRequest httpRequest, HttpResponse httpResponse, TwitterException twitterException) {
        this.request = httpRequest;
        this.response = httpResponse;
        this.twitterException = twitterException;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpRequest getRequest() {
        return this.request;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HttpResponse getResponse() {
        return this.response;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterException getTwitterException() {
        return this.twitterException;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAuthenticated() {
        return this.request.getAuthorization().isEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HttpResponseEvent httpResponseEvent = (HttpResponseEvent) obj;
        HttpRequest httpRequest = this.request;
        if (httpRequest == null ? httpResponseEvent.request != null : !httpRequest.equals(httpResponseEvent.request)) {
            return false;
        }
        HttpResponse httpResponse = this.response;
        HttpResponse httpResponse2 = httpResponseEvent.response;
        return httpResponse == null ? httpResponse2 == null : httpResponse.equals(httpResponse2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        HttpRequest httpRequest = this.request;
        int hashCode = (httpRequest != null ? httpRequest.hashCode() : 0) * 31;
        HttpResponse httpResponse = this.response;
        return hashCode + (httpResponse != null ? httpResponse.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628097868) + this.request + y.ݮڮֲڭܩ(-628097644) + this.response + '}';
    }
}
