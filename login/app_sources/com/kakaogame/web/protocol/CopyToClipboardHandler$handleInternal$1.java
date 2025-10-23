package com.kakaogame.web.protocol;

import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.Logger;
import com.kakaogame.util.InputUtil;
import com.liapp.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CopyToClipboardHandler.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.web.protocol.CopyToClipboardHandler$handleInternal$1", m855f = "CopyToClipboardHandler.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class CopyToClipboardHandler$handleInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $webUri;
    final /* synthetic */ WebView $webView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CopyToClipboardHandler$handleInternal$1(Uri uri, WebView webView, Continuation<? super CopyToClipboardHandler$handleInternal$1> continuation) {
        super(2, continuation);
        this.$webUri = uri;
        this.$webView = webView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CopyToClipboardHandler$handleInternal$1(this.$webUri, this.$webView, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CopyToClipboardHandler$handleInternal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        Uri uri = this.$webUri;
        Intrinsics.checkNotNull(uri);
        String queryParameter = uri.getQueryParameter(y.ٲٴݴ״ٰ(1782384304));
        Logger.INSTANCE.m699d(y.ݮڮֲڭܩ(-628223556), y.٬ݯح׭٩(576315830) + queryParameter);
        WebView webView = this.$webView;
        Intrinsics.checkNotNull(webView);
        InputUtil.setClipboardText(webView.getContext(), queryParameter, queryParameter);
        return Unit.INSTANCE;
    }
}
