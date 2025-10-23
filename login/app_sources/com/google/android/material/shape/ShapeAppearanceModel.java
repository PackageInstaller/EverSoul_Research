package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.C0903R;

/* loaded from: classes2.dex */
public class ShapeAppearanceModel {
    public static final CornerSize PILL = new RelativeCornerSize(0.5f);
    EdgeTreatment bottomEdge;
    CornerTreatment bottomLeftCorner;
    CornerSize bottomLeftCornerSize;
    CornerTreatment bottomRightCorner;
    CornerSize bottomRightCornerSize;
    EdgeTreatment leftEdge;
    EdgeTreatment rightEdge;
    EdgeTreatment topEdge;
    CornerTreatment topLeftCorner;
    CornerSize topLeftCornerSize;
    CornerTreatment topRightCorner;
    CornerSize topRightCornerSize;

    public interface CornerSizeUnaryOperator {
        CornerSize apply(CornerSize cornerSize);
    }

    public static final class Builder {
        private EdgeTreatment bottomEdge;
        private CornerTreatment bottomLeftCorner;
        private CornerSize bottomLeftCornerSize;
        private CornerTreatment bottomRightCorner;
        private CornerSize bottomRightCornerSize;
        private EdgeTreatment leftEdge;
        private EdgeTreatment rightEdge;
        private EdgeTreatment topEdge;
        private CornerTreatment topLeftCorner;
        private CornerSize topLeftCornerSize;
        private CornerTreatment topRightCorner;
        private CornerSize topRightCornerSize;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder() {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllCorners(int i, float f) {
            return setAllCorners(MaterialShapeUtils.createCornerTreatment(i)).setAllCornerSizes(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllCorners(CornerTreatment cornerTreatment) {
            return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllCornerSizes(CornerSize cornerSize) {
            return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllCornerSizes(float f) {
            return setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomRightCornerSize(f).setBottomLeftCornerSize(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopLeftCornerSize(float f) {
            this.topLeftCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopLeftCornerSize(CornerSize cornerSize) {
            this.topLeftCornerSize = cornerSize;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopRightCornerSize(float f) {
            this.topRightCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopRightCornerSize(CornerSize cornerSize) {
            this.topRightCornerSize = cornerSize;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomRightCornerSize(float f) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomRightCornerSize(CornerSize cornerSize) {
            this.bottomRightCornerSize = cornerSize;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomLeftCornerSize(float f) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(f);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomLeftCornerSize(CornerSize cornerSize) {
            this.bottomLeftCornerSize = cornerSize;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopLeftCorner(int i, float f) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopLeftCorner(int i, CornerSize cornerSize) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(cornerSize);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopLeftCorner(CornerTreatment cornerTreatment) {
            this.topLeftCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setTopLeftCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopRightCorner(int i, float f) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopRightCorner(int i, CornerSize cornerSize) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(cornerSize);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopRightCorner(CornerTreatment cornerTreatment) {
            this.topRightCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setTopRightCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomRightCorner(int i, float f) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomRightCorner(int i, CornerSize cornerSize) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(cornerSize);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomRightCorner(CornerTreatment cornerTreatment) {
            this.bottomRightCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setBottomRightCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomLeftCorner(int i, float f) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomLeftCorner(int i, CornerSize cornerSize) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(cornerSize);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomLeftCorner(CornerTreatment cornerTreatment) {
            this.bottomLeftCorner = cornerTreatment;
            float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
            if (compatCornerTreatmentSize != -1.0f) {
                setBottomLeftCornerSize(compatCornerTreatmentSize);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setAllEdges(EdgeTreatment edgeTreatment) {
            return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setLeftEdge(EdgeTreatment edgeTreatment) {
            this.leftEdge = edgeTreatment;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setTopEdge(EdgeTreatment edgeTreatment) {
            this.topEdge = edgeTreatment;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setRightEdge(EdgeTreatment edgeTreatment) {
            this.rightEdge = edgeTreatment;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setBottomEdge(EdgeTreatment edgeTreatment) {
            this.bottomEdge = edgeTreatment;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static float compatCornerTreatmentSize(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).radius;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).size;
            }
            return -1.0f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2) {
        return builder(context, attributeSet, i, i2, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return builder(context, attributeSet, i, i2, new AbsoluteCornerSize(i3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2, CornerSize cornerSize) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0903R.styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(C0903R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(C0903R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, cornerSize);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder(Context context, int i, int i2) {
        return builder(context, i, i2, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Builder builder(Context context, int i, int i2, int i3) {
        return builder(context, i, i2, new AbsoluteCornerSize(i3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Builder builder(Context context, int i, int i2, CornerSize cornerSize) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0903R.styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(C0903R.styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(C0903R.styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(C0903R.styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(C0903R.styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(C0903R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, C0903R.styleable.ShapeAppearance_cornerSize, cornerSize);
            CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, C0903R.styleable.ShapeAppearance_cornerSizeTopLeft, cornerSize2);
            CornerSize cornerSize4 = getCornerSize(obtainStyledAttributes, C0903R.styleable.ShapeAppearance_cornerSizeTopRight, cornerSize2);
            CornerSize cornerSize5 = getCornerSize(obtainStyledAttributes, C0903R.styleable.ShapeAppearance_cornerSizeBottomRight, cornerSize2);
            return new Builder().setTopLeftCorner(i4, cornerSize3).setTopRightCorner(i5, cornerSize4).setBottomRightCorner(i6, cornerSize5).setBottomLeftCorner(i7, getCornerSize(obtainStyledAttributes, C0903R.styleable.ShapeAppearance_cornerSizeBottomLeft, cornerSize2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static CornerSize getCornerSize(TypedArray typedArray, int i, CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cornerSize;
        }
        if (peekValue.type == 5) {
            return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return peekValue.type == 6 ? new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f)) : cornerSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ShapeAppearanceModel(Builder builder) {
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShapeAppearanceModel() {
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Builder toBuilder() {
        return new Builder(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShapeAppearanceModel withCornerSize(float f) {
        return toBuilder().setAllCornerSizes(f).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShapeAppearanceModel withCornerSize(CornerSize cornerSize) {
        return toBuilder().setAllCornerSizes(cornerSize).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShapeAppearanceModel withTransformedCornerSizes(CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isRoundRect(RectF rectF) {
        boolean z = this.leftEdge.getClass().equals(EdgeTreatment.class) && this.rightEdge.getClass().equals(EdgeTreatment.class) && this.topEdge.getClass().equals(EdgeTreatment.class) && this.bottomEdge.getClass().equals(EdgeTreatment.class);
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        return z && ((this.topRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.topRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomLeftCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.topRightCorner instanceof RoundedCornerTreatment) && (this.topLeftCorner instanceof RoundedCornerTreatment) && (this.bottomRightCorner instanceof RoundedCornerTreatment) && (this.bottomLeftCorner instanceof RoundedCornerTreatment));
    }
}
