package androidx.datastore.core;

import androidx.datastore.core.DataMigrationInitializer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DataMigrationInitializer.kt */
@Metadata(m840k = 3, m841mv = {1, 5, 1}, m843xi = 48)
@DebugMetadata(m854c = "androidx.datastore.core.DataMigrationInitializer$Companion", m855f = "DataMigrationInitializer.kt", m856i = {0, 1}, m857l = {42, 57}, m858m = "runMigrations", m859n = {"cleanUps", "cleanUpFailure"}, m860s = {"L$0", "L$0"})
/* loaded from: classes.dex */
final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataMigrationInitializer.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer.Companion companion, Continuation<? super DataMigrationInitializer$Companion$runMigrations$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object runMigrations;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        runMigrations = this.this$0.runMigrations(null, null, this);
        return runMigrations;
    }
}
