package com.kakaogame.log;

import android.content.Context;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.auth.LoginData;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.service.BasicLogService;
import com.kakaogame.server.ServerRequest;
import com.kakaogame.server.ServerResponse;
import com.kakaogame.server.ServerResult;
import com.kakaogame.util.AES256Cipher;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.StringUtil;
import com.liapp.y;
import com.singular.sdk.internal.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Thread;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: ErrorLogManager.kt */
@Metadata(m838d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020 H\u0007J\b\u0010\"\u001a\u00020 H\u0002J \u0010#\u001a\u00020 2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001aH\u0002Jb\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u001e2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002Jb\u00105\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u00010\u001e2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u00106\u001a\u00020 H\u0007J:\u00107\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u00108\u001a\u0004\u0018\u0001092\u000e\u00103\u001a\n\u0018\u00010:j\u0004\u0018\u0001`;2\u0006\u00104\u001a\u00020\u0004JL\u0010<\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u000e\u00103\u001a\n\u0018\u00010:j\u0004\u0018\u0001`;2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0007JB\u0010=\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u0001022\u000e\u00103\u001a\n\u0018\u00010:j\u0004\u0018\u0001`;2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0007J<\u0010>\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\u000e\u00103\u001a\n\u0018\u00010:j\u0004\u0018\u0001`;2\b\u00104\u001a\u0004\u0018\u00010\u0004JZ\u0010?\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u0001022\u000e\u00103\u001a\n\u0018\u00010:j\u0004\u0018\u0001`;2\b\u00104\u001a\u0004\u0018\u00010\u00042\u0006\u0010@\u001a\u00020\u0017H\u0007J&\u0010A\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\n\u00103\u001a\u00060:j\u0002`;2\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010B\u001a\u00020 2\u0006\u0010C\u001a\u00020(H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006D"}, m839d2 = {"Lcom/kakaogame/log/ErrorLogManager;", "", "()V", "ACCOUNT_KEY", "", "CLIENT_LOG_CODE", "CRASH", "EXCEPTION_KEY", "EXTRA_KEY", "FAIL_LOGDATA_NAME", "GEOIP_ERROR", "IDP_CHECK_AUTH_ERROR", "IDP_ERROR_KEY", "IDP_LOGIN_ERROR", "IMAGE_LOADING_ERROR", "INFODESK_ERROR", "LOGIN_DATA_KEY", "PLATFORM_LOGIN_ERROR", "RECONNECT_LOGIN_ERROR", "REQUEST_KEY", "SERVER_RESULT_KEY", "TAG", "enableSendErrorLog", "", "failQueue", "Ljava/util/Queue;", "", "prefKey", "getStackTraceString", Constants.RequestBody.EXTRA_ATTRIBUTES_KEY, "", "initErrorLog", "", "initialize", "loadFailLogData", "saveFailLogData", "failLog", "sendErrorLog", "errorType", "errorCode", "", "request", "Lcom/kakaogame/server/ServerRequest;", "response", "Lcom/kakaogame/server/ServerResponse;", ErrorLogManager.IDP_ERROR_KEY, "Lcom/kakaogame/KGResult;", "loginData", "Lcom/kakaogame/auth/LoginData;", "account", "Lcom/kakaogame/idp/IdpAccount;", ErrorLogManager.EXCEPTION_KEY, "extra", "sendErrorLogData", "sendFailLogData", "sendGeoIpError", "result", "Lcom/kakaogame/server/ServerResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "sendIdpCheckAuthError", "sendIdpLoginError", "sendInfodeskError", "sendPlatformLoginError", "isReconnect", "sendUIError", "setErrorLogEnable", "percentOfSendingErrorLog", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ErrorLogManager {
    private static final String ACCOUNT_KEY = "savedAccount";
    private static final String CLIENT_LOG_CODE = "androidClientError";
    private static final String CRASH = "Crash";
    private static final String EXCEPTION_KEY = "exception";
    private static final String EXTRA_KEY = "extra";
    private static final String FAIL_LOGDATA_NAME = "FailLogData";
    private static final String GEOIP_ERROR = "GeoIpError";
    private static final String IDP_CHECK_AUTH_ERROR = "IDPCheckAuthError";
    private static final String IDP_ERROR_KEY = "idpError";
    private static final String IDP_LOGIN_ERROR = "IDPLoginError";
    private static final String IMAGE_LOADING_ERROR = "ImageLoadingError";
    private static final String INFODESK_ERROR = "InfodeskError";
    private static final String LOGIN_DATA_KEY = "savedLoginData";
    private static final String PLATFORM_LOGIN_ERROR = "PlatformLoginError";
    private static final String RECONNECT_LOGIN_ERROR = "ReconnectLoginError";
    private static final String REQUEST_KEY = "requestData";
    private static final String SERVER_RESULT_KEY = "serverResult";
    private static final String TAG = "ErrorLogManager";
    private static boolean enableSendErrorLog = false;
    private static final String prefKey = "FailLogData";
    public static final ErrorLogManager INSTANCE = new ErrorLogManager();
    private static final Queue<Map<String, Object>> failQueue = new LinkedList();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ErrorLogManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initErrorLog();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setErrorLogEnable(int percentOfSendingErrorLog) {
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1158693167) + percentOfSendingErrorLog;
        String str2 = y.ݮڮֲڭܩ(-628370684);
        logger.m699d(str2, str);
        enableSendErrorLog = new Random().nextInt(100) < percentOfSendingErrorLog;
        Logger.INSTANCE.m704i(str2, y.دײܮڳܯ(2051473125) + enableSendErrorLog);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendInfodeskError(int errorCode, String request, String response, Exception exception, String extra) {
        sendErrorLogData(y.֬ڱܱײٮ(-1158700831), errorCode, request, response != null ? StringUtil.escapeHTML(response) : null, null, null, null, exception, extra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendPlatformLoginError(int errorCode, ServerRequest request, ServerResponse response, LoginData loginData, IdpAccount account, Exception exception, String extra, boolean isReconnect) {
        INSTANCE.sendErrorLog(isReconnect ? y.ٲٴݴ״ٰ(1782250776) : y.ۮڭڭܬި(862686083), errorCode, request, response, null, loginData, account, exception, extra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendIdpLoginError(int errorCode, KGResult<?> idpError, IdpAccount account, Exception exception, String extra) {
        INSTANCE.sendErrorLog(y.ݬֲ֮ܲت(1512491535), errorCode, null, null, idpError, null, account, exception, extra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendIdpCheckAuthError(int errorCode, KGResult<?> idpError, LoginData loginData, IdpAccount account, Exception exception, String extra) {
        INSTANCE.sendErrorLog(y.ٴسسݬߨ(1393549474), errorCode, null, null, idpError, loginData, account, exception, extra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void sendGeoIpError(int errorCode, ServerRequest request, ServerResult result, Exception exception, String extra) {
        Intrinsics.checkNotNullParameter(extra, y.ۮڭڭܬި(862688371));
        sendErrorLogData(y.ݮڮֲڭܩ(-628373204), errorCode, request != null ? request.toString() : null, result != null ? result.toString() : null, null, null, null, exception, extra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendUIError(int errorCode, Exception exception, String extra) {
        Intrinsics.checkNotNullParameter(exception, y.ۮڭڭܬި(862642723));
        INSTANCE.sendErrorLog(y.ݮڮֲڭܩ(-628369660), errorCode, null, null, null, null, null, exception, extra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendErrorLog(String errorType, int errorCode, ServerRequest request, ServerResponse response, KGResult<?> idpError, LoginData loginData, IdpAccount account, Throwable exception, String extra) {
        sendErrorLogData(errorType, errorCode, request != null ? request.toString() : null, response != null ? response.toString() : null, idpError, loginData, account, exception, extra);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendErrorLogData(String errorType, int errorCode, String request, String response, KGResult<?> idpError, LoginData loginData, IdpAccount account, Throwable exception, String extra) {
        if (errorCode == 461 || errorCode == 463 || errorCode == 1001 || errorCode == 2001 || errorCode == 3002 || errorCode == 4000 || errorCode == 9001 || !enableSendErrorLog) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (request != null) {
            String str = request;
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) y.֬ڱܱײٮ(-1158693591), false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) y.֬ڱܱײٮ(-1158693543), false, 2, (Object) null)) {
                request = new Regex(DeviceUtil.getWhiteKey(CoreManager.INSTANCE.getInstance().getContext())).replace(str, "");
            }
            linkedHashMap.put(y.دײܮڳܯ(2051465957), request);
        }
        if (response != null) {
            linkedHashMap.put(SERVER_RESULT_KEY, response);
        }
        if (idpError != null) {
            linkedHashMap.put(IDP_ERROR_KEY, idpError.toString());
        }
        if (loginData != null) {
            Map<String, Object> object = loginData.getObject();
            Intrinsics.checkNotNull(object);
            linkedHashMap.put(LOGIN_DATA_KEY, object);
        }
        if (account != null) {
            Map<String, Object> object2 = account.getObject();
            Intrinsics.checkNotNull(object2);
            linkedHashMap.put(ACCOUNT_KEY, object2);
        }
        if (exception != null) {
            linkedHashMap.put(EXCEPTION_KEY, getStackTraceString(exception));
        }
        String str2 = extra;
        if (!(str2 == null || str2.length() == 0)) {
            linkedHashMap.put("extra", extra);
        }
        BasicLogService.writeBasicLog(CoreManager.INSTANCE.getInstance().getContext(), CLIENT_LOG_CODE, errorType, String.valueOf(errorCode), linkedHashMap, new KGResultCallback<Map<String, ? extends Object>>() { // from class: com.kakaogame.log.ErrorLogManager$sendErrorLogData$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGResultCallback
            public void onResult(KGResult<Map<String, ? extends Object>> result) {
                if (result == null || result.isSuccess() || result.getContent() == null) {
                    return;
                }
                ErrorLogManager.INSTANCE.saveFailLogData(result.getContent());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void saveFailLogData(Map<String, ? extends Object> failLog) {
        String encryptIV;
        String str = y.ٲٴݴ״ٰ(1782250104);
        if (failLog != null) {
            try {
                if (failLog.isEmpty()) {
                    return;
                }
                Queue<Map<String, Object>> queue = failQueue;
                queue.offer(failLog);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(queue);
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
                    PreferenceUtil.setString(CoreManager.INSTANCE.getInstance().getContext(), str, str, encodeString);
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628370684), e.toString(), e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void loadFailLogData() {
        String encryptIV;
        String decodeString;
        Context context = CoreManager.INSTANCE.getInstance().getContext();
        String str = y.ٲٴݴ״ٰ(1782250104);
        String string = PreferenceUtil.getString(context, str, str, null);
        if (string != null) {
            try {
                String encryptKey = InfodeskHelper.INSTANCE.getEncryptKey();
                if (encryptKey == null || (encryptIV = InfodeskHelper.INSTANCE.getEncryptIV()) == null || (decodeString = AES256Cipher.decodeString(encryptKey, encryptIV, string)) == null) {
                    return;
                }
                byte[] bytes = decodeString.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                ObjectInputStream objectInputStream = new ObjectInputStream(new Base64InputStream(new ByteArrayInputStream(bytes), 0));
                Object readObject = objectInputStream.readObject();
                objectInputStream.close();
                if (readObject != null && (readObject instanceof LinkedList)) {
                    Iterator it = ((LinkedList) readObject).iterator();
                    while (it.hasNext()) {
                        failQueue.add((Map) it.next());
                    }
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628370684), e.toString(), e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void sendFailLogData() {
        Queue<Map<String, Object>> queue = failQueue;
        if (queue.size() == 0) {
            return;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Map<String, Object> poll = failQueue.poll();
            if (poll != null && !poll.isEmpty()) {
                BasicLogService.writeBasicLog(poll, new KGResultCallback<Map<String, ? extends Object>>() { // from class: com.kakaogame.log.ErrorLogManager$sendFailLogData$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<Map<String, ? extends Object>> result) {
                        if (result != null) {
                            if (result.isSuccess()) {
                                PreferenceUtil.remove(CoreManager.INSTANCE.getInstance().getContext(), y.ٲٴݴ״ٰ(1782250104));
                            } else {
                                if (result.isSuccess() || result.getContent() == null) {
                                    return;
                                }
                                ErrorLogManager.INSTANCE.saveFailLogData(result.getContent());
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initErrorLog() {
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.kakaogame.log.ErrorLogManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                ErrorLogManager.initErrorLog$lambda$1(defaultUncaughtExceptionHandler, thread, th);
            }
        });
        loadFailLogData();
        sendFailLogData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initErrorLog$lambda$1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512492295) + thread;
        String str2 = y.ݮڮֲڭܩ(-628370684);
        logger.m702e(str2, str, th);
        ErrorLogManager errorLogManager = INSTANCE;
        String stackTraceString = errorLogManager.getStackTraceString(th);
        if (th.getCause() != null) {
            stackTraceString = stackTraceString + y.ٲٴݴ״ٰ(1782249824) + errorLogManager.getStackTraceString(th.getCause());
        }
        new LinkedHashMap().put(y.ۮڭڭܬި(862642723), stackTraceString);
        Log.e(str2, stackTraceString);
        errorLogManager.sendErrorLog(y.٬ݯح׭٩(576463854), 4001, null, null, null, null, null, th, "");
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getStackTraceString(Throwable e) {
        if (e == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(e + y.ݮڮֲڭܩ(-628756788));
        StackTraceElement[] stackTrace = e.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, y.ٲٴݴ״ٰ(1782250176));
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString());
            sb.append(y.ٲٴݴ״ٰ(1782249824));
            i++;
            if (i >= 20) {
                break;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, y.ٲٴݴ״ٰ(1781855688));
        return sb2;
    }
}
