package com.kakaogame.promotion;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import androidx.appcompat.C0047R;
import com.kakaogame.KGMessage;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.databinding.ZinnySdkPromotionEndingPopupBinding;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.kakaogame.p029ui.DeepLinkManager;
import com.kakaogame.promotion.KGPromotionData;
import com.kakaogame.util.AppUtil;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.web.WebDialogManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: EndingPromotionManager.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000bH\u0002J,\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000bH\u0002J\u001e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/promotion/EndingPromotionManager;", "", "()V", "TAG", "", "showClickLink", "", "activity", "Landroid/app/Activity;", "clickLink", "callback", "Lcom/kakaogame/KGResultCallback;", "showEndingPromotionPopup", KGMessage.SENDER_ID_PROMOTION, "Lcom/kakaogame/promotion/KGPromotionData;", "showEndingPromotions", "EndingPopupDialog", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class EndingPromotionManager {
    public static final EndingPromotionManager INSTANCE = new EndingPromotionManager();
    private static final String TAG = "EndingPromotionManager";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EndingPromotionManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showEndingPromotions(Activity activity, KGResultCallback<String> callback) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(callback, y.֬ڱܱײٮ(-1159472767));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EndingPromotionManager$showEndingPromotions$1(activity, new Ref.ObjectRef(), callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showEndingPromotionPopup(Activity activity, KGPromotionData promotion, KGResultCallback<String> callback) {
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576490822) + promotion;
        String str2 = y.ٴسسݬߨ(1393512226);
        logger.m699d(str2, str);
        try {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new EndingPromotionManager$showEndingPromotionPopup$1(activity, promotion, callback, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, y.֬ڱܱײٮ(-1158736023) + e, e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void showClickLink(Activity activity, String clickLink, final KGResultCallback<String> callback) {
        if (DeepLinkManager.INSTANCE.isPlatformDeepLink(clickLink)) {
            if (callback != null) {
                callback.onResult(DeepLinkManager.INSTANCE.handlePlatformDeepLink(activity, clickLink));
            }
        } else if (!DeepLinkManager.INSTANCE.isDeepLink(clickLink)) {
            WebDialogManager.show$default(activity, clickLink, null, false, new KGResultCallback<String>() { // from class: com.kakaogame.promotion.EndingPromotionManager$showClickLink$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<String> result) {
                    KGResultCallback<String> kGResultCallback = callback;
                    if (kGResultCallback != null) {
                        kGResultCallback.onResult(result);
                    }
                }
            }, 12, null);
        } else if (callback != null) {
            callback.onResult(KGResult.INSTANCE.getSuccessResult(clickLink));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EndingPromotionManager.kt */
    @Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m839d2 = {"Lcom/kakaogame/promotion/EndingPromotionManager$EndingPopupDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", KGMessage.SENDER_ID_PROMOTION, "Lcom/kakaogame/promotion/KGPromotionData;", "(Landroid/app/Activity;Lcom/kakaogame/promotion/KGPromotionData;)V", "clickLink", "", "getClickLink", "()Ljava/lang/String;", "setClickLink", "(Ljava/lang/String;)V", "handleClick", "", "initView", "Companion", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class EndingPopupDialog extends Dialog {
        private static final String TAG = "EndingPopupDialog";
        private final Activity activity;
        private String clickLink;
        private final KGPromotionData promotion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public EndingPopupDialog(Activity activity, KGPromotionData kGPromotionData) {
            super(activity, C0047R.style.Base_AlertDialog_AppCompat);
            Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
            this.activity = activity;
            this.promotion = kGPromotionData;
            requestWindowFeature(1);
            Window window = getWindow();
            Intrinsics.checkNotNull(window);
            window.setBackgroundDrawable(new ColorDrawable(0));
            Window window2 = getWindow();
            Intrinsics.checkNotNull(window2);
            window2.getAttributes().windowAnimations = R.style.Animation.Dialog;
            setCanceledOnTouchOutside(false);
            initView();
            DisplayUtil displayUtil = DisplayUtil.INSTANCE;
            Window window3 = getWindow();
            Intrinsics.checkNotNull(window3);
            displayUtil.setFullScreenView(activity, window3);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getClickLink() {
            return this.clickLink;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setClickLink(String str) {
            this.clickLink = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void handleClick() {
            KGPromotionData kGPromotionData = this.promotion;
            if (kGPromotionData != null) {
                boolean z = kGPromotionData.getApplyType() == KGPromotionData.KGPromotionApplyType.CLICK;
                Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393511618), y.ݬֲ֮ܲت(1512466095) + z);
                CustomProgressDialog customProgressDialog = new CustomProgressDialog(this.activity);
                if (z) {
                    customProgressDialog.show();
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new EndingPromotionManager$EndingPopupDialog$handleClick$1$1(z, kGPromotionData, customProgressDialog, this, null), 3, null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x005a, code lost:
        
            if (r3 == null) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0063, code lost:
        
            if (r1 == null) goto L10;
         */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void initView() {
            /*
                r6 = this;
                android.view.LayoutInflater r0 = r6.getLayoutInflater()
                com.kakaogame.databinding.ZinnySdkPromotionEndingPopupBinding r0 = com.kakaogame.databinding.ZinnySdkPromotionEndingPopupBinding.inflate(r0)
                r1 = 1393308746(0x530c344a, float:6.021727E11)
                java.lang.String r1 = com.liapp.y.ٴسسݬߨ(r1)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                android.widget.TextView r1 = r0.zinnySdkPromotionEndingPopupOk
                com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$$ExternalSyntheticLambda0 r2 = new com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$$ExternalSyntheticLambda0
                r2.<init>()
                r1.setOnClickListener(r2)
                android.widget.TextView r1 = r0.zinnySdkPromotionEndingPopupCancel
                com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$$ExternalSyntheticLambda1 r2 = new com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$$ExternalSyntheticLambda1
                r2.<init>()
                r1.setOnClickListener(r2)
                android.app.Activity r1 = r6.activity
                android.content.Context r1 = (android.content.Context) r1
                int r2 = com.kakaogame.C2382R.anim.zinny_sdk_rotate
                android.view.animation.Animation r1 = android.view.animation.AnimationUtils.loadAnimation(r1, r2)
                com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$$ExternalSyntheticLambda2 r2 = new com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$$ExternalSyntheticLambda2
                r2.<init>()
                r6.setOnShowListener(r2)
                com.kakaogame.promotion.KGPromotionData r1 = r6.promotion
                r2 = 8
                if (r1 == 0) goto L65
                java.lang.String r3 = r1.getLandscapeImageUrl()
                if (r3 == 0) goto L5c
                android.widget.ImageView r4 = r0.zinnySdkPromotionEndingPopupImage
                r5 = 2051428317(0x7a464fdd, float:2.5742365E35)
                java.lang.String r5 = com.liapp.y.دײܮڳܯ(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$initView$1$4$1$1 r5 = new com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$initView$1$4$1$1
                r5.<init>(r0, r6)
                com.nostra13.universalimageloader.core.listener.ImageLoadingListener r5 = (com.nostra13.universalimageloader.core.listener.ImageLoadingListener) r5
                com.kakaogame.p029ui.ImageDownloader.displayImage(r3, r4, r5)
                if (r3 != 0) goto L63
            L5c:
                android.widget.RelativeLayout r3 = r0.zinnySdkPromotionEndingPopupContent
                r3.setVisibility(r2)
                kotlin.Unit r3 = kotlin.Unit.INSTANCE
            L63:
                if (r1 != 0) goto L6c
            L65:
                android.widget.RelativeLayout r1 = r0.zinnySdkPromotionEndingPopupContent
                r1.setVisibility(r2)
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
            L6c:
                android.widget.RelativeLayout r0 = r0.getRoot()
                android.view.View r0 = (android.view.View) r0
                r6.setContentView(r0)
                return
                fill-array 0x0076: FILL_ARRAY_DATA , data: ?
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.promotion.EndingPromotionManager.EndingPopupDialog.initView():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void initView$lambda$9$lambda$1(EndingPopupDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismiss();
            AppUtil.terminateApp(this$0.activity);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void initView$lambda$9$lambda$2(EndingPopupDialog this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.dismiss();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void initView$lambda$9$lambda$4(ZinnySdkPromotionEndingPopupBinding this_apply, Animation animation, EndingPopupDialog this$0, DialogInterface dialogInterface) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this_apply.zinnySdkPromotionEndingPopupProgress.getVisibility() != 8) {
                this_apply.zinnySdkPromotionEndingPopupProgress.startAnimation(animation);
                KGPromotionData kGPromotionData = this$0.promotion;
                if (kGPromotionData == null || kGPromotionData.getApplyType() != KGPromotionData.KGPromotionApplyType.SHOW) {
                    return;
                }
                kGPromotionData.apply(null);
            }
        }
    }
}
