package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.core.util.Pair;

/* loaded from: classes.dex */
public class ActivityOptionsCompat {
    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Rect getLaunchBounds() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void requestUsageTimeReport(PendingIntent pendingIntent) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ActivityOptionsCompat setLaunchBounds(Rect rect) {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Bundle toBundle() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void update(ActivityOptionsCompat activityOptionsCompat) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeCustomAnimation(Context context, int i, int i2) {
        return new ActivityOptionsCompatImpl(Api16Impl.makeCustomAnimation(context, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
        return new ActivityOptionsCompatImpl(Api16Impl.makeScaleUpAnimation(view, i, i2, i3, i4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeClipRevealAnimation(View view, int i, int i2, int i3, int i4) {
        return new ActivityOptionsCompatImpl(Api23Impl.makeClipRevealAnimation(view, i, i2, i3, i4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
        return new ActivityOptionsCompatImpl(Api16Impl.makeThumbnailScaleUpAnimation(view, bitmap, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View view, String str) {
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(activity, view, str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pairArr) {
        android.util.Pair[] pairArr2;
        if (pairArr != null) {
            pairArr2 = new android.util.Pair[pairArr.length];
            for (int i = 0; i < pairArr.length; i++) {
                pairArr2[i] = android.util.Pair.create(pairArr[i].first, pairArr[i].second);
            }
        } else {
            pairArr2 = null;
        }
        return new ActivityOptionsCompatImpl(Api21Impl.makeSceneTransitionAnimation(activity, pairArr2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeTaskLaunchBehind() {
        return new ActivityOptionsCompatImpl(Api21Impl.makeTaskLaunchBehind());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ActivityOptionsCompat makeBasic() {
        return new ActivityOptionsCompatImpl(Api23Impl.makeBasic());
    }

    private static class ActivityOptionsCompatImpl extends ActivityOptionsCompat {
        private final ActivityOptions mActivityOptions;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            this.mActivityOptions = activityOptions;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(ActivityOptionsCompat activityOptionsCompat) {
            if (activityOptionsCompat instanceof ActivityOptionsCompatImpl) {
                this.mActivityOptions.update(((ActivityOptionsCompatImpl) activityOptionsCompat).mActivityOptions);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent pendingIntent) {
            Api23Impl.requestUsageTimeReport(this.mActivityOptions, pendingIntent);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.app.ActivityOptionsCompat
        public ActivityOptionsCompat setLaunchBounds(Rect rect) {
            return new ActivityOptionsCompatImpl(Api24Impl.setLaunchBounds(this.mActivityOptions, rect));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            return Api24Impl.getLaunchBounds(this.mActivityOptions);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ActivityOptionsCompat() {
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions makeCustomAnimation(Context context, int i, int i2) {
            return ActivityOptions.makeCustomAnimation(context, i, i2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions makeScaleUpAnimation(View view, int i, int i2, int i3, int i4) {
            return ActivityOptions.makeScaleUpAnimation(view, i, i2, i3, i4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions makeThumbnailScaleUpAnimation(View view, Bitmap bitmap, int i, int i2) {
            return ActivityOptions.makeThumbnailScaleUpAnimation(view, bitmap, i, i2);
        }
    }

    static class Api23Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api23Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions makeClipRevealAnimation(View view, int i, int i2, int i3, int i4) {
            return ActivityOptions.makeClipRevealAnimation(view, i, i2, i3, i4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions makeBasic() {
            return ActivityOptions.makeBasic();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void requestUsageTimeReport(ActivityOptions activityOptions, PendingIntent pendingIntent) {
            activityOptions.requestUsageTimeReport(pendingIntent);
        }
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions makeSceneTransitionAnimation(Activity activity, View view, String str) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @SafeVarargs
        static ActivityOptions makeSceneTransitionAnimation(Activity activity, android.util.Pair<View, String>... pairArr) {
            return ActivityOptions.makeSceneTransitionAnimation(activity, pairArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions makeTaskLaunchBehind() {
            return ActivityOptions.makeTaskLaunchBehind();
        }
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ActivityOptions setLaunchBounds(ActivityOptions activityOptions, Rect rect) {
            return activityOptions.setLaunchBounds(rect);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Rect getLaunchBounds(ActivityOptions activityOptions) {
            return activityOptions.getLaunchBounds();
        }
    }
}
