package com.kakaogame;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.DisplayUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KGAuthActivity.kt */
@Metadata(m838d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\tH\u0014J\b\u0010\u0015\u001a\u00020\tH\u0014J+\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\tH\u0014J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, m839d2 = {"Lcom/kakaogame/KGAuthActivity;", "Landroid/app/Activity;", "()V", "displayCutoutMode", "", KGAuthActivity.EXTRA_NAME_FLAGS, KGAuthActivity.EXTRA_NAME_TX_ID, "", "onActivityResult", "", "requestCode", ServerConstants.TRACE_RESULT_CODE, "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "setVisibility", "Companion", "KGActivityEventListener", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGAuthActivity extends Activity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_NAME_CUTOUT_MODE = "cutoutMode";
    private static final String EXTRA_NAME_FLAGS = "flags";
    private static final String EXTRA_NAME_TX_ID = "txId";
    private static final String TAG = "KGAuthActivity";
    private int displayCutoutMode;
    private int flags;
    private long txId = -1;

    /* compiled from: KGAuthActivity.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/KGAuthActivity$KGActivityEventListener;", "", "onActivityResult", "", "requestCode", "", ServerConstants.TRACE_RESULT_CODE, "data", "Landroid/content/Intent;", "onActivityStart", "activity", "Landroid/app/Activity;", "onDestroy", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface KGActivityEventListener {
        void onActivityResult(int requestCode, int resultCode, Intent data);

        void onActivityStart(Activity activity);

        void onDestroy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        y.٬خݮ۳ݯ(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setVisibility() {
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
        getWindow().addFlags(this.flags);
        if (Build.VERSION.SDK_INT >= 28) {
            getWindow().getAttributes().layoutInDisplayCutoutMode = this.displayCutoutMode;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        y.٬خݮ۳ݯ(this);
        super.onCreate(savedInstanceState);
        String str = y.ݬֲ֮ܲت(1512636207);
        String str2 = y.ٴسسݬߨ(1392629066);
        String str3 = y.ݮڮֲڭܩ(-628756844);
        String str4 = y.٬ݯح׭٩(575803774);
        try {
            if (savedInstanceState != null) {
                Logger.INSTANCE.m699d(str3, "Restore Activity");
                this.txId = savedInstanceState.getLong(str4, -1L);
                this.flags = savedInstanceState.getInt(str2, 0);
                this.displayCutoutMode = savedInstanceState.getInt(str, 0);
            } else {
                Intent intent = getIntent();
                this.txId = intent.getLongExtra(str4, -1L);
                this.flags = intent.getIntExtra(str2, 0);
                this.displayCutoutMode = intent.getIntExtra(str, 0);
            }
            setVisibility();
            DisplayUtil.checkSystemFontSize(this);
            if (this.txId < 0) {
                finish();
            } else if (!AuthActivityManager.INSTANCE.getInstance().setActivity(this.txId, this)) {
                finish();
            } else {
                AuthActivityManager.INSTANCE.getInstance().processActivityAction(this.txId, this);
            }
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str3, e.toString(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onResume() {
        y.ݱݬ׬۬ݨ(this);
        super.onResume();
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628756844), y.٬ݯح׭٩(575804374));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onPause() {
        y.ݯױܭ۱ݭ(this);
        super.onPause();
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628756844), y.٬ݯح׭٩(575803878));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, y.ٲٴݴ״ٰ(1781845792));
        savedInstanceState.putLong(y.٬ݯح׭٩(575803774), this.txId);
        savedInstanceState.putInt(y.ٴسسݬߨ(1392629066), this.flags);
        savedInstanceState.putInt(y.ݬֲ֮ܲت(1512636207), this.displayCutoutMode);
        super.onSaveInstanceState(savedInstanceState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628756844), y.دײܮڳܯ(2051593997));
        if (this.txId > 0) {
            AuthActivityManager.INSTANCE.getInstance().removeActivityParameters(this.txId, this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
        super.onConfigurationChanged(newConfig);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575803430)).append(requestCode);
        String str = y.ݮڮֲڭܩ(-628756788);
        logger.m699d(y.ݮڮֲڭܩ(-628756844), append.append(str).append(resultCode).append(str).append(data).toString());
        AuthActivityManager.INSTANCE.getInstance().onActivityResult(requestCode, resultCode, data);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, y.دײܮڳܯ(2051593325));
        Intrinsics.checkNotNullParameter(grantResults, y.ۮڭڭܬި(862306227));
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.ۮڭڭܬި(862306243)).append(requestCode);
        String str = y.ݮڮֲڭܩ(-628756788);
        String sb = append.append(str).append(permissions).append(str).append(grantResults).toString();
        String str2 = y.ݮڮֲڭܩ(-628756844);
        logger.m699d(str2, sb);
        try {
            AuthActivityManager.INSTANCE.getInstance().onRequestPermissionsResult(this.txId, requestCode, permissions, grantResults);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
        }
    }

    /* compiled from: KGAuthActivity.kt */
    @Metadata(m838d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lcom/kakaogame/KGAuthActivity$Companion;", "", "()V", "EXTRA_NAME_CUTOUT_MODE", "", "EXTRA_NAME_FLAGS", "EXTRA_NAME_TX_ID", "TAG", "start", "", "activity", "Landroid/app/Activity;", "eventListener", "Lcom/kakaogame/KGAuthActivity$KGActivityEventListener;", "permissionResultCallback", "Landroidx/core/app/ActivityCompat$OnRequestPermissionsResultCallback;", "common-kakaogames_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static /* synthetic */ long start$default(Companion companion, Activity activity, KGActivityEventListener kGActivityEventListener, ActivityCompat.OnRequestPermissionsResultCallback onRequestPermissionsResultCallback, int i, Object obj) {
            if ((i & 4) != 0) {
                onRequestPermissionsResultCallback = null;
            }
            return companion.start(activity, kGActivityEventListener, onRequestPermissionsResultCallback);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final long start(Activity activity, KGActivityEventListener eventListener, ActivityCompat.OnRequestPermissionsResultCallback permissionResultCallback) {
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            Intrinsics.checkNotNullParameter(eventListener, y.ۮڭڭܬި(862302443));
            Logger logger = Logger.INSTANCE;
            StringBuilder append = new StringBuilder(y.دײܮڳܯ(2051594277)).append(activity);
            String str = y.ݮڮֲڭܩ(-628756788);
            String sb = append.append(str).append(eventListener).append(str).append(permissionResultCallback).toString();
            String str2 = y.ݮڮֲڭܩ(-628756844);
            logger.m699d(str2, sb);
            try {
                long activityParameters = AuthActivityManager.INSTANCE.getInstance().setActivityParameters(eventListener, permissionResultCallback);
                AuthActivityManager.INSTANCE.getInstance().addResultListener(eventListener);
                Intent intent = new Intent(activity, (Class<?>) KGAuthActivity.class);
                intent.putExtra(KGAuthActivity.EXTRA_NAME_TX_ID, activityParameters);
                if (Build.VERSION.SDK_INT >= 28) {
                    intent.putExtra(KGAuthActivity.EXTRA_NAME_CUTOUT_MODE, activity.getWindow().getAttributes().layoutInDisplayCutoutMode);
                }
                intent.putExtra(KGAuthActivity.EXTRA_NAME_FLAGS, activity.getWindow().getAttributes().flags);
                activity.startActivity(intent);
                return activityParameters;
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                return -1L;
            }
        }
    }
}
