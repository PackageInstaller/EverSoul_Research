package com.kakaogame.security;

import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.addon.KGService;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.Base64Util;
import com.kakaogame.util.json.JSONArray;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: SecondaryPWService.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0007J\u001e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00072\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00072\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0007J\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0007J\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00072\u0006\u0010\u001b\u001a\u00020\u0004J&\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004J\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\"\u001a\u00020\u0004J\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\"\u001a\u00020\u0004J\u001e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006("}, m839d2 = {"Lcom/kakaogame/security/SecondaryPWService;", "", "()V", "TAG", "", "TRANSFORMATION", "deletePassword", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "encryptDataRSA", "data", "key", "getKeypad", "Lcom/kakaogame/security/KeypadDataResult;", KGService.COUNT, "", "getUserState", "Lcom/kakaogame/security/UserState;", "matchPassword", "password", "publicKey", "sendCodeWithEmail", "Lcom/kakaogame/security/SendAuthCodeResult;", "email", "sendCodeWithExistType", "sendCodeWithKakaoTalk", "sendCodeWithSMS", ServerConstants.PHONE_NUMBER, "setPassword", Base2ndPWViewData.KEY_CONFIRM, "stringToPublicKey", "Ljava/security/PublicKey;", "publicKeyString", "verifyEmailAuthCode", "code", ServerConstants.EMAIL_ADDRESS, "verifyExistAuthCode", "verifyKakaoTalkAuthCode", "verifySMSAuthCode", "Settings", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class SecondaryPWService {
    public static final SecondaryPWService INSTANCE = new SecondaryPWService();
    private static final String TAG = "SecondaryPWService";
    private static final String TRANSFORMATION = "RSA/ECB/OAEPPadding";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SecondaryPWService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<UserState> getUserState() {
        String str = y.ٲٴݴ״ٰ(1782047088);
        String str2 = y.ݬֲ֮ܲت(1512814407);
        String str3 = y.دײܮڳܯ(2051571757);
        String str4 = y.ݬֲ֮ܲت(1512589743);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getUserStatusUri());
            serverRequest.putHeader(str4, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str4, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return KGResult.INSTANCE.getSuccessResult(new UserState(true, false, 0, 0, 14, null));
            }
            Object obj2 = jSONObject.get((Object) str3);
            Intrinsics.checkNotNull(obj2, str2);
            String str5 = (String) obj2;
            if (Intrinsics.areEqual(str5, "567")) {
                return KGResult.INSTANCE.getSuccessResult(new UserState(false, false, 0, 0, 14, null));
            }
            if (Intrinsics.areEqual(str5, "565")) {
                Object obj3 = jSONObject.get((Object) "remainingTime");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
                JSONObject jSONObject2 = (JSONObject) obj3;
                Object obj4 = jSONObject2.get((Object) "minutes");
                Intrinsics.checkNotNull(obj4, str);
                int intValue = ((Number) obj4).intValue();
                Object obj5 = jSONObject2.get((Object) "seconds");
                Intrinsics.checkNotNull(obj5, str);
                return KGResult.INSTANCE.getSuccessResult(new UserState(true, true, intValue, ((Number) obj5).intValue()));
            }
            KGResult.Companion companion = KGResult.INSTANCE;
            Object obj6 = jSONObject.get((Object) str3);
            Intrinsics.checkNotNull(obj6, str2);
            return companion.getResult(Integer.parseInt((String) obj6));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<SendAuthCodeResult> sendCodeWithKakaoTalk() {
        String str = y.ݬֲ֮ܲت(1512589743);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSendKakaoTalkUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            String str2 = y.ݬֲ֮ܲت(1512814407);
            if (booleanValue) {
                Object obj2 = jSONObject.get((Object) "authType");
                Intrinsics.checkNotNull(obj2, str2);
                if (SecondaryPWServiceKt.getSendAuthType((String) obj2) == SendAuthType.TALK) {
                    return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(true, null, null, 6, null));
                }
                Object obj3 = jSONObject.get((Object) "authKey");
                Intrinsics.checkNotNull(obj3, str2);
                return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(true, SendAuthType.SMS, (String) obj3));
            }
            Object obj4 = jSONObject.get((Object) "code");
            Intrinsics.checkNotNull(obj4, str2);
            String str3 = (String) obj4;
            switch (str3.hashCode()) {
                case 51700:
                    if (!str3.equals("466")) {
                        return KGResult.INSTANCE.getResult(9999);
                    }
                    return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(false, SendAuthType.SMS, null, 4, null));
                case 51701:
                    if (str3.equals("467")) {
                        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.AUTH_CODE_TIME_ERROR);
                    }
                    return KGResult.INSTANCE.getResult(9999);
                case 51726:
                    if (str3.equals("471")) {
                        return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(false, SendAuthType.SMS, null, 4, null));
                    }
                    return KGResult.INSTANCE.getResult(9999);
                default:
                    return KGResult.INSTANCE.getResult(9999);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> verifyKakaoTalkAuthCode(String code) {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.دײܮڳܯ(2051571757);
        Intrinsics.checkNotNullParameter(code, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getVerifyKakaoTalkAuthCodeUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            serverRequest.putBody(ServerConstants.AUTH_CODE_NUMBER, code);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            Object obj2 = jSONObject.get((Object) str2);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj2;
            return Intrinsics.areEqual(str3, "461") ? KGResult.INSTANCE.getResult(461) : Intrinsics.areEqual(str3, "462") ? KGResult.INSTANCE.getResult(462) : KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<SendAuthCodeResult> sendCodeWithSMS(String phoneNumber) {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.ٴسسݬߨ(1393059690);
        Intrinsics.checkNotNullParameter(phoneNumber, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSendSMSUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            if (Intrinsics.areEqual(KGSystem.getCountryCode(), LocaleManager.KOREA_COUNTRY_CODE)) {
                serverRequest.putBody(ServerConstants.COUNTRY_NUMBER, 82);
            }
            serverRequest.putBody(str2, phoneNumber);
            serverRequest.putBody("countryCode", KGSystem.getCountryCode());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            String str3 = y.ݬֲ֮ܲت(1512814407);
            if (booleanValue) {
                Object obj2 = jSONObject.get((Object) "authType");
                Intrinsics.checkNotNull(obj2, str3);
                if (SecondaryPWServiceKt.getSendAuthType((String) obj2) == SendAuthType.TALK) {
                    return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(true, null, null, 6, null));
                }
                Object obj3 = jSONObject.get((Object) "authKey");
                Intrinsics.checkNotNull(obj3, str3);
                return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(true, SendAuthType.SMS, (String) obj3));
            }
            Object obj4 = jSONObject.get((Object) "code");
            Intrinsics.checkNotNull(obj4, str3);
            String str4 = (String) obj4;
            return Intrinsics.areEqual(str4, "478") ? KGResult.INSTANCE.getResult(KGResult.KGResultCode.INVALID_PHONE_NUMBER) : Intrinsics.areEqual(str4, "467") ? KGResult.INSTANCE.getResult(KGResult.KGResultCode.AUTH_CODE_TIME_ERROR) : KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<SendAuthCodeResult> sendCodeWithEmail(String email) {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.֬ڱܱײٮ(-1159479551);
        Intrinsics.checkNotNullParameter(email, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSendEmailUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            serverRequest.putBody(str2, email);
            serverRequest.putBody("lang", KGSystem.getLanguageCode());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            String str3 = y.ݬֲ֮ܲت(1512814407);
            if (booleanValue) {
                Object obj2 = jSONObject.get((Object) "authKey");
                Intrinsics.checkNotNull(obj2, str3);
                return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(true, SendAuthType.EMAIL, (String) obj2));
            }
            Object obj3 = jSONObject.get((Object) "code");
            Intrinsics.checkNotNull(obj3, str3);
            String str4 = (String) obj3;
            switch (str4.hashCode()) {
                case 51700:
                    if (!str4.equals("466")) {
                        break;
                    } else {
                        return KGResult.INSTANCE.getResult(462);
                    }
                case 51701:
                    if (!str4.equals("467")) {
                        break;
                    } else {
                        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.AUTH_CODE_TIME_ERROR);
                    }
                case 51727:
                    if (str4.equals("472")) {
                        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.INVALID_EMAIL_ADDRESS);
                    }
                    break;
            }
            return KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> verifySMSAuthCode(String code, String phoneNumber) {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.دײܮڳܯ(2051571757);
        Intrinsics.checkNotNullParameter(code, str2);
        String str3 = y.ٴسسݬߨ(1393059690);
        Intrinsics.checkNotNullParameter(phoneNumber, str3);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getVerifySMSAuthCodeUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            serverRequest.putBody(ServerConstants.AUTH_CODE_NUMBER, code);
            if (Intrinsics.areEqual(KGSystem.getCountryCode(), LocaleManager.KOREA_COUNTRY_CODE)) {
                serverRequest.putBody(ServerConstants.COUNTRY_NUMBER, 82);
            }
            serverRequest.putBody(str3, phoneNumber);
            serverRequest.putBody("countryCode", KGSystem.getCountryCode());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            Object obj2 = jSONObject.get((Object) str2);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str4 = (String) obj2;
            return Intrinsics.areEqual(str4, "461") ? KGResult.INSTANCE.getResult(461) : Intrinsics.areEqual(str4, "462") ? KGResult.INSTANCE.getResult(462) : KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> verifyEmailAuthCode(String code, String emailAddress) {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.دײܮڳܯ(2051571757);
        Intrinsics.checkNotNullParameter(code, str2);
        String str3 = y.دײܮڳܯ(2051105829);
        Intrinsics.checkNotNullParameter(emailAddress, str3);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getVerifyEmailAuthCodeUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            serverRequest.putBody(ServerConstants.AUTH_CODE_NUMBER, code);
            serverRequest.putBody(str3, emailAddress);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            Object obj2 = jSONObject.get((Object) str2);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str4 = (String) obj2;
            return Intrinsics.areEqual(str4, "461") ? KGResult.INSTANCE.getResult(461) : Intrinsics.areEqual(str4, "462") ? KGResult.INSTANCE.getResult(462) : KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<SendAuthCodeResult> sendCodeWithExistType() {
        String str = y.ݬֲ֮ܲت(1512589743);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSendExistUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            String str2 = y.ݬֲ֮ܲت(1512814407);
            if (booleanValue) {
                Object obj2 = jSONObject.get((Object) "authType");
                Intrinsics.checkNotNull(obj2, str2);
                if (SecondaryPWServiceKt.getSendAuthType((String) obj2) == SendAuthType.TALK) {
                    return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(true, null, null, 6, null));
                }
                Object obj3 = jSONObject.get((Object) "authKey");
                Intrinsics.checkNotNull(obj3, str2);
                return KGResult.INSTANCE.getSuccessResult(new SendAuthCodeResult(true, SendAuthType.SMS, (String) obj3));
            }
            Object obj4 = jSONObject.get((Object) "code");
            Intrinsics.checkNotNull(obj4, str2);
            return Intrinsics.areEqual((String) obj4, "467") ? KGResult.INSTANCE.getResult(KGResult.KGResultCode.AUTH_CODE_TIME_ERROR) : KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> verifyExistAuthCode(String code) {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.دײܮڳܯ(2051571757);
        Intrinsics.checkNotNullParameter(code, str2);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getVerifyExistAuthCodeUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            serverRequest.putBody(ServerConstants.AUTH_CODE_NUMBER, code);
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            Object obj2 = jSONObject.get((Object) str2);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str3 = (String) obj2;
            return Intrinsics.areEqual(str3, "461") ? KGResult.INSTANCE.getResult(461) : Intrinsics.areEqual(str3, "462") ? KGResult.INSTANCE.getResult(462) : KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<KeypadDataResult> getKeypad(int count) {
        String str = y.ݮڮֲڭܩ(-628332684);
        String str2 = y.ݬֲ֮ܲت(1512589743);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getGetKeypadUri());
            serverRequest.putHeader(str2, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str2, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            serverRequest.putBody(ServerConstants.SIZE, Integer.valueOf(count));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean z = !((Boolean) obj).booleanValue();
            String str3 = y.ݬֲ֮ܲت(1512814407);
            if (z) {
                Object obj2 = jSONObject.get((Object) "code");
                Intrinsics.checkNotNull(obj2, str3);
                if (Intrinsics.areEqual((String) obj2, "565")) {
                    return KGResult.INSTANCE.getResult(KGResult.KGResultCode.BLOCKED_USER_ACCESS);
                }
                return KGResult.INSTANCE.getResult(9999);
            }
            Object obj3 = jSONObject.get((Object) Base2ndPWViewData.KEY_KEYPAD);
            Intrinsics.checkNotNull(obj3, str);
            JSONObject jSONObject2 = (JSONObject) obj3;
            Object obj4 = jSONObject2.get((Object) "publicKey");
            Intrinsics.checkNotNull(obj4, str3);
            String str4 = (String) obj4;
            Object obj5 = jSONObject2.get((Object) "keypadList");
            Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type com.kakaogame.util.json.JSONArray");
            JSONArray jSONArray = (JSONArray) obj5;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jSONArray, 10));
            for (Object obj6 : jSONArray) {
                Intrinsics.checkNotNull(obj6, str);
                Object obj7 = ((JSONObject) obj6).get((Object) "imageRawData");
                Intrinsics.checkNotNull(obj7, str3);
                Object obj8 = ((JSONObject) obj6).get((Object) "charValues");
                Intrinsics.checkNotNull(obj8, str3);
                arrayList.add(new KeypadRawData((String) obj7, (String) obj8));
            }
            return KGResult.INSTANCE.getSuccessResult(new KeypadDataResult(str4, arrayList));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> setPassword(String password, String confirm, String publicKey) {
        String str = y.ݬֲ֮ܲت(1512589743);
        Intrinsics.checkNotNullParameter(password, y.ٲٴݴ״ٰ(1782362744));
        Intrinsics.checkNotNullParameter(confirm, y.ۮڭڭܬި(862392731));
        Intrinsics.checkNotNullParameter(publicKey, y.֬ڱܱײٮ(-1159073663));
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getSetPasswordUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            serverRequest.putBody(str, currentPlayer != null ? currentPlayer.getPlayerId() : null);
            serverRequest.putBody("os", KGSystem.getOSName());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody(ServerConstants.PIN_LIST, CollectionsKt.listOf((Object[]) new String[]{encryptDataRSA(password, publicKey), encryptDataRSA(confirm, publicKey)}));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            Object obj2 = jSONObject.get((Object) "code");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            String str2 = (String) obj2;
            int hashCode = str2.hashCode();
            if (hashCode != 51703) {
                if (hashCode != 52659) {
                    if (hashCode == 52663 && str2.equals("568")) {
                        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.SAME_PASSWORD_USED);
                    }
                } else if (str2.equals("564")) {
                    return KGResult.INSTANCE.getResult(461);
                }
            } else if (str2.equals("469")) {
                return KGResult.INSTANCE.getResult(469);
            }
            return KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Integer> matchPassword(String password, String publicKey) {
        String str = y.ݬֲ֮ܲت(1512589743);
        Intrinsics.checkNotNullParameter(password, y.ٲٴݴ״ٰ(1782362744));
        Intrinsics.checkNotNullParameter(publicKey, y.֬ڱܱײٮ(-1159073663));
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getMatchPasswordUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            serverRequest.putBody(str, currentPlayer.getPlayerId());
            serverRequest.putBody("os", KGSystem.getOSName());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            serverRequest.putBody(ServerConstants.PIN, encryptDataRSA(password, publicKey));
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            JSONObject content = requestServer$default.getContent();
            Intrinsics.checkNotNull(content);
            JSONObject jSONObject = content;
            Object obj = jSONObject.get((Object) "result");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            boolean booleanValue = ((Boolean) obj).booleanValue();
            String str2 = (String) jSONObject.get((Object) "code");
            Number number = (Number) jSONObject.get((Object) "pinFailCount");
            int intValue = number != null ? number.intValue() : 1;
            if (booleanValue) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            if (str2 == null) {
                return KGResult.INSTANCE.getResult(9999);
            }
            return Intrinsics.areEqual(str2, "469") ? KGResult.INSTANCE.getResult(469) : Intrinsics.areEqual(str2, "565") ? KGResult.INSTANCE.getResult(KGResult.KGResultCode.BLOCKED_USER_ACCESS) : Intrinsics.areEqual(str2, "563") ? KGResult.INSTANCE.getResult(KGResult.KGResultCode.NOT_MATCHED_PASSWORD, "not_matched", Integer.valueOf(intValue)) : KGResult.INSTANCE.getResult(9999);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> deletePassword() {
        String str = y.ݬֲ֮ܲت(1512589743);
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getDeletePasswordUri());
            serverRequest.putHeader(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            serverRequest.putBody(str, currentPlayer.getPlayerId());
            serverRequest.putBody("os", KGSystem.getOSName());
            serverRequest.putBody("country", KGSystem.getCountryCode());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (!requestServer$default.isSuccess()) {
                return KGResult.INSTANCE.getResult(requestServer$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159196743), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final PublicKey stringToPublicKey(String publicKeyString) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Util.INSTANCE.getBase64decodeByteString(publicKeyString)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String encryptDataRSA(String data, String key) {
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, y.ٴسسݬߨ(1393410554));
        try {
            PublicKey stringToPublicKey = stringToPublicKey(key);
            if (stringToPublicKey == null) {
                return null;
            }
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(1, stringToPublicKey);
            return Base64Util.getBase64encodeFromData(cipher.doFinal(bytes), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* compiled from: SecondaryPWService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0011\u0010\u001f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006¨\u0006!"}, m839d2 = {"Lcom/kakaogame/security/SecondaryPWService$Settings;", "", "()V", "deletePasswordUri", "", "getDeletePasswordUri", "()Ljava/lang/String;", "getKeypadUri", "getGetKeypadUri", "matchPasswordUri", "getMatchPasswordUri", "sendEmailUri", "getSendEmailUri", "sendExistUri", "getSendExistUri", "sendKakaoTalkUri", "getSendKakaoTalkUri", "sendSMSUri", "getSendSMSUri", "setPasswordUri", "getSetPasswordUri", "userStatusUri", "getUserStatusUri", "setUserStatusUri", "(Ljava/lang/String;)V", "verifyEmailAuthCodeUri", "getVerifyEmailAuthCodeUri", "verifyExistAuthCodeUri", "getVerifyExistAuthCodeUri", "verifyKakaoTalkAuthCodeUri", "getVerifyKakaoTalkAuthCodeUri", "verifySMSAuthCodeUri", "getVerifySMSAuthCodeUri", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String userStatusUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393052514), y.٬ݯح׭٩(576421958));
        private static final String sendKakaoTalkUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782405664), y.֬ڱܱײٮ(-1159193671));
        private static final String sendSMSUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٴسسݬߨ(1393051394), y.ٴسسݬߨ(1393049850));
        private static final String sendEmailUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862726211), y.֬ڱܱײٮ(-1159192591));
        private static final String sendExistUri = y.֬ڱܱײٮ(-1159192943);
        private static final String verifyKakaoTalkAuthCodeUri = OpenApiService.INSTANCE.setOpenApiUri(y.ٲٴݴ״ٰ(1782399504), y.ۮڭڭܬި(862730067));
        private static final String verifySMSAuthCodeUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051104061), y.ۮڭڭܬި(862728595));
        private static final String verifyEmailAuthCodeUri = OpenApiService.INSTANCE.setOpenApiUri(y.ۮڭڭܬި(862728371), y.ݬֲ֮ܲت(1512141175));
        private static final String verifyExistAuthCodeUri = y.٬ݯح׭٩(576430062);
        private static final String getKeypadUri = OpenApiService.INSTANCE.setOpenApiUri(y.دײܮڳܯ(2051102517), y.٬ݯح׭٩(576426566));
        private static final String setPasswordUri = y.٬ݯح׭٩(576426782);
        private static final String matchPasswordUri = y.٬ݯح׭٩(576427126);
        private static final String deletePasswordUri = y.ۮڭڭܬި(862730331);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getUserStatusUri() {
            return userStatusUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setUserStatusUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            userStatusUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendKakaoTalkUri() {
            return sendKakaoTalkUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendSMSUri() {
            return sendSMSUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendEmailUri() {
            return sendEmailUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSendExistUri() {
            return sendExistUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getVerifyKakaoTalkAuthCodeUri() {
            return verifyKakaoTalkAuthCodeUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getVerifySMSAuthCodeUri() {
            return verifySMSAuthCodeUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getVerifyEmailAuthCodeUri() {
            return verifyEmailAuthCodeUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getVerifyExistAuthCodeUri() {
            return verifyExistAuthCodeUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getGetKeypadUri() {
            return getKeypadUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getSetPasswordUri() {
            return setPasswordUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getMatchPasswordUri() {
            return matchPasswordUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getDeletePasswordUri() {
            return deletePasswordUri;
        }
    }
}
