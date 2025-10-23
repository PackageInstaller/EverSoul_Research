package com.kakaogame.game;

import com.kakao.sdk.partner.model.KakaoPhase;
import com.kakaogame.idp.KGKakao2Auth;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameServerProtocol.kt */
@Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b$\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010+\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006."}, m839d2 = {"Lcom/kakaogame/game/GameServerProtocol;", "", "()V", "API_PROXY_AUTHORITY", "", "getAPI_PROXY_AUTHORITY", "()Ljava/lang/String;", "Alpha", "Beta", "DEPLOY_PHASE", "Lcom/kakao/sdk/partner/model/KakaoPhase;", "GAME_API_AUTHORITY", "GET_APP_POST_PATH", "GET_INVITATION_EVENTS_PATH", "GET_INVITATION_SENDER_LIST_PATH", "GET_INVITATION_SENDER_PATH", "GET_INVITATION_STATES_PATH", "GET_TEMPLATE_PATH", "IMAGE_UPLOAD_PATH", "INGAME_STATUS", "KAGE_API_AUTHORITY", "getKAGE_API_AUTHORITY", "KAGE_CDN_AUTHORITY", "KGA_APP_KEY", "getKGA_APP_KEY", "setKGA_APP_KEY", "(Ljava/lang/String;)V", "KGA_HEADER_KEY", "getKGA_HEADER_KEY", "setKGA_HEADER_KEY", "KGA_USER_ID", "getKGA_USER_ID", "setKGA_USER_ID", "Local", "PLUS_FRIEND_ADD", "PUBLIC_ERROR", "REACH_API_VERSION", "REACH_AUTHORITY", "getREACH_AUTHORITY", "REACH_WEB_APP_URL_SCHEME", "Release", "Sandbox", "initAPIProxyAuthority", "initGameAPIAuthority", "initKageAPIAuthority", "initReachAuthority", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class GameServerProtocol {
    private static final String API_PROXY_AUTHORITY;
    public static final String Alpha = "dev";
    public static final String Beta = "cbt";
    private static final KakaoPhase DEPLOY_PHASE;
    public static final String GAME_API_AUTHORITY;
    public static final String GET_APP_POST_PATH = "/app_post";
    public static final String GET_INVITATION_EVENTS_PATH = "/common/v1/invitation_events";
    public static final String GET_INVITATION_SENDER_LIST_PATH = "/invitation_sender_list";
    public static final String GET_INVITATION_SENDER_PATH = "/invitation_sender";
    public static final String GET_INVITATION_STATES_PATH = "/invitation_states";
    public static final String GET_TEMPLATE_PATH = "/playgame/v2/story_feed/template/";
    public static final String IMAGE_UPLOAD_PATH = "/upload/game-sdk/";
    public static final String INGAME_STATUS = "reach/v1/ingame/status";
    public static final GameServerProtocol INSTANCE;
    private static final String KAGE_API_AUTHORITY;
    public static final String KAGE_CDN_AUTHORITY = "http://gc.kakaocdn.net/dn/";
    private static String KGA_APP_KEY = null;
    private static String KGA_HEADER_KEY = null;
    private static String KGA_USER_ID = null;
    public static final String Local = "local";
    public static final String PLUS_FRIEND_ADD = "/plus_friend/add";
    public static final String PUBLIC_ERROR = "/public/error";
    private static final String REACH_API_VERSION = "reach/v1";
    private static final String REACH_AUTHORITY;
    public static final String REACH_WEB_APP_URL_SCHEME = "kakaoreach";
    public static final String Release = "production";
    public static final String Sandbox = "sandbox";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private GameServerProtocol() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        GameServerProtocol gameServerProtocol = new GameServerProtocol();
        INSTANCE = gameServerProtocol;
        DEPLOY_PHASE = KGKakao2Auth.INSTANCE.getKAKAO_PHASE();
        KAGE_API_AUTHORITY = gameServerProtocol.initKageAPIAuthority();
        GAME_API_AUTHORITY = gameServerProtocol.initGameAPIAuthority();
        API_PROXY_AUTHORITY = gameServerProtocol.initAPIProxyAuthority();
        REACH_AUTHORITY = gameServerProtocol.initReachAuthority();
        KGA_HEADER_KEY = y.٬ݯح׭٩(576624686);
        KGA_APP_KEY = y.֬ڱܱײٮ(-1158872711);
        KGA_USER_ID = y.ݬֲ֮ܲت(1512339223);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKAGE_API_AUTHORITY() {
        return KAGE_API_AUTHORITY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getAPI_PROXY_AUTHORITY() {
        return API_PROXY_AUTHORITY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getREACH_AUTHORITY() {
        return REACH_AUTHORITY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKGA_HEADER_KEY() {
        return KGA_HEADER_KEY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setKGA_HEADER_KEY(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        KGA_HEADER_KEY = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKGA_APP_KEY() {
        return KGA_APP_KEY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setKGA_APP_KEY(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        KGA_APP_KEY = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getKGA_USER_ID() {
        return KGA_USER_ID;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setKGA_USER_ID(String str) {
        Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
        KGA_USER_ID = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String initKageAPIAuthority() {
        String str;
        KakaoPhase kakaoPhase = DEPLOY_PHASE;
        Intrinsics.checkNotNull(kakaoPhase);
        String phaseName = kakaoPhase.getPhaseName();
        int hashCode = phaseName.hashCode();
        String str2 = y.٬ݯح׭٩(576625926);
        switch (hashCode) {
            case 98293:
                str = y.ݬֲ֮ܲت(1512338399);
                break;
            case 99349:
                return !phaseName.equals(y.ݬֲ֮ܲت(1512338647)) ? str2 : y.٬ݯح׭٩(576626462);
            case 1753018553:
                str = y.ٴسسݬߨ(1393384938);
                break;
            case 1865400007:
                return !phaseName.equals(y.ݬֲ֮ܲت(1512359007)) ? str2 : y.ݮڮֲڭܩ(-628527516);
            default:
                return str2;
        }
        phaseName.equals(str);
        return str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String initGameAPIAuthority() {
        KakaoPhase kakaoPhase = DEPLOY_PHASE;
        Intrinsics.checkNotNull(kakaoPhase);
        String phaseName = kakaoPhase.getPhaseName();
        int hashCode = phaseName.hashCode();
        if (hashCode != 98293) {
            if (hashCode != 99349) {
                if (hashCode == 1753018553 && phaseName.equals(y.ٴسسݬߨ(1393384938))) {
                    return y.ٲٴݴ״ٰ(1782071552);
                }
            } else if (phaseName.equals(y.ݬֲ֮ܲت(1512338647))) {
                return y.ٲٴݴ״ٰ(1782071392);
            }
        } else if (phaseName.equals(y.ݬֲ֮ܲت(1512338399))) {
            return y.ݮڮֲڭܩ(-628528068);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String initAPIProxyAuthority() {
        KakaoPhase kakaoPhase = DEPLOY_PHASE;
        Intrinsics.checkNotNull(kakaoPhase);
        String phaseName = kakaoPhase.getPhaseName();
        switch (phaseName.hashCode()) {
            case 98293:
                if (phaseName.equals(y.ݬֲ֮ܲت(1512338399))) {
                    return y.ݮڮֲڭܩ(-628528068);
                }
                return null;
            case 99349:
                if (phaseName.equals(y.ݬֲ֮ܲت(1512338647))) {
                    return y.ٲٴݴ״ٰ(1782071392);
                }
                return null;
            case 103145323:
                if (phaseName.equals(y.֬ڱܱײٮ(-1158872183))) {
                    return y.֬ڱܱײٮ(-1158872111);
                }
                return null;
            case 1753018553:
                if (phaseName.equals(y.ٴسسݬߨ(1393384938))) {
                    return y.ٲٴݴ״ٰ(1782071552);
                }
                return null;
            case 1865400007:
                if (phaseName.equals(y.ݬֲ֮ܲت(1512359007))) {
                    return y.ݬֲ֮ܲت(1512339279);
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String initReachAuthority() {
        KakaoPhase kakaoPhase = DEPLOY_PHASE;
        Intrinsics.checkNotNull(kakaoPhase);
        String phaseName = kakaoPhase.getPhaseName();
        switch (phaseName.hashCode()) {
            case 98293:
                if (phaseName.equals(y.ݬֲ֮ܲت(1512338399))) {
                    return y.ٲٴݴ״ٰ(1782073688);
                }
                return null;
            case 99349:
                if (phaseName.equals(y.ݬֲ֮ܲت(1512338647))) {
                    return y.֬ڱܱײٮ(-1158870871);
                }
                return null;
            case 103145323:
                if (phaseName.equals(y.֬ڱܱײٮ(-1158872183))) {
                    return y.֬ڱܱײٮ(-1158872111);
                }
                return null;
            case 1753018553:
                if (phaseName.equals(y.ٴسسݬߨ(1393384938))) {
                    return y.ݬֲ֮ܲت(1512341143);
                }
                return null;
            case 1865400007:
                if (phaseName.equals(y.ݬֲ֮ܲت(1512359007))) {
                    return y.دײܮڳܯ(2051298869);
                }
                return null;
            default:
                return null;
        }
    }
}
