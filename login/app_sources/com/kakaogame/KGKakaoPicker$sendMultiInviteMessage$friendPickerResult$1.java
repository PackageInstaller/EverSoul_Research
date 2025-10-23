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
@Metadata(m838d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001*\u00020\u0004H\u008a@"}, m839d2 = {"<anonymous>", "Lcom/kakaogame/KGResult;", "", "Lcom/kakaogame/KGKakaoPicker$KGKakaoUser;", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.KGKakaoPicker$sendMultiInviteMessage$friendPickerResult$1", m855f = "KGKakaoPicker.kt", m856i = {}, m857l = {189}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGKakaoPicker$sendMultiInviteMessage$friendPickerResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super KGResult<List<? extends KGKakaoPicker.KGKakaoUser>>>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $isPopup;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGKakaoPicker$sendMultiInviteMessage$friendPickerResult$1(Activity activity, boolean z, Continuation<? super KGKakaoPicker$sendMultiInviteMessage$friendPickerResult$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$isPopup = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGKakaoPicker$sendMultiInviteMessage$friendPickerResult$1(this.$activity, this.$isPopup, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super KGResult<List<? extends KGKakaoPicker.KGKakaoUser>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super KGResult<List<KGKakaoPicker.KGKakaoUser>>>) continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super KGResult<List<KGKakaoPicker.KGKakaoUser>>> continuation) {
        return ((KGKakaoPicker$sendMultiInviteMessage$friendPickerResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = KGKakaoPicker.INSTANCE.showMultiFriendPicker(this.$activity, this.$isPopup, this);
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
