package com.kakaogame.idp;

import android.content.Intent;
import com.kakaogame.KGResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import twitter4j.auth.AccessToken;

/* compiled from: KGTwitterAuth.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.idp.KGTwitterAuth$activityResultOnIdpLogin$1", m855f = "KGTwitterAuth.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGTwitterAuth$activityResultOnIdpLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<KGResult<AccessToken>, Unit> $callback;
    final /* synthetic */ Intent $data;
    int label;
    final /* synthetic */ KGTwitterAuth this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGTwitterAuth$activityResultOnIdpLogin$1(Intent intent, Function1<? super KGResult<AccessToken>, Unit> function1, KGTwitterAuth kGTwitterAuth, Continuation<? super KGTwitterAuth$activityResultOnIdpLogin$1> continuation) {
        super(2, continuation);
        this.$data = intent;
        this.$callback = function1;
        this.this$0 = kGTwitterAuth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGTwitterAuth$activityResultOnIdpLogin$1(this.$data, this.$callback, this.this$0, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGTwitterAuth$activityResultOnIdpLogin$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        if (r6 == null) goto L18;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            if (r0 != 0) goto L54
            kotlin.ResultKt.throwOnFailure(r6)
            android.content.Intent r6 = r5.$data
            r0 = 4010(0xfaa, float:5.619E-42)
            if (r6 == 0) goto L46
            com.kakaogame.idp.KGTwitterAuth r1 = r5.this$0
            r2 = 0
            twitter4j.Twitter r3 = com.kakaogame.idp.KGTwitterAuth.access$getTwitter$p(r1)     // Catch: twitter4j.TwitterException -> L30
            if (r3 == 0) goto L34
            twitter4j.auth.RequestToken r1 = com.kakaogame.idp.KGTwitterAuth.access$getRequestToken$p(r1)     // Catch: twitter4j.TwitterException -> L30
            android.os.Bundle r6 = r6.getExtras()     // Catch: twitter4j.TwitterException -> L30
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch: twitter4j.TwitterException -> L30
            java.lang.String r4 = "oauth_verifier"
            java.lang.String r6 = r6.getString(r4)     // Catch: twitter4j.TwitterException -> L30
            twitter4j.auth.AccessToken r6 = r3.getOAuthAccessToken(r1, r6)     // Catch: twitter4j.TwitterException -> L30
            r2 = r6
            goto L34
        L30:
            r6 = move-exception
            r6.printStackTrace()
        L34:
            if (r2 == 0) goto L3e
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE
            com.kakaogame.KGResult r6 = r6.getSuccessResult(r2)
            if (r6 != 0) goto L44
        L3e:
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE
            com.kakaogame.KGResult r6 = r6.getResult(r0)
        L44:
            if (r6 != 0) goto L4c
        L46:
            com.kakaogame.KGResult$Companion r6 = com.kakaogame.KGResult.INSTANCE
            com.kakaogame.KGResult r6 = r6.getResult(r0)
        L4c:
            kotlin.jvm.functions.Function1<com.kakaogame.KGResult<twitter4j.auth.AccessToken>, kotlin.Unit> r0 = r5.$callback
            r0.invoke(r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r0 = 1392608770(0x53018602, float:5.5629906E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            r6.<init>(r0)
            throw r6
            fill-array 0x0062: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.idp.KGTwitterAuth$activityResultOnIdpLogin$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
