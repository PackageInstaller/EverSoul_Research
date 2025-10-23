package com.kakaogame.security;

import android.app.Activity;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.kakaogame.KGResult;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProtectionManager.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@"}, m839d2 = {"<anonymous>", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/security/UserState;", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.security.ProtectionManager$check2ndPW$2", m855f = "ProtectionManager.kt", m856i = {}, m857l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class ProtectionManager$check2ndPW$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KGResult<UserState>>, Object> {
    final /* synthetic */ Activity $activity;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ProtectionManager$check2ndPW$2(Activity activity, Continuation<? super ProtectionManager$check2ndPW$2> continuation) {
        super(2, continuation);
        this.$activity = activity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProtectionManager$check2ndPW$2(this.$activity, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KGResult<UserState>> continuation) {
        return ((ProtectionManager$check2ndPW$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object showPasswordInputDialog;
        KGResult.Companion companion;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            KGResult.Companion companion2 = KGResult.INSTANCE;
            this.L$0 = companion2;
            this.label = 1;
            showPasswordInputDialog = ProtectionManager.INSTANCE.showPasswordInputDialog(this.$activity, this);
            if (showPasswordInputDialog == coroutine_suspended) {
                return coroutine_suspended;
            }
            companion = companion2;
            obj = showPasswordInputDialog;
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            companion = (KGResult.Companion) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return companion.getResult((Map<String, ? extends Object>) obj);
    }
}
