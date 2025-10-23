package kotlinx.coroutines;

import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;

/* compiled from: Exceptions.common.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m839d2 = {"Lkotlinx/coroutines/CompletionHandlerException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", ServerConstants.CAUSE, "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CompletionHandlerException extends RuntimeException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CompletionHandlerException(String str, Throwable th) {
        super(str, th);
    }
}
