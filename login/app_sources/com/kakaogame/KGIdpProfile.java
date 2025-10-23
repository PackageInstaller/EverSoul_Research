package com.kakaogame;

import android.app.Activity;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.idp.IdpAuthExHandler;
import com.kakaogame.idp.IdpAuthHandler;
import com.kakaogame.idp.IdpAuthManager;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGIdpProfile.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\b&\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u001f\b\u0004\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00160\u0015H&R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\t¨\u0006\u0019"}, m839d2 = {"Lcom/kakaogame/KGIdpProfile;", "Lcom/kakaogame/KGObject;", "content", "", "", "", "(Ljava/util/Map;)V", "accountType", "getAccountType", "()Ljava/lang/String;", "idpAccessToken", "getIdpAccessToken", "idpCode", "Lcom/kakaogame/KGIdpProfile$KGIdpCode;", "getIdpCode", "()Lcom/kakaogame/KGIdpProfile$KGIdpCode;", "idpUserId", "getIdpUserId", "playerId", "getPlayerId", "loadFriendProfiles", "Lcom/kakaogame/KGResult;", "", "Companion", "KGIdpCode", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public abstract class KGIdpProfile extends KGObject {
    private static final String CLASS_NAME_KEY = "KGIdpProfile";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "KGIdpProfile";
    private static final long serialVersionUID = -5920474118075278619L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final KGIdpProfile getLocalIdpProfile() {
        return INSTANCE.getLocalIdpProfile();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initialize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void refreshLocalIdpProfile(KGResultCallback<KGIdpProfile> kGResultCallback) {
        INSTANCE.refreshLocalIdpProfile(kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getAccountType() {
        return "";
    }

    public abstract KGResult<Map<String, KGIdpProfile>> loadFriendProfiles();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected KGIdpProfile(Map<String, Object> map) {
        super(map);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGIdpProfile.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/KGIdpProfile$KGIdpCode;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Guest", "Kakao", "Facebook", "Google", "SigninWithApple", "Twitter", "Gamania", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGIdpCode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGIdpCode[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final String code;
        public static final KGIdpCode Guest = new KGIdpCode(y.ݮڮֲڭܩ(-628797068), 0, y.ݮڮֲڭܩ(-628796564));
        public static final KGIdpCode Kakao = new KGIdpCode(y.֬ڱܱײٮ(-1159645087), 1, y.ٴسسݬߨ(1392600890));
        public static final KGIdpCode Facebook = new KGIdpCode(y.ٲٴݴ״ٰ(1781824128), 2, y.ٲٴݴ״ٰ(1781823696));
        public static final KGIdpCode Google = new KGIdpCode(y.٬ݯح׭٩(575840726), 3, y.ݮڮֲڭܩ(-628796348));
        public static final KGIdpCode SigninWithApple = new KGIdpCode(y.ݮڮֲڭܩ(-628796812), 4, y.ٲٴݴ״ٰ(1781825344));
        public static final KGIdpCode Twitter = new KGIdpCode(y.ݬֲ֮ܲت(1512590647), 5, y.ۮڭڭܬި(862259635));
        public static final KGIdpCode Gamania = new KGIdpCode(y.دײܮڳܯ(2051564677), 6, y.ݮڮֲڭܩ(-628796260));

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGIdpCode[] $values() {
            return new KGIdpCode[]{Guest, Kakao, Facebook, Google, SigninWithApple, Twitter, Gamania};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGIdpCode> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGIdpCode valueOf(String str) {
            return (KGIdpCode) Enum.valueOf(KGIdpCode.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGIdpCode[] values() {
            return (KGIdpCode[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGIdpCode(String str, int i, String str2) {
            this.code = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCode() {
            return this.code;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGIdpCode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        /* compiled from: KGIdpProfile.kt */
        @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/KGIdpProfile$KGIdpCode$Companion;", "", "()V", "get", "Lcom/kakaogame/KGIdpProfile$KGIdpCode;", "name", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final KGIdpCode get(String name) {
                String str;
                String str2 = y.ݮڮֲڭܩ(-628797244);
                if (name != null) {
                    str = name.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(str, str2);
                } else {
                    str = null;
                }
                String lowerCase = y.ݮڮֲڭܩ(-628797068).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, str2);
                if (Intrinsics.areEqual(str, lowerCase)) {
                    return KGIdpCode.Guest;
                }
                String lowerCase2 = y.֬ڱܱײٮ(-1159645087).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, str2);
                if (Intrinsics.areEqual(str, lowerCase2)) {
                    return KGIdpCode.Kakao;
                }
                String lowerCase3 = y.ٲٴݴ״ٰ(1781824128).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, str2);
                if (Intrinsics.areEqual(str, lowerCase3)) {
                    return KGIdpCode.Facebook;
                }
                String lowerCase4 = y.٬ݯح׭٩(575840726).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase4, str2);
                if (Intrinsics.areEqual(str, lowerCase4)) {
                    return KGIdpCode.Google;
                }
                String lowerCase5 = y.ݮڮֲڭܩ(-628796812).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase5, str2);
                if (Intrinsics.areEqual(str, lowerCase5)) {
                    return KGIdpCode.SigninWithApple;
                }
                String lowerCase6 = y.ݬֲ֮ܲت(1512590647).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase6, str2);
                if (Intrinsics.areEqual(str, lowerCase6)) {
                    return KGIdpCode.Twitter;
                }
                String lowerCase7 = y.دײܮڳܯ(2051564677).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase7, str2);
                if (Intrinsics.areEqual(str, lowerCase7)) {
                    return KGIdpCode.Gamania;
                }
                return null;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGIdpCode getIdpCode() {
        return KGIdpCode.INSTANCE.get((String) get(y.دײܮڳܯ(2051564517)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpUserId() {
        return (String) get(y.ݮڮֲڭܩ(-628796020));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getIdpAccessToken() {
        return (String) get(y.ٴسسݬߨ(1392599370));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlayerId() {
        return (String) get(y.ݬֲ֮ܲت(1512589743));
    }

    /* compiled from: KGIdpProfile.kt */
    @Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0010\u001a\u00020\u000e2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m839d2 = {"Lcom/kakaogame/KGIdpProfile$Companion;", "", "()V", "CLASS_NAME_KEY", "", "TAG", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile$annotations", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "serialVersionUID", "", "initInterfaceBroker", "", "initialize", "refreshLocalIdpProfile", "Lcom/kakaogame/KGResult;", "activity", "Landroid/app/Activity;", "callback", "Lcom/kakaogame/KGResultCallback;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getLocalIdpProfile$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void initialize() {
            initInterfaceBroker();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final void refreshLocalIdpProfile(KGResultCallback<KGIdpProfile> callback) {
            Logger.INSTANCE.m704i(y.ۮڭڭܬި(862257643), y.ۮڭڭܬި(862257907));
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGIdpProfile$Companion$refreshLocalIdpProfile$1(callback, null), 3, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<KGIdpProfile> refreshLocalIdpProfile(Activity activity) {
            try {
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    return KGResult.INSTANCE.getResult(3002);
                }
                IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
                Intrinsics.checkNotNull(authData);
                IdpAuthHandler idpAuthHadler = IdpAuthManager.getIdpAuthHadler(authData.getIdpCode());
                if (idpAuthHadler == null) {
                    return KGResult.INSTANCE.getResult(3001);
                }
                KGResult checkAuth$default = IdpAuthHandler.DefaultImpls.checkAuth$default(idpAuthHadler, activity, CoreManager.INSTANCE.getInstance().getAuthData(), 0, 4, null);
                if (!checkAuth$default.isSuccess() && checkAuth$default.getCode() != 200000) {
                    return KGResult.INSTANCE.getResult(checkAuth$default);
                }
                if (checkAuth$default.isSuccess()) {
                    AuthDataManager.INSTANCE.setAccount(activity, (IdpAccount) checkAuth$default.getContent());
                }
                KGIdpProfile localIdpProfile = ((IdpAuthExHandler) idpAuthHadler).getLocalIdpProfile();
                if (localIdpProfile == null) {
                    return KGResult.INSTANCE.getResult(9999, "idpProfile is null");
                }
                return KGResult.INSTANCE.getSuccessResult(localIdpProfile);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ۮڭڭܬި(862257643), e.toString(), e);
                return KGResult.INSTANCE.getResult(4001, e.toString());
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGIdpProfile getLocalIdpProfile() {
            try {
                if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    return null;
                }
                IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
                Intrinsics.checkNotNull(authData);
                IdpAuthExHandler idpAuthExHandler = (IdpAuthExHandler) IdpAuthManager.getIdpAuthHadler(authData.getIdpCode());
                if (idpAuthExHandler != null) {
                    return idpAuthExHandler.getLocalIdpProfile();
                }
                return null;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ۮڭڭܬި(862257643), e.toString(), e);
                return null;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initInterfaceBroker() {
            InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862258011), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGIdpProfile$Companion$initInterfaceBroker$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
                public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                    KGResult<?> refreshLocalIdpProfile;
                    Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                    Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                    refreshLocalIdpProfile = KGIdpProfile.INSTANCE.refreshLocalIdpProfile(activity);
                    FirebaseEvent.Companion.sendEvent(y.ۮڭڭܬި(862257643), y.دײܮڳܯ(2051566397), refreshLocalIdpProfile);
                    if (refreshLocalIdpProfile.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(refreshLocalIdpProfile);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Object content = refreshLocalIdpProfile.getContent();
                    Intrinsics.checkNotNull(content);
                    linkedHashMap.put(y.ݮڮֲڭܩ(-628793764), content);
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
            });
        }
    }
}
