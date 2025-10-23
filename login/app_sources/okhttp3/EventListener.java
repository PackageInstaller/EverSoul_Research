package okhttp3;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventListener.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J*\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J2\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J+\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0011\u0010\"\u001a\r\u0012\t\u0012\u00070$¢\u0006\u0002\b%0#H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J+\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0011\u0010*\u001a\r\u0012\t\u0012\u00070\u0016¢\u0006\u0002\b%0#H\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00106\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u00107\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u001a\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006A"}, m839d2 = {"Lokhttp3/EventListener;", "", "()V", "cacheConditionalHit", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "cachedResponse", "Lokhttp3/Response;", "cacheHit", "response", "cacheMiss", "callEnd", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "canceled", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectFailed", "connectStart", "connectionAcquired", "connection", "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "Lkotlin/jvm/JvmSuppressWildcards;", "dnsStart", "proxySelectEnd", "url", "Lokhttp3/HttpUrl;", "proxies", "proxySelectStart", "requestBodyEnd", "byteCount", "", "requestBodyStart", "requestFailed", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseFailed", "responseHeadersEnd", "responseHeadersStart", "satisfactionFailure", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "Companion", "Factory", "okhttp"}, m840k = 1, m841mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class EventListener {
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: EventListener.kt */
    @Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m839d2 = {"Lokhttp3/EventListener$Factory;", "", "create", "Lokhttp3/EventListener;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "okhttp"}, m840k = 1, m841mv = {1, 4, 0})
    public interface Factory {
        EventListener create(Call call);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cacheConditionalHit(Call call, Response cachedResponse) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(cachedResponse, "cachedResponse");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cacheHit(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cacheMiss(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void callEnd(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void callStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void canceled(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
        Intrinsics.checkNotNullParameter(inetAddressList, "inetAddressList");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void dnsStart(Call call, String domainName) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(domainName, "domainName");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxies, "proxies");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void proxySelectStart(Call call, HttpUrl url) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestBodyEnd(Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(request, "request");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void responseBodyEnd(Call call, long byteCount) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void responseBodyStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(ioe, "ioe");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void responseHeadersStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.checkNotNullParameter(call, "call");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void secureConnectStart(Call call) {
        Intrinsics.checkNotNullParameter(call, "call");
    }
}
