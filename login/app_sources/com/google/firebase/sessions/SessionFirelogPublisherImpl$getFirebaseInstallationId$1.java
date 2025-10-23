package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SessionFirelogPublisher.kt */
@Metadata(m840k = 3, m841mv = {1, 7, 1}, m843xi = 48)
@DebugMetadata(m854c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", m855f = "SessionFirelogPublisher.kt", m856i = {}, m857l = {111}, m858m = "getFirebaseInstallationId", m859n = {}, m860s = {})
/* loaded from: classes2.dex */
final class SessionFirelogPublisherImpl$getFirebaseInstallationId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionFirelogPublisherImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SessionFirelogPublisherImpl$getFirebaseInstallationId$1(SessionFirelogPublisherImpl sessionFirelogPublisherImpl, Continuation<? super SessionFirelogPublisherImpl$getFirebaseInstallationId$1> continuation) {
        super(continuation);
        this.this$0 = sessionFirelogPublisherImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object firebaseInstallationId;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        firebaseInstallationId = this.this$0.getFirebaseInstallationId(this);
        return firebaseInstallationId;
    }
}
