package com.kakaogame;

import android.app.Activity;
import com.kakaogame.KGKakaoPicker;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KGKakaoPicker.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@"}, m839d2 = {"<anonymous>", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGKakaoPicker$showInvitationDialog$1", m855f = "KGKakaoPicker.kt", m856i = {}, m857l = {389}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGKakaoPicker$showInvitationDialog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KGResult<Void>>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ List<KGKakaoPicker.KGKakaoUser> $kakaoUsers;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGKakaoPicker$showInvitationDialog$1(Activity activity, List<KGKakaoPicker.KGKakaoUser> list, Continuation<? super KGKakaoPicker$showInvitationDialog$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$kakaoUsers = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGKakaoPicker$showInvitationDialog$1(this.$activity, this.$kakaoUsers, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super KGResult<Void>> continuation) {
        return ((KGKakaoPicker$showInvitationDialog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = KGKakaoPicker.INSTANCE.showInvitationDialog(this.$activity, this.$kakaoUsers, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
