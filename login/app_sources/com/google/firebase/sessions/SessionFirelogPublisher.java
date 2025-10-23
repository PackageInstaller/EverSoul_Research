package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import com.kakao.sdk.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionFirelogPublisher.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bà\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, m839d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisher;", "", "logSession", "", "sessionDetails", "Lcom/google/firebase/sessions/SessionDetails;", "Companion", "com.google.firebase-firebase-sessions"}, m840k = 1, m841mv = {1, 7, 1}, m843xi = 48)
/* loaded from: classes2.dex */
public interface SessionFirelogPublisher {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void logSession(SessionDetails sessionDetails);

    /* compiled from: SessionFirelogPublisher.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/google/firebase/sessions/SessionFirelogPublisher$Companion;", "", "()V", "instance", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/google/firebase/sessions/SessionFirelogPublisher;", "com.google.firebase-firebase-sessions"}, m840k = 1, m841mv = {1, 7, 1}, m843xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final SessionFirelogPublisher getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(SessionFirelogPublisher.class);
            Intrinsics.checkNotNullExpressionValue(obj, "Firebase.app[SessionFirelogPublisher::class.java]");
            return (SessionFirelogPublisher) obj;
        }
    }
}
