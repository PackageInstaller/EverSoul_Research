package com.google.android.gms.tasks;

import com.facebook.login.LoginLogger;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static IllegalStateException m179of(Task<?> task) {
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        return new DuplicateTaskCompletionException("Complete with: ".concat(exception != null ? LoginLogger.EVENT_EXTRAS_FAILURE : task.isSuccessful() ? "result ".concat(String.valueOf(String.valueOf(task.getResult()))) : task.isCanceled() ? "cancellation" : "unknown issue"), exception);
    }
}
