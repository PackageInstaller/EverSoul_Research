package okhttp3.internal.connection;

import com.singular.sdk.internal.Constants;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RouteException.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000e"}, m839d2 = {"Lokhttp3/internal/connection/RouteException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "firstConnectException", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "getFirstConnectException", "()Ljava/io/IOException;", "<set-?>", "lastConnectException", "getLastConnectException", "addConnectException", "", Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, "okhttp"}, m840k = 1, m841mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class RouteException extends RuntimeException {
    private final IOException firstConnectException;
    private IOException lastConnectException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IOException getFirstConnectException() {
        return this.firstConnectException;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RouteException(IOException firstConnectException) {
        super(firstConnectException);
        Intrinsics.checkNotNullParameter(firstConnectException, "firstConnectException");
        this.firstConnectException = firstConnectException;
        this.lastConnectException = firstConnectException;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IOException getLastConnectException() {
        return this.lastConnectException;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void addConnectException(IOException e) {
        Intrinsics.checkNotNullParameter(e, "e");
        ExceptionsKt.addSuppressed(this.firstConnectException, e);
        this.lastConnectException = e;
    }
}
