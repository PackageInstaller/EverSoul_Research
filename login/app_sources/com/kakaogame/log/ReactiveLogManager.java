package com.kakaogame.log;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.LocaleManager;
import com.kakaogame.manager.LogThreadPoolManager;
import com.kakaogame.push.PushMessage;
import com.kakaogame.server.openapi.OpenApiService;
import com.kakaogame.util.Stopwatch;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReactiveLogManager.kt */
@Metadata(m838d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001a\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ>\u0010\u001b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, m839d2 = {"Lcom/kakaogame/log/ReactiveLogManager;", "", "()V", "PUSH_RECEIVE_LOG_NAME", "", "TAG", "enableSendInternalLog", "", "lock", "playStopwatch", "Lcom/kakaogame/util/Stopwatch;", "disablePush", "", "activity", "Landroid/app/Activity;", "getPushId", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "receivePush", "context", "Landroid/content/Context;", "removePushId", "setInternalLogEnable", "percentOfSendingInternalLog", "", "startPlay", "stopPlay", "writeActionLog", "category", "action", PushMessage.KEY_PUSH_ID, "segId", "valueNo", "", "Settings", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ReactiveLogManager {
    private static final String PUSH_RECEIVE_LOG_NAME = "PushReceiveLog";
    private static final String TAG = "ReactiveLogManager";
    private static Stopwatch playStopwatch;
    public static final ReactiveLogManager INSTANCE = new ReactiveLogManager();
    private static final Object lock = new Object();
    private static boolean enableSendInternalLog = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ReactiveLogManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setInternalLogEnable(int percentOfSendingInternalLog) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782241680) + percentOfSendingInternalLog;
        String str2 = y.ݮڮֲڭܩ(-628359700);
        logger.m699d(str2, str);
        if (percentOfSendingInternalLog < 100) {
            enableSendInternalLog = new Random().nextInt(100) < percentOfSendingInternalLog;
        }
        Logger.INSTANCE.m699d(str2, y.ۮڭڭܬި(862683803) + enableSendInternalLog);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a1 A[Catch: all -> 0x00ec, TryCatch #1 {, blocks: (B:15:0x007c, B:17:0x0080, B:19:0x0095, B:24:0x00a1, B:26:0x00bb, B:27:0x00dd, B:30:0x00e8), top: B:14:0x007c, outer: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void startPlay(android.app.Activity r12) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.log.ReactiveLogManager.startPlay(android.app.Activity):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void stopPlay(Activity activity) {
        Logger.INSTANCE.m704i(y.ݮڮֲڭܩ(-628359700), y.ۮڭڭܬި(862693699).concat(enableSendInternalLog ? y.دײܮڳܯ(2051939573) : y.ٲٴݴ״ٰ(1781635312)));
        if (enableSendInternalLog) {
            try {
                synchronized (lock) {
                    Stopwatch stopwatch = playStopwatch;
                    if (stopwatch != null) {
                        Intrinsics.checkNotNull(stopwatch);
                        stopwatch.stop();
                        Stopwatch stopwatch2 = playStopwatch;
                        Intrinsics.checkNotNull(stopwatch2);
                        long durationMs = stopwatch2.getDurationMs();
                        ReactiveLogManager reactiveLogManager = INSTANCE;
                        playStopwatch = null;
                        reactiveLogManager.writeActionLog(activity, "app", "pause", reactiveLogManager.getPushId(activity), null, durationMs);
                    }
                    INSTANCE.removePushId(activity);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628359700), e.toString(), e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0088 A[Catch: all -> 0x00ac, TryCatch #1 {, blocks: (B:12:0x005b, B:14:0x007c, B:19:0x0088, B:22:0x009e, B:23:0x00a8), top: B:11:0x005b, outer: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void receivePush(android.content.Context r11, android.content.Intent r12) {
        /*
            r10 = this;
            r0 = 862694555(0x336bac9b, float:5.4872185E-8)
            java.lang.String r0 = com.liapp.y.ۮڭڭܬި(r0)
            r1 = 1512852487(0x5a2c4c07, float:1.2124322E16)
            java.lang.String r1 = com.liapp.y.ݬֲ֮ܲت(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE
            r2 = -628359700(0xffffffffda8bfdec, float:-1.9702106E16)
            java.lang.String r2 = com.liapp.y.ݮڮֲڭܩ(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 862694555(0x336bac9b, float:5.4872185E-8)
            java.lang.String r4 = com.liapp.y.ۮڭڭܬި(r4)
            r3.<init>(r4)
            java.lang.StringBuilder r3 = r3.append(r12)
            r4 = 1393542778(0x530fc67a, float:6.175102E11)
            java.lang.String r4 = com.liapp.y.ٴسسݬߨ(r4)
            java.lang.StringBuilder r3 = r3.append(r4)
            boolean r4 = com.kakaogame.log.ReactiveLogManager.enableSendInternalLog
            if (r4 == 0) goto L41
            r4 = 2051939573(0x7a4e1cf5, float:2.6755012E35)
            java.lang.String r4 = com.liapp.y.دײܮڳܯ(r4)
            goto L48
        L41:
            r4 = 1781635312(0x6a3198f0, float:5.3675524E25)
            java.lang.String r4 = com.liapp.y.ٲٴݴ״ٰ(r4)
        L48:
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.m704i(r2, r3)
            boolean r1 = com.kakaogame.log.ReactiveLogManager.enableSendInternalLog
            if (r1 != 0) goto L58
            return
        L58:
            java.lang.Object r1 = com.kakaogame.log.ReactiveLogManager.lock     // Catch: java.lang.Exception -> Laf
            monitor-enter(r1)     // Catch: java.lang.Exception -> Laf
            com.kakaogame.log.ReactiveLogManager r2 = com.kakaogame.log.ReactiveLogManager.INSTANCE     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = r2.getPushId(r12)     // Catch: java.lang.Throwable -> Lac
            com.kakaogame.Logger r12 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "ReactiveLogManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r4.<init>(r0)     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r0 = r4.append(r6)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lac
            r12.m699d(r3, r0)     // Catch: java.lang.Throwable -> Lac
            r12 = r6
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch: java.lang.Throwable -> Lac
            r0 = 0
            r3 = 1
            if (r12 == 0) goto L85
            int r12 = r12.length()     // Catch: java.lang.Throwable -> Lac
            if (r12 != 0) goto L83
            goto L85
        L83:
            r12 = r0
            goto L86
        L85:
            r12 = r3
        L86:
            if (r12 != 0) goto La8
            java.lang.String r12 = "PushReceiveLog"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch: java.lang.Throwable -> Lac
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> Lac
            com.kakaogame.util.PreferenceUtil.setLong(r11, r12, r6, r4)     // Catch: java.lang.Throwable -> Lac
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)     // Catch: java.lang.Throwable -> Lac
            boolean r12 = com.kakaogame.util.AppUtil.isAppForeground(r11)     // Catch: java.lang.Throwable -> Lac
            if (r12 == 0) goto L9e
            r0 = r3
        L9e:
            long r8 = (long) r0     // Catch: java.lang.Throwable -> Lac
            java.lang.String r4 = "pushmsg"
            java.lang.String r5 = "recv"
            r7 = 0
            r3 = r11
            r2.writeActionLog(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> Lac
        La8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lac
            monitor-exit(r1)     // Catch: java.lang.Exception -> Laf
            goto Lc2
        Lac:
            r11 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Exception -> Laf
            throw r11     // Catch: java.lang.Exception -> Laf
        Laf:
            r11 = move-exception
            com.kakaogame.Logger r12 = com.kakaogame.Logger.INSTANCE
            r0 = -628359700(0xffffffffda8bfdec, float:-1.9702106E16)
            java.lang.String r0 = com.liapp.y.ݮڮֲڭܩ(r0)
            java.lang.String r1 = r11.toString()
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            r12.m702e(r0, r1, r11)
        Lc2:
            return
            fill-array 0x00c4: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.log.ReactiveLogManager.receivePush(android.content.Context, android.content.Intent):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049 A[Catch: all -> 0x005a, TryCatch #1 {, blocks: (B:12:0x0032, B:14:0x003d, B:19:0x0049, B:20:0x0056), top: B:11:0x0032, outer: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void disablePush(android.app.Activity r10) {
        /*
            r9 = this;
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            r1 = -628359700(0xffffffffda8bfdec, float:-1.9702106E16)
            java.lang.String r1 = com.liapp.y.ݮڮֲڭܩ(r1)
            boolean r2 = com.kakaogame.log.ReactiveLogManager.enableSendInternalLog
            if (r2 == 0) goto L15
            r2 = 2051939573(0x7a4e1cf5, float:2.6755012E35)
            java.lang.String r2 = com.liapp.y.دײܮڳܯ(r2)
            goto L1c
        L15:
            r2 = 1781635312(0x6a3198f0, float:5.3675524E25)
            java.lang.String r2 = com.liapp.y.ٲٴݴ״ٰ(r2)
        L1c:
            r3 = -1158702647(0xffffffffbaef99c9, float:-0.0018280084)
            java.lang.String r3 = com.liapp.y.֬ڱܱײٮ(r3)
            java.lang.String r2 = r3.concat(r2)
            r0.m704i(r1, r2)
            boolean r0 = com.kakaogame.log.ReactiveLogManager.enableSendInternalLog
            if (r0 != 0) goto L2f
            return
        L2f:
            java.lang.Object r0 = com.kakaogame.log.ReactiveLogManager.lock     // Catch: java.lang.Exception -> L5d
            monitor-enter(r0)     // Catch: java.lang.Exception -> L5d
            com.kakaogame.log.ReactiveLogManager r1 = com.kakaogame.log.ReactiveLogManager.INSTANCE     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = r1.getPushId(r10)     // Catch: java.lang.Throwable -> L5a
            r2 = r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Throwable -> L5a
            if (r2 == 0) goto L46
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L5a
            if (r2 != 0) goto L44
            goto L46
        L44:
            r2 = 0
            goto L47
        L46:
            r2 = 1
        L47:
            if (r2 != 0) goto L56
            r2 = r10
            android.content.Context r2 = (android.content.Context) r2     // Catch: java.lang.Throwable -> L5a
            java.lang.String r3 = "pushmsg"
            java.lang.String r4 = "disable"
            r6 = 0
            r7 = -1
            r1.writeActionLog(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5a
        L56:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L5a
            monitor-exit(r0)     // Catch: java.lang.Exception -> L5d
            goto L70
        L5a:
            r10 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Exception -> L5d
            throw r10     // Catch: java.lang.Exception -> L5d
        L5d:
            r10 = move-exception
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            r1 = -628359700(0xffffffffda8bfdec, float:-1.9702106E16)
            java.lang.String r1 = com.liapp.y.ݮڮֲڭܩ(r1)
            java.lang.String r2 = r10.toString()
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            r0.m702e(r1, r2, r10)
        L70:
            return
            fill-array 0x0072: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.log.ReactiveLogManager.disablePush(android.app.Activity):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void writeActionLog(Context context, String category, String action, String pushId, String segId, long valueNo) {
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ݬֲ֮ܲت(1512793951)).append(category);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(action).append(str).append(pushId).append(str).append(segId).append(str).append(valueNo).toString();
        String str2 = y.ݮڮֲڭܩ(-628359700);
        logger.m704i(str2, sb);
        if (context == null) {
            Logger.INSTANCE.m701e(str2, y.ٲٴݴ״ٰ(1782240648));
            return;
        }
        if (TextUtils.isEmpty(category)) {
            Logger.INSTANCE.m701e(str2, y.٬ݯح׭٩(575766846));
            return;
        }
        if (TextUtils.isEmpty(action)) {
            Logger.INSTANCE.m701e(str2, y.ٴسسݬߨ(1392657618));
            return;
        }
        Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
        Intrinsics.checkNotNull(configuration);
        String appId = configuration.getAppId();
        String appSecret = configuration.getAppSecret();
        String market = configuration.getMarket();
        String playerId = CoreManager.INSTANCE.getInstance().getPlayerId();
        String str3 = playerId;
        if (str3 == null || str3.length() == 0) {
            playerId = AuthDataManager.INSTANCE.getLastPlayerId(context);
        }
        String str4 = playerId;
        if (str4 == null || str4.length() == 0) {
            Logger.INSTANCE.m701e(str2, y.ٴسسݬߨ(1393544954));
            return;
        }
        String deviceId = KGSystem.getDeviceId();
        String countryCode = LocaleManager.INSTANCE.getCountryCode();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str5 = y.ۮڭڭܬި(862411867);
        linkedHashMap.put(str5, appId);
        linkedHashMap.put(y.ۮڭڭܬި(862506555), appSecret);
        String str6 = y.ݬֲ֮ܲت(1512589743);
        linkedHashMap.put(str6, playerId);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(str5, appId);
        linkedHashMap2.put(str6, playerId);
        linkedHashMap2.put(y.ۮڭڭܬި(862689795), category);
        linkedHashMap2.put(y.֬ڱܱײٮ(-1159583711), action);
        if (pushId != null) {
            linkedHashMap2.put(y.ٲٴݴ״ٰ(1782016584), pushId);
        }
        if (segId != null) {
            linkedHashMap2.put(y.ݮڮֲڭܩ(-628359308), segId);
        }
        linkedHashMap2.put(y.ۮڭڭܬި(862691907), Long.valueOf(valueNo));
        linkedHashMap2.put(y.ۮڭڭܬި(862691979), deviceId);
        linkedHashMap2.put(y.دײܮڳܯ(2051393733), countryCode);
        linkedHashMap2.put(y.دײܮڳܯ(2051758173), market);
        linkedHashMap2.put(y.ݮڮֲڭܩ(-628723908), KGSystem.getOSName());
        LogThreadPoolManager logThreadPoolManager = LogThreadPoolManager.INSTANCE;
        Logger.INSTANCE.m704i(str2, y.ݬֲ֮ܲت(1512497271) + OpenApiService.requestOpenApi(Settings.INSTANCE.getWriteActionLogOpenAPIUri(), linkedHashMap, linkedHashMap2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getPushId(Activity activity) {
        if (activity == null) {
            return null;
        }
        return getPushId(activity.getIntent());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void removePushId(Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return;
        }
        intent.removeExtra(y.ٲٴݴ״ٰ(1782240584));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String getPushId(Intent intent) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862691427);
        String str2 = y.ݮڮֲڭܩ(-628359700);
        logger.m699d(str2, str + intent);
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra(y.ٲٴݴ״ٰ(1782240584));
        Logger.INSTANCE.m704i(str2, str + stringExtra);
        return stringExtra;
    }

    /* compiled from: ReactiveLogManager.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/log/ReactiveLogManager$Settings;", "", "()V", "writeActionLogOpenAPIUri", "", "getWriteActionLogOpenAPIUri", "()Ljava/lang/String;", "setWriteActionLogOpenAPIUri", "(Ljava/lang/String;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        public static final Settings INSTANCE = new Settings();
        private static String writeActionLogOpenAPIUri = y.دײܮڳܯ(2051459821);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Settings() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getWriteActionLogOpenAPIUri() {
            return writeActionLogOpenAPIUri;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setWriteActionLogOpenAPIUri(String str) {
            Intrinsics.checkNotNullParameter(str, y.ٴسسݬߨ(1392633402));
            writeActionLogOpenAPIUri = str;
        }
    }
}
