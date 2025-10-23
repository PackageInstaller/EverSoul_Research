package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final int[] COLORS = {ViewCompat.MEASURED_STATE_MASK};

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressDrawableSize {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int evaluateColorChange(float f, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f))) << 8) | ((i & 255) + ((int) (f * ((i2 & 255) - r8))));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircularProgressDrawable(Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.mRing = ring;
        ring.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setSizeParameters(float f, float f2, float f3, float f4) {
        Ring ring = this.mRing;
        float f5 = this.mResources.getDisplayMetrics().density;
        ring.setStrokeWidth(f2 * f5);
        ring.setCenterRadius(f * f5);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f3 * f5, f4 * f5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStyle(int i) {
        if (i == 0) {
            setSizeParameters(CENTER_RADIUS_LARGE, STROKE_WIDTH_LARGE, 12.0f, 6.0f);
        } else {
            setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStrokeWidth(float f) {
        this.mRing.setStrokeWidth(f);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCenterRadius(float f) {
        this.mRing.setCenterRadius(f);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStrokeCap(Paint.Cap cap) {
        this.mRing.setStrokeCap(cap);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setArrowDimensions(float f, float f2) {
        this.mRing.setArrowDimensions(f, f2);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setArrowEnabled(boolean z) {
        this.mRing.setShowArrow(z);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setArrowScale(float f) {
        this.mRing.setArrowScale(f);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setStartEndTrim(float f, float f2) {
        this.mRing.setStartTrim(f);
        this.mRing.setEndTrim(f2);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProgressRotation(float f) {
        this.mRing.setRotation(f);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBackgroundColor(int i) {
        this.mRing.setBackgroundColor(i);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restore();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mRing.setAlpha(i);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setRotation(float f) {
        this.mRotation = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private float getRotation() {
        return this.mRotation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimator.setDuration(666L);
            this.mAnimator.start();
        } else {
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimator.setDuration(1332L);
            this.mAnimator.start();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void updateRingColor(float f, Ring ring) {
        if (f > 0.75f) {
            ring.setColor(evaluateColorChange((f - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        } else {
            ring.setColor(ring.getStartingColor());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void applyFinishTranslation(float f, Ring ring) {
        updateRingColor(f, ring);
        float floor = (float) (Math.floor(ring.getStartingRotation() / MAX_PROGRESS_ARC) + 1.0d);
        ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - MIN_PROGRESS_ARC) - ring.getStartingStartTrim()) * f));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + ((floor - ring.getStartingRotation()) * f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void applyTransformation(float f, Ring ring, boolean z) {
        float interpolation;
        float f2;
        if (this.mFinishing) {
            applyFinishTranslation(f, ring);
            return;
        }
        if (f != 1.0f || z) {
            float startingRotation = ring.getStartingRotation();
            if (f < 0.5f) {
                interpolation = ring.getStartingStartTrim();
                f2 = (MATERIAL_INTERPOLATOR.getInterpolation(f / 0.5f) * 0.79f) + MIN_PROGRESS_ARC + interpolation;
            } else {
                float startingStartTrim = ring.getStartingStartTrim() + 0.79f;
                interpolation = startingStartTrim - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + MIN_PROGRESS_ARC);
                f2 = startingStartTrim;
            }
            float f3 = startingRotation + (RING_ROTATION * f);
            float f4 = (f + this.mRotationCount) * GROUP_FULL_ROTATION;
            ring.setStartTrim(interpolation);
            ring.setEndTrim(f2);
            ring.setRotation(f3);
            setRotation(f4);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setupAnimators() {
        final Ring ring = this.mRing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.updateRingColor(floatValue, ring);
                CircularProgressDrawable.this.applyTransformation(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.mRotationCount = 0.0f;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.applyTransformation(1.0f, ring, true);
                ring.storeOriginals();
                ring.goToNextColor();
                if (CircularProgressDrawable.this.mFinishing) {
                    CircularProgressDrawable.this.mFinishing = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    ring.setShowArrow(false);
                    return;
                }
                CircularProgressDrawable.this.mRotationCount += 1.0f;
            }
        });
        this.mAnimator = ofFloat;
    }

    private static class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint;
        float mArrowScale;
        int mArrowWidth;
        final Paint mCirclePaint;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim;
        final Paint mPaint;
        float mRingCenterRadius;
        float mRotation;
        boolean mShowArrow;
        float mStartTrim;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth;
        final RectF mTempBounds = new RectF();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Ring() {
            Paint paint = new Paint();
            this.mPaint = paint;
            Paint paint2 = new Paint();
            this.mArrowPaint = paint2;
            Paint paint3 = new Paint();
            this.mCirclePaint = paint3;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setArrowDimensions(float f, float f2) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setStrokeCap(Paint.Cap cap) {
            this.mPaint.setStrokeCap(cap);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getArrowWidth() {
            return this.mArrowWidth;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getArrowHeight() {
            return this.mArrowHeight;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            float f = this.mRingCenterRadius;
            float f2 = (this.mStrokeWidth / 2.0f) + f;
            if (f <= 0.0f) {
                f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
            }
            rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
            float f3 = this.mStartTrim;
            float f4 = this.mRotation;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.mEndTrim + f4) * 360.0f) - f5;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float f7 = this.mStrokeWidth / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.mPaint);
            drawTriangle(canvas, f5, f6, rectF);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void drawTriangle(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f4 = this.mArrowWidth;
                float f5 = this.mArrowScale;
                path3.lineTo((f4 * f5) / 2.0f, this.mArrowHeight * f5);
                this.mArrow.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.mStrokeWidth / 2.0f));
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
                canvas.restore();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setColors(int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int[] getColors() {
            return this.mColors;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setColor(int i) {
            this.mCurrentColor = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setBackgroundColor(int i) {
            this.mCirclePaint.setColor(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[i];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setAlpha(int i) {
            this.mAlpha = i;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getAlpha() {
            return this.mAlpha;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mPaint.setStrokeWidth(f);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setStartTrim(float f) {
            this.mStartTrim = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getStartTrim() {
            return this.mStartTrim;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setEndTrim(float f) {
            this.mEndTrim = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getEndTrim() {
            return this.mEndTrim;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setRotation(float f) {
            this.mRotation = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getRotation() {
            return this.mRotation;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setCenterRadius(float f) {
            this.mRingCenterRadius = f;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        boolean getShowArrow() {
            return this.mShowArrow;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getArrowScale() {
            return this.mArrowScale;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        float getStartingRotation() {
            return this.mStartingRotation;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }
    }
}
