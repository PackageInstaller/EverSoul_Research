package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: DebugProbesImpl.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper {
    private static final AtomicLongFieldUpdater sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper.class, "sequenceNumber");

    @Volatile
    private volatile long sequenceNumber;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
