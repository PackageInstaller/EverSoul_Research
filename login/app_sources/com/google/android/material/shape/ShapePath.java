package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ShapePath(float f, float f2) {
        reset(f, f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset(float f, float f2) {
        reset(f, f2, ANGLE_UP, 0.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset(float f, float f2, float f3, float f4) {
        setStartX(f);
        setStartY(f2);
        setEndX(f);
        setEndY(f2);
        setCurrentShadowAngle(f3);
        setEndShadowAngle((f3 + f4) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void lineTo(float f, float f2) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f266x = f;
        pathLineOperation.f267y = f2;
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f);
        setEndY(f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void quadToPoint(float f, float f2, float f3, float f4) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.setControlX(f);
        pathQuadOperation.setControlY(f2);
        pathQuadOperation.setEndX(f3);
        pathQuadOperation.setEndY(f4);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f3);
        setEndY(f4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void cubicToPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        this.operations.add(new PathCubicOperation(f, f2, f3, f4, f5, f6));
        this.containsIncompatibleShadowOp = true;
        setEndX(f5);
        setEndY(f6);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
        pathArcOperation.setStartAngle(f5);
        pathArcOperation.setSweepAngle(f6);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        if (z) {
            f5 = (f5 + ANGLE_LEFT) % 360.0f;
        }
        addShadowCompatOperation(arcShadowOperation, f5, z ? (ANGLE_LEFT + f7) % 360.0f : f7);
        double d = f7;
        setEndX(((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d)))));
        setEndY(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d)))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i = 0; i < size; i++) {
            this.operations.get(i).applyToPath(matrix, path);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.shadowCompatOperations);
        return new ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void draw(Matrix matrix3, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ShadowCompatOperation) it.next()).draw(matrix2, shadowRenderer, i, canvas);
                }
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f, float f2) {
        addConnectingShadowIfNecessary(f);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void addConnectingShadowIfNecessary(float f) {
        if (getCurrentShadowAngle() == f) {
            return;
        }
        float currentShadowAngle = ((f - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > ANGLE_LEFT) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        pathArcOperation.setStartAngle(getCurrentShadowAngle());
        pathArcOperation.setSweepAngle(currentShadowAngle);
        this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
        setCurrentShadowAngle(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float getStartX() {
        return this.startX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float getStartY() {
        return this.startY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float getEndX() {
        return this.endX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    float getEndY() {
        return this.endY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setStartX(float f) {
        this.startX = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setStartY(float f) {
        this.startY = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setEndX(float f) {
        this.endX = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setEndY(float f) {
        this.endY = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setCurrentShadowAngle(float f) {
        this.currentShadowAngle = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setEndShadowAngle(float f) {
        this.endShadowAngle = f;
    }

    static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ShadowCompatOperation() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void draw(ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i, canvas);
        }
    }

    static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public LineShadowOperation(PathLineOperation pathLineOperation, float f, float f2) {
            this.operation = pathLineOperation;
            this.startX = f;
            this.startY = f2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.operation.f267y - this.startY, this.operation.f266x - this.startX), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.startX, this.startY);
            matrix2.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getAngle() {
            return (float) Math.toDegrees(Math.atan((this.operation.f267y - this.startY) / (this.operation.f266x - this.startX)));
        }
    }

    static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.operation.getLeft(), this.operation.getTop(), this.operation.getRight(), this.operation.getBottom()), i, this.operation.getStartAngle(), this.operation.getSweepAngle());
        }
    }

    public static class PathLineOperation extends PathOperation {

        /* renamed from: x */
        private float f266x;

        /* renamed from: y */
        private float f267y;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f266x, this.f267y);
            path.transform(matrix);
        }
    }

    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getEndX() {
            return this.endX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setEndX(float f) {
            this.endX = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getControlY() {
            return this.controlY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setControlY(float f) {
            this.controlY = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getEndY() {
            return this.endY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setEndY(float f) {
            this.endY = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getControlX() {
            return this.controlX;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setControlX(float f) {
            this.controlX = f;
        }
    }

    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PathArcOperation(float f, float f2, float f3, float f4) {
            setLeft(f);
            setTop(f2);
            setRight(f3);
            setBottom(f4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF2 = rectF;
            rectF2.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF2, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getLeft() {
            return this.left;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getTop() {
            return this.top;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getRight() {
            return this.right;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getBottom() {
            return this.bottom;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setLeft(float f) {
            this.left = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setTop(float f) {
            this.top = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setRight(float f) {
            this.right = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setBottom(float f) {
            this.bottom = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getStartAngle() {
            return this.startAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public float getSweepAngle() {
            return this.sweepAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setStartAngle(float f) {
            this.startAngle = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setSweepAngle(float f) {
            this.sweepAngle = f;
        }
    }

    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PathCubicOperation(float f, float f2, float f3, float f4, float f5, float f6) {
            setControlX1(f);
            setControlY1(f2);
            setControlX2(f3);
            setControlY2(f4);
            setEndX(f5);
            setEndY(f6);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getControlX1() {
            return this.controlX1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setControlX1(float f) {
            this.controlX1 = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getControlY1() {
            return this.controlY1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setControlY1(float f) {
            this.controlY1 = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getControlX2() {
            return this.controlX2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setControlX2(float f) {
            this.controlX2 = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getControlY2() {
            return this.controlY1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setControlY2(float f) {
            this.controlY2 = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getEndX() {
            return this.endX;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setEndX(float f) {
            this.endX = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private float getEndY() {
            return this.endY;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void setEndY(float f) {
            this.endY = f;
        }
    }
}
