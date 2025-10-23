package com.kakaogame;

import com.kakaogame.KGKakaoProfile;
import com.kakaogame.log.FirebaseEvent;
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

/* compiled from: KGKakaoProfile.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGKakaoProfile$Companion$loadInvitableFriendProfiles$2", m855f = "KGKakaoProfile.kt", m856i = {}, m857l = {437}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGKakaoProfile$Companion$loadInvitableFriendProfiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KGResultCallback<KGKakaoProfile.KGKakaoFriendsResponse> $callback;
    final /* synthetic */ int $limit;
    final /* synthetic */ int $offset;
    final /* synthetic */ int $recommendLimit;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGKakaoProfile$Companion$loadInvitableFriendProfiles$2(int i, int i2, int i3, KGResultCallback<KGKakaoProfile.KGKakaoFriendsResponse> kGResultCallback, Continuation<? super KGKakaoProfile$Companion$loadInvitableFriendProfiles$2> continuation) {
        super(2, continuation);
        this.$recommendLimit = i;
        this.$offset = i2;
        this.$limit = i3;
        this.$callback = kGResultCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGKakaoProfile$Companion$loadInvitableFriendProfiles$2(this.$recommendLimit, this.$offset, this.$limit, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGKakaoProfile$Companion$loadInvitableFriendProfiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        KGResult requestInvitableFriendProfiles;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            requestInvitableFriendProfiles = KGKakaoProfile.INSTANCE.requestInvitableFriendProfiles(this.$recommendLimit, this.$offset, this.$limit);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C22991(this.$callback, requestInvitableFriendProfiles, null), this) == coroutine_suspended) {
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

    /* compiled from: KGKakaoProfile.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGKakaoProfile$Companion$loadInvitableFriendProfiles$2$1", m855f = "KGKakaoProfile.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGKakaoProfile$Companion$loadInvitableFriendProfiles$2$1 */
    static final class C22991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<KGKakaoProfile.KGKakaoFriendsResponse> $callback;
        final /* synthetic */ KGResult<KGKakaoProfile.KGKakaoFriendsResponse> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C22991(KGResultCallback<KGKakaoProfile.KGKakaoFriendsResponse> kGResultCallback, KGResult<KGKakaoProfile.KGKakaoFriendsResponse> kGResult, Continuation<? super C22991> continuation) {
            super(2, continuation);
            this.$callback = kGResultCallback;
            this.$result = kGResult;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22991(this.$callback, this.$result, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22991) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            KGResultCallback<KGKakaoProfile.KGKakaoFriendsResponse> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(this.$result);
            }
            FirebaseEvent.INSTANCE.sendEvent(y.٬ݯح׭٩(575748342), y.ݬֲ֮ܲت(1512600543), this.$result);
            return Unit.INSTANCE;
        }
    }
}
