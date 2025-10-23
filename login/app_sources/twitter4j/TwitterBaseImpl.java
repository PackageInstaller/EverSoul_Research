package twitter4j;

import com.liapp.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.BasicAuthorization;
import twitter4j.auth.NullAuthorization;
import twitter4j.auth.OAuth2Authorization;
import twitter4j.auth.OAuth2Support;
import twitter4j.auth.OAuth2Token;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.auth.OAuthSupport;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.util.function.Consumer;

/* loaded from: classes4.dex */
abstract class TwitterBaseImpl implements TwitterBase, Serializable, OAuthSupport, OAuth2Support, HttpResponseListener {
    private static final String WWW_DETAILS = "See http://twitter4j.org/en/configuration.html for details. See and register at http://apps.twitter.com/";
    private static final long serialVersionUID = -7824361938865528554L;
    Authorization auth;
    Configuration conf;
    ObjectFactory factory;
    transient HttpClient http;
    private transient String screenName = null;

    /* renamed from: id */
    private transient long f1573id = 0;
    private List<RateLimitStatusListener> rateLimitStatusListeners = new ArrayList(0);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TwitterBaseImpl(Configuration configuration, Authorization authorization) {
        this.conf = configuration;
        this.auth = authorization;
        init();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void init() {
        if (this.auth == null) {
            String oAuthConsumerKey = this.conf.getOAuthConsumerKey();
            String oAuthConsumerSecret = this.conf.getOAuthConsumerSecret();
            if (oAuthConsumerKey != null && oAuthConsumerSecret != null) {
                if (this.conf.isApplicationOnlyAuthEnabled()) {
                    OAuth2Authorization oAuth2Authorization = new OAuth2Authorization(this.conf);
                    String oAuth2TokenType = this.conf.getOAuth2TokenType();
                    String oAuth2AccessToken = this.conf.getOAuth2AccessToken();
                    if (oAuth2TokenType != null && oAuth2AccessToken != null) {
                        oAuth2Authorization.setOAuth2Token(new OAuth2Token(oAuth2TokenType, oAuth2AccessToken));
                    }
                    this.auth = oAuth2Authorization;
                } else {
                    OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                    String oAuthAccessToken = this.conf.getOAuthAccessToken();
                    String oAuthAccessTokenSecret = this.conf.getOAuthAccessTokenSecret();
                    if (oAuthAccessToken != null && oAuthAccessTokenSecret != null) {
                        oAuthAuthorization.setOAuthAccessToken(new AccessToken(oAuthAccessToken, oAuthAccessTokenSecret));
                    }
                    this.auth = oAuthAuthorization;
                }
            } else {
                this.auth = NullAuthorization.getInstance();
            }
        }
        this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
        setFactory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setFactory() {
        this.factory = new JSONImplFactory(this.conf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBase
    public String getScreenName() throws TwitterException, IllegalStateException {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException(y.ݮڮֲڭܩ(-628049660));
        }
        if (this.screenName == null) {
            Authorization authorization = this.auth;
            if (authorization instanceof BasicAuthorization) {
                String userId = ((BasicAuthorization) authorization).getUserId();
                this.screenName = userId;
                if (userId.contains(y.֬ڱܱײٮ(-1158359775))) {
                    this.screenName = null;
                }
            }
            if (this.screenName == null) {
                fillInIDAndScreenName();
            }
        }
        return this.screenName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBase
    public long getId() throws TwitterException, IllegalStateException {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException(y.ݮڮֲڭܩ(-628049660));
        }
        if (0 == this.f1573id) {
            fillInIDAndScreenName();
        }
        return this.f1573id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    User fillInIDAndScreenName() throws TwitterException {
        return fillInIDAndScreenName(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    User fillInIDAndScreenName(HttpParameter[] httpParameterArr) throws TwitterException {
        ensureAuthorizationEnabled();
        UserJSONImpl userJSONImpl = new UserJSONImpl(this.http.get(this.conf.getRestBaseURL() + y.ݬֲ֮ܲت(1513990103), httpParameterArr, this.auth, this), this.conf);
        this.screenName = userJSONImpl.getScreenName();
        this.f1573id = userJSONImpl.getId();
        return userJSONImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBase
    public void addRateLimitStatusListener(RateLimitStatusListener rateLimitStatusListener) {
        this.rateLimitStatusListeners.add(rateLimitStatusListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBase
    public void onRateLimitStatus(final Consumer<RateLimitStatusEvent> consumer) {
        this.rateLimitStatusListeners.add(new RateLimitStatusListener() { // from class: twitter4j.TwitterBaseImpl.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitReached(RateLimitStatusEvent rateLimitStatusEvent) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitStatus(RateLimitStatusEvent rateLimitStatusEvent) {
                consumer.accept(rateLimitStatusEvent);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBase
    public void onRateLimitReached(final Consumer<RateLimitStatusEvent> consumer) {
        this.rateLimitStatusListeners.add(new RateLimitStatusListener() { // from class: twitter4j.TwitterBaseImpl.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitStatus(RateLimitStatusEvent rateLimitStatusEvent) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // twitter4j.RateLimitStatusListener
            public void onRateLimitReached(RateLimitStatusEvent rateLimitStatusEvent) {
                consumer.accept(rateLimitStatusEvent);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.HttpResponseListener
    public void httpResponseReceived(HttpResponseEvent httpResponseEvent) {
        int statusCode;
        RateLimitStatus rateLimitStatus;
        if (this.rateLimitStatusListeners.size() != 0) {
            HttpResponse response = httpResponseEvent.getResponse();
            TwitterException twitterException = httpResponseEvent.getTwitterException();
            if (twitterException != null) {
                rateLimitStatus = twitterException.getRateLimitStatus();
                statusCode = twitterException.getStatusCode();
            } else {
                RateLimitStatus createRateLimitStatusFromResponseHeader = JSONImplFactory.createRateLimitStatusFromResponseHeader(response);
                statusCode = response.getStatusCode();
                rateLimitStatus = createRateLimitStatusFromResponseHeader;
            }
            if (rateLimitStatus != null) {
                RateLimitStatusEvent rateLimitStatusEvent = new RateLimitStatusEvent(this, rateLimitStatus, httpResponseEvent.isAuthenticated());
                if (statusCode == 420 || statusCode == 503 || statusCode == 429) {
                    for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
                        rateLimitStatusListener.onRateLimitStatus(rateLimitStatusEvent);
                        rateLimitStatusListener.onRateLimitReached(rateLimitStatusEvent);
                    }
                    return;
                }
                Iterator<RateLimitStatusListener> it = this.rateLimitStatusListeners.iterator();
                while (it.hasNext()) {
                    it.next().onRateLimitStatus(rateLimitStatusEvent);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBase
    public final Authorization getAuthorization() {
        return this.auth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.TwitterBase
    public Configuration getConfiguration() {
        return this.conf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void ensureAuthorizationEnabled() {
        if (!this.auth.isEnabled()) {
            throw new IllegalStateException(y.دײܮڳܯ(2052962525));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void ensureOAuthEnabled() {
        if (!(this.auth instanceof OAuthAuthorization)) {
            throw new IllegalStateException(y.ٴسسݬߨ(1393866594));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.putFields();
        objectOutputStream.writeFields();
        objectOutputStream.writeObject(this.conf);
        objectOutputStream.writeObject(this.auth);
        ArrayList arrayList = new ArrayList(0);
        for (RateLimitStatusListener rateLimitStatusListener : this.rateLimitStatusListeners) {
            if (rateLimitStatusListener instanceof Serializable) {
                arrayList.add(rateLimitStatusListener);
            }
        }
        objectOutputStream.writeObject(arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.readFields();
        this.conf = (Configuration) objectInputStream.readObject();
        this.auth = (Authorization) objectInputStream.readObject();
        this.rateLimitStatusListeners = (List) objectInputStream.readObject();
        this.http = HttpClientFactory.getInstance(this.conf.getHttpClientConfiguration());
        setFactory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport, twitter4j.auth.OAuth2Support
    public synchronized void setOAuthConsumer(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("consumer key is null");
        }
        if (str2 == null) {
            throw new NullPointerException("consumer secret is null");
        }
        Authorization authorization = this.auth;
        if (authorization instanceof NullAuthorization) {
            if (this.conf.isApplicationOnlyAuthEnabled()) {
                OAuth2Authorization oAuth2Authorization = new OAuth2Authorization(this.conf);
                oAuth2Authorization.setOAuthConsumer(str, str2);
                this.auth = oAuth2Authorization;
            } else {
                OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
                oAuthAuthorization.setOAuthConsumer(str, str2);
                this.auth = oAuthAuthorization;
            }
        } else if (authorization instanceof BasicAuthorization) {
            XAuthAuthorization xAuthAuthorization = new XAuthAuthorization((BasicAuthorization) this.auth);
            xAuthAuthorization.setOAuthConsumer(str, str2);
            this.auth = xAuthAuthorization;
        } else if ((authorization instanceof OAuthAuthorization) || (authorization instanceof OAuth2Authorization)) {
            throw new IllegalStateException("consumer key/secret pair already set.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken() throws TwitterException {
        return getOAuthRequestToken(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str) throws TwitterException {
        return getOAuth().getOAuthRequestToken(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2) throws TwitterException {
        return getOAuth().getOAuthRequestToken(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public RequestToken getOAuthRequestToken(String str, String str2, String str3) throws TwitterException {
        return getOAuth().getOAuthRequestToken(str, str2, str3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken() throws TwitterException {
        AccessToken oAuthAccessToken;
        Authorization authorization = getAuthorization();
        if (authorization instanceof BasicAuthorization) {
            BasicAuthorization basicAuthorization = (BasicAuthorization) authorization;
            Authorization authorizationFactory = AuthorizationFactory.getInstance(this.conf);
            if (authorizationFactory instanceof OAuthAuthorization) {
                this.auth = authorizationFactory;
                oAuthAccessToken = ((OAuthAuthorization) authorizationFactory).getOAuthAccessToken(basicAuthorization.getUserId(), basicAuthorization.getPassword());
            } else {
                throw new IllegalStateException("consumer key / secret combination not supplied.");
            }
        } else if (authorization instanceof XAuthAuthorization) {
            XAuthAuthorization xAuthAuthorization = (XAuthAuthorization) authorization;
            this.auth = xAuthAuthorization;
            OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
            oAuthAuthorization.setOAuthConsumer(xAuthAuthorization.getConsumerKey(), xAuthAuthorization.getConsumerSecret());
            oAuthAccessToken = oAuthAuthorization.getOAuthAccessToken(xAuthAuthorization.getUserId(), xAuthAuthorization.getPassword());
        } else {
            oAuthAccessToken = getOAuth().getOAuthAccessToken();
        }
        this.screenName = oAuthAccessToken.getScreenName();
        this.f1573id = oAuthAccessToken.getUserId();
        return oAuthAccessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(String str) throws TwitterException {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(str);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken) throws TwitterException {
        AccessToken oAuthAccessToken;
        oAuthAccessToken = getOAuth().getOAuthAccessToken(requestToken);
        this.screenName = oAuthAccessToken.getScreenName();
        return oAuthAccessToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(RequestToken requestToken, String str) throws TwitterException {
        return getOAuth().getOAuthAccessToken(requestToken, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public synchronized void setOAuthAccessToken(AccessToken accessToken) {
        getOAuth().setOAuthAccessToken(accessToken);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuthSupport
    public synchronized AccessToken getOAuthAccessToken(String str, String str2) throws TwitterException {
        return getOAuth().getOAuthAccessToken(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private OAuthSupport getOAuth() {
        Authorization authorization = this.auth;
        if (!(authorization instanceof OAuthSupport)) {
            throw new IllegalStateException(y.ݬֲ֮ܲت(1513984663));
        }
        return (OAuthSupport) authorization;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuth2Support
    public synchronized OAuth2Token getOAuth2Token() throws TwitterException {
        return getOAuth2().getOAuth2Token();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuth2Support
    public void setOAuth2Token(OAuth2Token oAuth2Token) {
        getOAuth2().setOAuth2Token(oAuth2Token);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.auth.OAuth2Support
    public synchronized void invalidateOAuth2Token() throws TwitterException {
        getOAuth2().invalidateOAuth2Token();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private OAuth2Support getOAuth2() {
        Authorization authorization = this.auth;
        if (!(authorization instanceof OAuth2Support)) {
            throw new IllegalStateException(y.ݬֲ֮ܲت(1513984663));
        }
        return (OAuth2Support) authorization;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TwitterBaseImpl)) {
            return false;
        }
        TwitterBaseImpl twitterBaseImpl = (TwitterBaseImpl) obj;
        Authorization authorization = this.auth;
        if (authorization == null ? twitterBaseImpl.auth != null : !authorization.equals(twitterBaseImpl.auth)) {
            return false;
        }
        if (!this.conf.equals(twitterBaseImpl.conf)) {
            return false;
        }
        HttpClient httpClient = this.http;
        if (httpClient == null ? twitterBaseImpl.http == null : httpClient.equals(twitterBaseImpl.http)) {
            return this.rateLimitStatusListeners.equals(twitterBaseImpl.rateLimitStatusListeners);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = this.conf.hashCode() * 31;
        HttpClient httpClient = this.http;
        int hashCode2 = (((hashCode + (httpClient != null ? httpClient.hashCode() : 0)) * 31) + this.rateLimitStatusListeners.hashCode()) * 31;
        Authorization authorization = this.auth;
        return hashCode2 + (authorization != null ? authorization.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ٴسسݬߨ(1393854570) + this.conf + y.ٲٴݴ״ٰ(1780586456) + this.http + y.٬ݯح׭٩(575098150) + this.rateLimitStatusListeners + y.ݬֲ֮ܲت(1513988711) + this.auth + '}';
    }
}
