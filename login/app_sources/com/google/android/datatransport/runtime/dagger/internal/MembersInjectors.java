package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.MembersInjector;

/* loaded from: classes.dex */
public final class MembersInjectors {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> MembersInjector<T> noOp() {
        return NoOpMembersInjector.INSTANCE;
    }

    private enum NoOpMembersInjector implements MembersInjector<Object> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.dagger.MembersInjector
        public void injectMembers(Object obj) {
            Preconditions.checkNotNull(obj, "Cannot inject members into a null reference");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MembersInjectors() {
    }
}
