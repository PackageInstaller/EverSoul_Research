package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGResult;
import com.kakaogame.auth.AuthImpl;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGSessionForCustomUI.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGSessionForCustomUI$loginKakao$1", m855f = "KGSessionForCustomUI.kt", m856i = {}, m857l = {127}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGSessionForCustomUI$loginKakao$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ KGKakaoAuthType $authType;
    final /* synthetic */ KGResultCallback<Void> $callback;
    final /* synthetic */ FirebaseEvent $fbEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGSessionForCustomUI$loginKakao$1(Activity activity, KGKakaoAuthType kGKakaoAuthType, KGResultCallback<Void> kGResultCallback, FirebaseEvent firebaseEvent, Continuation<? super KGSessionForCustomUI$loginKakao$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$authType = kGKakaoAuthType;
        this.$callback = kGResultCallback;
        this.$fbEvent = firebaseEvent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGSessionForCustomUI$loginKakao$1(this.$activity, this.$authType, this.$callback, this.$fbEvent, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGSessionForCustomUI$loginKakao$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthImpl authImpl = AuthImpl.INSTANCE;
            Activity activity = this.$activity;
            String code = KGIdpProfile.KGIdpCode.Kakao.getCode();
            KGKakaoAuthType kGKakaoAuthType = this.$authType;
            KGResult<Void> loginWithoutUI = authImpl.loginWithoutUI(activity, code, kGKakaoAuthType != null ? kGKakaoAuthType.getAuthType() : null, false);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C23751(this.$callback, loginWithoutUI, this.$fbEvent, null), this) == coroutine_suspended) {
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

    /* compiled from: KGSessionForCustomUI.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGSessionForCustomUI$loginKakao$1$1", m855f = "KGSessionForCustomUI.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGSessionForCustomUI$loginKakao$1$1 */
    static final class C23751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<Void> $callback;
        final /* synthetic */ FirebaseEvent $fbEvent;
        final /* synthetic */ KGResult<Void> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C23751(KGResultCallback<Void> kGResultCallback, KGResult<Void> kGResult, FirebaseEvent firebaseEvent, Continuation<? super C23751> continuation) {
            super(2, continuation);
            this.$callback = kGResultCallback;
            this.$result = kGResult;
            this.$fbEvent = firebaseEvent;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C23751(this.$callback, this.$result, this.$fbEvent, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C23751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                KGResult.Companion companion = KGResult.INSTANCE;
                KGResult<Void> kGResult = this.$result;
                Intrinsics.checkNotNull(kGResult);
                KGResult<Void> result = companion.getResult(kGResult);
                Logger.INSTANCE.m704i(y.ٲٴݴ״ٰ(1781953896), y.ݬֲ֮ܲت(1512722063) + this.$result);
                this.$callback.onResult(result);
                this.$fbEvent.setTraceResult(this.$result);
            }
            return Unit.INSTANCE;
        }
    }
}
