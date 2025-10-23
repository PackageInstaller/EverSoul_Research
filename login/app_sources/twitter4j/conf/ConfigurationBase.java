package twitter4j.conf;

import com.liapp.y;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import twitter4j.HttpClientConfiguration;
import twitter4j.Logger;

/* loaded from: classes4.dex */
class ConfigurationBase implements Configuration, Serializable {
    private static final List<ConfigurationBase> instances = new ArrayList();
    private static final long serialVersionUID = 6175546394599249696L;
    private String oAuth2AccessToken;
    private String oAuth2Scope;
    private String oAuth2TokenType;
    private boolean debug = false;
    private String user = null;
    private String password = null;
    private int httpStreamingReadTimeout = 40000;
    private int httpRetryCount = 0;
    private int httpRetryIntervalSeconds = 5;
    private String oAuthConsumerKey = null;
    private String oAuthConsumerSecret = null;
    private String oAuthAccessToken = null;
    private String oAuthAccessTokenSecret = null;
    private String oAuthRequestTokenURL = y.ٴسسݬߨ(1393943946);
    private String oAuthAuthorizationURL = y.ݮڮֲڭܩ(-627977364);
    private String oAuthAccessTokenURL = y.ݮڮֲڭܩ(-627977004);
    private String oAuthAuthenticationURL = y.دײܮڳܯ(2052907925);
    private String oAuth2TokenURL = y.ٴسسݬߨ(1393943322);
    private String oAuth2InvalidateTokenURL = y.دײܮڳܯ(2052914693);
    private String restBaseURL = y.֬ڱܱײٮ(-1158307647);
    private String streamBaseURL = y.֬ڱܱײٮ(-1158306863);
    private String userStreamBaseURL = y.ݬֲ֮ܲت(1513935983);
    private String siteStreamBaseURL = y.֬ڱܱײٮ(-1158306783);
    private String uploadBaseURL = y.ٲٴݴ״ٰ(1780540752);
    private String dispatcherImpl = y.ٴسسݬߨ(1393949458);
    private int asyncNumThreads = 1;
    private String loggerFactory = null;
    private long contributingTo = -1;
    private boolean includeMyRetweetEnabled = true;
    private boolean includeEntitiesEnabled = true;
    private boolean trimUserEnabled = false;
    private boolean includeExtAltTextEnabled = true;
    private boolean tweetModeExtended = true;
    private boolean includeEmailEnabled = false;
    private boolean jsonStoreEnabled = false;
    private boolean mbeanEnabled = false;
    private boolean userStreamRepliesAllEnabled = false;
    private boolean userStreamWithFollowingsEnabled = true;
    private boolean stallWarningsEnabled = true;
    private boolean applicationOnlyAuthEnabled = false;
    private String mediaProvider = y.֬ڱܱײٮ(-1158305503);
    private String mediaProviderAPIKey = null;
    private Properties mediaProviderParameters = null;
    private boolean daemonEnabled = true;
    private String streamThreadName = "";
    private HttpClientConfiguration httpConf = new MyHttpClientConfiguration(null, null, null, -1, false, 20000, 120000, false, true);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ConfigurationBase() {
    }

