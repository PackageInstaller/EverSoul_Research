package com.kakaogame.security;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.KGResultCallback;
import com.kakaogame.Logger;
import com.kakaogame.secondpw.ActionType;
import com.kakaogame.secondpw.SecondPWViewDialog;
import com.kakaogame.secondpw.SecondPWViewManager;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Result;
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

/* compiled from: ProtectionManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.security.ProtectionManager$showPasswordInputDialog$2$1", m855f = "ProtectionManager.kt", m856i = {}, m857l = {476, 477}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class ProtectionManager$showPasswordInputDialog$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<KGResult<String>> $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ProtectionManager$showPasswordInputDialog$2$1(Activity activity, Continuation<? super KGResult<String>> continuation, Continuation<? super ProtectionManager$showPasswordInputDialog$2$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$it = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProtectionManager$showPasswordInputDialog$2$1(this.$activity, this.$it, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProtectionManager$showPasswordInputDialog$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = SecondPWViewManager.getKeypadData$default(SecondPWViewManager.INSTANCE, this.$activity, 0, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new C25571((KGResult) obj, this.$activity, this.$it, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: ProtectionManager.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.security.ProtectionManager$showPasswordInputDialog$2$1$1", m855f = "ProtectionManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.security.ProtectionManager$showPasswordInputDialog$2$1$1 */
    static final class C25571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Continuation<KGResult<String>> $it;
        final /* synthetic */ KGResult<Void> $keypadDataResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C25571(KGResult<Void> kGResult, Activity activity, Continuation<? super KGResult<String>> continuation, Continuation<? super C25571> continuation2) {
            super(2, continuation2);
            this.$keypadDataResult = kGResult;
            this.$activity = activity;
            this.$it = continuation;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25571(this.$keypadDataResult, this.$activity, this.$it, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (this.$keypadDataResult.isSuccess()) {
                    final int requestedOrientation = this.$activity.getRequestedOrientation();
                    this.$activity.setRequestedOrientation(6);
                    Activity activity = this.$activity;
                    ActionType actionType = ActionType.ENTER_IS_ALLOWED_ACCESS;
                    final Activity activity2 = this.$activity;
                    final Continuation<KGResult<String>> continuation = this.$it;
                    new SecondPWViewDialog(activity, actionType, new KGResultCallback<String>() { // from class: com.kakaogame.security.ProtectionManager$showPasswordInputDialog$2$1$1$dialog$1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.kakaogame.KGResultCallback
                        public void onResult(KGResult<String> result) {
                            activity2.setRequestedOrientation(requestedOrientation);
                            Continuation<KGResult<String>> continuation2 = continuation;
                            Result.Companion companion = Result.INSTANCE;
                            Intrinsics.checkNotNull(result);
                            continuation2.resumeWith(Result.m1440constructorimpl(result));
                        }
                    }).show();
                } else {
                    Continuation<KGResult<String>> continuation2 = this.$it;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(this.$keypadDataResult)));
                }
            } catch (Exception e) {
                Logger.INSTANCE.m702e(y.ۮڭڭܬި(862721739), e.toString(), e);
                Continuation<KGResult<String>> continuation3 = this.$it;
                Result.Companion companion2 = Result.INSTANCE;
                continuation3.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
            }
            return Unit.INSTANCE;
        }
    }
}
