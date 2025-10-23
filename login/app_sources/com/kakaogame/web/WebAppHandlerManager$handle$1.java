package com.kakaogame.web;

import android.net.Uri;
import android.webkit.WebView;
import com.kakaogame.KGResult;
import com.kakaogame.web.WebAppHandlerManager;
import com.kakaogame.web.protocol.WebAppProtocolHandler;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: WebAppHandlerManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.web.WebAppHandlerManager$handle$1", m855f = "WebAppHandlerManager.kt", m856i = {}, m857l = {32}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class WebAppHandlerManager$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebAppHandlerManager.WebAppHandlerCallback $callback;
    final /* synthetic */ WebAppProtocolHandler $handler;
    final /* synthetic */ Uri $webUri;
    final /* synthetic */ WebView $webView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    WebAppHandlerManager$handle$1(WebAppProtocolHandler webAppProtocolHandler, WebView webView, Uri uri, WebAppHandlerManager.WebAppHandlerCallback webAppHandlerCallback, Continuation<? super WebAppHandlerManager$handle$1> continuation) {
        super(2, continuation);
        this.$handler = webAppProtocolHandler;
        this.$webView = webView;
        this.$webUri = uri;
        this.$callback = webAppHandlerCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebAppHandlerManager$handle$1(this.$handler, this.$webView, this.$webUri, this.$callback, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebAppHandlerManager$handle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WebAppProtocolHandler webAppProtocolHandler = this.$handler;
            WebView webView = this.$webView;
            Uri uri = this.$webUri;
            Intrinsics.checkNotNullExpressionValue(uri, y.ۮڭڭܬި(862887851));
            KGResult<String> handle = webAppProtocolHandler.handle(webView, uri);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C25631(this.$callback, handle, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: WebAppHandlerManager.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.web.WebAppHandlerManager$handle$1$1", m855f = "WebAppHandlerManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.web.WebAppHandlerManager$handle$1$1 */
    static final class C25631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WebAppHandlerManager.WebAppHandlerCallback $callback;
        final /* synthetic */ KGResult<String> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C25631(WebAppHandlerManager.WebAppHandlerCallback webAppHandlerCallback, KGResult<String> kGResult, Continuation<? super C25631> continuation) {
            super(2, continuation);
            this.$callback = webAppHandlerCallback;
            this.$result = kGResult;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25631(this.$callback, this.$result, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
            }
            ResultKt.throwOnFailure(obj);
            this.$callback.onHandle(this.$result);
            return Unit.INSTANCE;
        }
    }
}
