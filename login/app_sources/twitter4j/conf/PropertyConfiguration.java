package twitter4j.conf;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.liapp.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import twitter4j.HttpClientConfiguration;

/* loaded from: classes4.dex */
public final class PropertyConfiguration extends ConfigurationBase implements Serializable {
    private static final String APPLICATION_ONLY_AUTH_ENABLED = "enableApplicationOnlyAuth";
    private static final String ASYNC_DAEMON_ENABLED = "async.daemonEnabled";
    private static final String ASYNC_DISPATCHER_IMPL = "async.dispatcherImpl";
    private static final String ASYNC_NUM_THREADS = "async.numThreads";
    private static final String CONTRIBUTING_TO = "contributingTo";
    private static final String DEBUG = "debug";
    private static final String HTTP_CONNECTION_TIMEOUT = "http.connectionTimeout";
    private static final String HTTP_GZIP = "http.gzip";
    private static final String HTTP_PRETTY_DEBUG = "http.prettyDebug";
    private static final String HTTP_PROXY_HOST = "http.proxyHost";
    private static final String HTTP_PROXY_HOST_FALLBACK = "http.proxyHost";
    private static final String HTTP_PROXY_PASSWORD = "http.proxyPassword";
    private static final String HTTP_PROXY_PORT = "http.proxyPort";
    private static final String HTTP_PROXY_PORT_FALLBACK = "http.proxyPort";
    private static final String HTTP_PROXY_USER = "http.proxyUser";
    private static final String HTTP_READ_TIMEOUT = "http.readTimeout";
    private static final String HTTP_RETRY_COUNT = "http.retryCount";
    private static final String HTTP_RETRY_INTERVAL_SECS = "http.retryIntervalSecs";
    private static final String HTTP_STREAMING_READ_TIMEOUT = "http.streamingReadTimeout";
    private static final String INCLUDE_EMAIL = "includeEmail";
    private static final String INCLUDE_ENTITIES = "includeEntities";
    private static final String INCLUDE_EXT_ALT_TEXT = "includeExtAltText";
    private static final String INCLUDE_MY_RETWEET = "includeMyRetweet";
    private static final String JSON_STORE_ENABLED = "jsonStoreEnabled";
    private static final String LOGGER_FACTORY = "loggerFactory";
    private static final String MBEAN_ENABLED = "mbeanEnabled";
    private static final String MEDIA_PROVIDER = "media.provider";
    private static final String MEDIA_PROVIDER_API_KEY = "media.providerAPIKey";
    private static final String MEDIA_PROVIDER_PARAMETERS = "media.providerParameters";
    private static final String OAUTH2_ACCESS_TOKEN = "oauth2.accessToken";
    private static final String OAUTH2_INVALIDATE_TOKEN_URL = "oauth2.invalidateTokenURL";
    private static final String OAUTH2_SCOPE = "oauth2.scope";
    private static final String OAUTH2_TOKEN_TYPE = "oauth2.tokenType";
    private static final String OAUTH2_TOKEN_URL = "oauth2.tokenURL";
    private static final String OAUTH_ACCESS_TOKEN = "oauth.accessToken";
    private static final String OAUTH_ACCESS_TOKEN_SECRET = "oauth.accessTokenSecret";
    private static final String OAUTH_ACCESS_TOKEN_URL = "oauth.accessTokenURL";
    private static final String OAUTH_AUTHENTICATION_URL = "oauth.authenticationURL";
    private static final String OAUTH_AUTHORIZATION_URL = "oauth.authorizationURL";
    private static final String OAUTH_CONSUMER_KEY = "oauth.consumerKey";
    private static final String OAUTH_CONSUMER_SECRET = "oauth.consumerSecret";
    private static final String OAUTH_REQUEST_TOKEN_URL = "oauth.requestTokenURL";
    private static final String PASSWORD = "password";
    private static final String REST_BASE_URL = "restBaseURL";
    private static final String SITE_STREAM_BASE_URL = "siteStreamBaseURL";
    private static final String STREAM_BASE_URL = "streamBaseURL";
    private static final String STREAM_STALL_WARNINGS_ENABLED = "stream.enableStallWarnings";
    private static final String STREAM_THREAD_NAME = "streamThreadName";
    private static final String STREAM_USER_REPLIES_ALL = "stream.user.repliesAll";
    private static final String STREAM_USER_WITH_FOLLOWINGS = "stream.user.withFollowings";
    private static final String TWEET_MODE_EXTENDED = "tweetModeExtended";
    private static final String USER = "user";
    private static final String USER_STREAM_BASE_URL = "userStreamBaseURL";
    private static final long serialVersionUID = -7262615247923693252L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ void dumpConfiguration() {
        super.dumpConfiguration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getDispatcherImpl() {
        return super.getDispatcherImpl();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ HttpClientConfiguration getHttpClientConfiguration() {
        return super.getHttpClientConfiguration();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ int getHttpStreamingReadTimeout() {
        return super.getHttpStreamingReadTimeout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getLoggerFactory() {
        return super.getLoggerFactory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getMediaProvider() {
        return super.getMediaProvider();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getMediaProviderAPIKey() {
        return super.getMediaProviderAPIKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ Properties getMediaProviderParameters() {
        return super.getMediaProviderParameters();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public /* bridge */ /* synthetic */ String getOAuth2AccessToken() {
        return super.getOAuth2AccessToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getOAuth2InvalidateTokenURL() {
        return super.getOAuth2InvalidateTokenURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getOAuth2Scope() {
        return super.getOAuth2Scope();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public /* bridge */ /* synthetic */ String getOAuth2TokenType() {
        return super.getOAuth2TokenType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getOAuth2TokenURL() {
        return super.getOAuth2TokenURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public /* bridge */ /* synthetic */ String getOAuthAccessToken() {
        return super.getOAuthAccessToken();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration, twitter4j.auth.AuthorizationConfiguration
    public /* bridge */ /* synthetic */ String getOAuthAccessTokenSecret() {
        return super.getOAuthAccessTokenSecret();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getOAuthAccessTokenURL() {
        return super.getOAuthAccessTokenURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getOAuthAuthenticationURL() {
        return super.getOAuthAuthenticationURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getOAuthAuthorizationURL() {
        return super.getOAuthAuthorizationURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getOAuthRequestTokenURL() {
        return super.getOAuthRequestTokenURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getRestBaseURL() {
        return super.getRestBaseURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getSiteStreamBaseURL() {
        return super.getSiteStreamBaseURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getStreamBaseURL() {
        return super.getStreamBaseURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getStreamThreadName() {
        return super.getStreamThreadName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getUploadBaseURL() {
        return super.getUploadBaseURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ String getUserStreamBaseURL() {
        return super.getUserStreamBaseURL();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isApplicationOnlyAuthEnabled() {
        return super.isApplicationOnlyAuthEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isDaemonEnabled() {
        return super.isDaemonEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isIncludeEmailEnabled() {
        return super.isIncludeEmailEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isIncludeEntitiesEnabled() {
        return super.isIncludeEntitiesEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isIncludeExtAltTextEnabled() {
        return super.isIncludeExtAltTextEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isIncludeMyRetweetEnabled() {
        return super.isIncludeMyRetweetEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isJSONStoreEnabled() {
        return super.isJSONStoreEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isMBeanEnabled() {
        return super.isMBeanEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isStallWarningsEnabled() {
        return super.isStallWarningsEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isTrimUserEnabled() {
        return super.isTrimUserEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isTweetModeExtended() {
        return super.isTweetModeExtended();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isUserStreamRepliesAllEnabled() {
        return super.isUserStreamRepliesAllEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase, twitter4j.conf.Configuration
    public /* bridge */ /* synthetic */ boolean isUserStreamWithFollowingsEnabled() {
        return super.isUserStreamWithFollowingsEnabled();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ void setIncludeExtAltTextEnabled(boolean z) {
        super.setIncludeExtAltTextEnabled(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ void setIncludeMyRetweetEnabled(boolean z) {
        super.setIncludeMyRetweetEnabled(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ void setTrimUserEnabled(boolean z) {
        super.setTrimUserEnabled(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ void setTweetModeExtended(boolean z) {
        super.setTweetModeExtended(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PropertyConfiguration(InputStream inputStream) {
        Properties properties = new Properties();
        loadProperties(properties, inputStream);
        setFieldsWithTreePath(properties, RemoteSettings.FORWARD_SLASH_STRING);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PropertyConfiguration(Properties properties) {
        this(properties, y.ۮڭڭܬި(861981587));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PropertyConfiguration(Properties properties, String str) {
        setFieldsWithTreePath(properties, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PropertyConfiguration(String str) {
        Properties properties;
        try {
            properties = (Properties) System.getProperties().clone();
            try {
                Map<String, String> map = System.getenv();
                for (String str2 : map.keySet()) {
                    properties.setProperty(str2, map.get(str2));
                }
            } catch (SecurityException unused) {
            }
            normalize(properties);
        } catch (SecurityException unused2) {
            properties = new Properties();
        }
        loadProperties(properties, y.ݮڮֲڭܩ(-629059348) + File.separatorChar + y.دײܮڳܯ(2052903885));
        loadProperties(properties, Configuration.class.getResourceAsStream(y.دײܮڳܯ(2052902941)));
        loadProperties(properties, Configuration.class.getResourceAsStream(y.ٲٴݴ״ٰ(1780534320)));
        try {
            loadProperties(properties, new FileInputStream("WEB-INF/twitter4j.properties"));
        } catch (FileNotFoundException | SecurityException unused3) {
        }
        setFieldsWithTreePath(properties, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PropertyConfiguration() {
        this(y.ۮڭڭܬި(861981587));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean notNull(Properties properties, String str, String str2) {
        return properties.getProperty(new StringBuilder().append(str).append(str2).toString()) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean loadProperties(Properties properties, String str) {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(str);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                properties.load(fileInputStream2);
                normalize(properties);
                try {
                    fileInputStream2.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream == null) {
                    return false;
                }
                try {
                    fileInputStream.close();
                    return false;
                } catch (IOException unused3) {
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean loadProperties(Properties properties, InputStream inputStream) {
        try {
            properties.load(inputStream);
            normalize(properties);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void normalize(Properties properties) {
        String str;
        ArrayList arrayList = new ArrayList(10);
        Iterator it = properties.keySet().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            str = y.ٲٴݴ״ٰ(1780495112);
            if (!hasNext) {
                break;
            }
            String str2 = (String) it.next();
            if (-1 != str2.indexOf(str)) {
                arrayList.add(str2);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str3 = (String) it2.next();
            String property = properties.getProperty(str3);
            int indexOf = str3.indexOf(str);
            properties.setProperty(str3.substring(0, indexOf) + str3.substring(indexOf + 10), property);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setFieldsWithTreePath(Properties properties, String str) {
        setFieldsWithPrefix(properties, "");
        String str2 = null;
        for (String str3 : str.split(y.ۮڭڭܬި(861981587))) {
            if (!"".equals(str3)) {
                String str4 = y.ݮڮֲڭܩ(-629059348);
                if (str2 == null) {
                    str2 = str3 + str4;
                } else {
                    str2 = str2 + str3 + str4;
                }
                setFieldsWithPrefix(properties, str2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setFieldsWithPrefix(Properties properties, String str) {
        String str2 = y.ݬֲ֮ܲت(1512369983);
        if (notNull(properties, str, str2)) {
            setDebug(getBoolean(properties, str, str2));
        }
        String str3 = y.٬ݯح׭٩(575756878);
        if (notNull(properties, str, str3)) {
            setUser(getString(properties, str, str3));
        }
        String str4 = y.ٲٴݴ״ٰ(1782362744);
        if (notNull(properties, str, str4)) {
            setPassword(getString(properties, str, str4));
        }
        String str5 = y.٬ݯح׭٩(575072334);
        if (notNull(properties, str, str5)) {
            setPrettyDebugEnabled(getBoolean(properties, str, str5));
        }
        String str6 = y.ۮڭڭܬި(863061051);
        if (notNull(properties, str, str6)) {
            setGZIPEnabled(getBoolean(properties, str, str6));
        }
        String str7 = y.ٲٴݴ״ٰ(1780494960);
        if (notNull(properties, str, str7)) {
            setHttpProxyHost(getString(properties, str, str7));
        } else if (notNull(properties, str, str7)) {
            setHttpProxyHost(getString(properties, str, str7));
        }
        String str8 = y.ݬֲ֮ܲت(1513883263);
        if (notNull(properties, str, str8)) {
            setHttpProxyUser(getString(properties, str, str8));
        }
        String str9 = y.ٲٴݴ״ٰ(1780494704);
        if (notNull(properties, str, str9)) {
            setHttpProxyPassword(getString(properties, str, str9));
        }
        String str10 = y.ݬֲ֮ܲت(1513882783);
        if (notNull(properties, str, str10)) {
            setHttpProxyPort(getIntProperty(properties, str, str10));
        } else if (notNull(properties, str, str10)) {
            setHttpProxyPort(getIntProperty(properties, str, str10));
        }
        String str11 = y.ٴسسݬߨ(1393897434);
        if (notNull(properties, str, str11)) {
            setHttpConnectionTimeout(getIntProperty(properties, str, str11));
        }
        String str12 = y.٬ݯح׭٩(575073398);
        if (notNull(properties, str, str12)) {
            setHttpReadTimeout(getIntProperty(properties, str, str12));
        }
        String str13 = y.֬ڱܱײٮ(-1158318615);
        if (notNull(properties, str, str13)) {
            setHttpStreamingReadTimeout(getIntProperty(properties, str, str13));
        }
        String str14 = y.٬ݯح׭٩(575073694);
        if (notNull(properties, str, str14)) {
            setHttpRetryCount(getIntProperty(properties, str, str14));
        }
        String str15 = y.ݬֲ֮ܲت(1513882031);
        if (notNull(properties, str, str15)) {
            setHttpRetryIntervalSeconds(getIntProperty(properties, str, str15));
        }
        String str16 = y.ٲٴݴ״ٰ(1780495840);
        if (notNull(properties, str, str16)) {
            setOAuthConsumerKey(getString(properties, str, str16));
        }
        String str17 = y.֬ڱܱײٮ(-1158318415);
        if (notNull(properties, str, str17)) {
            setOAuthConsumerSecret(getString(properties, str, str17));
        }
        String str18 = y.ٴسسݬߨ(1393894498);
        if (notNull(properties, str, str18)) {
            setOAuthAccessToken(getString(properties, str, str18));
        }
        String str19 = y.دײܮڳܯ(2052859557);
        if (notNull(properties, str, str19)) {
            setOAuthAccessTokenSecret(getString(properties, str, str19));
        }
        String str20 = y.ݬֲ֮ܲت(1513885191);
        if (notNull(properties, str, str20)) {
            setOAuth2TokenType(getString(properties, str, str20));
        }
        String str21 = y.دײܮڳܯ(2052858973);
        if (notNull(properties, str, str21)) {
            setOAuth2AccessToken(getString(properties, str, str21));
        }
        String str22 = y.ٴسسݬߨ(1393895058);
        if (notNull(properties, str, str22)) {
            setOAuth2Scope(getString(properties, str, str22));
        }
        String str23 = y.دײܮڳܯ(2052859213);
        if (notNull(properties, str, str23)) {
            setAsyncNumThreads(getIntProperty(properties, str, str23));
        }
        if (notNull(properties, str, y.ݮڮֲڭܩ(-628026468))) {
            setDaemonEnabled(getBoolean(properties, str, y.ݮڮֲڭܩ(-628026468)));
        }
        if (notNull(properties, str, y.ۮڭڭܬި(863062339))) {
            setStreamThreadName(getString(properties, str, y.ۮڭڭܬި(863062339)));
        }
        if (notNull(properties, str, y.ۮڭڭܬި(863062067))) {
            setContributingTo(getLongProperty(properties, str, y.ۮڭڭܬި(863062067)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575071670))) {
            setDispatcherImpl(getString(properties, str, y.٬ݯح׭٩(575071670)));
        }
        if (notNull(properties, str, y.ݮڮֲڭܩ(-628025756))) {
            setOAuthRequestTokenURL(getString(properties, str, y.ݮڮֲڭܩ(-628025756)));
        }
        if (notNull(properties, str, y.ۮڭڭܬި(863063003))) {
            setOAuthAuthorizationURL(getString(properties, str, y.ۮڭڭܬި(863063003)));
        }
        if (notNull(properties, str, y.ٲٴݴ״ٰ(1780497592))) {
            setOAuthAccessTokenURL(getString(properties, str, y.ٲٴݴ״ٰ(1780497592)));
        }
        if (notNull(properties, str, y.ٴسسݬߨ(1393900546))) {
            setOAuthAuthenticationURL(getString(properties, str, y.ٴسسݬߨ(1393900546)));
        }
        if (notNull(properties, str, y.ٲٴݴ״ٰ(1780490800))) {
            setOAuth2TokenURL(getString(properties, str, y.ٲٴݴ״ٰ(1780490800)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575076766))) {
            setOAuth2InvalidateTokenURL(getString(properties, str, y.٬ݯح׭٩(575076766)));
        }
        if (notNull(properties, str, y.ٴسسݬߨ(1393901274))) {
            setRestBaseURL(getString(properties, str, y.ٴسسݬߨ(1393901274)));
        }
        if (notNull(properties, str, y.ٲٴݴ״ٰ(1780490744))) {
            setStreamBaseURL(getString(properties, str, y.ٲٴݴ״ٰ(1780490744)));
        }
        if (notNull(properties, str, y.ݮڮֲڭܩ(-628028620))) {
            setUserStreamBaseURL(getString(properties, str, y.ݮڮֲڭܩ(-628028620)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575077326))) {
            setSiteStreamBaseURL(getString(properties, str, y.٬ݯح׭٩(575077326)));
        }
        if (notNull(properties, str, y.ٲٴݴ״ٰ(1780492160))) {
            setIncludeMyRetweetEnabled(getBoolean(properties, str, y.ٲٴݴ״ٰ(1780492160)));
        }
        if (notNull(properties, str, y.ۮڭڭܬި(863064083))) {
            setIncludeEntitiesEnabled(getBoolean(properties, str, y.ۮڭڭܬި(863064083)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575077790))) {
            setIncludeEmailEnabled(getBoolean(properties, str, y.٬ݯح׭٩(575077790)));
        }
        if (notNull(properties, str, y.ٲٴݴ״ٰ(1780491528))) {
            setIncludeExtAltTextEnabled(getBoolean(properties, str, y.ٲٴݴ״ٰ(1780491528)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575078022))) {
            setTweetModeExtended(getBoolean(properties, str, y.٬ݯح׭٩(575078022)));
        }
        if (notNull(properties, str, y.ݮڮֲڭܩ(-628027620))) {
            setLoggerFactory(getString(properties, str, y.ݮڮֲڭܩ(-628027620)));
        }
        if (notNull(properties, str, y.֬ڱܱײٮ(-1158322439))) {
            setJSONStoreEnabled(getBoolean(properties, str, y.֬ڱܱײٮ(-1158322439)));
        }
        if (notNull(properties, str, y.ݮڮֲڭܩ(-628031484))) {
            setMBeanEnabled(getBoolean(properties, str, y.ݮڮֲڭܩ(-628031484)));
        }
        if (notNull(properties, str, y.ۮڭڭܬި(863067635))) {
            setUserStreamRepliesAllEnabled(getBoolean(properties, str, y.ۮڭڭܬި(863067635)));
        }
        if (notNull(properties, str, y.֬ڱܱײٮ(-1158321991))) {
            setUserStreamWithFollowingsEnabled(getBoolean(properties, str, y.֬ڱܱײٮ(-1158321991)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575074902))) {
            setStallWarningsEnabled(getBoolean(properties, str, y.٬ݯح׭٩(575074902)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575075190))) {
            setApplicationOnlyAuthEnabled(getBoolean(properties, str, y.٬ݯح׭٩(575075190)));
        }
        if (notNull(properties, str, y.٬ݯح׭٩(575075374))) {
            setMediaProvider(getString(properties, str, y.٬ݯح׭٩(575075374)));
        }
        if (notNull(properties, str, y.دײܮڳܯ(2052862701))) {
            setMediaProviderAPIKey(getString(properties, str, y.دײܮڳܯ(2052862701)));
        }
        if (notNull(properties, str, y.ۮڭڭܬި(863066235))) {
            String[] split = getString(properties, str, y.ۮڭڭܬި(863066235)).split("&");
            Properties properties2 = new Properties();
            for (String str24 : split) {
                String[] split2 = str24.split(y.ۮڭڭܬި(862004339));
                properties2.setProperty(split2[0], split2[1]);
            }
            setMediaProviderParameters(properties2);
        }
        cacheInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean getBoolean(Properties properties, String str, String str2) {
        return Boolean.valueOf(properties.getProperty(str + str2)).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int getIntProperty(Properties properties, String str, String str2) {
        try {
            return Integer.parseInt(properties.getProperty(str + str2));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private long getLongProperty(Properties properties, String str, String str2) {
        try {
            return Long.parseLong(properties.getProperty(str + str2));
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getString(Properties properties, String str, String str2) {
        return properties.getProperty(str + str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.conf.ConfigurationBase
    protected Object readResolve() throws ObjectStreamException {
        return super.readResolve();
    }
}
