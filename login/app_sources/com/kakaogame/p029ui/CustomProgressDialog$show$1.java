package com.kakaogame.p029ui;

import android.content.Context;
import android.view.Window;
import com.kakaogame.p029ui.CustomProgressDialog;
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

/* compiled from: CustomProgressDialog.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.ui.CustomProgressDialog$show$1", m855f = "CustomProgressDialog.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class CustomProgressDialog$show$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CustomProgressDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CustomProgressDialog$show$1(CustomProgressDialog customProgressDialog, Continuation<? super CustomProgressDialog$show$1> continuation) {
        super(2, continuation);
        this.this$0 = customProgressDialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomProgressDialog$show$1(this.this$0, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomProgressDialog$show$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CustomProgressDialog.CustomProgressDialogImpl customProgressDialogImpl;
        CustomProgressDialog.CustomProgressDialogImpl customProgressDialogImpl2;
        Context context;
        CustomProgressDialog.CustomProgressDialogImpl customProgressDialogImpl3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            customProgressDialogImpl = this.this$0.dialog;
            if (customProgressDialogImpl == null) {
                CustomProgressDialog customProgressDialog = this.this$0;
                context = this.this$0.context;
                customProgressDialog.dialog = new CustomProgressDialog.CustomProgressDialogImpl(context);
                customProgressDialogImpl3 = this.this$0.dialog;
                Intrinsics.checkNotNull(customProgressDialogImpl3);
                Window window = customProgressDialogImpl3.getWindow();
                Intrinsics.checkNotNull(window);
                window.setFlags(8, 8);
            }
            customProgressDialogImpl2 = this.this$0.dialog;
            Intrinsics.checkNotNull(customProgressDialogImpl2);
            customProgressDialogImpl2.show();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
    }
}
