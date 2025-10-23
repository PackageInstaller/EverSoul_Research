package com.facebook.messenger;

import com.google.common.net.HttpHeaders;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessengerThreadParams.kt */
@Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0011B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0012"}, m839d2 = {"Lcom/facebook/messenger/MessengerThreadParams;", "", "origin", "Lcom/facebook/messenger/MessengerThreadParams$Origin;", "threadToken", "", "metadata", "participants", "", "(Lcom/facebook/messenger/MessengerThreadParams$Origin;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getMetadata", "()Ljava/lang/String;", "getOrigin", "()Lcom/facebook/messenger/MessengerThreadParams$Origin;", "getParticipants", "()Ljava/util/List;", "getThreadToken", HttpHeaders.ORIGIN, "facebook-messenger_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class MessengerThreadParams {
    private final String metadata;
    private final Origin origin;
    private final List<String> participants;
    private final String threadToken;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MessengerThreadParams(Origin origin, String threadToken, String metadata, List<String> participants) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(threadToken, "threadToken");
        Intrinsics.checkNotNullParameter(metadata, "metadata");
        Intrinsics.checkNotNullParameter(participants, "participants");
        this.origin = origin;
        this.threadToken = threadToken;
        this.metadata = metadata;
        this.participants = participants;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Origin getOrigin() {
        return this.origin;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getThreadToken() {
        return this.threadToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMetadata() {
        return this.metadata;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List<String> getParticipants() {
        return this.participants;
    }

    /* compiled from: MessengerThreadParams.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/facebook/messenger/MessengerThreadParams$Origin;", "", "(Ljava/lang/String;I)V", "REPLY_FLOW", "COMPOSE_FLOW", "UNKNOWN", "facebook-messenger_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
    public enum Origin {
        REPLY_FLOW,
        COMPOSE_FLOW,
        UNKNOWN;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Origin[] valuesCustom() {
            Origin[] valuesCustom = values();
            return (Origin[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }
}