    class MyHttpClientConfiguration implements HttpClientConfiguration, Serializable {
        private static final long serialVersionUID = 8226866124868861058L;
        private boolean gzipEnabled;
        private int httpConnectionTimeout;
        private String httpProxyHost;
        private String httpProxyPassword;
        private int httpProxyPort;
        private boolean httpProxySocks;
        private String httpProxyUser;
        private int httpReadTimeout;
        private boolean prettyDebug;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MyHttpClientConfiguration(String str, String str2, String str3, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
            this.httpProxyHost = str;
            this.httpProxyUser = str2;
            this.httpProxyPassword = str3;
            this.httpProxyPort = i;
            this.httpProxySocks = z;
            this.httpConnectionTimeout = i2;
            this.httpReadTimeout = i3;
            this.prettyDebug = z2;
            this.gzipEnabled = z3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public String getHttpProxyHost() {
            return this.httpProxyHost;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public int getHttpProxyPort() {
            return this.httpProxyPort;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public String getHttpProxyUser() {
            return this.httpProxyUser;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public String getHttpProxyPassword() {
            return this.httpProxyPassword;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public boolean isHttpProxySocks() {
            return this.httpProxySocks;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public int getHttpConnectionTimeout() {
            return this.httpConnectionTimeout;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public int getHttpReadTimeout() {
            return this.httpReadTimeout;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public int getHttpRetryCount() {
            return ConfigurationBase.this.httpRetryCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public int getHttpRetryIntervalSeconds() {
            return ConfigurationBase.this.httpRetryIntervalSeconds;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public boolean isPrettyDebugEnabled() {
            return this.prettyDebug;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // twitter4j.HttpClientConfiguration
        public boolean isGZIPEnabled() {
            return this.gzipEnabled;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object obj) {
            boolean z;
            boolean z2;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MyHttpClientConfiguration myHttpClientConfiguration = (MyHttpClientConfiguration) obj;
            if (this.gzipEnabled != myHttpClientConfiguration.gzipEnabled || (z = this.httpProxySocks) != (z2 = myHttpClientConfiguration.httpProxySocks) || this.httpConnectionTimeout != myHttpClientConfiguration.httpConnectionTimeout || this.httpProxyPort != myHttpClientConfiguration.httpProxyPort || z != z2 || this.httpReadTimeout != myHttpClientConfiguration.httpReadTimeout || this.prettyDebug != myHttpClientConfiguration.prettyDebug) {
                return false;
            }
            String str = this.httpProxyHost;
            if (str == null ? myHttpClientConfiguration.httpProxyHost != null : !str.equals(myHttpClientConfiguration.httpProxyHost)) {
                return false;
            }
            String str2 = this.httpProxyPassword;
            if (str2 == null ? myHttpClientConfiguration.httpProxyPassword != null : !str2.equals(myHttpClientConfiguration.httpProxyPassword)) {
                return false;
            }
            String str3 = this.httpProxyUser;
            String str4 = myHttpClientConfiguration.httpProxyUser;
            return str3 == null ? str4 == null : str3.equals(str4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            String str = this.httpProxyHost;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.httpProxyUser;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.httpProxyPassword;
            return ((((((((((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.httpProxyPort) * 31) + (this.httpProxySocks ? 1 : 0)) * 31) + this.httpConnectionTimeout) * 31) + this.httpReadTimeout) * 31) + (this.prettyDebug ? 1 : 0)) * 31) + (this.gzipEnabled ? 1 : 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return y.ݮڮֲڭܩ(-627975180) + this.httpProxyHost + y.دײܮڳܯ(2052909709) + this.httpProxyUser + y.֬ڱܱײٮ(-1158302559) + this.httpProxyPassword + y.ٲٴݴ״ٰ(1780544840) + this.httpProxyPort + y.ۮڭڭܬި(863077315) + (this.httpProxySocks ? Proxy.Type.SOCKS : Proxy.Type.HTTP) + y.ٲٴݴ״ٰ(1780544624) + this.httpConnectionTimeout + y.دײܮڳܯ(2052908613) + this.httpReadTimeout + y.دײܮڳܯ(2052908709) + this.prettyDebug + y.دײܮڳܯ(2052908837) + this.gzipEnabled + '}';
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dumpConfiguration() {
        Logger logger = Logger.getLogger(ConfigurationBase.class);
        if (this.debug) {
            for (Field field : ConfigurationBase.class.getDeclaredFields()) {
                try {
                    Object obj = field.get(this);
                    String valueOf = String.valueOf(obj);
                    if (obj != null && field.getName().matches("oAuthConsumerSecret|oAuthAccessTokenSecret|password")) {
                        valueOf = String.valueOf(obj).replaceAll(".", "*");
                    }
                    logger.debug(field.getName() + ": " + valueOf);
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public final boolean isDebugEnabled() {
        return this.debug;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setDebug(boolean z) {
        this.debug = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getUser() {
        return this.user;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUser(String str) {
        this.user = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getPassword() {
        return this.password;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public HttpClientConfiguration getHttpClientConfiguration() {
        return this.httpConf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setPassword(String str) {
        this.password = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setPrettyDebugEnabled(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), z, this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setGZIPEnabled(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpProxyHost(String str) {
        this.httpConf = new MyHttpClientConfiguration(str, this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpProxyUser(String str) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), str, this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpProxyPassword(String str) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), str, this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpProxyPort(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), i, this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpProxySocks(boolean z) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), z, this.httpConf.getHttpConnectionTimeout(), this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpConnectionTimeout(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), i, this.httpConf.getHttpReadTimeout(), this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpReadTimeout(int i) {
        this.httpConf = new MyHttpClientConfiguration(this.httpConf.getHttpProxyHost(), this.httpConf.getHttpProxyUser(), this.httpConf.getHttpProxyPassword(), this.httpConf.getHttpProxyPort(), this.httpConf.isHttpProxySocks(), this.httpConf.getHttpConnectionTimeout(), i, this.httpConf.isPrettyDebugEnabled(), this.httpConf.isGZIPEnabled());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public int getHttpStreamingReadTimeout() {
        return this.httpStreamingReadTimeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpStreamingReadTimeout(int i) {
        this.httpStreamingReadTimeout = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpRetryCount(int i) {
        this.httpRetryCount = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setHttpRetryIntervalSeconds(int i) {
        this.httpRetryIntervalSeconds = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getOAuthConsumerKey() {
        return this.oAuthConsumerKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthConsumerKey(String str) {
        this.oAuthConsumerKey = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public final String getOAuthConsumerSecret() {
        return this.oAuthConsumerSecret;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthConsumerSecret(String str) {
        this.oAuthConsumerSecret = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuthAccessToken() {
        return this.oAuthAccessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthAccessToken(String str) {
        this.oAuthAccessToken = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuthAccessTokenSecret() {
        return this.oAuthAccessTokenSecret;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthAccessTokenSecret(String str) {
        this.oAuthAccessTokenSecret = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuth2TokenType() {
        return this.oAuth2TokenType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuth2TokenType(String str) {
        this.oAuth2TokenType = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public String getOAuth2AccessToken() {
        return this.oAuth2AccessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getOAuth2Scope() {
        return this.oAuth2Scope;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuth2AccessToken(String str) {
        this.oAuth2AccessToken = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuth2Scope(String str) {
        this.oAuth2Scope = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public final int getAsyncNumThreads() {
        return this.asyncNumThreads;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setAsyncNumThreads(int i) {
        this.asyncNumThreads = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public final long getContributingTo() {
        return this.contributingTo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setContributingTo(long j) {
        this.contributingTo = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getRestBaseURL() {
        return this.restBaseURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setRestBaseURL(String str) {
        this.restBaseURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getUploadBaseURL() {
        return this.uploadBaseURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUploadBaseURL(String str) {
        this.uploadBaseURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getStreamBaseURL() {
        return this.streamBaseURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setStreamBaseURL(String str) {
        this.streamBaseURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getUserStreamBaseURL() {
        return this.userStreamBaseURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUserStreamBaseURL(String str) {
        this.userStreamBaseURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getSiteStreamBaseURL() {
        return this.siteStreamBaseURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setSiteStreamBaseURL(String str) {
        this.siteStreamBaseURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getOAuthRequestTokenURL() {
        return this.oAuthRequestTokenURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthRequestTokenURL(String str) {
        this.oAuthRequestTokenURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getOAuthAuthorizationURL() {
        return this.oAuthAuthorizationURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthAuthorizationURL(String str) {
        this.oAuthAuthorizationURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getOAuthAccessTokenURL() {
        return this.oAuthAccessTokenURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthAccessTokenURL(String str) {
        this.oAuthAccessTokenURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getOAuthAuthenticationURL() {
        return this.oAuthAuthenticationURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuthAuthenticationURL(String str) {
        this.oAuthAuthenticationURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getOAuth2TokenURL() {
        return this.oAuth2TokenURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuth2TokenURL(String str) {
        this.oAuth2TokenURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getOAuth2InvalidateTokenURL() {
        return this.oAuth2InvalidateTokenURL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setOAuth2InvalidateTokenURL(String str) {
        this.oAuth2InvalidateTokenURL = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getDispatcherImpl() {
        return this.dispatcherImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setDispatcherImpl(String str) {
        this.dispatcherImpl = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getLoggerFactory() {
        return this.loggerFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isIncludeEntitiesEnabled() {
        return this.includeEntitiesEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setIncludeEntitiesEnabled(boolean z) {
        this.includeEntitiesEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setLoggerFactory(String str) {
        this.loggerFactory = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isIncludeMyRetweetEnabled() {
        return this.includeMyRetweetEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIncludeMyRetweetEnabled(boolean z) {
        this.includeMyRetweetEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isTrimUserEnabled() {
        return this.trimUserEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isIncludeExtAltTextEnabled() {
        return this.includeExtAltTextEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isTweetModeExtended() {
        return this.tweetModeExtended;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isDaemonEnabled() {
        return this.daemonEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setDaemonEnabled(boolean z) {
        this.daemonEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isIncludeEmailEnabled() {
        return this.includeEmailEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setIncludeEmailEnabled(boolean z) {
        this.includeEmailEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTrimUserEnabled(boolean z) {
        this.trimUserEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIncludeExtAltTextEnabled(boolean z) {
        this.includeExtAltTextEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTweetModeExtended(boolean z) {
        this.tweetModeExtended = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isJSONStoreEnabled() {
        return this.jsonStoreEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setJSONStoreEnabled(boolean z) {
        this.jsonStoreEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isMBeanEnabled() {
        return this.mbeanEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setMBeanEnabled(boolean z) {
        this.mbeanEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isUserStreamRepliesAllEnabled() {
        return this.userStreamRepliesAllEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isUserStreamWithFollowingsEnabled() {
        return this.userStreamWithFollowingsEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUserStreamRepliesAllEnabled(boolean z) {
        this.userStreamRepliesAllEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUserStreamWithFollowingsEnabled(boolean z) {
        this.userStreamWithFollowingsEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isStallWarningsEnabled() {
        return this.stallWarningsEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setStallWarningsEnabled(boolean z) {
        this.stallWarningsEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public boolean isApplicationOnlyAuthEnabled() {
        return this.applicationOnlyAuthEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setApplicationOnlyAuthEnabled(boolean z) {
        this.applicationOnlyAuthEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getMediaProvider() {
        return this.mediaProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setMediaProvider(String str) {
        this.mediaProvider = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getMediaProviderAPIKey() {
        return this.mediaProviderAPIKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setMediaProviderAPIKey(String str) {
        this.mediaProviderAPIKey = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public Properties getMediaProviderParameters() {
        return this.mediaProviderParameters;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setMediaProviderParameters(Properties properties) {
        this.mediaProviderParameters = properties;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.Configuration
    public String getStreamThreadName() {
        return this.streamThreadName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setStreamThreadName(String str) {
        this.streamThreadName = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String fixURL(boolean z, String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(y.ݮڮֲڭܩ(-628270524));
        if (-1 == indexOf) {
            throw new IllegalArgumentException("url should contain '://'");
        }
        String substring = str.substring(indexOf + 3);
        if (z) {
            return y.٬ݯح׭٩(575036142) + substring;
        }
        return y.دײܮڳܯ(2052889629) + substring;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ConfigurationBase configurationBase = (ConfigurationBase) obj;
        if (this.debug != configurationBase.debug || this.httpStreamingReadTimeout != configurationBase.httpStreamingReadTimeout || this.httpRetryCount != configurationBase.httpRetryCount || this.httpRetryIntervalSeconds != configurationBase.httpRetryIntervalSeconds || this.asyncNumThreads != configurationBase.asyncNumThreads || this.contributingTo != configurationBase.contributingTo || this.includeMyRetweetEnabled != configurationBase.includeMyRetweetEnabled || this.includeEntitiesEnabled != configurationBase.includeEntitiesEnabled || this.trimUserEnabled != configurationBase.trimUserEnabled || this.includeExtAltTextEnabled != configurationBase.includeExtAltTextEnabled || this.tweetModeExtended != configurationBase.tweetModeExtended || this.includeEmailEnabled != configurationBase.includeEmailEnabled || this.jsonStoreEnabled != configurationBase.jsonStoreEnabled || this.mbeanEnabled != configurationBase.mbeanEnabled || this.userStreamRepliesAllEnabled != configurationBase.userStreamRepliesAllEnabled || this.userStreamWithFollowingsEnabled != configurationBase.userStreamWithFollowingsEnabled || this.stallWarningsEnabled != configurationBase.stallWarningsEnabled || this.applicationOnlyAuthEnabled != configurationBase.applicationOnlyAuthEnabled || this.daemonEnabled != configurationBase.daemonEnabled) {
            return false;
        }
        String str = this.user;
        if (str == null ? configurationBase.user != null : !str.equals(configurationBase.user)) {
            return false;
        }
        String str2 = this.password;
        if (str2 == null ? configurationBase.password != null : !str2.equals(configurationBase.password)) {
            return false;
        }
        HttpClientConfiguration httpClientConfiguration = this.httpConf;
        if (httpClientConfiguration == null ? configurationBase.httpConf != null : !httpClientConfiguration.equals(configurationBase.httpConf)) {
            return false;
        }
        String str3 = this.oAuthConsumerKey;
        if (str3 == null ? configurationBase.oAuthConsumerKey != null : !str3.equals(configurationBase.oAuthConsumerKey)) {
            return false;
        }
        String str4 = this.oAuthConsumerSecret;
        if (str4 == null ? configurationBase.oAuthConsumerSecret != null : !str4.equals(configurationBase.oAuthConsumerSecret)) {
            return false;
        }
        String str5 = this.oAuthAccessToken;
        if (str5 == null ? configurationBase.oAuthAccessToken != null : !str5.equals(configurationBase.oAuthAccessToken)) {
            return false;
        }
        String str6 = this.oAuthAccessTokenSecret;
        if (str6 == null ? configurationBase.oAuthAccessTokenSecret != null : !str6.equals(configurationBase.oAuthAccessTokenSecret)) {
            return false;
        }
        String str7 = this.oAuth2TokenType;
        if (str7 == null ? configurationBase.oAuth2TokenType != null : !str7.equals(configurationBase.oAuth2TokenType)) {
            return false;
        }
        String str8 = this.oAuth2AccessToken;
        if (str8 == null ? configurationBase.oAuth2AccessToken != null : !str8.equals(configurationBase.oAuth2AccessToken)) {
            return false;
        }
        String str9 = this.oAuth2Scope;
        if (str9 == null ? configurationBase.oAuth2Scope != null : !str9.equals(configurationBase.oAuth2Scope)) {
            return false;
        }
        String str10 = this.oAuthRequestTokenURL;
        if (str10 == null ? configurationBase.oAuthRequestTokenURL != null : !str10.equals(configurationBase.oAuthRequestTokenURL)) {
            return false;
        }
        String str11 = this.oAuthAuthorizationURL;
        if (str11 == null ? configurationBase.oAuthAuthorizationURL != null : !str11.equals(configurationBase.oAuthAuthorizationURL)) {
            return false;
        }
        String str12 = this.oAuthAccessTokenURL;
        if (str12 == null ? configurationBase.oAuthAccessTokenURL != null : !str12.equals(configurationBase.oAuthAccessTokenURL)) {
            return false;
        }
        String str13 = this.oAuthAuthenticationURL;
        if (str13 == null ? configurationBase.oAuthAuthenticationURL != null : !str13.equals(configurationBase.oAuthAuthenticationURL)) {
            return false;
        }
        String str14 = this.oAuth2TokenURL;
        if (str14 == null ? configurationBase.oAuth2TokenURL != null : !str14.equals(configurationBase.oAuth2TokenURL)) {
            return false;
        }
        String str15 = this.oAuth2InvalidateTokenURL;
        if (str15 == null ? configurationBase.oAuth2InvalidateTokenURL != null : !str15.equals(configurationBase.oAuth2InvalidateTokenURL)) {
            return false;
        }
        String str16 = this.restBaseURL;
        if (str16 == null ? configurationBase.restBaseURL != null : !str16.equals(configurationBase.restBaseURL)) {
            return false;
        }
        String str17 = this.streamBaseURL;
        if (str17 == null ? configurationBase.streamBaseURL != null : !str17.equals(configurationBase.streamBaseURL)) {
            return false;
        }
        String str18 = this.userStreamBaseURL;
        if (str18 == null ? configurationBase.userStreamBaseURL != null : !str18.equals(configurationBase.userStreamBaseURL)) {
            return false;
        }
        String str19 = this.siteStreamBaseURL;
        if (str19 == null ? configurationBase.siteStreamBaseURL != null : !str19.equals(configurationBase.siteStreamBaseURL)) {
            return false;
        }
        String str20 = this.uploadBaseURL;
        if (str20 == null ? configurationBase.uploadBaseURL != null : !str20.equals(configurationBase.uploadBaseURL)) {
            return false;
        }
        String str21 = this.dispatcherImpl;
        if (str21 == null ? configurationBase.dispatcherImpl != null : !str21.equals(configurationBase.dispatcherImpl)) {
            return false;
        }
        String str22 = this.loggerFactory;
        if (str22 == null ? configurationBase.loggerFactory != null : !str22.equals(configurationBase.loggerFactory)) {
            return false;
        }
        String str23 = this.mediaProvider;
        if (str23 == null ? configurationBase.mediaProvider != null : !str23.equals(configurationBase.mediaProvider)) {
            return false;
        }
        String str24 = this.mediaProviderAPIKey;
        if (str24 == null ? configurationBase.mediaProviderAPIKey != null : !str24.equals(configurationBase.mediaProviderAPIKey)) {
            return false;
        }
        Properties properties = this.mediaProviderParameters;
        if (properties == null ? configurationBase.mediaProviderParameters != null : !properties.equals(configurationBase.mediaProviderParameters)) {
            return false;
        }
        String str25 = this.streamThreadName;
        String str26 = configurationBase.streamThreadName;
        return str25 != null ? str25.equals(str26) : str26 == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int i = (this.debug ? 1 : 0) * 31;
        String str = this.user;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.password;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        HttpClientConfiguration httpClientConfiguration = this.httpConf;
        int hashCode3 = (((((((hashCode2 + (httpClientConfiguration != null ? httpClientConfiguration.hashCode() : 0)) * 31) + this.httpStreamingReadTimeout) * 31) + this.httpRetryCount) * 31) + this.httpRetryIntervalSeconds) * 31;
        String str3 = this.oAuthConsumerKey;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.oAuthConsumerSecret;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.oAuthAccessToken;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.oAuthAccessTokenSecret;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.oAuth2TokenType;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.oAuth2AccessToken;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.oAuth2Scope;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.oAuthRequestTokenURL;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.oAuthAuthorizationURL;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.oAuthAccessTokenURL;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.oAuthAuthenticationURL;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.oAuth2TokenURL;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.oAuth2InvalidateTokenURL;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.restBaseURL;
        int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.streamBaseURL;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.userStreamBaseURL;
        int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.siteStreamBaseURL;
        int hashCode20 = (hashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.uploadBaseURL;
        int hashCode21 = (hashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.dispatcherImpl;
        int hashCode22 = (((hashCode21 + (str21 != null ? str21.hashCode() : 0)) * 31) + this.asyncNumThreads) * 31;
        String str22 = this.loggerFactory;
        int hashCode23 = str22 != null ? str22.hashCode() : 0;
        long j = this.contributingTo;
        int i2 = (((((((((((((((((((((((((((hashCode22 + hashCode23) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.includeMyRetweetEnabled ? 1 : 0)) * 31) + (this.includeEntitiesEnabled ? 1 : 0)) * 31) + (this.trimUserEnabled ? 1 : 0)) * 31) + (this.includeExtAltTextEnabled ? 1 : 0)) * 31) + (this.tweetModeExtended ? 1 : 0)) * 31) + (this.includeEmailEnabled ? 1 : 0)) * 31) + (this.jsonStoreEnabled ? 1 : 0)) * 31) + (this.mbeanEnabled ? 1 : 0)) * 31) + (this.userStreamRepliesAllEnabled ? 1 : 0)) * 31) + (this.userStreamWithFollowingsEnabled ? 1 : 0)) * 31) + (this.stallWarningsEnabled ? 1 : 0)) * 31) + (this.applicationOnlyAuthEnabled ? 1 : 0)) * 31;
        String str23 = this.mediaProvider;
        int hashCode24 = (i2 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.mediaProviderAPIKey;
        int hashCode25 = (hashCode24 + (str24 != null ? str24.hashCode() : 0)) * 31;
        Properties properties = this.mediaProviderParameters;
        int hashCode26 = (((hashCode25 + (properties != null ? properties.hashCode() : 0)) * 31) + (this.daemonEnabled ? 1 : 0)) * 31;
        String str25 = this.streamThreadName;
        return hashCode26 + (str25 != null ? str25.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ۮڭڭܬި(863083859) + this.debug + y.دײܮڳܯ(2052912965) + this.user + y.ݬֲ֮ܲت(1513938463) + this.password + y.ٴسسݬߨ(1393948066) + this.httpConf + y.٬ݯح׭٩(575025758) + this.httpStreamingReadTimeout + y.ۮڭڭܬި(863084131) + this.httpRetryCount + y.ݬֲ֮ܲت(1513938039) + this.httpRetryIntervalSeconds + y.ݬֲ֮ܲت(1513937743) + this.oAuthConsumerKey + y.ݬֲ֮ܲت(1513937439) + this.oAuthConsumerSecret + y.ۮڭڭܬި(863083363) + this.oAuthAccessToken + y.ݮڮֲڭܩ(-627980452) + this.oAuthAccessTokenSecret + y.֬ڱܱײٮ(-1158304055) + this.oAuth2TokenType + y.ۮڭڭܬި(863085971) + this.oAuth2AccessToken + y.ٲٴݴ״ٰ(1780535920) + this.oAuth2Scope + y.֬ڱܱײٮ(-1158311735) + this.oAuthRequestTokenURL + y.ٲٴݴ״ٰ(1780535768) + this.oAuthAuthorizationURL + y.دײܮڳܯ(2052902365) + this.oAuthAccessTokenURL + y.٬ݯح׭٩(575016014) + this.oAuthAuthenticationURL + y.ۮڭڭܬި(863084627) + this.oAuth2TokenURL + y.֬ڱܱײٮ(-1158310095) + this.oAuth2InvalidateTokenURL + y.ٴسسݬߨ(1393937242) + this.restBaseURL + y.ٲٴݴ״ٰ(1780536448) + this.streamBaseURL + y.ۮڭڭܬި(863087875) + this.userStreamBaseURL + y.ٲٴݴ״ٰ(1780538336) + this.siteStreamBaseURL + y.֬ڱܱײٮ(-1158309751) + this.uploadBaseURL + y.دײܮڳܯ(2052899877) + this.dispatcherImpl + y.ݬֲ֮ܲت(1513942375) + this.asyncNumThreads + y.ۮڭڭܬި(863088275) + this.loggerFactory + y.دײܮڳܯ(2052899405) + this.contributingTo + y.֬ڱܱײٮ(-1158308383) + this.includeMyRetweetEnabled + y.ݮڮֲڭܩ(-627968532) + this.includeEntitiesEnabled + y.֬ڱܱײٮ(-1158307927) + this.trimUserEnabled + y.ݬֲ֮ܲت(1513941167) + this.includeExtAltTextEnabled + y.ۮڭڭܬި(863089963) + this.tweetModeExtended + y.ۮڭڭܬި(863090171) + this.includeEmailEnabled + y.دײܮڳܯ(2052907005) + this.jsonStoreEnabled + y.٬ݯح׭٩(575019526) + this.mbeanEnabled + y.ۮڭڭܬި(863090571) + this.userStreamRepliesAllEnabled + y.ݮڮֲڭܩ(-627971092) + this.userStreamWithFollowingsEnabled + y.دײܮڳܯ(2052905645) + this.stallWarningsEnabled + y.٬ݯح׭٩(575020438) + this.applicationOnlyAuthEnabled + y.֬ڱܱײٮ(-1158314079) + this.mediaProvider + y.٬ݯح׭٩(575020806) + this.mediaProviderAPIKey + y.ٴسسݬߨ(1393939546) + this.mediaProviderParameters + y.֬ڱܱײٮ(-1158313519) + this.daemonEnabled + y.ݬֲ֮ܲت(1513946855) + this.streamThreadName + y.ݮڮֲڭܩ(-628973388);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void cacheInstance(ConfigurationBase configurationBase) {
        List<ConfigurationBase> list = instances;
        if (list.contains(configurationBase)) {
            return;
        }
        list.add(configurationBase);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void cacheInstance() {
        cacheInstance(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ConfigurationBase getInstance(ConfigurationBase configurationBase) {
        List<ConfigurationBase> list = instances;
        int indexOf = list.indexOf(configurationBase);
        if (indexOf == -1) {
            list.add(configurationBase);
            return configurationBase;
        }
        return list.get(indexOf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Object readResolve() throws ObjectStreamException {
        return getInstance(this);
    }
}
