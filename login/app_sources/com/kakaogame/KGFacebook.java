package com.kakaogame;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.model.GameRequestContent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.FirebasePerformance;
import com.kakaogame.KGFacebook;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.broker.InterfaceBrokerHandler;
import com.kakaogame.core.CoreManager;
import com.liapp.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGFacebook.kt */
@Metadata(m838d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001f B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002JD\u0010\b\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0007Jb\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00150\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0002Jl\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u0018\u00010\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006!"}, m839d2 = {"Lcom/kakaogame/KGFacebook;", "", "()V", "TAG", "", "isFacebookLogin", "", "()Z", "executeGraphRequest", "Lcom/kakaogame/KGResult;", "graphPath", "parameters", "", "httpMethod", "Lcom/kakaogame/KGFacebook$KGFacebookHTTPMethod;", "", "callback", "Lcom/kakaogame/KGResultCallback;", "initInterfaceBroker", "initialize", "showGameRequestDialog", "", "activity", "Landroid/app/Activity;", "recipients", "message", "objectId", SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, "Lcom/kakaogame/KGFacebook$KGFacebookActionType;", "data", "title", "KGFacebookActionType", "KGFacebookHTTPMethod", "idp_facebook_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGFacebook {
    public static final KGFacebook INSTANCE = new KGFacebook();
    private static final String TAG = "KGFacebook";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KGFacebook() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void initialize() {
        INSTANCE.initInterfaceBroker();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void executeGraphRequest(String graphPath, Map<String, String> parameters, KGFacebookHTTPMethod httpMethod, KGResultCallback<Object> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGFacebook$executeGraphRequest$1(graphPath, parameters, httpMethod, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showGameRequestDialog(Activity activity, List<String> recipients, String message, String objectId, KGFacebookActionType actionType, String data, String title, KGResultCallback<List<String>> callback) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new KGFacebook$showGameRequestDialog$1(activity, recipients, message, objectId, actionType, data, title, callback, null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isFacebookLogin() {
        if (!CoreManager.INSTANCE.getInstance().isAuthorized()) {
            return false;
        }
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        Intrinsics.checkNotNull(currentPlayer);
        KGIdpProfile idpProfile = currentPlayer.getIdpProfile();
        Intrinsics.checkNotNull(idpProfile);
        return idpProfile.getIdpCode() == KGIdpProfile.KGIdpCode.Facebook;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Object> executeGraphRequest(String graphPath, Map<String, String> parameters, KGFacebookHTTPMethod httpMethod) {
        Bundle bundle;
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575860454)).append(graphPath);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(parameters).append(str).append(httpMethod).toString();
        String str2 = y.ۮڭڭܬި(862274235);
        logger.m704i(str2, sb);
        if (!isFacebookLogin()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        try {
            if (TextUtils.isEmpty(graphPath)) {
                return KGResult.INSTANCE.getResult(4000, "graphPath is null");
            }
            if (httpMethod == null) {
                return KGResult.INSTANCE.getResult(4000, "httpMethod is null");
            }
            Object obj = null;
            if (parameters == null || !(!parameters.isEmpty())) {
                bundle = null;
            } else {
                Bundle bundle2 = new Bundle();
                for (Map.Entry<String, String> entry : parameters.entrySet()) {
                    bundle2.putString(entry.getKey(), entry.getValue());
                }
                bundle = bundle2;
            }
            GraphResponse executeAndWait = new GraphRequest(AccessToken.INSTANCE.getCurrentAccessToken(), graphPath, bundle, httpMethod.getMethod(), null, null, 48, null).executeAndWait();
            FacebookRequestError error = executeAndWait.getError();
            Logger.INSTANCE.m704i(str2, "FacebookRequestError: " + error);
            if (error != null) {
                return KGResult.INSTANCE.getResult(error.getErrorCode(), error.getErrorMessage());
            }
            Logger.INSTANCE.m704i(str2, "GraphResponse: " + executeAndWait);
            if (executeAndWait.getJsonObject() != null) {
                obj = executeAndWait.getJsonObject();
            } else if (executeAndWait.getJsonArray() != null) {
                obj = executeAndWait.getJsonArray();
            }
            return KGResult.INSTANCE.getSuccessResult(obj);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0099 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c8 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cd A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ed A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f6 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0153 A[Catch: Exception -> 0x015c, TRY_LEAVE, TryCatch #0 {Exception -> 0x015c, blocks: (B:9:0x0074, B:11:0x007d, B:13:0x0084, B:18:0x0090, B:20:0x0099, B:22:0x009f, B:24:0x00aa, B:26:0x00b4, B:27:0x00b7, B:29:0x00bc, B:34:0x00c8, B:36:0x00cd, B:37:0x00d4, B:39:0x00d9, B:44:0x00e5, B:45:0x00e8, B:47:0x00ed, B:50:0x00f6, B:51:0x00f9, B:53:0x0153), top: B:7:0x0072 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.util.List<java.lang.String>> showGameRequestDialog(android.app.Activity r13, java.util.List<java.lang.String> r14, java.lang.String r15, java.lang.String r16, com.kakaogame.KGFacebook.KGFacebookActionType r17, java.lang.String r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.KGFacebook.showGameRequestDialog(android.app.Activity, java.util.List, java.lang.String, java.lang.String, com.kakaogame.KGFacebook$KGFacebookActionType, java.lang.String, java.lang.String):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initInterfaceBroker() {
        InterfaceBrokerHandler.registerInterfaceBroker(y.ٲٴݴ״ٰ(1781806328), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGFacebook$initInterfaceBroker$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGFacebook.KGFacebookHTTPMethod kGFacebookHTTPMethod;
                KGResult executeGraphRequest;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, "request");
                String str = (String) request.getParameter("graphPath");
                Map map = (Map) request.getParameter(y.ٴسسݬߨ(1392586602));
                String str2 = (String) request.getParameter(y.ٲٴݴ״ٰ(1781805184));
                KGFacebook.KGFacebookHTTPMethod[] values = KGFacebook.KGFacebookHTTPMethod.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        kGFacebookHTTPMethod = null;
                        break;
                    }
                    kGFacebookHTTPMethod = values[i];
                    if (StringsKt.equals(kGFacebookHTTPMethod.name(), str2, true)) {
                        break;
                    }
                    i++;
                }
                if (kGFacebookHTTPMethod != null) {
                    executeGraphRequest = KGFacebook.INSTANCE.executeGraphRequest(str, map, kGFacebookHTTPMethod);
                    if (executeGraphRequest.isNotSuccess()) {
                        return KGResult.INSTANCE.getResult(executeGraphRequest);
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put(y.ݬֲ֮ܲت(1512571887), executeGraphRequest.getContent());
                    return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                }
                return KGResult.INSTANCE.getResult(4000, y.٬ݯح׭٩(575859686) + str2);
            }
        });
        InterfaceBrokerHandler.registerInterfaceBroker(y.٬ݯح׭٩(575856942), new InterfaceBrokerHandler.InterfaceBroker() { // from class: com.kakaogame.KGFacebook$initInterfaceBroker$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.broker.InterfaceBrokerHandler.InterfaceBroker
            public KGResult<?> request(Activity activity, InterfaceBrokerHandler.InterfaceRequest request) {
                KGFacebook.KGFacebookActionType kGFacebookActionType;
                KGResult showGameRequestDialog;
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                Intrinsics.checkNotNullParameter(request, y.٬ݯح׭٩(575820214));
                List list = (List) request.getParameter(y.٬ݯح׭٩(575859942));
                String str = (String) request.getParameter(y.دײܮڳܯ(2051551053));
                String str2 = (String) request.getParameter(y.٬ݯح׭٩(575859974));
                String str3 = (String) request.getParameter(y.֬ڱܱײٮ(-1159629639));
                KGFacebook.KGFacebookActionType[] values = KGFacebook.KGFacebookActionType.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        kGFacebookActionType = null;
                        break;
                    }
                    KGFacebook.KGFacebookActionType kGFacebookActionType2 = values[i];
                    if (StringsKt.equals(kGFacebookActionType2.name(), str3, true)) {
                        kGFacebookActionType = kGFacebookActionType2;
                        break;
                    }
                    i++;
                }
                showGameRequestDialog = KGFacebook.INSTANCE.showGameRequestDialog(activity, list, str, str2, kGFacebookActionType, (String) request.getParameter(y.دײܮڳܯ(2051550101)), (String) request.getParameter(y.ٲٴݴ״ٰ(1781623336)));
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Object content = showGameRequestDialog.getContent();
                Intrinsics.checkNotNull(content);
                linkedHashMap.put(y.ۮڭڭܬި(862274339), content);
                if (showGameRequestDialog.isNotSuccess()) {
                    return KGResult.INSTANCE.getResult(showGameRequestDialog);
                }
                return KGResult.INSTANCE.getSuccessResult(linkedHashMap);
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGFacebook.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m839d2 = {"Lcom/kakaogame/KGFacebook$KGFacebookHTTPMethod;", "", FirebaseAnalytics.Param.METHOD, "Lcom/facebook/HttpMethod;", "(Ljava/lang/String;ILcom/facebook/HttpMethod;)V", "getMethod", "()Lcom/facebook/HttpMethod;", "GET", "POST", FirebasePerformance.HttpMethod.DELETE, "idp_facebook_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGFacebookHTTPMethod {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGFacebookHTTPMethod[] $VALUES;
        private final HttpMethod method;
        public static final KGFacebookHTTPMethod GET = new KGFacebookHTTPMethod(y.ۮڭڭܬި(862275579), 0, HttpMethod.GET);
        public static final KGFacebookHTTPMethod POST = new KGFacebookHTTPMethod(y.ٴسسݬߨ(1392856570), 1, HttpMethod.POST);
        public static final KGFacebookHTTPMethod DELETE = new KGFacebookHTTPMethod(y.ٴسسݬߨ(1392586410), 2, HttpMethod.DELETE);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGFacebookHTTPMethod[] $values() {
            return new KGFacebookHTTPMethod[]{GET, POST, DELETE};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGFacebookHTTPMethod> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGFacebookHTTPMethod valueOf(String str) {
            return (KGFacebookHTTPMethod) Enum.valueOf(KGFacebookHTTPMethod.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGFacebookHTTPMethod[] values() {
            return (KGFacebookHTTPMethod[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGFacebookHTTPMethod(String str, int i, HttpMethod httpMethod) {
            this.method = httpMethod;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final HttpMethod getMethod() {
            return this.method;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGFacebookHTTPMethod[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: KGFacebook.kt */
    @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m839d2 = {"Lcom/kakaogame/KGFacebook$KGFacebookActionType;", "", SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, "Lcom/facebook/share/model/GameRequestContent$ActionType;", "(Ljava/lang/String;ILcom/facebook/share/model/GameRequestContent$ActionType;)V", "getActionType", "()Lcom/facebook/share/model/GameRequestContent$ActionType;", "NONE", "SEND", "ASKFOR", "TURN", "idp_facebook_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class KGFacebookActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KGFacebookActionType[] $VALUES;
        private final GameRequestContent.ActionType actionType;
        public static final KGFacebookActionType NONE = new KGFacebookActionType(y.ۮڭڭܬި(862123667), 0, null);
        public static final KGFacebookActionType SEND = new KGFacebookActionType(y.ٲٴݴ״ٰ(1781805368), 1, GameRequestContent.ActionType.SEND);
        public static final KGFacebookActionType ASKFOR = new KGFacebookActionType(y.ݬֲ֮ܲت(1512572359), 2, GameRequestContent.ActionType.ASKFOR);
        public static final KGFacebookActionType TURN = new KGFacebookActionType(y.دײܮڳܯ(2051550445), 3, GameRequestContent.ActionType.TURN);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static final /* synthetic */ KGFacebookActionType[] $values() {
            return new KGFacebookActionType[]{NONE, SEND, ASKFOR, TURN};
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static EnumEntries<KGFacebookActionType> getEntries() {
            return $ENTRIES;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGFacebookActionType valueOf(String str) {
            return (KGFacebookActionType) Enum.valueOf(KGFacebookActionType.class, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static KGFacebookActionType[] values() {
            return (KGFacebookActionType[]) $VALUES.clone();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private KGFacebookActionType(String str, int i, GameRequestContent.ActionType actionType) {
            this.actionType = actionType;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final GameRequestContent.ActionType getActionType() {
            return this.actionType;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            KGFacebookActionType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
