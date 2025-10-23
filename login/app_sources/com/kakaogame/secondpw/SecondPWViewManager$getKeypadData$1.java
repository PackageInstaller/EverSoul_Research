package com.kakaogame.secondpw;

import com.kakaogame.addon.KGService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SecondPWViewManager.kt */
@Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.secondpw.SecondPWViewManager", m855f = "SecondPWViewManager.kt", m856i = {0, 0, 0}, m857l = {537}, m858m = "getKeypadData", m859n = {"context", "$this$withLock_u24default$iv", KGService.COUNT}, m860s = {"L$0", "L$1", "I$0"})
/* loaded from: classes3.dex */
final class SecondPWViewManager$getKeypadData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SecondPWViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SecondPWViewManager$getKeypadData$1(SecondPWViewManager secondPWViewManager, Continuation<? super SecondPWViewManager$getKeypadData$1> continuation) {
        super(continuation);
        this.this$0 = secondPWViewManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getKeypadData(null, 0, this);
    }
}
