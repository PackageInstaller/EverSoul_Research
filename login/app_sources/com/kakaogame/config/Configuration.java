package com.kakaogame.config;

import com.kakaogame.KGObject;
import com.kakaogame.server.ServerInfo;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: Configuration.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0003-./B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007B)\b\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u000bR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u0011\u0010'\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b(\u0010\u0010¨\u00060"}, m839d2 = {"Lcom/kakaogame/config/Configuration;", "Lcom/kakaogame/KGObject;", "()V", "m", "", "", "", "(Ljava/util/Map;)V", "appId", "(Ljava/util/Map;Ljava/lang/String;)V", Configuration.KEY_AGE_AUTH_FAIL_PROCESS_KILL, "", "getAgeAuthFailProcessKill", "()Z", "appGroupId", "getAppGroupId", "()Ljava/lang/String;", "getAppId", "appSecret", "getAppSecret", "appVersion", "getAppVersion", Configuration.KEY_DEBUG_LEVEL, "Lcom/kakaogame/config/Configuration$KGDebugLevel;", "getDebugLevel", "()Lcom/kakaogame/config/Configuration$KGDebugLevel;", "isAgeAuthOnLogin", "market", "getMarket", Configuration.KEY_SERVER_INFO, "Lcom/kakaogame/server/ServerInfo;", "getServerInfo", "()Lcom/kakaogame/server/ServerInfo;", Configuration.KEY_SERVER_TYPE, "Lcom/kakaogame/config/Configuration$KGServerType;", "getServerType", "()Lcom/kakaogame/config/Configuration$KGServerType;", "serverTypeString", "getServerTypeString", "serverTypeValue", "getServerTypeValue", "setGeoCountry", "", "geoCountry", Configuration.KEY_USE_FIREBASE, "Companion", "KGDebugLevel", "KGServerType", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class Configuration extends KGObject {
    private static final String CONFIG_FILENAME = "zinny_sdk_configuration.xml";
    private static final String KAKAO_CONFIG_FILENAME = "kakao_game_sdk_configuration.xml";
    public static final String KEY_AGE_AUTH_FAIL_PROCESS_KILL = "ageAuthFailProcessKill";
    public static final String KEY_APPGROUP_ID = "appGroupId";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_APP_SECRET = "appSecret";
    public static final String KEY_APP_VERSION = "appVersion";
    public static final String KEY_DEBUG_LEVEL = "debugLevel";
    public static final String KEY_IS_AGE_AUTH_ON_LOGIN = "ageAuthOnLogin";
    public static final String KEY_MARKET = "market";
    public static final String KEY_SERVER_INFO = "serverInfo";
    public static final String KEY_SERVER_TYPE = "serverType";
    public static final String KEY_USE_FIREBASE = "useFirebase";
    public static final String MARKET_AMAZON_TV = "amazonStore_fireTV";
    public static final String MARKET_GOOGLE_PLAY = "googlePlay";
    private static final String TAG = "Configuration";
    private static final long serialVersionUID = 2030904284449397017L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Configuration() {
        super(null, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Configuration(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Configuration(Map<String, Object> map, String str) {
        super(map);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        Object obj = get("appId");
        String str3 = y.ݬֲ֮ܲت(1512814407);
        Intrinsics.checkNotNull(obj, str3);
        String str4 = y.ۮڭڭܬި(862506555);
        Object obj2 = get(str4);
        Intrinsics.checkNotNull(obj2, str3);
        String str5 = (String) obj2;
        String str6 = (String) obj;
        String str7 = y.ٲٴݴ״ٰ(1781559176);
        if (StringsKt.contains$default((CharSequence) str6, (CharSequence) str7, false, 2, (Object) null)) {
            String[] strArr = (String[]) new Regex(str7).split(str6, 0).toArray(new String[0]);
            String[] strArr2 = (String[]) new Regex(str7).split(str5, 0).toArray(new String[0]);
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (Intrinsics.areEqual(str, strArr[i])) {
                    put("appId", strArr[i]);
                    put(str4, strArr2[i]);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppGroupId() {
        Object obj = get(y.ݮڮֲڭܩ(-628493652));
        return obj == null ? "" : (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppId() {
        Object obj = get(y.ۮڭڭܬި(862411867));
        Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
        return (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppSecret() {
        Object obj = get(y.ۮڭڭܬި(862506555));
        Intrinsics.checkNotNull(obj, y.ݬֲ֮ܲت(1512814407));
        return (String) obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAppVersion() {
        return (String) get(y.٬ݯح׭٩(576607038));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getMarket() {
        return (String) get(y.دײܮڳܯ(2051758173));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGDebugLevel getDebugLevel() {
        String str = (String) get(y.ݮڮֲڭܩ(-628493556));
        for (KGDebugLevel kGDebugLevel : KGDebugLevel.values()) {
            if (StringsKt.equals(kGDebugLevel.getValue(), str, true)) {
                return kGDebugLevel;
            }
        }
        return KGDebugLevel.NONE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setGeoCountry(String geoCountry) {
        Intrinsics.checkNotNullParameter(geoCountry, y.ݬֲ֮ܲت(1512368903));
        if (StringsKt.contains$default((CharSequence) getServerTypeString(), (CharSequence) y.ٴسسݬߨ(1393422826), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getServerTypeString(), (CharSequence) y.ݬֲ֮ܲت(1512359007), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getServerTypeString(), (CharSequence) y.֬ڱܱײٮ(-1158820255), false, 2, (Object) null)) {
            return;
        }
        boolean equals = StringsKt.equals(geoCountry, y.ٴسسݬߨ(1393410210), true);
        String str = y.ݬֲ֮ܲت(1512369191);
        if (equals) {
            put(str, ConfigLoader.getServerInfo("real"));
        } else {
            if (StringsKt.equals(geoCountry, y.ٴسسݬߨ(1393410370), true)) {
                return;
            }
            put(str, ConfigLoader.getServerInfo("real_global"));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGServerType getServerType() {
        String str = (String) get(y.ݬֲ֮ܲت(1512366615));
        for (KGServerType kGServerType : KGServerType.values()) {
            if (StringsKt.equals(kGServerType.getValue(), str, true)) {
                return kGServerType;
            }
        }
        return KGServerType.LIVE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getServerTypeValue() {
        String str = (String) get(y.ݬֲ֮ܲت(1512366615));
        return str == null ? y.ٴسسݬߨ(1393412162) : str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean getAgeAuthFailProcessKill() {
        if (((String) get(y.ٲٴݴ״ٰ(1782110504))) == null) {
            return true;
        }
        return !StringsKt.equals(r0, y.ٲٴݴ״ٰ(1781635312), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAgeAuthOnLogin() {
        String str = (String) get(y.ۮڭڭܬި(862562603));
        if (str == null) {
            return false;
        }
        return StringsKt.equals(str, y.دײܮڳܯ(2051939573), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean useFirebase() {
        if (((String) get(y.ٴسسݬߨ(1393410402))) == null) {
            return true;
        }
        return !StringsKt.equals(r0, y.ٲٴݴ״ٰ(1781635312), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ServerInfo getServerInfo() {
        return new ServerInfo((Map) get(y.ݬֲ֮ܲت(1512369191)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getServerTypeString() {
        String str = (String) get(y.ݬֲ֮ܲت(1512366615));
        String str2 = str;
        return str2 == null || str2.length() == 0 ? KGServerType.LIVE.getValue() : str;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Configuration.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/config/Configuration$KGDebugLevel;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VERBOSE", "DEBUG", "ERROR", "NONE", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGDebugLevel {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGDebugLevel[] $VALUES;
        private final String value;
        public static final KGDebugLevel VERBOSE = new KGDebugLevel(y.֬ڱܱײٮ(-1158833823), 0, y.٬ݯح׭٩(576585766));
        public static final KGDebugLevel DEBUG = new KGDebugLevel(y.دײܮڳܯ(2051327661), 1, y.ݬֲ֮ܲت(1512369983));
        public static final KGDebugLevel ERROR = new KGDebugLevel(y.ٴسسݬߨ(1393411402), 2, y.٬ݯح׭٩(576154958));
        public static final KGDebugLevel NONE = new KGDebugLevel(y.ۮڭڭܬި(862123667), 3, y.ݬֲ֮ܲت(1512369879));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGDebugLevel[] $values() {
            return new KGDebugLevel[]{VERBOSE, DEBUG, ERROR, NONE};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGDebugLevel> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGDebugLevel valueOf(String str) {
            return (KGDebugLevel) Enum.valueOf(KGDebugLevel.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGDebugLevel[] values() {
            return (KGDebugLevel[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGDebugLevel(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGDebugLevel[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Configuration.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/config/Configuration$KGServerType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BETA", "LIVE", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGServerType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGServerType[] $VALUES;
        public static final KGServerType BETA = new KGServerType(y.ݮڮֲڭܩ(-628493828), 0, y.ٴسسݬߨ(1393411362));
        public static final KGServerType LIVE = new KGServerType(y.دײܮڳܯ(2051327101), 1, y.ۮڭڭܬި(862563563));
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGServerType[] $values() {
            return new KGServerType[]{BETA, LIVE};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGServerType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGServerType valueOf(String str) {
            return (KGServerType) Enum.valueOf(KGServerType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGServerType[] values() {
            return (KGServerType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGServerType(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGServerType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
