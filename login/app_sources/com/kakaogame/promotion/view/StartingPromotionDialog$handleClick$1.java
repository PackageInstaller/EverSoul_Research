package com.kakaogame.promotion.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.kakaogame.KGResult;
import com.kakaogame.p029ui.CustomProgressDialog;
import com.kakaogame.p029ui.DialogManager;
import com.kakaogame.promotion.KGPromotionData;
import com.kakaogame.promotion.StartingPromotionManager;
import com.kakaogame.promotion.view.StartingPromotionDialog;
import com.kakaogame.promotion.view.StartingPromotionDialog$handleClick$1;
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

/* compiled from: StartingPromotionDialog.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.promotion.view.StartingPromotionDialog$handleClick$1", m855f = "StartingPromotionDialog.kt", m856i = {}, m857l = {89, 101}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class StartingPromotionDialog$handleClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CustomProgressDialog $progress;
    int label;
    final /* synthetic */ StartingPromotionDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StartingPromotionDialog$handleClick$1(StartingPromotionDialog startingPromotionDialog, CustomProgressDialog customProgressDialog, Continuation<? super StartingPromotionDialog$handleClick$1> continuation) {
        super(2, continuation);
        this.this$0 = startingPromotionDialog;
        this.$progress = customProgressDialog;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StartingPromotionDialog$handleClick$1(this.this$0, this.$progress, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StartingPromotionDialog$handleClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        KGResult<Void> successResult;
        KGPromotionData kGPromotionData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C24431(this.this$0, this.$progress, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        z = this.this$0.applyClick;
        if (z) {
            kGPromotionData = this.this$0.promotion;
            successResult = kGPromotionData.apply();
        } else {
            successResult = KGResult.INSTANCE.getSuccessResult();
        }
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new C24442(this.this$0, this.$progress, successResult, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: StartingPromotionDialog.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.promotion.view.StartingPromotionDialog$handleClick$1$1", m855f = "StartingPromotionDialog.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.promotion.view.StartingPromotionDialog$handleClick$1$1 */
    static final class C24431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomProgressDialog $progress;
        int label;
        final /* synthetic */ StartingPromotionDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24431(StartingPromotionDialog startingPromotionDialog, CustomProgressDialog customProgressDialog, Continuation<? super C24431> continuation) {
            super(2, continuation);
            this.this$0 = startingPromotionDialog;
            this.$progress = customProgressDialog;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24431(this.this$0, this.$progress, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                z = this.this$0.applyClick;
                if (z) {
                    this.$progress.show();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
    }

    /* compiled from: StartingPromotionDialog.kt */
    @Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    @DebugMetadata(m854c = "com.kakaogame.promotion.view.StartingPromotionDialog$handleClick$1$2", m855f = "StartingPromotionDialog.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
    /* renamed from: com.kakaogame.promotion.view.StartingPromotionDialog$handleClick$1$2 */
    static final class C24442 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CustomProgressDialog $progress;
        final /* synthetic */ KGResult<Void> $result;
        int label;
        final /* synthetic */ StartingPromotionDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        C24442(StartingPromotionDialog startingPromotionDialog, CustomProgressDialog customProgressDialog, KGResult<Void> kGResult, Continuation<? super C24442> continuation) {
            super(2, continuation);
            this.this$0 = startingPromotionDialog;
            this.$progress = customProgressDialog;
            this.$result = kGResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static final void invokeSuspend$lambda$1(DialogInterface dialogInterface) {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C24442(this.this$0, this.$progress, this.$result, continuation);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C24442) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            KGPromotionData kGPromotionData;
            StartingPromotionDialog.StartingPromotionDialogListener startingPromotionDialogListener;
            KGPromotionData kGPromotionData2;
            StartingPromotionDialog.StartingPromotionDialogListener startingPromotionDialogListener2;
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                z = this.this$0.applyClick;
                if (z) {
                    this.$progress.dismiss();
                }
                KGResult<Void> kGResult = this.$result;
                if (kGResult != null) {
                    if (kGResult.isSuccess()) {
                        kGPromotionData = this.this$0.promotion;
                        if (TextUtils.isEmpty(kGPromotionData.getLinkUrl())) {
                            startingPromotionDialogListener = this.this$0.callbackListener;
                            startingPromotionDialogListener.onDismiss();
                        } else {
                            StartingPromotionDialog startingPromotionDialog = this.this$0;
                            kGPromotionData2 = startingPromotionDialog.promotion;
                            startingPromotionDialog.clickLink = kGPromotionData2.getLinkUrl();
                            startingPromotionDialogListener2 = this.this$0.callbackListener;
                            str = this.this$0.clickLink;
                            startingPromotionDialogListener2.onImageLinkClicked(str);
                        }
                        this.this$0.dismiss();
                    } else {
                        KGResult<Void> kGResult2 = this.$result;
                        String errorMessage = StartingPromotionManager.INSTANCE.getErrorMessage(this.this$0.getOwnerActivity(), kGResult2.getCode());
                        DialogManager dialogManager = DialogManager.INSTANCE;
                        Activity ownerActivity = this.this$0.getOwnerActivity();
                        Intrinsics.checkNotNull(ownerActivity);
                        dialogManager.showErrorDialog(ownerActivity, errorMessage, false, new DialogInterface.OnDismissListener() { // from class: com.kakaogame.promotion.view.StartingPromotionDialog$handleClick$1$2$$ExternalSyntheticLambda0
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // android.content.DialogInterface.OnDismissListener
                            public final void onDismiss(DialogInterface dialogInterface) {
                                StartingPromotionDialog$handleClick$1.C24442.invokeSuspend$lambda$1(dialogInterface);
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
    }
}
