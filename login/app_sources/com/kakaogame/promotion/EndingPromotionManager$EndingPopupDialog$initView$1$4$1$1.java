package com.kakaogame.promotion;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.kakaogame.Logger;
import com.kakaogame.databinding.ZinnySdkPromotionEndingPopupBinding;
import com.kakaogame.promotion.EndingPromotionManager;
import com.liapp.y;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EndingPromotionManager.kt */
@Metadata(m838d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, m839d2 = {"com/kakaogame/promotion/EndingPromotionManager$EndingPopupDialog$initView$1$4$1$1", "Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;", "onLoadingCancelled", "", "imageUri", "", "arg1", "Landroid/view/View;", "onLoadingComplete", "arg2", "Landroid/graphics/Bitmap;", "onLoadingFailed", "Lcom/nostra13/universalimageloader/core/assist/FailReason;", "onLoadingStarted", "gamesdk_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class EndingPromotionManager$EndingPopupDialog$initView$1$4$1$1 implements ImageLoadingListener {
    final /* synthetic */ ZinnySdkPromotionEndingPopupBinding $this_apply;
    final /* synthetic */ EndingPromotionManager.EndingPopupDialog this$0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
    public void onLoadingCancelled(String imageUri, View arg1) {
        Intrinsics.checkNotNullParameter(imageUri, y.ۮڭڭܬި(862302395));
        Intrinsics.checkNotNullParameter(arg1, "arg1");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EndingPromotionManager$EndingPopupDialog$initView$1$4$1$1(ZinnySdkPromotionEndingPopupBinding zinnySdkPromotionEndingPopupBinding, EndingPromotionManager.EndingPopupDialog endingPopupDialog) {
        this.$this_apply = zinnySdkPromotionEndingPopupBinding;
        this.this$0 = endingPopupDialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
    public void onLoadingComplete(String imageUri, View arg1, Bitmap arg2) {
        Intrinsics.checkNotNullParameter(imageUri, y.ۮڭڭܬި(862302395));
        Intrinsics.checkNotNullParameter(arg1, "arg1");
        Intrinsics.checkNotNullParameter(arg2, "arg2");
        Logger.INSTANCE.m699d("EndingPopupDialog", "onLoadingComplete");
        ImageView imageView = this.$this_apply.zinnySdkPromotionEndingPopupImage;
        final EndingPromotionManager.EndingPopupDialog endingPopupDialog = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.promotion.EndingPromotionManager$EndingPopupDialog$initView$1$4$1$1$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EndingPromotionManager$EndingPopupDialog$initView$1$4$1$1.onLoadingComplete$lambda$0(EndingPromotionManager.EndingPopupDialog.this, view);
            }
        });
        this.$this_apply.zinnySdkPromotionEndingPopupProgress.setVisibility(8);
        this.$this_apply.zinnySdkPromotionEndingPopupProgress.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void onLoadingComplete$lambda$0(EndingPromotionManager.EndingPopupDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleClick();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
    public void onLoadingFailed(String imageUri, View arg1, FailReason arg2) {
        Intrinsics.checkNotNullParameter(imageUri, y.ۮڭڭܬި(862302395));
        Intrinsics.checkNotNullParameter(arg1, y.ٲٴݴ״ٰ(1782213664));
        Intrinsics.checkNotNullParameter(arg2, "arg2");
        Logger.INSTANCE.m701e("EndingPopupDialog", y.ٲٴݴ״ٰ(1782213744) + imageUri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
    public void onLoadingStarted(String imageUri, View arg1) {
        Intrinsics.checkNotNullParameter(imageUri, y.ۮڭڭܬި(862302395));
        Intrinsics.checkNotNullParameter(arg1, y.ٲٴݴ״ٰ(1782213664));
        Logger.INSTANCE.m699d(y.ٴسسݬߨ(1393511618), y.ٴسسݬߨ(1393521570) + imageUri);
    }
}
