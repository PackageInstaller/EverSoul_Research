package com.kakaogame.core;

import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGMessage;
import com.kakaogame.Logger;
import com.kakaogame.infodesk.InfodeskData;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.util.json.JSONArray;
import com.liapp.y;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FeatureManager.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\n\u0010\t\u001a\u00020\u0006*\u00020\nJ\n\u0010\u000b\u001a\u00020\u0006*\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/core/FeatureManager;", "", "()V", "TAG", "", "allowConnectFrom", "", "idpCode", "allowConnectTo", "isNotSupportedFeature", "Lcom/kakaogame/core/FeatureManager$Feature;", "isSupportedFeature", "Feature", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class FeatureManager {
    public static final FeatureManager INSTANCE = new FeatureManager();
    private static final String TAG = "FeatureManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FeatureManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean allowConnectFrom(String idpCode) {
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Guest.getCode())) {
            return true;
        }
        if (Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Kakao.getCode()) || Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Twitter.getCode()) || Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Gamania.getCode())) {
            return false;
        }
        return InfodeskHelper.INSTANCE.getSupportedIdpCodes().contains(y.ݮڮֲڭܩ(-628796260));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean allowConnectTo(String idpCode) {
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        Intrinsics.checkNotNull(currentPlayer);
        KGIdpProfile idpProfile = currentPlayer.getIdpProfile();
        Intrinsics.checkNotNull(idpProfile);
        KGIdpProfile.KGIdpCode idpCode2 = idpProfile.getIdpCode();
        if (idpCode2 == null || Intrinsics.areEqual(idpCode, idpCode2.getCode()) || Intrinsics.areEqual(idpCode, KGIdpProfile.KGIdpCode.Guest.getCode())) {
            return false;
        }
        if (StringsKt.equals(idpCode2.getCode(), KGIdpProfile.KGIdpCode.Guest.getCode(), true)) {
            return true;
        }
        return StringsKt.equals(KGIdpProfile.KGIdpCode.Gamania.getCode(), idpCode, true);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: FeatureManager.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m839d2 = {"Lcom/kakaogame/core/FeatureManager$Feature;", "", "(Ljava/lang/String;I)V", "urgentNotice", "maintenance", "push", "delivery", KGMessage.SENDER_ID_PROMOTION, "coupon", "leaderboard", KGMessage.SENDER_ID_NOTICE, "snsShare", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Feature {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Feature[] $VALUES;
        public static final Feature urgentNotice = new Feature(y.ٴسسݬߨ(1393389338), 0);
        public static final Feature maintenance = new Feature(y.ݮڮֲڭܩ(-628686508), 1);
        public static final Feature push = new Feature(y.٬ݯح׭٩(576629638), 2);
        public static final Feature delivery = new Feature(y.ۮڭڭܬި(862521043), 3);
        public static final Feature promotion = new Feature(y.ٴسسݬߨ(1393387626), 4);
        public static final Feature coupon = new Feature(y.֬ڱܱײٮ(-1158859343), 5);
        public static final Feature leaderboard = new Feature(y.ۮڭڭܬި(862519803), 6);
        public static final Feature notice = new Feature(y.ٲٴݴ״ٰ(1782085152), 7);
        public static final Feature snsShare = new Feature(y.دײܮڳܯ(2051304197), 8);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ Feature[] $values() {
            return new Feature[]{urgentNotice, maintenance, push, delivery, promotion, coupon, leaderboard, notice, snsShare};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<Feature> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Feature valueOf(String str) {
            return (Feature) Enum.valueOf(Feature.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Feature[] values() {
            return (Feature[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Feature(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            Feature[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isSupportedFeature(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, y.٬ݯح׭٩(575694806));
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628531820) + feature;
        String str2 = y.ۮڭڭܬި(862520131);
        logger.m706v(str2, str);
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        if (infodesk == null) {
            return false;
        }
        JSONArray jSONArray = (JSONArray) infodesk.get((Object) y.ݮڮֲڭܩ(-628531548));
        Logger.INSTANCE.m706v(str2, y.ݬֲ֮ܲت(1512325143) + jSONArray);
        if (jSONArray == null) {
            return false;
        }
        JSONArray jSONArray2 = jSONArray;
        if ((jSONArray2 instanceof Collection) && jSONArray2.isEmpty()) {
            return false;
        }
        for (Object obj : jSONArray2) {
            String name = feature.name();
            Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
            if (StringsKt.equals(name, (String) obj, true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNotSupportedFeature(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, y.٬ݯح׭٩(575694806));
        return !isSupportedFeature(feature);
    }
}
