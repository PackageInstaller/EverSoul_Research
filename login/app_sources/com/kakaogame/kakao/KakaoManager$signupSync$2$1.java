package com.kakaogame.kakao;

import android.util.Pair;
import com.kakao.sdk.partner.user.UserApiClientKt;
import com.kakao.sdk.user.UserApiClient;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KakaoManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.kakao.KakaoManager$signupSync$2$1", m855f = "KakaoManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KakaoManager$signupSync$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Continuation<KGResult<Void>> $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KakaoManager$signupSync$2$1(Continuation<? super KGResult<Void>> continuation, Continuation<? super KakaoManager$signupSync$2$1> continuation2) {
        super(2, continuation2);
        this.$it = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KakaoManager$signupSync$2$1(this.$it, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KakaoManager$signupSync$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        UserApiClient companion = UserApiClient.INSTANCE.getInstance();
        final Continuation<KGResult<Void>> continuation = this.$it;
        UserApiClientKt.signupForPartner$default(companion, null, new Function1<Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoManager$signupSync$2$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String str = y.٬ݯح׭٩(576474518);
                if (th != null) {
                    Logger.INSTANCE.m699d(str, y.ٴسسݬߨ(1393527370) + th);
                    Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                    KGResult.Companion companion2 = KGResult.INSTANCE;
                    Object obj2 = classifyKakaoError.first;
                    Intrinsics.checkNotNullExpressionValue(obj2, y.ۮڭڭܬި(862384955));
                    KGResult result = companion2.getResult(((Number) obj2).intValue(), (String) classifyKakaoError.second);
                    Continuation<KGResult<Void>> continuation2 = continuation;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(result));
                    return;
                }
                Logger.INSTANCE.m699d(str, y.ݮڮֲڭܩ(-628375876));
                KGResult successResult = KGResult.INSTANCE.getSuccessResult();
                Continuation<KGResult<Void>> continuation3 = continuation;
                Result.Companion companion4 = Result.INSTANCE;
                continuation3.resumeWith(Result.m1440constructorimpl(successResult));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }
}
