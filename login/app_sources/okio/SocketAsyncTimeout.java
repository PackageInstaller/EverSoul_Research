package okio;

import com.kakaogame.server.ServerConstants;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmOkio.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m839d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", ServerConstants.CAUSE, "timedOut", "", "okio"}, m840k = 1, m841mv = {1, 4, 0})
/* loaded from: classes2.dex */
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Socket socket;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SocketAsyncTimeout(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.socket = socket;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.AsyncTimeout
    protected IOException newTimeoutException(IOException cause) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (cause != null) {
            socketTimeoutException.initCause(cause);
        }
        return socketTimeoutException;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.AsyncTimeout
    protected void timedOut() {
        Logger logger;
        Logger logger2;
        try {
            this.socket.close();
        } catch (AssertionError e) {
            if (Okio.isAndroidGetsocknameError(e)) {
                logger2 = Okio__JvmOkioKt.logger;
                logger2.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e);
                return;
            }
            throw e;
        } catch (Exception e2) {
            logger = Okio__JvmOkioKt.logger;
            logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e2);
        }
    }
}
