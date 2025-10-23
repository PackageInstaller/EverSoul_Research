package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;

/* loaded from: classes.dex */
public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    public abstract Type getDefaultValue();

    public abstract WireFormat.FieldType getLiteType();

    public abstract MessageLite getMessageDefaultInstance();

    public abstract int getNumber();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}
