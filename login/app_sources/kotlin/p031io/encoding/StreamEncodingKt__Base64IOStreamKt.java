package kotlin.p031io.encoding;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Base64IOStream.kt */
@Metadata(m838d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, m839d2 = {"decodingWith", "Ljava/io/InputStream;", "base64", "Lkotlin/io/encoding/Base64;", "encodingWith", "Ljava/io/OutputStream;", "kotlin-stdlib"}, m840k = 5, m841mv = {1, 8, 0}, m843xi = 49, m844xs = "kotlin/io/encoding/StreamEncodingKt")
/* loaded from: classes3.dex */
class StreamEncodingKt__Base64IOStreamKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final InputStream decodingWith(InputStream inputStream, Base64 base64) {
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(base64, "base64");
        return new DecodeInputStream(inputStream, base64);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final OutputStream encodingWith(OutputStream outputStream, Base64 base64) {
        Intrinsics.checkNotNullParameter(outputStream, "<this>");
        Intrinsics.checkNotNullParameter(base64, "base64");
        return new EncodeOutputStream(outputStream, base64);
    }
}
