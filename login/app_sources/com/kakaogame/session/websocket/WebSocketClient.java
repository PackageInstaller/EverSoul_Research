package com.kakaogame.session.websocket;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.net.HttpHeaders;
import com.kakao.sdk.share.Constants;
import com.kakaogame.Logger;
import com.liapp.y;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.CharEncoding;

/* compiled from: WebSocketClient.kt */
@Metadata(m838d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0002+,B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001aJ\b\u0010\u001f\u001a\u00020\bH\u0002J\u0006\u0010 \u001a\u00020\u001aJ\u0010\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010!\u001a\u00020\u001a2\b\u0010$\u001a\u0004\u0018\u00010\bJ\u0006\u0010%\u001a\u00020\u001aJ\u0012\u0010&\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020\u001cH\u0002J\u0010\u0010(\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010(\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\bJ\u0010\u0010)\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010#R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m839d2 = {"Lcom/kakaogame/session/websocket/WebSocketClient;", "", "mURI", "Ljava/net/URI;", "mListener", "Lcom/kakaogame/session/websocket/WebSocketClient$Listener;", "mExtraHeaders", "", "", "(Ljava/net/URI;Lcom/kakaogame/session/websocket/WebSocketClient$Listener;Ljava/util/Map;)V", "<set-?>", "", "isConnected", "()Z", "mHandler", "Landroid/os/Handler;", "mHandlerThread", "Landroid/os/HandlerThread;", "mParser", "Lcom/kakaogame/session/websocket/HybiParser;", "mSendLock", "mSocket", "Ljava/net/Socket;", "mThread", "Ljava/lang/Thread;", "checkResponse", "", "inputStream", "Ljava/io/InputStream;", "secWebSocketKey", "connect", "createSecret", "disconnect", "onMessage", "data", "", "message", "ping", "readLine", "reader", Constants.TALK_SHARE_AUTHORITY, "sendFrame", TypedValues.AttributesType.S_FRAME, "Companion", "Listener", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class WebSocketClient {
    private static final String TAG = "WebSocketClient";
    private boolean isConnected;
    private final Map<String, String> mExtraHeaders;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Listener mListener;
    private final HybiParser mParser;
    private final Object mSendLock;
    private Socket mSocket;
    private Thread mThread;
    private final URI mURI;

    /* compiled from: WebSocketClient.kt */
    @Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\bH&¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/session/websocket/WebSocketClient$Listener;", "", "onConnect", "", "onDisconnect", "code", "", "reason", "", "onError", "error", "Ljava/lang/Exception;", "onMessage", "data", "", "message", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface Listener {
        void onConnect();

        void onDisconnect(int code, String reason);

        void onError(Exception error);

        void onMessage(String message);

        void onMessage(byte[] data);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebSocketClient(URI uri, Listener listener, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(uri, y.ٴسسݬߨ(1393114866));
        Intrinsics.checkNotNullParameter(listener, y.ٴسسݬߨ(1393114754));
        this.mURI = uri;
        this.mListener = listener;
        this.mExtraHeaders = map;
        HandlerThread handlerThread = new HandlerThread("websocket-thread");
        this.mHandlerThread = handlerThread;
        this.mParser = new HybiParser(this);
        this.mSendLock = new Object();
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isConnected() {
        return this.isConnected;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void connect() {
        Thread thread = this.mThread;
        if (thread != null) {
            Intrinsics.checkNotNull(thread);
            if (thread.isAlive()) {
                return;
            }
        }
        Thread thread2 = new Thread(new Runnable() { // from class: com.kakaogame.session.websocket.WebSocketClient$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                WebSocketClient.connect$lambda$0(WebSocketClient.this);
            }
        });
        this.mThread = thread2;
        thread2.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:0|1|(7:2|3|4|(1:6)(3:81|(1:86)|87)|7|(1:9)(1:80)|10)|(4:(5:(22:15|(1:17)|18|(1:20)(1:78)|21|22|23|24|(13:29|30|(3:32|(7:35|36|37|38|39|40|33)|56)|57|(1:59)|60|61|62|63|64|65|66|68)|74|30|(0)|57|(0)|60|61|62|63|64|65|66|68)|(14:26|29|30|(0)|57|(0)|60|61|62|63|64|65|66|68)|65|66|68)|62|63|64)|79|(0)|18|(0)(0)|21|22|23|24|74|30|(0)|57|(0)|60|61|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(4:(5:(22:15|(1:17)|18|(1:20)(1:78)|21|22|23|24|(13:29|30|(3:32|(7:35|36|37|38|39|40|33)|56)|57|(1:59)|60|61|62|63|64|65|66|68)|74|30|(0)|57|(0)|60|61|62|63|64|65|66|68)|(14:26|29|30|(0)|57|(0)|60|61|62|63|64|65|66|68)|65|66|68)|62|63|64) */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0239, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02b3, code lost:
    
        r2 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b4 A[Catch: Exception -> 0x023c, SocketException -> 0x0272, SSLException -> 0x0292, EOFException -> 0x02b2, TryCatch #2 {EOFException -> 0x02b2, blocks: (B:3:0x004b, B:6:0x0062, B:7:0x0087, B:10:0x009e, B:12:0x00a8, B:17:0x00b4, B:18:0x00d1, B:21:0x00e1, B:80:0x0098, B:81:0x0069, B:83:0x0075), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01c1 A[Catch: EOFException -> 0x0239, Exception -> 0x023c, SocketException -> 0x0272, SSLException -> 0x0292, TryCatch #4 {SSLException -> 0x0292, blocks: (B:3:0x004b, B:6:0x0062, B:7:0x0087, B:10:0x009e, B:12:0x00a8, B:17:0x00b4, B:18:0x00d1, B:21:0x00e1, B:24:0x00e5, B:26:0x0108, B:29:0x0115, B:30:0x0120, B:32:0x01c1, B:33:0x01c9, B:35:0x01cf, B:40:0x01ec, B:57:0x0204, B:59:0x0210, B:60:0x0214, B:74:0x011a, B:80:0x0098, B:81:0x0069, B:83:0x0075), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0210 A[Catch: EOFException -> 0x0239, Exception -> 0x023c, SocketException -> 0x0272, SSLException -> 0x0292, TryCatch #4 {SSLException -> 0x0292, blocks: (B:3:0x004b, B:6:0x0062, B:7:0x0087, B:10:0x009e, B:12:0x00a8, B:17:0x00b4, B:18:0x00d1, B:21:0x00e1, B:24:0x00e5, B:26:0x0108, B:29:0x0115, B:30:0x0120, B:32:0x01c1, B:33:0x01c9, B:35:0x01cf, B:40:0x01ec, B:57:0x0204, B:59:0x0210, B:60:0x0214, B:74:0x011a, B:80:0x0098, B:81:0x0069, B:83:0x0075), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00df  */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.kakaogame.session.websocket.WebSocketClient$Listener] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.kakaogame.session.websocket.WebSocketClient$Listener] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void connect$lambda$0(com.kakaogame.session.websocket.WebSocketClient r17) {
        /*
            Method dump skipped, instructions count: 720
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.session.websocket.WebSocketClient.connect$lambda$0(com.kakaogame.session.websocket.WebSocketClient):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void disconnect() {
        if (this.mSocket != null) {
            this.mHandler.post(new Runnable() { // from class: com.kakaogame.session.websocket.WebSocketClient$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    WebSocketClient.disconnect$lambda$1(WebSocketClient.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void disconnect$lambda$1(WebSocketClient webSocketClient) {
        String str = y.ٲٴݴ״ٰ(1782327224);
        Intrinsics.checkNotNullParameter(webSocketClient, y.ٴسسݬߨ(1393322442));
        Socket socket = webSocketClient.mSocket;
        if (socket != null) {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    Logger.INSTANCE.m699d(str, y.ۮڭڭܬި(862807899));
                    webSocketClient.mListener.onError(e);
                } catch (Exception e2) {
                    Logger.INSTANCE.m699d(str, y.ۮڭڭܬި(862807107));
                    webSocketClient.mListener.onError(e2);
                }
            }
            webSocketClient.mSocket = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void send(String data) {
        if (data != null) {
            sendFrame(this.mParser.frame(data));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void send(byte[] data) {
        if (data != null) {
            sendFrame(this.mParser.frame(data));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void ping() {
        sendFrame(this.mParser.framePing());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onMessage(String message) {
        this.mListener.onMessage(message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onMessage(byte[] data) {
        this.mListener.onMessage(data);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void checkResponse(InputStream inputStream, String secWebSocketKey) throws IOException, NoSuchAlgorithmException {
        String str = y.ٴسسݬߨ(1393114986);
        String str2 = y.ݮڮֲڭܩ(-628290772);
        String readLine = readLine(inputStream);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            String readLine2 = readLine(inputStream);
            Intrinsics.checkNotNull(readLine2);
            String str3 = readLine2;
            boolean z = str3 == null || str3.length() == 0;
            String str4 = y.ٲٴݴ״ٰ(1782327224);
            if (!z) {
                Logger.INSTANCE.m699d(str4, y.ݬֲ֮ܲت(1512051375) + readLine2);
                StringTokenizer stringTokenizer = new StringTokenizer(readLine2, y.ݬֲ֮ܲت(1512932847));
                if (stringTokenizer.countTokens() < 2) {
                    throw new RuntimeException(y.دײܮڳܯ(2051029957) + readLine2);
                }
                String nextToken = stringTokenizer.nextToken();
                String nextToken2 = stringTokenizer.nextToken();
                Intrinsics.checkNotNull(nextToken);
                Intrinsics.checkNotNull(nextToken2);
                linkedHashMap.put(nextToken, nextToken2);
            } else {
                Logger.INSTANCE.m699d(str4, y.ۮڭڭܬި(862802931) + readLine);
                String str5 = readLine;
                if (str5 == null || str5.length() == 0) {
                    throw new RuntimeException("Received no reply from server.");
                }
                StringTokenizer stringTokenizer2 = new StringTokenizer(readLine, y.دײܮڳܯ(2051829469));
                if (stringTokenizer2.countTokens() < 3) {
                    throw new RuntimeException(y.֬ڱܱײٮ(-1159108151) + readLine);
                }
                stringTokenizer2.nextToken();
                String nextToken3 = stringTokenizer2.nextToken();
                String nextToken4 = stringTokenizer2.nextToken();
                boolean areEqual = Intrinsics.areEqual(y.ٴسسݬߨ(1393113962), nextToken3);
                String str6 = y.ݮڮֲڭܩ(-628756788);
                if (!areEqual) {
                    throw new RuntimeException(y.ۮڭڭܬި(862802627) + nextToken3 + str6 + nextToken4);
                }
                Logger.INSTANCE.m699d(str4, y.ݮڮֲڭܩ(-628289780) + linkedHashMap);
                try {
                    if (!StringsKt.equals("websocket", (String) linkedHashMap.get(str), true)) {
                        Logger.INSTANCE.m708w(str4, "WebSocket Connect Response Header is wrong: Upgrade: websocket : " + linkedHashMap);
                    }
                } catch (Exception e) {
                    Logger.INSTANCE.m709w(str4, e.toString(), e);
                }
                try {
                    if (!StringsKt.equals(str, (String) linkedHashMap.get(HttpHeaders.CONNECTION), true)) {
                        Logger.INSTANCE.m708w(str4, "WebSocket Connect Response Header is wrong: Connection: Upgrade : " + linkedHashMap);
                    }
                } catch (Exception e2) {
                    Logger.INSTANCE.m709w(str4, e2.toString(), e2);
                }
                try {
                    String str7 = (String) linkedHashMap.get(HttpHeaders.SEC_WEBSOCKET_ACCEPT);
                    Charset forName = Charset.forName(CharEncoding.US_ASCII);
                    Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                    byte[] bytes = (secWebSocketKey + str2).getBytes(forName);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    messageDigest.update(bytes, 0, bytes.length);
                    String encodeToString = Base64.encodeToString(messageDigest.digest(), 0);
                    Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(...)");
                    String str8 = encodeToString;
                    int length = str8.length() - 1;
                    int i = 0;
                    boolean z2 = false;
                    while (i <= length) {
                        boolean z3 = Intrinsics.compare((int) str8.charAt(!z2 ? i : length), 32) <= 0;
                        if (z2) {
                            if (!z3) {
                                break;
                            } else {
                                length--;
                            }
                        } else if (z3) {
                            i++;
                        } else {
                            z2 = true;
                        }
                    }
                    String obj = str8.subSequence(i, length + 1).toString();
                    if (Intrinsics.areEqual(obj, str7)) {
                        return;
                    }
                    Logger.INSTANCE.m708w(str4, "WebSocket Connect Response Header is wrong: Sec-WebSocket-Accept : " + str7 + str6 + obj);
                    return;
                } catch (Exception e3) {
                    Logger.INSTANCE.m709w(str4, e3.toString(), e3);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String readLine(InputStream reader) throws IOException {
        int read = reader.read();
        if (read == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        while (read != 10) {
            if (read != 13) {
                sb.append((char) read);
            }
            read = reader.read();
            if (read == -1) {
                return null;
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String createSecret() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (Math.random() * 256);
        }
        String encodeToString = Base64.encodeToString(bArr, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, y.دײܮڳܯ(2051018429));
        String str = encodeToString;
        int length = str.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i2, length + 1).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendFrame(final byte[] frame) {
        this.mHandler.post(new Runnable() { // from class: com.kakaogame.session.websocket.WebSocketClient$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                WebSocketClient.sendFrame$lambda$8(WebSocketClient.this, frame);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void sendFrame$lambda$8(WebSocketClient webSocketClient, byte[] bArr) {
        Intrinsics.checkNotNullParameter(webSocketClient, y.ٴسسݬߨ(1393322442));
        try {
            synchronized (webSocketClient.mSendLock) {
                Socket socket = webSocketClient.mSocket;
                if (socket != null) {
                    Intrinsics.checkNotNull(socket);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                }
                Unit unit = Unit.INSTANCE;
            }
        } catch (IOException e) {
            webSocketClient.mListener.onError(e);
        } catch (NullPointerException unused) {
        } catch (Exception e2) {
            webSocketClient.mListener.onError(e2);
        }
    }
}
