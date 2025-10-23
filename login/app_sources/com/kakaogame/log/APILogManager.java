package com.kakaogame.log;

import android.text.TextUtils;
import com.kakao.sdk.partner.user.Constants;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.log.service.BasicLogService;
import com.kakaogame.server.KeyBaseResult;
import com.kakaogame.server.ServerConstants;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: APILogManager.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J(\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/log/APILogManager;", "", "()V", "TAG", "", "enableSendApiLog", "", "initialize", "", "setApiCallLogEnable", "percentOfSendingAPICallLog", "", "writeClientApiCall", Constants.API_TYPE, "result", "Lcom/kakaogame/KGResult;", "latency", "", "writeServerApiCall", "uri", "Lcom/kakaogame/server/KeyBaseResult;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class APILogManager {
    public static final APILogManager INSTANCE = new APILogManager();
    private static final String TAG = "APILogManager";
    private static boolean enableSendApiLog;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private APILogManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setApiCallLogEnable(int percentOfSendingAPICallLog) {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051467277) + percentOfSendingAPICallLog;
        String str2 = y.ۮڭڭܬި(862683651);
        logger.m699d(str2, str);
        if (percentOfSendingAPICallLog > 0) {
            enableSendApiLog = new Random().nextInt(100) < percentOfSendingAPICallLog;
        }
        Logger.INSTANCE.m699d(str2, y.ۮڭڭܬި(862683803) + enableSendApiLog);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeClientApiCall(String api, KGResult<?> result, long latency) {
        if (result != null) {
            try {
                result.isSuccess();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(TAG, e.toString(), e);
                return;
            }
        }
        if (enableSendApiLog) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (result != null) {
                linkedHashMap.put(ServerConstants.TRACE_RESULT_CODE, Integer.valueOf(result.getCode()));
            }
            linkedHashMap.put("latency", Long.valueOf(latency));
            BasicLogService.writeBasicLog(CoreManager.INSTANCE.getInstance().getContext(), "ClientAPICall", api, null, linkedHashMap);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void writeServerApiCall(String uri, KeyBaseResult<?> result, long latency) {
        String str = y.ۮڭڭܬި(862683651);
        Intrinsics.checkNotNullParameter(uri, y.ۮڭڭܬި(862392755));
        try {
            if (enableSendApiLog) {
                if (TextUtils.isEmpty(uri)) {
                    Logger.INSTANCE.m701e(str, "uri is null");
                    return;
                }
                boolean startsWith$default = StringsKt.startsWith$default(uri, "log://", false, 2, (Object) null);
                String str2 = y.ݮڮֲڭܩ(-628371428);
                if (startsWith$default) {
                    Logger.INSTANCE.m706v(str, str2 + uri);
                    return;
                }
                if (StringsKt.contains$default((CharSequence) uri, (CharSequence) "/service/", false, 2, (Object) null) && StringsKt.endsWith$default(uri, "Log", false, 2, (Object) null)) {
                    Logger.INSTANCE.m706v(str, str2 + uri);
                    return;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (result != null) {
                    linkedHashMap.put(ServerConstants.TRACE_RESULT_CODE, Integer.valueOf(result.getCode()));
                }
                linkedHashMap.put("latency", Long.valueOf(latency));
                BasicLogService.writeBasicLog(CoreManager.INSTANCE.getInstance().getContext(), "ServerAPICall", uri, null, linkedHashMap);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }
}
