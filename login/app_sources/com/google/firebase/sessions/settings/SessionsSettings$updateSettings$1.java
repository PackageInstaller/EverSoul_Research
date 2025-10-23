package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SessionsSettings.kt */
@Metadata(m840k = 3, m841mv = {1, 7, 1}, m843xi = 48)
@DebugMetadata(m854c = "com.google.firebase.sessions.settings.SessionsSettings", m855f = "SessionsSettings.kt", m856i = {0}, m857l = {138, 139}, m858m = "updateSettings", m859n = {"this"}, m860s = {"L$0"})
/* loaded from: classes2.dex */
final class SessionsSettings$updateSettings$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionsSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SessionsSettings$updateSettings$1(SessionsSettings sessionsSettings, Continuation<? super SessionsSettings$updateSettings$1> continuation) {
        super(continuation);
        this.this$0 = sessionsSettings;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateSettings(this);
    }
}
