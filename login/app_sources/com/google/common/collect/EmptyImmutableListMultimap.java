package com.google.common.collect;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object> {
    static final EmptyImmutableListMultimap INSTANCE = new EmptyImmutableListMultimap();
    private static final long serialVersionUID = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private EmptyImmutableListMultimap() {
        super(ImmutableMap.m234of(), 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object readResolve() {
        return INSTANCE;
    }
}
