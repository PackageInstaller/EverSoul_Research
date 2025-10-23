package com.kakao.sdk.friend.model;

import kotlin.Metadata;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

@Metadata(m837bv = {}, m838d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m839d2 = {"Lcom/kakao/sdk/friend/model/PickerChatFilter;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DIRECT", "MULTI", "REGULAR", "OPEN", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public enum PickerChatFilter {
    DIRECT("direct"),
    MULTI("multi"),
    REGULAR("regular"),
    OPEN(AbstractCircuitBreaker.PROPERTY_NAME);

    private final String value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PickerChatFilter(String str) {
        this.value = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValue() {
        return this.value;
    }
}
