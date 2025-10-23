package com.kakaogame.promotion.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.C0047R;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.kakaogame.C2382R;
import com.kakaogame.KGActivityManager;
import com.kakaogame.KGMessage;
import com.kakaogame.Logger;
import com.kakaogame.databinding.ZinnySdkPromotionStartPopupBinding;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.kakaogame.promotion.KGPromotionData;
import com.kakaogame.util.DisplayUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: StartingPromotionDialog.kt */
@Metadata(m838d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001$B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, m839d2 = {"Lcom/kakaogame/promotion/view/StartingPromotionDialog;", "Landroid/app/Dialog;", "Lcom/kakaogame/KGActivityManager$ConfigChangeListener;", "activity", "Landroid/app/Activity;", KGMessage.SENDER_ID_PROMOTION, "Lcom/kakaogame/promotion/KGPromotionData;", "callbackListener", "Lcom/kakaogame/promotion/view/StartingPromotionDialog$StartingPromotionDialogListener;", "(Landroid/app/Activity;Lcom/kakaogame/promotion/KGPromotionData;Lcom/kakaogame/promotion/view/StartingPromotionDialog$StartingPromotionDialogListener;)V", "TAG", "", "anim", "Landroid/view/animation/Animation;", "applyClick", "", "binding", "Lcom/kakaogame/databinding/ZinnySdkPromotionStartPopupBinding;", "clickLink", "preOrientation", "", "calculateViewSize", "", "dismiss", "downloadImage", "handleClick", "initView", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setDialogDim", "setDialogVisibility", "StartingPromotionDialogListener", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class StartingPromotionDialog extends Dialog implements KGActivityManager.ConfigChangeListener {
    private final String TAG;
    private Animation anim;
    private boolean applyClick;
    private ZinnySdkPromotionStartPopupBinding binding;
    private final StartingPromotionDialogListener callbackListener;
    private String clickLink;
    private int preOrientation;
    private KGPromotionData promotion;

    /* compiled from: StartingPromotionDialog.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/promotion/view/StartingPromotionDialog$StartingPromotionDialogListener;", "", "onCheckClicked", "", "onDismiss", "onImageLinkClicked", "clickLink", "", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface StartingPromotionDialogListener {
        void onCheckClicked();

        void onDismiss();

        void onImageLinkClicked(String clickLink);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StartingPromotionDialog(Activity activity, KGPromotionData kGPromotionData, StartingPromotionDialogListener startingPromotionDialogListener) {
        super(activity, C0047R.style.Base_AlertDialog_AppCompat);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(kGPromotionData, y.ٴسسݬߨ(1393387626));
        Intrinsics.checkNotNullParameter(startingPromotionDialogListener, y.٬ݯح׭٩(576403726));
        this.promotion = kGPromotionData;
        this.callbackListener = startingPromotionDialogListener;
        this.TAG = "StartingPromotionDialog";
        this.preOrientation = -1;
        setOwnerActivity(activity);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void initView() {
        Logger.INSTANCE.m699d(this.TAG, y.֬ڱܱײٮ(-1158912503));
        final ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding = this.binding;
        if (zinnySdkPromotionStartPopupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1158912015));
            zinnySdkPromotionStartPopupBinding = null;
        }
        ImageView imageView = zinnySdkPromotionStartPopupBinding.zinnySdkPromotionStartPopupImage;
        zinnySdkPromotionStartPopupBinding.zinnySdkPromotionStartPopupClose.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.promotion.view.StartingPromotionDialog$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartingPromotionDialog.initView$lambda$2$lambda$0(StartingPromotionDialog.this, view);
            }
        });
        zinnySdkPromotionStartPopupBinding.zinnySdkPromotionStartPopupCheck.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.promotion.view.StartingPromotionDialog$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartingPromotionDialog.initView$lambda$2$lambda$1(ZinnySdkPromotionStartPopupBinding.this, this, view);
            }
        });
        this.anim = AnimationUtils.loadAnimation(getOwnerActivity(), C2382R.anim.zinny_sdk_rotate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initView$lambda$2$lambda$0(StartingPromotionDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.callbackListener.onDismiss();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void initView$lambda$2$lambda$1(ZinnySdkPromotionStartPopupBinding this_apply, StartingPromotionDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.zinnySdkPromotionStartPopupCheckImage.setImageResource(C2382R.drawable.popup_promotion_btn_checked);
        this$0.callbackListener.onCheckClicked();
        this$0.dismiss();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void handleClick() {
        this.applyClick = this.promotion.getApplyType() == KGPromotionData.KGPromotionApplyType.CLICK;
        Logger.INSTANCE.m699d(this.TAG, y.ݬֲ֮ܲت(1512466095) + this.applyClick);
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new StartingPromotionDialog$handleClick$1(this, new CustomProgressDialog(ownerActivity), null), 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void calculateViewSize() {
        int i;
        int i2;
        Logger.INSTANCE.m699d(this.TAG, y.ݮڮֲڭܩ(-628606444));
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        int displayWidth = DisplayUtil.getDisplayWidth(ownerActivity);
        Activity ownerActivity2 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity2);
        int displayHeight = DisplayUtil.getDisplayHeight(ownerActivity2);
        Activity ownerActivity3 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity3);
        int dimensionPixelSize = ownerActivity3.getResources().getDimensionPixelSize(C2382R.dimen.sdk_starting_promotion_side_margin);
        Activity ownerActivity4 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity4);
        int dimensionPixelOffset = ownerActivity4.getResources().getDimensionPixelOffset(C2382R.dimen.sdk_starting_promotion_bottom_bar_height);
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding = this.binding;
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding2 = null;
        String str = y.֬ڱܱײٮ(-1158912015);
        if (zinnySdkPromotionStartPopupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            zinnySdkPromotionStartPopupBinding = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(zinnySdkPromotionStartPopupBinding.zinnySdkPromotionView.getLayoutParams());
        Activity ownerActivity5 = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity5);
        if (DisplayUtil.isScreenPortrait(ownerActivity5)) {
            int i3 = dimensionPixelSize * 2;
            i = displayWidth - i3;
            Activity ownerActivity6 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity6);
            int dimensionPixelSize2 = ownerActivity6.getResources().getDimensionPixelSize(C2382R.dimen.sdk_starting_promotion_port_image_width);
            Activity ownerActivity7 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity7);
            i2 = RangesKt.coerceAtMost(((ownerActivity7.getResources().getDimensionPixelSize(C2382R.dimen.sdk_starting_promotion_port_image_height) * i) / dimensionPixelSize2) + dimensionPixelOffset, displayHeight - i3);
            int i4 = (displayHeight - i2) / 2;
            marginLayoutParams.setMargins(dimensionPixelSize, i4, dimensionPixelSize, i4);
        } else {
            int i5 = dimensionPixelSize * 2;
            int i6 = displayHeight - i5;
            Activity ownerActivity8 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity8);
            int dimensionPixelSize3 = ownerActivity8.getResources().getDimensionPixelSize(C2382R.dimen.sdk_starting_promotion_land_image_width);
            Activity ownerActivity9 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity9);
            int coerceAtMost = RangesKt.coerceAtMost(((i6 - dimensionPixelOffset) * dimensionPixelSize3) / ownerActivity9.getResources().getDimensionPixelSize(C2382R.dimen.sdk_starting_promotion_land_image_height), displayWidth - i5);
            int i7 = (displayWidth - coerceAtMost) / 2;
            marginLayoutParams.setMargins(i7, dimensionPixelSize, i7, dimensionPixelSize);
            i = coerceAtMost;
            i2 = i6;
        }
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding3 = this.binding;
        if (zinnySdkPromotionStartPopupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            zinnySdkPromotionStartPopupBinding3 = null;
        }
        zinnySdkPromotionStartPopupBinding3.zinnySdkPromotionView.getLayoutParams().width = i;
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding4 = this.binding;
        if (zinnySdkPromotionStartPopupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            zinnySdkPromotionStartPopupBinding4 = null;
        }
        zinnySdkPromotionStartPopupBinding4.zinnySdkPromotionView.getLayoutParams().height = i2;
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding5 = this.binding;
        if (zinnySdkPromotionStartPopupBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            zinnySdkPromotionStartPopupBinding5 = null;
        }
        RelativeLayout relativeLayout = zinnySdkPromotionStartPopupBinding5.zinnySdkPromotionImageView;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.getLayoutParams().width = i;
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding6 = this.binding;
        if (zinnySdkPromotionStartPopupBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            zinnySdkPromotionStartPopupBinding2 = zinnySdkPromotionStartPopupBinding6;
        }
        RelativeLayout relativeLayout2 = zinnySdkPromotionStartPopupBinding2.zinnySdkPromotionImageView;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.getLayoutParams().height = i2 - dimensionPixelOffset;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.INSTANCE.m699d(this.TAG, y.ݬֲ֮ܲت(1512384319));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(false);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.kakaogame.promotion.view.StartingPromotionDialog$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                StartingPromotionDialog.onCreate$lambda$3(StartingPromotionDialog.this, dialogInterface);
            }
        });
        setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kakaogame.promotion.view.StartingPromotionDialog$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$4;
                onCreate$lambda$4 = StartingPromotionDialog.onCreate$lambda$4(StartingPromotionDialog.this, dialogInterface, i, keyEvent);
                return onCreate$lambda$4;
            }
        });
        ZinnySdkPromotionStartPopupBinding inflate = ZinnySdkPromotionStartPopupBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
        this.binding = inflate;
        initView();
        downloadImage();
        calculateViewSize();
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding = this.binding;
        if (zinnySdkPromotionStartPopupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            zinnySdkPromotionStartPopupBinding = null;
        }
        setContentView(zinnySdkPromotionStartPopupBinding.getRoot());
        setDialogVisibility();
        DisplayUtil displayUtil = DisplayUtil.INSTANCE;
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        displayUtil.setFullScreenView(ownerActivity, window2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onCreate$lambda$3(StartingPromotionDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.promotion.getApplyType() == KGPromotionData.KGPromotionApplyType.SHOW) {
            this$0.promotion.apply(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean onCreate$lambda$4(StartingPromotionDialog this$0, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (keyEvent.getAction() != 1 || i != 4) {
            return false;
        }
        this$0.callbackListener.onDismiss();
        this$0.dismiss();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        Logger.INSTANCE.m699d(this.TAG, y.ݬֲ֮ܲت(1512384367));
        setDialogDim();
        KGActivityManager.INSTANCE.addConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Logger.INSTANCE.m699d(this.TAG, y.ݬֲ֮ܲت(1512380623));
        super.dismiss();
        KGActivityManager.INSTANCE.removeConfigChangeListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setDialogDim() {
        Logger.INSTANCE.m699d(this.TAG, y.ٲٴݴ״ٰ(1782127208));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.3f;
        attributes.flags |= 2;
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setAttributes(attributes);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void setDialogVisibility() {
        Logger.INSTANCE.m699d(this.TAG, y.دײܮڳܯ(2051138941));
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        window.addFlags(ownerActivity.getWindow().getAttributes().flags);
        if (Build.VERSION.SDK_INT >= 28) {
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            Activity ownerActivity2 = getOwnerActivity();
            Intrinsics.checkNotNull(ownerActivity2);
            attributes.layoutInDisplayCutoutMode = ownerActivity2.getWindow().getAttributes().layoutInDisplayCutoutMode;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.KGActivityManager.ConfigChangeListener
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, y.ݬֲ֮ܲت(1512614831));
        Logger.INSTANCE.m699d(this.TAG, y.ٲٴݴ״ٰ(1782131848) + newConfig.orientation + y.ݮڮֲڭܩ(-628606940) + this.preOrientation);
        if (this.preOrientation < 0 || newConfig.orientation != this.preOrientation) {
            ZinnySdkPromotionStartPopupBinding inflate = ZinnySdkPromotionStartPopupBinding.inflate(getLayoutInflater());
            Intrinsics.checkNotNullExpressionValue(inflate, y.ٴسسݬߨ(1393308746));
            this.binding = inflate;
            initView();
            downloadImage();
            calculateViewSize();
            ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding = this.binding;
            if (zinnySdkPromotionStartPopupBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException(y.֬ڱܱײٮ(-1158912015));
                zinnySdkPromotionStartPopupBinding = null;
            }
            setContentView(zinnySdkPromotionStartPopupBinding.getRoot());
        }
        this.preOrientation = newConfig.orientation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void downloadImage() {
        String landscapeImageUrl;
        Logger.INSTANCE.m699d(this.TAG, y.ٴسسݬߨ(1393098130));
        Activity ownerActivity = getOwnerActivity();
        Intrinsics.checkNotNull(ownerActivity);
        if (DisplayUtil.isScreenPortrait(ownerActivity)) {
            landscapeImageUrl = this.promotion.getPortraitImageUrl();
        } else {
            landscapeImageUrl = this.promotion.getLandscapeImageUrl();
        }
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        circularProgressDrawable.setStrokeWidth(5.0f);
        circularProgressDrawable.setCenterRadius(30.0f);
        circularProgressDrawable.start();
        RequestBuilder placeholder = Glide.with(getContext()).load(landscapeImageUrl).placeholder(circularProgressDrawable);
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding = this.binding;
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding2 = null;
        String str = y.֬ڱܱײٮ(-1158912015);
        if (zinnySdkPromotionStartPopupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            zinnySdkPromotionStartPopupBinding = null;
        }
        placeholder.into(zinnySdkPromotionStartPopupBinding.zinnySdkPromotionStartPopupImage);
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding3 = this.binding;
        if (zinnySdkPromotionStartPopupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            zinnySdkPromotionStartPopupBinding3 = null;
        }
        zinnySdkPromotionStartPopupBinding3.zinnySdkPromotionStartPopupProgress.setVisibility(8);
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding4 = this.binding;
        if (zinnySdkPromotionStartPopupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            zinnySdkPromotionStartPopupBinding4 = null;
        }
        zinnySdkPromotionStartPopupBinding4.zinnySdkPromotionStartPopupProgress.clearAnimation();
        ZinnySdkPromotionStartPopupBinding zinnySdkPromotionStartPopupBinding5 = this.binding;
        if (zinnySdkPromotionStartPopupBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
        } else {
            zinnySdkPromotionStartPopupBinding2 = zinnySdkPromotionStartPopupBinding5;
        }
        zinnySdkPromotionStartPopupBinding2.zinnySdkPromotionStartPopupImage.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.promotion.view.StartingPromotionDialog$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StartingPromotionDialog.downloadImage$lambda$5(StartingPromotionDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void downloadImage$lambda$5(StartingPromotionDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleClick();
    }
}
