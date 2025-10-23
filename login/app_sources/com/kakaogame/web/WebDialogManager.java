package com.kakaogame.web;

import android.app.Activity;
import android.content.DialogInterface;
import android.webkit.WebView;
import com.kakaogame.C2382R;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.p029ui.DeepLinkManager;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.web.WebDialog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
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

/* compiled from: WebDialogManager.kt */
@Metadata(m838d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\"\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0087@¢\u0006\u0002\u0010\u0011J>\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0017H\u0007J2\u0010\u0018\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0017H\u0007J2\u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0017H\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J:\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0017H\u0002J<\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0017H\u0007J<\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0010\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m839d2 = {"Lcom/kakaogame/web/WebDialogManager;", "", "()V", "TAG", "", "checkSystemWebViewError", "", "webView", "Landroid/webkit/WebView;", "activity", "Landroid/app/Activity;", "checkWebUrl", "Lcom/kakaogame/KGResult;", "webUrl", "show", "webDialog", "Lcom/kakaogame/web/WebDialog;", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "hideTopbar", "", "callback", "Lcom/kakaogame/KGResultCallback;", "showCafe", "showCafeImpl", "showImpl", "showPost", "postData", "", "showPostImpl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class WebDialogManager {
    public static final WebDialogManager INSTANCE = new WebDialogManager();
    private static final String TAG = "WebDialogManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private WebDialogManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Object show(Activity activity, String str, Continuation<? super KGResult<String>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        show$default(activity, str, null, false, new KGResultCallback<String>() { // from class: com.kakaogame.web.WebDialogManager$show$2$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGResultCallback
            public void onResult(KGResult<String> result) {
                Continuation<KGResult<String>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                Intrinsics.checkNotNull(result);
                continuation2.resumeWith(Result.m1440constructorimpl(result));
            }
        }, 12, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void show$default(Activity activity, String str, WebDialog.Settings settings, boolean z, KGResultCallback kGResultCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            settings = new WebDialog.Settings.Builder().setFixedFontSize(true).build();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        show(activity, str, settings, z, kGResultCallback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void show(Activity activity, String webUrl, WebDialog.Settings settings, boolean hideTopbar, KGResultCallback<String> callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webUrl, y.دײܮڳܯ(2051274949));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159029327), y.ۮڭڭܬި(862890899) + webUrl);
        DisplayUtil.checkSystemFontSize(activity);
        WebDialogManager webDialogManager = INSTANCE;
        KGResult<String> checkWebUrl = webDialogManager.checkWebUrl(activity, webUrl);
        if (checkWebUrl != null) {
            if (callback != null) {
                callback.onResult(checkWebUrl);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WebDialogManager$show$4$1(webDialogManager, activity, webUrl, settings, hideTopbar, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showImpl(Activity activity, String webUrl, WebDialog.Settings settings, boolean hideTopbar, final KGResultCallback<String> callback) {
        try {
            final WebDialog webDialog = new WebDialog(activity, webUrl, settings);
            if (hideTopbar) {
                webDialog.hideTopbar();
            }
            webDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.web.WebDialogManager$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WebDialogManager.showImpl$lambda$3(WebDialog.this, callback, dialogInterface);
                }
            });
            webDialog.show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159029327), e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showImpl$lambda$3(WebDialog webDialog, KGResultCallback kGResultCallback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(webDialog, "$webDialog");
        KGResult successResult = KGResult.INSTANCE.getSuccessResult(webDialog.getDeepLinkUrl());
        if (kGResultCallback != null) {
            kGResultCallback.onResult(successResult);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void show(Activity activity, WebDialog webDialog) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webDialog, y.ݬֲ֮ܲت(1512302815));
        DisplayUtil.checkSystemFontSize(activity);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WebDialogManager$show$5(activity, webDialog, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showImpl(Activity activity, WebDialog webDialog) {
        try {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            webDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.web.WebDialogManager$$ExternalSyntheticLambda4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WebDialogManager.showImpl$lambda$4(MutexLock.this, dialogInterface);
                }
            });
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WebDialogManager$showImpl$3(createLock, activity, DialogManager.INSTANCE.requestedActivityOrientation$gamesdk_release(activity), webDialog, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159029327), e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showImpl$lambda$4(MutexLock showLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(showLock, "$showLock");
        showLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showCafe(Activity activity, String webUrl, WebDialog.Settings settings, KGResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webUrl, y.دײܮڳܯ(2051274949));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159029327), y.ۮڭڭܬި(862890899) + webUrl);
        DisplayUtil.checkSystemFontSize(activity);
        KGResult<String> checkWebUrl = INSTANCE.checkWebUrl(activity, webUrl);
        if (checkWebUrl == null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WebDialogManager$showCafe$2(activity, webUrl, settings, callback, null), 3, null);
        } else if (callback != null) {
            callback.onResult(checkWebUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showCafeImpl(Activity activity, String webUrl, WebDialog.Settings settings, final KGResultCallback<String> callback) {
        try {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            final CafeWebDialog cafeWebDialog = new CafeWebDialog(activity, webUrl, settings);
            cafeWebDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.web.WebDialogManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WebDialogManager.showCafeImpl$lambda$6(CafeWebDialog.this, callback, createLock, dialogInterface);
                }
            });
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WebDialogManager$showCafeImpl$2(createLock, activity, DialogManager.INSTANCE.requestedActivityOrientation$gamesdk_release(activity), cafeWebDialog, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159029327), e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showCafeImpl$lambda$6(CafeWebDialog cafeWebDialog, KGResultCallback kGResultCallback, MutexLock showLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(cafeWebDialog, "$cafeWebDialog");
        Intrinsics.checkNotNullParameter(showLock, "$showLock");
        KGResult successResult = KGResult.INSTANCE.getSuccessResult(cafeWebDialog.getDeepLinkUrl());
        if (kGResultCallback != null) {
            kGResultCallback.onResult(successResult);
        }
        showLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> checkWebUrl(Activity activity, String webUrl) {
        boolean handleCustomScheme = WebViewContainer.INSTANCE.handleCustomScheme(activity, webUrl);
        String str = y.֬ڱܱײٮ(-1159029327);
        if (handleCustomScheme) {
            Logger.INSTANCE.m699d(str, y.٬ݯح׭٩(576259526) + webUrl);
            return KGResult.INSTANCE.getSuccessResult("");
        }
        if (!DeepLinkManager.INSTANCE.isPlatformDeepLink(webUrl)) {
            return null;
        }
        KGResult<String> handlePlatformDeepLink = DeepLinkManager.INSTANCE.handlePlatformDeepLink(activity, webUrl);
        Logger.INSTANCE.m704i(str, y.ݬֲ֮ܲت(1512508447) + handlePlatformDeepLink);
        return handlePlatformDeepLink;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void showPost(Activity activity, String webUrl, byte[] postData, boolean hideTopbar, KGResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webUrl, y.دײܮڳܯ(2051274949));
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159029327), y.ݬֲ֮ܲت(1512302975) + webUrl);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WebDialogManager$showPost$1(activity, webUrl, postData, hideTopbar, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showPostImpl(Activity activity, String webUrl, byte[] postData, boolean hideTopbar, final KGResultCallback<String> callback) {
        try {
            final MutexLock createLock = MutexLock.INSTANCE.createLock();
            final WebDialog webDialog = new WebDialog(activity, webUrl, postData, new WebDialog.Settings.Builder().build());
            if (hideTopbar) {
                webDialog.hideTopbar();
            }
            webDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.web.WebDialogManager$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    WebDialogManager.showPostImpl$lambda$7(WebDialog.this, callback, createLock, dialogInterface);
                }
            });
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WebDialogManager$showPostImpl$2(createLock, activity, DialogManager.INSTANCE.requestedActivityOrientation$gamesdk_release(activity), webDialog, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159029327), e.toString(), e);
            KGResult<String> result = KGResult.INSTANCE.getResult(4001, e.toString());
            if (callback != null) {
                callback.onResult(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showPostImpl$lambda$7(WebDialog webDialog, KGResultCallback kGResultCallback, MutexLock showLock, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(webDialog, "$webDialog");
        Intrinsics.checkNotNullParameter(showLock, "$showLock");
        KGResult successResult = KGResult.INSTANCE.getSuccessResult(webDialog.getDeepLinkUrl());
        if (kGResultCallback != null) {
            kGResultCallback.onResult(successResult);
        }
        showLock.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void checkSystemWebViewError(WebView webView, final Activity activity) {
        String str = y.֬ڱܱײٮ(-1159029327);
        String str2 = y.٬ݯح׭٩(576259374);
        Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        try {
            String userAgentString = webView.getSettings().getUserAgentString();
            Logger.INSTANCE.m704i(str, str2 + userAgentString);
            Intrinsics.checkNotNull(userAgentString);
            if (StringsKt.contains$default((CharSequence) userAgentString, (CharSequence) "Chrome/53", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) userAgentString, (CharSequence) "Chrome/54", false, 2, (Object) null)) {
                DialogManager.Settings settings = new DialogManager.Settings(null, null, null, Integer.valueOf(C2382R.string.zinny_sdk_error_system_webview), null, null, null, null, false, null, null, null, null, 8183, null);
                settings.setPositiveButton(C2382R.string.zinny_sdk_error_system_webview_update, new DialogInterface.OnClickListener() { // from class: com.kakaogame.web.WebDialogManager$$ExternalSyntheticLambda2
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        WebDialogManager.checkSystemWebViewError$lambda$8(activity, dialogInterface, i);
                    }
                });
                DialogManager.INSTANCE.showAlertDialog(activity, settings);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str, e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void checkSystemWebViewError$lambda$8(Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        AppUtil.launchApp(activity, "market://details?id=com.android.chrome");
        AppUtil.terminateApp(activity);
    }
}
