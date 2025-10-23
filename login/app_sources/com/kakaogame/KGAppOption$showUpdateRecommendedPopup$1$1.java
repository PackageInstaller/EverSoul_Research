package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGAppOption;
import com.kakaogame.log.FirebaseEvent;
import com.kakaogame.p029ui.AppUpdateManager;
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

/* compiled from: KGAppOption.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGAppOption$showUpdateRecommendedPopup$1$1", m855f = "KGAppOption.kt", m856i = {}, m857l = {83}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGAppOption$showUpdateRecommendedPopup$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KGResultCallback<Boolean> $callback;
    final /* synthetic */ FirebaseEvent $fbEvent;
    final /* synthetic */ Activity $it;
    final /* synthetic */ KGAppOption.UpdatePopupParamBuilder $popupInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGAppOption$showUpdateRecommendedPopup$1$1(Activity activity, KGAppOption.UpdatePopupParamBuilder updatePopupParamBuilder, KGResultCallback<Boolean> kGResultCallback, FirebaseEvent firebaseEvent, Continuation<? super KGAppOption$showUpdateRecommendedPopup$1$1> continuation) {
        super(2, continuation);
        this.$it = activity;
        this.$popupInfo = updatePopupParamBuilder;
        this.$callback = kGResultCallback;
        this.$fbEvent = firebaseEvent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGAppOption$showUpdateRecommendedPopup$1$1(this.$it, this.$popupInfo, this.$callback, this.$fbEvent, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGAppOption$showUpdateRecommendedPopup$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGResult<Boolean> checkUpdateInGame = AppUpdateManager.checkUpdateInGame(this.$it, this.$popupInfo);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C22591(this.$callback, checkUpdateInGame, this.$fbEvent, null), this) == coroutine_suspended) {
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

    /* compiled from: KGAppOption.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.KGAppOption$showUpdateRecommendedPopup$1$1$1", m855f = "KGAppOption.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.KGAppOption$showUpdateRecommendedPopup$1$1$1 */
    static final class C22591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ KGResultCallback<Boolean> $callback;
        final /* synthetic */ FirebaseEvent $fbEvent;
        final /* synthetic */ KGResult<Boolean> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C22591(KGResultCallback<Boolean> kGResultCallback, KGResult<Boolean> kGResult, FirebaseEvent firebaseEvent, Continuation<? super C22591> continuation) {
            super(2, continuation);
            this.$callback = kGResultCallback;
            this.$result = kGResult;
            this.$fbEvent = firebaseEvent;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C22591(this.$callback, this.$result, this.$fbEvent, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C22591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            KGResultCallback<Boolean> kGResultCallback = this.$callback;
            if (kGResultCallback != null) {
                kGResultCallback.onResult(this.$result);
            }
            this.$fbEvent.setResult(this.$result);
            return Unit.INSTANCE;
        }
    }
}
