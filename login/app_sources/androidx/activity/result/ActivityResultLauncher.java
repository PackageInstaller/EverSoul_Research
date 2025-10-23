package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

/* loaded from: classes.dex */
public abstract class ActivityResultLauncher<I> {
    public abstract ActivityResultContract<I, ?> getContract();

    public abstract void launch(I i, ActivityOptionsCompat activityOptionsCompat);

    public abstract void unregister();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void launch(I i) {
        launch(i, null);
    }
}
