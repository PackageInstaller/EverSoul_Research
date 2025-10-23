package com.kakaogame.server;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.liapp.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* compiled from: NoSSLv3SocketFactory.kt */
@Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/server/NoSSLv3SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "()V", "delegate", "(Ljavax/net/ssl/SSLSocketFactory;)V", "createSocket", "Ljava/net/Socket;", "host", "Ljava/net/InetAddress;", "port", "", "address", "localAddress", "localPort", "s", "", "autoClose", "", "localHost", "getDefaultCipherSuites", "", "()[Ljava/lang/String;", "getSupportedCipherSuites", "makeSocketSafe", "socket", "DelegateSSLSocket", "NoSSLv3SSLSocket", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class NoSSLv3SocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory delegate;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NoSSLv3SocketFactory() {
        SSLSocketFactory defaultSSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        Intrinsics.checkNotNullExpressionValue(defaultSSLSocketFactory, y.ٲٴݴ״ٰ(1782352496));
        this.delegate = defaultSSLSocketFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public NoSSLv3SocketFactory(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory, y.֬ڱܱײٮ(-1159078599));
        this.delegate = sSLSocketFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        String[] defaultCipherSuites = this.delegate.getDefaultCipherSuites();
        Intrinsics.checkNotNullExpressionValue(defaultCipherSuites, y.ٲٴݴ״ٰ(1782352056));
        return defaultCipherSuites;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] supportedCipherSuites = this.delegate.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, y.٬ݯح׭٩(576347262));
        return supportedCipherSuites;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Socket makeSocketSafe(Socket socket) {
        return socket instanceof SSLSocket ? new NoSSLv3SSLSocket(this, (SSLSocket) socket) : socket;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        Intrinsics.checkNotNullParameter(s, y.ٲٴݴ״ٰ(1781877368));
        Intrinsics.checkNotNullParameter(host, y.ٲٴݴ״ٰ(1782352248));
        Socket createSocket = this.delegate.createSocket(s, host, port, autoClose);
        Intrinsics.checkNotNullExpressionValue(createSocket, "createSocket(...)");
        return makeSocketSafe(createSocket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port) throws IOException {
        Intrinsics.checkNotNullParameter(host, y.ٲٴݴ״ٰ(1782352248));
        Socket createSocket = this.delegate.createSocket(host, port);
        Intrinsics.checkNotNullExpressionValue(createSocket, "createSocket(...)");
        return makeSocketSafe(createSocket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        Intrinsics.checkNotNullParameter(host, y.ٲٴݴ״ٰ(1782352248));
        Intrinsics.checkNotNullParameter(localHost, y.ٲٴݴ״ٰ(1782352264));
        Socket createSocket = this.delegate.createSocket(host, port, localHost, localPort);
        Intrinsics.checkNotNullExpressionValue(createSocket, "createSocket(...)");
        return makeSocketSafe(createSocket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress host, int port) throws IOException {
        Intrinsics.checkNotNullParameter(host, y.ٲٴݴ״ٰ(1782352248));
        Socket createSocket = this.delegate.createSocket(host, port);
        Intrinsics.checkNotNullExpressionValue(createSocket, "createSocket(...)");
        return makeSocketSafe(createSocket);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        Intrinsics.checkNotNullParameter(address, y.ٴسسݬߨ(1393137322));
        Intrinsics.checkNotNullParameter(localAddress, y.ݮڮֲڭܩ(-628251796));
        Socket createSocket = this.delegate.createSocket(address, port, localAddress, localPort);
        Intrinsics.checkNotNullExpressionValue(createSocket, "createSocket(...)");
        return makeSocketSafe(createSocket);
    }

    /* compiled from: NoSSLv3SocketFactory.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/server/NoSSLv3SocketFactory$NoSSLv3SSLSocket;", "Lcom/kakaogame/server/NoSSLv3SocketFactory$DelegateSSLSocket;", "Lcom/kakaogame/server/NoSSLv3SocketFactory;", "delegate", "Ljavax/net/ssl/SSLSocket;", "(Lcom/kakaogame/server/NoSSLv3SocketFactory;Ljavax/net/ssl/SSLSocket;)V", "setEnabledProtocols", "", "protocols", "", "", "([Ljava/lang/String;)V", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private final class NoSSLv3SSLSocket extends DelegateSSLSocket {
        final /* synthetic */ NoSSLv3SocketFactory this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public NoSSLv3SSLSocket(NoSSLv3SocketFactory noSSLv3SocketFactory, SSLSocket sSLSocket) {
            super(noSSLv3SocketFactory, sSLSocket);
            Intrinsics.checkNotNullParameter(sSLSocket, y.֬ڱܱײٮ(-1159078599));
            this.this$0 = noSSLv3SocketFactory;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.server.NoSSLv3SocketFactory.DelegateSSLSocket, javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] protocols) {
            Intrinsics.checkNotNullParameter(protocols, y.دײܮڳܯ(2051053589));
            if (protocols.length == 1) {
                String str = protocols[0];
                String str2 = y.دײܮڳܯ(2051053773);
                if (Intrinsics.areEqual(str2, str)) {
                    String[] enabledProtocols = getDelegate().getEnabledProtocols();
                    ArrayList arrayList = new ArrayList(Arrays.asList(Arrays.copyOf(enabledProtocols, enabledProtocols.length)));
                    if (arrayList.size() > 1) {
                        arrayList.remove(str2);
                        System.out.println((Object) y.ٲٴݴ״ٰ(1782351328));
                    } else {
                        System.out.println((Object) (y.ۮڭڭܬި(862846227) + arrayList));
                    }
                    protocols = (String[]) arrayList.toArray(new String[0]);
                }
            }
            super.setEnabledProtocols(protocols);
        }
    }

    /* compiled from: NoSSLv3SocketFactory.kt */
    @Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b4\b\u0096\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\b\u0010+\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\fH\u0016J\b\u0010-\u001a\u00020\u0013H\u0016J\b\u0010.\u001a\u00020\u0011H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u0011H\u0016J\b\u00102\u001a\u00020\u0011H\u0016J\u0013\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\u0013\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\b\u00105\u001a\u00020\u0013H\u0016J\b\u00106\u001a\u00020\u0011H\u0016J\b\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020\u0013H\u0016J\b\u00109\u001a\u00020\u0013H\u0016J\b\u0010:\u001a\u00020\u0013H\u0016J\b\u0010;\u001a\u00020\u0013H\u0016J\b\u0010<\u001a\u00020\u0013H\u0016J\b\u0010=\u001a\u00020\u0013H\u0016J\u0010\u0010>\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0013H\u0016J\u001b\u0010C\u001a\u00020\u00072\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0002\u0010EJ\u001b\u0010F\u001a\u00020\u00072\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0002\u0010EJ\u0010\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0013H\u0016J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0013H\u0016J\u0010\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0013H\u0016J \u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020\u0011H\u0016J\u0010\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0011H\u0016J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0013H\u0016J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u0011H\u0016J\u0018\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010Z\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0013H\u0016J\u0010\u0010[\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010\\\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\u0013H\u0016J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0013H\u0016J\b\u0010`\u001a\u00020\u0007H\u0016J\b\u0010a\u001a\u00020\u0007H\u0016J\b\u0010b\u001a\u00020\u0007H\u0016J\b\u0010c\u001a\u00020\u001bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0001X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006d"}, m839d2 = {"Lcom/kakaogame/server/NoSSLv3SocketFactory$DelegateSSLSocket;", "Ljavax/net/ssl/SSLSocket;", "delegate", "(Lcom/kakaogame/server/NoSSLv3SocketFactory;Ljavax/net/ssl/SSLSocket;)V", "getDelegate", "()Ljavax/net/ssl/SSLSocket;", "addHandshakeCompletedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Ljavax/net/ssl/HandshakeCompletedListener;", "bind", "localAddr", "Ljava/net/SocketAddress;", "close", "connect", "remoteAddr", "timeout", "", "equals", "", "o", "", "getChannel", "Ljava/nio/channels/SocketChannel;", "getEnableSessionCreation", "getEnabledCipherSuites", "", "", "()[Ljava/lang/String;", "getEnabledProtocols", "getInetAddress", "Ljava/net/InetAddress;", "getInputStream", "Ljava/io/InputStream;", "getKeepAlive", "getLocalAddress", "getLocalPort", "getLocalSocketAddress", "getNeedClientAuth", "getOOBInline", "getOutputStream", "Ljava/io/OutputStream;", "getPort", "getReceiveBufferSize", "getRemoteSocketAddress", "getReuseAddress", "getSendBufferSize", "getSession", "Ljavax/net/ssl/SSLSession;", "getSoLinger", "getSoTimeout", "getSupportedCipherSuites", "getSupportedProtocols", "getTcpNoDelay", "getTrafficClass", "getUseClientMode", "getWantClientAuth", "isBound", "isClosed", "isConnected", "isInputShutdown", "isOutputShutdown", "removeHandshakeCompletedListener", "sendUrgentData", "value", "setEnableSessionCreation", "flag", "setEnabledCipherSuites", "suites", "([Ljava/lang/String;)V", "setEnabledProtocols", "protocols", "setKeepAlive", "keepAlive", "setNeedClientAuth", "need", "setOOBInline", "oobinline", "setPerformancePreferences", "connectionTime", "latency", "bandwidth", "setReceiveBufferSize", ServerConstants.SIZE, "setReuseAddress", "reuse", "setSendBufferSize", "setSoLinger", DebugKt.DEBUG_PROPERTY_VALUE_ON, "setSoTimeout", "setTcpNoDelay", "setTrafficClass", "setUseClientMode", "mode", "setWantClientAuth", "want", "shutdownInput", "shutdownOutput", "startHandshake", "toString", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public class DelegateSSLSocket extends SSLSocket {
        private final SSLSocket delegate;
        final /* synthetic */ NoSSLv3SocketFactory this$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public DelegateSSLSocket(NoSSLv3SocketFactory noSSLv3SocketFactory, SSLSocket sSLSocket) {
            Intrinsics.checkNotNullParameter(sSLSocket, y.֬ڱܱײٮ(-1159078599));
            this.this$0 = noSSLv3SocketFactory;
            this.delegate = sSLSocket;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected final SSLSocket getDelegate() {
            return this.delegate;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedCipherSuites() {
            String[] supportedCipherSuites = this.delegate.getSupportedCipherSuites();
            Intrinsics.checkNotNullExpressionValue(supportedCipherSuites, y.٬ݯح׭٩(576347262));
            return supportedCipherSuites;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledCipherSuites() {
            String[] enabledCipherSuites = this.delegate.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, y.دײܮڳܯ(2051048421));
            return enabledCipherSuites;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void setEnabledCipherSuites(String[] suites) {
            Intrinsics.checkNotNullParameter(suites, y.֬ڱܱײٮ(-1159084263));
            this.delegate.setEnabledCipherSuites(suites);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedProtocols() {
            String[] supportedProtocols = this.delegate.getSupportedProtocols();
            Intrinsics.checkNotNullExpressionValue(supportedProtocols, y.دײܮڳܯ(2051054389));
            return supportedProtocols;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledProtocols() {
            String[] enabledProtocols = this.delegate.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols, y.ٲٴݴ״ٰ(1782357352));
            return enabledProtocols;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] protocols) {
            Intrinsics.checkNotNullParameter(protocols, y.دײܮڳܯ(2051053589));
            this.delegate.setEnabledProtocols(protocols);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public SSLSession getSession() {
            SSLSession session = this.delegate.getSession();
            Intrinsics.checkNotNullExpressionValue(session, y.ۮڭڭܬި(862844659));
            return session;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void addHandshakeCompletedListener(HandshakeCompletedListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            this.delegate.addHandshakeCompletedListener(listener);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void removeHandshakeCompletedListener(HandshakeCompletedListener listener) {
            Intrinsics.checkNotNullParameter(listener, y.٬ݯح׭٩(575816662));
            this.delegate.removeHandshakeCompletedListener(listener);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void startHandshake() throws IOException {
            this.delegate.startHandshake();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void setUseClientMode(boolean mode) {
            this.delegate.setUseClientMode(mode);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public boolean getUseClientMode() {
            return this.delegate.getUseClientMode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void setNeedClientAuth(boolean need) {
            this.delegate.setNeedClientAuth(need);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void setWantClientAuth(boolean want) {
            this.delegate.setWantClientAuth(want);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public boolean getNeedClientAuth() {
            return this.delegate.getNeedClientAuth();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public boolean getWantClientAuth() {
            return this.delegate.getWantClientAuth();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public void setEnableSessionCreation(boolean flag) {
            this.delegate.setEnableSessionCreation(flag);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket
        public boolean getEnableSessionCreation() {
            return this.delegate.getEnableSessionCreation();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void bind(SocketAddress localAddr) throws IOException {
            Intrinsics.checkNotNullParameter(localAddr, y.ٴسسݬߨ(1393131530));
            this.delegate.bind(localAddr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.delegate.close();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void connect(SocketAddress remoteAddr) throws IOException {
            Intrinsics.checkNotNullParameter(remoteAddr, y.ٴسسݬߨ(1393131762));
            this.delegate.connect(remoteAddr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
            Intrinsics.checkNotNullParameter(remoteAddr, y.ٴسسݬߨ(1393131762));
            this.delegate.connect(remoteAddr, timeout);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public SocketChannel getChannel() {
            SocketChannel channel = this.delegate.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, y.٬ݯح׭٩(576341310));
            return channel;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public InetAddress getInetAddress() {
            InetAddress inetAddress = this.delegate.getInetAddress();
            Intrinsics.checkNotNullExpressionValue(inetAddress, y.֬ڱܱײٮ(-1159078287));
            return inetAddress;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            InputStream inputStream = this.delegate.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, y.٬ݯح׭٩(576341958));
            return inputStream;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean getKeepAlive() throws SocketException {
            return this.delegate.getKeepAlive();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public InetAddress getLocalAddress() {
            InetAddress localAddress = this.delegate.getLocalAddress();
            Intrinsics.checkNotNullExpressionValue(localAddress, y.ٴسسݬߨ(1393138882));
            return localAddress;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public int getLocalPort() {
            return this.delegate.getLocalPort();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public SocketAddress getLocalSocketAddress() {
            SocketAddress localSocketAddress = this.delegate.getLocalSocketAddress();
            Intrinsics.checkNotNullExpressionValue(localSocketAddress, y.دײܮڳܯ(2051055421));
            return localSocketAddress;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean getOOBInline() throws SocketException {
            return this.delegate.getOOBInline();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            OutputStream outputStream = this.delegate.getOutputStream();
            Intrinsics.checkNotNullExpressionValue(outputStream, y.ۮڭڭܬި(862844699));
            return outputStream;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public int getPort() {
            return this.delegate.getPort();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public synchronized int getReceiveBufferSize() throws SocketException {
            return this.delegate.getReceiveBufferSize();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public SocketAddress getRemoteSocketAddress() {
            SocketAddress remoteSocketAddress = this.delegate.getRemoteSocketAddress();
            Intrinsics.checkNotNullExpressionValue(remoteSocketAddress, y.ݮڮֲڭܩ(-628249972));
            return remoteSocketAddress;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean getReuseAddress() throws SocketException {
            return this.delegate.getReuseAddress();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public synchronized int getSendBufferSize() throws SocketException {
            return this.delegate.getSendBufferSize();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public int getSoLinger() throws SocketException {
            return this.delegate.getSoLinger();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public synchronized int getSoTimeout() throws SocketException {
            return this.delegate.getSoTimeout();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean getTcpNoDelay() throws SocketException {
            return this.delegate.getTcpNoDelay();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public int getTrafficClass() throws SocketException {
            return this.delegate.getTrafficClass();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean isBound() {
            return this.delegate.isBound();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean isConnected() {
            return this.delegate.isConnected();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean isInputShutdown() {
            return this.delegate.isInputShutdown();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public boolean isOutputShutdown() {
            return this.delegate.isOutputShutdown();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void sendUrgentData(int value) throws IOException {
            this.delegate.sendUrgentData(value);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void setKeepAlive(boolean keepAlive) throws SocketException {
            this.delegate.setKeepAlive(keepAlive);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void setOOBInline(boolean oobinline) throws SocketException {
            this.delegate.setOOBInline(oobinline);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
            this.delegate.setPerformancePreferences(connectionTime, latency, bandwidth);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public synchronized void setReceiveBufferSize(int size) throws SocketException {
            this.delegate.setReceiveBufferSize(size);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void setReuseAddress(boolean reuse) throws SocketException {
            this.delegate.setReuseAddress(reuse);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public synchronized void setSendBufferSize(int size) throws SocketException {
            this.delegate.setSendBufferSize(size);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void setSoLinger(boolean on, int timeout) throws SocketException {
            this.delegate.setSoLinger(on, timeout);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public synchronized void setSoTimeout(int timeout) throws SocketException {
            this.delegate.setSoTimeout(timeout);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void setTcpNoDelay(boolean on) throws SocketException {
            this.delegate.setTcpNoDelay(on);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void setTrafficClass(int value) throws SocketException {
            this.delegate.setTrafficClass(value);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void shutdownInput() throws IOException {
            this.delegate.shutdownInput();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.net.Socket
        public void shutdownOutput() throws IOException {
            this.delegate.shutdownOutput();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // javax.net.ssl.SSLSocket, java.net.Socket
        public String toString() {
            String sSLSocket = this.delegate.toString();
            Intrinsics.checkNotNullExpressionValue(sSLSocket, y.ٲٴݴ״ٰ(1781855688));
            return sSLSocket;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(Object o) {
            return Intrinsics.areEqual(this.delegate, o);
        }
    }
}
