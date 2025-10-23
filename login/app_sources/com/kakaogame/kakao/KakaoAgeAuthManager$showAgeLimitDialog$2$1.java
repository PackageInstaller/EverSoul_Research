package com.kakaogame.kakao;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KakaoAgeAuthManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.kakao.KakaoAgeAuthManager$showAgeLimitDialog$2$1", m855f = "KakaoAgeAuthManager.kt", m856i = {}, m857l = {352}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KakaoAgeAuthManager$showAgeLimitDialog$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<Unit> $cont;
    final /* synthetic */ boolean $isLogin;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KakaoAgeAuthManager$showAgeLimitDialog$2$1(boolean z, Activity activity, Continuation<? super Unit> continuation, Continuation<? super KakaoAgeAuthManager$showAgeLimitDialog$2$1> continuation2) {
        super(2, continuation2);
        this.$isLogin = z;
        this.$activity = activity;
        this.$cont = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KakaoAgeAuthManager$showAgeLimitDialog$2$1(this.$isLogin, this.$activity, this.$cont, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KakaoAgeAuthManager$showAgeLimitDialog$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(1:(1:4)(2:14|15))(6:16|(2:18|(1:20))|6|7|8|9)|5|6|7|8|9) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x009d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009e, code lost:
    
        r0 = com.kakaogame.Logger.INSTANCE;
        r1 = com.kakaogame.kakao.KakaoAgeAuthManager.TAG;
        r0.m702e(r1, r6.toString(), r6);
        r6 = r5.$cont;
        r0 = kotlin.Result.INSTANCE;
        r6.resumeWith(kotlin.Result.m1440constructorimpl(null));
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
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L1c
            if (r1 != r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r6)
            goto L31
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            r0 = 1392608770(0x53018602, float:5.5629906E11)
            java.lang.String r0 = com.liapp.y.ٴسسݬߨ(r0)
            r6.<init>(r0)
            throw r6
        L1c:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.$isLogin
            if (r6 == 0) goto L59
            com.kakaogame.kakao.KakaoManager r6 = com.kakaogame.kakao.KakaoManager.INSTANCE
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r2
            java.lang.Object r6 = r6.unlink(r1)
            if (r6 != r0) goto L31
            return r0
        L31:
            com.kakaogame.KGResult r6 = (com.kakaogame.KGResult) r6
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            java.lang.String r1 = com.kakaogame.kakao.KakaoAgeAuthManager.access$getTAG$p()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 1512567775(0x5a27f3df, float:1.1818615E16)
            java.lang.String r4 = com.liapp.y.ݬֲ֮ܲت(r4)
            r3.<init>(r4)
            java.lang.StringBuilder r6 = r3.append(r6)
            java.lang.String r6 = r6.toString()
            r0.m704i(r1, r6)
            com.kakaogame.core.CoreManager$Companion r6 = com.kakaogame.core.CoreManager.INSTANCE
            com.kakaogame.core.CoreManager r6 = r6.getInstance()
            r6.logout()
        L59:
            android.app.Activity r6 = r5.$activity     // Catch: java.lang.Exception -> L9d
            android.app.AlertDialog$Builder r6 = com.kakaogame.p029ui.DialogManager.createAlertDialogBuilder(r6)     // Catch: java.lang.Exception -> L9d
            com.kakaogame.kakao.KakaoAgeAuthManager r0 = com.kakaogame.kakao.KakaoAgeAuthManager.INSTANCE     // Catch: java.lang.Exception -> L9d
            int r0 = com.kakaogame.kakao.KakaoAgeAuthManager.access$getAgeAuthLimit(r0)     // Catch: java.lang.Exception -> L9d
            int r0 = r0 - r2
            android.app.Activity r1 = r5.$activity     // Catch: java.lang.Exception -> L9d
            android.content.Context r1 = (android.content.Context) r1     // Catch: java.lang.Exception -> L9d
            java.lang.String r3 = "zinny_sdk_reach_kakao_age_limit"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L9d
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)     // Catch: java.lang.Exception -> L9d
            r4 = 0
            r2[r4] = r0     // Catch: java.lang.Exception -> L9d
            java.lang.String r0 = com.kakaogame.util.ResourceUtil.getString(r1, r3, r2)     // Catch: java.lang.Exception -> L9d
            android.app.Activity r1 = r5.$activity     // Catch: java.lang.Exception -> L9d
            android.content.Context r1 = (android.content.Context) r1     // Catch: java.lang.Exception -> L9d
            java.lang.String r2 = "zinny_sdk_common_button_ok"
            java.lang.String r1 = com.kakaogame.util.ResourceUtil.getString(r1, r2)     // Catch: java.lang.Exception -> L9d
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> L9d
            r6.setMessage(r0)     // Catch: java.lang.Exception -> L9d
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L9d
            com.kakaogame.kakao.KakaoAgeAuthManager$showAgeLimitDialog$2$1$1 r0 = new com.kakaogame.kakao.KakaoAgeAuthManager$showAgeLimitDialog$2$1$1     // Catch: java.lang.Exception -> L9d
            kotlin.coroutines.Continuation<kotlin.Unit> r2 = r5.$cont     // Catch: java.lang.Exception -> L9d
            r0.<init>()     // Catch: java.lang.Exception -> L9d
            android.content.DialogInterface$OnClickListener r0 = (android.content.DialogInterface.OnClickListener) r0     // Catch: java.lang.Exception -> L9d
            r6.setPositiveButton(r1, r0)     // Catch: java.lang.Exception -> L9d
            r6.setCancelable(r4)     // Catch: java.lang.Exception -> L9d
            r6.show()     // Catch: java.lang.Exception -> L9d
            goto Lb9
        L9d:
            r6 = move-exception
            com.kakaogame.Logger r0 = com.kakaogame.Logger.INSTANCE
            java.lang.String r1 = com.kakaogame.kakao.KakaoAgeAuthManager.access$getTAG$p()
            java.lang.String r2 = r6.toString()
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r0.m702e(r1, r2, r6)
            kotlin.coroutines.Continuation<kotlin.Unit> r6 = r5.$cont
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            r0 = 0
            java.lang.Object r0 = kotlin.Result.m1440constructorimpl(r0)
            r6.resumeWith(r0)
        Lb9:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
            fill-array 0x00bc: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.kakao.KakaoAgeAuthManager$showAgeLimitDialog$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
