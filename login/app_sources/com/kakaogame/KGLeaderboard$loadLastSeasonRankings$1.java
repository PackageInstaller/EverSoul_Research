package com.kakaogame;

import com.kakaogame.KGLeaderboard;
import com.kakaogame.log.FirebaseEvent;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGLeaderboard.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGLeaderboard$loadLastSeasonRankings$1", m855f = "KGLeaderboard.kt", m856i = {}, m857l = {147}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGLeaderboard$loadLastSeasonRankings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $beginRank;
    final /* synthetic */ KGResultCallback<KGLeaderboard.KGRankingResponse> $callback;
    final /* synthetic */ int $endRank;
    final /* synthetic */ String $leaderboardId;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGLeaderboard$loadLastSeasonRankings$1(String str, int i, int i2, KGResultCallback<KGLeaderboard.KGRankingResponse> kGResultCallback, Continuation<? super KGLeaderboard$loadLastSeasonRankings$1> continuation) {
        super(2, continuation);
        this.$leaderboardId = str;
        this.$beginRank = i;
        this.$endRank = i2;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGLeaderboard$loadLastSeasonRankings$1(this.$leaderboardId, this.$beginRank, this.$endRank, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGLeaderboard$loadLastSeasonRankings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult loadRankings;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            loadRankings = KGLeaderboard.INSTANCE.loadRankings(this.$leaderboardId, (String) null, -1, Boxing.boxInt(this.$beginRank), Boxing.boxInt(this.$endRank));
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C23181(this.$callback, loadRankings, null), this) == coroutine_suspended) {
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

    /* compiled from: KGLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGLeaderboard$loadLastSeasonRankings$1$1", m855f = "KGLeaderboard.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGLeaderboard$loadLastSeasonRankings$1$1 */
    static final class C23181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<KGLeaderboard.KGRankingResponse> $callback;
        final /* synthetic */ KGResult<KGLeaderboard.KGRankingResponse> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C23181(KGResultCallback<KGLeaderboard.KGRankingResponse> kGResultCallback, KGResult<KGLeaderboard.KGRankingResponse> kGResult, Continuation<? super C23181> continuation) {
            super(2, continuation);
            this.$callback = kGResultCallback;
            this.$result = kGResult;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23181(this.$callback, this.$result, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            KGResultCallback<KGLeaderboard.KGRankingResponse> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(this.$result);
            }
            FirebaseEvent.INSTANCE.sendEvent(y.֬ڱܱײٮ(-1159572759), y.دײܮڳܯ(2051737333), this.$result);
            return Unit.INSTANCE;
        }
    }
}
