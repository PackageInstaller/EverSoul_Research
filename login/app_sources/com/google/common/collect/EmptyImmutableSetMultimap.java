package com.google.common.collect;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
    private static final long serialVersionUID = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.m234of(), 0, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object readResolve() {
        return INSTANCE;
    }
}
