package okio;

import com.kakaogame.secondpw.viewdata.Base2ndPWViewData;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JvmOkio.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m839d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", Base2ndPWViewData.KEY_INPUT, "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, m840k = 1, m841mv = {1, 4, 0})
/* loaded from: classes2.dex */
final class InputStreamSource implements Source {
    private final InputStream input;
    private final Timeout timeout;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InputStreamSource(InputStream input, Timeout timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.input = input;
        this.timeout = timeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.Source
    public long read(Buffer sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount == 0) {
            return 0L;
        }
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        try {
            this.timeout.throwIfReached();
            Segment writableSegment$okio = sink.writableSegment$okio(1);
            int read = this.input.read(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(byteCount, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos != writableSegment$okio.limit) {
                    return -1L;
                }
                sink.head = writableSegment$okio.pop();
                SegmentPool.recycle(writableSegment$okio);
                return -1L;
            }
            writableSegment$okio.limit += read;
            long j = read;
            sink.setSize$okio(sink.size() + j);
            return j;
        } catch (AssertionError e) {
            if (Okio.isAndroidGetsocknameError(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okio.Source
    public Timeout timeout() {
        return this.timeout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "source(" + this.input + ')';
    }
}
