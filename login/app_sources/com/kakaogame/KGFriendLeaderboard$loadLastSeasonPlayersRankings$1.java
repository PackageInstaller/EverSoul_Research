package com.kakaogame;

import com.kakaogame.KGFriendLeaderboard;
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

/* compiled from: KGFriendLeaderboard.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGFriendLeaderboard$loadLastSeasonPlayersRankings$1", m855f = "KGFriendLeaderboard.kt", m856i = {}, m857l = {115}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGFriendLeaderboard$loadLastSeasonPlayersRankings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KGResultCallback<KGFriendLeaderboard.KGFriendRankingResponse> $callback;
    final /* synthetic */ String $leaderboardId;
    final /* synthetic */ List<String> $playerIds;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGFriendLeaderboard$loadLastSeasonPlayersRankings$1(List<String> list, String str, KGResultCallback<KGFriendLeaderboard.KGFriendRankingResponse> kGResultCallback, Continuation<? super KGFriendLeaderboard$loadLastSeasonPlayersRankings$1> continuation) {
        super(2, continuation);
        this.$playerIds = list;
        this.$leaderboardId = str;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGFriendLeaderboard$loadLastSeasonPlayersRankings$1(this.$playerIds, this.$leaderboardId, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGFriendLeaderboard$loadLastSeasonPlayersRankings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult loadPlayersRankings;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            loadPlayersRankings = KGFriendLeaderboard.INSTANCE.loadPlayersRankings((List<String>) this.$playerIds, this.$leaderboardId, -1);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C22731(loadPlayersRankings, this.$callback, null), this) == coroutine_suspended) {
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

    /* compiled from: KGFriendLeaderboard.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGFriendLeaderboard$loadLastSeasonPlayersRankings$1$1", m855f = "KGFriendLeaderboard.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGFriendLeaderboard$loadLastSeasonPlayersRankings$1$1 */
    static final class C22731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<KGFriendLeaderboard.KGFriendRankingResponse> $callback;
        final /* synthetic */ KGResult<KGFriendLeaderboard.KGFriendRankingResponse> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C22731(KGResult<KGFriendLeaderboard.KGFriendRankingResponse> kGResult, KGResultCallback<KGFriendLeaderboard.KGFriendRankingResponse> kGResultCallback, Continuation<? super C22731> continuation) {
            super(2, continuation);
            this.$result = kGResult;
            this.$callback = kGResultCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22731(this.$result, this.$callback, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.INSTANCE;
            String str = y.دײܮڳܯ(2051552749) + this.$result;
            String str2 = y.ݬֲ֮ܲت(1512576175);
            logger.m704i(str2, str);
            KGResultCallback<KGFriendLeaderboard.KGFriendRankingResponse> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(this.$result);
            }
            FirebaseEvent.INSTANCE.sendEvent(str2, y.ݬֲ֮ܲت(1512578991), this.$result);
            return Unit.INSTANCE;
        }
    }
}
