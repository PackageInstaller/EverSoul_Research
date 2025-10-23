package com.kakaogame.kakao;

import com.kakao.sdk.partner.user.UserApiClientKt;
import com.kakao.sdk.partner.user.model.PartnerUser;
import com.kakao.sdk.user.UserApiClient;
import com.kakaogame.KGResult;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KakaoManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.kakao.KakaoManager$requestMe$2$1", m855f = "KakaoManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KakaoManager$requestMe$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Continuation<KGResult<UserProfile>> $cont;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KakaoManager$requestMe$2$1(Continuation<? super KGResult<UserProfile>> continuation, Continuation<? super KakaoManager$requestMe$2$1> continuation2) {
        super(2, continuation2);
        this.$cont = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KakaoManager$requestMe$2$1(this.$cont, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KakaoManager$requestMe$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        final Continuation<KGResult<UserProfile>> continuation = this.$cont;
        UserApiClientKt.meForPartner$default(companion, null, false, new Function2<PartnerUser, Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoManager$requestMe$2$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PartnerUser partnerUser, Throwable th) {
                invoke2(partnerUser, th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0064, code lost:
            
                if (r3 == null) goto L7;
             */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(com.kakao.sdk.partner.user.model.PartnerUser r3, java.lang.Throwable r4) {
                /*
                    r2 = this;
                    if (r4 == 0) goto L4e
                    com.kakaogame.Logger r3 = com.kakaogame.Logger.INSTANCE
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = -1158687423(0xffffffffbaefd541, float:-0.0018297808)
                    java.lang.String r1 = com.liapp.y.֬ڱܱײٮ(r1)
                    r0.<init>(r1)
                    java.lang.StringBuilder r0 = r0.append(r4)
                    java.lang.String r0 = r0.toString()
                    r1 = 576474518(0x225c4d96, float:2.9856633E-18)
                    java.lang.String r1 = com.liapp.y.٬ݯح׭٩(r1)
                    r3.m699d(r1, r0)
                    android.util.Pair r3 = com.kakaogame.kakao.KakaoUtil.classifyKakaoError(r4)
                    com.kakaogame.KGResult$Companion r4 = com.kakaogame.KGResult.INSTANCE
                    java.lang.Object r0 = r3.first
                    r1 = 862384955(0x3366f33b, float:5.3772265E-8)
                    java.lang.String r1 = com.liapp.y.ۮڭڭܬި(r1)
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    java.lang.Number r0 = (java.lang.Number) r0
                    int r0 = r0.intValue()
                    java.lang.Object r3 = r3.second
                    java.lang.String r3 = (java.lang.String) r3
                    com.kakaogame.KGResult r3 = r4.getResult(r0, r3)
                    kotlin.coroutines.Continuation<com.kakaogame.KGResult<com.kakaogame.kakao.UserProfile>> r4 = r1
                    kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
                    java.lang.Object r3 = kotlin.Result.m1440constructorimpl(r3)
                    r4.resumeWith(r3)
                    goto L79
                L4e:
                    if (r3 == 0) goto L66
                    com.kakaogame.kakao.KakaoManager r4 = com.kakaogame.kakao.KakaoManager.INSTANCE
                    com.kakaogame.kakao.UserProfile r0 = new com.kakaogame.kakao.UserProfile
                    r0.<init>(r3)
                    com.kakaogame.kakao.KakaoManager.access$setUserProfile(r4, r0)
                    com.kakaogame.KGResult$Companion r3 = com.kakaogame.KGResult.INSTANCE
                    com.kakaogame.kakao.UserProfile r4 = com.kakaogame.kakao.KakaoManager.access$getUserProfile$p()
                    com.kakaogame.KGResult r3 = r3.getSuccessResult(r4)
                    if (r3 != 0) goto L6e
                L66:
                    com.kakaogame.KGResult$Companion r3 = com.kakaogame.KGResult.INSTANCE
                    r4 = 2003(0x7d3, float:2.807E-42)
                    com.kakaogame.KGResult r3 = r3.getResult(r4)
                L6e:
                    kotlin.coroutines.Continuation<com.kakaogame.KGResult<com.kakaogame.kakao.UserProfile>> r4 = r1
                    kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
                    java.lang.Object r3 = kotlin.Result.m1440constructorimpl(r3)
                    r4.resumeWith(r3)
                L79:
                    return
                    fill-array 0x007a: FILL_ARRAY_DATA , data: ?
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.kakao.KakaoManager$requestMe$2$1.C24171.invoke2(com.kakao.sdk.partner.user.model.PartnerUser, java.lang.Throwable):void");
            }
        }, 3, null);
        return Unit.INSTANCE;
    }
}
