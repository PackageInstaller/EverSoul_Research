package com.kakaogame.log.service;

import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.core.CoreManager;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BasicLogService.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.log.service.BasicLogService$writeBasicLog$1", m855f = "BasicLogService.kt", m856i = {}, m857l = {101}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class BasicLogService$writeBasicLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $body;
    final /* synthetic */ KGResultCallback<Map<String, Object>> $callback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BasicLogService$writeBasicLog$1(Map<String, ? extends Object> map, KGResultCallback<Map<String, Object>> kGResultCallback, Continuation<? super BasicLogService$writeBasicLog$1> continuation) {
        super(2, continuation);
        this.$body = map;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BasicLogService$writeBasicLog$1(this.$body, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BasicLogService$writeBasicLog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGResult writeBasicLogUsingOpenApi = (CoreManager.INSTANCE.getInstance().isAuthorized() || !CoreManager.INSTANCE.getInstance().isPaused()) ? BasicLogService.INSTANCE.writeBasicLogUsingOpenApi(this.$body) : BasicLogService.INSTANCE.writeBasicLogUsingSession(this.$body);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C24211(this.$callback, writeBasicLogUsingOpenApi, this.$body, null), this) == coroutine_suspended) {
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

    /* compiled from: BasicLogService.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.log.service.BasicLogService$writeBasicLog$1$1", m855f = "BasicLogService.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.log.service.BasicLogService$writeBasicLog$1$1 */
    static final class C24211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, Object> $body;
        final /* synthetic */ KGResultCallback<Map<String, Object>> $callback;
        final /* synthetic */ KGResult<Void> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24211(KGResultCallback<Map<String, Object>> kGResultCallback, KGResult<Void> kGResult, Map<String, ? extends Object> map, Continuation<? super C24211> continuation) {
            super(2, continuation);
            this.$callback = kGResultCallback;
            this.$result = kGResult;
            this.$body = map;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24211(this.$callback, this.$result, this.$body, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            KGResultCallback<Map<String, Object>> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(KGResult.INSTANCE.getResult(this.$result.getCode(), this.$result.getDescription(), this.$body));
            }
            return Unit.INSTANCE;
        }
    }
}
