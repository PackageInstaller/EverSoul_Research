package com.kakaogame.security;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.secondpw.ActionType;
import com.kakaogame.secondpw.SecondPWViewManager;
import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProtectionManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.security.ProtectionManager$isAllowedAccessOnEngine$2$1", m855f = "ProtectionManager.kt", m856i = {}, m857l = {225}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class ProtectionManager$isAllowedAccessOnEngine$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<KGResult<Base2ndPWViewData>> $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ProtectionManager$isAllowedAccessOnEngine$2$1(Activity activity, Continuation<? super KGResult<Base2ndPWViewData>> continuation, Continuation<? super ProtectionManager$isAllowedAccessOnEngine$2$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$it = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProtectionManager$isAllowedAccessOnEngine$2$1(this.$activity, this.$it, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProtectionManager$isAllowedAccessOnEngine$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = SecondPWViewManager.getKeypadData$default(SecondPWViewManager.INSTANCE, this.$activity, 0, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
        }
        KGResult kGResult = (KGResult) obj;
        if (kGResult.isSuccess()) {
            SecondPWViewManager secondPWViewManager = SecondPWViewManager.INSTANCE;
            Activity activity = this.$activity;
            ActionType actionType = ActionType.ENTER_IS_ALLOWED_ACCESS;
            final Continuation<KGResult<Base2ndPWViewData>> continuation = this.$it;
            SecondPWViewManager.getUIData$default(secondPWViewManager, activity, actionType, null, new Function1<Base2ndPWViewData, Unit>() { // from class: com.kakaogame.security.ProtectionManager$isAllowedAccessOnEngine$2$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(1);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Base2ndPWViewData base2ndPWViewData) {
                    invoke2(base2ndPWViewData);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Base2ndPWViewData base2ndPWViewData) {
                    Intrinsics.checkNotNullParameter(base2ndPWViewData, y.٬ݯح׭٩(576439206));
                    if (base2ndPWViewData.isResult() && base2ndPWViewData.getResultCode() != 200) {
                        Continuation<KGResult<Base2ndPWViewData>> continuation2 = continuation;
                        Result.Companion companion = Result.INSTANCE;
                        continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(base2ndPWViewData.getResultCode())));
                    } else {
                        Continuation<KGResult<Base2ndPWViewData>> continuation3 = continuation;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult(base2ndPWViewData)));
                    }
                }
            }, 4, null);
        } else {
            Continuation<KGResult<Base2ndPWViewData>> continuation2 = this.$it;
            Result.Companion companion = Result.INSTANCE;
            continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(kGResult)));
        }
        return Unit.INSTANCE;
    }
}
