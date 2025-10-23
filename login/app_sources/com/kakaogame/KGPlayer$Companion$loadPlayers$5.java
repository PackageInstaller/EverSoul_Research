package com.kakaogame;

import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import java.util.List;
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

/* compiled from: KGPlayer.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGPlayer$Companion$loadPlayers$5", m855f = "KGPlayer.kt", m856i = {}, m857l = {295}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGPlayer$Companion$loadPlayers$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KGResultCallback<Map<String, KGPlayer>> $callback;
    final /* synthetic */ List<String> $playerIds;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGPlayer$Companion$loadPlayers$5(List<String> list, KGResultCallback<Map<String, KGPlayer>> kGResultCallback, Continuation<? super KGPlayer$Companion$loadPlayers$5> continuation) {
        super(2, continuation);
        this.$playerIds = list;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGPlayer$Companion$loadPlayers$5(this.$playerIds, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGPlayer$Companion$loadPlayers$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGResult<Map<String, KGPlayer>> loadPlayers = KGPlayer.INSTANCE.loadPlayers(this.$playerIds);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C23471(this.$callback, loadPlayers, null), this) == coroutine_suspended) {
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

    /* compiled from: KGPlayer.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGPlayer$Companion$loadPlayers$5$1", m855f = "KGPlayer.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGPlayer$Companion$loadPlayers$5$1 */
    static final class C23471 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<Map<String, KGPlayer>> $callback;
        final /* synthetic */ KGResult<Map<String, KGPlayer>> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C23471(KGResultCallback<Map<String, KGPlayer>> kGResultCallback, KGResult<Map<String, KGPlayer>> kGResult, Continuation<? super C23471> continuation) {
            super(2, continuation);
            this.$callback = kGResultCallback;
            this.$result = kGResult;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23471(this.$callback, this.$result, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23471) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            if (this.$callback != null) {
                Logger logger = Logger.INSTANCE;
                String str = y.֬ڱܱײٮ(-1159469399) + this.$result;
                String str2 = y.ۮڭڭܬި(862442395);
                logger.m704i(str2, str);
                this.$callback.onResult(this.$result);
                FirebaseEvent.INSTANCE.sendEvent(str2, y.ٴسسݬߨ(1392751666), this.$result);
            }
            return Unit.INSTANCE;
        }
    }
}
