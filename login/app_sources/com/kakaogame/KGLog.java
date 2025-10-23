package com.kakaogame;

import android.app.Activity;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.log.PlayerLogManager;
import com.kakaogame.log.service.LogBucketService;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGLog.kt */
@Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ4\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012J\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J,\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J\"\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004J,\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004J(\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0018H\u0002J2\u0010\u0016\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001aH\u0007J(\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0018H\u0002J2\u0010\u001b\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001aH\u0007J(\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0018H\u0002J2\u0010\u001c\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001aH\u0007J(\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0018H\u0002J2\u0010\u001d\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001aH\u0007J(\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0018H\u0002J2\u0010\u001e\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00182\u0010\u0010\u0019\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006 "}, m839d2 = {"Lcom/kakaogame/KGLog;", "", "()V", "TAG", "", "playerGameData", "Lcom/kakaogame/KGPlayerGameData;", "getPlayerGameData", "()Lcom/kakaogame/KGPlayerGameData;", "accumulateValue", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "category", "action", "value", "", Constants.ScionAnalytics.PARAM_LABEL, "initInterfaceBroker", "", "initialize", "startLatencyCheck", "stopLatencyCheck", "writeActionLog", "logBody", "", "callback", "Lcom/kakaogame/KGResultCallback;", "writeItemLog", "writeNetworkLog", "writeResourceLog", "writeRoundLog", "LatencyData", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGLog {
    public static final KGLog INSTANCE = new KGLog();
    private static final String TAG = "LoggerBucket";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGLog() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeItemLog(Map<String, ? extends Object> logBody) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575769246) + logBody;
        String str2 = y.ٲٴݴ״ٰ(1782010432);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.دײܮڳܯ(2051755357));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                KGResult<Void> result2 = KGResult.INSTANCE.getResult(3002);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            }
            result = KGResult.INSTANCE.getResult(LogBucketService.writeItemLog(logBody));
            start.stop();
            name = start.getName();
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeItemLog(Map<String, ? extends Object> logBody, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLog$writeItemLog$4(logBody, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeResourceLog(Map<String, ? extends Object> logBody) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862331067) + logBody;
        String str2 = y.ٲٴݴ״ٰ(1782010432);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.ۮڭڭܬި(862331675));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                KGResult<Void> result2 = KGResult.INSTANCE.getResult(3002);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            }
            result = KGResult.INSTANCE.getResult(LogBucketService.writeResourceLog(logBody));
            start.stop();
            name = start.getName();
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeResourceLog(Map<String, ? extends Object> logBody, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLog$writeResourceLog$4(logBody, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeActionLog(Map<String, ? extends Object> logBody) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512793951) + logBody;
        String str2 = y.ٲٴݴ״ٰ(1782010432);
        logger.m706v(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.دײܮڳܯ(2051755957));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                KGResult<Void> result2 = KGResult.INSTANCE.getResult(3002);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            }
            result = KGResult.INSTANCE.getResult(LogBucketService.writeActionLog(logBody));
            start.stop();
            name = start.getName();
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeActionLog(Map<String, ? extends Object> logBody, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLog$writeActionLog$4(logBody, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeNetworkLog(Map<String, ? extends Object> logBody) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392658522) + logBody;
        String str2 = y.ٲٴݴ״ٰ(1782010432);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1159588447));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                KGResult<Void> result2 = KGResult.INSTANCE.getResult(3002);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            }
            result = KGResult.INSTANCE.getResult(LogBucketService.writeNetworkLog(logBody));
            start.stop();
            name = start.getName();
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeNetworkLog(Map<String, ? extends Object> logBody, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLog$writeNetworkLog$4(logBody, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> writeRoundLog(Map<String, ? extends Object> logBody) {
        KGResult<Void> result;
        String name;
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628719756) + logBody;
        String str2 = y.ٲٴݴ״ٰ(1782010432);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.٬ݯح׭٩(575770526));
        try {
            try {
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                KGResult<Void> result2 = KGResult.INSTANCE.getResult(3002);
                start.stop();
                KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                return result2;
            }
            result = KGResult.INSTANCE.getResult(LogBucketService.writeRoundLog(logBody));
            start.stop();
            name = start.getName();
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void writeRoundLog(Map<String, ? extends Object> logBody, KGResultCallback<Void> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGLog$writeRoundLog$4(logBody, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGPlayerGameData getPlayerGameData() {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051752981);
        String str2 = y.ٲٴݴ״ٰ(1782010432);
        logger.m704i(str2, str);
        try {
            return KGPlayerGameData.INSTANCE.getInstance();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> accumulateValue(String category, String action, long value) {
        try {
            return accumulateValue(category, action, null, value);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782010432), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> accumulateValue(String category, String action, String label, long value) {
        String str = y.ٴسسݬߨ(1392657618);
        String str2 = y.٬ݯح׭٩(575766846);
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ݬֲ֮ܲت(1512795655)).append(category);
        String str3 = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str3).append(action).append(y.دײܮڳܯ(2051753029)).append(label).append(str3).append(value).toString();
        String str4 = y.ٲٴݴ״ٰ(1782010432);
        logger.m704i(str4, sb);
        try {
            if (TextUtils.isEmpty(category)) {
                Logger.INSTANCE.m701e(str4, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (TextUtils.isEmpty(action)) {
                Logger.INSTANCE.m701e(str4, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            Intrinsics.checkNotNull(category);
            Intrinsics.checkNotNull(action);
            Intrinsics.checkNotNull(label);
            PlayerLogManager.addSummaryLog(category, action, label, value);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> startLatencyCheck(String category, String action) {
        try {
            return startLatencyCheck(category, action, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782010432), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> startLatencyCheck(String category, String action, String label) {
        String str = y.ٴسسݬߨ(1392657618);
        String str2 = y.٬ݯح׭٩(575766846);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ٲٴݴ״ٰ(1782012392) + category + y.ݮڮֲڭܩ(-628756788) + action + y.دײܮڳܯ(2051753029) + label;
        String str4 = y.ٲٴݴ״ٰ(1782010432);
        logger.m704i(str4, str3);
        try {
            if (TextUtils.isEmpty(category)) {
                Logger.INSTANCE.m701e(str4, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            if (TextUtils.isEmpty(action)) {
                Logger.INSTANCE.m701e(str4, str);
                return KGResult.INSTANCE.getResult(4000, str);
            }
            LatencyData.INSTANCE.createLatencyData(category, action, label);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> stopLatencyCheck(String category, String action) {
        try {
            return stopLatencyCheck(category, action, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ٲٴݴ״ٰ(1782010432), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Void> stopLatencyCheck(String category, String action, String label) {
        String str = y.٬ݯح׭٩(575767446);
        String str2 = y.ٴسسݬߨ(1392657618);
        String str3 = y.٬ݯح׭٩(575766846);
        String str4 = y.ٴسسݬߨ(1392656618);
        Logger logger = Logger.INSTANCE;
        String str5 = y.ٴسسݬߨ(1392656842) + category + y.ݮڮֲڭܩ(-628756788) + action + y.دײܮڳܯ(2051753029) + label;
        String str6 = y.ٲٴݴ״ٰ(1782010432);
        logger.m704i(str6, str5);
        try {
            if (TextUtils.isEmpty(category)) {
                Logger.INSTANCE.m701e(str6, str3);
                return KGResult.INSTANCE.getResult(4000, str3);
            }
            if (TextUtils.isEmpty(action)) {
                Logger.INSTANCE.m701e(str6, str2);
                return KGResult.INSTANCE.getResult(4000, str2);
            }
            LatencyData latencyData = LatencyData.INSTANCE.getLatencyData(category, action, label);
            if (latencyData == null) {
                Logger.INSTANCE.m701e(str6, str);
                return KGResult.INSTANCE.getResult(4002, str);
            }
            long stop = latencyData.stop();
            Logger.INSTANCE.m704i(str6, str4 + stop);
            accumulateValue(category, action, label, stop);
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str6, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512791567), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> writeItemLog;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                writeItemLog = KGLog.INSTANCE.writeItemLog((Map) request.getParameter("logBody"));
                return writeItemLog;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1782016368), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> writeResourceLog;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                writeResourceLog = KGLog.INSTANCE.writeResourceLog((Map) request.getParameter("logBody"));
                return writeResourceLog;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512791247), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> writeActionLog;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                writeActionLog = KGLog.INSTANCE.writeActionLog((Map) request.getParameter("logBody"));
                return writeActionLog;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575779846), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> writeNetworkLog;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                writeNetworkLog = KGLog.INSTANCE.writeNetworkLog((Map) request.getParameter("logBody"));
                return writeNetworkLog;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392668994), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGResult<?> writeRoundLog;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                writeRoundLog = KGLog.INSTANCE.writeRoundLog((Map) request.getParameter("logBody"));
                return writeRoundLog;
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862329027), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("category");
                String str2 = (String) request.getParameter(y.֬ڱܱײٮ(-1159583711));
                String str3 = y.ٲٴݴ״ٰ(1782016584);
                return KGLog.INSTANCE.startLatencyCheck(str, str2, request.containsParameterKey(str3) ? (String) request.getParameter(str3) : null);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575780574), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("category");
                String str2 = (String) request.getParameter(y.֬ڱܱײٮ(-1159583711));
                String str3 = y.ٲٴݴ״ٰ(1782016584);
                return KGLog.INSTANCE.stopLatencyCheck(str, str2, request.containsParameterKey(str3) ? (String) request.getParameter(str3) : null);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051764653), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGLog$initInterfaceBroker$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("category");
                String str2 = (String) request.getParameter("action");
                String str3 = request.containsParameterKey(Constants.ScionAnalytics.PARAM_LABEL) ? (String) request.getParameter(Constants.ScionAnalytics.PARAM_LABEL) : null;
                Number number = (Number) request.getParameter("value");
                Intrinsics.checkNotNull(number);
                return KGLog.INSTANCE.accumulateValue(str, str2, str3, number.longValue());
            }
        });
    }

    /* compiled from: KGLog.kt */
    @Metadata(m838d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J&\u0010\t\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/KGLog$LatencyData;", "", "category", "", "action", Constants.ScionAnalytics.PARAM_LABEL, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "startNanoTime", "", "equals", "", "remove", "", "stop", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private static final class LatencyData {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final List<LatencyData> list = new ArrayList();
        private final String action;
        private final String category;
        private final String label;
        private final long startNanoTime;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ LatencyData(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LatencyData(String str, String str2, String str3) {
            this.category = str;
            this.action = str2;
            this.label = str3;
            this.startNanoTime = System.nanoTime();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long stop() {
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNanoTime);
            remove();
            return millis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void remove() {
            List<LatencyData> list2 = list;
            synchronized (list2) {
                list2.remove(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean equals(String category, String action, String label) {
            if (!Intrinsics.areEqual(this.category, category) || !Intrinsics.areEqual(this.action, action)) {
                return false;
            }
            String str = this.label;
            return str == null ? label == null : Intrinsics.areEqual(str, label);
        }

        /* compiled from: KGLog.kt */
        @Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tJ&\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/KGLog$LatencyData$Companion;", "", "()V", com.kakao.sdk.template.Constants.TYPE_LIST, "", "Lcom/kakaogame/KGLog$LatencyData;", "createLatencyData", "", "category", "", "action", Constants.ScionAnalytics.PARAM_LABEL, "getLatencyData", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Companion {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Companion() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final void createLatencyData(String category, String action, String label) {
                LatencyData latencyData = new LatencyData(category, action, label, null);
                synchronized (LatencyData.list) {
                    LatencyData.list.add(latencyData);
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final LatencyData getLatencyData(String category, String action, String label) {
                synchronized (LatencyData.list) {
                    for (LatencyData latencyData : LatencyData.list) {
                        if (latencyData.equals(category, action, label)) {
                            return latencyData;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    return null;
                }
            }
        }
    }
}
