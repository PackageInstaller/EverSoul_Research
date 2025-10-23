package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SingleProcessDataStore.kt */
@Metadata(m840k = 3, m841mv = {1, 5, 1}, m843xi = 48)
@DebugMetadata(m854c = "androidx.datastore.core.SingleProcessDataStore", m855f = "SingleProcessDataStore.kt", m856i = {0}, m857l = {311}, m858m = "readAndInitOrPropagateFailure", m859n = {"this"}, m860s = {"L$0"})
/* loaded from: classes.dex */
final class SingleProcessDataStore$readAndInitOrPropagateFailure$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingleProcessDataStore$readAndInitOrPropagateFailure$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readAndInitOrPropagateFailure$1> continuation) {
        super(continuation);
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readAndInitOrPropagateFailure;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readAndInitOrPropagateFailure = this.this$0.readAndInitOrPropagateFailure(this);
        return readAndInitOrPropagateFailure;
    }
}
