package kotlin.collections.builders;

import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: MapBuilder.kt */
@Metadata(m838d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "()V", "map", "", "(Ljava/util/Map;)V", "readExternal", "", Base2ndPWViewData.KEY_INPUT, "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
final class SerializedMap implements Externalizable {
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SerializedMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SerializedMap() {
        this(MapsKt.emptyMap());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        byte readByte = input.readByte();
        if (readByte != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte));
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException("Illegal size value: " + readInt + ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        Map createMapBuilder = MapsKt.createMapBuilder(readInt);
        for (int i = 0; i < readInt; i++) {
            createMapBuilder.put(input.readObject(), input.readObject());
        }
        this.map = MapsKt.build(createMapBuilder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Object readResolve() {
        return this.map;
    }
}
