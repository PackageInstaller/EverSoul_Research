package com.kakaogame.promotion;

import android.content.Context;
import com.facebook.AuthenticationTokenClaims;
import com.kakaogame.KGObject;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SNSShareData.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0004!\"#$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u001c\u001a\b\u0018\u00010\u001bR\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u00060\u001bR\u00020\u00000\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, m839d2 = {"Lcom/kakaogame/promotion/SNSShareData;", "", "data", "Lcom/kakaogame/util/json/JSONObject;", "(Lcom/kakaogame/util/json/JSONObject;)V", "KEY_HASH_TAGS", "", "KEY_LINK_URL", "KEY_REWARD", "KEY_SHARE_TYPE", "REPLACE_CODE_APP_ID", "REPLACE_CODE_CUSTOM_CODE", "REPLACE_CODE_REFERRER", "invitationGuestUrl", "getInvitationGuestUrl", "()Ljava/lang/String;", "invitationHostUrl", "getInvitationHostUrl", "loadDataTime", "", "seq", "getSeq", "()J", "setSeq", "(J)V", SNSShareData.KEY_SHARE_INFO_MAP, "", "Lcom/kakaogame/promotion/SNSShareData$ShareInfo;", "getShareData", "type", "Lcom/kakaogame/promotion/SNSShareData$SNSShareType;", "needRefresh", "", "Companion", "SNSShareChannel", "SNSShareType", "ShareInfo", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SNSShareData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_GUEST_URL = "snsShareGuestUrl";
    private static final String KEY_HOST_URL = "snsShareHostUrl";
    private static final String KEY_SEQ = "seq";
    private static final String KEY_SHARE_INFO_MAP = "shareInfoMap";
    private static final String KEY_WEB_URL_MAP = "webUrlMap";
    private static final String TAG = "SNSShareData";
    private final String KEY_HASH_TAGS;
    private final String KEY_LINK_URL;
    private final String KEY_REWARD;
    private final String KEY_SHARE_TYPE;
    private final String REPLACE_CODE_APP_ID;
    private final String REPLACE_CODE_CUSTOM_CODE;
    private final String REPLACE_CODE_REFERRER;
    private final String invitationGuestUrl;
    private final String invitationHostUrl;
    private long loadDataTime;
    private long seq;
    private final Map<String, ShareInfo> shareInfoMap;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final SNSShareData loadData() {
        return INSTANCE.loadData();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SNSShareData(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, y.دײܮڳܯ(2051550101));
        this.shareInfoMap = new LinkedHashMap();
        this.KEY_SHARE_TYPE = y.دײܮڳܯ(2051120853);
        this.KEY_HASH_TAGS = y.ݬֲ֮ܲت(1512159079);
        this.KEY_LINK_URL = y.ۮڭڭܬި(862661435);
        this.KEY_REWARD = y.٬ݯح׭٩(576412014);
        this.REPLACE_CODE_APP_ID = y.ۮڭڭܬި(862778539);
        this.REPLACE_CODE_REFERRER = y.ٴسسݬߨ(1393073594);
        this.REPLACE_CODE_CUSTOM_CODE = y.٬ݯح׭٩(576412278);
        JSONObject jSONObject2 = (JSONObject) jSONObject.get((Object) y.ۮڭڭܬި(862779267));
        Intrinsics.checkNotNull(jSONObject2);
        for (String str : jSONObject2.keySet()) {
            Map<String, ShareInfo> map = this.shareInfoMap;
            Intrinsics.checkNotNull(str);
            map.put(str, new ShareInfo((JSONObject) jSONObject2.get((Object) str)));
        }
        JSONObject jSONObject3 = (JSONObject) jSONObject.get((Object) y.٬ݯح׭٩(576412438));
        Intrinsics.checkNotNull(jSONObject3);
        this.invitationHostUrl = (String) jSONObject3.get((Object) y.ٲٴݴ״ٰ(1782283920));
        this.invitationGuestUrl = (String) jSONObject3.get((Object) y.ٴسسݬߨ(1393451178));
        this.loadDataTime = CoreManager.INSTANCE.getInstance().currentTimeMillis();
        Number number = (Number) jSONObject.get((Object) y.دײܮڳܯ(2051707837));
        this.seq = number != null ? number.longValue() : 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getInvitationHostUrl() {
        return this.invitationHostUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getInvitationGuestUrl() {
        return this.invitationGuestUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long getSeq() {
        return this.seq;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSeq(long j) {
        this.seq = j;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SNSShareData.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/promotion/SNSShareData$SNSShareType;", "", "(Ljava/lang/String;I)V", "linkInvite", "linkShare", "nonLinkShare", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class SNSShareType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SNSShareType[] $VALUES;
        public static final SNSShareType linkInvite = new SNSShareType(y.٬ݯح׭٩(576407278), 0);
        public static final SNSShareType linkShare = new SNSShareType(y.دײܮڳܯ(2051113293), 1);
        public static final SNSShareType nonLinkShare = new SNSShareType(y.ۮڭڭܬި(862775971), 2);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ SNSShareType[] $values() {
            return new SNSShareType[]{linkInvite, linkShare, nonLinkShare};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<SNSShareType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SNSShareType valueOf(String str) {
            return (SNSShareType) Enum.valueOf(SNSShareType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SNSShareType[] values() {
            return (SNSShareType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SNSShareType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            SNSShareType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SNSShareData.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, m839d2 = {"Lcom/kakaogame/promotion/SNSShareData$SNSShareChannel;", "", "(Ljava/lang/String;I)V", "facebook", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class SNSShareChannel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SNSShareChannel[] $VALUES;
        public static final SNSShareChannel facebook = new SNSShareChannel(y.ٲٴݴ״ٰ(1781823696), 0);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ SNSShareChannel[] $values() {
            return new SNSShareChannel[]{facebook};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<SNSShareChannel> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SNSShareChannel valueOf(String str) {
            return (SNSShareChannel) Enum.valueOf(SNSShareChannel.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static SNSShareChannel[] values() {
            return (SNSShareChannel[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SNSShareChannel(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            SNSShareChannel[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean needRefresh() {
        return CoreManager.INSTANCE.getInstance().currentTimeMillis() - this.loadDataTime > AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ShareInfo getShareData(SNSShareType type) {
        Intrinsics.checkNotNullParameter(type, y.ٲٴݴ״ٰ(1781623144));
        return this.shareInfoMap.get(type.name());
    }

    /* compiled from: SNSShareData.kt */
    @Metadata(m838d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, m839d2 = {"Lcom/kakaogame/promotion/SNSShareData$ShareInfo;", "Lcom/kakaogame/KGObject;", "data", "Lcom/kakaogame/util/json/JSONObject;", "(Lcom/kakaogame/promotion/SNSShareData;Lcom/kakaogame/util/json/JSONObject;)V", "firstHashtag", "", "getFirstHashtag", "()Ljava/lang/String;", "isReward", "", "()Z", "linkUrl", "getLinkUrl", "type", "Lcom/kakaogame/promotion/SNSShareData$SNSShareType;", "getType", "()Lcom/kakaogame/promotion/SNSShareData$SNSShareType;", "customCode", "code", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public final class ShareInfo extends KGObject {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ShareInfo(JSONObject jSONObject) {
            super(jSONObject);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final SNSShareType getType() {
            String str = (String) get(SNSShareData.this.KEY_SHARE_TYPE);
            if (Intrinsics.areEqual(y.٬ݯح׭٩(576407278), str)) {
                return SNSShareType.linkInvite;
            }
            if (Intrinsics.areEqual(y.دײܮڳܯ(2051113293), str)) {
                return SNSShareType.linkShare;
            }
            return SNSShareType.nonLinkShare;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getFirstHashtag() {
            return getFirstHashtag(null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x001f, code lost:
        
            if (r0.containsKey((java.lang.Object) r3) != false) goto L8;
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String getFirstHashtag(java.lang.String r3) {
            /*
                r2 = this;
                com.kakaogame.promotion.SNSShareData r0 = com.kakaogame.promotion.SNSShareData.this
                java.lang.String r0 = com.kakaogame.promotion.SNSShareData.access$getKEY_HASH_TAGS$p(r0)
                java.lang.Object r0 = r2.get(r0)
                com.kakaogame.util.json.JSONObject r0 = (com.kakaogame.util.json.JSONObject) r0
                r1 = r3
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 != 0) goto L22
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                boolean r1 = r0.containsKey(r3)
                if (r1 == 0) goto L22
                goto L24
            L22:
                java.lang.String r3 = "default"
            L24:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                java.lang.Object r3 = r0.get(r3)
                com.kakaogame.util.json.JSONArray r3 = (com.kakaogame.util.json.JSONArray) r3
                if (r3 == 0) goto L3e
                int r0 = r3.size()
                if (r0 != 0) goto L36
                goto L3e
            L36:
                r0 = 0
                java.lang.Object r3 = r3.get(r0)
                java.lang.String r3 = (java.lang.String) r3
                goto L40
            L3e:
                java.lang.String r3 = ""
            L40:
                return r3
                fill-array 0x0042: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.promotion.SNSShareData.ShareInfo.getFirstHashtag(java.lang.String):java.lang.String");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLinkUrl() {
            return getLinkUrl(null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getLinkUrl(String code) {
            String str = (String) get(SNSShareData.this.KEY_LINK_URL);
            Intrinsics.checkNotNull(str);
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) SNSShareData.this.REPLACE_CODE_APP_ID, false, 2, (Object) null)) {
                String str2 = SNSShareData.this.REPLACE_CODE_APP_ID;
                Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
                Intrinsics.checkNotNull(configuration);
                str = StringsKt.replace$default(str, str2, configuration.getAppId(), false, 4, (Object) null);
            }
            String str3 = str;
            if (StringsKt.contains$default((CharSequence) str3, (CharSequence) SNSShareData.this.REPLACE_CODE_REFERRER, false, 2, (Object) null)) {
                Context context = CoreManager.INSTANCE.getInstance().getContext();
                String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
                String str4 = SNSShareData.this.REPLACE_CODE_REFERRER;
                String loadPlayerInvitationReferrer = InviteDataManager.loadPlayerInvitationReferrer(context, playerId);
                Intrinsics.checkNotNull(loadPlayerInvitationReferrer);
                str3 = StringsKt.replace$default(str3, str4, loadPlayerInvitationReferrer, false, 4, (Object) null);
            }
            String str5 = str3;
            if (code != null && StringsKt.contains$default((CharSequence) str5, (CharSequence) SNSShareData.this.REPLACE_CODE_CUSTOM_CODE, false, 2, (Object) null)) {
                str5 = StringsKt.replace$default(str5, SNSShareData.this.REPLACE_CODE_CUSTOM_CODE, code, false, 4, (Object) null);
            }
            Logger.INSTANCE.m699d(y.ۮڭڭܬި(862776155), y.ݮڮֲڭܩ(-628316076) + str5);
            return str5;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isReward() {
            Object obj = get(SNSShareData.this.KEY_REWARD);
            if (obj != null && (obj instanceof Boolean)) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        }
    }

    /* compiled from: SNSShareData.kt */
    @Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/promotion/SNSShareData$Companion;", "", "()V", "KEY_GUEST_URL", "", "KEY_HOST_URL", "KEY_SEQ", "KEY_SHARE_INFO_MAP", "KEY_WEB_URL_MAP", "TAG", "loadData", "Lcom/kakaogame/promotion/SNSShareData;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
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
        public final SNSShareData loadData() {
            KGResult<SNSShareData> loadSNSShareInfo = PromotionService.loadSNSShareInfo();
            Logger.INSTANCE.m699d(y.ۮڭڭܬި(862776155), y.ۮڭڭܬި(862775523) + loadSNSShareInfo);
            if (loadSNSShareInfo.isSuccess()) {
                return loadSNSShareInfo.getContent();
            }
            return null;
        }
    }
}
