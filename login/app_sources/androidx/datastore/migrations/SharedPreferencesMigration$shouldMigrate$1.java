package androidx.datastore.migrations;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SharedPreferencesMigration.kt */
@Metadata(m840k = 3, m841mv = {1, 5, 1}, m843xi = 48)
@DebugMetadata(m854c = "androidx.datastore.migrations.SharedPreferencesMigration", m855f = "SharedPreferencesMigration.kt", m856i = {0}, m857l = {147}, m858m = "shouldMigrate", m859n = {"this"}, m860s = {"L$0"})
/* loaded from: classes.dex */
final class SharedPreferencesMigration$shouldMigrate$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharedPreferencesMigration<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SharedPreferencesMigration$shouldMigrate$1(SharedPreferencesMigration<T> sharedPreferencesMigration, Continuation<? super SharedPreferencesMigration$shouldMigrate$1> continuation) {
        super(continuation);
        this.this$0 = sharedPreferencesMigration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.shouldMigrate(null, this);
    }
}
