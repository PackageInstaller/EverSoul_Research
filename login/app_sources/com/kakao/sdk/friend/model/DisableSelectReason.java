package com.kakao.sdk.friend.model;

import com.kakao.sdk.friend.C2110R;
import kotlin.Metadata;

@Metadata(m837bv = {}, m838d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, m839d2 = {"Lcom/kakao/sdk/friend/model/DisableSelectReason;", "", "", "resId", "I", "getResId", "()I", "<init>", "(Ljava/lang/String;II)V", "MSG_BLOCKED", "REGISTERED", "UNREGISTERED", "NOT_FRIEND", "CUSTOM", "friend_release"}, m840k = 1, m841mv = {1, 6, 0})
/* loaded from: classes3.dex */
public enum DisableSelectReason {
    MSG_BLOCKED(C2110R.string.reject_message),
    REGISTERED(C2110R.string.registered),
    UNREGISTERED(C2110R.string.unregistered),
    NOT_FRIEND(C2110R.string.not_talk_friend),
    CUSTOM(-1);

    private final int resId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DisableSelectReason(int i) {
        this.resId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getResId() {
        return this.resId;
    }
}
