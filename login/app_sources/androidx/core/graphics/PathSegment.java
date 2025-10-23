package androidx.core.graphics;

import android.graphics.PointF;
import androidx.core.util.Preconditions;

/* loaded from: classes.dex */
public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PathSegment(PointF pointF, float f, PointF pointF2, float f2) {
        this.mStart = (PointF) Preconditions.checkNotNull(pointF, "start == null");
        this.mStartFraction = f;
        this.mEnd = (PointF) Preconditions.checkNotNull(pointF2, "end == null");
        this.mEndFraction = f2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PointF getStart() {
        return this.mStart;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getStartFraction() {
        return this.mStartFraction;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PointF getEnd() {
        return this.mEnd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getEndFraction() {
        return this.mEndFraction;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PathSegment)) {
            return false;
        }
        PathSegment pathSegment = (PathSegment) obj;
        return Float.compare(this.mStartFraction, pathSegment.mStartFraction) == 0 && Float.compare(this.mEndFraction, pathSegment.mEndFraction) == 0 && this.mStart.equals(pathSegment.mStart) && this.mEnd.equals(pathSegment.mEnd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int hashCode = this.mStart.hashCode() * 31;
        float f = this.mStartFraction;
        int floatToIntBits = (((hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.mEnd.hashCode()) * 31;
        float f2 = this.mEndFraction;
        return floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }
}
