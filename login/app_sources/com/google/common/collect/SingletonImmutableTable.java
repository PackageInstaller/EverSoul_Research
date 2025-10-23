package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Map;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Table
    public int size() {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return column((SingletonImmutableTable<R, C, V>) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingletonImmutableTable(R r, C c, V v) {
        this.singleRowKey = (R) Preconditions.checkNotNull(r);
        this.singleColumnKey = (C) Preconditions.checkNotNull(c);
        this.singleValue = (V) Preconditions.checkNotNull(v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingletonImmutableTable(Table.Cell<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        if (containsColumn(c)) {
            return ImmutableMap.m235of(this.singleRowKey, (Object) this.singleValue);
        }
        return ImmutableMap.m234of();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.m235of(this.singleColumnKey, ImmutableMap.m235of(this.singleRowKey, (Object) this.singleValue));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.m235of(this.singleRowKey, ImmutableMap.m235of(this.singleColumnKey, (Object) this.singleValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return ImmutableSet.m263of(cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.m263of(this.singleValue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableTable
    ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }
}
