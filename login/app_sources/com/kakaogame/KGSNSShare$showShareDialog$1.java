package com.kakaogame;

import android.app.Activity;
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

/* compiled from: KGSNSShare.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGSNSShare$showShareDialog$1", m855f = "KGSNSShare.kt", m856i = {}, m857l = {738}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGSNSShare$showShareDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGResultCallback<Void> $callback;
    final /* synthetic */ String $code;
    final /* synthetic */ SNSShareData $data;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGSNSShare$showShareDialog$1(Activity activity, SNSShareData sNSShareData, String str, KGResultCallback<Void> kGResultCallback, Continuation<? super KGSNSShare$showShareDialog$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$data = sNSShareData;
        this.$code = str;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGSNSShare$showShareDialog$1(this.$activity, this.$data, this.$code, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGSNSShare$showShareDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BasicLogService.writeBasicActionLog(this.$activity, y.٬ݯح׭٩(575673646), y.֬ڱܱײٮ(-1159491839), y.ݮڮֲڭܩ(-628628076), y.ݬֲ֮ܲت(1512765831), null, null, null);
            SNSShareData.ShareInfo shareData = this.$data.getShareData(SNSShareData.SNSShareType.linkShare);
            Intrinsics.checkNotNull(shareData);
            String linkUrl = shareData.getLinkUrl(this.$code);
            String firstHashtag = shareData.getFirstHashtag(this.$code);
            Activity activity = this.$activity;
            Intrinsics.checkNotNull(linkUrl);
            KGResult<Void> facebookShareLink = ChannelConnectHelper.facebookShareLink(activity, linkUrl, firstHashtag);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C23591(facebookShareLink, this.$activity, this.$data, this.$code, this.$callback, null), this) == coroutine_suspended) {
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

    /* compiled from: KGSNSShare.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGSNSShare$showShareDialog$1$1", m855f = "KGSNSShare.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGSNSShare$showShareDialog$1$1 */
    static final class C23591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ KGResultCallback<Void> $callback;
        final /* synthetic */ String $code;
        final /* synthetic */ SNSShareData $data;
        final /* synthetic */ KGResult<Void> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C23591(KGResult<Void> kGResult, Activity activity, SNSShareData sNSShareData, String str, KGResultCallback<Void> kGResultCallback, Continuation<? super C23591> continuation) {
            super(2, continuation);
            this.$result = kGResult;
            this.$activity = activity;
            this.$data = sNSShareData;
            this.$code = str;
            this.$callback = kGResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23591(this.$result, this.$activity, this.$data, this.$code, this.$callback, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            KGResult<Void> kGResult = this.$result;
            if (kGResult.isSuccess()) {
                BasicLogService.writeBasicActionLog(this.$activity, y.٬ݯح׭٩(575673646), y.֬ڱܱײٮ(-1159492431), y.ݮڮֲڭܩ(-628628076), y.ݬֲ֮ܲت(1512765831), null, null, null);
                KGResult<Void> sendRequestSNSShareReward = PromotionService.sendRequestSNSShareReward(this.$data.getSeq(), SNSShareData.SNSShareType.linkShare, this.$code);
                if (!sendRequestSNSShareReward.isSuccess()) {
                    kGResult = sendRequestSNSShareReward;
                }
            }
            KGResultCallback<Void> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(kGResult);
            }
            return Unit.INSTANCE;
        }
    }
}
