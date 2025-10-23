package twitter4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: classes4.dex */
final class StreamingGZIPInputStream extends GZIPInputStream {
    private final InputStream wrapped;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StreamingGZIPInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
        this.wrapped = inputStream;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.zip.InflaterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.wrapped.available();
    }
}
