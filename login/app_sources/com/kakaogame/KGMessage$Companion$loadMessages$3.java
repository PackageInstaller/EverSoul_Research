package com.kakaogame;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kakaogame.KGMessage;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import java.util.List;
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

/* compiled from: KGMessage.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGMessage$Companion$loadMessages$3", m855f = "KGMessage.kt", m856i = {}, m857l = {TypedValues.PositionType.TYPE_SIZE_PERCENT}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGMessage$Companion$loadMessages$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KGResultCallback<KGMessage.KGMessageResponse> $callback;
    final /* synthetic */ int $count;
    final /* synthetic */ String $messageBoxId;
    final /* synthetic */ long $pageKey;
    final /* synthetic */ List<KGMessage.KGMessageState> $states;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGMessage$Companion$loadMessages$3(String str, List<? extends KGMessage.KGMessageState> list, long j, int i, KGResultCallback<KGMessage.KGMessageResponse> kGResultCallback, Continuation<? super KGMessage$Companion$loadMessages$3> continuation) {
        super(2, continuation);
        this.$messageBoxId = str;
        this.$states = list;
        this.$pageKey = j;
        this.$count = i;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGMessage$Companion$loadMessages$3(this.$messageBoxId, this.$states, this.$pageKey, this.$count, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGMessage$Companion$loadMessages$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult loadMessages;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            loadMessages = KGMessage.INSTANCE.loadMessages(this.$messageBoxId, this.$states, this.$pageKey, this.$count);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C23411(this.$callback, loadMessages, null), this) == coroutine_suspended) {
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

    /* compiled from: KGMessage.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGMessage$Companion$loadMessages$3$1", m855f = "KGMessage.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGMessage$Companion$loadMessages$3$1 */
    static final class C23411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<KGMessage.KGMessageResponse> $callback;
        final /* synthetic */ KGResult<KGMessage.KGMessageResponse> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C23411(KGResultCallback<KGMessage.KGMessageResponse> kGResultCallback, KGResult<KGMessage.KGMessageResponse> kGResult, Continuation<? super C23411> continuation) {
            super(2, continuation);
            this.$callback = kGResultCallback;
            this.$result = kGResult;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23411(this.$callback, this.$result, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                String str = y.٬ݯح׭٩(575771910) + this.$result;
                String str2 = y.ٲٴݴ״ٰ(1782008680);
                logger.m704i(str2, str);
                this.$callback.onResult(this.$result);
                FirebaseEvent.INSTANCE.sendEvent(str2, y.ݮڮֲڭܩ(-628727284), this.$result);
            }
            return Unit.INSTANCE;
        }
    }
}
