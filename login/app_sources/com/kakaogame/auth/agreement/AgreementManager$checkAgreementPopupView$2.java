package com.kakaogame.auth.agreement;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.auth.agreement.AgreementManager;
import com.liapp.y;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AgreementManager.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@"}, m839d2 = {"<anonymous>", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.auth.agreement.AgreementManager$checkAgreementPopupView$2", m855f = "AgreementManager.kt", m856i = {}, m857l = {162}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class AgreementManager$checkAgreementPopupView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KGResult<Void>>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Map<String, Object> $agreementParams;
    final /* synthetic */ AgreementManager.AgreementCheckType $checkType;
    final /* synthetic */ int $traceJobId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AgreementManager$checkAgreementPopupView$2(Activity activity, AgreementManager.AgreementCheckType agreementCheckType, Map<String, Object> map, int i, Continuation<? super AgreementManager$checkAgreementPopupView$2> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$checkType = agreementCheckType;
        this.$agreementParams = map;
        this.$traceJobId = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AgreementManager$checkAgreementPopupView$2(this.$activity, this.$checkType, this.$agreementParams, this.$traceJobId, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KGResult<Void>> continuation) {
        return ((AgreementManager$checkAgreementPopupView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = AgreementManager.INSTANCE.showAgreement(this.$activity, this.$checkType, this.$agreementParams, this.$traceJobId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
