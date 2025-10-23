package com.kakaogame.auth.view;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.auth.view.LoginUIManager;
import com.liapp.y;
import java.util.List;
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

/* compiled from: LoginUIManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.auth.view.LoginUIManager$showLoginPopup$2$1", m855f = "LoginUIManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class LoginUIManager$showLoginPopup$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<KGResult<Void>> $cont;
    final /* synthetic */ List<String> $idpCodes;
    final /* synthetic */ LoginUIManager.RequestType $requestType;
    final /* synthetic */ int $traceJobId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LoginUIManager$showLoginPopup$2$1(Activity activity, List<String> list, LoginUIManager.RequestType requestType, int i, Continuation<? super KGResult<Void>> continuation, Continuation<? super LoginUIManager$showLoginPopup$2$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$idpCodes = list;
        this.$requestType = requestType;
        this.$traceJobId = i;
        this.$cont = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginUIManager$showLoginPopup$2$1(this.$activity, this.$idpCodes, this.$requestType, this.$traceJobId, this.$cont, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginUIManager$showLoginPopup$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        LoginUIManager loginUIManager = LoginUIManager.INSTANCE;
        Activity activity = this.$activity;
        List<String> list = this.$idpCodes;
        LoginUIManager.RequestType requestType = this.$requestType;
        int i = this.$traceJobId;
        final Continuation<KGResult<Void>> continuation = this.$cont;
        loginUIManager.showLoginDialog(activity, list, requestType, i, new Function1<KGResult<Void>, Unit>() { // from class: com.kakaogame.auth.view.LoginUIManager$showLoginPopup$2$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KGResult<Void> kGResult) {
                invoke2(kGResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KGResult<Void> kGResult) {
                Intrinsics.checkNotNullParameter(kGResult, y.ٲٴݴ״ٰ(1782134480));
                Continuation<KGResult<Void>> continuation2 = continuation;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m1440constructorimpl(kGResult));
            }
        });
        return Unit.INSTANCE;
    }
}
