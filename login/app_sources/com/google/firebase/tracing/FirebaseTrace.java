package com.google.firebase.tracing;

import android.os.Trace;

/* loaded from: classes2.dex */
public final class FirebaseTrace {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FirebaseTrace() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void pushTrace(String str) {
        Trace.beginSection(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void popTrace() {
        Trace.endSection();
    }
}
