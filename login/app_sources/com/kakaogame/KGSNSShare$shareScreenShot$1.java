package com.kakaogame;

import android.app.Activity;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.promotion.share.ScreenShotDialog;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KGSNSShare.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGSNSShare$shareScreenShot$1", m855f = "KGSNSShare.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGSNSShare$shareScreenShot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGResultCallback<Void> $callback;
    final /* synthetic */ FirebaseEvent $fbEvent;
    final /* synthetic */ boolean $isNative;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGSNSShare$shareScreenShot$1(Activity activity, boolean z, KGResultCallback<Void> kGResultCallback, FirebaseEvent firebaseEvent, Continuation<? super KGSNSShare$shareScreenShot$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$isNative = z;
        this.$callback = kGResultCallback;
        this.$fbEvent = firebaseEvent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGSNSShare$shareScreenShot$1(this.$activity, this.$isNative, this.$callback, this.$fbEvent, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGSNSShare$shareScreenShot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        try {
            Activity activity = this.$activity;
            boolean z = this.$isNative;
            final KGResultCallback<Void> kGResultCallback = this.$callback;
            final FirebaseEvent firebaseEvent = this.$fbEvent;
            new ScreenShotDialog(activity, z, new KGResultCallback<Void>() { // from class: com.kakaogame.KGSNSShare$shareScreenShot$1$screenShotDialog$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGResultCallback
                public void onResult(KGResult<Void> result) {
                    KGResultCallback<Void> kGResultCallback2 = kGResultCallback;
                    if (kGResultCallback2 != null) {
                        kGResultCallback2.onResult(result);
                    }
                    firebaseEvent.setResult(result);
                }
            }).show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݬֲ֮ܲت(1512767087), e.toString(), e);
            KGResult<Void> result = KGResult.INSTANCE.getResult(4001, e.toString());
            KGResultCallback<Void> kGResultCallback2 = this.$callback;
            if (kGResultCallback2 != null) {
                kGResultCallback2.onResult(result);
            }
            this.$fbEvent.setResult(result);
        }
        return Unit.INSTANCE;
    }
}
