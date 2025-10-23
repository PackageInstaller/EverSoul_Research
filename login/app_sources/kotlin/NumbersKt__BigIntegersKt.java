package kotlin;

import com.kakaogame.auth.agreement.AgreementService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BigIntegers.kt */
@Metadata(m838d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0087\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\u0087\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\u0087\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\u0019"}, m839d2 = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", AgreementService.VALUE_NO, "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, m840k = 5, m841mv = {1, 8, 0}, m843xi = 49, m844xs = "kotlin/NumbersKt")
/* loaded from: classes3.dex */
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger plus(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger add = bigInteger.add(other);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger minus(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger subtract = bigInteger.subtract(other);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger times(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger multiply = bigInteger.multiply(other);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger div(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger divide = bigInteger.divide(other);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other)");
        return divide;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger rem(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger remainder = bigInteger.remainder(other);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger unaryMinus(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger negate = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger inc(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigInteger.ONE)");
        return add;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger dec(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger inv(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger not = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(not, "this.not()");
        return not;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger and(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger and = bigInteger.and(other);
        Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
        return and;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    private static final BigInteger m845or(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger or = bigInteger.or(other);
        Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
        return or;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger xor(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger xor = bigInteger.xor(other);
        Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
        return xor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger shl(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger shiftLeft = bigInteger.shiftLeft(i);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger shr(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger shiftRight = bigInteger.shiftRight(i);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger toBigInteger(int i) {
        BigInteger valueOf = BigInteger.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigInteger toBigInteger(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
        return valueOf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext, "UNLIMITED");
        }
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final BigDecimal toBigDecimal(BigInteger bigInteger, int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }
}
