package twitter4j;

import com.liapp.y;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.auth.OAuthAuthorization;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes4.dex */
public class TwitterFactory implements Serializable {
    static final Authorization DEFAULT_AUTHORIZATION;
    private static final Twitter SINGLETON;
    private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
    private static final long serialVersionUID = -563983536986910054L;
    private final Configuration conf;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        /*
            r0 = 1393874906(0x5314d7da, float:6.3927655E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            twitter4j.conf.Configuration r1 = twitter4j.conf.ConfigurationContext.getInstance()
            twitter4j.auth.Authorization r1 = twitter4j.auth.AuthorizationFactory.getInstance(r1)
            twitter4j.TwitterFactory.DEFAULT_AUTHORIZATION = r1
            r1 = 1
            r2 = 0
            java.lang.String r3 = "com.google.appengine.api.urlfetch.URLFetchService"
            java.lang.Class.forName(r3)     // Catch: java.lang.ClassNotFoundException -> L1a
            r3 = r1
            goto L1b
        L1a:
            r3 = r2
        L1b:
            if (r3 == 0) goto L21
            java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L21
            goto L22
        L21:
            r0 = 0
        L22:
            if (r0 != 0) goto L2b
            r0 = -1158378055(0xffffffffbaf48db9, float:-0.0018657959)
            java.lang.String r0 = com.liapp.y.֬ڱܱײٮ(r0)
        L2b:
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L6a java.lang.NoSuchMethodException -> L71
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.ClassNotFoundException -> L6a java.lang.NoSuchMethodException -> L71
            java.lang.Class<twitter4j.conf.Configuration> r5 = twitter4j.conf.Configuration.class
            r4[r2] = r5     // Catch: java.lang.ClassNotFoundException -> L6a java.lang.NoSuchMethodException -> L71
            java.lang.Class<twitter4j.auth.Authorization> r5 = twitter4j.auth.Authorization.class
            r4[r1] = r5     // Catch: java.lang.ClassNotFoundException -> L6a java.lang.NoSuchMethodException -> L71
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r4)     // Catch: java.lang.ClassNotFoundException -> L6a java.lang.NoSuchMethodException -> L71
            twitter4j.TwitterFactory.TWITTER_CONSTRUCTOR = r0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            twitter4j.conf.Configuration r4 = twitter4j.conf.ConfigurationContext.getInstance()     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            r3[r2] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            twitter4j.auth.Authorization r2 = twitter4j.TwitterFactory.DEFAULT_AUTHORIZATION     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            r3[r1] = r2     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            java.lang.Object r0 = r0.newInstance(r3)     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            twitter4j.Twitter r0 = (twitter4j.Twitter) r0     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            twitter4j.TwitterFactory.SINGLETON = r0     // Catch: java.lang.reflect.InvocationTargetException -> L55 java.lang.IllegalAccessException -> L5c java.lang.InstantiationException -> L63
            return
        L55:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L5c:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L63:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L6a:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L71:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
            fill-array 0x0078: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.TwitterFactory.<clinit>():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterFactory() {
        this(ConfigurationContext.getInstance());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterFactory(Configuration configuration) {
        if (configuration == null) {
            throw new NullPointerException(y.ٴسسݬߨ(1393873250));
        }
        this.conf = configuration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TwitterFactory(String str) {
        this(ConfigurationContext.getInstance(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Twitter getInstance() {
        return getInstance(AuthorizationFactory.getInstance(this.conf));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Twitter getInstance(AccessToken accessToken) {
        String oAuthConsumerKey = this.conf.getOAuthConsumerKey();
        String oAuthConsumerSecret = this.conf.getOAuthConsumerSecret();
        if (oAuthConsumerKey == null && oAuthConsumerSecret == null) {
            throw new IllegalStateException(y.ٲٴݴ״ٰ(1780600120));
        }
        OAuthAuthorization oAuthAuthorization = new OAuthAuthorization(this.conf);
        oAuthAuthorization.setOAuthAccessToken(accessToken);
        return getInstance(oAuthAuthorization);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Twitter getInstance(Authorization authorization) {
        try {
            return TWITTER_CONSTRUCTOR.newInstance(this.conf, authorization);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Twitter getSingleton() {
        return SINGLETON;
    }
}
