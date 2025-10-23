package androidx.datastore.preferences.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class StructuralMessageInfo implements MessageInfo {
    private final int[] checkInitialized;
    private final MessageLite defaultInstance;
    private final FieldInfo[] fields;
    private final boolean messageSetWireFormat;
    private final ProtoSyntax syntax;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.syntax = protoSyntax;
        this.messageSetWireFormat = z;
        this.checkInitialized = iArr;
        this.fields = fieldInfoArr;
        this.defaultInstance = (MessageLite) Internal.checkNotNull(obj, "defaultInstance");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return this.syntax;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return this.messageSetWireFormat;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int[] getCheckInitialized() {
        return this.checkInitialized;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FieldInfo[] getFields() {
        return this.fields;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.datastore.preferences.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder newBuilder(int i) {
        return new Builder(i);
    }

    public static final class Builder {
        private int[] checkInitialized;
        private Object defaultInstance;
        private final List<FieldInfo> fields;
        private boolean messageSetWireFormat;
        private ProtoSyntax syntax;
        private boolean wasBuilt;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder() {
            this.checkInitialized = null;
            this.fields = new ArrayList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(int i) {
            this.checkInitialized = null;
            this.fields = new ArrayList(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void withDefaultInstance(Object obj) {
            this.defaultInstance = obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void withSyntax(ProtoSyntax protoSyntax) {
            this.syntax = (ProtoSyntax) Internal.checkNotNull(protoSyntax, "syntax");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void withMessageSetWireFormat(boolean z) {
            this.messageSetWireFormat = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void withCheckInitialized(int[] iArr) {
            this.checkInitialized = iArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void withField(FieldInfo fieldInfo) {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            this.fields.add(fieldInfo);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StructuralMessageInfo build() {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            if (this.syntax == null) {
                throw new IllegalStateException("Must specify a proto syntax");
            }
            this.wasBuilt = true;
            Collections.sort(this.fields);
            return new StructuralMessageInfo(this.syntax, this.messageSetWireFormat, this.checkInitialized, (FieldInfo[]) this.fields.toArray(new FieldInfo[0]), this.defaultInstance);
        }
    }
}
