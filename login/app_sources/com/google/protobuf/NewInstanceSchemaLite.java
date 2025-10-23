package com.google.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    NewInstanceSchemaLite() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).newMutableInstance();
    }
}
