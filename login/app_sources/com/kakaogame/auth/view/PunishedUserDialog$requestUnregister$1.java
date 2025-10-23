package com.kakaogame.auth.view;

import com.kakaogame.KGResult;
import com.kakaogame.auth.AuthService;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: PunishedUserDialog.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.auth.view.PunishedUserDialog$requestUnregister$1", m855f = "PunishedUserDialog.kt", m856i = {}, m857l = {359}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class PunishedUserDialog$requestUnregister$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PunishedUserDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PunishedUserDialog$requestUnregister$1(PunishedUserDialog punishedUserDialog, Continuation<? super PunishedUserDialog$requestUnregister$1> continuation) {
        super(2, continuation);
        this.this$0 = punishedUserDialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PunishedUserDialog$requestUnregister$1(this.this$0, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PunishedUserDialog$requestUnregister$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGResult<Void> removeForPunishmentUser = AuthService.INSTANCE.removeForPunishmentUser(this.this$0.getOnetimeToken(), this.this$0.getUserId());
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C23931(this.this$0, removeForPunishmentUser, null), this) == coroutine_suspended) {
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

    /* compiled from: PunishedUserDialog.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.auth.view.PunishedUserDialog$requestUnregister$1$1", m855f = "PunishedUserDialog.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.auth.view.PunishedUserDialog$requestUnregister$1$1 */
    static final class C23931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResult<Void> $result;
        int label;
        final /* synthetic */ PunishedUserDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C23931(PunishedUserDialog punishedUserDialog, KGResult<Void> kGResult, Continuation<? super C23931> continuation) {
            super(2, continuation);
            this.this$0 = punishedUserDialog;
            this.$result = kGResult;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23931(this.this$0, this.$result, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.showUnregisterEnd(this.$result.getCode());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
    }
}
