package com.kakaogame.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.net.MailTo;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.KGSystem;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.manager.SdkManager;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.Base64Util;
import com.kakaogame.util.DeviceUtil;
import com.kakaogame.util.MutexLock;
import com.kakaogame.util.VersionUtil;
import com.kakaogame.util.json.JSONValue;
import com.kakaogame.web.WebAppHandlerManager;
import com.liapp.y;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: WebViewContainer.kt */
@Metadata(m838d1 = {"\u0000\u0090\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\b\b\u0016\u0018\u0000 £\u00012\u00020\u0001:\u0006£\u0001¤\u0001¥\u0001B=\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u00106\u001a\u000207H\u0002J$\u00108\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\u0006\u0010;\u001a\u00020<H\u0004J\"\u0010=\u001a\u0002072\u0018\u0010>\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010'\u0018\u00010 H\u0004J\u0006\u0010?\u001a\u000207J\u0018\u0010@\u001a\u00020<2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\bH\u0002J\u0006\u0010A\u001a\u00020<J \u0010B\u001a\u0002072\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\nJ\u001c\u0010B\u001a\u0002072\b\u0010C\u001a\u0004\u0018\u00010D2\b\u0010E\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010G\u001a\u0002072\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0004J\u0012\u0010I\u001a\u00020<2\b\u0010J\u001a\u0004\u0018\u00010KH\u0004J,\u0010L\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010M\u001a\u00020<2\u0006\u0010N\u001a\u00020<2\b\u0010O\u001a\u0004\u0018\u00010PH\u0004J>\u0010Q\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010R\u001a\u0004\u0018\u00010\b2\u0006\u0010S\u001a\u00020\u001e2\u0006\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001e2\b\u0010V\u001a\u0004\u0018\u00010WH\u0004J&\u0010X\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010Y\u001a\u0004\u0018\u00010P2\b\u0010Z\u001a\u0004\u0018\u00010PH\u0004J\b\u0010[\u001a\u000207H\u0004J\u001c\u0010\\\u001a\u0002072\b\u0010]\u001a\u0004\u0018\u00010\b2\b\u0010>\u001a\u0004\u0018\u00010^H\u0004J\b\u0010_\u001a\u000207H\u0016J0\u0010`\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010a\u001a\u0004\u0018\u00010\b2\b\u0010b\u001a\u0004\u0018\u00010cH\u0014J0\u0010d\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010a\u001a\u0004\u0018\u00010\b2\b\u0010b\u001a\u0004\u0018\u00010cH\u0004J0\u0010e\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010a\u001a\u0004\u0018\u00010\b2\b\u0010b\u001a\u0004\u0018\u00010cH\u0004J:\u0010f\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010a\u001a\u0004\u0018\u00010\b2\b\u0010g\u001a\u0004\u0018\u00010\b2\b\u0010b\u001a\u0004\u0018\u00010hH\u0004J\b\u0010i\u001a\u00020<H\u0004J\u001c\u0010j\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\bH\u0004J\u001c\u0010k\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\bH\u0014J&\u0010l\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\b\u0010m\u001a\u0004\u0018\u00010\u0014H\u0014J\u001a\u0010n\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010o\u001a\u00020\nH\u0004J\"\u0010p\u001a\u0002072\u0006\u0010q\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\u001e2\b\u0010V\u001a\u0004\u0018\u00010WH\u0004J&\u0010r\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010s\u001a\u0004\u0018\u00010t2\b\u0010u\u001a\u0004\u0018\u00010vH\u0014J.\u0010r\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\u0006\u0010w\u001a\u00020\n2\b\u0010x\u001a\u0004\u0018\u00010\b2\b\u0010y\u001a\u0004\u0018\u00010\bH\u0014J0\u0010z\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010{\u001a\u0004\u0018\u00010|2\b\u0010}\u001a\u0004\u0018\u00010\b2\b\u0010~\u001a\u0004\u0018\u00010\bH\u0004J(\u0010\u007f\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010s\u001a\u0004\u0018\u00010t2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0014J\u001e\u0010\u0082\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0014H\u0004J3\u0010\u0084\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010~\u001a\u0004\u0018\u00010\b2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\b2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\bH\u0004J)\u0010\u0087\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\t\u0010{\u001a\u0005\u0018\u00010\u0088\u00012\t\u0010u\u001a\u0005\u0018\u00010\u0089\u0001H\u0014J\u001e\u0010\u008a\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\bH\u0014J&\u0010\u008c\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\b2\u0007\u0010\u008d\u0001\u001a\u00020<H\u0004J\u0013\u0010\u008e\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u0005H\u0004J'\u0010\u008f\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\b\u0010\u0092\u0001\u001a\u00030\u0091\u0001H\u0004J\u001e\u0010\u0093\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010+2\t\u0010>\u001a\u0005\u0018\u00010\u0094\u0001H\u0014J)\u0010\u0095\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010P2\t\u0010\u0097\u0001\u001a\u0004\u0018\u00010PH\u0004J\u001f\u0010\u0098\u0001\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010\u00052\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0004J\u001f\u0010\u009b\u0001\u001a\u0002072\b\u0010\u009c\u0001\u001a\u00030\u009d\u00012\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u000207H\u0002J\u0011\u0010 \u0001\u001a\u0002072\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001f\u0010¡\u0001\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010\u00052\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u0001H\u0004J\u001d\u0010¢\u0001\u001a\u00020<2\b\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\bH\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R(\u0010&\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0'\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u0016\u0010*\u001a\u0004\u0018\u00010+8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u000601R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, m839d2 = {"Lcom/kakaogame/web/WebViewContainer;", "", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "customCookie", "", "", "cookieExcludeOption", "", "(Landroid/app/Activity;Landroid/webkit/WebView;Ljava/util/Map;I)V", "getActivity", "()Landroid/app/Activity;", "activityResultLock", "Lcom/kakaogame/util/MutexLock;", "Ljava/lang/Void;", "getCookieExcludeOption", "()I", "defaultVideoPoster", "Landroid/graphics/Bitmap;", "getDefaultVideoPoster", "()Landroid/graphics/Bitmap;", "innerPopupViews", "Ljava/util/Stack;", "getInnerPopupViews", "()Ljava/util/Stack;", "setInnerPopupViews", "(Ljava/util/Stack;)V", "txId", "", "uploadMessage", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "getUploadMessage", "()Landroid/webkit/ValueCallback;", "setUploadMessage", "(Landroid/webkit/ValueCallback;)V", "uploadMessages", "", "getUploadMessages", "setUploadMessages", "videoLoadingProgressView", "Landroid/view/View;", "getVideoLoadingProgressView", "()Landroid/view/View;", "webAppHandlerManager", "Lcom/kakaogame/web/WebAppHandlerManager;", "webChromeClient", "Lcom/kakaogame/web/WebViewContainer$WebChromeClientImpl;", "getWebView", "()Landroid/webkit/WebView;", "webViewClient", "Landroid/webkit/WebViewClient;", "clearFileChooser", "", "doUpdateVisitedHistory", ViewHierarchyConstants.VIEW_KEY, "url", "isReload", "", "getVisitedHistory", "callback", "goBackInnerPopupView", "handleWebAppProtocol", "hasInnerPopupView", "initCookies", "context", "Landroid/content/Context;", "webUrl", "excludeOption", "onCloseWindow", "window", "onConsoleMessage", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "onCreateWindow", "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "onExceededDatabaseQuota", "databaseIdentifier", "currentQuota", "estimatedSize", "totalUsedQuota", "quotaUpdater", "Landroid/webkit/WebStorage$QuotaUpdater;", "onFormResubmission", "dontResend", "resend", "onGeolocationPermissionsHidePrompt", "onGeolocationPermissionsShowPrompt", "origin", "Landroid/webkit/GeolocationPermissions$Callback;", "onHideCustomView", "onJsAlert", "message", "result", "Landroid/webkit/JsResult;", "onJsBeforeUnload", "onJsConfirm", "onJsPrompt", "defaultValue", "Landroid/webkit/JsPromptResult;", "onJsTimeout", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "onProgressChanged", "newProgress", "onReachedMaxAppCacheSize", "spaceNeeded", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "description", "failingUrl", "onReceivedHttpAuthRequest", "handler", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedIcon", "icon", "onReceivedLoginRequest", "account", "args", "onReceivedSslError", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "onReceivedTitle", "title", "onReceivedTouchIconUrl", "precomposed", "onRequestFocus", "onScaleChanged", "oldScale", "", "newScale", "onShowCustomView", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "onTooManyRedirects", "cancelMsg", "continueMsg", "onUnhandledKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "openFileChooser", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "", "resetWebView", "setWebSettings", "shouldOverrideKeyEvent", "shouldOverrideUrlLoading", "Companion", "WebChromeClientImpl", "WebViewClientImpl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class WebViewContainer {
    protected static final String BLANK_PAGE = "about:blank";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_ACCEPT_TYPE = "image/*";
    public static final int EXCLUDE_CS_EMAIL = 1;
    public static final int EXCLUDE_KAKAO_TOKEN = 16;
    private static final int FILECHOOSER_REQ_CODE = 1887;
    private static final String TAG = "WebViewContainer";
    private final Activity activity;
    private final MutexLock<Void> activityResultLock;
    private final int cookieExcludeOption;
    private final Map<String, Object> customCookie;
    private Stack<WebView> innerPopupViews;
    private long txId;
    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessages;
    private final WebAppHandlerManager webAppHandlerManager;
    private final WebChromeClientImpl webChromeClient;
    private final WebView webView;
    private final WebViewClient webViewClient;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebViewContainer(Activity activity) {
        this(activity, null, null, 0, 14, null);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebViewContainer(Activity activity, WebView webView) {
        this(activity, webView, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebViewContainer(Activity activity, WebView webView, Map<String, ? extends Object> map) {
        this(activity, webView, map, 0, 8, null);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onFormResubmission(WebView view, Message dontResend, Message resend) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onGeolocationPermissionsHidePrompt() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onHideCustomView() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean onJsTimeout() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onLoadResource(WebView view, String url) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onPageFinished(WebView view, String url) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onPageStarted(WebView view, String url, Bitmap favicon) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onProgressChanged(WebView view, int newProgress) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onReceivedIcon(WebView view, Bitmap icon) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onReceivedTitle(WebView view, String title) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onRequestFocus(WebView view) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onScaleChanged(WebView view, float oldScale, float newScale) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onUnhandledKeyEvent(WebView view, KeyEvent event) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebViewContainer(Activity activity, WebView webView, Map<String, ? extends Object> map, int i) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
        this.activity = activity;
        this.webView = webView;
        this.customCookie = map;
        this.cookieExcludeOption = i;
        this.innerPopupViews = new Stack<>();
        this.activityResultLock = MutexLock.INSTANCE.createLock();
        resetWebView();
        setWebSettings(webView);
        WebViewClientImpl webViewClientImpl = new WebViewClientImpl();
        this.webViewClient = webViewClientImpl;
        WebChromeClientImpl webChromeClientImpl = new WebChromeClientImpl();
        this.webChromeClient = webChromeClientImpl;
        this.webAppHandlerManager = new WebAppHandlerManager();
        webView.setWebViewClient(webViewClientImpl);
        webView.setWebChromeClient(webChromeClientImpl);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ WebViewContainer(Activity activity, WebView webView, Map map, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i2 & 2) != 0 ? new WebView(activity) : webView, (i2 & 4) != 0 ? null : map, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final WebView getWebView() {
        return this.webView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getCookieExcludeOption() {
        return this.cookieExcludeOption;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Stack<WebView> getInnerPopupViews() {
        return this.innerPopupViews;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setInnerPopupViews(Stack<WebView> stack) {
        Intrinsics.checkNotNullParameter(stack, y.ٴسسݬߨ(1392633402));
        this.innerPopupViews = stack;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final ValueCallback<Uri> getUploadMessage() {
        return this.uploadMessage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUploadMessage(ValueCallback<Uri> valueCallback) {
        this.uploadMessage = valueCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final ValueCallback<Uri[]> getUploadMessages() {
        return this.uploadMessages;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setUploadMessages(ValueCallback<Uri[]> valueCallback) {
        this.uploadMessages = valueCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setWebSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, y.ۮڭڭܬި(862808243));
        webView.setInitialScale(1);
        webView.requestFocus(130);
        webView.setVerticalScrollbarOverlay(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setUseWideViewPort(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(2);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        settings.setMixedContentMode(0);
        settings.setUserAgentString(settings.getUserAgentString() + y.ٲٴݴ״ٰ(1782566744));
        settings.setUseWideViewPort(true);
        Companion companion = INSTANCE;
        String str = y.ۮڭڭܬި(862894539);
        companion.methodInvoke(settings, str, new Class[]{Boolean.TYPE}, new Object[]{true});
        companion.methodInvoke(settings, y.ݮڮֲڭܩ(-628169276), new Class[]{WebSettings.PluginState.class}, new Object[]{WebSettings.PluginState.ON});
        companion.methodInvoke(settings, str, new Class[]{Boolean.TYPE}, new Object[]{true});
        companion.methodInvoke(settings, y.ۮڭڭܬި(862894883), new Class[]{Boolean.TYPE}, new Object[]{true});
        companion.methodInvoke(settings, "setAllowFileAccessFromFileURLs", new Class[]{Boolean.TYPE}, new Object[]{true});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasInnerPopupView() {
        return this.innerPopupViews.size() > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void goBackInnerPopupView() {
        if (this.innerPopupViews.lastElement().canGoBack()) {
            this.innerPopupViews.lastElement().goBack();
        } else {
            onCloseWindow(this.innerPopupViews.pop());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void initCookies(Context context, String webUrl) {
        Intrinsics.checkNotNull(webUrl);
        initCookies(context, webUrl, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void initCookies(Context context, String webUrl, int excludeOption) {
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628168852) + webUrl;
        String str2 = y.ۮڭڭܬި(862893459);
        logger.m699d(str2, str);
        if (TextUtils.isEmpty(webUrl)) {
            return;
        }
        String domainUrl = INSTANCE.getDomainUrl(webUrl);
        if (TextUtils.isEmpty(domainUrl)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(y.ݮڮֲڭܩ(-628723908), KGSystem.getOSName());
        linkedHashMap.put(y.٬ݯح׭٩(576651310), VersionUtil.getOSVersion());
        linkedHashMap.put(y.ݬֲ֮ܲت(1512431663), DeviceUtil.getDeviceModel());
        linkedHashMap.put(y.٬ݯح׭٩(576655054), KGSystem.getLanguageCode());
        linkedHashMap.put(y.دײܮڳܯ(2051393733), KGSystem.getCountryCode());
        linkedHashMap.put(y.دײܮڳܯ(2051393261), KGSystem.getDeviceId());
        linkedHashMap.put(y.֬ڱܱײٮ(-1158779935), Long.valueOf(CoreManager.INSTANCE.getInstance().currentTimeMillis()));
        Configuration configuration = CoreManager.INSTANCE.getInstance().getConfiguration();
        linkedHashMap.put(y.ۮڭڭܬި(862411867), configuration.getAppId());
        linkedHashMap.put(y.֬ڱܱײٮ(-1158899895), configuration.getAppVersion());
        linkedHashMap.put(y.دײܮڳܯ(2051758173), configuration.getMarket());
        linkedHashMap.put(y.٬ݯح׭٩(576655134), SdkManager.INSTANCE.getSdkVersion());
        String lowerCase = configuration.getServerTypeValue().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
        linkedHashMap.put(y.ۮڭڭܬި(862864659), StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) y.ٴسسݬߨ(1393218538), false, 2, (Object) null) ? y.دײܮڳܯ(2051264901) : y.ۮڭڭܬި(862864699));
        String termsOfServiceVer = InfodeskHelper.INSTANCE.getTermsOfServiceVer();
        if (termsOfServiceVer != null) {
            linkedHashMap.put(y.٬ݯح׭٩(576567662), termsOfServiceVer);
        }
        String termsOfServiceUrl = InfodeskHelper.INSTANCE.getTermsOfServiceUrl();
        if (termsOfServiceUrl != null) {
            linkedHashMap.put(y.ۮڭڭܬި(862864803), termsOfServiceUrl);
        }
        String publisherId = InfodeskHelper.INSTANCE.getPublisherId();
        if (publisherId != null) {
            linkedHashMap.put(y.ݬֲ֮ܲت(1512521775), publisherId);
        }
        String policyVersion = InfodeskHelper.INSTANCE.getPolicyVersion();
        if (policyVersion != null) {
            linkedHashMap.put(y.֬ڱܱײٮ(-1158793383), policyVersion);
        }
        if ((excludeOption & 1) == 0) {
            String cSEmail = InfodeskHelper.INSTANCE.getCSEmail();
            Logger.INSTANCE.m699d(str2, y.֬ڱܱײٮ(-1159041007) + cSEmail);
            if (cSEmail != null) {
                linkedHashMap.put(y.ݬֲ֮ܲت(1512516327), cSEmail);
            }
        }
        if (CoreManager.INSTANCE.getInstance().isAuthorized()) {
            linkedHashMap.put(y.ݬֲ֮ܲت(1512589743), CoreManager.INSTANCE.getInstance().getPlayerId());
            IdpAccount authData = CoreManager.INSTANCE.getInstance().getAuthData();
            Intrinsics.checkNotNull(authData);
            linkedHashMap.put(y.٬ݯح׭٩(576653590), authData.getIdpUserId());
            linkedHashMap.put(y.دײܮڳܯ(2051564517), authData.getIdpCode());
            KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
            Intrinsics.checkNotNull(currentPlayer);
            long registTime = currentPlayer.getRegistTime();
            if (registTime > 0) {
                linkedHashMap.put(y.دײܮڳܯ(2051718589), Long.valueOf(registTime));
            }
            if (StringsKt.equals(KGIdpProfile.KGIdpCode.Kakao.getCode(), authData.getIdpCode(), true)) {
                if ((excludeOption & 16) == 0) {
                    linkedHashMap.put(KGKakao2Auth.KEY_SERVICE_USER_ID, (String) authData.get(KGKakao2Auth.KEY_SERVICE_USER_ID));
                    linkedHashMap.put("kakaoAccessToken", authData.getIdpAccessToken());
                }
                if (InfodeskHelper.INSTANCE.isKakaoGame()) {
                    CookieManager.getInstance().setCookie(y.ۮڭڭܬި(862864635), y.٬ݯح׭٩(576317878) + authData.getIdpAccessToken());
                }
                KGLocalPlayer currentPlayer2 = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                Intrinsics.checkNotNull(currentPlayer2);
                KGIdpProfile idpProfile = currentPlayer2.getIdpProfile();
                Intrinsics.checkNotNull(idpProfile);
                String accountType = idpProfile.getAccountType();
                if (!TextUtils.isEmpty(accountType)) {
                    linkedHashMap.put(y.֬ڱܱײٮ(-1159040231), accountType);
                }
            }
        }
        Map<String, Object> map = this.customCookie;
        if (map != null) {
            Intrinsics.checkNotNull(map);
            linkedHashMap.putAll(map);
        }
        Logger.INSTANCE.m699d(str2, y.ۮڭڭܬި(862865323) + domainUrl);
        String jSONString = JSONValue.toJSONString(linkedHashMap);
        Logger.INSTANCE.m699d(str2, y.ۮڭڭܬި(862864915) + jSONString);
        String urlSafeBase64encode = Base64Util.getUrlSafeBase64encode(jSONString);
        Logger.INSTANCE.m699d(str2, y.ݮڮֲڭܩ(-628220940) + urlSafeBase64encode);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setCookie(domainUrl, y.٬ݯح׭٩(576318550) + urlSafeBase64encode);
        cookieManager.setAcceptCookie(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void resetWebView() {
        this.webView.stopLoading();
        this.webView.clearHistory();
        this.webView.clearFormData();
        this.webView.clearCache(true);
        this.webView.onResume();
        this.webView.resumeTimers();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean handleWebAppProtocol(final WebView view, String url) {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862893459), y.دײܮڳܯ(2051265669) + url);
        return this.webAppHandlerManager.handle(this.webView, url, new WebAppHandlerManager.WebAppHandlerCallback() { // from class: com.kakaogame.web.WebViewContainer$handleWebAppProtocol$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.web.WebAppHandlerManager.WebAppHandlerCallback
            public void onHandle(KGResult<String> result) {
                Logger logger = Logger.INSTANCE;
                String str = y.ۮڭڭܬި(862895387) + result;
                String str2 = y.ۮڭڭܬި(862893459);
                logger.m699d(str2, str);
                String content = result != null ? result.getContent() : null;
                Logger.INSTANCE.m699d(str2, y.ٴسسݬߨ(1393218698) + content);
                if (content != null) {
                    view.loadUrl(content);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void clearFileChooser() {
        ValueCallback<Uri> valueCallback = this.uploadMessage;
        if (valueCallback != null) {
            Intrinsics.checkNotNull(valueCallback);
            valueCallback.onReceiveValue(null);
            this.uploadMessage = null;
        }
        ValueCallback<Uri[]> valueCallback2 = this.uploadMessages;
        if (valueCallback2 != null) {
            Intrinsics.checkNotNull(valueCallback2);
            valueCallback2.onReceiveValue(null);
            this.uploadMessages = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void openFileChooser(Intent intent, CharSequence title) {
        Logger.INSTANCE.m699d(y.ۮڭڭܬި(862893459), y.֬ڱܱײٮ(-1159034231) + intent.getAction() + y.ݮڮֲڭܩ(-628756788) + ((Object) title));
        if (TextUtils.isEmpty(title)) {
        }
        intent.addFlags(64);
        intent.addFlags(1);
        final Intent createChooser = Intent.createChooser(intent, title);
        this.txId = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, this.activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.web.WebViewContainer$openFileChooser$eventListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onDestroy() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityStart(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
                activity.startActivityForResult(createChooser, 1887);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                long j;
                Logger logger = Logger.INSTANCE;
                String str = y.٬ݯح׭٩(575803430) + requestCode + y.ݮڮֲڭܩ(-628756788) + resultCode;
                String str2 = y.ۮڭڭܬި(862893459);
                logger.m699d(str2, str);
                if (requestCode == 1887) {
                    Uri data2 = (data == null || resultCode != -1) ? null : data.getData();
                    if (data2 != null) {
                        this.getActivity().grantUriPermission(this.getActivity().getPackageName(), data2, 1);
                    }
                    if (this.getUploadMessage() != null) {
                        Logger.INSTANCE.m699d(str2, y.ݬֲ֮ܲت(1512308231) + data2);
                        ValueCallback<Uri> uploadMessage = this.getUploadMessage();
                        Intrinsics.checkNotNull(uploadMessage);
                        uploadMessage.onReceiveValue(data2);
                        this.setUploadMessage(null);
                    }
                    if (this.getUploadMessages() != null) {
                        Logger.INSTANCE.m699d(str2, y.دײܮڳܯ(2051265589) + data2);
                        Uri[] uriArr = data2 != null ? new Uri[]{data2} : null;
                        ValueCallback<Uri[]> uploadMessages = this.getUploadMessages();
                        Intrinsics.checkNotNull(uploadMessages);
                        uploadMessages.onReceiveValue(uriArr);
                        this.setUploadMessages(null);
                    }
                    AuthActivityManager.INSTANCE.getInstance().removeResultListener(this);
                    AuthActivityManager companion = AuthActivityManager.INSTANCE.getInstance();
                    j = this.txId;
                    companion.finishActivity(j);
                }
            }
        }, null, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (view == null || url == null || handleWebAppProtocol(view, url) || INSTANCE.handleCustomScheme(this.activity, url)) {
            return true;
        }
        initCookies(this.activity, url);
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Bitmap getDefaultVideoPoster() {
        return this.webChromeClient.getDefaultVideoPoster();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final View getVideoLoadingProgressView() {
        return this.webChromeClient.getVideoLoadingProgressView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void getVisitedHistory(ValueCallback<String[]> callback) {
        this.webChromeClient.getVisitedHistory(callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void onCloseWindow(WebView window) {
        if (Intrinsics.areEqual(window, this.webView)) {
            return;
        }
        this.webView.removeView(window);
    }

    /* compiled from: WebViewContainer.kt */
    @Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J.\u0010\u0015\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J0\u0010\u001a\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0016J0\u0010\u001f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\"\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u001b\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\"\u0010&\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J&\u0010*\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010+\u001a\u0004\u0018\u00010\u000e2\b\u0010,\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010-\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00100\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u001c\u00101\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, m839d2 = {"Lcom/kakaogame/web/WebViewContainer$WebViewClientImpl;", "Landroid/webkit/WebViewClient;", "(Lcom/kakaogame/web/WebViewContainer;)V", "shouldOverrideUrl", "", "doUpdateVisitedHistory", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "url", "isReload", "", "onFormResubmission", "dontResend", "Landroid/os/Message;", "resend", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedHttpAuthRequest", "handler", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedLoginRequest", "account", "args", "onReceivedSslError", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onScaleChanged", "oldScale", "", "newScale", "onTooManyRedirects", "cancelMsg", "continueMsg", "onUnhandledKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "shouldOverrideKeyEvent", "shouldOverrideUrlLoading", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private final class WebViewClientImpl extends WebViewClient {
        private String shouldOverrideUrl;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WebViewClientImpl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
            WebViewContainer.this.doUpdateVisitedHistory(view, url, isReload);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView view, Message dontResend, Message resend) {
            if (resend != null) {
                resend.sendToTarget();
            }
            WebViewContainer.this.onFormResubmission(view, dontResend, resend);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            WebViewContainer.this.onLoadResource(view, url);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            WebViewContainer.this.onPageFinished(view, url);
            WebViewContainer.this.onReceivedTitle(view, view != null ? view.getTitle() : null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            WebViewContainer.this.onPageStarted(view, url, favicon);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            WebViewContainer.this.onReceivedError(view, errorCode, description, failingUrl);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
            WebViewContainer.this.onReceivedHttpAuthRequest(view, handler, host, realm);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
            WebViewContainer.this.onReceivedLoginRequest(view, realm, account, args);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            if (view != null) {
                WebDialogManager.checkSystemWebViewError(view, WebViewContainer.this.getActivity());
            }
            WebViewContainer.this.onReceivedSslError(view, handler, error);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView view, float oldScale, float newScale) {
            WebViewContainer.this.onScaleChanged(view, oldScale, newScale);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
            WebViewContainer.this.onTooManyRedirects(view, cancelMsg, continueMsg);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
            WebViewContainer.this.onUnhandledKeyEvent(view, event);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            return WebViewContainer.this.shouldOverrideKeyEvent(view, event);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            this.shouldOverrideUrl = url;
            return WebViewContainer.this.shouldOverrideUrlLoading(view, url);
        }
    }

    /* compiled from: WebViewContainer.kt */
    @Metadata(m838d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J,\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J>\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J0\u0010!\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J0\u0010%\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J0\u0010&\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J:\u0010'\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u00132\b\u0010(\u001a\u0004\u0018\u00010\u00132\b\u0010#\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\bH\u0016J\u001a\u0010+\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020-H\u0016J \u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001c\u00100\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001c\u00103\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u00104\u001a\u0004\u0018\u00010\u0013H\u0016J$\u00105\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u00106\u001a\u00020\bH\u0016J\u0012\u00107\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u00108\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u0001092\b\u0010\u001e\u001a\u0004\u0018\u00010:H\u0016J$\u00108\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020-2\b\u0010\u001e\u001a\u0004\u0018\u00010:H\u0017J2\u0010<\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010\u00062\u0014\u0010>\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020A0@\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010CH\u0017¨\u0006D"}, m839d2 = {"Lcom/kakaogame/web/WebViewContainer$WebChromeClientImpl;", "Landroid/webkit/WebChromeClient;", "(Lcom/kakaogame/web/WebViewContainer;)V", "onCloseWindow", "", "window", "Landroid/webkit/WebView;", "onConsoleMessage", "", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "onCreateWindow", ViewHierarchyConstants.VIEW_KEY, "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "onExceededDatabaseQuota", "url", "", "databaseIdentifier", "currentQuota", "", "estimatedSize", "totalUsedQuota", "quotaUpdater", "Landroid/webkit/WebStorage$QuotaUpdater;", "onGeolocationPermissionsHidePrompt", "onGeolocationPermissionsShowPrompt", "origin", "callback", "Landroid/webkit/GeolocationPermissions$Callback;", "onHideCustomView", "onJsAlert", "message", "result", "Landroid/webkit/JsResult;", "onJsBeforeUnload", "onJsConfirm", "onJsPrompt", "defaultValue", "Landroid/webkit/JsPromptResult;", "onJsTimeout", "onProgressChanged", "newProgress", "", "onReachedMaxAppCacheSize", "spaceNeeded", "onReceivedIcon", "icon", "Landroid/graphics/Bitmap;", "onReceivedTitle", "title", "onReceivedTouchIconUrl", "precomposed", "onRequestFocus", "onShowCustomView", "Landroid/view/View;", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "requestedOrientation", "onShowFileChooser", "webView", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public final class WebChromeClientImpl extends WebChromeClient {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WebChromeClientImpl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView window) {
            WebViewContainer.this.onCloseWindow(window);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return WebViewContainer.this.onConsoleMessage(consoleMessage);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
            Logger logger = Logger.INSTANCE;
            String str = isDialog ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
            String str2 = y.ٲٴݴ״ٰ(1782564520);
            String concat = str2.concat(str);
            String str3 = y.ۮڭڭܬި(862893459);
            logger.m699d(str3, concat);
            if (view == null) {
                return false;
            }
            Message obtainMessage = view.getHandler().obtainMessage();
            Intrinsics.checkNotNullExpressionValue(obtainMessage, y.ݬֲ֮ܲت(1512305111));
            view.requestFocusNodeHref(obtainMessage);
            String string = obtainMessage.getData().getString(y.ݬֲ֮ܲت(1512934047));
            Logger logger2 = Logger.INSTANCE;
            StringBuilder sb = new StringBuilder(str2);
            if (string == null) {
                string = "null";
            }
            logger2.m699d(str3, sb.append(string).toString());
            view.removeAllViews();
            WebView webView = new WebView(view.getContext());
            WebViewContainer.this.setWebSettings(webView);
            webView.setWebChromeClient(WebViewContainer.this.new WebChromeClientImpl());
            webView.setWebViewClient(new WebViewClient());
            webView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            WebViewContainer.this.getWebView().addView(webView);
            WebViewContainer.this.getWebView().scrollTo(0, 0);
            WebViewContainer.this.getInnerPopupViews().push(webView);
            Object obj = resultMsg != null ? resultMsg.obj : null;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.webkit.WebView.WebViewTransport");
            ((WebView.WebViewTransport) obj).setWebView(webView);
            resultMsg.sendToTarget();
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
            WebViewContainer.this.onExceededDatabaseQuota(url, databaseIdentifier, currentQuota, estimatedSize, totalUsedQuota, quotaUpdater);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            WebViewContainer.this.onGeolocationPermissionsHidePrompt();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            WebViewContainer.this.onGeolocationPermissionsShowPrompt(origin, callback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            super.onHideCustomView();
            WebViewContainer.this.onHideCustomView();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return WebViewContainer.this.onJsAlert(view, url, message, result);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            return WebViewContainer.this.onJsBeforeUnload(view, url, message, result);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return WebViewContainer.this.onJsConfirm(view, url, message, result);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return WebViewContainer.this.onJsPrompt(view, url, message, defaultValue, result);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            return WebViewContainer.this.onJsTimeout();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView view, int newProgress) {
            WebViewContainer.this.onProgressChanged(view, newProgress);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
            WebViewContainer.this.onReachedMaxAppCacheSize(spaceNeeded, totalUsedQuota, quotaUpdater);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView view, Bitmap icon) {
            WebViewContainer.this.onReceivedIcon(view, icon);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView view, String title) {
            WebViewContainer.this.onReceivedTitle(view, title);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
            WebViewContainer.this.onReceivedTouchIconUrl(view, url, precomposed);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView view) {
            WebViewContainer.this.onRequestFocus(view);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            super.onShowCustomView(view, callback);
            WebViewContainer.this.onShowCustomView(view, callback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
            super.onShowCustomView(view, requestedOrientation, callback);
            WebViewContainer.this.onShowCustomView(view, callback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (fileChooserParams == null) {
                return false;
            }
            Logger.INSTANCE.m699d(y.ۮڭڭܬި(862893459), y.دײܮڳܯ(2051266717) + fileChooserParams.getAcceptTypes() + y.ݮڮֲڭܩ(-628756788) + ((Object) fileChooserParams.getTitle()));
            WebViewContainer.this.clearFileChooser();
            WebViewContainer.this.setUploadMessages(filePathCallback);
            WebViewContainer webViewContainer = WebViewContainer.this;
            Intent createIntent = fileChooserParams.createIntent();
            Intrinsics.checkNotNullExpressionValue(createIntent, y.دײܮڳܯ(2051267045));
            webViewContainer.openFileChooser(createIntent, fileChooserParams.getTitle());
            return true;
        }
    }

    /* compiled from: WebViewContainer.kt */
    @Metadata(m838d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004J?\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00180\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0084T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m839d2 = {"Lcom/kakaogame/web/WebViewContainer$Companion;", "", "()V", "BLANK_PAGE", "", "DEFAULT_ACCEPT_TYPE", "EXCLUDE_CS_EMAIL", "", "EXCLUDE_KAKAO_TOKEN", "FILECHOOSER_REQ_CODE", "TAG", "getDomainUrl", "webUrl", "handleCustomScheme", "", "activity", "Landroid/app/Activity;", "url", "methodInvoke", "", "obj", FirebaseAnalytics.Param.METHOD, "parameterTypes", "", "Ljava/lang/Class;", "args", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)V", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getDomainUrl(String webUrl) {
            String str = y.دײܮڳܯ(2051260909);
            String str2 = y.ٲٴݴ״ٰ(1782570232);
            Logger logger = Logger.INSTANCE;
            String str3 = y.ۮڭڭܬި(862893331) + webUrl;
            String str4 = y.ۮڭڭܬި(862893459);
            logger.m699d(str4, str3);
            try {
                URI uri = new URI(webUrl);
                Logger.INSTANCE.m699d(str4, str2 + uri);
                String host = uri.getHost();
                Logger.INSTANCE.m699d(str4, str + host);
                Intrinsics.checkNotNull(host);
                return host;
            } catch (URISyntaxException e) {
                Logger.INSTANCE.m702e(str4, e.toString(), e);
                return "";
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean handleCustomScheme(Activity activity, String url) {
            Intrinsics.checkNotNullParameter(url, y.ݬֲ֮ܲت(1512934047));
            String str = y.دײܮڳܯ(2051758173);
            String str2 = y.ݮڮֲڭܩ(-628241444);
            String str3 = y.ݬֲ֮ܲت(1512852487);
            String str4 = y.ݮڮֲڭܩ(-628168348);
            String str5 = y.֬ڱܱײٮ(-1159036767);
            Regex regex = new Regex(y.ٲٴݴ״ٰ(1782563112));
            Logger logger = Logger.INSTANCE;
            String str6 = y.٬ݯح׭٩(576259526) + url;
            String str7 = y.ۮڭڭܬި(862893459);
            logger.m699d(str7, str6);
            if (activity == null) {
                return false;
            }
            try {
                if (TextUtils.isEmpty(url)) {
                    return false;
                }
                if (!StringsKt.startsWith$default(url, MailTo.MAILTO_SCHEME, false, 2, (Object) null) && !StringsKt.startsWith$default(url, "tel:", false, 2, (Object) null) && !StringsKt.startsWith$default(url, "geo:0,0?q=", false, 2, (Object) null)) {
                    if (StringsKt.startsWith$default(url, str, false, 2, (Object) null)) {
                        AppUtil.launchViewer(activity, url);
                    } else if (StringsKt.startsWith$default(url, str2, false, 2, (Object) null)) {
                        AppUtil.launchViewer(activity, url);
                    } else if (StringsKt.startsWith$default(url, str3, false, 2, (Object) null)) {
                        AppUtil.launchIntent(activity, url);
                    } else if (StringsKt.startsWith$default(url, str4, false, 2, (Object) null)) {
                        AppUtil.launchAndroidApp(activity, url);
                    } else {
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                        String lowerCase = url.toLowerCase(locale);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (StringsKt.startsWith$default(lowerCase, str5, false, 2, (Object) null)) {
                            String queryParameter = Uri.parse(url).getQueryParameter("uri");
                            Intrinsics.checkNotNull(queryParameter);
                            AppUtil.launchApp(activity, queryParameter);
                        } else {
                            if (!regex.matches(url)) {
                                return false;
                            }
                            AppUtil.launchMarket(activity, url);
                        }
                    }
                    return true;
                }
                AppUtil.launchViewer(activity, url);
                return true;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str7, e.toString(), e);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void methodInvoke(Object obj, String method, Class<?>[] parameterTypes, Object[] args) {
            try {
                obj.getClass().getMethod(method, (Class[]) Arrays.copyOf(parameterTypes, parameterTypes.length)).invoke(obj, Arrays.copyOf(args, args.length));
            } catch (Exception e) {
                Logger.INSTANCE.m704i(WebViewContainer.TAG, e.toString());
            }
        }
    }
}
