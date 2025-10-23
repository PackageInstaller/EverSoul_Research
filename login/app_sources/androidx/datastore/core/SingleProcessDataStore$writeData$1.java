package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SingleProcessDataStore.kt */
@Metadata(m840k = 3, m841mv = {1, 5, 1}, m843xi = 48)
@DebugMetadata(m854c = "androidx.datastore.core.SingleProcessDataStore", m855f = "SingleProcessDataStore.kt", m856i = {0, 0, 0}, m857l = {426}, m858m = "writeData$datastore_core", m859n = {"this", "scratchFile", "stream"}, m860s = {"L$0", "L$1", "L$4"})
/* loaded from: classes.dex */
final class SingleProcessDataStore$writeData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingleProcessDataStore$writeData$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$writeData$1> continuation) {
        super(continuation);
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeData$datastore_core(null, this);
    }
}
