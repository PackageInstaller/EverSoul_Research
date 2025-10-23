package com.kakaogame.idp;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import com.kakaogame.KGResult;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.idp.KGSIWAAuth;
import com.kakaogame.util.DisplayUtil;
import com.kakaogame.web.WebDialog;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: KGSIWAAuth.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.idp.KGSIWAAuth$idpLoginSync$2$1", m855f = "KGSIWAAuth.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class KGSIWAAuth$idpLoginSync$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Continuation<KGResult<IdpAccount>> $cont;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ KGSIWAAuth this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    KGSIWAAuth$idpLoginSync$2$1(Activity activity, String str, KGSIWAAuth kGSIWAAuth, Continuation<? super KGResult<IdpAccount>> continuation, Continuation<? super KGSIWAAuth$idpLoginSync$2$1> continuation2) {
        super(2, continuation2);
        this.$activity = activity;
        this.$url = str;
        this.this$0 = kGSIWAAuth;
        this.$cont = continuation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new KGSIWAAuth$idpLoginSync$2$1(this.$activity, this.$url, this.this$0, this.$cont, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((KGSIWAAuth$idpLoginSync$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        final int requestedOrientation = this.$activity.getRequestedOrientation();
        if (DisplayUtil.isScreenPortrait(this.$activity)) {
            this.$activity.setRequestedOrientation(7);
        } else {
            this.$activity.setRequestedOrientation(6);
        }
        SIWAWebDialog sIWAWebDialog = new SIWAWebDialog(this.$activity, this.$url, new WebDialog.Settings.Builder().build());
        final Activity activity = this.$activity;
        final KGSIWAAuth kGSIWAAuth = this.this$0;
        final Continuation<KGResult<IdpAccount>> continuation = this.$cont;
        sIWAWebDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.kakaogame.idp.KGSIWAAuth$idpLoginSync$2$1.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                KGResult result;
                String str;
                Intrinsics.checkNotNull(dialogInterface, y.ݮڮֲڭܩ(-628429676));
                SIWAWebDialog sIWAWebDialog2 = (SIWAWebDialog) dialogInterface;
                if (sIWAWebDialog2.responseData.length() == 0) {
                    result = KGResult.INSTANCE.getResult(9001);
                } else {
                    Uri parse = Uri.parse(sIWAWebDialog2.responseData);
                    String queryParameter = parse.getQueryParameter(y.ٴسسݬߨ(1392585418));
                    if (Intrinsics.areEqual(queryParameter, y.ۮڭڭܬި(862630851))) {
                        String queryParameter2 = parse.getQueryParameter(y.٬ݯح׭٩(576653590));
                        String queryParameter3 = parse.getQueryParameter(y.دײܮڳܯ(2051571757));
                        String str2 = queryParameter2;
                        if (!(str2 == null || str2.length() == 0)) {
                            String str3 = queryParameter3;
                            if (!(str3 == null || str3.length() == 0)) {
                                result = KGResult.INSTANCE.getSuccessResult(IdpAccount.INSTANCE.createSIWAAccount(queryParameter2, queryParameter3, null, null));
                            }
                        }
                        result = KGResult.INSTANCE.getResult(2003);
                    } else if (StringsKt.equals(queryParameter, "9001", true)) {
                        result = KGResult.INSTANCE.getResult(9001);
                    } else {
                        result = KGResult.INSTANCE.getResult(2003);
                    }
                }
                activity.setRequestedOrientation(requestedOrientation);
                if (result.isSuccess()) {
                    Object content = result.getContent();
                    Intrinsics.checkNotNull(content);
                    IdpAccount idpAccount = (IdpAccount) content;
                    KGSIWAAuth.Companion companion = KGSIWAAuth.INSTANCE;
                    KGSIWAAuth.accessToken = idpAccount.getIdpAccessToken();
                    IdpAccount.Companion companion2 = IdpAccount.INSTANCE;
                    String idpUserId = idpAccount.getIdpUserId();
                    String idpAccessToken = idpAccount.getIdpAccessToken();
                    str = kGSIWAAuth.redirectUri;
                    KGResult successResult = KGResult.INSTANCE.getSuccessResult(companion2.createSIWAAccount(idpUserId, idpAccessToken, null, str));
                    Continuation<KGResult<IdpAccount>> continuation2 = continuation;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(successResult));
                    return;
                }
                Continuation<KGResult<IdpAccount>> continuation3 = continuation;
                Result.Companion companion4 = Result.INSTANCE;
                continuation3.resumeWith(Result.m1440constructorimpl(result));
            }
        });
        sIWAWebDialog.show();
        return Unit.INSTANCE;
    }
}
