package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGSession;
import com.kakaogame.core.CoreImpl;
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

/* compiled from: KGSession.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGSession$loadAppInfos$1", m855f = "KGSession.kt", m856i = {0}, m857l = {134}, m858m = "invokeSuspend", m859n = {"result"}, m860s = {"L$0"})
/* loaded from: classes3.dex */
final class KGSession$loadAppInfos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGResultCallback<List<KGSession.KGAppInfo>> $callback;
    final /* synthetic */ FirebaseEvent $fbEvent;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGSession$loadAppInfos$1(Activity activity, FirebaseEvent firebaseEvent, KGResultCallback<List<KGSession.KGAppInfo>> kGResultCallback, Continuation<? super KGSession$loadAppInfos$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$fbEvent = firebaseEvent;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGSession$loadAppInfos$1(this.$activity, this.$fbEvent, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGSession$loadAppInfos$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult<List<KGSession.KGAppInfo>> kGResult;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGResult<List<KGSession.KGAppInfo>> loadAppInfos = CoreImpl.loadAppInfos(this.$activity);
            this.L$0 = loadAppInfos;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C23611(loadAppInfos, this.$callback, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            kGResult = loadAppInfos;
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            kGResult = (KGResult) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        this.$fbEvent.setTraceResult(kGResult);
        return Unit.INSTANCE;
    }

    /* compiled from: KGSession.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGSession$loadAppInfos$1$1", m855f = "KGSession.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGSession$loadAppInfos$1$1 */
    static final class C23611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<List<KGSession.KGAppInfo>> $callback;
        final /* synthetic */ KGResult<List<KGSession.KGAppInfo>> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C23611(KGResult<List<KGSession.KGAppInfo>> kGResult, KGResultCallback<List<KGSession.KGAppInfo>> kGResultCallback, Continuation<? super C23611> continuation) {
            super(2, continuation);
            this.$result = kGResult;
            this.$callback = kGResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23611(this.$result, this.$callback, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            Logger.INSTANCE.m704i(y.ٴسسݬߨ(1392718866), y.دײܮڳܯ(2051683645) + this.$result);
            KGResultCallback<List<KGSession.KGAppInfo>> kGResultCallback = this.$callback;
            if (kGResultCallback == null) {
                return null;
            }
            kGResultCallback.onResult(this.$result);
            return Unit.INSTANCE;
        }
    }
}
