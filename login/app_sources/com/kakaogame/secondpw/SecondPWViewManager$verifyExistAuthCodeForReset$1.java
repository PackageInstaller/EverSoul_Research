package com.kakaogame.secondpw;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SecondPWViewManager.kt */
@Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
@DebugMetadata(m854c = "com.kakaogame.secondpw.SecondPWViewManager", m855f = "SecondPWViewManager.kt", m856i = {0}, m857l = {310}, m858m = "verifyExistAuthCodeForReset", m859n = {"activity"}, m860s = {"L$0"})
/* loaded from: classes3.dex */
final class SecondPWViewManager$verifyExistAuthCodeForReset$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SecondPWViewManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SecondPWViewManager$verifyExistAuthCodeForReset$1(SecondPWViewManager secondPWViewManager, Continuation<? super SecondPWViewManager$verifyExistAuthCodeForReset$1> continuation) {
        super(continuation);
        this.this$0 = secondPWViewManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object verifyExistAuthCodeForReset;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        verifyExistAuthCodeForReset = this.this$0.verifyExistAuthCodeForReset(null, null, this);
        return verifyExistAuthCodeForReset;
    }
}
