package com.kakaogame.web;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.C0047R;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.kakaogame.C2382R;
import com.kakaogame.KGActivityManager;
import com.kakaogame.KGApplication;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.databinding.ZinnySdkDialogWebKakaoBinding;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.p029ui.DeepLinkManager;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.util.ResourceUtil;
import com.kakaogame.web.WebDialog;
import com.kakaogame.web.protocol.WebAppProtocolHandler;
import com.liapp.y;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: WebDialog.kt */
@Metadata(m838d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0006defghiB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0014\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0006H\u0002J(\u0010L\u001a\u00020J2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00062\u000e\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0OH\u0002J\u0010\u0010P\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0006H\u0002J \u0010Q\u001a\u00020J2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010C\u001a\u00020D2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010R\u001a\u00020JH\u0016J\b\u0010\u001f\u001a\u00020JH\u0003J\u0018\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0010H\u0004J\u0006\u0010#\u001a\u00020JJ\b\u0010V\u001a\u00020JH\u0014J\b\u0010W\u001a\u00020JH\u0016J\u0010\u0010X\u001a\u00020J2\u0006\u0010Y\u001a\u00020ZH\u0016J\u0012\u0010[\u001a\u00020J2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0014J\b\u0010^\u001a\u00020JH\u0014J\b\u0010_\u001a\u00020JH\u0014J\b\u0010`\u001a\u00020JH\u0004J\u0010\u0010a\u001a\u00020J2\u0006\u0010T\u001a\u00020\u0004H\u0002J\u0010\u0010b\u001a\u00020J2\u0006\u0010c\u001a\u00020\u001eH\u0014R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020$8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u0004\u0018\u00010\u00108\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001a\u0010.\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u0012\u0010\u000b\u001a\u00020\f8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001c\u00101\u001a\u0004\u0018\u000102X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0012\u0010<\u001a\u00020\u001e8\u0004@\u0004X\u0085\u000e¢\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020>X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0010\u0010\u0005\u001a\u00020\u00068\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u00020DX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006j"}, m839d2 = {"Lcom/kakaogame/web/WebDialog;", "Landroid/app/Dialog;", "Lcom/kakaogame/KGActivityManager$ConfigChangeListener;", "activity", "Landroid/app/Activity;", "webUrl", "", "(Landroid/app/Activity;Ljava/lang/String;)V", "postData", "", "(Landroid/app/Activity;Ljava/lang/String;[B)V", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Landroid/app/Activity;Ljava/lang/String;Lcom/kakaogame/web/WebDialog$Settings;)V", "(Landroid/app/Activity;Ljava/lang/String;[BLcom/kakaogame/web/WebDialog$Settings;)V", "backView", "Landroid/view/View;", "binding", "Lcom/kakaogame/databinding/ZinnySdkDialogWebKakaoBinding;", "getBinding", "()Lcom/kakaogame/databinding/ZinnySdkDialogWebKakaoBinding;", "binding$delegate", "Lkotlin/Lazy;", "container", "Lcom/kakaogame/web/WebViewContainer;", "<set-?>", "deepLinkUrl", "getDeepLinkUrl", "()Ljava/lang/String;", "displayCutoutMode", "", "getDisplayCutoutMode", "()I", "setDisplayCutoutMode", "(I)V", "hideTopbar", "", "isPulltoRefresh", "isTablet", "()Z", "logoView", "getPostData", "()[B", "preOrientation", "getPreOrientation", "setPreOrientation", "preScreenLayout", "getPreScreenLayout", "setPreScreenLayout", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "topbarView", "getTopbarView", "()Landroid/view/View;", "setTopbarView", "(Landroid/view/View;)V", "viewMargin", "webLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getWebLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setWebLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "changeTitleText", "", "url", "checkRequiredPermission", "permission", "callback", "Lcom/kakaogame/KGResultCallback;", "checkUIParameters", "createContainer", "dismiss", "handleKeyboardShowEvent", "act", "contentView", "initViews", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "setDialogVisibility", "setFocusChanged", "setMargin", "cutoutSize", "Companion", "MakeShortcutHandler", "OnCloseListener", "SelectImageHandler", "Settings", "WebViewContainerImpl", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class WebDialog extends Dialog implements KGActivityManager.ConfigChangeListener {
    private static final int PICK_IMAGE_REQ_CODE = 999;
    private static final String TAG = "WebDialog";
    private static final String changeTitleWebAppProtocol = "zinny://changeTitleText";
    private static final String closeWebAppProtocol = "zinny://closeview";
    protected View backView;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;
    protected WebViewContainer container;
    private String deepLinkUrl;
    private int displayCutoutMode;
    private boolean hideTopbar;
    private boolean isPulltoRefresh;
    protected View logoView;
    private final byte[] postData;
    private int preOrientation;
    private int preScreenLayout;
    protected Settings settings;
    private TextView titleView;
    private View topbarView;
    protected int viewMargin;
    protected SwipeRefreshLayout webLayout;
    protected final String webUrl;
    protected WebView webView;

    /* compiled from: WebDialog.kt */
    @Metadata(m838d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$OnCloseListener;", "", "onClose", "", "dialog", "Lcom/kakaogame/web/WebDialog;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface OnCloseListener {
        void onClose(WebDialog dialog);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int getPreOrientation() {
        return this.preOrientation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setPreOrientation(int i) {
        this.preOrientation = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int getPreScreenLayout() {
        return this.preScreenLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setPreScreenLayout(int i) {
        this.preScreenLayout = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final byte[] getPostData() {
        return this.postData;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final WebView getWebView() {
        WebView webView = this.webView;
        if (webView != null) {
            return webView;
        }
        Intrinsics.throwUninitializedPropertyAccessException(y.٬ݯح׭٩(576656206));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, y.ٴسسݬߨ(1392633402));
        this.webView = webView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final SwipeRefreshLayout getWebLayout() {
        SwipeRefreshLayout swipeRefreshLayout = this.webLayout;
        if (swipeRefreshLayout != null) {
            return swipeRefreshLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1159031223));
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setWebLayout(SwipeRefreshLayout swipeRefreshLayout) {
        Intrinsics.checkNotNullParameter(swipeRefreshLayout, y.ٴسسݬߨ(1392633402));
        this.webLayout = swipeRefreshLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final View getTopbarView() {
        return this.topbarView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setTopbarView(View view) {
        this.topbarView = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final TextView getTitleView() {
        return this.titleView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setTitleView(TextView textView) {
        this.titleView = textView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ZinnySdkDialogWebKakaoBinding getBinding() {
        return (ZinnySdkDialogWebKakaoBinding) this.binding.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: getDisplayCutoutMode, reason: collision with other method in class */
    public final int m1274getDisplayCutoutMode() {
        return this.displayCutoutMode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setDisplayCutoutMode(int i) {
        this.displayCutoutMode = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebDialog(Activity activity, String str) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051274949));
        this.preOrientation = -1;
        this.preScreenLayout = -1;
        this.binding = LazyKt.lazy(new Function0<ZinnySdkDialogWebKakaoBinding>() { // from class: com.kakaogame.web.WebDialog$binding$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final ZinnySdkDialogWebKakaoBinding invoke() {
                return ZinnySdkDialogWebKakaoBinding.inflate(WebDialog.this.getLayoutInflater());
            }
        });
        this.deepLinkUrl = "";
        this.isPulltoRefresh = true;
        setOwnerActivity(activity);
        this.webUrl = str;
        this.postData = null;
        this.settings = new Settings.Builder().build();
        getDisplayCutoutMode();
        new SelectImageHandler();
        new MakeShortcutHandler();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected WebDialog(Activity activity, String str, byte[] bArr) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051274949));
        this.preOrientation = -1;
        this.preScreenLayout = -1;
        this.binding = LazyKt.lazy(new Function0<ZinnySdkDialogWebKakaoBinding>() { // from class: com.kakaogame.web.WebDialog$binding$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final ZinnySdkDialogWebKakaoBinding invoke() {
                return ZinnySdkDialogWebKakaoBinding.inflate(WebDialog.this.getLayoutInflater());
            }
        });
        this.deepLinkUrl = "";
        this.isPulltoRefresh = true;
        setOwnerActivity(activity);
        this.webUrl = str;
        this.postData = bArr;
        this.settings = new Settings.Builder().build();
        getDisplayCutoutMode();
        new SelectImageHandler();
        new MakeShortcutHandler();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebDialog(Activity activity, String str, Settings settings) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051274949));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        this.preOrientation = -1;
        this.preScreenLayout = -1;
        this.binding = LazyKt.lazy(new Function0<ZinnySdkDialogWebKakaoBinding>() { // from class: com.kakaogame.web.WebDialog$binding$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final ZinnySdkDialogWebKakaoBinding invoke() {
                return ZinnySdkDialogWebKakaoBinding.inflate(WebDialog.this.getLayoutInflater());
            }
        });
        this.deepLinkUrl = "";
        this.isPulltoRefresh = true;
        setOwnerActivity(activity);
        this.webUrl = str;
        this.postData = null;
        this.settings = settings;
        getDisplayCutoutMode();
        new SelectImageHandler();
        new MakeShortcutHandler();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WebDialog(Activity activity, String str, byte[] bArr, Settings settings) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051274949));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        this.preOrientation = -1;
        this.preScreenLayout = -1;
        this.binding = LazyKt.lazy(new Function0<ZinnySdkDialogWebKakaoBinding>() { // from class: com.kakaogame.web.WebDialog$binding$2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function0
            public final ZinnySdkDialogWebKakaoBinding invoke() {
                return ZinnySdkDialogWebKakaoBinding.inflate(WebDialog.this.getLayoutInflater());
            }
        });
        this.deepLinkUrl = "";
        this.isPulltoRefresh = true;
        setOwnerActivity(activity);
        this.webUrl = str;
        this.postData = bArr;
        this.settings = settings;
        getDisplayCutoutMode();
        new SelectImageHandler();
        new MakeShortcutHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void getDisplayCutoutMode() {
        if (Build.VERSION.SDK_INT >= 28) {
            Activity ownerActivity = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity);
            this.displayCutoutMode = ownerActivity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void checkRequiredPermission(final Activity activity, final String permission, final KGResultCallback<Boolean> callback) {
        KGApplication.checkPermission(activity, permission, new KGResultCallback<Boolean>() { // from class: com.kakaogame.web.WebDialog$checkRequiredPermission$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.KGResultCallback
            public void onResult(KGResult<Boolean> result) {
                if (result != null) {
                    if (result.isSuccess() && Intrinsics.areEqual((Object) result.getContent(), (Object) true)) {
                        Log.e(y.ٴسسݬߨ(1393216610), y.ۮڭڭܬި(862782131) + result);
                        callback.onResult(result);
                        return;
                    }
                    KGApplication.requestPermission(activity, permission, callback);
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void setDialogVisibility() {
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowCompat.setDecorFitsSystemWindows(window, false);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window2, window3.getDecorView());
        Intrinsics.checkNotNullExpressionValue(insetsController, y.ݮڮֲڭܩ(-628756716));
        insetsController.hide(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars());
        insetsController.setSystemBarsBehavior(2);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        window4.addFlags(ownerActivity.getWindow().getAttributes().flags);
        if (Build.VERSION.SDK_INT >= 28) {
            Window window5 = getWindow();
            Intrinsics.checkNotNull(window5);
            window5.getAttributes().layoutInDisplayCutoutMode = this.displayCutoutMode;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        setMargin(DisplayUtil.checkCutout(ownerActivity));
        if (this.postData != null) {
            getWebView().postUrl(this.webUrl, this.postData);
            return;
        }
        if (this.settings.getRequestHeaders() == null) {
            getWebView().loadUrl(this.webUrl);
            return;
        }
        WebView webView = getWebView();
        String str = this.webUrl;
        Map<String, String> requestHeaders = this.settings.getRequestHeaders();
        Intrinsics.checkNotNull(requestHeaders);
        webView.loadUrl(str, requestHeaders);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.Animation.Dialog;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.addFlags(16777216);
        setCanceledOnTouchOutside(false);
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setBackgroundDrawable(new ColorDrawable(0));
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.web.WebDialog$$ExternalSyntheticLambda6
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$0;
                onCreate$lambda$0 = WebDialog.onCreate$lambda$0(WebDialog.this, dialogInterface, i, keyEvent);
                return onCreate$lambda$0;
            }
        });
        checkUIParameters(this.webUrl);
        initViews();
        setDialogVisibility();
        WebViewContainer webViewContainer = this.container;
        Intrinsics.checkNotNull(webViewContainer);
        webViewContainer.initCookies(getContext(), this.webUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean onCreate$lambda$0(WebDialog this$0, DialogInterface dialogInterface, int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 1 || i != 4) {
            return false;
        }
        WebViewContainer webViewContainer = this$0.container;
        Intrinsics.checkNotNull(webViewContainer);
        if (webViewContainer.hasInnerPopupView()) {
            WebViewContainer webViewContainer2 = this$0.container;
            Intrinsics.checkNotNull(webViewContainer2);
            webViewContainer2.goBackInnerPopupView();
            return true;
        }
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.ٲٴݴ״ٰ(1782572512) + this$0.getWebView().canGoBack());
        WebViewContainer webViewContainer3 = this$0.container;
        if (webViewContainer3 == null ? true : webViewContainer3 instanceof WebViewContainerImpl) {
            WebViewContainerImpl webViewContainerImpl = (WebViewContainerImpl) webViewContainer3;
            if ((webViewContainerImpl != null ? webViewContainerImpl.getCustomView() : null) != null) {
                WebViewContainer webViewContainer4 = this$0.container;
                if (webViewContainer4 != null) {
                    webViewContainer4.onHideCustomView();
                }
            } else if (this$0.getWebView().canGoBack()) {
                this$0.getWebView().goBack();
            } else if (this$0.settings.getCloseListener() != null) {
                OnCloseListener closeListener = this$0.settings.getCloseListener();
                if (closeListener != null) {
                    closeListener.onClose(this$0);
                }
            } else {
                this$0.dismiss();
            }
        } else {
            this$0.dismiss();
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.ݬֲ֮ܲت(1512384367));
        getWebView().onResume();
        getWebView().resumeTimers();
        KGActivityManager.INSTANCE.addConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.٬ݯح׭٩(576258342));
        getWebView().onPause();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.ݬֲ֮ܲت(1512380623));
        KGActivityManager.INSTANCE.removeConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void initViews() {
        View view;
        setContentView(getBinding().getRoot());
        ZinnySdkDialogWebKakaoBinding binding = getBinding();
        WebView webView = binding.zinnySdkDialogWebContent;
        Intrinsics.checkNotNullExpressionValue(webView, y.ݮڮֲڭܩ(-628487844));
        setWebView(webView);
        SwipeRefreshLayout swipeRefreshLayout = binding.zinnySdkDialogWebLayout;
        Intrinsics.checkNotNullExpressionValue(swipeRefreshLayout, y.دײܮڳܯ(2051489709));
        setWebLayout(swipeRefreshLayout);
        this.topbarView = binding.zinnySdkDialogWebTopbar;
        this.titleView = binding.zinnySdkDialogWebTopbarTitle;
        this.backView = binding.zinnySdkDialogWebTopbarBack;
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        RelativeLayout relativeLayout = binding.zinnySdkDialogWebMain;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, y.ۮڭڭܬި(862891371));
        handleKeyboardShowEvent(ownerActivity, relativeLayout);
        Activity ownerActivity2 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity2);
        setFocusChanged(ownerActivity2);
        if (this.settings.getBackgroundColor() != Integer.MAX_VALUE) {
            binding.zinnySdkDialogWebMain.setBackgroundColor(this.settings.getBackgroundColor());
        }
        getWebView().getSettings().setMixedContentMode(0);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(getWebView(), true);
        Activity ownerActivity3 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity3);
        createContainer(ownerActivity3, getWebView(), this.settings);
        if (!InfodeskHelper.INSTANCE.offWebViewPopupUI()) {
            if ((this.webUrl.length() > 0) && StringsKt.contains$default((CharSequence) this.webUrl, (CharSequence) y.ٲٴݴ״ٰ(1782578536), false, 2, (Object) null)) {
                WebSettings settings = getWebView().getSettings();
                Intrinsics.checkNotNullExpressionValue(settings, y.ۮڭڭܬި(862808243));
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setSupportMultipleWindows(true);
            }
        }
        View view2 = this.backView;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.web.WebDialog$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WebDialog.initViews$lambda$4$lambda$1(WebDialog.this, view3);
                }
            });
        }
        if (this.isPulltoRefresh) {
            getWebLayout().setEnabled(true);
            getWebLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.kakaogame.web.WebDialog$$ExternalSyntheticLambda2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    WebDialog.initViews$lambda$4$lambda$2(WebDialog.this);
                }
            });
        } else {
            getWebLayout().setEnabled(false);
        }
        binding.zinnySdkDialogWebTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.web.WebDialog$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WebDialog.initViews$lambda$4$lambda$3(WebDialog.this, view3);
            }
        });
        if (InfodeskHelper.INSTANCE.offWebviewTopBarYellow()) {
            ImageView imageView = binding.zinnySdkDialogWebTopbarCloseImage;
            Activity ownerActivity4 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity4);
            imageView.setImageDrawable(ResourceUtil.getDrawable(ownerActivity4, C2382R.drawable.ic_action_cancel_grey));
            ImageView imageView2 = binding.zinnySdkDialogWebTopbarPreviousImage;
            Activity ownerActivity5 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity5);
            imageView2.setImageDrawable(ResourceUtil.getDrawable(ownerActivity5, C2382R.drawable.ic_action_previous_item_grey));
            if (this.settings.getTitleBackgroundColor() != Integer.MAX_VALUE) {
                View view3 = this.topbarView;
                if (view3 != null) {
                    view3.setBackgroundColor(this.settings.getTitleBackgroundColor());
                }
            } else {
                int webviewTitleBgColor = InfodeskHelper.INSTANCE.webviewTitleBgColor();
                View view4 = this.topbarView;
                if (view4 != null) {
                    view4.setBackgroundColor(webviewTitleBgColor);
                }
            }
            if (this.settings.getTitleTextColor() != Integer.MAX_VALUE) {
                TextView textView = this.titleView;
                if (textView != null) {
                    textView.setTextColor(this.settings.getTitleTextColor());
                }
            } else {
                int webviewTitleTextColor = InfodeskHelper.INSTANCE.webviewTitleTextColor();
                TextView textView2 = this.titleView;
                if (textView2 != null) {
                    textView2.setTextColor(webviewTitleTextColor);
                }
            }
        }
        if (this.settings.isHideCloseButton()) {
            binding.zinnySdkDialogWebTopbarClose.setVisibility(8);
        }
        if ((this.hideTopbar || this.settings.isHideTopbar()) && (view = this.topbarView) != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$4$lambda$1(WebDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WebViewContainer webViewContainer = this$0.container;
        Intrinsics.checkNotNull(webViewContainer);
        if (webViewContainer.hasInnerPopupView()) {
            WebViewContainer webViewContainer2 = this$0.container;
            Intrinsics.checkNotNull(webViewContainer2);
            webViewContainer2.goBackInnerPopupView();
        } else {
            if (this$0.getWebView().canGoBack()) {
                this$0.getWebView().goBack();
                return;
            }
            View view2 = this$0.backView;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$4$lambda$2(WebDialog webDialog) {
        Intrinsics.checkNotNullParameter(webDialog, y.ٴسسݬߨ(1393322442));
        webDialog.getWebLayout().setRefreshing(true);
        webDialog.getWebView().reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$4$lambda$3(WebDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.settings.getCloseListener() != null) {
            OnCloseListener closeListener = this$0.settings.getCloseListener();
            Intrinsics.checkNotNull(closeListener);
            closeListener.onClose(this$0);
            return;
        }
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void createContainer(Activity activity, WebView webView, Settings settings) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        this.container = new WebViewContainerImpl(this, activity, webView, settings);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final boolean isTablet() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        float f = displayMetrics.density;
        float f2 = i;
        float f3 = i2;
        if (Math.min(f2 / f, f3 / f) >= 600.0f) {
            return true;
        }
        float f4 = f2 / displayMetrics.xdpi;
        float f5 = f3 / displayMetrics.ydpi;
        return Math.sqrt((double) ((f4 * f4) + (f5 * f5))) >= 7.0d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setMargin(int cutoutSize) {
        int i;
        RelativeLayout relativeLayout = getBinding().zinnySdkDialogWeb;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, y.ٲٴݴ״ٰ(1782578656));
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        Point currentWindowMetricsPointCompat = DisplayUtil.getCurrentWindowMetricsPointCompat(ownerActivity);
        int i2 = currentWindowMetricsPointCompat.y;
        int i3 = currentWindowMetricsPointCompat.x;
        Logger logger = Logger.INSTANCE;
        String str = y.ٴسسݬߨ(1393222610) + i3 + y.ݮڮֲڭܩ(-628176812) + i2;
        String str2 = y.ٴسسݬߨ(1393216610);
        logger.m699d(str2, str);
        if (this.settings.isCustomSize()) {
            Activity ownerActivity2 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity2);
            boolean isScreenPortrait = DisplayUtil.isScreenPortrait(ownerActivity2);
            int i4 = i2 / 100;
            int i5 = i4 * 3;
            int i6 = i3 / 100;
            int i7 = i6 * 3;
            if (this.settings.isMarginSet()) {
                i = i4 * this.settings.getVerticalMargin();
                int horizontalMargin = i6 * this.settings.getHorizontalMargin();
                if (isTablet()) {
                    i *= 4;
                    horizontalMargin *= 4;
                }
                i7 = horizontalMargin;
                Logger logger2 = Logger.INSTANCE;
                StringBuilder append = new StringBuilder(y.ۮڭڭܬި(862891107)).append(i);
                String str3 = y.ۮڭڭܬި(862891147);
                logger2.m699d(str2, append.append(str3).append(i7).toString());
                String str4 = y.֬ڱܱײٮ(-1159030007);
                String str5 = y.دײܮڳܯ(2051261637);
                if (isScreenPortrait) {
                    int i8 = i3 - (i7 * 2);
                    int height = (this.settings.getHeight(isScreenPortrait) * i8) / this.settings.getWidth(isScreenPortrait);
                    Logger.INSTANCE.m699d(str2, str5 + i8 + str4 + height);
                    if (i2 - (i * 2) > height) {
                        i = (i2 - height) / 2;
                    }
                    Logger.INSTANCE.m699d(str2, str5 + i8 + str4 + height);
                    Logger.INSTANCE.m699d(str2, y.֬ڱܱײٮ(-1159030239) + i + str3 + i7);
                } else {
                    int i9 = i2 - (i * 2);
                    int width = (this.settings.getWidth(isScreenPortrait) * i9) / this.settings.getHeight(isScreenPortrait);
                    if (i3 - (i7 * 2) > width) {
                        i7 = (i3 - width) / 2;
                    }
                    Logger.INSTANCE.m699d(str2, str5 + width + str4 + i9);
                    Logger.INSTANCE.m699d(str2, y.ݬֲ֮ܲت(1512303703) + i + str3 + i7);
                }
            } else {
                if (this.settings.getHeight(isScreenPortrait) > 0) {
                    Activity ownerActivity3 = getOwnerActivity();
                    Intrinsics.checkNotNull(ownerActivity3);
                    i5 = (i2 - ownerActivity3.getResources().getDimensionPixelSize(this.settings.getHeight(isScreenPortrait))) / 2;
                }
                if (this.settings.getWidth(isScreenPortrait) > 0) {
                    Activity ownerActivity4 = getOwnerActivity();
                    Intrinsics.checkNotNull(ownerActivity4);
                    int dimensionPixelSize = ownerActivity4.getResources().getDimensionPixelSize(this.settings.getWidth(isScreenPortrait));
                    if (dimensionPixelSize > i3) {
                        dimensionPixelSize = i3;
                    }
                    i7 = (i3 - dimensionPixelSize) / 2;
                }
                i = i5;
            }
            this.viewMargin = Math.min(i, i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(relativeLayout.getLayoutParams());
            marginLayoutParams.setMargins(i7, i, i7, i);
            relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(marginLayoutParams));
            return;
        }
        this.viewMargin = Math.min((i2 / 100) * 3, (i3 / 100) * 3);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(relativeLayout.getLayoutParams());
        Activity ownerActivity5 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity5);
        if (DisplayUtil.isScreenPortrait(ownerActivity5)) {
            int i10 = this.viewMargin;
            marginLayoutParams2.setMargins(i10, cutoutSize + i10, i10, i10);
        } else {
            Activity ownerActivity6 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity6);
            if (DisplayUtil.getLandscapeDirection(ownerActivity6) == 0) {
                int i11 = this.viewMargin;
                marginLayoutParams2.setMargins(cutoutSize + i11, i11, i11, i11);
            } else {
                Activity ownerActivity7 = getOwnerActivity();
                Intrinsics.checkNotNull(ownerActivity7);
                if (DisplayUtil.getLandscapeDirection(ownerActivity7) == 1) {
                    int i12 = this.viewMargin;
                    marginLayoutParams2.setMargins(i12, i12, cutoutSize + i12, i12);
                }
            }
        }
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(marginLayoutParams2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.ٲٴݴ״ٰ(1782131848) + newConfig.orientation + y.ݮڮֲڭܩ(-628606940) + this.preOrientation);
        if (this.preOrientation < 0 || newConfig.orientation != this.preOrientation || this.preScreenLayout < 0 || newConfig.screenLayout != this.preScreenLayout) {
            Activity ownerActivity = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity);
            int checkCutout = DisplayUtil.checkCutout(ownerActivity);
            setDialogVisibility();
            setMargin(checkCutout);
        }
        this.preOrientation = newConfig.orientation;
        this.preScreenLayout = newConfig.screenLayout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void checkUIParameters(String url) {
        boolean parseBoolean;
        boolean parseBoolean2;
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, y.֬ڱܱײٮ(-1158775023));
        String lowerCase = url.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, y.ݮڮֲڭܩ(-628797244));
        Uri parse = Uri.parse(lowerCase);
        String queryParameter = parse.getQueryParameter(y.٬ݯح׭٩(576260838));
        if (TextUtils.isEmpty(queryParameter)) {
            parseBoolean = this.settings.isPulltoRefresh();
        } else {
            parseBoolean = Boolean.parseBoolean(queryParameter);
        }
        this.isPulltoRefresh = parseBoolean;
        String queryParameter2 = parse.getQueryParameter(y.دײܮڳܯ(2051263805));
        if (TextUtils.isEmpty(queryParameter2)) {
            parseBoolean2 = this.settings.isHideTopbar();
        } else {
            parseBoolean2 = Boolean.parseBoolean(queryParameter2);
        }
        this.hideTopbar = parseBoolean2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void hideTopbar() {
        this.hideTopbar = true;
        this.settings.hideTopbar();
        View view = this.topbarView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setFocusChanged(Activity act) {
        View decorView = act.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, y.ٲٴݴ״ٰ(1782133032));
        decorView.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.kakaogame.web.WebDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public final void onWindowFocusChanged(boolean z) {
                WebDialog.setFocusChanged$lambda$5(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void setFocusChanged$lambda$5(boolean z) {
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.ٴسسݬߨ(1393216234).concat(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void handleKeyboardShowEvent(final Activity act, final View contentView) {
        Intrinsics.checkNotNullParameter(act, y.ٴسسݬߨ(1393216402));
        Intrinsics.checkNotNullParameter(contentView, y.ٴسسݬߨ(1393216426));
        if (Build.VERSION.SDK_INT >= 30) {
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            ViewCompat.setOnApplyWindowInsetsListener(window.getDecorView(), new OnApplyWindowInsetsListener() { // from class: com.kakaogame.web.WebDialog$$ExternalSyntheticLambda4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    WindowInsetsCompat handleKeyboardShowEvent$lambda$6;
                    handleKeyboardShowEvent$lambda$6 = WebDialog.handleKeyboardShowEvent$lambda$6(contentView, this, view, windowInsetsCompat);
                    return handleKeyboardShowEvent$lambda$6;
                }
            });
        } else {
            Window window2 = act.getWindow();
            Intrinsics.checkNotNull(window2);
            final View decorView = window2.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, y.ٲٴݴ״ٰ(1782133032));
            decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kakaogame.web.WebDialog$$ExternalSyntheticLambda5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public final void onGlobalLayout() {
                    WebDialog.handleKeyboardShowEvent$lambda$7(decorView, act, this, contentView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final WindowInsetsCompat handleKeyboardShowEvent$lambda$6(View view, WebDialog webDialog, View view2, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, y.ݮڮֲڭܩ(-628163604));
        Intrinsics.checkNotNullParameter(webDialog, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(view2, y.٬ݯح׭٩(576261150));
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.ime() | WindowInsetsCompat.Type.navigationBars());
        Intrinsics.checkNotNullExpressionValue(insets2, y.٬ݯح׭٩(576285454));
        if (insets2.bottom > 0) {
            view.setPadding(0, 0, 0, insets2.bottom - webDialog.viewMargin);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        Logger.INSTANCE.m699d(TAG, y.ݮڮֲڭܩ(-628163420) + insets2.bottom + y.ݮڮֲڭܩ(-628163124) + webDialog.viewMargin);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void handleKeyboardShowEvent$lambda$7(View view, Activity activity, WebDialog webDialog, View view2) {
        String str = y.ݬֲ֮ܲت(1513068719);
        String str2 = y.ٴسسݬߨ(1393216610);
        Intrinsics.checkNotNullParameter(view, y.ݮڮֲڭܩ(-628162956));
        Intrinsics.checkNotNullParameter(activity, y.دײܮڳܯ(2051262709));
        Intrinsics.checkNotNullParameter(webDialog, y.ٴسسݬߨ(1393322442));
        Intrinsics.checkNotNullParameter(view2, y.ݮڮֲڭܩ(-628163604));
        try {
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            int displayHeight = DisplayUtil.getDisplayHeight(activity);
            if (Build.VERSION.SDK_INT >= 28) {
                displayHeight -= DisplayUtil.INSTANCE.getNavigationBarHeight(activity) + DisplayUtil.INSTANCE.getStatusBarHeight2(activity);
            }
            int i = displayHeight - rect.bottom;
            Logger.INSTANCE.m699d(str2, displayHeight + str + rect.bottom + str + i);
            if (i <= 0) {
                webDialog.setDialogVisibility();
            }
            if (i > 0) {
                if (view2.getPaddingBottom() != i) {
                    view2.setPadding(0, 0, 0, i - webDialog.viewMargin);
                }
            } else if (view2.getPaddingBottom() != 0) {
                view2.setPadding(0, 0, 0, 0);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void changeTitleText(String url) {
        TextView textView;
        String queryParameter = Uri.parse(url).getQueryParameter(y.ٲٴݴ״ٰ(1781623336));
        if (TextUtils.isEmpty(queryParameter) || (textView = this.titleView) == null) {
            return;
        }
        textView.setText(queryParameter);
    }

    /* compiled from: WebDialog.kt */
    @Metadata(m838d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0094\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J0\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u001c\u0010!\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u001c\u0010\"\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u001dH\u0014J\u001c\u0010$\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010&\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$WebViewContainerImpl;", "Lcom/kakaogame/web/WebViewContainer;", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Lcom/kakaogame/web/WebDialog;Landroid/app/Activity;Landroid/webkit/WebView;Lcom/kakaogame/web/WebDialog$Settings;)V", "customView", "Landroid/view/View;", "getCustomView", "()Landroid/view/View;", "setCustomView", "(Landroid/view/View;)V", "customViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "customViewContainer", "Landroid/view/ViewGroup;", "layoutParameters", "Landroid/widget/FrameLayout$LayoutParams;", "lock", "", "onHideCustomView", "", "onJsAlert", "", ViewHierarchyConstants.VIEW_KEY, "url", "", "message", "result", "Landroid/webkit/JsResult;", "onPageFinished", "onReceivedTitle", "title", "onShowCustomView", "callback", "shouldOverrideUrlLoading", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    protected class WebViewContainerImpl extends WebViewContainer {
        private View customView;
        private WebChromeClient.CustomViewCallback customViewCallback;
        private ViewGroup customViewContainer;
        private final FrameLayout.LayoutParams layoutParameters;
        private final Object lock;
        final /* synthetic */ WebDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public WebViewContainerImpl(WebDialog webDialog, Activity activity, WebView webView, Settings settings) {
            super(activity, webView, settings.getCustomCookie(), settings.getCookieExcludeOption());
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
            Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
            this.this$0 = webDialog;
            this.lock = new Object();
            this.layoutParameters = new FrameLayout.LayoutParams(-1, -1, 17);
            if (settings.isFixedTextFontSize()) {
                webView.getSettings().setTextZoom(100);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final View getCustomView() {
            return this.customView;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setCustomView(View view) {
            this.customView = view;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onReceivedTitle(WebView view, String title) {
            TextView titleView = this.this$0.getTitleView();
            if (TextUtils.isEmpty(titleView != null ? titleView.getText() : null)) {
                if (this.this$0.settings.isFixedTitle()) {
                    String title2 = this.this$0.settings.getTitle();
                    if (TextUtils.isEmpty(title2)) {
                        title2 = view != null ? view.getTitle() : null;
                    }
                    TextView titleView2 = this.this$0.getTitleView();
                    if (titleView2 == null) {
                        return;
                    }
                    titleView2.setText(title2);
                    return;
                }
                TextView titleView3 = this.this$0.getTitleView();
                if (titleView3 == null) {
                    return;
                }
                titleView3.setText(view != null ? view.getTitle() : null);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected boolean shouldOverrideUrlLoading(WebView view, String url) {
            Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.ݮڮֲڭܩ(-628484836) + url);
            if (url == null) {
                return true;
            }
            if (DeepLinkManager.INSTANCE.isDeepLink(url)) {
                this.this$0.deepLinkUrl = url;
                this.this$0.dismiss();
                return true;
            }
            if (DeepLinkManager.INSTANCE.isPlatformDeepLink(url)) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WebDialog$WebViewContainerImpl$shouldOverrideUrlLoading$1(this, url, null), 3, null);
                return true;
            }
            if (StringsKt.equals(url, y.֬ڱܱײٮ(-1158775207), true)) {
                this.this$0.dismiss();
                return true;
            }
            if (StringsKt.startsWith$default(url, y.٬ݯح׭٩(576260486), false, 2, (Object) null)) {
                this.this$0.changeTitleText(url);
                return true;
            }
            if (StringsKt.startsWith$default(url, y.ٲٴݴ״ٰ(1782267112), false, 2, (Object) null)) {
                AppUtil.launchIntent(getActivity(), url);
                return true;
            }
            boolean startsWith$default = StringsKt.startsWith$default(url, y.ݮڮֲڭܩ(-628164052), false, 2, (Object) null);
            String str = y.٬ݯح׭٩(576051006);
            if (startsWith$default) {
                try {
                    Intent parseUri = Intent.parseUri(url, 1);
                    if (parseUri != null && ((Intrinsics.areEqual(parseUri.getScheme(), "https") || Intrinsics.areEqual(parseUri.getScheme(), str)) && parseUri.getAction() != null)) {
                        String action = parseUri.getAction();
                        Intrinsics.checkNotNull(action);
                        if (StringsKt.contains$default((CharSequence) action, (CharSequence) ShareConstants.CONTENT_URL, false, 2, (Object) null)) {
                            String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                            if (view != null) {
                                Intrinsics.checkNotNull(stringExtra);
                                view.loadUrl(stringExtra);
                            }
                            return true;
                        }
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            if (WebViewContainer.INSTANCE.handleCustomScheme(getActivity(), url)) {
                this.this$0.dismiss();
                return true;
            }
            if (StringsKt.startsWith$default(url, str, false, 2, (Object) null) || StringsKt.startsWith$default(url, y.ݬֲ֮ܲت(1512166159), false, 2, (Object) null)) {
                return super.shouldOverrideUrlLoading(view, url);
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected void onPageFinished(WebView view, String url) {
            if (this.this$0.getWebLayout().isRefreshing()) {
                this.this$0.getWebLayout().setRefreshing(false);
            }
            if (this.this$0.backView != null && view != null) {
                if (view.canGoBack()) {
                    View view2 = this.this$0.backView;
                    if (view2 != null) {
                        view2.setVisibility(0);
                    }
                    if (this.this$0.logoView != null) {
                        View view3 = this.this$0.logoView;
                        Intrinsics.checkNotNull(view3);
                        view3.setVisibility(8);
                    }
                } else {
                    View view4 = this.this$0.backView;
                    if (view4 != null) {
                        view4.setVisibility(8);
                    }
                    if (this.this$0.logoView != null) {
                        View view5 = this.this$0.logoView;
                        Intrinsics.checkNotNull(view5);
                        view5.setVisibility(0);
                    }
                }
            }
            if (this.this$0.settings.isFixedTitle()) {
                String title = this.this$0.settings.getTitle();
                if (TextUtils.isEmpty(title)) {
                    title = view != null ? view.getTitle() : null;
                }
                TextView titleView = this.this$0.getTitleView();
                if (titleView == null) {
                    return;
                }
                titleView.setText(title);
                return;
            }
            TextView titleView2 = this.this$0.getTitleView();
            if (titleView2 == null) {
                return;
            }
            titleView2.setText(view != null ? view.getTitle() : null);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.ۮڭڭܬި(862888979));
            Object obj = this.lock;
            WebDialog webDialog = this.this$0;
            synchronized (obj) {
                if (this.customView != null) {
                    if (callback != null) {
                        callback.onCustomViewHidden();
                    }
                    return;
                }
                if (this.customViewContainer == null) {
                    View findViewById = webDialog.findViewById(C2382R.id.zinny_sdk_dialog_web_custom_container);
                    Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
                    ViewGroup viewGroup = (ViewGroup) findViewById;
                    this.customViewContainer = viewGroup;
                    Intrinsics.checkNotNull(viewGroup);
                    viewGroup.setBackgroundResource(R.color.black);
                }
                if (view != null) {
                    view.setLayoutParams(this.layoutParameters);
                }
                if (view != null) {
                    view.setBackgroundResource(R.color.black);
                }
                this.customView = view;
                this.customViewCallback = callback;
                ViewGroup viewGroup2 = this.customViewContainer;
                Intrinsics.checkNotNull(viewGroup2);
                viewGroup2.addView(this.customView);
                ViewGroup viewGroup3 = this.customViewContainer;
                Intrinsics.checkNotNull(viewGroup3);
                viewGroup3.setVisibility(0);
                Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
                loadAnimation.setStartOffset(200L);
                loadAnimation.setDuration(500L);
                View view2 = this.customView;
                Intrinsics.checkNotNull(view2);
                view2.startAnimation(loadAnimation);
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        public void onHideCustomView() {
            Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393216610), y.֬ڱܱײٮ(-1159032407));
            synchronized (this.lock) {
                View view = this.customView;
                if (view == null) {
                    return;
                }
                Intrinsics.checkNotNull(view);
                view.setVisibility(8);
                ViewGroup viewGroup = this.customViewContainer;
                Intrinsics.checkNotNull(viewGroup);
                viewGroup.removeView(this.customView);
                Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
                loadAnimation.setStartOffset(0L);
                loadAnimation.setDuration(500L);
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.kakaogame.web.WebDialog$WebViewContainerImpl$onHideCustomView$1$1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation arg0) {
                        Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation arg0) {
                        Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation arg0) {
                        ViewGroup viewGroup2;
                        Intrinsics.checkNotNullParameter(arg0, y.ٴسسݬߨ(1392632554));
                        viewGroup2 = WebDialog.WebViewContainerImpl.this.customViewContainer;
                        Intrinsics.checkNotNull(viewGroup2);
                        viewGroup2.setVisibility(8);
                    }
                });
                ViewGroup viewGroup2 = this.customViewContainer;
                Intrinsics.checkNotNull(viewGroup2);
                viewGroup2.startAnimation(loadAnimation);
                WebChromeClient.CustomViewCallback customViewCallback = this.customViewCallback;
                Intrinsics.checkNotNull(customViewCallback);
                customViewCallback.onCustomViewHidden();
                this.customView = null;
                this.customViewCallback = null;
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebViewContainer
        protected boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            DialogManager.Settings settings = new DialogManager.Settings(null, null, message, null, null, null, null, null, false, null, null, null, null, 8187, null);
            settings.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.kakaogame.web.WebDialog$WebViewContainerImpl$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    WebDialog.WebViewContainerImpl.onJsAlert$lambda$2(result, dialogInterface, i);
                }
            });
            DialogManager.INSTANCE.showAlertDialog(getActivity(), settings);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void onJsAlert$lambda$2(JsResult jsResult, DialogInterface dialogInterface, int i) {
            if (jsResult != null) {
                jsResult.confirm();
            }
            dialogInterface.dismiss();
        }
    }

    /* compiled from: WebDialog.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$SelectImageHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "(Lcom/kakaogame/web/WebDialog;)V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private final class SelectImageHandler extends WebAppProtocolHandler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SelectImageHandler() {
            super("selectImage");
            setWebAppProtocolHandler();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
        protected String handleInternal(WebView webView, Uri webUri) {
            WebDialog webDialog = WebDialog.this;
            Activity ownerActivity = webDialog.getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity);
            final WebDialog webDialog2 = WebDialog.this;
            webDialog.checkRequiredPermission(ownerActivity, y.֬ڱܱײٮ(-1159024895), new KGResultCallback<Boolean>() { // from class: com.kakaogame.web.WebDialog$SelectImageHandler$handleInternal$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<Boolean> result) {
                    if (result != null && result.isSuccess() && Intrinsics.areEqual((Object) result.getContent(), (Object) true)) {
                        Intent intent = new Intent(y.دײܮڳܯ(2051273573), MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType(y.ݬֲ֮ܲت(1512299119));
                        Activity ownerActivity2 = WebDialog.this.getOwnerActivity();
                        Intrinsics.checkNotNull(ownerActivity2);
                        ownerActivity2.startActivityForResult(intent, 999);
                    }
                }
            });
            return null;
        }
    }

    /* compiled from: WebDialog.kt */
    @Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$MakeShortcutHandler;", "Lcom/kakaogame/web/protocol/WebAppProtocolHandler;", "(Lcom/kakaogame/web/WebDialog;)V", "handleInternal", "", "webView", "Landroid/webkit/WebView;", "webUri", "Landroid/net/Uri;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    private final class MakeShortcutHandler extends WebAppProtocolHandler {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MakeShortcutHandler() {
            super("makeShortcut");
            setWebAppProtocolHandler();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.protocol.WebAppProtocolHandler
        protected String handleInternal(WebView webView, final Uri webUri) {
            WebDialog webDialog = WebDialog.this;
            Activity ownerActivity = webDialog.getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity);
            final WebDialog webDialog2 = WebDialog.this;
            webDialog.checkRequiredPermission(ownerActivity, "com.android.launcher.permission.INSTALL_SHORTCUT", new KGResultCallback<Boolean>() { // from class: com.kakaogame.web.WebDialog$MakeShortcutHandler$handleInternal$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<Boolean> result) {
                    if (result != null && result.isSuccess() && Intrinsics.areEqual((Object) result.getContent(), (Object) true)) {
                        Uri uri = webUri;
                        String queryParameter = uri != null ? uri.getQueryParameter(y.ۮڭڭܬި(862392755)) : null;
                        Uri uri2 = webUri;
                        String queryParameter2 = uri2 != null ? uri2.getQueryParameter(y.ٲٴݴ״ٰ(1781623336)) : null;
                        Uri uri3 = webUri;
                        String queryParameter3 = uri3 != null ? uri3.getQueryParameter(y.ݮڮֲڭܩ(-628177764)) : null;
                        if (queryParameter == null || queryParameter2 == null || queryParameter3 == null) {
                            return;
                        }
                        KGApplication kGApplication = KGApplication.INSTANCE;
                        Activity ownerActivity2 = webDialog2.getOwnerActivity();
                        Intrinsics.checkNotNull(ownerActivity2);
                        kGApplication.addShortcut(ownerActivity2, queryParameter, queryParameter2, queryParameter3);
                    }
                }
            });
            return null;
        }
    }

    /* compiled from: WebDialog.kt */
    @Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003<=>B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0019J\u000e\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0019J\u0006\u0010:\u001a\u00020;R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R>\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020(@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R:\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0016R\"\u0010.\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001e\u00101\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u001e\u00103\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u001e\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007¨\u0006?"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$Settings;", "", "()V", "<set-?>", "", "backgroundColor", "getBackgroundColor", "()I", "Lcom/kakaogame/web/WebDialog$Settings$CloseButtonColor;", "closeButtonColor", "getCloseButtonColor", "()Lcom/kakaogame/web/WebDialog$Settings$CloseButtonColor;", "Lcom/kakaogame/web/WebDialog$OnCloseListener;", "closeListener", "getCloseListener", "()Lcom/kakaogame/web/WebDialog$OnCloseListener;", "cookieExcludeOption", "getCookieExcludeOption", "", "", "customCookie", "getCustomCookie", "()Ljava/util/Map;", "horizontalMargin", "getHorizontalMargin", "", "isCustomSize", "()Z", "isFixedTextFontSize", "isFixedTitle", "isHideCloseButton", "isHideTopbar", "isMarginSet", "isPulltoRefresh", "setPulltoRefresh", "(Z)V", "land_height", "land_width", "port_height", "port_width", "Lcom/kakaogame/web/WebDialog$Settings$PreviousButtonColor;", "previousButtonColor", "getPreviousButtonColor", "()Lcom/kakaogame/web/WebDialog$Settings$PreviousButtonColor;", "requestHeaders", "getRequestHeaders", "title", "getTitle", "()Ljava/lang/String;", "titleBackgroundColor", "getTitleBackgroundColor", "titleTextColor", "getTitleTextColor", "verticalMargin", "getVerticalMargin", "getHeight", "isPortrait", "getWidth", "hideTopbar", "", "Builder", "CloseButtonColor", "PreviousButtonColor", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Settings {
        private OnCloseListener closeListener;
        private int cookieExcludeOption;
        private Map<String, ? extends Object> customCookie;
        private int horizontalMargin;
        private boolean isCustomSize;
        private boolean isFixedTextFontSize;
        private boolean isFixedTitle;
        private boolean isHideCloseButton;
        private boolean isHideTopbar;
        private int land_height;
        private int land_width;
        private int port_height;
        private int port_width;
        private Map<String, String> requestHeaders;
        private String title;
        private int verticalMargin;
        private boolean isPulltoRefresh = true;
        private int backgroundColor = Integer.MAX_VALUE;
        private int titleBackgroundColor = Integer.MAX_VALUE;
        private int titleTextColor = Integer.MAX_VALUE;
        private CloseButtonColor closeButtonColor = CloseButtonColor.BLACK;
        private PreviousButtonColor previousButtonColor = PreviousButtonColor.BLACK;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getTitle() {
            return this.title;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getVerticalMargin() {
            return this.verticalMargin;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getHorizontalMargin() {
            return this.horizontalMargin;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isFixedTitle() {
            return this.isFixedTitle;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isCustomSize() {
            return this.isCustomSize;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isPulltoRefresh() {
            return this.isPulltoRefresh;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setPulltoRefresh(boolean z) {
            this.isPulltoRefresh = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isFixedTextFontSize() {
            return this.isFixedTextFontSize;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isHideTopbar() {
            return this.isHideTopbar;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isHideCloseButton() {
            return this.isHideCloseButton;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final OnCloseListener getCloseListener() {
            return this.closeListener;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, String> getRequestHeaders() {
            return this.requestHeaders;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Map<String, Object> getCustomCookie() {
            return this.customCookie;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getCookieExcludeOption() {
            return this.cookieExcludeOption;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getBackgroundColor() {
            return this.backgroundColor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTitleBackgroundColor() {
            return this.titleBackgroundColor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getTitleTextColor() {
            return this.titleTextColor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final CloseButtonColor getCloseButtonColor() {
            return this.closeButtonColor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final PreviousButtonColor getPreviousButtonColor() {
            return this.previousButtonColor;
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: WebDialog.kt */
        @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$Settings$CloseButtonColor;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "BLACK", "GREY", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class CloseButtonColor {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ CloseButtonColor[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE;
            private final String value;
            public static final CloseButtonColor BLACK = new CloseButtonColor(y.ݮڮֲڭܩ(-628763188), 0, y.دײܮڳܯ(2051597077));
            public static final CloseButtonColor GREY = new CloseButtonColor(y.֬ڱܱײٮ(-1159032527), 1, y.ٴسسݬߨ(1393064434));

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private static final /* synthetic */ CloseButtonColor[] $values() {
                return new CloseButtonColor[]{BLACK, GREY};
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumEntries<CloseButtonColor> getEntries() {
                return $ENTRIES;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static CloseButtonColor valueOf(String str) {
                return (CloseButtonColor) Enum.valueOf(CloseButtonColor.class, str);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static CloseButtonColor[] values() {
                return (CloseButtonColor[]) $VALUES.clone();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private CloseButtonColor(String str, int i, String str2) {
                this.value = str2;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            static {
                CloseButtonColor[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
                INSTANCE = new Companion(null);
            }

            /* compiled from: WebDialog.kt */
            @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$Settings$CloseButtonColor$Companion;", "", "()V", "get", "Lcom/kakaogame/web/WebDialog$Settings$CloseButtonColor;", "name", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
            public static final class Companion {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Companion() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public final CloseButtonColor get(String name) {
                    if (!StringsKt.equals(CloseButtonColor.BLACK.value, name, true)) {
                        if (StringsKt.equals(CloseButtonColor.GREY.value, name, true)) {
                            return CloseButtonColor.GREY;
                        }
                        return CloseButtonColor.BLACK;
                    }
                    return CloseButtonColor.BLACK;
                }
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: WebDialog.kt */
        @Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$Settings$PreviousButtonColor;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "BLACK", "GREY", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class PreviousButtonColor {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ PreviousButtonColor[] $VALUES;

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE;
            private final String value;
            public static final PreviousButtonColor BLACK = new PreviousButtonColor(y.ݮڮֲڭܩ(-628763188), 0, y.دײܮڳܯ(2051597077));
            public static final PreviousButtonColor GREY = new PreviousButtonColor(y.֬ڱܱײٮ(-1159032527), 1, y.ٴسسݬߨ(1393064434));

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private static final /* synthetic */ PreviousButtonColor[] $values() {
                return new PreviousButtonColor[]{BLACK, GREY};
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static EnumEntries<PreviousButtonColor> getEntries() {
                return $ENTRIES;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static PreviousButtonColor valueOf(String str) {
                return (PreviousButtonColor) Enum.valueOf(PreviousButtonColor.class, str);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public static PreviousButtonColor[] values() {
                return (PreviousButtonColor[]) $VALUES.clone();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private PreviousButtonColor(String str, int i, String str2) {
                this.value = str2;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            static {
                PreviousButtonColor[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
                INSTANCE = new Companion(null);
            }

            /* compiled from: WebDialog.kt */
            @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¨\u0006\u0007"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$Settings$PreviousButtonColor$Companion;", "", "()V", "get", "Lcom/kakaogame/web/WebDialog$Settings$PreviousButtonColor;", "name", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
            public static final class Companion {
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                private Companion() {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                public final PreviousButtonColor get(String name) {
                    if (!StringsKt.equals(PreviousButtonColor.BLACK.value, name, true)) {
                        if (StringsKt.equals(PreviousButtonColor.GREY.value, name, true)) {
                            return PreviousButtonColor.GREY;
                        }
                        return PreviousButtonColor.BLACK;
                    }
                    return PreviousButtonColor.BLACK;
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getWidth(boolean isPortrait) {
            if (isPortrait) {
                return this.port_width;
            }
            return this.land_width;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getHeight(boolean isPortrait) {
            if (isPortrait) {
                return this.port_height;
            }
            return this.land_height;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void hideTopbar() {
            this.isHideTopbar = true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isMarginSet() {
            return this.verticalMargin > 0 && this.horizontalMargin > 0;
        }

        /* compiled from: WebDialog.kt */
        @Metadata(m838d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nJ\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\u00002\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0000J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0013J\u0016\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bJ\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u001eJ\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0013J\u001a\u0010!\u001a\u00020\u00002\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0010J&\u0010#\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bJ\u0010\u0010&\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010)\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010*\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, m839d2 = {"Lcom/kakaogame/web/WebDialog$Settings$Builder;", "", "()V", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "build", "setBackgroundColor", TypedValues.Custom.S_COLOR, "", "setCloseButtonColor", "Lcom/kakaogame/web/WebDialog$Settings$CloseButtonColor;", "", "setCookieExcludeOption", "cookieExcludeOption", "setCustomCookie", "customCookie", "", "setFixedFontSize", "isFixed", "", "setFixedTitle", "setHideCloseButton", "hideCloseButton", "setHideTopBar", "hideTopBar", "setLandSize", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setPortSize", "setPreviousButtonColor", "Lcom/kakaogame/web/WebDialog$Settings$PreviousButtonColor;", "setPulltoRefresh", "pulltoRefresh", "setRequestHeaders", "requestHeaders", "setSizeWithMargin", "verticalMargin", "horizontalMargin", "setTitle", "title", "setTitleBackgroundColor", "setTitleTextColor", "setViewCloseListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/kakaogame/web/WebDialog$OnCloseListener;", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
        public static final class Builder {
            private final Settings settings = new Settings();

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setTitle(String title) {
                this.settings.title = title;
                this.settings.isFixedTitle = true;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setFixedTitle() {
                this.settings.isFixedTitle = true;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setPortSize(int width, int height) {
                this.settings.port_width = width;
                this.settings.port_height = height;
                this.settings.isCustomSize = true;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setLandSize(int width, int height) {
                this.settings.land_width = width;
                this.settings.land_height = height;
                this.settings.isCustomSize = true;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setSizeWithMargin(int width, int height, int verticalMargin, int horizontalMargin) {
                if (width > height) {
                    this.settings.land_width = width;
                    this.settings.land_height = height;
                    this.settings.port_width = height;
                    this.settings.port_height = width;
                } else {
                    this.settings.land_width = height;
                    this.settings.land_height = width;
                    this.settings.port_width = width;
                    this.settings.port_height = height;
                }
                this.settings.verticalMargin = verticalMargin;
                this.settings.horizontalMargin = horizontalMargin;
                this.settings.isCustomSize = true;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setPulltoRefresh(boolean pulltoRefresh) {
                this.settings.setPulltoRefresh(pulltoRefresh);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setViewCloseListener(OnCloseListener listener) {
                this.settings.closeListener = listener;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setRequestHeaders(Map<String, String> requestHeaders) {
                Intrinsics.checkNotNullParameter(requestHeaders, y.֬ڱܱײٮ(-1159024975));
                this.settings.requestHeaders = requestHeaders;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setCustomCookie(Map<String, ? extends Object> customCookie) {
                this.settings.customCookie = customCookie;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setCookieExcludeOption(int cookieExcludeOption) {
                this.settings.cookieExcludeOption = cookieExcludeOption;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setBackgroundColor(int color) {
                this.settings.backgroundColor = color;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setTitleBackgroundColor(int color) {
                this.settings.titleBackgroundColor = color;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setTitleTextColor(int color) {
                this.settings.titleTextColor = color;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setFixedFontSize(boolean isFixed) {
                this.settings.isFixedTextFontSize = isFixed;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setHideTopBar(boolean hideTopBar) {
                this.settings.isHideTopbar = hideTopBar;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setHideCloseButton(boolean hideCloseButton) {
                this.settings.isHideCloseButton = hideCloseButton;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setCloseButtonColor(CloseButtonColor color) {
                Intrinsics.checkNotNullParameter(color, y.ݮڮֲڭܩ(-628760828));
                this.settings.closeButtonColor = color;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setPreviousButtonColor(PreviousButtonColor color) {
                Intrinsics.checkNotNullParameter(color, y.ݮڮֲڭܩ(-628760828));
                this.settings.previousButtonColor = color;
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setCloseButtonColor(String color) {
                this.settings.closeButtonColor = CloseButtonColor.INSTANCE.get(color);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Builder setPreviousButtonColor(String color) {
                this.settings.previousButtonColor = PreviousButtonColor.INSTANCE.get(color);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public final Settings build() {
                return this.settings;
            }
        }
    }
}
