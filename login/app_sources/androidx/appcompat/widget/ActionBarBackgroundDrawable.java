package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
class ActionBarBackgroundDrawable extends Drawable {
    final ActionBarContainer mContainer;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.mContainer = actionBarContainer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mContainer.mIsSplit) {
            if (this.mContainer.mSplitBackground != null) {
                this.mContainer.mSplitBackground.draw(canvas);
            }
        } else {
            if (this.mContainer.mBackground != null) {
                this.mContainer.mBackground.draw(canvas);
            }
            if (this.mContainer.mStackedBackground == null || !this.mContainer.mIsStacked) {
                return;
            }
            this.mContainer.mStackedBackground.draw(canvas);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.mContainer.mIsSplit) {
            if (this.mContainer.mSplitBackground != null) {
                Api21Impl.getOutline(this.mContainer.mBackground, outline);
            }
        } else if (this.mContainer.mBackground != null) {
            Api21Impl.getOutline(this.mContainer.mBackground, outline);
        }
    }

    private static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void getOutline(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }
    }
}
