package twitter4j;

/* loaded from: classes4.dex */
public interface HttpClientConfiguration {
    int getHttpConnectionTimeout();

    String getHttpProxyHost();

    String getHttpProxyPassword();

    int getHttpProxyPort();

    String getHttpProxyUser();

    int getHttpReadTimeout();

    int getHttpRetryCount();

    int getHttpRetryIntervalSeconds();

    boolean isGZIPEnabled();

    boolean isHttpProxySocks();

    boolean isPrettyDebugEnabled();
}
