package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.platform.MaterialContainerTransform;

/* loaded from: classes2.dex */
class MaskEvaluator {
    private ShapeAppearanceModel currentShapeAppearanceModel;
    private final Path path = new Path();
    private final Path startPath = new Path();
    private final Path endPath = new Path();
    private final ShapeAppearancePathProvider pathProvider = ShapeAppearancePathProvider.getInstance();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MaskEvaluator() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void evaluate(float f, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel lerp = TransitionUtils.lerp(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f);
        this.currentShapeAppearanceModel = lerp;
        this.pathProvider.calculatePath(lerp, 1.0f, rectF2, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, rectF3, this.endPath);
        this.path.op(this.startPath, this.endPath, Path.Op.UNION);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void clip(Canvas canvas) {
        canvas.clipPath(this.path);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Path getPath() {
        return this.path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }
}
