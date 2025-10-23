package com.kakaogame.auth;

import android.content.Context;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.LoginData;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.idp.IdpAuthExHandler;
import com.kakaogame.idp.IdpAuthManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.AES256Cipher;
import com.kakaogame.util.PreferenceUtil;
import com.liapp.y;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: AuthDataManager.kt */
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u0010\u0010#\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!J\n\u0010$\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020'H\u0007J\u0006\u0010(\u001a\u00020\u001bJ\u0012\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020!H\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010\u00102\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\"\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.2\u0006\u0010 \u001a\u00020!2\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u00101\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u001c\u0010\u001a\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u00102\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u00103\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001a\u00104\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u00102\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u00105\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00010\tJ,\u00106\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u00107\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001a\u00108\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u00109\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0007J\u001a\u0010:\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010;\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, m839d2 = {"Lcom/kakaogame/auth/AuthDataManager;", "", "()V", "ACCOUNT_NAME", "", "LOGINDATA_NAME", "TAG", "TEMP_ACCOUNT_NAME", "account", "Lcom/kakaogame/idp/IdpAccount;", "getAccount$annotations", "getAccount", "()Lcom/kakaogame/idp/IdpAccount;", "appId", "lock", "loginData", "Lcom/kakaogame/auth/LoginData;", "getLoginData$annotations", "getLoginData", "()Lcom/kakaogame/auth/LoginData;", "playerId", "getPlayerId", "()Ljava/lang/String;", "prefKey", "reservedAccount", "reservedLoginData", "saveAccount", "", Configuration.KEY_SERVER_TYPE, "tempAccount", "clearAuthData", "", "context", "Landroid/content/Context;", "clearTempAccount", "getLastPlayerId", "getTempAccount", "initialize", "config", "Lcom/kakaogame/config/Configuration;", "isSaveAccount", "loadAccount", "loadLoginData", "loadTempAccount", "refreshTokenWithIdp", "requestIssueZAT", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", ServerConstants.CAUSE, "requestRefreshZAT", "idpAccount", "saveLoginData", "saveTempAccount", "setAccount", "setAuthData", "authData", "setTempAccount", "updateAccessToken", "updateCI", "ci", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthDataManager {
    private static String appId;
    private static String prefKey;
    private static IdpAccount reservedAccount;
    private static LoginData reservedLoginData;
    private static boolean saveAccount;
    private static String serverType;
    private static IdpAccount tempAccount;
    public static final AuthDataManager INSTANCE = new AuthDataManager();
    private static final String TAG = y.ݮڮֲڭܩ(-628585172);
    private static final String ACCOUNT_NAME = y.ٴسسݬߨ(1393343066);
    private static final String TEMP_ACCOUNT_NAME = y.ݬֲ֮ܲت(1512411607);
    private static final String LOGINDATA_NAME = y.دײܮڳܯ(2051389637);
    private static final Object lock = new Object();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getAccount$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getLoginData$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthDataManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Context context, Configuration config) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        AuthDataManager authDataManager = INSTANCE;
        appId = config.getAppId();
        serverType = config.getServerTypeString();
        prefKey = appId;
        boolean z = true;
        if (!StringsKt.equals(Configuration.KGServerType.LIVE.getValue(), serverType, true)) {
            prefKey += '_' + serverType;
        }
        Logger.INSTANCE.m699d(TAG, y.دײܮڳܯ(2051389877) + prefKey);
        synchronized (lock) {
            reservedLoginData = authDataManager.loadLoginData(context);
            reservedAccount = authDataManager.loadAccount(context);
            tempAccount = authDataManager.loadTempAccount(context);
            if (reservedAccount == null) {
                z = false;
            }
            saveAccount = z;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void clearAuthData(Context context) {
        Logger.INSTANCE.m699d(TAG, y.ݮڮֲڭܩ(-628584612));
        synchronized (lock) {
            reservedLoginData = null;
            reservedAccount = null;
            tempAccount = null;
            saveAccount = false;
            PreferenceUtil.remove(context, ACCOUNT_NAME);
            PreferenceUtil.remove(context, TEMP_ACCOUNT_NAME);
            PreferenceUtil.remove(context, LOGINDATA_NAME);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void clearTempAccount(Context context) {
        Logger.INSTANCE.m699d(TAG, y.ݮڮֲڭܩ(-628584612));
        synchronized (lock) {
            tempAccount = null;
            PreferenceUtil.remove(context, TEMP_ACCOUNT_NAME);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setAuthData(Context context, LoginData loginData, IdpAccount authData, boolean saveAccount2) {
        String str = y.ݬֲ֮ܲت(1512413407);
        String str2 = y.ۮڭڭܬި(862509787);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger logger = Logger.INSTANCE;
        String str3 = TAG;
        logger.m699d(str3, y.ݬֲ֮ܲت(1512417055));
        synchronized (lock) {
            IdpAccount idpAccount = reservedAccount;
            if (idpAccount == null) {
                reservedAccount = authData;
            } else {
                Intrinsics.checkNotNull(idpAccount);
                Intrinsics.checkNotNull(authData);
                idpAccount.update(authData);
            }
            LoginData loginData2 = reservedLoginData;
            if (loginData2 == null) {
                reservedLoginData = loginData;
            } else {
                Intrinsics.checkNotNull(loginData2);
                Intrinsics.checkNotNull(loginData);
                loginData2.update(loginData);
            }
            AuthDataManager authDataManager = INSTANCE;
            saveAccount = saveAccount2;
            authDataManager.saveLoginData(context, reservedLoginData);
            if (saveAccount2) {
                authDataManager.saveAccount(context, reservedAccount);
            } else {
                PreferenceUtil.remove(context, ACCOUNT_NAME);
            }
            Logger logger2 = Logger.INSTANCE;
            StringBuilder sb = new StringBuilder(str2);
            IdpAccount idpAccount2 = reservedAccount;
            Intrinsics.checkNotNull(idpAccount2);
            logger2.m699d(str3, sb.append(idpAccount2.toJSONString()).toString());
            Logger logger3 = Logger.INSTANCE;
            StringBuilder sb2 = new StringBuilder(str);
            LoginData loginData3 = reservedLoginData;
            Intrinsics.checkNotNull(loginData3);
            logger3.m699d(str3, sb2.append(loginData3.toJSONString()).toString());
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setAccount(Context context, IdpAccount account) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger.INSTANCE.m699d(TAG, y.٬ݯح׭٩(576669918));
        if (account == null) {
            return;
        }
        synchronized (lock) {
            IdpAccount idpAccount = reservedAccount;
            if (idpAccount == null) {
                reservedAccount = account;
            } else {
                Intrinsics.checkNotNull(idpAccount);
                idpAccount.update(account);
            }
            INSTANCE.saveAccount(context, reservedAccount);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setTempAccount(Context context, IdpAccount account) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger.INSTANCE.m699d(TAG, y.٬ݯح׭٩(576669918));
        if (account == null) {
            return;
        }
        synchronized (lock) {
            IdpAccount idpAccount = tempAccount;
            if (idpAccount == null) {
                tempAccount = account;
            } else {
                Intrinsics.checkNotNull(idpAccount);
                idpAccount.update(account);
            }
            INSTANCE.saveTempAccount(context, tempAccount);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void updateCI(Context context, String ci) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger.INSTANCE.m699d(TAG, y.٬ݯح׭٩(576669918));
        if (reservedAccount == null || ci == null) {
            return;
        }
        synchronized (lock) {
            IdpAccount idpAccount = reservedAccount;
            Intrinsics.checkNotNull(idpAccount);
            idpAccount.put("ci", ci);
            INSTANCE.saveAccount(context, reservedAccount);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void updateAccessToken(Context context) {
        String idpCode;
        IdpAuthExHandler idpAuthExHandler;
        IdpAccount idpAccount;
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger.INSTANCE.m699d(TAG, y.ٲٴݴ״ٰ(1782157912));
        AuthDataManager authDataManager = INSTANCE;
        IdpAccount account = getAccount();
        if (account == null || (idpCode = account.getIdpCode()) == null || (idpAuthExHandler = (IdpAuthExHandler) IdpAuthManager.getIdpAuthHadler(idpCode)) == null || (idpAccount = reservedAccount) == null) {
            return;
        }
        String accessToken = idpAuthExHandler.getAccessToken(CoreManager.INSTANCE.getInstance().getActivity());
        synchronized (lock) {
            idpAccount.put("accessToken", accessToken);
            authDataManager.saveAccount(context, idpAccount);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final LoginData getLoginData() {
        LoginData loginData;
        synchronized (lock) {
            loginData = reservedLoginData;
        }
        return loginData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final IdpAccount getAccount() {
        IdpAccount idpAccount;
        synchronized (lock) {
            idpAccount = reservedAccount;
        }
        return idpAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final IdpAccount getTempAccount() {
        IdpAccount idpAccount;
        synchronized (lock) {
            idpAccount = tempAccount;
        }
        return idpAccount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getPlayerId() {
        synchronized (lock) {
            LoginData loginData = reservedLoginData;
            if (loginData == null) {
                return "";
            }
            Intrinsics.checkNotNull(loginData);
            return loginData.getPlayerId();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isSaveAccount() {
        boolean z;
        synchronized (lock) {
            z = saveAccount;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void requestRefreshZAT(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        LoginData loginData = getLoginData();
        if (loginData == null || loginData.getAccessToken() == null) {
            return;
        }
        LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
        Intrinsics.checkNotNull(accessToken);
        if (accessToken.needRefresh()) {
            KGResult<LoginData.ZinnyAccessToken> refreshZat = AuthService.refreshZat(context, loginData);
            Logger.INSTANCE.m699d(TAG, y.دײܮڳܯ(2051379093) + refreshZat);
            if (refreshZat.isSuccess()) {
                LoginData.ZinnyAccessToken content = refreshZat.getContent();
                Intrinsics.checkNotNull(content);
                loginData.setAccessToken(content);
                synchronized (lock) {
                    LoginData loginData2 = reservedLoginData;
                    if (loginData2 == null) {
                        reservedLoginData = loginData;
                    } else {
                        Intrinsics.checkNotNull(loginData2);
                        loginData2.update(loginData);
                    }
                    INSTANCE.saveLoginData(context, reservedLoginData);
                    Unit unit = Unit.INSTANCE;
                }
                return;
            }
            if (refreshZat.getCode() == 406) {
                refreshTokenWithIdp();
                return;
            }
            if (refreshZat.getCode() == 400 || refreshZat.getCode() == 500 || refreshZat.getCode() == 503 || refreshZat.getCode() == 1001 || refreshZat.getCode() == 2001 || refreshZat.getCode() == 2003 || refreshZat.getCode() == 2004) {
                return;
            }
            CoreManager.INSTANCE.getInstance().onLogout(CoreManager.INSTANCE.getInstance().getPlayerId());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> requestIssueZAT(Context context, String cause) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        AuthDataManager authDataManager = INSTANCE;
        LoginData loginData = getLoginData();
        if (loginData == null) {
            return KGResult.INSTANCE.getResult(4002);
        }
        if (loginData.getAccessToken() == null) {
            return KGResult.INSTANCE.getResult(4002);
        }
        KGResult<LoginData.ZinnyAccessToken> issueZatWithRefreshToken = AuthService.issueZatWithRefreshToken(context, loginData, cause);
        Logger.INSTANCE.m699d(TAG, y.ݮڮֲڭܩ(-628587364) + issueZatWithRefreshToken);
        if (issueZatWithRefreshToken.isSuccess()) {
            LoginData.ZinnyAccessToken content = issueZatWithRefreshToken.getContent();
            Intrinsics.checkNotNull(content);
            loginData.setAccessToken(content);
            synchronized (lock) {
                LoginData loginData2 = reservedLoginData;
                if (loginData2 == null) {
                    reservedLoginData = loginData;
                } else {
                    Intrinsics.checkNotNull(loginData2);
                    loginData2.update(loginData);
                }
                authDataManager.saveLoginData(context, reservedLoginData);
                Unit unit = Unit.INSTANCE;
            }
            return KGResult.INSTANCE.getSuccessResult();
        }
        return KGResult.INSTANCE.getResult(issueZatWithRefreshToken);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void refreshTokenWithIdp() {
        KGResult<LoginData> autoLoginInternalForZatRefresh = CoreManager.INSTANCE.getInstance().autoLoginInternalForZatRefresh();
        Logger.INSTANCE.m699d(TAG, y.ݬֲ֮ܲت(1512414095) + autoLoginInternalForZatRefresh);
        if (autoLoginInternalForZatRefresh.isSuccess()) {
            return;
        }
        CoreManager.INSTANCE.getInstance().onLogout(CoreManager.INSTANCE.getInstance().getPlayerId());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getLastPlayerId(Context context) {
        try {
            LoginData loadLoginData = loadLoginData(context);
            return loadLoginData == null ? "" : loadLoginData.getPlayerId();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void saveAccount(Context context, IdpAccount idpAccount) {
        String encryptIV;
        Logger.INSTANCE.m699d(TAG, y.ۮڭڭܬި(862509211) + idpAccount);
        if (idpAccount == null) {
            return;
        }
        try {
            Map<String, Object> object = idpAccount.getObject();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 0);
            base64OutputStream.write(byteArray);
            base64OutputStream.close();
            String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
            if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
                return;
            }
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray2, "toByteArray(...)");
            String encodeString = AES256Cipher.encodeString(encryptKey, encryptIV, new String(byteArray2, Charsets.UTF_8));
            if (encodeString != null) {
                String str = ACCOUNT_NAME;
                String str2 = prefKey;
                Intrinsics.checkNotNull(str2);
                PreferenceUtil.setString(context, str, str2, encodeString);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void saveTempAccount(Context context, IdpAccount idpAccount) {
        String encryptIV;
        Logger.INSTANCE.m699d(TAG, y.٬ݯح׭٩(576681630) + idpAccount);
        if (idpAccount == null) {
            return;
        }
        try {
            Map<String, Object> object = idpAccount.getObject();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 0);
            base64OutputStream.write(byteArray);
            base64OutputStream.close();
            String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
            if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
                return;
            }
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray2, "toByteArray(...)");
            String encodeString = AES256Cipher.encodeString(encryptKey, encryptIV, new String(byteArray2, Charsets.UTF_8));
            if (encodeString != null) {
                String str = TEMP_ACCOUNT_NAME;
                String str2 = prefKey;
                Intrinsics.checkNotNull(str2);
                PreferenceUtil.setString(context, str, str2, encodeString);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void saveLoginData(Context context, LoginData loginData) {
        String encryptIV;
        Logger.INSTANCE.m699d(TAG, y.ۮڭڭܬި(862509843) + loginData);
        if (loginData == null) {
            return;
        }
        try {
            Map<String, Object> object = loginData.getObject();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 0);
            base64OutputStream.write(byteArray);
            base64OutputStream.close();
            String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
            if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null) {
                return;
            }
            byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray2, "toByteArray(...)");
            String encodeString = AES256Cipher.encodeString(encryptKey, encryptIV, new String(byteArray2, Charsets.UTF_8));
            if (encodeString != null) {
                String str = LOGINDATA_NAME;
                String str2 = prefKey;
                Intrinsics.checkNotNull(str2);
                PreferenceUtil.setString(context, str, str2, encodeString);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final IdpAccount loadAccount(Context context) {
        String encryptIV;
        String decodeString;
        IdpAccount idpAccount;
        String str = y.ٲٴݴ״ٰ(1782164288);
        String str2 = y.ۮڭڭܬި(862510587);
        String str3 = ACCOUNT_NAME;
        String str4 = prefKey;
        Intrinsics.checkNotNull(str4);
        String string = PreferenceUtil.getString(context, str3, str4, null);
        if (string != null) {
            try {
                String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
                if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null || (decodeString = AES256Cipher.decodeString(encryptKey, encryptIV, string)) == null) {
                    return null;
                }
                byte[] bytes = decodeString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                ObjectInputStream objectInputStream = new ObjectInputStream(new Base64InputStream(new ByteArrayInputStream(bytes), 0));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject == null) {
                    return null;
                }
                Logger logger = Logger.INSTANCE;
                String str5 = TAG;
                logger.m706v(str5, str2 + readObject.getClass());
                if (readObject instanceof Map) {
                    idpAccount = new IdpAccount(TypeIntrinsics.asMutableMap(readObject));
                } else {
                    idpAccount = readObject instanceof IdpAccount ? (IdpAccount) readObject : null;
                }
                Logger.INSTANCE.m706v(str5, str + idpAccount);
                return idpAccount;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final IdpAccount loadTempAccount(Context context) {
        String encryptIV;
        String decodeString;
        IdpAccount idpAccount;
        String str = y.٬ݯح׭٩(576680582);
        String str2 = y.ۮڭڭܬި(862510715);
        String str3 = TEMP_ACCOUNT_NAME;
        String str4 = prefKey;
        Intrinsics.checkNotNull(str4);
        String string = PreferenceUtil.getString(context, str3, str4, null);
        if (string != null) {
            try {
                String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
                if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null || (decodeString = AES256Cipher.decodeString(encryptKey, encryptIV, string)) == null) {
                    return null;
                }
                byte[] bytes = decodeString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                ObjectInputStream objectInputStream = new ObjectInputStream(new Base64InputStream(new ByteArrayInputStream(bytes), 0));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject == null) {
                    return null;
                }
                Logger logger = Logger.INSTANCE;
                String str5 = TAG;
                logger.m706v(str5, str2 + readObject.getClass());
                if (readObject instanceof Map) {
                    idpAccount = new IdpAccount(TypeIntrinsics.asMutableMap(readObject));
                } else {
                    idpAccount = readObject instanceof IdpAccount ? (IdpAccount) readObject : null;
                }
                Logger.INSTANCE.m706v(str5, str + idpAccount);
                return idpAccount;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final LoginData loadLoginData(Context context) {
        String encryptIV;
        String decodeString;
        LoginData loginData;
        String str = y.ݬֲ֮ܲت(1512414959);
        String str2 = y.ٴسسݬߨ(1393341858);
        String str3 = LOGINDATA_NAME;
        String str4 = prefKey;
        Intrinsics.checkNotNull(str4);
        String string = PreferenceUtil.getString(context, str3, str4, null);
        if (string != null) {
            try {
                String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
                if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null || (decodeString = AES256Cipher.decodeString(encryptKey, encryptIV, string)) == null) {
                    return null;
                }
                byte[] bytes = decodeString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                ObjectInputStream objectInputStream = new ObjectInputStream(new Base64InputStream(new ByteArrayInputStream(bytes), 0));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject == null) {
                    return null;
                }
                Logger logger = Logger.INSTANCE;
                String str5 = TAG;
                logger.m706v(str5, str2 + readObject.getClass());
                if (readObject instanceof Map) {
                    loginData = new LoginData(TypeIntrinsics.asMutableMap(readObject));
                } else {
                    loginData = readObject instanceof LoginData ? (LoginData) readObject : null;
                }
                Logger.INSTANCE.m706v(str5, str + loginData);
                return loginData;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
            }
        }
        return null;
    }
}
