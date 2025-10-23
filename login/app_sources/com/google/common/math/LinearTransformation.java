package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class LinearTransformation {
    public abstract LinearTransformation inverse();

    public abstract boolean isHorizontal();

    public abstract boolean isVertical();

    public abstract double slope();

    public abstract double transform(double d);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LinearTransformationBuilder mapping(double d, double d2) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d) && DoubleUtils.isFinite(d2));
        return new LinearTransformationBuilder(d, d2);
    }

    public static final class LinearTransformationBuilder {

        /* renamed from: x1 */
        private final double f420x1;

        /* renamed from: y1 */
        private final double f421y1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LinearTransformationBuilder(double d, double d2) {
            this.f420x1 = d;
            this.f421y1 = d2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LinearTransformation and(double d, double d2) {
            Preconditions.checkArgument(DoubleUtils.isFinite(d) && DoubleUtils.isFinite(d2));
            double d3 = this.f420x1;
            if (d == d3) {
                Preconditions.checkArgument(d2 != this.f421y1);
                return new VerticalLinearTransformation(this.f420x1);
            }
            return withSlope((d2 - this.f421y1) / (d - d3));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LinearTransformation withSlope(double d) {
            Preconditions.checkArgument(!Double.isNaN(d));
            if (DoubleUtils.isFinite(d)) {
                return new RegularLinearTransformation(d, this.f421y1 - (this.f420x1 * d));
            }
            return new VerticalLinearTransformation(this.f420x1);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LinearTransformation vertical(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new VerticalLinearTransformation(d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LinearTransformation horizontal(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return new RegularLinearTransformation(0.0d, d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LinearTransformation forNaN() {
        return NaNLinearTransformation.INSTANCE;
    }

    private static final class RegularLinearTransformation extends LinearTransformation {

        @CheckForNull
        @LazyInit
        LinearTransformation inverse;
        final double slope;
        final double yIntercept;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RegularLinearTransformation(double d, double d2) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        RegularLinearTransformation(double d, double d2, LinearTransformation linearTransformation) {
            this.slope = d;
            this.yIntercept = d2;
            this.inverse = linearTransformation;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return this.slope == 0.0d;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return this.slope;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            return (d * this.slope) + this.yIntercept;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.slope), Double.valueOf(this.yIntercept));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LinearTransformation createInverse() {
            double d = this.slope;
            if (d != 0.0d) {
                return new RegularLinearTransformation(1.0d / d, (this.yIntercept * (-1.0d)) / d, this);
            }
            return new VerticalLinearTransformation(this.yIntercept, this);
        }
    }

    private static final class VerticalLinearTransformation extends LinearTransformation {

        @CheckForNull
        @LazyInit
        LinearTransformation inverse;

        /* renamed from: x */
        final double f422x;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        VerticalLinearTransformation(double d) {
            this.f422x = d;
            this.inverse = null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        VerticalLinearTransformation(double d, LinearTransformation linearTransformation) {
            this.f422x = d;
            this.inverse = linearTransformation;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            throw new IllegalStateException();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            throw new IllegalStateException();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            LinearTransformation linearTransformation = this.inverse;
            if (linearTransformation != null) {
                return linearTransformation;
            }
            LinearTransformation createInverse = createInverse();
            this.inverse = createInverse;
            return createInverse;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f422x));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private LinearTransformation createInverse() {
            return new RegularLinearTransformation(0.0d, this.f422x, this);
        }
    }

    private static final class NaNLinearTransformation extends LinearTransformation {
        static final NaNLinearTransformation INSTANCE = new NaNLinearTransformation();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public LinearTransformation inverse() {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public boolean isHorizontal() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public boolean isVertical() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public double slope() {
            return Double.NaN;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return "NaN";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.math.LinearTransformation
        public double transform(double d) {
            return Double.NaN;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private NaNLinearTransformation() {
        }
    }
}
