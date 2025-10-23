package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: BufferedChannel.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class BufferedChannel$onSend$2 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onSend$2 INSTANCE = new BufferedChannel$onSend$2();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BufferedChannel$onSend$2() {
        super(3, BufferedChannel.class, "processResultSelectSend", "processResultSelectSend(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        Object processResultSelectSend;
        processResultSelectSend = bufferedChannel.processResultSelectSend(obj, obj2);
        return processResultSelectSend;
    }
}
