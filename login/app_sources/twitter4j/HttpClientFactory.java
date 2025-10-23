package twitter4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import twitter4j.conf.ConfigurationContext;

/* loaded from: classes4.dex */
public final class HttpClientFactory {
    private static final Constructor<?> HTTP_CLIENT_CONSTRUCTOR;
    private static final String HTTP_CLIENT_IMPLEMENTATION = "twitter4j.http.httpClient";
    private static final ConcurrentHashMap<HttpClientConfiguration, HttpClient> confClientMap;

    /* JADX WARN: Removed duplicated region for block: B:16:0x001d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0015 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        /*
            r0 = 1782505496(0x6a3ee018, float:5.768854E25)
            java.lang.String r0 = com.liapp.y.ٲٴݴ״ٰ(r0)
            java.lang.String r0 = java.lang.System.getProperty(r0)
            if (r0 == 0) goto L12
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L12
            goto L13
        L12:
            r0 = 0
        L13:
            if (r0 != 0) goto L1b
            java.lang.String r1 = "twitter4j.AlternativeHttpClientImpl"
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L1b
        L1b:
            if (r0 != 0) goto L2b
            java.lang.String r0 = "twitter4j.HttpClientImpl"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.ClassNotFoundException -> L24
            goto L2b
        L24:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
        L2b:
            r1 = 1
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: java.lang.NoSuchMethodException -> L41
            java.lang.Class<twitter4j.HttpClientConfiguration> r2 = twitter4j.HttpClientConfiguration.class
            r3 = 0
            r1[r3] = r2     // Catch: java.lang.NoSuchMethodException -> L41
            java.lang.reflect.Constructor r0 = r0.getConstructor(r1)     // Catch: java.lang.NoSuchMethodException -> L41
            twitter4j.HttpClientFactory.HTTP_CLIENT_CONSTRUCTOR = r0     // Catch: java.lang.NoSuchMethodException -> L41
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            twitter4j.HttpClientFactory.confClientMap = r0
            return
        L41:
            r0 = move-exception
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>(r0)
            throw r1
            fill-array 0x0048: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: twitter4j.HttpClientFactory.<clinit>():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpClient getInstance() {
        return getInstance(ConfigurationContext.getInstance().getHttpClientConfiguration());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static HttpClient getInstance(HttpClientConfiguration httpClientConfiguration) {
        ConcurrentHashMap<HttpClientConfiguration, HttpClient> concurrentHashMap = confClientMap;
        HttpClient httpClient = concurrentHashMap.get(httpClientConfiguration);
        if (httpClient != null) {
            return httpClient;
        }
        try {
            HttpClient httpClient2 = (HttpClient) HTTP_CLIENT_CONSTRUCTOR.newInstance(httpClientConfiguration);
            concurrentHashMap.put(httpClientConfiguration, httpClient2);
            return httpClient2;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }
}
