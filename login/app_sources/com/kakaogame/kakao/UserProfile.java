package com.kakaogame.kakao;

import android.os.Parcel;
import com.kakao.sdk.partner.user.model.ForPartner;
import com.kakao.sdk.partner.user.model.PartnerAccount;
import com.kakao.sdk.partner.user.model.PartnerUser;
import com.kakao.sdk.user.Constants;
import com.kakao.sdk.user.model.Profile;
import com.kakaogame.idp.KGKakao2Auth;
import com.liapp.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserProfile.kt */
@Metadata(m838d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\b\u001a\u00020\tJ\b\u0010'\u001a\u00020\u000fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R>\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u00152\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001e\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000eR\"\u0010!\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\"\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012¨\u0006("}, m839d2 = {"Lcom/kakaogame/kakao/UserProfile;", "", "user", "Lcom/kakao/sdk/partner/user/model/PartnerUser;", "(Lcom/kakao/sdk/partner/user/model/PartnerUser;)V", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "hasSignedUp", "", "<set-?>", "", "id", "getId", "()J", "", "nickname", "getNickname", "()Ljava/lang/String;", "profileImagePath", "getProfileImagePath", "", Constants.PROPERTIES, "getProperties", "()Ljava/util/Map;", "", "remainingGroupMsgCount", "getRemainingGroupMsgCount", "()I", KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, "getRemainingInviteCount", KGKakao2Auth.KEY_SERVICE_USER_ID, "getServiceUserId", "thumbnailImagePath", "getThumbnailImagePath", "uuid", "getUuid", "getProperty", "propertyKey", "toString", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UserProfile {
    private boolean hasSignedUp;
    private long id;
    private String nickname;
    private String profileImagePath;
    private Map<String, String> properties;
    private int remainingGroupMsgCount;
    private int remainingInviteCount;
    private long serviceUserId;
    private String thumbnailImagePath;
    private String uuid;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, String> getProperties() {
        return this.properties;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getId() {
        return this.id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNickname() {
        return this.nickname;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getThumbnailImagePath() {
        return this.thumbnailImagePath;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileImagePath() {
        return this.profileImagePath;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUuid() {
        return this.uuid;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getServiceUserId() {
        return this.serviceUserId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRemainingInviteCount() {
        return this.remainingInviteCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRemainingGroupMsgCount() {
        return this.remainingGroupMsgCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserProfile(PartnerUser partnerUser) {
        Long serviceUserId;
        Intrinsics.checkNotNullParameter(partnerUser, y.٬ݯح׭٩(575756878));
        this.properties = new HashMap();
        this.hasSignedUp = true;
        Long id = partnerUser.getId();
        Intrinsics.checkNotNull(id);
        this.id = id.longValue();
        PartnerAccount kakaoAccount = partnerUser.getKakaoAccount();
        if (kakaoAccount != null) {
            if (kakaoAccount.getProfile() != null) {
                Profile profile = kakaoAccount.getProfile();
                Intrinsics.checkNotNull(profile);
                this.nickname = profile.getNickname();
                Profile profile2 = kakaoAccount.getProfile();
                Intrinsics.checkNotNull(profile2);
                this.thumbnailImagePath = profile2.getThumbnailImageUrl();
                Profile profile3 = kakaoAccount.getProfile();
                Intrinsics.checkNotNull(profile3);
                this.profileImagePath = profile3.getProfileImageUrl();
            }
            long j = 0;
            if (kakaoAccount.getServiceUserId() != null && (serviceUserId = kakaoAccount.getServiceUserId()) != null) {
                j = serviceUserId.longValue();
            }
            this.serviceUserId = j;
        }
        Boolean hasSignedUp = partnerUser.getHasSignedUp();
        if (hasSignedUp != null) {
            this.hasSignedUp = hasSignedUp.booleanValue();
        }
        ForPartner forPartner = partnerUser.getForPartner();
        if (forPartner != null) {
            String uuid = forPartner.getUuid();
            this.uuid = uuid == null ? "" : uuid;
            Integer remainingInviteCount = forPartner.getRemainingInviteCount();
            this.remainingInviteCount = remainingInviteCount != null ? remainingInviteCount.intValue() : 0;
            Integer remainingGroupMsgCount = forPartner.getRemainingGroupMsgCount();
            this.remainingGroupMsgCount = remainingGroupMsgCount != null ? remainingGroupMsgCount.intValue() : 0;
        }
        if (partnerUser.getProperties() != null) {
            this.properties = partnerUser.getProperties();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserProfile(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, y.֬ڱܱײٮ(-1158857455));
        this.properties = new HashMap();
        this.hasSignedUp = true;
        this.id = parcel.readLong();
        this.nickname = parcel.readString();
        this.thumbnailImagePath = parcel.readString();
        this.profileImagePath = parcel.readString();
        this.uuid = parcel.readString();
        this.serviceUserId = parcel.readLong();
        this.remainingInviteCount = parcel.readInt();
        this.remainingGroupMsgCount = parcel.readInt();
        this.hasSignedUp = parcel.readInt() == 1;
        Map<String, String> map = this.properties;
        Intrinsics.checkNotNull(map);
        parcel.readMap(map, getClass().getClassLoader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProperty(String propertyKey) {
        Map<String, String> map = this.properties;
        if (map == null) {
            return null;
        }
        Intrinsics.checkNotNull(map);
        return map.get(propertyKey);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasSignedUp() {
        return this.hasSignedUp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(y.٬ݯح׭٩(576477622));
        sb.append(this.nickname).append(y.ۮڭڭܬި(862713715));
        sb.append(this.thumbnailImagePath).append(y.ݬֲ֮ܲت(1512486039));
        sb.append(this.profileImagePath).append(y.دײܮڳܯ(2051448245));
        sb.append(this.uuid).append(y.دײܮڳܯ(2051447405));
        sb.append(this.serviceUserId).append(y.ݮڮֲڭܩ(-628380436));
        sb.append(this.remainingInviteCount).append(y.٬ݯح׭٩(576478630));
        sb.append(this.remainingGroupMsgCount).append(y.ۮڭڭܬި(862712651));
        sb.append(this.hasSignedUp).append(y.٬ݯح׭٩(576479038));
        sb.append(this.properties);
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, y.ٲٴݴ״ٰ(1781855688));
        return sb2;
    }
}
