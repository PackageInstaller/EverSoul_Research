package com.kakaogame.server;

import android.util.Log;
import com.kakaogame.Logger;
import com.liapp.y;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ServerSecurityManager.kt */
@Metadata(m838d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/server/ServerSecurityManager;", "", "()V", "TAG", "", "sSLSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "getSSLSocketFactory$annotations", "getSSLSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/TrustManager;", "getTrustManager", "()Ljavax/net/ssl/TrustManager;", "getHostnameVerifier", "Ljavax/net/ssl/HostnameVerifier;", "url", "Ljava/net/URL;", "isRealHost", "", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ServerSecurityManager {
    public static final ServerSecurityManager INSTANCE = new ServerSecurityManager();
    private static final String TAG = "ServerSecurityManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getSSLSocketFactory$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ServerSecurityManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final SSLSocketFactory getSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager trustManager = INSTANCE.getTrustManager();
        SSLContext sSLContext = SSLContext.getInstance(y.٬ݯح׭٩(576333430));
        sSLContext.init(null, new TrustManager[]{trustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, y.٬ݯح׭٩(576333502));
        return new NoSSLv3SocketFactory(socketFactory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final HostnameVerifier getHostnameVerifier(final URL url) {
        Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
        return new HostnameVerifier() { // from class: com.kakaogame.server.ServerSecurityManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // javax.net.ssl.HostnameVerifier
            public final boolean verify(String str, SSLSession sSLSession) {
                boolean hostnameVerifier$lambda$0;
                hostnameVerifier$lambda$0 = ServerSecurityManager.getHostnameVerifier$lambda$0(url, str, sSLSession);
                return hostnameVerifier$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean getHostnameVerifier$lambda$0(URL url, String str, SSLSession sSLSession) {
        Intrinsics.checkNotNullParameter(url, y.ۮڭڭܬި(862817059));
        if (INSTANCE.isRealHost(url)) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isRealHost(URL url) {
        Log.v(y.٬ݯح׭٩(576332806), y.ݬֲ֮ܲت(1512098015) + url);
        String authority = url.getAuthority();
        if (authority == null) {
            return false;
        }
        String lowerCase = authority.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.֬ڱܱײٮ(-1159086455));
        if (lowerCase == null) {
            return false;
        }
        String str = lowerCase;
        return (StringsKt.contains$default((CharSequence) str, (CharSequence) y.دײܮڳܯ(2051079973), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.ݮڮֲڭܩ(-628241980), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.٬ݯح׭٩(576338430), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.٬ݯح׭٩(576338374), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.ݮڮֲڭܩ(-628241844), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.ٲٴݴ״ٰ(1782374768), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.ݮڮֲڭܩ(-628241692), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.ݮڮֲڭܩ(-628241596), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.ݮڮֲڭܩ(-628241444), false, 2, (Object) null)) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final TrustManager getTrustManager() {
        return new X509TrustManager() { // from class: com.kakaogame.server.ServerSecurityManager$trustManager$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                Intrinsics.checkNotNullParameter(chain, y.٬ݯح׭٩(576332222));
                Intrinsics.checkNotNullParameter(authType, y.ۮڭڭܬި(862463915));
                Logger.INSTANCE.m706v("ServerSecurityManager", y.֬ڱܱײٮ(-1159087879) + authType + y.ݮڮֲڭܩ(-628756788) + chain);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                Intrinsics.checkNotNullParameter(chain, y.٬ݯح׭٩(576332222));
                Intrinsics.checkNotNullParameter(authType, y.ۮڭڭܬި(862463915));
                Logger.INSTANCE.m706v(y.٬ݯح׭٩(576332806), y.ݬֲ֮ܲت(1512099175) + authType + y.ݮڮֲڭܩ(-628756788) + chain);
                for (X509Certificate x509Certificate : chain) {
                    x509Certificate.checkValidity();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                Logger.INSTANCE.m706v(y.٬ݯح׭٩(576332806), y.ۮڭڭܬި(862816731));
                return new X509Certificate[0];
            }
        };
    }
}
