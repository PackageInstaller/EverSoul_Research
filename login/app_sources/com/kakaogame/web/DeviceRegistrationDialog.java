package com.kakaogame.web;

import android.R;
import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakaogame.C2382R;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.core.CoreManager;
import com.kakaogame.security.ProtectionManager;
import com.kakaogame.web.WebDialog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeviceRegistrationDialog.kt */
@Metadata(m838d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\"\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m839d2 = {"Lcom/kakaogame/web/DeviceRegistrationDialog;", "Lcom/kakaogame/web/WebDialog;", "activity", "Landroid/app/Activity;", "webUrl", "", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "callback", "Lkotlin/Function1;", "Lcom/kakaogame/KGResult;", "", "(Landroid/app/Activity;Ljava/lang/String;Lcom/kakaogame/web/WebDialog$Settings;Lkotlin/jvm/functions/Function1;)V", "createContainer", "webView", "Landroid/webkit/WebView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setDialogVisibility", "Companion", "DeviceRegistrationViewContainerImpl", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class DeviceRegistrationDialog extends WebDialog {
    private static final String TAG = "DeviceRegistrationDialog";
    private static final String closeWebAppProtocol = "zinny://closeview";
    private static final String responseWebAppProtocol = "zinny://registerDevice";
    private final Function1<KGResult<String>, Unit> callback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DeviceRegistrationDialog(Activity activity, String str, WebDialog.Settings settings, Function1<? super KGResult<String>, Unit> function1) {
        super(activity, str, settings);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(str, y.دײܮڳܯ(2051274949));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        Intrinsics.checkNotNullParameter(function1, y.֬ڱܱײٮ(-1159472767));
        this.callback = function1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog, android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.getAttributes().windowAnimations = R.style.Animation.Dialog;
            window.setFlags(1024, 1024);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        setCanceledOnTouchOutside(false);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.web.DeviceRegistrationDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$1;
                onCreate$lambda$1 = DeviceRegistrationDialog.onCreate$lambda$1(DeviceRegistrationDialog.this, dialogInterface, i, keyEvent);
                return onCreate$lambda$1;
            }
        });
        initViews();
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        setDialogVisibility(ownerActivity);
        findViewById(C2382R.id.zinny_sdk_dialog_web_topbar_close).setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.web.DeviceRegistrationDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceRegistrationDialog.onCreate$lambda$2(DeviceRegistrationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean onCreate$lambda$1(DeviceRegistrationDialog this$0, DialogInterface dialogInterface, int i, KeyEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 1 || i != 4) {
            return false;
        }
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051275605), y.ٲٴݴ״ٰ(1782572512) + this$0.getWebView().canGoBack());
        if (this$0.getWebView().canGoBack()) {
            this$0.getWebView().goBack();
        } else {
            this$0.callback.invoke(KGResult.INSTANCE.getSuccessResult());
            this$0.dismiss();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onCreate$lambda$2(DeviceRegistrationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callback.invoke(KGResult.INSTANCE.getSuccessResult());
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setDialogVisibility(Activity activity) {
        if (Build.VERSION.SDK_INT >= 30) {
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            window.setDecorFitsSystemWindows(false);
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            window2.getAttributes().layoutInDisplayCutoutMode = getDisplayCutoutMode();
            return;
        }
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        View decorView = window3.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, y.ٲٴݴ״ٰ(1782133032));
        decorView.setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() | 5894);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.addFlags(activity.getWindow().getAttributes().flags);
        if (Build.VERSION.SDK_INT >= 28) {
            Window window5 = getWindow();
            Intrinsics.checkNotNull(window5);
            window5.getAttributes().layoutInDisplayCutoutMode = getDisplayCutoutMode();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.web.WebDialog
    protected void createContainer(Activity activity, WebView webView, WebDialog.Settings settings) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
        Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
        this.container = new DeviceRegistrationViewContainerImpl(this, activity, webView, settings);
    }

    /* compiled from: DeviceRegistrationDialog.kt */
    @Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0084\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014¨\u0006\u000f"}, m839d2 = {"Lcom/kakaogame/web/DeviceRegistrationDialog$DeviceRegistrationViewContainerImpl;", "Lcom/kakaogame/web/WebDialog$WebViewContainerImpl;", "Lcom/kakaogame/web/WebDialog;", "activity", "Landroid/app/Activity;", "webView", "Landroid/webkit/WebView;", "settings", "Lcom/kakaogame/web/WebDialog$Settings;", "(Lcom/kakaogame/web/DeviceRegistrationDialog;Landroid/app/Activity;Landroid/webkit/WebView;Lcom/kakaogame/web/WebDialog$Settings;)V", "shouldOverrideUrlLoading", "", ViewHierarchyConstants.VIEW_KEY, "url", "", "security_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    protected final class DeviceRegistrationViewContainerImpl extends WebDialog.WebViewContainerImpl {
        final /* synthetic */ DeviceRegistrationDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public DeviceRegistrationViewContainerImpl(DeviceRegistrationDialog deviceRegistrationDialog, Activity activity, WebView webView, WebDialog.Settings settings) {
            super(deviceRegistrationDialog, activity, webView, settings);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(webView, y.٬ݯح׭٩(576656206));
            Intrinsics.checkNotNullParameter(settings, y.دײܮڳܯ(2051042461));
            this.this$0 = deviceRegistrationDialog;
            webView.getSettings().setTextZoom(100);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.kakaogame.web.WebDialog.WebViewContainerImpl, com.kakaogame.web.WebViewContainer
        protected boolean shouldOverrideUrlLoading(WebView view, String url) {
            Logger.INSTANCE.m699d(y.دײܮڳܯ(2051275605), y.ݮڮֲڭܩ(-628484836) + url);
            if (url == null) {
                return true;
            }
            if (StringsKt.contains((CharSequence) url, (CharSequence) y.دײܮڳܯ(2051275653), true)) {
                Uri parse = Uri.parse(url);
                String appId = CoreManager.INSTANCE.getInstance().getConfiguration().getAppId();
                KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
                Intrinsics.checkNotNull(currentPlayer);
                String playerId = currentPlayer.getPlayerId();
                String queryParameter = parse.getQueryParameter(y.ٴسسݬߨ(1393058762));
                if (queryParameter == null) {
                    return true;
                }
                ProtectionManager.CertificationPrefManager.INSTANCE.saveCertification(getWebView().getContext(), appId, playerId, queryParameter);
                return true;
            }
            if (StringsKt.equals(url, y.֬ڱܱײٮ(-1158775207), true)) {
                this.this$0.callback.invoke(KGResult.INSTANCE.getSuccessResult());
                this.this$0.dismiss();
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
