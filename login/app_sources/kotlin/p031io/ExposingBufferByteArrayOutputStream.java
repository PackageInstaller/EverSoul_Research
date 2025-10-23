package kotlin.p031io;

import com.kakaogame.server.ServerConstants;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileReadWrite.kt */
@Metadata(m838d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m839d2 = {"Lkotlin/io/ExposingBufferByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", ServerConstants.SIZE, "", "(I)V", "buffer", "", "getBuffer", "()[B", "kotlin-stdlib"}, m840k = 1, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
final class ExposingBufferByteArrayOutputStream extends ByteArrayOutputStream {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExposingBufferByteArrayOutputStream(int i) {
        super(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final byte[] getBuffer() {
        byte[] buf = this.buf;
        Intrinsics.checkNotNullExpressionValue(buf, "buf");
        return buf;
    }
}
