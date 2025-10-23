package com.kakaogame.game.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InvitationSender.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0015\u0010\nR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006\""}, m839d2 = {"Lcom/kakaogame/game/model/InvitationSender;", "", SDKConstants.PARAM_A2U_BODY, "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getBody", "()Lorg/json/JSONObject;", "invitationEventId", "", "getInvitationEventId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "invitationUrl", "", "getInvitationUrl", "()Ljava/lang/String;", "nickname", "getNickname", "profileImageUrl", "getProfileImageUrl", "totalReceiversCount", "getTotalReceiversCount", "userId", "", "getUserId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InvitationSender {
    private final JSONObject body;
    private final Integer invitationEventId;
    private final String invitationUrl;
    private final String nickname;
    private final String profileImageUrl;
    private final Integer totalReceiversCount;
    private final Long userId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ InvitationSender copy$default(InvitationSender invitationSender, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = invitationSender.body;
        }
        return invitationSender.copy(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject component1() {
        return this.body;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InvitationSender copy(JSONObject body) {
        Intrinsics.checkNotNullParameter(body, y.ۮڭڭܬި(862442651));
        return new InvitationSender(body);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InvitationSender) && Intrinsics.areEqual(this.body, ((InvitationSender) other).body);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.body.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.ݮڮֲڭܩ(-628451020) + this.body + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvitationSender(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, y.ۮڭڭܬި(862442651));
        this.body = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject(y.֬ڱܱײٮ(-1158745855));
        this.invitationEventId = optJSONObject != null ? Integer.valueOf(optJSONObject.optInt(y.ٲٴݴ״ٰ(1781792816))) : null;
        this.invitationUrl = jSONObject.optString(y.ٲٴݴ״ٰ(1782074712), null);
        this.userId = Long.valueOf(jSONObject.optLong(y.ݬֲ֮ܲت(1512773759)));
        this.profileImageUrl = jSONObject.optString(y.دײܮڳܯ(2051518141), null);
        this.nickname = jSONObject.optString(y.دײܮڳܯ(2051779213), null);
        this.totalReceiversCount = Integer.valueOf(jSONObject.optInt(y.֬ڱܱײٮ(-1158869007)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject getBody() {
        return this.body;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getInvitationEventId() {
        return this.invitationEventId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getInvitationUrl() {
        return this.invitationUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getTotalReceiversCount() {
        return this.totalReceiversCount;
    }
}
