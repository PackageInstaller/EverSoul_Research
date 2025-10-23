package com.kakaogame.promotion.share;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.RelativeLayout;
import androidx.appcompat.C0047R;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.kakaogame.C2382R;
import com.kakaogame.KGActivityManager;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.broker.InterfaceBrokerManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.databinding.KakaoGameSdkShareScreenshotBinding;
import com.kakaogame.game.StringSet;
import com.kakaogame.promotion.SNSShareData;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.DisplayUtil;
import com.liapp.y;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ScreenShotDialog.kt */
@Metadata(m838d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fB)\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\u0002\u0010\rJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0012\u0010)\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\b\u0010,\u001a\u00020\u001bH\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\b\u0010.\u001a\u00020\u001bH\u0014J\u0010\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u001bH\u0002J\b\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u0007H\u0002J\b\u00107\u001a\u00020\u001bH\u0016J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;J\b\u0010<\u001a\u00020\u001bH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006>"}, m839d2 = {"Lcom/kakaogame/promotion/share/ScreenShotDialog;", "Landroid/app/Dialog;", "Lcom/kakaogame/KGActivityManager$ConfigChangeListener;", "Lcom/kakaogame/KGActivityManager$LifecycleListener;", "activity", "Landroid/app/Activity;", "isNative", "", "isCrop", "callback", "Lcom/kakaogame/KGResultCallback;", "Ljava/lang/Void;", "(Landroid/app/Activity;ZZLcom/kakaogame/KGResultCallback;)V", "(Landroid/app/Activity;ZLcom/kakaogame/KGResultCallback;)V", "binding", "Lcom/kakaogame/databinding/KakaoGameSdkShareScreenshotBinding;", "isProgress", "paused", "preOrientation", "", "progressLock", "", "<set-?>", ServerConstants.TRACE_RESULT_CODE, "getResultCode", "()I", "dismiss", "", "getBitmapFromView", "Landroid/graphics/Bitmap;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "getResultBitmap", StringSet.original, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "initViews", "manageCropView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onStart", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "reopenDialog", "setDialogVisibility", "setLayoutSettings", "setProgressSharing", "progress", "show", "showShareDialog", "bitmap", Base2ndPWViewData.KEY_PATH, "", "takeScreenCapture", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ScreenShotDialog extends Dialog implements KGActivityManager.ConfigChangeListener, KGActivityManager.LifecycleListener {
    private static final String TAG = "ScreenShotDialog";
    private KakaoGameSdkShareScreenshotBinding binding;
    private final KGResultCallback<Void> callback;
    private boolean isCrop;
    private final boolean isNative;
    private boolean isProgress;
    private boolean paused;
    private int preOrientation;
    private final Object progressLock;
    private int resultCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScreenShotDialog(Activity activity, boolean z, KGResultCallback<Void> kGResultCallback) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat_Light);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        this.isNative = z;
        this.callback = kGResultCallback;
        this.preOrientation = -1;
        this.progressLock = new Object();
        this.resultCode = 9001;
        this.isCrop = false;
        setOwnerActivity(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getResultCode() {
        return this.resultCode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScreenShotDialog(Activity activity, boolean z, boolean z2, KGResultCallback<Void> kGResultCallback) {
        this(activity, z, kGResultCallback);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        this.isCrop = z2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ݬֲ֮ܲت(1512384319));
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        CoreManager.INSTANCE.getInstance().setCaptureDialog(this);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.getAttributes().windowAnimations = R.style.Animation.Dialog;
        setCanceledOnTouchOutside(true);
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.promotion.share.ScreenShotDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$0;
                onCreate$lambda$0 = ScreenShotDialog.onCreate$lambda$0(ScreenShotDialog.this, dialogInterface, i, keyEvent);
                return onCreate$lambda$0;
            }
        });
        KakaoGameSdkShareScreenshotBinding inflate = KakaoGameSdkShareScreenshotBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
        this.binding = inflate;
        initViews();
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding = this.binding;
        if (kakaoGameSdkShareScreenshotBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            kakaoGameSdkShareScreenshotBinding = null;
        }
        setContentView(kakaoGameSdkShareScreenshotBinding.getRoot());
        setDialogVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean onCreate$lambda$0(ScreenShotDialog this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        Logger.INSTANCE.m699d(TAG, y.ٴسسݬߨ(1393092178));
        this$0.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setProgressSharing(boolean progress) {
        synchronized (this.progressLock) {
            this.isProgress = progress;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setDialogVisibility() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.دײܮڳܯ(2051138941));
        if (Build.VERSION.SDK_INT >= 30) {
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            window.setDecorFitsSystemWindows(false);
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            WindowInsetsController insetsController = window2.getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
                return;
            }
            return;
        }
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.getDecorView().setSystemUiVisibility(5894);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void show() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.٬ݯح׭٩(576403774));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setFlags(8, 8);
        super.show();
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.clearFlags(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showShareDialog(String path) {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ٲٴݴ״ٰ(1782447400) + path);
        final Bitmap decodeFile = BitmapFactory.decodeFile(path);
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity != null) {
            ownerActivity.runOnUiThread(new Runnable() { // from class: com.kakaogame.promotion.share.ScreenShotDialog$$ExternalSyntheticLambda4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenShotDialog.showShareDialog$lambda$2(ScreenShotDialog.this, decodeFile);
                }
            });
        }
        Intrinsics.checkNotNull(decodeFile);
        showShareDialog(getResultBitmap(decodeFile, decodeFile.getWidth(), decodeFile.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showShareDialog$lambda$2(ScreenShotDialog screenShotDialog, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(screenShotDialog, y.ٴسسݬߨ(1393322442));
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding = screenShotDialog.binding;
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding2 = null;
        String str = y.֬ڱܱײٮ(-1158912015);
        if (kakaoGameSdkShareScreenshotBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            kakaoGameSdkShareScreenshotBinding = null;
        }
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotResultImage.setImageBitmap(bitmap);
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding3 = screenShotDialog.binding;
        if (kakaoGameSdkShareScreenshotBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            kakaoGameSdkShareScreenshotBinding2 = kakaoGameSdkShareScreenshotBinding3;
        }
        kakaoGameSdkShareScreenshotBinding2.kakaoGameSdkScreenshotResultImage.setVisibility(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showShareDialog(Bitmap bitmap) {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ٲٴݴ״ٰ(1782447400) + bitmap);
        try {
            Activity ownerActivity = getOwnerActivity();
            File file = new File(ownerActivity != null ? ownerActivity.getFilesDir() : null, "testFile.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            String absolutePath = file.getAbsolutePath();
            SNSShareData snsShareData = CoreManager.INSTANCE.getInstance().getSnsShareData();
            if (snsShareData != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ScreenShotDialog$showShareDialog$2(this, snsShareData, absolutePath, null), 3, null);
            } else {
                this.resultCode = 1001;
                dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Bitmap getResultBitmap(Bitmap original, int width, int height) {
        int i;
        Logger logger = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.دײܮڳܯ(2051139229)).append(original);
        String str = y.ݬֲ֮ܲت(1513068719);
        logger.m699d(y.֬ڱܱײٮ(-1159153855), append.append(str).append(width).append(str).append(height).toString());
        boolean z = this.isCrop;
        String str2 = y.֬ڱܱײٮ(-1159153303);
        if (z) {
            int i2 = 0;
            if (width < height) {
                i = (height - width) / 2;
            } else {
                i2 = (width - height) / 2;
                width = height;
                i = 0;
            }
            Bitmap createBitmap = Bitmap.createBitmap(original, i2, i, width, width);
            Intrinsics.checkNotNullExpressionValue(createBitmap, str2);
            return createBitmap;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(original);
        Intrinsics.checkNotNullExpressionValue(createBitmap2, str2);
        return createBitmap2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void takeScreenCapture() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.٬ݯح׭٩(576399086));
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        View decorView = ownerActivity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, y.ٲٴݴ״ٰ(1782133032));
        if (Build.VERSION.SDK_INT >= 28) {
            Bitmap resultBitmap = getResultBitmap(getBitmapFromView(decorView), decorView.getWidth(), decorView.getHeight());
            CoreManager.INSTANCE.getInstance().sendEvent(1001);
            showShareDialog(resultBitmap);
            return;
        }
        decorView.setDrawingCacheEnabled(true);
        Bitmap drawingCache = decorView.getDrawingCache();
        Intrinsics.checkNotNullExpressionValue(drawingCache, y.ٲٴݴ״ٰ(1782447200));
        Bitmap resultBitmap2 = getResultBitmap(drawingCache, decorView.getWidth(), decorView.getHeight());
        decorView.setDrawingCacheEnabled(false);
        CoreManager.INSTANCE.getInstance().sendEvent(1001);
        showShareDialog(resultBitmap2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Bitmap getBitmapFromView(View view) {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ٴسسݬߨ(1393093626) + view);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, y.֬ڱܱײٮ(-1159153303));
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void manageCropView() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.٬ݯح׭٩(576397758));
        boolean z = this.isCrop;
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding = null;
        String str = y.֬ڱܱײٮ(-1158912015);
        if (z) {
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding2 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
                kakaoGameSdkShareScreenshotBinding2 = null;
            }
            kakaoGameSdkShareScreenshotBinding2.kakaoGameSdkScreenshotCropType.setImageResource(C2382R.drawable.kakao_game_screenshot_square);
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding3 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str);
            } else {
                kakaoGameSdkShareScreenshotBinding = kakaoGameSdkShareScreenshotBinding3;
            }
            kakaoGameSdkShareScreenshotBinding.kakaoGameSdkBound.setVisibility(0);
            return;
        }
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding4 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            kakaoGameSdkShareScreenshotBinding4 = null;
        }
        kakaoGameSdkShareScreenshotBinding4.kakaoGameSdkScreenshotCropType.setImageResource(C2382R.drawable.kakao_game_screenshot_rectangle);
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding5 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            kakaoGameSdkShareScreenshotBinding = kakaoGameSdkShareScreenshotBinding5;
        }
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkBound.setVisibility(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initViews() {
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding = this.binding;
        if (kakaoGameSdkShareScreenshotBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1158912015));
            kakaoGameSdkShareScreenshotBinding = null;
        }
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkDialogTopbarClose.initialize(getOwnerActivity());
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkDialogTopbarClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.promotion.share.ScreenShotDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotDialog.initViews$lambda$6$lambda$3(ScreenShotDialog.this, view);
            }
        });
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotCamera.initialize(getOwnerActivity());
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotCamera.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.promotion.share.ScreenShotDialog$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotDialog.initViews$lambda$6$lambda$4(ScreenShotDialog.this, view);
            }
        });
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotCrop.initialize(getOwnerActivity());
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotCrop.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.promotion.share.ScreenShotDialog$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotDialog.initViews$lambda$6$lambda$5(ScreenShotDialog.this, view);
            }
        });
        setLayoutSettings();
        manageCropView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$6$lambda$3(ScreenShotDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$6$lambda$4(ScreenShotDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isProgress) {
            return;
        }
        this$0.setProgressSharing(true);
        if (!this$0.isNative) {
            if (CoreManager.INSTANCE.getInstance().isUnity()) {
                InterfaceBrokerManager.takeScreenShotOnUnity();
                return;
            } else {
                if (CoreManager.INSTANCE.getInstance().isUnreal()) {
                    InterfaceBrokerManager.takeScreenShotOnUnreal();
                    return;
                }
                return;
            }
        }
        this$0.takeScreenCapture();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initViews$lambda$6$lambda$5(ScreenShotDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isCrop = !this$0.isCrop;
        this$0.manageCropView();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setLayoutSettings() {
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        Point currentWindowMetricsPointCompat = DisplayUtil.getCurrentWindowMetricsPointCompat(ownerActivity);
        int i = currentWindowMetricsPointCompat.y;
        int i2 = currentWindowMetricsPointCompat.x;
        Activity ownerActivity2 = getOwnerActivity();
        boolean z = ownerActivity2 != null && DisplayUtil.isScreenPortrait(ownerActivity2);
        String str = y.ۮڭڭܬި(862752387);
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding = null;
        String str2 = y.֬ڱܱײٮ(-1158912015);
        if (z) {
            int i3 = (i - i2) / 2;
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding2 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                kakaoGameSdkShareScreenshotBinding2 = null;
            }
            ViewGroup.LayoutParams layoutParams = kakaoGameSdkShareScreenshotBinding2.kakaoGameSdkBoundTopLeft.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, str);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = -1;
            layoutParams2.height = i3;
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding3 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                kakaoGameSdkShareScreenshotBinding3 = null;
            }
            kakaoGameSdkShareScreenshotBinding3.kakaoGameSdkBoundTopLeft.setLayoutParams(layoutParams2);
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding4 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                kakaoGameSdkShareScreenshotBinding4 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = kakaoGameSdkShareScreenshotBinding4.kakaoGameSdkBoundBottomnRight.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, str);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.width = -1;
            layoutParams4.height = i3;
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding5 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                kakaoGameSdkShareScreenshotBinding5 = null;
            }
            kakaoGameSdkShareScreenshotBinding5.kakaoGameSdkBoundBottomnRight.setLayoutParams(layoutParams4);
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding6 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                kakaoGameSdkShareScreenshotBinding6 = null;
            }
            ViewGroup.LayoutParams layoutParams5 = kakaoGameSdkShareScreenshotBinding6.kakaoGameSdkScreenshotWatermarkCropImage.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, str);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
            layoutParams6.addRule(1, 0);
            layoutParams6.addRule(10, 0);
            layoutParams6.addRule(9);
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding7 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                kakaoGameSdkShareScreenshotBinding7 = null;
            }
            layoutParams6.addRule(3, kakaoGameSdkShareScreenshotBinding7.kakaoGameSdkBoundTopLeft.getId());
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding8 = this.binding;
            if (kakaoGameSdkShareScreenshotBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            } else {
                kakaoGameSdkShareScreenshotBinding = kakaoGameSdkShareScreenshotBinding8;
            }
            kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotWatermarkCropImage.setLayoutParams(layoutParams6);
            return;
        }
        int i4 = (i2 - i) / 2;
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding9 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            kakaoGameSdkShareScreenshotBinding9 = null;
        }
        ViewGroup.LayoutParams layoutParams7 = kakaoGameSdkShareScreenshotBinding9.kakaoGameSdkBoundTopLeft.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams7, str);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) layoutParams7;
        layoutParams8.width = i4;
        layoutParams8.height = -1;
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding10 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            kakaoGameSdkShareScreenshotBinding10 = null;
        }
        kakaoGameSdkShareScreenshotBinding10.kakaoGameSdkBoundTopLeft.setLayoutParams(layoutParams8);
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding11 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            kakaoGameSdkShareScreenshotBinding11 = null;
        }
        ViewGroup.LayoutParams layoutParams9 = kakaoGameSdkShareScreenshotBinding11.kakaoGameSdkBoundBottomnRight.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams9, str);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) layoutParams9;
        layoutParams10.width = i4;
        layoutParams10.height = -1;
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding12 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            kakaoGameSdkShareScreenshotBinding12 = null;
        }
        kakaoGameSdkShareScreenshotBinding12.kakaoGameSdkBoundBottomnRight.setLayoutParams(layoutParams10);
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding13 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            kakaoGameSdkShareScreenshotBinding13 = null;
        }
        ViewGroup.LayoutParams layoutParams11 = kakaoGameSdkShareScreenshotBinding13.kakaoGameSdkScreenshotWatermarkCropImage.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams11, str);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) layoutParams11;
        layoutParams12.addRule(3, 0);
        layoutParams12.addRule(9, 0);
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding14 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            kakaoGameSdkShareScreenshotBinding14 = null;
        }
        layoutParams12.addRule(1, kakaoGameSdkShareScreenshotBinding14.kakaoGameSdkBoundTopLeft.getId());
        layoutParams12.addRule(10);
        KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding15 = this.binding;
        if (kakaoGameSdkShareScreenshotBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        } else {
            kakaoGameSdkShareScreenshotBinding = kakaoGameSdkShareScreenshotBinding15;
        }
        kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotWatermarkCropImage.setLayoutParams(layoutParams12);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGActivityManager.LifecycleListener
    public void onResume() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.٬ݯح׭٩(576403478) + this.resultCode);
        if (!this.isNative && this.paused && this.resultCode == 9001) {
            this.resultCode = KGResult.KGResultCode.REQUEST_REOPEN;
            dismiss();
        }
        this.paused = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGActivityManager.LifecycleListener
    public void onPause() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.٬ݯح׭٩(575803878));
        this.paused = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGActivityManager.ConfigChangeListener
    public void onConfigurationChanged(Configuration newConfig) {
        View decorView;
        Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ٲٴݴ״ٰ(1782131848) + newConfig.orientation + y.ݮڮֲڭܩ(-628606940) + this.preOrientation);
        if (this.preOrientation < 0 || newConfig.orientation != this.preOrientation) {
            setLayoutSettings();
            manageCropView();
            Window window = getWindow();
            if (window != null && (decorView = window.getDecorView()) != null) {
                decorView.invalidate();
            }
        }
        this.preOrientation = newConfig.orientation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, y.ٲٴݴ״ٰ(1782060104));
        super.onTouchEvent(event);
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ݬֲ֮ܲت(1512167199) + event);
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity == null) {
            return false;
        }
        ownerActivity.dispatchTouchEvent(event);
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void reopenDialog() {
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ٴسسݬߨ(1393092290));
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity != null) {
            ownerActivity.runOnUiThread(new Runnable() { // from class: com.kakaogame.promotion.share.ScreenShotDialog$$ExternalSyntheticLambda5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    ScreenShotDialog.reopenDialog$lambda$8(ScreenShotDialog.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void reopenDialog$lambda$8(ScreenShotDialog screenShotDialog) {
        Intrinsics.checkNotNullParameter(screenShotDialog, y.ٴسسݬߨ(1393322442));
        try {
            Activity ownerActivity = screenShotDialog.getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity);
            new ScreenShotDialog(ownerActivity, screenShotDialog.isNative, screenShotDialog.isCrop, screenShotDialog.callback).show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.֬ڱܱײٮ(-1159153855), e.toString(), e);
            KGResult<Void> result = KGResult.INSTANCE.getResult(4001, e.toString());
            KGResultCallback<Void> kGResultCallback = screenShotDialog.callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(result);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ݬֲ֮ܲت(1512384367));
        KGActivityManager.INSTANCE.addConfigChangeListener(this);
        KGActivityManager.INSTANCE.addLifecycleListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        KGResult<Void> successResult;
        super.dismiss();
        Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.ݬֲ֮ܲت(1512380623));
        KGActivityManager.INSTANCE.removeConfigChangeListener(this);
        KGActivityManager.INSTANCE.removeLifecycleListener(this);
        if (getOwnerActivity() == null && this.callback != null) {
            KGResult<Void> result = KGResult.INSTANCE.getResult(9001);
            KGResultCallback<Void> kGResultCallback = this.callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(result);
                return;
            }
            return;
        }
        if (this.callback != null) {
            int i = this.resultCode;
            if (i == 100000) {
                try {
                    Thread.sleep(300L);
                } catch (Exception unused) {
                }
                reopenDialog();
                return;
            }
            if (i == 200) {
                successResult = KGResult.INSTANCE.getSuccessResult();
            } else if (i == 1001 || i == 8001) {
                successResult = KGResult.INSTANCE.getResult(i);
            } else {
                successResult = KGResult.INSTANCE.getResult(9001);
            }
            KGResultCallback<Void> kGResultCallback2 = this.callback;
            if (kGResultCallback2 != null) {
                kGResultCallback2.onResult(successResult);
            }
        }
    }
}
