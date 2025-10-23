package com.google.firebase.sessions.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FirebaseSessionsDependencies.kt */
@Metadata(m840k = 3, m841mv = {1, 7, 1}, m843xi = 48)
@DebugMetadata(m854c = "com.google.firebase.sessions.api.FirebaseSessionsDependencies", m855f = "FirebaseSessionsDependencies.kt", m856i = {0, 0, 0}, m857l = {124}, m858m = "getRegisteredSubscribers$com_google_firebase_firebase_sessions", m859n = {"destination$iv$iv", "subscriberName", "$this$withLock_u24default$iv"}, m860s = {"L$0", "L$2", "L$3"})
/* loaded from: classes2.dex */
final class FirebaseSessionsDependencies$getRegisteredSubscribers$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FirebaseSessionsDependencies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FirebaseSessionsDependencies$getRegisteredSubscribers$1(FirebaseSessionsDependencies firebaseSessionsDependencies, Continuation<? super FirebaseSessionsDependencies$getRegisteredSubscribers$1> continuation) {
        super(continuation);
        this.this$0 = firebaseSessionsDependencies;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getRegisteredSubscribers$com_google_firebase_firebase_sessions(this);
    }
}
