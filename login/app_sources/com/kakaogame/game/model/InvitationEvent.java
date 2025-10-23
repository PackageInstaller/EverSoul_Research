package com.kakaogame.game.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.game.StringSet;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: InvitationEvent.kt */
@Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0013\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0011HÖ\u0001J\t\u0010*\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000fR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000fR\u001e\u0010!\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010$¨\u0006+"}, m839d2 = {"Lcom/kakaogame/game/model/InvitationEvent;", "", SDKConstants.PARAM_A2U_BODY, "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getBody", "()Lorg/json/JSONObject;", StringSet.enabled, "", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "endsAt", "", "getEndsAt", "()Ljava/lang/String;", "id", "", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "invitationUrl", "getInvitationUrl", "setInvitationUrl", "(Ljava/lang/String;)V", "maxSenderRewardsCount", "getMaxSenderRewardsCount", "receiverReward", "getReceiverReward", "senderReward", "getSenderReward", "startsAt", "getStartsAt", "totalReceiversCount", "getTotalReceiversCount", "setTotalReceiversCount", "(Ljava/lang/Integer;)V", "component1", "copy", "equals", "other", "hashCode", "toString", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InvitationEvent {
    private final JSONObject body;
    private final Boolean enabled;
    private final String endsAt;
    private final Integer id;
    private String invitationUrl;
    private final Integer maxSenderRewardsCount;
    private final String receiverReward;
    private final String senderReward;
    private final String startsAt;
    private Integer totalReceiversCount;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ InvitationEvent copy$default(InvitationEvent invitationEvent, JSONObject jSONObject, int i, Object obj) {
        if ((i & 1) != 0) {
            jSONObject = invitationEvent.body;
        }
        return invitationEvent.copy(jSONObject);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject component1() {
        return this.body;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final InvitationEvent copy(JSONObject body) {
        Intrinsics.checkNotNullParameter(body, y.ۮڭڭܬި(862442651));
        return new InvitationEvent(body);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InvitationEvent) && Intrinsics.areEqual(this.body, ((InvitationEvent) other).body);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.body.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.٬ݯح׭٩(576624566) + this.body + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvitationEvent(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, y.ۮڭڭܬި(862442651));
        this.body = jSONObject;
        this.id = Integer.valueOf(jSONObject.optInt(y.ٲٴݴ״ٰ(1781792816)));
        this.enabled = Boolean.valueOf(jSONObject.optBoolean(y.ٲٴݴ״ٰ(1782073832)));
        this.startsAt = jSONObject.optString(y.ٲٴݴ״ٰ(1782073424), null);
        this.endsAt = jSONObject.optString(y.٬ݯح׭٩(576623534), null);
        this.maxSenderRewardsCount = Integer.valueOf(jSONObject.optInt(y.ݮڮֲڭܩ(-628530252)));
        this.senderReward = jSONObject.optString(y.ٲٴݴ״ٰ(1782075296), null);
        this.receiverReward = jSONObject.optString(y.ٴسسݬߨ(1393381746), null);
        String str = y.ٲٴݴ״ٰ(1782075040);
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        this.invitationUrl = optJSONObject != null ? optJSONObject.optString(y.ٲٴݴ״ٰ(1782074712), null) : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject(str);
        this.totalReceiversCount = optJSONObject2 != null ? Integer.valueOf(optJSONObject2.optInt(y.֬ڱܱײٮ(-1158869007))) : null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final JSONObject getBody() {
        return this.body;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getStartsAt() {
        return this.startsAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getEndsAt() {
        return this.endsAt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getMaxSenderRewardsCount() {
        return this.maxSenderRewardsCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getSenderReward() {
        return this.senderReward;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getReceiverReward() {
        return this.receiverReward;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getInvitationUrl() {
        return this.invitationUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setInvitationUrl(String str) {
        this.invitationUrl = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Integer getTotalReceiversCount() {
        return this.totalReceiversCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setTotalReceiversCount(Integer num) {
        this.totalReceiversCount = num;
    }
}
