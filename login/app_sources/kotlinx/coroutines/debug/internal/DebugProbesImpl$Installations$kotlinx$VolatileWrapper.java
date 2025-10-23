package kotlinx.coroutines.debug.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: DebugProbesImpl.kt */
@Metadata(m840k = 3, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DebugProbesImpl$Installations$kotlinx$VolatileWrapper {
    private static final AtomicIntegerFieldUpdater installations$FU = AtomicIntegerFieldUpdater.newUpdater(DebugProbesImpl$Installations$kotlinx$VolatileWrapper.class, "installations");

    @Volatile
    private volatile int installations;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DebugProbesImpl$Installations$kotlinx$VolatileWrapper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ DebugProbesImpl$Installations$kotlinx$VolatileWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
