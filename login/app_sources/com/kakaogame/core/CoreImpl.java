package com.kakaogame.core;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.kakaogame.KGResult;
import com.kakaogame.KGSession;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthImpl;
import com.kakaogame.auth.LoginData;
import com.kakaogame.auth.agreement.AgreementManager;
import com.kakaogame.config.ConfigLoader;
import com.kakaogame.config.Configuration;
import com.kakaogame.config.LocalConfigDataManager;
import com.kakaogame.gameserver.GameSessionService;
import com.kakaogame.idp.ChannelConnectHelper;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.infodesk.InfodeskData;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.infodesk.InfodeskNoticeManager;
import com.kakaogame.infodesk.InfodeskService;
import com.kakaogame.invite.InviteDataManager;
import com.kakaogame.log.ErrorLogManager;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.log.tracer.TraceJobCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.p029ui.AppUpdateManager;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.p029ui.ImageDownloader;
import com.kakaogame.promotion.UrlPromotionManager;
import com.kakaogame.push.OnlinePushManager;
import com.kakaogame.server.PresenceService;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.InputUtil;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CoreImpl.kt */
@Metadata(m838d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001a\u0010\"\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0002J\"\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\b2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002J\u001e\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020)\u0018\u00010(0\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0006\u0010*\u001a\u00020\u001dJ\u0010\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\bH\u0007J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J$\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\b2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J$\u00101\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00118F@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, m839d2 = {"Lcom/kakaogame/core/CoreImpl;", "", "()V", "TAG", "", "autoLoginAccount", "Lcom/kakaogame/idp/IdpAccount;", "autoLoginResult", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/auth/LoginData;", "autoLoginTraceJobId", "", "configuration", "Lcom/kakaogame/config/Configuration;", "initLock", "initial_appId", "initialized", "", "<set-?>", "isPaused", "()Z", "value", "isStarting", "setStarting", "(Z)V", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "startLock", "checkPlatformSettingScheme", "", "activity", "Landroid/app/Activity;", "getInfodesk", "Ljava/lang/Void;", "initModule", "config", "initialize", "appId", "isInitialized", "loadAppInfos", "", "Lcom/kakaogame/KGSession$KGAppInfo;", "onLogout", "pause", "requestInstallReferrer", "resume", "setInitialize", "start", "startImpl", "useDynamicConfig", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class CoreImpl {
    private static final String TAG = "CoreImpl";
    private static IdpAccount autoLoginAccount;
    private static KGResult<LoginData> autoLoginResult;
    private static Configuration configuration;
    private static boolean initialized;
    private static boolean isPaused;
    private static boolean isStarting;
    private static InstallReferrerClient referrerClient;
    public static final CoreImpl INSTANCE = new CoreImpl();
    private static final Object initLock = new Object();
    private static final Object startLock = new Object();
    private static String initial_appId = "";
    private static int autoLoginTraceJobId = -1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> start(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        return start$default(activity, null, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CoreImpl() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isStarting() {
        boolean z;
        synchronized (startLock) {
            z = isStarting;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setStarting(boolean z) {
        synchronized (startLock) {
            isStarting = z;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPaused() {
        return isPaused;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00f3 A[Catch: Exception -> 0x0282, TryCatch #0 {Exception -> 0x0282, blocks: (B:3:0x004b, B:5:0x005c, B:8:0x006c, B:11:0x0082, B:13:0x0090, B:14:0x0094, B:16:0x009a, B:18:0x009e, B:19:0x00a2, B:20:0x00cb, B:22:0x00cf, B:23:0x00d3, B:25:0x00e7, B:30:0x00f3, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:37:0x0111, B:39:0x0115, B:40:0x0119, B:42:0x0132, B:43:0x0136, B:45:0x0143, B:46:0x0147, B:48:0x0187, B:51:0x01a4, B:53:0x01b4, B:55:0x01c4, B:57:0x01c8, B:59:0x01d2, B:61:0x01d9, B:62:0x01dd, B:64:0x01e8, B:65:0x01ec, B:67:0x0211, B:69:0x022c, B:72:0x0239, B:74:0x0240, B:75:0x0245, B:77:0x024c, B:78:0x0278, B:83:0x00c0), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0115 A[Catch: Exception -> 0x0282, TryCatch #0 {Exception -> 0x0282, blocks: (B:3:0x004b, B:5:0x005c, B:8:0x006c, B:11:0x0082, B:13:0x0090, B:14:0x0094, B:16:0x009a, B:18:0x009e, B:19:0x00a2, B:20:0x00cb, B:22:0x00cf, B:23:0x00d3, B:25:0x00e7, B:30:0x00f3, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:37:0x0111, B:39:0x0115, B:40:0x0119, B:42:0x0132, B:43:0x0136, B:45:0x0143, B:46:0x0147, B:48:0x0187, B:51:0x01a4, B:53:0x01b4, B:55:0x01c4, B:57:0x01c8, B:59:0x01d2, B:61:0x01d9, B:62:0x01dd, B:64:0x01e8, B:65:0x01ec, B:67:0x0211, B:69:0x022c, B:72:0x0239, B:74:0x0240, B:75:0x0245, B:77:0x024c, B:78:0x0278, B:83:0x00c0), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0132 A[Catch: Exception -> 0x0282, TryCatch #0 {Exception -> 0x0282, blocks: (B:3:0x004b, B:5:0x005c, B:8:0x006c, B:11:0x0082, B:13:0x0090, B:14:0x0094, B:16:0x009a, B:18:0x009e, B:19:0x00a2, B:20:0x00cb, B:22:0x00cf, B:23:0x00d3, B:25:0x00e7, B:30:0x00f3, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:37:0x0111, B:39:0x0115, B:40:0x0119, B:42:0x0132, B:43:0x0136, B:45:0x0143, B:46:0x0147, B:48:0x0187, B:51:0x01a4, B:53:0x01b4, B:55:0x01c4, B:57:0x01c8, B:59:0x01d2, B:61:0x01d9, B:62:0x01dd, B:64:0x01e8, B:65:0x01ec, B:67:0x0211, B:69:0x022c, B:72:0x0239, B:74:0x0240, B:75:0x0245, B:77:0x024c, B:78:0x0278, B:83:0x00c0), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0143 A[Catch: Exception -> 0x0282, TryCatch #0 {Exception -> 0x0282, blocks: (B:3:0x004b, B:5:0x005c, B:8:0x006c, B:11:0x0082, B:13:0x0090, B:14:0x0094, B:16:0x009a, B:18:0x009e, B:19:0x00a2, B:20:0x00cb, B:22:0x00cf, B:23:0x00d3, B:25:0x00e7, B:30:0x00f3, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:37:0x0111, B:39:0x0115, B:40:0x0119, B:42:0x0132, B:43:0x0136, B:45:0x0143, B:46:0x0147, B:48:0x0187, B:51:0x01a4, B:53:0x01b4, B:55:0x01c4, B:57:0x01c8, B:59:0x01d2, B:61:0x01d9, B:62:0x01dd, B:64:0x01e8, B:65:0x01ec, B:67:0x0211, B:69:0x022c, B:72:0x0239, B:74:0x0240, B:75:0x0245, B:77:0x024c, B:78:0x0278, B:83:0x00c0), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0187 A[Catch: Exception -> 0x0282, TryCatch #0 {Exception -> 0x0282, blocks: (B:3:0x004b, B:5:0x005c, B:8:0x006c, B:11:0x0082, B:13:0x0090, B:14:0x0094, B:16:0x009a, B:18:0x009e, B:19:0x00a2, B:20:0x00cb, B:22:0x00cf, B:23:0x00d3, B:25:0x00e7, B:30:0x00f3, B:32:0x00fa, B:33:0x00fe, B:35:0x0108, B:37:0x0111, B:39:0x0115, B:40:0x0119, B:42:0x0132, B:43:0x0136, B:45:0x0143, B:46:0x0147, B:48:0x0187, B:51:0x01a4, B:53:0x01b4, B:55:0x01c4, B:57:0x01c8, B:59:0x01d2, B:61:0x01d9, B:62:0x01dd, B:64:0x01e8, B:65:0x01ec, B:67:0x0211, B:69:0x022c, B:72:0x0239, B:74:0x0240, B:75:0x0245, B:77:0x024c, B:78:0x0278, B:83:0x00c0), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a2  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.kakaogame.KGResult<java.lang.Void> initialize(android.app.Activity r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.core.CoreImpl.initialize(android.app.Activity, java.lang.String):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean useDynamicConfig(Activity activity, String appId, Configuration config) {
        if (appId == null && SdkManager.INSTANCE.checkTestAppLaunching(activity)) {
            return true;
        }
        Intrinsics.checkNotNull(config);
        if (!StringsKt.equals("195539", config.getAppId(), true)) {
            return false;
        }
        Logger.INSTANCE.m699d(TAG, "Start on Friends Time App. Use Dynamic Config.");
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isInitialized() {
        boolean z;
        synchronized (initLock) {
            z = initialized;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setInitialize(boolean value) {
        synchronized (initLock) {
            initialized = value;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void checkPlatformSettingScheme(final Activity activity) {
        Uri data;
        final Intent intent = activity.getIntent();
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393414154) + intent;
        String str2 = y.ۮڭڭܬި(862564443);
        logger.m699d(str2, str);
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        String authority = data.getAuthority();
        if (authority != null && StringsKt.equals(authority, y.֬ڱܱײٮ(-1158836839), true)) {
            final String whiteKey = DeviceUtil.getWhiteKey(activity);
            activity.runOnUiThread(new Runnable() { // from class: com.kakaogame.core.CoreImpl$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    CoreImpl.checkPlatformSettingScheme$lambda$4(whiteKey, activity, intent);
                }
            });
            return;
        }
        String queryParameter = data.getQueryParameter(y.ۮڭڭܬި(862566459));
        Logger.INSTANCE.m701e(str2, y.ٴسسݬߨ(1393414506) + queryParameter);
        if (queryParameter != null) {
            String queryParameter2 = data.getQueryParameter(y.٬ݯح׭٩(576591198));
            if (queryParameter2 == null) {
                return;
            }
            if (LocalConfigDataManager.saveLocalConfigData(activity, queryParameter, queryParameter2)) {
                intent.setData(null);
                activity.setIntent(intent);
                DialogManager.INSTANCE.showProcessKillDialog(activity, y.ݬֲ֮ܲت(1512372767), false);
            }
        }
        if (data.getQueryParameter(y.֬ڱܱײٮ(-1158836367)) != null) {
            LocalConfigDataManager.removeLocalConfigData(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void checkPlatformSettingScheme$lambda$4(String str, Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(str, y.֬ڱܱײٮ(-1158836407));
        Intrinsics.checkNotNullParameter(activity, y.ݬֲ֮ܲت(1512823367));
        if (TextUtils.isEmpty(str)) {
            Toast makeText = Toast.makeText(activity, "White Key를 가져오는데 실패했습니다. '설정 > 구글 > 광고' 해제 여부를 확인해주세요.", 0);
            y.٬خݮ۳ݯ();
            makeText.show();
            return;
        }
        Activity activity2 = activity;
        InputUtil.setClipboardText(activity2, str, str);
        Toast makeText2 = Toast.makeText(activity2, "White Key가 클립보드에 복사되었습니다.", 0);
        y.٬خݮ۳ݯ();
        makeText2.show();
        intent.setData(null);
        activity.setIntent(intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void requestInstallReferrer(final Activity activity) {
        try {
            if (InviteDataManager.isFirstLaunching(activity) && DeviceUtil.isGooglePlayServicesAvailable(activity)) {
                InstallReferrerClient build = InstallReferrerClient.newBuilder(activity).build();
                referrerClient = build;
                if (build != null) {
                    build.startConnection(new InstallReferrerStateListener() { // from class: com.kakaogame.core.CoreImpl$requestInstallReferrer$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.android.installreferrer.api.InstallReferrerStateListener
                        public void onInstallReferrerServiceDisconnected() {
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
                        
                            com.kakaogame.invite.InviteDataManager.saveReferrer(r1, r3);
                         */
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.android.installreferrer.api.InstallReferrerStateListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void onInstallReferrerSetupFinished(int r6) {
                            /*
                                r5 = this;
                                r0 = 1512371111(0x5a24f3a7, float:1.1607449E16)
                                java.lang.String r0 = com.liapp.y.ݬֲ֮ܲت(r0)
                                r1 = 1
                                r2 = 862564443(0x3369b05b, float:5.4409934E-8)
                                java.lang.String r2 = com.liapp.y.ۮڭڭܬި(r2)
                                if (r6 == 0) goto L31
                                if (r6 == r1) goto L24
                                r0 = 2
                                if (r6 == r0) goto L17
                                goto L87
                            L17:
                                com.kakaogame.Logger r6 = com.kakaogame.Logger.INSTANCE
                                r0 = 576593294(0x225e1d8e, float:3.0102256E-18)
                                java.lang.String r0 = com.liapp.y.٬ݯح׭٩(r0)
                                r6.m699d(r2, r0)
                                goto L87
                            L24:
                                com.kakaogame.Logger r6 = com.kakaogame.Logger.INSTANCE
                                r0 = 576590078(0x225e10fe, float:3.0095606E-18)
                                java.lang.String r0 = com.liapp.y.٬ݯح׭٩(r0)
                                r6.m699d(r2, r0)
                                goto L87
                            L31:
                                com.android.installreferrer.api.InstallReferrerClient r6 = com.kakaogame.core.CoreImpl.access$getReferrerClient$p()     // Catch: java.lang.Exception -> L6d
                                r3 = 0
                                if (r6 == 0) goto L3d
                                com.android.installreferrer.api.ReferrerDetails r6 = r6.getInstallReferrer()     // Catch: java.lang.Exception -> L6d
                                goto L3e
                            L3d:
                                r6 = r3
                            L3e:
                                if (r6 == 0) goto L44
                                java.lang.String r3 = r6.getInstallReferrer()     // Catch: java.lang.Exception -> L6d
                            L44:
                                com.kakaogame.Logger r6 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> L6d
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6d
                                r4.<init>(r0)     // Catch: java.lang.Exception -> L6d
                                java.lang.StringBuilder r0 = r4.append(r3)     // Catch: java.lang.Exception -> L6d
                                java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L6d
                                r6.m699d(r2, r0)     // Catch: java.lang.Exception -> L6d
                                r6 = r3
                                java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch: java.lang.Exception -> L6d
                                if (r6 == 0) goto L63
                                int r6 = r6.length()     // Catch: java.lang.Exception -> L6d
                                if (r6 != 0) goto L62
                                goto L63
                            L62:
                                r1 = 0
                            L63:
                                if (r1 != 0) goto L87
                                android.app.Activity r6 = r1     // Catch: java.lang.Exception -> L6d
                                android.content.Context r6 = (android.content.Context) r6     // Catch: java.lang.Exception -> L6d
                                com.kakaogame.invite.InviteDataManager.saveReferrer(r6, r3)     // Catch: java.lang.Exception -> L6d
                                goto L87
                            L6d:
                                r6 = move-exception
                                com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                r3 = 576590678(0x225e1356, float:3.0096847E-18)
                                java.lang.String r3 = com.liapp.y.٬ݯح׭٩(r3)
                                r1.<init>(r3)
                                java.lang.StringBuilder r6 = r1.append(r6)
                                java.lang.String r6 = r6.toString()
                                r0.m699d(r2, r6)
                            L87:
                                com.android.installreferrer.api.InstallReferrerClient r6 = com.kakaogame.core.CoreImpl.access$getReferrerClient$p()
                                if (r6 == 0) goto L97
                                com.android.installreferrer.api.InstallReferrerClient r6 = com.kakaogame.core.CoreImpl.access$getReferrerClient$p()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                                r6.endConnection()
                            L97:
                                return
                                fill-array 0x0098: FILL_ARRAY_DATA , data: ?
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.core.CoreImpl$requestInstallReferrer$1.onInstallReferrerSetupFinished(int):void");
                        }
                    });
                }
            }
        } catch (Exception e) {
            Logger.INSTANCE.m700d(y.ۮڭڭܬި(862564443), y.دײܮڳܯ(2051287613) + e, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ KGResult start$default(Activity activity, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return start(activity, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> start(final Activity activity, String appId) {
        KGResult<Void> result;
        boolean checkTestAppLaunching;
        String str;
        String str2;
        String str3 = y.ݮڮֲڭܩ(-628551492);
        String str4 = y.ٴسسݬߨ(1393370522);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str5 = y.دײܮڳܯ(2051594277) + activity;
        String str6 = y.ۮڭڭܬި(862564443);
        logger.m704i(str6, str5);
        CoreManager.INSTANCE.getInstance().setActivityHolder(new Function0<Activity>() { // from class: com.kakaogame.core.CoreImpl$start$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Activity invoke() {
                return activity;
            }
        });
        CoreImpl coreImpl = INSTANCE;
        if (coreImpl.isStarting()) {
            Logger.INSTANCE.m701e(str6, "start: already starting.");
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.IN_PROGRESS, y.ݬֲ֮ܲت(1512312311));
        }
        FirebaseEvent firebaseEvent = null;
        Configuration configuration2 = null;
        try {
            try {
                coreImpl.requestInstallReferrer(activity);
                coreImpl.checkPlatformSettingScheme(activity);
                checkTestAppLaunching = SdkManager.INSTANCE.checkTestAppLaunching(activity);
                str = y.ٲٴݴ״ٰ(1782069304);
                str2 = y.ٴسسݬߨ(1392718866);
            } catch (Exception e) {
                e = e;
            }
            if (!checkTestAppLaunching && coreImpl.isInitialized() && (TextUtils.isEmpty(appId) || Intrinsics.areEqual(initial_appId, appId))) {
                Logger.INSTANCE.m699d(str6, "start: already initialized.");
                if (!SDKVersion.isPublishing) {
                    KGResult<Void> successResult = KGResult.INSTANCE.getSuccessResult();
                    coreImpl.setStarting(false);
                    return successResult;
                }
                FirebaseEvent firebaseTrace = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, str);
                coreImpl.setStarting(false);
                isPaused = true;
                KGResult<Void> resume = resume(activity);
                firebaseTrace.setResult(resume);
                coreImpl.setStarting(false);
                return resume;
            }
            coreImpl.setStarting(true);
            Intent intent = activity.getIntent();
            if (intent != null) {
                CoreManager.INSTANCE.getInstance().setLaunchingReferrer(intent.getExtras());
            }
            KGResult<Void> initialize = coreImpl.initialize(activity, appId);
            Logger.INSTANCE.m706v(str6, str4 + initialize);
            if (initialize.isNotSuccess()) {
                KGResult<Void> result2 = KGResult.INSTANCE.getResult(initialize.getCode(), initialize.getDescription());
                coreImpl.setStarting(false);
                return result2;
            }
            CoreManager.INSTANCE.getInstance().initFirebase(activity);
            FirebaseEvent firebaseTrace2 = FirebaseEvent.INSTANCE.getFirebaseTrace(str2, str);
            try {
            } catch (Exception e2) {
                e = e2;
                firebaseEvent = firebaseTrace2;
                Logger.INSTANCE.m702e(str6, e.toString(), e);
                result = KGResult.INSTANCE.getResult(9999, e.toString());
                if (firebaseEvent != null) {
                    firebaseEvent.setResult(result);
                }
                return result;
            }
            if (!SDKVersion.isPublishing && autoLoginAccount == null) {
                KGResult<Void> successResult2 = KGResult.INSTANCE.getSuccessResult();
                firebaseTrace2.setResult(successResult2);
                coreImpl.setStarting(false);
                return successResult2;
            }
            KGResult<Void> startImpl = coreImpl.startImpl(activity);
            Logger.INSTANCE.m706v(str6, str3 + startImpl);
            if (startImpl.isSuccess()) {
                if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
                    UrlPromotionManager.checkUrlPromotion(activity);
                }
                Activity activity2 = activity;
                Configuration configuration3 = configuration;
                if (configuration3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("configuration");
                } else {
                    configuration2 = configuration3;
                }
                LocaleManager.requestGeoCountryCode(activity2, configuration2);
            }
            result = KGResult.INSTANCE.getResult(startImpl.getCode(), startImpl.getDescription());
            firebaseTrace2.setResult(result);
            coreImpl.setStarting(false);
            return result;
        } finally {
            INSTANCE.setStarting(false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<List<KGSession.KGAppInfo>> loadAppInfos(final Activity activity) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        CoreManager.INSTANCE.getInstance().setActivityHolder(new Function0<Activity>() { // from class: com.kakaogame.core.CoreImpl$loadAppInfos$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Activity invoke() {
                return activity;
            }
        });
        Activity activity2 = activity;
        CoreManager.INSTANCE.getInstance().initFirebase(activity2);
        KGResult<Configuration> loadConfiguration = ConfigLoader.loadConfiguration(activity, null);
        if (!loadConfiguration.isSuccess()) {
            return KGResult.INSTANCE.getResult(loadConfiguration);
        }
        Configuration content = loadConfiguration.getContent();
        Intrinsics.checkNotNull(content);
        Configuration configuration2 = content;
        if (LocaleManager.requestGeoCountryCode(activity2, configuration2).isNotSuccess()) {
            return KGResult.INSTANCE.getResult(1001);
        }
        boolean z = true;
        LocaleManager.INSTANCE.getCountryCode(activity2, true, configuration2);
        KGResult<List<JSONObject>> loadAppInfoList = InfodeskService.loadAppInfoList(activity2, configuration2);
        if (loadAppInfoList.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(loadAppInfoList);
        }
        List<JSONObject> content2 = loadAppInfoList.getContent();
        List<JSONObject> list = content2;
        if (list != null && !list.isEmpty()) {
            z = false;
        }
        if (z) {
            return KGResult.INSTANCE.getResult(4002);
        }
        ArrayList arrayList = new ArrayList();
        for (JSONObject jSONObject : content2) {
            Intrinsics.checkNotNull(jSONObject);
            arrayList.add(new KGSession.KGAppInfo(jSONObject));
        }
        return KGResult.INSTANCE.getSuccessResult(arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> resume(final Activity activity) {
        KGResult<Void> result;
        String str = y.ݬֲ֮ܲت(1512415535);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٲٴݴ״ٰ(1781928728);
        String str3 = y.ۮڭڭܬި(862564443);
        logger.m704i(str3, str2);
        CoreManager.INSTANCE.getInstance().setActivityHolder(new Function0<Activity>() { // from class: com.kakaogame.core.CoreImpl$resume$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Activity invoke() {
                return activity;
            }
        });
        CoreImpl coreImpl = INSTANCE;
        if (!coreImpl.isInitialized()) {
            Logger.INSTANCE.m699d(str3, y.ݮڮֲڭܩ(-628548284));
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (coreImpl.isStarting()) {
            Logger.INSTANCE.m699d(str3, y.ٲٴݴ״ٰ(1782068936));
            CoreManager.INSTANCE.getInstance().resume();
            return KGResult.INSTANCE.getSuccessResult();
        }
        DisplayUtil.checkSystemFontSize(activity);
        Intent intent = activity.getIntent();
        if (intent != null) {
            CoreManager.INSTANCE.getInstance().setLaunchingReferrer(intent.getExtras());
        }
        if (!SDKVersion.isPublishing) {
            CoreManager.INSTANCE.getInstance().resume();
            if (InfodeskHelper.INSTANCE.isUseHttpHeartbeat()) {
                PresenceService.startHeartbeat();
            }
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (!isPaused) {
            Logger.INSTANCE.m699d(str3, y.֬ڱܱײٮ(-1158842471));
            return KGResult.INSTANCE.getSuccessResult();
        }
        if (AuthImpl.isLoginProcess()) {
            Logger.INSTANCE.m699d(str3, y.ٴسسݬߨ(1393371930));
            CoreManager.INSTANCE.getInstance().resume();
            return KGResult.INSTANCE.getSuccessResult();
        }
        coreImpl.checkPlatformSettingScheme(activity);
        ErrorLogManager.sendFailLogData();
        KGResult<Void> infodesk = coreImpl.getInfodesk(activity);
        if (infodesk.isNotSuccess()) {
            return infodesk;
        }
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        coreImpl.setStarting(true);
        Logger.INSTANCE.m699d(str3, y.ٲٴݴ״ٰ(1782070080));
        try {
            try {
                IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
                if (authData != null) {
                    int makeJob = Tracer.INSTANCE.makeJob(TraceJobCode.SDK_AUTO_LOGIN);
                    KGResult<LoginData> autoLogin = CoreManager.INSTANCE.getInstance().autoLogin(activity, true, makeJob);
                    if (!autoLogin.isNotSuccess()) {
                        KGResult<Void> checkAgreement = AgreementManager.checkAgreement(activity, authData, AgreementManager.AgreementCheckType.AUTO_LOGIN, makeJob);
                        Logger.INSTANCE.m699d(str3, str + checkAgreement);
                        Tracer.finish$default(Tracer.INSTANCE, makeJob, checkAgreement.getCode(), checkAgreement.toString(), null, 4, null);
                        if (checkAgreement.isNotSuccess()) {
                            KGResult<Void> result2 = checkAgreement.getCode() == 400 ? KGResult.INSTANCE.getResult(4010) : KGResult.INSTANCE.getResult(checkAgreement);
                            coreImpl.setStarting(false);
                            return result2;
                        }
                    } else if (autoLogin.getCode() != 3002) {
                        KGResult<Void> handleLoginResult = AuthImpl.handleLoginResult(activity, authData, autoLogin, true, makeJob);
                        Tracer.finish$default(Tracer.INSTANCE, makeJob, handleLoginResult.getCode(), handleLoginResult.toString(), null, 4, null);
                        if (autoLogin.getCode() != 463) {
                            KGResult<Void> result3 = handleLoginResult.isNotSuccess() ? KGResult.INSTANCE.getResult(handleLoginResult) : KGResult.INSTANCE.getResult(autoLogin);
                            coreImpl.setStarting(false);
                            return result3;
                        }
                        if (handleLoginResult.isNotSuccess()) {
                            KGResult<Void> result4 = handleLoginResult.getCode() == 463 ? KGResult.INSTANCE.getResult(401) : KGResult.INSTANCE.getResult(handleLoginResult);
                            coreImpl.setStarting(false);
                            return result4;
                        }
                    }
                }
                KGResult<Void> resume = CoreManager.INSTANCE.getInstance().resume();
                UrlPromotionManager.checkUrlPromotion(activity);
                result = KGResult.INSTANCE.getResult(resume);
                coreImpl.setStarting(false);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str3, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                INSTANCE.setStarting(false);
            }
            return result;
        } catch (Throwable th) {
            INSTANCE.setStarting(false);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> getInfodesk(Activity activity) {
        KGResult<InfodeskData> loadInfodesk = CoreManager.INSTANCE.getInstance().loadInfodesk(false);
        boolean isNotSuccess = loadInfodesk.isNotSuccess();
        String str = y.ۮڭڭܬި(862564443);
        if (isNotSuccess) {
            Logger.INSTANCE.m701e(str, y.ݬֲ֮ܲت(1512372535) + loadInfodesk);
            return KGResult.INSTANCE.getResult(loadInfodesk);
        }
        KGResult<Void> handleInfodesk = CoreManager.INSTANCE.getInstance().handleInfodesk(activity, loadInfodesk.getContent(), false);
        if (handleInfodesk.isNotSuccess()) {
            Logger.INSTANCE.m701e(str, y.ݮڮֲڭܩ(-628496388) + handleInfodesk);
            return KGResult.INSTANCE.getResult(handleInfodesk);
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> pause() {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051682333);
        String str2 = y.ۮڭڭܬި(862564443);
        logger.m704i(str2, str);
        try {
            if (!AuthImpl.isLoginProcess() && !CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                isPaused = true;
                return KGResult.INSTANCE.getResult(CoreManager.INSTANCE.getInstance().pause());
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void onLogout() {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862564443), y.ۮڭڭܬި(862540123));
        autoLoginAccount = null;
        autoLoginResult = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> startImpl(Activity activity) {
        ErrorLogManager.sendFailLogData();
        InfodeskData infodesk = CoreManager.INSTANCE.getInstance().getInfodesk();
        String str = y.ۮڭڭܬި(862564443);
        if (infodesk == null) {
            KGResult<InfodeskData> loadInfodesk = CoreManager.INSTANCE.getInstance().loadInfodesk(false);
            if (loadInfodesk.isNotSuccess()) {
                Logger.INSTANCE.m701e(str, y.֬ڱܱײٮ(-1158841767) + loadInfodesk);
                return KGResult.INSTANCE.getResult(loadInfodesk);
            }
            infodesk = loadInfodesk.getContent();
        }
        KGResult<Void> handleInfodesk = CoreManager.INSTANCE.getInstance().handleInfodesk(activity, infodesk, false);
        if (handleInfodesk.isNotSuccess()) {
            Logger.INSTANCE.m708w(str, y.ݮڮֲڭܩ(-628496388) + handleInfodesk);
            return KGResult.INSTANCE.getResult(handleInfodesk);
        }
        long checkWarningSDK = InfodeskHelper.INSTANCE.checkWarningSDK();
        if (checkWarningSDK > -1) {
            Logger.INSTANCE.m703he(str, y.ٴسسݬߨ(1393369154));
            if (checkWarningSDK == 0) {
                CoreManager.INSTANCE.getInstance().startWarningSDKTimer();
            }
        }
        KGResult<LoginData> kGResult = autoLoginResult;
        if (kGResult != null && kGResult.isNotSuccess()) {
            if (kGResult.getCode() == 3002) {
                Tracer.finish$default(Tracer.INSTANCE, autoLoginTraceJobId, 3002, y.٬ݯح׭٩(576644918), null, 4, null);
                autoLoginTraceJobId = -1;
            } else {
                KGResult<Void> handleLoginResult = AuthImpl.handleLoginResult(activity, autoLoginAccount, kGResult, true, autoLoginTraceJobId);
                Logger.INSTANCE.m708w(str, y.ٲٴݴ״ٰ(1782063656) + handleLoginResult);
                Tracer.finish$default(Tracer.INSTANCE, autoLoginTraceJobId, handleLoginResult.isNotSuccess() ? handleLoginResult.getCode() : kGResult.getCode(), handleLoginResult.isNotSuccess() ? handleLoginResult.toString() : kGResult.toString(), null, 4, null);
                autoLoginTraceJobId = -1;
                if (handleLoginResult.getCode() == 463) {
                    Logger.INSTANCE.m699d(str, y.ٲٴݴ״ٰ(1782063368));
                } else {
                    if (handleLoginResult.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(handleLoginResult);
                    }
                    if (!CoreManager.INSTANCE.getInstance().isAuthError(kGResult)) {
                        return KGResult.INSTANCE.getResult(kGResult);
                    }
                }
            }
        }
        Logger.INSTANCE.m699d(str, y.ٲٴݴ״ٰ(1782063608) + CoreManager.INSTANCE.getInstance().isAuthorized());
        if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
            Logger.INSTANCE.m699d(str, y.֬ڱܱײٮ(-1158847863));
            IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
            Intrinsics.checkNotNull(authData);
            ChannelConnectHelper.checkGoogleGame(activity, authData);
            KGResult<Void> checkAgreement = AgreementManager.checkAgreement(activity, authData, AgreementManager.AgreementCheckType.AUTO_LOGIN, autoLoginTraceJobId);
            Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512415535) + checkAgreement);
            Tracer.finish$default(Tracer.INSTANCE, autoLoginTraceJobId, 200, y.ٴسسݬߨ(1392755458), null, 4, null);
            autoLoginTraceJobId = -1;
            if (checkAgreement.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(checkAgreement);
            }
        }
        return KGResult.INSTANCE.getSuccessResult();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initModule(Activity activity, Configuration config) {
        AuthImpl.initialize();
        Intrinsics.checkNotNull(config);
        String appId = config.getAppId();
        Activity activity2 = activity;
        AgreementManager.initialize(activity2, appId);
        AppUpdateManager.initialize(appId);
        InfodeskNoticeManager.initialize(appId);
        UrlPromotionManager.initialize(activity2, appId);
        OnlinePushManager.initialize(activity2);
        ImageDownloader.initialize(activity2);
        GameSessionService.initialize(activity2);
    }
}
