package com.kakaogame.auth.view;

import android.app.Activity;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.view.LogoutUIManager;
import com.kakaogame.util.MutexLock;
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

/* compiled from: LogoutUIManager.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m839d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.auth.view.LogoutUIManager$showLogoutPopup$1", m855f = "LogoutUIManager.kt", m856i = {}, m857l = {}, m858m = "invokeSuspend", m859n = {}, m860s = {})
/* loaded from: classes3.dex */
final class LogoutUIManager$showLogoutPopup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $idpCode;
    final /* synthetic */ LogoutUIManager.RequestType $requestType;
    final /* synthetic */ MutexLock<KGResult<Void>> $uiLock;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LogoutUIManager$showLogoutPopup$1(Activity activity, String str, LogoutUIManager.RequestType requestType, MutexLock<KGResult<Void>> mutexLock, Continuation<? super LogoutUIManager$showLogoutPopup$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$idpCode = str;
        this.$requestType = requestType;
        this.$uiLock = mutexLock;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogoutUIManager$showLogoutPopup$1(this.$activity, this.$idpCode, this.$requestType, this.$uiLock, continuation);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogoutUIManager$showLogoutPopup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392608770));
        }
        ResultKt.throwOnFailure(obj);
        try {
            Activity activity = this.$activity;
            Intrinsics.checkNotNull(activity);
            new LogoutUIManager.LogoutPopupDialog(activity, this.$idpCode, this.$requestType, this.$uiLock).show();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(y.ݮڮֲڭܩ(-628612716), y.ۮڭڭܬި(862485899) + e, e);
            this.$uiLock.setContent(KGResult.INSTANCE.getResult(4001, e.toString()));
            this.$uiLock.unlock();
        }
        return Unit.INSTANCE;
    }
}
