package kotlin.experimental;

import kotlin.Metadata;

/* compiled from: bitwiseOperations.kt */
@Metadata(m838d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0005\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f¨\u0006\u0007"}, m839d2 = {"and", "", "other", "", "inv", "or", "xor", "kotlin-stdlib"}, m840k = 2, m841mv = {1, 8, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class BitwiseOperationsKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final byte and(byte b, byte b2) {
        return (byte) (b & b2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final short and(short s, short s2) {
        return (short) (s & s2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final byte inv(byte b) {
        return (byte) (~b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final short inv(short s) {
        return (short) (~s);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    private static final byte m862or(byte b, byte b2) {
        return (byte) (b | b2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    private static final short m863or(short s, short s2) {
        return (short) (s | s2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final byte xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final short xor(short s, short s2) {
        return (short) (s ^ s2);
    }
}
