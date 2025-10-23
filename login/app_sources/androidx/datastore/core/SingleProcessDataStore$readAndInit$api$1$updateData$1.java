package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SingleProcessDataStore.kt */
@Metadata(m840k = 3, m841mv = {1, 5, 1}, m843xi = 48)
@DebugMetadata(m854c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", m855f = "SingleProcessDataStore.kt", m856i = {0, 0, 1, 2, 2}, m857l = {503, 337, 339}, m858m = "updateData", m859n = {"transform", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "newData"}, m860s = {"L$0", "L$1", "L$0", "L$0", "L$2"})
/* loaded from: classes.dex */
final class SingleProcessDataStore$readAndInit$api$1$updateData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessDataStore$readAndInit$api$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingleProcessDataStore$readAndInit$api$1$updateData$1(SingleProcessDataStore$readAndInit$api$1 singleProcessDataStore$readAndInit$api$1, Continuation<? super SingleProcessDataStore$readAndInit$api$1$updateData$1> continuation) {
        super(continuation);
        this.this$0 = singleProcessDataStore$readAndInit$api$1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateData(null, this);
    }
}
