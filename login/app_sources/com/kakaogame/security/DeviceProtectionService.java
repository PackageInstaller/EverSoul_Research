package com.kakaogame.security;

import android.text.TextUtils;
import com.google.firebase.perf.FirebasePerformance;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResult;
import com.kakaogame.server.ServerService;
import com.kakaogame.server.http.HttpService;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.Base64Util;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.liapp.y;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.LinkedHashMap;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: DeviceProtectionService.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0007J\u001e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00072\u0006\u0010\u0013\u001a\u00020\u0004J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006\u0018"}, m839d2 = {"Lcom/kakaogame/security/DeviceProtectionService;", "", "()V", "TAG", "", "TRANSFORMATION", "isRegisteredUser", "Lcom/kakaogame/KGResult;", "", "()Lcom/kakaogame/KGResult;", "check2StepVerificationEmail", "checkRegisteredDevice", ServerConstants.GUID, ServerConstants.CERTIFICATION, "encryptDataRSA", "data", "key", "register2StepVerificationEmail", "Ljava/lang/Void;", "email", "stringToPublicKey", "Ljava/security/PublicKey;", "publicKeyString", "Settings", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class DeviceProtectionService {
    public static final DeviceProtectionService INSTANCE = new DeviceProtectionService();
    private static final String TAG = "ProtectionService";
    private static final String TRANSFORMATION = "RSA/ECB/OAEPPadding";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DeviceProtectionService() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[Catch: Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:3:0x0024, B:5:0x0030, B:10:0x003c, B:13:0x0047, B:15:0x00f8, B:17:0x00ff, B:19:0x010e, B:21:0x0117), top: B:2:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047 A[Catch: Exception -> 0x013c, TryCatch #0 {Exception -> 0x013c, blocks: (B:3:0x0024, B:5:0x0030, B:10:0x003c, B:13:0x0047, B:15:0x00f8, B:17:0x00ff, B:19:0x010e, B:21:0x0117), top: B:2:0x0024 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.Boolean> checkRegisteredDevice(java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.security.DeviceProtectionService.checkRegisteredDevice(java.lang.String, java.lang.String):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Boolean> isRegisteredUser() {
        KGResult<Boolean> result;
        try {
            ServerRequest serverRequest = new ServerRequest(Settings.INSTANCE.getCheckUserRegisteredUri());
            serverRequest.putBody("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            serverRequest.putBody("playerId", currentPlayer.getPlayerId());
            ServerResult requestServer$default = ServerService.requestServer$default(serverRequest, 0, 2, null);
            if (requestServer$default.isSuccess()) {
                JSONObject content = requestServer$default.getContent();
                Intrinsics.checkNotNull(content);
                Object obj = content.get((Object) "result");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                result = KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(((Boolean) obj).booleanValue()));
            } else {
                result = KGResult.INSTANCE.getResult(requestServer$default);
            }
            return result;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576431870), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<String> check2StepVerificationEmail() {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.ۮڭڭܬި(862411867);
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(str2, CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            linkedHashMap.put("appSecret", CoreManager.INSTANCE.getInstance().getConfiguration().getAppSecret());
            linkedHashMap.put(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            linkedHashMap.put(ServerConstants.ZAT, CoreManager.INSTANCE.getInstance().getAccessToken());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str2, CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            jSONObject.put(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            KGResult requestOpenApi$default = OpenApiService.requestOpenApi$default(OpenApiService.INSTANCE, Settings.selectUri, "GET", linkedHashMap, jSONObject, (HttpService.HttpContentType) null, 0, 48, (Object) null);
            if (requestOpenApi$default.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(requestOpenApi$default);
            }
            Object parse = JSONValue.parse((String) requestOpenApi$default.getContent());
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type com.kakaogame.util.json.JSONObject");
            return KGResult.INSTANCE.getSuccessResult((String) ((JSONObject) parse).get((Object) "email"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576431870), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> register2StepVerificationEmail(String email) {
        String str = y.ݬֲ֮ܲت(1512589743);
        String str2 = y.֬ڱܱײٮ(-1159479551);
        Intrinsics.checkNotNullParameter(email, str2);
        try {
            String emailPublicKey = InfodeskHelper.INSTANCE.getEmailPublicKey();
            if (TextUtils.isEmpty(emailPublicKey)) {
                return KGResult.INSTANCE.getResult(5001, "You have to set 'public key'.");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appId", CoreManager.INSTANCE.getInstance().getConfiguration().getAppId());
            linkedHashMap.put("appSecret", CoreManager.INSTANCE.getInstance().getConfiguration().getAppSecret());
            linkedHashMap.put(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            linkedHashMap.put(ServerConstants.ZAT, CoreManager.INSTANCE.getInstance().getAccessToken());
            linkedHashMap.put(ServerConstants.ET, "ZET");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, CoreManager.INSTANCE.getInstance().getPlayerId());
            jSONObject.put(str2, email);
            String encryptDataRSA = encryptDataRSA(JSONValue.toJSONString(jSONObject), emailPublicKey);
            if (encryptDataRSA == null) {
                return KGResult.INSTANCE.getResult(4001);
            }
            KGResult requestOpenApi$default = OpenApiService.requestOpenApi$default(OpenApiService.INSTANCE, Settings.registerUri, FirebasePerformance.HttpMethod.PUT, linkedHashMap, encryptDataRSA, 0, 16, null);
            if (requestOpenApi$default.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(requestOpenApi$default);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.٬ݯح׭٩(576431870), e.toString(), e);
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

    /* compiled from: DeviceProtectionService.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m839d2 = {"Lcom/kakaogame/security/DeviceProtectionService$Settings;", "", "()V", "checkRegisteredDeviceUri", "", "getCheckRegisteredDeviceUri", "()Ljava/lang/String;", "setCheckRegisteredDeviceUri", "(Ljava/lang/String;)V", "checkUserRegisteredUri", "getCheckUserRegisteredUri", "setCheckUserRegisteredUri", "registerUri", "selectUri", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String checkRegisteredDeviceUri = y.ݬֲ֮ܲت(1512131471);
        private static String checkUserRegisteredUri = y.ݬֲ֮ܲت(1512131303);
        public static final String registerUri = "v3/email/register";
        public static final String selectUri = "v3/email/select";

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCheckRegisteredDeviceUri() {
            return checkRegisteredDeviceUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCheckRegisteredDeviceUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            checkRegisteredDeviceUri = str;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getCheckUserRegisteredUri() {
            return checkUserRegisteredUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCheckUserRegisteredUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            checkUserRegisteredUri = str;
        }
    }
}
