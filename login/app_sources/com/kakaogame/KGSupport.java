package com.kakaogame;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.FeatureManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.DateUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.web.WebDialog;
import com.kakaogame.web.WebDialogManager;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGSupport.kt */
@Metadata(m838d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J$\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0015H\u0002J0\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0015H\u0002J$\u0010\u001b\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J,\u0010\u001b\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001c\u001a\u00020\u001d2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J,\u0010\u001b\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007JE\u0010\u001b\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002¢\u0006\u0002\u0010!J$\u0010\"\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J.\u0010\"\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J(\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010$2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010%J$\u0010&\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J$\u0010'\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J.\u0010(\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J$\u0010*\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J.\u0010+\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J6\u0010+\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010,\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J$\u0010-\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J.\u0010-\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J$\u0010/\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007J.\u0010/\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u00042\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u00060"}, m839d2 = {"Lcom/kakaogame/KGSupport;", "", "()V", "CLASS_NAME_KEY", "", "KEY_TGT_TOKEN", "KEY_URL", "PREF_KEY_NOTICE", "PREF_NAME", "TAG", "initInterfaceBroker", "", "initialize", "openExternalBrowser", "activity", "Landroid/app/Activity;", "uri", "showConfirm", "", "showCSView", "callback", "Lcom/kakaogame/KGResultCallback;", "showCafeCustomView", "url", "showCafeWebView", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "showCommunityView", "articleId", "", "pageCode", "fbEvent", "Lcom/kakaogame/log/FirebaseEvent;", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/Long;Lcom/kakaogame/KGResultCallback;Lcom/kakaogame/log/FirebaseEvent;)V", "showDaumCafeView", "showDaumCafeWebView", "Lcom/kakaogame/KGResult;", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showEventProgressWall", "showEventWall", "showEventWinningResultView", "eventKey", "showGachaOddsView", "showInAppWebView", "showNoticeOnlyView", "showNoticeView", "noticeKey", "showNoticeViewForOneDay", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGSupport {
    private static final String CLASS_NAME_KEY = "KGSupport";
    public static final KGSupport INSTANCE = new KGSupport();
    private static final String KEY_TGT_TOKEN = "{tgt_token}";
    private static final String KEY_URL = "{url}";
    private static final String PREF_KEY_NOTICE = "CommonNotice";
    private static final String PREF_NAME = "KGSupport_Notice";
    private static final String TAG = "KGSupport";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGSupport() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initialize() {
        initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCSView(Activity activity, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512730023);
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        try {
            INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getCustomerServiceUrl(), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showCSView"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showNoticeView(Activity activity, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051693997);
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        try {
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.notice)) {
                KGResult<String> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                    return;
                }
                return;
            }
            INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getNoticeUrl(), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showNoticeView"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result2 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showNoticeViewForOneDay(Activity activity, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628658852);
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        Activity activity2 = activity;
        String str3 = y.ݮڮֲڭܩ(-628658764);
        String str4 = y.ݮڮֲڭܩ(-628658652);
        String string = PreferenceUtil.getString(activity2, str3, str4, "");
        String currentDateToString = DateUtil.currentDateToString(y.ٴسسݬߨ(1392728762));
        if (Intrinsics.areEqual(string, currentDateToString)) {
            if (callback != null) {
                callback.onResult(KGResult.INSTANCE.getSuccessResult(""));
                return;
            }
            return;
        }
        PreferenceUtil.setString(activity2, str3, str4, currentDateToString);
        try {
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.notice)) {
                KGResult<String> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                    return;
                }
                return;
            }
            INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getNoticeUrl(), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showNoticeViewForOneDay"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result2 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[Catch: Exception -> 0x0080, TryCatch #0 {Exception -> 0x0080, blocks: (B:3:0x0020, B:5:0x002a, B:7:0x0034, B:11:0x0038, B:13:0x0045, B:18:0x0051, B:20:0x005d), top: B:2:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d A[Catch: Exception -> 0x0080, TRY_LEAVE, TryCatch #0 {Exception -> 0x0080, blocks: (B:3:0x0020, B:5:0x002a, B:7:0x0034, B:11:0x0038, B:13:0x0045, B:18:0x0051, B:20:0x005d), top: B:2:0x0020 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void showNoticeView(android.app.Activity r5, java.lang.String r6, com.kakaogame.KGResultCallback<java.lang.String> r7) {
        /*
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 1512731639(0x5a2a73f7, float:1.1994563E16)
            java.lang.String r2 = com.liapp.y.ݬֲ֮ܲت(r2)
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            r2 = 1512722991(0x5a2a522f, float:1.1985277E16)
            java.lang.String r2 = com.liapp.y.ݬֲ֮ܲت(r2)
            r0.m704i(r2, r1)
            com.kakaogame.core.FeatureManager r0 = com.kakaogame.core.FeatureManager.INSTANCE     // Catch: java.lang.Exception -> L80
            com.kakaogame.core.FeatureManager$Feature r1 = com.kakaogame.core.FeatureManager.Feature.notice     // Catch: java.lang.Exception -> L80
            boolean r0 = r0.isNotSupportedFeature(r1)     // Catch: java.lang.Exception -> L80
            if (r0 == 0) goto L38
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> L80
            r6 = 5001(0x1389, float:7.008E-42)
            com.kakaogame.KGResult r5 = r5.getResult(r6)     // Catch: java.lang.Exception -> L80
            if (r7 == 0) goto L37
            r7.onResult(r5)     // Catch: java.lang.Exception -> L80
        L37:
            return
        L38:
            com.kakaogame.log.FirebaseEvent$Companion r0 = com.kakaogame.log.FirebaseEvent.INSTANCE     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = "showNoticeView_noticeKey"
            com.kakaogame.log.FirebaseEvent r0 = r0.getFirebaseEvent(r2, r1)     // Catch: java.lang.Exception -> L80
            r1 = r6
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L80
            if (r1 == 0) goto L4e
            int r1 = r1.length()     // Catch: java.lang.Exception -> L80
            if (r1 != 0) goto L4c
            goto L4e
        L4c:
            r1 = 0
            goto L4f
        L4e:
            r1 = 1
        L4f:
            if (r1 == 0) goto L5d
            com.kakaogame.KGSupport r6 = com.kakaogame.KGSupport.INSTANCE     // Catch: java.lang.Exception -> L80
            com.kakaogame.infodesk.InfodeskHelper r1 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE     // Catch: java.lang.Exception -> L80
            java.lang.String r1 = r1.getNoticeUrl()     // Catch: java.lang.Exception -> L80
            r6.showInAppWebView(r5, r1, r7, r0)     // Catch: java.lang.Exception -> L80
            goto L9e
        L5d:
            com.kakaogame.KGSupport r1 = com.kakaogame.KGSupport.INSTANCE     // Catch: java.lang.Exception -> L80
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L80
            r3.<init>()     // Catch: java.lang.Exception -> L80
            com.kakaogame.infodesk.InfodeskHelper r4 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE     // Catch: java.lang.Exception -> L80
            java.lang.String r4 = r4.getNoticeUrl()     // Catch: java.lang.Exception -> L80
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Exception -> L80
            java.lang.String r4 = "/detail/"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Exception -> L80
            java.lang.StringBuilder r6 = r3.append(r6)     // Catch: java.lang.Exception -> L80
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L80
            r1.showInAppWebView(r5, r6, r7, r0)     // Catch: java.lang.Exception -> L80
            goto L9e
        L80:
            r5 = move-exception
            com.kakaogame.Logger r6 = com.kakaogame.Logger.INSTANCE
            java.lang.String r0 = r5.toString()
            r1 = r5
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r6.m702e(r2, r0, r1)
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE
            r0 = 4001(0xfa1, float:5.607E-42)
            java.lang.String r5 = r5.toString()
            com.kakaogame.KGResult r5 = r6.getResult(r0, r5)
            if (r7 == 0) goto L9e
            r7.onResult(r5)
        L9e:
            return
            fill-array 0x00a0: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGSupport.showNoticeView(android.app.Activity, java.lang.String, com.kakaogame.KGResultCallback):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showNoticeViewForOneDay(Activity activity, String noticeKey, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862401043) + noticeKey;
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        Activity activity2 = activity;
        Intrinsics.checkNotNull(noticeKey);
        String str3 = y.ݮڮֲڭܩ(-628658764);
        String string = PreferenceUtil.getString(activity2, str3, noticeKey, "");
        String currentDateToString = DateUtil.currentDateToString(y.֬ڱܱײٮ(-1159526095));
        if (Intrinsics.areEqual(string, currentDateToString)) {
            if (callback != null) {
                callback.onResult(KGResult.INSTANCE.getSuccessResult(""));
                return;
            }
            return;
        }
        PreferenceUtil.setString(activity2, str3, noticeKey, currentDateToString);
        try {
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.notice)) {
                KGResult<String> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                    return;
                }
                return;
            }
            FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showNoticeViewForOneDay_noticeKey");
            if (TextUtils.isEmpty(noticeKey)) {
                INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getNoticeUrl(), callback, firebaseEvent);
            } else {
                INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getNoticeUrl() + "/detail/" + noticeKey, callback, firebaseEvent);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result2 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showNoticeOnlyView(Activity activity, KGResultCallback<String> callback) {
        String str = y.ݬֲ֮ܲت(1512722991);
        try {
            INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getNoticeOnlyUrl(), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str, "showNoticeOnlyView"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showEventWall(Activity activity, KGResultCallback<String> callback) {
        String str = y.ݬֲ֮ܲت(1512722991);
        try {
            INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getEventWallUrl(), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str, "showEventWall"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showEventProgressWall(Activity activity, KGResultCallback<String> callback) {
        String str = y.ݬֲ֮ܲت(1512722991);
        try {
            INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getEventProgressWallUrl(), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str, "showEventProgressWall"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "경품 이벤트 당첨 안내 뷰를 띄운다.")
    @JvmStatic
    public static final void showEventWinningResultView(Activity activity, String eventKey, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(575707574) + eventKey;
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        try {
            if (FeatureManager.INSTANCE.isNotSupportedFeature(FeatureManager.Feature.notice)) {
                KGResult<String> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                    return;
                }
                return;
            }
            if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
                Logger.INSTANCE.m701e(str2, "showNoticeView: not loggedIn");
                KGResult<String> result2 = KGResult.INSTANCE.getResult(3002, "not loggedIn");
                if (callback != null) {
                    callback.onResult(result2);
                    return;
                }
                return;
            }
            FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showEventWinningResultView");
            if (TextUtils.isEmpty(eventKey)) {
                INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getEventWinnerUrl(), callback, firebaseEvent);
            } else {
                INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getEventWinnerUrl() + '/' + eventKey, callback, firebaseEvent);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result3 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result3);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showInAppWebView(Activity activity, String url, KGResultCallback<String> callback) {
        INSTANCE.showInAppWebView(activity, url, callback, FirebaseEvent.INSTANCE.getFirebaseEvent(y.ݬֲ֮ܲت(1512722991), y.֬ڱܱײٮ(-1159518415)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showGachaOddsView(Activity activity, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628659500);
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        try {
            if (TextUtils.isEmpty(InfodeskHelper.INSTANCE.getGachaOddsUrl())) {
                KGResult<String> result = KGResult.INSTANCE.getResult(5001);
                if (callback != null) {
                    callback.onResult(result);
                    return;
                }
                return;
            }
            INSTANCE.showInAppWebView(activity, InfodeskHelper.INSTANCE.getGachaOddsUrl(), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showGachaOddsView"));
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result2 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showInAppWebView(Activity activity, String url, KGResultCallback<String> callback, FirebaseEvent fbEvent) {
        Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512722991), y.ۮڭڭܬި(862402075) + url);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSupport$showInAppWebView$1(activity, url, callback, fbEvent, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCommunityView(Activity activity, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051687197);
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        INSTANCE.showCommunityView(activity, null, null, callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, y.ۮڭڭܬި(862395451)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCommunityView(Activity activity, String pageCode, KGResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(pageCode, y.ٴسسݬߨ(1392736962));
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862399267) + pageCode;
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        INSTANCE.showCommunityView(activity, pageCode, null, callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, y.ٴسسݬߨ(1392736946)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCommunityView(Activity activity, long articleId, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392721922) + articleId;
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        INSTANCE.showCommunityView(activity, null, Long.valueOf(articleId), callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, y.ݬֲ֮ܲت(1512726463)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093 A[Catch: Exception -> 0x0155, TryCatch #0 {Exception -> 0x0155, blocks: (B:4:0x001b, B:7:0x00a1, B:8:0x00a4, B:11:0x00a8, B:13:0x00fe, B:16:0x0107, B:18:0x0111, B:19:0x0119, B:22:0x0025, B:24:0x0031, B:25:0x003c, B:27:0x0047, B:29:0x004d, B:31:0x0055, B:33:0x0064, B:35:0x006a, B:36:0x006e, B:37:0x007d, B:39:0x0087, B:44:0x0093), top: B:2:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009c  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void showCommunityView(android.app.Activity r10, java.lang.String r11, java.lang.Long r12, final com.kakaogame.KGResultCallback<java.lang.String> r13, final com.kakaogame.log.FirebaseEvent r14) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGSupport.showCommunityView(android.app.Activity, java.lang.String, java.lang.Long, com.kakaogame.KGResultCallback, com.kakaogame.log.FirebaseEvent):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showDaumCafeView(Activity activity, KGResultCallback<String> callback) {
        boolean z;
        KGResult<String> result;
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1392729194);
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        try {
            FirebaseEvent firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showDaumCafeView");
            String daumCafeUrl = InfodeskHelper.INSTANCE.getDaumCafeUrl();
            if (activity == null) {
                result = KGResult.INSTANCE.getResult(4000, "activity is null");
            } else {
                String str3 = daumCafeUrl;
                if (str3 != null && str3.length() != 0) {
                    z = false;
                    if (!z && (StringsKt.contains$default((CharSequence) daumCafeUrl, (CharSequence) "http://", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) daumCafeUrl, (CharSequence) "https://", false, 2, (Object) null))) {
                        result = null;
                    }
                    result = KGResult.INSTANCE.getResult(4002);
                }
                z = true;
                if (!z) {
                    result = null;
                }
                result = KGResult.INSTANCE.getResult(4002);
            }
            if (result == null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSupport$showDaumCafeView$2(activity, daumCafeUrl, callback, firebaseEvent, null), 3, null);
                return;
            }
            if (callback != null) {
                callback.onResult(result);
            }
            firebaseEvent.setResult(result);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result2 = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result2);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showDaumCafeView(Activity activity, String url, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862402019) + url;
        String str2 = y.ݬֲ֮ܲت(1512722991);
        logger.m704i(str2, str);
        try {
            if (url == null) {
                if (callback == null) {
                } else {
                    callback.onResult(KGResult.INSTANCE.getResult(4000, "url is null"));
                }
            } else if (activity != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGSupport$showDaumCafeView$3(activity, url, callback, FirebaseEvent.INSTANCE.getFirebaseEvent(str2, "showDaumCafeView_url"), null), 3, null);
            } else if (callback == null) {
            } else {
                callback.onResult(KGResult.INSTANCE.getResult(4000, "activity is null"));
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showDaumCafeWebView(Activity activity, String str, Continuation<? super KGResult<String>> continuation) {
        KGIdpProfile idpProfile;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger.INSTANCE.m704i(y.ݬֲ֮ܲت(1512722991), y.ۮڭڭܬި(862402019) + str);
        if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
            KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Kakao;
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            if (kGIdpCode == ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
                AuthDataManager.updateAccessToken(activity);
            }
        }
        INSTANCE.showCafeCustomView(activity, str, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$showDaumCafeWebView$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGResultCallback
            public void onResult(KGResult<String> result) {
                Continuation<KGResult<String>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(result));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a2, code lost:
    
        showCafeWebView(r13, r14, r0, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a5, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[Catch: Exception -> 0x00f5, TryCatch #0 {Exception -> 0x00f5, blocks: (B:3:0x0007, B:5:0x004d, B:7:0x0058, B:9:0x005e, B:11:0x0066, B:13:0x0072, B:18:0x007e, B:21:0x0082, B:23:0x0098, B:28:0x00a2, B:30:0x00a6, B:32:0x00b0, B:34:0x00b4, B:36:0x00c9, B:37:0x00d5, B:39:0x00e3, B:40:0x00ed, B:44:0x00f1), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[Catch: Exception -> 0x00f5, TryCatch #0 {Exception -> 0x00f5, blocks: (B:3:0x0007, B:5:0x004d, B:7:0x0058, B:9:0x005e, B:11:0x0066, B:13:0x0072, B:18:0x007e, B:21:0x0082, B:23:0x0098, B:28:0x00a2, B:30:0x00a6, B:32:0x00b0, B:34:0x00b4, B:36:0x00c9, B:37:0x00d5, B:39:0x00e3, B:40:0x00ed, B:44:0x00f1), top: B:2:0x0007 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void showCafeCustomView(android.app.Activity r13, java.lang.String r14, com.kakaogame.KGResultCallback<java.lang.String> r15) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGSupport.showCafeCustomView(android.app.Activity, java.lang.String, com.kakaogame.KGResultCallback):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showCafeWebView(Activity activity, String url, WebDialog.Settings settings, KGResultCallback<String> callback) {
        String str = y.ݬֲ֮ܲت(1512722991);
        String str2 = y.ٴسسݬߨ(1392723698);
        try {
            Logger.INSTANCE.m699d(str, y.ٴسسݬߨ(1392723938) + url);
            if (url.length() == 0) {
                Logger.INSTANCE.m701e(str, str2 + url);
                callback.onResult(KGResult.INSTANCE.getResult(4000, "url is empty"));
            } else if (InfodeskHelper.INSTANCE.useDaumCafeOldUI()) {
                WebDialogManager.show$default(activity, url, null, false, callback, 12, null);
            } else {
                WebDialogManager.showCafe(activity, url, settings, callback);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
            callback.onResult(KGResult.INSTANCE.getResult(4001, e.toString()));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void openExternalBrowser$default(KGSupport kGSupport, Activity activity, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        kGSupport.openExternalBrowser(activity, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[Catch: Exception -> 0x00ad, TryCatch #0 {Exception -> 0x00ad, blocks: (B:4:0x003e, B:7:0x0046, B:9:0x004b, B:14:0x0057, B:17:0x006c, B:19:0x00a7), top: B:2:0x003c }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void openExternalBrowser(final android.app.Activity r24, final java.lang.String r25, boolean r26) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = 1781947248(0x6a365b70, float:5.5114075E25)
            java.lang.String r3 = com.liapp.y.ٲٴݴ״ٰ(r3)
            com.kakaogame.Logger r4 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 1512730143(0x5a2a6e1f, float:1.1992956E16)
            java.lang.String r6 = com.liapp.y.ݬֲ֮ܲت(r6)
            r5.<init>(r6)
            java.lang.StringBuilder r5 = r5.append(r1)
            r6 = -628756788(0xffffffffda85eecc, float:-1.8849366E16)
            java.lang.String r6 = com.liapp.y.ݮڮֲڭܩ(r6)
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            r6 = 1512722991(0x5a2a522f, float:1.1985277E16)
            java.lang.String r6 = com.liapp.y.ݬֲ֮ܲت(r6)
            r4.m704i(r6, r5)
            if (r0 != 0) goto L46
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = "openExternalBrowser: activity is null"
            r0.m701e(r6, r1)     // Catch: java.lang.Exception -> Lad
            return
        L46:
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch: java.lang.Exception -> Lad
            if (r4 == 0) goto L54
            int r4 = r4.length()     // Catch: java.lang.Exception -> Lad
            if (r4 != 0) goto L52
            goto L54
        L52:
            r4 = 0
            goto L55
        L54:
            r4 = 1
        L55:
            if (r4 == 0) goto L6a
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Exception -> Lad
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lad
            r2.<init>(r3)     // Catch: java.lang.Exception -> Lad
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch: java.lang.Exception -> Lad
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> Lad
            r0.m701e(r6, r1)     // Catch: java.lang.Exception -> Lad
            return
        L6a:
            if (r2 == 0) goto La7
            com.kakaogame.ui.DialogManager$Settings r2 = new com.kakaogame.ui.DialogManager$Settings     // Catch: java.lang.Exception -> Lad
            r8 = 0
            r9 = 0
            r10 = 0
            int r3 = com.kakaogame.C2382R.string.kakao_game_sdk_open_external_browser     // Catch: java.lang.Exception -> Lad
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Exception -> Lad
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 8183(0x1ff7, float:1.1467E-41)
            r22 = 0
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)     // Catch: java.lang.Exception -> Lad
            int r3 = com.kakaogame.C2382R.string.kakao_game_sdk_open_external_browser_ok     // Catch: java.lang.Exception -> Lad
            com.kakaogame.KGSupport$$ExternalSyntheticLambda0 r4 = new com.kakaogame.KGSupport$$ExternalSyntheticLambda0     // Catch: java.lang.Exception -> Lad
            r4.<init>()     // Catch: java.lang.Exception -> Lad
            r2.setPositiveButton(r3, r4)     // Catch: java.lang.Exception -> Lad
            int r1 = com.kakaogame.C2382R.string.kakao_game_sdk_open_external_browser_cancel     // Catch: java.lang.Exception -> Lad
            com.kakaogame.KGSupport$$ExternalSyntheticLambda1 r3 = new com.kakaogame.KGSupport$$ExternalSyntheticLambda1     // Catch: java.lang.Exception -> Lad
            r3.<init>()     // Catch: java.lang.Exception -> Lad
            r2.setNegativeButton(r1, r3)     // Catch: java.lang.Exception -> Lad
            com.kakaogame.ui.DialogManager r1 = com.kakaogame.p029ui.DialogManager.INSTANCE     // Catch: java.lang.Exception -> Lad
            r1.showAlertDialog(r0, r2)     // Catch: java.lang.Exception -> Lad
            goto Lb9
        La7:
            android.content.Context r0 = (android.content.Context) r0     // Catch: java.lang.Exception -> Lad
            com.kakaogame.util.AppUtil.launchViewer(r0, r1)     // Catch: java.lang.Exception -> Lad
            goto Lb9
        Lad:
            r0 = move-exception
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE
            java.lang.String r2 = r0.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.m702e(r6, r2, r0)
        Lb9:
            return
            fill-array 0x00ba: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGSupport.openExternalBrowser(android.app.Activity, java.lang.String, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void openExternalBrowser$lambda$3(Activity activity, String str, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        AppUtil.launchViewer(activity, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݮڮֲڭܩ(-628669628), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.showCSView(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$1$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575714246), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.ٲٴݴ״ٰ(1781949976));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                if (TextUtils.isEmpty(str)) {
                    KGSupport.showNoticeView(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$2$request$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                } else {
                    KGSupport.showNoticeView(activity, str, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$2$request$2
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                }
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512725359), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.showNoticeOnlyView(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$3$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051698789), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.showEventWall(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$4$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.دײܮڳܯ(2051699069), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.showEventProgressWall(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$5$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٴسسݬߨ(1392725018), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.ٲٴݴ״ٰ(1781949976));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                if (TextUtils.isEmpty(str)) {
                    KGSupport.showNoticeViewForOneDay(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$6$request$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                } else {
                    KGSupport.showNoticeViewForOneDay(activity, str, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$6$request$2
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                }
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.֬ڱܱײٮ(-1159524175), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$7
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.showEventWinningResultView(activity, (String) request.getParameter(y.٬ݯح׭٩(575716694)), new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$7$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512727927), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = (String) request.getParameter(y.ݬֲ֮ܲت(1512934047));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.INSTANCE.showInAppWebView(activity, str, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$8$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                }, FirebaseEvent.INSTANCE.getFirebaseEvent(y.ݬֲ֮ܲت(1512722991), y.֬ڱܱײٮ(-1159518415)));
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512727655), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                FirebaseEvent firebaseEvent;
                String str;
                Long l;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str2 = y.ٴسسݬߨ(1392736962);
                boolean containsParameterKey = request.containsParameterKey(str2);
                String str3 = y.ݬֲ֮ܲت(1512722991);
                if (containsParameterKey) {
                    String str4 = (String) request.getParameter(str2);
                    firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(str3, y.ٴسسݬߨ(1392736946));
                    str = str4;
                } else {
                    firebaseEvent = null;
                    str = null;
                }
                String str5 = y.ٲٴݴ״ٰ(1781949656);
                if (request.containsParameterKey(str5)) {
                    Number number = (Number) request.getParameter(str5);
                    Intrinsics.checkNotNull(number);
                    Long valueOf = Long.valueOf(number.longValue());
                    firebaseEvent = FirebaseEvent.INSTANCE.getFirebaseEvent(str3, y.ݬֲ֮ܲت(1512726463));
                    l = valueOf;
                } else {
                    l = null;
                }
                FirebaseEvent firebaseEvent2 = firebaseEvent == null ? FirebaseEvent.INSTANCE.getFirebaseEvent(str3, y.ۮڭڭܬި(862395451)) : firebaseEvent;
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.INSTANCE.showCommunityView(activity, str, l, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$9$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                }, firebaseEvent2);
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ݬֲ֮ܲت(1512727183), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$10
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                String str = y.ݬֲ֮ܲت(1512934047);
                String str2 = request.containsParameterKey(str) ? (String) request.getParameter(str) : null;
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                if (TextUtils.isEmpty(str2)) {
                    KGSupport.showDaumCafeView(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$10$request$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                } else {
                    KGSupport.showDaumCafeView(activity, str2, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$10$request$2
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            createLock.setContent(result);
                            createLock.unlock();
                        }
                    });
                }
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575704598), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$11
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                KGSupport.INSTANCE.openExternalBrowser(activity, (String) request.getParameter(y.ۮڭڭܬި(862392755)), !StringsKt.equals(y.֬ڱܱײٮ(-1159518775), (String) request.getParameter(y.ۮڭڭܬި(862392731)), true));
                return KGResult.INSTANCE.getSuccessResult();
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.ۮڭڭܬި(862397051), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$12
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                final MutexLock createLock = MutexLock.INSTANCE.createLock();
                KGSupport.showGachaOddsView(activity, new KGResultCallback<String>() { // from class: com.kakaogame.KGSupport$initInterfaceBroker$12$request$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.kakaogame.KGResultCallback
                    public void onResult(KGResult<String> result) {
                        createLock.setContent(result);
                        createLock.unlock();
                    }
                });
                MutexLock.lock$default(createLock, 0L, 1, null);
                KGResult kGResult = (KGResult) createLock.getContent();
                Intrinsics.checkNotNull(kGResult);
                if (kGResult.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(y.٬ݯح׭٩(575841974), kGResult.getContent());
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }
}
