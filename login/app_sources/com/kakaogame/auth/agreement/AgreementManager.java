package com.kakaogame.auth.agreement;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.perf.FirebasePerformance;
import com.kakaogame.C2382R;
import com.kakaogame.KGAgreement;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.agreement.AgreementManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.server.InhouseGWService;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.PreferenceUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.util.StringUtil;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.web.WebViewContainer;
import com.kakaogame.web.protocol.WebAppProtocolHandler;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: AgreementManager.kt */
@Metadata(m838d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u000201B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J0\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J,\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001c\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\"H\u0007J \u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0004H\u0007JD\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"2\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010-J\f\u0010.\u001a\u00020/*\u00020\u001bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m839d2 = {"Lcom/kakaogame/auth/agreement/AgreementManager;", "", "()V", "PREF_AGREEMENT_NAME", "", "TAG", "TERMS_CODE_CHANNELING_SERVICE", "TERMS_CODE_FOREIGN_SERVICE", "TERMS_CODE_PRIVACY", "TERMS_CODE_PUSH_CUSTOM", "TERMS_CODE_PUSH_NIGHT", "TERMS_CODE_PUSH_PLAYER", "TERMS_CODE_SERVICE", "appId", "checkAgreement", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "account", "Lcom/kakaogame/idp/IdpAccount;", "checkType", "Lcom/kakaogame/auth/agreement/AgreementManager$AgreementCheckType;", "traceJobId", "", "checkAgreementPopupView", "agreementContent", "Lcom/kakaogame/util/json/JSONObject;", "clearPreference", "", "context", "Landroid/content/Context;", "getAgreement", "getAgreementInfo", "", "initialize", "ctx", "applicationId", "saveAgreement", "agreementItems", "saveAgreementInfo", "setAgreements", "agreementsStr", "showAgreement", "agreementParams", "(Landroid/app/Activity;Lcom/kakaogame/auth/agreement/AgreementManager$AgreementCheckType;Ljava/util/Map;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUsingKakaoSyncAgreement", "", "AgreementCheckType", "AgreementDialog", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AgreementManager {
    public static final AgreementManager INSTANCE = new AgreementManager();
    private static final String PREF_AGREEMENT_NAME = "KakaoGameSDK_Agreements";
    private static final String TAG = "AgreementManager";
    public static final String TERMS_CODE_CHANNELING_SERVICE = "E004";
    public static final String TERMS_CODE_FOREIGN_SERVICE = "E003";
    public static final String TERMS_CODE_PRIVACY = "E002";
    public static final String TERMS_CODE_PUSH_CUSTOM = "N004";
    public static final String TERMS_CODE_PUSH_NIGHT = "N003";
    public static final String TERMS_CODE_PUSH_PLAYER = "N002";
    public static final String TERMS_CODE_SERVICE = "E001";
    private static String appId;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AgreementManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize(Context ctx, String applicationId) {
        appId = applicationId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> checkAgreement(Activity activity, IdpAccount account, AgreementCheckType checkType, int traceJobId) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(account, y.ۮڭڭܬި(862470355));
        Intrinsics.checkNotNullParameter(checkType, y.ݮڮֲڭܩ(-628562524));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782134072) + account + y.ݮڮֲڭܩ(-628756788) + checkType;
        String str2 = y.ݮڮֲڭܩ(-628563748);
        logger.m704i(str2, str);
        try {
            if (activity.isFinishing()) {
                return KGResult.INSTANCE.getResult(4000, "activity is null or not running.");
            }
            if (InfodeskHelper.INSTANCE.getOffTermsAgreementPopup()) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            KGResult<JSONObject> agreement = getAgreement(account, checkType, traceJobId);
            if (!agreement.isSuccess()) {
                return KGResult.INSTANCE.getResult(agreement);
            }
            JSONObject content = agreement.getContent();
            Intrinsics.checkNotNull(content);
            KGResult<Void> checkAgreementPopupView = checkAgreementPopupView(activity, checkType, content, traceJobId);
            if (!checkAgreementPopupView.isSuccess()) {
                return KGResult.INSTANCE.getResult(checkAgreementPopupView);
            }
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<JSONObject> getAgreement(IdpAccount account, AgreementCheckType checkType, int traceJobId) {
        KGResult<JSONObject> forLogin;
        String str = y.ٲٴݴ״ٰ(1782133848);
        String str2 = y.ݮڮֲڭܩ(-628563748);
        try {
            if (account == null) {
                return KGResult.INSTANCE.getResult(4000, "account is null");
            }
            if (checkType == null) {
                return KGResult.INSTANCE.getResult(4000, "checkType is null");
            }
            String idpCode = account.getIdpCode();
            String idpUserId = account.getIdpUserId();
            String idpAccessToken = account.getIdpAccessToken();
            if (checkType == AgreementCheckType.CONNECT) {
                forLogin = InhouseGWService.getForConnect(idpCode, idpUserId, traceJobId);
            } else {
                forLogin = InhouseGWService.getForLogin(idpCode, idpUserId, idpAccessToken, traceJobId);
            }
            Logger.INSTANCE.m704i(str2, str + forLogin);
            return forLogin;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean isUsingKakaoSyncAgreement(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, y.٬ݯح׭٩(575694806));
        String str = y.ٲٴݴ״ٰ(1782133968);
        if (!jSONObject.containsKey((Object) str)) {
            return false;
        }
        return StringsKt.equals(y.ٴسسݬߨ(1392530602), (String) jSONObject.get((Object) str), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> checkAgreementPopupView(Activity activity, AgreementCheckType checkType, JSONObject agreementContent, int traceJobId) {
        Object runBlocking$default;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(checkType, y.ݮڮֲڭܩ(-628562524));
        Intrinsics.checkNotNullParameter(agreementContent, y.ٴسسݬߨ(1393306338));
        try {
            if (!StringsKt.equals(AgreementService.VALUE_YES, (String) agreementContent.get("agreementPopup"), true)) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Object> entry : agreementContent.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (!StringsKt.equals(LocalPlayerService.FIELD_KEY_AGREEMENT, key, true)) {
                    if (value == null) {
                        value = "null";
                    }
                    linkedHashMap.put(key, value);
                } else if (value != null) {
                    linkedHashMap.putAll((Map) value);
                }
            }
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new AgreementManager$checkAgreementPopupView$2(activity, checkType, linkedHashMap, traceJobId, null), 1, null);
            return (KGResult) runBlocking$default;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628563748), e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b9, code lost:
    
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object showAgreement(android.app.Activity r17, com.kakaogame.auth.agreement.AgreementManager.AgreementCheckType r18, java.util.Map<java.lang.String, ? extends java.lang.Object> r19, int r20, kotlin.coroutines.Continuation<? super com.kakaogame.KGResult<java.lang.Void>> r21) {
        /*
            r16 = this;
            r8 = r17
            kotlin.coroutines.SafeContinuation r9 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r21)
            r9.<init>(r0)
            r10 = r9
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 1782136616(0x6a393f28, float:5.598738E25)
            java.lang.String r2 = com.liapp.y.ٲٴݴ״ٰ(r2)
            r1.<init>(r2)
            r4 = r19
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            r11 = -628563748(0xffffffffda88e0dc, float:-1.9263916E16)
            java.lang.String r11 = com.liapp.y.ݮڮֲڭܩ(r11)
            r0.m704i(r11, r1)
            boolean r0 = r17.isFinishing()
            if (r0 == 0) goto L4e
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            com.kakaogame.KGResult$Companion r0 = com.kakaogame.KGResult.INSTANCE
            r1 = 4000(0xfa0, float:5.605E-42)
            r2 = 576709878(0x225fe4f6, float:3.0343346E-18)
            java.lang.String r2 = com.liapp.y.٬ݯح׭٩(r2)
            com.kakaogame.KGResult r0 = r0.getResult(r1, r2)
            java.lang.Object r0 = kotlin.Result.m1440constructorimpl(r0)
            r10.resumeWith(r0)
        L4e:
            int r12 = r17.getRequestedOrientation()
            com.kakaogame.infodesk.InfodeskHelper r0 = com.kakaogame.infodesk.InfodeskHelper.INSTANCE
            java.lang.String r0 = r0.getAgreementUrl()
            if (r0 == 0) goto Lc0
            boolean r0 = com.kakaogame.util.DisplayUtil.isScreenPortrait(r17)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            if (r0 == 0) goto L62
            r0 = 7
            goto L63
        L62:
            r0 = 6
        L63:
            r8.setRequestedOrientation(r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            kotlinx.coroutines.CoroutineScope r0 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r13 = 0
            r14 = 0
            com.kakaogame.auth.agreement.AgreementManager$showAgreement$2$1$1 r15 = new com.kakaogame.auth.agreement.AgreementManager$showAgreement$2$1$1     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r7 = 0
            r1 = r15
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r4 = r15
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
            r5 = 3
            r6 = 0
            r1 = r0
            r2 = r13
            r3 = r14
            kotlinx.coroutines.Job r0 = kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L94
        L8e:
            r8.setRequestedOrientation(r12)
            goto Lb9
        L92:
            r0 = move-exception
            goto Lbc
        L94:
            r0 = move-exception
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE     // Catch: java.lang.Throwable -> L92
            java.lang.String r2 = r0.toString()     // Catch: java.lang.Throwable -> L92
            r3 = r0
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch: java.lang.Throwable -> L92
            r1.m702e(r11, r2, r3)     // Catch: java.lang.Throwable -> L92
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L92
            com.kakaogame.KGResult$Companion r1 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Throwable -> L92
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L92
            r2 = 4001(0xfa1, float:5.607E-42)
            com.kakaogame.KGResult r0 = r1.getResult(r2, r0)     // Catch: java.lang.Throwable -> L92
            java.lang.Object r0 = kotlin.Result.m1440constructorimpl(r0)     // Catch: java.lang.Throwable -> L92
            r10.resumeWith(r0)     // Catch: java.lang.Throwable -> L92
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L92
            goto L8e
        Lb9:
            if (r0 != 0) goto Lda
            goto Lc0
        Lbc:
            r8.setRequestedOrientation(r12)
            throw r0
        Lc0:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            com.kakaogame.KGResult$Companion r0 = com.kakaogame.KGResult.INSTANCE
            r1 = 3000(0xbb8, float:4.204E-42)
            r2 = 1512376911(0x5a250a4f, float:1.1613676E16)
            java.lang.String r2 = com.liapp.y.ݬֲ֮ܲت(r2)
            com.kakaogame.KGResult r0 = r0.getResult(r1, r2)
            java.lang.Object r0 = kotlin.Result.m1440constructorimpl(r0)
            r10.resumeWith(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        Lda:
            java.lang.Object r0 = r9.getOrThrow()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto Le7
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r21)
        Le7:
            return r0
            fill-array 0x00e8: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.auth.agreement.AgreementManager.showAgreement(android.app.Activity, com.kakaogame.auth.agreement.AgreementManager$AgreementCheckType, java.util.Map, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void clearPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Logger logger = Logger.INSTANCE;
        String str = y.֬ڱܱײٮ(-1159610191);
        String str2 = y.ݮڮֲڭܩ(-628563748);
        logger.m699d(str2, str);
        try {
            PreferenceUtil.remove(context, PREF_AGREEMENT_NAME);
            KGAgreement.clearPreference(context);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> saveAgreement(Map<String, String> agreementItems) {
        String str = y.ٴسسݬߨ(1393304778);
        Intrinsics.checkNotNullParameter(agreementItems, y.ۮڭڭܬި(862473387));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ݬֲ֮ܲت(1512377735) + agreementItems;
        String str3 = y.ݮڮֲڭܩ(-628563748);
        logger.m699d(str3, str2);
        try {
            KGResult<Void> agreement = AgreementService.setAgreement(agreementItems);
            Logger.INSTANCE.m699d(str3, str + agreement);
            if (agreement.isSuccess()) {
                CoreManager.refreshPlayer$default(CoreManager.INSTANCE.getInstance(), 0, 1, null);
                return KGResult.INSTANCE.getSuccessResult();
            }
            return KGResult.INSTANCE.getResult(agreement);
        } catch (Exception e) {
            Logger.INSTANCE.m700d(str3, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map<String, Object> getAgreementInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        try {
            String str = appId;
            Intrinsics.checkNotNull(str);
            String string = PreferenceUtil.getString(context, PREF_AGREEMENT_NAME, str);
            if (string == null) {
                return null;
            }
            Object parse = JSONValue.parse(string);
            Intrinsics.checkNotNull(parse, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            return (Map) parse;
        } catch (Exception e) {
            Logger.INSTANCE.m700d(y.ݮڮֲڭܩ(-628563748), e.toString(), e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032 A[Catch: Exception -> 0x0084, TryCatch #0 {Exception -> 0x0084, blocks: (B:3:0x001d, B:5:0x0026, B:10:0x0032, B:12:0x003a, B:14:0x0047, B:16:0x0051, B:17:0x007d, B:21:0x0060, B:23:0x006a), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[Catch: Exception -> 0x0084, TryCatch #0 {Exception -> 0x0084, blocks: (B:3:0x001d, B:5:0x0026, B:10:0x0032, B:12:0x003a, B:14:0x0047, B:16:0x0051, B:17:0x007d, B:21:0x0060, B:23:0x006a), top: B:2:0x001d }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.kakaogame.KGResult<java.lang.Void> saveAgreementInfo(android.content.Context r4, int r5) {
        /*
            r0 = 1512979991(0x5a2e3e17, float:1.2261229E16)
            java.lang.String r0 = com.liapp.y.ݬֲ֮ܲت(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            r1 = 1782135216(0x6a3939b0, float:5.5980925E25)
            java.lang.String r1 = com.liapp.y.ٲٴݴ״ٰ(r1)
            r2 = -628563748(0xffffffffda88e0dc, float:-1.9263916E16)
            java.lang.String r2 = com.liapp.y.ݮڮֲڭܩ(r2)
            r0.m699d(r2, r1)
            com.kakaogame.auth.agreement.AgreementManager r0 = com.kakaogame.auth.agreement.AgreementManager.INSTANCE     // Catch: java.lang.Exception -> L84
            java.util.Map r0 = r0.getAgreementInfo(r4)     // Catch: java.lang.Exception -> L84
            r1 = 1
            if (r0 == 0) goto L2f
            boolean r3 = r0.isEmpty()     // Catch: java.lang.Exception -> L84
            if (r3 == 0) goto L2d
            goto L2f
        L2d:
            r3 = 0
            goto L30
        L2f:
            r3 = r1
        L30:
            if (r3 == 0) goto L60
            com.kakaogame.KGAgreement r0 = com.kakaogame.KGAgreement.INSTANCE     // Catch: java.lang.Exception -> L84
            boolean r0 = r0.getSendFlag(r4)     // Catch: java.lang.Exception -> L84
            if (r0 != 0) goto L7d
            com.kakaogame.KGAgreement r0 = com.kakaogame.KGAgreement.INSTANCE     // Catch: java.lang.Exception -> L84
            java.util.Map r0 = r0.makeAgreement(r4)     // Catch: java.lang.Exception -> L84
            boolean r3 = r0.isEmpty()     // Catch: java.lang.Exception -> L84
            r3 = r3 ^ r1
            if (r3 == 0) goto L7d
            com.kakaogame.KGResult r0 = com.kakaogame.server.InhouseGWService.set(r0, r5)     // Catch: java.lang.Exception -> L84
            boolean r0 = r0.isSuccess()     // Catch: java.lang.Exception -> L84
            if (r0 == 0) goto L7d
            com.kakaogame.KGAgreement r0 = com.kakaogame.KGAgreement.INSTANCE     // Catch: java.lang.Exception -> L84
            r0.setSendFlag(r4, r1)     // Catch: java.lang.Exception -> L84
            com.kakaogame.core.CoreManager$Companion r4 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> L84
            com.kakaogame.core.CoreManager r4 = r4.getInstance()     // Catch: java.lang.Exception -> L84
            r4.refreshPlayer(r5)     // Catch: java.lang.Exception -> L84
            goto L7d
        L60:
            com.kakaogame.KGResult r0 = com.kakaogame.server.InhouseGWService.set(r0, r5)     // Catch: java.lang.Exception -> L84
            boolean r0 = r0.isSuccess()     // Catch: java.lang.Exception -> L84
            if (r0 == 0) goto L7d
            java.lang.String r0 = "KakaoGameSDK_Agreements"
            java.lang.String r1 = com.kakaogame.auth.agreement.AgreementManager.appId     // Catch: java.lang.Exception -> L84
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: java.lang.Exception -> L84
            com.kakaogame.util.PreferenceUtil.removeKey(r4, r0, r1)     // Catch: java.lang.Exception -> L84
            com.kakaogame.core.CoreManager$Companion r4 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> L84
            com.kakaogame.core.CoreManager r4 = r4.getInstance()     // Catch: java.lang.Exception -> L84
            r4.refreshPlayer(r5)     // Catch: java.lang.Exception -> L84
        L7d:
            com.kakaogame.KGResult$Companion r4 = com.kakaogame.KGResult.INSTANCE     // Catch: java.lang.Exception -> L84
            com.kakaogame.KGResult r4 = r4.getSuccessResult()     // Catch: java.lang.Exception -> L84
            goto L9d
        L84:
            r4 = move-exception
            com.kakaogame.Logger r5 = com.kakaogame.Logger.INSTANCE
            java.lang.String r0 = r4.toString()
            r1 = r4
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            r5.m700d(r2, r0, r1)
            com.kakaogame.KGResult$Companion r5 = com.kakaogame.KGResult.INSTANCE
            r0 = 4001(0xfa1, float:5.607E-42)
            java.lang.String r4 = r4.toString()
            com.kakaogame.KGResult r4 = r5.getResult(r0, r4)
        L9d:
            return r4
            fill-array 0x009e: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.auth.agreement.AgreementManager.saveAgreementInfo(android.content.Context, int):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setAgreements(Context context, String agreementsStr) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        Intrinsics.checkNotNullParameter(agreementsStr, y.ٲٴݴ״ٰ(1782134824));
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628616220) + agreementsStr;
        String str2 = y.ݮڮֲڭܩ(-628563748);
        logger.m699d(str2, str);
        try {
            if (agreementsStr.length() > 0) {
                String str3 = appId;
                Intrinsics.checkNotNull(str3);
                PreferenceUtil.setString(context, PREF_AGREEMENT_NAME, str3, agreementsStr);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgreementManager.kt */
    @Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/auth/agreement/AgreementManager$AgreementCheckType;", "", "(Ljava/lang/String;I)V", "LOGIN", FirebasePerformance.HttpMethod.CONNECT, "AUTO_LOGIN", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class AgreementCheckType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AgreementCheckType[] $VALUES;
        public static final AgreementCheckType LOGIN = new AgreementCheckType(y.ۮڭڭܬި(862499747), 0);
        public static final AgreementCheckType CONNECT = new AgreementCheckType(y.ݬֲ֮ܲت(1512436055), 1);
        public static final AgreementCheckType AUTO_LOGIN = new AgreementCheckType(y.٬ݯح׭٩(576659238), 2);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ AgreementCheckType[] $values() {
            return new AgreementCheckType[]{LOGIN, CONNECT, AUTO_LOGIN};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<AgreementCheckType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static AgreementCheckType valueOf(String str) {
            return (AgreementCheckType) Enum.valueOf(AgreementCheckType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static AgreementCheckType[] values() {
            return (AgreementCheckType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AgreementCheckType(String str, int i) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            AgreementCheckType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: AgreementManager.kt */
    @Metadata(m838d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002()BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u001a\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\u0010\u0010J\b\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0002J\b\u0010 \u001a\u00020\u000fH\u0016J\u0012\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u000fH\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u000bH\u0002J\b\u0010'\u001a\u00020\u000fH\u0002R\u000e\u0010\u0011\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000¨\u0006*"}, m839d2 = {"Lcom/kakaogame/auth/agreement/AgreementManager$AgreementDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "checkType", "Lcom/kakaogame/auth/agreement/AgreementManager$AgreementCheckType;", "agreementParams", "", "", "", "traceJobId", "", "callback", "Lkotlin/Function1;", "Lcom/kakaogame/KGResult;", "", "(Landroid/app/Activity;Lcom/kakaogame/auth/agreement/AgreementManager$AgreementCheckType;Ljava/util/Map;ILkotlin/jvm/functions/Function1;)V", "AD_AGREEMENT_KEY", "JOIN_MEMBERSHOP_KEY", "PLUS_FRIEND_ID_KEY", "backView", "Landroid/view/View;", "displayCutoutMode", "mainView", "titleView", "Landroid/widget/TextView;", "viewLoadingFinish", "", "webView", "Landroid/webkit/WebView;", "initTopbar", "initWebView", "onAttachedToWindow", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setDialogVisibility", "setMargin", "cutoutSize", "showEndingPopup", "AgreementHandler", "WebViewContainerImpl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class AgreementDialog extends Dialog {
        private final String AD_AGREEMENT_KEY;
        private final String JOIN_MEMBERSHOP_KEY;
        private final String PLUS_FRIEND_ID_KEY;
        private final Activity activity;
        private final Map<String, Object> agreementParams;
        private View backView;
        private final Function1<KGResult<String>, Unit> callback;
        private final AgreementCheckType checkType;
        private int displayCutoutMode;
        private View mainView;
        private TextView titleView;
        private final int traceJobId;
        private boolean viewLoadingFinish;
        private WebView webView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AgreementDialog(Activity activity, AgreementCheckType agreementCheckType, Map<String, ? extends Object> map, int i, Function1<? super KGResult<String>, Unit> function1) {
            super(activity, R.style.Theme.NoTitleBar.Fullscreen);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(agreementCheckType, y.ݮڮֲڭܩ(-628562524));
            Intrinsics.checkNotNullParameter(map, y.دײܮڳܯ(2051395645));
            Intrinsics.checkNotNullParameter(function1, y.֬ڱܱײٮ(-1159472767));
            this.activity = activity;
            this.checkType = agreementCheckType;
            this.agreementParams = map;
            this.traceJobId = i;
            this.callback = function1;
            this.PLUS_FRIEND_ID_KEY = "plusFriendId";
            this.JOIN_MEMBERSHOP_KEY = "joinMemberShip";
            this.AD_AGREEMENT_KEY = "setAdAgreement";
            if (Build.VERSION.SDK_INT >= 28) {
                this.displayCutoutMode = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void setDialogVisibility() {
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, y.ٲٴݴ״ٰ(1782133032));
            decorView.setSystemUiVisibility(this.activity.getWindow().getDecorView().getSystemUiVisibility() | 5380);
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            window2.addFlags(this.activity.getWindow().getAttributes().flags);
            if (Build.VERSION.SDK_INT >= 28) {
                Window window3 = getWindow();
                Intrinsics.checkNotNull(window3);
                window3.getAttributes().layoutInDisplayCutoutMode = this.displayCutoutMode;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Dialog
        protected void onCreate(Bundle savedInstanceState) {
            View decorView;
            super.onCreate(savedInstanceState);
            Tracer.INSTANCE.startAction(this.traceJobId, TraceLoginActionCode.SDK_SHOW_AGREEMENT);
            View layout = ResourceUtil.getLayout(this.activity, C2382R.layout.zinny_sdk_agreement_kakao);
            if (layout != null) {
                this.mainView = layout;
                int i = Build.VERSION.SDK_INT;
                String str = y.ݮڮֲڭܩ(-628562300);
                WebView webView = null;
                if (i >= 28) {
                    View view = this.mainView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                        view = null;
                    }
                    view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                }
                View view2 = this.mainView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    view2 = null;
                }
                setContentView(view2);
                View view3 = this.mainView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    view3 = null;
                }
                View findViewById = view3.findViewById(C2382R.id.zinny_sdk_agreement_kakao_webview);
                Intrinsics.checkNotNull(findViewById, y.٬ݯح׭٩(576711662));
                WebView webView2 = (WebView) findViewById;
                this.webView = webView2;
                String str2 = y.٬ݯح׭٩(576656206);
                if (webView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                    webView2 = null;
                }
                webView2.getSettings().setMixedContentMode(0);
                WebView webView3 = this.webView;
                if (webView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                    webView3 = null;
                }
                webView3.getSettings().setTextZoom(100);
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                WebView webView4 = this.webView;
                if (webView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                } else {
                    webView = webView4;
                }
                cookieManager.setAcceptThirdPartyCookies(webView, true);
                setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.auth.agreement.AgreementManager$AgreementDialog$$ExternalSyntheticLambda0
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.content.DialogInterface.OnKeyListener
                    public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                        boolean onCreate$lambda$1$lambda$0;
                        onCreate$lambda$1$lambda$0 = AgreementManager.AgreementDialog.onCreate$lambda$1$lambda$0(AgreementManager.AgreementDialog.this, dialogInterface, i2, keyEvent);
                        return onCreate$lambda$1$lambda$0;
                    }
                });
                initTopbar();
                initWebView();
                setDialogVisibility();
                Window window = getWindow();
                if (window == null || (decorView = window.getDecorView()) == null) {
                    return;
                }
                decorView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final boolean onCreate$lambda$1$lambda$0(AgreementDialog this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (keyEvent.getAction() != 1 || i != 4) {
                return false;
            }
            WebView webView = this$0.webView;
            WebView webView2 = null;
            String str = y.٬ݯح׭٩(576656206);
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                webView = null;
            }
            if (webView.canGoBack()) {
                WebView webView3 = this$0.webView;
                if (webView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                } else {
                    webView2 = webView3;
                }
                webView2.goBack();
            } else {
                this$0.showEndingPopup();
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            setMargin(DisplayUtil.checkCutout(this.activity));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void setMargin(int cutoutSize) {
            View findViewById = findViewById(C2382R.id.zinny_sdk_agreement_kakao);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(findViewById.getLayoutParams());
            if (DisplayUtil.isScreenPortrait(this.activity)) {
                marginLayoutParams.setMargins(0, cutoutSize, 0, 0);
            } else if (DisplayUtil.getLandscapeDirection(this.activity) == 0) {
                marginLayoutParams.setMargins(cutoutSize, 0, 0, 0);
            } else if (DisplayUtil.getLandscapeDirection(this.activity) == 1) {
                marginLayoutParams.setMargins(0, 0, cutoutSize, 0);
            }
            findViewById.setLayoutParams(new FrameLayout.LayoutParams(marginLayoutParams));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initTopbar() {
            View view = this.mainView;
            String str = y.ݮڮֲڭܩ(-628562300);
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                view = null;
            }
            View findViewById = view.findViewById(C2382R.id.zinny_sdk_agreement_kakao_topbar_title);
            String str2 = y.ۮڭڭܬި(862501395);
            Intrinsics.checkNotNullExpressionValue(findViewById, str2);
            this.titleView = (TextView) findViewById;
            View view3 = this.mainView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                view3 = null;
            }
            View findViewById2 = view3.findViewById(C2382R.id.zinny_sdk_agreement_kakao_topbar_back);
            Intrinsics.checkNotNullExpressionValue(findViewById2, str2);
            this.backView = findViewById2;
            if (findViewById2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.ٲٴݴ״ٰ(1782171856));
                findViewById2 = null;
            }
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.auth.agreement.AgreementManager$AgreementDialog$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    AgreementManager.AgreementDialog.initTopbar$lambda$2(AgreementManager.AgreementDialog.this, view4);
                }
            });
            if (InfodeskHelper.INSTANCE.offWebviewTopBarYellow()) {
                int webviewTitleBgColor = InfodeskHelper.INSTANCE.webviewTitleBgColor();
                int webviewTitleTextColor = InfodeskHelper.INSTANCE.webviewTitleTextColor();
                View view4 = this.mainView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                    view4 = null;
                }
                view4.findViewById(C2382R.id.zinny_sdk_dialog_web_topbar).setBackgroundColor(webviewTitleBgColor);
                TextView textView = this.titleView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(y.ۮڭڭܬި(862500891));
                    textView = null;
                }
                textView.setTextColor(webviewTitleTextColor);
                View view5 = this.mainView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                } else {
                    view2 = view5;
                }
                View findViewById3 = view2.findViewById(C2382R.id.zinny_sdk_agreement_image_back);
                Intrinsics.checkNotNull(findViewById3, y.ݬֲ֮ܲت(1512437799));
                ((ImageView) findViewById3).setImageDrawable(ResourceUtil.getDrawable(this.activity, C2382R.drawable.ic_action_previous_item_grey));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void initTopbar$lambda$2(AgreementDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            WebView webView = this$0.webView;
            String str = y.٬ݯح׭٩(576656206);
            WebView webView2 = null;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                webView = null;
            }
            if (webView.canGoBack()) {
                WebView webView3 = this$0.webView;
                if (webView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                } else {
                    webView2 = webView3;
                }
                webView2.goBack();
                return;
            }
            ?? r2 = this$0.backView;
            if (r2 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("backView");
            } else {
                webView2 = r2;
            }
            webView2.setVisibility(4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void initWebView() {
            Activity activity = this.activity;
            WebView webView = this.webView;
            WebView webView2 = null;
            String str = y.٬ݯح׭٩(576656206);
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                webView = null;
            }
            WebViewContainerImpl webViewContainerImpl = new WebViewContainerImpl(this, activity, webView);
            new AgreementHandler();
            String agreementUrl = InfodeskHelper.INSTANCE.getAgreementUrl();
            if (agreementUrl != null) {
                webViewContainerImpl.initCookies(getContext(), agreementUrl);
                String makeRequestUrl = StringUtil.makeRequestUrl(agreementUrl, this.agreementParams);
                Logger.INSTANCE.m704i(y.ݮڮֲڭܩ(-628563748), y.٬ݯح׭٩(576711046) + makeRequestUrl);
                WebView webView3 = this.webView;
                if (webView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(str);
                } else {
                    webView2 = webView3;
                }
                webView2.loadUrl(makeRequestUrl);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private final void showEndingPopup() {
            String string;
            if (this.checkType == AgreementCheckType.CONNECT) {
                string = ResourceUtil.getString(this.activity, C2382R.string.kakao_game_sdk_connect_agreement_cancel);
            } else {
                string = ResourceUtil.getString(this.activity, C2382R.string.zinny_sdk_app_finish);
            }
            DialogManager.Settings settings = new DialogManager.Settings(null, null, string, null, null, null, null, null, true, null, null, null, null, 7931, null);
            settings.setPositiveButton(C2382R.string.zinny_sdk_common_button_ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.agreement.AgreementManager$AgreementDialog$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AgreementManager.AgreementDialog.showEndingPopup$lambda$4(AgreementManager.AgreementDialog.this, dialogInterface, i);
                }
            });
            settings.setNegativeButton(C2382R.string.zinny_sdk_common_button_cancel, new DialogInterface.OnClickListener() { // from class: com.kakaogame.auth.agreement.AgreementManager$AgreementDialog$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            DialogManager.INSTANCE.showAlertDialog(this.activity, settings);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void showEndingPopup$lambda$4(AgreementDialog this$0, DialogInterface dialogInterface, int i) {
            KGResult<String> result;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            dialogInterface.dismiss();
            if (this$0.checkType == AgreementCheckType.CONNECT) {
                result = KGResult.INSTANCE.getResult(9001);
            } else {
                result = KGResult.INSTANCE.getResult(9900);
            }
            Tracer.INSTANCE.finishAction(this$0.traceJobId, TraceLoginActionCode.SDK_AGREEMENT_WEB_CLOSE, Tracer.INSTANCE.makeCustomErrorCode(this$0.traceJobId, 601), y.ۮڭڭܬި(862472163));
            this$0.callback.invoke(result);
            this$0.dismiss();
        }

        /* compiled from: AgreementManager.kt */
        @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0015¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/auth/agreement/AgreementManager$AgreementDialog$AgreementHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "(Lcom/kakaogame/auth/agreement/AgreementManager$AgreementDialog;)V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public final class AgreementHandler extends WebAppProtocolHandler {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public AgreementHandler() {
                super("AgreementOk");
                setWebAppProtocolHandler();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
            protected String handleInternal(WebView webView, Uri webUri) {
                Logger.INSTANCE.m704i(y.ݮڮֲڭܩ(-628563748), y.دײܮڳܯ(2051397893) + webUri);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                if (webUri != null) {
                    AgreementDialog agreementDialog = AgreementDialog.this;
                    List<String> queryParameters = webUri.getQueryParameters(agreementDialog.PLUS_FRIEND_ID_KEY);
                    Intrinsics.checkNotNullExpressionValue(queryParameters, y.ٲٴݴ״ٰ(1782172168));
                    linkedHashMap.put(y.٬ݯح׭٩(576655830), queryParameters);
                    String queryParameter = webUri.getQueryParameter(agreementDialog.JOIN_MEMBERSHOP_KEY);
                    String str = y.ٴسسݬߨ(1392530602);
                    linkedHashMap.put(y.ۮڭڭܬި(862502731), Boolean.valueOf(StringsKt.equals(str, queryParameter, true)));
                    linkedHashMap.put(y.ۮڭڭܬި(862502859), Boolean.valueOf(StringsKt.equals(str, webUri.getQueryParameter(agreementDialog.AD_AGREEMENT_KEY), true)));
                    for (String str2 : webUri.getQueryParameterNames()) {
                        if (!StringsKt.equals(str2, agreementDialog.PLUS_FRIEND_ID_KEY, true) && !StringsKt.equals(str2, agreementDialog.JOIN_MEMBERSHOP_KEY, true) && !StringsKt.equals(str2, agreementDialog.AD_AGREEMENT_KEY, true)) {
                            Intrinsics.checkNotNull(str2);
                            linkedHashMap2.put(str2, webUri.getQueryParameter(str2));
                        }
                    }
                    linkedHashMap.put(LocalPlayerService.FIELD_KEY_AGREEMENT, linkedHashMap2);
                }
                KGResult successResult = KGResult.INSTANCE.getSuccessResult(JSONValue.toJSONString(linkedHashMap));
                Tracer.INSTANCE.finishAction(AgreementDialog.this.traceJobId, TraceLoginActionCode.SDK_AGREEMENT_WEB_CLOSE, 200, y.ٴسسݬߨ(1392755458));
                AgreementDialog.this.callback.invoke(successResult);
                AgreementDialog.this.dismiss();
                return null;
            }
        }

        /* compiled from: AgreementManager.kt */
        @Metadata(m838d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J.\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0014J\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\u0015"}, m839d2 = {"Lcom/kakaogame/auth/agreement/AgreementManager$AgreementDialog$WebViewContainerImpl;", "Lcom/kakaogame/web/WebViewContainer;", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "(Lcom/kakaogame/auth/agreement/AgreementManager$AgreementDialog;Landroid/app/Activity;Landroid/webkit/WebView;)V", "onPageFinished", "", ViewHierarchyConstants.VIEW_KEY, "url", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedTitle", "title", "shouldOverrideUrlLoading", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        private final class WebViewContainerImpl extends WebViewContainer {
            final /* synthetic */ AgreementDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public WebViewContainerImpl(AgreementDialog agreementDialog, Activity activity, WebView webView) {
                super(activity, webView, null, 0, 12, null);
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
                this.this$0 = agreementDialog;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.web.WebViewContainer
            protected boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (!this.this$0.viewLoadingFinish) {
                    Tracer.INSTANCE.finishAction(this.this$0.traceJobId, TraceLoginActionCode.SDK_SHOW_AGREEMENT, 200, y.ٴسسݬߨ(1392755458));
                    Tracer.INSTANCE.startAction(this.this$0.traceJobId, TraceLoginActionCode.SDK_AGREEMENT_WEB_LOADING);
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.web.WebViewContainer
            protected void onReceivedTitle(WebView view, String title) {
                if (view != null) {
                    AgreementDialog agreementDialog = this.this$0;
                    TextView textView = agreementDialog.titleView;
                    TextView textView2 = null;
                    String str = y.ۮڭڭܬި(862500891);
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str);
                        textView = null;
                    }
                    CharSequence text = textView.getText();
                    Intrinsics.checkNotNullExpressionValue(text, y.ٴسسݬߨ(1393349082));
                    if (text.length() == 0) {
                        TextView textView3 = agreementDialog.titleView;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str);
                        } else {
                            textView2 = textView3;
                        }
                        textView2.setText(view.getTitle());
                    }
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.web.WebViewContainer
            protected void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Tracer.INSTANCE.finishAction(this.this$0.traceJobId, TraceLoginActionCode.SDK_AGREEMENT_WEB_LOADING, Tracer.INSTANCE.makeCustomErrorCode(this.this$0.traceJobId, TypedValues.PositionType.TYPE_TRANSITION_EASING), y.ٲٴݴ״ٰ(1782173440) + errorCode + y.دײܮڳܯ(2051396309) + description);
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.web.WebViewContainer
            protected void onPageFinished(WebView view, String url) {
                if (!this.this$0.viewLoadingFinish) {
                    this.this$0.viewLoadingFinish = true;
                    Tracer tracer = Tracer.INSTANCE;
                    int i = this.this$0.traceJobId;
                    TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_SHOW_AGREEMENT;
                    String str = y.ٴسسݬߨ(1392755458);
                    tracer.finishAction(i, traceLoginActionCode, 200, str);
                    Tracer.INSTANCE.finishAction(this.this$0.traceJobId, TraceLoginActionCode.SDK_AGREEMENT_WEB_LOADING, 200, str);
                    Tracer.INSTANCE.startAction(this.this$0.traceJobId, TraceLoginActionCode.SDK_AGREEMENT_WEB_CLOSE);
                }
                if (view != null) {
                    AgreementDialog agreementDialog = this.this$0;
                    View view2 = agreementDialog.backView;
                    TextView textView = null;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(y.ٲٴݴ״ٰ(1782171856));
                        view2 = null;
                    }
                    view2.setVisibility(view.canGoBack() ? 0 : 4);
                    TextView textView2 = agreementDialog.titleView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleView");
                    } else {
                        textView = textView2;
                    }
                    textView.setText(view.getTitle());
                }
            }
        }
    }
}
