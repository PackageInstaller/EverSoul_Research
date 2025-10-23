package com.singular.sdk.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public class TLSSocketFactory extends SSLSocketFactory {
    private SSLSocketFactory internalSSLSocketFactory;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TLSSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        this.internalSSLSocketFactory = sSLContext.getSocketFactory();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.internalSSLSocketFactory.getDefaultCipherSuites();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.internalSSLSocketFactory.getSupportedCipherSuites();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(socket, str, i, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(str, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(str, i, inetAddress, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(inetAddress, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return enableTLSOnSocket(this.internalSSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Socket enableTLSOnSocket(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
        }
        return socket;
    }
}
