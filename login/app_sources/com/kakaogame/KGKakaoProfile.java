package com.kakaogame;

import android.app.Activity;
import android.widget.Toast;
import com.kakao.sdk.partner.talk.model.PartnerFriend;
import com.kakao.sdk.talk.Constants;
import com.kakao.sdk.talk.model.Friend;
import com.kakao.sdk.talk.model.Friends;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoProfile;
import com.kakaogame.KGResult;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.game.StringSet;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.kakao.KakaoAgeAuthManager;
import com.kakaogame.kakao.KakaoGameAPI;
import com.kakaogame.kakao.KakaoManager;
import com.kakaogame.kakao.KakaoUtil;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakaoProfile.kt */
@Metadata(m838d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 <2\u00020\u0001:\u0002<=B\u001f\b\u0016\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006B%\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u000f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\r¢\u0006\u0002\u0010\u000eB\u0011\b\u0016\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B%\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0015B5\b\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0002\u0010\u0019J\u001c\u00109\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010;0:H\u0016R\u0014\u0010\u001a\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0011\u0010!\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\"R\u0011\u0010#\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b#\u0010\"R\u0011\u0010\u0018\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\"R\u0013\u0010$\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b%\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0013\u0010'\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u0011\u0010)\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0011\u0010.\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0013\u00100\u001a\u0004\u0018\u0001018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b5\u0010\u001cR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b6\u0010\u001cR\u0013\u00107\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b8\u0010\u001c¨\u0006>"}, m839d2 = {"Lcom/kakaogame/KGKakaoProfile;", "Lcom/kakaogame/KGIdpProfile;", "content", "", "", "", "(Ljava/util/Map;)V", "version", "", "(ILjava/util/Map;)V", Constants.FRIEND, "Lcom/kakao/sdk/talk/model/Friend;", "(Lcom/kakao/sdk/talk/model/Friend;)V", "Lcom/kakao/sdk/partner/talk/model/PartnerFriend;", "(Lcom/kakao/sdk/partner/talk/model/PartnerFriend;)V", "obj", "Lcom/kakaogame/util/json/JSONObject;", "(Lcom/kakaogame/util/json/JSONObject;)V", "userId", "nickname", KGKakao2Auth.KEY_THUMBNAIL_IMAGE_URL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", KGKakao2Auth.KEY_APP_REGISTERED, "", KGKakao2Auth.KEY_UNREGISTERED, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "accountType", "getAccountType", "()Ljava/lang/String;", "cI", "getCI", KGKakao2Auth.KEY_IMPRESSION_ID, "getImpressionId", KGKakao2Auth.KEY_ALLOW_MSG, "()Z", KGKakao2Auth.KEY_RECOMMENDED, "memberKey", "getMemberKey", "getNickname", "profileImageUrl", "getProfileImageUrl", KGKakao2Auth.KEY_RECOMMEND_RANK, "getRecommendRank", "()I", KGKakao2Auth.KEY_REMAINING_GROUP_MSG_COUNT, "getRemainingGroupMessageCount", KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, "getRemainingInviteCount", KGKakao2Auth.KEY_SERVICE_USER_ID, "", "getServiceUserId", "()Ljava/lang/Long;", "talkOs", "getTalkOs", "getThumbnailImageUrl", "uUID", "getUUID", "loadFriendProfiles", "Lcom/kakaogame/KGResult;", "", "Companion", "KGKakaoFriendsResponse", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakaoProfile extends KGIdpProfile {
    private static final String CLASS_NAME_KEY = "KGKakaoProfile";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "KGKakaoProfile";
    private static final long serialVersionUID = -2875654182578894278L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void checkTalkUser(KGResultCallback<Boolean> kGResultCallback) {
        INSTANCE.checkTalkUser(kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initialize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void loadInvitableFriendProfiles(int i, int i2, int i3, KGResultCallback<KGKakaoFriendsResponse> kGResultCallback) {
        INSTANCE.loadInvitableFriendProfiles(i, i2, i3, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = " 현재 앱을 플레이한 적이 없는 카카오 친구들의 프로필 정보 목록을 조회한다.(이름 순으로 소팅)")
    @JvmStatic
    public static final void loadInvitableFriendProfiles(int i, int i2, KGResultCallback<KGKakaoFriendsResponse> kGResultCallback) {
        INSTANCE.loadInvitableFriendProfiles(i, i2, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "현재 앱을 플레이한 적이 없는 카카오 친구들의 프로필 정보 목록을 조회한다.(추천순으로 소팅)")
    @JvmStatic
    public static final void loadRecommendedInvitableFriendProfiles(int i, int i2, KGResultCallback<KGKakaoFriendsResponse> kGResultCallback) {
        INSTANCE.loadRecommendedInvitableFriendProfiles(i, i2, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void requestAgeVerification(Activity activity, KGResultCallback<Void> kGResultCallback) {
        INSTANCE.requestAgeVerification(activity, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoProfile(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoProfile(int i, Map<String, Object> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, y.֬ڱܱײٮ(-1159406207));
        if (i == 4) {
            put(y.دײܮڳܯ(2051787797), map.get("talkOs"));
            put(y.ٴسسݬߨ(1392692882), map.get("allowedMsg"));
            put(y.ݬֲ֮ܲت(1512826055), map.get("profileThumbnailImage"));
            put(y.دײܮڳܯ(2051779213), map.get("profileNickname"));
            put(y.ٴسسݬߨ(1392693162), map.get("appRegistered"));
            put(KGKakao2Auth.KEY_UNREGISTERED, false);
            boolean containsKey = map.containsKey(StringSet.recommended);
            String str = y.ٴسسݬߨ(1392691234);
            if (containsKey) {
                Number number = (Number) map.get(StringSet.recommended);
                if ((number != null ? number.intValue() : 0) == 1) {
                    put(str, true);
                    return;
                } else {
                    put(str, false);
                    return;
                }
            }
            put(str, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoProfile(Friend friend) {
        super(new LinkedHashMap());
        String l;
        Intrinsics.checkNotNullParameter(friend, y.֬ڱܱײٮ(-1159555639));
        put(y.دײܮڳܯ(2051564517), y.֬ڱܱײٮ(-1159645087));
        Long id = friend.getId();
        put(y.ݮڮֲڭܩ(-628796020), (id == null || (l = id.toString()) == null) ? y.دײܮڳܯ(2051900013) : l);
        put(y.ٴسسݬߨ(1392679994), friend.getUuid());
        put(y.ۮڭڭܬި(862363651), friend.getServiceUserId());
        put(y.دײܮڳܯ(2051779213), friend.getProfileNickname());
        put(y.ݬֲ֮ܲت(1512826055), friend.getProfileThumbnailImage());
        put(y.ٴسسݬߨ(1392693162), true);
        put(y.ٴسسݬߨ(1392692882), friend.getAllowedMsg());
        put(KGKakao2Auth.KEY_TALK_OS, "");
        put(KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, 0);
        put(KGKakao2Auth.KEY_REMAINING_GROUP_MSG_COUNT, 0);
        put(KGKakao2Auth.KEY_RECOMMENDED, false);
        put(KGKakao2Auth.KEY_IMPRESSION_ID, "");
        put(KGKakao2Auth.KEY_UNREGISTERED, false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoProfile(PartnerFriend partnerFriend) {
        super(new LinkedHashMap());
        String l;
        Intrinsics.checkNotNullParameter(partnerFriend, y.֬ڱܱײٮ(-1159555639));
        put(y.دײܮڳܯ(2051564517), y.֬ڱܱײٮ(-1159645087));
        Long id = partnerFriend.getId();
        put(y.ݮڮֲڭܩ(-628796020), (id == null || (l = id.toString()) == null) ? y.دײܮڳܯ(2051900013) : l);
        put(y.ٴسسݬߨ(1392679994), partnerFriend.getUuid());
        put(y.ۮڭڭܬި(862363651), partnerFriend.getServiceUserId());
        put(y.دײܮڳܯ(2051779213), partnerFriend.getProfileNickname());
        put(y.ݬֲ֮ܲت(1512826055), partnerFriend.getProfileThumbnailImage());
        put(y.ٴسسݬߨ(1392693162), partnerFriend.getAppRegistered());
        put(y.ٴسسݬߨ(1392692882), partnerFriend.getAllowedMsg());
        put(y.دײܮڳܯ(2051787797), partnerFriend.getTalkOs());
        put(KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, 0);
        put(KGKakao2Auth.KEY_REMAINING_GROUP_MSG_COUNT, 0);
        put(KGKakao2Auth.KEY_RECOMMENDED, false);
        put(KGKakao2Auth.KEY_IMPRESSION_ID, "");
        put(KGKakao2Auth.KEY_UNREGISTERED, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoProfile(JSONObject jSONObject) {
        super(new LinkedHashMap());
        if (jSONObject != null) {
            put(y.دײܮڳܯ(2051564517), y.֬ڱܱײٮ(-1159645087));
            String str = y.ٴسسݬߨ(1392679994);
            put(str, jSONObject.get((Object) str));
            put(y.دײܮڳܯ(2051779213), jSONObject.get((Object) y.دײܮڳܯ(2051787741)));
            put(y.ݬֲ֮ܲت(1512826055), jSONObject.get((Object) y.٬ݯح׭٩(575737358)));
            put(y.ٴسسݬߨ(1392693162), jSONObject.get((Object) y.دײܮڳܯ(2051787125)));
            put(y.ٴسسݬߨ(1392692882), jSONObject.get((Object) y.ٲٴݴ״ٰ(1782043792)));
            put(y.دײܮڳܯ(2051787797), jSONObject.get((Object) y.֬ڱܱײٮ(-1159555375)));
            put(y.دײܮڳܯ(2051786309), 0);
            put(y.ٴسسݬߨ(1392690362), 0);
            String str2 = y.ٲٴݴ״ٰ(1782045392);
            boolean containsKey = jSONObject.containsKey((Object) str2);
            String str3 = y.ۮڭڭܬި(862363651);
            if (containsKey) {
                put(str3, jSONObject.get((Object) str2));
            } else {
                put(str3, 0L);
            }
            String str4 = y.ٲٴݴ״ٰ(1781792816);
            boolean containsKey2 = jSONObject.containsKey((Object) str4);
            String str5 = y.ݮڮֲڭܩ(-628796020);
            if (containsKey2) {
                put(str5, jSONObject.get((Object) str4));
            } else {
                put(str5, y.دײܮڳܯ(2051900013));
            }
            String str6 = y.ٲٴݴ״ٰ(1782045016);
            boolean containsKey3 = jSONObject.containsKey((Object) str6);
            String str7 = y.ٴسسݬߨ(1392691234);
            if (containsKey3) {
                Number number = (Number) jSONObject.get((Object) str6);
                Intrinsics.checkNotNull(number);
                put(str7, Boolean.valueOf(number.intValue() == 1));
            } else {
                put(str7, false);
            }
            String str8 = y.ݬֲ֮ܲت(1512828207);
            boolean containsKey4 = jSONObject.containsKey((Object) str8);
            String str9 = y.ٲٴݴ״ٰ(1782044728);
            if (containsKey4) {
                put(str9, jSONObject.get((Object) str8));
            } else {
                put(str9, "");
            }
            put(KGKakao2Auth.KEY_UNREGISTERED, false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoProfile(String str, String str2, String str3) {
        super(new LinkedHashMap());
        put(y.دײܮڳܯ(2051564517), y.֬ڱܱײٮ(-1159645087));
        put(y.ݮڮֲڭܩ(-628796020), str);
        put("uuid", "");
        put(y.ۮڭڭܬި(862363651), 0L);
        put("nickname", str2);
        put(KGKakao2Auth.KEY_THUMBNAIL_IMAGE_URL, str3);
        put(KGKakao2Auth.KEY_APP_REGISTERED, true);
        put(y.ݮڮֲڭܩ(-628689972), false);
        put(y.ٴسسݬߨ(1392692882), true);
        put(KGKakao2Auth.KEY_TALK_OS, "");
        put(KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, 0);
        put(KGKakao2Auth.KEY_REMAINING_GROUP_MSG_COUNT, 0);
        put(KGKakao2Auth.KEY_RECOMMENDED, false);
        put(KGKakao2Auth.KEY_IMPRESSION_ID, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KGKakaoProfile(String str, String str2, String str3, boolean z, boolean z2) {
        super(new LinkedHashMap());
        put(y.دײܮڳܯ(2051564517), y.֬ڱܱײٮ(-1159645087));
        put(y.ݮڮֲڭܩ(-628796020), str);
        put("uuid", "");
        put(y.ۮڭڭܬި(862363651), 0L);
        put("nickname", str2);
        put(KGKakao2Auth.KEY_THUMBNAIL_IMAGE_URL, str3);
        put(KGKakao2Auth.KEY_APP_REGISTERED, Boolean.valueOf(z));
        put(KGKakao2Auth.KEY_UNREGISTERED, Boolean.valueOf(z2));
        put(KGKakao2Auth.KEY_ALLOW_MSG, true);
        put(KGKakao2Auth.KEY_TALK_OS, "");
        put(KGKakao2Auth.KEY_REMAINING_INVITE_COUNT, 0);
        put(KGKakao2Auth.KEY_REMAINING_GROUP_MSG_COUNT, 0);
        put(KGKakao2Auth.KEY_RECOMMENDED, false);
        put(KGKakao2Auth.KEY_IMPRESSION_ID, "");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGIdpProfile
    public KGResult<Map<String, KGIdpProfile>> loadFriendProfiles() {
        if (KakaoManager.isTalkUser()) {
            return KGKakao2Auth.INSTANCE.loadKakaoFriendProfiles();
        }
        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, y.ۮڭڭܬި(862270011));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Long getServiceUserId() {
        String str = y.ۮڭڭܬި(862363651);
        if (containsKey(str)) {
            return (Long) get(str);
        }
        return 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getNickname() {
        return (String) get(y.دײܮڳܯ(2051779213));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getThumbnailImageUrl() {
        return (String) get(y.ݬֲ֮ܲت(1512826055));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getProfileImageUrl() {
        return (String) get(y.٬ݯح׭٩(575735166));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCI() {
        return (String) get(y.ۮڭڭܬި(862366179));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAppRegistered() {
        String str = y.ٴسسݬߨ(1392693162);
        if (!containsKey(str)) {
            return false;
        }
        Object obj = get(str);
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782032576));
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isUnregistered() {
        String str = y.ݮڮֲڭܩ(-628689972);
        if (!containsKey(str)) {
            return false;
        }
        Object obj = get(str);
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782032576));
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAllowedMessage() {
        String str = y.ٴسسݬߨ(1392692882);
        if (!containsKey(str)) {
            return false;
        }
        Object obj = get(str);
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782032576));
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getTalkOs() {
        return (String) get(y.دײܮڳܯ(2051787797));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRemainingInviteCount() {
        String str = y.دײܮڳܯ(2051786309);
        if (!containsKey(str)) {
            return 0;
        }
        Object obj = get(str);
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRemainingGroupMessageCount() {
        String str = y.ٴسسݬߨ(1392690362);
        if (!containsKey(str)) {
            return 0;
        }
        Object obj = get(str);
        Intrinsics.checkNotNull(obj, y.ۮڭڭܬި(862379403));
        return ((Integer) obj).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isRecommended() {
        String str = y.ٴسسݬߨ(1392691234);
        if (!containsKey(str)) {
            return false;
        }
        Object obj = get(str);
        Intrinsics.checkNotNull(obj, y.ٲٴݴ״ٰ(1782032576));
        return ((Boolean) obj).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getRecommendRank() {
        String str = y.ۮڭڭܬި(862365923);
        if (!containsKey(str)) {
            return -1;
        }
        Number number = (Number) get(str);
        Intrinsics.checkNotNull(number);
        return number.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getImpressionId() {
        return (String) get(y.ٲٴݴ״ٰ(1782044728));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getUUID() {
        return (String) get(y.ٴسسݬߨ(1392679994));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMemberKey() {
        return (String) get(y.ٲٴݴ״ٰ(1782046688));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGIdpProfile
    public String getAccountType() {
        return KakaoManager.isTalkUser() ? y.ٴسسݬߨ(1392689218) : y.ۮڭڭܬި(862366043);
    }

    /* compiled from: KGKakaoProfile.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/KGKakaoProfile$KGKakaoFriendsResponse;", "", "totalCount", "", "friendList", "", "Lcom/kakaogame/KGKakaoProfile;", "(ILjava/util/List;)V", "getFriendList", "()Ljava/util/List;", "getTotalCount", "()I", "Companion", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGKakaoFriendsResponse {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<KGKakaoProfile> friendList;
        private final int totalCount;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public KGKakaoFriendsResponse(int i, List<KGKakaoProfile> list) {
            Intrinsics.checkNotNullParameter(list, y.֬ڱܱײٮ(-1159556295));
            this.totalCount = i;
            this.friendList = list;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTotalCount() {
            return this.totalCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final List<KGKakaoProfile> getFriendList() {
            return this.friendList;
        }

        /* compiled from: KGKakaoProfile.kt */
        @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGKakaoProfile$KGKakaoFriendsResponse$Companion;", "", "()V", "emptyResponse", "Lcom/kakaogame/KGKakaoProfile$KGKakaoFriendsResponse;", "getEmptyResponse", "()Lcom/kakaogame/KGKakaoProfile$KGKakaoFriendsResponse;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private final KGKakaoFriendsResponse getEmptyResponse() {
                return new KGKakaoFriendsResponse(0, new ArrayList());
            }
        }
    }

    /* compiled from: KGKakaoProfile.kt */
    @Metadata(m838d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0007J \u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J*\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000bH\u0007J2\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000bH\u0007J*\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u000bH\u0007J\"\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u000bH\u0007J*\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m839d2 = {"Lcom/kakaogame/KGKakaoProfile$Companion;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "serialVersionUID", "", "checkTalkUser", "", "callback", "Lcom/kakaogame/KGResultCallback;", "", "initInterfaceBroker", "initialize", "loadInvitableFriendProfiles", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/KGKakaoProfile$KGKakaoFriendsResponse;", "offset", "", "limit", ServerConstants.RECOMMEND_LIMIT, "loadRecommendedInvitableFriendProfiles", "requestAgeVerification", "activity", "Landroid/app/Activity;", "Ljava/lang/Void;", "requestInvitableFriendProfiles", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void initialize() {
            initInterfaceBroker();
            KGKakaoTalkGroupChat.INSTANCE.initialize();
            KGKakaoTalkMessage.INSTANCE.initialize();
            KGKakaoInvitationEvent.INSTANCE.initialize();
            KGKakaoInvitationHost.INSTANCE.initialize();
            KGKakaoInvitationJoiner.INSTANCE.initialize();
            KGKakaoInvitation.INSTANCE.initialize();
            KGKakaoTalk.INSTANCE.initialize();
            KGKakaoGuildChat.INSTANCE.initialize();
            KGKakaoPicker.INSTANCE.initialize();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void checkTalkUser(KGResultCallback<Boolean> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoProfile$Companion$checkTalkUser$1(callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void requestAgeVerification(Activity activity, KGResultCallback<Void> callback) {
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoProfile$Companion$requestAgeVerification$1(activity, callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated(message = " 현재 앱을 플레이한 적이 없는 카카오 친구들의 프로필 정보 목록을 조회한다.(이름 순으로 소팅)")
        @JvmStatic
        public final void loadInvitableFriendProfiles(int offset, int limit, KGResultCallback<KGKakaoFriendsResponse> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoProfile$Companion$loadInvitableFriendProfiles$1(offset, limit, callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Deprecated(message = "현재 앱을 플레이한 적이 없는 카카오 친구들의 프로필 정보 목록을 조회한다.(추천순으로 소팅)")
        @JvmStatic
        public final void loadRecommendedInvitableFriendProfiles(int offset, int limit, KGResultCallback<KGKakaoFriendsResponse> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C2300xbb986f30(offset, limit, callback, null), 3, null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void loadInvitableFriendProfiles(int recommendLimit, int offset, int limit, KGResultCallback<KGKakaoFriendsResponse> callback) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGKakaoProfile$Companion$loadInvitableFriendProfiles$2(recommendLimit, offset, limit, callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<KGKakaoFriendsResponse> loadInvitableFriendProfiles(int offset, int limit) {
            KGResult<KGKakaoFriendsResponse> result;
            ArrayList emptyList;
            String str = y.٬ݯح׭٩(575746614);
            String str2 = y.ۮڭڭܬި(862363619);
            Logger logger = Logger.INSTANCE;
            String str3 = y.ٲٴݴ״ٰ(1782048912) + offset + y.ݮڮֲڭܩ(-628756788) + limit;
            String str4 = y.٬ݯح׭٩(575748342);
            logger.m699d(str4, str3);
            Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159549631));
            KGResult<KGKakaoFriendsResponse> kGResult = null;
            try {
                try {
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str4, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                }
                if (CoreManager.INSTANCE.getInstance().isKakaoCacheMode() && !CoreManager.INSTANCE.getInstance().tryKakaoReConnect().isSuccess()) {
                    final Activity activity = CoreManager.INSTANCE.getInstance().getActivity();
                    activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.KGKakaoProfile$Companion$$ExternalSyntheticLambda0
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            KGKakaoProfile.Companion.loadInvitableFriendProfiles$lambda$0(activity);
                        }
                    });
                    KGResult<KGKakaoFriendsResponse> successResult = KGResult.INSTANCE.getSuccessResult(new KGKakaoFriendsResponse(0, CollectionsKt.emptyList()));
                    start.stop();
                    KakaoUtil.convertResultCode(successResult);
                    KGResultUtil.writeClientApiCall(start.getName(), successResult, start.getDurationMs());
                    return successResult;
                }
                if (offset < 0) {
                    result = KGResult.INSTANCE.getResult(4000, str2 + offset);
                } else if (limit <= 0) {
                    result = KGResult.INSTANCE.getResult(4000, str + limit);
                } else if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    result = KGResult.INSTANCE.getResult(3002);
                } else if (KakaoManager.INSTANCE.isNotTalkUser()) {
                    result = KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, "onNotKakaoTalkUser");
                } else {
                    KGResult<Friends<PartnerFriend>> requestInvitableFriends = KakaoGameAPI.INSTANCE.requestInvitableFriends(offset, limit);
                    if (requestInvitableFriends.isNotSuccess()) {
                        KGResult<KGKakaoFriendsResponse> result2 = KGResult.INSTANCE.getResult(requestInvitableFriends);
                        start.stop();
                        KakaoUtil.convertResultCode(null);
                        KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                        return result2;
                    }
                    Friends<PartnerFriend> content = requestInvitableFriends.getContent();
                    Intrinsics.checkNotNull(content);
                    Friends<PartnerFriend> friends = content;
                    int component1 = friends.component1();
                    List<PartnerFriend> component2 = friends.component2();
                    if (component2 != null) {
                        List<PartnerFriend> list = component2;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new KGKakaoProfile((PartnerFriend) it.next()));
                        }
                        emptyList = arrayList;
                    } else {
                        emptyList = CollectionsKt.emptyList();
                    }
                    kGResult = KGResult.INSTANCE.getSuccessResult(new KGKakaoFriendsResponse(component1, emptyList));
                    result = kGResult;
                }
                start.stop();
                KakaoUtil.convertResultCode(kGResult);
                KGResultUtil.writeClientApiCall(start.getName(), kGResult, start.getDurationMs());
                return result;
            } catch (Throwable th) {
                start.stop();
                KakaoUtil.convertResultCode(null);
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void loadInvitableFriendProfiles$lambda$0(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
            Activity activity2 = activity;
            Toast makeText = Toast.makeText(activity2, ResourceUtil.getString(activity2, y.ݮڮֲڭܩ(-628701596)), 1);
            makeText.setGravity(81, 0, 0);
            y.٬خݮ۳ݯ();
            makeText.show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<KGKakaoFriendsResponse> requestInvitableFriendProfiles(int recommendLimit, int offset, int limit) {
            KGResult<KGKakaoFriendsResponse> result;
            KGIdpProfile idpProfile;
            KGIdpProfile idpProfile2;
            String str = y.ٲٴݴ״ٰ(1782036808);
            String str2 = y.٬ݯح׭٩(575746614);
            String str3 = y.ۮڭڭܬި(862363619);
            Logger logger = Logger.INSTANCE;
            String str4 = y.ٴسسݬߨ(1392702242) + recommendLimit + ':' + offset + y.ݮڮֲڭܩ(-628756788) + limit;
            String str5 = y.٬ݯح׭٩(575748342);
            logger.m699d(str5, str4);
            Stopwatch start = Stopwatch.INSTANCE.start(y.ݮڮֲڭܩ(-628688676));
            try {
                try {
                    if (offset < 0) {
                        result = KGResult.INSTANCE.getResult(4000, str3 + offset);
                    } else if (limit <= 0) {
                        result = KGResult.INSTANCE.getResult(4000, str2 + limit);
                    } else if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                        result = KGResult.INSTANCE.getResult(3002);
                    } else {
                        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Kakao;
                        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                        if (kGIdpCode != ((currentPlayer == null || (idpProfile2 = currentPlayer.getIdpProfile()) == null) ? null : idpProfile2.getIdpCode())) {
                            KGResult.Companion companion = KGResult.INSTANCE;
                            StringBuilder sb = new StringBuilder(str);
                            KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                            result = companion.getResult(5001, sb.append((currentPlayer2 == null || (idpProfile = currentPlayer2.getIdpProfile()) == null) ? null : idpProfile.getIdpCode()).toString());
                        } else {
                            result = KakaoManager.INSTANCE.isNotTalkUser() ? KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_KAKAOTALK_USER, "onNotKakaoTalkUser") : KakaoGameAPI.INSTANCE.requestRecommendedInvitableFriends(recommendLimit, offset, limit);
                        }
                    }
                    start.stop();
                    KGResultUtil.writeClientApiCall(start.getName(), result, start.getDurationMs());
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(str5, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                    start.stop();
                    KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                }
                return result;
            } catch (Throwable th) {
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
                throw th;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628700076), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoProfile$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    KGResult<Boolean> checkTalkUser = KakaoManager.INSTANCE.checkTalkUser();
                    FirebaseEvent.INSTANCE.sendEvent(y.٬ݯح׭٩(575748342), y.ٴسسݬߨ(1392704530), checkTalkUser);
                    if (!checkTalkUser.isSuccess()) {
                        return KGResult.INSTANCE.getResult(checkTalkUser);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Boolean content = checkTalkUser.getContent();
                    Intrinsics.checkNotNull(content);
                    linkedHashMap.put(y.ٴسسݬߨ(1392704794), content);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392703866), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoProfile$Companion$initInterfaceBroker$2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                    KGResult<String> checkAgeAuth = KakaoAgeAuthManager.INSTANCE.checkAgeAuth(activity, false);
                    FirebaseEvent.INSTANCE.sendEvent(y.٬ݯح׭٩(575748342), y.دײܮڳܯ(2051801045), checkAgeAuth);
                    if (!checkAgeAuth.isSuccess()) {
                        return KGResult.INSTANCE.getResult(checkAgeAuth);
                    }
                    return KGResult.INSTANCE.getSuccessResult();
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862360507), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoProfile$Companion$initInterfaceBroker$3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    int i;
                    KGResult requestInvitableFriendProfiles;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Object parameter = request.getParameter("offset");
                    String str = y.ٲٴݴ״ٰ(1782047088);
                    Intrinsics.checkNotNull(parameter, str);
                    int intValue = ((Number) parameter).intValue();
                    Object parameter2 = request.getParameter(y.ݮڮֲڭܩ(-628790308));
                    Intrinsics.checkNotNull(parameter2, str);
                    int intValue2 = ((Number) parameter2).intValue();
                    String str2 = y.֬ڱܱײٮ(-1159658759);
                    if (request.containsParameterKey(str2)) {
                        Object parameter3 = request.getParameter(str2);
                        Intrinsics.checkNotNull(parameter3, str);
                        i = ((Number) parameter3).intValue();
                    } else {
                        i = -1;
                    }
                    requestInvitableFriendProfiles = KGKakaoProfile.INSTANCE.requestInvitableFriendProfiles(i, intValue, intValue2);
                    Intrinsics.checkNotNull(requestInvitableFriendProfiles);
                    if (!requestInvitableFriendProfiles.isSuccess()) {
                        return KGResult.INSTANCE.getResult(requestInvitableFriendProfiles);
                    }
                    Object content = requestInvitableFriendProfiles.getContent();
                    Intrinsics.checkNotNull(content);
                    KGKakaoProfile.KGKakaoFriendsResponse kGKakaoFriendsResponse = (KGKakaoProfile.KGKakaoFriendsResponse) content;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ۮڭڭܬި(862269467), Integer.valueOf(kGKakaoFriendsResponse.getTotalCount()));
                    linkedHashMap.put(y.ٴسسݬߨ(1392597458), kGKakaoFriendsResponse.getFriendList());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
            InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512824815), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGKakaoProfile$Companion$initInterfaceBroker$4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> loadInvitableFriendProfiles;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, "request");
                    Object parameter = request.getParameter("offset");
                    String str = y.ٲٴݴ״ٰ(1782047088);
                    Intrinsics.checkNotNull(parameter, str);
                    int intValue = ((Number) parameter).intValue();
                    Object parameter2 = request.getParameter(y.ݮڮֲڭܩ(-628790308));
                    Intrinsics.checkNotNull(parameter2, str);
                    int intValue2 = ((Number) parameter2).intValue();
                    String str2 = y.֬ڱܱײٮ(-1159658759);
                    if (!request.containsParameterKey(str2)) {
                        loadInvitableFriendProfiles = KGKakaoProfile.INSTANCE.loadInvitableFriendProfiles(intValue, intValue2);
                    } else {
                        Object parameter3 = request.getParameter(str2);
                        Intrinsics.checkNotNull(parameter3, str);
                        loadInvitableFriendProfiles = KGKakaoProfile.INSTANCE.requestInvitableFriendProfiles(((Number) parameter3).intValue(), intValue, intValue2);
                        FirebaseEvent.INSTANCE.sendEvent(y.٬ݯح׭٩(575748342), y.ݬֲ֮ܲت(1512600543), loadInvitableFriendProfiles);
                    }
                    Intrinsics.checkNotNull(loadInvitableFriendProfiles);
                    if (!loadInvitableFriendProfiles.isSuccess()) {
                        return KGResult.INSTANCE.getResult(loadInvitableFriendProfiles);
                    }
                    Object content = loadInvitableFriendProfiles.getContent();
                    Intrinsics.checkNotNull(content);
                    KGKakaoProfile.KGKakaoFriendsResponse kGKakaoFriendsResponse = (KGKakaoProfile.KGKakaoFriendsResponse) content;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ۮڭڭܬި(862269467), Integer.valueOf(kGKakaoFriendsResponse.getTotalCount()));
                    linkedHashMap.put(y.ٴسسݬߨ(1392597458), kGKakaoFriendsResponse.getFriendList());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
        }
    }
}
