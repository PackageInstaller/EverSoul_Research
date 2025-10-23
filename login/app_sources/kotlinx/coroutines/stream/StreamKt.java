package kotlinx.coroutines.stream;

import java.util.stream.Stream;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: Stream.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, m839d2 = {"consumeAsFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Ljava/util/stream/Stream;", "kotlinx-coroutines-core"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class StreamKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final <T> Flow<T> consumeAsFlow(Stream<T> stream) {
        return new StreamFlow(stream);
    }
}
