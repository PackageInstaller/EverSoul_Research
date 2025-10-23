package com.kakaogame.kakao;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.kakaogame.Logger;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.util.ResourceUtil;
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
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KakaoAgeAuthManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.kakao.KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1", m855f = "KakaoAgeAuthManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<Unit> $it;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1(Activity activity, Continuation<? super Unit> continuation, Continuation<? super KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$it = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1(this.$activity, this.$it, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        try {
            AlertDialog.Builder createAlertDialogBuilder = DialogManager.createAlertDialogBuilder(this.$activity);
            String string = ResourceUtil.getString(this.$activity, "zinny_sdk_reach_kakao_age_check_guide");
            String string2 = ResourceUtil.getString(this.$activity, "zinny_sdk_common_button_ok");
            createAlertDialogBuilder.setMessage(string);
            final Continuation<Unit> continuation = this.$it;
            createAlertDialogBuilder.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.kakaogame.kakao.KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Continuation<Unit> continuation2 = continuation;
                    Result.Companion companion = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(null));
                }
            });
            createAlertDialogBuilder.setCancelable(false);
            createAlertDialogBuilder.show();
        } catch (Exception e) {
            Logger logger = Logger.INSTANCE;
            str = KakaoAgeAuthManager.TAG;
            logger.m702e(str, e.toString(), e);
            Continuation<Unit> continuation2 = this.$it;
            Result.Companion companion = Result.INSTANCE;
            continuation2.resumeWith(Result.m1440constructorimpl(null));
        }
        return Unit.INSTANCE;
    }
}
