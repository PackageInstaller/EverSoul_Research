package androidx.datastore.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SingleProcessDataStore.kt */
@Metadata(m840k = 3, m841mv = {1, 5, 1}, m843xi = 48)
@DebugMetadata(m854c = "androidx.datastore.core.SingleProcessDataStore", m855f = "SingleProcessDataStore.kt", m856i = {0, 0, 1, 1, 1, 2}, m857l = {322, 348, TypedValues.PositionType.TYPE_SIZE_PERCENT}, m858m = "readAndInit", m859n = {"updateLock", "initData", "updateLock", "initData", "initializationComplete", "$this$withLock_u24default$iv"}, m860s = {"L$1", "L$2", "L$1", "L$2", "L$3", "L$3"})
/* loaded from: classes.dex */
final class SingleProcessDataStore$readAndInit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingleProcessDataStore$readAndInit$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$readAndInit$1> continuation) {
        super(continuation);
        this.this$0 = singleProcessDataStore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readAndInit;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readAndInit = this.this$0.readAndInit(this);
        return readAndInit;
    }
}
