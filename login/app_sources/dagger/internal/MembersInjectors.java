package dagger.internal;

import com.liapp.y;
import dagger.MembersInjector;

/* loaded from: classes3.dex */
public final class MembersInjectors {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }

    private enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // dagger.MembersInjector
        public void injectMembers(Object obj) {
            Preconditions.checkNotNull(obj, y.٬ݯح׭٩(576304718));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MembersInjectors() {
    }
}
