package com.kakaogame.auth.agreement;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.auth.agreement.AgreementManager;
import com.kakaogame.util.AppUtil;
import com.liapp.y;
import java.util.Map;
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

/* compiled from: AgreementManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.auth.agreement.AgreementManager$showAgreement$2$1$1", m855f = "AgreementManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class AgreementManager$showAgreement$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Map<String, Object> $agreementParams;
    final /* synthetic */ AgreementManager.AgreementCheckType $checkType;
    final /* synthetic */ Continuation<KGResult<Void>> $cont;
    final /* synthetic */ int $traceJobId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AgreementManager$showAgreement$2$1$1(Activity activity, AgreementManager.AgreementCheckType agreementCheckType, Map<String, ? extends Object> map, int i, Continuation<? super KGResult<Void>> continuation, Continuation<? super AgreementManager$showAgreement$2$1$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$checkType = agreementCheckType;
        this.$agreementParams = map;
        this.$traceJobId = i;
        this.$cont = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AgreementManager$showAgreement$2$1$1(this.$activity, this.$checkType, this.$agreementParams, this.$traceJobId, this.$cont, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AgreementManager$showAgreement$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        Activity activity = this.$activity;
        AgreementManager.AgreementCheckType agreementCheckType = this.$checkType;
        Map<String, Object> map = this.$agreementParams;
        int i = this.$traceJobId;
        final Activity activity2 = this.$activity;
        final AgreementManager.AgreementCheckType agreementCheckType2 = this.$checkType;
        final int i2 = this.$traceJobId;
        final Continuation<KGResult<Void>> continuation = this.$cont;
        new AgreementManager.AgreementDialog(activity, agreementCheckType, map, i, new Function1<KGResult<String>, Unit>() { // from class: com.kakaogame.auth.agreement.AgreementManager$showAgreement$2$1$1$dialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KGResult<String> kGResult) {
                invoke2(kGResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KGResult<String> kGResult) {
                Intrinsics.checkNotNullParameter(kGResult, y.ٲٴݴ״ٰ(1782134480));
                if (kGResult.isSuccess()) {
                    String content = kGResult.getContent();
                    Intrinsics.checkNotNull(content);
                    AgreementManager.setAgreements(activity2, content);
                    if (agreementCheckType2 == AgreementManager.AgreementCheckType.AUTO_LOGIN) {
                        AgreementManager.saveAgreementInfo(activity2, i2);
                    }
                    Continuation<KGResult<Void>> continuation2 = continuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getSuccessResult()));
                    return;
                }
                if (kGResult.getCode() == 9900) {
                    AppUtil.terminateApp(activity2);
                }
                Continuation<KGResult<Void>> continuation3 = continuation;
                Result.Companion companion2 = Result.INSTANCE;
                continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(kGResult)));
            }
        }).show();
        return Unit.INSTANCE;
    }
}
