package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GzipSink.kt */
@Metadata(m837bv = {1, 0, 3}, m838d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, m839d2 = {"gzip", "Lokio/GzipSink;", "Lokio/Sink;", "okio"}, m840k = 2, m841mv = {1, 4, 0})
/* renamed from: okio.-GzipSinkExtensions, reason: invalid class name */
/* loaded from: classes2.dex */
public final class GzipSinkExtensions {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final GzipSink gzip(Sink gzip) {
        Intrinsics.checkNotNullParameter(gzip, "$this$gzip");
        return new GzipSink(gzip);
    }
}
