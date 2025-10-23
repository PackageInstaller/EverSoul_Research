package com.kakaogame.auth;

import android.content.Context;
import android.text.TextUtils;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.LoginData;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.NetworkUtil;
import com.kakaogame.util.TelephonyUtil;
import com.kakaogame.util.VersionUtil;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AuthService.kt */
@Metadata(m838d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u000278B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J4\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J:\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J0\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u001a\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bH\u0007J\u0010\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0004H\u0007J*\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u000fH\u0007J\u0010\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u000fH\u0007J \u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u000f2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J \u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u00020\u0004J\u0018\u00102\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0018H\u0002J\u0018\u00104\u001a\u00020#2\u0006\u00103\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0016\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0\u000f2\u0006\u00106\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, m839d2 = {"Lcom/kakaogame/auth/AuthService;", "", "()V", "LOGIN_TYPE", "", "RESUME", "TAG", "configuration", "Lcom/kakaogame/config/Configuration;", "canIssueZat", "", "loginData", "Lcom/kakaogame/auth/LoginData;", "canLoginZat", "connect", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "context", "Landroid/content/Context;", "playerId", "account", "traceJobId", "", "getIDPLoginRequest", "Lcom/kakaogame/server/ServerRequest;", AuthService.LOGIN_TYPE, "Lcom/kakaogame/auth/AuthService$LoginType;", AuthService.RESUME, "retryCount", "", "getZatLoginRequest", "handleLoginResult", "result", "Lcom/kakaogame/server/ServerResult;", "initialize", "", "config", "isSupportIdpCode", "idpCode", "issueZatWithRefreshToken", "Lcom/kakaogame/auth/LoginData$ZinnyAccessToken;", ServerConstants.CAUSE, "logout", "Ljava/lang/Void;", "pause", "refreshZat", "removeForPunishmentUser", "onetimeToken", "revokeSIWA", "refreshToken", "setCommonLoginBody", "request", "setIdpLoginBody", "syncGooglePlayerId", "serverAuthToken", "LoginType", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthService {
    public static final AuthService INSTANCE = new AuthService();
    private static final String LOGIN_TYPE = "loginType";
    private static final String RESUME = "resume";
    private static final String TAG = "AuthService";
    private static Configuration configuration;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AuthService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Configuration config) {
        Intrinsics.checkNotNullParameter(config, y.ݮڮֲڭܩ(-628584492));
        configuration = config;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00b8 A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:3:0x003b, B:5:0x0043, B:8:0x0051, B:10:0x00ac, B:15:0x00b8, B:16:0x00bd, B:20:0x00cf, B:21:0x00d4, B:25:0x00e6, B:26:0x00eb, B:28:0x00f4, B:33:0x0100, B:34:0x0105, B:36:0x010e, B:39:0x0117, B:40:0x011c), top: B:2:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00cf A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:3:0x003b, B:5:0x0043, B:8:0x0051, B:10:0x00ac, B:15:0x00b8, B:16:0x00bd, B:20:0x00cf, B:21:0x00d4, B:25:0x00e6, B:26:0x00eb, B:28:0x00f4, B:33:0x0100, B:34:0x0105, B:36:0x010e, B:39:0x0117, B:40:0x011c), top: B:2:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e6 A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:3:0x003b, B:5:0x0043, B:8:0x0051, B:10:0x00ac, B:15:0x00b8, B:16:0x00bd, B:20:0x00cf, B:21:0x00d4, B:25:0x00e6, B:26:0x00eb, B:28:0x00f4, B:33:0x0100, B:34:0x0105, B:36:0x010e, B:39:0x0117, B:40:0x011c), top: B:2:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0100 A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:3:0x003b, B:5:0x0043, B:8:0x0051, B:10:0x00ac, B:15:0x00b8, B:16:0x00bd, B:20:0x00cf, B:21:0x00d4, B:25:0x00e6, B:26:0x00eb, B:28:0x00f4, B:33:0x0100, B:34:0x0105, B:36:0x010e, B:39:0x0117, B:40:0x011c), top: B:2:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:3:0x003b, B:5:0x0043, B:8:0x0051, B:10:0x00ac, B:15:0x00b8, B:16:0x00bd, B:20:0x00cf, B:21:0x00d4, B:25:0x00e6, B:26:0x00eb, B:28:0x00f4, B:33:0x0100, B:34:0x0105, B:36:0x010e, B:39:0x0117, B:40:0x011c), top: B:2:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0117 A[Catch: Exception -> 0x0126, TryCatch #0 {Exception -> 0x0126, blocks: (B:3:0x003b, B:5:0x0043, B:8:0x0051, B:10:0x00ac, B:15:0x00b8, B:16:0x00bd, B:20:0x00cf, B:21:0x00d4, B:25:0x00e6, B:26:0x00eb, B:28:0x00f4, B:33:0x0100, B:34:0x0105, B:36:0x010e, B:39:0x0117, B:40:0x011c), top: B:2:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<com.kakaogame.server.ServerRequest> getZatLoginRequest(android.content.Context r5, com.kakaogame.auth.LoginData r6, boolean r7, long r8) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.auth.AuthService.getZatLoginRequest(android.content.Context, com.kakaogame.auth.LoginData, boolean, long):com.kakaogame.KGResult");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x018f A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:4:0x005e, B:7:0x006c, B:9:0x007e, B:11:0x00a6, B:13:0x00b7, B:14:0x00c0, B:16:0x00cc, B:18:0x00d0, B:19:0x00e3, B:20:0x00f6, B:22:0x0102, B:23:0x011d, B:27:0x015e, B:28:0x0163, B:32:0x0175, B:33:0x017a, B:35:0x0183, B:40:0x018f, B:41:0x0194, B:43:0x019d, B:48:0x01a9, B:49:0x01ae, B:52:0x01bc, B:54:0x01d7, B:59:0x01e3, B:60:0x0205, B:62:0x020b, B:66:0x0218, B:68:0x021d, B:71:0x01e7, B:73:0x01f6, B:78:0x0202, B:84:0x00da, B:85:0x00ed), top: B:2:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a9 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:4:0x005e, B:7:0x006c, B:9:0x007e, B:11:0x00a6, B:13:0x00b7, B:14:0x00c0, B:16:0x00cc, B:18:0x00d0, B:19:0x00e3, B:20:0x00f6, B:22:0x0102, B:23:0x011d, B:27:0x015e, B:28:0x0163, B:32:0x0175, B:33:0x017a, B:35:0x0183, B:40:0x018f, B:41:0x0194, B:43:0x019d, B:48:0x01a9, B:49:0x01ae, B:52:0x01bc, B:54:0x01d7, B:59:0x01e3, B:60:0x0205, B:62:0x020b, B:66:0x0218, B:68:0x021d, B:71:0x01e7, B:73:0x01f6, B:78:0x0202, B:84:0x00da, B:85:0x00ed), top: B:2:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bc A[Catch: Exception -> 0x0224, TRY_ENTER, TryCatch #0 {Exception -> 0x0224, blocks: (B:4:0x005e, B:7:0x006c, B:9:0x007e, B:11:0x00a6, B:13:0x00b7, B:14:0x00c0, B:16:0x00cc, B:18:0x00d0, B:19:0x00e3, B:20:0x00f6, B:22:0x0102, B:23:0x011d, B:27:0x015e, B:28:0x0163, B:32:0x0175, B:33:0x017a, B:35:0x0183, B:40:0x018f, B:41:0x0194, B:43:0x019d, B:48:0x01a9, B:49:0x01ae, B:52:0x01bc, B:54:0x01d7, B:59:0x01e3, B:60:0x0205, B:62:0x020b, B:66:0x0218, B:68:0x021d, B:71:0x01e7, B:73:0x01f6, B:78:0x0202, B:84:0x00da, B:85:0x00ed), top: B:2:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e3 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:4:0x005e, B:7:0x006c, B:9:0x007e, B:11:0x00a6, B:13:0x00b7, B:14:0x00c0, B:16:0x00cc, B:18:0x00d0, B:19:0x00e3, B:20:0x00f6, B:22:0x0102, B:23:0x011d, B:27:0x015e, B:28:0x0163, B:32:0x0175, B:33:0x017a, B:35:0x0183, B:40:0x018f, B:41:0x0194, B:43:0x019d, B:48:0x01a9, B:49:0x01ae, B:52:0x01bc, B:54:0x01d7, B:59:0x01e3, B:60:0x0205, B:62:0x020b, B:66:0x0218, B:68:0x021d, B:71:0x01e7, B:73:0x01f6, B:78:0x0202, B:84:0x00da, B:85:0x00ed), top: B:2:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x020b A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:4:0x005e, B:7:0x006c, B:9:0x007e, B:11:0x00a6, B:13:0x00b7, B:14:0x00c0, B:16:0x00cc, B:18:0x00d0, B:19:0x00e3, B:20:0x00f6, B:22:0x0102, B:23:0x011d, B:27:0x015e, B:28:0x0163, B:32:0x0175, B:33:0x017a, B:35:0x0183, B:40:0x018f, B:41:0x0194, B:43:0x019d, B:48:0x01a9, B:49:0x01ae, B:52:0x01bc, B:54:0x01d7, B:59:0x01e3, B:60:0x0205, B:62:0x020b, B:66:0x0218, B:68:0x021d, B:71:0x01e7, B:73:0x01f6, B:78:0x0202, B:84:0x00da, B:85:0x00ed), top: B:2:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e7 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:4:0x005e, B:7:0x006c, B:9:0x007e, B:11:0x00a6, B:13:0x00b7, B:14:0x00c0, B:16:0x00cc, B:18:0x00d0, B:19:0x00e3, B:20:0x00f6, B:22:0x0102, B:23:0x011d, B:27:0x015e, B:28:0x0163, B:32:0x0175, B:33:0x017a, B:35:0x0183, B:40:0x018f, B:41:0x0194, B:43:0x019d, B:48:0x01a9, B:49:0x01ae, B:52:0x01bc, B:54:0x01d7, B:59:0x01e3, B:60:0x0205, B:62:0x020b, B:66:0x0218, B:68:0x021d, B:71:0x01e7, B:73:0x01f6, B:78:0x0202, B:84:0x00da, B:85:0x00ed), top: B:2:0x005c }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0202 A[Catch: Exception -> 0x0224, TryCatch #0 {Exception -> 0x0224, blocks: (B:4:0x005e, B:7:0x006c, B:9:0x007e, B:11:0x00a6, B:13:0x00b7, B:14:0x00c0, B:16:0x00cc, B:18:0x00d0, B:19:0x00e3, B:20:0x00f6, B:22:0x0102, B:23:0x011d, B:27:0x015e, B:28:0x0163, B:32:0x0175, B:33:0x017a, B:35:0x0183, B:40:0x018f, B:41:0x0194, B:43:0x019d, B:48:0x01a9, B:49:0x01ae, B:52:0x01bc, B:54:0x01d7, B:59:0x01e3, B:60:0x0205, B:62:0x020b, B:66:0x0218, B:68:0x021d, B:71:0x01e7, B:73:0x01f6, B:78:0x0202, B:84:0x00da, B:85:0x00ed), top: B:2:0x005c }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<com.kakaogame.server.ServerRequest> getIDPLoginRequest(android.content.Context r7, com.kakaogame.idp.IdpAccount r8, com.kakaogame.auth.AuthService.LoginType r9, boolean r10, long r11) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.auth.AuthService.getIDPLoginRequest(android.content.Context, com.kakaogame.idp.IdpAccount, com.kakaogame.auth.AuthService$LoginType, boolean, long):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<LoginData> handleLoginResult(ServerResult result) {
        Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782180032), y.٬ݯح׭٩(576668558) + result);
        if (result == null) {
            return KGResult.INSTANCE.getResult(2001);
        }
        if (result.isSuccess()) {
            JSONObject content = result.getContent();
            if (content == null) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            if (!content.containsKey((Object) y.ۮڭڭܬި(862276451))) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            if (!content.containsKey((Object) y.ݮڮֲڭܩ(-628583628))) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            if (!content.containsKey((Object) y.֬ڱܱײٮ(-1158900543))) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            LoginData loginData = new LoginData(content);
            if (TextUtils.isEmpty(loginData.getPlayerId())) {
                return KGResult.INSTANCE.getResult(2003, result.toString());
            }
            return KGResult.INSTANCE.getSuccessResult(loginData);
        }
        JSONObject content2 = result.getContent();
        int code = result.getCode();
        int i = 401;
        if (code == 412) {
            code = 401;
        }
        if (content2 != null) {
            LoginData loginData2 = new LoginData(content2);
            KGResult<LoginData> result2 = KGResult.INSTANCE.getResult(code, result.getDescription(), loginData2);
            if (code != 401) {
                return result2;
            }
            String str = y.ݬֲ֮ܲت(1512734375);
            if (!content2.containsKey((Object) str)) {
                return result2;
            }
            String str2 = y.دײܮڳܯ(2051571757);
            if (!content2.containsKey((Object) str2)) {
                return result2;
            }
            try {
                Long l = (Long) content2.get((Object) str2);
                KGResult.Companion companion = KGResult.INSTANCE;
                if (l != null) {
                    if (l.longValue() == -10) {
                        i = KGResult.KGResultCode.BLOCKED_COUNTRY_CODE;
                    } else if (l.longValue() == -20) {
                        i = KGResult.KGResultCode.BLOCKED_IP_ADDRESS;
                    } else if (l.longValue() < 0) {
                        i = (int) l.longValue();
                    }
                }
                String str3 = (String) content2.get((Object) str);
                if (str3 == null) {
                    str3 = "";
                }
                return companion.getResult(i, str3, loginData2);
            } catch (ClassCastException | NullPointerException unused) {
                return result2;
            }
        }
        return KGResult.INSTANCE.getResult(code, result.getDescription());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> pause() {
        String str = y.ٲٴݴ״ٰ(1782180032);
        try {
            Logger.INSTANCE.m699d(str, "pause");
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getZatPauseUri());
            LoginData loginData = AuthDataManager.getLoginData();
            Intrinsics.checkNotNull(loginData);
            LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
            Configuration configuration2 = configuration;
            Intrinsics.checkNotNull(configuration2);
            serverRequest.putBody("appId", configuration2.getAppId());
            Configuration configuration3 = configuration;
            Intrinsics.checkNotNull(configuration3);
            serverRequest.putBody("appSecret", configuration3.getAppSecret());
            serverRequest.putBody("playerId", loginData.getPlayerId());
            Configuration configuration4 = configuration;
            Intrinsics.checkNotNull(configuration4);
            serverRequest.putBody(ServerConstants.APP_VERSION, configuration4.getAppVersion());
            serverRequest.putBody(ServerConstants.SDK_VERSION, SdkManager.INSTANCE.getSdkVersion());
            serverRequest.putBody("os", KGSystem.getOSName());
            Configuration configuration5 = configuration;
            Intrinsics.checkNotNull(configuration5);
            serverRequest.putBody("market", configuration5.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            Intrinsics.checkNotNull(accessToken);
            serverRequest.putBody(ServerConstants.ZAT, accessToken.getZat());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            KGResult.Companion companion = KGResult.INSTANCE;
            Intrinsics.checkNotNull(requestServer$default, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            return companion.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> logout() {
        String str = y.ٲٴݴ״ٰ(1782180032);
        try {
            Logger.INSTANCE.m699d(str, "logout");
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getZatLogoutUri());
            LoginData loginData = AuthDataManager.getLoginData();
            if (loginData == null) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
            Configuration configuration2 = configuration;
            Intrinsics.checkNotNull(configuration2);
            serverRequest.putBody("appId", configuration2.getAppId());
            Configuration configuration3 = configuration;
            Intrinsics.checkNotNull(configuration3);
            serverRequest.putBody("appSecret", configuration3.getAppSecret());
            serverRequest.putBody("playerId", loginData.getPlayerId());
            Configuration configuration4 = configuration;
            Intrinsics.checkNotNull(configuration4);
            serverRequest.putBody(ServerConstants.APP_VERSION, configuration4.getAppVersion());
            serverRequest.putBody(ServerConstants.SDK_VERSION, SdkManager.INSTANCE.getSdkVersion());
            serverRequest.putBody("os", KGSystem.getOSName());
            Configuration configuration5 = configuration;
            Intrinsics.checkNotNull(configuration5);
            serverRequest.putBody("market", configuration5.getMarket());
            serverRequest.putBody(ServerConstants.DEVICE_ID, KGSystem.getDeviceId());
            Intrinsics.checkNotNull(accessToken);
            serverRequest.putBody(ServerConstants.ZAT, accessToken.getZat());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            KGResult.Companion companion = KGResult.INSTANCE;
            Intrinsics.checkNotNull(requestServer$default, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            return companion.getResult(requestServer$default);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<IdpAccount> connect(Context context, String playerId, IdpAccount account, int traceJobId) {
        JSONObject content;
        JSONObject content2;
        String str = y.ݮڮֲڭܩ(-628570132);
        String str2 = y.ٲٴݴ״ٰ(1782174560);
        String str3 = y.ٲٴݴ״ٰ(1781825344);
        String str4 = y.٬ݯح׭٩(576653590);
        String str5 = y.ٲٴݴ״ٰ(1782180032);
        String str6 = y.ٲٴݴ״ٰ(1782174280);
        String str7 = y.ٲٴݴ״ٰ(1782174440);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            Logger.INSTANCE.m699d(str5, str7 + account);
            if (TextUtils.isEmpty(playerId)) {
                return KGResult.INSTANCE.getResult(4000, "playerId is null");
            }
            if (account == null) {
                return KGResult.INSTANCE.getResult(4000, "account is null");
            }
            String str8 = Settings.INSTANCE.getConnectUriMap().get(account.getIdpCode());
            if (str8 == null) {
                Logger.INSTANCE.m701e(str5, str6 + account);
                return KGResult.INSTANCE.getResult(4000, str6 + account);
            }
            ServerRequest serverRequest = new ServerRequest(str8);
            AuthService authService = INSTANCE;
            authService.setCommonLoginBody(context, serverRequest);
            authService.setIdpLoginBody(serverRequest, account);
            serverRequest.putBody("playerId", playerId);
            serverRequest.putBody(str4, account.getIdpUserId());
            serverRequest.putBody("idpCode", account.getIdpCode());
            if (Intrinsics.areEqual(account.getIdpCode(), IdpAccount.IdpCode.TWITTER)) {
                serverRequest.putBody(ServerConstants.TWITTER_ACCESS_TOKEN_SECRET, account.getTokenSecret());
                serverRequest.putBody("consumerKey", account.getConsumerKey());
                serverRequest.putBody("consumerSecret", account.getConsumerSecret());
            }
            if (Intrinsics.areEqual(account.getIdpCode(), str3)) {
                serverRequest.putBody("authToken", account.getIdpAccessToken());
                serverRequest.putBody("redirectUri", account.getRedirectUri());
            } else {
                serverRequest.putBody("accessToken", account.getIdpAccessToken());
            }
            ServerResult requestServer = ServerService.requestServer(serverRequest, traceJobId);
            if (Intrinsics.areEqual(account.getIdpCode(), str3) && (content2 = requestServer.getContent()) != null) {
                Logger.INSTANCE.m699d(str5, content2.toString());
                if (content2.containsKey((Object) str2)) {
                    account.put("accessToken", (String) content2.get((Object) str2));
                }
                if (content2.containsKey((Object) str)) {
                    account.put("refreshToken", (String) content2.get((Object) str));
                }
            }
            if (Intrinsics.areEqual(account.getIdpCode(), IdpAccount.IdpCode.Gamania) && (content = requestServer.getContent()) != null) {
                Logger.INSTANCE.m699d(str5, content.toString());
                if (content.containsKey((Object) str4)) {
                    account.put("userId", (String) content.get((Object) str4));
                }
            }
            if (!requestServer.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer);
            }
            return KGResult.INSTANCE.getSuccessResult(account);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<LoginData.ZinnyAccessToken> refreshZat(Context context, LoginData loginData) {
        String str = y.֬ڱܱײٮ(-1158900543);
        String str2 = y.ٲٴݴ״ٰ(1782180032);
        String str3 = y.ݮڮֲڭܩ(-628583628);
        String str4 = y.دײܮڳܯ(2051379093);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(loginData, y.ۮڭڭܬި(862495171));
        try {
            Logger.INSTANCE.m699d(str2, str4 + loginData);
            LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getZatRefreshTokenUri());
            INSTANCE.setCommonLoginBody(context, serverRequest);
            Intrinsics.checkNotNull(accessToken);
            serverRequest.putBody(str3, accessToken.getZat());
            serverRequest.putBody("playerId", loginData.getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                KGResult.Companion companion = KGResult.INSTANCE;
                Intrinsics.checkNotNull(requestServer$default, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
                return companion.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            if (!content.containsKey((Object) str3)) {
                return KGResult.INSTANCE.getResult(2003, requestServer$default.toString());
            }
            if (!content.containsKey((Object) str)) {
                return KGResult.INSTANCE.getResult(2003, requestServer$default.toString());
            }
            Object obj = content.get((Object) str3);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = content.get((Object) str);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            return KGResult.INSTANCE.getSuccessResult(new LoginData.ZinnyAccessToken((String) obj, ((Long) obj2).longValue()));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<LoginData.ZinnyAccessToken> issueZatWithRefreshToken(Context context, LoginData loginData, String cause) {
        String str = y.֬ڱܱײٮ(-1158900543);
        String str2 = y.ݮڮֲڭܩ(-628583628);
        String str3 = y.ٲٴݴ״ٰ(1782180032);
        String str4 = y.ݮڮֲڭܩ(-628587364);
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(loginData, y.ۮڭڭܬި(862495171));
        try {
            Logger.INSTANCE.m699d(str3, str4 + loginData);
            LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getZatIssueTokenUri());
            INSTANCE.setCommonLoginBody(context, serverRequest);
            Intrinsics.checkNotNull(accessToken);
            serverRequest.putBody(ServerConstants.ZRT, accessToken.getZrt());
            serverRequest.putBody("playerId", loginData.getPlayerId());
            serverRequest.putBody(ServerConstants.DEVICE_APP_KEY, KGSystem.INSTANCE.getDeviceAppKey());
            serverRequest.putBody(ServerConstants.CAUSE, cause);
            ServerResult requestServerApi$default = OpenApiService.requestServerApi$default(serverRequest, 0, 2, null);
            if (!requestServerApi$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServerApi$default);
            }
            JSONObject content = requestServerApi$default.getContent();
            Intrinsics.checkNotNull(content);
            if (!content.containsKey((Object) str2)) {
                return KGResult.INSTANCE.getResult(2003, requestServerApi$default.toString());
            }
            if (!content.containsKey((Object) str)) {
                return KGResult.INSTANCE.getResult(2003, requestServerApi$default.toString());
            }
            Object obj = content.get((Object) str2);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Object obj2 = content.get((Object) str);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            return KGResult.INSTANCE.getSuccessResult(new LoginData.ZinnyAccessToken((String) obj, ((Long) obj2).longValue()));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean canLoginZat(LoginData loginData) {
        String str = y.ٲٴݴ״ٰ(1782180032);
        if (loginData == null) {
            Logger.INSTANCE.m701e(str, y.٬ݯح׭٩(576664590));
            return false;
        }
        LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
        if (accessToken == null) {
            Logger.INSTANCE.m701e(str, y.ٴسسݬߨ(1393356938));
            return false;
        }
        if (!accessToken.isExpired()) {
            return true;
        }
        Logger.INSTANCE.m701e(str, y.٬ݯح׭٩(576665318));
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean canIssueZat(LoginData loginData) {
        String str = y.ٲٴݴ״ٰ(1782180032);
        if (loginData == null) {
            Logger.INSTANCE.m701e(str, y.٬ݯح׭٩(576664590));
            return false;
        }
        LoginData.ZinnyAccessToken accessToken = loginData.getAccessToken();
        if (accessToken == null) {
            Logger.INSTANCE.m701e(str, y.ٴسسݬߨ(1393356938));
            return false;
        }
        if (!accessToken.isZrtExpired()) {
            return true;
        }
        Logger.INSTANCE.m701e(str, y.٬ݯح׭٩(576664982));
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> syncGooglePlayerId(String serverAuthToken) {
        String str = y.ٲٴݴ״ٰ(1782180032);
        String str2 = y.ٴسسݬߨ(1393345458);
        String str3 = y.ݬֲ֮ܲت(1512437583);
        Intrinsics.checkNotNullParameter(serverAuthToken, y.ٴسسݬߨ(1393352154));
        try {
            Logger.INSTANCE.m699d(str, str3 + serverAuthToken);
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSyncGooglePlayerIdUri());
            serverRequest.putBody("playerId", CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("authToken", serverAuthToken);
            ServerResult requestServerApi$default = OpenApiService.requestServerApi$default(serverRequest, 0, 2, null);
            if (requestServerApi$default.isNotSuccess()) {
                Logger.INSTANCE.m699d(str, str2 + requestServerApi$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> revokeSIWA(String playerId, String refreshToken) {
        String str = y.ٲٴݴ״ٰ(1782180032);
        String str2 = y.ٴسسݬߨ(1393345082);
        String str3 = y.ݬֲ֮ܲت(1512433815);
        String str4 = y.֬ڱܱײٮ(-1158898111);
        Intrinsics.checkNotNullParameter(refreshToken, str4);
        try {
            Logger.INSTANCE.m699d(str, str3 + refreshToken);
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getRevokeSIWAUri());
            serverRequest.putHeader("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            serverRequest.putHeader("appSecret", CoreManager.INSTANCE.getInstance().getConfiguration().getAppSecret());
            serverRequest.putBody("playerId", playerId);
            serverRequest.putBody(str4, refreshToken);
            ServerResult requestServerApi$default = OpenApiService.requestServerApi$default(serverRequest, 0, 2, null);
            if (requestServerApi$default.isNotSuccess()) {
                Logger.INSTANCE.m699d(str, str2 + requestServerApi$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> removeForPunishmentUser(String onetimeToken, String playerId) {
        String str = y.ۮڭڭܬި(862506555);
        String str2 = y.ۮڭڭܬި(862411867);
        Intrinsics.checkNotNullParameter(onetimeToken, y.٬ݯح׭٩(576652574));
        String str3 = y.ݬֲ֮ܲت(1512589743);
        Intrinsics.checkNotNullParameter(playerId, str3);
        Logger logger = Logger.INSTANCE;
        String str4 = y.ۮڭڭܬި(862496939);
        String str5 = y.ٲٴݴ״ٰ(1782180032);
        logger.m699d(str5, str4);
        try {
            String removeForPunishedUserUri = Settings.INSTANCE.getRemoveForPunishedUserUri();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(str2, CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            linkedHashMap.put(str, CoreManager.INSTANCE.getInstance().getConfiguration().getAppSecret());
            linkedHashMap.put(str3, playerId);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str2, CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            jSONObject.put(str, CoreManager.INSTANCE.getInstance().getConfiguration().getAppSecret());
            jSONObject.put(ServerConstants.ONETIME_TOKEN, onetimeToken);
            jSONObject.put(str3, playerId);
            return KGResult.INSTANCE.getResult(OpenApiService.requestOpenApi$default(OpenApiService.INSTANCE, removeForPunishedUserUri, "POST", linkedHashMap, jSONObject, (HttpService.HttpContentType) null, 0, 48, (Object) null));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str5, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isSupportIdpCode(String idpCode) {
        Intrinsics.checkNotNullParameter(idpCode, y.دײܮڳܯ(2051564517));
        return Settings.INSTANCE.getLoginUriMap().containsKey(idpCode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setCommonLoginBody(Context context, ServerRequest request) {
        Configuration configuration2 = configuration;
        Intrinsics.checkNotNull(configuration2);
        request.putBody(y.ۮڭڭܬި(862411867), configuration2.getAppId());
        Configuration configuration3 = configuration;
        Intrinsics.checkNotNull(configuration3);
        request.putBody(y.ۮڭڭܬި(862506555), configuration3.getAppSecret());
        Configuration configuration4 = configuration;
        Intrinsics.checkNotNull(configuration4);
        request.putBody(y.֬ڱܱײٮ(-1158899895), configuration4.getAppVersion());
        Configuration configuration5 = configuration;
        Intrinsics.checkNotNull(configuration5);
        request.putBody(y.دײܮڳܯ(2051758173), configuration5.getMarket());
        request.putBody(y.دײܮڳܯ(2051393733), KGSystem.getCountryCode());
        request.putBody(y.٬ݯح׭٩(576655054), KGSystem.getLanguageCode());
        request.putBody(y.٬ݯح׭٩(576655134), SdkManager.INSTANCE.getSdkVersion());
        request.putBody(y.٬ݯح׭٩(576655198), TelephonyUtil.getNetworkOperatorName(context));
        request.putBody(y.ݬֲ֮ܲت(1512431663), DeviceUtil.getDeviceBrand() + ' ' + DeviceUtil.getDeviceModel());
        request.putBody(y.ݮڮֲڭܩ(-628723908), KGSystem.getOSName());
        request.putBody(y.٬ݯح׭٩(576651310), VersionUtil.getOSVersion());
        request.putBody(y.ٴسسݬߨ(1393345546), NetworkUtil.getNetworkType(context));
        request.putBody(y.دײܮڳܯ(2051393261), KGSystem.getDeviceId());
        request.putBody(y.֬ڱܱײٮ(-1158899247), Long.valueOf(System.currentTimeMillis()));
        request.putBody(y.ٲٴݴ״ٰ(1782176344), Long.valueOf(LocaleManager.INSTANCE.getTimeZoneOffset()));
        try {
            String advertisingId = DeviceUtil.getAdvertisingId(context);
            if (!Intrinsics.areEqual(advertisingId, "")) {
                request.putBody(ServerConstants.ADID, advertisingId);
            }
            request.putBody(ServerConstants.WHITEKEY, DeviceUtil.getWhiteKey(context));
        } catch (RuntimeException e) {
            Logger.INSTANCE.m699d(y.ٲٴݴ״ٰ(1782180032), y.٬ݯح׭٩(576651774) + e);
        }
        request.putAllBody(Settings.INSTANCE.getLoginParamMap());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setIdpLoginBody(ServerRequest request, IdpAccount account) {
        if (StringsKt.equals(y.ݮڮֲڭܩ(-628796564), account.getIdpCode(), true)) {
            request.putBody(y.ۮڭڭܬި(862498427), KGSystem.getOSName());
        }
        if (StringsKt.equals(y.ٲٴݴ״ٰ(1782175880), account.getIdpCode(), true)) {
            String str = y.ٴسسݬߨ(1393345546);
            request.putBody(str, account.get(str));
            request.putBody(y.ݬֲ֮ܲت(1512431663), DeviceUtil.getDeviceModel());
        }
        if (StringsKt.equals(y.دײܮڳܯ(2051392101), account.getIdpCode(), true)) {
            String str2 = y.دײܮڳܯ(2051392229);
            request.putBody(str2, account.get(str2));
        }
    }

    /* compiled from: AuthService.kt */
    @Metadata(m838d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000fR\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000f¨\u0006 "}, m839d2 = {"Lcom/kakaogame/auth/AuthService$Settings;", "", "()V", "connectUriMap", "", "", "getConnectUriMap", "()Ljava/util/Map;", "loginParamMap", "", "getLoginParamMap", "loginUriMap", "getLoginUriMap", "removeForPunishedUserUri", "getRemoveForPunishedUserUri", "()Ljava/lang/String;", "setRemoveForPunishedUserUri", "(Ljava/lang/String;)V", "revokeSIWAUri", "getRevokeSIWAUri", "syncGooglePlayerIdUri", "getSyncGooglePlayerIdUri", "zatIssueTokenUri", "getZatIssueTokenUri", "zatLoginUri", "getZatLoginUri", "zatLogoutUri", "getZatLogoutUri", "zatPauseUri", "getZatPauseUri", "zatRefreshTokenUri", "getZatRefreshTokenUri", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static final Map<String, String> loginUriMap = MapsKt.mapOf(TuplesKt.m846to(KGIdpProfile.KGIdpCode.Guest.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576672526), y.٬ݯح׭٩(576672894))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Kakao.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628579164), y.ۮڭڭܬި(862517499))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Facebook.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628578756), y.دײܮڳܯ(2051379501))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Google.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862487843), y.֬ڱܱײٮ(-1158893111))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.SigninWithApple.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393356226), y.٬ݯح׭٩(576662182))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Twitter.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393356554), y.دײܮڳܯ(2051402317))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Gamania.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.֬ڱܱײٮ(-1158892079), y.٬ݯح׭٩(576663014))));
        private static final Map<String, String> connectUriMap = MapsKt.mapOf(TuplesKt.m846to(KGIdpProfile.KGIdpCode.Kakao.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782183312), y.ٴسسݬߨ(1393355538))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Facebook.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393353802), y.ݬֲ֮ܲت(1512427375))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Google.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862489827), y.ٲٴݴ״ٰ(1782184368))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.SigninWithApple.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393354538), y.ݬֲ֮ܲت(1512426439))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Twitter.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051400501), y.ٴسسݬߨ(1393353282))), TuplesKt.m846to(KGIdpProfile.KGIdpCode.Gamania.getCode(), OpenApiService.INSTANCE.setOpenApiUri(y.ݬֲ֮ܲت(1512425839), y.دײܮڳܯ(2051400125))));
        private static final Map<String, Object> loginParamMap = new LinkedHashMap();
        private static final String zatLoginUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782178736), y.ٴسسݬߨ(1393360146));
        private static final String zatLogoutUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576665998), y.ٴسسݬߨ(1393360434));
        private static final String zatPauseUri = OpenApiService.INSTANCE.setOpenApiUri(y.ݮڮֲڭܩ(-628569420), y.دײܮڳܯ(2051407357));
        private static final String zatRefreshTokenUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782178024), y.֬ڱܱײٮ(-1158896159));
        private static final String zatIssueTokenUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782179400), y.ݮڮֲڭܩ(-628568452));
        private static final String syncGooglePlayerIdUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576667382), y.ۮڭڭܬި(862491371));
        private static final String revokeSIWAUri = OpenApiService.INSTANCE.setOpenApiUri(y.٬ݯح׭٩(576663694), y.֬ڱܱײٮ(-1158895399));
        private static String removeForPunishedUserUri = y.֬ڱܱײٮ(-1158894615);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, String> getLoginUriMap() {
            return loginUriMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, String> getConnectUriMap() {
            return connectUriMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, Object> getLoginParamMap() {
            return loginParamMap;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getZatLoginUri() {
            return zatLoginUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getZatLogoutUri() {
            return zatLogoutUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getZatPauseUri() {
            return zatPauseUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getZatRefreshTokenUri() {
            return zatRefreshTokenUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getZatIssueTokenUri() {
            return zatIssueTokenUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSyncGooglePlayerIdUri() {
            return syncGooglePlayerIdUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRevokeSIWAUri() {
            return revokeSIWAUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getRemoveForPunishedUserUri() {
            return removeForPunishedUserUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setRemoveForPunishedUserUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            removeForPunishedUserUri = str;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AuthService.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/auth/AuthService$LoginType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "AUTO", "MANUAL", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class LoginType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LoginType[] $VALUES;
        public static final LoginType AUTO = new LoginType(y.֬ڱܱײٮ(-1158886479), 0, y.ۮڭڭܬި(862519147));
        public static final LoginType MANUAL = new LoginType(y.ٴسسݬߨ(1393333922), 1, y.ٴسسݬߨ(1393333986));
        private final String value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ LoginType[] $values() {
            return new LoginType[]{AUTO, MANUAL};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<LoginType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoginType valueOf(String str) {
            return (LoginType) Enum.valueOf(LoginType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static LoginType[] values() {
            return (LoginType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LoginType(String str, int i, String str2) {
            this.value = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            LoginType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
