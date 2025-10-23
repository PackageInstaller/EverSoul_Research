package com.kakaogame.idp;

import android.app.Dialog;
import android.content.DialogInterface;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KGGoogleAuth.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.idp.KGGoogleAuth$isGooglePlayServicesAvailable$1$1", m855f = "KGGoogleAuth.kt", m856i = {}, m857l = {348}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGGoogleAuth$isGooglePlayServicesAvailable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $it;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGGoogleAuth$isGooglePlayServicesAvailable$1$1(Dialog dialog, Continuation<? super KGGoogleAuth$isGooglePlayServicesAvailable$1$1> continuation) {
        super(2, continuation);
        this.$it = dialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGGoogleAuth$isGooglePlayServicesAvailable$1$1(this.$it, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGGoogleAuth$isGooglePlayServicesAvailable$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Dialog dialog = this.$it;
            this.L$0 = dialog;
            this.label = 1;
            KGGoogleAuth$isGooglePlayServicesAvailable$1$1 kGGoogleAuth$isGooglePlayServicesAvailable$1$1 = this;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(kGGoogleAuth$isGooglePlayServicesAvailable$1$1));
            final SafeContinuation safeContinuation2 = safeContinuation;
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.idp.KGGoogleAuth$isGooglePlayServicesAvailable$1$1$1$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    Continuation<Unit> continuation = safeContinuation2;
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m1440constructorimpl(Unit.INSTANCE));
                }
            });
            dialog.show();
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(kGGoogleAuth$isGooglePlayServicesAvailable$1$1);
            }
            if (orThrow == coroutine_suspended) {
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
}
