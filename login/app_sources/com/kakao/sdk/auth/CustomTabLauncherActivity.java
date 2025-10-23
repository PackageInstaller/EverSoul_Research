package com.kakao.sdk.auth;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.KakaoSdkError;
import com.kakao.sdk.common.util.KakaoCustomTabsClient;
import com.kakao.sdk.common.util.SdkLog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTabLauncherActivity.kt */
@Metadata(m838d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0014J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0013H\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006!"}, m839d2 = {"Lcom/kakao/sdk/auth/CustomTabLauncherActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "customTabsConnection", "Landroid/content/ServiceConnection;", "customTabsOpened", "", "fullUri", "Landroid/net/Uri;", "internalHandler", "Landroid/os/Handler;", "resultReceiver", "Landroid/os/ResultReceiver;", "loadData", "", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "openBrowserWithoutBinding", "uri", "openChromeCustomTab", "sendError", "exception", "Lcom/kakao/sdk/common/model/KakaoSdkError;", "sendOK", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public class CustomTabLauncherActivity extends AppCompatActivity {
    private ServiceConnection customTabsConnection;
    private boolean customTabsOpened;
    private Uri fullUri;
    private Handler internalHandler;
    private ResultReceiver resultReceiver;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        loadData(intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putBoolean(Constants.KEY_CUSTOM_TABS_OPENED, this.customTabsOpened);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        this.customTabsOpened = savedInstanceState.getBoolean(Constants.KEY_CUSTOM_TABS_OPENED, this.customTabsOpened);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void loadData(Intent intent) {
        Bundle bundle;
        ResultReceiver resultReceiver;
        Uri uri;
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            Bundle extras = intent.getExtras();
            if (extras != null && (bundle = extras.getBundle(Constants.KEY_BUNDLE)) != null) {
                if (Build.VERSION.SDK_INT >= 33) {
                    resultReceiver = (ResultReceiver) bundle.getParcelable(Constants.KEY_RESULT_RECEIVER, ResultReceiver.class);
                } else {
                    Parcelable parcelable = bundle.getParcelable(Constants.KEY_RESULT_RECEIVER);
                    if (parcelable == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.os.ResultReceiver");
                    }
                    resultReceiver = (ResultReceiver) parcelable;
                }
                if (resultReceiver != null) {
                    this.resultReceiver = resultReceiver;
                    if (Build.VERSION.SDK_INT >= 33) {
                        uri = (Uri) bundle.getParcelable(Constants.KEY_FULL_URI, Uri.class);
                    } else {
                        Parcelable parcelable2 = bundle.getParcelable(Constants.KEY_FULL_URI);
                        if (parcelable2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
                        }
                        uri = (Uri) parcelable2;
                    }
                    if (uri != null) {
                        this.fullUri = uri;
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            this.internalHandler = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.kakao.sdk.auth.CustomTabLauncherActivity$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.os.Handler.Callback
                public final boolean handleMessage(Message message) {
                    boolean m1210loadData$lambda1;
                    m1210loadData$lambda1 = CustomTabLauncherActivity.m1210loadData$lambda1(CustomTabLauncherActivity.this, message);
                    return m1210loadData$lambda1;
                }
            });
        } catch (Throwable th) {
            SdkLog.INSTANCE.m470e(th);
            ClientError clientError = new ClientError(ClientErrorCause.Unknown, null, 2, null);
            clientError.initCause(th);
            sendError(clientError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: loadData$lambda-1, reason: not valid java name */
    public static final boolean m1210loadData$lambda1(CustomTabLauncherActivity this$0, Message it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        SdkLog.INSTANCE.m471i("handle delay message");
        this$0.sendError(new ClientError(ClientErrorCause.Cancelled, null, 2, null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onResume() {
        Handler handler;
        super.onResume();
        Uri uri = null;
        if (!this.customTabsOpened) {
            this.customTabsOpened = true;
            Uri uri2 = this.fullUri;
            if (uri2 == null) {
                sendError(new ClientError(ClientErrorCause.IllegalState, "url has been not initialized."));
                return;
            }
            if (uri2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fullUri");
            } else {
                uri = uri2;
            }
            openChromeCustomTab(uri);
            return;
        }
        SdkLog.INSTANCE.m471i("trigger delay message");
        Handler handler2 = this.internalHandler;
        if (!Intrinsics.areEqual((Object) (handler2 != null ? Boolean.valueOf(handler2.hasMessages(0)) : null), (Object) false) || (handler = this.internalHandler) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(0, 100L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Uri data;
        Handler handler;
        super.onNewIntent(intent);
        SdkLog.INSTANCE.m471i("onNewIntent");
        setIntent(intent);
        Handler handler2 = this.internalHandler;
        if (Intrinsics.areEqual((Object) (handler2 == null ? null : Boolean.valueOf(handler2.hasMessages(0))), (Object) true) && (handler = this.internalHandler) != null) {
            handler.removeMessages(0);
        }
        this.internalHandler = null;
        if (intent != null && (data = intent.getData()) != null) {
            sendOK(data);
        }
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ServiceConnection serviceConnection = this.customTabsConnection;
        if (serviceConnection == null) {
            return;
        }
        unbindService(serviceConnection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void openChromeCustomTab(Uri uri) {
        SdkLog.INSTANCE.m471i(Intrinsics.stringPlus("Authorize Uri: ", uri));
        try {
            ServiceConnection openWithDefault = KakaoCustomTabsClient.INSTANCE.openWithDefault(this, uri);
            this.customTabsConnection = openWithDefault;
            if (openWithDefault == null) {
                SdkLog.INSTANCE.m471i("try to open chrome without service binding");
                openBrowserWithoutBinding(uri);
            }
        } catch (UnsupportedOperationException e) {
            SdkLog.INSTANCE.m473w(e);
            openBrowserWithoutBinding(uri);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void openBrowserWithoutBinding(Uri uri) {
        try {
            KakaoCustomTabsClient.INSTANCE.open(this, uri);
        } catch (ActivityNotFoundException e) {
            SdkLog.INSTANCE.m473w(e);
            sendError(new ClientError(ClientErrorCause.NotSupported, "No browser has been installed on a device."));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendError(KakaoSdkError exception) {
        ResultReceiver resultReceiver = this.resultReceiver;
        if (resultReceiver != null) {
            if (resultReceiver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultReceiver");
                resultReceiver = null;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable(Constants.KEY_EXCEPTION, exception);
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(0, bundle);
        }
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void sendOK(Uri uri) {
        ResultReceiver resultReceiver = this.resultReceiver;
        if (resultReceiver != null) {
            if (resultReceiver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultReceiver");
                resultReceiver = null;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.KEY_URL, uri);
            Unit unit = Unit.INSTANCE;
            resultReceiver.send(-1, bundle);
        }
        finish();
    }
}
