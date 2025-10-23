package com.kakaogame;

import android.app.Activity;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KGSupport.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGSupport$showInAppWebView$1", m855f = "KGSupport.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGSupport$showInAppWebView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGResultCallback<String> $callback;
    final /* synthetic */ FirebaseEvent $fbEvent;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGSupport$showInAppWebView$1(Activity activity, String str, KGResultCallback<String> kGResultCallback, FirebaseEvent firebaseEvent, Continuation<? super KGSupport$showInAppWebView$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$url = str;
        this.$callback = kGResultCallback;
        this.$fbEvent = firebaseEvent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGSupport$showInAppWebView$1(this.$activity, this.$url, this.$callback, this.$fbEvent, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGSupport$showInAppWebView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object runBlocking$default;
        KGResult<String> kGResult;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        if (this.$activity == null) {
            kGResult = KGResult.INSTANCE.getResult(4000, y.ٴسسݬߨ(1392634106));
        } else {
            String str = this.$url;
            if (!(str == null || str.length() == 0)) {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGSupport$showInAppWebView$1$result$1(this.$activity, this.$url, null), 1, null);
                kGResult = (KGResult) runBlocking$default;
            } else {
                Logger.INSTANCE.m701e(y.ݬֲ֮ܲت(1512722991), y.ٲٴݴ״ٰ(1781951152) + this.$url);
                kGResult = KGResult.INSTANCE.getResult(4000, y.ݬֲ֮ܲت(1512725815));
            }
        }
        KGResultCallback<String> kGResultCallback = this.$callback;
        if (kGResultCallback != null) {
            kGResultCallback.onResult(kGResult);
        }
        this.$fbEvent.setResult(kGResult);
        return Unit.INSTANCE;
    }
}
