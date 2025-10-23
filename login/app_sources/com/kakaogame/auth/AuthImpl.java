package com.kakaogame.auth;

import android.app.Activity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.KGSessionForCustomUI;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.agreement.AgreementManager;
import com.kakaogame.auth.agreement.AgreementService;
import com.kakaogame.auth.view.LoginUIManager;
import com.kakaogame.auth.view.LogoutUIManager;
import com.kakaogame.core.ConnectionManager;
import com.kakaogame.core.CoreImpl;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.idp.ChannelConnectHelper;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.idp.IdpAuthManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.tracer.TraceJobCode;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.promotion.UrlPromotionManager;
import com.kakaogame.push.PushPermissionManager;
import com.kakaogame.push.PushService;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: AuthImpl.kt */
@Metadata(m838d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J:\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J*\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0016\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J \u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J0\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u000bJ:\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040%H\u0002JD\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u00072\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u00122\u0006\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010+\u001a\u00020,H\u0007J2\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J6\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u001e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ0\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u000bJ8\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\"\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u00103\u001a\u00020\u000bH\u0007J\b\u00104\u001a\u00020,H\u0002J \u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J.\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040%2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J \u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR&\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\f\u0010\u000eR&\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u000f\u0010\u000e¨\u00069"}, m839d2 = {"Lcom/kakaogame/auth/AuthImpl;", "", "()V", "LOCATION_US", "", "TAG", "idpAccount", "Lcom/kakaogame/idp/IdpAccount;", "getIdpAccount", "()Lcom/kakaogame/idp/IdpAccount;", "<set-?>", "", "isConnectProcess", "isConnectProcess$annotations", "()Z", "isLoginProcess", "isLoginProcess$annotations", "chooseIdpAccount", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "idpChoiceMode", "Lcom/kakaogame/KGSessionForCustomUI$KGIdpChoiceMode;", "connectImpl", "idpCode", "extras", "logoutAlreadyUsedIdp", "traceJobId", "", "connectInternal", "account", "connectWithUI", "connectWithUIImpl", "connectWithoutUI", "connectWithoutUIImpl", "getAllowedIdpList", "", "handleLoginResult", "authData", "loginResult", "Lcom/kakaogame/auth/LoginData;", "saveAccount", "initialize", "", "loginImpl", "loginInternal", "loginWithUI", "loginWithoutUI", "skipStart", "logout", "showUI", "onLogout", "showCOPPA", "showLogin", "idpCodes", "unregister", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthImpl {
    public static final AuthImpl INSTANCE = new AuthImpl();
    private static final String LOCATION_US = "us";
    private static final String TAG = "AuthImpl";
    private static boolean isConnectProcess;
    private static boolean isLoginProcess;

    /* compiled from: AuthImpl.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[KGSessionForCustomUI.KGIdpChoiceMode.values().length];
            try {
                iArr[KGSessionForCustomUI.KGIdpChoiceMode.CurrentAccount.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KGSessionForCustomUI.KGIdpChoiceMode.AlreadyConnectedAccount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isConnectProcess$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isLoginProcess$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isLoginProcess() {
        return isLoginProcess;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isConnectProcess() {
        return isConnectProcess;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        CoreManager.INSTANCE.getInstance().addCoreStateListener(new CoreManager.CoreStateListener() { // from class: com.kakaogame.auth.AuthImpl$initialize$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onConnect(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogout(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onPause() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onUnregister(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogin(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                if (FeatureManager.INSTANCE.isSupportedFeature(FeatureManager.Feature.push)) {
                    PushService.register();
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> loginWithUI(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        int makeJob = Tracer.INSTANCE.makeJob(TraceJobCode.SDK_LOGIN);
        KGResult<Void> loginWithUI = INSTANCE.loginWithUI(activity, makeJob);
        Tracer tracer = Tracer.INSTANCE;
        int code = loginWithUI.getCode();
        String description = loginWithUI.getDescription();
        if (description == null) {
            description = loginWithUI.toString();
        }
        Tracer.finish$default(tracer, makeJob, code, description, null, 4, null);
        return loginWithUI;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> loginWithUI(Activity activity, int traceJobId) {
        KGResult<Void> successResult;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862515443);
        String str2 = y.ݮڮֲڭܩ(-628572900);
        logger.m699d(str2, str);
        if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (CoreImpl.INSTANCE.isStarting()) {
            successResult = KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, y.ݮڮֲڭܩ(-628577764));
        } else {
            if (isLoginProcess) {
                isLoginProcess = false;
                successResult = KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, y.ݬֲ֮ܲت(1512420615));
            } else if (CoreManager.INSTANCE.getInstance().getInfodesk() != null) {
                successResult = KGResult.INSTANCE.getSuccessResult();
            } else if (SDKVersion.isPublishing) {
                successResult = KGResult.INSTANCE.getResult(3001, y.ݮڮֲڭܩ(-628576644));
            } else if (CoreManager.INSTANCE.getInstance().loadInfodesk(false).isNotSuccess()) {
                successResult = KGResult.INSTANCE.getResult(1001, y.دײܮڳܯ(2051381581));
            } else {
                ConnectionManager.setConnectionType(activity, CoreManager.INSTANCE.getInstance().getConfiguration(), InfodeskHelper.INSTANCE.getServerConnectionType() == InfodeskHelper.ServerConnectionType.https);
                successResult = KGResult.INSTANCE.getSuccessResult();
            }
        }
        if (successResult.isNotSuccess()) {
            return successResult;
        }
        List<String> supportedIdpCodes = InfodeskHelper.INSTANCE.getSupportedIdpCodes();
        if (supportedIdpCodes.isEmpty()) {
            Logger.INSTANCE.m703he(str2, "loginWithUI: idpCode list is null. Check infodesk data on your game.");
            return KGResult.INSTANCE.getResult(3000, y.ݬֲ֮ܲت(1512423303));
        }
        return showLogin(activity, supportedIdpCodes, traceJobId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showLogin(Activity activity, List<String> idpCodes, int traceJobId) {
        KGResult<Void> result;
        KGResult<Void> showCOPPA;
        Object runBlocking$default;
        try {
            try {
                isLoginProcess = true;
                showCOPPA = showCOPPA(activity, traceJobId);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
            }
            if (showCOPPA.isNotSuccess()) {
                return showCOPPA;
            }
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AuthImpl$showLogin$loginResult$1(activity, idpCodes, traceJobId, null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default;
            if (kGResult.isNotSuccess()) {
                result = KGResult.INSTANCE.getResult(kGResult);
            } else {
                result = KGResult.INSTANCE.getSuccessResult();
            }
            return result;
        } finally {
            isLoginProcess = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> showCOPPA(Activity activity, int traceJobId) {
        Object runBlocking$default;
        int userAgeCheck = InfodeskHelper.INSTANCE.getUserAgeCheck();
        String countryCode = KGSystem.getCountryCode();
        if (userAgeCheck <= 0) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        String str = countryCode;
        if (str == null || str.length() == 0) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        String lowerCase = countryCode.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
        if (!Intrinsics.areEqual(lowerCase, y.ٴسسݬߨ(1393328954))) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_COPPA_UI);
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AuthImpl$showCOPPA$checkAgeResult$1(activity, userAgeCheck, null), 1, null);
        KGResult kGResult = (KGResult) runBlocking$default;
        Tracer tracer = Tracer.INSTANCE;
        TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_COPPA_UI;
        int code = kGResult.getCode();
        String description = kGResult.getDescription();
        if (description == null) {
            description = kGResult.toString();
        }
        tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
        if (kGResult.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(9001, y.ݮڮֲڭܩ(-628574252));
        }
        Object content = kGResult.getContent();
        Intrinsics.checkNotNull(content);
        if (!((Boolean) content).booleanValue()) {
            BuildersKt__BuildersKt.runBlocking$default(null, new AuthImpl$showCOPPA$1(activity, userAgeCheck, null), 1, null);
            return KGResult.INSTANCE.getResult(9900);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> loginWithoutUI(Activity activity, String idpCode, String extras, boolean skipStart) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        int makeJob = Tracer.INSTANCE.makeJob(TraceJobCode.SDK_LOGIN);
        KGResult<Void> loginWithoutUI = loginWithoutUI(activity, idpCode, extras, skipStart, makeJob);
        Tracer tracer = Tracer.INSTANCE;
        int code = loginWithoutUI.getCode();
        String description = loginWithoutUI.getDescription();
        if (description == null) {
            description = loginWithoutUI.toString();
        }
        Tracer.finish$default(tracer, makeJob, code, description, null, 4, null);
        return loginWithoutUI;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> loginWithoutUI(Activity activity, String idpCode, String extras, boolean skipStart, int traceJobId) {
        KGResult<Void> successResult;
        KGResult<Void> result;
        String name;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782156192) + idpCode;
        String str2 = y.ݮڮֲڭܩ(-628572900);
        logger.m699d(str2, str);
        if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (idpCode.length() == 0) {
            successResult = KGResult.INSTANCE.getResult(4000, y.ٲٴݴ״ٰ(1782155856));
        } else if (!skipStart && CoreImpl.INSTANCE.isStarting()) {
            successResult = KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, y.ݮڮֲڭܩ(-628577764));
        } else if (isLoginProcess) {
            isLoginProcess = false;
            successResult = KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, y.ݬֲ֮ܲت(1512420615));
        } else if (CoreManager.INSTANCE.getInstance().getInfodesk() != null) {
            successResult = KGResult.INSTANCE.getSuccessResult();
        } else if (SDKVersion.isPublishing) {
            successResult = KGResult.INSTANCE.getResult(3001, y.ݮڮֲڭܩ(-628576644));
        } else if (CoreManager.INSTANCE.getInstance().loadInfodesk(false).isNotSuccess()) {
            successResult = KGResult.INSTANCE.getResult(1001, y.دײܮڳܯ(2051381581));
        } else {
            ConnectionManager.setConnectionType(activity, CoreManager.INSTANCE.getInstance().getConfiguration(), InfodeskHelper.INSTANCE.getServerConnectionType() == InfodeskHelper.ServerConnectionType.https);
            successResult = KGResult.INSTANCE.getSuccessResult();
        }
        if (successResult.isNotSuccess()) {
            return successResult;
        }
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(576672230));
        try {
            try {
                isLoginProcess = true;
                result = showCOPPA(activity, traceJobId);
                if (!result.isNotSuccess()) {
                    result = loginImpl(activity, idpCode, extras, traceJobId);
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            isLoginProcess = false;
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            isLoginProcess = false;
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> loginImpl(Activity activity, String idpCode, String extras, int traceJobId) {
        String str = y.ݮڮֲڭܩ(-628572900);
        String str2 = y.دײܮڳܯ(2051375909);
        String str3 = y.ۮڭڭܬި(862511891);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        try {
            if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
                AuthImpl authImpl = INSTANCE;
                IdpAccount idpAccount = authImpl.getIdpAccount();
                Intrinsics.checkNotNull(idpAccount);
                if (StringsKt.equals(idpCode, idpAccount.getIdpCode(), true)) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
                KGResult<Void> logout = CoreManager.INSTANCE.getInstance().logout();
                if (logout.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(logout);
                }
                authImpl.onLogout();
            }
            KGResult<IdpAccount> idpLogin = IdpAuthManager.idpLogin(activity, idpCode, extras, traceJobId);
            Logger.INSTANCE.m699d(str, str3 + idpLogin);
            if (idpLogin.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(idpLogin);
            }
            IdpAccount content = idpLogin.getContent();
            KGResult loginInternal$default = loginInternal$default(INSTANCE, activity, content, false, traceJobId, 4, null);
            Logger.INSTANCE.m699d(str, str2 + loginInternal$default);
            if (loginInternal$default.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(loginInternal$default);
            }
            Intrinsics.checkNotNull(content);
            ChannelConnectHelper.checkGoogleGame(activity, content);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ KGResult loginInternal$default(AuthImpl authImpl, Activity activity, IdpAccount idpAccount, boolean z, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            i = -1;
        }
        return authImpl.loginInternal(activity, idpAccount, z, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> loginInternal(Activity activity, IdpAccount account, boolean saveAccount, int traceJobId) {
        Object obj;
        String str = y.دײܮڳܯ(2051376061);
        String str2 = y.ݬֲ֮ܲت(1512616079);
        String str3 = y.ݬֲ֮ܲت(1512415535);
        Logger logger = Logger.INSTANCE;
        String str4 = y.ۮڭڭܬި(862513355) + account;
        String str5 = y.ݮڮֲڭܩ(-628572900);
        logger.m704i(str5, str4);
        try {
            if (account == null) {
                return KGResult.INSTANCE.getResult(4000, "account is null");
            }
            if (!Intrinsics.areEqual(KGIdpProfile.KGIdpCode.Kakao.getCode(), account.getIdpCode())) {
                KGResult<Void> checkAgreement = AgreementManager.checkAgreement(activity, account, AgreementManager.AgreementCheckType.LOGIN, traceJobId);
                Logger.INSTANCE.m699d(str5, str3 + checkAgreement);
                if (!checkAgreement.isSuccess()) {
                    return KGResult.INSTANCE.getResult(checkAgreement);
                }
            }
            KGResult<LoginData> authorize = CoreManager.INSTANCE.getInstance().authorize(account, saveAccount, traceJobId);
            if (authorize.isSuccess()) {
                LoginData content = authorize.getContent();
                Intrinsics.checkNotNull(content);
                Map<String, Object> player = content.getPlayer();
                if (player != null) {
                    if (player.containsKey(str2)) {
                        obj = player.get(str2);
                    } else {
                        Map<String, Object> agreementInfo = AgreementManager.INSTANCE.getAgreementInfo(activity);
                        obj = agreementInfo != null ? agreementInfo.get(str2) : null;
                    }
                    Map map = (Map) obj;
                    if (map != null && map.containsKey(str) && Intrinsics.areEqual(AgreementService.VALUE_YES, map.get(str))) {
                        PushPermissionManager.INSTANCE.requestPushPermission(activity, false);
                    }
                }
                AgreementManager.saveAgreementInfo(CoreManager.INSTANCE.getInstance().getContext(), traceJobId);
                UrlPromotionManager.checkUrlPromotion(activity);
                return KGResult.INSTANCE.getSuccessResult();
            }
            KGResult<Void> handleLoginResult = handleLoginResult(activity, account, authorize, saveAccount, traceJobId);
            if (authorize.getCode() == 463) {
                if (handleLoginResult.isSuccess()) {
                    return KGResult.INSTANCE.getSuccessResult();
                }
                if (handleLoginResult.getCode() == 463) {
                    return KGResult.INSTANCE.getResult(9001);
                }
                return KGResult.INSTANCE.getResult(handleLoginResult);
            }
            if (handleLoginResult.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(handleLoginResult);
            }
            return KGResult.INSTANCE.getResult(authorize);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final List<String> getAllowedIdpList() {
        ArrayList arrayList = new ArrayList();
        for (String str : InfodeskHelper.INSTANCE.getSupportedIdpCodes()) {
            if (FeatureManager.INSTANCE.allowConnectTo(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> connectWithUI(Activity activity) {
        KGIdpProfile idpProfile;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        if (CoreImpl.INSTANCE.isStarting()) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, y.ݮڮֲڭܩ(-628577764));
        }
        if (isLoginProcess) {
            isLoginProcess = false;
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, y.ݬֲ֮ܲت(1512420615));
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(4002, y.֬ڱܱײٮ(-1158888783));
        }
        FeatureManager featureManager = FeatureManager.INSTANCE;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        KGIdpProfile.KGIdpCode idpCode = (currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode();
        Intrinsics.checkNotNull(idpCode);
        if (!featureManager.allowConnectFrom(idpCode.getCode())) {
            KGResult.Companion companion = KGResult.INSTANCE;
            StringBuilder sb = new StringBuilder(y.دײܮڳܯ(2051381885));
            KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer2);
            KGIdpProfile idpProfile2 = currentPlayer2.getIdpProfile();
            Intrinsics.checkNotNull(idpProfile2);
            return companion.getResult(4002, sb.append(idpProfile2.getIdpCode()).toString());
        }
        int makeJob = Tracer.INSTANCE.makeJob(TraceJobCode.SDK_CONNECT);
        KGResult<Void> connectWithUIImpl = connectWithUIImpl(activity, makeJob);
        Tracer tracer = Tracer.INSTANCE;
        int code = connectWithUIImpl.getCode();
        String description = connectWithUIImpl.getDescription();
        if (description == null) {
            description = connectWithUIImpl.toString();
        }
        Tracer.finish$default(tracer, makeJob, code, description, null, 4, null);
        return connectWithUIImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> connectWithUIImpl(Activity activity, int traceJobId) {
        KGResult<Void> result;
        List<String> allowedIdpList;
        Object runBlocking$default;
        Object runBlocking$default2;
        KGResult<Void> result2;
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782160152);
        String str2 = y.ݮڮֲڭܩ(-628572900);
        logger.m704i(str2, str);
        try {
            try {
                isLoginProcess = true;
                isConnectProcess = true;
                allowedIdpList = getAllowedIdpList();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
            }
            if (!allowedIdpList.isEmpty()) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AuthImpl$connectWithUIImpl$connectCheckResult$1(activity, null), 1, null);
                KGResult kGResult = (KGResult) runBlocking$default;
                if (!kGResult.isNotSuccess()) {
                    runBlocking$default2 = BuildersKt__BuildersKt.runBlocking$default(null, new AuthImpl$connectWithUIImpl$connectResult$1(activity, allowedIdpList, traceJobId, null), 1, null);
                    KGResult kGResult2 = (KGResult) runBlocking$default2;
                    if (kGResult2.isNotSuccess()) {
                        if (CoreImpl.INSTANCE.isPaused()) {
                            isLoginProcess = false;
                            isConnectProcess = false;
                            CoreImpl.resume(activity);
                        }
                        result2 = KGResult.INSTANCE.getResult(kGResult2);
                    } else {
                        result = KGResult.INSTANCE.getSuccessResult();
                        return result;
                    }
                } else {
                    result2 = KGResult.INSTANCE.getResult(kGResult);
                }
            } else {
                result2 = KGResult.INSTANCE.getResult(3000, "idpCodes is empty");
            }
            return result2;
        } finally {
            isLoginProcess = false;
            isConnectProcess = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> connectWithoutUI(Activity activity, String idpCode, String extras, boolean logoutAlreadyUsedIdp) {
        KGIdpProfile idpProfile;
        KGIdpProfile idpProfile2;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        if (CoreImpl.INSTANCE.isStarting()) {
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, "starting");
        }
        if (isLoginProcess) {
            isLoginProcess = false;
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, "login/connect already called");
        }
        if (idpCode.length() == 0) {
            return KGResult.INSTANCE.getResult(4000, "idpCode is null");
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002, "not authorized");
        }
        FeatureManager featureManager = FeatureManager.INSTANCE;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        KGIdpProfile.KGIdpCode kGIdpCode = null;
        KGIdpProfile.KGIdpCode idpCode2 = (currentPlayer == null || (idpProfile2 = currentPlayer.getIdpProfile()) == null) ? null : idpProfile2.getIdpCode();
        Intrinsics.checkNotNull(idpCode2);
        if (!featureManager.allowConnectFrom(idpCode2.getCode())) {
            KGResult.Companion companion = KGResult.INSTANCE;
            StringBuilder sb = new StringBuilder("current account is not support to connect other idp: ");
            KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            if (currentPlayer2 != null && (idpProfile = currentPlayer2.getIdpProfile()) != null) {
                kGIdpCode = idpProfile.getIdpCode();
            }
            Intrinsics.checkNotNull(kGIdpCode);
            return companion.getResult(4002, sb.append(kGIdpCode.getCode()).toString());
        }
        if (!FeatureManager.INSTANCE.allowConnectTo(idpCode)) {
            return KGResult.INSTANCE.getResult(4000, idpCode + " idp is not supported to connect");
        }
        int makeJob = Tracer.INSTANCE.makeJob(TraceJobCode.SDK_CONNECT);
        KGResult<Void> connectWithoutUIImpl = connectWithoutUIImpl(activity, idpCode, extras, logoutAlreadyUsedIdp, makeJob);
        Tracer tracer = Tracer.INSTANCE;
        int code = connectWithoutUIImpl.getCode();
        String description = connectWithoutUIImpl.getDescription();
        if (description == null) {
            description = connectWithoutUIImpl.toString();
        }
        Tracer.finish$default(tracer, makeJob, code, description, null, 4, null);
        return connectWithoutUIImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> connectWithoutUIImpl(Activity activity, String idpCode, String extras, boolean logoutAlreadyUsedIdp, int traceJobId) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862514611) + idpCode;
        String str2 = y.ݮڮֲڭܩ(-628572900);
        logger.m704i(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ݬֲ֮ܲت(1512419007));
        isLoginProcess = true;
        isConnectProcess = true;
        try {
            try {
                KGResult<Void> connectImpl = connectImpl(activity, idpCode, extras, logoutAlreadyUsedIdp, traceJobId);
                if (connectImpl.isNotSuccess() && CoreImpl.INSTANCE.isPaused()) {
                    isLoginProcess = false;
                    isConnectProcess = false;
                    CoreImpl.resume(activity);
                }
                result = KGResult.INSTANCE.getResult(connectImpl.getCode(), connectImpl.getMessage());
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            isLoginProcess = false;
            isConnectProcess = false;
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            isLoginProcess = false;
            isConnectProcess = false;
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> connectImpl(Activity activity, String idpCode, String extras, boolean logoutAlreadyUsedIdp, int traceJobId) {
        String str = y.ݮڮֲڭܩ(-628572900);
        String str2 = y.ۮڭڭܬި(862512715);
        String str3 = y.ݮڮֲڭܩ(-628572724);
        String str4 = y.ۮڭڭܬި(862511891);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        try {
            KGResult<IdpAccount> idpLogin = IdpAuthManager.idpLogin(activity, idpCode, extras, traceJobId);
            Logger.INSTANCE.m699d(str, str4 + idpLogin);
            if (idpLogin.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(idpLogin);
            }
            IdpAccount content = idpLogin.getContent();
            KGResult<Void> connectInternal = INSTANCE.connectInternal(activity, content, traceJobId);
            Logger.INSTANCE.m699d(str, str3 + connectInternal);
            if (connectInternal.isNotSuccess()) {
                if (!logoutAlreadyUsedIdp && connectInternal.getCode() == 406) {
                    AuthDataManager.setTempAccount(activity, content);
                } else {
                    Intrinsics.checkNotNull(content);
                    Logger.INSTANCE.m699d(str, str2 + IdpAuthManager.logout(activity, content));
                }
                return KGResult.INSTANCE.getResult(connectInternal);
            }
            Intrinsics.checkNotNull(content);
            ChannelConnectHelper.checkGoogleGame(activity, content);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> connectInternal(Activity activity, IdpAccount account, int traceJobId) {
        String str = y.ݮڮֲڭܩ(-628572724);
        String str2 = y.ݬֲ֮ܲت(1512415535);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ۮڭڭܬި(862511683) + account;
        String str4 = y.ݮڮֲڭܩ(-628572900);
        logger.m704i(str4, str3);
        try {
            if (account == null) {
                return KGResult.INSTANCE.getResult(4000, "account is null");
            }
            if (!Intrinsics.areEqual(KGIdpProfile.KGIdpCode.Kakao.getCode(), account.getIdpCode())) {
                KGResult<Void> checkAgreement = AgreementManager.checkAgreement(activity, account, AgreementManager.AgreementCheckType.CONNECT, traceJobId);
                Logger.INSTANCE.m699d(str4, str2 + checkAgreement);
                if (checkAgreement.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(checkAgreement);
                }
            }
            KGResult<Void> connect = CoreManager.INSTANCE.getInstance().connect(account, true, traceJobId);
            Logger.INSTANCE.m699d(str4, str + connect);
            if (connect.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(connect);
            }
            AgreementManager.saveAgreementInfo(CoreManager.INSTANCE.getInstance().getContext(), -1);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> logout(Activity activity, boolean showUI) {
        KGResult<Void> result;
        String name;
        KGResult<Void> result2;
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782160784) + showUI;
        String str2 = y.ݮڮֲڭܩ(-628572900);
        logger.m704i(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ۮڭڭܬި(862514147));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (!CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
                Intrinsics.checkNotNull(authData);
                String idpCode = authData.getIdpCode();
                if (activity == null) {
                    KGResult<Void> logout = CoreManager.INSTANCE.getInstance().logout();
                    if (logout.isNotSuccess()) {
                        result2 = KGResult.INSTANCE.getResult(logout);
                    }
                    INSTANCE.onLogout();
                    result = KGResult.INSTANCE.getSuccessResult();
                    start.stop();
                    name = start.getName();
                    KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                    return result;
                }
                if (showUI) {
                    KGResult<Void> showLogoutPopup = LogoutUIManager.INSTANCE.showLogoutPopup(activity, idpCode, LogoutUIManager.RequestType.LOGOUT);
                    if (showLogoutPopup.isNotSuccess()) {
                        result2 = KGResult.INSTANCE.getResult(showLogoutPopup);
                    }
                }
                CustomProgressDialog customProgressDialog = new CustomProgressDialog(activity);
                if (showUI) {
                    customProgressDialog.show();
                }
                KGResult<Void> logout2 = CoreManager.INSTANCE.getInstance().logout();
                if (showUI) {
                    customProgressDialog.dismiss();
                }
                if (logout2.isNotSuccess()) {
                    result2 = KGResult.INSTANCE.getResult(logout2);
                }
                INSTANCE.onLogout();
                result = KGResult.INSTANCE.getSuccessResult();
                start.stop();
                name = start.getName();
                KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
                return result;
            }
            result2 = KGResult.INSTANCE.getResult(3002);
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
            return result2;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> unregister(Activity activity, boolean showUI) {
        KGResult<Void> result;
        String name;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393335666) + showUI;
        String str2 = y.ݮڮֲڭܩ(-628572900);
        logger.m704i(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1158889311));
        try {
            try {
                if (!SDKVersion.isPublishing) {
                    result = KGResult.INSTANCE.getResult(5001);
                } else if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                    result = KGResult.INSTANCE.getResult(3002);
                } else if (CoreManager.INSTANCE.getInstance().getAuthData() == null) {
                    result = KGResult.INSTANCE.getResult(3002);
                } else if (showUI) {
                    IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
                    Intrinsics.checkNotNull(authData);
                    KGResult<Void> showLogoutPopup = LogoutUIManager.INSTANCE.showLogoutPopup(activity, authData.getIdpCode(), LogoutUIManager.RequestType.UNREGISTER);
                    if (showLogoutPopup.isNotSuccess()) {
                        result = KGResult.INSTANCE.getResult(showLogoutPopup);
                    } else {
                        CustomProgressDialog customProgressDialog = new CustomProgressDialog(activity);
                        customProgressDialog.show();
                        KGResult<Void> requestUnregister = CoreManager.INSTANCE.getInstance().requestUnregister();
                        customProgressDialog.dismiss();
                        if (requestUnregister.isNotSuccess()) {
                            KGResult.INSTANCE.getResult(requestUnregister);
                        }
                        INSTANCE.onLogout();
                        result = KGResult.INSTANCE.getSuccessResult();
                    }
                } else {
                    KGResult<Void> requestUnregister2 = CoreManager.INSTANCE.getInstance().requestUnregister();
                    if (requestUnregister2.isNotSuccess()) {
                        KGResult.INSTANCE.getResult(requestUnregister2);
                    }
                    INSTANCE.onLogout();
                    result = KGResult.INSTANCE.getSuccessResult();
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult handleLoginResult$default(Activity activity, IdpAccount idpAccount, KGResult kGResult, boolean z, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            i = -1;
        }
        return handleLoginResult(activity, idpAccount, kGResult, z, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> handleLoginResult(Activity activity, IdpAccount authData, KGResult<LoginData> loginResult, boolean saveAccount, int traceJobId) {
        Object runBlocking$default;
        String str = y.دײܮڳܯ(2051377101);
        String str2 = y.ݮڮֲڭܩ(-628575740);
        String str3 = y.֬ڱܱײٮ(-1158884391);
        String str4 = y.ٴسسݬߨ(1393329802);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(loginResult, y.ݮڮֲڭܩ(-628575484));
        Logger logger = Logger.INSTANCE;
        String str5 = y.٬ݯح׭٩(576668558) + loginResult;
        String str6 = y.ݮڮֲڭܩ(-628572900);
        logger.m699d(str6, str5);
        int code = loginResult.getCode();
        String str7 = y.֬ڱܱײٮ(-1158881959);
        String str8 = y.ٲٴݴ״ٰ(1782161344);
        try {
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str6, e.toString(), e);
        }
        if (code != 494) {
            switch (code) {
                case 461:
                    LoginData content = loginResult.getContent();
                    Intrinsics.checkNotNull(content);
                    LoginData loginData = content;
                    if (authData == null) {
                        authData = AuthDataManager.getAccount();
                    }
                    if (loginData.isMarketRefund() && InfodeskHelper.INSTANCE.getUseCustomMarketRefundUIGooglePlay()) {
                        Logger.INSTANCE.m699d(str6, str8 + CoreManager.INSTANCE.getInstance().idpLogout(authData));
                        CoreManager.INSTANCE.getInstance().setMarketRefundInfoList(loginData.getMarketRefundInfoList());
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = loginData.get("restrReason");
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        return companion.getResult(KGResult.KGResultCode.PLAYER_MARKET_REFUND_PUNISHMENT, (String) obj);
                    }
                    KGResult<Void> showPunishment = LoginUIManager.showPunishment(activity, authData, loginData, saveAccount);
                    Logger.INSTANCE.m699d(str6, str7 + showPunishment);
                    return KGResult.INSTANCE.getResult(showPunishment);
                case 462:
                    Logger.INSTANCE.m699d(str6, str7 + LoginUIManager.showProtection(activity, loginResult.getContent()));
                    return KGResult.INSTANCE.getResult(9900);
                case 463:
                    if (authData == null) {
                        return KGResult.INSTANCE.getResult(463);
                    }
                    LoginData content2 = loginResult.getContent();
                    Intrinsics.checkNotNull(content2);
                    LoginData loginData2 = content2;
                    runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AuthImpl$handleLoginResult$showResult$1(activity, loginData2, null), 1, null);
                    KGResult kGResult = (KGResult) runBlocking$default;
                    Logger.INSTANCE.m699d(str6, str7 + kGResult);
                    if (kGResult.isSuccess()) {
                        KGResult<Void> cancelForRemove = LocalPlayerService.cancelForRemove(loginData2.getPlayerId(), traceJobId);
                        Logger.INSTANCE.m699d(str6, str4 + cancelForRemove);
                        if (cancelForRemove.isNotSuccess()) {
                            return KGResult.INSTANCE.getResult(cancelForRemove);
                        }
                        if (Intrinsics.areEqual(authData.getIdpCode(), KGIdpProfile.KGIdpCode.SigninWithApple.getCode())) {
                            authData.put("refreshToken", loginData2.getSiwaRefreshToken());
                        }
                        KGResult<LoginData> authorize = CoreManager.INSTANCE.getInstance().authorize(authData, saveAccount, traceJobId);
                        Logger.INSTANCE.m699d(str6, str + authorize);
                        if (authorize.isNotSuccess()) {
                            return KGResult.INSTANCE.getResult(authorize);
                        }
                    } else {
                        if (Intrinsics.areEqual(authData.getIdpCode(), KGIdpProfile.KGIdpCode.SigninWithApple.getCode())) {
                            Logger.INSTANCE.m699d(str6, str2 + AuthService.INSTANCE.revokeSIWA(loginData2.getPlayerId(), loginData2.getSiwaRefreshToken()));
                        }
                        Logger.INSTANCE.m699d(str6, str3 + CoreManager.INSTANCE.getInstance().idpLogout(authData));
                        return KGResult.INSTANCE.getResult(463);
                    }
                    break;
            }
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (authData == null) {
            authData = AuthDataManager.getAccount();
        }
        Logger.INSTANCE.m699d(str6, str8 + CoreManager.INSTANCE.getInstance().idpLogout(authData));
        Logger.INSTANCE.m699d(str6, str7 + LoginUIManager.showRestrictAdolescent(activity));
        return KGResult.INSTANCE.getResult(9900);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final IdpAccount getIdpAccount() {
        try {
            return CoreManager.INSTANCE.getInstance().getAuthData();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628572900), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void onLogout() {
        CoreImpl.INSTANCE.onLogout();
        AgreementManager.clearPreference(CoreManager.INSTANCE.getInstance().getContext());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> chooseIdpAccount(Activity activity, KGSessionForCustomUI.KGIdpChoiceMode idpChoiceMode) {
        String str = y.ٲٴݴ״ٰ(1782157632);
        String str2 = y.֬ڱܱײٮ(-1158884391);
        String str3 = y.ۮڭڭܬި(862512715);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(idpChoiceMode, y.ٴسسݬߨ(1393330282));
        Logger logger = Logger.INSTANCE;
        String str4 = y.ݬֲ֮ܲت(1512416055) + idpChoiceMode;
        String str5 = y.ݮڮֲڭܩ(-628572900);
        logger.m704i(str5, str4);
        try {
            IdpAccount tempAccount = AuthDataManager.getTempAccount();
            int i = WhenMappings.$EnumSwitchMapping$0[idpChoiceMode.ordinal()];
            if (i == 1) {
                Intrinsics.checkNotNull(tempAccount);
                Logger.INSTANCE.m699d(str5, str3 + IdpAuthManager.logout(activity, tempAccount));
            } else if (i == 2) {
                Logger.INSTANCE.m699d(str5, str2 + CoreManager.INSTANCE.getInstance().logout());
                KGResult loginInternal$default = loginInternal$default(INSTANCE, activity, tempAccount, false, 0, 12, null);
                Logger.INSTANCE.m699d(str5, str + loginInternal$default);
                if (loginInternal$default.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(loginInternal$default);
                }
                Intrinsics.checkNotNull(tempAccount);
                ChannelConnectHelper.checkGoogleGame(activity, tempAccount);
            }
            AuthDataManager.clearTempAccount(activity);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }
}
