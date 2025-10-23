package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: Semaphore.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
/* synthetic */ class SemaphoreImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, SemaphoreSegment, SemaphoreSegment> {
    public static final SemaphoreImpl$addAcquireToQueue$createNewSegment$1 INSTANCE = new SemaphoreImpl$addAcquireToQueue$createNewSegment$1();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SemaphoreImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ SemaphoreSegment invoke(Long l, SemaphoreSegment semaphoreSegment) {
        return invoke(l.longValue(), semaphoreSegment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SemaphoreSegment invoke(long j, SemaphoreSegment semaphoreSegment) {
        SemaphoreSegment createSegment;
        createSegment = SemaphoreKt.createSegment(j, semaphoreSegment);
        return createSegment;
    }
}
