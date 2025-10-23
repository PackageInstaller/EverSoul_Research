package com.kakaogame.idp;

import android.app.Activity;
import com.kakaogame.Logger;
import com.kakaogame.idp.SIWAWebDialog;
import com.kakaogame.p029ui.DeepLinkManager;
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

/* compiled from: SIWAWebDialog.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.idp.SIWAWebDialog$SIWAWebViewContainerImpl$shouldOverrideUrlLoading$1", m855f = "SIWAWebDialog.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* renamed from: com.kakaogame.idp.SIWAWebDialog$SIWAWebViewContainerImpl$shouldOverrideUrlLoading$1 */
/* loaded from: classes3.dex */
final class C2412x7784436d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ SIWAWebDialog.SIWAWebViewContainerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2412x7784436d(SIWAWebDialog.SIWAWebViewContainerImpl sIWAWebViewContainerImpl, String str, Continuation<? super C2412x7784436d> continuation) {
        super(2, continuation);
        this.this$0 = sIWAWebViewContainerImpl;
        this.$url = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C2412x7784436d(this.this$0, this.$url, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C2412x7784436d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Activity activity;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        DeepLinkManager deepLinkManager = DeepLinkManager.INSTANCE;
        activity = this.this$0.getActivity();
        Logger.INSTANCE.m704i(y.ٲٴݴ״ٰ(1782267840), y.ݬֲ֮ܲت(1512508447) + deepLinkManager.handlePlatformDeepLink(activity, this.$url));
        return Unit.INSTANCE;
    }
}
