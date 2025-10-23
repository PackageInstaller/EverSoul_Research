package twitter4j.conf;

import com.liapp.y;
import java.util.Properties;

/* loaded from: classes4.dex */
public final class ConfigurationBuilder {
    private ConfigurationBase configurationBean = new PropertyConfiguration();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setPrettyDebugEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setPrettyDebugEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setGZIPEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setGZIPEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setDebugEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setDebug(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setApplicationOnlyAuthEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setApplicationOnlyAuthEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setUser(String str) {
        checkNotBuilt();
        this.configurationBean.setUser(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setPassword(String str) {
        checkNotBuilt();
        this.configurationBean.setPassword(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpProxyHost(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyHost(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpProxyUser(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyUser(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpProxyPassword(String str) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyPassword(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpProxyPort(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpProxyPort(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpProxySocks(boolean z) {
        checkNotBuilt();
        this.configurationBean.setHttpProxySocks(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpConnectionTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpConnectionTimeout(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpReadTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpReadTimeout(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpStreamingReadTimeout(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpStreamingReadTimeout(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpRetryCount(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpRetryCount(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setHttpRetryIntervalSeconds(int i) {
        checkNotBuilt();
        this.configurationBean.setHttpRetryIntervalSeconds(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthConsumerKey(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthConsumerKey(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthConsumerSecret(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthConsumerSecret(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthAccessToken(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessToken(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthAccessTokenSecret(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessTokenSecret(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuth2TokenType(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2TokenType(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuth2AccessToken(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2AccessToken(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuth2Scope(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2Scope(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthRequestTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthRequestTokenURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthAuthorizationURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAuthorizationURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthAccessTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAccessTokenURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuthAuthenticationURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuthAuthenticationURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuth2TokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2TokenURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setOAuth2InvalidateTokenURL(String str) {
        checkNotBuilt();
        this.configurationBean.setOAuth2InvalidateTokenURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setRestBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setRestBaseURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setUploadBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setUploadBaseURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setStreamBaseURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setUserStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setUserStreamBaseURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setSiteStreamBaseURL(String str) {
        checkNotBuilt();
        this.configurationBean.setSiteStreamBaseURL(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setAsyncNumThreads(int i) {
        checkNotBuilt();
        this.configurationBean.setAsyncNumThreads(i);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setDaemonEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setDaemonEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setContributingTo(long j) {
        checkNotBuilt();
        this.configurationBean.setContributingTo(j);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setDispatcherImpl(String str) {
        checkNotBuilt();
        this.configurationBean.setDispatcherImpl(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setTrimUserEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setTrimUserEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setIncludeExtAltTextEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeExtAltTextEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setTweetModeExtended(boolean z) {
        checkNotBuilt();
        this.configurationBean.setTweetModeExtended(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setIncludeMyRetweetEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeMyRetweetEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setIncludeEntitiesEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeEntitiesEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setIncludeEmailEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setIncludeEmailEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setJSONStoreEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setJSONStoreEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setMBeanEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setMBeanEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setUserStreamRepliesAllEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setUserStreamRepliesAllEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setUserStreamWithFollowingsEnabled(boolean z) {
        checkNotBuilt();
        this.configurationBean.setUserStreamWithFollowingsEnabled(z);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setMediaProvider(String str) {
        checkNotBuilt();
        this.configurationBean.setMediaProvider(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setMediaProviderAPIKey(String str) {
        checkNotBuilt();
        this.configurationBean.setMediaProviderAPIKey(str);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConfigurationBuilder setMediaProviderParameters(Properties properties) {
        checkNotBuilt();
        this.configurationBean.setMediaProviderParameters(properties);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Configuration build() {
        checkNotBuilt();
        this.configurationBean.cacheInstance();
        try {
            return this.configurationBean;
        } finally {
            this.configurationBean = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkNotBuilt() {
        if (this.configurationBean == null) {
            throw new IllegalStateException(y.ٴسسݬߨ(1393940082));
        }
    }
}
