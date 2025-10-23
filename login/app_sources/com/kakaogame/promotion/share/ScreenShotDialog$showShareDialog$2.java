package com.kakaogame.promotion.share;

import android.app.Activity;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.databinding.KakaoGameSdkShareScreenshotBinding;
import com.kakaogame.idp.ChannelConnectHelper;
import com.kakaogame.log.service.BasicLogService;
import com.kakaogame.promotion.PromotionService;
import com.kakaogame.promotion.SNSShareData;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: ScreenShotDialog.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.promotion.share.ScreenShotDialog$showShareDialog$2", m855f = "ScreenShotDialog.kt", m856i = {}, m857l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class ScreenShotDialog$showShareDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SNSShareData $data;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ ScreenShotDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ScreenShotDialog$showShareDialog$2(ScreenShotDialog screenShotDialog, SNSShareData sNSShareData, String str, Continuation<? super ScreenShotDialog$showShareDialog$2> continuation) {
        super(2, continuation);
        this.this$0 = screenShotDialog;
        this.$data = sNSShareData;
        this.$path = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScreenShotDialog$showShareDialog$2(this.this$0, this.$data, this.$path, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ScreenShotDialog$showShareDialog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasicLogService.writeBasicActionLog(this.this$0.getOwnerActivity(), y.٬ݯح׭٩(575673646), y.֬ڱܱײٮ(-1159491839), y.دײܮڳܯ(2051139965), y.ݬֲ֮ܲت(1512765831), null, null, null);
            SNSShareData.ShareInfo shareData = this.$data.getShareData(SNSShareData.SNSShareType.nonLinkShare);
            Intrinsics.checkNotNull(shareData);
            String firstHashtag = shareData.getFirstHashtag();
            Activity ownerActivity = this.this$0.getOwnerActivity();
            String str = this.$path;
            Intrinsics.checkNotNullExpressionValue(str, y.دײܮڳܯ(2051139869));
            KGResult<Void> facebookShareImage = ChannelConnectHelper.facebookShareImage(ownerActivity, str, firstHashtag);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C24411(this.this$0, facebookShareImage, this.$data, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: ScreenShotDialog.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.promotion.share.ScreenShotDialog$showShareDialog$2$1", m855f = "ScreenShotDialog.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.promotion.share.ScreenShotDialog$showShareDialog$2$1 */
    static final class C24411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SNSShareData $data;
        final /* synthetic */ KGResult<Void> $result;
        int label;
        final /* synthetic */ ScreenShotDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24411(ScreenShotDialog screenShotDialog, KGResult<Void> kGResult, SNSShareData sNSShareData, Continuation<? super C24411> continuation) {
            super(2, continuation);
            this.this$0 = screenShotDialog;
            this.$result = kGResult;
            this.$data = sNSShareData;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24411(this.this$0, this.$result, this.$data, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            boolean z2;
            KakaoGameSdkShareScreenshotBinding kakaoGameSdkShareScreenshotBinding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                z = this.this$0.isNative;
                if (!z) {
                    kakaoGameSdkShareScreenshotBinding = this.this$0.binding;
                    if (kakaoGameSdkShareScreenshotBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        kakaoGameSdkShareScreenshotBinding = null;
                    }
                    kakaoGameSdkShareScreenshotBinding.kakaoGameSdkScreenshotResultImage.setVisibility(8);
                }
                this.this$0.setProgressSharing(false);
                Logger.INSTANCE.m699d(y.֬ڱܱײٮ(-1159153855), y.٬ݯح׭٩(576400838) + this.$result.getCode());
                if (this.$result.isSuccess()) {
                    BasicLogService.writeBasicActionLog(this.this$0.getOwnerActivity(), y.٬ݯح׭٩(575673646), y.֬ڱܱײٮ(-1159492431), y.دײܮڳܯ(2051139965), y.ݬֲ֮ܲت(1512765831), null, null, null);
                    this.this$0.resultCode = this.$result.getCode();
                    KGResult<Void> sendRequestSNSShareReward = PromotionService.sendRequestSNSShareReward(this.$data.getSeq(), SNSShareData.SNSShareType.nonLinkShare, null);
                    if (!sendRequestSNSShareReward.isSuccess()) {
                        this.this$0.resultCode = sendRequestSNSShareReward.getCode();
                    }
                    this.this$0.dismiss();
                } else if (this.$result.getCode() == 8001) {
                    this.this$0.resultCode = this.$result.getCode();
                    this.this$0.dismiss();
                } else if (this.$result.getCode() == 9001) {
                    z2 = this.this$0.isNative;
                    if (!z2) {
                        this.this$0.resultCode = KGResult.KGResultCode.REQUEST_REOPEN;
                        this.this$0.dismiss();
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
    }
}
