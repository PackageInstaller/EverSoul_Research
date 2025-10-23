package com.kakaogame.kakao;

import android.app.Activity;
import android.util.Pair;
import com.kakao.sdk.partner.user.UserApiClientKt;
import com.kakao.sdk.partner.user.model.AgeAuthLevel;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KakaoAgeAuthManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.kakao.KakaoAgeAuthManager$verifyAgeSync$2$1", m855f = "KakaoAgeAuthManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KakaoAgeAuthManager$verifyAgeSync$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<KGResult<Void>> $cont;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KakaoAgeAuthManager$verifyAgeSync$2$1(Activity activity, Continuation<? super KGResult<Void>> continuation, Continuation<? super KakaoAgeAuthManager$verifyAgeSync$2$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$cont = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        KakaoAgeAuthManager$verifyAgeSync$2$1 kakaoAgeAuthManager$verifyAgeSync$2$1 = new KakaoAgeAuthManager$verifyAgeSync$2$1(this.$activity, this.$cont, continuation);
        kakaoAgeAuthManager$verifyAgeSync$2$1.L$0 = obj;
        return kakaoAgeAuthManager$verifyAgeSync$2$1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KakaoAgeAuthManager$verifyAgeSync$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int ageAuthLimit;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        UserApiClient companion = UserApiClient.INSTANCE.getInstance();
        Activity activity = this.$activity;
        ageAuthLimit = KakaoAgeAuthManager.INSTANCE.getAgeAuthLimit();
        Integer boxInt = Boxing.boxInt(ageAuthLimit);
        AgeAuthLevel ageAuthLevel = AgeAuthLevel.AUTH_LEVEL2;
        Boolean boxBoolean = Boxing.boxBoolean(false);
        Boolean boxBoolean2 = Boxing.boxBoolean(true);
        final Continuation<KGResult<Void>> continuation = this.$cont;
        UserApiClientKt.verifyAge(companion, activity, boxInt, ageAuthLevel, boxBoolean, boxBoolean2, null, new Function1<Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoAgeAuthManager$verifyAgeSync$2$1.1
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
                Unit unit;
                String str;
                String str2;
                if (th != null) {
                    Continuation<KGResult<Void>> continuation2 = continuation;
                    Logger logger = Logger.INSTANCE;
                    str2 = KakaoAgeAuthManager.TAG;
                    logger.m699d(str2, y.ݮڮֲڭܩ(-628464788) + th);
                    Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                    KGResult.Companion companion2 = KGResult.INSTANCE;
                    Object obj2 = classifyKakaoError.first;
                    Intrinsics.checkNotNullExpressionValue(obj2, y.ۮڭڭܬި(862384955));
                    KGResult result = companion2.getResult(((Number) obj2).intValue(), (String) classifyKakaoError.second);
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(result));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Continuation<KGResult<Void>> continuation3 = continuation;
                    Logger logger2 = Logger.INSTANCE;
                    str = KakaoAgeAuthManager.TAG;
                    logger2.m699d(str, y.٬ݯح׭٩(576558190));
                    KGResult successResult = KGResult.INSTANCE.getSuccessResult();
                    Result.Companion companion4 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1440constructorimpl(successResult));
                }
            }
        });
        return Unit.INSTANCE;
    }
}
