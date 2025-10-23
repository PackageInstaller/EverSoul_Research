package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.appcompat.C0047R;

/* loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0047R.attr.ratingBarStyle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatProgressBarHelper appCompatProgressBarHelper = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = appCompatProgressBarHelper;
        appCompatProgressBarHelper.loadFromAttributes(attributeSet, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap sampleTile = this.mAppCompatProgressBarHelper.getSampleTile();
        if (sampleTile != null) {
            setMeasuredDimension(View.resolveSizeAndState(sampleTile.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
